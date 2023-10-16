package uz.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {
    @GetMapping("/first")
    public String first(){
        return "task/first";
    }
    @RequestMapping("/second")
    public String second(){
        return "task/second";
    }
    @RequestMapping("/third")
    public String third(){
        return "task/third";
    }
    @RequestMapping("/four")
    public String four(){
        return "task/four";
    }
    @RequestMapping("/five")
    public String five(){
        return "task/five";
    }
    @RequestMapping("/six")
    public String six(){
        return "task/six";
    }
}
