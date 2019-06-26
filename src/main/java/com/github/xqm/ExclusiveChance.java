package com.github.xqm;

import com.google.common.base.Objects;

public class ExclusiveChance {
    private Double possibility;

    public ExclusiveChance(Double possibility) {
        this.possibility = possibility;
    }

    ExclusiveChance not() {
        return new ExclusiveChance(1.0 - this.possibility);
    }


    ExclusiveChance and(ExclusiveChance chance) {
        return new ExclusiveChance(0.0);
    }

    ExclusiveChance or(ExclusiveChance chance) {
        return new ExclusiveChance(Math.min(this.possibility + chance.possibility, 1.0));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExclusiveChance that = (ExclusiveChance) o;
        return Math.abs(possibility - that.possibility) < 0.000001;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(possibility);
    }

    @Override
    public String toString() {
        return "ExclusiveChance{" +
                "possibility=" + possibility +
                '}';
    }
}
