package pl.sda.xmasgifts.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.xmasgifts.entity.Person;
import pl.sda.xmasgifts.entity.Wish;
import pl.sda.xmasgifts.repository.PersonRepository;
import pl.sda.xmasgifts.repository.WishRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JpaXmasGiftsService implements XmasGiftService{
    final WishRepository wishRepository;
    final PersonRepository personRepository;

    public JpaXmasGiftsService(WishRepository wishRepository, PersonRepository personRepository) {
        this.wishRepository = wishRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Person addPerson(Person person) {
        person.setId(UUID.randomUUID());
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public Optional<Wish> addPersonWish(Wish wish, UUID personId) {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        if(!optionalPerson.isPresent()){
            return Optional.empty();
        }
        Person person = optionalPerson.get();
        wish.setOwner(person);
        return Optional.of(wishRepository.save(wish));
    }

    @Override
    public Wish fulfillWishByPerson(long wishId, long personId) {
        return null;
    }

    @Override
    public List<Wish> findAllWishes() {
        return null;
    }

    @Override
    public List<Person> findAllGifters() {
        return null;
    }

    @Override
    public List<Person> findAllPersons(){
        return personRepository.findAll();
    }
}
