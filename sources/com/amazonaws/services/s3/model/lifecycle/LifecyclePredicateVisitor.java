package com.amazonaws.services.s3.model.lifecycle;

public interface LifecyclePredicateVisitor {
    void a(LifecyclePrefixPredicate lifecyclePrefixPredicate);

    void b(LifecycleTagPredicate lifecycleTagPredicate);

    void c(LifecycleAndOperator lifecycleAndOperator);
}
