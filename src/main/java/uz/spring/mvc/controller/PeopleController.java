package uz.spring.mvc.controller;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uz.spring.mvc.DAO.PersonDAO;
import uz.spring.mvc.model.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;
    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }
    @PostMapping
    public String createPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "people/new";
        }
    personDAO.saveUser(person);
    return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person")@Valid Person person,BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()){
            return "people/edit";
        }
        personDAO.edit(id,person);
        return "redirect:/people";
    }
    @DeleteMapping("{id}/delete")
    public String deletePerson( @PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
