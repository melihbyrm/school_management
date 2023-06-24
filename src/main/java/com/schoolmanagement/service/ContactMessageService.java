package com.schoolmanagement.service;
import com.schoolmanagement.dto.ContactMessageRequest;
import com.schoolmanagement.dto.ContactMessageResponse;
import com.schoolmanagement.entity.ContactMessage;
import com.schoolmanagement.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactMessageService {
    @Autowired
    private ContactMessageRepository contactMessageRepository;


    public void saveContactMessage(ContactMessageRequest contactMessageRequest) {

        ContactMessage contactMessage=new ContactMessage(contactMessageRequest);

        contactMessageRepository.save(contactMessage);

    }


    public List<ContactMessageResponse> getContactMessages() {

            List<ContactMessage> contactMessagesList=contactMessageRepository.findAll();

            return contactMessagesList.stream().map(ContactMessageResponse::new).collect(Collectors.toList());

    }




    public Page<ContactMessageResponse> getContactMessageByEmail( String email, Pageable pageable) {

      Page<ContactMessage> contactMessages= contactMessageRepository.findAllByEmail(email,pageable);

        return contactMessages.map(ContactMessageResponse::new);

    }


    public Page<ContactMessageResponse> getContactMessageBySubject(String subject, Pageable pageable) {
        Page<ContactMessage> contactMessages= contactMessageRepository.findAllBySubject(subject,pageable);

        return contactMessages.map(ContactMessageResponse::new);
    }
}
