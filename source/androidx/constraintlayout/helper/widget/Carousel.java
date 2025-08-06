package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.e;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

public class Carousel extends MotionHelper {
    public int A = 0;
    public int B = 4;
    public int C = 1;
    public float D = 2.0f;
    public int E = -1;
    public int F = 200;
    public int G = -1;
    public Runnable H = new a();

    /* renamed from: o  reason: collision with root package name */
    public b f7317o = null;

    /* renamed from: p  reason: collision with root package name */
    public final ArrayList<View> f7318p = new ArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    public int f7319q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f7320r = 0;

    /* renamed from: s  reason: collision with root package name */
    public MotionLayout f7321s;

    /* renamed from: t  reason: collision with root package name */
    public int f7322t = -1;

    /* renamed from: u  reason: collision with root package name */
    public boolean f7323u = false;

    /* renamed from: v  reason: collision with root package name */
    public int f7324v = -1;

    /* renamed from: w  reason: collision with root package name */
    public int f7325w = -1;

    /* renamed from: x  reason: collision with root package name */
    public int f7326x = -1;

    /* renamed from: y  reason: collision with root package name */
    public int f7327y = -1;

    /* renamed from: z  reason: collision with root package name */
    public float f7328z = 0.9f;

    public class a implements Runnable {

        /* renamed from: androidx.constraintlayout.helper.widget.Carousel$a$a  reason: collision with other inner class name */
        public class C0018a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ float f7330b;

            public C0018a(float f11) {
                this.f7330b = f11;
            }

            public void run() {
                Carousel.this.f7321s.r0(5, 1.0f, this.f7330b);
            }
        }

        public a() {
        }

