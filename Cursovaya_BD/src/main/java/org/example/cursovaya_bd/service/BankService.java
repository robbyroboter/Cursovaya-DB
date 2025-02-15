package org.example.cursovaya_bd.service;

import org.example.cursovaya_bd.entities.Bank;
import org.example.cursovaya_bd.repositories.BankRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {

    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public Optional<Bank> findBankById(Long id) {
        return bankRepository.findById(id);
    }

    public Page<Bank> findAllBanks(Pageable pageable) {
        return bankRepository.findAll(pageable);
    }

    public void deleteBank(Long id) {
        bankRepository.deleteById(id);
    }
}
