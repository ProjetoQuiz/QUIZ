package com.projeto.quiz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_result_orm")
public class UserResultOrm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_result_orm_id")
    private Long id;
    @Column(name = "user_name", nullable = false, length = 120)
    private String userName;
    @Column(name = "total_correct", nullable = false)
    private Integer totalCorrect;
    @Column(name = "total_wrong", nullable = false)
    private Integer totalWrong;

    @OneToOne(mappedBy = "userResultOrm")
    private User user;

    public UserResultOrm() {
    }

    public UserResultOrm(String userName, Integer totalCorrect, Integer totalWrong, User user) {
        this.userName = userName;
        this.totalCorrect = totalCorrect;
        this.totalWrong = totalWrong;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(Integer totalCorrect) {
        this.totalCorrect = totalCorrect;
    }

    public Integer getTotalWrong() {
        return totalWrong;
    }

    public void setTotalWrong(Integer totalWrong) {
        this.totalWrong = totalWrong;
    }

    @JsonIgnore
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
        UserResultOrm that = (UserResultOrm) o;
        return Objects.equals(id, that.id) && Objects.equals(userName, that.userName) && Objects.equals(totalCorrect, that.totalCorrect) && Objects.equals(totalWrong, that.totalWrong) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, totalCorrect, totalWrong, user);
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", totalCorrect=" + totalCorrect +
                ", totalWrong=" + totalWrong +
                ", user=" + user +
                '}';
    }
}
