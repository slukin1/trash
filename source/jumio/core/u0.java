package jumio.core;

import com.jumio.core.plugins.Plugin;
import com.jumio.core.util.ReflectionUtil;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jumio.core.e2;
import kotlin.Unit;

public final class u0 implements e2 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f56329a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final EnumMap<d2, Plugin> f56330b = new EnumMap<>(d2.class);

    public final <T extends Plugin> T a(d2 d2Var) {
        boolean z11;
        List<c2> list = d2Var.f56174b;
        if (!list.isEmpty() && !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!a((c2) it2.next())) {
                        z11 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z11 = true;
        T t11 = null;
        if (!z11) {
            return null;
        }
        synchronized (this.f56329a) {
            T t12 = (Plugin) this.f56330b.get(d2Var);
            if (t12 == null) {
                Class cls = ReflectionUtil.getClass(d2Var.f56173a);
                if (cls != null) {
                    try {
                        t12 = (Plugin) cls.newInstance();
                    } catch (Exception unused) {
                        t12 = null;
                    }
                    if (t12 != null) {
                        this.f56330b.put(d2Var, t12);
                    }
                }
            }
            t11 = t12;
        }
        return t11;
    }

    public final String b() {
        return e2.a.a(this);
    }

    public final List<String> c() {
        String str;
        d2[] values = d2.values();
        ArrayList arrayList = new ArrayList();
        int length = values.length;
        for (int i11 = 0; i11 < length; i11++) {
            d2 d2Var = values[i11];
            if (d2Var != d2.EMULATOR && b(d2Var)) {
                arrayList.add(d2Var);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            d2 d2Var2 = (d2) it2.next();
            if (d2Var2 == d2.BARCODE_NATIVE) {
                str = "BARCODE";
            } else {
                str = d2Var2.name();
            }
            arrayList2.add(str);
        }
        return CollectionsKt___CollectionsKt.S(arrayList2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        if (r5 != false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(jumio.core.d2 r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f56329a
            monitor-enter(r0)
            java.lang.String r1 = r5.f56173a     // Catch:{ all -> 0x003c }
            boolean r1 = com.jumio.core.util.ReflectionUtil.hasClass(r1)     // Catch:{ all -> 0x003c }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0039
            java.util.List<jumio.core.c2> r5 = r5.f56174b     // Catch:{ all -> 0x003c }
            boolean r1 = r5.isEmpty()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x0016
            goto L_0x0035
        L_0x0016:
            boolean r1 = r5.isEmpty()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x001d
            goto L_0x0035
        L_0x001d:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x003c }
        L_0x0021:
            boolean r1 = r5.hasNext()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x0035
            java.lang.Object r1 = r5.next()     // Catch:{ all -> 0x003c }
            jumio.core.c2 r1 = (jumio.core.c2) r1     // Catch:{ all -> 0x003c }
            boolean r1 = r4.a((jumio.core.c2) r1)     // Catch:{ all -> 0x003c }
            if (r1 != 0) goto L_0x0021
            r5 = r3
            goto L_0x0036
        L_0x0035:
            r5 = r2
        L_0x0036:
            if (r5 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r2 = r3
        L_0x003a:
            monitor-exit(r0)
            return r2
        L_0x003c:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.u0.b(jumio.core.d2):boolean");
    }

    public final boolean a(c2 c2Var) {
        boolean hasClass;
        synchronized (this.f56329a) {
            hasClass = ReflectionUtil.hasClass(c2Var.f56157a);
        }
        return hasClass;
    }

    public final void a() {
        synchronized (this.f56329a) {
            for (Map.Entry<d2, Plugin> value : this.f56330b.entrySet()) {
                ((Plugin) value.getValue()).unload();
            }
            this.f56330b.clear();
            Unit unit = Unit.f56620a;
        }
    }
}
