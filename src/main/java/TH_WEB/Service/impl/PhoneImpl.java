package TH_WEB.Service.impl;

import TH_WEB.Enity.Phone;
import TH_WEB.Respository.PhoneRespos;
import TH_WEB.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhoneImpl implements PhoneService {

    @Autowired(required = true)
    private PhoneRespos phoneRespos;

    @Override
    public List<Phone> listAll() {
        return phoneRespos.findAll();
    }

    @Override
    public Phone findbyID(int id) {
        return phoneRespos.findById(id);
    }

    @Override
    public Phone get(int id) {
        return phoneRespos.findById(id);
    }

    @Override
    public String save(Phone phone) {
        phoneRespos.save(phone);
        return phone.getName();
    }

    @Override
    public String deleted(int id) {
        String res = phoneRespos.deleteById(id);
        return res;
    }
}
