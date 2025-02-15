package org.example.cursovaya_bd.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String bik;


    public Bank() {}
    public Bank(String name, String bik) {
        this.name = name;
        this.bik = bik;
    }

    // get
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getBik() { return bik; }

    // set
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBik(String bik) { this.bik = bik; }

}
