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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public FormDto(String name, String email, String message, MultipartFile file) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.file = file;
    }

    public FormDto() {
    }
}
