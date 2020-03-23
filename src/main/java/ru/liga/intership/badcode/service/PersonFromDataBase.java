package ru.liga.intership.badcode.service;

import ru.liga.intership.badcode.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonFromDataBase {
	public static List<Person> retrievePersonFromResultSet(ResultSet resultSet) throws SQLException {
		List<Person> list = new ArrayList<>();
		while (resultSet.next()) {
			list.add(new Person(
					resultSet.getLong("id"),
					resultSet.getString("sex"),
					resultSet.getString("name"),
					resultSet.getLong("age"),
					resultSet.getLong("weight"),
					resultSet.getLong("height")
			));
		}
		return list;
	}
}
