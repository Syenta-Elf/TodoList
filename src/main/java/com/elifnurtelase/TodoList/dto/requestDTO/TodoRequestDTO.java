package com.elifnurtelase.TodoList.dto.requestDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TodoRequestDTO {
    private String title;
    private String description;
}
