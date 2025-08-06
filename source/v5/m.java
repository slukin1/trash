package v5;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.hbg.component.kline.draw.KlineDrawDataManager;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.draw.bean.KlineDrawPointBean;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import i6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q5.b;
import r5.a;

public class m extends q {
    public static final int H0 = PixelUtils.a(50.0f);
    public static final int I0 = PixelUtils.a(60.0f);
    public static final int J0 = PixelUtils.a(10.0f);
    public Matrix A0;
    public Bitmap B0;
    public int C0;
    public int D0;
    public Paint E0;
    public String F0;
    public String G0;

    /* renamed from: f0  reason: collision with root package name */
    public Paint f68352f0 = new Paint();

    /* renamed from: g0  reason: collision with root package name */
    public List<a> f68353g0 = new ArrayList();

    /* renamed from: h0  reason: collision with root package name */
    public a f68354h0;

    /* renamed from: i0  reason: collision with root package name */
    public float f68355i0;

    /* renamed from: j0  reason: collision with root package name */
    public float f68356j0;

    /* renamed from: k0  reason: collision with root package name */
    public float f68357k0;

    /* renamed from: l0  reason: collision with root package name */
    public float f68358l0;

    /* renamed from: m0  reason: collision with root package name */
    public float f68359m0;

    /* renamed from: n0  reason: collision with root package name */
    public float f68360n0;

    /* renamed from: t0  reason: collision with root package name */
    public KlineDrawPointBean f68361t0 = null;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f68362u0 = false;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f68363v0 = false;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f68364w0 = false;

    /* renamed from: x0  reason: collision with root package name */
    public int f68365x0 = 3;

    /* renamed from: y0  reason: collision with root package name */
    public b f68366y0;

    /* renamed from: z0  reason: collision with root package name */
    public Path f68367z0;

    public m(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
        this.f68352f0.setAntiAlias(true);
        this.f68352f0.setStyle(Paint.Style.STROKE);
        P0();
    }

    public void A0(boolean z11) {
        this.f68353g0 = null;
        if (z11) {
            W0();
        } else {
            this.F0 = null;
            this.G0 = null;
        }
        this.f68327x.m();
    }

    public final boolean B0(float f11, float f12) {
        return this.f68331z.contains(f11, f12);
    }

