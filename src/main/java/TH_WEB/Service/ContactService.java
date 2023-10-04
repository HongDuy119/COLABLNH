package TH_WEB.Service;

import TH_WEB.Enity.Contact;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface ContactService {
    // get all product
    public List<Contact> listAll();
    Contact findbyID(int id);
    //get all by id
    public Contact get(int id);

    public String save(Contact product);

    public String deleted(int id);



}
