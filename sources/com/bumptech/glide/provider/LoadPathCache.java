package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import androidx.core.util.e;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LoadPathCache {

    /* renamed from: c  reason: collision with root package name */
    public static final p<?, ?, ?> f64171c = new p(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), (e<List<Throwable>>) null)), (e<List<Throwable>>) null);

    /* renamed from: a  reason: collision with root package name */
    public final ArrayMap<MultiClassKey, p<?, ?, ?>> f64172a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<MultiClassKey> f64173b = new AtomicReference<>();

    public <Data, TResource, Transcode> p<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        p<Data, TResource, Transcode> pVar;
        MultiClassKey b11 = b(cls, cls2, cls3);
        synchronized (this.f64172a) {
            pVar = this.f64172a.get(b11);
        }
        this.f64173b.set(b11);
        return pVar;
    }

    public final MultiClassKey b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey andSet = this.f64173b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new MultiClassKey();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public boolean c(p<?, ?, ?> pVar) {
        return f64171c.equals(pVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, p<?, ?, ?> pVar) {
        synchronized (this.f64172a) {
            ArrayMap<MultiClassKey, p<?, ?, ?>> arrayMap = this.f64172a;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (pVar == null) {
                pVar = f64171c;
            }
            arrayMap.put(multiClassKey, pVar);
        }
    }
}
