package com.projeto.quiz.services;

import com.projeto.quiz.exceptions.ResourceNotFoundException;
import com.projeto.quiz.mapper.DozerMapper;
import com.projeto.quiz.models.User;
import com.projeto.quiz.models.UserResponsesOrm;
import com.projeto.quiz.models.UserResultOrm;
import com.projeto.quiz.repositories.UserRepository;
import com.projeto.quiz.repositories.UserResponsesOrmRepository;
import com.projeto.quiz.repositories.UserResultOrmRepository;
import com.projeto.quiz.vo.UserRankingOrmVO;
import com.projeto.quiz.vo.UserResultOrmGetVO;
import com.projeto.quiz.vo.UserResultOrmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserResultOrmService {
    @Autowired
    UserResponsesOrmRepository userResponsesOrmRepository;
    @Autowired
    UserResultOrmRepository userResultOrmRepository;
    @Autowired
    UserRepository userRepository;

    public UserResultOrmVO saveResultOrm(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("No records found for this user"));
        List<UserResponsesOrm> userResponses = userResponsesOrmRepository.findByUserId(userId);

        int totalCorrect = 0;
        int totalWrong = 0;

        for (UserResponsesOrm response : userResponses) {
            if ("true".equals(response.getCorrect())) {
                totalCorrect++;
            } else {
                totalWrong++;
            }
        }
        var newResult = new UserResultOrm();
        newResult.setUserName(user.getUserName());
        newResult.setTotalCorrect(totalCorrect);
        newResult.setTotalWrong(totalWrong);
        newResult.setUser(user);
        user.setUserResultOrm(newResult);
        newResult = userResultOrmRepository.save(newResult);
        return DozerMapper.parseObject(newResult, UserResultOrmVO.class);
    }

    public UserResultOrmGetVO getUserResult(Long userId) {
        Optional<UserResultOrm> userResult = Optional.ofNullable(userResultOrmRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("No records found for this user")));;
        return DozerMapper.parseObject(userResult.get(),UserResultOrmGetVO.class);
    }
}

