package com.elifnurtelase.TodoList.dto.responseDTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserResponseDTO {
    private Long id;
    private String firstName;
    private List<TodoResponseDTO> todoList;
}
