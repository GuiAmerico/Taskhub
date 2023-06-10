package com.americo.taskhub.application.ports.out;

import com.americo.taskhub.application.core.domain.Board;

import java.util.List;

public interface FindAllBoardsByWorkspaceOutputPort {
    List<Board> findAllBoardsByWorkspace(String workspaceName);
}
