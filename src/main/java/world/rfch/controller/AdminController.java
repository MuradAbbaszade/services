package world.rfch.controller;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import world.rfch.controller.dto.EmployeeDto;
import world.rfch.controller.dto.PortfolioDto;
import world.rfch.controller.dto.ResponseMessage;
import world.rfch.controller.dto.ServiceDto;
import world.rfch.jpa.entity.EmployeeEntity;
import world.rfch.jpa.entity.FormEntity;
import world.rfch.jpa.entity.PortfolioEntity;
import world.rfch.jpa.entity.ServiceEntity;
import world.rfch.service.EmployeeService;
import world.rfch.service.FormService;
import world.rfch.service.PortfolioService;
import world.rfch.service.ServicesService;
import world.rfch.serviceImpl.EmployeeServiceImpl;
import world.rfch.serviceImpl.PortfolioServiceImpl;
import world.rfch.serviceImpl.ServicesServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.channels.MulticastChannel;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private FormService formService;

    @GetMapping
    public String showPage(){
        return "admin-panel.html";
    }

    @GetMapping("data")
    public String showData(){
        return "data.html";
    }

    @GetMapping("forms")
    public ResponseEntity<List<FormEntity>> getForms(){
        return ResponseEntity.ok(formService.getAll());
    }

    @GetMapping("portfolio/{id}")
    public ResponseEntity<PortfolioEntity> getPortfolio(@PathVariable Long id){
        try {
            return ResponseEntity.ok(portfolioService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("service/{id}")
    public ResponseEntity<ServiceEntity> getService(@PathVariable Long id){
        try {
            return ResponseEntity.ok(servicesService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable Long id){
        try {
            return ResponseEntity.ok(employeeService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("saveEmployee")
    public ResponseEntity<ResponseMessage> saveEmployee(@RequestBody EmployeeDto employeeDto){
        try {
            employeeService.save(employeeDto.toEntity());
            return ResponseEntity.ok(ResponseMessage.builder().message("Employee saved").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }

    @PostMapping("saveService")
    public ResponseEntity<ResponseMessage> saveService(@RequestBody ServiceDto serviceDto){
        try {
            servicesService.save(serviceDto.toEntity());
            return ResponseEntity.ok(ResponseMessage.builder().message("Service saved").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }
    @PostMapping("savePortfolio")
    public ResponseEntity<ResponseMessage> savePortfolio(@RequestBody PortfolioDto portfolioDto){
        try {
            portfolioService.save(portfolioDto.toEntity());
            return ResponseEntity.ok(ResponseMessage.builder().message("Portfolio saved").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }
    @PostMapping("uploadPortfolioImage")
    public ResponseEntity<ResponseMessage> addPortfolioImage(@RequestParam("image")MultipartFile multipartFile,
                                                       @RequestParam("imageName")String name){
        File file = getFile(name);
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
            return ResponseEntity.ok(ResponseMessage.builder().message(file.getPath()).build());
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(ResponseMessage.builder().message("An error occur while upload image").build());
        }
    }

    @PostMapping("deleteEmployee")
    public ResponseEntity<ResponseMessage> deleteEmployee(@RequestBody Long id){
        try {
            employeeService.deleteById(id);
            return ResponseEntity.ok(ResponseMessage.builder().message("Employee deleted").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }
    @PostMapping("deleteService")
    public ResponseEntity<ResponseMessage> deleteService(@RequestBody Long id){
        try {
            servicesService.deleteById(id);
            return ResponseEntity.ok(ResponseMessage.builder().message("Service deleted").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }
    @PostMapping("deletePortfolio")
    public ResponseEntity<ResponseMessage> deletePortfolio(@RequestBody Long id){
        try {
            portfolioService.deleteById(id);
            return ResponseEntity.ok(ResponseMessage.builder().message("Portfolio deleted").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }

    public File getFile(String inputFileName){
        int version = 0;
        String base = "src/main/resources/static/images/portfolio/gallery/";
        String fileName = base+inputFileName;
        File file = new File(fileName);
        while (file.exists()) {
            version++;
            String fileNameBase = fileName.substring(0, fileName.lastIndexOf('.'));
            String extension = fileName.substring(fileName.lastIndexOf('.'));
            file = new File(fileNameBase+"("+ version+")"+extension);
        }
        return file;
    }
}
