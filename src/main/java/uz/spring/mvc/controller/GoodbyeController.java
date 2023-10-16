package uz.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodbyeController {
    @GetMapping("/goodbye")
    public String sayGoodbye(){
        return "first/goodbye";
    }
}
