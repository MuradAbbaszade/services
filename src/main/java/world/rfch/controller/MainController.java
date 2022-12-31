package world.rfch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import world.rfch.jpa.entity.EmployeeEntity;
import world.rfch.jpa.entity.PortfolioEntity;
import world.rfch.jpa.entity.ServiceEntity;
import world.rfch.service.EmployeeService;
import world.rfch.service.PortfolioService;
import world.rfch.service.ServicesService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public String showMainPage(){
        return "index.html";
    }

    @GetMapping("portfolios")
    public ResponseEntity<List<PortfolioEntity>> getPortfolios(){
        return ResponseEntity.ok(portfolioService.getAll());
    }

    @GetMapping("employees")
    public ResponseEntity<List<EmployeeEntity>> getEmployees(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("services")
    public ResponseEntity<List<ServiceEntity>> getServices(){
        return ResponseEntity.ok(servicesService.getAll());
    }
}
