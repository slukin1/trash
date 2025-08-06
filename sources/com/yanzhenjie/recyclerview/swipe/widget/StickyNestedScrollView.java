package com.yanzhenjie.recyclerview.swipe.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StickyNestedScrollView extends NestedScrollView {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<View> f52699b;

    /* renamed from: c  reason: collision with root package name */
    public View f52700c;

    /* renamed from: d  reason: collision with root package name */
    public float f52701d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f52702e;

    /* renamed from: f  reason: collision with root package name */
    public int f52703f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52704g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52705h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52706i;

    /* renamed from: j  reason: collision with root package name */
    public int f52707j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f52708k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f52709l;

    /* renamed from: m  reason: collision with root package name */
    public List<b> f52710m;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (StickyNestedScrollView.this.f52700c != null) {
                StickyNestedScrollView stickyNestedScrollView = StickyNestedScrollView.this;
                int b11 = stickyNestedScrollView.j(stickyNestedScrollView.f52700c);
                StickyNestedScrollView stickyNestedScrollView2 = StickyNestedScrollView.this;
                int c11 = stickyNestedScrollView2.i(stickyNestedScrollView2.f52700c);
                StickyNestedScrollView stickyNestedScrollView3 = StickyNestedScrollView.this;
                StickyNestedScrollView.this.invalidate(b11, c11, stickyNestedScrollView3.k(stickyNestedScrollView3.f52700c), (int) (((float) StickyNestedScrollView.this.getScrollY()) + ((float) StickyNestedScrollView.this.f52700c.getHeight()) + StickyNestedScrollView.this.f52701d));
            }
            StickyNestedScrollView.this.postDelayed(this, 16);
        }
    }

    public interface b {
        void a(View view);

        void b(View view);
    }

    public StickyNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842880);
    }

    public void addView(View view) {
        super.addView(view);
        h(view);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f52700c != null) {
            canvas.save();
            canvas.translate((float) (getPaddingLeft() + this.f52703f), ((float) getScrollY()) + this.f52701d + ((float) (this.f52705h ? getPaddingTop() : 0)));
            canvas.clipRect(0.0f, this.f52705h ? -this.f52701d : 0.0f, (float) (getWidth() - this.f52703f), (float) (this.f52700c.getHeight() + this.f52707j + 1));
            if (this.f52708k != null) {
                this.f52708k.setBounds(0, this.f52700c.getHeight(), this.f52700c.getWidth(), this.f52700c.getHeight() + this.f52707j);
                this.f52708k.draw(canvas);
            }
            canvas.clipRect(0.0f, this.f52705h ? -this.f52701d : 0.0f, (float) getWidth(), (float) this.f52700c.getHeight());
            if (l(this.f52700c).contains("-hastransparency")) {
                q(this.f52700c);
                this.f52700c.draw(canvas);
                n(this.f52700c);
            } else {
                this.f52700c.draw(canvas);
            }
            canvas.restore();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z11 = true;
        if (motionEvent.getAction() == 0) {
            this.f52704g = true;
        }
        if (this.f52704g) {
            boolean z12 = this.f52700c != null;
            this.f52704g = z12;
            if (z12) {
                if (motionEvent.getY() > ((float) this.f52700c.getHeight()) + this.f52701d || motionEvent.getX() < ((float) j(this.f52700c)) || motionEvent.getX() > ((float) k(this.f52700c))) {
                    z11 = false;
                }
                this.f52704g = z11;
            }
        } else if (this.f52700c == null) {
            this.f52704g = false;
        }
        if (this.f52704g) {
            motionEvent.offsetLocation(0.0f, ((((float) getScrollY()) + this.f52701d) - ((float) m(this.f52700c))) * -1.0f);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final boolean f(View view) {
        if (!l(view).contains("sticky")) {
            return false;
        }
        this.f52699b.add(view);
        return true;
    }

    public final void g() {
        float f11;
        int i11;
        int i12;
        Iterator<View> it2 = this.f52699b.iterator();
        View view = null;
        View view2 = null;
        while (true) {
            int i13 = 0;
            if (!it2.hasNext()) {
                break;
            }
            View next = it2.next();
            int m11 = m(next) - getScrollY();
            if (this.f52705h) {
                i12 = 0;
            } else {
                i12 = getPaddingTop();
            }
            int i14 = m11 + i12;
            if (i14 <= 0) {
                if (view != null) {
                    int m12 = m(view) - getScrollY();
                    if (!this.f52705h) {
                        i13 = getPaddingTop();
                    }
                    if (i14 <= m12 + i13) {
                    }
                }
                view = next;
            } else {
                if (view2 != null) {
                    int m13 = m(view2) - getScrollY();
                    if (!this.f52705h) {
                        i13 = getPaddingTop();
                    }
                    if (i14 >= m13 + i13) {
                    }
                }
                view2 = next;
            }
        }
        if (view != null) {
            if (view2 == null) {
                f11 = 0.0f;
            } else {
                int m14 = m(view2) - getScrollY();
                if (this.f52705h) {
                    i11 = 0;
                } else {
                    i11 = getPaddingTop();
                }
                f11 = (float) Math.min(0, (m14 + i11) - view.getHeight());
            }
            this.f52701d = f11;
            View view3 = this.f52700c;
            if (view != view3) {
                if (view3 != null) {
                    List<b> list = this.f52710m;
                    if (list != null) {
                        for (b a11 : list) {
                            a11.a(this.f52700c);
                        }
                    }
                    s();
                }
                this.f52703f = j(view);
                r(view);
                List<b> list2 = this.f52710m;
                if (list2 != null) {
                    for (b b11 : list2) {
                        b11.b(this.f52700c);
                    }
                }
            }
        } else if (this.f52700c != null) {
            List<b> list3 = this.f52710m;
            if (list3 != null) {
                for (b a12 : list3) {
                    a12.a(this.f52700c);
                }
            }
            s();
        }
    }

    public final void h(View view) {
        if (!f(view) && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                h(viewGroup.getChildAt(i11));
            }
        }
    }

    public final int i(View view) {
        int bottom = view.getBottom();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            bottom += view.getBottom();
        }
        return bottom;
    }

    public final int j(View view) {
        int left = view.getLeft();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            left += view.getLeft();
        }
        return left;
    }

    public final int k(View view) {
        int right = view.getRight();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            right += view.getRight();
        }
        return right;
    }

    public final String l(View view) {
        return String.valueOf(view.getTag());
    }

    public final int m(View view) {
        int top = view.getTop();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            top += view.getTop();
        }
        return top;
    }

    public final void n(View view) {
        view.setAlpha(0.0f);
    }

    public final void o() {
        if (this.f52700c != null) {
            s();
        }
        this.f52699b.clear();
        h(getChildAt(0));
        g();
        invalidate();
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.f52702e);
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (!this.f52706i) {
            this.f52705h = true;
        }
        o();
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        g();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f52704g) {
            motionEvent.offsetLocation(0.0f, (((float) getScrollY()) + this.f52701d) - ((float) m(this.f52700c)));
        }
        if (motionEvent.getAction() == 0) {
            this.f52709l = false;
        }
        if (this.f52709l) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(0);
            super.onTouchEvent(obtain);
            this.f52709l = false;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.f52709l = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        this.f52699b = new ArrayList<>();
    }

    public final void q(View view) {
        view.setAlpha(1.0f);
    }

    public final void r(View view) {
        this.f52700c = view;
        if (view != null) {
            if (l(view).contains("-hastransparency")) {
                n(this.f52700c);
            }
            if (l(this.f52700c).contains("-nonconstant")) {
                post(this.f52702e);
            }
        }
    }

    public final void s() {
        if (l(this.f52700c).contains("-hastransparency")) {
            q(this.f52700c);
        }
        this.f52700c = null;
        removeCallbacks(this.f52702e);
    }

    public void setClipToPadding(boolean z11) {
        super.setClipToPadding(z11);
        this.f52705h = z11;
        this.f52706i = true;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f52708k = drawable;
    }

    public void setShadowHeight(int i11) {
        this.f52707j = i11;
    }

    public StickyNestedScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f52702e = new a();
        this.f52707j = 10;
        this.f52709l = true;
        p();
    }

    public void addView(View view, int i11) {
        super.addView(view, i11);
        h(view);
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        h(view);
    }

    public void addView(View view, int i11, int i12) {
        super.addView(view, i11, i12);
        h(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        h(view);
    }
}
