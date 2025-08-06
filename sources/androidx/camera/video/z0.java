package androidx.camera.video;

import androidx.camera.core.impl.utils.CloseGuardHelper;
import androidx.core.util.h;
import java.util.concurrent.atomic.AtomicBoolean;

public final class z0 implements AutoCloseable {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f6401b;

    /* renamed from: c  reason: collision with root package name */
    public final Recorder f6402c;

    /* renamed from: d  reason: collision with root package name */
    public final long f6403d;

    /* renamed from: e  reason: collision with root package name */
    public final t f6404e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f6405f;

    /* renamed from: g  reason: collision with root package name */
    public final CloseGuardHelper f6406g;

    public z0(Recorder recorder, long j11, t tVar, boolean z11, boolean z12) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f6401b = atomicBoolean;
        CloseGuardHelper create = CloseGuardHelper.create();
        this.f6406g = create;
        this.f6402c = recorder;
        this.f6403d = j11;
        this.f6404e = tVar;
        this.f6405f = z11;
        if (z12) {
            atomicBoolean.set(true);
        } else {
            create.open("stop");
        }
    }

    public static z0 a(u uVar, long j11) {
        h.h(uVar, "The given PendingRecording cannot be null.");
        return new z0(uVar.e(), j11, uVar.d(), uVar.g(), true);
    }

    public static z0 b(u uVar, long j11) {
        h.h(uVar, "The given PendingRecording cannot be null.");
        return new z0(uVar.e(), j11, uVar.d(), uVar.g(), false);
    }

    public void close() {
        j(0, (Throwable) null);
    }

    public t e() {
        return this.f6404e;
    }

    public long f() {
        return this.f6403d;
    }

    public void finalize() throws Throwable {
        try {
            this.f6406g.warnIfOpen();
            j(10, new RuntimeException("Recording stopped due to being garbage collected."));
        } finally {
            super.finalize();
        }
    }

    public void g() {
        close();
    }

    public final void j(int i11, Throwable th2) {
        this.f6406g.close();
        if (!this.f6401b.getAndSet(true)) {
            this.f6402c.z0(this, i11, th2);
        }
    }
}
