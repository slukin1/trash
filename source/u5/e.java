package u5;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.shape.LabelShape;
import com.hbg.component.kline.shape.LineShape;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.PaintUtils;
import com.hbg.lib.common.utils.UtilCollections;
import java.util.ArrayList;
import java.util.List;
import v5.j;

public class e extends j {
    public float C;
    public float D;
    public RectF E = new RectF();
    public RectF F = new RectF();
    public float G = ((float) DimenUtils.a(1.0f));
    public int H = DimenUtils.a(9.0f);
    public int I = DimenUtils.a(10.0f);
    public float J = ((float) DimenUtils.a(0.0f));
    public float K;
    public float L;
    public float M;
    public int N;
    public List<LineShape> O = new ArrayList(16);

    public e(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
    }

    public static /* synthetic */ void j0(float[] fArr, int i11, LineShape lineShape) {
        int i12 = i11 << 2;
        fArr[i12 + 0] = lineShape.m()[0];
        fArr[i12 + 1] = lineShape.m()[1];
        fArr[i12 + 2] = lineShape.m()[2];
        fArr[i12 + 3] = lineShape.m()[3];
    }

    public static /* synthetic */ void k0(Canvas canvas, int i11, LabelShape labelShape) {
        if (labelShape != null) {
            labelShape.l(canvas);
        }
    }

    public static /* synthetic */ void l0(Canvas canvas, int i11, LineShape lineShape) {
        if (lineShape != null) {
            lineShape.l(canvas);
        }
    }

    public boolean H(Object obj) {
        return obj instanceof e;
    }

    public void N() {
        this.O.clear();
    }

    public final void T() {
        this.O.clear();
        int i11 = this.f68327x.d3() == "" ? 0 : 1;
        int i12 = 4 - i11;
        this.N = i12;
        float f11 = this.f68324u;
        float f12 = this.f68323t;
        float f13 = ((((float) this.f67201f) - f11) - f12) / (((float) 4) + 0.5f);
        this.C = f13;
        int i13 = this.f67202g;
        float f14 = this.f68325v;
        float f15 = this.f68326w;
        float f16 = ((((float) i13) - f14) - f15) / 5.0f;
        this.D = f16;
        RectF rectF = this.f68330y;
        rectF.top = f12;
        rectF.left = f14;
        rectF.right = ((float) i13) - f15;
        float f17 = f12 + (0.5f * f13);
        rectF.bottom = f17;
        RectF rectF2 = this.f68331z;
        rectF2.top = f17;
        rectF2.left = f14;
        rectF2.right = ((float) i13) - f15;
        float f18 = f17 + (((float) i12) * f13);
        rectF2.bottom = f18;
        RectF rectF3 = this.E;
        rectF3.top = f18;
        rectF3.left = f14;
        rectF3.right = ((float) i13) - f15;
        float f19 = f18 + (((float) i11) * f13);
        rectF3.bottom = f19;
        RectF rectF4 = this.F;
        rectF4.top = f19;
        rectF4.left = f14;
        rectF4.right = ((float) i13) - f15;
        rectF4.bottom = f19 + f11;
        rectF2.right -= (f16 * 3.0f) / 4.0f;
        rectF3.right -= (f16 * 3.0f) / 4.0f;
        rectF4.right -= (f16 * 3.0f) / 4.0f;
        this.f68317n.setTextSize((float) this.I);
        this.f68317n.getTextBounds("BOLL", 0, 4, this.f68318o);
        this.K = ((float) this.f68318o.height()) + (this.G * 2.0f);
        if (this.L == 0.0f) {
            PaintUtils.h(this.f68317n, Paint.Align.LEFT, 0, (float) this.H);
            this.f68317n.getTextBounds("BOLL", 0, 4, this.f68318o);
            this.L = ((this.K / 2.0f) - this.f68318o.exactCenterY()) + this.G;
            this.M = (((-this.K) / 2.0f) - this.f68318o.exactCenterY()) - this.G;
        }
        ArrayList arrayList = new ArrayList(16);
        for (int i14 = 0; i14 < 4; i14++) {
            RectF rectF5 = this.f68331z;
            float f21 = rectF5.left;
            float f22 = rectF5.top + (this.C * ((float) i14));
            LineShape n02 = n0();
            n02.q(new float[]{f21, f22, this.f68331z.right, f22});
            arrayList.add(n02);
        }
        float[] fArr = new float[(arrayList.size() << 2)];
        UtilCollections.c(arrayList, new d(fArr));
        LineShape n03 = n0();
        n03.q(fArr);
        this.O.add(n03);
    }

