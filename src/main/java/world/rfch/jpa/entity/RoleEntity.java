package world.rfch.jpa.entity;

import lombok.Data;
import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class RoleEntity extends AbstractEntity {
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roleEntityList")
    private List<UserEntity> userEntityList;
}
