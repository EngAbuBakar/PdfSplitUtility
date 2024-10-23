package com.Pdf.component;

public class MaxExample {

    public static void main(String[] args) {
        int[] array = {2,4,54,5};

        int max= 0;
        System.out.println("The maximum number is: ");
        for (int i = 0 ; i< array.length; i++){
            if(array[i]>max){
                max =array[i];
            }
        }
        System.out.println(max);


        System.out.println("The minimum number is: ");
        for (int i = 0 ; i< array.length; i++){
            if(array[i]<max){
                max =array[i];
            }
        }
        System.out.println(max);
    }



}
