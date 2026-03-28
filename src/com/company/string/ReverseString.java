package com.company.string;

public class ReverseString {
    public static void main(String[] args) {
        String original = "Hello World!";
        StringBuilder reversed = new StringBuilder(original); // Create a StringBuilder with the original string
        reversed.reverse(); // Use the built-in reverse method
        System.out.println("Original string: " + original);
        System.out.println("Reversed string: " + reversed); // Convert back to String for output
        StringBuilder sb = new StringBuilder();
        for (int i = original.length() -1; i>=0; i--) {
           sb.append(original.charAt(i));
        }
        System.out.println("Reversed string: " + sb);
    }
}
