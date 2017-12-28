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
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_staff_id_seq")
    @SequenceGenerator(name = "staff_staff_id_seq", sequenceName = "staff_staff_id_seq")
    @Column(name = "staff_id")
    private Integer staffId;

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
    private boolean active;

    @NotNull
    @Size(min = 1, max = 16)
    private String username;

    @Size(max = 40)
    private String password;

    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Lob
    private byte[] picture;

    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address address;

    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne(optional = false)
    private Store store;

    @OneToMany(mappedBy = "manager")
    private Set<Store> managedStores = new HashSet<>();

    @OneToMany(mappedBy = "staff")
    private Set<Payment> payments = new HashSet<>();

}
