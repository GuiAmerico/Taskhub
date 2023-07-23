package com.americo.taskhub.adapters.out.repository;

import com.americo.taskhub.adapters.out.repository.entity.ColumnEntity;
import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.core.domain.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ColumnRepository extends JpaRepository<ColumnEntity, UUID> {
    @Query("SELECT c FROM ColumnEntity c WHERE c.board.id =:boardId")
    List<ColumnEntity> findByBoard(UUID boardId);
}
