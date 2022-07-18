package exp.avishek.phonebook.dao;

import exp.avishek.phonebook.model.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao extends JpaRepository<AddressEntity, Integer> {

    AddressEntity findAddressEntityByAddressId(int addressID);

//    AddressEntity findPhonebookDirectoryEntitiesByLastName(String lastName);

    List<AddressEntity> findAll();


}
