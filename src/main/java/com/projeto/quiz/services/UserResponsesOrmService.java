package com.projeto.quiz.services;

import com.projeto.quiz.mapper.DozerMapper;
import com.projeto.quiz.models.QuestionOrm;
import com.projeto.quiz.models.UserResponsesOrm;
import com.projeto.quiz.repositories.QuestionOrmRepository;
import com.projeto.quiz.repositories.UserResponsesOrmRepository;
import com.projeto.quiz.vo.UserResponsesOrmGetOrm;
import com.projeto.quiz.vo.UserResponsesOrmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserResponsesOrmService {
    @Autowired
    UserResponsesOrmRepository userResponsesOrmRepository;

    @Autowired
    QuestionOrmRepository questionOrmRepository;

    /*
    public List<UserResponsesOrmVO> response(Long userId) {
        List<UserResponsesOrm> userResponsesList = userResponsesOrmRepository.findByUserId(userId);
        List<UserResponsesOrmVO> userResponsesVOList = DozerMapper.parseListObject(userResponsesList, UserResponsesOrmVO.class);
        return userResponsesVOList;
    }


     */

    public List<UserResponsesOrmGetOrm> response(Long userId) {
        List<UserResponsesOrm> userResponsesList = userResponsesOrmRepository.findByUserId(userId);
        List<UserResponsesOrmGetOrm> userResponsesVOList = DozerMapper.parseListObject(userResponsesList, UserResponsesOrmGetOrm.class);
        return userResponsesVOList;
    }


    public List<UserResponsesOrmVO> userResponsesOrm(List<UserResponsesOrmVO> userResponsesOrmVO){
        var userResponses = DozerMapper.parseListObject(userResponsesOrmVO, UserResponsesOrm.class);
        List<UserResponsesOrm> responseList = new ArrayList<>();
        for (var item: userResponses) {
            QuestionOrm questionOrm = questionOrmRepository.findById(item.getQuestionOrm().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Question not found"));
            if(item.getUserResponse().equalsIgnoreCase(questionOrm.getResponse())){
                item.setCorrect("true");
            } else {
                item.setCorrect("false");
            }
            responseList.add(userResponsesOrmRepository.save(item));
        }
        return DozerMapper.parseListObject(responseList, UserResponsesOrmVO.class);
    }

}


