package org.sai.samithi.controllers;

import org.sai.samithi.entities.Contact;
import org.sai.samithi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact/index";
    }

    @PostMapping("/contact/add")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.add(contact);
        return "redirect:/contact/saved";
    }

    @GetMapping("/contact/saved")
    public String contactSavedPage() {
        return "contact/saved";
    }

    @GetMapping("/contact/list")
    public String getContacts(@RequestParam(defaultValue = "0") int page, Model model) {
        model.addAttribute("contactPage",
                contactService.contactPageRequest(page, 20));
        return "contact/list";
    }

}
