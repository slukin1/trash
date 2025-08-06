package com.iproov.sdk.cameray;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.cameray.Ccase;
import com.iproov.sdk.cameray.Ctry;
import com.iproov.sdk.core.Cbreak;
import com.iproov.sdk.core.Ccatch;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p021new.Celse;
import com.iproov.sdk.p021new.Cgoto;
import com.iproov.sdk.p021new.Cthis;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iproov.sdk.cameray.if  reason: invalid class name */
public class Cif implements Ctry {
    /* access modifiers changed from: private */

    /* renamed from: return  reason: not valid java name */
    public static final String f99return = ("🎥2 " + Cif.class.getSimpleName());

    /* renamed from: static  reason: not valid java name */
    private static final RectF f100static = new RectF(0.4f, 0.4f, 0.6f, 0.6f);

    /* renamed from: break  reason: not valid java name */
    private HandlerThread f101break;

    /* renamed from: case  reason: not valid java name */
    private final ImageReader f102case;

    /* renamed from: catch  reason: not valid java name */
    private HandlerThread f103catch;

    /* renamed from: class  reason: not valid java name */
    private Handler f104class;

    /* renamed from: const  reason: not valid java name */
    private Handler f105const;
    /* access modifiers changed from: private */

    /* renamed from: do  reason: not valid java name */
    public final Semaphore f106do = new Semaphore(1);

    /* renamed from: else  reason: not valid java name */
    public final Surface f107else;
    /* access modifiers changed from: private */

    /* renamed from: final  reason: not valid java name */
    public CameraDevice f108final;

    /* renamed from: for  reason: not valid java name */
    public final CameraManager f109for;

    /* renamed from: goto  reason: not valid java name */
    public Surface f110goto;

    /* renamed from: if  reason: not valid java name */
    public final Ctry.Cdo f111if;
    /* access modifiers changed from: private */

    /* renamed from: import  reason: not valid java name */
    public RectF f112import = f100static;

    /* renamed from: native  reason: not valid java name */
    private final CameraDevice.StateCallback f113native = new Cfor();

    /* renamed from: new  reason: not valid java name */
    public final Cfor f114new;

    /* renamed from: public  reason: not valid java name */
    private CameraCaptureSession.CaptureCallback f115public = new Cdo();
    /* access modifiers changed from: private */

    /* renamed from: super  reason: not valid java name */
    public final Object f116super = new Object();

    /* renamed from: this  reason: not valid java name */
    public List<Surface> f117this;

    /* renamed from: throw  reason: not valid java name */
    private Cnew f118throw;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public Cgoto f119try;
    /* access modifiers changed from: private */

    /* renamed from: while  reason: not valid java name */
    public CameraCaptureSession f120while;

    /* renamed from: com.iproov.sdk.cameray.if$do  reason: invalid class name */
    public class Cdo extends CameraCaptureSession.CaptureCallback {
        public Cdo() {
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            Cif.this.f111if.m218do(new Cthis(totalCaptureResult));
        }
    }

    /* renamed from: com.iproov.sdk.cameray.if$for  reason: invalid class name */
    public class Cfor extends CameraDevice.StateCallback {
        public Cfor() {
        }

        public void onClosed(CameraDevice cameraDevice) {
            Cif.this.f106do.release();
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            Cif.this.m145break();
            Cif.this.f111if.m219do((Exception) new Ccase(Ccase.Cdo.CAMERA_ERROR, "error camera disconnected"));
        }

        public void onError(CameraDevice cameraDevice, int i11) {
            Cif.this.m145break();
            Ctry.Cdo doVar = Cif.this.f111if;
            Ccase.Cdo doVar2 = Ccase.Cdo.CAMERA_ERROR;
            doVar.m219do((Exception) new Ccase(doVar2, "error in camera: " + i11));
        }

        public void onOpened(CameraDevice cameraDevice) {
            CameraDevice unused = Cif.this.f108final = cameraDevice;
            Cif.this.f106do.release();
            Cbreak.m310do(Ccatch.AND2);
            try {
                Cif ifVar = Cif.this;
                Cif ifVar2 = Cif.this;
                ifVar.m151do(new Cnew(cameraDevice, (Cfor) Cif.this.m175if(), ifVar2.f117this, ifVar2.f119try, Cif.this.f112import));
                Cif ifVar3 = Cif.this;
                ifVar3.f111if.m217do(ifVar3.m175if(), Cif.this.m164this());
                Cif.this.m174goto();
            } catch (Exception e11) {
                Cif.this.f111if.m219do(e11);
            }
        }
    }

