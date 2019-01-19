package Modules;

import java.util.Random;

public class MathModule {
    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static float clamp(float f, int min, int max){
        if(f > max){
            return max;
        } else if(f < min){
            return min;
        } else if(f > min && f < max){
            return f;
        } else {
            return f;
        }
    }
}
