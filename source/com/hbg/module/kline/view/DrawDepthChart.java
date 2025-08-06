package com.hbg.module.kline.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.utils.PaintUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$font;
import com.hbg.module.kline.bean.MarketDepthPercentItem;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import td.i;

public class DrawDepthChart extends View implements GestureDetector.OnGestureListener {
    public double A;
    public RectF A0 = new RectF();
    public int B;
    public final int B0 = PixelUtils.a(6.0f);
    public int C;
    public final int C0 = PixelUtils.a(4.0f);
    public float D;
    public final int D0 = PixelUtils.a(4.0f);
    public int E;
    public final int E0 = PixelUtils.a(4.0f);
    public int F;
    public int F0 = 0;
    public float G;
    public Rect G0 = new Rect();
    public int H;
    public RectF H0 = new RectF(0.0f, 0.0f, 8.0f, 8.0f);
    public int I;
    public RectF I0 = new RectF(0.0f, 0.0f, (float) PixelUtils.a(16.0f), (float) PixelUtils.a(16.0f));
    public int J;
    public PointF J0 = new PointF();
    public int K;
    public PointF K0 = new PointF();
    public float L;
    public PointF[] M;
    public PointF[] N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public TradeType T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a0  reason: collision with root package name */
    public GestureDetector f24313a0;

    /* renamed from: b  reason: collision with root package name */
    public int f24314b;

    /* renamed from: b0  reason: collision with root package name */
    public int f24315b0 = Color.parseColor("#5E5E61");

    /* renamed from: c  reason: collision with root package name */
    public int f24316c;

    /* renamed from: c0  reason: collision with root package name */
    public int f24317c0 = Color.parseColor("#8C8C93");

    /* renamed from: d  reason: collision with root package name */
    public Paint f24318d;

    /* renamed from: d0  reason: collision with root package name */
    public int f24319d0 = Color.parseColor("#E6E6E6");

    /* renamed from: e  reason: collision with root package name */
    public Paint f24320e;

    /* renamed from: e0  reason: collision with root package name */
    public int f24321e0 = Color.parseColor("#E5E6E6E6");

    /* renamed from: f  reason: collision with root package name */
    public Paint f24322f;

    /* renamed from: f0  reason: collision with root package name */
    public int f24323f0 = Color.parseColor("#4C4C4E");

    /* renamed from: g  reason: collision with root package name */
    public Paint f24324g;

    /* renamed from: g0  reason: collision with root package name */
    public Path f24325g0 = new Path();

    /* renamed from: h  reason: collision with root package name */
    public Paint f24326h;

    /* renamed from: h0  reason: collision with root package name */
    public Path f24327h0 = new Path();

    /* renamed from: i  reason: collision with root package name */
    public Paint f24328i;

    /* renamed from: i0  reason: collision with root package name */
    public Path f24329i0 = new Path();

    /* renamed from: j  reason: collision with root package name */
    public Paint f24330j;

    /* renamed from: j0  reason: collision with root package name */
    public Path f24331j0 = new Path();

    /* renamed from: k  reason: collision with root package name */
    public Paint f24332k;

    /* renamed from: k0  reason: collision with root package name */
    public PointF f24333k0 = new PointF();

    /* renamed from: l  reason: collision with root package name */
    public float f24334l;

    /* renamed from: l0  reason: collision with root package name */
    public PointF f24335l0 = new PointF();

    /* renamed from: m  reason: collision with root package name */
    public float f24336m;

    /* renamed from: m0  reason: collision with root package name */
    public View f24337m0;

    /* renamed from: n  reason: collision with root package name */
    public float f24338n;

    /* renamed from: n0  reason: collision with root package name */
    public boolean f24339n0 = false;

    /* renamed from: o  reason: collision with root package name */
    public float f24340o;

    /* renamed from: p  reason: collision with root package name */
    public float f24341p;

    /* renamed from: q  reason: collision with root package name */
    public float f24342q;

    /* renamed from: r  reason: collision with root package name */
    public List<MarketDepthPercentItem> f24343r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public List<MarketDepthPercentItem> f24344s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    public double f24345t;

    /* renamed from: t0  reason: collision with root package name */
    public boolean f24346t0;

    /* renamed from: u  reason: collision with root package name */
    public double f24347u;

    /* renamed from: u0  reason: collision with root package name */
    public int f24348u0;

    /* renamed from: v  reason: collision with root package name */
    public double f24349v;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f24350v0;

    /* renamed from: w  reason: collision with root package name */
    public double f24351w;

    /* renamed from: w0  reason: collision with root package name */
    public int f24352w0;

    /* renamed from: x  reason: collision with root package name */
    public double f24353x;

    /* renamed from: x0  reason: collision with root package name */
    public List<a> f24354x0 = new ArrayList(4);

    /* renamed from: y  reason: collision with root package name */
    public double f24355y;

    /* renamed from: y0  reason: collision with root package name */
    public RectF f24356y0 = new RectF();

    /* renamed from: z  reason: collision with root package name */
    public double f24357z;

    /* renamed from: z0  reason: collision with root package name */
    public List<a> f24358z0 = new ArrayList(4);

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f24359a;

        /* renamed from: b  reason: collision with root package name */
        public String f24360b;

        /* renamed from: c  reason: collision with root package name */
        public int f24361c;

        public a() {
        }

        public int a() {
            return this.f24361c;
        }

        public String b() {
            return this.f24359a;
        }

        public String c() {
            return this.f24360b;
        }

