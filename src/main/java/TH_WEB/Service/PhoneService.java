package TH_WEB.Service;

import TH_WEB.Enity.Contact;
import TH_WEB.Enity.Phone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface PhoneService {
    public List<Phone> listAll();
    Phone findbyID(int id);
    //get all by id
    public Phone get(int id);

    public String save(Phone phone);

    public String deleted(int id);
}
