package br.com.contact;

import java.util.List;

import org.json.JSONObject;

public interface ContactService {
    public void createContact(Contact contact);
    public void removeContact(Long id);
    public void updateContact(Long id, Contact contact);
    public Contact getContactByName(String name);
    public Contact getByName(String name);
    public List<Contact> getAllContacts();
}
