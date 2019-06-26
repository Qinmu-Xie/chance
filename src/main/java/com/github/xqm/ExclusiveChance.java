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
}
