package com.projeto.quiz.repositories;

import com.projeto.quiz.models.UserResultOrm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResultOrmRepository extends JpaRepository<UserResultOrm, Long> {
}

