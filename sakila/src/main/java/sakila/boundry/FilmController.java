package sakila.boundry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sakila.control.ActorRepository;
import sakila.control.FilmRepository;
import sakila.entity.Actor;
import sakila.entity.Film;

import java.util.List;

@RestController
@RequestMapping(path = "api/films")
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping
    public List<Film> getOAll() {
        return filmRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Film getOne(@PathVariable Integer id) {
        return filmRepository.getOne(id);
    }

}
