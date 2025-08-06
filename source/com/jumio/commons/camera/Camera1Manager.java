package com.jumio.commons.camera;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.views.CameraScanView;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;

public final class Camera1Manager implements CameraManagerInterface, Camera.PreviewCallback, View.OnClickListener, View.OnTouchListener, TextureView.SurfaceTextureListener {
    public static final Companion Companion = new Companion((r) null);
    public static final List<String> FALLBACK_AUTO_FOCUS_LIST = CollectionsKt__CollectionsKt.n("GT-I9100", "SPH-D710", "SGH-T989", "SCH-I605", "SAMSUNG-SGH-I727", "GT-I9100G", "SAMSUNG-SGH-I777", "SPH-D710BST", "GT-I9100P", "GT-I9100T", "SGH-S959G", "SGH-T989D", "SGH-I727R", "GT-I9100M", "SPH-D710VMUB", "SAMSUNG-SGH-T989", "SGH-I757M", "SGH-I777", "GT-I9210", "GT-I9105P", "GT-I9105", "GT-I9105I", "GT-I9105G", "SAMSUNG-SGH-I717", "SGH-T879", "SGH-I717M", "SGH-I717R", "GT-N7000", "GT-N7005", "DROIDX");
    public static final String[] FALLBACK_PREVIEW_FORMAT_LIST = {"Nexus 7"};

    /* renamed from: b  reason: collision with root package name */
    public Camera f38922b;

    /* renamed from: c  reason: collision with root package name */
    public int f38923c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f38924d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f38925e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final Camera.AutoFocusCallback f38926f = new gw.a(this);

    /* renamed from: g  reason: collision with root package name */
    public DeviceRotationManager f38927g = new DeviceRotationManager();

    /* renamed from: h  reason: collision with root package name */
    public Size f38928h = new Size(0, 0);

    /* renamed from: i  reason: collision with root package name */
    public TextureView f38929i;

    /* renamed from: j  reason: collision with root package name */
    public CameraCallbackInterface f38930j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f38931k;

    /* renamed from: l  reason: collision with root package name */
    public PreviewProperties f38932l = new PreviewProperties();

    /* renamed from: m  reason: collision with root package name */
    public Frame.MetaData f38933m = new Frame.MetaData((Size) null, 0, 0, 0, 0, false, 0, 0, 255, (r) null);

    /* renamed from: n  reason: collision with root package name */
    public ExecutorService f38934n = Executors.newSingleThreadExecutor();

    /* renamed from: o  reason: collision with root package name */
    public boolean f38935o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f38936p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f38937q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f38938r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f38939s;

