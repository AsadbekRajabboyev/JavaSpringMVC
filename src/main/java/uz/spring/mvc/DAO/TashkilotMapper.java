package uz.spring.mvc.DAO;

import org.springframework.jdbc.core.RowMapper;
import uz.spring.mvc.model.Person;
import uz.spring.mvc.tashkilotApp.dao.TashkilotDAO;
import uz.spring.mvc.tashkilotApp.model.Tashkilot;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TashkilotMapper implements RowMapper<Tashkilot> {
    @Override
    public Tashkilot mapRow(ResultSet resultSet, int i) throws SQLException {
        Tashkilot tashkilot = new Tashkilot();
        tashkilot.setId(resultSet.getInt("id"));
        tashkilot.setName(resultSet.getString("namee"));
        tashkilot.setType(resultSet.getString("type"));
        return tashkilot;
    }
}
