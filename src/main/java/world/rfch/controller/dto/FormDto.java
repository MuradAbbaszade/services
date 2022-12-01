package world.rfch.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@ToString
@RequiredArgsConstructor
public class FormDto {
    public String name;
    public String email;
    public String message;
    public MultipartFile file;
}
