package com.projeto.quiz.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.quiz.models.Address;
import com.projeto.quiz.models.Document;
import com.projeto.quiz.models.UserResponsesOrm;
import com.projeto.quiz.models.UserResultOrm;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserVO extends RepresentationModel<UserVO> implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phone;
    private String sex;
    private Document document;
    @JsonIgnore
    private List<UserResponsesOrm> userResponsesOrm = new ArrayList<>();
    private UserResultOrm userResultOrm;
    private List<Address> addresses = new ArrayList<>();

    public UserVO() {
    }

    public UserVO(String firstName, String lastName, String userName, String password, String phone, String sex, Document document, List<UserResponsesOrm> userResponsesOrm, UserResultOrm userResultOrm, List<Address> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.document = document;
        this.userResponsesOrm = userResponsesOrm;
        this.userResultOrm = userResultOrm;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<UserResponsesOrm> getUserResponsesOrm() {
        return userResponsesOrm;
    }

    public void setUserResponsesOrm(List<UserResponsesOrm> userResponsesOrm) {
        this.userResponsesOrm = userResponsesOrm;
    }

    public UserResultOrm getUserResultOrm() {
        return userResultOrm;
    }

    public void setUserResultOrm(UserResultOrm userResultOrm) {
        this.userResultOrm = userResultOrm;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(id, userVO.id) && Objects.equals(firstName, userVO.firstName) && Objects.equals(lastName, userVO.lastName) && Objects.equals(userName, userVO.userName) && Objects.equals(password, userVO.password) && Objects.equals(phone, userVO.phone) && Objects.equals(sex, userVO.sex) && Objects.equals(document, userVO.document) && Objects.equals(userResponsesOrm, userVO.userResponsesOrm) && Objects.equals(userResultOrm, userVO.userResultOrm) && Objects.equals(addresses, userVO.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, firstName, lastName, userName, password, phone, sex, document, userResponsesOrm, userResultOrm, addresses);
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", document=" + document +
                ", userResponsesOrm=" + userResponsesOrm +
                ", userResultOrm=" + userResultOrm +
                ", addresses=" + addresses +
                '}';
    }
}
