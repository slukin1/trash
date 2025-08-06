package p039do;

import java.util.Comparator;
import java.util.Map;
import ml.d;

/* renamed from: do.n  reason: invalid package */
public final /* synthetic */ class n implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f53852b;

    public /* synthetic */ n(Map map) {
        this.f53852b = map;
    }

    public final int compare(Object obj, Object obj2) {
        return s.R(this.f53852b, (d) obj, (d) obj2);
    }
}
