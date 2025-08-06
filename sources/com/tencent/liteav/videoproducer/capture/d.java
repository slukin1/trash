package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.a.a;
import java.util.Comparator;

final /* synthetic */ class d implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final d f22602a = new d();

    private d() {
    }

    public static Comparator a() {
        return f22602a;
    }

    public final int compare(Object obj, Object obj2) {
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        int i11 = aVar.f22516a;
        int i12 = aVar2.f22516a;
        if (i11 < i12) {
            return -1;
        }
        if (i11 == i12) {
            return aVar.f22517b - aVar2.f22517b;
        }
        return 1;
    }
}
