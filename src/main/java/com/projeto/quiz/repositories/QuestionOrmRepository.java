package com.projeto.quiz.repositories;

import com.projeto.quiz.models.QuestionOrm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionOrmRepository extends JpaRepository<QuestionOrm, Long> {


}
