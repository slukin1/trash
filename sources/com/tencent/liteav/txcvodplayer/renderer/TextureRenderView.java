package com.tencent.liteav.txcvodplayer.renderer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;
import com.tencent.liteav.txcplayer.c;
import com.tencent.liteav.txcvodplayer.renderer.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TextureRenderView extends TextureView implements a {

    /* renamed from: a  reason: collision with root package name */
    private b f21992a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f21993b;

    public static final class b implements TextureView.SurfaceTextureListener, c {

        /* renamed from: a  reason: collision with root package name */
        public SurfaceTexture f21998a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f21999b;

        /* renamed from: c  reason: collision with root package name */
        public int f22000c;

        /* renamed from: d  reason: collision with root package name */
        public int f22001d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22002e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22003f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f22004g = false;

        /* renamed from: h  reason: collision with root package name */
        public WeakReference<TextureRenderView> f22005h;

        /* renamed from: i  reason: collision with root package name */
        public Map<a.C0173a, Object> f22006i = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.f22005h = new WeakReference<>(textureRenderView);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            this.f21998a = surfaceTexture;
            this.f21999b = false;
            this.f22000c = 0;
            this.f22001d = 0;
            a aVar = new a((TextureRenderView) this.f22005h.get(), surfaceTexture, this);
            for (a.C0173a a11 : this.f22006i.keySet()) {
                a11.a((a.b) aVar);
            }
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f21998a = surfaceTexture;
            this.f21999b = false;
            this.f22000c = 0;
            this.f22001d = 0;
            a aVar = new a((TextureRenderView) this.f22005h.get(), surfaceTexture, this);
            for (a.C0173a b11 : this.f22006i.keySet()) {
                b11.b(aVar);
            }
            LiteavLog.i("TextureRenderView", "onSurfaceTextureDestroyed: destroy: " + this.f22002e);
            return this.f22002e;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            this.f21998a = surfaceTexture;
            this.f21999b = true;
            this.f22000c = i11;
            this.f22001d = i12;
            a aVar = new a((TextureRenderView) this.f22005h.get(), surfaceTexture, this);
            for (a.C0173a a11 : this.f22006i.keySet()) {
                a11.a(aVar, i11, i12);
            }
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final void a(SurfaceTexture surfaceTexture) {
            if (surfaceTexture == null) {
                LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: null");
            } else if (this.f22004g) {
                if (surfaceTexture != this.f21998a) {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (!this.f22002e) {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture");
                    surfaceTexture.release();
                } else {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView");
                }
            } else if (this.f22003f) {
                if (surfaceTexture != this.f21998a) {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (!this.f22002e) {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView");
                    this.f22002e = true;
                } else {
                    LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView");
                }
            } else if (surfaceTexture != this.f21998a) {
                LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: alive: release different SurfaceTexture");
                surfaceTexture.release();
            } else if (!this.f22002e) {
                LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView");
                this.f22002e = true;
            } else {
                LiteavLog.i("TextureRenderView", "releaseSurfaceTexture: alive: will released by TextureView");
            }
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.f21992a = new b(this);
        b bVar = new b(this);
        this.f21993b = bVar;
        setSurfaceTextureListener(bVar);
    }

    public final boolean a() {
        return false;
    }

    public a.b getSurfaceHolder() {
        return new a(this, this.f21993b.f21998a, this.f21993b);
    }

    public View getView() {
        return this;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f21993b;
        LiteavLog.i("TextureRenderView", "onAttachFromWindow()");
        bVar.f22003f = false;
        bVar.f22004g = false;
    }

    public void onDetachedFromWindow() {
        try {
            b bVar = this.f21993b;
            LiteavLog.i("TextureRenderView", "willDetachFromWindow()");
            bVar.f22003f = true;
            super.onDetachedFromWindow();
            b bVar2 = this.f21993b;
            LiteavLog.i("TextureRenderView", "didDetachFromWindow()");
            bVar2.f22004g = true;
        } catch (Exception unused) {
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }

    public void onMeasure(int i11, int i12) {
        this.f21992a.c(i11, i12);
        b bVar = this.f21992a;
        setMeasuredDimension(bVar.f22008b, bVar.f22009c);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z11 = false;
        for (a.C0173a a11 : this.f21993b.f22006i.keySet()) {
            if (a11.a(motionEvent)) {
                z11 = true;
            }
        }
        if (!z11) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setAspectRatio(int i11) {
        this.f21992a.f22010d = i11;
        requestLayout();
    }

    public void setVideoRotation(int i11) {
        this.f21992a.f22007a = i11;
        setRotation((float) i11);
    }

    public final void a(int i11, int i12) {
        if (i11 > 0 && i12 > 0) {
            this.f21992a.a(i11, i12);
            requestLayout();
        }
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public final void a(a.C0173a aVar) {
        a aVar2;
        b bVar = this.f21993b;
        bVar.f22006i.put(aVar, aVar);
        if (bVar.f21998a != null) {
            aVar2 = new a((TextureRenderView) bVar.f22005h.get(), bVar.f21998a, bVar);
            aVar.a((a.b) aVar2);
        } else {
            aVar2 = null;
        }
        if (bVar.f21999b) {
            if (aVar2 == null) {
                aVar2 = new a((TextureRenderView) bVar.f22005h.get(), bVar.f21998a, bVar);
            }
            aVar.a(aVar2, bVar.f22000c, bVar.f22001d);
        }
    }

    public final void b(int i11, int i12) {
        if (i11 > 0 && i12 > 0) {
            this.f21992a.b(i11, i12);
            requestLayout();
        }
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }

    public final void b(a.C0173a aVar) {
        this.f21993b.f22006i.remove(aVar);
    }

    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        private TextureRenderView f21994a;

        /* renamed from: b  reason: collision with root package name */
        private SurfaceTexture f21995b;

        /* renamed from: c  reason: collision with root package name */
        private c f21996c;

        /* renamed from: d  reason: collision with root package name */
        private Surface f21997d;

        public a(TextureRenderView textureRenderView, SurfaceTexture surfaceTexture, c cVar) {
            this.f21994a = textureRenderView;
            this.f21995b = surfaceTexture;
            this.f21996c = cVar;
        }

        public final void a(ITXVCubePlayer iTXVCubePlayer) {
            if (iTXVCubePlayer != null) {
                if (LiteavSystemInfo.getSystemOSVersionInt() < 16 || !(iTXVCubePlayer instanceof com.tencent.liteav.txcplayer.b)) {
                    Surface b11 = b();
                    this.f21997d = b11;
                    iTXVCubePlayer.setSurface(b11);
                    return;
                }
                com.tencent.liteav.txcplayer.b bVar = (com.tencent.liteav.txcplayer.b) iTXVCubePlayer;
                this.f21994a.f21993b.f22002e = false;
                if (this.f21994a.getSurfaceTexture() != null) {
                    this.f21995b = this.f21994a.getSurfaceTexture();
                }
                try {
                    SurfaceTexture surfaceTexture = bVar.getSurfaceTexture();
                    if (surfaceTexture != null) {
                        bVar.setSurfaceTextureHost(this.f21994a.f21993b);
                        if (this.f21994a.getSurfaceTexture() != surfaceTexture) {
                            this.f21994a.setSurfaceTexture(surfaceTexture);
                        }
                        this.f21994a.f21993b.f21998a = surfaceTexture;
                    } else {
                        Surface surface = this.f21997d;
                        if (surface != null) {
                            iTXVCubePlayer.setSurface(surface);
                        }
                        bVar.setSurfaceTexture(this.f21995b);
                        bVar.setSurfaceTextureHost(this.f21994a.f21993b);
                    }
                    this.f21997d = iTXVCubePlayer.getSurface();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }

        public final Surface b() {
            if (this.f21995b == null) {
                return null;
            }
            if (this.f21997d == null) {
                this.f21997d = new Surface(this.f21995b);
            }
            return this.f21997d;
        }

        public final Surface c() {
            return this.f21997d;
        }

        public final a a() {
            return this.f21994a;
        }
    }
}
