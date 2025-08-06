package com.huobi.kyc.huaweiliveness.camera;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class a implements Camera.AutoFocusCallback, Camera.PreviewCallback {

    /* renamed from: k  reason: collision with root package name */
    public static final String f74808k = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public Activity f74809b;

    /* renamed from: c  reason: collision with root package name */
    public Camera f74810c;

    /* renamed from: d  reason: collision with root package name */
    public Camera.Parameters f74811d;

    /* renamed from: e  reason: collision with root package name */
    public Camera.CameraInfo f74812e = new Camera.CameraInfo();

    /* renamed from: f  reason: collision with root package name */
    public int f74813f;

    /* renamed from: g  reason: collision with root package name */
    public int f74814g;

    /* renamed from: h  reason: collision with root package name */
    public float f74815h = ((((float) this.f74814g) * 1.0f) / ((float) this.f74813f));

    /* renamed from: i  reason: collision with root package name */
    public c f74816i;

    /* renamed from: j  reason: collision with root package name */
    public OrientationEventListener f74817j;

    /* renamed from: com.huobi.kyc.huaweiliveness.camera.a$a  reason: collision with other inner class name */
    public class C0800a extends OrientationEventListener {
        public C0800a(Context context) {
            super(context);
        }

        public void onOrientationChanged(int i11) {
        }
    }

    public class b implements Comparator<Camera.Size> {
        public b() {
        }

        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            return (size2.width * size2.height) - (size.width * size.height);
        }
    }

    public interface c {
        void a(byte[] bArr, int i11, int i12);
    }

    public a(Activity activity) {
        this.f74809b = activity;
        this.f74817j = new C0800a(this.f74809b);
    }

    public Activity a() {
        return this.f74809b;
    }

    public final List<Camera.Size> b() {
        List<Camera.Size> supportedPreviewSizes = this.f74811d.getSupportedPreviewSizes();
        Collections.sort(supportedPreviewSizes, new b());
        Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
        while (it2.hasNext()) {
            Camera.Size next = it2.next();
            if (next.width > 640 || next.height > 640) {
                it2.remove();
            }
        }
        return supportedPreviewSizes;
    }

    public int c() {
        return this.f74814g;
    }

    public int d() {
        return this.f74813f;
    }

    public final Camera.Size e(List<Camera.Size> list) {
        int i11 = Integer.MAX_VALUE;
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            Camera.Size size = list.get(i13);
            Log.v(f74808k, "SupportedSize, width: " + size.width + ", height: " + size.height);
            int i14 = size.width;
            if (((float) i14) * this.f74815h == ((float) size.height)) {
                int abs = Math.abs(this.f74813f - i14);
                if (abs == 0) {
                    return size;
                }
                if (i11 > abs) {
                    i12 = i13;
                    i11 = abs;
                }
            }
        }
        return list.get(i12);
    }

    public final void f() {
        String str = f74808k;
        Log.v(str, "initConfig");
        try {
            Camera.Parameters parameters = this.f74810c.getParameters();
            this.f74811d = parameters;
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes != null && supportedFlashModes.contains("off")) {
                this.f74811d.setFlashMode("off");
            }
            List<String> supportedFocusModes = this.f74811d.getSupportedFocusModes();
            if (supportedFocusModes != null && supportedFocusModes.contains(TtmlNode.TEXT_EMPHASIS_AUTO)) {
                this.f74811d.setFocusMode(TtmlNode.TEXT_EMPHASIS_AUTO);
            }
            this.f74811d.setPreviewFormat(17);
            Camera.Size e11 = e(b());
            int i11 = e11.width;
            this.f74813f = i11;
            int i12 = e11.height;
            this.f74814g = i12;
            this.f74811d.setPreviewSize(i11, i12);
            Log.d(str, "previewWidth: " + this.f74813f + ", previewHeight: " + this.f74814g);
            this.f74810c.setParameters(this.f74811d);
            this.f74810c.setPreviewCallback(this);
        } catch (Exception e12) {
            Log.e(f74808k, "initConfig error", e12);
        }
    }

    public void g() {
        String str = f74808k;
        Log.d(str, "openCamera cameraId: 1");
        this.f74810c = Camera.open(1);
        Camera.getCameraInfo(1, this.f74812e);
        f();
        i();
        Log.d(str, "openCamera enable mOrientationEventListener");
        this.f74817j.enable();
    }

    public void h() {
        if (this.f74810c != null) {
            Log.v(f74808k, "releaseCamera");
            this.f74810c.setPreviewCallback((Camera.PreviewCallback) null);
            this.f74810c.stopPreview();
            this.f74810c.release();
            this.f74810c = null;
        }
        this.f74817j.disable();
    }

    public final void i() {
        int i11;
        int rotation = this.f74809b.getWindowManager().getDefaultDisplay().getRotation();
        int i12 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i12 = 90;
            } else if (rotation == 2) {
                i12 = 180;
            } else if (rotation == 3) {
                i12 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f74812e;
        if (cameraInfo.facing == 1) {
            i11 = (360 - ((cameraInfo.orientation + i12) % 360)) % 360;
        } else {
            i11 = ((cameraInfo.orientation - i12) + 360) % 360;
        }
        this.f74810c.setDisplayOrientation(i11);
    }

    public void j(c cVar) {
        this.f74816i = cVar;
    }

    public void k(SurfaceHolder surfaceHolder) {
        if (this.f74810c != null) {
            Log.i(f74808k, "startPreview");
            try {
                this.f74810c.setPreviewDisplay(surfaceHolder);
            } catch (IOException e11) {
                Log.e(f74808k, "startPreview error", e11);
            }
            this.f74810c.startPreview();
        }
    }

    public void onAutoFocus(boolean z11, Camera camera) {
        String str = f74808k;
        Log.d(str, "onAutoFocus: " + z11);
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.f74816i != null) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            this.f74816i.a(bArr, previewSize.width, previewSize.height);
        }
    }
}
