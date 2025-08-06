package jumio.liveness;

import com.jumio.commons.log.Log;
import com.jumio.core.image.ImageStoreInterface;
import com.jumio.core.models.LivenessSettingsModel;
import com.jumio.liveness.image.LivenessImageData;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.x;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final LivenessSettingsModel f56492a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageStoreInterface f56493b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f56494c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Object f56495d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashMap<t, List<k>> f56496e = new LinkedHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final Object f56497f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f56498g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final Object f56499h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public boolean f56500i;

    /* renamed from: j  reason: collision with root package name */
    public Long f56501j;

    public o(LivenessSettingsModel livenessSettingsModel, ImageStoreInterface imageStoreInterface) {
        this.f56492a = livenessSettingsModel;
        this.f56493b = imageStoreInterface;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0073, code lost:
        return false;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x004b=Splitter:B:23:0x004b, B:30:0x005c=Splitter:B:30:0x005c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(jumio.liveness.k r9, jumio.liveness.t r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f56495d
            monitor-enter(r0)
            int r1 = r10.ordinal()     // Catch:{ all -> 0x0075 }
            r2 = 1
            if (r1 == 0) goto L_0x005c
            if (r1 == r2) goto L_0x0013
            r3 = 2
            if (r1 == r3) goto L_0x005c
            r3 = 3
            if (r1 == r3) goto L_0x0013
            goto L_0x0072
        L_0x0013:
            jumio.liveness.j r1 = r9.f56486a     // Catch:{ all -> 0x0075 }
            long r3 = r1.f56481a     // Catch:{ all -> 0x0075 }
            boolean r1 = r8.f56500i     // Catch:{ all -> 0x0075 }
            if (r1 != 0) goto L_0x001e
            r8.b((long) r3)     // Catch:{ all -> 0x0075 }
        L_0x001e:
            boolean r1 = r8.a((long) r3)     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0055
            r8.c()     // Catch:{ all -> 0x0075 }
            int r1 = r8.b((jumio.liveness.t) r10)     // Catch:{ all -> 0x0075 }
            java.util.ArrayList r5 = r8.f56494c     // Catch:{ all -> 0x0075 }
            int r5 = r5.size()     // Catch:{ all -> 0x0075 }
            if (r5 < r1) goto L_0x004b
            java.util.ArrayList r5 = r8.f56494c     // Catch:{ all -> 0x0075 }
            com.jumio.core.models.LivenessSettingsModel r6 = r8.f56492a     // Catch:{ all -> 0x0075 }
            long r6 = r6.getMaxConsecutiveImageTimespanInMs()     // Catch:{ all -> 0x0075 }
            jumio.liveness.p.a((java.util.ArrayList) r5, (int) r1, (long) r6)     // Catch:{ all -> 0x0075 }
            java.util.ArrayList r5 = r8.f56494c     // Catch:{ all -> 0x0075 }
            int r5 = r5.size()     // Catch:{ all -> 0x0075 }
            if (r5 < r1) goto L_0x004b
            r8.a((jumio.liveness.t) r10)     // Catch:{ all -> 0x0075 }
            monitor-exit(r0)
            return r2
        L_0x004b:
            r8.b()     // Catch:{ all -> 0x0075 }
            boolean r10 = r8.f56500i     // Catch:{ all -> 0x0075 }
            if (r10 != 0) goto L_0x0055
            r8.b((long) r3)     // Catch:{ all -> 0x0075 }
        L_0x0055:
            java.util.ArrayList r10 = r8.f56494c     // Catch:{ all -> 0x0075 }
            r10.add(r9)     // Catch:{ all -> 0x0075 }
            monitor-exit(r0)
            return r2
        L_0x005c:
            java.util.ArrayList r1 = r8.f56494c     // Catch:{ all -> 0x0075 }
            r1.add(r9)     // Catch:{ all -> 0x0075 }
            java.util.ArrayList r9 = r8.f56494c     // Catch:{ all -> 0x0075 }
            int r9 = r9.size()     // Catch:{ all -> 0x0075 }
            int r1 = r8.b((jumio.liveness.t) r10)     // Catch:{ all -> 0x0075 }
            if (r9 != r1) goto L_0x0072
            r8.a((jumio.liveness.t) r10)     // Catch:{ all -> 0x0075 }
            monitor-exit(r0)
            return r2
        L_0x0072:
            monitor-exit(r0)
            r9 = 0
            return r9
        L_0x0075:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.liveness.o.a(jumio.liveness.k, jumio.liveness.t):boolean");
    }

    public final void b() {
        synchronized (this.f56495d) {
            Log.d("LivenessRecorder", "Resetting the current snapshot");
            c();
            Iterator it2 = this.f56494c.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                if (!a(kVar.b())) {
                    long f11 = kVar.b().f();
                    Log.d("LivenessRecorder", "Discarding frame " + f11 + " as it is not stored");
                    kVar.a();
                }
            }
            this.f56494c.clear();
            Unit unit = Unit.f56620a;
        }
    }

    public final boolean c(t tVar) {
        boolean z11;
        boolean z12;
        synchronized (this.f56497f) {
            List list = this.f56496e.get(tVar);
            z11 = false;
            if (list != null) {
                if (!list.isEmpty()) {
                    z12 = false;
                    if (!z12 && list.size() == b(tVar)) {
                        z11 = true;
                    }
                }
            }
            z12 = true;
            z11 = true;
        }
        return z11;
    }

    public final void c() {
        synchronized (this.f56495d) {
            this.f56500i = false;
            this.f56501j = null;
            Unit unit = Unit.f56620a;
        }
    }

    public final int b(t tVar) {
        int ordinal = tVar.ordinal();
        if (ordinal == 0) {
            return this.f56492a.getInitialImages();
        }
        if (ordinal == 1) {
            return this.f56492a.getNearImages();
        }
        if (ordinal == 2) {
            return this.f56492a.getTransitionImages();
        }
        if (ordinal == 3) {
            return this.f56492a.getFarImages();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void b(long j11) {
        synchronized (this.f56495d) {
            this.f56500i = true;
            Long valueOf = Long.valueOf(j11);
            this.f56501j = valueOf;
            Log.i("LivenessRecorder", "Starting the recording of Liveness images at " + valueOf);
            Unit unit = Unit.f56620a;
        }
    }

    public final int a() {
        int size;
        synchronized (this.f56495d) {
            size = this.f56494c.size();
        }
        return size;
    }

    public static void a(o oVar) {
        oVar.b();
        synchronized (oVar.f56497f) {
            for (t tVar : t.values()) {
                List<k> list = oVar.f56496e.get(tVar);
                if (list != null) {
                    for (k a11 : list) {
                        a11.a();
                    }
                }
                oVar.f56496e.remove(tVar);
            }
            Unit unit = Unit.f56620a;
        }
        synchronized (oVar.f56499h) {
            List unused = CollectionsKt___CollectionsKt.B0(oVar.f56498g, oVar.b(t.INITIAL));
            oVar.f56498g.clear();
        }
    }

    public final boolean a(long j11) {
        boolean z11 = false;
        if (!this.f56500i) {
            return false;
        }
        Long l11 = this.f56501j;
        if (l11 != null && j11 - l11.longValue() > this.f56492a.getMinTimePerDistanceInMs()) {
            z11 = true;
        }
        if (z11) {
            int size = this.f56494c.size();
            Log.i("LivenessRecorder", "Finished recording of Liveness images with total " + size);
        }
        return z11;
    }

    public final void a(t tVar) {
        synchronized (this.f56495d) {
            List<k> I0 = CollectionsKt___CollectionsKt.I0(this.f56494c);
            int size = I0.size();
            Log.d("LivenessRecorder", "SNAPSHOT size for " + tVar + l.f34627b + size);
            synchronized (this.f56499h) {
                for (k kVar : I0) {
                    LivenessImageData livenessImageData = new LivenessImageData();
                    p.a(livenessImageData, kVar.c(), this.f56492a);
                    this.f56493b.add(livenessImageData, kVar.b().c(), kVar.b().e(), kVar.b().d(), kVar.b().b());
                    this.f56498g.add(livenessImageData);
                }
                Unit unit = Unit.f56620a;
            }
            synchronized (this.f56497f) {
                this.f56496e.put(tVar, I0);
            }
            b();
        }
    }

    public final boolean a(j jVar) {
        boolean z11;
        synchronized (this.f56497f) {
            List w11 = CollectionsKt__IterablesKt.w(this.f56496e.values());
            if (!(w11 instanceof Collection) || !w11.isEmpty()) {
                Iterator it2 = w11.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (x.b(((k) it2.next()).f56486a, jVar)) {
                            z11 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z11 = false;
        }
        return z11;
    }
}
