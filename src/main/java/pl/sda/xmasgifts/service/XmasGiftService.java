package pl.sda.xmasgifts.service;

import pl.sda.xmasgifts.entity.Person;
import pl.sda.xmasgifts.entity.Wish;

import java.util.List;
import java.util.Optional;


public interface XmasGiftService {
    Person addPerson(Person person);
    Optional<Wish> addPersonWish(Wish wish, long personId);
    Wish fulfillWishByPerson(long wishId, long personId);
    List<Wish> findAllWishes();
    List<Person> findAllGifters();

    List<Person> findAllPersons();
}
