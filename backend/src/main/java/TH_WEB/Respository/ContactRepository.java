package TH_WEB.Respository;

import TH_WEB.Enity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findAll();

    Contact findById(int id);


}
