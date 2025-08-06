package v5;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import c6.b;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.shape.LabelShape;
import com.hbg.component.kline.shape.LineShape;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.NumberKlineUtil;
import com.hbg.lib.common.utils.UtilCollections;
import java.util.ArrayList;
import java.util.List;

public class q extends j {

    /* renamed from: d0  reason: collision with root package name */
    public static final int f68368d0 = DimenUtils.a(12.0f);

    /* renamed from: e0  reason: collision with root package name */
    public static final int f68369e0 = DimenUtils.a(8.0f);
    public float C;
    public float D;
    public RectF E = new RectF();
    public RectF F = new RectF();
    public RectF G = new RectF();
    public RectF H = new RectF();
    public RectF I = new RectF();
    public RectF J = new RectF();
    public RectF K = new RectF();
    public float L = ((float) DimenUtils.a(1.0f));
    public b<RectF> M;
    public int N = DimenUtils.a(9.0f);
    public int O = DimenUtils.a(10.0f);
    public float P = ((float) DimenUtils.a(4.0f));
    public float Q = ((float) DimenUtils.a(15.0f));
    public float R;
    public float S;
    public float T;
    public float U = 0.5f;
    public int V = 4;
    public boolean W;
    public Drawable X;
    public Rect Y = new Rect();
    public float Z = ((float) DimenUtils.a(2.5f));

    /* renamed from: a0  reason: collision with root package name */
    public float f68370a0 = ((float) DimenUtils.a(10.0f));

    /* renamed from: b0  reason: collision with root package name */
    public boolean f68371b0;

    /* renamed from: c0  reason: collision with root package name */
    public List<LineShape> f68372c0 = new ArrayList(16);

    public q(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
        Drawable q32 = candleStickRender.q3();
        this.X = q32;
        if (q32 != null) {
            this.Y.set(0, 0, q32.getIntrinsicWidth(), this.X.getIntrinsicHeight());
            this.X.setBounds(this.Y);
        }
    }

    public static /* synthetic */ void v0(Canvas canvas, int i11, LabelShape labelShape) {
        if (labelShape != null) {
            labelShape.l(canvas);
        }
    }

    public static /* synthetic */ void w0(Canvas canvas, int i11, LineShape lineShape) {
        if (lineShape != null) {
            lineShape.l(canvas);
        }
    }

    public static /* synthetic */ void x0(float[] fArr, int i11, LineShape lineShape) {
        int i12 = i11 << 2;
        fArr[i12 + 0] = lineShape.m()[0];
        fArr[i12 + 1] = lineShape.m()[1];
        fArr[i12 + 2] = lineShape.m()[2];
        fArr[i12 + 3] = lineShape.m()[3];
    }

    public boolean H(Object obj) {
        return obj instanceof q;
    }

    public b<RectF> I() {
        return this.M;
    }

    public int L() {
        return (int) (((this.f68330y.height() + this.f68331z.height()) - ((float) f68369e0)) - ((float) this.Y.height()));
    }

    public boolean M() {
        return this.f68371b0;
    }

    public void N() {
    }

    public void O(b<RectF> bVar) {
        this.M = bVar;
    }

    public void P(boolean z11) {
        this.f68371b0 = z11;
    }

    public void T(Canvas canvas, List<LabelShape> list) {
        UtilCollections.c(list, new n(canvas));
    }

    public void U(Canvas canvas, List<LineShape> list) {
        UtilCollections.c(list, new o(canvas));
    }

    public String V(double d11) {
        return NumberKlineUtil.d(d11, this.f68327x.Q2());
    }

    public float W() {
        return this.Z;
    }

    public float X() {
        return this.f68370a0;
    }

    public int Y() {
        return this.N;
    }

    public float Z() {
        return this.L;
    }

    public float a0() {
        return this.C;
    }

    public float b0() {
        return this.D;
    }

    public List<LineShape> c0() {
        return this.f68372c0;
    }

    public RectF d0() {
        return this.J;
    }

