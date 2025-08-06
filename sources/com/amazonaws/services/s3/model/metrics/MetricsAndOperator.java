package com.amazonaws.services.s3.model.metrics;

import java.util.List;

public final class MetricsAndOperator extends MetricsNAryOperator {
    public MetricsAndOperator(List<MetricsFilterPredicate> list) {
        super(list);
    }

    public void accept(MetricsPredicateVisitor metricsPredicateVisitor) {
        metricsPredicateVisitor.b(this);
    }

    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }
}
