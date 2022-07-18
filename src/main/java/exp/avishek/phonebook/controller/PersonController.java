package exp.avishek.phonebook.controller;

import exp.avishek.phonebook.model.Person;
import exp.avishek.phonebook.service.PhoneBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PhoneBookService phoneBookService;

    public PersonController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @GetMapping(path = "/firstName")
    public Person getPersonByFirstName(@RequestParam String firstName){
        return phoneBookService.getDetailsByFirstName(firstName);
    }

    @GetMapping(path = "/lastName")
    public Person getPersonByLastName(@RequestParam String lastName) {
        return phoneBookService.getDetailsByFirstName(lastName);
    }
}
