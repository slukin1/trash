package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.h0;
import androidx.recyclerview.widget.RecyclerView;

public class i extends RecyclerView.ItemDecoration implements RecyclerView.k {
    public static final int[] D = {16842919};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.OnScrollListener C;

    /* renamed from: a  reason: collision with root package name */
    public final int f10854a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10855b;

    /* renamed from: c  reason: collision with root package name */
    public final StateListDrawable f10856c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f10857d;

    /* renamed from: e  reason: collision with root package name */
    public final int f10858e;

    /* renamed from: f  reason: collision with root package name */
    public final int f10859f;

    /* renamed from: g  reason: collision with root package name */
    public final StateListDrawable f10860g;

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f10861h;

    /* renamed from: i  reason: collision with root package name */
    public final int f10862i;

    /* renamed from: j  reason: collision with root package name */
    public final int f10863j;

    /* renamed from: k  reason: collision with root package name */
    public int f10864k;

    /* renamed from: l  reason: collision with root package name */
    public int f10865l;

    /* renamed from: m  reason: collision with root package name */
    public float f10866m;

    /* renamed from: n  reason: collision with root package name */
    public int f10867n;

    /* renamed from: o  reason: collision with root package name */
    public int f10868o;

    /* renamed from: p  reason: collision with root package name */
    public float f10869p;

    /* renamed from: q  reason: collision with root package name */
    public int f10870q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f10871r = 0;

    /* renamed from: s  reason: collision with root package name */
    public RecyclerView f10872s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f10873t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f10874u = false;

    /* renamed from: v  reason: collision with root package name */
    public int f10875v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f10876w = 0;

    /* renamed from: x  reason: collision with root package name */
    public final int[] f10877x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    public final int[] f10878y = new int[2];

