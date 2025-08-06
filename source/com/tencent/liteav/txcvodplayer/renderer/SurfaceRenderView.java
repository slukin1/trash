package com.tencent.liteav.txcvodplayer.renderer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;
import com.tencent.liteav.txcvodplayer.renderer.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SurfaceRenderView extends SurfaceView implements a {

    /* renamed from: a  reason: collision with root package name */
    private b f21981a;

    /* renamed from: b  reason: collision with root package name */
    private b f21982b;

    public static final class b implements SurfaceHolder.Callback {

        /* renamed from: a  reason: collision with root package name */
        public SurfaceHolder f21985a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f21986b;

        /* renamed from: c  reason: collision with root package name */
        public int f21987c;

        /* renamed from: d  reason: collision with root package name */
        public int f21988d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<SurfaceRenderView> f21989e;

        /* renamed from: f  reason: collision with root package name */
        public Map<a.C0173a, Object> f21990f = new ConcurrentHashMap();

        /* renamed from: g  reason: collision with root package name */
        private int f21991g;

        public b(SurfaceRenderView surfaceRenderView) {
            this.f21989e = new WeakReference<>(surfaceRenderView);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            this.f21985a = surfaceHolder;
            this.f21986b = true;
            this.f21991g = i11;
            this.f21987c = i12;
            this.f21988d = i13;
            a aVar = new a((SurfaceRenderView) this.f21989e.get(), this.f21985a);
            for (a.C0173a a11 : this.f21990f.keySet()) {
                a11.a(aVar, i12, i13);
            }
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f21985a = surfaceHolder;
            this.f21986b = false;
            this.f21991g = 0;
            this.f21987c = 0;
            this.f21988d = 0;
            a aVar = new a((SurfaceRenderView) this.f21989e.get(), this.f21985a);
            for (a.C0173a a11 : this.f21990f.keySet()) {
                a11.a((a.b) aVar);
            }
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f21985a = null;
            this.f21986b = false;
            this.f21991g = 0;
            this.f21987c = 0;
            this.f21988d = 0;
            a aVar = new a((SurfaceRenderView) this.f21989e.get(), this.f21985a);
            for (a.C0173a b11 : this.f21990f.keySet()) {
                b11.b(aVar);
            }
        }
    }

    public SurfaceRenderView(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.f21981a = new b(this);
        this.f21982b = new b(this);
        getHolder().addCallback(this.f21982b);
        getHolder().setType(0);
    }

    public final void a(int i11, int i12) {
        if (i11 > 0 && i12 > 0) {
            this.f21981a.a(i11, i12);
            getHolder().setFixedSize(i11, i12);
            requestLayout();
        }
    }

    public final boolean a() {
        return true;
    }

    public View getView() {
        return this;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SurfaceRenderView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 14) {
            accessibilityNodeInfo.setClassName(SurfaceRenderView.class.getName());
        }
    }

    public void onMeasure(int i11, int i12) {
        this.f21981a.c(i11, i12);
        b bVar = this.f21981a;
        setMeasuredDimension(bVar.f22008b, bVar.f22009c);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z11 = false;
        for (a.C0173a a11 : this.f21982b.f21990f.keySet()) {
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
        this.f21981a.f22010d = i11;
        requestLayout();
    }

    public void setVideoRotation(int i11) {
        LiteavLog.e("", "SurfaceView doesn't support rotation (" + i11 + ")!\n");
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        private SurfaceRenderView f21983a;

        /* renamed from: b  reason: collision with root package name */
        private SurfaceHolder f21984b;

        public a(SurfaceRenderView surfaceRenderView, SurfaceHolder surfaceHolder) {
            this.f21983a = surfaceRenderView;
            this.f21984b = surfaceHolder;
        }

        public final void a(ITXVCubePlayer iTXVCubePlayer) {
            if (iTXVCubePlayer != null) {
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 16 && (iTXVCubePlayer instanceof com.tencent.liteav.txcplayer.b)) {
                    ((com.tencent.liteav.txcplayer.b) iTXVCubePlayer).setSurfaceTexture((SurfaceTexture) null);
                }
                iTXVCubePlayer.setDisplay(this.f21984b);
            }
        }

        public final Surface b() {
            SurfaceHolder surfaceHolder = this.f21984b;
            if (surfaceHolder == null) {
                return null;
            }
            return surfaceHolder.getSurface();
        }

        public final Surface c() {
            return b();
        }

        public final a a() {
            return this.f21983a;
        }
    }

    public final void a(a.C0173a aVar) {
        a aVar2;
        b bVar = this.f21982b;
        bVar.f21990f.put(aVar, aVar);
        if (bVar.f21985a != null) {
            aVar2 = new a((SurfaceRenderView) bVar.f21989e.get(), bVar.f21985a);
            aVar.a((a.b) aVar2);
        } else {
            aVar2 = null;
        }
        if (bVar.f21986b) {
            if (aVar2 == null) {
                aVar2 = new a((SurfaceRenderView) bVar.f21989e.get(), bVar.f21985a);
            }
            aVar.a(aVar2, bVar.f21987c, bVar.f21988d);
        }
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }

    public final void b(int i11, int i12) {
        if (i11 > 0 && i12 > 0) {
            this.f21981a.b(i11, i12);
            requestLayout();
        }
    }

    public final void b(a.C0173a aVar) {
        this.f21982b.f21990f.remove(aVar);
    }
}
