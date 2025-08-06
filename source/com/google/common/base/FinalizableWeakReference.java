package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.WeakReference;

@GwtIncompatible
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
    public FinalizableWeakReference(T t11, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t11, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
