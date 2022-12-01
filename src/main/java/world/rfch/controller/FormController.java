package world.rfch.controller;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.net.smtp.SmtpProtocolException;
import world.rfch.service.EmailSenderService;

import javax.mail.MessagingException;


@Controller
public class FormController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("form")
    public ResponseEntity<String> sendForm(@RequestParam("file")MultipartFile file,
                                         @RequestParam("name")String name,
                                         @RequestParam("email")String email,
                                         @RequestParam("message")String message){
        try {
            emailSenderService.sendEmail(email,name,message,file);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok("Mail sent succesfully");
    }
}
