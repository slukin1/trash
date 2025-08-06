package androidx.camera.camera2.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Rational;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.u;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Quirks;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import r.h;

public class x2 {

    /* renamed from: v  reason: collision with root package name */
    public static final MeteringRectangle[] f5445v = new MeteringRectangle[0];

    /* renamed from: a  reason: collision with root package name */
    public final u f5446a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f5447b;

    /* renamed from: c  reason: collision with root package name */
    public final ScheduledExecutorService f5448c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5449d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile Rational f5450e = null;

    /* renamed from: f  reason: collision with root package name */
    public final h f5451f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5452g = false;

    /* renamed from: h  reason: collision with root package name */
    public Integer f5453h = 0;

    /* renamed from: i  reason: collision with root package name */
    public ScheduledFuture<?> f5454i;

    /* renamed from: j  reason: collision with root package name */
    public ScheduledFuture<?> f5455j;

    /* renamed from: k  reason: collision with root package name */
    public long f5456k = 0;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5457l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f5458m = false;

    /* renamed from: n  reason: collision with root package name */
    public int f5459n = 1;

    /* renamed from: o  reason: collision with root package name */
    public u.c f5460o = null;

    /* renamed from: p  reason: collision with root package name */
    public u.c f5461p = null;

    /* renamed from: q  reason: collision with root package name */
    public MeteringRectangle[] f5462q;

    /* renamed from: r  reason: collision with root package name */
    public MeteringRectangle[] f5463r;

    /* renamed from: s  reason: collision with root package name */
    public MeteringRectangle[] f5464s;

    /* renamed from: t  reason: collision with root package name */
    public CallbackToFutureAdapter.a<FocusMeteringResult> f5465t;

