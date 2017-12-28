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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_customer_id_seq")
    @SequenceGenerator(name = "customer_customer_id_seq", sequenceName = "customer_customer_id_seq")
    @Column(name = "customer_id")
    private Integer customerId;

    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 50)
    private String email;

    @NotNull
    private boolean activebool;

    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    private Integer active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Rental> rentals = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Payment> payments = new HashSet<>();

    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address address;

    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne(optional = false)
    private Store store;
}
