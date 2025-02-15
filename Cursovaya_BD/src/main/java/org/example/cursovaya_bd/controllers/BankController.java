package org.example.cursovaya_bd.controllers;

import org.example.cursovaya_bd.entities.Bank;
import org.example.cursovaya_bd.service.BankService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping()
    public Page<Bank> getAllBanks(Pageable pageable) {
        return bankService.findAllBanks(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable Long id) {
        Optional<Bank> bank = bankService.findBankById(id);
        // bank.isPresent() ? ResponseEntity.ok(bank.get()) : ResponseEntity.notFound().build();
        return bank.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Bank> createBank(@RequestBody Bank bankItems) {
        Bank bank = new Bank(bankItems.getName(), bankItems.getBik());
        Bank createdBank = bankService.saveBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBank);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable Long id, @RequestBody Bank bankItems) {
        Optional<Bank> bank = bankService.findBankById(id);
        if (bank.isPresent()) {
            Bank updatedBank = bank.get();
            updatedBank.setName(bankItems.getName());
            updatedBank.setBik(bankItems.getBik());
            bankService.saveBank(updatedBank);
            return ResponseEntity.ok(updatedBank);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bank> deleteBank(@PathVariable Long id) {
        bankService.deleteBank(id);
        return ResponseEntity.noContent().build();
    }
}