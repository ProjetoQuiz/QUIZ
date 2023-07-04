package com.projeto.quiz.controllers;

import com.projeto.quiz.services.UserResultOrmService;
import com.projeto.quiz.vo.UserResultOrmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz/result/orm")
public class UserResultOrmController {

    @Autowired
    UserResultOrmService userResultOrmService;

    @PostMapping("/{id}")
    public UserResultOrmVO save(@PathVariable("id") Long userId){
        return userResultOrmService.saveResultOrm(userId);
    }
}
