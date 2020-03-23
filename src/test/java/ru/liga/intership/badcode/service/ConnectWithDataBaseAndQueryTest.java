package ru.liga.intership.badcode.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.intership.badcode.BadcodeApplication;

import java.sql.SQLException;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
public class ConnectWithDataBaseAndQueryTest {

	private static ConnectWithDataBaseAndQuery connect;

	@Before
	public void setUp() throws SQLException {
		SpringApplication.run(BadcodeApplication.class);
		connect = new ConnectWithDataBaseAndQuery("jdbc:hsqldb:mem:test", "sa", "");
	}
	@Test(expected = SQLException.class)
	public void wrongQueryIntoDataBase() throws SQLException{
		connect.queryIntoDataBase("SELECT * FROM ADULTPERSONS");
	}

	@Test
	public void testOnNotNull() throws SQLException {
		assertNotNull(connect.queryIntoDataBase("SELECT * FROM person WHERE sex = 'male' AND age > 18"));
	}

}