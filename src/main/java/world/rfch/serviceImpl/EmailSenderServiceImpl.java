package world.rfch.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import world.rfch.service.EmailSenderService;

import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmailWithAttachment(String toEmail,
                          String subject,
                          String message,
                          MultipartFile attachment) throws Exception{
        if (attachment.getSize()<1048576 || attachment.getSize()>20971520){
            throw new Exception("File size must be between 1mb and 20mb");
        }
        if (toEmail.isEmpty()||subject.isEmpty()||message.isEmpty()||attachment.isEmpty()){
            throw new Exception("Please fill all fields");
        }
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("muradabbaszade6@gmail.com");
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setText(message);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.addAttachment(attachment.getOriginalFilename(), attachment);
        }catch (Exception e){
            throw new Exception("An error occur while sending email");
        }
        javaMailSender.send(mimeMessage);
    }

    @Override
    public void sendEmail(String toEmail, String subject, String message) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("muradabbaszade6@gmail.com");
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setText(message);
            mimeMessageHelper.setSubject(subject);
        }catch (Exception e){
            throw new Exception("An error occur while sending email");
        }
        javaMailSender.send(mimeMessage);
    }
}
