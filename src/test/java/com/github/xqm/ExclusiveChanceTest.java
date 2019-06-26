package com.github.xqm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExclusiveChanceTest {

    @Test
    public void should_get_not_chance() {

        //given
        ExclusiveChance exclusiveChance = new ExclusiveChance(0.2);

        //when
        ExclusiveChance not = exclusiveChance.not();

        //then
        assertEquals(new ExclusiveChance(0.8), not);
    }

    @Test
    public void should_get_and_chance() {

        //given
        ExclusiveChance exclusiveChanceA = new ExclusiveChance(0.2);
        ExclusiveChance exclusiveChanceB = new ExclusiveChance(0.7);

        //when
        ExclusiveChance and = exclusiveChanceA.and(exclusiveChanceB);

        //then
        assertEquals(new ExclusiveChance(0.0), and);

    }


    @Test
    public void should_get_or_chance() {

        //given
        ExclusiveChance exclusiveChanceA = new ExclusiveChance(0.2);
        ExclusiveChance exclusiveChanceB = new ExclusiveChance(0.7);

        //when
        ExclusiveChance or = exclusiveChanceA.or(exclusiveChanceB);

        //then
        assertEquals(new ExclusiveChance(0.9), or);

    }
}