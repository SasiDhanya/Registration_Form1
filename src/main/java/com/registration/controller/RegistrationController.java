package com.registration.controller;

import com.registration.entity.Registration;
import com.registration.payload.RegistrationDTO;
import com.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/insert")
    public String showInsertForm(Model model) {
        model.addAttribute("registrationDTO", new RegistrationDTO());
        return "insert";
    }

    @PostMapping("/insert")
    public String insertRegistration(
            @ModelAttribute("registrationDTO") @Valid RegistrationDTO registrationDTO,
            BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // Validation failed, return to the insert page with error messages
            return "insert";
        }

        try {
            Registration savedRegistration = registrationService.insertRegistration(registrationDTO);
            if (savedRegistration != null) {
                redirectAttributes.addFlashAttribute("successMessage", "Record inserted successfully.");
                return "redirect:/registration/insert"; // Redirect to the insert page to clear the form fields
            }
        } catch (IOException e) {
            model.addAttribute("errorMessage", "Error occurred while inserting the record.");
        }

        return "insert";
    }

    @PostMapping("/edit/{id}")
    public String updateRegistration(
            @PathVariable Long id,
            @ModelAttribute("registrationDTO") @Valid RegistrationDTO updatedData,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model) {
        if (result.hasErrors()) {
            return "edit";
        }

        try {
            Registration existingRegistration = registrationService.getRegistrationById(id);

            if (existingRegistration != null) {
                // Update fields with the new data
                existingRegistration.setName(updatedData.getName());
                existingRegistration.setGender(updatedData.getGender());
                existingRegistration.setAddress(updatedData.getAddress());
                existingRegistration.setCity(updatedData.getCity());
                existingRegistration.setPin(updatedData.getPin());
                existingRegistration.setState(updatedData.getState());
                existingRegistration.setEmail(updatedData.getEmail());
                existingRegistration.setContact(updatedData.getContact());


                MultipartFile profilePhoto = updatedData.getProfilePhoto();
                if (profilePhoto != null && !profilePhoto.isEmpty()) {
                    byte[] photoData = profilePhoto.getBytes();

                    existingRegistration.setProfilePhoto(photoData);
                }

                // Save the updated registration entity
                registrationService.updateRegistration(existingRegistration, updatedData);
                redirectAttributes.addFlashAttribute("successMessage", "Record updated successfully.");
            } else {
                return "redirect:/registration/view";
            }
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error occurred while updating the record.");
            return "edit";
        }
        return "redirect:/registration/view";
    }

    @GetMapping("/view")
    public String viewRegistrations(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page) {
        Page<Registration> registrations = registrationService.getAllRegistrationsWithPagination(page);
        model.addAttribute("registrations", registrations);
        return "view";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Registration registration = registrationService.getRegistrationById(id);
        if (registration != null) {
            RegistrationDTO registrationDTO = convertToDTO(registration);
            model.addAttribute("registrationDTO", registrationDTO);
            return "edit";
        }

        return "redirect:/registration/view";
    }

    private RegistrationDTO convertToDTO(Registration registration) {
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setId(registration.getId());
        registrationDTO.setName(registration.getName());
        registrationDTO.setGender(registration.getGender());
        registrationDTO.setAddress(registration.getAddress());
        registrationDTO.setCity(registration.getCity());
        registrationDTO.setPin(registration.getPin());
        registrationDTO.setState(registration.getState());
        registrationDTO.setEmail(registration.getEmail());
        registrationDTO.setContact(registration.getContact());
        return registrationDTO;
    }

    @GetMapping("/photo/{registrationId}")
    public ResponseEntity<byte[]> viewProfilePhoto(@PathVariable Long registrationId) {
        Registration registration = registrationService.getRegistrationById(registrationId);

        if (registration != null && registration.getProfilePhoto() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(registration.getProfilePhoto(), headers, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/delete/{id}")
    public String deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return "redirect:/registration/view";
    }
}
