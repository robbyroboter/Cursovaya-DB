package org.example.cursovaya_bd.repositories;

import org.example.cursovaya_bd.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findByLegalForm(Client.LegalForm legalForm, Pageable pageable);
}
