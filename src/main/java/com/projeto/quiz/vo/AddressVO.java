package com.projeto.quiz.vo;

import com.projeto.quiz.models.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddressVO implements Serializable {
    private Long id;
    private String cep;
    private String publicPlace;
    private String neighborhood;
    private String complement;
    private String state;
    private String city;
    private String country;

    private List<User> users = new ArrayList<>();

    public AddressVO(String cep, String publicPlace, String neighborhood, String complement, String state, String city, String country, List<User> users) {
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
        AddressVO addressVO = (AddressVO) o;
        return Objects.equals(id, addressVO.id) && Objects.equals(cep, addressVO.cep) && Objects.equals(publicPlace, addressVO.publicPlace) && Objects.equals(neighborhood, addressVO.neighborhood) && Objects.equals(complement, addressVO.complement) && Objects.equals(state, addressVO.state) && Objects.equals(city, addressVO.city) && Objects.equals(country, addressVO.country) && Objects.equals(users, addressVO.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, publicPlace, neighborhood, complement, state, city, country, users);
    }

    @Override
    public String toString() {
        return "AddressVO{" +
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
