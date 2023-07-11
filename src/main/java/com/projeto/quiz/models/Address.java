package com.projeto.quiz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "address_table")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "cep", nullable = false, length = 8)
    private String cep;

    @Column(name = "public_place", nullable = false, length = 256)
    private String publicPlace;

    @Column(name = "neighborhood", nullable = false, length = 256)
    private String neighborhood;

    @Column(name = "complement", length = 256)
    private String complement;

    @Column(name = "state", nullable = false, length = 256)
    private String state;

    @Column(name = "city", nullable = false, length = 256)
    private String city;

    @Column(name = "country", nullable = false, length = 256)
    private String country;

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonIgnore
    private List<User> users = new ArrayList<>();


    public Address() {
    }

    public Address(String cep, String publicPlace, String neighborhood, String complement, String state, String city, String country, List<User> users) {
        this.cep = cep;
        this.publicPlace = publicPlace;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.state = state;
        this.city = city;
        this.country = country;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(cep, address.cep) && Objects.equals(publicPlace, address.publicPlace) && Objects.equals(neighborhood, address.neighborhood) && Objects.equals(complement, address.complement) && Objects.equals(state, address.state) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(users, address.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, publicPlace, neighborhood, complement, state, city, country, users);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", publicPlace='" + publicPlace + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", complement='" + complement + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", users=" + users +
                '}';
    }
}
