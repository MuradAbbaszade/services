package world.rfch.jpa.entity;

import lombok.Data;
import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="service")
public class ServiceEntity extends AbstractEntity {
    @Column(name = "title")
    private String title;
    @Column(name = "icon")
    private String icon;
    @Column(name = "about")
    private String about;
}
