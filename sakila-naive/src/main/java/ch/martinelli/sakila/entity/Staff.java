package ch.martinelli.sakila.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
}
