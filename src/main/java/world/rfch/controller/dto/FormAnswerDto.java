package world.rfch.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FormAnswerDto {
    private String email;
    private String title;
    private String message;
}
