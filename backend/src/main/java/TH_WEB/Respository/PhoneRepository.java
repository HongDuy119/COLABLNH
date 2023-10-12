package TH_WEB.Respository;

import TH_WEB.Enity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    List<Phone> findAll();
    @Query(value = "select p from Phone p join p.contacts c where c.id = :contactId")
    List<Phone> listPhoneContactId(int contactId);
    public Phone findById(int id);

    String deleteById(int id);
}
