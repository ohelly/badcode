package ru.liga.intership.badcode.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.intership.badcode.BadcodeApplication;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class PersonFromDataBaseTest {

	private static ConnectWithDataBaseAndQuery connect;

	@Before
	public void setUp() throws SQLException {
		SpringApplication.run(BadcodeApplication.class);
		connect = new ConnectWithDataBaseAndQuery("jdbc:hsqldb:mem:test", "sa", "");
	}

	@Test
	public void retrievePersonFromResultSetSizeZero() throws SQLException {
		ResultSet resultSet = connect.queryIntoDataBase("SELECT * FROM person WHERE sex = 'male' AND age > 40");
		assertEquals(0, PersonFromDataBase.retrievePersonFromResultSet(resultSet).size());
	}

	@Test
	public void retrievePersonFromResultSetSizeOne() throws SQLException {
		ResultSet resultSet = connect.queryIntoDataBase("SELECT * FROM person WHERE sex = 'male' AND age < 18");
		assertEquals(1, PersonFromDataBase.retrievePersonFromResultSet(resultSet).size());
	}
}