package org.example.cursovaya_bd.service;

import org.example.cursovaya_bd.entities.Deposit;
import org.example.cursovaya_bd.repositories.DepositRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DepositService {

    private final DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public Deposit saveDeposit(Deposit deposit) {
        if (deposit.getClient() == null) throw new RuntimeException("Client not found!");
        if (deposit.getBank() == null) throw new RuntimeException("Bank not found!");
        return depositRepository.save(deposit);
    }

    public Optional<Deposit> findDepositById(Long id) {
        return depositRepository.findById(id);
    }

    public Page<Deposit> findAllDeposits(Pageable pageable) {
        return depositRepository.findAll(pageable);
    }

    public Page<Deposit> findDepositsByOpeningDay(LocalDate openingDate, Pageable pageable) {
        return depositRepository.findByOpeningDate(openingDate, pageable);
    }

    public void deleteDeposit(Long id) {
        depositRepository.deleteById(id);
    }

}
