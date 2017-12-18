package ch.martinelli.sakila.control;

import ch.martinelli.sakila.entity.Actor;
import ch.martinelli.sakila.entity.ActorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    ActorInfo findByActorId(Integer id);
}
