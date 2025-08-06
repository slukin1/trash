package com.amazonaws.services.s3.model.metrics;

public final class MetricsPrefixPredicate extends MetricsFilterPredicate {
    private final String prefix;

    public MetricsPrefixPredicate(String str) {
        this.prefix = str;
    }

    public void accept(MetricsPredicateVisitor metricsPredicateVisitor) {
        metricsPredicateVisitor.c(this);
    }

    public String getPrefix() {
        return this.prefix;
    }
}
