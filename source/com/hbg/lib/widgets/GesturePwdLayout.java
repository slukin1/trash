package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.hbg.lib.common.utils.ViewUtil;
import java.util.ArrayList;
import java.util.List;

public class GesturePwdLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f71341b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f71342c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    public int f71343d;

    /* renamed from: e  reason: collision with root package name */
    public int f71344e;

    /* renamed from: f  reason: collision with root package name */
    public int f71345f;

    /* renamed from: g  reason: collision with root package name */
    public int f71346g;

    /* renamed from: h  reason: collision with root package name */
    public int f71347h;

    /* renamed from: i  reason: collision with root package name */
    public int f71348i;

    /* renamed from: j  reason: collision with root package name */
    public int f71349j;

    /* renamed from: k  reason: collision with root package name */
    public int f71350k;

    /* renamed from: l  reason: collision with root package name */
    public int f71351l;

    /* renamed from: m  reason: collision with root package name */
    public int f71352m = -15170860;

    /* renamed from: n  reason: collision with root package name */
    public int f71353n = -1610430;

    /* renamed from: o  reason: collision with root package name */
    public int f71354o = -15170860;

    /* renamed from: p  reason: collision with root package name */
    public boolean f71355p;

    /* renamed from: q  reason: collision with root package name */
    public final List<List<GesturePwdRippleView>> f71356q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public final List<GesturePwdRippleView> f71357r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public final List<GesturePwdRippleView> f71358s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    public boolean f71359t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f71360u;

    /* renamed from: v  reason: collision with root package name */
    public a f71361v;

    public interface a {
        void y7(List<Integer> list);
    }

    public GesturePwdLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context);
    }

    public static int f(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        h();
    }

    public final void b(Context context, int i11) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        this.f71341b.addView(linearLayout, new LinearLayout.LayoutParams(-1, -1, 1.0f));
        this.f71356q.add(new ArrayList());
        for (int i12 = 0; i12 < 3; i12++) {
            c(context, linearLayout, i11, i12);
        }
    }

    public final void c(Context context, LinearLayout linearLayout, int i11, int i12) {
        GesturePwdRippleView gesturePwdRippleView = new GesturePwdRippleView(context);
        linearLayout.addView(gesturePwdRippleView, new LinearLayout.LayoutParams(-1, -1, 1.0f));
        gesturePwdRippleView.setRows(i11);
        gesturePwdRippleView.setColumns(i12);
        gesturePwdRippleView.setPosition(this.f71357r.size());
        gesturePwdRippleView.setSelectColor(this.f71352m);
        this.f71356q.get(i11).add(gesturePwdRippleView);
        this.f71357r.add(gesturePwdRippleView);
    }

    public final void d(GesturePwdRippleView gesturePwdRippleView) {
        if (!this.f71358s.contains(gesturePwdRippleView)) {
            this.f71358s.add(gesturePwdRippleView);
            gesturePwdRippleView.p();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: com.hbg.lib.widgets.GesturePwdRippleView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: com.hbg.lib.widgets.GesturePwdRippleView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: com.hbg.lib.widgets.GesturePwdRippleView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(int r9, int r10, boolean r11) {
        /*
            r8 = this;
            int r0 = r8.f71349j
            int r0 = r0 / 3
            r8.f71347h = r0
            int r0 = r8.f71350k
            int r0 = r0 / 3
            r8.f71348i = r0
            android.widget.LinearLayout r0 = r8.f71341b
            float r0 = r0.getY()
            int r0 = (int) r0
            r8.f71351l = r0
            int r10 = r10 - r0
            int r0 = r8.getPaddingLeft()
            int r1 = r8.f71347h
            int r0 = r0 + r1
            int r0 = r0 + r1
            r1 = 0
            r2 = 2
            r3 = 1
            if (r9 <= r0) goto L_0x0025
            r0 = r2
            goto L_0x0031
        L_0x0025:
            int r0 = r8.getPaddingLeft()
            int r4 = r8.f71347h
            int r0 = r0 + r4
            if (r9 <= r0) goto L_0x0030
            r0 = r3
            goto L_0x0031
        L_0x0030:
            r0 = r1
        L_0x0031:
            int r4 = r8.getPaddingTop()
            int r5 = r8.f71348i
            int r4 = r4 + r5
            int r4 = r4 + r5
            if (r10 <= r4) goto L_0x003d
            r4 = r2
            goto L_0x0049
        L_0x003d:
            int r4 = r8.getPaddingTop()
            int r5 = r8.f71348i
            int r4 = r4 + r5
            if (r10 <= r4) goto L_0x0048
            r4 = r3
            goto L_0x0049
        L_0x0048:
            r4 = r1
        L_0x0049:
            java.util.List<java.util.List<com.hbg.lib.widgets.GesturePwdRippleView>> r5 = r8.f71356q
            java.lang.Object r5 = r5.get(r4)
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r5 = r5.get(r0)
            com.hbg.lib.widgets.GesturePwdRippleView r5 = (com.hbg.lib.widgets.GesturePwdRippleView) r5
            int r6 = r8.getPaddingLeft()
            int r7 = r8.f71347h
            int r0 = r0 * r7
            int r6 = r6 + r0
            int r7 = r7 / r2
            int r6 = r6 + r7
            int r9 = r9 - r6
            int r9 = java.lang.Math.abs(r9)
            float r9 = (float) r9
            int r0 = r8.getPaddingTop()
            int r6 = r8.f71348i
            int r4 = r4 * r6
            int r0 = r0 + r4
            int r6 = r6 / r2
            int r0 = r0 + r6
            int r10 = r10 - r0
            int r10 = java.lang.Math.abs(r10)
            float r10 = (float) r10
            int r0 = r5.getMaxSize()
            int r0 = r0 / r2
            float r0 = (float) r0
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 >= 0) goto L_0x0086
            int r9 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r9 >= 0) goto L_0x0086
            r1 = r3
        L_0x0086:
            if (r1 == 0) goto L_0x0141
            java.util.List<com.hbg.lib.widgets.GesturePwdRippleView> r9 = r8.f71358s
            boolean r9 = r9.contains(r5)
            if (r9 != 0) goto L_0x0141
            if (r11 == 0) goto L_0x0098
            boolean r9 = r8.f71359t
            if (r9 != 0) goto L_0x0098
            r8.f71359t = r3
        L_0x0098:
            boolean r9 = r8.f71359t
            if (r9 == 0) goto L_0x0141
            java.util.List<com.hbg.lib.widgets.GesturePwdRippleView> r9 = r8.f71358s
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x013e
            java.util.List<com.hbg.lib.widgets.GesturePwdRippleView> r9 = r8.f71358s
            int r10 = r9.size()
            int r10 = r10 - r3
            java.lang.Object r9 = r9.get(r10)
            com.hbg.lib.widgets.GesturePwdRippleView r9 = (com.hbg.lib.widgets.GesturePwdRippleView) r9
            r10 = 0
            int r11 = r9.getRows()
            int r0 = r5.getRows()
            int r11 = r11 - r0
            int r11 = java.lang.Math.abs(r11)
            int r0 = r9.getColumns()
            int r1 = r5.getColumns()
            int r0 = r0 - r1
            int r0 = java.lang.Math.abs(r0)
            if (r11 <= r3) goto L_0x00e0
            if (r0 <= r3) goto L_0x00e0
            java.util.List<java.util.List<com.hbg.lib.widgets.GesturePwdRippleView>> r9 = r8.f71356q
            java.lang.Object r9 = r9.get(r3)
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = r9.get(r3)
            r10 = r9
            com.hbg.lib.widgets.GesturePwdRippleView r10 = (com.hbg.lib.widgets.GesturePwdRippleView) r10
            goto L_0x0139
        L_0x00e0:
            int r1 = r9.getRows()
            int r2 = r5.getRows()
            if (r1 != r2) goto L_0x010d
            if (r0 <= r3) goto L_0x010d
            int r10 = r9.getColumns()
            int r11 = r5.getColumns()
            int r10 = java.lang.Math.min(r10, r11)
            int r10 = r10 + r3
            java.util.List<java.util.List<com.hbg.lib.widgets.GesturePwdRippleView>> r11 = r8.f71356q
            int r9 = r9.getRows()
            java.lang.Object r9 = r11.get(r9)
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = r9.get(r10)
            r10 = r9
            com.hbg.lib.widgets.GesturePwdRippleView r10 = (com.hbg.lib.widgets.GesturePwdRippleView) r10
            goto L_0x0139
        L_0x010d:
            int r0 = r9.getColumns()
            int r1 = r5.getColumns()
            if (r0 != r1) goto L_0x0139
            if (r11 <= r3) goto L_0x0139
            int r10 = r9.getRows()
            int r11 = r5.getRows()
            int r10 = java.lang.Math.min(r10, r11)
            int r10 = r10 + r3
            java.util.List<java.util.List<com.hbg.lib.widgets.GesturePwdRippleView>> r11 = r8.f71356q
            java.lang.Object r10 = r11.get(r10)
            java.util.List r10 = (java.util.List) r10
            int r9 = r9.getColumns()
            java.lang.Object r9 = r10.get(r9)
            r10 = r9
            com.hbg.lib.widgets.GesturePwdRippleView r10 = (com.hbg.lib.widgets.GesturePwdRippleView) r10
        L_0x0139:
            if (r10 == 0) goto L_0x013e
            r8.d(r10)
        L_0x013e:
            r8.d(r5)
        L_0x0141:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.GesturePwdLayout.e(int, int, boolean):void");
    }

    public final void g(Context context) {
        Resources resources = getResources();
        int i11 = R$color.baseColorMajorTheme100;
        this.f71352m = resources.getColor(i11);
        this.f71354o = getResources().getColor(i11);
        this.f71353n = getResources().getColor(R$color.base_down_color);
        setWillNotDraw(false);
        this.f71342c.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f71342c.setAntiAlias(true);
        this.f71342c.setColor(this.f71354o);
        this.f71342c.setStrokeWidth((float) f(context, 1.0f));
        ViewUtil.b(this, new h0(this));
    }

    public final void h() {
        this.f71343d = getWidth();
        this.f71344e = getHeight();
        this.f71349j = (this.f71343d - getPaddingLeft()) - getPaddingRight();
        this.f71350k = (this.f71343d - getPaddingTop()) - getPaddingBottom();
        i();
    }

    public final void i() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f71341b = linearLayout;
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f71349j, this.f71350k);
        int f11 = f(getContext(), 75.0f);
        if ((this.f71344e - getPaddingTop()) - getPaddingBottom() >= this.f71343d + f11 + f11) {
            layoutParams.topMargin = f11;
        } else {
            layoutParams.gravity = 17;
        }
        addView(this.f71341b, layoutParams);
        for (int i11 = 0; i11 < 3; i11++) {
            b(getContext(), i11);
        }
    }

    public final boolean k(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()).contains(motionEvent.getX(), motionEvent.getY());
    }

    public void l() {
        for (GesturePwdRippleView next : this.f71357r) {
            next.o();
            next.setSelectColor(this.f71352m);
        }
        this.f71355p = false;
        int i11 = this.f71352m;
        this.f71354o = i11;
        this.f71342c.setColor(i11);
        this.f71358s.clear();
        this.f71359t = false;
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f71359t) {
            int i11 = this.f71347h;
            int i12 = this.f71348i;
            int i13 = i11 / 2;
            int i14 = i12 / 2;
            int i15 = 1;
            if (this.f71360u) {
                List<GesturePwdRippleView> list = this.f71358s;
                GesturePwdRippleView gesturePwdRippleView = list.get(list.size() - 1);
                canvas.drawLine((float) (getPaddingLeft() + (gesturePwdRippleView.getColumns() * i11) + i13), (float) (getPaddingTop() + (gesturePwdRippleView.getRows() * i12) + i14 + this.f71351l), (float) this.f71345f, (float) this.f71346g, this.f71342c);
            }
            GesturePwdRippleView gesturePwdRippleView2 = this.f71358s.get(0);
            while (i15 < this.f71358s.size()) {
                GesturePwdRippleView gesturePwdRippleView3 = this.f71358s.get(i15);
                canvas.drawLine((float) (getPaddingLeft() + (gesturePwdRippleView2.getColumns() * i11) + i13), (float) (getPaddingTop() + (gesturePwdRippleView2.getRows() * i12) + i14 + this.f71351l), (float) (getPaddingLeft() + (gesturePwdRippleView3.getColumns() * i11) + i13), (float) (getPaddingTop() + (gesturePwdRippleView3.getRows() * i12) + i14 + this.f71351l), this.f71342c);
                i15++;
                gesturePwdRippleView2 = gesturePwdRippleView3;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int min = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (min != 0) {
            setMeasuredDimension(min, min);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r0 != 3) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            float r0 = r5.getX()
            int r0 = (int) r0
            r4.f71345f = r0
            float r0 = r5.getY()
            int r0 = (int) r0
            r4.f71346g = r0
            int r0 = r5.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x0066
            r2 = 0
            if (r0 == r1) goto L_0x002f
            r3 = 2
            if (r0 == r3) goto L_0x001f
            r5 = 3
            if (r0 == r5) goto L_0x002f
            goto L_0x006f
        L_0x001f:
            r4.f71360u = r1
            boolean r5 = r4.k(r5)
            if (r5 == 0) goto L_0x006f
            int r5 = r4.f71345f
            int r0 = r4.f71346g
            r4.e(r5, r0, r2)
            goto L_0x006f
        L_0x002f:
            r4.f71360u = r2
            java.util.List<com.hbg.lib.widgets.GesturePwdRippleView> r5 = r4.f71358s
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x006f
            com.hbg.lib.widgets.GesturePwdLayout$a r5 = r4.f71361v
            if (r5 == 0) goto L_0x006f
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List<com.hbg.lib.widgets.GesturePwdRippleView> r0 = r4.f71358s
            java.util.Iterator r0 = r0.iterator()
        L_0x0048:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0060
            java.lang.Object r2 = r0.next()
            com.hbg.lib.widgets.GesturePwdRippleView r2 = (com.hbg.lib.widgets.GesturePwdRippleView) r2
            int r2 = r2.getPosition()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.add(r2)
            goto L_0x0048
        L_0x0060:
            com.hbg.lib.widgets.GesturePwdLayout$a r0 = r4.f71361v
            r0.y7(r5)
            goto L_0x006f
        L_0x0066:
            r4.f71360u = r1
            int r5 = r4.f71345f
            int r0 = r4.f71346g
            r4.e(r5, r0, r1)
        L_0x006f:
            r4.invalidate()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.GesturePwdLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCallback(a aVar) {
        this.f71361v = aVar;
    }

    public void setError(boolean z11) {
        this.f71355p = z11;
        int i11 = z11 ? this.f71353n : this.f71352m;
        this.f71354o = i11;
        this.f71342c.setColor(i11);
        for (GesturePwdRippleView next : this.f71357r) {
            if (!z11 || !this.f71358s.contains(next)) {
                next.setSelectColor(this.f71352m);
                next.setCenterPointColor(getResources().getColor(R$color.baseColorThreeLevelText));
            } else {
                next.setSelectColor(this.f71353n);
                next.setCenterPointColor(this.f71353n);
            }
        }
        invalidate();
    }

    public GesturePwdLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        g(context);
    }
}
