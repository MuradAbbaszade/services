package world.rfch.jpa.entity;

import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.Column;

public class PortfolioEntity extends AbstractEntity {
    @Column(name = "sub_title")
    private String subTitle;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "link")
    private String link;
}
