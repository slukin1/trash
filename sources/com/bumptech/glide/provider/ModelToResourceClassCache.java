package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ModelToResourceClassCache {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<MultiClassKey> f64174a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<MultiClassKey, List<Class<?>>> f64175b = new ArrayMap<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        MultiClassKey andSet = this.f64174a.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new MultiClassKey(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f64175b) {
            list = this.f64175b.get(andSet);
        }
        this.f64174a.set(andSet);
        return list;
    }

    public void b(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f64175b) {
            this.f64175b.put(new MultiClassKey(cls, cls2, cls3), list);
        }
    }
}
