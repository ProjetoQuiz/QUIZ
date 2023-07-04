package com.projeto.quiz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "document_table")
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long id;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @OneToOne(mappedBy = "document")
    @JsonIgnore
    private User user;

    public Document() {
    }

    public Document(Long id, String cpf, User user) {
        this.id = id;
        this.cpf = cpf;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) && Objects.equals(cpf, document.cpf) && Objects.equals(user, document.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, user);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", user=" + user +
                '}';
    }
}