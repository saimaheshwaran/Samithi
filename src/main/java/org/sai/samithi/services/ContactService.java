package org.sai.samithi.services;

import lombok.NoArgsConstructor;
import org.sai.samithi.entities.Contact;
import org.sai.samithi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        contact.setCreatedAt(Date.from(Instant.now()));
        return contactRepository.save(contact);
    }

    public Page<Contact> contactPageRequest(int page, int pageSize) {
        return contactRepository.findAll(
                PageRequest.of( page, pageSize,
                Sort.by(Sort.Direction.DESC, "createdAt")));
    }

    public List<Contact> getAll() {
        return contactRepository.getAllByLatestDate();
    }

}
