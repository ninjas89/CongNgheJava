package tdtu.edu.un.WG26.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.edu.un.WG26.Model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {


}
