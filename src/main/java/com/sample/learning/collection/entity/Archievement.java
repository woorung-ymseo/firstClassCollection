package com.sample.learning.collection.entity;


import com.sample.learning.collection.constants.Subject;
import org.apache.commons.lang3.StringUtils;

public class Archievement {

    private String name;
    private Subject subject;
    private int score;

    public Archievement(String name, Subject subject, int score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public boolean isMath(Subject subject) {
        return StringUtils.equals(this.subject.name(), subject.name());
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject.name();
    }

    public int getScore() {
        return score;
    }
}
