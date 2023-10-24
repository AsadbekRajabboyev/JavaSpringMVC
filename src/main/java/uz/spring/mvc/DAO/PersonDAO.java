package uz.spring.mvc.DAO;

import org.springframework.stereotype.Component;
import uz.spring.mvc.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person>people;
    private int autoInc = 0;
    private static int PEOPLE_COUNT =0;
    {
        people = new ArrayList<>();
        people.add(new Person(++autoInc,"Asadbek"));
        people.add(new Person(++autoInc,"Hurshid"));
        people.add(new Person(++autoInc,"Komil"));
        people.add(new Person(++autoInc,"Bobur"));

    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
    public void saveUser(Person person){
            person.setId(++autoInc);
            people.add(person);
    }
}