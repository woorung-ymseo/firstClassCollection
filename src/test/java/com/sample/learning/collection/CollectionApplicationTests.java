package com.sample.learning.collection;

import com.sample.learning.collection.constants.Subject;
import com.sample.learning.collection.entity.Archievement;
import com.sample.learning.collection.wrap.EnglishArchievement;
import com.sample.learning.collection.wrap.MathArchievement;
import com.sample.learning.collection.wrap.UserArchievement;
import com.sample.learning.collection.wrap.UserScore;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CollectionApplicationTests {

    /**
     * 일급컬렉션이란 Collection을 Wrapping하면서 그 외 다른 멤버 변수가 없는 상태
     */
    @Tag("일급컬렉션 맵 예시")
    @Test
    void collectionMap() {
        // given
        Map<String, Integer> score = new HashMap<String, Integer>();

        score.put("seo", 100);
        score.put("kim", 90);
        score.put("park", 80);

        UserScore userScore = new UserScore(score);

        // when
        int sum = userScore.sum();

        // then
        assertThat(270)
                .isNotZero()
                .isEqualTo(sum);
    }

    @Tag("일급컬렉션 리스트 예시 - 평균값 구하기")
    @Test
    void collectionList() {
        // given
        List<Archievement> archievements = Arrays.asList(
                new Archievement("seo", Subject.MATH, 100),
                new Archievement("seo", Subject.ENGLISH, 100),
                new Archievement("seo", Subject.SCIENCE, 100),
                new Archievement("kim", Subject.MATH, 80),
                new Archievement("kim", Subject.ENGLISH, 70),
                new Archievement("kim", Subject.SCIENCE, 60),
                new Archievement("park", Subject.MATH, 50),
                new Archievement("park", Subject.ENGLISH, 40),
                new Archievement("park", Subject.SCIENCE, 30)
        );

        UserArchievement userArchievement = new UserArchievement(archievements);


        // when
        OptionalDouble mathAverage = userArchievement.getMathAverage();

        // then
        assertThat(mathAverage.getAsDouble())
                .isNotZero()
                .isEqualTo(230/3D);
    }

    @Tag("일급컬렉션 리스트 예시 - 이름으로 판별 가능")
    @Test
    void collectionListName() {
        // given
        List<Archievement> archievements = Arrays.asList(
                new Archievement("seo", Subject.MATH, 100),
                new Archievement("seo", Subject.ENGLISH, 100),
                new Archievement("seo", Subject.SCIENCE, 100),
                new Archievement("kim", Subject.MATH, 80),
                new Archievement("kim", Subject.ENGLISH, 70),
                new Archievement("kim", Subject.SCIENCE, 60),
                new Archievement("park", Subject.MATH, 50),
                new Archievement("park", Subject.ENGLISH, 40),
                new Archievement("park", Subject.SCIENCE, 30)
        );

        MathArchievement mathArchievement = new MathArchievement(archievements.stream()
                                                                    .filter(a -> a.isMath(Subject.MATH))
                                                                    .collect(Collectors.toList()));

        EnglishArchievement englishArchievement = new EnglishArchievement(archievements.stream()
                                                                    .filter(a -> a.isMath(Subject.ENGLISH))
                                                                    .collect(Collectors.toList()));


        // when
        OptionalDouble mathAverage = mathArchievement.getAverage();
        OptionalDouble englishAverage = englishArchievement.getAverage();

        // then
        assertThat(mathAverage.getAsDouble())
                .isNotZero()
                .isEqualTo(230/3D);

        assertThat(englishAverage.getAsDouble())
                .isNotZero()
                .isEqualTo(210/3D);
    }
}
