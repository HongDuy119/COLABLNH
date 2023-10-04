package TH_WEB.Controller;

import TH_WEB.Enity.Contact;
import TH_WEB.Enity.Phone;
import TH_WEB.Service.ContactService;
import TH_WEB.Service.PhoneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    ContactService contactService;

    @Autowired
    PhoneService phoneService;


    /**
     Lấy tất cả thông tin contact
     **/


    @GetMapping("/contacts")
    public ResponseEntity<?> getContracts(){
        List<Contact> contacts = contactService.listAll();
        return ResponseEntity.ok(contacts);
    }

    /**
     lấy số diện thoại từ 1 contact
     truyền contactId
     **/
    @GetMapping("/contracts/{contactId}/phone")
    public ResponseEntity<?> getPhoneById(@PathVariable int contactId){
        Contact contact = contactService.findbyID(contactId);
        return ResponseEntity.ok(contact.getPhones());
    }

    /**
     Thêm 1 contact mới
     truyền Body contact
     **/
    @PostMapping("/contracts")
    public ResponseEntity<?>  addContact(@RequestBody Contact contact)
    {
        return ResponseEntity.ok(contactService.save(contact));
    }


    /**
     Lấy thông tin Contact
     truyền contactId
     **/
    @GetMapping("/contracts/{contactId}")
    public ResponseEntity<?> getContactById(@PathVariable int contactId){
        Contact contact = contactService.findbyID(contactId);
        return ResponseEntity.ok(contact);
    }

    /**
     Xóa contact từ id
     Truyền contactId
     **/
    @DeleteMapping("/contacts/{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable int contactId)
    {
        return ResponseEntity.ok(contactService.deleted(contactId));
    }


    /**
     Update contact truyen body Contact
     **/
    @PutMapping("/contacts/{contactId}")
    public ResponseEntity<?> editContact(@RequestBody Contact contact)
    {
        return ResponseEntity.ok(contactService.save(contact));
    }

    /**
    Tạo 1 phones mới
     truyền body Contact
     **/

    @PostMapping("/contracts/{contractId}/phones")
    public ResponseEntity <?> addPhone(@RequestBody Contact contact)
    {
        return ResponseEntity.ok(contactService.save(contact));
    }

    /**
     Lấy 1 số điện thoại từ contractId -> phoneId
     Truyền PathVariable contactId và phoneId
     **/
    @GetMapping("/contact/{contactId}/phones/{phoneId}")
    public ResponseEntity<?> getPhoneById(@PathVariable int contactId, @PathVariable int phoneId)
    {
        List<Phone> phones = contactService.findbyID(contactId).getPhones();
        for(Phone phone : phones)
        {
            if(phone.getId() == phoneId)
            {
                return ResponseEntity.ok(phone.getPhoneNumber());
            }
        }
        return ResponseEntity.ok("");
    }


    /**
     Xóa phoneNumber từ phoneId
     **/
    @DeleteMapping("/contact/{contactId}/phone/{phoneId}")
    public ResponseEntity<?> deletePhoneById(@PathVariable int contactId, @PathVariable int phoneId)
    {
        return ResponseEntity.ok(phoneService.deleted(phoneId));
    }

    /**
     Edit số điện thoại

     truyền Body Phone
     **/
    @PutMapping("/contact/{contactId}/phone/{phoneId}")
    public ResponseEntity<?> updatePhoneById(@RequestBody Phone phone)
    {
        return ResponseEntity.ok(phoneService.save(phone));
    }





}
