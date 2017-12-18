package ch.martinelli.sakila.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "film_film_id_seq")
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

    @Size(max = 2147483647)
    private String rating;

    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Column(name = "special_features")
    private Serializable specialFeatures;

    /*
    @NotNull
    @Lob
    private char[] fulltext;
    */

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Set<FilmCategory> filmCategories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Set<FilmActor> filmActors = new HashSet<>();

    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    @ManyToOne(optional = false)
    private Language language;

    @JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
    @ManyToOne
    private Language originalLanguage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Set<Inventory> inventories = new HashSet<>();

}
