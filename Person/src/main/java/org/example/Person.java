package org.example;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age = 0;

    private String town = "";

    //...

    public Person(String name, String surname) {
        //...
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        //...
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return !town.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(age);
        } else {
            return OptionalInt.empty();
        }
    }

    public String getAddress() {
        return town;
    }

    public void setAddress(String town) {
        this.town = town;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        return child.setSurname(this.surname).setAge(0);
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"surname\": \"" + surname + "\",\n" +
                "  \"age\": " + (age >= 0 ? age : "\"Not available\"") + ",\n" +
                "  \"livingTown\": \"" + town + "\"\n" +
                "}";
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + town.hashCode();
        return result;
    }
}
