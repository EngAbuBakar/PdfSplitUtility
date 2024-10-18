package com.Pdf.component;

public class ReverseStringExample {

    public static void main(String[] args) {
        String originalString = "dream big";

        String reverseString = "";

        for (int i = originalString.length()-1 ; i>=0; i--){
            reverseString = reverseString + originalString.charAt(i);
        }
        System.out.println(reverseString);
    }
}
