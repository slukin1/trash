package com.huobi.otc.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.customview.widget.ViewDragHelper;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$id;
import net.lucode.hackware.magicindicator.buildins.UIUtil;

public class DragRelativeLayout extends RelativeLayout {

    /* renamed from: k  reason: collision with root package name */
    public static int f79756k = -1;

    /* renamed from: l  reason: collision with root package name */
    public static int f79757l = -1;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f79758m = true;

    /* renamed from: b  reason: collision with root package name */
    public View f79759b;

    /* renamed from: c  reason: collision with root package name */
    public View f79760c;

    /* renamed from: d  reason: collision with root package name */
    public ViewDragHelper f79761d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f79762e;

    /* renamed from: f  reason: collision with root package name */
    public int f79763f;

    /* renamed from: g  reason: collision with root package name */
    public int f79764g;

    /* renamed from: h  reason: collision with root package name */
    public int f79765h;

    /* renamed from: i  reason: collision with root package name */
    public b f79766i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f79767j = false;

    public interface b {
        boolean a();

        void b();

        void c(boolean z11);

        void d(boolean z11);

        float getTvTranslateX();
    }

    public class c extends ViewDragHelper.Callback {
        public c() {
        }

        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            return Math.min(Math.max(DragRelativeLayout.this.f79763f, i11), DragRelativeLayout.this.f79764g);
        }

        public int clampViewPositionVertical(View view, int i11, int i12) {
            return Math.min(Math.max(0, i11), DragRelativeLayout.this.f79765h);
        }

        public int getViewHorizontalDragRange(View view) {
            return DragRelativeLayout.this.getWidth();
        }

        public int getViewVerticalDragRange(View view) {
            return DragRelativeLayout.this.getWidth();
        }

        public void onViewDragStateChanged(int i11) {
            super.onViewDragStateChanged(i11);
        }

        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            super.onViewPositionChanged(view, i11, i12, i13, i14);
            int unused = DragRelativeLayout.f79756k = i11;
            int unused2 = DragRelativeLayout.f79757l = i12;
        }

        public void onViewReleased(View view, float f11, float f12) {
            int i11;
            super.onViewReleased(view, f11, f12);
            boolean z11 = false;
            boolean unused = DragRelativeLayout.this.f79762e = false;
            int[] iArr = new int[2];
            DragRelativeLayout.this.f79760c.getLocationOnScreen(iArr);
            if (iArr[0] + (DragRelativeLayout.this.f79759b.getWidth() / 2) < DragRelativeLayout.this.getWidth() / 2) {
                z11 = true;
            }
            boolean unused2 = DragRelativeLayout.f79758m = z11;
            if (DragRelativeLayout.f79758m) {
                i11 = DragRelativeLayout.this.f79763f;
            } else {
                i11 = DragRelativeLayout.this.f79764g + (DragRelativeLayout.this.f79759b.getWidth() - DragRelativeLayout.this.f79760c.getWidth());
                if (DragRelativeLayout.this.f79766i.a()) {
                    i11 = DragRelativeLayout.this.f79764g;
                }
            }
            DragRelativeLayout.this.f79761d.Q(i11, DragRelativeLayout.f79757l);
            if (DragRelativeLayout.this.f79766i != null) {
                DragRelativeLayout.this.f79766i.c(DragRelativeLayout.f79758m);
            }
            DragRelativeLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i11) {
            boolean z11 = view == DragRelativeLayout.this.f79759b;
            if (z11 && DragRelativeLayout.this.f79766i != null) {
                DragRelativeLayout.this.f79766i.b();
            }
            return z11;
        }
    }

    public DragRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void setCurrentX(int i11) {
        f79756k = i11;
    }

    public void computeScroll() {
        if (this.f79761d.n(true)) {
            invalidate();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f79759b = findViewById(R$id.fv_float);
        this.f79760c = findViewById(R$id.slv_float);
        this.f79761d = ViewDragHelper.p(this, new c());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x11 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            this.f79767j = x11 > this.f79759b.getLeft() && x11 < this.f79759b.getRight() && y11 > this.f79759b.getTop() && y11 < this.f79759b.getBottom();
        }
        if (this.f79767j) {
            this.f79762e = this.f79761d.R(motionEvent);
        }
        if (this.f79762e || super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        super.onLayout(z11, i11, i12, i13, i14);
        this.f79766i.d(f79758m);
        Resources resources = getResources();
        int height = getHeight() - this.f79759b.getHeight();
        this.f79765h = height;
        this.f79763f = resources.getDimensionPixelOffset(R$dimen.dimen_8);
        this.f79764g = getWidth() - this.f79759b.getWidth();
        int i16 = f79757l;
        if (i16 == -1) {
            i15 = height - UIUtil.a(getContext(), 110.0d);
        } else {
            int i17 = this.f79765h;
            if (i16 > i17) {
                i16 = i17;
            }
            i15 = i16;
        }
        int i18 = f79756k;
        if (i18 <= -1) {
            i18 = this.f79763f;
        }
        if (!f79758m) {
            if (!this.f79766i.a()) {
                i18 = this.f79764g + (this.f79759b.getWidth() - this.f79760c.getWidth());
            } else if (this.f79766i.getTvTranslateX() == 0.0f) {
                i18 = this.f79764g;
            }
        }
        View view = this.f79759b;
        view.layout(i18, i15, view.getWidth() + i18, this.f79759b.getHeight() + i15);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f79762e) {
            this.f79761d.H(motionEvent);
        }
        return this.f79762e;
    }

    public void setOnFloatDragListener(b bVar) {
        this.f79766i = bVar;
        bVar.d(f79758m);
    }
}
