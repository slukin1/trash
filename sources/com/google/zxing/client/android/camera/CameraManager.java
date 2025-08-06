package com.google.zxing.client.android.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.client.android.camera.open.OpenCamera;

public final class CameraManager {
    private static final int MAX_FRAME_HEIGHT = 777;
    private static final int MAX_FRAME_WIDTH = 1382;
    private static final int MIN_FRAME_HEIGHT = 240;
    private static final int MIN_FRAME_WIDTH = 240;
    private static final String TAG = "CameraManager";
    private AutoFocusManager autoFocusManager;
    private OpenCamera camera;
    private final CameraConfigurationManager configManager;
    private final Context context;
    private Rect framingRect;
    private Rect framingRectInPreview;
    private boolean initialized;
    private final PreviewCallback previewCallback;
    private boolean previewing;
    private int requestedCameraId = -1;
    private int requestedFramingRectHeight;
    private int requestedFramingRectWidth;

    public CameraManager(Context context2) {
        this.context = context2;
        CameraConfigurationManager cameraConfigurationManager = new CameraConfigurationManager(context2);
        this.configManager = cameraConfigurationManager;
        this.previewCallback = new PreviewCallback(cameraConfigurationManager);
    }

    private static int findDesiredDimensionInRange(int i11, int i12, int i13) {
        int i14 = (int) ((((double) i11) * 7.2d) / 10.0d);
        return i14 < i12 ? i12 : i14 > i13 ? i13 : i14;
    }

    public PlanarYUVLuminanceSource buildLuminanceSource(byte[] bArr, int i11, int i12) {
        if (getFramingRectInPreview() == null) {
            return null;
        }
        return new PlanarYUVLuminanceSource(bArr, i11, i12, 0, 0, i11, i12, false);
    }

    public synchronized void closeDriver() {
        OpenCamera openCamera = this.camera;
        if (openCamera != null) {
            openCamera.getCamera().release();
            this.camera = null;
            this.framingRect = null;
            this.framingRectInPreview = null;
        }
    }

