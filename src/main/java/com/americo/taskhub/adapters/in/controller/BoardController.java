package com.americo.taskhub.adapters.in.controller;

import com.americo.taskhub.adapters.in.controller.mapper.BoardMapper;
import com.americo.taskhub.adapters.in.controller.request.BoardRequest;
import com.americo.taskhub.adapters.in.controller.response.BoardResponse;
import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.ports.in.CreateBoardInputPort;
import com.americo.taskhub.application.ports.in.FindAllBoardsByWorkspaceInputPort;
import com.americo.taskhub.application.ports.in.FindAllBoardsInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RequestMapping("/v1/boards")
@RestController
public class BoardController {

    private final CreateBoardInputPort createBoardInputPort;
    private final FindAllBoardsInputPort findAllBoardsInputPort;
    private final FindAllBoardsByWorkspaceInputPort findAllBoardsByWorkspaceInputPort;
    private BoardMapper mapper = new BoardMapper();

    @PostMapping
    public ResponseEntity<BoardResponse> createBoard(@RequestBody @Valid BoardRequest boardRequest) {
        Board board = mapper.toBoard(boardRequest);
        BoardResponse boardResponse = mapper.toBoardResponse(createBoardInputPort.createBoard(board));
        return ResponseEntity.status(CREATED).body(boardResponse);
    }

    @GetMapping("/{workspaceName}")
    public ResponseEntity<List<BoardResponse>> findAllBoardByWorkspace(@PathVariable String workspaceName) {
        List<BoardResponse> boardResponses = mapper
                .toBoardResponseList(findAllBoardsByWorkspaceInputPort.findAllBoardsByWorkspace(workspaceName));
        return ResponseEntity.status(OK).body(boardResponses);
    }
    @GetMapping
    public ResponseEntity<List<BoardResponse>> findAllBoard() {
        List<BoardResponse> boardResponses = mapper
                .toBoardResponseList(findAllBoardsInputPort.findAllBoards());
        return ResponseEntity.status(OK).body(boardResponses);
    }
}
