package TH_WEB.Service.impl;

import TH_WEB.Enity.Contact;
import TH_WEB.Respository.ContactRespos;
import TH_WEB.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Service
@Transactional
public class ContactImpl implements ContactService {

    @Autowired(required = true)
    private ContactRespos contacttRespos;

    @Override
    public List<Contact> listAll() {
        return contacttRespos.findAll();
    }

    @Override
    public Contact findbyID(int id) {
        return contacttRespos.findById(id);
    }

    @Override
    public Contact get(int id) {
        return contacttRespos.findById(id);
    }

    @Override
    public String save(Contact product) {
        contacttRespos.save(product);
        return product.getName();
    }

    @Override
    public String deleted(int id) {
        String res = contacttRespos.deleteById(id);
        return res;
    }
}
