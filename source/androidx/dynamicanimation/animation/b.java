package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.h0;
import androidx.dynamicanimation.animation.a;
import androidx.dynamicanimation.animation.b;
import java.util.ArrayList;

public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: m  reason: collision with root package name */
    public static final r f9340m = new f("translationX");

    /* renamed from: n  reason: collision with root package name */
    public static final r f9341n = new g("translationY");

    /* renamed from: o  reason: collision with root package name */
    public static final r f9342o = new h("translationZ");

    /* renamed from: p  reason: collision with root package name */
    public static final r f9343p = new i("scaleX");

    /* renamed from: q  reason: collision with root package name */
    public static final r f9344q = new j("scaleY");

    /* renamed from: r  reason: collision with root package name */
    public static final r f9345r = new k("rotation");

    /* renamed from: s  reason: collision with root package name */
    public static final r f9346s = new l("rotationX");

    /* renamed from: t  reason: collision with root package name */
    public static final r f9347t = new m("rotationY");

    /* renamed from: u  reason: collision with root package name */
    public static final r f9348u = new n("x");

    /* renamed from: v  reason: collision with root package name */
    public static final r f9349v = new a("y");

    /* renamed from: w  reason: collision with root package name */
    public static final r f9350w = new C0037b("z");

    /* renamed from: x  reason: collision with root package name */
    public static final r f9351x = new c("alpha");

    /* renamed from: y  reason: collision with root package name */
    public static final r f9352y = new d("scrollX");

    /* renamed from: z  reason: collision with root package name */
    public static final r f9353z = new e("scrollY");

    /* renamed from: a  reason: collision with root package name */
    public float f9354a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f9355b = Float.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9356c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Object f9357d;

    /* renamed from: e  reason: collision with root package name */
    public final j1.a f9358e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9359f = false;

    /* renamed from: g  reason: collision with root package name */
    public float f9360g = Float.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    public float f9361h = (-Float.MAX_VALUE);

    /* renamed from: i  reason: collision with root package name */
    public long f9362i = 0;

    /* renamed from: j  reason: collision with root package name */
    public float f9363j;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList<p> f9364k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList<q> f9365l = new ArrayList<>();

    public static class a extends r {
        public a(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getY();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setY(f11);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.b$b  reason: collision with other inner class name */
    public static class C0037b extends r {
        public C0037b(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return h0.U(view);
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            h0.W0(view, f11);
        }
    }

    public static class c extends r {
        public c(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getAlpha();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setAlpha(f11);
        }
    }

    public static class d extends r {
        public d(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return (float) view.getScrollX();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setScrollX((int) f11);
        }
    }

    public static class e extends r {
        public e(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return (float) view.getScrollY();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setScrollY((int) f11);
        }
    }

    public static class f extends r {
        public f(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getTranslationX();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setTranslationX(f11);
        }
    }

    public static class g extends r {
        public g(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getTranslationY();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setTranslationY(f11);
        }
    }

    public static class h extends r {
        public h(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return h0.S(view);
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            h0.V0(view, f11);
        }
    }

    public static class i extends r {
        public i(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getScaleX();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setScaleX(f11);
        }
    }

    public static class j extends r {
        public j(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getScaleY();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setScaleY(f11);
        }
    }

    public static class k extends r {
        public k(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getRotation();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setRotation(f11);
        }
    }

    public static class l extends r {
        public l(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getRotationX();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setRotationX(f11);
        }
    }

    public static class m extends r {
        public m(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getRotationY();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setRotationY(f11);
        }
    }

    public static class n extends r {
        public n(String str) {
            super(str, (f) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getX();
        }

        /* renamed from: b */
        public void setValue(View view, float f11) {
            view.setX(f11);
        }
    }

    public static class o {

        /* renamed from: a  reason: collision with root package name */
        public float f9366a;

        /* renamed from: b  reason: collision with root package name */
        public float f9367b;
    }

    public interface p {
        void a(b bVar, boolean z11, float f11, float f12);
    }

    public interface q {
        void a(b bVar, float f11, float f12);
    }

    public static abstract class r extends j1.a<View> {
        public /* synthetic */ r(String str, f fVar) {
            this(str);
        }

        public r(String str) {
            super(str);
        }
    }

    public <K> b(K k11, j1.a<K> aVar) {
        this.f9357d = k11;
        this.f9358e = aVar;
        if (aVar == f9345r || aVar == f9346s || aVar == f9347t) {
            this.f9363j = 0.1f;
        } else if (aVar == f9351x) {
            this.f9363j = 0.00390625f;
        } else if (aVar == f9343p || aVar == f9344q) {
            this.f9363j = 0.00390625f;
        } else {
            this.f9363j = 1.0f;
        }
    }

    public static <T> void h(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public boolean a(long j11) {
        long j12 = this.f9362i;
        if (j12 == 0) {
            this.f9362i = j11;
            k(this.f9355b);
            return false;
        }
        this.f9362i = j11;
        boolean o11 = o(j11 - j12);
        float min = Math.min(this.f9355b, this.f9360g);
        this.f9355b = min;
        float max = Math.max(min, this.f9361h);
        this.f9355b = max;
        k(max);
        if (o11) {
            d(false);
        }
        return o11;
    }

    public T b(p pVar) {
        if (!this.f9364k.contains(pVar)) {
            this.f9364k.add(pVar);
        }
        return this;
    }

    public void c() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.f9359f) {
            d(true);
        }
    }

    public final void d(boolean z11) {
        this.f9359f = false;
        a.d().g(this);
        this.f9362i = 0;
        this.f9356c = false;
        for (int i11 = 0; i11 < this.f9364k.size(); i11++) {
            if (this.f9364k.get(i11) != null) {
                this.f9364k.get(i11).a(this, z11, this.f9355b, this.f9354a);
            }
        }
        h(this.f9364k);
    }

    public final float e() {
        return this.f9358e.getValue(this.f9357d);
    }

    public float f() {
        return this.f9363j * 0.75f;
    }

    public boolean g() {
        return this.f9359f;
    }

    public T i(float f11) {
        this.f9360g = f11;
        return this;
    }

    public T j(float f11) {
        this.f9361h = f11;
        return this;
    }

    public void k(float f11) {
        this.f9358e.setValue(this.f9357d, f11);
        for (int i11 = 0; i11 < this.f9365l.size(); i11++) {
            if (this.f9365l.get(i11) != null) {
                this.f9365l.get(i11).a(this, this.f9355b, this.f9354a);
            }
        }
        h(this.f9365l);
    }

    public T l(float f11) {
        this.f9355b = f11;
        this.f9356c = true;
        return this;
    }

    public void m() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.f9359f) {
            n();
        }
    }

    public final void n() {
        if (!this.f9359f) {
            this.f9359f = true;
            if (!this.f9356c) {
                this.f9355b = e();
            }
            float f11 = this.f9355b;
            if (f11 > this.f9360g || f11 < this.f9361h) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            a.d().a(this, 0);
        }
    }

    public abstract boolean o(long j11);
}
