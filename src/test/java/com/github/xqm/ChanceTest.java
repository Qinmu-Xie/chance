package com.github.xqm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChanceTest {

    @Test
    public void should_get_not_chance() {

        //given
        IndependentChance independentChance = new IndependentChance(0.2);

        //when
        IndependentChance not = independentChance.not();

        //then
        assertEquals(new IndependentChance(0.8), not);
    }


    @Test
    public void should_get_and_chance() {

        //given
        IndependentChance independentChanceA = new IndependentChance(0.2);
        IndependentChance independentChanceB = new IndependentChance(0.7);

        //when
        IndependentChance and = independentChanceA.and(independentChanceB);

        //then
        assertEquals(new IndependentChance(0.14), and);
    }

    @Test
    public void should_get_or_change() {

        //given
        IndependentChance independentChanceA = new IndependentChance(0.2);
        IndependentChance independentChanceB = new IndependentChance(0.7);

        //when
        IndependentChance or = independentChanceA.or(independentChanceB);

        //then
        assertEquals(new IndependentChance(0.76), or);
    }
}