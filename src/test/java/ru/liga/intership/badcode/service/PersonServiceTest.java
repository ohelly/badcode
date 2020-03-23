package ru.liga.intership.badcode.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import ru.liga.intership.badcode.BadcodeApplication;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class PersonServiceTest {

	private static ConnectWithDataBaseAndQuery connect;
	private static PersonService personService;

	@Before
	public void setUp() throws SQLException {
		SpringApplication.run(BadcodeApplication.class);
		connect = new ConnectWithDataBaseAndQuery("jdbc:hsqldb:mem:test", "sa", "");
		personService = new PersonService(PersonFromDataBase
				.retrievePersonFromResultSet(
						connect.queryIntoDataBase("SELECT * FROM person WHERE sex = 'male' AND age > 18")));
	}

	@Test
	public void getAdultMaleUsersAverageBMI() {
		assertEquals(25.774209960992707, personService.getAdultMaleUsersAverageBMI(), 0);
	}

	@Test
	public void getSumOfImtAllPersons() {
		assertEquals(51.54841992198541, personService.getSumOfImtAllPersons(), 0);
	}

	@Test
	public void getCountOfPerson() {
		assertEquals(2, personService.getCountOfPerson());
	}
}