package cn.sharesdk.framework.authorize;

import android.app.Activity;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f13414a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f13415b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13416c;

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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static cn.sharesdk.framework.authorize.a c() {
        /*
            java.lang.Class<cn.sharesdk.framework.authorize.a> r0 = cn.sharesdk.framework.authorize.a.class
            monitor-enter(r0)
            cn.sharesdk.framework.authorize.a r1 = f13414a     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            cn.sharesdk.framework.authorize.a r1 = f13414a     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            cn.sharesdk.framework.authorize.a r1 = new cn.sharesdk.framework.authorize.a     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            f13414a = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            cn.sharesdk.framework.authorize.a r0 = f13414a
            return r0
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.authorize.a.c():cn.sharesdk.framework.authorize.a");
    }

    public boolean a() {
        return this.f13416c;
    }

    public Activity b() {
        return this.f13415b;
    }

    public void a(boolean z11) {
        this.f13416c = z11;
    }

    public void a(Activity activity) {
        this.f13415b = activity;
    }
}
