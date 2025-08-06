package u5;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.shape.LabelShape;
import com.hbg.component.kline.utils.DateTimeKlineUtils;
import com.hbg.component.kline.utils.NumberKlineUtil;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import i6.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class a extends e {
    public List<LabelShape> P = new ArrayList(5);
    public List<LabelShape> Q = new ArrayList(5);
    public Date R = new Date();
    public SimpleDateFormat S;

    public a(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        this.S = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
    }

    public void F() {
        LabelShape labelShape;
        LabelShape labelShape2;
        double d11;
        LabelShape labelShape3;
        super.F();
        if (this.f68327x.B3()) {
            CandleStickRender candleStickRender = this.f68327x;
            double d12 = (candleStickRender.B0 - candleStickRender.C0) / ((double) this.N);
            boolean z11 = !this.P.isEmpty();
            boolean z12 = !this.Q.isEmpty();
            int i11 = 0;
            for (int i12 = 0; i12 <= this.N; i12++) {
                if (!z11 || i12 >= this.P.size()) {
                    labelShape3 = m0();
                    this.P.add(labelShape3);
                } else {
                    labelShape3 = this.P.get(i12);
                }
                labelShape3.q(Paint.Align.RIGHT);
                labelShape3.r(o0(this.f68327x.B0 - (((double) i12) * d12)));
                labelShape3.u((((float) this.f67202g) - this.J) - this.f68326w);
                labelShape3.k(this.M + this.f68323t + this.f68330y.height() + (((float) i12) * this.C));
                labelShape3.s(this.f68327x.O0());
            }
            double d13 = 0.0d;
            long d14 = DateTimeKlineUtils.d();
            for (int size = this.f68327x.Y0.size() - 1; size >= 0; size--) {
                KlineInfo klineInfo = this.f68327x.Y0.get(size);
                if (klineInfo.getTimeMs() < d14) {
                    break;
                }
                if (this.f68327x.V4()) {
                    d11 = klineInfo.getVol();
                } else {
                    d11 = klineInfo.getAmount();
                }
                d13 += d11;
            }
            if (z11) {
                labelShape = this.P.get(this.N + 1);
            } else {
                labelShape = m0();
                this.P.add(labelShape);
            }
            labelShape.q(Paint.Align.RIGHT);
            labelShape.r("VOL: " + m.T(String.valueOf(d13), Math.min(this.f68327x.Q2(), 2)));
            labelShape.u((((float) this.f67202g) - this.J) - this.f68326w);
            List<LabelShape> list = this.P;
            labelShape.k(list.get(list.size() - 2).f() + this.C);
            labelShape.s(this.f68327x.O0());
            int i13 = (int) this.f68331z.right;
            long timeMs = B(this.f68327x.Y0.size() - 1).getTimeMs();
            int i14 = 4;
            while (i14 >= 0) {
                this.R.setTime(timeMs - (((long) i11) * 21600000));
                if (!z12 || i11 >= this.Q.size()) {
                    labelShape2 = m0();
                    this.Q.add(labelShape2);
                } else {
                    labelShape2 = this.Q.get(i11);
                }
                if (i14 == 4) {
                    labelShape2.q(Paint.Align.RIGHT);
                } else if (i14 == 0) {
                    labelShape2.q(Paint.Align.LEFT);
                } else {
                    labelShape2.q(Paint.Align.CENTER);
                }
                labelShape2.r(this.S.format(this.R));
                labelShape2.u(i13 < 0 ? 0.0f : (float) i13);
                labelShape2.k(this.F.centerY() - this.f68318o.exactCenterY());
                labelShape2.s(this.f68327x.O0());
                i14--;
                i11++;
                i13 = (int) (((float) i13) - (this.f68331z.width() / 4.0f));
            }
        }
    }

    public void N() {
        super.N();
        this.Q.clear();
        this.P.clear();
        this.S.setTimeZone(TimeZone.getDefault());
    }

    public String o0(double d11) {
        return NumberKlineUtil.d(d11, this.f68327x.Q2());
    }

    public void y(Canvas canvas) {
        U(canvas, this.P);
        U(canvas, this.Q);
    }
}
