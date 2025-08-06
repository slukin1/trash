package v5;

import android.content.res.Resources;
import android.graphics.RectF;
import c6.b;
import com.hbg.component.kline.render.CandleStickRender;

public abstract class j extends a {
    public b<RectF> A;
    public boolean B;

    /* renamed from: y  reason: collision with root package name */
    public RectF f68330y = new RectF();

    /* renamed from: z  reason: collision with root package name */
    public RectF f68331z = new RectF();

    public j(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
    }

    public boolean H(Object obj) {
        return obj instanceof j;
    }

    public b<RectF> I() {
        return this.A;
    }

    public RectF J() {
        return this.f68331z;
    }

    public RectF K() {
        return this.f68330y;
    }

    public int L() {
        return 0;
    }

    public boolean M() {
        return this.B;
    }

    public void N() {
    }

    public void O(b<RectF> bVar) {
        this.A = bVar;
    }

    public void P(boolean z11) {
        this.B = z11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (!jVar.H(this) || !super.equals(obj)) {
            return false;
        }
        RectF K = K();
        RectF K2 = jVar.K();
        if (K != null ? !K.equals(K2) : K2 != null) {
            return false;
        }
        RectF J = J();
        RectF J2 = jVar.J();
        if (J != null ? !J.equals(J2) : J2 != null) {
            return false;
        }
        b<RectF> I = I();
        b<RectF> I2 = jVar.I();
        if (I != null ? I.equals(I2) : I2 == null) {
            return M() == jVar.M();
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        RectF K = K();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (K == null ? 43 : K.hashCode());
        RectF J = J();
        int hashCode3 = (hashCode2 * 59) + (J == null ? 43 : J.hashCode());
        b<RectF> I = I();
        int i12 = hashCode3 * 59;
        if (I != null) {
            i11 = I.hashCode();
        }
        return ((i12 + i11) * 59) + (M() ? 79 : 97);
    }

    public String toString() {
        return "LayerBaseGrid(topRect=" + K() + ", klineRect=" + J() + ", callback=" + I() + ", landscape=" + M() + ")";
    }
}
