package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.b;
import o.d;

public final class c4 extends SynchronizedCaptureSession.StateCallback {

    /* renamed from: a  reason: collision with root package name */
    public final List<SynchronizedCaptureSession.StateCallback> f5041a;

    public c4(List<SynchronizedCaptureSession.StateCallback> list) {
        ArrayList arrayList = new ArrayList();
        this.f5041a = arrayList;
        arrayList.addAll(list);
    }

    public static SynchronizedCaptureSession.StateCallback t(SynchronizedCaptureSession.StateCallback... stateCallbackArr) {
        return new c4(Arrays.asList(stateCallbackArr));
    }

    public void a(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback a11 : this.f5041a) {
            a11.a(synchronizedCaptureSession);
        }
    }

    public void m(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback m11 : this.f5041a) {
            m11.m(synchronizedCaptureSession);
        }
    }

    public void n(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback n11 : this.f5041a) {
            n11.n(synchronizedCaptureSession);
        }
    }

    public void o(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback o11 : this.f5041a) {
            o11.o(synchronizedCaptureSession);
        }
    }

    public void p(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback p11 : this.f5041a) {
            p11.p(synchronizedCaptureSession);
        }
    }

    public void q(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback q11 : this.f5041a) {
            q11.q(synchronizedCaptureSession);
        }
    }

    public void r(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback r11 : this.f5041a) {
            r11.r(synchronizedCaptureSession);
        }
    }

    public void s(SynchronizedCaptureSession synchronizedCaptureSession, Surface surface) {
        for (SynchronizedCaptureSession.StateCallback s11 : this.f5041a) {
            s11.s(synchronizedCaptureSession, surface);
        }
    }

    public static class a extends SynchronizedCaptureSession.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        public final CameraCaptureSession.StateCallback f5042a;

        public a(CameraCaptureSession.StateCallback stateCallback) {
            this.f5042a = stateCallback;
        }

        public void a(SynchronizedCaptureSession synchronizedCaptureSession) {
            this.f5042a.onActive(synchronizedCaptureSession.f().c());
        }

        public void m(SynchronizedCaptureSession synchronizedCaptureSession) {
            d.b(this.f5042a, synchronizedCaptureSession.f().c());
        }

        public void n(SynchronizedCaptureSession synchronizedCaptureSession) {
            this.f5042a.onClosed(synchronizedCaptureSession.f().c());
        }

        public void o(SynchronizedCaptureSession synchronizedCaptureSession) {
            this.f5042a.onConfigureFailed(synchronizedCaptureSession.f().c());
        }

        public void p(SynchronizedCaptureSession synchronizedCaptureSession) {
            this.f5042a.onConfigured(synchronizedCaptureSession.f().c());
        }

        public void q(SynchronizedCaptureSession synchronizedCaptureSession) {
            this.f5042a.onReady(synchronizedCaptureSession.f().c());
        }

        public void r(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void s(SynchronizedCaptureSession synchronizedCaptureSession, Surface surface) {
            b.a(this.f5042a, synchronizedCaptureSession.f().c(), surface);
        }

        public a(List<CameraCaptureSession.StateCallback> list) {
            this(r1.a(list));
        }
    }
}
