package pl.sda.xmasgifts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.xmasgifts.entity.Wish;

@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {

}
