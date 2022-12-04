package world.rfch.serviceImpl;

import world.rfch.jpa.entity.PortfolioEntity;
import world.rfch.service.PortfolioService;

import java.util.List;

public class PortfolioServiceImpl implements PortfolioService {
    @Override
    public boolean add(PortfolioEntity portfolioEntity) {
        return false;
    }

    @Override
    public List<PortfolioEntity> getAll() {
        return null;
    }

    @Override
    public PortfolioEntity getById(Long id) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean update(PortfolioEntity portfolioEntity) {
        return false;
    }
}
