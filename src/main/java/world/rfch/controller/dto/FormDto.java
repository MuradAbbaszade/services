package world.rfch.controller.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import world.rfch.jpa.entity.FormEntity;

import java.io.File;

@Data
@NoArgsConstructor
public class FormDto {
    private String name;
    private String email;
    private String message;
    private String file;

    public FormEntity toEntity(){
        FormEntity formEntity = new FormEntity();
        formEntity.setName(this.name);
        formEntity.setEmail(this.email);
        formEntity.setMessage(this.message);
        formEntity.setFile(this.file);
        return formEntity;
    }
}
