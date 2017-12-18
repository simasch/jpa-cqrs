package ch.martinelli.sakila.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "payment_payment_id_seq")
    @Column(name = "payment_id")
    private Integer paymentId;

    @NotNull
    private BigDecimal amount;

    @NotNull
    @Column(name = "payment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customer customer;

    @JoinColumn(name = "rental_id", referencedColumnName = "rental_id")
    @ManyToOne(optional = false)
    private Rental rental;

    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    @ManyToOne(optional = false)
    private Staff staff;
}
