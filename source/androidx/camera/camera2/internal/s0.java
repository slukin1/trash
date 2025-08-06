package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.Logger;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.h;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import o.l0;
import o.y;
import p.b;
import q.c;
import q.d;
import r.e;
import t.g;

public final class s0 implements CameraInfoInternal {

    /* renamed from: a  reason: collision with root package name */
    public final String f5297a;

    /* renamed from: b  reason: collision with root package name */
    public final y f5298b;

    /* renamed from: c  reason: collision with root package name */
    public final g f5299c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f5300d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public u f5301e;

    /* renamed from: f  reason: collision with root package name */
    public a<Integer> f5302f = null;

    /* renamed from: g  reason: collision with root package name */
    public a<ZoomState> f5303g = null;

    /* renamed from: h  reason: collision with root package name */
    public final a<CameraState> f5304h;

    /* renamed from: i  reason: collision with root package name */
    public List<Pair<CameraCaptureCallback, Executor>> f5305i = null;

    /* renamed from: j  reason: collision with root package name */
    public final Quirks f5306j;

    /* renamed from: k  reason: collision with root package name */
    public final EncoderProfilesProvider f5307k;

    /* renamed from: l  reason: collision with root package name */
    public final l0 f5308l;

    public static class a<T> extends MediatorLiveData<T> {

        /* renamed from: b  reason: collision with root package name */
        public LiveData<T> f5309b;

        /* renamed from: c  reason: collision with root package name */
        public final T f5310c;

        public a(T t11) {
            this.f5310c = t11;
        }

        public <S> void b(LiveData<S> liveData, z<? super S> zVar) {
            throw new UnsupportedOperationException();
        }

        public void d(LiveData<T> liveData) {
            LiveData<T> liveData2 = this.f5309b;
            if (liveData2 != null) {
                super.c(liveData2);
            }
            this.f5309b = liveData;
            super.b(liveData, new r0(this));
        }

        public T getValue() {
            LiveData<T> liveData = this.f5309b;
            return liveData == null ? this.f5310c : liveData.getValue();
        }
    }

    public s0(String str, l0 l0Var) throws CameraAccessExceptionCompat {
        String str2 = (String) h.g(str);
        this.f5297a = str2;
        this.f5308l = l0Var;
        y c11 = l0Var.c(str2);
        this.f5298b = c11;
        this.f5299c = new g(this);
        this.f5306j = c.a(str, c11);
        this.f5307k = new m1(str);
        this.f5304h = new a<>(CameraState.create(CameraState.Type.CLOSED));
    }

    public g a() {
        return this.f5299c;
    }

