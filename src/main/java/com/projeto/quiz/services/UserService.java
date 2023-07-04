package com.projeto.quiz.services;

import com.projeto.quiz.mapper.DozerMapper;
import com.projeto.quiz.models.User;
import com.projeto.quiz.repositories.UserRepository;
import com.projeto.quiz.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String delete(Long id) {
        var dbUser = userRepository.findById(id);
        if(dbUser.isPresent()) {
            userRepository.deleteById(id);
            return "User with id " + id + " has been deleted!";
        }else
            return "ID " + id + " not found!";
    }
    public UserVO findById(Long id){
        Optional<User> userDb = userRepository.findById(id);
        return DozerMapper.parseObject(userDb.get(),UserVO.class);

    }

    public UserVO save(UserVO userVO) {
        User user = DozerMapper.parseObject(userVO, User.class);
        var userDb = userRepository.save(user);
        userVO = DozerMapper.parseObject(userDb, UserVO.class);
        return userVO;

        //var user = userRepository.save(DozerMapper.parseObject(userVO, User.class));
        //return DozerMapper.parseObject(user, UserVO.class);
    }

    public UserVO update(UserVO userVO) {
        Optional<User> dbUser = userRepository.findById(userVO.getId());
        if(dbUser.isPresent()) {
            User user = DozerMapper.parseObject(userVO, User.class);
            user = userRepository.save(user);
            return DozerMapper.parseObject(user, UserVO.class);
        }
        return null;
    }
}

