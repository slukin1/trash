package androidx.camera.video;

import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.ResolutionValidatedEncoderProfilesProvider;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.v;
import androidx.core.util.h;
import d0.b;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import y.c;
import y.e;

public final class y0 implements c1 {

    /* renamed from: b  reason: collision with root package name */
    public final EncoderProfilesProvider f6393b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<DynamicRange, a> f6394c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<DynamicRange, a> f6395d = new HashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<v, VideoValidatedEncoderProfilesProxy> f6396a = new LinkedHashMap();

        /* renamed from: b  reason: collision with root package name */
        public final TreeMap<Size, v> f6397b = new TreeMap<>(new CompareSizesByArea());

        /* renamed from: c  reason: collision with root package name */
        public final VideoValidatedEncoderProfilesProxy f6398c;

        /* renamed from: d  reason: collision with root package name */
        public final VideoValidatedEncoderProfilesProxy f6399d;

        public a(EncoderProfilesProvider encoderProfilesProvider) {
            for (v next : v.b()) {
                EncoderProfilesProxy d11 = d(next, encoderProfilesProvider);
                if (d11 != null) {
                    Logger.d("RecorderVideoCapabilities", "profiles = " + d11);
                    VideoValidatedEncoderProfilesProxy g11 = g(d11);
                    if (g11 == null) {
                        Logger.w("RecorderVideoCapabilities", "EncoderProfiles of quality " + next + " has no video validated profiles.");
                    } else {
                        EncoderProfilesProxy.VideoProfileProxy d12 = g11.d();
                        this.f6397b.put(new Size(d12.getWidth(), d12.getHeight()), next);
                        this.f6396a.put(next, g11);
                    }
                }
            }
            if (this.f6396a.isEmpty()) {
                Logger.e("RecorderVideoCapabilities", "No supported EncoderProfiles");
                this.f6399d = null;
                this.f6398c = null;
                return;
            }
            ArrayDeque arrayDeque = new ArrayDeque(this.f6396a.values());
            this.f6398c = (VideoValidatedEncoderProfilesProxy) arrayDeque.peekFirst();
            this.f6399d = (VideoValidatedEncoderProfilesProxy) arrayDeque.peekLast();
        }

        public static void a(v vVar) {
            boolean a11 = v.a(vVar);
            h.b(a11, "Unknown quality: " + vVar);
        }

        public VideoValidatedEncoderProfilesProxy b(Size size) {
            v c11 = c(size);
            Logger.d("RecorderVideoCapabilities", "Using supported quality of " + c11 + " for size " + size);
            if (c11 == v.f6371g) {
                return null;
            }
            VideoValidatedEncoderProfilesProxy e11 = e(c11);
            if (e11 != null) {
                return e11;
            }
            throw new AssertionError("Camera advertised available quality but did not produce EncoderProfiles for advertised quality.");
        }

        public v c(Size size) {
            Map.Entry<Size, v> ceilingEntry = this.f6397b.ceilingEntry(size);
            if (ceilingEntry != null) {
                return ceilingEntry.getValue();
            }
            Map.Entry<Size, v> floorEntry = this.f6397b.floorEntry(size);
            if (floorEntry != null) {
                return floorEntry.getValue();
            }
            return v.f6371g;
        }

        public final EncoderProfilesProxy d(v vVar, EncoderProfilesProvider encoderProfilesProvider) {
            h.j(vVar instanceof v.b, "Currently only support ConstantQuality");
            return encoderProfilesProvider.getAll(((v.b) vVar).d());
        }

        public VideoValidatedEncoderProfilesProxy e(v vVar) {
            a(vVar);
            if (vVar == v.f6370f) {
                return this.f6398c;
            }
            if (vVar == v.f6369e) {
                return this.f6399d;
            }
            return this.f6396a.get(vVar);
        }

        public List<v> f() {
            return new ArrayList(this.f6396a.keySet());
        }

