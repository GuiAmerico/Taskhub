package com.americo.taskhub.adapters.out.repository.mapper;

import com.americo.taskhub.adapters.out.repository.entity.BoardEntity;
import com.americo.taskhub.application.core.domain.Board;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BoardEntityMapper {
    private ModelMapper mapper = new ModelMapper();

    public Board toBoard(BoardEntity board) {
        return mapper.map(board, Board.class);
    }

    public BoardEntity toBoardEntity(Board board) {
        return mapper.map(board, BoardEntity.class);
    }

    public List<Board> toBoardList(List<BoardEntity> boards) {
        return boards.stream().map(this::toBoard).collect(Collectors.toList());
    }

    public List<BoardEntity> toBoardEntityList(List<Board> boards) {
        return boards.stream().map(this::toBoardEntity).collect(Collectors.toList());
    }

}
