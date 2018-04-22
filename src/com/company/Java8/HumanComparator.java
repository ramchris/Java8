package com.company.Java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HumanComparator {
    public static void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("jack" , "25"));
        humanList.add(new Human("Hack" , "65"));
        humanList.add(new Human("Back" , "45"));
        humanList.sort(Comparator.comparing(Human::getAge).thenComparing(Human::getName));
        humanList.forEach(System.out::println);
    }
}
