package com.elifnurtelase.TodoList.dto.responseDTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class TodoResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
}
