package com.americo.taskhub.adapters.in.controller.mapper;

import com.americo.taskhub.adapters.in.controller.request.BoardRequest;
import com.americo.taskhub.adapters.in.controller.response.BoardResponse;
import com.americo.taskhub.application.core.domain.Board;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BoardMapper {
    private ModelMapper mapper = new ModelMapper();

    public Board toBoard(BoardRequest board) {
        return mapper.map(board, Board.class);
    }

    public BoardResponse toBoardResponse(Board board) {
        return mapper.map(board, BoardResponse.class);
    }

    public List<Board> toBoardList(List<BoardRequest> boards) {
        return boards.stream().map(this::toBoard).collect(Collectors.toList());
    }

    public List<BoardResponse> toBoardResponseList(List<Board> boards) {
        return boards.stream().map(this::toBoardResponse).collect(Collectors.toList());
    }
}
