package exp.avishek.phonebook.dao;

import exp.avishek.phonebook.model.entity.PhonebookDirectoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookEntityDao extends JpaRepository<PhonebookDirectoryEntity, Integer> {

    PhonebookDirectoryEntity findPhonebookDirectoryEntityByFirstName(String firstName);

    PhonebookDirectoryEntity findPhonebookDirectoryEntityByLastName(String lastName);

}
