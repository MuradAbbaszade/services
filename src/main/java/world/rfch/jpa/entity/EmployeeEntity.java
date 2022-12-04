package world.rfch.jpa.entity;

import lombok.Data;
import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="employee")
public class EmployeeEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="position")
    private String position;
    @Column(name = "about")
    private String about;
}
