package uz.spring.mvc.tashkilotApp.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.spring.mvc.model.Person;
import uz.spring.mvc.tashkilotApp.dao.TashkilotDAO;
import uz.spring.mvc.tashkilotApp.model.Tashkilot;

import javax.validation.Valid;

@Controller
@RequestMapping("/tashkilot")
public class TashkilotController {
    private final TashkilotDAO tashkilotDAO;
    @Autowired
    public TashkilotController(TashkilotDAO tashkilotDAO) {
        this.tashkilotDAO = tashkilotDAO;
    }

    @GetMapping
    public String barchaTashkilotlar(Model model){
        model.addAttribute("tashkilot", tashkilotDAO.showAllTashkilot());
        return "tashkilot/barchaTashkilotlar";
    }
    @GetMapping("/new")
    public String yangiTashkilotQoshish(Model model){
        model.addAttribute("tashkilot", new Tashkilot());
        return "tashkilot/yangiTashkilot";
    }
    @PostMapping
    public String yangiTashkilot(@ModelAttribute("tashkilots") @Valid Tashkilot tashkilot, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "people/new";
        }
        tashkilotDAO.yangiTashkilot(tashkilot);
        return "redirect:/tashkilot";
    }
    @GetMapping("/bolimlar")
    public String barchaBolimlar(){
        return "tashkilot/barchaBolimlar";
    }
    @GetMapping("bolimlar/yangiBolimQoshish")
    public String yangiBolimQoshish(){
        return "tashkilot/yangiBolimQoshish";
    }
    @GetMapping("/ishchilar")
    public String barchaIshchilar(){
        return "tashkilot/barchaIshchilar";
    }
    @GetMapping("/ishchilar/yangiIshchiQoshish")
    public String yangiIshchiQoshish(){
        return "tashkilot/yangiIshchi";
    }
}
