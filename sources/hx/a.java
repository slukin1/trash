package hx;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class a extends Animation {

    /* renamed from: r  reason: collision with root package name */
    public static final boolean f29054r = (Integer.valueOf(Build.VERSION.SDK).intValue() < 11);

    /* renamed from: s  reason: collision with root package name */
    public static final WeakHashMap<View, a> f29055s = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<View> f29056b;

    /* renamed from: c  reason: collision with root package name */
    public final Camera f29057c = new Camera();

    /* renamed from: d  reason: collision with root package name */
    public boolean f29058d;

    /* renamed from: e  reason: collision with root package name */
    public float f29059e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f29060f;

    /* renamed from: g  reason: collision with root package name */
    public float f29061g;

    /* renamed from: h  reason: collision with root package name */
    public float f29062h;

    /* renamed from: i  reason: collision with root package name */
    public float f29063i;

    /* renamed from: j  reason: collision with root package name */
    public float f29064j;

    /* renamed from: k  reason: collision with root package name */
    public float f29065k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f29066l = 1.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f29067m;

    /* renamed from: n  reason: collision with root package name */
    public float f29068n;

    /* renamed from: o  reason: collision with root package name */
    public final RectF f29069o = new RectF();

    /* renamed from: p  reason: collision with root package name */
    public final RectF f29070p = new RectF();

    /* renamed from: q  reason: collision with root package name */
    public final Matrix f29071q = new Matrix();

    public a(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f29056b = new WeakReference<>(view);
    }

    public static a H(View view) {
        WeakHashMap<View, a> weakHashMap = f29055s;
        a aVar = weakHashMap.get(view);
        if (aVar != null && aVar == view.getAnimation()) {
            return aVar;
        }
        a aVar2 = new a(view);
        weakHashMap.put(view, aVar2);
        return aVar2;
    }

    public void A(int i11) {
        View view = (View) this.f29056b.get();
        if (view != null) {
            view.scrollTo(i11, view.getScrollY());
        }
    }

    public void B(int i11) {
        View view = (View) this.f29056b.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i11);
        }
    }

    public void C(float f11) {
        if (this.f29067m != f11) {
            r();
            this.f29067m = f11;
            q();
        }
    }

    public void D(float f11) {
        if (this.f29068n != f11) {
            r();
            this.f29068n = f11;
            q();
        }
    }

    public void E(float f11) {
        View view = (View) this.f29056b.get();
        if (view != null) {
            C(f11 - ((float) view.getLeft()));
        }
    }

    public void F(float f11) {
        View view = (View) this.f29056b.get();
        if (view != null) {
            D(f11 - ((float) view.getTop()));
        }
    }

    public final void G(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z11 = this.f29058d;
        float f11 = z11 ? this.f29060f : width / 2.0f;
        float f12 = z11 ? this.f29061g : height / 2.0f;
        float f13 = this.f29062h;
        float f14 = this.f29063i;
        float f15 = this.f29064j;
        if (!(f13 == 0.0f && f14 == 0.0f && f15 == 0.0f)) {
            Camera camera = this.f29057c;
            camera.save();
            camera.rotateX(f13);
            camera.rotateY(f14);
            camera.rotateZ(-f15);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f11, -f12);
            matrix.postTranslate(f11, f12);
        }
        float f16 = this.f29065k;
        float f17 = this.f29066l;
        if (!(f16 == 1.0f && f17 == 1.0f)) {
            matrix.postScale(f16, f17);
            matrix.postTranslate((-(f11 / width)) * ((f16 * width) - width), (-(f12 / height)) * ((f17 * height) - height));
        }
        matrix.postTranslate(this.f29067m, this.f29068n);
    }

    public void applyTransformation(float f11, Transformation transformation) {
        View view = (View) this.f29056b.get();
        if (view != null) {
            transformation.setAlpha(this.f29059e);
            G(transformation.getMatrix(), view);
        }
    }

    public final void b(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f29071q;
        matrix.reset();
        G(matrix, view);
        this.f29071q.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        float f11 = rectF.right;
        float f12 = rectF.left;
        if (f11 < f12) {
            rectF.right = f12;
            rectF.left = f11;
        }
        float f13 = rectF.bottom;
        float f14 = rectF.top;
        if (f13 < f14) {
            rectF.top = f13;
            rectF.bottom = f14;
        }
    }

    public float c() {
        return this.f29059e;
    }

    public float d() {
        return this.f29060f;
    }

    public float e() {
        return this.f29061g;
    }

    public float f() {
        return this.f29064j;
    }

    public float g() {
        return this.f29062h;
    }

    public float h() {
        return this.f29063i;
    }

    public float i() {
        return this.f29065k;
    }

    public float j() {
        return this.f29066l;
    }

    public int k() {
        View view = (View) this.f29056b.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int l() {
        View view = (View) this.f29056b.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float m() {
        return this.f29067m;
    }

    public float n() {
        return this.f29068n;
    }

    public float o() {
        View view = (View) this.f29056b.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.f29067m;
    }

    public float p() {
        View view = (View) this.f29056b.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.f29068n;
    }

    public final void q() {
        View view = (View) this.f29056b.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.f29070p;
            b(rectF, view);
            rectF.union(this.f29069o);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    public final void r() {
        View view = (View) this.f29056b.get();
        if (view != null) {
            b(this.f29069o, view);
        }
    }

    public void s(float f11) {
        if (this.f29059e != f11) {
            this.f29059e = f11;
            View view = (View) this.f29056b.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void t(float f11) {
        if (!this.f29058d || this.f29060f != f11) {
            r();
            this.f29058d = true;
            this.f29060f = f11;
            q();
        }
    }

    public void u(float f11) {
        if (!this.f29058d || this.f29061g != f11) {
            r();
            this.f29058d = true;
            this.f29061g = f11;
            q();
        }
    }

    public void v(float f11) {
        if (this.f29064j != f11) {
            r();
            this.f29064j = f11;
            q();
        }
    }

    public void w(float f11) {
        if (this.f29062h != f11) {
            r();
            this.f29062h = f11;
            q();
        }
    }

    public void x(float f11) {
        if (this.f29063i != f11) {
            r();
            this.f29063i = f11;
            q();
        }
    }

    public void y(float f11) {
        if (this.f29065k != f11) {
            r();
            this.f29065k = f11;
            q();
        }
    }

    public void z(float f11) {
        if (this.f29066l != f11) {
            r();
            this.f29066l = f11;
            q();
        }
    }
}
