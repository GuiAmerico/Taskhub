package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.ports.in.FindAllBoardsByWorkspaceInputPort;
import com.americo.taskhub.application.ports.in.FindAllBoardsInputPort;
import com.americo.taskhub.application.ports.out.FindAllBoardsByWorkspaceOutputPort;
import com.americo.taskhub.application.ports.out.FindAllBoardsOutputPort;

import java.util.List;

public class FindAllBoardsByWorkspaceUseCase implements FindAllBoardsByWorkspaceInputPort {
    private final FindAllBoardsByWorkspaceOutputPort findAllBoardsByWorkspaceOutputPort;

    public FindAllBoardsByWorkspaceUseCase(FindAllBoardsByWorkspaceOutputPort findAllBoardsByWorkspaceOutputPort) {
        this.findAllBoardsByWorkspaceOutputPort = findAllBoardsByWorkspaceOutputPort;
    }

    @Override
    public List<Board> findAllBoardsByWorkspace(String workspaceName) {
        return findAllBoardsByWorkspace(workspaceName);
    }
}
