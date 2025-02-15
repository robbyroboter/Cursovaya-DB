package org.example.cursovaya_bd.controllers;

import org.example.cursovaya_bd.entities.Client;
import org.example.cursovaya_bd.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public Page<Client> getAllClients(@RequestParam(required = false) Client.LegalForm legalForm, Pageable pageable) {
        if (legalForm != null) return clientService.findAllClientsByLegalForm(legalForm, pageable);
        return clientService.findAllClients(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.findClientById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientInfo) {
        Optional<Client> client = clientService.findClientById(id);
        if (client.isPresent()) {
            Client updatedClient = client.get();
            updatedClient.setAddress(clientInfo.getAddress());
            updatedClient.setName(clientInfo.getName());
            updatedClient.setShortName(clientInfo.getShortName());
            updatedClient.setLegalForm(clientInfo.getLegalForm());
            clientService.saveClient(updatedClient);
            return ResponseEntity.ok(updatedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
