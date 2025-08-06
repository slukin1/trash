package jumio.core;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import com.jumio.core.util.ConcurrentMutableList;
import com.jumio.core.util.ConcurrentMutableListKt;
import java.util.UUID;

@PersistWith("AnalyticsModel")
public final class f implements StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public long f56183a;

    /* renamed from: b  reason: collision with root package name */
    public long f56184b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentMutableList f56185c = ConcurrentMutableListKt.concurrentMutableListOf();

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentMutableList f56186d = ConcurrentMutableListKt.concurrentMutableListOf();

    /* renamed from: e  reason: collision with root package name */
    public final UUID f56187e = UUID.randomUUID();

    /* renamed from: f  reason: collision with root package name */
    public int f56188f = 10;

    /* renamed from: g  reason: collision with root package name */
    public long f56189g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56190h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56191i = true;

    public final void a(long j11) {
        this.f56183a = j11;
    }

    public final void b(long j11) {
        this.f56184b = j11;
    }

    public final void c(long j11) {
        this.f56189g = j11;
    }

    public final void d() {
        this.f56190h = true;
    }

    public final UUID a() {
        return this.f56187e;
    }

    public final boolean b() {
        return this.f56190h;
    }

    public final boolean c() {
        return this.f56191i;
    }

    public final void a(int i11) {
        this.f56188f = i11;
    }

    public final void a(boolean z11) {
        this.f56191i = z11;
    }
}
