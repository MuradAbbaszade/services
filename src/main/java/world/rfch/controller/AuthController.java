package world.rfch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("adminLogin")
    public String showAdminLoginPage(){
        return "login.html";
    }
}
