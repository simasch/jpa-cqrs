package sakila.boundry;

import sakila.control.ActorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sakila.entity.Actor;

import java.util.List;

@RestController
@RequestMapping(path = "api/actors")
public class ActorController {

    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping
    public List<Actor> getOAll() {
        return actorRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Actor getOne(@PathVariable Integer id) {
        return actorRepository.getOne(id);
    }

}
