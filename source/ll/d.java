package ll;

import java.util.Comparator;
import ml.b;

public final /* synthetic */ class d implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58027b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58028c;

    public /* synthetic */ d(String str, boolean z11) {
        this.f58027b = str;
        this.f58028c = z11;
    }

    public final int compare(Object obj, Object obj2) {
        return j.v(this.f58027b, this.f58028c, (b) obj, (b) obj2);
    }
}
