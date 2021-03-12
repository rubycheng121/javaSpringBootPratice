package ruby.springboot.practice.dao;

import ruby.springboot.practice.model.Person;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return  insertPerson(id,person);
    }

    default List<Person> selectAllPeople()  {
        return null;
    }

    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
    Optional<Person> selectPersonById(UUID id);

}
