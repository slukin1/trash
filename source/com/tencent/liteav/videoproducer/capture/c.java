package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.Size;
import java.util.Comparator;

final /* synthetic */ class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final c f22601a = new c();

    private c() {
    }

    public static Comparator a() {
        return f22601a;
    }

    public final int compare(Object obj, Object obj2) {
        return ((Size) obj2).getArea() - ((Size) obj).getArea();
    }
}
