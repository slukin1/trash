package com.huobi.home.util;

import androidx.lifecycle.z;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class SingleLiveEvent$observe$1 extends Lambda implements l<T, Unit> {
    public final /* synthetic */ z<? super T> $observer;
    public final /* synthetic */ SingleLiveEvent<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleLiveEvent$observe$1(SingleLiveEvent<T> singleLiveEvent, z<? super T> zVar) {
        super(1);
        this.this$0 = singleLiveEvent;
        this.$observer = zVar;
    }

    public final void invoke(T t11) {
        if (this.this$0.f72559a.compareAndSet(true, false)) {
            this.$observer.onChanged(t11);
        }
    }
}
