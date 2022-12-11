package world.rfch.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.PortfolioEntity;
import world.rfch.jpa.repository.PortfolioJpaRepository;
import world.rfch.service.PortfolioService;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioJpaRepository portfolioJpaRepository;

    @Override
    public boolean save(PortfolioEntity portfolioEntity) throws Exception {
        try{
            portfolioJpaRepository.save(portfolioEntity);
            return true;
        }catch (Exception e){
            throw new Exception("An error occur while save portfolio");
        }
    }

    @Override
    public List<PortfolioEntity> getAll() {
        return portfolioJpaRepository.findAll();
    }

    @Override
    public PortfolioEntity getById(Long id) throws Exception {
        return portfolioJpaRepository.findById(id)
                .orElseThrow(() -> new Exception("Portfolio not found"));
    }

    @Override
    public boolean deleteById(Long id) throws Exception {
        try{
            portfolioJpaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            throw new Exception("An error occur while delete portfolio");
        }
    }

    @Override
    public List<PortfolioEntity> deleteAll() {
        List<PortfolioEntity> portfolioEntities = getAll();
        portfolioJpaRepository.deleteAll();
        return portfolioEntities;
    }
}
