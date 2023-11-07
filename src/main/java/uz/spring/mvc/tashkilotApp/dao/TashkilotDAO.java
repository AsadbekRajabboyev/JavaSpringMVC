package uz.spring.mvc.tashkilotApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.spring.mvc.DAO.PersonMapper;
import uz.spring.mvc.DAO.TashkilotMapper;
import uz.spring.mvc.tashkilotApp.model.Tashkilot;

import java.util.ArrayList;
import java.util.List;

@Component
public class TashkilotDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public TashkilotDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Tashkilot> showAllTashkilot() {
        List<Tashkilot> tashkilotList = new ArrayList<>();
        return jdbcTemplate.query("Select * from tashkilotlar",new TashkilotMapper());
    }

    public void yangiTashkilot(Tashkilot tashkilot) {
        jdbcTemplate.update("INSERT INTO tashkilotlar(namee,type) values(?,?)", tashkilot.getName(),tashkilot.getType());
    }

}
