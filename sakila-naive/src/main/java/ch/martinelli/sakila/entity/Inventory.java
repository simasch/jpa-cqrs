package ch.martinelli.sakila.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "inventory_inventory_id_seq")
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    @ManyToOne(optional = false)
    private Film film;

    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne(optional = false)
    private Store store;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private Set<Rental> rentals = new HashSet<>();

}
