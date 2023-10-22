package uz.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam (value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, Model model){
        System.out.println("Hello "+ name+surname);
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        return "first/hello";
    }

}
