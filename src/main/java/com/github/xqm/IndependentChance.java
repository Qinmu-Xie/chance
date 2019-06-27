package com.github.xqm;

import com.google.common.base.Objects;

public class IndependentChance {
    private Double possibility;
    private double DELTA = 0.000001;
    private int MUST_HAPPEN = 1;

    IndependentChance(double possibility) {
        this.possibility = possibility;
    }

    IndependentChance not() {
        return new IndependentChance(MUST_HAPPEN - this.possibility);
    }


    IndependentChance and(IndependentChance chance) {
        return new IndependentChance(this.possibility * chance.possibility);
    }

    public IndependentChance or(IndependentChance chance) {
        return new IndependentChance(this.possibility + chance.possibility
                - this.and(chance).possibility);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndependentChance that = (IndependentChance) o;
        return Math.abs(possibility - that.possibility) < DELTA;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(possibility);
    }

    @Override
    public String toString() {
        return "IndependentChance{" +
                "possibility=" + possibility +
                '}';
    }


}
