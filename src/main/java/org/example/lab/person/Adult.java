package org.example.lab.person;

public class Adult extends Person {
    public Adult(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("I'm an adult, my name is " + name + " and I am " + age + " years old");
    }
}
