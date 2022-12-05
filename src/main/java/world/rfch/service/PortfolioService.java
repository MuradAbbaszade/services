package world.rfch.service;

import world.rfch.jpa.entity.PortfolioEntity;

import java.util.List;

public interface PortfolioService {
    boolean save(PortfolioEntity portfolioEntity) throws Exception;
    List<PortfolioEntity> getAll();
    PortfolioEntity getById(Long id) throws Exception;
    boolean deleteById(Long id) throws Exception;
    List<PortfolioEntity> deleteAll();
}
