package v5;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.render.buffer.DataBuffer;
import com.hbg.component.kline.render.buffer.DataBufferManager;
import com.hbg.component.kline.render.layer.BaseLayerKline;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.NumberKlineUtil;
import com.hbg.component.kline.utils.PaintUtils;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;

public class c0 extends BaseLayerKline {
    public DataBuffer.c A0;
    public DataBuffer.c B0;
    public DataBuffer.c C0;

    /* renamed from: z0  reason: collision with root package name */
    public DataBuffer.c f68328z0;

    public c0(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
        int z22 = candleStickRender.z2() << 2;
        Class cls = DataBuffer.c.class;
        DataBuffer.BufferType bufferType = CandleStickRender.G2;
        this.f68328z0 = (DataBuffer.c) DataBufferManager.d(z22, bufferType, cls);
        this.A0 = (DataBuffer.c) DataBufferManager.d(z22, bufferType, cls);
        this.B0 = (DataBuffer.c) DataBufferManager.d(z22, bufferType, cls);
        this.C0 = (DataBuffer.c) DataBufferManager.d(z22, bufferType, cls);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u1() {
        this.f68328z0.a();
        this.A0.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v1(int i11, KlineInfo klineInfo) {
        float[] fArr = this.f68320q;
        float D = D(i11);
        fArr[0] = D;
        float high = (float) klineInfo.getHigh();
        float low = (float) klineInfo.getLow();
        float open = (float) klineInfo.getOpen();
        float close = (float) klineInfo.getClose();
        if (close >= open) {
            this.f68328z0.d(new float[]{D, high, D, low});
            this.A0.d(new float[]{D, open, D, close});
            return;
        }
        this.f68328z0.e(new float[]{D, high, D, low});
        this.A0.e(new float[]{D, open, D, close});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w1(int i11, float f11) {
        float[] fArr = this.C0.f67303e;
        int i12 = i11 + 1;
        float f12 = fArr[i12];
        int i13 = i11 + 3;
        float f13 = fArr[i13];
        float abs = Math.abs(f12 - f13);
        int i14 = CandleStickRender.f67207w2;
        if (abs < ((float) i14)) {
            float f14 = (f12 + f13) / 2.0f;
            float[] fArr2 = this.C0.f67303e;
            fArr2[i12] = (((float) i14) / 2.0f) + f14;
            fArr2[i13] = f14 - (((float) i14) / 2.0f);
        }
    }

    public void J0() {
        if (this.f68327x.B3()) {
            super.J0();
            q1();
            this.f68327x.O.mapPoints(this.B0.f67303e, this.f68328z0.f67303e);
            this.B0.f(this.f68328z0);
            this.f68327x.O.mapPoints(this.C0.f67303e, this.A0.f67303e);
            this.C0.f(this.A0);
            t1();
        }
    }

    public void N() {
        super.N();
        this.A0.a();
        this.f68328z0.a();
        this.C0.a();
        this.B0.a();
    }

    public void n() {
        super.n();
        J0();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DataBufferManager.e(this.A0);
        DataBufferManager.e(this.f68328z0);
        DataBufferManager.e(this.C0);
        DataBufferManager.e(this.B0);
    }

    public final void q1() {
        A(new z(this), new a0(this));
    }

    public final void r1(Canvas canvas) {
        if (E(this.f68327x.i2()) && E(this.f68327x.k2())) {
            double high = this.f68327x.z1().get(this.f68327x.i2()).getHigh();
            double low = this.f68327x.z1().get(this.f68327x.k2()).getLow();
            String d11 = NumberKlineUtil.d(high, this.f68327x.Q2());
            String d12 = NumberKlineUtil.d(low, this.f68327x.Q2());
            this.f68320q[0] = D(this.f68327x.i2());
            this.f68320q[1] = (float) high;
            this.f68327x.q2().mapPoints(this.f68320q);
            s1(canvas, this.f68320q, d11);
            this.f68320q[0] = D(this.f68327x.k2());
            this.f68320q[1] = (float) low;
            this.f68327x.q2().mapPoints(this.f68320q);
            s1(canvas, this.f68320q, d12);
        }
    }

    public final void s1(Canvas canvas, float[] fArr, String str) {
        this.f68317n.reset();
        this.f68317n.setAntiAlias(true);
        this.f68317n.setColor(this.f68327x.P0());
        this.f68317n.setTextSize((float) DimenUtils.a(10.0f));
        this.f68317n.setTextAlign(x1(fArr[0]) ? Paint.Align.LEFT : Paint.Align.RIGHT);
        this.f68317n.getTextBounds(str, 0, str.length(), this.f68318o);
        float exactCenterY = fArr[1] - this.f68318o.exactCenterY();
        float f11 = fArr[1];
        RectF rectF = this.f68331z;
        float f12 = rectF.top;
        if (f11 <= f12) {
            fArr[1] = f12;
            exactCenterY = f12 - this.f68318o.exactCenterY();
        } else {
            float f13 = fArr[1];
            float f14 = rectF.bottom;
            if (f13 >= f14) {
                fArr[1] = f14;
                exactCenterY = f14 - this.f68318o.exactCenterY();
            }
        }
        if (x1(fArr[0])) {
            canvas.drawLine(fArr[0], fArr[1], fArr[0] + this.f68321r, fArr[1], this.f68317n);
            canvas.drawText(str, fArr[0] + this.f68321r + this.f68322s, exactCenterY, this.f68317n);
            return;
        }
        canvas.drawLine(fArr[0], fArr[1], fArr[0] - this.f68321r, fArr[1], this.f68317n);
        canvas.drawText(str, (fArr[0] - this.f68321r) - this.f68322s, exactCenterY, this.f68317n);
    }

    public final void t1() {
        UtilCollections.e(this.C0.f67303e, 4, new b0(this));
    }

    public final boolean x1(float f11) {
        return f11 < this.f68316m.centerX();
    }

    public void y(Canvas canvas) {
        super.y(canvas);
        canvas.save();
        canvas.clipRect(this.f68331z);
        PaintUtils.d(this.f68317n, 0, (float) CandleStickRender.f67208x2);
        S0(canvas, this.B0);
        this.f68317n.setStrokeWidth(this.f68327x.A0);
        S0(canvas, this.C0);
        T0(canvas);
        canvas.restore();
        R0(canvas);
        r1(canvas);
        if (this.W) {
            this.f68317n.setStrokeWidth(this.f68327x.A0);
            S0(canvas, this.f67320g0);
            W0(canvas);
        }
    }
}
