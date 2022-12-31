package world.rfch.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import world.rfch.jpa.entity.EmployeeEntity;

@Data
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String name;
    private String surname;
    private String position;
    private String about;

    public EmployeeEntity toEntity(){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(this.id);
        employeeEntity.setName(this.name);
        employeeEntity.setSurname(this.surname);
        employeeEntity.setPosition(this.position);
        employeeEntity.setAbout(this.about);
        return employeeEntity;
    }
}
