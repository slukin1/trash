package com.amazonaws.services.s3.model.analytics;

public final class AnalyticsPrefixPredicate extends AnalyticsFilterPredicate {
    private final String prefix;

    public AnalyticsPrefixPredicate(String str) {
        this.prefix = str;
    }

    public void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor) {
        analyticsPredicateVisitor.a(this);
    }

    public String getPrefix() {
        return this.prefix;
    }
}
