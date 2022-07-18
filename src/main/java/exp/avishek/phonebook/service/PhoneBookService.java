package exp.avishek.phonebook.service;

import exp.avishek.phonebook.model.Person;

public interface PhoneBookService {

    Person getDetailsByFirstName(String firstName);

    Person getDetailsByLastName(String lastName);
}