    /* renamed from: u  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f5466u;

    public class a extends CameraCaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackToFutureAdapter.a f5467a;

        public a(CallbackToFutureAdapter.a aVar) {
            this.f5467a = aVar;
        }

        public void onCaptureCancelled() {
            CallbackToFutureAdapter.a aVar = this.f5467a;
            if (aVar != null) {
                aVar.f(new CameraControl.OperationCanceledException("Camera is closed"));
            }
        }

        public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
            CallbackToFutureAdapter.a aVar = this.f5467a;
            if (aVar != null) {
                aVar.c(cameraCaptureResult);
            }
        }

        public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
            CallbackToFutureAdapter.a aVar = this.f5467a;
            if (aVar != null) {
                aVar.f(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
            }
        }
    }

    public class b extends CameraCaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackToFutureAdapter.a f5469a;

        public b(CallbackToFutureAdapter.a aVar) {
            this.f5469a = aVar;
        }

        public void onCaptureCancelled() {
            CallbackToFutureAdapter.a aVar = this.f5469a;
            if (aVar != null) {
                aVar.f(new CameraControl.OperationCanceledException("Camera is closed"));
            }
        }

        public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
            CallbackToFutureAdapter.a aVar = this.f5469a;
            if (aVar != null) {
                aVar.c(null);
            }
        }

        public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
            CallbackToFutureAdapter.a aVar = this.f5469a;
            if (aVar != null) {
                aVar.f(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
            }
        }
    }

    public x2(u uVar, ScheduledExecutorService scheduledExecutorService, Executor executor, Quirks quirks) {
        MeteringRectangle[] meteringRectangleArr = f5445v;
        this.f5462q = meteringRectangleArr;
        this.f5463r = meteringRectangleArr;
        this.f5464s = meteringRectangleArr;
        this.f5465t = null;
        this.f5466u = null;
        this.f5446a = uVar;
        this.f5447b = executor;
        this.f5448c = scheduledExecutorService;
        this.f5451f = new h(quirks);
    }

    public static boolean D(MeteringPoint meteringPoint) {
        return meteringPoint.getX() >= 0.0f && meteringPoint.getX() <= 1.0f && meteringPoint.getY() >= 0.0f && meteringPoint.getY() <= 1.0f;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object F(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5447b.execute(new v2(this, aVar));
        return "cancelFocusAndMetering";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean G(int i11, long j11, TotalCaptureResult totalCaptureResult) {
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)).intValue() != i11 || !u.F(totalCaptureResult, j11)) {
            return false;
        }
        r();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean H(boolean z11, long j11, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (S()) {
            if (!z11 || num == null) {
                this.f5458m = true;
                this.f5457l = true;
            } else if (this.f5453h.intValue() == 3) {
                if (num.intValue() == 4) {
                    this.f5458m = true;
                    this.f5457l = true;
                } else if (num.intValue() == 5) {
                    this.f5458m = false;
                    this.f5457l = true;
                }
            }
        }
        if (!this.f5457l || !u.F(totalCaptureResult, j11)) {
            if (!this.f5453h.equals(num) && num != null) {
                this.f5453h = num;
            }
            return false;
        }
        q(this.f5458m);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(long j11) {
        if (j11 == this.f5456k) {
            this.f5458m = false;
            q(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(long j11) {
        this.f5447b.execute(new r2(this, j11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(long j11) {
        if (j11 == this.f5456k) {
            o();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(long j11) {
        this.f5447b.execute(new u2(this, j11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object N(FocusMeteringAction focusMeteringAction, long j11, CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5447b.execute(new w2(this, aVar, focusMeteringAction, j11));
        return "startFocusAndMetering";
    }

    public static int O(int i11, int i12, int i13) {
        return Math.min(Math.max(i11, i13), i12);
    }

    public static PointF y(MeteringPoint meteringPoint, Rational rational, Rational rational2, int i11, h hVar) {
        if (meteringPoint.getSurfaceAspectRatio() != null) {
            rational2 = meteringPoint.getSurfaceAspectRatio();
        }
        PointF a11 = hVar.a(meteringPoint, i11);
        if (!rational2.equals(rational)) {
            if (rational2.compareTo(rational) > 0) {
                float doubleValue = (float) (rational2.doubleValue() / rational.doubleValue());
                a11.y = (((float) ((((double) doubleValue) - 1.0d) / 2.0d)) + a11.y) * (1.0f / doubleValue);
            } else {
                float doubleValue2 = (float) (rational.doubleValue() / rational2.doubleValue());
                a11.x = (((float) ((((double) doubleValue2) - 1.0d) / 2.0d)) + a11.x) * (1.0f / doubleValue2);
            }
        }
        return a11;
    }

    public static MeteringRectangle z(MeteringPoint meteringPoint, PointF pointF, Rect rect) {
        int width = (int) (((float) rect.left) + (pointF.x * ((float) rect.width())));
        int height = (int) (((float) rect.top) + (pointF.y * ((float) rect.height())));
        int size = ((int) (meteringPoint.getSize() * ((float) rect.width()))) / 2;
        int size2 = ((int) (meteringPoint.getSize() * ((float) rect.height()))) / 2;
        Rect rect2 = new Rect(width - size, height - size2, width + size, height + size2);
        rect2.left = O(rect2.left, rect.right, rect.left);
        rect2.right = O(rect2.right, rect.right, rect.left);
        rect2.top = O(rect2.top, rect.bottom, rect.top);
        rect2.bottom = O(rect2.bottom, rect.bottom, rect.top);
        return new MeteringRectangle(rect2, 1000);
    }

    public final List<MeteringRectangle> A(List<MeteringPoint> list, int i11, Rational rational, Rect rect, int i12) {
        if (list.isEmpty() || i11 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Rational rational2 = new Rational(rect.width(), rect.height());
        for (MeteringPoint next : list) {
            if (arrayList.size() == i11) {
                break;
            } else if (D(next)) {
                MeteringRectangle z11 = z(next, y(next, rational2, rational, i12, this.f5451f), rect);
                if (!(z11.getWidth() == 0 || z11.getHeight() == 0)) {
                    arrayList.add(z11);
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final boolean B() {
        return this.f5446a.w(1) == 1;
    }

    public boolean C(FocusMeteringAction focusMeteringAction) {
        Rect o11 = this.f5446a.o();
        Rational x11 = x();
        Rect rect = o11;
        return !A(focusMeteringAction.getMeteringPointsAf(), this.f5446a.s(), x11, rect, 1).isEmpty() || !A(focusMeteringAction.getMeteringPointsAe(), this.f5446a.r(), x11, rect, 2).isEmpty() || !A(focusMeteringAction.getMeteringPointsAwb(), this.f5446a.t(), x11, rect, 4).isEmpty();
    }

    public void P(boolean z11) {
        if (z11 != this.f5449d) {
            this.f5449d = z11;
            if (!this.f5449d) {
                o();
            }
        }
    }

    public void Q(Rational rational) {
        this.f5450e = rational;
    }

    public void R(int i11) {
        this.f5459n = i11;
    }

    public final boolean S() {
        return this.f5462q.length > 0;
    }

    public ListenableFuture<FocusMeteringResult> T(FocusMeteringAction focusMeteringAction) {
        return U(focusMeteringAction, 5000);
    }

    public ListenableFuture<FocusMeteringResult> U(FocusMeteringAction focusMeteringAction, long j11) {
        return CallbackToFutureAdapter.a(new q2(this, focusMeteringAction, j11));
    }

    /* renamed from: V */
    public void M(CallbackToFutureAdapter.a<FocusMeteringResult> aVar, FocusMeteringAction focusMeteringAction, long j11) {
        if (!this.f5449d) {
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        Rect o11 = this.f5446a.o();
        Rational x11 = x();
        Rational rational = x11;
        Rect rect = o11;
        List<MeteringRectangle> A = A(focusMeteringAction.getMeteringPointsAf(), this.f5446a.s(), rational, rect, 1);
        List<MeteringRectangle> A2 = A(focusMeteringAction.getMeteringPointsAe(), this.f5446a.r(), rational, rect, 2);
        List<MeteringRectangle> A3 = A(focusMeteringAction.getMeteringPointsAwb(), this.f5446a.t(), rational, rect, 4);
        if (!A.isEmpty() || !A2.isEmpty() || !A3.isEmpty()) {
            u("Cancelled by another startFocusAndMetering()");
            v("Cancelled by another startFocusAndMetering()");
            s();
            this.f5465t = aVar;
            MeteringRectangle[] meteringRectangleArr = f5445v;
            t((MeteringRectangle[]) A.toArray(meteringRectangleArr), (MeteringRectangle[]) A2.toArray(meteringRectangleArr), (MeteringRectangle[]) A3.toArray(meteringRectangleArr), focusMeteringAction, j11);
            return;
        }
        aVar.f(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera."));
    }

    public void W(CallbackToFutureAdapter.a<Void> aVar) {
        if (this.f5449d) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.f5459n);
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.c(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            builder.addImplementationOptions(builder2.build());
            builder.addCameraCaptureCallback(new b(aVar));
            this.f5446a.X(Collections.singletonList(builder.build()));
        } else if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
        }
    }

