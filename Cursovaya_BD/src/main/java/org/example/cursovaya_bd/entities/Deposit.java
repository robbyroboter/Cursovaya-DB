package org.example.cursovaya_bd.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Bank bank;

    private LocalDate openingDate;
    private Double depositPercentage;
    private Integer termInMonths;


    public Deposit() {}

    public Deposit(LocalDate openingDate, Double depositPercentage, Integer termInMonths) {
        this.openingDate = openingDate;
        this.depositPercentage = depositPercentage;
        this.termInMonths = termInMonths;
    }

    // get
    public Long getId() { return id; }
    public Client getClient() { return client; }
    public Bank getBank() { return bank; }
    public LocalDate getOpeningDate() { return openingDate; }
    public Double getDepositPercentage() { return depositPercentage; }
    public Integer getTermInMonths() { return termInMonths; }

    // set
    public void setId(Long id) { this.id = id; }
    public void setClient(Client client) { this.client = client; }
    public void setBank(Bank bank) { this.bank = bank; }
    public void setOpeningDate(LocalDate openingDate) { this.openingDate = openingDate; }
    public void setDepositPercentage(Double depositPercentage) { this.depositPercentage = depositPercentage; }
    public void setTermInMonths(Integer termInMonths) { this.termInMonths = termInMonths; }

}
