package com.tencent.liteav.videoproducer.capture.a;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.g;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CameraEventCallback;
import com.tencent.liteav.videoproducer.capture.b;
import java.util.ArrayList;
import java.util.List;

public final class a extends CameraControllerInterface implements Camera.ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    private boolean f22543a = true;

    /* renamed from: b  reason: collision with root package name */
    private Camera f22544b;

    /* renamed from: c  reason: collision with root package name */
    private k f22545c = k.NORMAL;

    /* renamed from: d  reason: collision with root package name */
    private k f22546d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22547e = true;

    /* renamed from: f  reason: collision with root package name */
    private SurfaceTexture f22548f;

    /* renamed from: g  reason: collision with root package name */
    private Size f22549g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22550h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22551i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f22552j = true;

    /* renamed from: k  reason: collision with root package name */
    private int f22553k = 0;

    /* renamed from: l  reason: collision with root package name */
    private CameraEventCallback f22554l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f22555m = false;

    /* renamed from: n  reason: collision with root package name */
    private float f22556n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f22557o = false;

    /* renamed from: p  reason: collision with root package name */
    private float f22558p = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    private final Camera.AutoFocusCallback f22559q = b.a();

    public final void enableCameraFpsCorrectionLogic(boolean z11) {
        this.f22547e = z11;
        LiteavLog.i("CameraController", "set enable camera fps correction logic value is:".concat(String.valueOf(z11)));
    }

    public final void enableTapToFocus(boolean z11) {
        Camera.Parameters a11;
        this.f22552j = z11;
        if (this.f22544b != null && (a11 = a()) != null) {
            try {
                a(a11, z11);
                this.f22544b.setParameters(a11);
            } catch (Throwable th2) {
                LiteavLog.e("CameraController", "enableTapToFocus failed.", th2);
            }
        }
    }

    public final k getCameraSystemRotation() {
        return this.f22545c;
    }

    public final int getCameraSystemRotationValue() {
        return this.f22545c.mValue;
    }

    public final int getMaxZoom() {
        int i11 = this.f22553k;
        if (i11 != 0) {
            return i11;
        }
        if (this.f22544b != null) {
            Camera.Parameters a11 = a();
            if (a11 == null) {
                return this.f22553k;
            }
            if (a11.getMaxZoom() > 0 && a11.isZoomSupported()) {
                this.f22553k = a11.getMaxZoom();
            }
        }
        return this.f22553k;
    }

    public final Size getPreviewSize() {
        return this.f22549g;
    }

    public final boolean isCameraAutoFocusFaceModeSupported() {
        Camera.Parameters a11;
        if (this.f22544b == null || (a11 = a()) == null || a11.getMaxNumDetectedFaces() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean isCameraFocusPositionInPreviewSupported() {
        return this.f22550h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (java.lang.Math.abs(r6.aspectRatio() - r5.f22549g.aspectRatio()) > 0.001d) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isCurrentPreviewSizeAspectRatioMatch(int r6, int r7, boolean r8) {
        /*
            r5 = this;
            android.hardware.Camera r0 = r5.f22544b
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0044
            android.hardware.Camera$Parameters r0 = r5.a()
            if (r0 != 0) goto L_0x000d
            return r2
        L_0x000d:
            com.tencent.liteav.base.util.k r3 = r5.f22546d
            if (r3 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            com.tencent.liteav.base.util.k r3 = r5.f22545c
        L_0x0014:
            com.tencent.liteav.base.util.Size r6 = a(r0, r3, r6, r7)
            if (r6 == 0) goto L_0x0044
            int r7 = r6.width
            int r0 = r6.height
            int r7 = r7 * r0
            com.tencent.liteav.base.util.Size r0 = r5.f22549g
            int r3 = r0.height
            int r0 = r0.width
            int r3 = r3 * r0
            if (r7 <= r3) goto L_0x0029
            r2 = r1
        L_0x0029:
            if (r8 == 0) goto L_0x0044
            double r6 = r6.aspectRatio()
            com.tencent.liteav.base.util.Size r8 = r5.f22549g
            double r3 = r8.aspectRatio()
            double r6 = r6 - r3
            double r6 = java.lang.Math.abs(r6)
            r3 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r1 = r2
        L_0x0045:
            java.lang.String r6 = java.lang.String.valueOf(r1)
            java.lang.String r7 = "isCurrentPreviewSizeAspectRatioMatch : "
            java.lang.String r6 = r7.concat(r6)
            java.lang.String r7 = "CameraController"
            com.tencent.liteav.base.util.LiteavLog.i(r7, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.a.a.isCurrentPreviewSizeAspectRatioMatch(int, int, boolean):boolean");
    }

    public final boolean isTorchSupported() {
        Camera.Parameters a11;
        List<String> supportedFlashModes;
        if (this.f22544b == null || (a11 = a()) == null || (supportedFlashModes = a11.getSupportedFlashModes()) == null || !supportedFlashModes.contains("torch")) {
            return false;
        }
        return true;
    }

    public final boolean isZoomSupported() {
        Camera.Parameters a11;
        if (this.f22544b == null || (a11 = a()) == null || a11.getMaxZoom() <= 0 || !a11.isZoomSupported()) {
            return false;
        }
        return true;
    }

    public final void onError(int i11, Camera camera) {
        LiteavLog.e("CameraController", "onError, error:".concat(String.valueOf(i11)));
        int i12 = 1;
        if (i11 == 1 || i11 == 2 || i11 == 100) {
            if (i11 != 2) {
                i12 = i11 == 100 ? 3 : 0;
            }
            CameraEventCallback cameraEventCallback = this.f22554l;
            if (cameraEventCallback != null) {
                cameraEventCallback.onCameraError(this, i12);
            }
        }
    }

    public final void setCameraRotationCorrectionValue(int i11) {
        this.f22546d = k.b(i11) ? k.a(i11) : null;
        LiteavLog.i("CameraController", "camera rotation correction is " + this.f22546d);
    }

    public final void setExposureCompensation(float f11) {
        this.f22556n = f11;
        this.f22555m = true;
        if (this.f22544b != null) {
            this.f22555m = false;
            Camera.Parameters a11 = a();
            if (a11 != null) {
                a11.setExposureCompensation(a(a11, f11));
                try {
                    this.f22544b.setParameters(a11);
                } catch (Throwable th2) {
                    LiteavLog.e("CameraController", "set exposure compensation failed.", th2);
                }
            }
        }
    }

    public final void setZoom(float f11) {
        this.f22558p = f11;
        this.f22557o = true;
        if (this.f22544b != null) {
            this.f22557o = false;
            Camera.Parameters a11 = a();
            if (a11 != null) {
                if (a11.getMaxZoom() <= 0 || !a11.isZoomSupported()) {
                    LiteavLog.i("CameraController", "camera doesn't support zoom!");
                    return;
                }
                int maxZoom = a11.getMaxZoom();
                try {
                    a11.setZoom(g.a(Math.round(f11 * ((float) maxZoom)), 0, maxZoom));
                    this.f22544b.setParameters(a11);
                } catch (Throwable th2) {
                    LiteavLog.e("CameraController", "set zoom failed.", th2);
                }
            }
        }
    }

    public final void startAutoFocusAtPosition(int i11, int i12) {
        if (this.f22552j && this.f22544b != null) {
            if (i11 >= 0) {
                Size size = this.f22549g;
                if (i11 < size.width && i12 >= 0 && i12 < size.height) {
                    LiteavLog.i("CameraController", "Start auto focus at (%d, %d)", Integer.valueOf(i11), Integer.valueOf(i12));
                    try {
                        this.f22544b.cancelAutoFocus();
                        Camera.Parameters a11 = a();
                        if (a11 != null) {
                            if (this.f22550h) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(new Camera.Area(a((float) i11, (float) i12, 2.0f), 1000));
                                a11.setFocusAreas(arrayList);
                            }
                            if (this.f22551i) {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(new Camera.Area(a((float) i11, (float) i12, 3.0f), 1000));
                                a11.setMeteringAreas(arrayList2);
                            }
                            try {
                                this.f22544b.setParameters(a11);
                                this.f22544b.autoFocus(this.f22559q);
                                return;
                            } catch (Throwable th2) {
                                LiteavLog.e("CameraController", "auto focus failed.", th2);
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        LiteavLog.e("CameraController", "cancel auto focus failed.", th3);
                        return;
                    }
                }
            }
            LiteavLog.w("CameraController", "Start auto focus at (%d, %d) invalid ", Integer.valueOf(i11), Integer.valueOf(i12));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0130 A[Catch:{ all -> 0x0167 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013e A[Catch:{ all -> 0x0167 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean startCapture(com.tencent.liteav.videoproducer.capture.CameraCaptureParams r9, android.graphics.SurfaceTexture r10, com.tencent.liteav.videoproducer.capture.CameraEventCallback r11) {
        /*
            r8 = this;
            java.lang.String r0 = "auto"
            r8.f22554l = r11
            java.lang.String r11 = "CameraController"
            r1 = 0
            if (r9 == 0) goto L_0x015f
            if (r10 == 0) goto L_0x015f
            android.hardware.Camera r2 = r8.f22544b     // Catch:{ all -> 0x0167 }
            r3 = 1
            if (r2 == 0) goto L_0x0017
            java.lang.String r9 = "it's capturing, you should Stop first."
            com.tencent.liteav.base.util.LiteavLog.e(r11, r9)     // Catch:{ all -> 0x0167 }
            goto L_0x0175
        L_0x0017:
            r8.f22548f = r10     // Catch:{ all -> 0x0167 }
            android.hardware.Camera$CameraInfo r10 = new android.hardware.Camera$CameraInfo     // Catch:{ all -> 0x0167 }
            r10.<init>()     // Catch:{ all -> 0x0167 }
            java.lang.Boolean r2 = r9.f22518a     // Catch:{ all -> 0x0167 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0167 }
            int r2 = a((boolean) r2, (android.hardware.Camera.CameraInfo) r10)     // Catch:{ all -> 0x0167 }
            java.lang.Boolean r4 = r9.f22518a     // Catch:{ all -> 0x0167 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0167 }
            r8.f22543a = r4     // Catch:{ all -> 0x0167 }
            android.hardware.Camera r4 = android.hardware.Camera.open(r2)     // Catch:{ all -> 0x0167 }
            r8.f22544b = r4     // Catch:{ all -> 0x0167 }
            int r4 = r10.orientation     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.base.util.k r4 = com.tencent.liteav.base.util.k.a((int) r4)     // Catch:{ all -> 0x0167 }
            r8.f22545c = r4     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.base.util.k r5 = r8.f22546d     // Catch:{ all -> 0x0167 }
            if (r5 == 0) goto L_0x0043
            r4 = r5
        L_0x0043:
            java.lang.String r5 = "open camera id: %d, isFrontCamera: %b, camera rotation: %s, camera info orientation: %d"
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0167 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0167 }
            r6[r1] = r2     // Catch:{ all -> 0x0167 }
            java.lang.Boolean r2 = r9.f22518a     // Catch:{ all -> 0x0167 }
            r6[r3] = r2     // Catch:{ all -> 0x0167 }
            r2 = 2
            r6[r2] = r4     // Catch:{ all -> 0x0167 }
            r2 = 3
            int r7 = r10.orientation     // Catch:{ all -> 0x0167 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0167 }
            r6[r2] = r7     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.base.util.LiteavLog.i(r11, r5, r6)     // Catch:{ all -> 0x0167 }
            android.hardware.Camera r2 = r8.f22544b     // Catch:{ all -> 0x0167 }
            android.hardware.Camera$Parameters r2 = r2.getParameters()     // Catch:{ all -> 0x0167 }
            int r5 = r2.getMaxNumFocusAreas()     // Catch:{ all -> 0x0167 }
            if (r5 <= 0) goto L_0x006f
            r5 = r3
            goto L_0x0070
        L_0x006f:
            r5 = r1
        L_0x0070:
            r8.f22550h = r5     // Catch:{ all -> 0x0167 }
            int r5 = r2.getMaxNumMeteringAreas()     // Catch:{ all -> 0x0167 }
            if (r5 <= 0) goto L_0x007a
            r5 = r3
            goto L_0x007b
        L_0x007a:
            r5 = r1
        L_0x007b:
            r8.f22551i = r5     // Catch:{ all -> 0x0167 }
            boolean r5 = r8.f22552j     // Catch:{ all -> 0x0167 }
            a((android.hardware.Camera.Parameters) r2, (boolean) r5)     // Catch:{ all -> 0x0167 }
            boolean r5 = r8.f22557o     // Catch:{ all -> 0x0167 }
            if (r5 == 0) goto L_0x00a9
            r8.f22557o = r1     // Catch:{ all -> 0x0167 }
            int r5 = r2.getMaxZoom()     // Catch:{ all -> 0x0167 }
            r8.f22553k = r5     // Catch:{ all -> 0x0167 }
            if (r5 <= 0) goto L_0x00a9
            boolean r5 = r2.isZoomSupported()     // Catch:{ all -> 0x0167 }
            if (r5 == 0) goto L_0x00a9
            float r5 = r8.f22558p     // Catch:{ all -> 0x0167 }
            int r6 = r8.f22553k     // Catch:{ all -> 0x0167 }
            float r6 = (float) r6     // Catch:{ all -> 0x0167 }
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)     // Catch:{ all -> 0x0167 }
            int r6 = r8.f22553k     // Catch:{ all -> 0x0167 }
            int r5 = com.tencent.liteav.base.util.g.a((int) r5, (int) r1, (int) r6)     // Catch:{ all -> 0x0167 }
            r2.setZoom(r5)     // Catch:{ all -> 0x0167 }
        L_0x00a9:
            boolean r5 = r8.f22555m     // Catch:{ all -> 0x0167 }
            if (r5 == 0) goto L_0x00b8
            r8.f22555m = r1     // Catch:{ all -> 0x0167 }
            float r5 = r8.f22556n     // Catch:{ all -> 0x0167 }
            int r5 = a((android.hardware.Camera.Parameters) r2, (float) r5)     // Catch:{ all -> 0x0167 }
            r2.setExposureCompensation(r5)     // Catch:{ all -> 0x0167 }
        L_0x00b8:
            int r5 = r9.f22525c     // Catch:{ all -> 0x0167 }
            int r6 = r9.f22526d     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.base.util.Size r4 = a(r2, r4, r5, r6)     // Catch:{ all -> 0x0167 }
            r8.f22549g = r4     // Catch:{ all -> 0x0167 }
            int r5 = r4.width     // Catch:{ all -> 0x0167 }
            int r4 = r4.height     // Catch:{ all -> 0x0167 }
            r2.setPreviewSize(r5, r4)     // Catch:{ all -> 0x0167 }
            java.lang.String r4 = com.tencent.liteav.base.system.LiteavSystemInfo.getModel()     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = "aiv8167sm3_bsp"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0167 }
            if (r4 == 0) goto L_0x00e5
            java.lang.String r4 = "Model equals dingdang, setPreviewFrameRate: %d"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x0167 }
            int r6 = r9.f22524b     // Catch:{ all -> 0x0167 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0167 }
            r5[r1] = r6     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.base.util.LiteavLog.i(r11, r4, r5)     // Catch:{ all -> 0x0167 }
            goto L_0x011d
        L_0x00e5:
            int r4 = r9.f22524b     // Catch:{ all -> 0x0167 }
            int r4 = r4 * 1000
            java.lang.String r5 = "preferred fps: "
            java.lang.String r6 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.base.util.LiteavLog.i(r11, r5)     // Catch:{ all -> 0x0167 }
            java.util.List r5 = r2.getSupportedPreviewFpsRange()     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.videoproducer.a.a[] r5 = a((java.util.List<int[]>) r5)     // Catch:{ all -> 0x0167 }
            boolean r6 = r8.f22547e     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.videoproducer.a.a r4 = com.tencent.liteav.videoproducer.capture.b.a(r5, r4, r6)     // Catch:{ all -> 0x0167 }
            if (r4 == 0) goto L_0x0113
            java.lang.String r5 = "choosed fps range: "
            java.lang.String r6 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.base.util.LiteavLog.i(r11, r5)     // Catch:{ all -> 0x0167 }
        L_0x0113:
            if (r4 == 0) goto L_0x011d
            int r9 = r4.f22516a     // Catch:{ all -> 0x0167 }
            int r4 = r4.f22517b     // Catch:{ all -> 0x0167 }
            r2.setPreviewFpsRange(r9, r4)     // Catch:{ all -> 0x0167 }
            goto L_0x0126
        L_0x011d:
            int r9 = r9.f22524b     // Catch:{ all -> 0x0167 }
            int r9 = r8.a((int) r9)     // Catch:{ all -> 0x0167 }
            r2.setPreviewFrameRate(r9)     // Catch:{ all -> 0x0167 }
        L_0x0126:
            r2.setWhiteBalance(r0)     // Catch:{ all -> 0x0167 }
            r2.setSceneMode(r0)     // Catch:{ all -> 0x0167 }
            int r9 = r10.facing     // Catch:{ all -> 0x0167 }
            if (r9 != r3) goto L_0x013e
            android.hardware.Camera r9 = r8.f22544b     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.base.util.k r10 = r8.f22545c     // Catch:{ all -> 0x0167 }
            int r10 = r10.mValue     // Catch:{ all -> 0x0167 }
            int r10 = 360 - r10
            int r10 = r10 % 360
            r9.setDisplayOrientation(r10)     // Catch:{ all -> 0x0167 }
            goto L_0x0147
        L_0x013e:
            android.hardware.Camera r9 = r8.f22544b     // Catch:{ all -> 0x0167 }
            com.tencent.liteav.base.util.k r10 = r8.f22545c     // Catch:{ all -> 0x0167 }
            int r10 = r10.mValue     // Catch:{ all -> 0x0167 }
            r9.setDisplayOrientation(r10)     // Catch:{ all -> 0x0167 }
        L_0x0147:
            android.hardware.Camera r9 = r8.f22544b     // Catch:{ all -> 0x0167 }
            r9.setParameters(r2)     // Catch:{ all -> 0x0167 }
            android.hardware.Camera r9 = r8.f22544b     // Catch:{ all -> 0x0167 }
            r9.setErrorCallback(r8)     // Catch:{ all -> 0x0167 }
            android.hardware.Camera r9 = r8.f22544b     // Catch:{ all -> 0x0167 }
            android.graphics.SurfaceTexture r10 = r8.f22548f     // Catch:{ all -> 0x0167 }
            r9.setPreviewTexture(r10)     // Catch:{ all -> 0x0167 }
            android.hardware.Camera r9 = r8.f22544b     // Catch:{ all -> 0x0167 }
            r9.startPreview()     // Catch:{ all -> 0x0167 }
            r1 = r3
            goto L_0x0175
        L_0x015f:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0167 }
            java.lang.String r10 = "captureParams or surfaceTexture is null"
            r9.<init>(r10)     // Catch:{ all -> 0x0167 }
            throw r9     // Catch:{ all -> 0x0167 }
        L_0x0167:
            r9 = move-exception
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r10 = "open camera1 fail, Exception:"
            java.lang.String r9 = r10.concat(r9)
            com.tencent.liteav.base.util.LiteavLog.e(r11, r9)
        L_0x0175:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.a.a.startCapture(com.tencent.liteav.videoproducer.capture.CameraCaptureParams, android.graphics.SurfaceTexture, com.tencent.liteav.videoproducer.capture.CameraEventCallback):boolean");
    }

    public final void stopCapture() {
        LiteavLog.i("CameraController", "stopCapture");
        try {
            Camera camera = this.f22544b;
            if (camera != null) {
                camera.setErrorCallback((Camera.ErrorCallback) null);
                this.f22544b.stopPreview();
                this.f22544b.release();
                this.f22544b = null;
            }
        } catch (Throwable th2) {
            LiteavLog.e("CameraController", "closeCamera fail, Exception:".concat(String.valueOf(th2)));
        }
        this.f22548f = null;
    }

    public final void turnOnTorch(boolean z11) {
        List<String> supportedFlashModes;
        if (this.f22544b != null) {
            String str = z11 ? "torch" : "off";
            Camera.Parameters a11 = a();
            if (a11 != null && (supportedFlashModes = a11.getSupportedFlashModes()) != null && supportedFlashModes.contains(str)) {
                try {
                    a11.setFlashMode(str);
                    this.f22544b.setParameters(a11);
                } catch (Throwable th2) {
                    LiteavLog.e("CameraController", "enable torch failed.", th2);
                }
            }
        }
    }

    private Rect a(float f11, float f12, float f13) {
        int i11 = (int) (f13 * 200.0f);
        Size size = this.f22549g;
        int i12 = i11 / 2;
        int a11 = g.a(((int) (((f11 / ((float) size.width)) * 2000.0f) - 1000.0f)) - i12, -1000, 1000);
        int a12 = g.a(a11 + i11, -1000, 1000);
        int a13 = g.a(((int) (((f12 / ((float) size.height)) * 2000.0f) - 1000.0f)) - i12, -1000, 1000);
        return new Rect(a11, a13, a12, g.a(i11 + a13, -1000, 1000));
    }

    private static int a(Camera.Parameters parameters, float f11) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        if (minExposureCompensation == 0 && maxExposureCompensation == 0) {
            LiteavLog.i("CameraController", "camera doesn't support exposure compensation");
            return minExposureCompensation;
        }
        com.tencent.liteav.base.a.a.a();
        return g.a((int) (g.a(f11, -1.0f) * ((float) maxExposureCompensation)), minExposureCompensation, maxExposureCompensation);
    }

    private static int a(boolean z11, Camera.CameraInfo cameraInfo) {
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < Camera.getNumberOfCameras(); i13++) {
            Camera.getCameraInfo(i13, cameraInfo);
            LiteavLog.i("CameraController", "get camera info, index: " + i13 + ", facing: " + cameraInfo.facing);
            if (i11 == -1 && cameraInfo.facing == 1) {
                i11 = i13;
            } else if (i12 == -1 && cameraInfo.facing == 0) {
                i12 = i13;
            }
        }
        if (!z11 ? i12 != -1 : i11 == -1) {
            i11 = i12;
        }
        Camera.getCameraInfo(i11, cameraInfo);
        return i11;
    }

    private static Size a(Camera.Parameters parameters, k kVar, int i11, int i12) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes != null) {
            for (Camera.Size next : supportedPreviewSizes) {
                arrayList.add(new Size(next.width, next.height));
            }
        }
        return b.a(arrayList, kVar, i11, i12);
    }

    private static void a(Camera.Parameters parameters, boolean z11) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null) {
            if (z11 && supportedFocusModes.contains(TtmlNode.TEXT_EMPHASIS_AUTO)) {
                parameters.setFocusMode(TtmlNode.TEXT_EMPHASIS_AUTO);
                LiteavLog.i("CameraController", "set focus mode to auto");
            } else if (supportedFocusModes.contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
                LiteavLog.i("CameraController", "set focus mode to continuous-video");
            }
        }
    }

    private int a(int i11) {
        Camera.Parameters a11 = a();
        if (a11 == null) {
            return 1;
        }
        List<Integer> supportedPreviewFrameRates = a11.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates == null || supportedPreviewFrameRates.isEmpty()) {
            LiteavLog.e("CameraController", "supported preview frame rates is empty");
            return 1;
        }
        int intValue = supportedPreviewFrameRates.get(0).intValue();
        for (Integer intValue2 : supportedPreviewFrameRates) {
            int intValue3 = intValue2.intValue();
            if (Math.abs(i11 - intValue3) < Math.abs(i11 - intValue)) {
                intValue = intValue3;
            }
        }
        LiteavLog.i("CameraController", "best matched frame rate: %d", Integer.valueOf(intValue));
        return intValue;
    }

    private Camera.Parameters a() {
        try {
            Camera camera = this.f22544b;
            if (camera != null) {
                return camera.getParameters();
            }
            return null;
        } catch (Throwable th2) {
            LiteavLog.e("CameraController", "getCameraParameters failed.", th2);
            return null;
        }
    }

    private static com.tencent.liteav.videoproducer.a.a[] a(List<int[]> list) {
        if (list == null || list.size() <= 0) {
            return new com.tencent.liteav.videoproducer.a.a[0];
        }
        com.tencent.liteav.videoproducer.a.a[] aVarArr = new com.tencent.liteav.videoproducer.a.a[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            int[] iArr = list.get(i11);
            if (iArr != null && iArr.length >= 2) {
                aVarArr[i11] = new com.tencent.liteav.videoproducer.a.a(iArr[0], iArr[1]);
            }
        }
        return aVarArr;
    }
}
