package uz.spring.mvc.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.spring.mvc.model.Person;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
private final JdbcTemplate jdbcTemplate;
    private int autoInc = 0;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        List<Person> personList = new ArrayList<>();
        return jdbcTemplate.query("Select * from person",new PersonMapper());
            //JDBC
        /*            Statement statement = connection.createStatement();
            String query = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String namee = resultSet.getString("namee");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                Person person = new Person(id, namee, age, email, phone);
                personList.add(person);
            }*/
            /*JDBC API PreparedStatment*//*
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from person");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namee = resultSet.getString("namee");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                Person person = new Person(id, namee, age, email, phone);
                personList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

    public Person show(int id) {
        return jdbcTemplate.query("Select * from person where id =?",new Object[]{id},new PersonMapper())
            .stream().findAny().orElse(null);
/*        Person person = null;
        List<Person> personList = new ArrayList<>();*/
      /*  try {
           Statement statement = connection.createStatement();
            String query = "SELECT * FROM person WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                int personId = resultSet.getInt("id");
                String namee = resultSet.getString("namee");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                return new Person(personId, namee, age, email, phone);
            }
            JDBC TEMPLATE PreparedStatment
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int id1 = resultSet.getInt("id");
            String namee = resultSet.getString("namee");
            int age = resultSet.getInt("age");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");

             person = new Person(id1, namee, age, email, phone);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/

    }

    public void saveUser(Person person) {
        jdbcTemplate.update("Insert into person Values(1,?,?,?,?)", person.getName(), person.getAge(), person.getEmail(), person.getPhone());
/*        try {

//JDBC            Statement statement = connection.createStatement();
//            String query = "insert into person VALUES("+ ++autoInc+",'"
//                    +person.getName()+"',"
//                    +person.getAge()+",'"
//                    +person.getEmail()+"','"
//                    +person.getPhone()+"')";
//            statement.executeLargeUpdate(query);
            //JDBC API && PreparedStatment
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into person VALUES(1,?,?,?,?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setString(4, person.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

    }

    public void edit(int id, Person yangiPerson) {
         jdbcTemplate.update("Update person set namee=?, age=?, email=?, phone=? Where id=?" , yangiPerson.getName(),yangiPerson.getAge(),yangiPerson.getEmail(),yangiPerson.getPhone(),id);
/*        try {
            JDBC bilan ishlash
           Statement statement = connection.createStatement();
           String query = "UPDATE person SET namee ="
                    +"'"+yangiPerson.getName()+"'," +
                   " age ="+yangiPerson.getAge()+
                    ", email ='"+yangiPerson.getEmail()+
                    "', phone ='"+yangiPerson.getPhone()+"' WHERE id="+id;
           statement.executeUpdate(query);
            JDBC TEMPLATE PreparedStatment
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE person SET namee =?, age =?, email =?, phone=? WHERE id =?");
            preparedStatement.setString(1, yangiPerson.getName());
            preparedStatement.setInt(2, yangiPerson.getAge());
            preparedStatement.setString(3, yangiPerson.getEmail());
            preparedStatement.setString(4, yangiPerson.getPhone());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
/*        Person eskiPerson= show(id);
        eskiPerson.setName(yangiPerson.getName());
        eskiPerson.setAge(yangiPerson.getAge());
        eskiPerson.setEmail(yangiPerson.getEmail());*/
    }

    public void delete(int id) {
/*        try {
            //JDBC
            Statement statement = connection.createStatement();
            String query ="Delete from person WHERE id ="+id;
            statement.executeUpdate(query);
            JDBC TEMPLATE PreparedStatment
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from person where id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //List bilan ishlaganda
        // Person person1 = show(id);
        // people.removeIf(person -> person.getId() == id);
    }*/
        jdbcTemplate.update("Delete from person Where id =?", id);
    }
}
