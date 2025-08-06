package com.amazonaws.services.s3.model.metrics;

public interface MetricsPredicateVisitor {
    void a(MetricsTagPredicate metricsTagPredicate);

    void b(MetricsAndOperator metricsAndOperator);

    void c(MetricsPrefixPredicate metricsPrefixPredicate);
}
