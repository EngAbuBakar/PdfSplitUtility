package com.Pdf.component;

import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>();

        list.add(2);
        list.add(1);
        list.add(5);
        list.add(78);

        List<Integer> count =  list.stream().filter(x->x%2!=0).collect(Collectors.toList());
        System.out.println(count);

    }
}
