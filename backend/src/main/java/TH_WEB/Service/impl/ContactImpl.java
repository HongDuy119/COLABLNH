package TH_WEB.Service.impl;

import TH_WEB.Enity.Contact;
import TH_WEB.Enity.Phone;
import TH_WEB.Respository.ContactRepository;
import TH_WEB.Service.ContactService;
import TH_WEB.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Service
@RequiredArgsConstructor
public class ContactImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> listAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findbyID(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact createContact(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }



    @Override
    public ResponseDto deleted(int id) {
        Contact contact = contactRepository.findById(id);
        if(contact==null){
            return new ResponseDto(false, "Contact not found");
        }
        contactRepository.delete(contact);
        return new ResponseDto(true, "Delete contact sucsess");
    }

    @Override
    public ResponseDto editContact(int contactId, Contact contact) {
        Contact contact1 = contactRepository.findById(contactId);
        if(contact1==null){
            return new ResponseDto(false, "Contact not found");
        }
        contact1.setName(contact.getName());
        contactRepository.save(contact1);
        return new ResponseDto(true, "Edit contact sucsess");
    }
}
