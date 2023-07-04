package com.projeto.quiz.services;

import com.projeto.quiz.mapper.DozerMapper;
import com.projeto.quiz.models.User;
import com.projeto.quiz.models.UserResponsesOrm;
import com.projeto.quiz.models.UserResultOrm;
import com.projeto.quiz.repositories.UserRepository;
import com.projeto.quiz.repositories.UserResponsesOrmRepository;
import com.projeto.quiz.repositories.UserResultOrmRepository;
import com.projeto.quiz.vo.UserResultOrmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserResultOrmService {
    @Autowired
    UserResponsesOrmRepository userResponsesOrmRepository;
    @Autowired
    UserResultOrmRepository userResultOrmRepository;
    @Autowired
    UserRepository userRepository;

    public UserResultOrmVO saveResultOrm(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Question not found"));
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
}

/*

 UserResultOrmVO resultOrmVO = dozerMapper.parseObject(new UserResultOrmVO(userName, totalCorrect, totalWrong, user), UserResultOrmVO.class);

        // Salvar o objeto mapeado no banco de dados usando o UserResultOrmRepository
        UserResultOrm resultOrm = dozerMapper.parseObject(resultOrmVO, UserResultOrm.class);
        userResultOrmRepository.save(resultOrm);

        var email = repository.save(DozerMapper.parseObject(emailVO, Email.class));
            return DozerMapper.parseObject(email, EmailVO.class);

 */