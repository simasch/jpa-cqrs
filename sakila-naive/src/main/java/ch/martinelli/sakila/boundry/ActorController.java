package ch.martinelli.sakila.boundry;

import ch.martinelli.sakila.control.ActorRepository;
import ch.martinelli.sakila.entity.Actor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/actors")
public class ActorController {

    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping
    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Actor getOne(@PathVariable Integer id) {
        return actorRepository.findOne(id);
    }

}
