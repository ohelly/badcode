package ru.liga.intership.badcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.liga.intership.badcode.service.ConnectWithDataBaseAndQuery;
import ru.liga.intership.badcode.service.PersonFromDataBase;
import ru.liga.intership.badcode.service.PersonService;

import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class BadcodeApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(BadcodeApplication.class, args);
		ConnectWithDataBaseAndQuery connect = new ConnectWithDataBaseAndQuery("jdbc:hsqldb:mem:test", "sa", "");
		ResultSet resultSet = connect.queryIntoDataBase("SELECT * FROM person WHERE sex = 'male' AND age > 18");
		PersonService personService = new PersonService(
				PersonFromDataBase.retrievePersonFromResultSet(resultSet));
		System.out.println("Average imt - " +
				personService.getAdultMaleUsersAverageBMI());
	}
}
