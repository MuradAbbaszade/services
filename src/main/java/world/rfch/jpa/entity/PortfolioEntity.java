package world.rfch.jpa.entity;

import lombok.Data;
import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="portfolio")
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
