package v5;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.render.buffer.DataBuffer;
import com.hbg.component.kline.render.layer.BaseLayerKline;
import com.hbg.component.kline.utils.DateTimeKlineUtils;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.PaintUtils;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;

public class d0 extends BaseLayerKline {
    public Path A0 = new Path();
    public Path B0 = new Path();
    public int C0 = DimenUtils.a(1.5f);
    public LinearGradient D0;

    /* renamed from: z0  reason: collision with root package name */
    public Path f68329z0 = new Path();

    public d0(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
    }

    public void J0() {
        if (this.f68327x.B3()) {
            super.J0();
            n1();
        }
    }

    public final void n1() {
        if (E(this.f68327x.f67272t0) && E(this.f68327x.f67276u0)) {
            this.f68329z0.reset();
            this.A0.reset();
            CandleStickRender candleStickRender = this.f68327x;
            int i11 = candleStickRender.f67272t0;
            int i12 = candleStickRender.f67276u0;
            float[] fArr = new float[2];
            float f11 = 0.0f;
            long d11 = DateTimeKlineUtils.d();
            boolean z11 = false;
            for (int i13 = i11; i13 <= i12; i13++) {
                KlineInfo klineInfo = this.f68327x.Y0.get(i13);
                float D = D(i13);
                fArr[0] = D;
                fArr[0] = D;
                fArr[1] = (float) klineInfo.getClose();
                this.f68327x.O.mapPoints(fArr);
                if (i13 == i11) {
                    this.f68329z0.moveTo(fArr[0], fArr[1]);
                } else {
                    this.f68329z0.lineTo(fArr[0], fArr[1]);
                }
                if (fArr[1] < f11) {
                    f11 = fArr[1];
                }
                if (klineInfo.getTimeMs() > d11) {
                    if (!z11) {
                        this.A0.moveTo(fArr[0], fArr[1]);
                        z11 = true;
                    } else {
                        this.A0.lineTo(fArr[0], fArr[1]);
                    }
                }
            }
            this.B0.set(this.f68329z0);
            this.B0.lineTo(fArr[0], this.f68331z.bottom);
            this.B0.lineTo(this.f68325v + (this.f68327x.f67282w0 / 2.0f), this.f68331z.bottom);
            this.B0.close();
            RectF rectF = this.f68331z;
            float f12 = rectF.left;
            this.D0 = new LinearGradient(f12, rectF.bottom, f12, rectF.top, this.f68327x.S0(), this.f68327x.T0(), Shader.TileMode.CLAMP);
        }
    }

    public final void o1(Canvas canvas) {
        PaintUtils.g(this.f68317n, this.D0);
        canvas.save();
        canvas.clipPath(this.B0);
        canvas.drawRect(this.f68331z, this.f68317n);
        canvas.restore();
        PaintUtils.f(this.f68317n, this.f68327x.R0(), (float) CandleStickRender.f67208x2);
        canvas.drawPath(this.f68329z0, this.f68317n);
        this.f68317n.setColor(this.f68327x.U0());
        canvas.drawPath(this.A0, this.f68317n);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void p1(Canvas canvas) {
        PaintUtils.d(this.f68317n, this.f68327x.V0(), (float) this.C0);
        DataBuffer.c cVar = this.f67320g0;
        canvas.drawLines(cVar.f67303e, 0, cVar.g() + 1, this.f68317n);
        DataBuffer.c cVar2 = this.f67320g0;
        canvas.drawLines(cVar2.f67303e, cVar2.h(), this.f67320g0.c() - this.f67320g0.h(), this.f68317n);
    }

    public void y(Canvas canvas) {
        super.y(canvas);
        o1(canvas);
        if (this.W) {
            p1(canvas);
        }
    }
}
