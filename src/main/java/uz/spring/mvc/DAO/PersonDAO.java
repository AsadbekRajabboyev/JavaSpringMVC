package uz.spring.mvc.DAO;

import org.springframework.stereotype.Component;
import uz.spring.mvc.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person>people;
    private static final int PEOPLE_COUNT =0;
    {
        people = new ArrayList<>();
        people.add(new Person(1,"Asadbek"));
        people.add(new Person(2,"Hurshid"));
        people.add(new Person(3,"Komil"));
        people.add(new Person(4,"Bobur"));

    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
}