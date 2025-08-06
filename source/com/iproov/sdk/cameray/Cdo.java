package com.iproov.sdk.cameray;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import com.iproov.sdk.cameray.Ccase;
import com.iproov.sdk.cameray.Ctry;
import com.iproov.sdk.core.Cbreak;
import com.iproov.sdk.core.Ccatch;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p021new.Cfor;
import com.iproov.sdk.p021new.Cgoto;
import com.iproov.sdk.p021new.Cnew;
import com.iproov.sdk.p021new.Cthis;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import m1.a;

/* renamed from: com.iproov.sdk.cameray.do  reason: invalid class name */
public class Cdo implements Ctry {

    /* renamed from: native  reason: not valid java name */
    private static final String f67native = ("🎥1 " + Cdo.class.getSimpleName());

    /* renamed from: public  reason: not valid java name */
    private static final Rect f68public = new Rect(-200, -200, 200, 200);
    /* access modifiers changed from: private */

    /* renamed from: break  reason: not valid java name */
    public Camera f69break;

    /* renamed from: case  reason: not valid java name */
    private final Cgoto f70case;

    /* renamed from: catch  reason: not valid java name */
    private boolean f71catch;

    /* renamed from: class  reason: not valid java name */
    public SurfaceTexture f72class;

    /* renamed from: const  reason: not valid java name */
    public Size f73const;

    /* renamed from: do  reason: not valid java name */
    private final int f74do;
    /* access modifiers changed from: private */

    /* renamed from: else  reason: not valid java name */
    public final Cbreak f75else;

    /* renamed from: final  reason: not valid java name */
    private HandlerThread f76final;

    /* renamed from: for  reason: not valid java name */
    private final Camera.PreviewCallback f77for;

    /* renamed from: goto  reason: not valid java name */
    private final AtomicBoolean f78goto = new AtomicBoolean(false);

    /* renamed from: if  reason: not valid java name */
    private final Ctry.Cdo f79if;
    /* access modifiers changed from: private */

    /* renamed from: import  reason: not valid java name */
    public volatile Float f80import;

    /* renamed from: new  reason: not valid java name */
    private final Cdo f81new;

    /* renamed from: super  reason: not valid java name */
    private Handler f82super;

    /* renamed from: this  reason: not valid java name */
    private volatile boolean f83this = false;

    /* renamed from: throw  reason: not valid java name */
    public final Camera.CameraInfo f84throw;

    /* renamed from: try  reason: not valid java name */
    private final com.iproov.sdk.p021new.Ctry f85try;

    /* renamed from: while  reason: not valid java name */
    private Rect f86while = f68public;

    /* renamed from: com.iproov.sdk.cameray.do$do  reason: invalid class name */
    public class Cdo implements Cnew {

        /* renamed from: do  reason: not valid java name */
        public final Orientation f87do;

        public Cdo(Orientation orientation) {
            this.f87do = orientation;
        }

        /* renamed from: for  reason: not valid java name */
        public Float m122for() {
            if (Cdo.this.f69break == null) {
                return null;
            }
            return Cdo.this.f80import;
        }

        /* renamed from: if  reason: not valid java name */
        public Cbreak m123if() {
            return Cdo.this.f75else;
        }

        /* renamed from: new  reason: not valid java name */
        public Orientation m124new() {
            return this.f87do;
        }
    }

