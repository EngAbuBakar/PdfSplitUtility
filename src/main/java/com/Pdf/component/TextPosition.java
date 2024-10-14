package com.Pdf.component;

public class TextPosition {
    private String word;
    private float x;
    private float y;

    public  TextPosition(String word, float x, float y) {
        this.word = word;
        this.x = x;
        this.y = y;
    }

    public String getWord() {
        return word;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Word: " + word + " at (" + x + ", " + y + ")";
    }
}
