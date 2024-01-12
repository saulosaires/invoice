package org.invoice.contact;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String phone;
    @Column(length = 1000)
    private String address;
    private String contactPerson;
    private String vat;
    private boolean isClient;
    private boolean isSupplier;
    private String bankName;
    private String accountHolder;
    private String accountNumber;
    private String swiftBic;
}
