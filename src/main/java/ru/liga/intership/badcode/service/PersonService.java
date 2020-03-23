package ru.liga.intership.badcode.service;


import ru.liga.intership.badcode.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private List<Person> listOfPersons;

    public PersonService(List<Person> listOfPersons) {
        this.listOfPersons = listOfPersons;
    }
    /**
     * Возвращает средний индекс массы тела всех лиц мужского пола старше 18 лет
     *
     * @return
     */
    public double getAdultMaleUsersAverageBMI() throws ArithmeticException{
    	double totalImt = getSumOfImtAllPersons();
    	long countOfPerson = getCountOfPerson();
        return totalImt / countOfPerson;
    }

    public double getSumOfImtAllPersons() {
    	double sum = 0;
    	for (Person p : listOfPersons)
    		sum += p.getImt();
    	return sum;
	}

	public long getCountOfPerson() {
    	return listOfPersons.size();
	}
}
