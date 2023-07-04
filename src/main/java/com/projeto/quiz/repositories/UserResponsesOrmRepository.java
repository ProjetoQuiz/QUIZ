package com.projeto.quiz.repositories;

import com.projeto.quiz.models.UserResponsesOrm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserResponsesOrmRepository extends JpaRepository<UserResponsesOrm,Long> {

    @Query("SELECT ur FROM UserResponsesOrm ur WHERE ur.user.id = :userId")
    List<UserResponsesOrm> findByUserId(@Param("userId") Long userId);


}
