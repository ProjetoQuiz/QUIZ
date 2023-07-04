package com.projeto.quiz.vo;


import com.projeto.quiz.models.QuestionOrm;
import com.projeto.quiz.models.User;

import java.io.Serializable;
import java.util.Objects;

public class UserResponsesOrmVO implements Serializable {
    private Long id;

    private QuestionOrm questionOrm;

    private User user;
    private String userResponse;
    private String correct;

    public UserResponsesOrmVO() {
    }

    public UserResponsesOrmVO(QuestionOrm questionOrm, User user, String userResponse, String correct) {
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
        UserResponsesOrmVO that = (UserResponsesOrmVO) o;
        return Objects.equals(id, that.id) && Objects.equals(questionOrm, that.questionOrm) && Objects.equals(user, that.user) && Objects.equals(userResponse, that.userResponse) && Objects.equals(correct, that.correct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionOrm, user, userResponse, correct);
    }

    @Override
    public String toString() {
        return "UserResponsesOrmVO{" +
                "id=" + id +
                ", questionOrm=" + questionOrm +
                ", user=" + user +
                ", userResponse='" + userResponse + '\'' +
                ", correct='" + correct + '\'' +
                '}';
    }
}
