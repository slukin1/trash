package p039do;

import java.util.Comparator;
import java.util.Map;
import ml.d;

/* renamed from: do.f  reason: invalid package */
public final /* synthetic */ class f implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f53845b;

    public /* synthetic */ f(Map map) {
        this.f53845b = map;
    }

    public final int compare(Object obj, Object obj2) {
        return k.T(this.f53845b, (d) obj, (d) obj2);
    }
}
