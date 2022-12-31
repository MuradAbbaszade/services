package world.rfch.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import world.rfch.jpa.entity.EmployeeEntity;
import world.rfch.jpa.entity.ServiceEntity;

import java.nio.charset.StandardCharsets;

@Data
@NoArgsConstructor
public class ServiceDto {
    private Long id;
    private String title;
    private String icon;
    private String about;

    public ServiceEntity toEntity(){
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setId(this.id);
        serviceEntity.setTitle(this.title);
        serviceEntity.setIcon(this.icon);
        serviceEntity.setAbout(this.about);
        return serviceEntity;
    }
}
