package uz.spring.mvc.DAO;

import org.springframework.stereotype.Component;
import uz.spring.mvc.model.Item;
import uz.spring.mvc.model.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class ItemDAO {
    private List<Item>product;
    private int autoInc = 0;
    {
        product =new ArrayList<>();
        product.add(new Item(++autoInc,"Olma", 100,"kg","2023"));
        product.add(new Item(++autoInc,"Sut", 10,"litr","2023"));
        product.add(new Item(++autoInc,"Sabzi", 100,"qop","2023"));
        product.add(new Item(++autoInc,"Katrtoshka", 100,"kg","2023"));
    }

    public List<Item> index() {
        return product;
    }
    public Item show(int id){
        return product.stream().filter(item->item.getId()==id).findAny().orElse(null);
    }

    public void saveItem(Item item){
        item.setId(++autoInc);
        product.add(item);

    }
}