    public float e0() {
        return this.R;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (!qVar.H(this) || !super.equals(obj) || Float.compare(a0(), qVar.a0()) != 0 || Float.compare(b0(), qVar.b0()) != 0) {
            return false;
        }
        RectF p02 = p0();
        RectF p03 = qVar.p0();
        if (p02 != null ? !p02.equals(p03) : p03 != null) {
            return false;
        }
        RectF m02 = m0();
        RectF m03 = qVar.m0();
        if (m02 != null ? !m02.equals(m03) : m03 != null) {
            return false;
        }
        RectF k02 = k0();
        RectF k03 = qVar.k0();
        if (k02 != null ? !k02.equals(k03) : k03 != null) {
            return false;
        }
        RectF n02 = n0();
        RectF n03 = qVar.n0();
        if (n02 != null ? !n02.equals(n03) : n03 != null) {
            return false;
        }
        RectF s02 = s0();
        RectF s03 = qVar.s0();
        if (s02 != null ? !s02.equals(s03) : s03 != null) {
            return false;
        }
        RectF d02 = d0();
        RectF d03 = qVar.d0();
        if (d02 != null ? !d02.equals(d03) : d03 != null) {
            return false;
        }
        RectF t02 = t0();
        RectF t03 = qVar.t0();
        if (t02 != null ? !t02.equals(t03) : t03 != null) {
            return false;
        }
        if (Float.compare(Z(), qVar.Z()) != 0) {
            return false;
        }
        b<RectF> I2 = I();
        b<RectF> I3 = qVar.I();
        if (I2 != null ? !I2.equals(I3) : I3 != null) {
            return false;
        }
        if (Y() != qVar.Y() || j0() != qVar.j0() || Float.compare(g0(), qVar.g0()) != 0 || Float.compare(f0(), qVar.f0()) != 0 || Float.compare(e0(), qVar.e0()) != 0 || Float.compare(h0(), qVar.h0()) != 0 || Float.compare(i0(), qVar.i0()) != 0 || Float.compare(o0(), qVar.o0()) != 0 || l0() != qVar.l0() || u0() != qVar.u0()) {
            return false;
        }
        Drawable q02 = q0();
        Drawable q03 = qVar.q0();
        if (q02 != null ? !q02.equals(q03) : q03 != null) {
            return false;
        }
        Rect r02 = r0();
        Rect r03 = qVar.r0();
        if (r02 != null ? !r02.equals(r03) : r03 != null) {
            return false;
        }
        if (Float.compare(W(), qVar.W()) != 0 || Float.compare(X(), qVar.X()) != 0 || M() != qVar.M()) {
            return false;
        }
        List<LineShape> c02 = c0();
        List<LineShape> c03 = qVar.c0();
        return c02 != null ? c02.equals(c03) : c03 == null;
    }

    public float f0() {
        return this.Q;
    }

    public float g0() {
        return this.P;
    }

    public float h0() {
        return this.S;
    }

    public int hashCode() {
        int hashCode = (((super.hashCode() * 59) + Float.floatToIntBits(a0())) * 59) + Float.floatToIntBits(b0());
        RectF p02 = p0();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (p02 == null ? 43 : p02.hashCode());
        RectF m02 = m0();
        int hashCode3 = (hashCode2 * 59) + (m02 == null ? 43 : m02.hashCode());
        RectF k02 = k0();
        int hashCode4 = (hashCode3 * 59) + (k02 == null ? 43 : k02.hashCode());
        RectF n02 = n0();
        int hashCode5 = (hashCode4 * 59) + (n02 == null ? 43 : n02.hashCode());
        RectF s02 = s0();
        int hashCode6 = (hashCode5 * 59) + (s02 == null ? 43 : s02.hashCode());
        RectF d02 = d0();
        int hashCode7 = (hashCode6 * 59) + (d02 == null ? 43 : d02.hashCode());
        RectF t02 = t0();
        int hashCode8 = (((hashCode7 * 59) + (t02 == null ? 43 : t02.hashCode())) * 59) + Float.floatToIntBits(Z());
        b<RectF> I2 = I();
        int i12 = 79;
        int hashCode9 = (((((((((((((((((((((hashCode8 * 59) + (I2 == null ? 43 : I2.hashCode())) * 59) + Y()) * 59) + j0()) * 59) + Float.floatToIntBits(g0())) * 59) + Float.floatToIntBits(f0())) * 59) + Float.floatToIntBits(e0())) * 59) + Float.floatToIntBits(h0())) * 59) + Float.floatToIntBits(i0())) * 59) + Float.floatToIntBits(o0())) * 59) + l0()) * 59) + (u0() ? 79 : 97);
        Drawable q02 = q0();
        int hashCode10 = (hashCode9 * 59) + (q02 == null ? 43 : q02.hashCode());
        Rect r02 = r0();
        int hashCode11 = ((((((hashCode10 * 59) + (r02 == null ? 43 : r02.hashCode())) * 59) + Float.floatToIntBits(W())) * 59) + Float.floatToIntBits(X())) * 59;
        if (!M()) {
            i12 = 97;
        }
        List<LineShape> c02 = c0();
        int i13 = (hashCode11 + i12) * 59;
        if (c02 != null) {
            i11 = c02.hashCode();
        }
        return i13 + i11;
    }

