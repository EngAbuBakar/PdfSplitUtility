package com.Pdf.component;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>();

        list.add(2);
        list.add(1);

        long count = list.stream().count();
        System.out.println(count);

    }
}
