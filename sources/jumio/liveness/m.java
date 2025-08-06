package jumio.liveness;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.TypeIntrinsics;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final Object f56490a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f56491b = new ArrayList();

    public final void a(j jVar) {
        synchronized (this.f56490a) {
            this.f56491b.add(jVar);
        }
    }

    public final j a(long j11) {
        Object obj;
        j jVar;
        boolean z11;
        synchronized (this.f56490a) {
            Iterator it2 = this.f56491b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((j) obj).f56481a == j11) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            TypeIntrinsics.a(this.f56491b).remove((j) obj);
            jVar = (j) obj;
        }
        return jVar;
    }

    public final void a() {
        synchronized (this.f56490a) {
            this.f56491b.clear();
            Unit unit = Unit.f56620a;
        }
    }
}
