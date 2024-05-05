package org.example.lab.person;

public class Kid extends Person {
    public Kid(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("I'm a kid, my name is " + name + " and I am " + age + " years old");
    }
}
