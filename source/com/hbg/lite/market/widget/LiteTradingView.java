package com.hbg.lite.market.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lite.R$color;
import com.hbg.lite.R$dimen;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$string;
import com.hbg.lite.R$styleable;
import com.hbg.lite.market.bean.MarketDetailBean;
import hb.d;
import hb.e;
import i6.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import nb.c;

public class LiteTradingView extends FrameLayout {
    public boolean A;
    public View B;
    public GestureDetector C;
    public int D;
    public int E;
    public Paint F;
    public MarketDetailBean G;
    public int H;
    public String I;
    public String J;
    public PointF K;
    public PointF L;
    public float M;
    public ValueAnimator N;
    public Paint O;
    public String P;
    public BlurMaskFilter Q;
    public boolean R;
    public Point S;

    /* renamed from: b  reason: collision with root package name */
    public int f77295b;

    /* renamed from: c  reason: collision with root package name */
    public int f77296c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f77297d;

    /* renamed from: e  reason: collision with root package name */
    public Path f77298e;

    /* renamed from: f  reason: collision with root package name */
    public Path f77299f;

    /* renamed from: g  reason: collision with root package name */
    public int f77300g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f77301h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f77302i;

    /* renamed from: j  reason: collision with root package name */
    public List<Integer> f77303j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f77304k;

    /* renamed from: l  reason: collision with root package name */
    public SparseIntArray f77305l;

    /* renamed from: m  reason: collision with root package name */
    public int[] f77306m;

    /* renamed from: n  reason: collision with root package name */
    public float[] f77307n;

    /* renamed from: o  reason: collision with root package name */
    public RectF f77308o;

    /* renamed from: p  reason: collision with root package name */
    public int f77309p;

    /* renamed from: q  reason: collision with root package name */
    public int f77310q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f77311r;

    /* renamed from: s  reason: collision with root package name */
    public double f77312s;

    /* renamed from: t  reason: collision with root package name */
    public int f77313t;

    /* renamed from: u  reason: collision with root package name */
    public b f77314u;

    /* renamed from: v  reason: collision with root package name */
    public List<MarketDetailBean> f77315v;

    /* renamed from: w  reason: collision with root package name */
    public int f77316w;

    /* renamed from: x  reason: collision with root package name */
    public double f77317x;

    /* renamed from: y  reason: collision with root package name */
    public int f77318y;

