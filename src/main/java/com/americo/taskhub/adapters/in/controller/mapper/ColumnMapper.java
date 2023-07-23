package com.americo.taskhub.adapters.in.controller.mapper;

import com.americo.taskhub.adapters.in.controller.request.ColumnRequest;
import com.americo.taskhub.adapters.in.controller.response.ColumnResponse;
import com.americo.taskhub.application.core.domain.Column;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ColumnMapper {
    private ModelMapper mapper = new ModelMapper();

    public Column toColumn(ColumnRequest column) {
        return mapper.map(column, Column.class);
    }

    public ColumnResponse toColumnResponse(Column column) {
        return mapper.map(column, ColumnResponse.class);
    }

    public List<Column> toColumnList(List<ColumnRequest> columns) {
        return columns.stream().map(this::toColumn).collect(Collectors.toList());
    }

    public List<ColumnResponse> toColumnResponseList(List<Column> columns) {
        return columns.stream().map(this::toColumnResponse).collect(Collectors.toList());
    }
}
