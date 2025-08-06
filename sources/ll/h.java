package ll;

import java.util.Comparator;
import ml.b;

public final /* synthetic */ class h implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f58036b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58037c;

    public /* synthetic */ h(j jVar, boolean z11) {
        this.f58036b = jVar;
        this.f58037c = z11;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f58036b.u(this.f58037c, (b) obj, (b) obj2);
    }
}
