package world.rfch.jpa.entity;

import lombok.Data;
import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="user")
public class UserEntity extends AbstractEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roleEntityList;

    @OneToMany(mappedBy="referringUserId")
    private List<UserEntity> referencedUserEntityList;

    @ManyToOne
    @JoinColumn(name="referring_user_id")
    private UserEntity referringUserId;
}
