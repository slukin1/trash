package hz;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.ytjojo.shadowlayout.R$styleable;
import com.ytjojo.shadowlayout.ShadowLayout;
import com.ytjojo.shadowlayout.ZDepth;
import com.ytjojo.shadowlayout.shadow.ShadowOval;
import com.ytjojo.shadowlayout.shadow.ShadowRect;
import com.ytjojo.shadowlayout.utils.ColorUtil;
import gz.a;

public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public a f52855a;

    /* renamed from: b  reason: collision with root package name */
    public ZDepth f52856b;

    /* renamed from: c  reason: collision with root package name */
    public int f52857c;

    /* renamed from: d  reason: collision with root package name */
    public int f52858d;

    /* renamed from: e  reason: collision with root package name */
    public int f52859e;

    /* renamed from: f  reason: collision with root package name */
    public int f52860f;

    /* renamed from: g  reason: collision with root package name */
    public long f52861g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52862h;

    /* renamed from: i  reason: collision with root package name */
    public ShadowLayout f52863i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f52864j;

    /* renamed from: k  reason: collision with root package name */
    public int f52865k = -14540254;

    /* renamed from: l  reason: collision with root package name */
    public Rect f52866l = new Rect();

    public b(ShadowLayout shadowLayout, TypedArray typedArray) {
        this.f52863i = shadowLayout;
        shadowLayout.setClipToPadding(false);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f52863i.setLayerType(1, (Paint) null);
        }
        n(typedArray);
    }

    public void a(Canvas canvas) {
        this.f52855a.a(canvas);
        this.f52863i.a(canvas);
    }

    public void b(Canvas canvas) {
        this.f52855a.b(canvas);
    }

    public void c(boolean z11, int i11, int i12, int i13, int i14) {
        this.f52866l.setEmpty();
        if (this.f52863i.getChildCount() > 0) {
            int childCount = this.f52863i.getChildCount();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt = this.f52863i.getChildAt(i15);
                if (i15 == 0) {
                    this.f52866l.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                } else {
                    this.f52866l.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                }
            }
        }
        p();
        this.f52855a.e(this.f52863i, i11, i12, i13, i14);
    }

    public void d() {
        this.f52863i.setPadding(j(), l(), k(), i());
    }

    public void e() {
        this.f52863i.postInvalidate();
    }

    public boolean f(Canvas canvas, View view) {
        if (!this.f52864j) {
            return false;
        }
        boolean d11 = this.f52855a.d(canvas, view);
        if (Build.VERSION.SDK_INT >= 21) {
            view.invalidateOutline();
        }
        return d11;
    }

    public void g(int i11) {
        this.f52865k = i11;
        p();
        e();
    }

    public Context h() {
        return this.f52863i.getContext();
    }

    public int i() {
        return this.f52860f;
    }

    public int j() {
        return this.f52857c;
    }

    public int k() {
        return this.f52859e;
    }

    public int l() {
        return this.f52858d;
    }

    public final ZDepth m(int i11) {
        switch (i11) {
            case 0:
                return ZDepth.Depth0;
            case 1:
                return ZDepth.Depth1;
            case 2:
                return ZDepth.Depth2;
            case 3:
                return ZDepth.Depth3;
            case 4:
                return ZDepth.Depth4;
            case 5:
                return ZDepth.Depth5;
            case 6:
                return ZDepth.Depth6;
            default:
                throw new IllegalArgumentException("unknown zDepth value.");
        }
    }

    public void n(TypedArray typedArray) {
        int i11;
        int i12 = typedArray.getInt(R$styleable.ShadowLayout_z_depth_shape, 0);
        int i13 = typedArray.getInt(R$styleable.ShadowLayout_z_depth, 1);
        int i14 = typedArray.getInt(R$styleable.ShadowLayout_z_depth_animDuration, 150);
        boolean z11 = typedArray.getBoolean(R$styleable.ShadowLayout_z_depth_doAnim, true);
        int i15 = typedArray.getInt(R$styleable.ShadowLayout_z_depth_padding, -1);
        int i16 = typedArray.getInt(R$styleable.ShadowLayout_z_depth_paddingLeft, -1);
        int i17 = typedArray.getInt(R$styleable.ShadowLayout_z_depth_paddingTop, -1);
        int i18 = typedArray.getInt(R$styleable.ShadowLayout_z_depth_paddingRight, -1);
        int i19 = typedArray.getInt(R$styleable.ShadowLayout_z_depth_paddingBottom, -1);
        this.f52864j = typedArray.getBoolean(R$styleable.ShadowLayout_z_depth_clipcanvas, false);
        this.f52865k = typedArray.getColor(R$styleable.ShadowLayout_sl_shadow_color, -14540254);
        if (i15 > -1) {
            i11 = i15;
            i17 = i11;
            i18 = i17;
        } else {
            int i21 = 5;
            if (i16 <= -1) {
                i16 = 5;
            }
            if (i17 <= -1) {
                i17 = 5;
            }
            if (i18 <= -1) {
                i18 = 5;
            }
            if (i19 > -1) {
                i21 = i19;
            }
            i11 = i21;
            i15 = i16;
        }
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(R$styleable.ShadowLayout_sl_shadow_rectroundradius, 0);
        q(i12);
        if (i12 == 0) {
            ((ShadowRect) this.f52855a).f(dimensionPixelOffset);
        }
        r(i13);
        w(i15);
        y(i17);
        x(i18);
        v(i11);
        t((long) i14);
        u(z11);
    }

    public int o(ZDepth zDepth) {
        return (int) Math.max(zDepth.mBlurTopShadowPx + zDepth.mOffsetYTopShadowPx, zDepth.mBlurBottomShadowPx + zDepth.mOffsetYBottomShadowPx);
    }

    public void onDetachedFromWindow() {
    }

    public final void p() {
        int a11 = ColorUtil.a(this.f52856b.mAlphaTopShadow, this.f52865k);
        int a12 = ColorUtil.a(this.f52856b.mAlphaBottomShadow, this.f52865k);
        a aVar = this.f52855a;
        ZDepth zDepth = this.f52856b;
        aVar.c(a11, a12, zDepth.mOffsetYTopShadowPx, zDepth.mOffsetYBottomShadowPx, zDepth.mBlurTopShadowPx, zDepth.mBlurBottomShadowPx, this.f52866l);
    }

    public void q(int i11) {
        if (i11 == 0) {
            this.f52855a = new ShadowRect();
        } else if (i11 == 1) {
            this.f52855a = new ShadowOval();
        } else {
            throw new IllegalArgumentException("unknown shape value.");
        }
    }

    public void r(int i11) {
        s(m(i11));
    }

    public void s(ZDepth zDepth) {
        this.f52856b = zDepth;
        zDepth.initZDepth(h());
    }

    public void t(long j11) {
        this.f52861g = j11;
    }

    public void u(boolean z11) {
        this.f52862h = z11;
    }

    public void v(int i11) {
        ZDepth m11 = m(i11);
        m11.initZDepth(h());
        this.f52860f = o(m11);
    }

    public void w(int i11) {
        ZDepth m11 = m(i11);
        m11.initZDepth(h());
        this.f52857c = o(m11);
    }

    public void x(int i11) {
        ZDepth m11 = m(i11);
        m11.initZDepth(h());
        this.f52859e = o(m11);
    }

    public void y(int i11) {
        ZDepth m11 = m(i11);
        m11.initZDepth(h());
        this.f52858d = o(m11);
    }
}
