package world.rfch.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import world.rfch.jpa.entity.EmployeeEntity;
import world.rfch.jpa.entity.PortfolioEntity;

@Data
@NoArgsConstructor
public class PortfolioDto {
    private String title;
    private String subTitle;
    private String image;
    private String link;

    public PortfolioEntity toEntity(){
        PortfolioEntity portfolioEntity = new PortfolioEntity();
        portfolioEntity.setTitle(this.title);
        portfolioEntity.setSubTitle(this.subTitle);
        portfolioEntity.setImage(this.image);
        portfolioEntity.setLink(this.link);
        return portfolioEntity;
    }
}
