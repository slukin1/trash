package s6;

import android.content.Context;
import k7.c;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f69034b;

    /* renamed from: a  reason: collision with root package name */
    public c f69035a;

    public a(Context context) {
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized s6.a b(android.content.Context r2) {
        /*
            java.lang.Class<s6.a> r0 = s6.a.class
            monitor-enter(r0)
            if (r2 == 0) goto L_0x001a
            s6.a r1 = f69034b     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x001a
            monitor-enter(r0)     // Catch:{ all -> 0x001e }
            s6.a r1 = f69034b     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x0015
            s6.a r1 = new s6.a     // Catch:{ all -> 0x0017 }
            r1.<init>(r2)     // Catch:{ all -> 0x0017 }
            f69034b = r1     // Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            goto L_0x001a
        L_0x0017:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r2     // Catch:{ all -> 0x001e }
        L_0x001a:
            s6.a r2 = f69034b     // Catch:{ all -> 0x001e }
            monitor-exit(r0)
            return r2
        L_0x001e:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.a.b(android.content.Context):s6.a");
    }

    public static void d() {
        c a11;
        a b11 = b((Context) null);
        if (b11 != null && (a11 = b11.a()) != null) {
            a11.release();
        }
    }

    public c a() {
        return this.f69035a;
    }

    public void c(int i11) {
        c cVar = this.f69035a;
        if (cVar != null) {
            cVar.g(i11);
        }
    }
}
