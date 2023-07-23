package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.in.controller.mapper.BoardMapper;
import com.americo.taskhub.adapters.out.repository.BoardRepository;
import com.americo.taskhub.adapters.out.repository.entity.BoardEntity;
import com.americo.taskhub.adapters.out.repository.mapper.BoardEntityMapper;
import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.ports.out.FindAllBoardsByWorkspaceOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class FindAllBoardsByWorkspaceAdapter implements FindAllBoardsByWorkspaceOutputPort {
    private final BoardRepository boardRepository;
    private final BoardEntityMapper mapper = new BoardEntityMapper();

    @AuditLog(action = "Find All Boards by Workspace")
    @Override
    public List<Board> findAllBoardsByWorkspace(String workspaceName) {
        List<BoardEntity> boardEntities = boardRepository.findByWorkspace(workspaceName);
        return mapper.toBoardList(boardEntities);
    }
}
