package com.example.bancopan.domain;

import com.example.bancopan.domain.enums.Gender;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client extends DomainModel<Client> {

    private static final long serialVersionUID = -4089639955528439777L;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    public String getDocument() {
        return document;
    }

    public Client withDocument(String document) {
        this.document = document;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Client withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Client withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public String getEmail() {
        return email;
    }

    public Client withEmail(String email) {
        this.email = email;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Client withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Client withAddress(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(document, client.document) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(email, client.email) && gender == client.gender && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document, firstName, lastName, email, gender, address);
    }
}
