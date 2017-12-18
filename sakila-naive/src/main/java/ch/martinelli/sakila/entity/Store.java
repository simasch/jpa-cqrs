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
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="store_store_id_seq")
    @Column(name = "store_id")
    private Integer storeId;

    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
    @ManyToOne(optional = false)
    private Staff manager;

    @JoinColumn(name = "store_id")
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Staff> staff = new HashSet<>();

    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private Set<Inventory> inventories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private Set<Customer> customers = new HashSet<>();

}
