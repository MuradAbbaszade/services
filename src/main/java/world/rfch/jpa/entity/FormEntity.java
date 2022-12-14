package world.rfch.jpa.entity;

import lombok.Data;
import world.rfch.controller.dto.FormDto;
import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="form")
public class FormEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="message")
    private String message;
    @Column(name = "file")
    private String file;

    public FormDto toDto(){
        FormDto formDto =  new FormDto();
        formDto.setName(this.name);
        formDto.setEmail(this.email);
        formDto.setMessage(this.message);
        formDto.setFile(this.file);
        return formDto;
    }
}