    /* renamed from: z  reason: collision with root package name */
    public Boolean f77319z;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        public void onLongPress(MotionEvent motionEvent) {
            LiteTradingView.this.setHighlight(motionEvent.getX());
        }
    }

    public interface b {
        void a(MarketDetailBean marketDetailBean);

        String b();
    }

    public LiteTradingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.M = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(boolean z11, List list) {
        try {
            H(z11);
            g(list);
            if (!x()) {
                this.N.cancel();
            } else if (!this.N.isRunning()) {
                this.N.start();
            }
            invalidate();
            e();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void setHighlight(float f11) {
        MarketDetailBean marketDetailBean;
        try {
            getParent().requestDisallowInterceptTouchEvent(true);
            int r11 = r(f11);
            this.f77300g = r11;
            int indexOf = this.f77303j.indexOf(Integer.valueOf(r11));
            if (indexOf >= this.f77315v.size()) {
                marketDetailBean = new MarketDetailBean(0, String.valueOf(this.f77312s));
            } else {
                marketDetailBean = this.f77315v.get(indexOf);
            }
            b bVar = this.f77314u;
            if (bVar != null) {
                bVar.a(marketDetailBean);
            }
            invalidate();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void A() {
        L();
        K();
        M();
        N();
        I();
    }

    public final void B(Context context) {
        this.f77313t = getResources().getColor(R$color.app_bg);
        boolean g11 = NightHelper.e().g();
        this.R = g11;
        if (g11) {
            this.Q = new BlurMaskFilter(getResources().getDimension(R$dimen.dimen_20), BlurMaskFilter.Blur.SOLID);
        }
        this.H = getResources().getDimensionPixelOffset(R$dimen.dimen_16);
        this.f77316w = PixelUtils.a(7.5f);
        this.P = context.getString(R$string.cny_pre_symbol);
    }

    public boolean C() {
        return this.f77300g >= 0;
    }

    public final void G(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LiteTradingView);
        this.f77311r = obtainStyledAttributes.getBoolean(R$styleable.LiteTradingView_enableInstantPrice, false);
        this.f77310q = obtainStyledAttributes.getDimensionPixelSize(R$styleable.LiteTradingView_strokeWidth, 1);
        Resources resources = getResources();
        int i11 = R$dimen.dimen_20;
        this.D = (int) resources.getDimension(i11);
        this.E = (int) getResources().getDimension(i11);
        obtainStyledAttributes.recycle();
    }

    public final void H(boolean z11) {
        if (z11) {
            J();
        }
        this.f77298e.reset();
        this.f77299f.reset();
        this.f77303j.clear();
        this.f77305l.clear();
    }

    public final void I() {
        if (this.O == null) {
            this.O = new Paint();
        }
        this.O.setAntiAlias(true);
        this.O.setStyle(Paint.Style.FILL);
        this.O.setColor(this.f77309p);
    }

    public final void J() {
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f77300g = -1;
        b bVar = this.f77314u;
        if (bVar != null) {
            bVar.a((MarketDetailBean) null);
        }
        invalidate();
    }

    public final void K() {
        if (this.f77301h == null) {
            this.f77301h = new Paint();
        }
        this.f77301h.setAntiAlias(true);
        this.f77301h.setStyle(Paint.Style.STROKE);
        this.f77301h.setStrokeWidth((float) PixelUtils.a(1.0f));
        this.f77301h.setColor(getResources().getColor(R$color.baseColorThreeLevelText));
    }

    public final void L() {
        if (this.f77297d == null) {
            this.f77297d = new Paint();
        }
        this.f77297d.setAntiAlias(true);
        this.f77297d.setStyle(Paint.Style.STROKE);
        this.f77297d.setStrokeWidth((float) this.f77310q);
        this.f77297d.setColor(this.f77309p);
        this.f77297d.setStrokeJoin(Paint.Join.ROUND);
        this.f77297d.setPathEffect(new CornerPathEffect(5.0f));
        this.f77297d.setMaskFilter((MaskFilter) null);
    }

    public final void M() {
        if (this.f77302i == null) {
            this.f77302i = new Paint();
        }
        this.f77302i.setDither(true);
        P();
    }

    public final void N() {
        if (this.F == null) {
            this.F = new Paint();
        }
        this.F.setAntiAlias(true);
        this.F.setStyle(Paint.Style.STROKE);
        this.F.setTextSize((float) PixelUtils.a(12.0f));
        this.F.setColor(getResources().getColor(R$color.baseColorPrimaryText));
        this.F.setTypeface((Typeface) null);
    }

    public void O(List<MarketDetailBean> list, boolean z11) {
        if (list != null && list.size() != 0) {
            this.f77315v = list;
            post(new d(this, z11, list));
        }
    }

    public final void P() {
        this.f77302i.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) this.f77296c, this.f77306m, this.f77307n, Shader.TileMode.CLAMP));
    }

    public final void e() {
        if (!this.f77304k) {
            this.f77304k = true;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.B, View.TRANSLATION_X, new float[]{0.0f, (float) this.f77295b});
            ofFloat.setDuration(700);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.start();
        }
    }

    public final void f(double d11) {
        int i11;
        double d12 = 0.0d;
        if (d11 == 0.0d) {
            int i12 = this.f77296c;
            int i13 = this.D;
            i11 = (((i12 - i13) - this.E) / 2) + i13;
        } else {
            double parseDouble = ((d11 - this.f77312s) + Double.parseDouble(TextUtils.isEmpty(this.J) ? "0" : this.J)) / d11;
            if (parseDouble > 1.0d) {
                d12 = 1.0d;
            } else if (parseDouble >= 0.0d) {
                d12 = parseDouble;
            }
            int i14 = this.f77296c;
            int i15 = this.D;
            i11 = (int) ((((double) ((i14 - i15) - this.E)) * d12) + ((double) i15));
        }
        int i16 = this.f77295b - this.H;
        this.f77298e.lineTo((float) i16, (float) i11);
        this.f77305l.put(i16, i11);
        this.f77303j.add(Integer.valueOf(i16));
        this.S = new Point(i16, i11);
    }

    public final void g(List<MarketDetailBean> list) {
        double d11;
        long j11;
        long j12;
        int i11;
        List<MarketDetailBean> list2 = list;
        e eVar = e.f54918b;
        MarketDetailBean marketDetailBean = (MarketDetailBean) Collections.min(list2, eVar);
        this.J = marketDetailBean.getPrice();
        MarketDetailBean marketDetailBean2 = (MarketDetailBean) Collections.max(list2, eVar);
        this.I = marketDetailBean2.getPrice();
        double doublePrice = marketDetailBean2.getDoublePrice() - marketDetailBean.getDoublePrice();
        if (x()) {
            d11 = this.f77312s;
        } else {
            d11 = list2.get(list.size() - 1).getDoublePrice();
        }
        int i12 = 0;
        double doublePrice2 = list2.get(0).getDoublePrice();
        this.f77317x = doublePrice2;
        h(d11 >= doublePrice2);
        Collections.sort(list);
        long time = list2.get(0).getTime();
        long time2 = list2.get(list.size() - 1).getTime() - time;
        while (i12 < list.size()) {
            MarketDetailBean marketDetailBean3 = list2.get(i12);
            if (x()) {
                j11 = ((marketDetailBean3.getTime() - time) * ((long) ((this.f77295b - this.f77316w) - this.H))) / time2;
            } else {
                j11 = ((marketDetailBean3.getTime() - time) * ((long) this.f77295b)) / time2;
            }
            int i13 = (int) j11;
            if (doublePrice == 0.0d) {
                int i14 = this.f77296c;
                int i15 = this.D;
                i11 = (((i14 - i15) - this.E) / 2) + i15;
                j12 = time;
            } else {
                int i16 = this.f77296c;
                int i17 = this.D;
                j12 = time;
                i11 = (int) ((((double) ((i16 - i17) - this.E)) * (((doublePrice - marketDetailBean3.getDoublePrice()) + marketDetailBean.getDoublePrice()) / doublePrice)) + ((double) i17));
            }
            this.f77305l.put(i13, i11);
            this.f77303j.add(Integer.valueOf(i13));
            if (i12 == 0) {
                this.f77298e.moveTo((float) i13, (float) i11);
            } else {
                this.f77298e.lineTo((float) i13, (float) i11);
            }
            if (marketDetailBean3.equals(marketDetailBean) && marketDetailBean3.equals(marketDetailBean2)) {
                this.K.set(-1.0f, 0.0f);
                this.L.set((float) i13, (float) (i11 - PixelUtils.a(5.0f)));
            } else if (marketDetailBean3.equals(marketDetailBean)) {
                this.K.set((float) i13, (float) (i11 + PixelUtils.a(5.0f)));
            } else if (marketDetailBean3.equals(marketDetailBean2)) {
                this.L.set((float) i13, (float) (i11 - PixelUtils.a(5.0f)));
            }
            i12++;
            list2 = list;
            time = j12;
        }
        if (x()) {
            f(doublePrice);
        }
        w();
    }

    public final void h(boolean z11) {
        Boolean bool = this.f77319z;
        if (bool != null) {
            z11 = bool.booleanValue();
        }
        if (z11) {
            this.f77309p = getResources().getColor(R$color.base_up_color);
            if (this.A) {
                int color = getResources().getColor(R$color.green_002);
                this.f77306m = new int[]{color, color};
            } else {
                this.f77306m = new int[]{getResources().getColor(R$color.lite_trade_view_rise_color_start), getResources().getColor(R$color.lite_trade_view_color_end)};
            }
            this.f77318y = R$drawable.lite_kline_up;
            return;
        }
        this.f77309p = getResources().getColor(R$color.base_down_color);
        if (this.A) {
            int color2 = getResources().getColor(R$color.red_002);
            this.f77306m = new int[]{color2, color2};
        } else {
            this.f77306m = new int[]{getResources().getColor(R$color.lite_trade_view_down_color_start), getResources().getColor(R$color.lite_trade_view_color_end)};
        }
        this.f77318y = R$drawable.lite_kline_down;
    }

    public void i() {
        this.f77315v = null;
        H(true);
        invalidate();
    }

    public final void j(Canvas canvas) {
        I();
        this.O.setAlpha((int) (((double) (1.0f - this.M)) * 0.5d * 255.0d));
        Point point = this.S;
        canvas.drawCircle((float) point.x, (float) point.y, (this.M * ((float) PixelUtils.a(9.0f))) + ((float) PixelUtils.a(2.0f)), this.O);
    }

    public final void k(Canvas canvas) {
        if (!C()) {
            this.F.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/din_medium.otf"));
            Paint.FontMetrics fontMetrics = this.F.getFontMetrics();
            if (this.K.x >= 0.0f) {
                String t11 = t(this.J);
                float measureText = this.F.measureText(t11);
                float s11 = s(this.K.x - (measureText / 2.0f), measureText);
                int i11 = this.f77296c;
                canvas.drawText(t11, s11, ((((float) (i11 + (i11 - this.D))) - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.F);
            }
            String t12 = t(this.I);
            float measureText2 = this.F.measureText(t12);
            canvas.drawText(t12, s(this.L.x - (measureText2 / 2.0f), measureText2), ((((float) this.D) - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.F);
        }
    }

    public final void l(Canvas canvas) {
        if (this.f77300g > 0) {
            m(canvas);
            n(canvas);
        }
    }

    public final void m(Canvas canvas) {
        int i11 = this.f77300g;
        canvas.drawLine((float) i11, (float) this.D, (float) i11, (float) (this.f77296c - (this.E / 2)), this.f77301h);
        int a11 = PixelUtils.a(7.5f);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R$drawable.lite_kline_press);
        int i12 = this.f77300g;
        int i13 = this.f77300g;
        canvas.drawBitmap(decodeResource, (Rect) null, new RectF((float) (i12 - a11), (float) (this.f77305l.get(i12) - a11), (float) (i13 + a11), (float) (this.f77305l.get(i13) + a11)), this.f77301h);
    }

    public final void n(Canvas canvas) {
        MarketDetailBean marketDetailBean;
        N();
        int indexOf = this.f77303j.indexOf(Integer.valueOf(this.f77300g));
        if (indexOf > this.f77315v.size() - 1) {
            marketDetailBean = this.G;
        } else {
            marketDetailBean = this.f77315v.get(indexOf);
        }
        String u11 = u(marketDetailBean);
        int v11 = v(this.f77300g, (int) this.F.measureText(u11));
        Paint.FontMetrics fontMetrics = this.F.getFontMetrics();
        canvas.drawText(u11, (float) v11, ((((float) this.D) - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.F);
    }

    public final void o(Canvas canvas) {
        if (this.f77311r && this.f77312s > 0.0d && this.S != null && this.f77318y != 0) {
            j(canvas);
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.f77318y);
            Point point = this.S;
            int i11 = point.x;
            int i12 = this.f77316w;
            int i13 = point.y;
            canvas.drawBitmap(decodeResource, (Rect) null, new RectF((float) (i11 - i12), (float) (i13 - i12), (float) (i11 + i12), (float) (i13 + i12)), this.f77301h);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List<MarketDetailBean> list = this.f77315v;
        if (list != null && list.size() != 0) {
            canvas.drawColor(this.f77313t);
            q(canvas);
            p(canvas);
            k(canvas);
            l(canvas);
            o(canvas);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode == 1073741824) {
            this.f77295b = size;
        } else if (mode == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Width must be EXACTLY");
        }
        if (mode2 == 1073741824) {
            this.f77296c = size2;
        } else if (i11 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Height must be EXACTLY");
        }
        setMeasuredDimension(this.f77295b, this.f77296c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r4 != 3) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            android.view.GestureDetector r0 = r3.C
            boolean r0 = r0.onTouchEvent(r4)
            r1 = 1
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            float r0 = r4.getX()
            int r4 = r4.getAction()
            if (r4 == 0) goto L_0x0021
            if (r4 == r1) goto L_0x001d
            r2 = 2
            if (r4 == r2) goto L_0x0021
            r0 = 3
            if (r4 == r0) goto L_0x001d
            goto L_0x002a
        L_0x001d:
            r3.J()
            goto L_0x002a
        L_0x0021:
            boolean r4 = r3.C()
            if (r4 == 0) goto L_0x002a
            r3.setHighlight(r0)
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lite.market.widget.LiteTradingView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null) {
            if (i11 != 0) {
                valueAnimator.cancel();
            } else if (!valueAnimator.isRunning()) {
                this.N.start();
            }
        }
    }

    public final void p(Canvas canvas) {
        L();
        if (this.R) {
            this.f77297d.setMaskFilter(this.Q);
            canvas.drawPath(this.f77298e, this.f77297d);
            L();
            this.f77297d.setColor(ContextCompat.getColor(getContext(), R$color.white));
            canvas.drawPath(this.f77298e, this.f77297d);
            return;
        }
        this.f77297d.setStrokeWidth(this.f77297d.getStrokeWidth() * 4.0f);
        this.f77297d.setColor(ContextCompat.getColor(getContext(), R$color.white));
        canvas.drawPath(this.f77298e, this.f77297d);
        L();
        canvas.drawPath(this.f77298e, this.f77297d);
    }

    public final void q(Canvas canvas) {
        if (this.f77308o != null) {
            M();
            canvas.save();
            canvas.clipPath(this.f77299f);
            canvas.drawRect(this.f77308o, this.f77302i);
            canvas.restore();
        }
    }

    public final int r(float f11) {
        int i11 = 1;
        float f12 = Float.MAX_VALUE;
        int i12 = 0;
        while (i11 < this.f77303j.size()) {
            Integer num = this.f77303j.get(i11);
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

    public final float s(float f11, float f12) {
        if (f11 < 0.0f) {
            return 0.0f;
        }
        float f13 = (((float) this.f77295b) - f12) - ((float) (this.f77311r ? this.H : 0));
        return f13 > f11 ? f11 : f13;
    }

    public void setCurrencySymbol(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.P = str;
        }
    }

    public void setData(List<MarketDetailBean> list) {
        O(list, true);
    }

    public void setEnableInstantPrice(boolean z11) {
        this.f77311r = z11;
    }

    public void setInstantPrice(MarketDetailBean marketDetailBean) {
        if (marketDetailBean != null) {
            this.f77312s = marketDetailBean.getDoublePrice();
            this.G = marketDetailBean;
            if (x()) {
                O(this.f77315v, false);
            }
        }
    }

    public void setMManualRise(Boolean bool) {
        this.f77319z = bool;
    }

    public void setMShadowPureColor(boolean z11) {
        this.A = z11;
    }

    public void setOnHighlightListener(b bVar) {
        this.f77314u = bVar;
    }

    public final String t(String str) {
        return this.P + c.b(str, m.U(str));
    }

    public final String u(MarketDetailBean marketDetailBean) {
        if (this.f77314u == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f77314u.b(), Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date(marketDetailBean.getTime() * 1000));
    }

    public final int v(int i11, int i12) {
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

    public final void w() {
        this.f77299f.addPath(this.f77298e);
        Path path = this.f77299f;
        List<Integer> list = this.f77303j;
        path.lineTo((float) list.get(list.size() - 1).intValue(), (float) this.f77296c);
        this.f77299f.lineTo(0.0f, (float) this.f77296c);
        this.f77299f.close();
        this.f77308o = new RectF(0.0f, (float) this.D, (float) this.f77295b, (float) this.f77296c);
    }

    public final boolean x() {
        return this.f77311r && this.f77312s > 0.0d;
    }

    public final void y(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        B(context);
        G(context, attributeSet);
        h(true);
        A();
        View view = new View(context);
        this.B = view;
        view.setBackgroundColor(this.f77313t);
        addView(this.B, new FrameLayout.LayoutParams(-1, -1));
        this.C = new GestureDetector(context, new a());
        z();
    }

    public final void z() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.N = ofFloat;
        ofFloat.setDuration(1200);
        this.N.setInterpolator(new DecelerateInterpolator());
        this.N.setRepeatCount(-1);
        this.N.addUpdateListener(new hb.c(this));
    }

    public LiteTradingView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f77298e = new Path();
        this.f77299f = new Path();
        this.f77300g = -1;
        this.f77303j = new ArrayList();
        this.f77305l = new SparseIntArray();
        this.f77306m = new int[]{getResources().getColor(R$color.base_up_color), getResources().getColor(R$color.color_white)};
        this.f77307n = new float[]{0.0f, 1.0f};
        this.f77312s = -1.0d;
        this.f77319z = null;
        this.I = "0";
        this.J = "0";
        this.K = new PointF();
        this.L = new PointF();
        y(context, attributeSet);
    }
}