    public void U(Canvas canvas, List<LabelShape> list) {
        UtilCollections.c(list, new b(canvas));
    }

    public void V(Canvas canvas, List<LineShape> list) {
        UtilCollections.c(list, new c(canvas));
    }

    public int W() {
        return this.H;
    }

    public float X() {
        return this.G;
    }

    public float Y() {
        return this.C;
    }

    public float Z() {
        return this.D;
    }

    public List<LineShape> a0() {
        return this.O;
    }

    public float b0() {
        return this.K;
    }

    public float c0() {
        return this.J;
    }

    public float d0() {
        return this.L;
    }

    public float e0() {
        return this.M;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!eVar.H(this) || !super.equals(obj) || Float.compare(Y(), eVar.Y()) != 0 || Float.compare(Z(), eVar.Z()) != 0) {
            return false;
        }
        RectF h02 = h0();
        RectF h03 = eVar.h0();
        if (h02 != null ? !h02.equals(h03) : h03 != null) {
            return false;
        }
        RectF i02 = i0();
        RectF i03 = eVar.i0();
        if (i02 != null ? !i02.equals(i03) : i03 != null) {
            return false;
        }
        if (Float.compare(X(), eVar.X()) != 0 || W() != eVar.W() || f0() != eVar.f0() || Float.compare(c0(), eVar.c0()) != 0 || Float.compare(b0(), eVar.b0()) != 0 || Float.compare(d0(), eVar.d0()) != 0 || Float.compare(e0(), eVar.e0()) != 0 || g0() != eVar.g0()) {
            return false;
        }
        List<LineShape> a02 = a0();
        List<LineShape> a03 = eVar.a0();
        return a02 != null ? a02.equals(a03) : a03 == null;
    }

    public int f0() {
        return this.I;
    }

    public int g0() {
        return this.N;
    }

    public RectF h0() {
        return this.E;
    }

    public int hashCode() {
        int hashCode = (((super.hashCode() * 59) + Float.floatToIntBits(Y())) * 59) + Float.floatToIntBits(Z());
        RectF h02 = h0();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (h02 == null ? 43 : h02.hashCode());
        RectF i02 = i0();
        int hashCode3 = (((((((((((((((((hashCode2 * 59) + (i02 == null ? 43 : i02.hashCode())) * 59) + Float.floatToIntBits(X())) * 59) + W()) * 59) + f0()) * 59) + Float.floatToIntBits(c0())) * 59) + Float.floatToIntBits(b0())) * 59) + Float.floatToIntBits(d0())) * 59) + Float.floatToIntBits(e0())) * 59) + g0();
        List<LineShape> a02 = a0();
        int i12 = hashCode3 * 59;
        if (a02 != null) {
            i11 = a02.hashCode();
        }
        return i12 + i11;
    }

    public RectF i0() {
        return this.F;
    }

    public LabelShape m0() {
        LabelShape labelShape = new LabelShape();
        labelShape.i(this.f68317n);
        labelShape.q(Paint.Align.LEFT);
        labelShape.t(this.H);
        return labelShape;
    }

    public void n() {
        super.n();
        T();
    }

    public final LineShape n0() {
        LineShape lineShape = new LineShape();
        lineShape.i(this.f68317n);
        lineShape.s(this.f68327x.K0());
        lineShape.t((float) CandleStickRender.f67209y2);
        lineShape.r(PaintUtils.f67401a);
        return lineShape;
    }

    public String toString() {
        return "ExpandLayerGrid(gridBoxHeight=" + Y() + ", gridBoxWidth=" + Z() + ", volRect=" + h0() + ", xTickRect=" + i0() + ", dp1=" + X() + ", commonLabelSize=" + W() + ", introLabelSize=" + f0() + ", infoPadding=" + c0() + ", infoHeight=" + b0() + ", initBaseLine=" + d0() + ", initBaseLineAbove=" + e0() + ", klineBoxSize=" + g0() + ", gridShape=" + a0() + ")";
    }

    public void y(Canvas canvas) {
        if (this.O.size() == 0) {
            T();
        }
        V(canvas, this.O);
    }
}
