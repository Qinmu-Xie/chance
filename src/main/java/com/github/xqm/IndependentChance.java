package com.github.xqm;

import com.google.common.base.Objects;

public class IndependentChance {
    private Double possibility;

    IndependentChance(double possibility) {
        this.possibility = possibility;
    }

    double getPossibility() {
        return this.possibility;
    }

    IndependentChance not() {
        return new IndependentChance(1 - this.possibility);
    }


    IndependentChance and(IndependentChance chance) {
        return new IndependentChance(this.possibility * chance.getPossibility());
    }

    public IndependentChance or(IndependentChance chance) {
        return new IndependentChance(this.possibility + chance.getPossibility()
                - (this.possibility * chance.getPossibility()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndependentChance that = (IndependentChance) o;
        return Math.abs(possibility - that.possibility) < 0.000001;
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
