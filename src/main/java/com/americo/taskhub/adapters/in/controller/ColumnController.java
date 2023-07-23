package com.americo.taskhub.adapters.in.controller;

import com.americo.taskhub.adapters.in.controller.mapper.ColumnMapper;
import com.americo.taskhub.adapters.in.controller.request.ColumnRequest;
import com.americo.taskhub.adapters.in.controller.response.ColumnResponse;
import com.americo.taskhub.application.core.domain.Column;
import com.americo.taskhub.application.ports.in.CreateColumnInputPort;
import com.americo.taskhub.application.ports.in.DeleteColumnByIdInputPort;
import com.americo.taskhub.application.ports.in.FindAllColumnsOfBoardInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RequestMapping("/v1/columns")
@RestController
public class ColumnController {

    private final CreateColumnInputPort createColumnInputPort;
    private final DeleteColumnByIdInputPort deleteColumnByIdInputPort;
    private final FindAllColumnsOfBoardInputPort findAllColumnsOfBoardInputPort;
    private final ColumnMapper mapper = new ColumnMapper();

    @PostMapping
    public ResponseEntity<ColumnResponse> createColumn(@RequestBody @Valid ColumnRequest columnRequest){
        Column column = mapper.toColumn(columnRequest);
        ColumnResponse columnResponse = mapper.toColumnResponse(createColumnInputPort.createColumn(column));
        return ResponseEntity.status(CREATED).body(columnResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColumnById(@PathVariable UUID id){
        deleteColumnByIdInputPort.deleteColumn(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<List<ColumnResponse>> findAllColumnsByBoard(@PathVariable UUID boardId){
        List<Column> columns = findAllColumnsOfBoardInputPort.findAllColumnsOfBoard(boardId);
        List<ColumnResponse> columnResponses = mapper.toColumnResponseList(columns);
        return ResponseEntity.status(OK).body(columnResponses);
    }

}
