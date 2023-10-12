package TH_WEB.Service;

import TH_WEB.Enity.Contact;
import TH_WEB.Enity.Phone;
import TH_WEB.dto.ResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface PhoneService {
    public List<Phone> listAll();
    Phone findbyID(int id);
    //get all by id
    public Phone get(int id);
    List<Phone> listPhoneContactId(int contactId);
    ResponseDto addPhone(int contactId, Phone phone);
    public String save(Phone phone);

    public String deleted(int id);
}
