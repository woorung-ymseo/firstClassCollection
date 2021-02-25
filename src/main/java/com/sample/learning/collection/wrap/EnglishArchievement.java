package com.sample.learning.collection.wrap;

import com.sample.learning.collection.entity.Archievement;

import java.util.List;
import java.util.OptionalDouble;

public class EnglishArchievement {

    private final List<Archievement> archievements;

    public EnglishArchievement(List<Archievement> archievements) {
        this.archievements = archievements;
    }

    public OptionalDouble getAverage() {
        return archievements.stream()
                .mapToDouble(Archievement::getScore)
                .average();
    }
}