    public final void C0(float f11, float f12) {
        this.f68365x0 = 3;
        List<a> list = this.f68353g0;
        KlineDrawLineBean klineDrawLineBean = null;
        if (list != null) {
            Iterator<a> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                a next = it2.next();
                if (next != null) {
                    KlineDrawPointBean f13 = next.f(f11, f12);
                    this.f68361t0 = f13;
                    if (f13 != null) {
                        Z0(next);
                        this.f68365x0 = 1;
                        next.B(this.f68361t0);
                        break;
                    } else if (next.g(f11, f12)) {
                        this.f68365x0 = 2;
                        Z0(next);
                        next.B((KlineDrawPointBean) null);
                        break;
                    }
                }
            }
        }
        if (this.f68365x0 == 3) {
            Z0((a) null);
            this.f68361t0 = null;
        }
        b bVar = this.f68366y0;
        if (bVar != null) {
            a aVar = this.f68354h0;
            if (aVar != null) {
                klineDrawLineBean = aVar.r();
            }
            bVar.wa(klineDrawLineBean);
        }
    }

    public void D0() {
        KlineDrawDataManager.a();
        List<a> list = this.f68353g0;
        if (list != null) {
            list.clear();
        }
        this.f68327x.m();
    }

    public Bitmap E0(Bitmap bitmap, float f11, float f12, int i11) {
        float f13;
        int i12 = i11 * 2;
        float f14 = (float) i11;
        float f15 = 0.0f;
        if (f11 > f14) {
            f13 = f11 - f14;
            if (((float) i12) + f13 > ((float) bitmap.getWidth())) {
                f13 = (float) (bitmap.getWidth() - i12);
            }
        } else {
            f13 = 0.0f;
        }
        if (f12 > f14) {
            f15 = f12 - f14;
            if (((float) i12) + f15 > ((float) bitmap.getHeight())) {
                f15 = (float) (bitmap.getHeight() - i12);
            }
        }
        return Bitmap.createBitmap(bitmap, (int) f13, (int) f15, i12, i12);
    }

    public void F() {
        super.F();
    }

    public boolean F0() {
        a aVar = this.f68354h0;
        if (aVar == null) {
            return false;
        }
        List<a> list = this.f68353g0;
        if (list != null) {
            list.remove(aVar);
        }
        G0(this.f68354h0.r());
        this.f68354h0 = null;
        this.f68361t0 = null;
        this.f68327x.m();
        return true;
    }

    public final void G0(KlineDrawLineBean klineDrawLineBean) {
        KlineDrawDataManager.d(klineDrawLineBean);
        this.f68327x.m();
    }

    public final void H0(Canvas canvas) {
        List<a> list = this.f68353g0;
        if (list != null) {
            for (a next : list) {
                if (next != null) {
                    next.o(canvas, this.f68352f0);
                }
            }
        }
    }

    public final void I0(Canvas canvas) {
        if (this.f68363v0 && this.B0 != null && this.f68354h0 != null) {
            canvas.save();
            if (this.f68357k0 > ((float) (PixelUtils.g() / 2))) {
                int i11 = H0;
                int i12 = J0;
                canvas.drawCircle((float) (i11 + i12), (float) (i12 + i11), (float) i11, this.E0);
            } else {
                float f11 = this.f68331z.right;
                int i13 = H0;
                int i14 = J0;
                canvas.drawCircle(((f11 - ((float) i13)) - ((float) i14)) + ((float) this.f68327x.p0()), (float) (i14 + i13), (float) i13, this.E0);
            }
            canvas.restore();
            canvas.save();
            if (this.f68357k0 > ((float) (PixelUtils.g() / 2))) {
                int i15 = J0;
                canvas.translate((float) i15, (float) i15);
            } else {
                float f12 = this.f68331z.right - ((float) (H0 * 2));
                int i16 = J0;
                canvas.translate((f12 - ((float) i16)) + ((float) this.f68327x.p0()), (float) i16);
            }
            canvas.clipPath(this.f68367z0);
            canvas.drawBitmap(this.B0, this.A0, (Paint) null);
            canvas.restore();
        }
    }

    public void J0() {
        this.f68362u0 = false;
        this.f68361t0 = null;
        Z0((a) null);
        this.f68327x.m();
    }

    public float K0() {
        return this.f68331z.bottom;
    }

    public float L0() {
        return this.f68331z.left;
    }

    public float M0() {
        return this.f68331z.right;
    }

    public void N() {
        super.N();
        W0();
    }

    public float N0() {
        return this.f68331z.top;
    }

    public final void O0() {
        Bitmap w02 = this.f68327x.w0();
        if (w02 != null) {
            Bitmap bitmap = this.B0;
            if (bitmap != null) {
                bitmap.recycle();
                this.B0 = null;
            }
            this.B0 = E0(this.f68327x.w0(), this.f68357k0, this.f68358l0, (int) (((float) H0) / 1.5f));
            w02.recycle();
        }
    }

    public final void P0() {
        this.C0 = this.f68327x.v2();
        this.D0 = this.f68327x.w2();
        Paint paint = new Paint();
        this.E0 = paint;
        paint.setColor(this.C0);
        this.E0.setStyle(Paint.Style.FILL_AND_STROKE);
        this.E0.setShadowLayer((float) PixelUtils.a(10.0f), 0.0f, (float) PixelUtils.a(1.0f), this.D0);
        this.f68367z0 = new Path();
        this.A0 = new Matrix();
        Path path = this.f68367z0;
        int i11 = H0;
        path.addCircle((float) i11, (float) i11, (float) i11, Path.Direction.CW);
        this.A0.setScale(1.5f, 1.5f);
    }

    public boolean Q0(boolean z11) {
        a aVar = this.f68354h0;
        if (aVar == null) {
            return false;
        }
        aVar.r().setLock(z11);
        KlineDrawDataManager.f(this.f68354h0.r());
        return true;
    }

    public void R0() {
        this.f68352f0.setColor(q5.a.g().a());
        this.f68352f0.setStrokeWidth(q5.a.g().c());
        a aVar = this.f68354h0;
        if (aVar != null) {
            KlineDrawDataManager.g(aVar.r());
            KlineDrawDataManager.f(this.f68354h0.r());
            this.f68327x.m();
        }
    }

    public final void S0() {
        a aVar = this.f68354h0;
        if (aVar == null) {
            return;
        }
        if (this.f68362u0) {
            b bVar = this.f68366y0;
            if (bVar != null) {
                bVar.R5(aVar.r());
                return;
            }
            return;
        }
        KlineDrawDataManager.f(aVar.r());
    }

    public final void T0(float f11, float f12) {
        String simpleName = m.class.getSimpleName();
        d.c(simpleName, "Drawline----onTouchMove----onTouchDown x = " + f11 + "; y = " + f12);
        if (!B0(f11, f12)) {
            b bVar = this.f68366y0;
            if (bVar != null) {
                bVar.H9();
                return;
            }
            return;
        }
        if (this.f68354h0 == null) {
            this.f68354h0 = KlineDrawDataManager.b(this.f68327x, this);
            if (this.f68353g0 == null) {
                this.f68353g0 = new ArrayList();
            }
            a aVar = this.f68354h0;
            if (aVar != null) {
                aVar.D(true);
            }
            this.f68353g0.add(this.f68354h0);
        }
        this.f68365x0 = 1;
        KlineDrawPointBean l11 = this.f68354h0.l(f11, f12);
        this.f68361t0 = l11;
        this.f68354h0.B(l11);
    }

    public final void U0(float f11, float f12, float f13, float f14) {
        String simpleName = m.class.getSimpleName();
        d.c(simpleName, "Drawline----onTouchMove----touchDownMode = " + this.f68365x0 + "; offsetX = " + f13 + "; offsetY = " + f14);
        int i11 = this.f68365x0;
        if (i11 == 1) {
            this.f68354h0.A(this.f68361t0, f11, f12);
        } else if (i11 == 2) {
            this.f68354h0.y(f11, f12, f13, f14);
        }
    }

    public final void V0(float f11, float f12) {
        a aVar;
        String simpleName = m.class.getSimpleName();
        d.c(simpleName, "Drawline----onTouchMove----onTouchUp x = " + f11 + "; y = " + f12);
        KlineDrawPointBean klineDrawPointBean = this.f68361t0;
        if (!(klineDrawPointBean == null || (aVar = this.f68354h0) == null)) {
            aVar.A(klineDrawPointBean, f11, f12);
        }
        a aVar2 = this.f68354h0;
        if (aVar2 != null) {
            aVar2.C();
        }
        if (this.f68365x0 == 3) {
            Z0((a) null);
        }
        this.f68361t0 = null;
    }

    public void W0() {
        X0(false);
    }

    public void X0(boolean z11) {
        if (z11 || CollectionsUtils.b(this.f68353g0) || !TextUtils.equals(this.F0, q5.a.g().i()) || !TextUtils.equals(this.G0, q5.a.g().h())) {
            this.f68353g0 = KlineDrawDataManager.e(this.f68327x, this);
            this.f68327x.m();
            this.F0 = q5.a.g().i();
            this.G0 = q5.a.g().h();
        }
    }

    public void Y0(b bVar) {
        this.f68366y0 = bVar;
    }

    public final void Z0(a aVar) {
        a aVar2 = this.f68354h0;
        if (aVar2 != null) {
            aVar2.D(false);
        }
        this.f68354h0 = aVar;
        if (aVar != null) {
            aVar.D(true);
        }
    }

    public void a(Canvas canvas) {
        super.a(canvas);
        canvas.save();
        canvas.clipRect(this.f68331z);
        H0(canvas);
        canvas.restore();
        I0(canvas);
    }

    public void a1(boolean z11) {
        this.f68362u0 = z11;
        if (z11) {
            this.f68361t0 = null;
            Z0((a) null);
            this.f68327x.m();
        }
    }

    public boolean b(MotionEvent motionEvent) {
        String simpleName = m.class.getSimpleName();
        d.c(simpleName, "Drawline----onTouchMove----action = " + motionEvent.getAction());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f68355i0 = motionEvent.getX();
            this.f68356j0 = motionEvent.getY();
            this.f68357k0 = motionEvent.getX();
            this.f68358l0 = motionEvent.getY();
            this.f68359m0 = motionEvent.getRawX();
            this.f68360n0 = motionEvent.getRawY();
            this.f68364w0 = this.f68354h0 != null;
            if (this.f68362u0) {
                T0(motionEvent.getX(), motionEvent.getY());
            } else {
                C0(this.f68355i0, this.f68356j0);
            }
            this.f68363v0 = true;
        } else if (action == 1) {
            V0(motionEvent.getX(), motionEvent.getY());
            S0();
            this.f68363v0 = false;
            this.f68327x.m();
        } else if (action == 2) {
            float x11 = motionEvent.getX() - this.f68357k0;
            float y11 = motionEvent.getY() - this.f68358l0;
            this.f68357k0 = motionEvent.getX();
            this.f68358l0 = motionEvent.getY();
            this.f68359m0 = motionEvent.getRawX();
            this.f68360n0 = motionEvent.getRawY();
            a aVar = this.f68354h0;
            if (aVar != null && !aVar.r().getLock()) {
                O0();
                if (!(x11 == 0.0f && y11 == 0.0f)) {
                    U0(motionEvent.getX(), motionEvent.getY(), x11, y11);
                    this.f68327x.m();
                }
            }
        }
        if (this.f68365x0 != 3 || this.f68364w0) {
            return true;
        }
        return false;
    }

    public void n() {
        super.n();
    }

    public void o(boolean z11) {
        if (z11) {
            X0(true);
        }
    }
}
