package sakila.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_country_id_seq")
    @SequenceGenerator(name = "country_country_id_seq", sequenceName = "country_country_id_seq")
    @Column(name = "country_id")
    private Integer countryId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String country;

    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @OneToMany(mappedBy = "country")
    private Set<City> cities = new HashSet<>();
}
