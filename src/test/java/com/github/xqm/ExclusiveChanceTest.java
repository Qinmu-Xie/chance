package com.github.xqm;

import org.junit.Test;

import static org.junit.Assert.*;

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
}