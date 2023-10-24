package uz.spring.mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.spring.mvc.DAO.ItemDAO;
import uz.spring.mvc.model.Item;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemDAO itemDAO;
    @Autowired
    public ItemController(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("product", itemDAO.index());
        return "item/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("item", itemDAO.show(id));
        return "item/show";
    }
    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("item", new Item());
        return "item/new";
    }
    @PostMapping
    public String createProduct(@ModelAttribute("item") Item item){
        itemDAO.saveItem(item);
        return "redirect:/items";
    }
}
