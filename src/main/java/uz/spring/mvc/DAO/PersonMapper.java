package uz.spring.mvc.DAO;

import org.springframework.jdbc.core.RowMapper;
import uz.spring.mvc.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("namee"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));
        person.setPhone(resultSet.getString("phone"));
        return person;
    }
}
