package com.amazonaws.metrics;

public abstract class SimpleMetricType implements MetricType {
    public final boolean equals(Object obj) {
        if (!(obj instanceof MetricType)) {
            return false;
        }
        return name().equals(((MetricType) obj).name());
    }

    public final int hashCode() {
        return name().hashCode();
    }

    public abstract String name();

    public final String toString() {
        return name();
    }
}
