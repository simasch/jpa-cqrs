package ch.martinelli.sakila.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "category_category_id_seq")
    @Column(name = "category_id")
    private Integer categoryId;

    @NotNull
    @Size(min = 1, max = 25)
    private String name;

    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<FilmCategory> filmCategories = new HashSet<>();
}
