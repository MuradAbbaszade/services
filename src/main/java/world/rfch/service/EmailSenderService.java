package world.rfch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail,
                          String subject,
                          String message,
                          MultipartFile attachment) throws Exception {
        if (toEmail.isEmpty()||subject.isEmpty()||message.isEmpty()||attachment.isEmpty()){
            throw new Exception();
        }
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        mimeMessageHelper.setFrom("muradabbaszade6@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(message);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.addAttachment(attachment.getOriginalFilename(),attachment);

        javaMailSender.send(mimeMessage);
    }
}
