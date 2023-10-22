package uz.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String  calculator (@RequestParam(value = "a", required = false)int a,
                               @RequestParam(value = "b", required = false) int b,
                               @RequestParam(value = "action",required = false)
                                   int action, Model model){
        int result= 0;
        if (action==1){
            result = a + b;
        } else if (action==2) {
            result = a-b;
        }else if (action==3){
            result = a*b;
        } else if (action==4) {
            result= a/b;
        }else {
            System.out.println("Amal bajarilmadi");
        }
         model.addAttribute("result", result);

        return "first/calculator";
    }
}
