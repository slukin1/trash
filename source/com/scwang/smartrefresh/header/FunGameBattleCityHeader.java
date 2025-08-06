package com.scwang.smartrefresh.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class FunGameBattleCityHeader extends FunGameView {

    /* renamed from: e0  reason: collision with root package name */
    public static int f29528e0 = 3;
    public SparseArray<Queue<RectF>> L;
    public Queue<Point> M;
    public Point N;
    public Random O;
    public float P;
    public int Q;
    public int R;
    public int S;
    public int T = 1;
    public int U = 4;
    public int V;
    public int W;

    /* renamed from: a0  reason: collision with root package name */
    public int f29529a0;

    /* renamed from: b0  reason: collision with root package name */
    public int f29530b0;

    /* renamed from: c0  reason: collision with root package name */
    public int f29531c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f29532d0 = true;

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean A(Point point) {
        int G = G(point.y);
        RectF rectF = (RectF) this.L.get(G).peek();
        if (rectF == null || !rectF.contains((float) point.x, (float) point.y)) {
            return false;
        }
        int i11 = this.f29531c0 + 1;
        this.f29531c0 = i11;
        if (i11 == this.f29530b0) {
            I();
        }
        this.L.get(G).poll();
        return true;
    }

    public final void B(Canvas canvas, Point point) {
        int i11 = point.x - this.U;
        point.x = i11;
        canvas.drawCircle((float) i11, (float) point.y, this.P, this.f29676x);
    }

    public final void C(Canvas canvas, int i11) {
        this.f29676x.setColor(this.C);
        int i12 = this.V + this.T;
        this.V = i12;
        if (i12 / this.Q == 1 || this.f29532d0) {
            this.V = 0;
            this.f29532d0 = false;
        }
        int y11 = y();
        boolean z11 = false;
        for (int i13 = 0; i13 < f29528e0; i13++) {
            Queue queue = this.L.get(i13);
            if (this.V == 0 && i13 == y11) {
                queue.offer(F(i13));
            }
            Iterator it2 = queue.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                RectF rectF = (RectF) it2.next();
                if (rectF.left >= ((float) i11)) {
                    int i14 = this.f29529a0 + 1;
                    this.f29529a0 = i14;
                    if (i14 >= 8) {
                        this.B = 2;
                        z11 = true;
                        break;
                    }
                    z11 = true;
                } else {
                    E(canvas, rectF);
                }
            }
            if (this.B == 2) {
                break;
            }
            if (z11) {
                queue.poll();
                z11 = false;
            }
        }
        invalidate();
    }

    public final void D(Canvas canvas, int i11) {
        this.f29676x.setColor(this.D);
        boolean z11 = z(G((int) this.f29678z), (float) (i11 - this.A), this.f29678z);
        int G = G((int) (this.f29678z + ((float) this.A)));
        int i12 = this.A;
        boolean z12 = z(G, (float) (i11 - i12), this.f29678z + ((float) i12));
        if (z11 || z12) {
            this.B = 2;
        }
        int i13 = this.A;
        float f11 = this.f29678z;
        float f12 = this.f29664m;
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) (i11 - i13), f11 + f12, (float) i11, f11 + ((float) i13) + f12, this.f29676x);
        int i14 = this.A;
        int i15 = this.S;
        float f13 = this.f29678z;
        Canvas canvas3 = canvas;
        canvas3.drawRect((float) ((i11 - i14) - i15), f13 + (((float) (i14 - i15)) * 0.5f), (float) (i11 - i14), f13 + (((float) (i14 - i15)) * 0.5f) + ((float) i15), this.f29676x);
    }

    public final void E(Canvas canvas, RectF rectF) {
        float f11 = rectF.left;
        int i11 = this.T;
        rectF.set(f11 + ((float) i11), rectF.top, rectF.right + ((float) i11), rectF.bottom);
        canvas.drawRect(rectF, this.f29676x);
        float f12 = rectF.top;
        int i12 = this.A;
        int i13 = this.S;
        float f13 = f12 + (((float) (i12 - i13)) * 0.5f);
        float f14 = rectF.right;
        canvas.drawRect(f14, f13, f14 + ((float) i13), f13 + ((float) i13), this.f29676x);
    }

    public final RectF F(int i11) {
        int i12 = this.A;
        float f11 = (float) (-(this.S + i12));
        float f12 = ((float) (i11 * i12)) + this.f29664m;
        return new RectF(f11, f12, (((float) this.S) * 2.5f) + f11, ((float) this.A) + f12);
    }

    public final int G(int i11) {
        int i12 = this.f29654c;
        int i13 = f29528e0;
        int i14 = i11 / (i12 / i13);
        if (i14 >= i13) {
            i14 = i13 - 1;
        }
        if (i14 < 0) {
            return 0;
        }
        return i14;
    }

    public final void H(Canvas canvas, int i11) {
        this.f29676x.setColor(this.E);
        int i12 = this.W + this.U;
        this.W = i12;
        boolean z11 = false;
        if (i12 / this.R == 1) {
            this.W = 0;
        }
        if (this.W == 0) {
            Point point = new Point();
            int i13 = this.A;
            point.x = (i11 - i13) - this.S;
            point.y = (int) (this.f29678z + (((float) i13) * 0.5f));
            this.M.offer(point);
        }
        for (Point point2 : this.M) {
            if (A(point2)) {
                this.N = point2;
            } else {
                if (((float) point2.x) + this.P <= 0.0f) {
                    z11 = true;
                }
                B(canvas, point2);
            }
        }
        if (z11) {
            this.M.poll();
        }
        this.M.remove(this.N);
        this.N = null;
    }

    public final void I() {
        this.f29530b0 += 8;
        this.T += DensityUtil.b(1.0f);
        this.U += DensityUtil.b(1.0f);
        this.f29531c0 = 0;
        int i11 = this.Q;
        if (i11 > 12) {
            this.Q = i11 - 12;
        }
        int i12 = this.R;
        if (i12 > 30) {
            this.R = i12 - 30;
        }
    }

    public void p(Canvas canvas, int i11, int i12) {
        D(canvas, i11);
        int i13 = this.B;
        if (i13 == 1 || i13 == 3 || i13 == 4) {
            C(canvas, i11);
            H(canvas, i11);
        }
        if (isInEditMode()) {
            int i14 = this.A;
            E(canvas, new RectF((float) i14, 0.0f, (float) (i14 * 2), (float) i14));
            int i15 = this.A;
            E(canvas, new RectF(0.0f, (float) i15, (float) i15, (float) (i15 * 2)));
            int i16 = this.A;
            E(canvas, new RectF((float) (i16 * 3), (float) (i16 * 2), (float) (i16 * 4), (float) (i16 * 3)));
        }
    }

    public void t() {
        this.O = new Random();
        int i11 = this.f29654c / f29528e0;
        this.A = i11;
        int floor = (int) Math.floor((double) ((((float) i11) * 0.33333334f) + 0.5f));
        this.S = floor;
        this.P = (((float) floor) - (this.f29664m * 2.0f)) * 0.5f;
        x();
    }

    public void x() {
        this.B = 0;
        this.f29678z = this.f29664m;
        this.T = DensityUtil.b(1.0f);
        this.U = DensityUtil.b(4.0f);
        this.f29530b0 = 8;
        this.f29531c0 = 0;
        this.f29532d0 = true;
        this.Q = this.A + this.S + 60;
        this.R = 360;
        this.L = new SparseArray<>();
        for (int i11 = 0; i11 < f29528e0; i11++) {
            this.L.put(i11, new LinkedList());
        }
        this.M = new LinkedList();
    }

    public final int y() {
        return this.O.nextInt(f29528e0);
    }

    public final boolean z(int i11, float f11, float f12) {
        RectF rectF = (RectF) this.L.get(i11).peek();
        return rectF != null && rectF.contains(f11, f12);
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
