package br.com.contact.service;

import java.util.List;

import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.response.ContactResponse;

public interface ContactService {
    public void createContact(ContactRequest request);
    public void removeContact(Long id);
    public ContactRequest getContactByName(String name);
    public ContactResponse getByName(String name);
    void updateContact(Long id, ContactRequest request);
    public List<ContactResponse> getAllContacts();
    public void updateContact(ContactRequest request);


}
