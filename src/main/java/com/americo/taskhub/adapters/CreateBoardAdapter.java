package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.BoardRepository;
import com.americo.taskhub.adapters.out.repository.entity.BoardEntity;
import com.americo.taskhub.adapters.out.repository.mapper.BoardEntityMapper;
import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.ports.out.CreateBoardOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateBoardAdapter implements CreateBoardOutputPort {

  private final BoardRepository boardRepository;
  private BoardEntityMapper mapper = new BoardEntityMapper();


  @AuditLog(action = "Create Board")
  @Override
  public Board create(Board board) {
    BoardEntity boardEntity = mapper.toBoardEntity(board);
    boardEntity.setCreated(LocalDateTime.now());
    System.out.println(board);
    boardEntity = boardRepository.save(boardEntity);
    return mapper.toBoard(boardEntity);
  }
}
