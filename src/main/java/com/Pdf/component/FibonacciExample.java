package com.Pdf.component;

public class FibonacciExample {

    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 1;
        int count = 10;

        for ( int i = 0; i<count; i++ ){
           int next = n1 + n2;
            n1=n2;
            n2 = next;
            System.out.println(next);
        }

    }
}
