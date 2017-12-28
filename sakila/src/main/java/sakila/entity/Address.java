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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_address_id_seq")
    @SequenceGenerator(name = "address_address_id_seq", sequenceName = "address_address_id_seq")
    @Column(name = "address_id")
    private Integer addressId;

    @NotNull
    @Size(min = 1, max = 50)
    private String address;

    @Size(max = 50)
    private String address2;

    @NotNull
    @Size(min = 1, max = 20)
    private String district;

    @Size(max = 10)
    @Column(name = "postal_code")
    private String postalCode;

    @NotNull
    @Size(min = 1, max = 20)
    private String phone;

    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City city;

    @OneToMany(mappedBy = "address")
    private Set<Store> stores = new HashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<Staff> staff = new HashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<Customer> customers = new HashSet<>();
}
