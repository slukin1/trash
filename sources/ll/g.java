package ll;

import java.util.Comparator;
import ml.b;

public final /* synthetic */ class g implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f58033b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58034c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f58035d;

    public /* synthetic */ g(j jVar, String str, boolean z11) {
        this.f58033b = jVar;
        this.f58034c = str;
        this.f58035d = z11;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f58033b.t(this.f58034c, this.f58035d, (b) obj, (b) obj2);
    }
}
