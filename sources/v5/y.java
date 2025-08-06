package v5;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.hbg.component.kline.bean.DataSetIndex;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.shape.CrossHorizontalShape;
import com.hbg.component.kline.shape.DeathLightShape;
import com.hbg.component.kline.shape.FloatPriceShape;
import com.hbg.component.kline.shape.LabelShape;
import com.hbg.component.kline.utils.DateTimeKlineUtils;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.NumberKlineUtil;
import com.hbg.component.kline.utils.PaintUtils;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.module.kline.R$string;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import i6.d;
import i6.m;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class y extends q {
    public List<LabelShape> A0 = new ArrayList(6);
    public List<LabelShape> B0 = new ArrayList(6);
    public List<LabelShape> C0 = new ArrayList(6);
    public List<LabelShape> D0 = new ArrayList(6);
    public DeathLightShape E0 = new DeathLightShape();
    public CrossHorizontalShape F0 = new CrossHorizontalShape();
    public Date G0 = new Date();
    public float H0 = 0.0f;
    public RectF I0 = new RectF();
    public PointF J0;
    public CandleStickRender.InteractionMode K0;
    public float L0;
    public float M0;
    public float N0;
    public boolean O0;

    /* renamed from: f0  reason: collision with root package name */
    public String f68373f0;

    /* renamed from: g0  reason: collision with root package name */
    public int f68374g0 = ((int) (this.L * 6.0f));

    /* renamed from: h0  reason: collision with root package name */
    public RectF f68375h0 = new RectF();

    /* renamed from: i0  reason: collision with root package name */
    public RectF f68376i0 = new RectF();

    /* renamed from: j0  reason: collision with root package name */
    public KlineInfo f68377j0;

    /* renamed from: k0  reason: collision with root package name */
    public KlineInfo f68378k0;

    /* renamed from: l0  reason: collision with root package name */
    public float f68379l0;

    /* renamed from: m0  reason: collision with root package name */
    public float f68380m0;

    /* renamed from: n0  reason: collision with root package name */
    public float f68381n0;

    /* renamed from: t0  reason: collision with root package name */
    public float f68382t0;

    /* renamed from: u0  reason: collision with root package name */
    public int f68383u0 = 0;

    /* renamed from: v0  reason: collision with root package name */
    public int f68384v0 = 0;

    /* renamed from: w0  reason: collision with root package name */
    public int f68385w0 = 0;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f68386x0 = false;

    /* renamed from: y0  reason: collision with root package name */
    public List<a> f68387y0 = new ArrayList();

    /* renamed from: z0  reason: collision with root package name */
    public List<LabelShape> f68388z0 = new ArrayList();

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f68389a;

        /* renamed from: b  reason: collision with root package name */
        public String f68390b;

        /* renamed from: c  reason: collision with root package name */
        public int f68391c;

        public a(String str, String str2, int i11) {
            this.f68389a = str;
            this.f68390b = str2;
            this.f68391c = i11;
        }

        public boolean a(Object obj) {
            return obj instanceof a;
        }

        public int b() {
            return this.f68391c;
        }

        public String c() {
            return this.f68389a;
        }

        public String d() {
            return this.f68390b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            String c11 = c();
            String c12 = aVar.c();
            if (c11 != null ? !c11.equals(c12) : c12 != null) {
                return false;
            }
            String d11 = d();
            String d12 = aVar.d();
            if (d11 != null ? d11.equals(d12) : d12 == null) {
                return b() == aVar.b();
            }
            return false;
        }

        public int hashCode() {
            String c11 = c();
            int i11 = 43;
            int hashCode = c11 == null ? 43 : c11.hashCode();
            String d11 = d();
            int i12 = (hashCode + 59) * 59;
            if (d11 != null) {
                i11 = d11.hashCode();
            }
            return ((i12 + i11) * 59) + b();
        }

        public String toString() {
            return "LayerHighLight.IntoItem(name=" + c() + ", value=" + d() + ", color=" + b() + ")";
        }
    }

    public y(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
        this.E0.i(this.f68317n);
        int h12 = candleStickRender.h1();
        this.E0.q(h12);
        this.E0.s(Color.argb(51, Color.red(h12), Color.green(h12), Color.blue(h12)));
        this.E0.r((float) DimenUtils.a(2.0f));
        this.E0.t((float) DimenUtils.a(3.0f));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N0(Canvas canvas, int i11, a aVar) {
        String c11 = aVar.c();
        String d11 = aVar.d();
        this.f68317n.setTextAlign(Paint.Align.LEFT);
        this.f68317n.setColor(this.f68327x.a3());
        float f11 = (float) i11;
        canvas.drawText(c11, this.f68375h0.left + ((float) this.f68374g0), this.f68381n0 + (this.f68382t0 * f11), this.f68317n);
        this.f68317n.setTextAlign(Paint.Align.RIGHT);
        this.f68317n.setColor(aVar.b());
        canvas.drawText(d11, this.f68375h0.right - ((float) this.f68374g0), this.f68381n0 + (this.f68382t0 * f11), this.f68317n);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0(int i11, DataSetIndex dataSetIndex) {
        Double M2;
        if (dataSetIndex.d() > 0 && (M2 = this.f68327x.M2(C(this.f68378k0), dataSetIndex.d())) != null) {
            LabelShape y02 = y0();
            y02.r(dataSetIndex.c() + l.f34627b + V(M2.doubleValue()));
            y02.s(dataSetIndex.b());
            this.A0.add(y02);
            this.O0 = true;
            V0(y02);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P0(int i11, DataSetIndex dataSetIndex) {
        Double m12;
        if (dataSetIndex.d() > 0 && (m12 = this.f68327x.m1(C(this.f68378k0), dataSetIndex.d())) != null) {
            LabelShape y02 = y0();
            y02.r(dataSetIndex.c() + l.f34627b + V(m12.doubleValue()));
            y02.s(dataSetIndex.b());
            this.A0.add(y02);
            this.O0 = true;
            V0(y02);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q0(int i11, int i12, DataSetIndex dataSetIndex) {
        Double d11;
        if (dataSetIndex.d() > 0 && UtilCollections.h(this.f68327x.f67221d1, i11) && (d11 = (Double) this.f68327x.f67221d1.get(i11).get(Integer.valueOf(dataSetIndex.d()))) != null) {
            LabelShape y02 = y0();
            y02.r(dataSetIndex.c() + l.f34627b + m.T(String.valueOf(d11), this.f68327x.p3()));
            y02.s(dataSetIndex.b());
            this.C0.add(y02);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R0(int i11, int i12, DataSetIndex dataSetIndex) {
        Double d11 = (Double) this.f68327x.O1().get(i11).get(dataSetIndex.c() + dataSetIndex.d());
        if (d11 != null) {
            LabelShape y02 = y0();
            y02.r(dataSetIndex.c() + l.f34627b + V(d11.doubleValue()));
            y02.s(dataSetIndex.b());
            this.B0.add(y02);
            W0(y02, this.G);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S0(int i11, int i12, DataSetIndex dataSetIndex) {
        Double d11;
        if (UtilCollections.h(this.f68327x.f67218c1, i11) && (d11 = (Double) this.f68327x.f67218c1.get(i11).get(Integer.valueOf(dataSetIndex.d()))) != null) {
            LabelShape y02 = y0();
            y02.r(dataSetIndex.c() + l.f34627b + V(d11.doubleValue()));
            y02.s(dataSetIndex.b());
            this.B0.add(y02);
            W0(y02, this.I);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T0(int i11, int i12, DataSetIndex dataSetIndex) {
        Double d11;
        if (UtilCollections.h(this.f68327x.f67215b1, i11) && (d11 = (Double) this.f68327x.f67215b1.get(i11).get(Integer.valueOf(dataSetIndex.d()))) != null) {
            LabelShape y02 = y0();
            y02.r(dataSetIndex.c() + l.f34627b + V(d11.doubleValue()));
            y02.s(dataSetIndex.b());
            this.B0.add(y02);
            W0(y02, this.H);
        }
    }

    public void F() {
        int i11;
        String str;
        String str2;
        super.F();
        if (this.f68327x.B3()) {
            if (this.I0.width() != this.f68327x.C0()) {
                RectF rectF = this.I0;
                rectF.top = this.f68330y.top;
                RectF rectF2 = this.f68331z;
                rectF.left = rectF2.left;
                rectF.right = rectF2.left + this.f68327x.C0();
            }
            this.I0.bottom = this.J.bottom;
            List<KlineInfo> list = this.f68327x.Y0;
            KlineInfo klineInfo = list.get(list.size() - 1);
            KlineInfo klineInfo2 = this.f68377j0;
            if (klineInfo2 == null || klineInfo2.getTime() == klineInfo.getTime()) {
                this.f68378k0 = klineInfo;
                if (this.f68377j0 != null) {
                    this.f68377j0 = klineInfo;
                }
            } else {
                this.f68378k0 = this.f68377j0;
            }
            KlineInfo klineInfo3 = this.f68378k0;
            if (klineInfo3 != klineInfo) {
                int C = C(klineInfo3);
                CandleStickRender candleStickRender = this.f68327x;
                if (C < candleStickRender.f67272t0 || C > candleStickRender.f67276u0) {
                    candleStickRender.u3();
                    this.f68378k0 = klineInfo;
                }
            }
            this.C0.clear();
            this.D0.clear();
            this.B0.clear();
            this.A0.clear();
            this.O0 = false;
            KlineInfo klineInfo4 = this.f68378k0;
            if (klineInfo4 != null) {
                int C2 = C(klineInfo4);
                this.f68386x0 = this.f68327x.j0(C2) < this.f67202g / 2;
                this.G0.setTime(this.f68378k0.getTimeMs());
                this.f68373f0 = DateTimeKlineUtils.b(this.f68327x.N1()).format(this.G0);
                float f11 = this.f68325v;
                float f12 = this.P;
                this.M0 = f11 + f12;
                this.N0 = this.S + f12;
                PaintUtils.h(this.f68317n, Paint.Align.LEFT, 0, (float) this.N);
                if ((this.f68327x.x2() & 1) == 1 && !UtilCollections.f(this.f68327x.P2())) {
                    UtilCollections.c(this.f68327x.P2(), new r(this));
                }
                this.M0 = this.f68325v + this.P;
                if (this.O0) {
                    this.N0 += ((float) this.f68318o.height()) + this.P;
                    this.O0 = false;
                }
                if ((this.f68327x.x2() & 2) == 2 && !UtilCollections.f(this.f68327x.p1())) {
                    UtilCollections.c(this.f68327x.p1(), new s(this));
                }
                this.M0 = this.f68325v + this.P;
                if (this.O0) {
                    this.N0 += ((float) this.f68318o.height()) + this.P;
                    this.O0 = false;
                }
                if ((this.f68327x.x2() & 4) == 4) {
                    if (NumberKlineUtil.g(this.f68378k0.getBollMid())) {
                        LabelShape y02 = y0();
                        y02.r("BOLL: " + V(this.f68378k0.getBollMid()));
                        y02.s(this.f68327x.K1()[1]);
                        this.A0.add(y02);
                        V0(y02);
                    }
                    if (NumberKlineUtil.g(this.f68378k0.getBollHigh())) {
                        LabelShape y03 = y0();
                        y03.r("UB: " + V(this.f68378k0.getBollHigh()));
                        y03.s(this.f68327x.K1()[2]);
                        this.A0.add(y03);
                        V0(y03);
                    }
                    if (NumberKlineUtil.g(this.f68378k0.getBollLow())) {
                        LabelShape y04 = y0();
                        y04.r("LB: " + V(this.f68378k0.getBollLow()));
                        y04.s(this.f68327x.K1()[3]);
                        this.A0.add(y04);
                        V0(y04);
                    }
                }
                if (this.W) {
                    if (NumberKlineUtil.g(this.f68378k0.getAmount()) && NumberKlineUtil.g(this.f68378k0.getVol())) {
                        LabelShape y05 = y0();
                        if (this.f68327x.V4()) {
                            str2 = m.T(String.valueOf(this.f68378k0.getVol()), this.f68327x.p3());
                        } else {
                            str2 = m.T(String.valueOf(this.f68378k0.getAmount()), this.f68327x.p3());
                        }
                        y05.r("VOL: " + str2);
                        y05.s(this.f68327x.K1()[8]);
                        this.C0.add(y05);
                    }
                    if (!UtilCollections.f(this.f68327x.o3())) {
                        UtilCollections.c(this.f68327x.o3(), new v(this, C2));
                    }
                    if (NumberKlineUtil.f(this.f68327x.H0)) {
                        LabelShape y06 = y0();
                        y06.q(Paint.Align.RIGHT);
                        y06.s(this.f68327x.O0());
                        y06.r(m.T(String.valueOf(this.f68327x.H0), this.f68327x.p3()));
                        this.D0.add(y06);
                    }
                }
                if (this.f68327x.e3() != null && this.f68327x.e3().size() > 0) {
                    Iterator it2 = this.f68327x.e3().iterator();
                    while (it2.hasNext()) {
                        String str3 = (String) it2.next();
                        str3.hashCode();
                        char c11 = 65535;
                        switch (str3.hashCode()) {
                            case 2779:
                                if (str3.equals("WR")) {
                                    c11 = 0;
                                    break;
                                }
                                break;
                            case 74257:
                                if (str3.equals("KDJ")) {
                                    c11 = 1;
                                    break;
                                }
                                break;
                            case 81448:
                                if (str3.equals("RSI")) {
                                    c11 = 2;
                                    break;
                                }
                                break;
                            case 2358517:
                                if (str3.equals("MACD")) {
                                    c11 = 3;
                                    break;
                                }
                                break;
                        }
                        switch (c11) {
                            case 0:
                                this.L0 = this.f68325v + this.P;
                                UtilCollections.c(this.f68327x.t3(), new w(this, C2));
                                break;
                            case 1:
                                this.L0 = this.f68325v + this.P;
                                int d11 = this.f68327x.P1().get(0).d();
                                int d12 = this.f68327x.P1().get(1).d();
                                int d13 = this.f68327x.P1().get(2).d();
                                LabelShape y07 = y0();
                                y07.r(String.format("KDJ(%s,%s,%s)", new Object[]{Integer.valueOf(d11), Integer.valueOf(d12), Integer.valueOf(d13)}));
                                y07.s(this.f68327x.K1()[0]);
                                this.B0.add(y07);
                                W0(y07, this.G);
                                UtilCollections.c(this.f68327x.P1(), new u(this, C2));
                                break;
                            case 2:
                                this.L0 = this.f68325v + this.P;
                                UtilCollections.c(this.f68327x.V2(), new t(this, C2));
                                break;
                            case 3:
                                this.L0 = this.f68325v + this.P;
                                int d14 = this.f68327x.u2().get(0).d();
                                this.f68327x.u2().get(0).b();
                                int d15 = this.f68327x.u2().get(1).d();
                                int b11 = this.f68327x.u2().get(1).b();
                                int d16 = this.f68327x.u2().get(2).d();
                                int b12 = this.f68327x.u2().get(2).b();
                                LabelShape y08 = y0();
                                y08.r(String.format("MACD(%s,%s,%s)", new Object[]{Integer.valueOf(d14), Integer.valueOf(d15), Integer.valueOf(d16)}));
                                y08.s(this.f68327x.K1()[0]);
                                this.B0.add(y08);
                                W0(y08, this.F);
                                if (NumberKlineUtil.g(this.f68378k0.getMacd())) {
                                    LabelShape y09 = y0();
                                    y09.r(this.f68327x.u2().get(0).c() + l.f34627b + V(this.f68378k0.getMacd()));
                                    y09.s(this.f68327x.K1()[8]);
                                    this.B0.add(y09);
                                    W0(y09, this.F);
                                }
                                if (NumberKlineUtil.g(this.f68378k0.getDif())) {
                                    LabelShape y010 = y0();
                                    y010.r(this.f68327x.u2().get(1).c() + l.f34627b + V(this.f68378k0.getDif()));
                                    y010.s(b11);
                                    this.B0.add(y010);
                                    W0(y010, this.F);
                                }
                                if (!NumberKlineUtil.g(this.f68378k0.getDea())) {
                                    break;
                                } else {
                                    LabelShape y011 = y0();
                                    y011.r(this.f68327x.u2().get(2).c() + l.f34627b + V(this.f68378k0.getDea()));
                                    y011.s(b12);
                                    this.B0.add(y011);
                                    W0(y011, this.F);
                                    break;
                                }
                        }
                    }
                }
                if (!UtilCollections.f(this.C0)) {
                    this.f68317n.getTextBounds(this.C0.get(0).n(), 0, this.C0.get(0).n().length(), this.f68318o);
                    float f13 = this.f68325v + this.P;
                    float f14 = this.S + this.E.top;
                    for (LabelShape next : this.C0) {
                        this.f68317n.getTextBounds(next.n(), 0, next.n().length(), this.f68318o);
                        next.u(f13);
                        next.k(f14);
                        f13 += ((float) this.f68318o.width()) + this.Q;
                    }
                }
                if (!UtilCollections.f(this.D0)) {
                    this.f68317n.getTextBounds(this.D0.get(0).n(), 0, this.D0.get(0).n().length(), this.f68318o);
                    float f15 = (this.f68331z.right - this.f68326w) - this.P;
                    float f16 = this.S + this.E.top;
                    for (LabelShape next2 : this.D0) {
                        this.f68317n.getTextBounds(next2.n(), 0, next2.n().length(), this.f68318o);
                        next2.u(f15);
                        next2.k(f16);
                        f15 -= ((float) this.f68318o.width()) + this.Q;
                    }
                }
                if (X0()) {
                    int H1 = this.f68327x.H1();
                    if (this.f68378k0.getChange() < 0.0d) {
                        i11 = this.f68327x.J0();
                    } else {
                        i11 = this.f68378k0.getChange() > 0.0d ? this.f68327x.Q0() : H1;
                    }
                    this.f68387y0.clear();
                    if (this.f68327x.N1() != CandleStickRender.KLineType.TIME_LINE) {
                        this.f68387y0.add(new a(l(R$string.time), this.f68373f0, H1));
                        String V = V(this.f68378k0.getOpen());
                        this.f68387y0.add(new a(l(R$string.open_price), V, H1));
                        this.f68387y0.add(new a(l(R$string.highest), V(this.f68378k0.getHigh()), H1));
                        this.f68387y0.add(new a(l(R$string.lowest), V(this.f68378k0.getLow()), H1));
                        String V2 = V(this.f68378k0.getClose());
                        this.f68387y0.add(new a(l(R$string.close_price), V2, H1));
                        this.f68387y0.add(new a(l(R$string.rise_and_fall2), NumberKlineUtil.e(m.a(V2).subtract(m.a(V)).doubleValue(), this.f68327x.Q2()), i11));
                        this.f68387y0.add(new a(l(R$string.rise_and_fall), NumberKlineUtil.b(this.f68378k0.getChangeRatio(), 2), i11));
                        if (!this.f68327x.G3() && !this.f68327x.z3()) {
                            if (this.f68327x.V4()) {
                                str = m.T(String.valueOf(this.f68378k0.getVol()), this.f68327x.p3());
                            } else {
                                str = m.T(String.valueOf(this.f68378k0.getAmount()), this.f68327x.p3());
                            }
                            this.f68387y0.add(new a(l(R$string.n_kline_select_detail_volume), str, H1));
                        }
                        for (a next3 : this.f68387y0) {
                            this.f68317n.getTextBounds(next3.c(), 0, next3.c().length(), this.f68318o);
                            if (this.f68318o.width() > this.f68383u0) {
                                this.f68383u0 = this.f68318o.width();
                            }
                            this.f68317n.getTextBounds(next3.d(), 0, next3.d().length(), this.f68318o);
                            if (this.f68318o.width() > this.f68384v0) {
                                this.f68384v0 = this.f68318o.width();
                            }
                            int height = this.f68318o.height();
                            if (height > this.f68385w0) {
                                this.f68385w0 = height;
                            }
                        }
                        this.f68375h0.set(0.0f, 0.0f, (float) (this.f68383u0 + this.f68384v0 + (this.f68374g0 * 5)), (float) ((this.f68385w0 * this.f68387y0.size()) + (this.f68374g0 * 2) + ((this.f68387y0.size() - 1) * this.f68374g0)));
                        if (this.f68386x0) {
                            this.f68375h0.offset((float) ((int) ((this.f68315l.width() - (this.L * 4.0f)) - this.f68375h0.width())), this.L * 34.0f);
                        } else {
                            RectF rectF3 = this.f68375h0;
                            float f17 = this.L;
                            rectF3.offsetTo(4.0f * f17, f17 * 34.0f);
                        }
                        if (this.f68381n0 == 0.0f) {
                            this.f68381n0 = ((this.f68375h0.top + ((float) this.f68374g0)) + (((float) this.f68318o.height()) / 2.0f)) - this.f68318o.exactCenterY();
                            this.f68382t0 = (float) (this.f68385w0 + this.f68374g0);
                        }
                    }
                    this.f68380m0 = L0();
                    this.f68379l0 = D(this.f68327x.f67279v0);
                    this.F0.i(this.f68317n);
                    this.F0.E(this.N);
                    this.F0.D(this.f68327x.M0());
                    this.F0.k(this.f68380m0);
                    this.F0.z(M0());
                    this.F0.y(this.f68386x0);
                    this.F0.F(this.f67202g);
                    this.F0.A(this.f68327x.L0());
                    this.F0.C(this.f68327x.I0());
                    this.F0.B((float) CandleStickRender.f67208x2);
                    this.F0.h();
                    Paint paint = this.f68317n;
                    String str4 = this.f68373f0;
                    paint.getTextBounds(str4, 0, str4.length(), this.f68318o);
                    this.H0 = this.K.centerY() - this.f68318o.exactCenterY();
                    RectF rectF4 = this.f68376i0;
                    Rect rect = this.f68318o;
                    rectF4.left = (float) rect.left;
                    rectF4.right = (float) rect.right;
                    rectF4.top = 0.0f;
                    rectF4.bottom = FloatPriceShape.f67368y;
                    rectF4.inset((float) (-((int) (this.L * 2.0f))), 0.0f);
                    RectF rectF5 = this.f68376i0;
                    RectF rectF6 = this.K;
                    rectF5.offsetTo((float) Math.max(0, (int) Math.min(this.f68379l0 - (rectF5.width() / 2.0f), this.K.width() - this.f68376i0.width())), (float) ((int) (rectF6.top + ((rectF6.height() - this.f68376i0.height()) / 2.0f))));
                    return;
                }
                s5.a aVar = this.f68327x.L0;
                if (aVar != null) {
                    aVar.a((KlineInfo) null, false);
                }
            }
        }
    }

    public final void H0(Canvas canvas) {
        T(canvas, this.A0);
        T(canvas, this.C0);
        T(canvas, this.D0);
        T(canvas, this.B0);
    }

    public final void I0(Canvas canvas) {
        canvas.save();
        PaintUtils.b(this.f68317n, this.f68327x.I0(), (float) CandleStickRender.f67208x2);
        float f11 = this.f68379l0;
        RectF rectF = this.I0;
        canvas.drawLine(f11, rectF.top, f11, rectF.bottom, this.f68317n);
        canvas.restore();
        this.F0.l(canvas);
        this.E0.u(this.f68379l0);
        this.E0.k(this.f68380m0);
        this.E0.l(canvas);
    }

    public final void J0(Canvas canvas) {
        if (!UtilCollections.f(this.f68387y0)) {
            PaintUtils.c(this.f68317n, this.f68327x.N0());
            RectF rectF = this.f68375h0;
            float f11 = this.L;
            canvas.drawRoundRect(rectF, f11 * 4.0f, f11 * 4.0f, this.f68317n);
            PaintUtils.d(this.f68317n, this.f68327x.y1(), (float) CandleStickRender.f67208x2);
            RectF rectF2 = this.f68375h0;
            float f12 = this.L;
            canvas.drawRoundRect(rectF2, f12 * 4.0f, f12 * 4.0f, this.f68317n);
            PaintUtils.h(this.f68317n, Paint.Align.LEFT, 0, (float) this.O);
            UtilCollections.c(this.f68387y0, new x(this, canvas));
        }
        T(canvas, this.f68388z0);
    }

    public final void K0(Canvas canvas) {
        PaintUtils.c(this.f68317n, this.f68327x.L0());
        RectF rectF = this.f68376i0;
        float f11 = this.L;
        canvas.drawRoundRect(rectF, f11 * 2.0f, f11 * 2.0f, this.f68317n);
        PaintUtils.h(this.f68317n, Paint.Align.CENTER, this.f68327x.M0(), (float) this.N);
        canvas.drawText(this.f68373f0, this.f68376i0.centerX(), this.H0, this.f68317n);
    }

    public final float L0() {
        PointF pointF = this.J0;
        if (pointF != null) {
            float f11 = pointF.y;
            RectF rectF = this.f68331z;
            float f12 = rectF.top;
            if (f11 <= f12) {
                return f12;
            }
            float f13 = rectF.bottom;
            if (f11 >= f13) {
                return f13;
            }
            return f11;
        }
        float[] fArr = {this.f68316m.top, (float) this.f68378k0.getClose()};
        this.f68327x.O.mapPoints(fArr);
        return fArr[1];
    }

    public final String M0() {
        String V = V(this.f68378k0.getClose());
        float[] fArr = {0.0f, this.f68380m0};
        Matrix matrix = new Matrix();
        if (!this.f68327x.O.invert(matrix)) {
            return V;
        }
        matrix.mapPoints(fArr);
        return V((double) fArr[1]);
    }

    public void N() {
        super.N();
        this.f68377j0 = null;
        this.f68378k0 = null;
    }

    public void U0(CandleStickRender.InteractionMode interactionMode, PointF pointF) {
        this.K0 = interactionMode;
        this.J0 = pointF;
    }

    public final void V0(LabelShape labelShape) {
        this.f68317n.getTextBounds(labelShape.n(), 0, labelShape.n().length(), this.f68318o);
        if (this.M0 + ((float) this.f68318o.width()) > this.f68331z.right) {
            this.M0 = this.f68325v + this.P;
            this.N0 += ((float) this.f68318o.height()) + this.P;
        }
        labelShape.u(this.M0);
        labelShape.k(this.N0);
        this.M0 += ((float) this.f68318o.width()) + (this.f68318o.width() == 0 ? 0.0f : this.Q);
    }

    public final void W0(LabelShape labelShape, RectF rectF) {
        float f11 = this.S + rectF.top;
        this.f68317n.getTextBounds(labelShape.n(), 0, labelShape.n().length(), this.f68318o);
        labelShape.u(this.L0);
        labelShape.k(f11);
        this.L0 += ((float) this.f68318o.width()) + this.Q;
    }

    public final boolean X0() {
        return this.f68327x.M1() == CandleStickRender.InteractionMode.DRAG_HIGH_LIGHT || this.f68327x.M1() == CandleStickRender.InteractionMode.TOUCH_HIGH_LIGHT;
    }

    public void Y0(KlineInfo klineInfo, boolean z11) {
        this.f68377j0 = klineInfo;
        this.f68386x0 = z11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("updateHighLightKline klineInfo:");
        sb2.append(klineInfo == null ? null : klineInfo.extraInfoBean);
        d.i(sb2.toString());
        F();
    }

    public void n() {
        super.n();
    }

    public void y(Canvas canvas) {
        if (this.f68378k0 != null) {
            if (X0()) {
                I0(canvas);
                K0(canvas);
                J0(canvas);
            }
            H0(canvas);
        }
    }
}
