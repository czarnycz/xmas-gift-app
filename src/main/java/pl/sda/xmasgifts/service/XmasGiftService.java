package pl.sda.xmasgifts.service;

import org.springframework.transaction.annotation.Transactional;
import pl.sda.xmasgifts.entity.Person;
import pl.sda.xmasgifts.entity.Wish;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface XmasGiftService {
    Person addPerson(Person person);

    @Transactional
    Optional<Wish> addPersonWish(Wish wish, UUID personId);

    Wish fulfillWishByPerson(long wishId, long personId);
    List<Wish> findAllWishes();
    List<Person> findAllGifters();

    List<Person> findAllPersons();
}
