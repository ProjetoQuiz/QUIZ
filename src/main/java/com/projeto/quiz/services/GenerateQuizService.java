package com.projeto.quiz.services;

import com.projeto.quiz.mapper.DozerMapper;
import com.projeto.quiz.models.QuestionOrm;
import com.projeto.quiz.repositories.QuestionOrmRepository;
import com.projeto.quiz.vo.QuestionOrmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GenerateQuizService {
    @Autowired
    QuestionOrmRepository questionOrmRepository;

    public List<QuestionOrmVO> generateFiveQuizQuestionsOrm() {
        List<QuestionOrm> allQuestions = questionOrmRepository.findAll();
        List<QuestionOrm> selectedQuestions = new ArrayList<>();

        Random random = new Random();
        for(int i=0; i<5; i++) {
            int rand = random.nextInt(allQuestions.size());
            selectedQuestions.add(allQuestions.get(rand));
            allQuestions.remove(rand);
        }
        return DozerMapper.parseListObject(selectedQuestions,QuestionOrmVO.class);
    }
}
