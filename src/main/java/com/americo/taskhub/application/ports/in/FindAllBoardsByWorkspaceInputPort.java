package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Board;

import java.util.List;

public interface FindAllBoardsByWorkspaceInputPort {
    List<Board> findAllBoardsByWorkspace(String workspaceName);
}
