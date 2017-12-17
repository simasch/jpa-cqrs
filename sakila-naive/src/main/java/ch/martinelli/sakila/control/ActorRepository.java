package ch.martinelli.sakila.control;

import ch.martinelli.sakila.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
