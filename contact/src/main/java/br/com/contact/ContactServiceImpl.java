package br.com.contact;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;
    
  

    @Override
    public void createContact(Contact contact) {
        // criar um contact
        this.contactRepository.save(contact);
    }

    @Override
    public void removeContact(Long id) {
        // remover um contact
        this.contactRepository.deleteById(id);
    }
    
    @Override
    public void updateContact(Long id, Contact contact) {
    	Contact contactUpdate = contactRepository.findById(id).get();
    	BeanUtils.copyProperties(contact, contactUpdate, "id");
    	contactRepository.save(contactUpdate);
    	
    }

    @Override
    public Contact getContactByName(String name) {
        // remover um contact by name
        List<Contact> contacts = this.contactRepository.findAll();
        Contact c = contacts.stream().filter(contact ->contact.getName().equals(name)).findAny().get();
        return c;
    }

    @Override
    public Contact getByName(String name) {
        return this.contactRepository.findByName(name);
    }

    @Override
    public List<Contact> getAllContacts() {
        // listar todos os contacts
        return this.contactRepository.findAll();
    }
}
