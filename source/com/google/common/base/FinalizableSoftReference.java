package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.SoftReference;

@GwtIncompatible
public abstract class FinalizableSoftReference<T> extends SoftReference<T> implements FinalizableReference {
    public FinalizableSoftReference(T t11, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t11, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
