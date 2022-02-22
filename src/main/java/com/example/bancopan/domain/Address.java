package com.example.bancopan.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address extends DomainModel<Address> {

    private static final long serialVersionUID = -3960497341753472344L;

    private static final String WITHOUT_NUMBER = "SN";

    public static final String STREET = "street";
    public static final String ZIPCODE = "zipcode";
    public static final String NUMBER = "number";
    public static final String COMPLEMENT = "complement";
    public static final String CITY = "city";

    @NotEmpty
    @Column(nullable = false)
    private String zipcode;

    @NotEmpty
    @Column(nullable = false)
    private String street;

    @NotEmpty
    @Column(nullable = false)
    private String number;

    @NotEmpty
    @Column(nullable = false)
    private String city;

    @NotNull
    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private State state;

    public Address() {}

    public Address(String zipCode, String street, String number, String city, State state) {

        withZipCode(zipCode);
        withStreet(street);
        withNumber(number);
        withCity(city);
        withState(state);
    }

    public String getZipcode() {
        return zipcode;
    }

    public Address withZipCode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address withStreet(String street) {
        this.street = street;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Address withNumber(String number) {
        if (Objects.isNull(number)) {
            this.number = WITHOUT_NUMBER;
        } else {
            this.number = number;
        }
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    public State getState() {
        return state;
    }

    public Address withState(State state) {
        this.state = state;
        return this;
    }

    public static class AddressBuilder {

        private String zipCode;
        private String street;
        private String number;
        private String city;
        private State state;

        public AddressBuilder withZipcode(String zipcode) {
            this.zipCode = zipcode;
            return this;
        }

        public AddressBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder withState(State state) {
            this.state = state;
            return this;
        }


        public Address build() {
            return new Address(zipCode, street, number, city, state);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Address address = (Address) o;
        return Objects.equals(zipcode, address.zipcode) && Objects.equals(street, address.street) && Objects.equals(number, address.number) && Objects.equals(city, address.city) && Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipcode, street, number, city, state);
    }
}
