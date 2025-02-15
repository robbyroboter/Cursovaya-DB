package org.example.cursovaya_bd.repositories;

import org.example.cursovaya_bd.entities.Deposit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
    Page<Deposit> findByOpeningDate(LocalDate openingDate, Pageable pageable);

}
