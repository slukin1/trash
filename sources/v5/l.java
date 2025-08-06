package v5;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.shape.LabelShape;
import com.hbg.component.kline.utils.DateTimeKlineUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class l extends q {

    /* renamed from: f0  reason: collision with root package name */
    public Date f68348f0 = new Date();

    /* renamed from: g0  reason: collision with root package name */
    public List<LabelShape> f68349g0 = new ArrayList(5);

    /* renamed from: h0  reason: collision with root package name */
    public List<LabelShape> f68350h0 = new ArrayList(6);

    /* renamed from: i0  reason: collision with root package name */
    public List<LabelShape> f68351i0 = new ArrayList(11);

    public l(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
    }

    public final LabelShape A0() {
        if (this.f68351i0.size() > 0) {
            return this.f68351i0.remove(0);
        }
        return y0();
    }

    public final void B0(List<LabelShape> list) {
        this.f68351i0.addAll(list);
        list.clear();
    }

    public void F() {
        super.F();
        if (this.f68327x.B3()) {
            CandleStickRender candleStickRender = this.f68327x;
            double d11 = (candleStickRender.B0 - candleStickRender.C0) / ((double) this.V);
            B0(this.f68350h0);
            B0(this.f68349g0);
            for (int i11 = 0; i11 < this.V + 1; i11++) {
                LabelShape A0 = A0();
                A0.q(Paint.Align.RIGHT);
                A0.r(V(this.f68327x.B0 - (((double) i11) * d11)));
                A0.u((this.f68331z.right - this.P) - this.f68326w);
                A0.k(this.T + this.f68323t + this.f68330y.height() + (((float) i11) * this.C));
                A0.s(this.f68327x.O0());
                this.f68349g0.add(A0);
            }
            for (int i12 = 0; i12 < 6; i12++) {
                int i13 = (int) (this.f68325v + (((float) i12) * this.D));
                int h02 = this.f68327x.h0(i13, true);
                if (E(h02)) {
                    this.f68348f0.setTime(B(h02).getTimeMs());
                    String format = DateTimeKlineUtils.b(this.f68327x.N1()).format(this.f68348f0);
                    LabelShape A02 = A0();
                    if (i12 == 0 && (this.f68327x.N1() == CandleStickRender.KLineType.MIN_1 || this.f68327x.N1() == CandleStickRender.KLineType.TIME_LINE)) {
                        A02.q(Paint.Align.LEFT);
                    } else {
                        A02.q(Paint.Align.CENTER);
                    }
                    A02.r(format);
                    A02.u((float) i13);
                    A02.k(this.K.centerY() - this.f68318o.exactCenterY());
                    A02.s(this.f68327x.O0());
                    this.f68350h0.add(A02);
                }
            }
            this.f68351i0.clear();
        }
    }

    public void N() {
        super.N();
        this.f68350h0.clear();
        this.f68349g0.clear();
        this.f68351i0.clear();
    }

    public void y(Canvas canvas) {
        try {
            T(canvas, this.f68349g0);
            T(canvas, this.f68350h0);
        } catch (Throwable unused) {
        }
    }
}