        public final VideoValidatedEncoderProfilesProxy g(EncoderProfilesProxy encoderProfilesProxy) {
            if (encoderProfilesProxy.getVideoProfiles().isEmpty()) {
                return null;
            }
            return VideoValidatedEncoderProfilesProxy.b(encoderProfilesProxy);
        }
    }

    public y0(CameraInfoInternal cameraInfoInternal, Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> function) {
        EncoderProfilesProvider encoderProfilesProvider = cameraInfoInternal.getEncoderProfilesProvider();
        this.f6393b = new b(new ResolutionValidatedEncoderProfilesProvider(m(cameraInfoInternal) ? new c(encoderProfilesProvider, function) : encoderProfilesProvider, cameraInfoInternal.getCameraQuirks()), cameraInfoInternal, a0.a.b());
        for (DynamicRange next : cameraInfoInternal.getSupportedDynamicRanges()) {
            a aVar = new a(new e(this.f6393b, next));
            if (!aVar.f().isEmpty()) {
                this.f6394c.put(next, aVar);
            }
        }
    }

    public static boolean e(DynamicRange dynamicRange, DynamicRange dynamicRange2) {
        h.j(l(dynamicRange2), "Fully specified range is not actually fully specified.");
        if (dynamicRange.getBitDepth() == 0 || dynamicRange.getBitDepth() == dynamicRange2.getBitDepth()) {
            return true;
        }
        return false;
    }

    public static boolean f(DynamicRange dynamicRange, DynamicRange dynamicRange2) {
        h.j(l(dynamicRange2), "Fully specified range is not actually fully specified.");
        int encoding = dynamicRange.getEncoding();
        if (encoding == 0) {
            return true;
        }
        int encoding2 = dynamicRange2.getEncoding();
        if ((encoding != 2 || encoding2 == 1) && encoding != encoding2) {
            return false;
        }
        return true;
    }

    public static boolean g(DynamicRange dynamicRange, Set<DynamicRange> set) {
        if (l(dynamicRange)) {
            return set.contains(dynamicRange);
        }
        for (DynamicRange next : set) {
            if (e(dynamicRange, next) && f(dynamicRange, next)) {
                return true;
            }
        }
        return false;
    }

    public static y0 h(CameraInfo cameraInfo) {
        return new y0((CameraInfoInternal) cameraInfo, c.f16785d);
    }

    public static boolean l(DynamicRange dynamicRange) {
        return (dynamicRange.getEncoding() == 0 || dynamicRange.getEncoding() == 2 || dynamicRange.getBitDepth() == 0) ? false : true;
    }

    public static boolean m(CameraInfoInternal cameraInfoInternal) {
        for (DynamicRange next : cameraInfoInternal.getSupportedDynamicRanges()) {
            Integer valueOf = Integer.valueOf(next.getEncoding());
            int bitDepth = next.getBitDepth();
            if (valueOf.equals(3) && bitDepth == 10) {
                return true;
            }
        }
        return false;
    }

    public v a(Size size, DynamicRange dynamicRange) {
        a j11 = j(dynamicRange);
        return j11 == null ? v.f6371g : j11.c(size);
    }

    public VideoValidatedEncoderProfilesProxy b(Size size, DynamicRange dynamicRange) {
        a j11 = j(dynamicRange);
        if (j11 == null) {
            return null;
        }
        return j11.b(size);
    }

    public List<v> c(DynamicRange dynamicRange) {
        a j11 = j(dynamicRange);
        return j11 == null ? new ArrayList() : j11.f();
    }

    public VideoValidatedEncoderProfilesProxy d(v vVar, DynamicRange dynamicRange) {
        a j11 = j(dynamicRange);
        if (j11 == null) {
            return null;
        }
        return j11.e(vVar);
    }

    public final a i(DynamicRange dynamicRange) {
        if (!g(dynamicRange, k())) {
            return null;
        }
        return new a(new e(this.f6393b, dynamicRange));
    }

    public final a j(DynamicRange dynamicRange) {
        if (l(dynamicRange)) {
            return this.f6394c.get(dynamicRange);
        }
        if (this.f6395d.containsKey(dynamicRange)) {
            return this.f6395d.get(dynamicRange);
        }
        a i11 = i(dynamicRange);
        this.f6395d.put(dynamicRange, i11);
        return i11;
    }

    public Set<DynamicRange> k() {
        return this.f6394c.keySet();
    }
}
