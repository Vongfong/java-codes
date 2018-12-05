package com.dragon.interview;

class Glyph {
    void draw() {
        System.out.println("Glyph.draw");
    }

    Glyph() {
        System.out.println("Glyph.before draw");
        draw();
        System.out.println("Glyph.after draw");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    void draw() {
        System.out.println("RoundGlyph, radius=" + radius);
    }

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph, radius=" + radius);
    }
}

public class Main {
    public static void main(String[] args){
        new RoundGlyph(5);
    }
}
