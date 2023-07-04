package com.projeto.quiz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_responses_orm")
public class UserResponsesOrm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_responses_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private QuestionOrm questionOrm;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name="user_response",nullable = false, length = 1)
    private String userResponse;
    @Column(name="correct", length = 5)
    private String correct;

    public UserResponsesOrm() {
    }

    public UserResponsesOrm(QuestionOrm questionOrm, User user, String userResponse, String correct) {
        this.questionOrm = questionOrm;
        this.user = user;
        this.userResponse = userResponse;
        this.correct = correct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionOrm getQuestionOrm() {
        return questionOrm;
    }

    public void setQuestionOrm(QuestionOrm questionOrm) {
        this.questionOrm = questionOrm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(String userResponse) {
        this.userResponse = userResponse;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponsesOrm that = (UserResponsesOrm) o;
        return Objects.equals(id, that.id) && Objects.equals(questionOrm, that.questionOrm) && Objects.equals(user, that.user) && Objects.equals(userResponse, that.userResponse) && Objects.equals(correct, that.correct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionOrm, user, userResponse, correct);
    }

    @Override
    public String toString() {
        return "UserResponsesOrm{" +
                "id=" + id +
                ", questionOrm=" + questionOrm +
                ", user=" + user +
                ", userResponse='" + userResponse + '\'' +
                ", correct='" + correct + '\'' +
                '}';
    }
}
