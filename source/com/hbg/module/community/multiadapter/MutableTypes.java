package com.hbg.module.community.multiadapter;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public class MutableTypes implements g {

    /* renamed from: a  reason: collision with root package name */
    public final int f17241a;

    /* renamed from: b  reason: collision with root package name */
    public final List<f<?>> f17242b;

    public MutableTypes() {
        this(0, (List) null, 3, (r) null);
    }

    public MutableTypes(int i11, List<f<?>> list) {
        this.f17241a = i11;
        this.f17242b = list;
    }

    public boolean a(Class<?> cls) {
        return CollectionsKt__MutableCollectionsKt.G(d(), new MutableTypes$unregister$1(cls));
    }

    public <T> void b(f<T> fVar) {
        d().add(fVar);
    }

    public int c(Class<?> cls) {
        Iterator<f<?>> it2 = d().iterator();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i12 = -1;
                break;
            } else if (x.b(it2.next().a(), cls)) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 != -1) {
            return i12;
        }
        for (f<?> a11 : d()) {
            if (a11.a().isAssignableFrom(cls)) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public List<f<?>> d() {
        return this.f17242b;
    }

    public <T> f<T> getType(int i11) {
        return d().get(i11);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MutableTypes(int r1, java.util.List r2, int r3, kotlin.jvm.internal.r r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0005
            r1 = 0
        L_0x0005:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000e
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
        L_0x000e:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.multiadapter.MutableTypes.<init>(int, java.util.List, int, kotlin.jvm.internal.r):void");
    }
}
