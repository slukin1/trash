package com.tencent.liteav.videoproducer.capture.b;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Range;
import android.view.Surface;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.g;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.v;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CameraEventCallback;
import com.tencent.liteav.videoproducer.capture.b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class a extends CameraControllerInterface {

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, CameraCharacteristics> f22561b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f22562c;

    /* renamed from: d  reason: collision with root package name */
    private static String f22563d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f22564e = "";
    private CameraEventCallback A;
    private float B = 0.0f;
    private float C = 0.0f;
    private final CameraDevice.StateCallback D = new CameraDevice.StateCallback() {
        private void a(CameraDevice cameraDevice, int i11) {
            if (a.this.f22568h.get()) {
                a.this.f22567g.a(b.a(a.this, i11));
            } else {
                a.this.a(false, cameraDevice);
            }
        }

        public final void onClosed(CameraDevice cameraDevice) {
            LiteavLog.i("Camera2Controller", "CameraDevice onClosed!" + a(cameraDevice));
        }

        public final void onDisconnected(CameraDevice cameraDevice) {
            LiteavLog.e("Camera2Controller", "CameraDevice onDisconnected!" + a(cameraDevice));
            a(cameraDevice, 1);
        }

        public final void onError(CameraDevice cameraDevice, int i11) {
            LiteavLog.e("Camera2Controller", "CameraDevice onError!" + a(cameraDevice) + ", error:" + i11);
            int i12 = 4;
            if (i11 == 3) {
                i12 = 2;
            } else if (i11 == 1) {
                i12 = 1;
            } else if (i11 == 5) {
                i12 = 3;
            } else if (i11 != 4) {
                i12 = 0;
            }
            a(cameraDevice, i12);
        }

        public final void onOpened(CameraDevice cameraDevice) {
            LiteavLog.i("Camera2Controller", "CameraDevice onOpen!" + a(cameraDevice));
            a.this.a(true, cameraDevice);
        }

        private static String a(CameraDevice cameraDevice) {
            if (cameraDevice == null) {
                return OptionsBridge.NULL_VALUE;
            }
            return "CameraDevice[id:" + cameraDevice.getId() + "]";
        }
    };
    private final CameraCaptureSession.StateCallback E = new CameraCaptureSession.StateCallback() {
        public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            LiteavLog.e("Camera2Controller", "CameraCaptureSession onConfigureFailed!");
            a.this.a(false, cameraCaptureSession);
        }

        public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
            LiteavLog.i("Camera2Controller", "CameraCaptureSession onConfigured!");
            a.this.a(true, cameraCaptureSession);
        }
    };
    private final CameraManager.AvailabilityCallback F = new CameraManager.AvailabilityCallback() {
        public final void onCameraAccessPrioritiesChanged() {
            super.onCameraAccessPrioritiesChanged();
        }

        public final void onCameraAvailable(String str) {
            super.onCameraAvailable(str);
            LiteavLog.i("Camera2Controller", "onCameraAvailable: ".concat(String.valueOf(str)));
            if (!a.this.f() && a.b(a.this.f22579s).equals(str) && a.this.f22568h.get()) {
                LiteavLog.w("Camera2Controller", "Current camera is available, it could be interrupted by system app.");
                a aVar = a.this;
                aVar.a(false, (CameraDevice) aVar.f22569i.get());
                a.this.f22567g.a(b.a(a.this, 1));
            }
        }

        public final void onCameraUnavailable(String str) {
            super.onCameraUnavailable(str);
            LiteavLog.i("Camera2Controller", "onCameraUnavailable: ".concat(String.valueOf(str)));
        }
    };
    private final CameraCaptureSession.CaptureCallback G = new CameraCaptureSession.CaptureCallback() {
        private static boolean a(CaptureRequest captureRequest) {
            return (captureRequest.getTag() instanceof a) && !((a) captureRequest.getTag()).f22565a;
        }

        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a.this.f22567g.a(c.a(this, totalCaptureResult, captureRequest));
        }

        public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            LiteavLog.e("Camera2Controller", "onCaptureFailed failure reason:" + captureFailure.getReason());
            a.this.f22567g.a(d.a(this, captureRequest));
        }

        public final void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        }

        private void a(CaptureRequest captureRequest, boolean z11) {
            if (!a.this.f()) {
                boolean unused = a.this.f22584x = false;
                try {
                    a.this.f22573m.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    a.this.f22573m.set(CaptureRequest.CONTROL_AE_MODE, 1);
                    a.this.f22573m.set(CaptureRequest.CONTROL_AF_MODE, 3);
                    a.this.d();
                    if (captureRequest.getTag() instanceof a) {
                        a.a((a) captureRequest.getTag(), z11);
                    }
                } catch (Throwable th2) {
                    LiteavLog.e("Camera2Controller", "mAfCaptureCallback exception:".concat(String.valueOf(th2)));
                }
            }
        }

        public static /* synthetic */ void a(AnonymousClass4 r12, CaptureRequest captureRequest) {
            if (!a(captureRequest)) {
                boolean unused = a.this.f22584x = false;
            } else {
                r12.a(captureRequest, false);
            }
        }

        public static /* synthetic */ void a(AnonymousClass4 r22, TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
            if (!a(captureRequest)) {
                boolean unused = a.this.f22584x = false;
                return;
            }
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (num == null) {
                LiteavLog.e("Camera2Controller", "handleCaptureCompleted get afState fail");
                r22.a(captureRequest, false);
            } else if (4 == num.intValue() || 5 == num.intValue()) {
                r22.a(captureRequest, true);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public boolean f22565a = false;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f22566f = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final v f22567g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f22568h = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final AtomicReference<CameraDevice> f22569i = new AtomicReference<>();

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f22570j = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private final AtomicReference<CameraCaptureSession> f22571k = new AtomicReference<>();

    /* renamed from: l  reason: collision with root package name */
    private CaptureRequest f22572l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public CaptureRequest.Builder f22573m;

    /* renamed from: n  reason: collision with root package name */
    private Size f22574n;

    /* renamed from: o  reason: collision with root package name */
    private k f22575o = k.NORMAL;

    /* renamed from: p  reason: collision with root package name */
    private k f22576p = null;

    /* renamed from: q  reason: collision with root package name */
    private boolean f22577q = true;

    /* renamed from: r  reason: collision with root package name */
    private SurfaceTexture f22578r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f22579s = true;

    /* renamed from: t  reason: collision with root package name */
    private boolean f22580t = true;

    /* renamed from: u  reason: collision with root package name */
    private boolean f22581u = true;

    /* renamed from: v  reason: collision with root package name */
    private int f22582v = -1;

    /* renamed from: w  reason: collision with root package name */
    private C0176a f22583w = C0176a.IDLE;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f22584x = false;

    /* renamed from: y  reason: collision with root package name */
    private CountDownLatch f22585y;

    /* renamed from: z  reason: collision with root package name */
    private CountDownLatch f22586z;

    /* renamed from: com.tencent.liteav.videoproducer.capture.b.a$a  reason: collision with other inner class name */
    public enum C0176a {
        IDLE,
        PREVIEWING
    }

    public a(v vVar) {
        this.f22567g = vVar;
    }

    public final void enableCameraFpsCorrectionLogic(boolean z11) {
        this.f22577q = z11;
        LiteavLog.i("Camera2Controller", "set enable camera fps correction logic value is: ".concat(String.valueOf(z11)));
    }

    public final void enableTapToFocus(boolean z11) {
        this.f22580t = z11;
        if (!this.f22584x) {
            c(z11);
            d();
        }
    }

    public final k getCameraSystemRotation() {
        return this.f22575o;
    }

    public final int getCameraSystemRotationValue() {
        return this.f22575o.mValue;
    }

    public final int getMaxZoom() {
        return 100;
    }

    public final Size getPreviewSize() {
        return this.f22574n;
    }

    public final boolean isCameraAutoFocusFaceModeSupported() {
        return a() != null && ((Integer) a().get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue() > 0;
    }

    public final boolean isCameraFocusPositionInPreviewSupported() {
        return a() != null && ((Integer) a().get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
    }

    public final boolean isCurrentPreviewSizeAspectRatioMatch(int i11, int i12, boolean z11) {
        k kVar = this.f22576p;
        if (kVar == null) {
            kVar = this.f22575o;
        }
        Size a11 = b.a(e(), kVar, i11, i12);
        boolean z12 = false;
        boolean z13 = a11.getArea() <= this.f22574n.getArea();
        if (!z11 || Math.abs(a11.aspectRatio() - this.f22574n.aspectRatio()) <= 0.001d) {
            z12 = z13;
        }
        LiteavLog.i("Camera2Controller", "isCurrentPreviewSizeAspectRatioMatch:".concat(String.valueOf(z12)));
        return z12;
    }

    public final boolean isTorchSupported() {
        return a() != null && ((Boolean) a().get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue();
    }

    public final boolean isZoomSupported() {
        return a() != null && ((Float) a().get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() > 0.0f;
    }

    public final void setCameraRotationCorrectionValue(int i11) {
        this.f22576p = k.b(i11) ? k.a(i11) : null;
        LiteavLog.i("Camera2Controller", "camera rotation correction is " + this.f22576p);
    }

    public final void setExposureCompensation(float f11) {
        this.B = f11;
        b(f11);
        d();
    }

    public final void setZoom(float f11) {
        this.C = f11;
        a(f11);
        d();
    }

    public final void startAutoFocusAtPosition(int i11, int i12) {
        double d11;
        double d12;
        int i13 = i11;
        int i14 = i12;
        if (this.f22580t && this.f22581u) {
            if (f() || this.f22584x) {
                LiteavLog.e("Camera2Controller", "autoFocus not preview, mCameraStatus:" + this.f22583w + " mIsAutoFocusing:" + this.f22584x);
                return;
            }
            CameraCaptureSession cameraCaptureSession = this.f22571k.get();
            if (cameraCaptureSession == null) {
                LiteavLog.e("Camera2Controller", "CameraCaptureSession get fail");
                return;
            }
            if (i13 >= 0) {
                Size size = this.f22574n;
                if (i13 < size.width && i14 >= 0 && i14 < size.height) {
                    LiteavLog.i("Camera2Controller", "Start auto focus at (%d, %d)", Integer.valueOf(i11), Integer.valueOf(i12));
                    double d13 = (double) i13;
                    double d14 = (double) i14;
                    Rect rect = (Rect) this.f22572l.get(CaptureRequest.SCALER_CROP_REGION);
                    if (rect == null) {
                        LiteavLog.e("Camera2Controller", "getMeteringRect can't get crop region");
                        rect = (Rect) a().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                    }
                    int width = rect.width();
                    int height = rect.height();
                    Size size2 = this.f22574n;
                    int i15 = size2.height;
                    int i16 = i15 * width;
                    int i17 = size2.width;
                    double d15 = 0.0d;
                    if (i16 > i17 * height) {
                        d11 = (((double) height) * 1.0d) / ((double) i15);
                        d12 = 0.0d;
                        d15 = (((double) width) - (((double) i17) * d11)) / 2.0d;
                    } else {
                        d11 = (((double) width) * 1.0d) / ((double) i17);
                        d12 = (((double) height) - (((double) i15) * d11)) / 2.0d;
                    }
                    double d16 = (d13 * d11) + d15 + ((double) rect.left);
                    double d17 = (d14 * d11) + d12 + ((double) rect.top);
                    Rect rect2 = new Rect();
                    rect2.left = g.a((int) (d16 - (((double) rect.width()) * 0.05d)), 0, rect.width());
                    rect2.right = g.a((int) (d16 + (((double) rect.width()) * 0.05d)), 0, rect.width());
                    rect2.top = g.a((int) (d17 - (((double) rect.height()) * 0.05d)), 0, rect.height());
                    rect2.bottom = g.a((int) (d17 + (((double) rect.height()) * 0.05d)), 0, rect.height());
                    try {
                        this.f22573m.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
                        this.f22573m.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
                        this.f22573m.set(CaptureRequest.CONTROL_AF_MODE, 1);
                        this.f22573m.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                        this.f22573m.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
                        this.f22584x = true;
                        this.f22565a = false;
                        this.f22573m.setTag(this);
                        cameraCaptureSession.setRepeatingRequest(this.f22573m.build(), this.G, this.f22566f);
                        return;
                    } catch (Throwable th2) {
                        LiteavLog.e("Camera2Controller", "startAutoFocusAtPosition exception:".concat(String.valueOf(th2)));
                        return;
                    }
                }
            }
            LiteavLog.w("Camera2Controller", "Start auto focus at (%d, %d) invalid ", Integer.valueOf(i11), Integer.valueOf(i12));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean startCapture(com.tencent.liteav.videoproducer.capture.CameraCaptureParams r13, android.graphics.SurfaceTexture r14, com.tencent.liteav.videoproducer.capture.CameraEventCallback r15) {
        /*
            r12 = this;
            java.lang.String r0 = "1"
            r12.A = r15
            boolean r15 = f22562c
            java.lang.String r1 = "camera"
            r2 = 1
            r3 = 0
            java.lang.String r4 = "Camera2Controller"
            if (r15 != 0) goto L_0x008e
            android.content.Context r15 = com.tencent.liteav.base.ContextUtils.getApplicationContext()     // Catch:{ all -> 0x007c }
            java.lang.Object r15 = r15.getSystemService(r1)     // Catch:{ all -> 0x007c }
            android.hardware.camera2.CameraManager r15 = (android.hardware.camera2.CameraManager) r15     // Catch:{ all -> 0x007c }
            java.lang.String[] r5 = r15.getCameraIdList()     // Catch:{ all -> 0x007c }
            int r6 = r5.length     // Catch:{ all -> 0x007c }
            r7 = r3
        L_0x001e:
            if (r7 >= r6) goto L_0x005e
            r8 = r5[r7]     // Catch:{ all -> 0x007c }
            android.hardware.camera2.CameraCharacteristics r9 = r15.getCameraCharacteristics(r8)     // Catch:{ all -> 0x007c }
            android.hardware.camera2.CameraCharacteristics$Key r10 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ all -> 0x007c }
            java.lang.Object r10 = r9.get(r10)     // Catch:{ all -> 0x007c }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x007c }
            if (r10 == 0) goto L_0x0044
            int r11 = r10.intValue()     // Catch:{ all -> 0x007c }
            if (r11 != 0) goto L_0x0044
            boolean r11 = r0.equals(r8)     // Catch:{ all -> 0x007c }
            if (r11 == 0) goto L_0x0044
            java.util.HashMap<java.lang.String, android.hardware.camera2.CameraCharacteristics> r10 = f22561b     // Catch:{ all -> 0x007c }
            r10.put(r8, r9)     // Catch:{ all -> 0x007c }
            f22564e = r8     // Catch:{ all -> 0x007c }
            goto L_0x005b
        L_0x0044:
            if (r10 == 0) goto L_0x005b
            int r10 = r10.intValue()     // Catch:{ all -> 0x007c }
            if (r10 != r2) goto L_0x005b
            java.lang.String r10 = "0"
            boolean r10 = r10.equals(r8)     // Catch:{ all -> 0x007c }
            if (r10 == 0) goto L_0x005b
            java.util.HashMap<java.lang.String, android.hardware.camera2.CameraCharacteristics> r10 = f22561b     // Catch:{ all -> 0x007c }
            r10.put(r8, r9)     // Catch:{ all -> 0x007c }
            f22563d = r8     // Catch:{ all -> 0x007c }
        L_0x005b:
            int r7 = r7 + 1
            goto L_0x001e
        L_0x005e:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "initCamera2Ability front:"
            r15.<init>(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = f22564e     // Catch:{ all -> 0x007c }
            r15.append(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = ", back:"
            r15.append(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = f22563d     // Catch:{ all -> 0x007c }
            r15.append(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x007c }
            com.tencent.liteav.base.util.LiteavLog.i(r4, r15)     // Catch:{ all -> 0x007c }
            goto L_0x008c
        L_0x007c:
            r15 = move-exception
            f22564e = r0
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "initCamera2Ability exception!"
            java.lang.String r15 = r0.concat(r15)
            com.tencent.liteav.base.util.LiteavLog.e(r4, r15)
        L_0x008c:
            f22562c = r2
        L_0x008e:
            if (r13 == 0) goto L_0x01b4
            if (r14 != 0) goto L_0x0094
            goto L_0x01b4
        L_0x0094:
            com.tencent.liteav.videoproducer.capture.b.a$a r15 = r12.f22583w
            com.tencent.liteav.videoproducer.capture.b.a$a r0 = com.tencent.liteav.videoproducer.capture.b.a.C0176a.IDLE
            if (r15 == r0) goto L_0x00a0
            java.lang.String r13 = "it's capturing, you should Stop first."
            com.tencent.liteav.base.util.LiteavLog.e(r4, r13)
            return r3
        L_0x00a0:
            r12.f22578r = r14
            java.lang.Boolean r15 = r13.f22518a
            boolean r15 = r15.booleanValue()
            r12.f22579s = r15
            android.hardware.camera2.CameraCharacteristics r15 = r12.a()
            if (r15 != 0) goto L_0x00b2
        L_0x00b0:
            r15 = r3
            goto L_0x00eb
        L_0x00b2:
            android.hardware.camera2.CameraCharacteristics r15 = r12.a()
            android.hardware.camera2.CameraCharacteristics$Key r5 = android.hardware.camera2.CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES
            java.lang.Object r15 = r15.get(r5)
            int[] r15 = (int[]) r15
            int r5 = r15.length
            if (r5 == 0) goto L_0x00cb
            int r5 = r15.length
            if (r5 != r2) goto L_0x00c9
            r15 = r15[r3]
            if (r15 != 0) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r15 = r2
            goto L_0x00eb
        L_0x00cb:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r5 = "Current "
            r15.<init>(r5)
            boolean r5 = r12.f22579s
            if (r5 == 0) goto L_0x00d9
            java.lang.String r5 = "front camera "
            goto L_0x00db
        L_0x00d9:
            java.lang.String r5 = "back camera "
        L_0x00db:
            r15.append(r5)
            java.lang.String r5 = " is not support auto focus."
            r15.append(r5)
            java.lang.String r15 = r15.toString()
            com.tencent.liteav.base.util.LiteavLog.w(r4, r15)
            goto L_0x00b0
        L_0x00eb:
            r12.f22581u = r15
            android.content.Context r15 = com.tencent.liteav.base.ContextUtils.getApplicationContext()
            java.lang.Object r15 = r15.getSystemService(r1)
            android.hardware.camera2.CameraManager r15 = (android.hardware.camera2.CameraManager) r15
            android.hardware.camera2.CameraManager$AvailabilityCallback r1 = r12.F
            android.os.Handler r5 = r12.f22566f
            r15.registerAvailabilityCallback(r1, r5)
            int r15 = r13.f22525c
            int r1 = r13.f22526d
            boolean r15 = r12.a((int) r15, (int) r1)
            if (r15 != 0) goto L_0x0113
            java.lang.String r13 = "openCamera failed."
            com.tencent.liteav.base.util.LiteavLog.e(r4, r13)
            r12.c()
            r12.f22583w = r0
            return r3
        L_0x0113:
            boolean r14 = r12.a((android.graphics.SurfaceTexture) r14)
            if (r14 != 0) goto L_0x0124
            java.lang.String r13 = "startPreview failed."
            com.tencent.liteav.base.util.LiteavLog.e(r4, r13)
            r12.b()
            r12.f22583w = r0
            return r3
        L_0x0124:
            android.hardware.camera2.CaptureRequest$Builder r14 = r12.f22573m
            android.hardware.camera2.CaptureRequest$Key r15 = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            r14.set(r15, r0)
            int r13 = r13.f22524b
            java.lang.String r14 = java.lang.String.valueOf(r13)
            java.lang.String r15 = "preferred fps: "
            java.lang.String r14 = r15.concat(r14)
            com.tencent.liteav.base.util.LiteavLog.i(r4, r14)
            android.util.Range r14 = new android.util.Range
            java.lang.Integer r15 = java.lang.Integer.valueOf(r13)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            r14.<init>(r15, r0)
            android.hardware.camera2.CameraCharacteristics r15 = r12.a()
            if (r15 != 0) goto L_0x0157
            java.lang.String r13 = "camera characteristics is null"
            com.tencent.liteav.base.util.LiteavLog.e(r4, r13)
            goto L_0x017c
        L_0x0157:
            android.hardware.camera2.CameraCharacteristics$Key r0 = android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES
            java.lang.Object r15 = r15.get(r0)
            android.util.Range[] r15 = (android.util.Range[]) r15
            com.tencent.liteav.videoproducer.a.a[] r15 = a((android.util.Range<java.lang.Integer>[]) r15)
            boolean r0 = r12.f22577q
            com.tencent.liteav.videoproducer.a.a r13 = com.tencent.liteav.videoproducer.capture.b.a(r15, r13, r0)
            if (r13 == 0) goto L_0x017c
            android.util.Range r14 = new android.util.Range
            int r15 = r13.f22516a
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            int r13 = r13.f22517b
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r14.<init>(r15, r13)
        L_0x017c:
            java.lang.String r13 = java.lang.String.valueOf(r14)
            java.lang.String r15 = "get best matched fps range result is "
            java.lang.String r13 = r15.concat(r13)
            com.tencent.liteav.base.util.LiteavLog.i(r4, r13)
            android.hardware.camera2.CaptureRequest$Builder r13 = r12.f22573m
            android.hardware.camera2.CaptureRequest$Key r15 = android.hardware.camera2.CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE
            r13.set(r15, r14)
            boolean r13 = r12.f22580t
            r12.c((boolean) r13)
            float r13 = r12.C
            r12.a((float) r13)
            float r13 = r12.B
            r12.b((float) r13)
            android.hardware.camera2.CaptureRequest$Builder r13 = r12.f22573m
            android.hardware.camera2.CaptureRequest r13 = r13.build()
            r12.f22572l = r13
            r12.d()
            com.tencent.liteav.videoproducer.capture.b.a$a r13 = com.tencent.liteav.videoproducer.capture.b.a.C0176a.PREVIEWING
            r12.f22583w = r13
            java.lang.String r13 = "startCaptureInternal ok."
            com.tencent.liteav.base.util.LiteavLog.i(r4, r13)
            return r2
        L_0x01b4:
            java.lang.String r13 = "captureParams or surfaceTexture is null"
            com.tencent.liteav.base.util.LiteavLog.e(r4, r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.b.a.startCapture(com.tencent.liteav.videoproducer.capture.CameraCaptureParams, android.graphics.SurfaceTexture, com.tencent.liteav.videoproducer.capture.CameraEventCallback):boolean");
    }

    public final void stopCapture() {
        CountDownLatch countDownLatch = this.f22585y;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        this.f22585y = null;
        CountDownLatch countDownLatch2 = this.f22586z;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
        this.f22586z = null;
        b();
        c();
        this.f22572l = null;
        this.f22565a = false;
        this.f22568h.set(false);
        this.f22578r = null;
        this.f22582v = -1;
        this.f22583w = C0176a.IDLE;
        LiteavLog.i("Camera2Controller", "stopCapture success");
    }

    public final void turnOnTorch(boolean z11) {
        if (f()) {
            LiteavLog.e("Camera2Controller", "turnOnTorch error mCameraStatus:" + this.f22583w);
            return;
        }
        boolean z12 = true;
        if (z11 && this.f22582v != 2) {
            this.f22582v = 2;
        } else if (!z11) {
            this.f22582v = 0;
        } else {
            z12 = false;
        }
        LiteavLog.i("Camera2Controller", "turnOnTorch:" + z11 + ", mode:" + this.f22582v + ", updateView:" + z12);
        if (z12) {
            this.f22573m.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.f22582v));
            d();
        }
    }

    private void b(float f11) {
        if (this.f22573m == null || a() == null) {
            LiteavLog.e("Camera2Controller", "setExposureCompensation fail, value:" + f11 + " mCameraStatus:" + this.f22583w);
            return;
        }
        Range range = (Range) a().get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        int intValue = ((Integer) range.getLower()).intValue();
        int intValue2 = ((Integer) range.getUpper()).intValue();
        if (intValue == 0 && intValue2 == 0) {
            LiteavLog.i("Camera2Controller", "camera doesn't support exposure compensation");
        } else {
            this.f22573m.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(g.a(((int) ((((float) (intValue2 - intValue)) * (g.a(f11, -1.0f) - -1.0f)) / 2.0f)) + intValue, intValue, intValue2)));
        }
    }

    private void c() {
        CameraDevice andSet = this.f22569i.getAndSet((Object) null);
        if (andSet != null) {
            try {
                andSet.close();
            } catch (Throwable th2) {
                LiteavLog.e("Camera2Controller", "closeCamera fail, Exception:".concat(String.valueOf(th2)));
            }
        }
        ((CameraManager) ContextUtils.getApplicationContext().getSystemService(OptionsBridge.CAMERA_KEY)).unregisterAvailabilityCallback(this.F);
    }

    /* access modifiers changed from: private */
    public void d() {
        CaptureRequest.Builder builder;
        CameraCaptureSession cameraCaptureSession = this.f22571k.get();
        if (cameraCaptureSession != null && (builder = this.f22573m) != null) {
            try {
                cameraCaptureSession.setRepeatingRequest(builder.build(), (CameraCaptureSession.CaptureCallback) null, (Handler) null);
            } catch (Throwable th2) {
                LiteavLog.e("Camera2Controller", "updatePreview exception:".concat(String.valueOf(th2)));
            }
        }
    }

    private List<Size> e() {
        if (a() == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes error, Characteristics is null");
            return null;
        }
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) a().get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes map null");
            return null;
        }
        android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        if (outputSizes == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes choices is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (android.util.Size size : outputSizes) {
            arrayList.add(new Size(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public boolean f() {
        return a() == null || this.f22573m == null || this.f22583w != C0176a.PREVIEWING;
    }

    private void a(float f11) {
        if (this.f22573m == null || a() == null) {
            LiteavLog.e("Camera2Controller", "setZoom fail, scale:" + f11 + " mPreviewBuilder is null.");
            return;
        }
        this.f22573m.set(CaptureRequest.SCALER_CROP_REGION, c(f11));
    }

    private void c(boolean z11) {
        CaptureRequest.Builder builder = this.f22573m;
        if (builder != null) {
            int i11 = z11 ? 1 : 3;
            builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(i11));
            LiteavLog.i("Camera2Controller", "setFocusModeWithoutUpdatePreview to ".concat(String.valueOf(i11)));
        }
    }

    public static /* synthetic */ void a(a aVar, int i11) {
        if (aVar.f()) {
            LiteavLog.e("Camera2Controller", "onCameraError, but camera is invalid, do not send camera error.");
            return;
        }
        CameraEventCallback cameraEventCallback = aVar.A;
        if (cameraEventCallback != null) {
            cameraEventCallback.onCameraError(aVar, i11);
        }
    }

    private Rect c(float f11) {
        Rect rect = (Rect) a().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        float floatValue = ((Float) a().get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        float f12 = floatValue - 1.0f;
        float a11 = (g.a(f11, 0.0f) * f12) + 1.0f;
        int height = (int) (((float) rect.height()) / floatValue);
        int width = rect.width() - ((int) (((float) rect.width()) / floatValue));
        int height2 = rect.height() - height;
        float f13 = a11 - 1.0f;
        int i11 = (int) (((((float) width) * f13) / f12) / 2.0f);
        int i12 = (int) (((((float) height2) * f13) / f12) / 2.0f);
        Rect rect2 = new Rect(i11, i12, rect.width() - i11, rect.height() - i12);
        LiteavLog.i("Camera2Controller", "calculateZoomRect calculatedZoomLevel:" + a11 + " rect:" + rect + " newRect2:" + rect2);
        return rect2;
    }

    /* access modifiers changed from: private */
    public void a(boolean z11, CameraDevice cameraDevice) {
        CountDownLatch countDownLatch = this.f22585y;
        this.f22568h.set(z11);
        this.f22569i.set(cameraDevice);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* access modifiers changed from: private */
    public static String b(boolean z11) {
        return z11 ? !TextUtils.isEmpty(f22564e) ? f22564e : f22563d : !TextUtils.isEmpty(f22563d) ? f22563d : f22564e;
    }

    private void b() {
        CameraCaptureSession andSet = this.f22571k.getAndSet((Object) null);
        if (andSet != null) {
            try {
                andSet.close();
            } catch (Throwable th2) {
                LiteavLog.e("Camera2Controller", "closePreviewSession fail, Exception:".concat(String.valueOf(th2)));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z11, CameraCaptureSession cameraCaptureSession) {
        CountDownLatch countDownLatch = this.f22586z;
        this.f22570j.set(z11);
        this.f22571k.set(cameraCaptureSession);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    private CameraCharacteristics a() {
        String b11 = b(this.f22579s);
        if (!TextUtils.isEmpty(b11)) {
            return f22561b.get(b11);
        }
        return null;
    }

    private boolean a(int i11, int i12) {
        String b11 = b(this.f22579s);
        if (a() == null) {
            LiteavLog.e("Camera2Controller", "openCamera fail getCameraCharacteristics null");
            return false;
        }
        k a11 = k.a(((Integer) a().get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue());
        this.f22575o = a11;
        k kVar = this.f22576p;
        if (kVar != null) {
            a11 = kVar;
        }
        this.f22574n = b.a(e(), a11, i11, i12);
        StringBuilder sb2 = new StringBuilder("openCamera ,id:");
        sb2.append(b11);
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(this.f22579s ? "front camera" : "back camera");
        sb2.append(" mPreviewSize ");
        sb2.append(this.f22574n);
        sb2.append(" cameraRotation ");
        sb2.append(a11);
        sb2.append(" mIsCameraSupportAutoFocus ");
        sb2.append(this.f22581u);
        LiteavLog.i("Camera2Controller", sb2.toString());
        try {
            this.f22585y = new CountDownLatch(1);
            ((CameraManager) ContextUtils.getApplicationContext().getSystemService(OptionsBridge.CAMERA_KEY)).openCamera(b11, this.D, this.f22566f);
            this.f22585y.await();
        } catch (Throwable th2) {
            LiteavLog.e("Camera2Controller", "openCamera exception:".concat(String.valueOf(th2)));
            a(false, (CameraDevice) null);
        }
        return this.f22568h.get();
    }

    private boolean a(SurfaceTexture surfaceTexture) {
        try {
            CameraDevice cameraDevice = this.f22569i.get();
            if (cameraDevice == null || surfaceTexture == null) {
                throw new IOException("startPreview cameraDevice null!");
            }
            b();
            SurfaceTexture surfaceTexture2 = this.f22578r;
            Size size = this.f22574n;
            surfaceTexture2.setDefaultBufferSize(size.width, size.height);
            Surface surface = new Surface(this.f22578r);
            CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(3);
            this.f22573m = createCaptureRequest;
            createCaptureRequest.addTarget(surface);
            List singletonList = Collections.singletonList(surface);
            this.f22586z = new CountDownLatch(1);
            cameraDevice.createCaptureSession(singletonList, this.E, this.f22566f);
            this.f22586z.await();
            return this.f22570j.get();
        } catch (Throwable th2) {
            LiteavLog.e("Camera2Controller", "startPreview exception", th2);
            a(false, (CameraCaptureSession) null);
        }
    }

    private static com.tencent.liteav.videoproducer.a.a[] a(Range<Integer>[] rangeArr) {
        if (rangeArr == null || rangeArr.length <= 0) {
            return new com.tencent.liteav.videoproducer.a.a[0];
        }
        com.tencent.liteav.videoproducer.a.a[] aVarArr = new com.tencent.liteav.videoproducer.a.a[rangeArr.length];
        for (int i11 = 0; i11 < rangeArr.length; i11++) {
            aVarArr[i11] = new com.tencent.liteav.videoproducer.a.a(rangeArr[i11].getLower().intValue(), rangeArr[i11].getUpper().intValue());
        }
        return aVarArr;
    }

    public static /* synthetic */ void a(a aVar, boolean z11) {
        LiteavLog.i("Camera2Controller", "onFocusCallback success:".concat(String.valueOf(z11)));
        aVar.f22565a = true;
        boolean z12 = aVar.f22580t;
        if (!z12) {
            aVar.c(z12);
            aVar.d();
        }
    }
}
