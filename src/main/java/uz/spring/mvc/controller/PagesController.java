package uz.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PagesController {
    @GetMapping()
    public String first(){
        return "task/first";
    }
    @GetMapping("/second")
    public String second(){
        return "task/second";
    }
    @GetMapping("/third")
    public String third(){
        return "task/third";
    }
    @GetMapping("/four")
    public String four(){
        return "task/four";
    }
    @GetMapping("/five")
    public String five(){
        return "task/five";
    }
    @GetMapping("/six")
    public String six(){
        return "task/six";
    }
}
