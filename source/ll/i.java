package ll;

import java.util.Comparator;
import ml.b;

public final /* synthetic */ class i implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f58038b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58039c;

    public /* synthetic */ i(j jVar, boolean z11) {
        this.f58038b = jVar;
        this.f58039c = z11;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f58038b.s(this.f58039c, (b) obj, (b) obj2);
    }
}
