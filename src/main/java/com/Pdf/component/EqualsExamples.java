package com.Pdf.component;

public class EqualsExamples {

    public static void main(String[] args) {

        String s1 = "HELLO";
        String s2 = "free";
        String s3 = new String("HELLO");

        System.out.println(s1 == s2); //false
        System.out.println(s1 == s3); //false
        System.out.println(s1.equals(s3)); //TRUE
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
    }



}
