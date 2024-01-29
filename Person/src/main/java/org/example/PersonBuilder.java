package org.example;

public class PersonBuilder {
    protected String name = "";
    protected String surname = "";
    private int age = 0;

    private String town = "";

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.town = town;
        return this;
    }

    public Person build() throws IllegalArgumentException {
        if (this.name.isEmpty() || this.surname.isEmpty()) {
            throw new IllegalStateException("Не заполнены все необходимые данные");

        }
        Person outputPerson = this.age >= 0 ? new Person(this.name, this.surname, this.age) : new Person(this.name, this.surname);
        if (this.town.isEmpty()) {
            outputPerson.setAddress(this.town);
        }
        return outputPerson;
    }
}
