package com.projeto.quiz.vo;

import com.projeto.quiz.models.User;

import java.io.Serializable;
import java.util.Objects;

public class DocumentVO implements Serializable {
    private Long id;
    private String cpf;
    private User user;
    public DocumentVO() {
    }

    public DocumentVO(Long id, String cpf, User user) {
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
        DocumentVO that = (DocumentVO) o;
        return Objects.equals(id, that.id) && Objects.equals(cpf, that.cpf) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, user);
    }

    @Override
    public String toString() {
        return "DocumentVO{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", user=" + user +
                '}';
    }
}