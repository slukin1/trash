package com.amazonaws.services.s3.model.lifecycle;

import java.io.Serializable;

public class LifecycleFilter implements Serializable {
    private LifecycleFilterPredicate predicate;

    public LifecycleFilter() {
    }

    public LifecycleFilterPredicate getPredicate() {
        return this.predicate;
    }

    public void setPredicate(LifecycleFilterPredicate lifecycleFilterPredicate) {
        this.predicate = lifecycleFilterPredicate;
    }

    public LifecycleFilter withPredicate(LifecycleFilterPredicate lifecycleFilterPredicate) {
        setPredicate(lifecycleFilterPredicate);
        return this;
    }

    public LifecycleFilter(LifecycleFilterPredicate lifecycleFilterPredicate) {
        this.predicate = lifecycleFilterPredicate;
    }
}
