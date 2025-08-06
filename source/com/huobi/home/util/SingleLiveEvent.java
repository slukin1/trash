package com.huobi.home.util;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import d10.l;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.f;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;

public final class SingleLiveEvent<T> extends MutableLiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f72559a = new AtomicBoolean(false);

    public static final class a implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f72560b;

        public a(l lVar) {
            this.f72560b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f72560b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f72560b.invoke(obj);
        }
    }

    public void observe(LifecycleOwner lifecycleOwner, z<? super T> zVar) {
        super.observe(lifecycleOwner, new a(new SingleLiveEvent$observe$1(this, zVar)));
    }

    public void setValue(T t11) {
        this.f72559a.set(true);
        super.setValue(t11);
    }
}
