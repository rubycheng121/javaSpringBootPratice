package ruby.springboot.practice.dao;

//import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ruby.springboot.practice.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        String sql = "INSERT INTO person(id,name) VALUES (uuid_generate_v4(), ?);";
        return jdbcTemplate.update(sql,person.getName());
    }


    @Override
    public List<Person> selectAllPeople()  {
        String sql = "SELECT id, name FROM person;";
        return jdbcTemplate.query(sql, (resultSet,i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            System.out.println(id.toString());
            String name = resultSet.getString("name");
            System.out.println(name);
            return new Person(id,name);
        });
    }


    @Override
    public int deletePersonById(UUID id) {
        String sql = "DELETE FROM person WHERE id= ? ;";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        String sql = "UPDATE person SET name=? WHERE id= ? ;";
        return jdbcTemplate.update(sql,person.getName(),id);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        String sql = "SELECT id, name FROM person where id =?;";
        Person person =  jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet,i) -> {
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    return new Person(id,name);
                });
        return Optional.ofNullable(person);
    }
}
