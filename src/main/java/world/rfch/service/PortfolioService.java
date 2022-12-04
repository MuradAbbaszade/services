package world.rfch.service;

import world.rfch.jpa.entity.EmployeeEntity;
import world.rfch.jpa.entity.PortfolioEntity;

import java.util.List;

public interface PortfolioService {
    boolean add(PortfolioEntity portfolioEntity);
    List<PortfolioEntity> getAll();
    PortfolioEntity getById(Long id);
    boolean deleteById(Long id);
    boolean update(PortfolioEntity portfolioEntity);
}
