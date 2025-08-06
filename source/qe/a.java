package qe;

import android.animation.ArgbEvaluator;
import android.graphics.Paint;
import com.hbg.module.libkt.custom.indicator.view.option.IndicatorOptions;
import kotlin.jvm.internal.r;

public abstract class a implements f {

    /* renamed from: g  reason: collision with root package name */
    public static final C0224a f25601g = new C0224a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public IndicatorOptions f25602a;

    /* renamed from: b  reason: collision with root package name */
    public final b f25603b = new b();

    /* renamed from: c  reason: collision with root package name */
    public float f25604c;

    /* renamed from: d  reason: collision with root package name */
    public float f25605d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f25606e;

    /* renamed from: f  reason: collision with root package name */
    public ArgbEvaluator f25607f;

    /* renamed from: qe.a$a  reason: collision with other inner class name */
    public static final class C0224a {
        public C0224a() {
        }

        public /* synthetic */ C0224a(r rVar) {
            this();
        }
    }

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f25608a;

        /* renamed from: b  reason: collision with root package name */
        public int f25609b;

        public b() {
        }

        public final int a() {
            return this.f25609b;
        }

        public final int b() {
            return this.f25608a;
        }

        public final void c(int i11, int i12) {
            this.f25608a = i11;
            this.f25609b = i12;
        }
    }

    public a(IndicatorOptions indicatorOptions) {
        this.f25602a = indicatorOptions;
        Paint paint = new Paint();
        this.f25606e = paint;
        paint.setAntiAlias(true);
        if (this.f25602a.j() == 4 || this.f25602a.j() == 5) {
            this.f25607f = new ArgbEvaluator();
        }
    }

    public final ArgbEvaluator b() {
        return this.f25607f;
    }

    public final IndicatorOptions c() {
        return this.f25602a;
    }

    public b d(int i11, int i12) {
        this.f25604c = RangesKt___RangesKt.c(this.f25602a.f(), this.f25602a.b());
        this.f25605d = RangesKt___RangesKt.f(this.f25602a.f(), this.f25602a.b());
        this.f25603b.c(j(), i());
        return this.f25603b;
    }

    public final Paint e() {
        return this.f25606e;
    }

    public final float f() {
        return this.f25604c;
    }

    public final float g() {
        return this.f25605d;
    }

    public final boolean h() {
        return this.f25602a.f() == this.f25602a.b();
    }

    public int i() {
        return ((int) this.f25602a.m()) + 1;
    }

    public final int j() {
        float h11 = (float) (this.f25602a.h() - 1);
        return (int) ((this.f25602a.l() * h11) + this.f25604c + (h11 * this.f25605d));
    }
}
