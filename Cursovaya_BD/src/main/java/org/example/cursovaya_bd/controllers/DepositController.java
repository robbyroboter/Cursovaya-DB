package org.example.cursovaya_bd.controllers;

import org.example.cursovaya_bd.entities.Deposit;
import org.example.cursovaya_bd.service.DepositService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/deposits")
public class DepositController {

    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @GetMapping()
    public Page<Deposit> getAllDeposits(@RequestParam(required = false)
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate openingDate,
                                        Pageable pageable) {
        if (openingDate != null) return depositService.findDepositsByOpeningDay(openingDate, pageable);
        return depositService.findAllDeposits(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deposit> getDepositById(@PathVariable Long id) {
        Optional<Deposit> deposit = depositService.findDepositById(id);
        return deposit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Deposit> createDeposit(@RequestBody Deposit deposit) {
        depositService.saveDeposit(deposit);
        return ResponseEntity.status(HttpStatus.CREATED).body(deposit);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Deposit> updateDeposit(@PathVariable Long id, @RequestBody Deposit depositItems) {
        Optional<Deposit> deposit = depositService.findDepositById(id);
        if (deposit.isPresent()) {
            Deposit updatedDeposit = deposit.get();
            updatedDeposit.setDepositPercentage(depositItems.getDepositPercentage());
            updatedDeposit.setTermInMonths(depositItems.getTermInMonths());
            depositService.saveDeposit(updatedDeposit);
            return ResponseEntity.ok(updatedDeposit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Deposit> deleteDeposit(@PathVariable Long id) {
        depositService.deleteDeposit(id);
        return ResponseEntity.noContent().build();
    }
}