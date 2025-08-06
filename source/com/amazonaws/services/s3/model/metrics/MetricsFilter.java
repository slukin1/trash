package com.amazonaws.services.s3.model.metrics;

import java.io.Serializable;

public class MetricsFilter implements Serializable {
    private MetricsFilterPredicate predicate;

    public MetricsFilter() {
    }

    public MetricsFilterPredicate getPredicate() {
        return this.predicate;
    }

    public void setPredicate(MetricsFilterPredicate metricsFilterPredicate) {
        this.predicate = metricsFilterPredicate;
    }

    public MetricsFilter withPredicate(MetricsFilterPredicate metricsFilterPredicate) {
        setPredicate(metricsFilterPredicate);
        return this;
    }

    public MetricsFilter(MetricsFilterPredicate metricsFilterPredicate) {
        this.predicate = metricsFilterPredicate;
    }
}
