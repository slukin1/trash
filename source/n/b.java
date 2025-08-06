package n;

import androidx.camera.camera2.impl.CameraEventCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.MultiValueSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class b extends MultiValueSet<CameraEventCallback> {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<CameraEventCallback> f16152a = new ArrayList();

        public a(List<CameraEventCallback> list) {
            for (CameraEventCallback add : list) {
                this.f16152a.add(add);
            }
        }

        public void a() {
            for (CameraEventCallback a11 : this.f16152a) {
                a11.a();
            }
        }

        public List<CaptureConfig> b() {
            ArrayList arrayList = new ArrayList();
            for (CameraEventCallback b11 : this.f16152a) {
                CaptureConfig b12 = b11.b();
                if (b12 != null) {
                    arrayList.add(b12);
                }
            }
            return arrayList;
        }

        public List<CaptureConfig> c() {
            ArrayList arrayList = new ArrayList();
            for (CameraEventCallback c11 : this.f16152a) {
                CaptureConfig c12 = c11.c();
                if (c12 != null) {
                    arrayList.add(c12);
                }
            }
            return arrayList;
        }

        public List<CaptureConfig> d() {
            ArrayList arrayList = new ArrayList();
            for (CameraEventCallback d11 : this.f16152a) {
                CaptureConfig d12 = d11.d();
                if (d12 != null) {
                    arrayList.add(d12);
                }
            }
            return arrayList;
        }

        public List<CaptureConfig> e() {
            ArrayList arrayList = new ArrayList();
            for (CameraEventCallback e11 : this.f16152a) {
                CaptureConfig e12 = e11.e();
                if (e12 != null) {
                    arrayList.add(e12);
                }
            }
            return arrayList;
        }
    }

    public b(CameraEventCallback... cameraEventCallbackArr) {
        addAll(Arrays.asList(cameraEventCallbackArr));
    }

    public static b b() {
        return new b(new CameraEventCallback[0]);
    }

    public a a() {
        return new a(getAllItems());
    }

    public MultiValueSet<CameraEventCallback> clone() {
        b b11 = b();
        b11.addAll(getAllItems());
        return b11;
    }
}
