package p039do;

import java.util.Comparator;
import java.util.Map;
import ml.d;

/* renamed from: do.g  reason: invalid package */
public final /* synthetic */ class g implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f53846b;

    public /* synthetic */ g(Map map) {
        this.f53846b = map;
    }

    public final int compare(Object obj, Object obj2) {
        return k.S(this.f53846b, (d) obj, (d) obj2);
    }
}
