package com.company.LiveTest;


import java.util.Scanner;

public class ArrayShifting {

     public static int[] solution(int[] old) {
        // System.out.println("old array length : "+old.length);
         int[] myNewArray = new int[old.length];
         for (int i = 0; i < old.length - 1; i++) {
             myNewArray[i+1] = old[i];
         }
         myNewArray[0] = old[old.length - 1];
         return myNewArray;
     }
    public static void main(String[] args) {

        int[] oldArray = {0, 5, 6, 3, 2};
        int[] newArray;
        int count = new Scanner(System.in).nextInt();
        for (int i = 0; i < count; i++) {
            newArray = solution(oldArray);
            oldArray = newArray;
            for (int number : newArray) {
                System.out.print(+number + ", ");
            }
            System.out.println("\n");
        }
    }
}
