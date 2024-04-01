package org.invoice.bank;

import org.invoice.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BankRepository extends JpaRepository<Bank, UUID> {
    List<Bank> findByCompanyOrderByName(Company company);
}
