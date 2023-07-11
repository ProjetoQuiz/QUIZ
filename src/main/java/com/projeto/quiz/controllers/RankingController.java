package com.projeto.quiz.controllers;

import com.projeto.quiz.services.RankingService;
import com.projeto.quiz.utils.MediaType;
import com.projeto.quiz.vo.UserRankingOrmVO;
import com.projeto.quiz.vo.UserResultOrmGetVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("quiz/ranking")
@Tag(name = "Ranking", description = "Endpoint to manage user rankings.")
public class RankingController {

    @Autowired
    RankingService rankingService;

    @GetMapping(value = "/orm", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Ranking of Object Relational Mapper (ORM) results.", description = "Ranking of Object Relational Mapper (ORM) results.", tags = {"Ranking"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation =UserRankingOrmVO.class))
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<UserRankingOrmVO> rankingUsers(){
        return rankingService.rankingOrmVO();
    }
}