        public void d(String str, String str2, int i11) {
            this.f24359a = str;
            this.f24360b = str2;
            this.f24361c = i11;
        }
    }

    public DrawDepthChart(Context context) {
        super(context);
        o(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(Canvas canvas, RectF rectF, float f11, float f12, int i11, a aVar) {
        String b11 = aVar.b();
        String c11 = aVar.c();
        this.f24318d.setTextAlign(Paint.Align.LEFT);
        this.f24318d.setColor(this.f24317c0);
        float f13 = f11 + (f12 * ((float) i11));
        canvas.drawText(b11, rectF.left + ((float) this.B0), f13, this.f24318d);
        this.f24318d.setTextAlign(Paint.Align.RIGHT);
        this.f24318d.setColor(aVar.a());
        canvas.drawText(c11, rectF.right - ((float) this.B0), f13, this.f24318d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r7 = r0.M;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        r7 = r0.N;
     */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0333  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(boolean r19, int r20, java.util.List<com.hbg.module.kline.view.DrawDepthChart.a> r21, android.graphics.RectF r22, android.graphics.PointF r23) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = 1
            r6 = 0
            if (r19 == 0) goto L_0x0018
            android.graphics.PointF[] r7 = r0.M
            if (r7 == 0) goto L_0x0023
            int r7 = r7.length
            if (r1 >= r7) goto L_0x0023
            if (r1 <= 0) goto L_0x0023
            goto L_0x0021
        L_0x0018:
            android.graphics.PointF[] r7 = r0.N
            if (r7 == 0) goto L_0x0023
            int r7 = r7.length
            if (r1 >= r7) goto L_0x0023
            if (r1 <= 0) goto L_0x0023
        L_0x0021:
            r7 = r5
            goto L_0x0024
        L_0x0023:
            r7 = r6
        L_0x0024:
            if (r7 != 0) goto L_0x0027
            return r6
        L_0x0027:
            if (r19 == 0) goto L_0x002c
            java.util.List<com.hbg.module.kline.bean.MarketDepthPercentItem> r7 = r0.f24343r
            goto L_0x002e
        L_0x002c:
            java.util.List<com.hbg.module.kline.bean.MarketDepthPercentItem> r7 = r0.f24344s
        L_0x002e:
            java.lang.Object r7 = r7.get(r1)
            com.hbg.module.kline.bean.MarketDepthPercentItem r7 = (com.hbg.module.kline.bean.MarketDepthPercentItem) r7
            if (r7 != 0) goto L_0x0037
            return r6
        L_0x0037:
            int r8 = r21.size()
            if (r8 != 0) goto L_0x005d
            com.hbg.module.kline.view.DrawDepthChart$a r8 = new com.hbg.module.kline.view.DrawDepthChart$a
            r8.<init>()
            r2.add(r8)
            com.hbg.module.kline.view.DrawDepthChart$a r8 = new com.hbg.module.kline.view.DrawDepthChart$a
            r8.<init>()
            r2.add(r8)
            com.hbg.module.kline.view.DrawDepthChart$a r8 = new com.hbg.module.kline.view.DrawDepthChart$a
            r8.<init>()
            r2.add(r8)
            com.hbg.module.kline.view.DrawDepthChart$a r8 = new com.hbg.module.kline.view.DrawDepthChart$a
            r8.<init>()
            r2.add(r8)
        L_0x005d:
            android.graphics.RectF r8 = r0.H0
            r9 = 0
            r10 = 1090519040(0x41000000, float:8.0)
            r8.set(r9, r9, r10, r10)
            android.graphics.RectF r8 = r0.H0
            float r10 = r8.width()
            float r10 = -r10
            r11 = 1073741824(0x40000000, float:2.0)
            float r10 = r10 / r11
            android.graphics.RectF r12 = r0.H0
            float r12 = r12.height()
            float r12 = -r12
            float r12 = r12 / r11
            r8.offset(r10, r12)
            android.graphics.RectF r8 = r0.I0
            r10 = 1098907648(0x41800000, float:16.0)
            int r12 = com.hbg.lib.common.utils.PixelUtils.a(r10)
            float r12 = (float) r12
            int r10 = com.hbg.lib.common.utils.PixelUtils.a(r10)
            float r10 = (float) r10
            r8.set(r9, r9, r12, r10)
            android.graphics.RectF r8 = r0.I0
            float r10 = r8.width()
            float r10 = -r10
            float r10 = r10 / r11
            android.graphics.RectF r12 = r0.I0
            float r12 = r12.height()
            float r12 = -r12
            float r12 = r12 / r11
            r8.offset(r10, r12)
            if (r19 == 0) goto L_0x00a5
            android.graphics.PointF[] r8 = r0.M
            r1 = r8[r1]
            goto L_0x00a9
        L_0x00a5:
            android.graphics.PointF[] r8 = r0.N
            r1 = r8[r1]
        L_0x00a9:
            r4.set(r1)
            double r12 = r7.a()
            java.lang.String r1 = r0.s(r12)
            double r12 = r7.b()
            java.lang.String r8 = r0.t(r12)
            double r12 = r0.f24351w
            double r14 = r0.f24349v
            double r12 = r12 + r14
            r14 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r12 = r12 / r14
            double r14 = r7.b()
            double r14 = r14 - r12
            r16 = 0
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d2
            java.lang.String r7 = "+"
            goto L_0x00d4
        L_0x00d2:
            java.lang.String r7 = ""
        L_0x00d4:
            if (r19 == 0) goto L_0x00d9
            int r10 = r0.E
            goto L_0x00db
        L_0x00d9:
            int r10 = r0.F
        L_0x00db:
            java.lang.Object r16 = r2.get(r6)
            r11 = r16
            com.hbg.module.kline.view.DrawDepthChart$a r11 = (com.hbg.module.kline.view.DrawDepthChart.a) r11
            android.content.Context r9 = r18.getContext()
            int r6 = com.hbg.module.kline.R$string.n_exchange_order_list_entrust_price
            java.lang.String r6 = r9.getString(r6)
            int r9 = r0.f24319d0
            r11.d(r6, r8, r9)
            java.lang.Object r6 = r2.get(r5)
            com.hbg.module.kline.view.DrawDepthChart$a r6 = (com.hbg.module.kline.view.DrawDepthChart.a) r6
            android.content.Context r8 = r18.getContext()
            int r9 = com.hbg.module.kline.R$string.n_depth_chart_sum
            java.lang.String r8 = r8.getString(r9)
            int r9 = r0.f24319d0
            r6.d(r8, r1, r9)
            r1 = 2
            java.lang.Object r6 = r2.get(r1)
            com.hbg.module.kline.view.DrawDepthChart$a r6 = (com.hbg.module.kline.view.DrawDepthChart.a) r6
            android.content.Context r8 = r18.getContext()
            int r9 = com.hbg.module.kline.R$string.n_depth_chart_diff_value
            java.lang.String r8 = r8.getString(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            java.lang.String r7 = r0.t(r14)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r6.d(r8, r7, r10)
            r6 = 3
            java.lang.Object r6 = r2.get(r6)
            com.hbg.module.kline.view.DrawDepthChart$a r6 = (com.hbg.module.kline.view.DrawDepthChart.a) r6
            android.content.Context r7 = r18.getContext()
            int r8 = com.hbg.module.kline.R$string.rise_and_fall
            java.lang.String r7 = r7.getString(r8)
            double r14 = r14 / r12
            java.lang.String r8 = com.hbg.component.kline.utils.NumberKlineUtil.b(r14, r1)
            r6.d(r7, r8, r10)
            java.util.Iterator r6 = r21.iterator()
            r7 = 0
            r8 = 0
        L_0x014d:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x01b0
            java.lang.Object r9 = r6.next()
            com.hbg.module.kline.view.DrawDepthChart$a r9 = (com.hbg.module.kline.view.DrawDepthChart.a) r9
            java.lang.String r10 = r9.b()
            int r10 = r10.length()
            android.graphics.Paint r11 = r0.f24318d
            java.lang.String r12 = r9.b()
            android.graphics.Rect r13 = r0.G0
            r14 = 0
            r11.getTextBounds(r12, r14, r10, r13)
            android.graphics.Rect r10 = r0.G0
            int r10 = r10.width()
            if (r10 <= r7) goto L_0x017b
            android.graphics.Rect r7 = r0.G0
            int r7 = r7.width()
        L_0x017b:
            java.lang.String r10 = r9.c()
            int r10 = r10.length()
            android.graphics.Paint r11 = r0.f24318d
            java.lang.String r9 = r9.c()
            android.graphics.Rect r12 = r0.G0
            r13 = 0
            r11.getTextBounds(r9, r13, r10, r12)
            android.graphics.Rect r9 = r0.G0
            int r9 = r9.width()
            if (r9 <= r8) goto L_0x019d
            android.graphics.Rect r8 = r0.G0
            int r8 = r8.width()
        L_0x019d:
            android.graphics.Rect r9 = r0.G0
            int r9 = r9.height()
            int r10 = r0.F0
            if (r9 <= r10) goto L_0x014d
            android.graphics.Rect r9 = r0.G0
            int r9 = r9.height()
            r0.F0 = r9
            goto L_0x014d
        L_0x01b0:
            int r7 = r7 + r8
            int r6 = r0.B0
            int r6 = r6 * r1
            int r7 = r7 + r6
            int r6 = r0.C0
            int r7 = r7 + r6
            int r6 = r0.F0
            int r8 = r21.size()
            int r6 = r6 * r8
            int r8 = r0.B0
            int r8 = r8 * r1
            int r6 = r6 + r8
            int r1 = r21.size()
            int r1 = r1 - r5
            int r2 = r0.C0
            int r1 = r1 * r2
            int r6 = r6 + r1
            float r1 = (float) r7
            float r2 = (float) r6
            r6 = 0
            r3.set(r6, r6, r1, r2)
            float r1 = r0.f24334l
            if (r19 == 0) goto L_0x01d9
            r6 = 1073741824(0x40000000, float:2.0)
            goto L_0x01df
        L_0x01d9:
            float r2 = r0.f24341p
            r6 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r6
            float r1 = r1 + r2
        L_0x01df:
            float r2 = r0.f24336m
            if (r19 == 0) goto L_0x01ea
            float r7 = r0.f24334l
            float r8 = r0.f24341p
            float r8 = r8 / r6
            float r7 = r7 + r8
            goto L_0x01ef
        L_0x01ea:
            float r6 = r0.f24334l
            float r7 = r0.f24341p
            float r7 = r7 + r6
        L_0x01ef:
            float r6 = r0.f24342q
            float r2 = r2 + r6
            int r6 = r0.D0
            float r6 = (float) r6
            float r6 = r6 + r1
            float r8 = r22.width()
            float r6 = r6 + r8
            int r8 = r0.E0
            float r8 = (float) r8
            float r6 = r6 + r8
            android.graphics.RectF r8 = r0.I0
            float r8 = r8.width()
            r9 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r9
            float r6 = r6 + r8
            float r8 = r4.x
            float r10 = r0.f24334l
            float r11 = r8 + r10
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 > 0) goto L_0x0261
            float r8 = r8 + r10
            android.graphics.RectF r1 = r0.I0
            float r1 = r1.width()
            float r1 = r1 / r9
            float r8 = r8 - r1
            int r1 = r0.E0
            float r1 = (float) r1
            float r8 = r8 - r1
            float r1 = r22.width()
            float r8 = r8 - r1
            float r1 = r4.y
            float r6 = r22.height()
            float r6 = r6 / r9
            float r1 = r1 + r6
            int r6 = r0.D0
            float r6 = (float) r6
            float r1 = r1 + r6
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0240
            float r1 = r22.height()
            float r2 = r2 - r1
            int r1 = r0.D0
        L_0x023c:
            float r1 = (float) r1
            float r2 = r2 - r1
            goto L_0x0343
        L_0x0240:
            float r1 = r4.y
            float r2 = r22.height()
            r6 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r6
            float r1 = r1 - r2
            int r2 = r0.D0
            float r7 = (float) r2
            float r1 = r1 - r7
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0256
        L_0x0253:
            float r2 = (float) r2
            goto L_0x0343
        L_0x0256:
            float r1 = r4.y
            float r2 = r22.height()
        L_0x025c:
            float r2 = r2 / r6
        L_0x025d:
            float r2 = r1 - r2
            goto L_0x0343
        L_0x0261:
            int r6 = r0.D0
            float r6 = (float) r6
            float r6 = r7 - r6
            float r8 = r22.width()
            float r6 = r6 - r8
            int r8 = r0.E0
            float r8 = (float) r8
            float r6 = r6 - r8
            android.graphics.RectF r8 = r0.I0
            float r8 = r8.width()
            r9 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r9
            float r6 = r6 - r8
            float r8 = r4.x
            float r10 = r0.f24334l
            float r11 = r8 + r10
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 < 0) goto L_0x02c3
            float r8 = r8 + r10
            android.graphics.RectF r1 = r0.I0
            float r1 = r1.width()
            float r1 = r1 / r9
            float r8 = r8 + r1
            int r1 = r0.E0
            float r1 = (float) r1
            float r8 = r8 + r1
            float r1 = r4.y
            float r6 = r22.height()
            float r6 = r6 / r9
            float r1 = r1 + r6
            int r6 = r0.D0
            float r6 = (float) r6
            float r1 = r1 + r6
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x02a8
            float r1 = r22.height()
            float r2 = r2 - r1
            int r1 = r0.D0
            goto L_0x023c
        L_0x02a8:
            float r1 = r4.y
            float r2 = r22.height()
            r6 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r6
            float r1 = r1 - r2
            int r2 = r0.D0
            float r7 = (float) r2
            float r1 = r1 - r7
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x02bc
            goto L_0x0253
        L_0x02bc:
            float r1 = r4.y
            float r2 = r22.height()
            goto L_0x025c
        L_0x02c3:
            r6 = r9
            float r8 = r8 + r10
            float r2 = r22.width()
            float r2 = r2 / r6
            float r8 = r8 - r2
            int r2 = r0.D0
            float r6 = (float) r2
            float r8 = r8 - r6
            int r6 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r6 >= 0) goto L_0x02d9
            float r2 = (float) r2
            float r1 = r1 + r2
            r8 = r1
        L_0x02d6:
            r6 = 1073741824(0x40000000, float:2.0)
            goto L_0x0305
        L_0x02d9:
            float r1 = r4.x
            float r2 = r0.f24334l
            float r1 = r1 + r2
            float r2 = r22.width()
            r6 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r6
            float r1 = r1 + r2
            int r2 = r0.D0
            float r6 = (float) r2
            float r1 = r1 + r6
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x02f7
            float r1 = (float) r2
            float r7 = r7 - r1
            float r1 = r22.width()
            float r7 = r7 - r1
            r8 = r7
            goto L_0x02d6
        L_0x02f7:
            float r1 = r4.x
            float r2 = r0.f24334l
            float r1 = r1 + r2
            float r2 = r22.width()
            r6 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r6
            float r1 = r1 - r2
            r8 = r1
        L_0x0305:
            float r1 = r4.y
            float r2 = r22.height()
            float r1 = r1 - r2
            android.graphics.RectF r2 = r0.I0
            float r2 = r2.height()
            float r2 = r2 / r6
            float r1 = r1 - r2
            int r2 = r0.E0
            float r2 = (float) r2
            float r1 = r1 - r2
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x0333
            float r1 = r4.y
            float r2 = r22.height()
            float r1 = r1 - r2
            android.graphics.RectF r2 = r0.I0
            float r2 = r2.height()
            r6 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r6
            float r1 = r1 - r2
            int r2 = r0.E0
            float r2 = (float) r2
            goto L_0x025d
        L_0x0333:
            r6 = 1073741824(0x40000000, float:2.0)
            float r1 = r4.y
            android.graphics.RectF r2 = r0.I0
            float r2 = r2.height()
            float r2 = r2 / r6
            float r1 = r1 + r2
            int r2 = r0.E0
            float r2 = (float) r2
            float r2 = r2 + r1
        L_0x0343:
            r3.offset(r8, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.view.DrawDepthChart.b(boolean, int, java.util.List, android.graphics.RectF, android.graphics.PointF):boolean");
    }

    public void c() {
        f();
        e();
        if (this.f24342q > 0.0f && this.f24341p > 0.0f && this.f24343r.size() > 0 && this.f24344s.size() > 0) {
            this.M = m(true, this.f24343r, (double) this.f24342q, (double) this.f24336m);
            int i11 = 0;
            this.N = m(false, this.f24344s, (double) this.f24342q, (double) this.f24336m);
            if (this.M != null) {
                this.f24325g0.reset();
                this.f24327h0.reset();
                int i12 = 0;
                while (true) {
                    PointF[] pointFArr = this.M;
                    if (i12 >= pointFArr.length) {
                        break;
                    }
                    PointF pointF = pointFArr[i12];
                    if (i12 != pointFArr.length - 1) {
                        PointF pointF2 = pointFArr[i12 + 1];
                        float f11 = (pointF.x + pointF2.x) / 2.0f;
                        PointF pointF3 = this.f24333k0;
                        pointF3.y = pointF.y;
                        pointF3.x = f11;
                        PointF pointF4 = this.f24335l0;
                        pointF4.y = pointF2.y;
                        pointF4.x = f11;
                        if (i12 == 0) {
                            this.f24325g0.moveTo(pointF.x, pointF.y);
                            this.f24327h0.moveTo(pointF.x, pointF.y);
                        }
                        Path path = this.f24325g0;
                        PointF pointF5 = this.f24333k0;
                        float f12 = pointF5.x;
                        float f13 = pointF5.y;
                        PointF pointF6 = this.f24335l0;
                        path.cubicTo(f12, f13, pointF6.x, pointF6.y, pointF2.x, pointF2.y);
                        Path path2 = this.f24327h0;
                        PointF pointF7 = this.f24333k0;
                        float f14 = pointF7.x;
                        float f15 = pointF7.y;
                        PointF pointF8 = this.f24335l0;
                        path2.cubicTo(f14, f15, pointF8.x, pointF8.y, pointF2.x, pointF2.y);
                    } else {
                        this.f24325g0.lineTo((this.f24341p / 2.0f) + this.f24334l, this.f24342q + this.f24336m);
                        this.f24327h0.lineTo((this.f24341p / 2.0f) + this.f24334l, this.f24342q + this.f24336m);
                        this.f24327h0.lineTo(this.f24334l, this.f24342q + this.f24336m);
                        this.f24327h0.lineTo(this.f24334l, this.M[0].y);
                    }
                    i12++;
                }
            }
            if (this.N != null) {
                this.f24329i0.reset();
                this.f24331j0.reset();
                this.f24329i0.moveTo((this.f24341p / 2.0f) + this.f24334l, this.f24342q + this.f24336m);
                this.f24331j0.moveTo((this.f24341p / 2.0f) + this.f24334l, this.f24342q + this.f24336m);
                while (true) {
                    PointF[] pointFArr2 = this.N;
                    if (i11 < pointFArr2.length) {
                        PointF pointF9 = pointFArr2[i11];
                        if (i11 != pointFArr2.length - 1) {
                            PointF pointF10 = pointFArr2[i11 + 1];
                            float f16 = (pointF9.x + pointF10.x) / 2.0f;
                            PointF pointF11 = this.f24333k0;
                            pointF11.y = pointF9.y;
                            pointF11.x = f16;
                            PointF pointF12 = this.f24335l0;
                            float f17 = pointF10.y;
                            pointF12.y = f17;
                            pointF12.x = f16;
                            this.f24329i0.cubicTo(pointF11.x, pointF11.y, f16, f17, pointF10.x, pointF10.y);
                            Path path3 = this.f24331j0;
                            PointF pointF13 = this.f24333k0;
                            float f18 = pointF13.x;
                            float f19 = pointF13.y;
                            PointF pointF14 = this.f24335l0;
                            path3.cubicTo(f18, f19, pointF14.x, pointF14.y, pointF10.x, pointF10.y);
                        } else {
                            this.f24329i0.lineTo(this.f24334l + this.f24341p, pointF9.y);
                            this.f24331j0.lineTo(this.f24334l + this.f24341p, pointF9.y);
                            this.f24331j0.lineTo(this.f24334l + this.f24341p, this.f24342q + this.f24336m);
                            this.f24331j0.lineTo((this.f24341p / 2.0f) + this.f24334l, this.f24336m + this.f24342q);
                        }
                        i11++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void d(MotionEvent motionEvent) {
        PointF[] pointFArr;
        PointF[] pointFArr2 = this.N;
        if (pointFArr2 != null && pointFArr2.length > 0 && (pointFArr = this.M) != null && pointFArr.length > 0) {
            this.f24339n0 = true;
            float x11 = motionEvent.getX();
            float width = ((float) getWidth()) - motionEvent.getX();
            float f11 = this.f24334l;
            float f12 = this.f24341p;
            boolean z11 = x11 < (f12 / 2.0f) + f11;
            this.f24346t0 = z11;
            if (z11) {
                this.f24348u0 = (int) (((x11 - f11) / ((f12 / 2.0f) / ((float) this.M.length))) + 0.5f);
            } else {
                this.f24348u0 = (int) ((((x11 - f11) - (f12 / 2.0f)) / ((f12 / 2.0f) / ((float) this.N.length))) + 0.5f);
            }
            boolean z12 = true ^ z11;
            this.f24350v0 = z12;
            if (z12) {
                this.f24352w0 = (int) (((width - f11) / ((f12 / 2.0f) / ((float) this.M.length))) + 0.5f);
            } else {
                this.f24352w0 = (int) ((((width - f11) - (f12 / 2.0f)) / ((f12 / 2.0f) / ((float) this.N.length))) + 0.5f);
            }
            invalidate();
        }
    }

    public final void e() {
        double d11 = this.f24345t - this.f24347u;
        this.f24357z = d11;
        this.A = d11 / ((double) this.B);
        double d12 = this.f24349v;
        double d13 = this.f24351w;
        this.f24353x = d12 - d13;
        if (t(d13).length() >= 13) {
            this.C = 3;
        }
        this.f24355y = this.f24353x / ((double) (this.C - 1));
    }

    public final void f() {
        double d11;
        List<MarketDepthPercentItem> list = this.f24344s;
        if (list != null && list.size() > 0) {
            List<MarketDepthPercentItem> list2 = this.f24344s;
            MarketDepthPercentItem marketDepthPercentItem = list2.get(list2.size() - 1);
            if (marketDepthPercentItem != null) {
                this.f24349v = marketDepthPercentItem.b();
                this.f24345t = marketDepthPercentItem.a();
            }
        }
        List<MarketDepthPercentItem> list3 = this.f24343r;
        if (list3 != null && list3.size() > 0) {
            MarketDepthPercentItem marketDepthPercentItem2 = this.f24343r.get(0);
            if (marketDepthPercentItem2 != null) {
                this.f24351w = marketDepthPercentItem2.b();
                d11 = marketDepthPercentItem2.a();
            } else {
                d11 = 0.0d;
            }
            double d12 = this.f24345t;
            if (d11 <= d12) {
                d11 = d12;
            }
            this.f24345t = d11;
        }
        this.f24347u = 0.0d;
    }

    public final boolean g() {
        if (b(this.f24346t0, this.f24348u0, this.f24354x0, this.f24356y0, this.J0)) {
            if (b(this.f24350v0, this.f24352w0, this.f24358z0, this.A0, this.K0)) {
                return true;
            }
        }
        return false;
    }

    public float getBrokenLineBottom() {
        return this.f24338n;
    }

    public PointF[] getPoints() {
        return this.M;
    }

    public final void h(Canvas canvas) {
        String str;
        String str2;
        String str3;
        this.f24318d.setStyle(Paint.Style.FILL);
        float f11 = this.f24342q / ((float) this.B);
        this.f24318d.setTextAlign(Paint.Align.RIGHT);
        this.f24318d.setColor(this.f24315b0);
        for (int i11 = 0; i11 < this.B; i11++) {
            canvas.drawText(s((this.A * ((double) (this.B - i11))) + this.f24347u), (float) (getWidth() - this.V), ((((float) i11) * f11) - ((float) PixelUtils.a(3.0f))) + this.f24336m, this.f24318d);
        }
        float f12 = this.f24341p / ((float) (this.C - 1));
        this.f24318d.setTextAlign(Paint.Align.LEFT);
        Paint.FontMetrics fontMetrics = this.f24318d.getFontMetrics();
        float abs = this.f24336m + this.f24342q + Math.abs(fontMetrics.bottom - fontMetrics.top) + ((float) this.U);
        int i12 = 1;
        while (true) {
            str = "--";
            if (i12 >= this.C - 1) {
                break;
            }
            float f13 = ((float) i12) * f12;
            double d11 = (this.f24355y * ((double) i12)) + this.f24351w;
            TradeType tradeType = this.T;
            if (tradeType == TradeType.CONTRACT) {
                str3 = m.m(String.valueOf(d11), i.a().b().z(this.Q));
            } else if (TradeType.isSwap(tradeType)) {
                str3 = m.m(String.valueOf(d11), i.a().b().y(this.P));
            } else if (TradeType.isOption(this.T)) {
                str3 = m.m(String.valueOf(d11), FuturePrecisionUtil.y(this.Q, "", this.S));
            } else if (TradeType.isLinearSwap(this.T)) {
                str3 = m.m(String.valueOf(d11), FuturePrecisionUtil.y(this.Q, this.R, ""));
            } else {
                str3 = m.m(String.valueOf(d11), PrecisionUtil.e(this.O));
            }
            if (d11 > 0.0d && this.f24349v > 0.0d && this.f24351w > 0.0d) {
                str = str3 + "";
            }
            canvas.drawText(str, (this.f24334l + f13) - (this.f24318d.measureText(str) / 2.0f), abs, this.f24318d);
            i12++;
        }
        if (this.f24349v > 0.0d) {
            double d12 = this.f24351w;
            if (d12 > 0.0d) {
                String valueOf = String.valueOf(d12);
                String valueOf2 = String.valueOf(this.f24349v);
                TradeType tradeType2 = this.T;
                if (tradeType2 == TradeType.CONTRACT) {
                    str = m.m(valueOf, i.a().b().z(this.Q));
                    str2 = m.m(valueOf2, i.a().b().z(this.Q));
                } else if (TradeType.isSwap(tradeType2)) {
                    str = m.m(valueOf, i.a().b().y(this.P));
                    str2 = m.m(valueOf2, i.a().b().y(this.P));
                } else if (TradeType.isOption(this.T)) {
                    str = m.m(valueOf, FuturePrecisionUtil.y(this.Q, "", this.S));
                    str2 = m.m(valueOf2, FuturePrecisionUtil.y(this.Q, "", this.S));
                } else if (TradeType.isLinearSwap(this.T)) {
                    str = m.m(valueOf, FuturePrecisionUtil.y(this.Q, this.R, ""));
                    str2 = m.m(valueOf2, FuturePrecisionUtil.y(this.Q, this.R, ""));
                } else {
                    str = m.m(valueOf, PrecisionUtil.e(this.O));
                    str2 = m.m(valueOf2, PrecisionUtil.e(this.O));
                }
                canvas.drawText(str, this.f24334l, abs, this.f24318d);
                canvas.drawText(str2, (this.f24341p - this.f24318d.measureText(str2)) - this.f24340o, abs, this.f24318d);
            }
        }
        str2 = str;
        canvas.drawText(str, this.f24334l, abs, this.f24318d);
        canvas.drawText(str2, (this.f24341p - this.f24318d.measureText(str2)) - this.f24340o, abs, this.f24318d);
    }

    public void i(Canvas canvas) {
        if (this.M != null) {
            canvas.drawPath(this.f24327h0, this.f24324g);
            canvas.drawPath(this.f24325g0, this.f24322f);
        }
    }

    public final void j(Canvas canvas) {
        float f11 = this.f24342q / ((float) this.B);
        float a11 = (float) PixelUtils.a(0.5f);
        canvas.drawLine(0.0f, a11, (float) getWidth(), a11, this.f24332k);
        for (int i11 = 0; i11 < this.B; i11++) {
            float f12 = (((float) i11) * f11) + this.f24336m;
            canvas.drawLine(0.0f, f12, (float) getWidth(), f12, this.f24332k);
        }
        float width = (float) (getWidth() / 4);
        float f13 = 0.0f;
        for (int i12 = 0; i12 < 3; i12++) {
            f13 += width;
            canvas.drawLine(f13, 0.0f, f13, this.f24336m + this.f24342q, this.f24332k);
        }
    }

    public final void k(Canvas canvas, List<a> list, RectF rectF, PointF pointF, boolean z11) {
        if (!UtilCollections.f(list)) {
            this.H0.set(0.0f, 0.0f, 8.0f, 8.0f);
            RectF rectF2 = this.H0;
            rectF2.offset((-rectF2.width()) / 2.0f, (-this.H0.height()) / 2.0f);
            this.I0.set(0.0f, 0.0f, (float) PixelUtils.a(16.0f), (float) PixelUtils.a(16.0f));
            RectF rectF3 = this.I0;
            rectF3.offset((-rectF3.width()) / 2.0f, (-this.I0.height()) / 2.0f);
            this.H0.offset(pointF.x, pointF.y);
            this.I0.offset(pointF.x, pointF.y);
            canvas.drawArc(this.I0, 0.0f, 360.0f, true, this.f24330j);
            Paint paint = z11 ? this.f24322f : this.f24326h;
            Canvas canvas2 = canvas;
            Paint paint2 = paint;
            canvas2.drawArc(this.I0, 0.0f, 360.0f, false, paint2);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas2.drawArc(this.H0, 0.0f, 360.0f, true, paint2);
            paint.setStyle(Paint.Style.STROKE);
            PaintUtils.c(this.f24318d, this.f24321e0);
            canvas.drawRoundRect(rectF, (float) PixelUtils.a(4.0f), (float) PixelUtils.a(4.0f), this.f24318d);
            PaintUtils.d(this.f24318d, this.f24323f0, (float) CandleStickRender.f67208x2);
            canvas.drawRoundRect(rectF, (float) PixelUtils.a(4.0f), (float) PixelUtils.a(4.0f), this.f24318d);
            PaintUtils.h(this.f24318d, Paint.Align.LEFT, this.f24319d0, this.D);
            UtilCollections.c(list, new fe.a(this, canvas, rectF, ((rectF.top + ((float) this.B0)) + (((float) this.G0.height()) / 2.0f)) - this.G0.exactCenterY(), (float) (this.F0 + this.C0)));
        }
    }

    public void l(Canvas canvas) {
        if (this.N != null) {
            canvas.drawPath(this.f24331j0, this.f24328i);
            canvas.drawPath(this.f24329i0, this.f24326h);
        }
    }

    public final PointF[] m(boolean z11, List<MarketDepthPercentItem> list, double d11, double d12) {
        float f11;
        int size = list.size();
        float f12 = (this.f24341p / 2.0f) / ((float) size);
        PointF[] pointFArr = z11 ? this.M : this.N;
        if (pointFArr == null || pointFArr.length != size) {
            pointFArr = new PointF[size];
        }
        double d13 = this.A * ((double) this.B);
        for (int i11 = 0; i11 < size; i11++) {
            MarketDepthPercentItem marketDepthPercentItem = list.get(i11);
            double a11 = marketDepthPercentItem != null ? marketDepthPercentItem.a() - this.f24347u : 0.0d;
            double d14 = (d13 - this.f24347u) / d11;
            float f13 = (float) ((d11 + d12) - ((double) (d14 == 0.0d ? 0.0f : (float) (a11 / d14))));
            if (z11) {
                f11 = ((float) i11) * f12;
            } else {
                f11 = (this.f24341p / 2.0f) + (((float) i11) * f12);
            }
            if (pointFArr[i11] == null) {
                pointFArr[i11] = new PointF(f11, f13);
            } else {
                pointFArr[i11].set(f11, f13);
            }
        }
        return pointFArr;
    }

    public void n(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.B = 5;
        this.C = 5;
        this.D = (float) PixelUtils.a(10.0f);
        this.G = 3.0f;
        this.L = 2.0f;
        this.f24334l = (float) PixelUtils.a(0.0f);
        this.f24336m = (float) PixelUtils.a(27.0f);
        this.f24338n = (float) PixelUtils.a(20.0f);
        this.f24340o = (float) PixelUtils.a(0.0f);
        this.U = PixelUtils.a(5.0f);
        this.W = PixelUtils.a(5.0f);
        this.V = PixelUtils.a(5.0f);
        this.f24315b0 = i13;
        this.f24321e0 = i14;
        p(i11, i12, i13, i15, i16);
        this.f24313a0 = new GestureDetector(getContext(), this);
    }

    public final void o(Context context) {
        this.f24317c0 = KLineHelper.c(context, R$attr.kline_secondary_text_color);
        this.f24319d0 = KLineHelper.c(context, R$attr.kline_primary_text_color);
        this.f24323f0 = KLineHelper.c(context, R$attr.kline_four_level_text_color);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        j(canvas);
        i(canvas);
        l(canvas);
        h(canvas);
        if (this.f24339n0 && g()) {
            k(canvas, this.f24354x0, this.f24356y0, this.J0, this.f24346t0);
            k(canvas, this.f24358z0, this.A0, this.K0, this.f24350v0);
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        d(motionEvent);
        getParent().requestDisallowInterceptTouchEvent(this.f24339n0);
        HashMap hashMap = new HashMap(2);
        hashMap.put("uid", BaseModuleConfig.a().getUid());
        hashMap.put("pair", this.O);
        BaseModuleConfig.a().w("APP_market_Kline_deepclick", hashMap);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f24316c = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.f24314b = measuredWidth;
        this.f24341p = (((float) measuredWidth) - this.f24334l) - this.f24340o;
        this.f24342q = (((float) this.f24316c) - this.f24336m) - this.f24338n;
        c();
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f24339n0 = false;
        invalidate();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r0 != 3) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            android.view.GestureDetector r0 = r3.f24313a0
            r0.onTouchEvent(r4)
            int r0 = r4.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 1
            if (r0 == r1) goto L_0x0047
            r2 = 2
            if (r0 == r2) goto L_0x0015
            r4 = 3
            if (r0 == r4) goto L_0x0047
            goto L_0x0054
        L_0x0015:
            boolean r0 = r3.f24339n0
            if (r0 == 0) goto L_0x0054
            android.view.ViewParent r0 = r3.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
            android.view.View r0 = r3.f24337m0
            if (r0 != 0) goto L_0x003a
            android.content.Context r0 = r3.getContext()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x003a
            android.content.Context r0 = r3.getContext()
            android.app.Activity r0 = (android.app.Activity) r0
            int r2 = com.hbg.module.kline.R$id.rl_fragment_info_root
            android.view.View r0 = r0.findViewById(r2)
            r3.f24337m0 = r0
        L_0x003a:
            android.view.View r0 = r3.f24337m0
            if (r0 == 0) goto L_0x0043
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x0043:
            r3.d(r4)
            goto L_0x0054
        L_0x0047:
            r4 = 0
            r3.f24339n0 = r4
            r3.invalidate()
            android.view.ViewParent r0 = r3.getParent()
            r0.requestDisallowInterceptTouchEvent(r4)
        L_0x0054:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.view.DrawDepthChart.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i11, int i12, int i13, int i14, int i15) {
        if (this.f24318d == null) {
            this.f24318d = new Paint();
            Paint paint = new Paint(1);
            this.f24320e = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f24320e.setStrokeWidth((float) PixelUtils.a(0.6f));
            q(this.f24318d);
        }
        this.f24318d.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_regular));
        this.f24318d.setTextSize(this.D);
        this.f24318d.setTextAlign(Paint.Align.LEFT);
        this.f24318d.setColor(i13);
        if (this.f24322f == null) {
            Paint paint2 = new Paint();
            this.f24322f = paint2;
            q(paint2);
            this.f24322f.setStrokeWidth(this.G);
            int color = ContextCompat.getColor(getContext(), w.h());
            this.E = color;
            this.f24322f.setColor(color);
        }
        if (this.f24326h == null) {
            Paint paint3 = new Paint();
            this.f24326h = paint3;
            q(paint3);
            this.f24326h.setStrokeWidth(this.G);
            int color2 = ContextCompat.getColor(getContext(), w.d());
            this.F = color2;
            this.f24326h.setColor(color2);
        }
        this.J = i11;
        this.K = i12;
        if (this.f24324g == null) {
            Paint paint4 = new Paint();
            this.f24324g = paint4;
            paint4.setAntiAlias(true);
            this.f24324g.setStyle(Paint.Style.FILL);
            this.f24324g.setStrokeWidth(this.L);
            int i16 = w.l() ? i12 : i11;
            this.H = i16;
            this.f24324g.setColor(i16);
        }
        if (this.f24328i == null) {
            Paint paint5 = new Paint();
            this.f24328i = paint5;
            paint5.setAntiAlias(true);
            this.f24328i.setStyle(Paint.Style.FILL);
            this.f24328i.setStrokeWidth(this.L);
            if (!w.l()) {
                i11 = i12;
            }
            this.I = i11;
            this.f24328i.setColor(i11);
        }
        if (this.f24330j == null) {
            Paint paint6 = new Paint();
            this.f24330j = paint6;
            paint6.setAntiAlias(true);
            this.f24330j.setStyle(Paint.Style.FILL);
            this.f24330j.setColor(i14);
        }
        if (this.f24332k == null) {
            Paint paint7 = new Paint();
            this.f24332k = paint7;
            q(paint7);
        }
        this.f24332k.setStrokeWidth((float) PixelUtils.a(0.5f));
        this.f24332k.setColor(i15);
    }

    public final void q(Paint paint) {
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    public final String s(double d11) {
        if (TradeType.isContract(this.T)) {
            return m.T(String.valueOf(d11), i.a().b().t(this.Q));
        }
        if (TradeType.isSwap(this.T)) {
            return m.T(String.valueOf(d11), i.a().b().A(this.O));
        }
        if (TradeType.isOption(this.T)) {
            return m.T(String.valueOf(d11), FuturePrecisionUtil.s(this.Q, this.R, this.S));
        }
        if (TradeType.isLinearSwap(this.T)) {
            return m.T(String.valueOf(d11), FuturePrecisionUtil.s(this.Q, this.R, ""));
        }
        return m.T(String.valueOf(d11), PrecisionUtil.d(this.O));
    }

    public void setBorderTextSize(float f11) {
        this.D = (float) PixelUtils.a(f11);
    }

    public void setBuyDataListValue(List<MarketDepthPercentItem> list) {
        this.f24343r.clear();
        this.f24343r.addAll(list);
    }

    public void setConstractSymbol(String str) {
        this.P = str;
    }

    public void setContractCode(String str) {
        this.Q = str;
    }

    public void setContractShortType(String str) {
        this.R = str;
    }

    public void setMaxYVlaue(float f11) {
        this.f24345t = (double) f11;
    }

    public void setMinYValue(float f11) {
        this.f24347u = (double) f11;
    }

    public void setNumberLine(int i11) {
        this.B = i11;
    }

    public void setOptionCode(String str) {
        this.S = str;
    }

    public void setSellDataListValue(List<MarketDepthPercentItem> list) {
        this.f24344s.clear();
        this.f24344s.addAll(list);
    }

    public void setSymbol(String str) {
        this.O = str;
    }

    public void setTradeType(TradeType tradeType) {
        this.T = tradeType;
    }

    public final String t(double d11) {
        TradeType tradeType = this.T;
        if (tradeType == TradeType.CONTRACT) {
            return m.y(String.valueOf(d11), i.a().b().z(this.Q));
        }
        if (TradeType.isSwap(tradeType)) {
            return m.y(String.valueOf(d11), i.a().b().y(this.P));
        }
        if (TradeType.isOption(this.T)) {
            return m.y(String.valueOf(d11), FuturePrecisionUtil.y(this.Q, "", this.S));
        }
        if (TradeType.isLinearSwap(this.T)) {
            return m.y(String.valueOf(d11), FuturePrecisionUtil.y(this.Q, this.R, ""));
        }
        return m.y(String.valueOf(d11), PrecisionUtil.e(this.O));
    }

    public DrawDepthChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o(context);
    }
}
