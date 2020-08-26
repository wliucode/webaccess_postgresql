package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PostgreSQL")
public class PersonDAOImpl implements PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        //return null;

        /*
        return List.of(new Person(UUID.randomUUID(),
                "FROM POSTGRES DB",
                "Liu",
                "wliu@test.com",
                "password"));

         */
        final String sql = "SELECT id, firstname, lastname, email, password FROM person";
        //List<Person> people =
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            return new Person(id, firstname, lastname, email, password);
        });
    }

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

        //return Optional.empty();
        final String sql = "SELECT id, firstname, lastname, email, password FROM person WHERE id = ?";

        Person person = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    return new Person(personId, firstname, lastname, email, password);
                });
        return Optional.ofNullable(person);
    }
}
