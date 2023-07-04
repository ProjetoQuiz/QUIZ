package com.projeto.quiz.controllers;

import com.projeto.quiz.services.GenerateQuizService;
import com.projeto.quiz.vo.QuestionOrmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class GenerateQuizController {
    @Autowired
    GenerateQuizService generateFiveQuiz;

    @GetMapping("/questions")
    public List<QuestionOrmVO> getFiveQuiz() {
        return generateFiveQuiz.generateFiveQuizQuestions();
    }
}
