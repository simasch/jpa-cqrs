package ch.martinelli.sakila.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "language_language_id_seq")

    @Column(name = "language_id")
    private Integer languageId;

    @NotNull
    @Size(min = 1, max = 20)
    private String name;

    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "language")
    private Set<Film> films = new HashSet<>();

    @OneToMany(mappedBy = "originalLanguage")
    private Set<Film> originalLanguageFilms = new HashSet<>();
}
