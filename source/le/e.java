package le;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.hbg.module.libkt.custom.blur.RenderEffectBlur;
import le.g;

public final class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public float f25290a = 10.0f;

    /* renamed from: b  reason: collision with root package name */
    public final a f25291b;

    /* renamed from: c  reason: collision with root package name */
    public c f25292c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f25293d;

    /* renamed from: e  reason: collision with root package name */
    public final View f25294e;

    /* renamed from: f  reason: collision with root package name */
    public int f25295f;

    /* renamed from: g  reason: collision with root package name */
    public final ViewGroup f25296g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f25297h = new int[2];

    /* renamed from: i  reason: collision with root package name */
    public final int[] f25298i = new int[2];

    /* renamed from: j  reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f25299j = new a();

    /* renamed from: k  reason: collision with root package name */
    public boolean f25300k = true;

    /* renamed from: l  reason: collision with root package name */
    public boolean f25301l;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f25302m;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        public boolean onPreDraw() {
            e.this.f();
            return true;
        }
    }

    public e(View view, ViewGroup viewGroup, int i11, a aVar) {
        this.f25296g = viewGroup;
        this.f25294e = view;
        this.f25295f = i11;
        this.f25291b = aVar;
        if (aVar instanceof RenderEffectBlur) {
            ((RenderEffectBlur) aVar).f(view.getContext());
        }
        d(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void a() {
        d(this.f25294e.getMeasuredWidth(), this.f25294e.getMeasuredHeight());
    }

    public d b(boolean z11) {
        this.f25296g.getViewTreeObserver().removeOnPreDrawListener(this.f25299j);
        this.f25294e.getViewTreeObserver().removeOnPreDrawListener(this.f25299j);
        if (z11) {
            this.f25296g.getViewTreeObserver().addOnPreDrawListener(this.f25299j);
            if (this.f25296g.getWindowId() != this.f25294e.getWindowId()) {
                this.f25294e.getViewTreeObserver().addOnPreDrawListener(this.f25299j);
            }
        }
        return this;
    }

    public final void c() {
        this.f25293d = this.f25291b.e(this.f25293d, this.f25290a);
        if (!this.f25291b.b()) {
            this.f25292c.setBitmap(this.f25293d);
        }
    }

    public void d(int i11, int i12) {
        b(true);
        g gVar = new g(this.f25291b.c());
        if (gVar.b(i11, i12)) {
            this.f25294e.setWillNotDraw(true);
            return;
        }
        this.f25294e.setWillNotDraw(false);
        g.a d11 = gVar.d(i11, i12);
        this.f25293d = Bitmap.createBitmap(d11.f25311a, d11.f25312b, this.f25291b.a());
        this.f25292c = new c(this.f25293d);
        this.f25301l = true;
        f();
    }

    public void destroy() {
        b(false);
        this.f25291b.destroy();
        this.f25301l = false;
    }

    public boolean draw(Canvas canvas) {
        if (this.f25300k && this.f25301l) {
            if (canvas instanceof c) {
                return false;
            }
            float height = ((float) this.f25294e.getHeight()) / ((float) this.f25293d.getHeight());
            canvas.save();
            canvas.scale(((float) this.f25294e.getWidth()) / ((float) this.f25293d.getWidth()), height);
            this.f25291b.d(canvas, this.f25293d);
            canvas.restore();
            int i11 = this.f25295f;
            if (i11 != 0) {
                canvas.drawColor(i11);
            }
        }
        return true;
    }

    public final void e() {
        this.f25296g.getLocationOnScreen(this.f25297h);
        this.f25294e.getLocationOnScreen(this.f25298i);
        int[] iArr = this.f25298i;
        int i11 = iArr[0];
        int[] iArr2 = this.f25297h;
        int i12 = i11 - iArr2[0];
        int i13 = iArr[1] - iArr2[1];
        float height = ((float) this.f25294e.getHeight()) / ((float) this.f25293d.getHeight());
        float width = ((float) this.f25294e.getWidth()) / ((float) this.f25293d.getWidth());
        this.f25292c.translate(((float) (-i12)) / width, ((float) (-i13)) / height);
        this.f25292c.scale(1.0f / width, 1.0f / height);
    }

    public void f() {
        if (this.f25300k && this.f25301l) {
            Drawable drawable = this.f25302m;
            if (drawable == null) {
                this.f25293d.eraseColor(0);
            } else {
                drawable.draw(this.f25292c);
            }
            this.f25292c.save();
            e();
            this.f25296g.draw(this.f25292c);
            this.f25292c.restore();
            c();
        }
    }
}
