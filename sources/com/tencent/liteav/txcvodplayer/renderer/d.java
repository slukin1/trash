package com.tencent.liteav.txcvodplayer.renderer;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.liteav.videobase.frame.i;
import com.tencent.liteav.videobase.frame.k;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.g;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videoconsumer.renderer.ab;
import com.tencent.liteav.videoconsumer.renderer.t;
import com.tencent.liteav.videoconsumer.renderer.u;
import com.tencent.liteav.videoconsumer.renderer.v;
import java.util.ArrayList;
import java.util.Iterator;

public final class d implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public CustomHandler f22017a;

    /* renamed from: b  reason: collision with root package name */
    public EGLCore f22018b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public t f22019c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public DisplayTarget f22020d;

    /* renamed from: e  reason: collision with root package name */
    private GLConstants.GLScaleType f22021e = GLConstants.GLScaleType.FIT_CENTER;

    /* renamed from: f  reason: collision with root package name */
    private k f22022f = k.NORMAL;

    /* renamed from: g  reason: collision with root package name */
    private SurfaceTexture f22023g;

    /* renamed from: h  reason: collision with root package name */
    private int f22024h = -1;

    /* renamed from: i  reason: collision with root package name */
    private PixelFrame f22025i;

    /* renamed from: j  reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.k f22026j;

    /* renamed from: k  reason: collision with root package name */
    private i f22027k;

    /* renamed from: l  reason: collision with root package name */
    private e f22028l;

    /* renamed from: m  reason: collision with root package name */
    private final float[] f22029m = new float[16];

    /* renamed from: n  reason: collision with root package name */
    private int f22030n = 720;

    /* renamed from: o  reason: collision with root package name */
    private int f22031o = 1280;

    /* renamed from: p  reason: collision with root package name */
    private final a f22032p;

    public interface a {
        void a(SurfaceTexture surfaceTexture);

        void a(PixelFrame pixelFrame);

        void f();
    }

    public d(a aVar) {
        this.f22032p = aVar;
    }

    public static /* synthetic */ void b(d dVar) {
        LiteavLog.i("VodRenderer", "Start");
        t tVar = dVar.f22019c;
        if (tVar != null) {
            tVar.a(dVar.f22020d, true);
            dVar.f22019c.a(dVar.f22022f);
            dVar.f22019c.a(dVar.f22021e);
            t tVar2 = dVar.f22019c;
            tVar2.a(u.a(tVar2));
        }
    }

    public final void a(boolean z11) {
        a(f.a(this, z11), "Stop");
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        a(l.a(this, surfaceTexture), "onFrameAvailable");
    }

    public static /* synthetic */ void a(d dVar, boolean z11) {
        LiteavLog.i("VodRenderer", "Stop");
        t tVar = dVar.f22019c;
        if (tVar != null) {
            tVar.a(ab.a(tVar, z11));
        }
    }

    public static /* synthetic */ void a(d dVar, DisplayTarget displayTarget) {
        LiteavLog.i("VodRenderer", "setDisplayTarget: ".concat(String.valueOf(displayTarget)));
        dVar.f22020d = displayTarget;
        t tVar = dVar.f22019c;
        if (tVar != null) {
            tVar.a(displayTarget, true);
        }
    }

    private boolean b() {
        EGLCore eGLCore = this.f22018b;
        if (eGLCore == null) {
            LiteavLog.e("VodRenderer", "makeCurrent on mEGLCore is null");
            return false;
        }
        try {
            eGLCore.makeCurrent();
            return true;
        } catch (com.tencent.liteav.videobase.egl.d e11) {
            LiteavLog.e("VodRenderer", "make current failed.", (Throwable) e11);
            return false;
        }
    }

    public static /* synthetic */ void a(d dVar, int i11, int i12) {
        if (dVar.f22030n != i11 || dVar.f22031o != i12) {
            LiteavLog.i("VodRenderer", "setVideoSize: %d*%d", Integer.valueOf(i11), Integer.valueOf(i12));
            dVar.f22030n = i11;
            dVar.f22031o = i12;
            dVar.f22025i.setWidth(i11);
            dVar.f22025i.setHeight(dVar.f22031o);
            i iVar = dVar.f22027k;
            if (iVar != null) {
                iVar.a();
                dVar.f22027k = null;
            }
            e eVar = dVar.f22028l;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public final void a(GLConstants.GLScaleType gLScaleType) {
        a(i.a(this, gLScaleType), "setScaleType");
    }

    public static /* synthetic */ void a(d dVar, GLConstants.GLScaleType gLScaleType) {
        LiteavLog.i("VodRenderer", "setScaleType ".concat(String.valueOf(gLScaleType)));
        dVar.f22021e = gLScaleType;
        t tVar = dVar.f22019c;
        if (tVar != null) {
            tVar.a(gLScaleType);
        }
    }

    public final void a(k kVar) {
        a(j.a(this, kVar), "setRenderRotation");
    }

    public static /* synthetic */ void a(d dVar, k kVar) {
        LiteavLog.i("VodRenderer", "setRenderRotation ".concat(String.valueOf(kVar)));
        dVar.f22022f = kVar;
        t tVar = dVar.f22019c;
        if (tVar != null) {
            tVar.a(kVar);
        }
    }

    public final void a() {
        ArrayList arrayList;
        if (this.f22018b != null) {
            com.tencent.liteav.videobase.frame.k kVar = this.f22026j;
            if (kVar != null) {
                kVar.f22212c = true;
                synchronized (kVar) {
                    arrayList = new ArrayList(kVar.f22210a);
                    kVar.f22210a.clear();
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
                this.f22026j = null;
            }
            try {
                this.f22018b.makeCurrent();
                a aVar = this.f22032p;
                if (aVar != null) {
                    aVar.f();
                }
                SurfaceTexture surfaceTexture = this.f22023g;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    this.f22023g = null;
                }
                OpenGlUtils.deleteTexture(this.f22024h);
                this.f22024h = -1;
                i iVar = this.f22027k;
                if (iVar != null) {
                    iVar.a();
                    this.f22027k = null;
                }
                e eVar = this.f22028l;
                if (eVar != null) {
                    eVar.a();
                    this.f22028l.b();
                    this.f22028l = null;
                }
            } catch (com.tencent.liteav.videobase.egl.d e11) {
                LiteavLog.e("VodRenderer", "EGLCore destroy failed.", (Throwable) e11);
            }
            EGLCore.destroy(this.f22018b);
            this.f22018b = null;
        }
    }

    public final void a(Runnable runnable, String str) {
        CustomHandler customHandler = this.f22017a;
        if (customHandler == null) {
            LiteavLog.w("VodRenderer", "ignore runnable: ".concat(String.valueOf(str)));
        } else if (customHandler.getLooper() != Looper.myLooper()) {
            customHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static /* synthetic */ void a(d dVar, SurfaceTexture surfaceTexture) {
        com.tencent.liteav.videobase.frame.k kVar;
        k.b bVar;
        SurfaceTexture surfaceTexture2 = dVar.f22023g;
        if (surfaceTexture2 == null || surfaceTexture != surfaceTexture2) {
            LiteavLog.i("VodRenderer", "mSurfaceTexture= " + dVar.f22023g + " ,surfaceTexture= " + surfaceTexture);
        } else if (dVar.b()) {
            if (dVar.f22028l == null || (kVar = dVar.f22026j) == null) {
                LiteavLog.w("VodRenderer", "onCaptureFrameAvailable mGLTexturePool:" + dVar.f22028l + " mTextureHolderPool:" + dVar.f22026j);
                return;
            }
            PixelFrame pixelFrame = null;
            try {
                bVar = (k.b) kVar.a();
            } catch (InterruptedException unused) {
                bVar = null;
            }
            try {
                dVar.f22023g.updateTexImage();
                dVar.f22023g.getTransformMatrix(dVar.f22029m);
                dVar.f22025i.setMatrix(dVar.f22029m);
            } catch (Exception e11) {
                LiteavLog.w("VodRenderer", "updateTexImage exception: ".concat(String.valueOf(e11)));
            }
            int i11 = dVar.f22024h;
            int width = dVar.f22025i.getWidth();
            int height = dVar.f22025i.getHeight();
            bVar.f22233b = 36197;
            bVar.f22232a = i11;
            bVar.f22234c = width;
            bVar.f22235d = height;
            PixelFrame a11 = bVar.a(dVar.f22025i.getGLContext());
            a11.setMatrix(dVar.f22029m);
            if (dVar.f22027k == null) {
                dVar.f22027k = new i(dVar.f22030n, dVar.f22031o);
            }
            OpenGlUtils.glViewport(0, 0, dVar.f22030n, dVar.f22031o);
            com.tencent.liteav.videobase.frame.d a12 = dVar.f22028l.a(dVar.f22030n, dVar.f22031o);
            dVar.f22027k.a(a11, GLConstants.GLScaleType.CENTER_CROP, a12);
            PixelFrame a13 = a12.a(dVar.f22018b.getEglContext());
            a12.release();
            a aVar = dVar.f22032p;
            if (aVar != null) {
                aVar.a(a13);
            }
            t tVar = dVar.f22019c;
            if (tVar != null && tVar.f22473c) {
                if (!tVar.f22474d) {
                    tVar.f22474d = true;
                    LiteavLog.d(tVar.f22471a, "VideoRender receive first frame!");
                }
                g gVar = tVar.f22472b;
                a13.retain();
                synchronized (gVar) {
                    if (gVar.f22273a.size() >= gVar.f22274b) {
                        pixelFrame = gVar.f22273a.removeFirst();
                    }
                    gVar.f22273a.addLast(a13);
                }
                if (pixelFrame != null) {
                    pixelFrame.release();
                }
                tVar.a(v.a(tVar));
            }
            bVar.release();
            a11.release();
            a13.release();
        }
    }

    public static /* synthetic */ void a(d dVar) {
        if (dVar.f22018b == null) {
            dVar.f22018b = new EGLCore();
            if (dVar.f22026j == null) {
                dVar.f22026j = new com.tencent.liteav.videobase.frame.k();
            }
            try {
                dVar.f22018b.initialize((Object) null, (Surface) null, 128, 128);
                dVar.f22018b.makeCurrent();
                dVar.f22024h = OpenGlUtils.generateTextureOES();
                SurfaceTexture surfaceTexture = new SurfaceTexture(dVar.f22024h);
                dVar.f22023g = surfaceTexture;
                surfaceTexture.setDefaultBufferSize(dVar.f22030n, dVar.f22031o);
                dVar.f22023g.setOnFrameAvailableListener(dVar);
                PixelFrame pixelFrame = new PixelFrame();
                dVar.f22025i = pixelFrame;
                pixelFrame.setWidth(dVar.f22030n);
                dVar.f22025i.setHeight(dVar.f22031o);
                dVar.f22025i.setPixelBufferType(GLConstants.a.TEXTURE_OES);
                dVar.f22025i.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
                dVar.f22025i.setRotation(com.tencent.liteav.base.util.k.NORMAL);
                dVar.f22025i.setGLContext(dVar.f22018b.getEglContext());
                dVar.f22025i.setTextureId(dVar.f22024h);
                dVar.f22028l = new e();
                a aVar = dVar.f22032p;
                if (aVar != null) {
                    aVar.a(dVar.f22023g);
                }
            } catch (com.tencent.liteav.videobase.egl.d e11) {
                LiteavLog.e("VodRenderer", "initializeEGL failed.", (Throwable) e11);
                dVar.f22018b = null;
            }
        }
        dVar.f22019c = new t(dVar.f22017a.getLooper(), new com.tencent.liteav.videobase.videobase.d());
    }
}
