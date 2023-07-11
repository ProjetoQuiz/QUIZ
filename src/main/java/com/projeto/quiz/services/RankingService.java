package com.projeto.quiz.services;

import com.projeto.quiz.mapper.DozerMapper;
import com.projeto.quiz.models.UserResultOrm;
import com.projeto.quiz.repositories.UserResultOrmRepository;
import com.projeto.quiz.vo.UserRankingOrmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    @Autowired
    UserResultOrmRepository userResultOrmRepository;

    public List<UserRankingOrmVO> rankingOrmVO(){

        List <UserResultOrm> resultOrm = userResultOrmRepository.findAll(Sort.by(Sort.Order.by("totalCorrect")).descending());

        List<UserRankingOrmVO> userRanking = DozerMapper.parseListObject(resultOrm,UserRankingOrmVO.class);

        return userRanking;
    }
}
