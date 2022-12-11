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
import world.rfch.serviceImpl.EmployeeServiceImpl;
import world.rfch.serviceImpl.PortfolioServiceImpl;
import world.rfch.serviceImpl.ServicesServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.channels.MulticastChannel;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private ServicesServiceImpl servicesService;
    @Autowired
    private PortfolioServiceImpl portfolioService;

    @GetMapping("/form")
    public String showFormPage(){
        return "admin-form.html";
    }
    @GetMapping
    public String showPage(){
        return "admin-panel.html";
    }
    @PostMapping("addEmployee")
    public ResponseEntity<ResponseMessage> addEmployee(@RequestBody EmployeeDto employeeDto){
        try {
            employeeService.save(employeeDto.toEntity());
            return ResponseEntity.ok(ResponseMessage.builder().message("Employee added").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }
    @PostMapping("addService")
    public ResponseEntity<ResponseMessage> addService(@RequestBody ServiceDto serviceDto){
        try {
            servicesService.save(serviceDto.toEntity());
            return ResponseEntity.ok(ResponseMessage.builder().message("Service added").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }
    @PostMapping("addPortfolio")
    public ResponseEntity<ResponseMessage> addPortfolio(@RequestBody PortfolioDto portfolioDto){
        try {
            portfolioDto.setImage("src/main/resources/static/images/portfolio/gallery/"+portfolioDto.getImage());
            portfolioService.save(portfolioDto.toEntity());
            return ResponseEntity.ok(ResponseMessage.builder().message("Portfolio added").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }
    @PostMapping("uploadPortfolioImage")
    public ResponseEntity<ResponseMessage> addPortfolioImage(@RequestParam("image")MultipartFile multipartFile,
                                                       @RequestParam("imageName")String name){
        File file = new File("src/main/resources/static/images/portfolio/gallery/"+name);
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
            return ResponseEntity.ok(ResponseMessage.builder().message("OK").build());
        }catch(Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message("An error occur while upload image").build());
        }
    }
}