    /* renamed from: com.iproov.sdk.cameray.if$if  reason: invalid class name */
    public class Cif extends CameraCaptureSession.StateCallback {
        public Cif() {
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            IPLog.w(Cif.f99return, "CAMERA: onConfigureFailed");
            Cif.this.f111if.m219do((Exception) new Ccase(Ccase.Cdo.CAMERA_ERROR, "onConfigureFailed"));
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            synchronized (Cif.this.f116super) {
                if (Cif.this.f108final != null) {
                    CameraCaptureSession unused = Cif.this.f120while = cameraCaptureSession;
                    try {
                        Cif.this.m163new();
                    } catch (CameraAccessException e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: com.iproov.sdk.cameray.if$new  reason: invalid class name */
    public class Cnew implements ImageReader.OnImageAvailableListener {
        public Cnew() {
        }

        public void onImageAvailable(ImageReader imageReader) {
            Image image;
            try {
                synchronized (Cif.this.f116super) {
                    image = imageReader.acquireLatestImage();
                    if (image != null) {
                        Cbreak.m310do(Ccatch.AND3);
                        if (image.getHeight() == Cif.this.f114new.m135goto().getHeight() || image.getWidth() == Cif.this.f114new.m135goto().getWidth()) {
                            Cbreak.m310do(Ccatch.AND14);
                        }
                        Cwhile whileR = new Cwhile(image);
                        image.close();
                        Cif.this.m170do((com.iproov.sdk.p021new.Cfor) whileR);
                    }
                }
            } catch (RuntimeException e11) {
                if (Cif.this.m153do(e11)) {
                    image = null;
                } else {
                    throw e11;
                }
            } catch (Exception e12) {
                String str = Cif.f99return;
                IPLog.e(str, "Corrupt frame? " + e12.toString());
                e12.printStackTrace();
                Cif.this.f111if.m219do((Exception) new Ccase(Ccase.Cdo.CAMERA_ERROR, "Frame not available, perhaps corrupt", e12));
            } catch (Throwable th2) {
                image.close();
                throw th2;
            }
        }
    }

    public Cif(Context context, boolean z11, String str, Cbreak breakR, Ctry.Cdo doVar, com.iproov.sdk.p021new.Ctry tryR, Cgoto gotoR) throws Ccase {
        this.f111if = doVar;
        CameraManager cameraManager = (CameraManager) context.getSystemService(OptionsBridge.CAMERA_KEY);
        this.f109for = cameraManager;
        if (cameraManager != null) {
            HandlerThread handlerThread = new HandlerThread("Camera2 Capture");
            this.f101break = handlerThread;
            handlerThread.start();
            this.f105const = new Handler(this.f101break.getLooper());
            HandlerThread handlerThread2 = new HandlerThread("Camera2");
            this.f103catch = handlerThread2;
            handlerThread2.start();
            this.f104class = new Handler(this.f103catch.getLooper());
            try {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                Float f11 = Celse.m1193do(cameraCharacteristics);
                this.f119try = gotoR;
                Cfor forR = new Cfor(str, z11, breakR, cameraCharacteristics, f11, tryR);
                this.f114new = forR;
                ImageReader newInstance = ImageReader.newInstance(forR.m135goto().getWidth(), forR.m135goto().getHeight(), 35, 2);
                this.f102case = newInstance;
                newInstance.setOnImageAvailableListener(new Cnew(), this.f105const);
                this.f107else = newInstance.getSurface();
            } catch (CameraAccessException e11) {
                throw new Ccase(Ccase.Cdo.CAMERA_PERMISSION_DENIED, (Throwable) e11);
            }
        } else {
            throw new Ccase(Ccase.Cdo.CAMERA_ERROR, "Cannot open camera service");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: break  reason: not valid java name */
    public void m145break() {
        Semaphore semaphore;
        synchronized (this.f116super) {
            try {
                Cnew newR = this.f118throw;
                if (newR != null) {
                    newR.m193do(this.f107else);
                    this.f118throw.m193do(this.f110goto);
                }
                m173else();
                boolean z11 = m177try();
                this.f118throw = null;
                if (!z11) {
                    semaphore = this.f106do;
                    semaphore.release();
                }
            } catch (RuntimeException e11) {
                try {
                    this.f111if.m215do(Ctry.Cif.FAILED_TO_STOP_GRACEFULLY, (Exception) e11);
                    this.f118throw = null;
                    semaphore = this.f106do;
                } catch (Throwable th2) {
                    this.f118throw = null;
                    this.f106do.release();
                    throw th2;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: this  reason: not valid java name */
    public Size m164this() {
        return ((Cfor) m175if()).m135goto();
    }

    /* renamed from: case  reason: not valid java name */
    public void m166case() {
    }

    /* renamed from: catch  reason: not valid java name */
    public void m167catch() {
    }

    /* access modifiers changed from: private */
    /* renamed from: new  reason: not valid java name */
    public void m163new() throws CameraAccessException {
        CameraCaptureSession cameraCaptureSession;
        synchronized (this.f116super) {
            Cnew newR = this.f118throw;
            if (!(newR == null || (cameraCaptureSession = this.f120while) == null)) {
                cameraCaptureSession.setRepeatingRequest(newR.m191do(), this.f115public, this.f104class);
            }
        }
    }

    /* renamed from: else  reason: not valid java name */
    public void m173else() {
        synchronized (this.f116super) {
            CameraCaptureSession cameraCaptureSession = this.f120while;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.f120while = null;
            }
        }
    }

    /* renamed from: goto  reason: not valid java name */
    public void m174goto() throws CameraAccessException {
        if (this.f108final != null && this.f105const != null) {
            m173else();
            this.f108final.createCaptureSession(this.f117this, new Cif(), this.f105const);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m176if(SurfaceTexture surfaceTexture) {
        surfaceTexture.setDefaultBufferSize(this.f114new.m131case().getWidth(), this.f114new.m131case().getHeight());
        Surface surface = new Surface(surfaceTexture);
        this.f110goto = surface;
        this.f117this = Collections.unmodifiableList(Arrays.asList(new Surface[]{this.f107else, surface}));
    }

    /* renamed from: try  reason: not valid java name */
    public boolean m177try() {
        CameraDevice cameraDevice = this.f108final;
        boolean z11 = cameraDevice != null;
        if (z11) {
            cameraDevice.close();
            this.f108final = null;
        }
        this.f102case.close();
        this.f101break.quit();
        this.f101break = null;
        this.f103catch.quit();
        this.f103catch = null;
        this.f104class = null;
        this.f105const = null;
        return z11;
    }

    /* access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public /* synthetic */ void m157for(SurfaceTexture surfaceTexture) {
        try {
            if (!this.f106do.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
                this.f111if.m219do((Exception) new RuntimeException("Time out waiting to lock camera opening."));
                return;
            }
            m176if(surfaceTexture);
            this.f109for.openCamera(this.f114new.m138try(), this.f113native, (Handler) null);
        } catch (CameraAccessException | InterruptedException e11) {
            this.f111if.m219do((Exception) new Ccase(Ccase.Cdo.CAMERA_ERROR, "Failed to open camera", e11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public /* synthetic */ void m160if(Runnable runnable) {
        try {
            if (!this.f106do.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
                this.f111if.m219do((Exception) new RuntimeException("Time out waiting to lock camera closing."));
                return;
            }
            m145break();
            runnable.run();
        } catch (InterruptedException e11) {
            this.f111if.m219do((Exception) new Ccase(Ccase.Cdo.CAMERA_ERROR, "Failed to close camera", e11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public boolean m153do(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m151do(Cnew newR) {
        synchronized (this.f116super) {
            this.f118throw = newR;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public /* synthetic */ void m161if(boolean z11) {
        synchronized (this.f116super) {
            Cnew newR = this.f118throw;
            if (newR != null) {
                newR.m194do(z11);
                try {
                    m163new();
                } catch (CameraAccessException | IllegalStateException e11) {
                    this.f111if.m215do(Ctry.Cif.FAILED_TO_LOCK_EXPOSURE, e11);
                }
            } else {
                return;
            }
        }
        this.f111if.m220do(z11);
    }

    /* renamed from: do  reason: not valid java name */
    public void m170do(com.iproov.sdk.p021new.Cfor forR) {
        this.f111if.m216do(forR);
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: do  reason: not valid java name */
    public void m169do(SurfaceTexture surfaceTexture) {
        Handler handler = this.f104class;
        if (handler != null) {
            handler.post(new g(this, surfaceTexture));
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m171do(Runnable runnable) {
        Handler handler = this.f104class;
        if (handler != null) {
            handler.post(new h(this, runnable));
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m172do(boolean z11) {
        Handler handler = this.f104class;
        if (handler != null) {
            handler.post(new i(this, z11));
        }
    }

    /* renamed from: do  reason: not valid java name */
    public Cconst m168do() {
        return Cconst.CAMERA2;
    }

    /* renamed from: if  reason: not valid java name */
    public com.iproov.sdk.p021new.Cnew m175if() {
        return this.f114new;
    }
}
