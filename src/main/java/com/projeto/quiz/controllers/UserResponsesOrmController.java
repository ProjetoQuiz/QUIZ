package com.projeto.quiz.controllers;

import com.projeto.quiz.services.UserResponsesOrmService;
import com.projeto.quiz.utils.MediaType;
import com.projeto.quiz.vo.UserResponsesOrmGetOrm;
import com.projeto.quiz.vo.UserResponsesOrmVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz/responses/orm")
@Tag(name = "Responses from Orm", description = "Endpoint to manage user orm responses.")
public class UserResponsesOrmController {

    @Autowired
    UserResponsesOrmService userResponsesOrmService;

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Find user orm responses by ID.", description = "Find user orm responses by ID.", tags = {"Responses from Orm"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = UserResponsesOrmGetOrm.class))
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<UserResponsesOrmGetOrm> responses(@PathVariable("id") Long userId) {
        return userResponsesOrmService.response(userId);
    }

    /*

    public List<UserResponsesOrmVO> responses(@PathVariable("id") Long userId) {
        return userResponsesOrmService.response(userId);
    }
     */

    @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
            summary = "Save user orm responses.", description = "Save user orm responses.", tags = {"Responses from Orm"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    array = @ArraySchema(schema  = @Schema(implementation = UserResponsesOrmVO.class))
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<UserResponsesOrmVO> sendResponses(@RequestBody List<UserResponsesOrmVO> userResponses) {
        return userResponsesOrmService.userResponsesOrm(userResponses);
    }
}