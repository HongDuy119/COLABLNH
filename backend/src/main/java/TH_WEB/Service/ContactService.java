package TH_WEB.Service;

import TH_WEB.Enity.Contact;
import TH_WEB.Enity.Phone;
import TH_WEB.dto.ResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface ContactService {
    // get all product
    List<Contact> listAll();
    Contact findbyID(int id);

    Contact createContact(Contact contact);

    ResponseDto deleted(int id);

    ResponseDto editContact(int contactId, Contact contact);


}
