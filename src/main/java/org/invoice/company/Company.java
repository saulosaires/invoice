package org.invoice.company;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.invoice.bank.Bank;
import org.invoice.country.Country;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @Column(length = 1000)
    private String address;

    private String vat;

    @OneToMany(mappedBy="company")
    private Set<Bank> banks;
}
