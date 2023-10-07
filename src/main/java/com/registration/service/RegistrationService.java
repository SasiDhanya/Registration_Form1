package com.registration.service;

import com.registration.entity.Registration;
import com.registration.payload.RegistrationDTO;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;


public interface RegistrationService {
    Registration insertRegistration(RegistrationDTO registrationDTO) throws IOException;
    public List<Registration> getAllRegistrations();
    Registration getRegistrationById(Long id);

    Registration updateRegistration(Registration existingRegistration, RegistrationDTO updatedData) throws IOException;

    Page<Registration> getAllRegistrationsWithPagination(int page);

    void deleteRegistration(Long id);

}