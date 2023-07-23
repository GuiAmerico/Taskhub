package com.americo.taskhub.adapters.out.repository;

import com.americo.taskhub.adapters.out.repository.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, UUID> {
    @Query("SELECT c FROM CardEntity c WHERE c.responsible.responsibleName=:responsibleName")
    List<CardEntity> findByResponsible(String responsibleName);

    @Query("SELECT c FROM CardEntity c WHERE c.column.id=:columnId")
    List<CardEntity> findByColumn(UUID columnId);

    @Query(value="UPDATE `_card` c SET c.column=:columnId WHERE c.id = :cardId" , nativeQuery = true)
    void moveCard(UUID columnId, UUID cardId);
}
