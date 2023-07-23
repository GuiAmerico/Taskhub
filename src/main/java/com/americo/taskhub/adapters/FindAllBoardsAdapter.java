package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.BoardRepository;
import com.americo.taskhub.adapters.out.repository.mapper.BoardEntityMapper;
import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.ports.in.FindAllBoardsInputPort;
import com.americo.taskhub.application.ports.out.FindAllBoardsOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@RequiredArgsConstructor
@Component
public class FindAllBoardsAdapter implements FindAllBoardsOutputPort {
    private final BoardRepository boardRepository;
    private final BoardEntityMapper mapper = new BoardEntityMapper();

    @AuditLog(action = "Find All Boards")
    @Override
    public List<Board> findAllBoards() {
        return mapper.toBoardList(boardRepository.findAll());
    }
}