        public void run() {
            Carousel.this.f7321s.setProgress(0.0f);
            Carousel.this.N();
            Carousel.this.f7317o.a(Carousel.this.f7320r);
            float velocity = Carousel.this.f7321s.getVelocity();
            if (Carousel.this.C == 2 && velocity > Carousel.this.D && Carousel.this.f7320r < Carousel.this.f7317o.c() - 1) {
                float I = velocity * Carousel.this.f7328z;
                if (Carousel.this.f7320r == 0 && Carousel.this.f7319q > Carousel.this.f7320r) {
                    return;
                }
                if (Carousel.this.f7320r != Carousel.this.f7317o.c() - 1 || Carousel.this.f7319q >= Carousel.this.f7320r) {
                    Carousel.this.f7321s.post(new C0018a(I));
                }
            }
        }
    }

    public interface b {
        void a(int i11);

        void b(View view, int i11);

        int c();
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        L(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f7321s.setTransitionDuration(this.F);
        if (this.E < this.f7320r) {
            this.f7321s.w0(this.f7326x, this.F);
        } else {
            this.f7321s.w0(this.f7327y, this.F);
        }
    }

    public final boolean K(int i11, boolean z11) {
        MotionLayout motionLayout;
        e.b e02;
        if (i11 == -1 || (motionLayout = this.f7321s) == null || (e02 = motionLayout.e0(i11)) == null || z11 == e02.C()) {
            return false;
        }
        e02.F(z11);
        return true;
    }

    public final void L(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.Carousel_carousel_firstView) {
                    this.f7322t = obtainStyledAttributes.getResourceId(index, this.f7322t);
                } else if (index == R$styleable.Carousel_carousel_backwardTransition) {
                    this.f7324v = obtainStyledAttributes.getResourceId(index, this.f7324v);
                } else if (index == R$styleable.Carousel_carousel_forwardTransition) {
                    this.f7325w = obtainStyledAttributes.getResourceId(index, this.f7325w);
                } else if (index == R$styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.B = obtainStyledAttributes.getInt(index, this.B);
                } else if (index == R$styleable.Carousel_carousel_previousState) {
                    this.f7326x = obtainStyledAttributes.getResourceId(index, this.f7326x);
                } else if (index == R$styleable.Carousel_carousel_nextState) {
                    this.f7327y = obtainStyledAttributes.getResourceId(index, this.f7327y);
                } else if (index == R$styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.f7328z = obtainStyledAttributes.getFloat(index, this.f7328z);
                } else if (index == R$styleable.Carousel_carousel_touchUpMode) {
                    this.C = obtainStyledAttributes.getInt(index, this.C);
                } else if (index == R$styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.D = obtainStyledAttributes.getFloat(index, this.D);
                } else if (index == R$styleable.Carousel_carousel_infinite) {
                    this.f7323u = obtainStyledAttributes.getBoolean(index, this.f7323u);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void N() {
        b bVar = this.f7317o;
        if (bVar != null && this.f7321s != null && bVar.c() != 0) {
            int size = this.f7318p.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = this.f7318p.get(i11);
                int i12 = (this.f7320r + i11) - this.A;
                if (this.f7323u) {
                    if (i12 < 0) {
                        int i13 = this.B;
                        if (i13 != 4) {
                            P(view, i13);
                        } else {
                            P(view, 0);
                        }
                        if (i12 % this.f7317o.c() == 0) {
                            this.f7317o.b(view, 0);
                        } else {
                            b bVar2 = this.f7317o;
                            bVar2.b(view, bVar2.c() + (i12 % this.f7317o.c()));
                        }
                    } else if (i12 >= this.f7317o.c()) {
                        if (i12 == this.f7317o.c()) {
                            i12 = 0;
                        } else if (i12 > this.f7317o.c()) {
                            i12 %= this.f7317o.c();
                        }
                        int i14 = this.B;
                        if (i14 != 4) {
                            P(view, i14);
                        } else {
                            P(view, 0);
                        }
                        this.f7317o.b(view, i12);
                    } else {
                        P(view, 0);
                        this.f7317o.b(view, i12);
                    }
                } else if (i12 < 0) {
                    P(view, this.B);
                } else if (i12 >= this.f7317o.c()) {
                    P(view, this.B);
                } else {
                    P(view, 0);
                    this.f7317o.b(view, i12);
                }
            }
            int i15 = this.E;
            if (i15 != -1 && i15 != this.f7320r) {
                this.f7321s.post(new m0.a(this));
            } else if (i15 == this.f7320r) {
                this.E = -1;
            }
            if (this.f7324v == -1 || this.f7325w == -1) {
                Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
            } else if (!this.f7323u) {
                int c11 = this.f7317o.c();
                if (this.f7320r == 0) {
                    K(this.f7324v, false);
                } else {
                    K(this.f7324v, true);
                    this.f7321s.setTransition(this.f7324v);
                }
                if (this.f7320r == c11 - 1) {
                    K(this.f7325w, false);
                    return;
                }
                K(this.f7325w, true);
                this.f7321s.setTransition(this.f7325w);
            }
        }
    }

    public final boolean O(int i11, View view, int i12) {
        ConstraintSet.Constraint w11;
        ConstraintSet c02 = this.f7321s.c0(i11);
        if (c02 == null || (w11 = c02.w(view.getId())) == null) {
            return false;
        }
        w11.f7998c.f8076c = 1;
        view.setVisibility(i12);
        return true;
    }

    public final boolean P(View view, int i11) {
        MotionLayout motionLayout = this.f7321s;
        if (motionLayout == null) {
            return false;
        }
        int[] constraintSetIds = motionLayout.getConstraintSetIds();
        boolean z11 = false;
        for (int O : constraintSetIds) {
            z11 |= O(O, view, i11);
        }
        return z11;
    }

    public int getCount() {
        b bVar = this.f7317o;
        if (bVar != null) {
            return bVar.c();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.f7320r;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i11 = 0; i11 < this.f7920c; i11++) {
                int i12 = this.f7919b[i11];
                View viewById = motionLayout.getViewById(i12);
                if (this.f7322t == i12) {
                    this.A = i11;
                }
                this.f7318p.add(viewById);
            }
            this.f7321s = motionLayout;
            if (this.C == 2) {
                e.b e02 = motionLayout.e0(this.f7325w);
                if (e02 != null) {
                    e02.H(5);
                }
                e.b e03 = this.f7321s.e0(this.f7324v);
                if (e03 != null) {
                    e03.H(5);
                }
            }
            N();
        }
    }

    public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
        this.G = i11;
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
        int i12 = this.f7320r;
        this.f7319q = i12;
        if (i11 == this.f7327y) {
            this.f7320r = i12 + 1;
        } else if (i11 == this.f7326x) {
            this.f7320r = i12 - 1;
        }
        if (this.f7323u) {
            if (this.f7320r >= this.f7317o.c()) {
                this.f7320r = 0;
            }
            if (this.f7320r < 0) {
                this.f7320r = this.f7317o.c() - 1;
            }
        } else {
            if (this.f7320r >= this.f7317o.c()) {
                this.f7320r = this.f7317o.c() - 1;
            }
            if (this.f7320r < 0) {
                this.f7320r = 0;
            }
        }
        if (this.f7319q != this.f7320r) {
            this.f7321s.post(this.H);
        }
    }

    public void setAdapter(b bVar) {
        this.f7317o = bVar;
    }

    public Carousel(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        L(context, attributeSet);
    }
}