    public float i0() {
        return this.T;
    }

    public int j0() {
        return this.O;
    }

    public RectF k0() {
        return this.G;
    }

    public int l0() {
        return this.V;
    }

    public RectF m0() {
        return this.F;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n() {
        /*
            r14 = this;
            super.n()
            java.util.List<com.hbg.component.kline.shape.LineShape> r0 = r14.f68372c0
            r0.clear()
            android.graphics.RectF r0 = r14.E
            r0.setEmpty()
            android.graphics.RectF r0 = r14.F
            r0.setEmpty()
            android.graphics.RectF r0 = r14.G
            r0.setEmpty()
            android.graphics.RectF r0 = r14.H
            r0.setEmpty()
            android.graphics.RectF r0 = r14.I
            r0.setEmpty()
            android.graphics.RectF r0 = r14.J
            r0.setEmpty()
            android.graphics.RectF r0 = r14.K
            r0.setEmpty()
            com.hbg.component.kline.render.CandleStickRender r0 = r14.f68327x
            java.lang.String r0 = r0.d3()
            java.lang.String r1 = "VOL"
            boolean r0 = r1.equals(r0)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0051
            com.hbg.component.kline.render.CandleStickRender r0 = r14.f68327x
            java.util.LinkedHashSet r0 = r0.e3()
            if (r0 == 0) goto L_0x004f
            com.hbg.component.kline.render.CandleStickRender r0 = r14.f68327x
            java.util.LinkedHashSet r0 = r0.e3()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0051
        L_0x004f:
            r0 = r3
            goto L_0x0052
        L_0x0051:
            r0 = r2
        L_0x0052:
            r14.W = r0
            com.hbg.component.kline.render.CandleStickRender r4 = r14.f68327x
            java.util.LinkedHashSet r4 = r4.e3()
            if (r4 == 0) goto L_0x007f
            com.hbg.component.kline.render.CandleStickRender r4 = r14.f68327x
            java.util.LinkedHashSet r4 = r4.e3()
            boolean r4 = r4.contains(r1)
            if (r4 == 0) goto L_0x0074
            com.hbg.component.kline.render.CandleStickRender r4 = r14.f68327x
            java.util.LinkedHashSet r4 = r4.e3()
            int r4 = r4.size()
            int r4 = r4 - r3
            goto L_0x007e
        L_0x0074:
            com.hbg.component.kline.render.CandleStickRender r4 = r14.f68327x
            java.util.LinkedHashSet r4 = r4.e3()
            int r4 = r4.size()
        L_0x007e:
            int r0 = r0 + r4
        L_0x007f:
            int r4 = r14.f67201f
            float r4 = (float) r4
            float r5 = r14.f68324u
            float r4 = r4 - r5
            float r5 = r14.f68323t
            float r4 = r4 - r5
            boolean r5 = r14.f68371b0
            int r5 = com.hbg.component.kline.constants.KLineConstants.a(r5)
            int r5 = r5 * r0
            float r5 = (float) r5
            float r4 = r4 - r5
            int r5 = r14.V
            float r6 = (float) r5
            float r7 = r14.U
            float r6 = r6 + r7
            float r4 = r4 / r6
            r14.C = r4
            int r6 = r14.f67202g
            float r8 = (float) r6
            float r9 = r14.f68325v
            float r8 = r8 - r9
            float r10 = r14.f68326w
            float r8 = r8 - r10
            r11 = 1084227584(0x40a00000, float:5.0)
            float r8 = r8 / r11
            r14.D = r8
            android.graphics.RectF r8 = r14.f68330y
            float r11 = r14.f68323t
            r8.top = r11
            r8.left = r9
            float r12 = (float) r6
            float r12 = r12 - r10
            r8.right = r12
            float r7 = r7 * r4
            float r11 = r11 + r7
            r8.bottom = r11
            android.graphics.RectF r7 = r14.f68331z
            r7.top = r11
            r7.left = r9
            float r6 = (float) r6
            float r6 = r6 - r10
            r7.right = r6
            float r5 = (float) r5
            float r4 = r4 * r5
            float r11 = r11 + r4
            r7.bottom = r11
            com.hbg.component.kline.render.CandleStickRender r4 = r14.f68327x
            boolean r4 = r4.x3()
            if (r4 != 0) goto L_0x00e9
            android.graphics.RectF r4 = r14.K
            android.graphics.RectF r5 = r14.f68331z
            float r5 = r5.bottom
            r4.top = r5
            float r6 = r14.f68325v
            r4.left = r6
            int r6 = r14.f67202g
            float r6 = (float) r6
            float r7 = r14.f68326w
            float r6 = r6 - r7
            r4.right = r6
            float r6 = r14.f68324u
            float r11 = r5 + r6
            r4.bottom = r11
        L_0x00e9:
            android.graphics.RectF r4 = r14.J
            float r5 = r14.f68325v
            r4.left = r5
            int r5 = r14.f67202g
            float r5 = (float) r5
            float r6 = r14.f68326w
            float r5 = r5 - r6
            r4.right = r5
            r4.top = r11
            com.hbg.component.kline.render.CandleStickRender r4 = r14.f68327x
            java.util.LinkedHashSet r4 = r4.e3()
            r5 = 3
            r6 = 2
            r7 = 4
            if (r4 == 0) goto L_0x0216
            com.hbg.component.kline.render.CandleStickRender r4 = r14.f68327x
            java.util.LinkedHashSet r4 = r4.e3()
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0216
            com.hbg.component.kline.render.CandleStickRender r4 = r14.f68327x
            java.util.LinkedHashSet r4 = r4.e3()
            java.util.Iterator r4 = r4.iterator()
        L_0x011a:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x023c
            java.lang.Object r8 = r4.next()
            java.lang.String r8 = (java.lang.String) r8
            r8.hashCode()
            r9 = -1
            int r10 = r8.hashCode()
            switch(r10) {
                case 2779: goto L_0x015c;
                case 74257: goto L_0x0151;
                case 81448: goto L_0x0146;
                case 85171: goto L_0x013d;
                case 2358517: goto L_0x0132;
                default: goto L_0x0131;
            }
        L_0x0131:
            goto L_0x0166
        L_0x0132:
            java.lang.String r10 = "MACD"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x013b
            goto L_0x0166
        L_0x013b:
            r9 = r7
            goto L_0x0166
        L_0x013d:
            boolean r8 = r8.equals(r1)
            if (r8 != 0) goto L_0x0144
            goto L_0x0166
        L_0x0144:
            r9 = r5
            goto L_0x0166
        L_0x0146:
            java.lang.String r10 = "RSI"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x014f
            goto L_0x0166
        L_0x014f:
            r9 = r6
            goto L_0x0166
        L_0x0151:
            java.lang.String r10 = "KDJ"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x015a
            goto L_0x0166
        L_0x015a:
            r9 = r3
            goto L_0x0166
        L_0x015c:
            java.lang.String r10 = "WR"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0165
            goto L_0x0166
        L_0x0165:
            r9 = r2
        L_0x0166:
            switch(r9) {
                case 0: goto L_0x01f4;
                case 1: goto L_0x01d3;
                case 2: goto L_0x01b2;
                case 3: goto L_0x018d;
                case 4: goto L_0x016a;
                default: goto L_0x0169;
            }
        L_0x0169:
            goto L_0x011a
        L_0x016a:
            android.graphics.RectF r8 = r14.F
            r8.top = r11
            float r9 = r14.f68325v
            r8.left = r9
            int r9 = r14.f67202g
            float r9 = (float) r9
            float r10 = r14.f68326w
            float r9 = r9 - r10
            r8.right = r9
            boolean r9 = r14.f68371b0
            int r9 = com.hbg.component.kline.constants.KLineConstants.a(r9)
            float r9 = (float) r9
            float r9 = r9 + r11
            r8.bottom = r9
            boolean r8 = r14.f68371b0
            int r8 = com.hbg.component.kline.constants.KLineConstants.a(r8)
        L_0x018a:
            float r8 = (float) r8
            float r11 = r11 + r8
            goto L_0x011a
        L_0x018d:
            boolean r8 = r14.W
            if (r8 == 0) goto L_0x011a
            android.graphics.RectF r8 = r14.E
            r8.top = r11
            float r9 = r14.f68325v
            r8.left = r9
            int r9 = r14.f67202g
            float r9 = (float) r9
            float r10 = r14.f68326w
            float r9 = r9 - r10
            r8.right = r9
            boolean r9 = r14.f68371b0
            int r9 = com.hbg.component.kline.constants.KLineConstants.a(r9)
            float r9 = (float) r9
            float r9 = r9 + r11
            r8.bottom = r9
            boolean r8 = r14.f68371b0
            int r8 = com.hbg.component.kline.constants.KLineConstants.a(r8)
            goto L_0x018a
        L_0x01b2:
            android.graphics.RectF r8 = r14.H
            r8.top = r11
            float r9 = r14.f68325v
            r8.left = r9
            int r9 = r14.f67202g
            float r9 = (float) r9
            float r10 = r14.f68326w
            float r9 = r9 - r10
            r8.right = r9
            boolean r9 = r14.f68371b0
            int r9 = com.hbg.component.kline.constants.KLineConstants.a(r9)
            float r9 = (float) r9
            float r9 = r9 + r11
            r8.bottom = r9
            boolean r8 = r14.f68371b0
            int r8 = com.hbg.component.kline.constants.KLineConstants.a(r8)
            goto L_0x018a
        L_0x01d3:
            android.graphics.RectF r8 = r14.G
            r8.top = r11
            float r9 = r14.f68325v
            r8.left = r9
            int r9 = r14.f67202g
            float r9 = (float) r9
            float r10 = r14.f68326w
            float r9 = r9 - r10
            r8.right = r9
            boolean r9 = r14.f68371b0
            int r9 = com.hbg.component.kline.constants.KLineConstants.a(r9)
            float r9 = (float) r9
            float r9 = r9 + r11
            r8.bottom = r9
            boolean r8 = r14.f68371b0
            int r8 = com.hbg.component.kline.constants.KLineConstants.a(r8)
            goto L_0x018a
        L_0x01f4:
            android.graphics.RectF r8 = r14.I
            r8.top = r11
            float r9 = r14.f68325v
            r8.left = r9
            int r9 = r14.f67202g
            float r9 = (float) r9
            float r10 = r14.f68326w
            float r9 = r9 - r10
            r8.right = r9
            boolean r9 = r14.f68371b0
            int r9 = com.hbg.component.kline.constants.KLineConstants.a(r9)
            float r9 = (float) r9
            float r9 = r9 + r11
            r8.bottom = r9
            boolean r8 = r14.f68371b0
            int r8 = com.hbg.component.kline.constants.KLineConstants.a(r8)
            goto L_0x018a
        L_0x0216:
            boolean r1 = r14.W
            if (r1 == 0) goto L_0x023c
            android.graphics.RectF r1 = r14.E
            r1.top = r11
            float r4 = r14.f68325v
            r1.left = r4
            int r4 = r14.f67202g
            float r4 = (float) r4
            float r8 = r14.f68326w
            float r4 = r4 - r8
            r1.right = r4
            boolean r4 = r14.f68371b0
            int r4 = com.hbg.component.kline.constants.KLineConstants.a(r4)
            float r4 = (float) r4
            float r4 = r4 + r11
            r1.bottom = r4
            boolean r1 = r14.f68371b0
            int r1 = com.hbg.component.kline.constants.KLineConstants.a(r1)
            float r1 = (float) r1
            float r11 = r11 + r1
        L_0x023c:
            android.graphics.RectF r1 = r14.J
            r1.bottom = r11
            com.hbg.component.kline.render.CandleStickRender r1 = r14.f68327x
            boolean r1 = r1.x3()
            if (r1 == 0) goto L_0x025d
            android.graphics.RectF r1 = r14.K
            r1.top = r11
            float r4 = r14.f68325v
            r1.left = r4
            int r4 = r14.f67202g
            float r4 = (float) r4
            float r8 = r14.f68326w
            float r4 = r4 - r8
            r1.right = r4
            float r4 = r14.f68324u
            float r11 = r11 + r4
            r1.bottom = r11
        L_0x025d:
            android.graphics.Paint r1 = r14.f68317n
            int r4 = r14.O
            float r4 = (float) r4
            r1.setTextSize(r4)
            android.graphics.Paint r1 = r14.f68317n
            android.graphics.Rect r4 = r14.f68318o
            java.lang.String r8 = "BOLL"
            r1.getTextBounds(r8, r2, r7, r4)
            android.graphics.Rect r1 = r14.f68318o
            int r1 = r1.height()
            float r1 = (float) r1
            float r4 = r14.L
            r9 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 * r9
            float r1 = r1 + r4
            r14.R = r1
            float r1 = r14.S
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x02b4
            android.graphics.Paint r1 = r14.f68317n
            android.graphics.Paint$Align r4 = android.graphics.Paint.Align.LEFT
            int r10 = r14.N
            float r10 = (float) r10
            com.hbg.component.kline.utils.PaintUtils.h(r1, r4, r2, r10)
            android.graphics.Paint r1 = r14.f68317n
            android.graphics.Rect r4 = r14.f68318o
            r1.getTextBounds(r8, r2, r7, r4)
            float r1 = r14.R
            float r1 = r1 / r9
            android.graphics.Rect r4 = r14.f68318o
            float r4 = r4.exactCenterY()
            float r1 = r1 - r4
            float r4 = r14.L
            float r1 = r1 + r4
            r14.S = r1
            float r1 = r14.R
            float r1 = -r1
            float r1 = r1 / r9
            android.graphics.Rect r4 = r14.f68318o
            float r4 = r4.exactCenterY()
            float r1 = r1 - r4
            float r4 = r14.L
            float r1 = r1 - r4
            r14.T = r1
        L_0x02b4:
            java.lang.Class r1 = r14.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.Class<v5.q> r4 = v5.q.class
            java.lang.String r4 = r4.getName()
            boolean r1 = android.text.TextUtils.equals(r1, r4)
            if (r1 != 0) goto L_0x02c9
            return
        L_0x02c9:
            java.util.ArrayList r1 = new java.util.ArrayList
            r4 = 16
            r1.<init>(r4)
            com.hbg.component.kline.render.CandleStickRender r4 = r14.f68327x
            boolean r4 = r4.x3()
            r8 = 5
            if (r4 != 0) goto L_0x0380
            r4 = r2
        L_0x02da:
            int r9 = r14.V
            if (r4 > r9) goto L_0x0304
            android.graphics.RectF r9 = r14.f68331z
            float r10 = r9.left
            float r9 = r9.top
            float r11 = r14.C
            float r12 = (float) r4
            float r11 = r11 * r12
            float r9 = r9 + r11
            com.hbg.component.kline.shape.LineShape r11 = r14.z0()
            float[] r12 = new float[r7]
            r12[r2] = r10
            r12[r3] = r9
            android.graphics.RectF r10 = r14.f68331z
            float r10 = r10.right
            r12[r6] = r10
            r12[r5] = r9
            r11.q(r12)
            r1.add(r11)
            int r4 = r4 + 1
            goto L_0x02da
        L_0x0304:
            r4 = r2
        L_0x0305:
            if (r4 >= r0) goto L_0x033c
            com.hbg.component.kline.shape.LineShape r9 = r14.z0()
            float[] r10 = new float[r7]
            android.graphics.RectF r11 = r14.K
            float r12 = r11.left
            r10[r2] = r12
            float r11 = r11.bottom
            boolean r12 = r14.f68371b0
            int r12 = com.hbg.component.kline.constants.KLineConstants.a(r12)
            int r12 = r12 * r4
            float r12 = (float) r12
            float r11 = r11 + r12
            r10[r3] = r11
            android.graphics.RectF r11 = r14.K
            float r12 = r11.right
            r10[r6] = r12
            float r11 = r11.bottom
            boolean r12 = r14.f68371b0
            int r12 = com.hbg.component.kline.constants.KLineConstants.a(r12)
            int r12 = r12 * r4
            float r12 = (float) r12
            float r11 = r11 + r12
            r10[r5] = r11
            r9.q(r10)
            r1.add(r9)
            int r4 = r4 + 1
            goto L_0x0305
        L_0x033c:
            r0 = r3
        L_0x033d:
            if (r0 >= r8) goto L_0x041c
            android.graphics.RectF r4 = r14.f68331z
            float r4 = r4.left
            float r9 = (float) r0
            float r10 = r14.D
            float r9 = r9 * r10
            float r4 = r4 + r9
            float r9 = r14.f68323t
            com.hbg.component.kline.shape.LineShape r10 = r14.z0()
            float[] r11 = new float[r7]
            r11[r2] = r4
            r11[r3] = r9
            r11[r6] = r4
            android.graphics.RectF r9 = r14.f68331z
            float r9 = r9.bottom
            r11[r5] = r9
            r10.q(r11)
            r1.add(r10)
            com.hbg.component.kline.shape.LineShape r9 = r14.z0()
            float[] r10 = new float[r7]
            r10[r2] = r4
            android.graphics.RectF r11 = r14.K
            float r11 = r11.bottom
            r10[r3] = r11
            r10[r6] = r4
            int r4 = r14.f67201f
            float r4 = (float) r4
            r10[r5] = r4
            r9.q(r10)
            r1.add(r9)
            int r0 = r0 + 1
            goto L_0x033d
        L_0x0380:
            r4 = r2
        L_0x0381:
            int r9 = r14.V
            if (r4 > r9) goto L_0x03ab
            android.graphics.RectF r9 = r14.f68331z
            float r10 = r9.left
            float r9 = r9.top
            float r11 = r14.C
            float r12 = (float) r4
            float r11 = r11 * r12
            float r9 = r9 + r11
            com.hbg.component.kline.shape.LineShape r11 = r14.z0()
            float[] r12 = new float[r7]
            r12[r2] = r10
            r12[r3] = r9
            android.graphics.RectF r10 = r14.f68331z
            float r10 = r10.right
            r12[r6] = r10
            r12[r5] = r9
            r11.q(r12)
            r1.add(r11)
            int r4 = r4 + 1
            goto L_0x0381
        L_0x03ab:
            r4 = r3
        L_0x03ac:
            if (r4 > r0) goto L_0x03f1
            com.hbg.component.kline.shape.LineShape r9 = r14.z0()
            float[] r10 = new float[r7]
            android.graphics.RectF r11 = r14.f68331z
            float r12 = r11.left
            r10[r2] = r12
            float r11 = r11.top
            float r12 = r14.C
            int r13 = r14.V
            float r13 = (float) r13
            float r12 = r12 * r13
            float r11 = r11 + r12
            boolean r12 = r14.f68371b0
            int r12 = com.hbg.component.kline.constants.KLineConstants.a(r12)
            int r12 = r12 * r4
            float r12 = (float) r12
            float r11 = r11 + r12
            r10[r3] = r11
            android.graphics.RectF r11 = r14.f68331z
            float r12 = r11.right
            r10[r6] = r12
            float r11 = r11.top
            float r12 = r14.C
            int r13 = r14.V
            float r13 = (float) r13
            float r12 = r12 * r13
            float r11 = r11 + r12
            boolean r12 = r14.f68371b0
            int r12 = com.hbg.component.kline.constants.KLineConstants.a(r12)
            int r12 = r12 * r4
            float r12 = (float) r12
            float r11 = r11 + r12
            r10[r5] = r11
            r9.q(r10)
            r1.add(r9)
            int r4 = r4 + 1
            goto L_0x03ac
        L_0x03f1:
            r0 = r3
        L_0x03f2:
            if (r0 >= r8) goto L_0x041c
            android.graphics.RectF r4 = r14.f68331z
            float r4 = r4.left
            float r9 = (float) r0
            float r10 = r14.D
            float r9 = r9 * r10
            float r4 = r4 + r9
            float r9 = r14.f68323t
            com.hbg.component.kline.shape.LineShape r10 = r14.z0()
            float[] r11 = new float[r7]
            r11[r2] = r4
            r11[r3] = r9
            r11[r6] = r4
            int r4 = r14.f67201f
            float r4 = (float) r4
            float r9 = r14.f68324u
            float r4 = r4 - r9
            r11[r5] = r4
            r10.q(r11)
            r1.add(r10)
            int r0 = r0 + 1
            goto L_0x03f2
        L_0x041c:
            int r0 = r1.size()
            int r0 = r0 << r6
            float[] r0 = new float[r0]
            v5.p r2 = new v5.p
            r2.<init>(r0)
            com.hbg.lib.common.utils.UtilCollections.c(r1, r2)
            com.hbg.component.kline.shape.LineShape r1 = r14.z0()
            r1.q(r0)
            java.util.List<com.hbg.component.kline.shape.LineShape> r0 = r14.f68372c0
            r0.add(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.q.n():void");
    }

    public RectF n0() {
        return this.H;
    }

    public float o0() {
        return this.U;
    }

    public RectF p0() {
        return this.E;
    }

    public Drawable q0() {
        return this.X;
    }

    public Rect r0() {
        return this.Y;
    }

    public RectF s0() {
        return this.I;
    }

    public RectF t0() {
        return this.K;
    }

    public String toString() {
        return "LayerGrid(gridBoxHeight=" + a0() + ", gridBoxWidth=" + b0() + ", volRect=" + p0() + ", macdRect=" + m0() + ", kdjRect=" + k0() + ", rsiRect=" + n0() + ", wrRect=" + s0() + ", indexRect=" + d0() + ", xTickRect=" + t0() + ", dp1=" + Z() + ", callback=" + I() + ", commonLabelSize=" + Y() + ", introLabelSize=" + j0() + ", infoPadding=" + g0() + ", infoMargin=" + f0() + ", infoHeight=" + e0() + ", initBaseLine=" + h0() + ", initBaseLineAbove=" + i0() + ", topBoxSize=" + o0() + ", klineBoxSize=" + l0() + ", volVisbale=" + u0() + ", waterLogo=" + q0() + ", waterRect=" + r0() + ", breathInterRadius=" + W() + ", breathOuterRadius=" + X() + ", landscape=" + M() + ", gridShape=" + c0() + ")";
    }

    public boolean u0() {
        return this.W;
    }

    public void y(Canvas canvas) {
        if (this.f68327x.u0() != null) {
            Drawable u02 = this.f68327x.u0();
            RectF rectF = this.f68331z;
            u02.setBounds((int) rectF.left, 0, (int) rectF.right, (int) rectF.bottom);
            this.f68327x.u0().draw(canvas);
        }
        b<RectF> bVar = this.M;
        if (bVar != null) {
            bVar.onCallback(this.f68331z);
        }
        if (this.f68327x.v0() != null) {
            Drawable v02 = this.f68327x.v0();
            RectF rectF2 = this.J;
            v02.setBounds((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
            this.f68327x.v0().draw(canvas);
        }
        U(canvas, this.f68372c0);
        if (this.X != null) {
            canvas.save();
            canvas.translate((float) f68368d0, (this.f68331z.bottom - ((float) this.Y.height())) - ((float) f68369e0));
            this.X.draw(canvas);
            canvas.restore();
        }
    }

    public LabelShape y0() {
        LabelShape labelShape = new LabelShape();
        labelShape.i(this.f68317n);
        labelShape.q(Paint.Align.LEFT);
        labelShape.t(this.N);
        return labelShape;
    }

    public final LineShape z0() {
        LineShape lineShape = new LineShape();
        lineShape.i(this.f68317n);
        lineShape.s(this.f68327x.K0());
        lineShape.t((float) CandleStickRender.f67209y2);
        return lineShape;
    }
}
