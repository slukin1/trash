package com.google.android.exoplayer2;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class c0 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f65850b;

    public /* synthetic */ c0(AtomicBoolean atomicBoolean) {
        this.f65850b = atomicBoolean;
    }

    public final Object get() {
        return Boolean.valueOf(this.f65850b.get());
    }
}
