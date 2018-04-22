package com.company.LiveTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleArraysRange {

    static List<Integer> solution(int[] oldArray, int sum){
       // int[] myNewArray = new int[oldArray.length];
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i <oldArray.length ; i++) {
            for (int j = i+1; j < oldArray.length; j++) {
                if (oldArray[j] == sum - oldArray[i]){
                    //return new int[] {i,j};
                    intList.add(i);
                    intList.add(j);
                }
            }
        }
        return intList;

    }
    public static void main(String[] args) {

        boolean[] arr1 = new boolean[]{true, false, false};
        System.out.println("Printing 1st array:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Array " + i + ":" + arr1[i]);
        }
        boolean[] arr2 = Arrays.copyOfRange(arr1, 1, 4);
        System.out.println("Printing new array:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Array " + i + ":" + arr2[i]);
        }




        //String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
        //String[] myNewArray = Arrays.stream(myArray).map(s -> s.toUpperCase()).toArray(value -> new String[value]);
        String[] myArray = { "this", "is", "a", "sentence" };
        String result = Arrays.stream(myArray)
                .reduce("", (a,b) -> a + b);
        System.out.println(result);
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Arrays.stream(data)
                .flatMap(strings -> Arrays.stream(strings))
                .filter(s -> "a".equalsIgnoreCase(s.toString()))
                .forEach(s -> System.out.println(s));


        //print indices
        int[] oldArray= {2,7,2,15};
        int sum =9 ;
        List<Integer> newArray = solution(oldArray, sum);
        newArray.stream().forEach(integer -> System.out.println(integer.toString()));

    }
}
