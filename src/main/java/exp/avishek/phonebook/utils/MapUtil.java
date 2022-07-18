package exp.avishek.phonebook.utils;

import exp.avishek.phonebook.model.Address;
import exp.avishek.phonebook.model.Person;
import exp.avishek.phonebook.model.Phone;
import exp.avishek.phonebook.model.entity.AddressEntity;
import exp.avishek.phonebook.model.entity.PhoneEntity;
import exp.avishek.phonebook.model.entity.PhonebookDirectoryEntity;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class MapUtil {

    public Person personMapper(@NotNull PhonebookDirectoryEntity personEntity, PhoneEntity phoneEntity, AddressEntity currentAddressEntity, AddressEntity permanentAddressEntity) {
        Person person = new Person();
        person.setFirstName(personEntity.getFirstName());
        person.setLastName(personEntity.getLastName());
        person.setAge(personEntity.getAge());
        person.setSSN(personEntity.getSsn());
        person.setCurrentAddress(addresMapper(currentAddressEntity));
        person.setPermanentAddress(addresMapper(permanentAddressEntity));
        person.setPhone(phoneMapper(phoneEntity));
        return person;
    }

    private Address addresMapper(AddressEntity addressEntity) {
        Address address = new Address();

        address.setAddressLine1(addressEntity.getAddressLine1());
        address.setAddressLine2(addressEntity.getAddressLine2());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setCountry(addressEntity.getCountry());
        address.setZipcode(Integer.toString(addressEntity.getZipcode()));

        return address;
    }

    private Phone phoneMapper(PhoneEntity phoneEntity) {
        Phone phone = new Phone();

        phone.setCountryCode(phoneEntity.getCountryCode());
        phone.setHomePhone(phoneEntity.getHomePhone());
        phone.setOfficePhone(phoneEntity.getOfficePhone());
        phone.setCellPhone(phoneEntity.getCellPhone());

        return phone;
    }
}
