package com.hbg.lite.market.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lite.R$color;
import com.hbg.lite.R$dimen;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$styleable;
import com.hbg.lite.market.bean.MarketDetailBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class LiteIndexTradingView extends FrameLayout {
    public boolean A;
    public boolean B;
    public List<MarketDetailBean> C;
    public int D;
    public double E;
    public int F;
    public Boolean G;
    public boolean H;
    public View I;
    public GestureDetector J;
    public int K;
    public int L;
    public Paint M;
    public MarketDetailBean N;
    public int O;
    public int P;
    public int Q;
    public Point R;

    /* renamed from: b  reason: collision with root package name */
    public int f77255b;

    /* renamed from: c  reason: collision with root package name */
    public int f77256c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f77257d;

    /* renamed from: e  reason: collision with root package name */
    public Path f77258e;

    /* renamed from: f  reason: collision with root package name */
    public Path f77259f;

    /* renamed from: g  reason: collision with root package name */
    public int f77260g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f77261h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f77262i;

    /* renamed from: j  reason: collision with root package name */
    public final Paint f77263j;

    /* renamed from: k  reason: collision with root package name */
    public List<Integer> f77264k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f77265l;

    /* renamed from: m  reason: collision with root package name */
    public SparseIntArray f77266m;

    /* renamed from: n  reason: collision with root package name */
    public int[] f77267n;

    /* renamed from: o  reason: collision with root package name */
    public float[] f77268o;

    /* renamed from: p  reason: collision with root package name */
    public RectF f77269p;

    /* renamed from: q  reason: collision with root package name */
    public final RectF f77270q;

    /* renamed from: r  reason: collision with root package name */
    public int f77271r;

    /* renamed from: s  reason: collision with root package name */
    public int f77272s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f77273t;

    /* renamed from: u  reason: collision with root package name */
    public double f77274u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f77275v;

    /* renamed from: w  reason: collision with root package name */
    public int f77276w;

    /* renamed from: x  reason: collision with root package name */
    public int f77277x;

    /* renamed from: y  reason: collision with root package name */
    public int f77278y;

    /* renamed from: z  reason: collision with root package name */
    public c f77279z;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        public void onLongPress(MotionEvent motionEvent) {
            LiteIndexTradingView.this.setHighlight(motionEvent.getX());
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            LiteIndexTradingView.this.I.setVisibility(8);
        }
    }

    public interface c {
        void a(MarketDetailBean marketDetailBean);

        String b();
    }

    public LiteIndexTradingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public void setHighlight(float f11) {
        try {
            getParent().requestDisallowInterceptTouchEvent(true);
            int n11 = n(f11);
            this.f77260g = n11;
            MarketDetailBean marketDetailBean = this.C.get(this.f77264k.indexOf(Integer.valueOf(n11)));
            c cVar = this.f77279z;
            if (cVar != null) {
                cVar.a(marketDetailBean);
            }
            invalidate();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void A() {
        Paint paint = new Paint();
        this.f77262i = paint;
        paint.setDither(true);
        E();
    }

    public final void B() {
        Paint paint = new Paint();
        this.M = paint;
        paint.setAntiAlias(true);
        this.M.setStyle(Paint.Style.STROKE);
        this.M.setTextSize((float) PixelUtils.a(12.0f));
        this.M.setColor(getResources().getColor(R$color.baseColorPrimaryText));
    }

    public void C(List<MarketDetailBean> list, boolean z11) {
        D(list, z11, 700);
    }

    public void D(List<MarketDetailBean> list, boolean z11, long j11) {
        if (list != null && list.size() != 0) {
            this.C = list;
            try {
                v(z11);
                invalidate();
                e(j11);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void E() {
        this.f77262i.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) this.f77256c, this.f77267n, this.f77268o, Shader.TileMode.CLAMP));
    }

    public final void e(long j11) {
        if (!this.f77265l) {
            this.f77265l = true;
            this.I.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.I, View.TRANSLATION_X, new float[]{0.0f, (float) getResources().getDisplayMetrics().widthPixels});
            ofFloat.setDuration(j11);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    public final void f(List<MarketDetailBean> list) {
        double d11;
        int i11;
        List<MarketDetailBean> list2 = list;
        hb.a aVar = hb.a.f54912b;
        double doublePrice = ((MarketDetailBean) Collections.min(list2, aVar)).getDoublePrice();
        double doublePrice2 = ((MarketDetailBean) Collections.max(list2, aVar)).getDoublePrice() - doublePrice;
        Collections.sort(list);
        long time = list2.get(0).getTime();
        long time2 = list2.get(list.size() - 1).getTime() - time;
        int i12 = 0;
        while (i12 < list.size()) {
            MarketDetailBean marketDetailBean = list2.get(i12);
            long j11 = time;
            int time3 = (int) (((marketDetailBean.getTime() - time) * ((long) this.f77255b)) / time2);
            if (doublePrice2 == 0.0d) {
                int i13 = this.f77256c;
                int i14 = this.K;
                i11 = ((((i13 - i14) - this.L) - this.O) / 2) + i14;
                d11 = doublePrice;
            } else {
                float strokeWidth = this.f77257d.getStrokeWidth();
                int i15 = this.f77256c;
                int i16 = this.K;
                float f11 = strokeWidth / 2.0f;
                d11 = doublePrice;
                i11 = (int) ((((double) (((float) (((i15 - i16) - this.L) - this.O)) - f11)) * (((doublePrice2 - marketDetailBean.getDoublePrice()) + doublePrice) / doublePrice2)) + ((double) i16) + ((double) f11));
            }
            this.f77266m.put(time3, i11);
            this.f77264k.add(Integer.valueOf(time3));
            if (i12 == 0) {
                this.f77258e.moveTo((float) time3, (float) i11);
            } else {
                this.f77258e.lineTo((float) time3, (float) i11);
            }
            i12++;
            time = j11;
            doublePrice = d11;
        }
        this.f77259f.addPath(this.f77258e);
        this.f77259f.lineTo((float) this.f77255b, (float) this.f77256c);
        this.f77259f.lineTo(0.0f, (float) this.f77256c);
        this.f77259f.close();
        this.f77269p = new RectF(0.0f, (float) this.K, (float) this.f77255b, (float) this.f77256c);
        double doublePrice3 = list2.get(list.size() - 1).getDoublePrice();
        boolean z11 = false;
        double doublePrice4 = list2.get(0).getDoublePrice();
        this.E = doublePrice4;
        if (doublePrice3 >= doublePrice4) {
            z11 = true;
        }
        h(z11);
    }

    public final void g(List<MarketDetailBean> list) {
        List<MarketDetailBean> list2 = list;
        hb.b bVar = hb.b.f54913b;
        MarketDetailBean marketDetailBean = new MarketDetailBean(0, String.valueOf(this.f77274u));
        list2.add(marketDetailBean);
        double doublePrice = ((MarketDetailBean) Collections.min(list2, bVar)).getDoublePrice();
        double doublePrice2 = ((MarketDetailBean) Collections.max(list2, bVar)).getDoublePrice() - doublePrice;
        list2.remove(marketDetailBean);
        double doublePrice3 = marketDetailBean.getDoublePrice();
        int i11 = 0;
        double doublePrice4 = list2.get(0).getDoublePrice();
        this.E = doublePrice4;
        h(doublePrice3 >= doublePrice4);
        Collections.sort(list);
        long time = list2.get(0).getTime();
        long time2 = list2.get(list.size() - 1).getTime() - time;
        this.D = PixelUtils.a(6.0f);
        while (i11 < list.size()) {
            MarketDetailBean marketDetailBean2 = list2.get(i11);
            int time3 = (int) (((marketDetailBean2.getTime() - time) * ((long) (this.f77255b - this.D))) / time2);
            int i12 = this.f77256c;
            int i13 = this.K;
            long j11 = time2;
            int doublePrice5 = (int) ((((double) ((i12 - i13) - this.L)) * (((doublePrice2 - marketDetailBean2.getDoublePrice()) + doublePrice) / doublePrice2)) + ((double) i13));
            this.f77266m.put(time3, doublePrice5);
            this.f77264k.add(Integer.valueOf(time3));
            if (i11 == 0) {
                this.f77258e.moveTo((float) time3, (float) doublePrice5);
            } else {
                this.f77258e.lineTo((float) time3, (float) doublePrice5);
            }
            i11++;
            list2 = list;
            time2 = j11;
        }
        double d11 = ((doublePrice2 - this.f77274u) + doublePrice) / doublePrice2;
        int i14 = this.f77255b - (this.D / 3);
        int i15 = this.f77256c;
        int i16 = this.K;
        int i17 = (int) ((((double) ((i15 - i16) - this.L)) * d11) + ((double) i16));
        this.f77258e.lineTo((float) i14, (float) i17);
        this.f77266m.put(i14, i17);
        this.f77264k.add(Integer.valueOf(i14));
        this.R = new Point(i14, i17);
        this.f77259f.addPath(this.f77258e);
        this.f77259f.lineTo((float) this.f77255b, (float) this.f77256c);
        this.f77259f.lineTo(0.0f, (float) this.f77256c);
        this.f77259f.close();
        this.f77269p = new RectF(0.0f, (float) this.K, (float) this.f77255b, (float) this.f77256c);
    }

    public final void h(boolean z11) {
        Boolean bool = this.G;
        if (bool != null) {
            z11 = bool.booleanValue();
        }
        if (z11) {
            this.f77271r = this.P;
            if (this.H) {
                int color = getResources().getColor(R$color.green_002);
                this.f77267n = new int[]{color, color};
            } else {
                this.f77267n = new int[]{getResources().getColor(R$color.lite_trade_view_rise_color_start), getResources().getColor(R$color.lite_trade_view_color_end)};
            }
            this.F = R$drawable.lite_kline_up;
            return;
        }
        this.f77271r = this.Q;
        if (this.H) {
            int color2 = getResources().getColor(R$color.red_002);
            this.f77267n = new int[]{color2, color2};
        } else {
            this.f77267n = new int[]{getResources().getColor(R$color.lite_trade_view_down_color_start), getResources().getColor(R$color.lite_trade_view_color_end)};
        }
        this.F = R$drawable.lite_kline_down;
    }

    public final void i(Canvas canvas) {
        if (this.f77260g > 0) {
            j(canvas);
            k(canvas);
        }
    }

    public final void j(Canvas canvas) {
        canvas.drawLine((float) this.f77260g, (float) PixelUtils.a(40.0f), (float) this.f77260g, (float) ((this.f77256c - this.L) + PixelUtils.a(15.0f)), this.f77261h);
        int a11 = PixelUtils.a(7.5f);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R$drawable.lite_kline_press);
        int i11 = this.f77260g;
        int i12 = this.f77260g;
        canvas.drawBitmap(decodeResource, (Rect) null, new RectF((float) (i11 - a11), (float) (this.f77266m.get(i11) - a11), (float) (i12 + a11), (float) (this.f77266m.get(i12) + a11)), this.f77261h);
    }

    public final void k(Canvas canvas) {
        MarketDetailBean marketDetailBean;
        int indexOf = this.f77264k.indexOf(Integer.valueOf(this.f77260g));
        if (indexOf > this.C.size() - 1) {
            marketDetailBean = this.N;
        } else {
            marketDetailBean = this.C.get(indexOf);
        }
        String o11 = o(marketDetailBean);
        canvas.drawText(o11, (float) p(this.f77260g, (int) this.M.measureText(o11)), (float) PixelUtils.a(26.0f), this.M);
    }

    public final void l(Canvas canvas) {
        if (this.f77273t && this.f77274u > 0.0d && this.R != null && this.F != 0) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.F);
            Point point = this.R;
            int i11 = point.x;
            int i12 = this.D;
            int i13 = point.y;
            canvas.drawBitmap(decodeResource, (Rect) null, new RectF((float) (i11 - i12), (float) (i13 - i12), (float) this.f77255b, (float) (i13 + i12)), this.f77261h);
        }
    }

    public final void m(Canvas canvas) {
        if (this.f77269p != null) {
            A();
            canvas.save();
            canvas.clipPath(this.f77259f);
            if (this.A) {
                canvas.drawRoundRect(this.f77269p, (float) this.f77277x, (float) this.f77278y, this.f77262i);
            } else {
                canvas.drawRect(this.f77269p, this.f77262i);
            }
            canvas.restore();
        }
    }

    public final int n(float f11) {
        int i11 = 1;
        float f12 = Float.MAX_VALUE;
        int i12 = 0;
        while (i11 < this.f77264k.size()) {
            Integer num = this.f77264k.get(i11);
            float abs = Math.abs(((float) num.intValue()) - f11);
            if (abs > f12) {
                break;
            }
            i12 = num.intValue();
            i11++;
            f12 = abs;
        }
        return i12;
    }

    public final String o(MarketDetailBean marketDetailBean) {
        if (this.f77279z == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f77279z.b(), Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date(marketDetailBean.getTime() * 1000));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        v(true);
        List<MarketDetailBean> list = this.C;
        if (list != null && !list.isEmpty()) {
            if (!this.f77273t || this.f77274u <= 0.0d) {
                f(this.C);
            } else {
                g(this.C);
            }
            if (this.B) {
                if (this.A) {
                    this.f77270q.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
                    canvas.drawRoundRect(this.f77270q, (float) this.f77277x, (float) this.f77278y, this.f77263j);
                } else {
                    canvas.drawColor(this.f77276w);
                }
            }
            m(canvas);
            z();
            canvas.drawPath(this.f77258e, this.f77257d);
            i(canvas);
            l(canvas);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode == 1073741824) {
            this.f77255b = size;
        } else if (mode == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Width must be EXACTLY");
        }
        if (mode2 == 1073741824) {
            this.f77256c = size2;
        } else if (i11 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Height must be EXACTLY");
        }
        setMeasuredDimension(this.f77255b, this.f77256c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r4 != 3) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            boolean r0 = r3.f77275v
            if (r0 != 0) goto L_0x0009
            boolean r4 = super.onTouchEvent(r4)
            return r4
        L_0x0009:
            android.view.GestureDetector r0 = r3.J
            boolean r0 = r0.onTouchEvent(r4)
            r1 = 1
            if (r0 == 0) goto L_0x0013
            return r1
        L_0x0013:
            float r0 = r4.getX()
            int r4 = r4.getAction()
            if (r4 == 0) goto L_0x002a
            if (r4 == r1) goto L_0x0026
            r2 = 2
            if (r4 == r2) goto L_0x002a
            r0 = 3
            if (r4 == r0) goto L_0x0026
            goto L_0x0031
        L_0x0026:
            r3.x()
            goto L_0x0031
        L_0x002a:
            int r4 = r3.f77260g
            if (r4 < 0) goto L_0x0031
            r3.setHighlight(r0)
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lite.market.widget.LiteIndexTradingView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final int p(int i11, int i12) {
        int i13 = i12 / 2;
        int i14 = i11 - i13;
        int i15 = i11 + i13;
        int a11 = PixelUtils.a(15.0f);
        if (i14 > a11 && i15 < PixelUtils.g() - a11) {
            return i14;
        }
        if (i14 <= a11) {
            return a11;
        }
        return (PixelUtils.g() - a11) - i12;
    }

    public final void q(Context context, AttributeSet attributeSet) {
        this.P = getResources().getColor(R$color.base_up_color);
        this.Q = getResources().getColor(R$color.base_down_color);
        setWillNotDraw(false);
        Resources resources = getResources();
        int i11 = R$color.app_bg;
        this.f77276w = resources.getColor(i11);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.dimen_5);
        this.f77277x = dimensionPixelOffset;
        this.f77278y = dimensionPixelOffset;
        u(context, attributeSet);
        h(true);
        r();
        View view = new View(context);
        this.I = view;
        view.setBackgroundColor(getResources().getColor(i11));
        addView(this.I, new FrameLayout.LayoutParams(-1, -1));
        this.I.setVisibility(8);
        this.J = new GestureDetector(context, new a());
    }

    public final void r() {
        w();
        z();
        y();
        A();
        B();
    }

    public void setBgColor(int i11) {
        this.f77276w = i11;
    }

    public void setData(List<MarketDetailBean> list) {
        C(list, true);
    }

    public void setDownColor(int i11) {
        this.Q = i11;
    }

    public void setDrawBg(boolean z11) {
        this.B = z11;
    }

    public void setEnableInstantPrice(boolean z11) {
        this.f77273t = z11;
    }

    public void setInstantPrice(MarketDetailBean marketDetailBean) {
        if (marketDetailBean != null) {
            this.f77274u = marketDetailBean.getDoublePrice();
            this.N = marketDetailBean;
            C(this.C, false);
        }
    }

    public void setMManualRise(Boolean bool) {
        this.G = bool;
    }

    public void setMShadowPureColor(boolean z11) {
        this.H = z11;
    }

    public void setNeedRoundRect(boolean z11) {
        this.A = z11;
    }

    public void setOnHighlightListener(c cVar) {
        this.f77279z = cVar;
    }

    public void setRiseColor(int i11) {
        this.P = i11;
    }

    public final void u(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LiteTradingView);
        int i11 = 0;
        this.f77273t = obtainStyledAttributes.getBoolean(R$styleable.LiteTradingView_enableInstantPrice, false);
        this.f77275v = obtainStyledAttributes.getBoolean(R$styleable.LiteTradingView_enableHighlight, false);
        this.f77272s = obtainStyledAttributes.getDimensionPixelSize(R$styleable.LiteTradingView_strokeWidth, 1);
        this.K = this.f77275v ? PixelUtils.a(45.0f) : 0;
        if (this.f77275v) {
            i11 = PixelUtils.a(45.0f);
        }
        this.L = i11;
        obtainStyledAttributes.recycle();
    }

    public final void v(boolean z11) {
        if (z11) {
            x();
        }
        this.f77258e.reset();
        this.f77259f.reset();
        this.f77264k.clear();
        this.f77266m.clear();
    }

    public final void w() {
        this.f77263j.setAntiAlias(true);
        this.f77263j.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f77263j.setColor(this.f77276w);
        this.f77263j.setStrokeJoin(Paint.Join.ROUND);
        this.f77263j.setPathEffect(new CornerPathEffect(5.0f));
    }

    public final void x() {
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f77260g = -1;
        c cVar = this.f77279z;
        if (cVar != null) {
            cVar.a((MarketDetailBean) null);
        }
        invalidate();
    }

    public final void y() {
        Paint paint = new Paint();
        this.f77261h = paint;
        paint.setAntiAlias(true);
        this.f77261h.setStyle(Paint.Style.STROKE);
        this.f77261h.setStrokeWidth((float) PixelUtils.a(1.0f));
        this.f77261h.setColor(getResources().getColor(R$color.baseColorThreeLevelText));
    }

    public final void z() {
        Paint paint = new Paint();
        this.f77257d = paint;
        paint.setAntiAlias(true);
        this.f77257d.setStyle(Paint.Style.STROKE);
        this.f77257d.setStrokeWidth((float) this.f77272s);
        this.f77257d.setColor(this.f77271r);
        this.f77257d.setStrokeJoin(Paint.Join.ROUND);
        this.f77257d.setPathEffect(new CornerPathEffect(5.0f));
    }

    public LiteIndexTradingView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f77258e = new Path();
        this.f77259f = new Path();
        this.f77260g = -1;
        this.f77263j = new Paint();
        this.f77264k = new ArrayList();
        this.f77266m = new SparseIntArray();
        this.f77267n = new int[]{getResources().getColor(R$color.base_up_color), getResources().getColor(R$color.color_white)};
        this.f77268o = new float[]{0.0f, 1.0f};
        this.f77270q = new RectF();
        this.f77274u = -1.0d;
        this.B = true;
        this.G = null;
        q(context, attributeSet);
    }
}
