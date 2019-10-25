package com.example.makethisdrawgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Expression_Dealer {

    public static float[] expression_dealer(String expression) {

        String expression1 = expression.replaceAll("[+]", ",").replaceAll("x", "");
        Pattern pattern = Pattern.compile(",");
        String numbers[] = pattern.split(expression1);
        ArrayList<Float> f_numbers = new ArrayList<>();
        for(String s:numbers) {
            f_numbers.add(Float.parseFloat(s));
        }

        return toArray(f_numbers);

    }

    public static float[] toArray(List<Float> target) {
        final float[] result = new float[target.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = target.get(i);
        }
        return result;
    }

}