    public void addSessionCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        synchronized (this.f5300d) {
            u uVar = this.f5301e;
            if (uVar == null) {
                if (this.f5305i == null) {
                    this.f5305i = new ArrayList();
                }
                this.f5305i.add(new Pair(cameraCaptureCallback, executor));
                return;
            }
            uVar.l(executor, cameraCaptureCallback);
        }
    }

    public y b() {
        return this.f5298b;
    }

    public int c() {
        Integer num = (Integer) this.f5298b.a(CameraCharacteristics.SENSOR_ORIENTATION);
        h.g(num);
        return num.intValue();
    }

    public int d() {
        Integer num = (Integer) this.f5298b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        h.g(num);
        return num.intValue();
    }

    public void e(u uVar) {
        synchronized (this.f5300d) {
            this.f5301e = uVar;
            a<ZoomState> aVar = this.f5303g;
            if (aVar != null) {
                aVar.d(uVar.A().j());
            }
            a<Integer> aVar2 = this.f5302f;
            if (aVar2 != null) {
                aVar2.d(this.f5301e.y().f());
            }
            List<Pair<CameraCaptureCallback, Executor>> list = this.f5305i;
            if (list != null) {
                for (Pair next : list) {
                    this.f5301e.l((Executor) next.second, (CameraCaptureCallback) next.first);
                }
                this.f5305i = null;
            }
        }
        f();
    }

    public final void f() {
        g();
    }

    public final void g() {
        String str;
        int d11 = d();
        if (d11 == 0) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        } else if (d11 == 1) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        } else if (d11 == 2) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        } else if (d11 == 3) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        } else if (d11 != 4) {
            str = "Unknown value: " + d11;
        } else {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        }
        Logger.i("Camera2CameraInfo", "Device Level: " + str);
    }

    public String getCameraId() {
        return this.f5297a;
    }

    public Quirks getCameraQuirks() {
        return this.f5306j;
    }

    public /* synthetic */ CameraSelector getCameraSelector() {
        return i.a(this);
    }

    public LiveData<CameraState> getCameraState() {
        return this.f5304h;
    }

    public EncoderProfilesProvider getEncoderProfilesProvider() {
        return this.f5307k;
    }

    public ExposureState getExposureState() {
        synchronized (this.f5300d) {
            u uVar = this.f5301e;
            if (uVar == null) {
                ExposureState e11 = l2.e(this.f5298b);
                return e11;
            }
            ExposureState f11 = uVar.p().f();
            return f11;
        }
    }

    public /* synthetic */ CameraInfoInternal getImplementation() {
        return i.b(this);
    }

    public String getImplementationType() {
        return d() == 2 ? CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY : CameraInfo.IMPLEMENTATION_TYPE_CAMERA2;
    }

    public float getIntrinsicZoomRatio() {
        Integer num = (Integer) this.f5298b.a(CameraCharacteristics.LENS_FACING);
        if (num == null) {
            return 1.0f;
        }
        try {
            return ((float) y2.c(this.f5308l, num.intValue())) / ((float) y2.a(y2.b(this.f5298b), y2.d(this.f5298b)));
        } catch (Exception e11) {
            Logger.e("Camera2CameraInfo", "The camera is unable to provide necessary information to resolve its intrinsic zoom ratio with error: " + e11);
            return 1.0f;
        }
    }

    public int getLensFacing() {
        Integer num = (Integer) this.f5298b.a(CameraCharacteristics.LENS_FACING);
        h.b(num != null, "Unable to get the lens facing of the camera.");
        return b3.a(num.intValue());
    }

    public int getSensorRotationDegrees(int i11) {
        int c11 = c();
        int surfaceRotationToDegrees = CameraOrientationUtil.surfaceRotationToDegrees(i11);
        boolean z11 = true;
        if (1 != getLensFacing()) {
            z11 = false;
        }
        return CameraOrientationUtil.getRelativeImageRotation(surfaceRotationToDegrees, c11, z11);
    }

    public Set<DynamicRange> getSupportedDynamicRanges() {
        return b.a(this.f5298b).c();
    }

    public Set<Range<Integer>> getSupportedFrameRateRanges() {
        Range[] rangeArr = (Range[]) this.f5298b.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr != null) {
            return new HashSet(Arrays.asList(rangeArr));
        }
        return Collections.emptySet();
    }

    public List<Size> getSupportedHighResolutions(int i11) {
        Size[] a11 = this.f5298b.b().a(i11);
        return a11 != null ? Arrays.asList(a11) : Collections.emptyList();
    }

    public List<Size> getSupportedResolutions(int i11) {
        Size[] b11 = this.f5298b.b().b(i11);
        return b11 != null ? Arrays.asList(b11) : Collections.emptyList();
    }

    public Timebase getTimebase() {
        Integer num = (Integer) this.f5298b.a(CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE);
        h.g(num);
        if (num.intValue() != 1) {
            return Timebase.UPTIME;
        }
        return Timebase.REALTIME;
    }

    public LiveData<Integer> getTorchState() {
        synchronized (this.f5300d) {
            u uVar = this.f5301e;
            if (uVar == null) {
                if (this.f5302f == null) {
                    this.f5302f = new a<>(0);
                }
                a<Integer> aVar = this.f5302f;
                return aVar;
            }
            a<Integer> aVar2 = this.f5302f;
            if (aVar2 != null) {
                return aVar2;
            }
            LiveData<Integer> f11 = uVar.y().f();
            return f11;
        }
    }

    public LiveData<ZoomState> getZoomState() {
        synchronized (this.f5300d) {
            u uVar = this.f5301e;
            if (uVar == null) {
                if (this.f5303g == null) {
                    this.f5303g = new a<>(m4.h(this.f5298b));
                }
                a<ZoomState> aVar = this.f5303g;
                return aVar;
            }
            a<ZoomState> aVar2 = this.f5303g;
            if (aVar2 != null) {
                return aVar2;
            }
            LiveData<ZoomState> j11 = uVar.A().j();
            return j11;
        }
    }

    public void h(LiveData<CameraState> liveData) {
        this.f5304h.d(liveData);
    }

    public boolean hasFlashUnit() {
        y yVar = this.f5298b;
        Objects.requireNonNull(yVar);
        return e.a(new q0(yVar));
    }

    public boolean isFocusMeteringSupported(FocusMeteringAction focusMeteringAction) {
        synchronized (this.f5300d) {
            u uVar = this.f5301e;
            if (uVar == null) {
                return false;
            }
            boolean C = uVar.q().C(focusMeteringAction);
            return C;
        }
    }

    public boolean isPrivateReprocessingSupported() {
        return t4.a(this.f5298b, 4);
    }

    public boolean isZslSupported() {
        return Build.VERSION.SDK_INT >= 23 && isPrivateReprocessingSupported() && d.a(ZslDisablerQuirk.class) == null;
    }

    public void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        synchronized (this.f5300d) {
            u uVar = this.f5301e;
            if (uVar == null) {
                List<Pair<CameraCaptureCallback, Executor>> list = this.f5305i;
                if (list != null) {
                    Iterator<Pair<CameraCaptureCallback, Executor>> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().first == cameraCaptureCallback) {
                            it2.remove();
                        }
                    }
                    return;
                }
                return;
            }
            uVar.S(cameraCaptureCallback);
        }
    }

    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }
}
