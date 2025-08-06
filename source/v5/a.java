package v5;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.component.kline.render.BaseSimpleRender;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.module.kline.R$font;

public abstract class a extends BaseSimpleRender {

    /* renamed from: l  reason: collision with root package name */
    public RectF f68315l = new RectF();

    /* renamed from: m  reason: collision with root package name */
    public RectF f68316m = new RectF();

    /* renamed from: n  reason: collision with root package name */
    public Paint f68317n;

    /* renamed from: o  reason: collision with root package name */
    public Rect f68318o = new Rect();

    /* renamed from: p  reason: collision with root package name */
    public RectF f68319p = new RectF();

    /* renamed from: q  reason: collision with root package name */
    public float[] f68320q = new float[2];

    /* renamed from: r  reason: collision with root package name */
    public float f68321r = ((float) DimenUtils.a(10.0f));

    /* renamed from: s  reason: collision with root package name */
    public float f68322s = ((float) DimenUtils.a(2.0f));

    /* renamed from: t  reason: collision with root package name */
    public float f68323t;

    /* renamed from: u  reason: collision with root package name */
    public float f68324u;

    /* renamed from: v  reason: collision with root package name */
    public float f68325v;

    /* renamed from: w  reason: collision with root package name */
    public float f68326w;

    /* renamed from: x  reason: collision with root package name */
    public CandleStickRender f68327x;

    public a(CandleStickRender candleStickRender, Resources resources) {
        this.f68327x = candleStickRender;
        this.f67200e = resources;
        Paint paint = new Paint();
        this.f68317n = paint;
        paint.setTypeface(ResourcesCompat.h(BaseApplication.b(), R$font.roboto_medium));
        this.f68317n.setAntiAlias(true);
        this.f68317n.setDither(true);
    }

    public void A(UtilCollections.a aVar, UtilCollections.b<KlineInfo> bVar) {
        CandleStickRender candleStickRender = this.f68327x;
        z(aVar, bVar, candleStickRender.f67272t0, candleStickRender.f67276u0);
    }

    public KlineInfo B(int i11) {
        if (E(i11)) {
            return this.f68327x.Y0.get(i11);
        }
        return null;
    }

    public int C(KlineInfo klineInfo) {
        if (!UtilCollections.f(this.f68327x.Y0)) {
            return this.f68327x.Y0.indexOf(klineInfo);
        }
        return -1;
    }

    public float D(int i11) {
        return this.f68325v + ((float) this.f68327x.j0(i11)) + (this.f68327x.f67282w0 / 2.0f);
    }

    public boolean E(int i11) {
        return this.f68327x.B3() && i11 >= 0 && i11 < this.f68327x.Y0.size();
    }

    public void F() {
    }

    public void G(Rect rect) {
        this.f68315l.set(rect);
        this.f67202g = (int) this.f68315l.width();
        this.f67201f = (int) this.f68315l.height();
        n();
    }

    public void n() {
        this.f68323t = (float) this.f68327x.q0();
        this.f68324u = (float) this.f68327x.n0();
        this.f68325v = (float) this.f68327x.o0();
        this.f68326w = (float) this.f68327x.p0();
        RectF rectF = this.f68316m;
        RectF rectF2 = this.f68315l;
        rectF.left = rectF2.left + this.f68325v;
        rectF.top = rectF2.top + this.f68323t;
        rectF.right = rectF2.width() - this.f68326w;
        this.f68316m.bottom = this.f68315l.height() - this.f68324u;
    }

    public abstract void y(Canvas canvas);

    public void z(UtilCollections.a aVar, UtilCollections.b<KlineInfo> bVar, int i11, int i12) {
        UtilCollections.a(this.f68327x.Y0, i11, i12, aVar, bVar);
    }
}
