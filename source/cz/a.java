package cz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.yanzhenjie.loading.FastOutSlowInInterpolator;
import com.yanzhenjie.loading.Utils;

public class a extends c {
    public static final int[] A = {Color.parseColor("#55ffffff"), Color.parseColor("#b1ffffff"), Color.parseColor("#ffffffff")};

    /* renamed from: v  reason: collision with root package name */
    public static final Interpolator f52775v = new LinearInterpolator();

    /* renamed from: w  reason: collision with root package name */
    public static final Interpolator f52776w = new FastOutSlowInInterpolator();

    /* renamed from: x  reason: collision with root package name */
    public static final Interpolator f52777x = new AccelerateInterpolator();

    /* renamed from: y  reason: collision with root package name */
    public static final Interpolator f52778y = new DecelerateInterpolator();

    /* renamed from: z  reason: collision with root package name */
    public static final float[] f52779z = {1.0f, 0.875f, 0.625f};

    /* renamed from: h  reason: collision with root package name */
    public final Paint f52780h = new Paint();

    /* renamed from: i  reason: collision with root package name */
    public final RectF f52781i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    public final Animator.AnimatorListener f52782j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f52783k;

    /* renamed from: l  reason: collision with root package name */
    public float[] f52784l;

    /* renamed from: m  reason: collision with root package name */
    public float f52785m;

    /* renamed from: n  reason: collision with root package name */
    public float f52786n;

    /* renamed from: o  reason: collision with root package name */
    public float f52787o;

    /* renamed from: p  reason: collision with root package name */
    public float f52788p;

    /* renamed from: q  reason: collision with root package name */
    public float f52789q;

    /* renamed from: r  reason: collision with root package name */
    public float f52790r;

    /* renamed from: s  reason: collision with root package name */
    public float f52791s;

    /* renamed from: t  reason: collision with root package name */
    public float f52792t;

    /* renamed from: u  reason: collision with root package name */
    public float f52793u;

    /* renamed from: cz.a$a  reason: collision with other inner class name */
    public class C0644a extends AnimatorListenerAdapter {
        public C0644a() {
        }

        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            a.this.y();
            a aVar = a.this;
            float unused = aVar.f52789q = aVar.f52788p;
            a aVar2 = a.this;
            float unused2 = aVar2.f52786n = (aVar2.f52786n + 1.0f) % 5.0f;
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            float unused = a.this.f52786n = 0.0f;
        }
    }

    public a(Context context) {
        super(context);
        C0644a aVar = new C0644a();
        this.f52782j = aVar;
        t(context);
        x();
        b(aVar);
    }

    public void c(float f11) {
        if (f11 <= 0.5f) {
            float interpolation = this.f52791s + (f52776w.getInterpolation(f11 / 0.5f) * 288.0f);
            this.f52789q = interpolation;
            float f12 = this.f52788p - interpolation;
            float abs = Math.abs(f12) / 288.0f;
            float interpolation2 = f52778y.getInterpolation(abs);
            Interpolator interpolator = f52775v;
            float interpolation3 = interpolation2 - interpolator.getInterpolation(abs);
            float interpolation4 = f52777x.getInterpolation(abs) - interpolator.getInterpolation(abs);
            float[] fArr = this.f52784l;
            float f13 = -f12;
            float[] fArr2 = f52779z;
            fArr[0] = fArr2[0] * f13 * (interpolation3 + 1.0f);
            fArr[1] = fArr2[1] * f13 * 1.0f;
            fArr[2] = f13 * fArr2[2] * (interpolation4 + 1.0f);
        }
        if (f11 > 0.5f) {
            float interpolation5 = this.f52790r + (f52776w.getInterpolation((f11 - 0.5f) / 0.5f) * 288.0f);
            this.f52788p = interpolation5;
            float f14 = interpolation5 - this.f52789q;
            float abs2 = Math.abs(f14) / 288.0f;
            float[] fArr3 = f52779z;
            if (abs2 > fArr3[1]) {
                float[] fArr4 = this.f52784l;
                fArr4[0] = -f14;
                fArr4[1] = fArr3[1] * 288.0f;
                fArr4[2] = fArr3[2] * 288.0f;
            } else if (abs2 > fArr3[2]) {
                float[] fArr5 = this.f52784l;
                fArr5[0] = 0.0f;
                fArr5[1] = -f14;
                fArr5[2] = fArr3[2] * 288.0f;
            } else {
                float[] fArr6 = this.f52784l;
                fArr6[0] = 0.0f;
                fArr6[1] = 0.0f;
                fArr6[2] = -f14;
            }
        }
        this.f52787o = (f11 * 216.0f) + ((this.f52786n / 5.0f) * 1080.0f);
    }

    public void d(Canvas canvas) {
        int save = canvas.save();
        this.f52781i.set(this.f52799b);
        RectF rectF = this.f52781i;
        float f11 = this.f52785m;
        rectF.inset(f11, f11);
        canvas.rotate(this.f52787o, this.f52781i.centerX(), this.f52781i.centerY());
        for (int i11 = 0; i11 < 3; i11++) {
            if (this.f52784l[i11] != 0.0f) {
                this.f52780h.setColor(this.f52783k[i11]);
                canvas.drawArc(this.f52781i, this.f52788p, this.f52784l[i11], false, this.f52780h);
            }
        }
        canvas.restoreToCount(save);
    }

    public void g() {
        v();
    }

    public void h(int i11) {
        this.f52780h.setAlpha(i11);
    }

    public void k(ColorFilter colorFilter) {
        this.f52780h.setColorFilter(colorFilter);
    }

    public final void t(Context context) {
        this.f52792t = Utils.a(context, 2.5f);
        this.f52793u = Utils.a(context, 12.5f);
        this.f52784l = new float[3];
        this.f52783k = A;
    }

    public final void u(float f11, float f12) {
        float min = (Math.min(f11, f12) / 2.0f) - this.f52793u;
        float ceil = (float) Math.ceil((double) (this.f52792t / 2.0f));
        if (min < ceil) {
            min = ceil;
        }
        this.f52785m = min;
    }

    public final void v() {
        this.f52790r = 0.0f;
        this.f52791s = 0.0f;
        this.f52788p = 0.0f;
        this.f52789q = 0.0f;
        float[] fArr = this.f52784l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    public void w(int i11, int i12, int i13) {
        this.f52783k = new int[]{i11, i12, i13};
    }

    public final void x() {
        this.f52780h.setAntiAlias(true);
        this.f52780h.setStrokeWidth(this.f52792t);
        this.f52780h.setStyle(Paint.Style.STROKE);
        this.f52780h.setStrokeCap(Paint.Cap.ROUND);
        u((float) ((int) this.f52803f), (float) ((int) this.f52804g));
    }

    public final void y() {
        float f11 = this.f52788p;
        this.f52790r = f11;
        this.f52791s = f11;
    }
}
