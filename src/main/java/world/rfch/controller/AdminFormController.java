package world.rfch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import world.rfch.controller.dto.FormAnswerDto;
import world.rfch.controller.dto.FormDto;
import world.rfch.controller.dto.ResponseMessage;
import world.rfch.jpa.entity.FormEntity;
import world.rfch.service.EmailSenderService;
import world.rfch.service.FormService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin/form")
public class AdminFormController {

    @Autowired
    FormService formService;
    @Autowired
    EmailSenderService emailSenderService;

    @GetMapping
    public String showFormPage(){
        return "admin-form.html";
    }
    @GetMapping("getForms")
    public ResponseEntity<List<FormEntity>> getForms(){
        return ResponseEntity.ok(formService.getAll());
    }
    @PostMapping("deleteForm")
    public ResponseEntity<ResponseMessage> deleteForm(@RequestBody Long id){
        try {
            formService.deleteById(id);
            return ResponseEntity.ok(ResponseMessage.builder().message("Form deleted succesfully").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message("An error occur while delete form").build());
        }
    }
    @PostMapping("answerForm")
    public ResponseEntity<ResponseMessage> answerForm(@RequestBody FormAnswerDto formAnswerDto){
        try {
            emailSenderService.sendEmail(formAnswerDto.getEmail(),formAnswerDto.getTitle(),formAnswerDto.getMessage());;
            return ResponseEntity.ok(ResponseMessage.builder().message("Answer sent succesfully").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message("An error occur while send answer").build());
        }
    }

}
