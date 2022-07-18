package exp.avishek.phonebook.service.impl;

import exp.avishek.phonebook.dao.AddressDao;
import exp.avishek.phonebook.dao.PhoneBookEntityDao;
import exp.avishek.phonebook.dao.PhoneDao;
import exp.avishek.phonebook.model.Person;
import exp.avishek.phonebook.model.entity.AddressEntity;
import exp.avishek.phonebook.model.entity.PhoneEntity;
import exp.avishek.phonebook.model.entity.PhonebookDirectoryEntity;
import exp.avishek.phonebook.service.PhoneBookService;
import exp.avishek.phonebook.utils.MapUtil;
import org.springframework.stereotype.Service;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    private PhoneDao phoneDao;
    private AddressDao addressDao;
    private PhoneBookEntityDao phoneBookEntityDao;

    public PhoneBookServiceImpl() {
    }

    public PhoneBookServiceImpl(PhoneDao phoneDao, AddressDao addressDao, PhoneBookEntityDao phoneBookEntityDao) {
        this.phoneDao = phoneDao;
        this.addressDao = addressDao;
        this.phoneBookEntityDao = phoneBookEntityDao;
    }

    @Override
    public Person getDetailsByFirstName(String firstName) {

        PhonebookDirectoryEntity phonebookDirectoryEntity = phoneBookEntityDao.findPhonebookDirectoryEntityByFirstName(firstName);
        return fillDetails(phonebookDirectoryEntity);
    }

    @Override
    public Person getDetailsByLastName(String lastName) {

        PhonebookDirectoryEntity phonebookDirectoryEntity = phoneBookEntityDao.findPhonebookDirectoryEntityByLastName(lastName);
        return fillDetails(phonebookDirectoryEntity);
    }

    private Person fillDetails(PhonebookDirectoryEntity phonebookDirectoryEntity) {
        PhoneEntity phoneEntity = phoneDao.findAllByPhoneId(phonebookDirectoryEntity.getPhoneId());
        AddressEntity currentAddressEntity = addressDao.findAddressEntityByAddressId(phonebookDirectoryEntity.getcAddressId());
        AddressEntity permanentAddressEntity = addressDao.findAddressEntityByAddressId(phonebookDirectoryEntity.getpAddressId());
        return MapUtil.personMapper(phonebookDirectoryEntity, phoneEntity, currentAddressEntity, permanentAddressEntity);
    }

}
