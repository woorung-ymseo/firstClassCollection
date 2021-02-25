package com.sample.learning.collection.wrap;

import com.sample.learning.collection.constants.Subject;
import com.sample.learning.collection.entity.Archievement;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class MathArchievement {

    private final List<Archievement> archievements;

    public MathArchievement(List<Archievement> archievements) {
        this.archievements = archievements;
    }

    public OptionalDouble getAverage() {
        return archievements.stream()
                .mapToDouble(Archievement::getScore)
                .average();
    }
}
