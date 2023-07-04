package com.projeto.quiz.controllers;

import com.projeto.quiz.services.UserResponsesService;
import com.projeto.quiz.vo.UserResponsesOrmVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz/response")
@Tag(name = "Response", description = "Endpoint for managing response.")
public class UserResponsesController {

    @Autowired
    UserResponsesService userResponsesService;

    @GetMapping("/{id}")
    public List<UserResponsesOrmVO> responses(@PathVariable("id") Long userId) {
        return userResponsesService.response(userId);
    }

    @PostMapping
    public List<UserResponsesOrmVO> sendResponses(@RequestBody List<UserResponsesOrmVO> userResponses) {
        return userResponsesService.userResponsesOrm(userResponses);
    }
}