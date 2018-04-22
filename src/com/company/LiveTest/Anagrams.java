package com.company.LiveTest;


import java.util.*;
import java.util.stream.Collectors;

class Developer {
    private String name;
    private int age;
    private String address;

    public Developer(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class Developers {
    private String name;
    private int age;
    private String address;

    public Developers(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class Anagrams {

    /*static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if(number%i == 0){
                return false; //number is divisible so its not prime
            }
        }
        return true; //number is prime now

    }*/


    private static List<Developer> getDeveloper(){
       return Arrays.asList(new Developer("Zack", 90, "Chic"),
       new Developer("MAd",100, "Chico"),
               new Developer("Rob",110, "Chico"),
               new Developer("Bob",70, "Chico")
       );


    }


    public static boolean isRotatedVersion(String str, String rotated) {
        boolean isRotated;
        if (str == null || rotated == null) {
            return false;
        }
        else if (str.length() != rotated.length())
        {
            isRotated = false;
        }
        else {
            String concatenated = str + str;
        isRotated = concatenated.contains(rotated);
        }
        return isRotated;
    }

    public static void main(String[] args) {


      /*  Integer a = 1000, b = 1000;
        System.out.println(a == b);

        Integer c = 129, d = 129;
        System.out.println(c == d);


        //Anagram :
        String s1 ="SAVE";
        String s2 ="VASE";
        char [] c1 = s1.toCharArray();
        char [] c2 = s2.toCharArray();
        System.out.println("C1 " +String.valueOf(c1)+ " and C2 " +String.valueOf(c2));
        Arrays.sort(c1);
        Arrays.sort(c2);
        System.out.println("C1 " +String.valueOf(c1)+ " and C2 " +String.valueOf(c2));
        boolean isAnagram = Arrays.equals(c1, c2);
        System.out.println("isAnagram : "+isAnagram);


        //Replace String
        String testString = "This is a test";
        System.out.println("testString.replace " +testString.replace("s", "m"));
        System.out.println("testString.replaceFirst " +testString.replaceFirst("is", "ui"));*/

        //Prime#
        /*int limit = new Scanner(System.in).nextInt();
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)){
                System.out.println(i);
            }
        }*/

        String s  = "Vicky";
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        System.out.println(sb.reverse());


        //isRotatedVersion
        String test = "abcd";
        String rotated = "dabc";
        boolean isRotated = isRotatedVersion(test, rotated);
        System.out.println(isRotated);


        //Duplicate String
        String toTest = "Programming";
        char[] charArray = toTest.toCharArray();

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for ( Character c: charArray) {
            if (characterIntegerMap.containsKey(c)){
                characterIntegerMap.put(c, characterIntegerMap.get(c)+1);
            } else {
                characterIntegerMap.put(c, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> set = characterIntegerMap.entrySet();
        for (Map.Entry<Character, Integer> m : set) {
            if (m.getValue() > 1){
                System.out.printf("%s : %d %n", m.getKey(), m.getValue());
            }
        }


        for(int i = 1; i <= 50; i++) {
            System.out.println( i % 15 ==0 ? "FiZZBUZZ" : i % 5 == 0 ? "BUZZ" : i % 3 == 0 ? "FiZZ" : i);
        }
        List<Developer> developerList = getDeveloper();
        developerList.sort(Comparator.comparingInt(Developer::getAge));
        developerList.forEach(developer -> System.out.println(developer.getAge()));
        System.out.println("Name Comparison");
        developerList.sort(Comparator.comparing(Developer::getName));
        developerList.forEach(developer -> System.out.println(developer.getName()));


        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");


        HOSTING.entrySet().stream().sorted(Map.Entry
                .comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (se, s2) -> s2, LinkedHashMap::new));




       (developerList.stream()
                .filter(developer -> developer.getAge() > 100).collect(Collectors.toList()))
                .stream().forEach(developer -> System.out.println(developer.getAge()));
        //filteredList.stream().forEach(developer -> System.out.println(developer.getName()));


        //developerList.stream().collect(Collectors.mapping(o -> o.getAge(),Collectors.maxBy(Integer::compareTo)));
        Optional<Integer> maxAge = developerList
                .stream()
                .collect(Collectors.mapping((Developer emp) -> emp.getAge(), Collectors.maxBy(Integer::compareTo)));
        System.out.println("Max Age: " + maxAge.get());


       List<Developers> developersList = developerList.stream().filter(developer -> developer.getAge() > 80)
       .map(developer -> new Developers(developer.getName(), developer.getAge(), developer.getAddress()))
               .collect(Collectors.toList());
        developersList.stream().forEach(developers -> System.out.println(developers.getAddress()));


    }
}
