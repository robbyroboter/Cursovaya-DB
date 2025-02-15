package org.example.cursovaya_bd.service;

import org.example.cursovaya_bd.repositories.ClientRepository;
import org.example.cursovaya_bd.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Page<Client> findAllClientsByLegalForm(Client.LegalForm legalForm, Pageable pageable) {
        return clientRepository.findByLegalForm(legalForm, pageable);
    }

    public Page<Client> findAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
