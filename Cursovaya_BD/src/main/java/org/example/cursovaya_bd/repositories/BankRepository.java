package org.example.cursovaya_bd.repositories;

import org.example.cursovaya_bd.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
