package ru.liga.intership.badcode.domain;



public class Person {
    private Long id;
    private String sex;
    private String name;
    private Long age;
    private Long weight;
    private Long height;
    private double heightInMeters;
    private double imt;


    public Person() {
    }

    public Person(Long id, String sex, String name, Long age, Long weight, Long height) {
        this.id = id;
        this.sex = sex;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        heightInMeters = height / 100d;
        imt = weight / (Double) (heightInMeters * heightInMeters);
    }

    public double getImt() {
        return imt;
    }

    public double getHeightInMeters() {
    	return heightInMeters;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
