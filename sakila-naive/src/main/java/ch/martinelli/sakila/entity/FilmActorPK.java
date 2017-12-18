package ch.martinelli.sakila.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Embeddable
public class FilmActorPK implements Serializable {

    @NotNull
    @Column(name = "actor_id")
    private short actorId;

    @NotNull
    @Column(name = "film_id")
    private short filmId;
}
