package com.sample.learning.collection.wrap;

import java.util.HashMap;
import java.util.Map;

public class UserScore {

    private final Map<String, Integer> score;

    public UserScore(Map<String, Integer> score) {
        this.score = score;
    }

    public int sum() {
        int sum = score.values().stream()
                .mapToInt(Integer::intValue)
                .sum();


        return sum;
    }
}