    /* renamed from: t  reason: collision with root package name */
    public Size f38940t;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final boolean hasFrontFacingCamera(Context context) {
            return context.getPackageManager().hasSystemFeature("android.hardware.camera.front");
        }
    }

    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final SurfaceTexture f38941a;

        /* renamed from: b  reason: collision with root package name */
        public final int f38942b;

        /* renamed from: c  reason: collision with root package name */
        public final int f38943c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f38944d;

        /* renamed from: e  reason: collision with root package name */
        public final int f38945e;

        public a(SurfaceTexture surfaceTexture, int i11, int i12, boolean z11, int i13) {
            this.f38941a = surfaceTexture;
            this.f38942b = i11;
            this.f38943c = i12;
            this.f38944d = z11;
            this.f38945e = i13;
        }

        public final void run() {
            Object access$getCameraAccessLock$p = Camera1Manager.this.f38925e;
            Camera1Manager camera1Manager = Camera1Manager.this;
            synchronized (access$getCameraAccessLock$p) {
                camera1Manager.a();
                camera1Manager.a(this.f38941a, this.f38942b, this.f38943c, this.f38944d, this.f38945e);
                if (!camera1Manager.isPausePreview()) {
                    camera1Manager.startPreview();
                }
                Unit unit = Unit.f56620a;
            }
        }
    }

    public final class b implements Runnable {
        public b() {
        }

        public final void run() {
            Object access$getCameraAccessLock$p = Camera1Manager.this.f38925e;
            Camera1Manager camera1Manager = Camera1Manager.this;
            synchronized (access$getCameraAccessLock$p) {
                try {
                    Camera access$getCamera$p = camera1Manager.f38922b;
                    if (access$getCamera$p != null) {
                        access$getCamera$p.release();
                    }
                } catch (Exception e11) {
                    Log.printStackTrace(e11);
                }
                camera1Manager.f38922b = null;
                camera1Manager.f38924d = null;
                Unit unit = Unit.f56620a;
            }
        }
    }

    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f38948a;

        /* renamed from: b  reason: collision with root package name */
        public final int f38949b;

        public c(int i11, int i12) {
            this.f38948a = i11;
            this.f38949b = i12;
        }

        public final void run() {
            TextureView textureView = Camera1Manager.this.getTextureView();
            int i11 = 0;
            int width = textureView != null ? textureView.getWidth() : 0;
            TextureView textureView2 = Camera1Manager.this.getTextureView();
            if (textureView2 != null) {
                i11 = textureView2.getHeight();
            }
            float f11 = (float) 2000;
            int i12 = this.f38948a;
            float f12 = (float) width;
            float f13 = (float) 1000;
            int i13 = (int) (((((float) (i12 - 50)) / f12) * f11) - f13);
            int i14 = (int) (((((float) (i12 + 50)) / f12) * f11) - f13);
            int i15 = this.f38949b;
            float f14 = (float) i11;
            int i16 = (int) (((((float) (i15 - 50)) / f14) * f11) - f13);
            int i17 = (int) (((((float) (i15 + 50)) / f14) * f11) - f13);
            Object access$getCameraAccessLock$p = Camera1Manager.this.f38925e;
            Camera1Manager camera1Manager = Camera1Manager.this;
            synchronized (access$getCameraAccessLock$p) {
                try {
                    Camera access$getCamera$p = camera1Manager.f38922b;
                    if (access$getCamera$p != null) {
                        if (!camera1Manager.getFocusing()) {
                            if (camera1Manager.getManualFocusEnabled()) {
                                camera1Manager.setFocusing(true);
                                access$getCamera$p.autoFocus(camera1Manager.f38926f);
                            } else {
                                Camera.Parameters parameters = access$getCamera$p.getParameters();
                                Camera1Manager.access$addAreas(camera1Manager, parameters, new Rect(i13, i16, i14, i17));
                                access$getCamera$p.setParameters(parameters);
                            }
                            Unit unit = Unit.f56620a;
                        } else {
                            return;
                        }
                    }
                } catch (Exception e11) {
                    Log.printStackTrace(e11);
                    Unit unit2 = Unit.f56620a;
                }
            }
            return;
        }
    }

    public final class d implements Runnable {
        public d() {
        }

        public final void run() {
            Camera1Manager.this.setFlash(false);
            Object access$getCameraAccessLock$p = Camera1Manager.this.f38925e;
            Camera1Manager camera1Manager = Camera1Manager.this;
            synchronized (access$getCameraAccessLock$p) {
                try {
                    Camera access$getCamera$p = camera1Manager.f38922b;
                    if (access$getCamera$p != null) {
                        access$getCamera$p.stopPreview();
                        Unit unit = Unit.f56620a;
                    }
                } catch (Exception e11) {
                    Log.printStackTrace(e11);
                    Unit unit2 = Unit.f56620a;
                }
            }
            return;
        }
    }

    public final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final SurfaceTexture f38952a;

        /* renamed from: b  reason: collision with root package name */
        public final int f38953b;

        /* renamed from: c  reason: collision with root package name */
        public final int f38954c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f38955d;

        /* renamed from: e  reason: collision with root package name */
        public final int f38956e;

        public e(SurfaceTexture surfaceTexture, int i11, int i12, boolean z11, int i13) {
            this.f38952a = surfaceTexture;
            this.f38953b = i11;
            this.f38954c = i12;
            this.f38955d = z11;
            this.f38956e = i13;
        }

        public final void run() {
            Object access$getCameraAccessLock$p = Camera1Manager.this.f38925e;
            Camera1Manager camera1Manager = Camera1Manager.this;
            synchronized (access$getCameraAccessLock$p) {
                Camera unused = camera1Manager.f38922b;
                CameraCallbackInterface cameraCallback = camera1Manager.getCameraCallback();
                if (cameraCallback != null) {
                    cameraCallback.onStopPreview();
                }
                camera1Manager.a(this.f38952a, this.f38953b, this.f38954c, this.f38955d, this.f38956e);
                if (!camera1Manager.isPausePreview()) {
                    camera1Manager.startPreview();
                }
                Unit unit = Unit.f56620a;
            }
        }
    }

    public static final void a(Camera1Manager camera1Manager, boolean z11, Camera camera) {
        camera1Manager.setFocusing(false);
    }

    public static final void access$addAreas(Camera1Manager camera1Manager, Camera.Parameters parameters, Rect rect) {
        camera1Manager.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Camera.Area(rect, 1));
        if (parameters.getMaxNumFocusAreas() > 0) {
            parameters.setFocusAreas(arrayList);
        }
        if (parameters.getMaxNumMeteringAreas() > 0) {
            parameters.setMeteringAreas(arrayList);
        }
    }

    public final void b(Camera.Parameters parameters, boolean z11) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (!z11 && supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
            setManualFocusEnabled(false);
        } else if (!z11 && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            setManualFocusEnabled(false);
        } else if (supportedFocusModes.contains(TtmlNode.TEXT_EMPHASIS_AUTO)) {
            parameters.setFocusMode(TtmlNode.TEXT_EMPHASIS_AUTO);
            setManualFocusEnabled(true);
        } else if (supportedFocusModes.contains("macro")) {
            parameters.setFocusMode("macro");
            setManualFocusEnabled(true);
        }
    }

    public final int calculateCameraRotation(Camera.CameraInfo cameraInfo, int i11) {
        int i12 = i11 != 1 ? i11 != 2 ? i11 != 3 ? 0 : 270 : 180 : 90;
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i12) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i12) + 360) % 360;
    }

    public void changeCamera() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            if (numberOfCameras > 0) {
                int i11 = this.f38923c + 1;
                this.f38923c = i11;
                if (i11 >= numberOfCameras) {
                    this.f38923c = 0;
                }
                reinitCamera();
            }
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
    }

    public synchronized void destroy() {
        getExecutorService().submit(new b());
    }

    public void fillImageData(ImageData imageData) {
        imageData.setCameraPosition(isFrontFacing() ? ImageData.CameraPosition.FRONT : ImageData.CameraPosition.BACK);
        imageData.setOrientationMode(getRotationManager().getScreenOrientation());
        imageData.getImageSize().setWidth(getPreviewProperties().getPreview().getWidth());
        imageData.getImageSize().setHeight(getPreviewProperties().getPreview().getHeight());
        imageData.setFlashMode(isFlashOn());
    }

    public CameraCallbackInterface getCameraCallback() {
        return this.f38930j;
    }

    public boolean getEnableFlashOnStart() {
        return this.f38937q;
    }

    public ExecutorService getExecutorService() {
        return this.f38934n;
    }

    public boolean getFocusing() {
        return this.f38939s;
    }

    public Frame.MetaData getFrameMetadata() {
        return this.f38933m;
    }

    public boolean getHasMultipleCameras() {
        return Camera.getNumberOfCameras() > 1;
    }

    public boolean getManualFocusEnabled() {
        return this.f38938r;
    }

    public PreviewProperties getPreviewProperties() {
        return this.f38932l;
    }

    public Size getPreviewSize() {
        return this.f38928h;
    }

    public Size getRequestedSize() {
        return this.f38940t;
    }

    public DeviceRotationManager getRotationManager() {
        return this.f38927g;
    }

    public final TextureView getTextureView() {
        return this.f38929i;
    }

    public boolean isFlashOn() {
        return this.f38936p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isFlashSupported() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f38925e
            monitor-enter(r0)
            android.hardware.Camera r1 = r3.f38922b     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x002a
            android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch:{ Exception -> 0x0024 }
            java.util.List r1 = r1.getSupportedFlashModes()     // Catch:{ Exception -> 0x0024 }
            if (r1 == 0) goto L_0x0028
            java.lang.String r2 = "torch"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0024 }
            if (r2 != 0) goto L_0x0021
            java.lang.String r2 = "on"
            boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x0024 }
            if (r1 == 0) goto L_0x0028
        L_0x0021:
            monitor-exit(r0)
            r0 = 1
            return r0
        L_0x0024:
            r1 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r1)     // Catch:{ all -> 0x002d }
        L_0x0028:
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x002d }
        L_0x002a:
            monitor-exit(r0)
            r0 = 0
            return r0
        L_0x002d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.Camera1Manager.isFlashSupported():boolean");
    }

    public boolean isFrontFacing() {
        return this.f38935o;
    }

    public boolean isPausePreview() {
        return this.f38931k;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        TextureView textureView = this.f38929i;
        int i11 = 0;
        int width = textureView != null ? textureView.getWidth() : 0;
        TextureView textureView2 = this.f38929i;
        if (textureView2 != null) {
            i11 = textureView2.getHeight();
        }
        requestFocus(width, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        CameraCallbackInterface cameraCallback = getCameraCallback();
        if (cameraCallback != null) {
            Frame.MetaData copy$default = Frame.MetaData.copy$default(getFrameMetadata(), (Size) null, 0, 0, 0, 0, false, 0, 0, 255, (Object) null);
            copy$default.setIso(0);
            try {
                copy$default.setIso(a(camera.getParameters()));
            } catch (Exception unused) {
            }
            copy$default.setTimeStamp(System.currentTimeMillis());
            Unit unit = Unit.f56620a;
            cameraCallback.onPreviewFrame(new Frame(bArr, copy$default));
        }
        synchronized (this.f38925e) {
            byte[] bArr2 = this.f38924d;
            if (bArr2 != null) {
                camera.addCallbackBuffer(bArr2);
                Unit unit2 = Unit.f56620a;
            }
        }
    }

    public synchronized void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
        getExecutorService().submit(new a(surfaceTexture, i11, i12, getRotationManager().isScreenPortrait(), getRotationManager().getDisplayRotation()));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        stopPreview(isPausePreview());
        destroy();
        return true;
    }

    public synchronized void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
        getExecutorService().submit(new e(surfaceTexture, i11, i12, getRotationManager().isScreenPortrait(), getRotationManager().getDisplayRotation()));
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (isPausePreview()) {
            return false;
        }
        int x11 = (int) motionEvent.getX();
        int y11 = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            requestFocus(x11, y11);
        }
        return false;
    }

    public synchronized void reinitCamera() {
        stopPreview(false);
        destroy();
        TextureView textureView = this.f38929i;
        SurfaceTexture surfaceTexture = textureView != null ? textureView.getSurfaceTexture() : null;
        if (!(textureView == null || surfaceTexture == null)) {
            onSurfaceTextureAvailable(surfaceTexture, textureView.getWidth(), textureView.getHeight());
        }
    }

    public synchronized void requestFocus(int i11, int i12) {
        getExecutorService().submit(new c(i11, i12));
    }

    public void setCameraCallback(CameraCallbackInterface cameraCallbackInterface) {
        this.f38930j = cameraCallbackInterface;
    }

    public void setCameraFacing(boolean z11) {
        this.f38923c = 0;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        int i11 = 0;
        while (true) {
            if (i11 >= numberOfCameras) {
                break;
            }
            try {
                Camera.getCameraInfo(i11, cameraInfo);
                setFrontFacing(cameraInfo.facing == 1);
                if ((z11 && cameraInfo.facing == 1) || (!z11 && cameraInfo.facing == 0)) {
                    this.f38923c = i11;
                }
            } catch (Exception e11) {
                Log.printStackTrace(e11);
            }
            i11++;
        }
        if (!isPausePreview() && this.f38922b != null) {
            try {
                reinitCamera();
            } catch (Exception e12) {
                Log.printStackTrace(e12);
            }
        }
    }

    public void setEnableFlashOnStart(boolean z11) {
        this.f38937q = z11;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.f38934n = executorService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setFlash(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f38925e
            monitor-enter(r0)
            android.hardware.Camera r1 = r3.f38922b     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            boolean r2 = r3.isFlashSupported()     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x000f
            monitor-exit(r0)
            return
        L_0x000f:
            r3.setFlashOn(r4)     // Catch:{ all -> 0x0025 }
            android.hardware.Camera$Parameters r2 = r1.getParameters()     // Catch:{ Exception -> 0x001d }
            a((android.hardware.Camera.Parameters) r2, (boolean) r4)     // Catch:{ Exception -> 0x001d }
            r1.setParameters(r2)     // Catch:{ Exception -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r4 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r4)     // Catch:{ all -> 0x0025 }
        L_0x0021:
            kotlin.Unit r4 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r0)
            return
        L_0x0025:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.Camera1Manager.setFlash(boolean):void");
    }

    public void setFlashOn(boolean z11) {
        this.f38936p = z11;
    }

    public void setFocusing(boolean z11) {
        this.f38939s = z11;
    }

    public void setFrameMetadata(Frame.MetaData metaData) {
        this.f38933m = metaData;
    }

    public void setFrontFacing(boolean z11) {
        this.f38935o = z11;
    }

    public void setManualFocusEnabled(boolean z11) {
        this.f38938r = z11;
    }

    public void setPausePreview(boolean z11) {
        this.f38931k = z11;
    }

    public void setPreviewProperties(PreviewProperties previewProperties) {
        this.f38932l = previewProperties;
    }

    public void setPreviewSize(Size size) {
        this.f38928h = size;
    }

    public void setRequestedSize(Size size) {
        this.f38940t = size;
    }

    public void setRotationManager(DeviceRotationManager deviceRotationManager) {
        this.f38927g = deviceRotationManager;
    }

    public final void setTextureView(TextureView textureView) {
        this.f38929i = textureView;
    }

    public void setup(Context context, CameraScanView cameraScanView, CameraCallbackInterface cameraCallbackInterface) {
        TextureView textureView = new TextureView(context);
        textureView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        cameraScanView.addView(textureView, 0);
        textureView.setSurfaceTextureListener(this);
        textureView.setOpaque(false);
        textureView.setOnClickListener(this);
        textureView.setOnTouchListener(this);
        this.f38929i = textureView;
        cameraScanView.invalidate();
        setCameraCallback(cameraCallbackInterface);
    }

    public void startPreview() {
        synchronized (this.f38925e) {
            Camera camera = this.f38922b;
            if (camera != null) {
                try {
                    if (!(this.f38924d != null || getPreviewSize().getWidth() == 0 || getPreviewSize().getHeight() == 0)) {
                        this.f38924d = new byte[(((getPreviewSize().getWidth() * getPreviewSize().getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8)];
                    }
                    camera.addCallbackBuffer(this.f38924d);
                    camera.setPreviewCallbackWithBuffer(this);
                    camera.startPreview();
                } catch (Exception e11) {
                    Log.printStackTrace(e11);
                    reinitCamera();
                }
            }
            setPausePreview(false);
            Unit unit = Unit.f56620a;
        }
    }

    public synchronized void stopPreview(boolean z11) {
        getExecutorService().submit(new d());
        setPausePreview(z11);
    }

    public static void a(Camera.Parameters parameters, boolean z11) {
        if (parameters.getSupportedFlashModes() == null || z11) {
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            boolean z12 = false;
            if (supportedFlashModes != null && supportedFlashModes.contains("torch")) {
                parameters.setFlashMode("torch");
                return;
            }
            List<String> supportedFlashModes2 = parameters.getSupportedFlashModes();
            if (supportedFlashModes2 != null && supportedFlashModes2.contains("on")) {
                z12 = true;
            }
            if (z12) {
                parameters.setFlashMode("on");
                return;
            }
            return;
        }
        parameters.setFlashMode("off");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.hardware.Camera.Parameters r5) {
        /*
            r0 = 0
            java.lang.String r1 = "iso"
            java.lang.String r2 = "iso-speed"
            java.lang.String r3 = "nv-picture-iso"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3}     // Catch:{ Exception -> 0x0036 }
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.n(r1)     // Catch:{ Exception -> 0x0036 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0036 }
        L_0x0013:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0036 }
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0036 }
            r3 = 1
            if (r5 == 0) goto L_0x002e
            java.lang.String r4 = r5.get(r2)     // Catch:{ Exception -> 0x0036 }
            if (r4 == 0) goto L_0x002a
            r4 = r3
            goto L_0x002b
        L_0x002a:
            r4 = r0
        L_0x002b:
            if (r4 != r3) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r3 = r0
        L_0x002f:
            if (r3 == 0) goto L_0x0013
            int r5 = r5.getInt(r2)     // Catch:{ Exception -> 0x0036 }
            return r5
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.Camera1Manager.a(android.hardware.Camera$Parameters):int");
    }

    public final Camera a(int i11) {
        Camera camera;
        TextureView textureView;
        int numberOfCameras = Camera.getNumberOfCameras();
        boolean z11 = false;
        this.f38923c = (numberOfCameras <= 0 || i11 >= numberOfCameras) ? 0 : i11;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(i11, cameraInfo);
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
        if (cameraInfo.facing == 1) {
            z11 = true;
        }
        setFrontFacing(z11);
        long currentTimeMillis = System.currentTimeMillis();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        loop0:
        while (true) {
            camera = null;
            while (camera == null && System.currentTimeMillis() - currentTimeMillis <= 2000) {
                try {
                    camera = Camera.open(i11);
                } catch (Throwable th2) {
                    ref$ObjectRef.element = th2;
                }
            }
        }
        if (!(camera != null || ref$ObjectRef.element == null || (textureView = this.f38929i) == null)) {
            textureView.post(new gw.c(this, ref$ObjectRef));
        }
        return camera;
    }

    public void setCameraFacing(JumioCameraFacing jumioCameraFacing) {
        this.f38923c = 0;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        int i11 = 0;
        while (i11 < numberOfCameras) {
            try {
                Camera.getCameraInfo(i11, cameraInfo);
                setFrontFacing(cameraInfo.facing == 1);
                if ((jumioCameraFacing == JumioCameraFacing.FRONT && cameraInfo.facing == 1) || (jumioCameraFacing == JumioCameraFacing.BACK && cameraInfo.facing == 0)) {
                    this.f38923c = i11;
                    return;
                }
                i11++;
            } catch (Exception e11) {
                Log.printStackTrace(e11);
                return;
            }
        }
    }

    public static final void a(Camera1Manager camera1Manager, Ref$ObjectRef ref$ObjectRef) {
        CameraCallbackInterface cameraCallback = camera1Manager.getCameraCallback();
        if (cameraCallback != null) {
            cameraCallback.onCameraError((Throwable) ref$ObjectRef.element);
        }
    }

    public final void a() {
        TextureView textureView;
        synchronized (this.f38925e) {
            this.f38922b = a(this.f38923c);
            Unit unit = Unit.f56620a;
        }
        boolean isFlashSupported = isFlashSupported();
        if (isFlashSupported && getEnableFlashOnStart()) {
            setFlash(true);
        }
        if (this.f38922b != null && (textureView = this.f38929i) != null) {
            textureView.post(new gw.d(this, isFlashSupported));
        }
    }

    public static final void a(Camera1Manager camera1Manager, boolean z11) {
        CameraCallbackInterface cameraCallback = camera1Manager.getCameraCallback();
        if (cameraCallback != null) {
            cameraCallback.onCameraAvailable(z11);
        }
    }

    public final void a(SurfaceTexture surfaceTexture, int i11, int i12, boolean z11, int i13) {
        synchronized (this.f38925e) {
            Camera camera = this.f38922b;
            if (camera != null) {
                try {
                    camera.setPreviewTexture(surfaceTexture);
                } catch (Throwable th2) {
                    Log.e("DefaultCameraManager", "Exception in setPreviewTexture()", th2);
                }
                Camera.Parameters parameters = camera.getParameters();
                b(parameters, FALLBACK_AUTO_FOCUS_LIST.contains(Build.MODEL));
                Matrix a11 = a(parameters, i11, i12, z11);
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                try {
                    Camera.getCameraInfo(this.f38923c, cameraInfo);
                } catch (Exception e11) {
                    Log.printStackTrace(e11);
                }
                int calculateCameraRotation = calculateCameraRotation(cameraInfo, i13);
                Camera camera2 = this.f38922b;
                if (camera2 != null) {
                    camera2.setDisplayOrientation(calculateCameraRotation);
                }
                Camera camera3 = this.f38922b;
                if (camera3 != null) {
                    camera3.setParameters(parameters);
                }
                Frame.MetaData frameMetadata = getFrameMetadata();
                frameMetadata.setSize(new Size(getPreviewSize().getWidth(), getPreviewSize().getHeight()));
                frameMetadata.setOrientation(calculateCameraRotation);
                frameMetadata.setRotation(cameraInfo.orientation);
                frameMetadata.setImageFormat(parameters.getPreviewFormat());
                frameMetadata.setPortrait(z11);
                PreviewProperties previewProperties = getPreviewProperties();
                previewProperties.setSurface(new Size(i11, i12));
                previewProperties.setFrontFacing(isFrontFacing());
                previewProperties.setSensorRotation(cameraInfo.orientation);
                TextureView textureView = this.f38929i;
                if (textureView != null) {
                    textureView.post(new gw.b(this, a11));
                }
            }
        }
    }

    public static final void a(Camera1Manager camera1Manager, Matrix matrix) {
        CameraCallbackInterface cameraCallback = camera1Manager.getCameraCallback();
        if (cameraCallback != null) {
            cameraCallback.onPreviewAvailable(camera1Manager.getPreviewProperties());
        }
        TextureView textureView = camera1Manager.f38929i;
        if (textureView != null) {
            textureView.setTransform(matrix);
        }
    }

    public final Matrix a(Camera.Parameters parameters, int i11, int i12, boolean z11) {
        Size size;
        float f11;
        float f12;
        float f13;
        int i13;
        float f14;
        int i14;
        int i15;
        int i16 = 0;
        if (getRequestedSize() == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            Camera.Size size2 = supportedPreviewSizes.get(0);
            String[] strArr = FALLBACK_PREVIEW_FORMAT_LIST;
            if (CollectionsKt__CollectionsKt.n(Arrays.copyOf(strArr, strArr.length)).contains(Build.MODEL) && size2.width == 1920 && size2.height == 1080) {
                supportedPreviewSizes.remove(0);
                size2 = supportedPreviewSizes.get(0);
            }
            for (Camera.Size next : supportedPreviewSizes) {
                if (next.width >= size2.width && next.height >= size2.height) {
                    size2 = next;
                }
            }
            size = new Size(size2.width, size2.height);
        } else {
            Camera.Size size3 = parameters.getSupportedPreviewSizes().get(0);
            Size requestedSize = getRequestedSize();
            if (requestedSize != null) {
                for (Camera.Size next2 : parameters.getSupportedPreviewSizes()) {
                    if (next2.width < requestedSize.getWidth() || next2.height < requestedSize.getHeight()) {
                        Camera.Size size4 = size3;
                        if (next2.width >= size4.width) {
                            if (next2.height < size4.height) {
                            }
                        }
                    }
                    size3 = next2;
                }
            }
            Camera.Size size5 = size3;
            size = new Size(size5.width, size5.height);
        }
        setPreviewSize(size);
        if (i11 > i12) {
            f12 = (float) i11;
            f11 = (float) i12;
        } else {
            f12 = (float) i12;
            f11 = (float) i11;
        }
        float f15 = f12 / f11;
        try {
            parameters.set("metering", TtmlNode.CENTER);
        } catch (Exception unused) {
        }
        float width = ((float) getPreviewSize().getWidth()) / ((float) getPreviewSize().getHeight());
        parameters.setPreviewSize(getPreviewSize().getWidth(), getPreviewSize().getHeight());
        float f16 = 1.0f;
        if (width == 1.0f) {
            getPreviewProperties().setPreview(new Size(getPreviewSize().getWidth(), getPreviewSize().getHeight()));
            i16 = i11 > i12 ? i11 : i12;
            float f17 = (float) i16;
            f14 = f17 / ((float) i11);
            f16 = f17 / ((float) i12);
            i13 = i16;
        } else {
            if (z11) {
                getPreviewProperties().setPreview(new Size(getPreviewSize().getHeight(), getPreviewSize().getWidth()));
                if (width >= f15) {
                    i14 = (int) (width * ((float) i11));
                } else {
                    if (width < f15) {
                        i15 = (int) (((float) i12) / width);
                        f14 = ((float) i16) / ((float) i11);
                        i13 = i12;
                    }
                    f13 = 1.0f;
                    i13 = 0;
                    getPreviewProperties().setScaledPreview(new Size(i16, i13));
                    Matrix matrix = new Matrix();
                    float f18 = (float) 2;
                    matrix.setScale(f16, f13, ((float) i11) / f18, ((float) i12) / f18);
                    return matrix;
                }
            } else {
                getPreviewProperties().setPreview(new Size(getPreviewSize().getWidth(), getPreviewSize().getHeight()));
                if (width <= f15) {
                    i14 = (int) (((float) i11) / width);
                } else {
                    if (width > f15) {
                        i15 = (int) (width * ((float) i12));
                        f14 = ((float) i16) / ((float) i11);
                        i13 = i12;
                    }
                    f13 = 1.0f;
                    i13 = 0;
                    getPreviewProperties().setScaledPreview(new Size(i16, i13));
                    Matrix matrix2 = new Matrix();
                    float f182 = (float) 2;
                    matrix2.setScale(f16, f13, ((float) i11) / f182, ((float) i12) / f182);
                    return matrix2;
                }
            }
            f13 = ((float) i14) / ((float) i12);
            i13 = i14;
            i16 = i11;
            getPreviewProperties().setScaledPreview(new Size(i16, i13));
            Matrix matrix22 = new Matrix();
            float f1822 = (float) 2;
            matrix22.setScale(f16, f13, ((float) i11) / f1822, ((float) i12) / f1822);
            return matrix22;
        }
        float f19 = f14;
        f13 = f16;
        f16 = f19;
        getPreviewProperties().setScaledPreview(new Size(i16, i13));
        Matrix matrix222 = new Matrix();
        float f18222 = (float) 2;
        matrix222.setScale(f16, f13, ((float) i11) / f18222, ((float) i12) / f18222);
        return matrix222;
    }
}
