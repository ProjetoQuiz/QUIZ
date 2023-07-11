package com.projeto.quiz.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.quiz.models.User;

import java.io.Serializable;
import java.util.Objects;

public class UserRankingOrmVO implements Serializable {
    @JsonIgnore
    private Long id;
    private String userName;
    private Integer totalCorrect;
    @JsonIgnore
    private Integer totalWrong;
    @JsonIgnore
    private User user;

    public UserRankingOrmVO() {
    }

    public UserRankingOrmVO(String userName, Integer totalCorrect, Integer totalWrong, User user) {
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
        UserRankingOrmVO that = (UserRankingOrmVO) o;
        return Objects.equals(id, that.id) && Objects.equals(userName, that.userName) && Objects.equals(totalCorrect, that.totalCorrect) && Objects.equals(totalWrong, that.totalWrong) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, totalCorrect, totalWrong, user);
    }

    @Override
    public String toString() {
        return "UserRankingOrmVO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", totalCorrect=" + totalCorrect +
                ", totalWrong=" + totalWrong +
                ", user=" + user +
                '}';
    }
}
