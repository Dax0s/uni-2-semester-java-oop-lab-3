package org.example.lab.person;

public abstract class Person {
    protected String name;
    protected int age;

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void speak();
}
