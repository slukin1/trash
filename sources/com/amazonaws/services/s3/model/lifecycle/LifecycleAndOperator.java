package com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

public final class LifecycleAndOperator extends LifecycleNAryOperator {
    public LifecycleAndOperator(List<LifecycleFilterPredicate> list) {
        super(list);
    }

    public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor) {
        lifecyclePredicateVisitor.c(this);
    }

    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }
}
