package com.amazonaws.services.s3.model.analytics;

public interface AnalyticsPredicateVisitor {
    void a(AnalyticsPrefixPredicate analyticsPrefixPredicate);

    void b(AnalyticsTagPredicate analyticsTagPredicate);

    void c(AnalyticsAndOperator analyticsAndOperator);
}
