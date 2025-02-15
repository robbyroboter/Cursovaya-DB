package org.example.cursovaya_bd.entities;

import jakarta.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String name;
    private String shortName;
    @Enumerated(EnumType.STRING)
    private LegalForm legalForm;

    public enum LegalForm {
        LLC,   // ООО
        CJSC,    // ЗАО
        INDIVIDUAL,  // Индивидуальный предприниматель
        JSC    // ОАО
    }

    public Client() {}
    public Client(String address, String name, String shortName, LegalForm legalForm) {
        this.address = address;
        this.name = name;
        this.shortName = shortName;
        this.legalForm = legalForm;
    }

    // get
    public Long getId() { return id; }
    public String getAddress() { return address; }
    public String getName() { return name; }
    public String getShortName() { return shortName; }
    public LegalForm getLegalForm() { return legalForm; }

    // set
    public void setId(Long id) { this.id = id; }
    public void setAddress(String address) { this.address = address; }
    public void setName(String name) { this.name = name; }
    public void setShortName(String shortName) { this.shortName = shortName; }
    public void setLegalForm(LegalForm legalForm) { this.legalForm = legalForm; }

}
