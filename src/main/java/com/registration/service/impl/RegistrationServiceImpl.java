package com.registration.service.impl;

import com.registration.entity.Registration;
import com.registration.payload.RegistrationDTO;
import com.registration.repository.RegistrationRepository;
import com.registration.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<Registration> getAllRegistrationsWithPagination(int page) {
        // Specify the page size as 8
        PageRequest pageRequest = PageRequest.of(page, 8);
        return registrationRepository.findAll(pageRequest);
    }


    @Override
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration getRegistrationById(Long id) {
        Optional<Registration> registration = registrationRepository.findById(id);
        return registration.orElse(null);
    }

    @Override
    public Registration insertRegistration(RegistrationDTO registrationDTO) {
        Registration registration = modelMapper.map(registrationDTO, Registration.class);
        MultipartFile profilePhoto = registrationDTO.getProfilePhoto();
        if (profilePhoto != null) {
            try {
                byte[] photoData = profilePhoto.getBytes();

                registration.setProfilePhoto(photoData);
            } catch (IOException e) {

                throw new RuntimeException(e);
            }
        }

        return registrationRepository.save(registration);
    }


    @Override
    public Registration updateRegistration(Registration existingRegistration, RegistrationDTO updatedData) throws IOException {
        Optional<Registration> optionalRegistration = registrationRepository.findById(existingRegistration.getId());

        if (optionalRegistration.isPresent()) {
            // Update the fields only if they are present in the updatedData
            if (updatedData.getName() != null) {
                existingRegistration.setName(updatedData.getName());
            }
            if (updatedData.getGender() != null) {
                existingRegistration.setGender(updatedData.getGender());
            }
            if (updatedData.getAddress() != null) {
                existingRegistration.setAddress(updatedData.getAddress());
            }

            MultipartFile profilePhoto = updatedData.getProfilePhoto();
            if (profilePhoto != null && !profilePhoto.isEmpty()) {
                try {
                    byte[] photoData = profilePhoto.getBytes();
                    existingRegistration.setProfilePhoto(photoData);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return registrationRepository.save(existingRegistration);
        }

        return null;
    }
    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
}
