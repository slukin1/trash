package u5;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.render.buffer.DataBuffer;
import com.hbg.component.kline.render.buffer.DataBufferManager;
import com.hbg.component.kline.utils.PaintUtils;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;

public class h extends e {
    public DataBuffer.c P;
    public DataBuffer.c Q;
    public Path R = new Path();
    public Path S = new Path();
    public LinearGradient T;

    public h(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
        int z22 = candleStickRender.z2() << 2;
        Class cls = DataBuffer.c.class;
        DataBuffer.BufferType bufferType = CandleStickRender.G2;
        this.P = (DataBuffer.c) DataBufferManager.d(z22, bufferType, cls);
        this.Q = (DataBuffer.c) DataBufferManager.d(z22, bufferType, cls);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0() {
        this.P.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x0(int i11, int i12, KlineInfo klineInfo) {
        double d11;
        float[] fArr = this.f68320q;
        float D = D(i12 + i11);
        fArr[0] = D;
        float open = (float) klineInfo.getOpen();
        float close = (float) klineInfo.getClose();
        if (this.f68327x.V4()) {
            d11 = klineInfo.getVol();
        } else {
            d11 = klineInfo.getAmount();
        }
        float f11 = (float) d11;
        if (close >= open) {
            this.P.d(new float[]{D, 0.0f, D, f11});
            return;
        }
        this.P.e(new float[]{D, 0.0f, D, f11});
    }

    public void F() {
        super.F();
        q0();
    }

    public void N() {
        super.N();
        this.P.a();
        this.Q.a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void q0() {
        int i11;
        if (this.f68327x.B3()) {
            if (((float) this.f68327x.d1()) > ((float) this.f68327x.i1()) * 1.5f) {
                i11 = CandleStickRender.f67206v2 + 2;
            } else {
                i11 = CandleStickRender.f67206v2 + 4;
            }
            CandleStickRender candleStickRender = this.f68327x;
            candleStickRender.A0 = candleStickRender.f67282w0 - ((float) i11);
            candleStickRender.u(candleStickRender.O);
            this.f68327x.O.preTranslate(0.0f, this.f68315l.height() - this.f68331z.bottom);
            Matrix matrix = this.f68327x.O;
            CandleStickRender candleStickRender2 = this.f68327x;
            matrix.preScale(1.0f, (float) (((double) this.f68331z.height()) / (candleStickRender2.B0 - candleStickRender2.C0)));
            CandleStickRender candleStickRender3 = this.f68327x;
            candleStickRender3.O.preTranslate(0.0f, (float) (-candleStickRender3.C0));
            if (this.f68327x.d3() != "") {
                r0();
            }
            s0();
        }
    }

    public final void r0() {
        CandleStickRender candleStickRender = this.f68327x;
        candleStickRender.u(candleStickRender.P);
        this.f68327x.P.preTranslate(0.0f, this.f68315l.height() - this.E.bottom);
        this.f68327x.P.preScale(1.0f, (float) (((double) (this.E.height() - this.G)) / this.f68327x.F0));
        t0();
    }

    public final void s0() {
        if (E(this.f68327x.f67272t0) && E(this.f68327x.f67276u0)) {
            this.R.reset();
            CandleStickRender candleStickRender = this.f68327x;
            int i11 = candleStickRender.f67272t0;
            int i12 = candleStickRender.f67276u0;
            int max = Math.max(0, candleStickRender.i1() - i12);
            float[] fArr = new float[2];
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int i13 = i11; i13 <= i12; i13++) {
                float D = D(i13 + max);
                fArr[0] = D;
                fArr[0] = D;
                fArr[1] = (float) this.f68327x.Y0.get(i13).getClose();
                this.f68327x.O.mapPoints(fArr);
                if (i13 == i11) {
                    this.R.moveTo(fArr[0], fArr[1]);
                    f11 = fArr[0];
                } else {
                    this.R.lineTo(fArr[0], fArr[1]);
                }
                if (fArr[1] < f12) {
                    f12 = fArr[1];
                }
            }
            this.S.set(this.R);
            this.S.lineTo(fArr[0], this.f68331z.bottom);
            this.S.lineTo(f11, this.f68331z.bottom);
            this.S.close();
            if (this.T == null) {
                RectF rectF = this.f68331z;
                float f13 = rectF.left;
                this.T = new LinearGradient(f13, rectF.bottom, f13, rectF.top, this.f68327x.S0(), this.f68327x.T0(), Shader.TileMode.CLAMP);
            }
        }
    }

    public final void t0() {
        A(new f(this), new g(this, Math.max(0, this.f68327x.i1() - this.f68327x.f67276u0)));
        this.f68327x.P.mapPoints(this.Q.f67303e, this.P.f67303e);
        this.Q.f(this.P);
    }

    public void u0(Canvas canvas, DataBuffer.c cVar) {
        this.f68317n.setColor(this.f68327x.Q0());
        canvas.drawLines(cVar.f67303e, 0, cVar.g() + 1, this.f68317n);
        this.f68317n.setColor(this.f68327x.J0());
        canvas.drawLines(cVar.f67303e, cVar.h(), cVar.c() - cVar.h(), this.f68317n);
    }

    public final void v0(Canvas canvas) {
        PaintUtils.g(this.f68317n, this.T);
        canvas.save();
        canvas.clipPath(this.S);
        canvas.drawRect(this.f68331z, this.f68317n);
        canvas.restore();
        PaintUtils.f(this.f68317n, this.f68327x.R0(), (float) CandleStickRender.f67208x2);
        canvas.drawPath(this.R, this.f68317n);
    }

    public void y(Canvas canvas) {
        super.y(canvas);
        v0(canvas);
        this.f68317n.setStrokeWidth(this.f68327x.A0);
        u0(canvas, this.Q);
    }
}
