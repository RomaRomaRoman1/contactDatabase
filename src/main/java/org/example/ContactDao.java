package org.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class ContactDao {
    private List<ContactDatabase> contactDatabaseList = new ArrayList<ContactDatabase>();
    public Optional<ContactDatabase> findAccount(String lastname) {
      Optional<ContactDatabase> result = contactDatabaseList.stream()
              .filter(contactDatabase -> contactDatabase.getLastName().equals(lastname))
              .findFirst();
      result.ifPresentOrElse(contactDatabase -> System.out.println("Найден контакт: " + contactDatabase),
              () -> System.out.println("Контакт " + lastname + " не найден..."));
      return result;
    }
    public List<ContactDatabase> addToContactDaoList (String name, String lastName, String phoneNumber, String email) {
        ContactDatabase contactDatabase = new ContactDatabase();
        contactDatabase.setPhoneNumber(phoneNumber);
        contactDatabase.setName(name);
        contactDatabase.setEmail(email);
        contactDatabase.setLastName(lastName);
        contactDatabaseList.add(contactDatabase);
       return contactDatabaseList;
    }
    public List<ContactDatabase> allContactDataBase() {
        return contactDatabaseList;
    }
    public Optional<ContactDatabase> changeContactDatabase (String lastName, String newPhoneNumber) {
        Optional<ContactDatabase> result1 = contactDatabaseList.stream()
                .filter(contactDatabase -> contactDatabase.getLastName().equals(lastName))
                        .map(contactDatabase -> {contactDatabase.setPhoneNumber(newPhoneNumber);
        return contactDatabase;})
                                .findFirst();

        result1.ifPresentOrElse(contactDatabase -> System.out.println("Контакт найден: " + contactDatabase), () -> System.out.println("Контакт: " + lastName + "Не найден"));
        return result1;
    }
}
