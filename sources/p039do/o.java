package p039do;

import java.util.Comparator;
import java.util.Map;

/* renamed from: do.o  reason: invalid package */
public final /* synthetic */ class o implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f53853b;

    public /* synthetic */ o(Map map) {
        this.f53853b = map;
    }

    public final int compare(Object obj, Object obj2) {
        return s.M(this.f53853b, (String) obj, (String) obj2);
    }
}
