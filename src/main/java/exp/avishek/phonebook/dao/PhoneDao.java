package exp.avishek.phonebook.dao;

import exp.avishek.phonebook.model.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneDao extends JpaRepository<PhoneEntity, Integer> {

    PhoneEntity findAllByPhoneId(int phoneId);

    PhoneEntity findPhoneEntitiesByHomePhone(String homePhone);

    PhoneEntity findPhoneEntitiesByOfficePhone(String officePhone);

    PhoneEntity findPhoneEntitiesByCellPhone(String cellPhone);

    List<PhoneEntity> findAll();
}
