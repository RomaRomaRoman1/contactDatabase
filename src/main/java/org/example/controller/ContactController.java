package org.example.controller;

import org.example.facade.ContactFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactFacade contactFacade;
@Autowired
    public ContactController(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }
    @GetMapping("/{lastName}")
    public Optional <ContactDto> findAccount (@PathVariable String lastName) {
    return contactFacade.findAccount(lastName);
    }
    @PostMapping
    public List<ContactDto> addContact (@RequestParam String name, @RequestParam String lastName, @RequestParam String phoneNumber, @RequestParam String email) {
    return contactFacade.addToContactDtoList(name, lastName, phoneNumber, email);
    }
    @GetMapping("/findAll")
    public List <ContactDto> findAll() {
    return contactFacade.findAll();
    }
    @PostMapping("/changeAccount")
    public Optional<ContactDto> changeContact (@RequestParam String lastName, @RequestParam String phoneNumber) {
    return contactFacade.changeContactDtoList(lastName, phoneNumber);
    }
}
