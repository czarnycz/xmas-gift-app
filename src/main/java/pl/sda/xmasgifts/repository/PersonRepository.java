package pl.sda.xmasgifts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.xmasgifts.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
