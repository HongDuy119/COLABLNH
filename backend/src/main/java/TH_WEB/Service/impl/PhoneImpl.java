package TH_WEB.Service.impl;

import TH_WEB.Enity.Contact;
import TH_WEB.Enity.Phone;
import TH_WEB.Respository.ContactRepository;
import TH_WEB.Respository.PhoneRepository;
import TH_WEB.Service.PhoneService;
import TH_WEB.dto.ResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneImpl implements PhoneService {
    private final ContactRepository contactRepository;
    @Autowired(required = true)
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> listAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone findbyID(int id) {
        return phoneRepository.findById(id);
    }

    @Override
    public Phone get(int id) {
        return phoneRepository.findById(id);
    }

    @Override
    public List<Phone> listPhoneContactId(int contactId) {
        return phoneRepository.listPhoneContactId(contactId);
    }

    @Override
    public ResponseDto addPhone(int contactId, Phone phone) {
        Contact contact = contactRepository.findById(contactId);
        if (contact==null){
            return new ResponseDto(false, "Contact not found");
        }
        phone.setContacts(contact);
        contact.getPhones().add(phone);
        phoneRepository.save(phone);
        contactRepository.save(contact);
        return new ResponseDto(true, "Add phone success");
    }

    @Override
    public String save(Phone phone) {
        phoneRepository.save(phone);
        return phone.getName();
    }

    @Override
    @Transactional
    public String deleted(int id) {
        String res = phoneRepository.deleteById(id);
        return res;
    }
}
