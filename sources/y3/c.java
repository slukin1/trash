package y3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import f4.h;
import java.nio.ByteBuffer;
import java.util.List;
import n3.g;
import y3.f;

public class c extends Drawable implements f.b, Animatable {

    /* renamed from: b  reason: collision with root package name */
    public final a f66675b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66676c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66677d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66678e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66679f;

    /* renamed from: g  reason: collision with root package name */
    public int f66680g;

    /* renamed from: h  reason: collision with root package name */
    public int f66681h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66682i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f66683j;

    /* renamed from: k  reason: collision with root package name */
    public Rect f66684k;

    /* renamed from: l  reason: collision with root package name */
    public List<Animatable2Compat$AnimationCallback> f66685l;

    public static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final f f66686a;

        public a(f fVar) {
            this.f66686a = fVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, l3.a aVar, g<Bitmap> gVar, int i11, int i12, Bitmap bitmap) {
        this(new a(new f(com.bumptech.glide.a.d(context), aVar, i11, i12, gVar, bitmap)));
    }

    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f66680g++;
        }
        int i11 = this.f66681h;
        if (i11 != -1 && this.f66680g >= i11) {
            j();
            stop();
        }
    }

    public final Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    public ByteBuffer c() {
        return this.f66675b.f66686a.b();
    }

    public final Rect d() {
        if (this.f66684k == null) {
            this.f66684k = new Rect();
        }
        return this.f66684k;
    }

    public void draw(Canvas canvas) {
        if (!this.f66678e) {
            if (this.f66682i) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
                this.f66682i = false;
            }
            canvas.drawBitmap(this.f66675b.f66686a.c(), (Rect) null, d(), h());
        }
    }

    public Bitmap e() {
        return this.f66675b.f66686a.e();
    }

    public int f() {
        return this.f66675b.f66686a.f();
    }

    public int g() {
        return this.f66675b.f66686a.d();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f66675b;
    }

    public int getIntrinsicHeight() {
        return this.f66675b.f66686a.h();
    }

    public int getIntrinsicWidth() {
        return this.f66675b.f66686a.k();
    }

    public int getOpacity() {
        return -2;
    }

    public final Paint h() {
        if (this.f66683j == null) {
            this.f66683j = new Paint(2);
        }
        return this.f66683j;
    }

    public int i() {
        return this.f66675b.f66686a.j();
    }

    public boolean isRunning() {
        return this.f66676c;
    }

    public final void j() {
        List<Animatable2Compat$AnimationCallback> list = this.f66685l;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f66685l.get(i11).onAnimationEnd(this);
            }
        }
    }

    public void k() {
        this.f66678e = true;
        this.f66675b.f66686a.a();
    }

    public final void l() {
        this.f66680g = 0;
    }

    public void m(g<Bitmap> gVar, Bitmap bitmap) {
        this.f66675b.f66686a.o(gVar, bitmap);
    }

    public final void n() {
        h.a(!this.f66678e, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f66675b.f66686a.f() == 1) {
            invalidateSelf();
        } else if (!this.f66676c) {
            this.f66676c = true;
            this.f66675b.f66686a.r(this);
            invalidateSelf();
        }
    }

    public final void o() {
        this.f66676c = false;
        this.f66675b.f66686a.s(this);
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f66682i = true;
    }

    public void setAlpha(int i11) {
        h().setAlpha(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z11, boolean z12) {
        h.a(!this.f66678e, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f66679f = z11;
        if (!z11) {
            o();
        } else if (this.f66677d) {
            n();
        }
        return super.setVisible(z11, z12);
    }

    public void start() {
        this.f66677d = true;
        l();
        if (this.f66679f) {
            n();
        }
    }

    public void stop() {
        this.f66677d = false;
        o();
    }

    public c(a aVar) {
        this.f66679f = true;
        this.f66681h = -1;
        this.f66675b = (a) h.d(aVar);
    }
}
