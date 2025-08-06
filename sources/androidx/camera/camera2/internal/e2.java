package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class e2 {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f5085a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5086b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final Set<SynchronizedCaptureSession> f5087c = new LinkedHashSet();

    /* renamed from: d  reason: collision with root package name */
    public final Set<SynchronizedCaptureSession> f5088d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    public final Set<SynchronizedCaptureSession> f5089e = new LinkedHashSet();

    /* renamed from: f  reason: collision with root package name */
    public final CameraDevice.StateCallback f5090f = new a();

    public class a extends CameraDevice.StateCallback {
        public a() {
        }

        public final void b() {
            List<SynchronizedCaptureSession> g11;
            synchronized (e2.this.f5086b) {
                g11 = e2.this.g();
                e2.this.f5089e.clear();
                e2.this.f5087c.clear();
                e2.this.f5088d.clear();
            }
            for (SynchronizedCaptureSession h11 : g11) {
                h11.h();
            }
        }

        public final void c() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            synchronized (e2.this.f5086b) {
                linkedHashSet.addAll(e2.this.f5089e);
                linkedHashSet.addAll(e2.this.f5087c);
            }
            e2.this.f5085a.execute(new d2(linkedHashSet));
        }

        public void onClosed(CameraDevice cameraDevice) {
            b();
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            c();
            b();
        }

        public void onError(CameraDevice cameraDevice, int i11) {
            c();
            b();
        }

        public void onOpened(CameraDevice cameraDevice) {
        }
    }

    public e2(Executor executor) {
        this.f5085a = executor;
    }

    public static void b(Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession next : set) {
            next.b().n(next);
        }
    }

    public final void a(SynchronizedCaptureSession synchronizedCaptureSession) {
        SynchronizedCaptureSession next;
        Iterator<SynchronizedCaptureSession> it2 = g().iterator();
        while (it2.hasNext() && (next = it2.next()) != synchronizedCaptureSession) {
            next.h();
        }
    }

    public CameraDevice.StateCallback c() {
        return this.f5090f;
    }

    public List<SynchronizedCaptureSession> d() {
        ArrayList arrayList;
        synchronized (this.f5086b) {
            arrayList = new ArrayList(this.f5087c);
        }
        return arrayList;
    }

    public List<SynchronizedCaptureSession> e() {
        ArrayList arrayList;
        synchronized (this.f5086b) {
            arrayList = new ArrayList(this.f5088d);
        }
        return arrayList;
    }

    public List<SynchronizedCaptureSession> f() {
        ArrayList arrayList;
        synchronized (this.f5086b) {
            arrayList = new ArrayList(this.f5089e);
        }
        return arrayList;
    }

    public List<SynchronizedCaptureSession> g() {
        ArrayList arrayList;
        synchronized (this.f5086b) {
            arrayList = new ArrayList();
            arrayList.addAll(d());
            arrayList.addAll(f());
        }
        return arrayList;
    }

    public void h(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.f5086b) {
            this.f5087c.remove(synchronizedCaptureSession);
            this.f5088d.remove(synchronizedCaptureSession);
        }
    }

    public void i(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.f5086b) {
            this.f5088d.add(synchronizedCaptureSession);
        }
    }

    public void j(SynchronizedCaptureSession synchronizedCaptureSession) {
        a(synchronizedCaptureSession);
        synchronized (this.f5086b) {
            this.f5089e.remove(synchronizedCaptureSession);
        }
    }

    public void k(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.f5086b) {
            this.f5087c.add(synchronizedCaptureSession);
            this.f5089e.remove(synchronizedCaptureSession);
        }
        a(synchronizedCaptureSession);
    }

    public void l(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.f5086b) {
            this.f5089e.add(synchronizedCaptureSession);
        }
    }
}
