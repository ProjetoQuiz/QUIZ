package com.projeto.quiz.controllers;

import com.projeto.quiz.services.UserResultOrmService;
import com.projeto.quiz.utils.MediaType;
import com.projeto.quiz.vo.UserResultOrmGetVO;
import com.projeto.quiz.vo.UserResultOrmVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz/result/orm")
@Tag(name = "User orm result", description = "Endpoint to manage user orm result.")
public class UserResultOrmController {

    @Autowired
    UserResultOrmService userResultOrmService;

    @PostMapping(value = "/{id}")
    @Operation(
            summary = "Create a user orm result.", description = "Create a user orm result", tags = {"User orm result"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = UserResultOrmVO .class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public UserResultOrmVO save(@PathVariable("id") Long userId){
        return userResultOrmService.saveResultOrm(userId);
    }


    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Find user result by ID.", description = "Find user result by ID.", tags = {"User orm result"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = UserResultOrmGetVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public UserResultOrmGetVO getUserResult(@PathVariable("id") Long userId) {
        return userResultOrmService.getUserResult(userId);
    }
}
