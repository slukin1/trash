package com.amazonaws.services.s3.model.metrics;

import com.amazonaws.services.s3.model.Tag;

public final class MetricsTagPredicate extends MetricsFilterPredicate {
    private final Tag tag;

    public MetricsTagPredicate(Tag tag2) {
        this.tag = tag2;
    }

    public void accept(MetricsPredicateVisitor metricsPredicateVisitor) {
        metricsPredicateVisitor.a(this);
    }

    public Tag getTag() {
        return this.tag;
    }
}
