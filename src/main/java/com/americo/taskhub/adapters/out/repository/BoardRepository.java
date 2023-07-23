package com.americo.taskhub.adapters.out.repository;

import com.americo.taskhub.adapters.out.repository.entity.BoardEntity;
import com.americo.taskhub.application.core.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, UUID> {
    List<BoardEntity> findByWorkspace(String workspace);


}

/*
*
* private UUID id;
    private String title;
    private String workspace;
    private Visibility visibility;
    private LocalDateTime created;
    private Responsible responsible;
    private List<Column> columns = new ArrayList<>();
*
* */
