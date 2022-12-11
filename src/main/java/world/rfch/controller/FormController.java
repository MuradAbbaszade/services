package world.rfch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import world.rfch.controller.dto.FormDto;
import world.rfch.controller.dto.ResponseMessage;
import world.rfch.serviceImpl.EmailSenderServiceImpl;
import world.rfch.serviceImpl.FormServiceImpl;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


@Controller
public class FormController {

    @Autowired
    private FormServiceImpl formService;

    @GetMapping
    public String showPage(){
        return "index.html";
    }
    @PostMapping("form/uploadFile")
    public ResponseEntity<ResponseMessage> sendForm(@RequestParam("file") MultipartFile inputFile,
                                                    @RequestParam("fileName") String inputFileName){

        File file = new File("src/main/resources/files-from-users/"+inputFileName);
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(inputFile.getBytes());
            return ResponseEntity.ok(ResponseMessage.builder().message("OK").build());
        }catch(Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message("An error occur while upload file").build());
        }
    }
    @PostMapping("form/sendForm")
    public ResponseEntity<ResponseMessage> addPortfolio(@RequestBody FormDto formDto){
        try {
            formDto.setFile("src/main/resources/files-from-users/"+formDto.getFile());
            formService.save(formDto.toEntity());
            return ResponseEntity.ok(ResponseMessage.builder().message("Form added").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }
}
