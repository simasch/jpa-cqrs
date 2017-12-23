package sakila.control;

import org.springframework.data.jpa.repository.JpaRepository;
import sakila.entity.Actor;
import sakila.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
