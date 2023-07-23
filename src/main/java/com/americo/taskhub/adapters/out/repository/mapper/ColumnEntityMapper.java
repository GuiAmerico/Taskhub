package com.americo.taskhub.adapters.out.repository.mapper;

import com.americo.taskhub.adapters.out.repository.entity.ColumnEntity;
import com.americo.taskhub.application.core.domain.Column;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ColumnEntityMapper {
    private ModelMapper mapper = new ModelMapper();

    public Column toColumn(ColumnEntity column) {
        return mapper.map(column, Column.class);
    }

    public ColumnEntity toColumnEntity(Column column) {
        return mapper.map(column, ColumnEntity.class);
    }

    public List<Column> toColumnList(List<ColumnEntity> columns) {
        return columns.stream().map(this::toColumn).collect(Collectors.toList());
    }

    public List<ColumnEntity> toColumnEntityList(List<Column> columns) {
        return columns.stream().map(this::toColumnEntity).collect(Collectors.toList());
    }

}