    public Cdo(int i11, boolean z11, Cbreak breakR, Ctry.Cdo doVar, com.iproov.sdk.p021new.Ctry tryR, Cgoto gotoR) {
        this.f74do = i11;
        this.f75else = breakR;
        this.f79if = doVar;
        this.f85try = tryR;
        this.f70case = gotoR;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f84throw = cameraInfo;
        Camera.getCameraInfo(i11, cameraInfo);
        int i12 = cameraInfo.orientation;
        this.f81new = new Cdo(Orientation.findByDegrees(z11 ? (i12 + 270) % 360 : i12));
        HandlerThread handlerThread = new HandlerThread("Camera1", -8);
        this.f76final = handlerThread;
        handlerThread.start();
        this.f82super = new Handler(this.f76final.getLooper());
        this.f77for = new b(this, doVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: else  reason: not valid java name */
    public /* synthetic */ void m103else() {
        if (this.f69break == null || this.f83this) {
            this.f78goto.set(false);
            this.f83this = false;
            return;
        }
        try {
            this.f79if.m214do();
            this.f69break.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, new a(this));
        } catch (RuntimeException e11) {
            try {
                this.f79if.m215do(Ctry.Cif.FAILED_TO_TAKE_PICTURE, (Exception) e11);
                m99do((Size) null);
                this.f78goto.set(false);
            } catch (RuntimeException e12) {
                this.f79if.m219do((Exception) new Ccase(Ccase.Cdo.CAMERA_ERROR, "Failed to restart review after take picture failed", e12));
            }
        }
    }

    /* renamed from: new  reason: not valid java name */
    private int[] m110new() {
        Camera camera = this.f69break;
        if (camera == null) {
            return null;
        }
        try {
            for (int[] next : camera.getParameters().getSupportedPreviewFpsRange()) {
                if (next[1] >= 30000) {
                    return next;
                }
            }
        } catch (RuntimeException e11) {
            e11.printStackTrace();
        }
        return null;
    }

    /* renamed from: try  reason: not valid java name */
    private List<Size> m111try() {
        ArrayList arrayList = new ArrayList();
        Camera camera = this.f69break;
        if (camera != null) {
            for (Camera.Size next : camera.getParameters().getSupportedPreviewSizes()) {
                arrayList.add(new Size(next.width, next.height));
            }
        }
        return arrayList;
    }

    /* renamed from: case  reason: not valid java name */
    public void m112case() {
        Handler handler;
        if (this.f78goto.compareAndSet(false, true) && this.f69break != null && (handler = this.f82super) != null) {
            handler.postDelayed(new c(this), 480);
        }
    }

    /* renamed from: catch  reason: not valid java name */
    public void m113catch() {
        this.f83this = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r1 == null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r1.release();
        r4.f69break = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        r4.f76final.quit();
        r4.f76final = null;
        r4.f82super = null;
        r4.f71catch = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r1 != null) goto L_0x002b;
     */
    /* renamed from: goto  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m120goto() {
        /*
            r4 = this;
            r0 = 0
            android.hardware.Camera r1 = r4.f69break     // Catch:{ RuntimeException -> 0x001f, IOException -> 0x001d }
            if (r1 == 0) goto L_0x0016
            boolean r2 = r4.f71catch     // Catch:{ RuntimeException -> 0x001f, IOException -> 0x001d }
            if (r2 == 0) goto L_0x000c
            r1.stopPreview()     // Catch:{ RuntimeException -> 0x001f, IOException -> 0x001d }
        L_0x000c:
            android.hardware.Camera r1 = r4.f69break     // Catch:{ RuntimeException -> 0x001f, IOException -> 0x001d }
            r1.setPreviewTexture(r0)     // Catch:{ RuntimeException -> 0x001f, IOException -> 0x001d }
            android.hardware.Camera r1 = r4.f69break     // Catch:{ RuntimeException -> 0x001f, IOException -> 0x001d }
            r1.setPreviewCallback(r0)     // Catch:{ RuntimeException -> 0x001f, IOException -> 0x001d }
        L_0x0016:
            android.hardware.Camera r1 = r4.f69break
            if (r1 == 0) goto L_0x0030
            goto L_0x002b
        L_0x001b:
            r1 = move-exception
            goto L_0x003d
        L_0x001d:
            r1 = move-exception
            goto L_0x0020
        L_0x001f:
            r1 = move-exception
        L_0x0020:
            com.iproov.sdk.cameray.try$do r2 = r4.f79if     // Catch:{ all -> 0x001b }
            com.iproov.sdk.cameray.try$if r3 = com.iproov.sdk.cameray.Ctry.Cif.FAILED_TO_STOP_GRACEFULLY     // Catch:{ all -> 0x001b }
            r2.m215do((com.iproov.sdk.cameray.Ctry.Cif) r3, (java.lang.Exception) r1)     // Catch:{ all -> 0x001b }
            android.hardware.Camera r1 = r4.f69break
            if (r1 == 0) goto L_0x0030
        L_0x002b:
            r1.release()
            r4.f69break = r0
        L_0x0030:
            android.os.HandlerThread r1 = r4.f76final
            r1.quit()
            r4.f76final = r0
            r4.f82super = r0
            r0 = 0
            r4.f71catch = r0
            return
        L_0x003d:
            android.hardware.Camera r2 = r4.f69break
            if (r2 == 0) goto L_0x0046
            r2.release()
            r4.f69break = r0
        L_0x0046:
            android.os.HandlerThread r2 = r4.f76final
            r2.quit()
            r4.f76final = r0
            r4.f82super = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.cameray.Cdo.m120goto():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public /* synthetic */ void m100do(Ctry.Cdo doVar, byte[] bArr, Camera camera) {
        if (camera != null && bArr != null && bArr.length != 0) {
            try {
                Cthrow throwR = new Cthrow(this.f73const.getWidth(), this.f73const.getHeight(), bArr);
                Cbreak.m310do(Ccatch.AND3);
                Cbreak.m310do(Ccatch.AND14);
                m116do((Cfor) throwR);
            } catch (Exception e11) {
                String str = f67native;
                IPLog.e(str, "Corrupt frame? " + e11.toString());
                e11.printStackTrace();
                doVar.m216do((Cfor) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public void m109if(boolean z11) {
        Camera camera = this.f69break;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setAutoExposureLock(z11);
                parameters.setAutoWhiteBalanceLock(z11);
                this.f69break.setParameters(parameters);
                this.f79if.m220do(z11);
            } catch (IllegalStateException e11) {
                this.f79if.m215do(Ctry.Cif.FAILED_TO_LOCK_EXPOSURE, (Exception) e11);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public /* synthetic */ void m107if(SurfaceTexture surfaceTexture) {
        this.f72class = surfaceTexture;
        if (this.f69break == null) {
            try {
                this.f69break = Camera.open(this.f74do);
                m119for();
                if (this.f73const == null) {
                    m120goto();
                    this.f79if.m219do((Exception) new Ccase(Ccase.Cdo.CAMERA_ERROR, "No preview size available!"));
                    return;
                }
                Cbreak.m310do(Ccatch.AND2);
                this.f69break.setPreviewCallback(this.f77for);
                m99do(this.f73const);
            } catch (IOException | RuntimeException e11) {
                m120goto();
                this.f79if.m219do((Exception) new Ccase(Ccase.Cdo.CAMERA_ERROR, "Failed to open camera", e11));
            }
        }
    }

    /* renamed from: for  reason: not valid java name */
    public void m119for() throws IOException {
        int i11;
        Camera camera = this.f69break;
        if (camera != null) {
            if (this.f84throw.canDisableShutterSound) {
                camera.enableShutterSound(false);
            }
            Camera.Parameters parameters = this.f69break.getParameters();
            this.f80import = Float.valueOf(parameters.getFocalLength());
            parameters.setPreviewFormat(17);
            parameters.isZoomSupported();
            if (parameters.isZoomSupported() && (i11 = this.f70case.m1199do(Cconst.CAMERA1, Float.valueOf(this.f69break.getParameters().getFocalLength()), parameters.getZoomRatios())) != -1) {
                parameters.setZoom(i11);
            }
            this.f69break.setParameters(parameters);
            Size size = this.f85try.m1228do(Cconst.CAMERA1, m111try());
            this.f73const = size;
            if (size != null) {
                parameters.setPreviewSize(size.getWidth(), this.f73const.getHeight());
                this.f69break.setPreviewTexture(this.f72class);
                int[] iArr = m110new();
                if (iArr != null) {
                    parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                    this.f73const.getWidth();
                    this.f73const.getHeight();
                    int i12 = iArr[1] / 1000;
                }
                m102do(parameters);
                this.f69break.setParameters(parameters);
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m116do(Cfor forR) {
        this.f79if.m216do(forR);
    }

    /* renamed from: do  reason: not valid java name */
    public void m115do(SurfaceTexture surfaceTexture) {
        Handler handler = this.f82super;
        if (handler != null) {
            handler.post(new d(this, surfaceTexture));
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m117do(Runnable runnable) {
        Handler handler = this.f82super;
        if (handler != null) {
            handler.post(new e(this, runnable));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public /* synthetic */ void m108if(Runnable runnable) {
        m120goto();
        runnable.run();
    }

    /* renamed from: do  reason: not valid java name */
    public void m118do(boolean z11) {
        Handler handler = this.f82super;
        if (handler != null) {
            handler.post(new f(this, z11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public /* synthetic */ void m101do(byte[] bArr, Camera camera) {
        try {
            this.f79if.m218do(new Cthis(new a((InputStream) new ByteArrayInputStream(bArr))));
            m109if(true);
        } catch (IOException e11) {
            this.f79if.m215do(Ctry.Cif.FAILED_TO_READ_EXIF_DATA, (Exception) e11);
        } finally {
            m99do((Size) null);
            this.f78goto.set(false);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public Cnew m121if() {
        return this.f81new;
    }

    /* renamed from: do  reason: not valid java name */
    public Cconst m114do() {
        return Cconst.CAMERA1;
    }

    /* renamed from: do  reason: not valid java name */
    private boolean m102do(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Camera.Area(this.f86while, 1000));
        parameters.setMeteringAreas(arrayList);
        Objects.toString(this.f86while);
        return true;
    }

    /* renamed from: do  reason: not valid java name */
    private void m99do(Size size) {
        Camera camera = this.f69break;
        if (camera != null) {
            try {
                camera.setPreviewTexture(this.f72class);
                this.f69break.setPreviewCallback(this.f77for);
                this.f69break.startPreview();
                this.f71catch = true;
                if (size != null) {
                    this.f79if.m217do(m121if(), size);
                }
            } catch (IOException | RuntimeException e11) {
                e11.printStackTrace();
            }
        }
    }
}
