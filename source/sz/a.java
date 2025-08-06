package sz;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import d00.b;
import java.util.Arrays;
import java.util.Locale;

public class a {

    /* renamed from: x  reason: collision with root package name */
    public static final float[] f60123x = {2.0f, 1.5f, 1.17f, 1.0f, 0.83f, 0.67f};

    /* renamed from: a  reason: collision with root package name */
    public final int f60124a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f60125b;

    /* renamed from: c  reason: collision with root package name */
    public final int f60126c;

    /* renamed from: d  reason: collision with root package name */
    public final int f60127d;

    /* renamed from: e  reason: collision with root package name */
    public final int f60128e;

    /* renamed from: f  reason: collision with root package name */
    public final int f60129f;

    /* renamed from: g  reason: collision with root package name */
    public final int f60130g;

    /* renamed from: h  reason: collision with root package name */
    public final int f60131h;

    /* renamed from: i  reason: collision with root package name */
    public final int f60132i;

    /* renamed from: j  reason: collision with root package name */
    public final int f60133j;

    /* renamed from: k  reason: collision with root package name */
    public final int f60134k;

    /* renamed from: l  reason: collision with root package name */
    public final int f60135l;

    /* renamed from: m  reason: collision with root package name */
    public final int f60136m;

    /* renamed from: n  reason: collision with root package name */
    public final Typeface f60137n;

    /* renamed from: o  reason: collision with root package name */
    public final Typeface f60138o;

    /* renamed from: p  reason: collision with root package name */
    public final int f60139p;

    /* renamed from: q  reason: collision with root package name */
    public final int f60140q;

    /* renamed from: r  reason: collision with root package name */
    public final int f60141r;

    /* renamed from: s  reason: collision with root package name */
    public final int f60142s;

    /* renamed from: t  reason: collision with root package name */
    public final Typeface f60143t;

    /* renamed from: u  reason: collision with root package name */
    public final float[] f60144u;

    /* renamed from: v  reason: collision with root package name */
    public final int f60145v;

    /* renamed from: w  reason: collision with root package name */
    public final int f60146w;

    /* renamed from: sz.a$a  reason: collision with other inner class name */
    public static class C0676a {

        /* renamed from: a  reason: collision with root package name */
        public int f60147a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f60148b = true;

        /* renamed from: c  reason: collision with root package name */
        public int f60149c;

        /* renamed from: d  reason: collision with root package name */
        public int f60150d;

        /* renamed from: e  reason: collision with root package name */
        public int f60151e;

        /* renamed from: f  reason: collision with root package name */
        public int f60152f;

        /* renamed from: g  reason: collision with root package name */
        public int f60153g;

        /* renamed from: h  reason: collision with root package name */
        public int f60154h;

        /* renamed from: i  reason: collision with root package name */
        public int f60155i;

        /* renamed from: j  reason: collision with root package name */
        public int f60156j;

        /* renamed from: k  reason: collision with root package name */
        public int f60157k;

        /* renamed from: l  reason: collision with root package name */
        public int f60158l;

        /* renamed from: m  reason: collision with root package name */
        public int f60159m;

        /* renamed from: n  reason: collision with root package name */
        public Typeface f60160n;

        /* renamed from: o  reason: collision with root package name */
        public Typeface f60161o;

        /* renamed from: p  reason: collision with root package name */
        public int f60162p;

        /* renamed from: q  reason: collision with root package name */
        public int f60163q;

        /* renamed from: r  reason: collision with root package name */
        public int f60164r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f60165s;

        /* renamed from: t  reason: collision with root package name */
        public Typeface f60166t;

        /* renamed from: u  reason: collision with root package name */
        public float[] f60167u;

        /* renamed from: v  reason: collision with root package name */
        public int f60168v;

        /* renamed from: w  reason: collision with root package name */
        public int f60169w = -1;

        public C0676a A(int i11) {
            this.f60153g = i11;
            return this;
        }

        public C0676a B(int i11) {
            this.f60154h = i11;
            return this;
        }

        public C0676a C(int i11) {
            this.f60159m = i11;
            return this;
        }

        public C0676a D(int i11) {
            this.f60164r = i11;
            return this;
        }

        public C0676a E(int i11) {
            this.f60169w = i11;
            return this;
        }

        public C0676a x(int i11) {
            this.f60149c = i11;
            return this;
        }

        public C0676a y(int i11) {
            this.f60150d = i11;
            return this;
        }

        public a z() {
            return new a(this);
        }
    }

    public a(C0676a aVar) {
        this.f60124a = aVar.f60147a;
        this.f60125b = aVar.f60148b;
        this.f60126c = aVar.f60149c;
        this.f60127d = aVar.f60150d;
        this.f60128e = aVar.f60151e;
        this.f60129f = aVar.f60152f;
        this.f60130g = aVar.f60153g;
        this.f60131h = aVar.f60154h;
        this.f60132i = aVar.f60155i;
        this.f60133j = aVar.f60156j;
        this.f60134k = aVar.f60157k;
        this.f60135l = aVar.f60158l;
        this.f60136m = aVar.f60159m;
        this.f60137n = aVar.f60160n;
        this.f60138o = aVar.f60161o;
        this.f60139p = aVar.f60162p;
        this.f60140q = aVar.f60163q;
        this.f60141r = aVar.f60164r;
        this.f60142s = aVar.f60165s;
        this.f60143t = aVar.f60166t;
        this.f60144u = aVar.f60167u;
        this.f60145v = aVar.f60168v;
        this.f60146w = aVar.f60169w;
    }