    public synchronized Rect getFramingRect() {
        if (this.framingRect == null) {
            if (this.camera == null) {
                return null;
            }
            Point screenResolution = this.configManager.getScreenResolution();
            if (screenResolution == null) {
                return null;
            }
            int findDesiredDimensionInRange = findDesiredDimensionInRange(screenResolution.x, 240, MAX_FRAME_WIDTH);
            int findDesiredDimensionInRange2 = findDesiredDimensionInRange(screenResolution.y, 240, MAX_FRAME_HEIGHT);
            if (findDesiredDimensionInRange >= findDesiredDimensionInRange2) {
                findDesiredDimensionInRange = findDesiredDimensionInRange2;
            }
            int i11 = (screenResolution.x - findDesiredDimensionInRange) / 2;
            int i12 = (screenResolution.y - findDesiredDimensionInRange) / 2;
            this.framingRect = new Rect(i11, i12, i11 + findDesiredDimensionInRange, findDesiredDimensionInRange + i12);
            String str = TAG;
            Log.d(str, "Calculated framing rect: " + this.framingRect);
        }
        return this.framingRect;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Rect getFramingRectInPreview() {
        /*
            r6 = this;
            monitor-enter(r6)
            android.graphics.Rect r0 = r6.framingRectInPreview     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0049
            android.graphics.Rect r0 = r6.getFramingRect()     // Catch:{ all -> 0x004d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r6)
            return r1
        L_0x000e:
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ all -> 0x004d }
            r2.<init>(r0)     // Catch:{ all -> 0x004d }
            com.google.zxing.client.android.camera.CameraConfigurationManager r0 = r6.configManager     // Catch:{ all -> 0x004d }
            android.graphics.Point r0 = r0.getCameraResolution()     // Catch:{ all -> 0x004d }
            com.google.zxing.client.android.camera.CameraConfigurationManager r3 = r6.configManager     // Catch:{ all -> 0x004d }
            android.graphics.Point r3 = r3.getScreenResolution()     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0047
            if (r3 != 0) goto L_0x0024
            goto L_0x0047
        L_0x0024:
            int r1 = r2.left     // Catch:{ all -> 0x004d }
            int r4 = r0.x     // Catch:{ all -> 0x004d }
            int r1 = r1 * r4
            int r5 = r3.x     // Catch:{ all -> 0x004d }
            int r1 = r1 / r5
            r2.left = r1     // Catch:{ all -> 0x004d }
            int r1 = r2.right     // Catch:{ all -> 0x004d }
            int r1 = r1 * r4
            int r1 = r1 / r5
            r2.right = r1     // Catch:{ all -> 0x004d }
            int r1 = r2.top     // Catch:{ all -> 0x004d }
            int r0 = r0.y     // Catch:{ all -> 0x004d }
            int r1 = r1 * r0
            int r3 = r3.y     // Catch:{ all -> 0x004d }
            int r1 = r1 / r3
            r2.top = r1     // Catch:{ all -> 0x004d }
            int r1 = r2.bottom     // Catch:{ all -> 0x004d }
            int r1 = r1 * r0
            int r1 = r1 / r3
            r2.bottom = r1     // Catch:{ all -> 0x004d }
            r6.framingRectInPreview = r2     // Catch:{ all -> 0x004d }
            goto L_0x0049
        L_0x0047:
            monitor-exit(r6)
            return r1
        L_0x0049:
            android.graphics.Rect r0 = r6.framingRectInPreview     // Catch:{ all -> 0x004d }
            monitor-exit(r6)
            return r0
        L_0x004d:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.camera.CameraManager.getFramingRectInPreview():android.graphics.Rect");
    }

    public synchronized boolean isOpen() {
        return this.camera != null;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x004a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0077 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void openDriver(android.view.SurfaceHolder r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            com.google.zxing.client.android.camera.open.OpenCamera r0 = r7.camera     // Catch:{ all -> 0x0083 }
            if (r0 != 0) goto L_0x0018
            int r0 = r7.requestedCameraId     // Catch:{ all -> 0x0083 }
            com.google.zxing.client.android.camera.open.OpenCamera r0 = com.google.zxing.client.android.camera.open.OpenCameraInterface.open(r0)     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x0010
            r7.camera = r0     // Catch:{ all -> 0x0083 }
            goto L_0x0018
        L_0x0010:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0083 }
            java.lang.String r0 = "Camera.open() failed to return object from driver"
            r8.<init>(r0)     // Catch:{ all -> 0x0083 }
            throw r8     // Catch:{ all -> 0x0083 }
        L_0x0018:
            boolean r1 = r7.initialized     // Catch:{ all -> 0x0083 }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0034
            r7.initialized = r2     // Catch:{ all -> 0x0083 }
            com.google.zxing.client.android.camera.CameraConfigurationManager r1 = r7.configManager     // Catch:{ all -> 0x0083 }
            r1.initFromCameraParameters(r0)     // Catch:{ all -> 0x0083 }
            int r1 = r7.requestedFramingRectWidth     // Catch:{ all -> 0x0083 }
            if (r1 <= 0) goto L_0x0034
            int r4 = r7.requestedFramingRectHeight     // Catch:{ all -> 0x0083 }
            if (r4 <= 0) goto L_0x0034
            r7.setManualFramingRect(r1, r4)     // Catch:{ all -> 0x0083 }
            r7.requestedFramingRectWidth = r3     // Catch:{ all -> 0x0083 }
            r7.requestedFramingRectHeight = r3     // Catch:{ all -> 0x0083 }
        L_0x0034:
            android.hardware.Camera r1 = r0.getCamera()     // Catch:{ all -> 0x0083 }
            android.hardware.Camera$Parameters r4 = r1.getParameters()     // Catch:{ all -> 0x0083 }
            if (r4 != 0) goto L_0x0040
            r4 = 0
            goto L_0x0044
        L_0x0040:
            java.lang.String r4 = r4.flatten()     // Catch:{ all -> 0x0083 }
        L_0x0044:
            com.google.zxing.client.android.camera.CameraConfigurationManager r5 = r7.configManager     // Catch:{ RuntimeException -> 0x004a }
            r5.setDesiredCameraParameters(r0, r3)     // Catch:{ RuntimeException -> 0x004a }
            goto L_0x007e
        L_0x004a:
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = "Camera rejected parameters. Setting only minimal safe-mode parameters"
            android.util.Log.w(r3, r5)     // Catch:{ all -> 0x0083 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r5.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r6 = "Resetting to saved camera params: "
            r5.append(r6)     // Catch:{ all -> 0x0083 }
            r5.append(r4)     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0083 }
            android.util.Log.i(r3, r5)     // Catch:{ all -> 0x0083 }
            if (r4 == 0) goto L_0x007e
            android.hardware.Camera$Parameters r3 = r1.getParameters()     // Catch:{ all -> 0x0083 }
            r3.unflatten(r4)     // Catch:{ all -> 0x0083 }
            r1.setParameters(r3)     // Catch:{ RuntimeException -> 0x0077 }
            com.google.zxing.client.android.camera.CameraConfigurationManager r3 = r7.configManager     // Catch:{ RuntimeException -> 0x0077 }
            r3.setDesiredCameraParameters(r0, r2)     // Catch:{ RuntimeException -> 0x0077 }
            goto L_0x007e
        L_0x0077:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = "Camera rejected even safe-mode parameters! No configuration"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x0083 }
        L_0x007e:
            r1.setPreviewDisplay(r8)     // Catch:{ all -> 0x0083 }
            monitor-exit(r7)
            return
        L_0x0083:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.camera.CameraManager.openDriver(android.view.SurfaceHolder):void");
    }

    public synchronized void requestPreviewFrame(Handler handler, int i11) {
        OpenCamera openCamera = this.camera;
        if (openCamera != null && this.previewing) {
            this.previewCallback.setHandler(handler, i11);
            openCamera.getCamera().setOneShotPreviewCallback(this.previewCallback);
        }
    }

    public synchronized void setManualCameraId(int i11) {
        this.requestedCameraId = i11;
    }

    public synchronized void setManualFramingRect(int i11, int i12) {
        if (this.initialized) {
            Point screenResolution = this.configManager.getScreenResolution();
            int i13 = screenResolution.x;
            if (i11 > i13) {
                i11 = i13;
            }
            int i14 = screenResolution.y;
            if (i12 > i14) {
                i12 = i14;
            }
            int i15 = (i13 - i11) / 2;
            int i16 = (i14 - i12) / 2;
            this.framingRect = new Rect(i15, i16, i11 + i15, i12 + i16);
            String str = TAG;
            Log.d(str, "Calculated manual framing rect: " + this.framingRect);
            this.framingRectInPreview = null;
        } else {
            this.requestedFramingRectWidth = i11;
            this.requestedFramingRectHeight = i12;
        }
    }

    public synchronized void setTorch(boolean z11) {
        OpenCamera openCamera = this.camera;
        if (!(openCamera == null || z11 == this.configManager.getTorchState(openCamera.getCamera()))) {
            AutoFocusManager autoFocusManager2 = this.autoFocusManager;
            boolean z12 = autoFocusManager2 != null;
            if (z12) {
                autoFocusManager2.stop();
                this.autoFocusManager = null;
            }
            this.configManager.setTorch(openCamera.getCamera(), z11);
            if (z12) {
                AutoFocusManager autoFocusManager3 = new AutoFocusManager(this.context, openCamera.getCamera());
                this.autoFocusManager = autoFocusManager3;
                autoFocusManager3.start();
            }
        }
    }

    public synchronized void startPreview() {
        OpenCamera openCamera = this.camera;
        if (openCamera != null && !this.previewing) {
            openCamera.getCamera().startPreview();
            this.previewing = true;
            this.autoFocusManager = new AutoFocusManager(this.context, openCamera.getCamera());
        }
    }

    public synchronized void stopPreview() {
        AutoFocusManager autoFocusManager2 = this.autoFocusManager;
        if (autoFocusManager2 != null) {
            autoFocusManager2.stop();
            this.autoFocusManager = null;
        }
        OpenCamera openCamera = this.camera;
        if (openCamera != null && this.previewing) {
            openCamera.getCamera().stopPreview();
            this.previewCallback.setHandler((Handler) null, 0);
            this.previewing = false;
        }
    }
}
