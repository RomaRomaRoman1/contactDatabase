package facade;

import controller.ContactDto;
import org.example.ContactDao;
import org.example.ContactDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.core.convert.TypeDescriptor.map;
@Service
public class ContactFacade {
    ContactDao contactDao;
    private List <ContactDto> contactDtoList = new ArrayList<>();
    @Autowired
    public ContactFacade(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
    public Optional <ContactDto> findAccount (String lastName) {
    return contactDao.findAccount(lastName)
            .map(ContactDto::new);
    }
    public List<ContactDto> findAll () {
        List<ContactDatabase> contactDatabaseList = contactDao.allContactDataBase();
        return contactDatabaseList.stream()
                .map(ContactDto::new)
                .collect(Collectors.toList());
    }
    public List <ContactDto> addToContactDtoList (String lastName, int phoneNumber){
        ContactDto contactDto = new ContactDto();
        contactDto.setNumberPhone(phoneNumber);
        contactDto.setLastName(lastName);
        contactDtoList.add(contactDto);
        return contactDtoList;
    }
    public Optional<ContactDto> changeContactDtoList (String lastName, int phoneNumber) {
    Optional<ContactDto> contactDto1= contactDao.changeContactDatabase(lastName, phoneNumber)
            .map(ContactDto::new);

            contactDto1.ifPresentOrElse(contactDto -> System.out.println("Контакт изменен: " + lastName),()-> System.out.println("Контакт не найден"));
    return contactDto1;
    }
}
