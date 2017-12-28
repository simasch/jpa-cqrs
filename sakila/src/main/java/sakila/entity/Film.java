package sakila.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "film_film_id_seq")
    @SequenceGenerator(name = "film_film_id_seq", sequenceName = "film_film_id_seq")
    @Column(name = "film_id")
    private Integer filmId;

    @NotNull
    @Size(min = 1, max = 255)
    private String title;

    @Size(max = 2147483647)
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @NotNull
    @Column(name = "rental_duration")
    private short rentalDuration;

    @NotNull
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    private Short length;

    @NotNull
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    private Set<Actor> actors = new HashSet<>();

    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    @ManyToOne(optional = false)
    private Language language;

    @JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
    @ManyToOne
    private Language originalLanguage;

    @OneToMany(mappedBy = "film")
    private Set<Inventory> inventories = new HashSet<>();
}
