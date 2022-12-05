package world.rfch.controller.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
@ToString
@RequiredArgsConstructor
public class FormDto {
    public String name;
    public String email;
    public String message;
    public MultipartFile file;
}
