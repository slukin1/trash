package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.h;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.l;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.a;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.egl.d;
import com.tencent.liteav.videobase.frame.FrameMetaData;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.liteav.videobase.frame.i;
import com.tencent.liteav.videobase.utils.BitmapUtils;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.g;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.c;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videobase.videobase.f;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;
import com.tencent.liteav.videoconsumer.renderer.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public final class t extends r implements RenderViewHelperInterface.RenderViewListener {
    private final Size A = new Size();
    private a B;
    private s C;
    private boolean D = false;
    private Bitmap E;
    private final com.tencent.liteav.base.b.a F = new com.tencent.liteav.base.b.a(5000);
    private a G;
    private List<PointF> H;
    private List<PointF> I;

    /* renamed from: a  reason: collision with root package name */
    public final String f22471a = ("VideoRenderer_" + hashCode());

    /* renamed from: b  reason: collision with root package name */
    public final g f22472b = new g();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f22473c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22474d = false;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f22475e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    private final CustomHandler f22476f;

    /* renamed from: g  reason: collision with root package name */
    private final c f22477g;

    /* renamed from: h  reason: collision with root package name */
    private final l f22478h;

    /* renamed from: i  reason: collision with root package name */
    private final l f22479i = new l(5);

    /* renamed from: j  reason: collision with root package name */
    private final b f22480j = new b();

    /* renamed from: k  reason: collision with root package name */
    private final Size f22481k = new Size();

    /* renamed from: l  reason: collision with root package name */
    private Surface f22482l = null;

    /* renamed from: m  reason: collision with root package name */
    private boolean f22483m = false;

    /* renamed from: n  reason: collision with root package name */
    private Object f22484n;

    /* renamed from: o  reason: collision with root package name */
    private EGLCore f22485o = null;

    /* renamed from: p  reason: collision with root package name */
    private final com.tencent.liteav.videobase.frame.c f22486p = new com.tencent.liteav.videobase.frame.c();

    /* renamed from: q  reason: collision with root package name */
    private i f22487q;

    /* renamed from: r  reason: collision with root package name */
    private e f22488r;

    /* renamed from: s  reason: collision with root package name */
    private GLConstants.GLScaleType f22489s = GLConstants.GLScaleType.CENTER_CROP;

    /* renamed from: t  reason: collision with root package name */
    private k f22490t = k.NORMAL;

    /* renamed from: u  reason: collision with root package name */
    private boolean f22491u = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f22492v = false;

    /* renamed from: w  reason: collision with root package name */
    private DisplayTarget f22493w;

    /* renamed from: x  reason: collision with root package name */
    private RenderViewHelperInterface f22494x;

    /* renamed from: y  reason: collision with root package name */
    private final Size f22495y = new Size();

    /* renamed from: z  reason: collision with root package name */
    private boolean f22496z = false;

    public t(Looper looper, c cVar) {
        this.f22476f = new CustomHandler(looper);
        this.f22478h = null;
        this.f22477g = cVar;
    }

    public static /* synthetic */ void a(t tVar, s sVar) {
        LiteavLog.i(tVar.f22471a, "Start");
        if (tVar.f22473c) {
            LiteavLog.w(tVar.f22471a, "renderer is started!");
            return;
        }
        tVar.f22473c = true;
        tVar.C = sVar;
        DisplayTarget displayTarget = tVar.f22493w;
        if (displayTarget != null) {
            tVar.b(displayTarget, true);
        }
        tVar.F.f21407a = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: private */
    public void b(DisplayTarget displayTarget, boolean z11) {
        String str = this.f22471a;
        LiteavLog.i(str, "setDisplayViewInternal=" + displayTarget + ",clearLastImage=" + z11);
        boolean equals = CommonUtil.equals(this.f22493w, displayTarget);
        if (!equals || displayTarget == null || this.f22494x == null) {
            if (!equals) {
                this.D = true;
                DisplayTarget displayTarget2 = this.f22493w;
                if (displayTarget2 != null && z11) {
                    displayTarget2.hideAll();
                }
            }
            a(z11);
            this.f22493w = displayTarget;
            if (displayTarget != null) {
                displayTarget.showAll();
                this.f22494x = RenderViewHelperInterface.create(displayTarget, this);
                return;
            }
            return;
        }
        LiteavLog.w(this.f22471a, "view is equal and RenderViewHelper is created.");
    }

    public static /* synthetic */ void c(t tVar) {
        k kVar;
        RenderViewHelperInterface renderViewHelperInterface;
        PixelFrame a11 = tVar.f22472b.a();
        if (a11 == null) {
            LiteavLog.d(tVar.f22471a, "renderFrameInternal pixelFrame is null!");
            return;
        }
        tVar.f22495y.set(a11.getWidth(), a11.getHeight());
        FrameMetaData metaData = a11.getMetaData();
        if (metaData != null) {
            tVar.f22490t = metaData.getRenderRotation();
            tVar.f22491u = metaData.isRenderMirrorHorizontal();
            tVar.f22492v = metaData.isRenderMirrorVertical();
            tVar.f22495y.set(metaData.getCaptureRealSize());
        }
        if (tVar.F.a() && (renderViewHelperInterface = tVar.f22494x) != null) {
            renderViewHelperInterface.checkViewAvailability();
        }
        if (tVar.f22496z) {
            RenderViewHelperInterface renderViewHelperInterface2 = tVar.f22494x;
            if (renderViewHelperInterface2 != null) {
                renderViewHelperInterface2.updateVideoFrameInfo(tVar.f22489s, a11.getWidth(), a11.getHeight(), tVar.f22496z);
            }
            int i11 = s.a.f22469d;
        } else if (tVar.f22494x == null) {
            int i12 = s.a.f22468c;
        } else if (!tVar.a(a11)) {
            int i13 = s.a.f22466a;
            LiteavLog.e(tVar.f22480j.a("makeCurrent"), tVar.f22471a, "make current failed.", new Object[0]);
        } else {
            tVar.b();
            PixelFrame pixelFrame = new PixelFrame(a11);
            boolean z11 = tVar.f22491u;
            boolean z12 = tVar.f22492v;
            k kVar2 = tVar.f22490t;
            pixelFrame.setRotation(k.a((pixelFrame.getRotation().mValue + kVar2.mValue) % 360));
            if (z11) {
                pixelFrame.setMirrorHorizontal(!pixelFrame.isMirrorHorizontal());
            }
            if (z12) {
                pixelFrame.setMirrorVertical(!pixelFrame.isMirrorVertical());
            }
            if (kVar2 == k.ROTATION_90 || kVar2 == k.ROTATION_270) {
                int width = pixelFrame.getWidth();
                pixelFrame.setWidth(pixelFrame.getHeight());
                pixelFrame.setHeight(width);
            }
            pixelFrame.setMirrorVertical(!pixelFrame.isMirrorVertical());
            if (!(pixelFrame.getRotation() == k.NORMAL || pixelFrame.getRotation() == (kVar = k.ROTATION_180))) {
                pixelFrame.setRotation(k.a((pixelFrame.getRotation().mValue + kVar.mValue) % 360));
            }
            tVar.A.width = pixelFrame.getWidth();
            tVar.A.height = pixelFrame.getHeight();
            tVar.a(pixelFrame, tVar.f22489s);
            if (tVar.B != null) {
                OpenGlUtils.bindFramebuffer(36160, 0);
                Size size = tVar.f22481k;
                int i14 = size.width;
                int i15 = size.height;
                a aVar = tVar.B;
                if (aVar != null) {
                    tVar.B = null;
                    ByteBuffer b11 = com.tencent.liteav.videobase.utils.e.b(i14 * i15 * 4);
                    if (b11 == null) {
                        LiteavLog.e(tVar.f22471a, "snapshotVideoFrameFromFrameBuffer, allocate direct buffer failed.");
                        aVar.onComplete((Bitmap) null);
                    } else {
                        b11.order(ByteOrder.nativeOrder());
                        b11.position(0);
                        GLES20.glReadPixels(0, 0, i14, i15, 6408, 5121, b11);
                        tVar.f22475e.post(w.a(tVar, tVar.f22494x, b11, i14, i15, aVar));
                    }
                }
            }
            if (!tVar.c() || OpenGlUtils.getGLErrorCount() > 0) {
                int i16 = s.a.f22466a;
                LiteavLog.e(tVar.f22480j.a("renderFailed"), tVar.f22471a, "render frame failed.", new Object[0]);
            } else {
                int i17 = s.a.f22467b;
                if (tVar.D) {
                    tVar.f22477g.notifyEvent(e.b.EVT_VIDEO_RENDER_FIRST_FRAME_ON_VIEW, a11, (String) null);
                    tVar.D = false;
                }
            }
        }
        a11.release();
    }

    public final void onRequestRedraw(Bitmap bitmap) {
        a(bitmap);
        a(y.a(this));
    }

    public final void onSurfaceChanged(Surface surface, boolean z11) {
        a(x.a(this, surface, z11));
    }

    public final void onSurfaceDestroy() {
        Runnable a11 = z.a(this);
        l lVar = this.f22478h;
        if (lVar != null) {
            lVar.a(a11, 2000);
        } else if (Looper.myLooper() == this.f22476f.getLooper()) {
            a11.run();
        } else {
            this.f22476f.runAndWaitDone(a11, 2000);
        }
    }

    public static /* synthetic */ void a(t tVar, boolean z11) {
        ArrayList arrayList;
        Surface surface;
        LiteavLog.i(tVar.f22471a, "Stop,clearLastImage=".concat(String.valueOf(z11)));
        if (!tVar.f22473c) {
            LiteavLog.w(tVar.f22471a, "renderer is not started!");
            return;
        }
        tVar.f22473c = false;
        tVar.B = null;
        tVar.a(z11);
        DisplayTarget displayTarget = tVar.f22493w;
        if (displayTarget != null && z11) {
            displayTarget.hideAll();
        }
        g gVar = tVar.f22472b;
        synchronized (gVar) {
            arrayList = new ArrayList(gVar.f22273a);
            gVar.f22273a.clear();
        }
        LiteavLog.i("RingFrameQueue", "evictAll pixelFrame.");
        PixelFrame.releasePixelFrames(arrayList);
        tVar.a();
        if (tVar.f22483m && (surface = tVar.f22482l) != null) {
            surface.release();
            tVar.f22483m = false;
        }
        tVar.f22482l = null;
        tVar.f22481k.set(0, 0);
        tVar.f22495y.set(0, 0);
        tVar.f22474d = false;
    }

    private void b() {
        EGLCore eGLCore = this.f22485o;
        if (eGLCore != null) {
            Size surfaceSize = eGLCore.getSurfaceSize();
            if (!this.f22481k.equals(surfaceSize)) {
                com.tencent.liteav.base.b.a a11 = this.f22480j.a("updateSurfaceSize");
                String str = this.f22471a;
                LiteavLog.i(a11, str, "surface size changed,old size=" + this.f22481k + ",new size=" + surfaceSize, new Object[0]);
                this.f22481k.set(surfaceSize);
                if (this.f22482l != null) {
                    c cVar = this.f22477g;
                    f fVar = f.STATUS_VIDEO_RENDER_RESOLUTION;
                    Size size = this.f22481k;
                    cVar.updateStatus(fVar, Integer.valueOf(size.height | (size.width << 16)));
                }
            }
        }
    }

    public static /* synthetic */ void b(t tVar) {
        PixelFrame createFromBitmap;
        Bitmap a11 = tVar.a((Bitmap) null);
        if (a11 != null && (createFromBitmap = PixelFrame.createFromBitmap(a11)) != null && tVar.a(createFromBitmap)) {
            tVar.b();
            createFromBitmap.setMirrorVertical(true);
            tVar.a(createFromBitmap, tVar.f22489s);
            tVar.c();
        }
    }

    public final void a(DisplayTarget displayTarget, boolean z11) {
        a(ac.a(this, displayTarget, z11));
    }

    public final void a(GLConstants.GLScaleType gLScaleType) {
        a(ad.a(this, gLScaleType));
    }

    public static /* synthetic */ void a(t tVar, GLConstants.GLScaleType gLScaleType) {
        if (tVar.f22489s != gLScaleType) {
            LiteavLog.i(tVar.f22471a, "setScaleType ".concat(String.valueOf(gLScaleType)));
            tVar.f22489s = gLScaleType;
        }
    }

    public final void a(k kVar) {
        a(ae.a(this, kVar));
    }

    public static /* synthetic */ void a(t tVar, k kVar) {
        if (tVar.f22490t != kVar) {
            LiteavLog.i(tVar.f22471a, "setRenderRotation ".concat(String.valueOf(kVar)));
            tVar.f22490t = kVar;
        }
    }

    public final void a(Runnable runnable) {
        l lVar = this.f22478h;
        if (lVar != null) {
            lVar.a(runnable);
        } else if (Looper.myLooper() == this.f22476f.getLooper()) {
            runnable.run();
        } else {
            this.f22476f.post(runnable);
        }
    }

    private void a() {
        if (this.f22485o != null) {
            com.tencent.liteav.base.b.a a11 = this.f22480j.a("uninitGL");
            String str = this.f22471a;
            Object[] objArr = new Object[2];
            Surface surface = this.f22482l;
            objArr[0] = Integer.valueOf(surface != null ? surface.hashCode() : 0);
            objArr[1] = this.f22481k;
            LiteavLog.i(a11, str, "uninitializeEGL %d %s", objArr);
            try {
                this.f22485o.makeCurrent();
            } catch (d e11) {
                LiteavLog.e(this.f22480j.a("makeCurrentError"), this.f22471a, "uninitializeEGL EGLCore makeCurrent failed.".concat(String.valueOf(e11)), new Object[0]);
            }
            a aVar = this.G;
            if (aVar != null) {
                i iVar = aVar.f22396g;
                if (iVar != null) {
                    iVar.a();
                    aVar.f22396g = null;
                }
                com.tencent.liteav.videobase.b.b bVar = aVar.f22393d;
                if (bVar != null) {
                    bVar.b();
                    aVar.f22393d = null;
                }
                this.G = null;
            }
            i iVar2 = this.f22487q;
            if (iVar2 != null) {
                iVar2.a();
                this.f22487q = null;
            }
            this.f22486p.d();
            com.tencent.liteav.videobase.frame.e eVar = this.f22488r;
            if (eVar != null) {
                eVar.a();
                this.f22488r.b();
                this.f22488r = null;
            }
            EGLCore.destroy(this.f22485o);
            this.f22485o = null;
        }
    }

    private boolean c() {
        try {
            this.f22485o.swapBuffers();
            return true;
        } catch (d e11) {
            LiteavLog.e(this.f22480j.a("swapBuffers"), this.f22471a, "EGLCore swapBuffers failed.".concat(String.valueOf(e11)), new Object[0]);
            this.f22477g.notifyWarning(e.c.WARNING_VIDEO_RENDER_SWAP_BUFFER, "VideoRender: swapBuffer error:".concat(String.valueOf(e11)));
            return false;
        }
    }

    private boolean a(PixelFrame pixelFrame) {
        Object gLContext = pixelFrame.getGLContext();
        if (this.f22485o == null || (gLContext != null && !CommonUtil.equals(this.f22484n, gLContext))) {
            a();
            Object gLContext2 = pixelFrame.getGLContext();
            if (this.f22482l == null) {
                LiteavLog.e(this.f22480j.a("initGLNoSurface"), this.f22471a, "Initialize EGL failed because surface is null", new Object[0]);
            } else {
                try {
                    com.tencent.liteav.base.b.a a11 = this.f22480j.a("initGL");
                    String str = this.f22471a;
                    LiteavLog.i(a11, str, "initializeEGL surface=" + this.f22482l + ",size=" + this.f22481k, new Object[0]);
                    EGLCore eGLCore = new EGLCore();
                    this.f22485o = eGLCore;
                    Surface surface = this.f22482l;
                    Size size = this.f22481k;
                    eGLCore.initialize(gLContext2, surface, size.width, size.height);
                    this.f22484n = gLContext2;
                    this.f22485o.makeCurrent();
                    if (this.f22488r == null) {
                        this.f22488r = new com.tencent.liteav.videobase.frame.e();
                    }
                    this.f22486p.a();
                } catch (d e11) {
                    LiteavLog.e(this.f22480j.a("initGLError"), this.f22471a, "initializeEGL failed.", (Throwable) e11);
                    this.f22485o = null;
                    this.f22477g.notifyWarning(e.c.WARNING_VIDEO_RENDER_EGL_CORE_CREATE_FAILED, "VideoRender: create EGLCore fail:".concat(String.valueOf(e11)));
                }
            }
        }
        EGLCore eGLCore2 = this.f22485o;
        if (eGLCore2 == null) {
            return false;
        }
        try {
            eGLCore2.makeCurrent();
            return true;
        } catch (d e12) {
            LiteavLog.e(this.f22480j.a("makeCurrentForFrameError"), this.f22471a, "EGLCore makeCurrent failed.".concat(String.valueOf(e12)), new Object[0]);
            return false;
        }
    }

    private void a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType) {
        RenderViewHelperInterface renderViewHelperInterface = this.f22494x;
        if (renderViewHelperInterface != null) {
            renderViewHelperInterface.updateVideoFrameInfo(this.f22489s, this.A.getWidth(), this.A.getHeight(), this.f22496z);
        }
        if (this.f22481k.isValid()) {
            if (this.f22494x instanceof k) {
                gLScaleType = GLConstants.GLScaleType.FILL;
            }
            List<PointF> list = this.H;
            List<PointF> list2 = this.I;
            if (list != null && list.size() == 4 && list2 != null && list2.size() == 4) {
                if (this.G == null) {
                    com.tencent.liteav.videobase.frame.e eVar = this.f22488r;
                    Size size = this.f22481k;
                    a aVar = new a(eVar, size.width, size.height);
                    this.G = aVar;
                    List<PointF> list3 = this.H;
                    List<PointF> list4 = this.I;
                    aVar.f22398i = list3;
                    aVar.f22399j = list4;
                    aVar.f22400k = true;
                }
                RenderViewHelperInterface renderViewHelperInterface2 = this.f22494x;
                if (renderViewHelperInterface2 != null) {
                    a aVar2 = this.G;
                    Size size2 = this.f22481k;
                    Matrix transformMatrix = renderViewHelperInterface2.getTransformMatrix(size2.width, size2.height);
                    if (!h.a(aVar2.f22397h, transformMatrix)) {
                        aVar2.f22397h = transformMatrix;
                        aVar2.f22400k = true;
                    }
                }
                a aVar3 = this.G;
                Size size3 = this.f22481k;
                int i11 = size3.width;
                int i12 = size3.height;
                Size size4 = aVar3.f22391b;
                if (!(size4.width == i11 && size4.height == i12)) {
                    size4.set(i11, i12);
                    aVar3.f22400k = true;
                }
                a aVar4 = this.G;
                if (aVar4.f22391b.isValid()) {
                    if (aVar4.f22396g == null) {
                        String str = aVar4.f22390a;
                        LiteavLog.i(str, "create PixelFrameRenderer, size =" + aVar4.f22391b);
                        Size size5 = aVar4.f22391b;
                        aVar4.f22396g = new i(size5.width, size5.height);
                    }
                    Size size6 = aVar4.f22391b;
                    OpenGlUtils.glViewport(0, 0, size6.width, size6.height);
                    com.tencent.liteav.videobase.frame.e eVar2 = aVar4.f22392c;
                    Size size7 = aVar4.f22391b;
                    com.tencent.liteav.videobase.frame.d a11 = eVar2.a(size7.width, size7.height);
                    i iVar = aVar4.f22396g;
                    Size size8 = aVar4.f22391b;
                    iVar.a(size8.width, size8.height);
                    aVar4.f22396g.a(pixelFrame, gLScaleType, a11);
                    com.tencent.liteav.videobase.b.b bVar = aVar4.f22393d;
                    if (bVar == null && bVar == null) {
                        com.tencent.liteav.videobase.b.b bVar2 = new com.tencent.liteav.videobase.b.b();
                        aVar4.f22393d = bVar2;
                        bVar2.a(aVar4.f22392c);
                        if (aVar4.f22394e == null || aVar4.f22395f == null) {
                            aVar4.f22394e = OpenGlUtils.createNormalCubeVerticesBuffer();
                            aVar4.f22395f = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
                        }
                    }
                    if (aVar4.f22400k) {
                        aVar4.a(aVar4.f22398i, aVar4.f22399j);
                        aVar4.f22400k = false;
                    }
                    aVar4.f22393d.a(a11.a(), (com.tencent.liteav.videobase.frame.d) null, aVar4.f22394e, aVar4.f22395f);
                    a11.release();
                    return;
                }
                return;
            }
            Size size9 = this.f22481k;
            OpenGlUtils.glViewport(0, 0, size9.width, size9.height);
            if (this.f22487q == null) {
                String str2 = this.f22471a;
                LiteavLog.i(str2, "create PixelFrameRenderer, surfaceSize=" + this.f22481k);
                Size size10 = this.f22481k;
                this.f22487q = new i(size10.width, size10.height);
            }
            i iVar2 = this.f22487q;
            Size size11 = this.f22481k;
            iVar2.a(size11.width, size11.height);
            this.f22487q.a(pixelFrame, gLScaleType, (com.tencent.liteav.videobase.frame.d) null);
        }
    }

    public static /* synthetic */ void a(t tVar, RenderViewHelperInterface renderViewHelperInterface, ByteBuffer byteBuffer, int i11, int i12, a aVar) {
        Matrix matrix = null;
        TextureView textureView = renderViewHelperInterface instanceof k ? ((k) renderViewHelperInterface).f22441a : null;
        if (textureView != null) {
            matrix = textureView.getTransform(new Matrix());
        }
        tVar.f22479i.a(aa.a(tVar, byteBuffer, i11, i12, matrix, aVar));
    }

    private void a(Surface surface, boolean z11) {
        Surface surface2;
        if (h.a(this.f22482l, surface)) {
            LiteavLog.d(this.f22471a, "updateSurface same surface!");
            return;
        }
        a();
        if (this.f22483m && (surface2 = this.f22482l) != null) {
            surface2.release();
        }
        this.f22482l = surface;
        if (surface == null) {
            this.f22481k.set(0, 0);
        }
        this.f22483m = z11;
    }

    private void a(boolean z11) {
        RenderViewHelperInterface renderViewHelperInterface = this.f22494x;
        if (renderViewHelperInterface != null) {
            renderViewHelperInterface.release(z11);
            this.f22494x = null;
        }
    }

    public static /* synthetic */ void a(t tVar, Surface surface, boolean z11) {
        LiteavLog.i(tVar.f22471a, "onSurfaceChanged surface: %s, oldSurface: %s, isNeedRelease: %b", surface, tVar.f22482l, Boolean.valueOf(z11));
        tVar.a(surface, z11);
    }

    private Bitmap a(Bitmap bitmap) {
        Bitmap bitmap2;
        synchronized (this) {
            bitmap2 = this.E;
            this.E = bitmap;
        }
        return bitmap2;
    }

    public static /* synthetic */ void a(t tVar) {
        String str = tVar.f22471a;
        LiteavLog.i(str, "onSurfaceDestroy " + tVar.f22482l);
        tVar.a((Surface) null, tVar.f22483m);
    }

    public static /* synthetic */ void a(t tVar, ByteBuffer byteBuffer, int i11, int i12, Matrix matrix, a aVar) {
        try {
            byteBuffer.position(0);
            Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(byteBuffer);
            if (matrix == null) {
                matrix = new Matrix();
            }
            matrix.postScale(1.0f, -1.0f, ((float) i11) / 2.0f, ((float) i12) / 2.0f);
            aVar.onComplete(BitmapUtils.createBitmap(createBitmap, matrix, true));
        } catch (Throwable th2) {
            LiteavLog.e(tVar.f22471a, "build snapshot bitmap failed.", th2);
            aVar.onComplete((Bitmap) null);
        }
    }
}
