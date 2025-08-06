package com.amazonaws.services.s3.model.lifecycle;

public final class LifecyclePrefixPredicate extends LifecycleFilterPredicate {
    private final String prefix;

    public LifecyclePrefixPredicate(String str) {
        this.prefix = str;
    }

    public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor) {
        lifecyclePredicateVisitor.a(this);
    }

    public String getPrefix() {
        return this.prefix;
    }
}
