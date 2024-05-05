package org.example.lab.factory_method;

import org.example.lab.person.Person;
import org.example.lab.person.Adult;

public class AdultCreator extends PersonCreator {
    @Override
    public Person createPerson(String name, int age) {
        return new Adult(name, age);
    }
}
