package ch.martinelli.sakila.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Embeddable
public class FilmCategoryPK implements Serializable {

    @NotNull
    @Column(name = "film_id")
    private short filmId;

    @NotNull
    @Column(name = "category_id")
    private short categoryId;
}
