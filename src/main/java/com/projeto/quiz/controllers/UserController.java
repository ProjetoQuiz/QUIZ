package com.projeto.quiz.controllers;

import com.projeto.quiz.services.UserService;
import com.projeto.quiz.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz/user")
public class UserController {
    @Autowired
    private UserService userService;
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

    @GetMapping("/{id}")
    public UserVO findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserVO save(@RequestBody UserVO userVO) {
        return userService.save(userVO);
    }
    @PutMapping
    public UserVO update(@RequestBody UserVO userVO) {
        return userService.update(userVO);
    }

}