package world.rfch.service;

import org.springframework.web.multipart.MultipartFile;

public interface EmailSenderService {
    void sendEmail(String toEmail, String subject, String message, MultipartFile attachment) throws Exception;
}
