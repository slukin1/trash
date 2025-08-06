package x9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Handler;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class d {

    /* renamed from: k  reason: collision with root package name */
    public static SparseArray<d> f76804k = new SparseArray<>();

    /* renamed from: a  reason: collision with root package name */
    public AnimatorSet f76805a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f76806b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f76807c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public Handler f76808d = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public long f76809e = 400;

    /* renamed from: f  reason: collision with root package name */
    public long f76810f = 400;

    /* renamed from: g  reason: collision with root package name */
    public int f76811g;

    /* renamed from: h  reason: collision with root package name */
    public int f76812h = 3;

    /* renamed from: i  reason: collision with root package name */
    public Animator.AnimatorListener f76813i = new a();

    /* renamed from: j  reason: collision with root package name */
    public Runnable f76814j = new a(this);

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            d.f(d.this);
            long j11 = 0;
            if (d.this.f76811g == d.this.f76812h) {
                int unused = d.this.f76811g = 0;
                j11 = 0 + d.this.f76810f;
            }
            if (d.this.f76806b) {
                d.this.f76808d.postDelayed(d.this.f76814j, j11);
            }
        }
    }

    public interface b {
        List<Animator> a(int i11);
    }

    public static /* synthetic */ int f(d dVar) {
        int i11 = dVar.f76811g;
        dVar.f76811g = i11 + 1;
        return i11;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized x9.d m(int r3) {
        /*
            java.lang.Class<x9.d> r0 = x9.d.class
            monitor-enter(r0)
            monitor-enter(r0)     // Catch:{ all -> 0x001e }
            android.util.SparseArray<x9.d> r1 = f76804k     // Catch:{ all -> 0x001b }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x001b }
            x9.d r1 = (x9.d) r1     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0018
            x9.d r1 = new x9.d     // Catch:{ all -> 0x001b }
            r1.<init>()     // Catch:{ all -> 0x001b }
            android.util.SparseArray<x9.d> r2 = f76804k     // Catch:{ all -> 0x001b }
            r2.put(r3, r1)     // Catch:{ all -> 0x001b }
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)
            return r1
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r3     // Catch:{ all -> 0x001e }
        L_0x001e:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: x9.d.m(int):x9.d");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(b bVar) {
        if (!this.f76807c.contains(bVar)) {
            this.f76807c.add(bVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o() {
        List<Animator> a11;
        i6.d.b("ShimmerAnimatorManager-->looping");
        if (!this.f76807c.isEmpty()) {
            try {
                ArrayList arrayList = new ArrayList();
                for (b next : this.f76807c) {
                    if (!(next == null || (a11 = next.a(this.f76811g)) == null || a11.isEmpty())) {
                        arrayList.addAll(a11);
                    }
                }
                if (!arrayList.isEmpty()) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.f76805a = animatorSet;
                    animatorSet.addListener(this.f76813i);
                    this.f76805a.setDuration(this.f76809e);
                    this.f76805a.playTogether(arrayList);
                    this.f76805a.start();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(b bVar) {
        if (this.f76807c.contains(bVar)) {
            this.f76807c.remove(bVar);
        }
    }

    public void l(b bVar) {
        this.f76808d.post(new b(this, bVar));
    }

    public void q(b bVar) {
        this.f76808d.post(new c(this, bVar));
    }

    public void r(int i11) {
        this.f76812h = i11;
    }

    public void s() {
        if (!this.f76806b) {
            this.f76806b = true;
            this.f76808d.removeCallbacks(this.f76814j);
            this.f76808d.postDelayed(this.f76814j, this.f76810f);
        }
    }

    public void t() {
        this.f76806b = false;
        this.f76808d.removeCallbacksAndMessages((Object) null);
        AnimatorSet animatorSet = this.f76805a;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f76805a = null;
        }
        this.f76811g = 0;
    }
}
