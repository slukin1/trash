package p039do;

import java.util.Comparator;
import java.util.Map;

/* renamed from: do.h  reason: invalid package */
public final /* synthetic */ class h implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f53847b;

    public /* synthetic */ h(Map map) {
        this.f53847b = map;
    }

    public final int compare(Object obj, Object obj2) {
        return k.Q(this.f53847b, (String) obj, (String) obj2);
    }
}
