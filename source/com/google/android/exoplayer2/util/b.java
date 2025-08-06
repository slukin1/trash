package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.ListenerSet;
import java.util.concurrent.CopyOnWriteArraySet;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CopyOnWriteArraySet f66084b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f66085c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ListenerSet.Event f66086d;

    public /* synthetic */ b(CopyOnWriteArraySet copyOnWriteArraySet, int i11, ListenerSet.Event event) {
        this.f66084b = copyOnWriteArraySet;
        this.f66085c = i11;
        this.f66086d = event;
    }

    public final void run() {
        ListenerSet.lambda$queueEvent$0(this.f66084b, this.f66085c, this.f66086d);
    }
}
