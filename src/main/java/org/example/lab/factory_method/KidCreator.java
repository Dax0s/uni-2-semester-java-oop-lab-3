package org.example.lab.factory_method;

import org.example.lab.person.Person;
import org.example.lab.person.Kid;

public class KidCreator extends PersonCreator {
    @Override
    public Person createPerson(String name, int age) {
        return new Kid(name, age);
    }
}
