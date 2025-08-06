package p;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final c f16277a;

    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final List<f> f16280a;

        /* renamed from: b  reason: collision with root package name */
        public final CameraCaptureSession.StateCallback f16281b;

        /* renamed from: c  reason: collision with root package name */
        public final Executor f16282c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16283d;

        /* renamed from: e  reason: collision with root package name */
        public e f16284e = null;

        /* renamed from: f  reason: collision with root package name */
        public CaptureRequest f16285f = null;

        public b(int i11, List<f> list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this.f16283d = i11;
            this.f16280a = Collections.unmodifiableList(new ArrayList(list));
            this.f16281b = stateCallback;
            this.f16282c = executor;
        }

        public e a() {
            return this.f16284e;
        }

        public CameraCaptureSession.StateCallback b() {
            return this.f16281b;
        }

        public Executor c() {
            return this.f16282c;
        }

        public List<f> d() {
            return this.f16280a;
        }

        public void e(e eVar) {
            if (this.f16283d != 1) {
                this.f16284e = eVar;
                return;
            }
            throw new UnsupportedOperationException("Method not supported for high speed session types");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (Objects.equals(this.f16284e, bVar.f16284e) && this.f16283d == bVar.f16283d && this.f16280a.size() == bVar.f16280a.size()) {
                    for (int i11 = 0; i11 < this.f16280a.size(); i11++) {
                        if (!this.f16280a.get(i11).equals(bVar.f16280a.get(i11))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public Object f() {
            return null;
        }

        public int g() {
            return this.f16283d;
        }

        public void h(CaptureRequest captureRequest) {
            this.f16285f = captureRequest;
        }

        public int hashCode() {
            int i11;
            int hashCode = this.f16280a.hashCode() ^ 31;
            int i12 = (hashCode << 5) - hashCode;
            e eVar = this.f16284e;
            if (eVar == null) {
                i11 = 0;
            } else {
                i11 = eVar.hashCode();
            }
            int i13 = i11 ^ i12;
            return this.f16283d ^ ((i13 << 5) - i13);
        }
    }

    public interface c {
        e a();

        CameraCaptureSession.StateCallback b();

        Executor c();

        List<f> d();

        void e(e eVar);

        Object f();

        int g();

        void h(CaptureRequest captureRequest);
    }

    public l(int i11, List<f> list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        if (Build.VERSION.SDK_INT < 28) {
            this.f16277a = new b(i11, list, executor, stateCallback);
        } else {
            this.f16277a = new a(i11, list, executor, stateCallback);
        }
    }

    public static List<OutputConfiguration> h(List<f> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (f h11 : list) {
            arrayList.add((OutputConfiguration) h11.h());
        }
        return arrayList;
    }

    public static List<f> i(List<OutputConfiguration> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (OutputConfiguration i11 : list) {
            arrayList.add(f.i(i11));
        }
        return arrayList;
    }

    public Executor a() {
        return this.f16277a.c();
    }

    public e b() {
        return this.f16277a.a();
    }

    public List<f> c() {
        return this.f16277a.d();
    }

    public int d() {
        return this.f16277a.g();
    }

    public CameraCaptureSession.StateCallback e() {
        return this.f16277a.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        return this.f16277a.equals(((l) obj).f16277a);
    }

    public void f(e eVar) {
        this.f16277a.e(eVar);
    }

    public void g(CaptureRequest captureRequest) {
        this.f16277a.h(captureRequest);
    }

    public int hashCode() {
        return this.f16277a.hashCode();
    }

    public Object j() {
        return this.f16277a.f();
    }

    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final SessionConfiguration f16278a;

        /* renamed from: b  reason: collision with root package name */
        public final List<f> f16279b;

        public a(Object obj) {
            SessionConfiguration sessionConfiguration = (SessionConfiguration) obj;
            this.f16278a = sessionConfiguration;
            this.f16279b = Collections.unmodifiableList(l.i(sessionConfiguration.getOutputConfigurations()));
        }

        public e a() {
            return e.b(this.f16278a.getInputConfiguration());
        }

        public CameraCaptureSession.StateCallback b() {
            return this.f16278a.getStateCallback();
        }

        public Executor c() {
            return this.f16278a.getExecutor();
        }

        public List<f> d() {
            return this.f16279b;
        }

        public void e(e eVar) {
            this.f16278a.setInputConfiguration((InputConfiguration) eVar.a());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            return Objects.equals(this.f16278a, ((a) obj).f16278a);
        }

        public Object f() {
            return this.f16278a;
        }

        public int g() {
            return this.f16278a.getSessionType();
        }

        public void h(CaptureRequest captureRequest) {
            this.f16278a.setSessionParameters(captureRequest);
        }

        public int hashCode() {
            return this.f16278a.hashCode();
        }

        public a(int i11, List<f> list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this(new SessionConfiguration(i11, l.h(list), executor, stateCallback));
        }
    }
}
