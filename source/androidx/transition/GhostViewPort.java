package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.h0;
import v1.c;
import v1.u;

@SuppressLint({"ViewConstructor"})
class GhostViewPort extends ViewGroup implements c {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f11817b;

    /* renamed from: c  reason: collision with root package name */
    public View f11818c;

    /* renamed from: d  reason: collision with root package name */
    public final View f11819d;

    /* renamed from: e  reason: collision with root package name */
    public int f11820e;

    /* renamed from: f  reason: collision with root package name */
    public Matrix f11821f;

    /* renamed from: g  reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f11822g = new a();

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        public boolean onPreDraw() {
            View view;
            h0.n0(GhostViewPort.this);
            GhostViewPort ghostViewPort = GhostViewPort.this;
            ViewGroup viewGroup = ghostViewPort.f11817b;
            if (viewGroup == null || (view = ghostViewPort.f11818c) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            h0.n0(GhostViewPort.this.f11817b);
            GhostViewPort ghostViewPort2 = GhostViewPort.this;
            ghostViewPort2.f11817b = null;
            ghostViewPort2.f11818c = null;
            return true;
        }
    }

    public GhostViewPort(View view) {
        super(view.getContext());
        this.f11819d = view;
        setWillNotDraw(false);
        setLayerType(2, (Paint) null);
    }

    public static GhostViewPort b(View view, ViewGroup viewGroup, Matrix matrix) {
        GhostViewHolder ghostViewHolder;
        if (view.getParent() instanceof ViewGroup) {
            GhostViewHolder b11 = GhostViewHolder.b(viewGroup);
            GhostViewPort e11 = e(view);
            int i11 = 0;
            if (!(e11 == null || (ghostViewHolder = (GhostViewHolder) e11.getParent()) == b11)) {
                i11 = e11.f11820e;
                ghostViewHolder.removeView(e11);
                e11 = null;
            }
            if (e11 == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    c(view, viewGroup, matrix);
                }
                e11 = new GhostViewPort(view);
                e11.h(matrix);
                if (b11 == null) {
                    b11 = new GhostViewHolder(viewGroup);
                } else {
                    b11.g();
                }
                d(viewGroup, b11);
                d(viewGroup, e11);
                b11.a(e11);
                e11.f11820e = i11;
            } else if (matrix != null) {
                e11.h(matrix);
            }
            e11.f11820e++;
            return e11;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    public static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        u.j(viewGroup2, matrix);
        matrix.preTranslate((float) (-viewGroup2.getScrollX()), (float) (-viewGroup2.getScrollY()));
        u.k(viewGroup, matrix);
    }

    public static void d(View view, View view2) {
        u.g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    public static GhostViewPort e(View view) {
        return (GhostViewPort) view.getTag(R$id.ghost_view);
    }

    public static void f(View view) {
        GhostViewPort e11 = e(view);
        if (e11 != null) {
            int i11 = e11.f11820e - 1;
            e11.f11820e = i11;
            if (i11 <= 0) {
                ((GhostViewHolder) e11.getParent()).removeView(e11);
            }
        }
    }

    public static void g(View view, GhostViewPort ghostViewPort) {
        view.setTag(R$id.ghost_view, ghostViewPort);
    }

    public void a(ViewGroup viewGroup, View view) {
        this.f11817b = viewGroup;
        this.f11818c = view;
    }

    public void h(Matrix matrix) {
        this.f11821f = matrix;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(this.f11819d, this);
        this.f11819d.getViewTreeObserver().addOnPreDrawListener(this.f11822g);
        u.i(this.f11819d, 4);
        if (this.f11819d.getParent() != null) {
            ((View) this.f11819d.getParent()).invalidate();
        }
    }

    public void onDetachedFromWindow() {
        this.f11819d.getViewTreeObserver().removeOnPreDrawListener(this.f11822g);
        u.i(this.f11819d, 0);
        g(this.f11819d, (GhostViewPort) null);
        if (this.f11819d.getParent() != null) {
            ((View) this.f11819d.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        v1.a.a(canvas, true);
        canvas.setMatrix(this.f11821f);
        u.i(this.f11819d, 0);
        this.f11819d.invalidate();
        u.i(this.f11819d, 4);
        drawChild(canvas, this.f11819d, getDrawingTime());
        v1.a.a(canvas, false);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        if (e(this.f11819d) == this) {
            u.i(this.f11819d, i11 == 0 ? 4 : 0);
        }
    }
}
