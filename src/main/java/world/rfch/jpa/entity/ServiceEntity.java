package world.rfch.jpa.entity;

import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.Column;

public class ServiceEntity extends AbstractEntity {
    @Column(name = "title")
    private String title;
    @Column(name = "icon")
    private String icon;
    @Column(name = "about")
    private String about;
}
