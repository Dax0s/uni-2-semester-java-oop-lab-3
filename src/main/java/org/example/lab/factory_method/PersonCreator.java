package org.example.lab.factory_method;

import org.example.lab.person.Person;

public abstract class PersonCreator {
    public void speak(String name, int age) {
        Person person = createPerson(name, age);
        person.speak();
    }

    public abstract Person createPerson(String name, int age);
}
