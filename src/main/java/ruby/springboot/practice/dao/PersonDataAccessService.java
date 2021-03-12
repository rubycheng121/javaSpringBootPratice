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
        return 0;
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

//        List<Person> people = (List<Person>) jdbcTemplate.query(sql, (resultSet -> {
//            UUID id = UUID.fromString(resultSet.getString("id"));
//            System.out.println(id.toString());
//            String name = resultSet.getString("name");
//            System.out.println(name);
//                    return new Person(id,name);
//        }));
//        return people;
    }

//        @Override
//    public List<Person> selectAllPeople() {
//            return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
//    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }
}
