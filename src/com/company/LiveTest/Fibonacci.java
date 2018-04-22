package com.company.LiveTest;

import java.util.Scanner;

public class Fibonacci {

     static int fib(int n){
        if(n<=1){
            return n;
        }
        return  fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        System.out.println(fib(number));
    }
}
