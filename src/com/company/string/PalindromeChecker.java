package com.company.string;

public class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        // Optional: convert to lowercase and remove non-alphanumeric characters
        // if case/punctuation should be ignored (e.g., "A man, a plan, a canal: Panama")
        // str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            System.out.println("left: " + str.charAt(left) + " right: " + str.charAt(right));
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }

        return true; // Palindrome confirmed
    }

    public static void main(String[] args) {
        String s1 = "radar";
        String s2 = "hello";

        System.out.println(s1 + " is a palindrome? " + isPalindrome(s1));
       // System.out.println(s2 + " is a palindrome? " + isPalindrome(s2));
    }
}
