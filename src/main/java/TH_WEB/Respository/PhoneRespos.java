package TH_WEB.Respository;

import TH_WEB.Enity.Contact;
import TH_WEB.Enity.Phone;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PhoneRespos extends JpaRepository<Phone, Integer> {

    List<Phone> findAll();

    public Phone findById(int id);

    String deleteById(int id);
}
