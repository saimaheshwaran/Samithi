package org.sai.samithi.services;

import lombok.NoArgsConstructor;
import org.sai.samithi.entities.Contact;
import org.sai.samithi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service @NoArgsConstructor
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact add(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public List<Contact> getAll() {
        return contactRepository.getAllByLatestDate();
    }

}
