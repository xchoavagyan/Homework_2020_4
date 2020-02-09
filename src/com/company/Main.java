package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("1 - Convert elements of a  collection to upper case.");

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("My");
        stringArrayList.add("name");
        stringArrayList.add("is");
        stringArrayList.add("John");
        stringArrayList.add("Doe");
        List<String> collect = stringArrayList.stream()
                .map((each) -> each.toUpperCase())
                .collect(Collectors.toList());
        collect.forEach((each) -> System.out.println(each));

        System.out.println("2 - Filter collection so that only elements with less than 4 characters are returned.");

        List<String> collect1 = stringArrayList.stream()
                .filter((each) -> each.chars().count() <= 3)
                .collect(Collectors.toList());
        collect1.forEach((each) -> System.out.println(each));

        System.out.println("3 - Flatten multidimensional collection");

        ArrayList<String> list = new ArrayList<>();
        list.add("My");
        list.add("name");
        list.add("is");
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("Doe");

        List<ArrayList<String>> lists = new ArrayList<>();
        lists.add(list);
        lists.add(list1);

        List<String> strings = lists.stream()
                .flatMap((each) -> each.stream())
                .collect(Collectors.toList());
        strings.forEach((each) -> System.out.println(each));

        System.out.println("4 -Get oldest person from the collection");

        Person person1 = new Person("John", 10,"England");
        Person person2 = new Person("July", 15,"British");
        Person person3 = new Person("Jack", 20,"England");

        ArrayList<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);

        OptionalInt max = people.stream()
                .mapToInt(each -> each.getAge())
                .max();
        System.out.println(max.getAsInt());

        System.out.println("5 - Sum all elements of a numeric collection");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        int sum = integerList.stream()
                .mapToInt(each -> each)
                .sum();
        System.out.println(sum);

        System.out.println("6 - Get names of all kids (under age of 18)");

        List<String> kids = people.stream()
                .filter(person -> person.getAge() < 18)
                .map(person -> person.getName())
                .collect(Collectors.toList());
        kids.forEach(each -> System.out.println(each));

        System.out.println(" 7 Partition adults and kids ");

        Map<Boolean, List<Person>> partitionAdult = people.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() > 18));
        System.out.println(partitionAdult.get(true));

        System.out.println("8 - Group people by nationality");

        Map<String, List<Person>> groupedByNationality = people.stream().collect(Collectors.groupingBy(person -> person.getNationality()));
        System.out.println(groupedByNationality.get("British"));

        System.out.println("9 - Return people names separated by comma");

        String commaSeperated = people.stream()
                .map(person -> person.getName())
                .collect(Collectors.joining(","));
        System.out.println(commaSeperated);
    }
}
