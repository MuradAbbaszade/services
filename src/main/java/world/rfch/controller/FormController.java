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
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormServiceImpl formService;

    @PostMapping("uploadFile")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile inputFile,
                                                    @RequestParam("fileName") String inputFileName){

        File file = getFile(inputFileName);
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(inputFile.getBytes());
            return ResponseEntity.ok(ResponseMessage.builder().message(file.getPath()).build());
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(ResponseMessage.builder().message("An error occur while upload file").build());
        }
    }
    @PostMapping("sendForm")
    public ResponseEntity<ResponseMessage> addForm(@RequestBody FormDto formDto){
        try {
            formService.save(formDto.toEntity());
            return ResponseEntity.ok(ResponseMessage.builder().message("Form succesfully sent").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseMessage.builder().message(e.getMessage()).build());
        }
    }

    public File getFile(String inputFileName){
        int version = 0;
        String base = "src/main/resources/files-from-users/";
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
