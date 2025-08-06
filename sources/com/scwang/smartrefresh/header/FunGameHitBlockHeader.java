package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import iy.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FunGameHitBlockHeader extends FunGameView {
    public float L;
    public float M;
    public float N;
    public Paint O;
    public float P;
    public float Q;
    public float R;
    public float S;
    public List<Point> T;
    public boolean U;
    public int V;
    public int W;

    /* renamed from: a0  reason: collision with root package name */
    public int f29533a0;

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context, attributeSet);
    }

    private void k(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FunGameHitBlockHeader);
        this.W = obtainStyledAttributes.getInt(R$styleable.FunGameHitBlockHeader_fgvBlockHorizontalNum, 3);
        this.f29533a0 = obtainStyledAttributes.getInt(R$styleable.FunGameHitBlockHeader_fgvBallSpeed, DensityUtil.b(3.0f));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.O = paint;
        paint.setStyle(Paint.Style.FILL);
        this.N = (float) DensityUtil.b(4.0f);
    }

    public final void A(Canvas canvas) {
        boolean z11;
        int i11 = 0;
        while (true) {
            int i12 = this.W;
            if (i11 < i12 * 5) {
                int i13 = i11 / i12;
                int i14 = i11 % i12;
                Iterator<Point> it2 = this.T.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().equals(i14, i13)) {
                            z11 = true;
                            break;
                        }
                    } else {
                        z11 = false;
                        break;
                    }
                }
                if (!z11) {
                    this.O.setColor(a.d(this.C, 255 / (i14 + 1)));
                    float f11 = this.P;
                    float f12 = this.M;
                    float f13 = f11 + (((float) i14) * (f12 + 1.0f));
                    float f14 = (float) i13;
                    float f15 = this.L;
                    float f16 = (f14 * (f15 + 1.0f)) + 1.0f;
                    canvas.drawRect(f13, f16, f13 + f12, f16 + f15, this.O);
                }
                i11++;
            } else {
                return;
            }
        }
    }

    public final void B(Canvas canvas) {
        this.f29676x.setColor(this.D);
        float f11 = this.Q;
        float f12 = this.f29678z;
        canvas.drawRect(f11, f12, f11 + this.M, f12 + ((float) this.A), this.f29676x);
    }

    public final void C(Canvas canvas, int i11) {
        this.f29676x.setColor(this.E);
        float f11 = this.R;
        float f12 = this.P;
        int i12 = this.W;
        if (f11 <= f12 + (((float) i12) * this.M) + (((float) (i12 - 1)) * 1.0f) + this.N && y(f11, this.S)) {
            this.U = false;
        }
        float f13 = this.R;
        float f14 = this.P;
        float f15 = this.N;
        if (f13 <= f14 + f15) {
            this.U = false;
        }
        float f16 = this.Q;
        if (f13 + f15 < f16 || f13 - f15 >= f16 + this.M) {
            if (f13 > ((float) i11)) {
                this.B = 2;
            }
        } else if (z(this.S)) {
            if (this.T.size() == this.W * 5) {
                this.B = 2;
                return;
            }
            this.U = true;
        }
        float f17 = this.S;
        float f18 = this.N;
        if (f17 <= f18 + 1.0f) {
            this.V = 150;
        } else if (f17 >= (((float) this.f29654c) - f18) - 1.0f) {
            this.V = 210;
        }
        if (this.U) {
            this.R -= (float) this.f29533a0;
        } else {
            this.R += (float) this.f29533a0;
        }
        float tan = f17 - (((float) Math.tan(Math.toRadians((double) this.V))) * ((float) this.f29533a0));
        this.S = tan;
        canvas.drawCircle(this.R, tan, this.N, this.f29676x);
        invalidate();
    }

    public void p(Canvas canvas, int i11, int i12) {
        A(canvas);
        B(canvas);
        int i13 = this.B;
        if (i13 == 1 || i13 == 3 || i13 == 4 || isInEditMode()) {
            C(canvas, i11);
        }
    }

    public void t() {
        int measuredWidth = getMeasuredWidth();
        this.A = (int) (this.L * 1.6f);
        float f11 = ((float) (this.f29654c / 5)) - 1.0f;
        this.L = f11;
        float f12 = (float) measuredWidth;
        this.M = 0.01806f * f12;
        this.P = 0.08f * f12;
        this.Q = f12 * 0.8f;
        this.A = (int) (f11 * 1.6f);
    }

    public void x() {
        this.R = this.Q - (this.N * 3.0f);
        this.S = (float) ((int) (((float) this.f29654c) * 0.5f));
        this.f29678z = 1.0f;
        this.V = 30;
        this.U = true;
        List<Point> list = this.T;
        if (list == null) {
            this.T = new ArrayList();
        } else {
            list.clear();
        }
    }

    public final boolean y(float f11, float f12) {
        int i11 = (int) ((((f11 - this.P) - this.N) - ((float) this.f29533a0)) / this.M);
        if (i11 == this.W) {
            i11--;
        }
        int i12 = (int) (f12 / this.L);
        if (i12 == 5) {
            i12--;
        }
        Point point = new Point();
        point.set(i11, i12);
        boolean z11 = false;
        Iterator<Point> it2 = this.T.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().equals(point.x, point.y)) {
                    z11 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z11) {
            this.T.add(point);
        }
        return !z11;
    }

    public final boolean z(float f11) {
        float f12 = f11 - this.f29678z;
        return f12 >= 0.0f && f12 <= ((float) this.A);
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        k(context, attributeSet);
    }
}