    public void X(CallbackToFutureAdapter.a<CameraCaptureResult> aVar, boolean z11) {
        if (this.f5449d) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.f5459n);
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.c(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            if (z11) {
                builder2.c(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(this.f5446a.v(1)));
            }
            builder.addImplementationOptions(builder2.build());
            builder.addCameraCaptureCallback(new a(aVar));
            this.f5446a.X(Collections.singletonList(builder.build()));
        } else if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
        }
    }

    public void k(Camera2ImplConfig.Builder builder) {
        int i11;
        if (this.f5452g) {
            i11 = 1;
        } else {
            i11 = w();
        }
        builder.c(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.f5446a.w(i11)));
        MeteringRectangle[] meteringRectangleArr = this.f5462q;
        if (meteringRectangleArr.length != 0) {
            builder.c(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
        }
        MeteringRectangle[] meteringRectangleArr2 = this.f5463r;
        if (meteringRectangleArr2.length != 0) {
            builder.c(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
        }
        MeteringRectangle[] meteringRectangleArr3 = this.f5464s;
        if (meteringRectangleArr3.length != 0) {
            builder.c(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr3);
        }
    }

    public void l(boolean z11, boolean z12) {
        if (this.f5449d) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setUseRepeatingSurface(true);
            builder.setTemplateType(this.f5459n);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            if (z11) {
                builder2.c(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            }
            if (Build.VERSION.SDK_INT >= 23 && z12) {
                builder2.c(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
            }
            builder.addImplementationOptions(builder2.build());
            this.f5446a.X(Collections.singletonList(builder.build()));
        }
    }

    public ListenableFuture<Void> m() {
        return CallbackToFutureAdapter.a(new p2(this));
    }

    /* renamed from: n */
    public void E(CallbackToFutureAdapter.a<Void> aVar) {
        v("Cancelled by another cancelFocusAndMetering()");
        u("Cancelled by cancelFocusAndMetering()");
        this.f5466u = aVar;
        s();
        p();
        if (S()) {
            l(true, false);
        }
        MeteringRectangle[] meteringRectangleArr = f5445v;
        this.f5462q = meteringRectangleArr;
        this.f5463r = meteringRectangleArr;
        this.f5464s = meteringRectangleArr;
        this.f5452g = false;
        long a02 = this.f5446a.a0();
        if (this.f5466u != null) {
            n2 n2Var = new n2(this, this.f5446a.w(w()), a02);
            this.f5461p = n2Var;
            this.f5446a.k(n2Var);
        }
    }

    public void o() {
        E((CallbackToFutureAdapter.a<Void>) null);
    }

    public final void p() {
        ScheduledFuture<?> scheduledFuture = this.f5455j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f5455j = null;
        }
    }

    public void q(boolean z11) {
        p();
        CallbackToFutureAdapter.a<FocusMeteringResult> aVar = this.f5465t;
        if (aVar != null) {
            aVar.c(FocusMeteringResult.create(z11));
            this.f5465t = null;
        }
    }

    public final void r() {
        CallbackToFutureAdapter.a<Void> aVar = this.f5466u;
        if (aVar != null) {
            aVar.c(null);
            this.f5466u = null;
        }
    }

    public final void s() {
        ScheduledFuture<?> scheduledFuture = this.f5454i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f5454i = null;
        }
    }

    public final void t(MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, MeteringRectangle[] meteringRectangleArr3, FocusMeteringAction focusMeteringAction, long j11) {
        long j12;
        this.f5446a.R(this.f5460o);
        s();
        p();
        this.f5462q = meteringRectangleArr;
        this.f5463r = meteringRectangleArr2;
        this.f5464s = meteringRectangleArr3;
        if (S()) {
            this.f5452g = true;
            this.f5457l = false;
            this.f5458m = false;
            j12 = this.f5446a.a0();
            X((CallbackToFutureAdapter.a<CameraCaptureResult>) null, true);
        } else {
            this.f5452g = false;
            this.f5457l = true;
            this.f5458m = false;
            j12 = this.f5446a.a0();
        }
        this.f5453h = 0;
        o2 o2Var = new o2(this, B(), j12);
        this.f5460o = o2Var;
        this.f5446a.k(o2Var);
        long j13 = this.f5456k + 1;
        this.f5456k = j13;
        s2 s2Var = new s2(this, j13);
        ScheduledExecutorService scheduledExecutorService = this.f5448c;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f5455j = scheduledExecutorService.schedule(s2Var, j11, timeUnit);
        if (focusMeteringAction.isAutoCancelEnabled()) {
            this.f5454i = this.f5448c.schedule(new t2(this, j13), focusMeteringAction.getAutoCancelDurationInMillis(), timeUnit);
        }
    }

    public final void u(String str) {
        this.f5446a.R(this.f5460o);
        CallbackToFutureAdapter.a<FocusMeteringResult> aVar = this.f5465t;
        if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException(str));
            this.f5465t = null;
        }
    }

    public final void v(String str) {
        this.f5446a.R(this.f5461p);
        CallbackToFutureAdapter.a<Void> aVar = this.f5466u;
        if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException(str));
            this.f5466u = null;
        }
    }

    public int w() {
        return this.f5459n != 3 ? 4 : 3;
    }

    public final Rational x() {
        if (this.f5450e != null) {
            return this.f5450e;
        }
        Rect o11 = this.f5446a.o();
        return new Rational(o11.width(), o11.height());
    }
}