    /* renamed from: z  reason: collision with root package name */
    public final ValueAnimator f10879z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            i.this.h(500);
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            i.this.s(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f10882b = false;

        public c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f10882b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f10882b) {
                this.f10882b = false;
            } else if (((Float) i.this.f10879z.getAnimatedValue()).floatValue() == 0.0f) {
                i iVar = i.this;
                iVar.A = 0;
                iVar.p(0);
            } else {
                i iVar2 = i.this;
                iVar2.A = 2;
                iVar2.m();
            }
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            i.this.f10856c.setAlpha(floatValue);
            i.this.f10857d.setAlpha(floatValue);
            i.this.m();
        }
    }

    public i(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i11, int i12, int i13) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f10879z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f10856c = stateListDrawable;
        this.f10857d = drawable;
        this.f10860g = stateListDrawable2;
        this.f10861h = drawable2;
        this.f10858e = Math.max(i11, stateListDrawable.getIntrinsicWidth());
        this.f10859f = Math.max(i11, drawable.getIntrinsicWidth());
        this.f10862i = Math.max(i11, stateListDrawable2.getIntrinsicWidth());
        this.f10863j = Math.max(i11, drawable2.getIntrinsicWidth());
        this.f10854a = i12;
        this.f10855b = i13;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        a(recyclerView);
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f10872s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                c();
            }
            this.f10872s = recyclerView;
            if (recyclerView != null) {
                q();
            }
        }
    }

    public final void b() {
        this.f10872s.removeCallbacks(this.B);
    }

    public final void c() {
        this.f10872s.removeItemDecoration(this);
        this.f10872s.removeOnItemTouchListener(this);
        this.f10872s.removeOnScrollListener(this.C);
        b();
    }

    public final void d(Canvas canvas) {
        int i11 = this.f10871r;
        int i12 = this.f10862i;
        int i13 = i11 - i12;
        int i14 = this.f10868o;
        int i15 = this.f10867n;
        int i16 = i14 - (i15 / 2);
        this.f10860g.setBounds(0, 0, i15, i12);
        this.f10861h.setBounds(0, 0, this.f10870q, this.f10863j);
        canvas.translate(0.0f, (float) i13);
        this.f10861h.draw(canvas);
        canvas.translate((float) i16, 0.0f);
        this.f10860g.draw(canvas);
        canvas.translate((float) (-i16), (float) (-i13));
    }

    public final void e(Canvas canvas) {
        int i11 = this.f10870q;
        int i12 = this.f10858e;
        int i13 = i11 - i12;
        int i14 = this.f10865l;
        int i15 = this.f10864k;
        int i16 = i14 - (i15 / 2);
        this.f10856c.setBounds(0, 0, i12, i15);
        this.f10857d.setBounds(0, 0, this.f10859f, this.f10871r);
        if (j()) {
            this.f10857d.draw(canvas);
            canvas.translate((float) this.f10858e, (float) i16);
            canvas.scale(-1.0f, 1.0f);
            this.f10856c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate((float) (-this.f10858e), (float) (-i16));
            return;
        }
        canvas.translate((float) i13, 0.0f);
        this.f10857d.draw(canvas);
        canvas.translate(0.0f, (float) i16);
        this.f10856c.draw(canvas);
        canvas.translate((float) (-i13), (float) (-i16));
    }

    public final int[] f() {
        int[] iArr = this.f10878y;
        int i11 = this.f10855b;
        iArr[0] = i11;
        iArr[1] = this.f10870q - i11;
        return iArr;
    }

    public final int[] g() {
        int[] iArr = this.f10877x;
        int i11 = this.f10855b;
        iArr[0] = i11;
        iArr[1] = this.f10871r - i11;
        return iArr;
    }

    public void h(int i11) {
        int i12 = this.A;
        if (i12 == 1) {
            this.f10879z.cancel();
        } else if (i12 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f10879z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f10879z.setDuration((long) i11);
        this.f10879z.start();
    }

    public final void i(float f11) {
        int[] f12 = f();
        float max = Math.max((float) f12[0], Math.min((float) f12[1], f11));
        if (Math.abs(((float) this.f10868o) - max) >= 2.0f) {
            int o11 = o(this.f10869p, max, f12, this.f10872s.computeHorizontalScrollRange(), this.f10872s.computeHorizontalScrollOffset(), this.f10870q);
            if (o11 != 0) {
                this.f10872s.scrollBy(o11, 0);
            }
            this.f10869p = max;
        }
    }

    public final boolean j() {
        return h0.F(this.f10872s) == 1;
    }

    public boolean k(float f11, float f12) {
        if (f12 >= ((float) (this.f10871r - this.f10862i))) {
            int i11 = this.f10868o;
            int i12 = this.f10867n;
            return f11 >= ((float) (i11 - (i12 / 2))) && f11 <= ((float) (i11 + (i12 / 2)));
        }
    }

    public boolean l(float f11, float f12) {
        if (!j() ? f11 >= ((float) (this.f10870q - this.f10858e)) : f11 <= ((float) this.f10858e)) {
            int i11 = this.f10865l;
            int i12 = this.f10864k;
            return f12 >= ((float) (i11 - (i12 / 2))) && f12 <= ((float) (i11 + (i12 / 2)));
        }
    }

    public void m() {
        this.f10872s.invalidate();
    }

    public final void n(int i11) {
        b();
        this.f10872s.postDelayed(this.B, (long) i11);
    }

    public final int o(float f11, float f12, int[] iArr, int i11, int i12, int i13) {
        int i14 = iArr[1] - iArr[0];
        if (i14 == 0) {
            return 0;
        }
        int i15 = i11 - i13;
        int i16 = (int) (((f12 - f11) / ((float) i14)) * ((float) i15));
        int i17 = i12 + i16;
        if (i17 >= i15 || i17 < 0) {
            return 0;
        }
        return i16;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f10870q != this.f10872s.getWidth() || this.f10871r != this.f10872s.getHeight()) {
            this.f10870q = this.f10872s.getWidth();
            this.f10871r = this.f10872s.getHeight();
            p(0);
        } else if (this.A != 0) {
            if (this.f10873t) {
                e(canvas);
            }
            if (this.f10874u) {
                d(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i11 = this.f10875v;
        if (i11 == 1) {
            boolean l11 = l(motionEvent.getX(), motionEvent.getY());
            boolean k11 = k(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!l11 && !k11) {
                return false;
            }
            if (k11) {
                this.f10876w = 1;
                this.f10869p = (float) ((int) motionEvent.getX());
            } else if (l11) {
                this.f10876w = 2;
                this.f10866m = (float) ((int) motionEvent.getY());
            }
            p(2);
        } else if (i11 != 2) {
            return false;
        }
        return true;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z11) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f10875v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean l11 = l(motionEvent.getX(), motionEvent.getY());
                boolean k11 = k(motionEvent.getX(), motionEvent.getY());
                if (l11 || k11) {
                    if (k11) {
                        this.f10876w = 1;
                        this.f10869p = (float) ((int) motionEvent.getX());
                    } else if (l11) {
                        this.f10876w = 2;
                        this.f10866m = (float) ((int) motionEvent.getY());
                    }
                    p(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f10875v == 2) {
                this.f10866m = 0.0f;
                this.f10869p = 0.0f;
                p(1);
                this.f10876w = 0;
            } else if (motionEvent.getAction() == 2 && this.f10875v == 2) {
                r();
                if (this.f10876w == 1) {
                    i(motionEvent.getX());
                }
                if (this.f10876w == 2) {
                    t(motionEvent.getY());
                }
            }
        }
    }

    public void p(int i11) {
        if (i11 == 2 && this.f10875v != 2) {
            this.f10856c.setState(D);
            b();
        }
        if (i11 == 0) {
            m();
        } else {
            r();
        }
        if (this.f10875v == 2 && i11 != 2) {
            this.f10856c.setState(E);
            n(1200);
        } else if (i11 == 1) {
            n(1500);
        }
        this.f10875v = i11;
    }

    public final void q() {
        this.f10872s.addItemDecoration(this);
        this.f10872s.addOnItemTouchListener(this);
        this.f10872s.addOnScrollListener(this.C);
    }

    public void r() {
        int i11 = this.A;
        if (i11 != 0) {
            if (i11 == 3) {
                this.f10879z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f10879z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f10879z.setDuration(500);
        this.f10879z.setStartDelay(0);
        this.f10879z.start();
    }

    public void s(int i11, int i12) {
        int computeVerticalScrollRange = this.f10872s.computeVerticalScrollRange();
        int i13 = this.f10871r;
        this.f10873t = computeVerticalScrollRange - i13 > 0 && i13 >= this.f10854a;
        int computeHorizontalScrollRange = this.f10872s.computeHorizontalScrollRange();
        int i14 = this.f10870q;
        boolean z11 = computeHorizontalScrollRange - i14 > 0 && i14 >= this.f10854a;
        this.f10874u = z11;
        boolean z12 = this.f10873t;
        if (z12 || z11) {
            if (z12) {
                float f11 = (float) i13;
                this.f10865l = (int) ((f11 * (((float) i12) + (f11 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f10864k = Math.min(i13, (i13 * i13) / computeVerticalScrollRange);
            }
            if (this.f10874u) {
                float f12 = (float) i14;
                this.f10868o = (int) ((f12 * (((float) i11) + (f12 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f10867n = Math.min(i14, (i14 * i14) / computeHorizontalScrollRange);
            }
            int i15 = this.f10875v;
            if (i15 == 0 || i15 == 1) {
                p(1);
            }
        } else if (this.f10875v != 0) {
            p(0);
        }
    }

    public final void t(float f11) {
        int[] g11 = g();
        float max = Math.max((float) g11[0], Math.min((float) g11[1], f11));
        if (Math.abs(((float) this.f10865l) - max) >= 2.0f) {
            int o11 = o(this.f10866m, max, g11, this.f10872s.computeVerticalScrollRange(), this.f10872s.computeVerticalScrollOffset(), this.f10871r);
            if (o11 != 0) {
                this.f10872s.scrollBy(0, o11);
            }
            this.f10866m = max;
        }
    }
}
