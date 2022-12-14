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
import world.rfch.service.EmployeeService;
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

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private PortfolioService portfolioService;

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
            portfolioService.save(portfolioDto.toEntity());
            return ResponseEntity.ok(ResponseMessage.builder().message("Portfolio added").build());
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
