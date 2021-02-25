package com.sample.learning.collection.wrap;

import com.sample.learning.collection.constants.Subject;
import com.sample.learning.collection.entity.Archievement;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class UserArchievement {

    private final List<Archievement> archievements;

    public UserArchievement(List<Archievement> archievements) {
        this.archievements = archievements;
    }

    public OptionalDouble getMathAverage() {
        return getFilterSubject(archievement -> archievement.isMath(Subject.MATH));
    }

    public OptionalDouble getEnglishAverage() {
        return getFilterSubject(archievement -> archievement.isMath(Subject.ENGLISH));
    }

    private OptionalDouble getFilterSubject(Predicate<Archievement> predicate) {
        return archievements.stream()
                .filter(predicate)
                .mapToDouble(Archievement::getScore)
                .average();
    }
}