    public static C0676a j(Context context) {
        b a11 = b.a(context);
        return new C0676a().C(a11.b(8)).x(a11.b(24)).y(a11.b(4)).A(a11.b(1)).D(a11.b(1)).E(a11.b(4));
    }

    public void a(Paint paint) {
        int i11 = this.f60128e;
        if (i11 == 0) {
            i11 = d00.a.a(paint.getColor(), 25);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i11);
    }

    public void b(Paint paint) {
        int i11 = this.f60133j;
        if (i11 == 0) {
            i11 = this.f60132i;
        }
        if (i11 != 0) {
            paint.setColor(i11);
        }
        Typeface typeface = this.f60138o;
        if (typeface == null) {
            typeface = this.f60137n;
        }
        if (typeface != null) {
            paint.setTypeface(typeface);
            int i12 = this.f60140q;
            if (i12 <= 0) {
                i12 = this.f60139p;
            }
            if (i12 > 0) {
                paint.setTextSize((float) i12);
                return;
            }
            return;
        }
        paint.setTypeface(Typeface.MONOSPACE);
        int i13 = this.f60140q;
        if (i13 <= 0) {
            i13 = this.f60139p;
        }
        if (i13 > 0) {
            paint.setTextSize((float) i13);
        } else {
            paint.setTextSize(paint.getTextSize() * 0.87f);
        }
    }

    public void c(Paint paint) {
        int i11 = this.f60132i;
        if (i11 != 0) {
            paint.setColor(i11);
        }
        Typeface typeface = this.f60137n;
        if (typeface != null) {
            paint.setTypeface(typeface);
            int i12 = this.f60139p;
            if (i12 > 0) {
                paint.setTextSize((float) i12);
                return;
            }
            return;
        }
        paint.setTypeface(Typeface.MONOSPACE);
        int i13 = this.f60139p;
        if (i13 > 0) {
            paint.setTextSize((float) i13);
        } else {
            paint.setTextSize(paint.getTextSize() * 0.87f);
        }
    }

    public void d(Paint paint) {
        int i11 = this.f60142s;
        if (i11 == 0) {
            i11 = d00.a.a(paint.getColor(), 75);
        }
        paint.setColor(i11);
        paint.setStyle(Paint.Style.FILL);
        int i12 = this.f60141r;
        if (i12 >= 0) {
            paint.setStrokeWidth((float) i12);
        }
    }

    public void e(Paint paint, int i11) {
        Typeface typeface = this.f60143t;
        if (typeface == null) {
            paint.setFakeBoldText(true);
        } else {
            paint.setTypeface(typeface);
        }
        float[] fArr = this.f60144u;
        if (fArr == null) {
            fArr = f60123x;
        }
        if (fArr == null || fArr.length < i11) {
            throw new IllegalStateException(String.format(Locale.US, "Supplied heading level: %d is invalid, where configured heading sizes are: `%s`", new Object[]{Integer.valueOf(i11), Arrays.toString(fArr)}));
        }
        paint.setTextSize(paint.getTextSize() * fArr[i11 - 1]);
    }

    public void f(Paint paint) {
        paint.setUnderlineText(this.f60125b);
        int i11 = this.f60124a;
        if (i11 != 0) {
            paint.setColor(i11);
        } else if (paint instanceof TextPaint) {
            paint.setColor(((TextPaint) paint).linkColor);
        }
    }

    public void g(TextPaint textPaint) {
        textPaint.setUnderlineText(this.f60125b);
        int i11 = this.f60124a;
        if (i11 != 0) {
            textPaint.setColor(i11);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
    }

    public void h(Paint paint) {
        int i11 = this.f60129f;
        if (i11 == 0) {
            i11 = paint.getColor();
        }
        paint.setColor(i11);
        int i12 = this.f60130g;
        if (i12 != 0) {
            paint.setStrokeWidth((float) i12);
        }
    }

    public void i(Paint paint) {
        int i11 = this.f60145v;
        if (i11 == 0) {
            i11 = d00.a.a(paint.getColor(), 25);
        }
        paint.setColor(i11);
        paint.setStyle(Paint.Style.FILL);
        int i12 = this.f60146w;
        if (i12 >= 0) {
            paint.setStrokeWidth((float) i12);
        }
    }

    public int k() {
        return this.f60126c;
    }

    public int l() {
        int i11 = this.f60127d;
        return i11 == 0 ? (int) ((((float) this.f60126c) * 0.25f) + 0.5f) : i11;
    }

    public int m(int i11) {
        int min = Math.min(this.f60126c, i11) / 2;
        int i12 = this.f60131h;
        return (i12 == 0 || i12 > min) ? min : i12;
    }

    public int n(Paint paint) {
        int i11 = this.f60134k;
        return i11 != 0 ? i11 : d00.a.a(paint.getColor(), 25);
    }

    public int o(Paint paint) {
        int i11 = this.f60135l;
        if (i11 == 0) {
            i11 = this.f60134k;
        }
        return i11 != 0 ? i11 : d00.a.a(paint.getColor(), 25);
    }

    public int p() {
        return this.f60136m;
    }
}
