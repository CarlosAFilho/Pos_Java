package br.com.contact.controller;

import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.response.ContactResponse;
import br.com.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    @Autowired
    private  ContactService contactService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactResponse> get(){
        return this.contactService.getAllContacts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody ContactRequest request){
        this.contactService.createContact(request);
    }
    
    @PutMapping(value = "/{id}")
    private void updateContact(@PathVariable("id") long id, @RequestBody ContactRequest request) {
        this.contactService.updateContact(request);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") Long id){
        this.contactService.removeContact(id);

    }

    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public ContactRequest getContactByName(@RequestParam String name){
        return this.contactService.getContactByName(name);
    }
}
