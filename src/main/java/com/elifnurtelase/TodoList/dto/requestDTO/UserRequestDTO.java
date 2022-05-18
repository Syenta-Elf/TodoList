package com.elifnurtelase.TodoList.dto.requestDTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserRequestDTO {
    private String firstName;
    private String lastName;
}
