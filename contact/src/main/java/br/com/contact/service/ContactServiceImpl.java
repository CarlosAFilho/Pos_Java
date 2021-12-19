package br.com.contact.service;


import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.response.ContactResponse;
import br.com.contact.model.Contact;
import br.com.contact.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
  

    @Override
    public void createContact(ContactRequest request) {
        this.contactRepository.save(new Contact().convertToEntity(request));
    }

    @Override
    public void removeContact(Long id) {
        this.contactRepository.deleteById(id);
    }

    @Override
    public ContactRequest getContactByName(String name) {
        return null;
    }

    @Override
    public void updateContact(Long id, ContactRequest request) {
        Contact contactUpdate = contactRepository.findById(id).get();
        BeanUtils.copyProperties(request, contactUpdate, "id");
        contactRepository.save(contactUpdate);
    }

    @Override
    public List<ContactResponse> getAllContacts() {
        return this.contactRepository.findAll()
                .stream().map(contact -> contact.convertToResponse(contact))
                .collect(Collectors.toList());
    }

    @Override
    public void updateContact(ContactRequest request) {

    }

    @Override
    public ContactResponse getByName(String name) {
        return this.contactRepository.findByName(name);
    }


}
