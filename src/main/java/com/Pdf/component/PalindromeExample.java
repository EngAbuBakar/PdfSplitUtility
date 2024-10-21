package com.Pdf.component;

public class PalindromeExample {
    public static void main(String[] args) {
        String word= "radar";
        StringBuilder revString = new StringBuilder();

        for (int i = word.length()-1 ; i>=0; i--)
        {
            revString.append(word.charAt(i));
        }
        if(word.equalsIgnoreCase(revString.toString())){
            System.out.println("the word: "+word+" is "+"palindrome");
        }else {
            System.out.println("not");
        }
    }

}
