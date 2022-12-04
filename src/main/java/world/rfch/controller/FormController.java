package world.rfch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import world.rfch.controller.dto.FormDto;
import world.rfch.serviceImpl.EmailSenderServiceImpl;


@Controller
public class FormController {

    @Autowired
    private EmailSenderServiceImpl emailSenderService;
    @GetMapping
    public String showPage(){
        return "index.html";
    }
    @PostMapping
    public ResponseEntity<String> sendForm(@ModelAttribute FormDto formDto){
        System.out.println(formDto.getEmail());
        try {
            emailSenderService.sendEmail(formDto.getEmail(),formDto.getName(),formDto.getMessage(),formDto.getFile());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok("Mail sent succesfully");
    }
}
