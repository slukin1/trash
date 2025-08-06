package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.h0;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public boolean f4215b;

    /* renamed from: c  reason: collision with root package name */
    public View f4216c;

    /* renamed from: d  reason: collision with root package name */
    public View f4217d;

    /* renamed from: e  reason: collision with root package name */
    public View f4218e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f4219f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f4220g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f4221h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4222i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4223j;

    /* renamed from: k  reason: collision with root package name */
    public int f4224k;

    public static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h0.B0(this, new a(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f4219f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f4220g = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f4224k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z11 = true;
        if (getId() == R$id.split_action_bar) {
            this.f4222i = true;
            this.f4221h = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f4222i ? !(this.f4219f == null && this.f4220g == null) : this.f4221h != null) {
            z11 = false;
        }
        setWillNotDraw(z11);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4219f;
        if (drawable != null && drawable.isStateful()) {
            this.f4219f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f4220g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f4220g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f4221h;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f4221h.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f4216c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4219f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f4220g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f4221h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f4217d = findViewById(R$id.action_bar);
        this.f4218e = findViewById(R$id.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f4215b || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            super.onLayout(r5, r6, r7, r8, r9)
            android.view.View r5 = r4.f4216c
            r7 = 8
            r9 = 1
            r0 = 0
            if (r5 == 0) goto L_0x0013
            int r1 = r5.getVisibility()
            if (r1 == r7) goto L_0x0013
            r1 = r9
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r5 == 0) goto L_0x0033
            int r2 = r5.getVisibility()
            if (r2 == r7) goto L_0x0033
            int r7 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r5.getMeasuredHeight()
            int r3 = r7 - r3
            int r2 = r2.bottomMargin
            int r3 = r3 - r2
            int r7 = r7 - r2
            r5.layout(r6, r3, r8, r7)
        L_0x0033:
            boolean r6 = r4.f4222i
            if (r6 == 0) goto L_0x004b
            android.graphics.drawable.Drawable r5 = r4.f4221h
            if (r5 == 0) goto L_0x0048
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto L_0x00be
        L_0x0048:
            r9 = r0
            goto L_0x00be
        L_0x004b:
            android.graphics.drawable.Drawable r6 = r4.f4219f
            if (r6 == 0) goto L_0x00a3
            android.view.View r6 = r4.f4217d
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x0075
            android.graphics.drawable.Drawable r6 = r4.f4219f
            android.view.View r7 = r4.f4217d
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f4217d
            int r8 = r8.getTop()
            android.view.View r0 = r4.f4217d
            int r0 = r0.getRight()
            android.view.View r2 = r4.f4217d
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto L_0x00a2
        L_0x0075:
            android.view.View r6 = r4.f4218e
            if (r6 == 0) goto L_0x009d
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x009d
            android.graphics.drawable.Drawable r6 = r4.f4219f
            android.view.View r7 = r4.f4218e
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f4218e
            int r8 = r8.getTop()
            android.view.View r0 = r4.f4218e
            int r0 = r0.getRight()
            android.view.View r2 = r4.f4218e
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto L_0x00a2
        L_0x009d:
            android.graphics.drawable.Drawable r6 = r4.f4219f
            r6.setBounds(r0, r0, r0, r0)
        L_0x00a2:
            r0 = r9
        L_0x00a3:
            r4.f4223j = r1
            if (r1 == 0) goto L_0x0048
            android.graphics.drawable.Drawable r6 = r4.f4220g
            if (r6 == 0) goto L_0x0048
            int r7 = r5.getLeft()
            int r8 = r5.getTop()
            int r0 = r5.getRight()
            int r5 = r5.getBottom()
            r6.setBounds(r7, r8, r0, r5)
        L_0x00be:
            if (r9 == 0) goto L_0x00c3
            r4.invalidate()
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        if (this.f4217d == null && View.MeasureSpec.getMode(i12) == Integer.MIN_VALUE && (i14 = this.f4224k) >= 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(Math.min(i14, View.MeasureSpec.getSize(i12)), Integer.MIN_VALUE);
        }
        super.onMeasure(i11, i12);
        if (this.f4217d != null) {
            int mode = View.MeasureSpec.getMode(i12);
            View view = this.f4216c;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f4217d)) {
                    i13 = a(this.f4217d);
                } else {
                    i13 = !b(this.f4218e) ? a(this.f4218e) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i13 + a(this.f4216c), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i12) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f4219f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f4219f);
        }
        this.f4219f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f4217d;
            if (view != null) {
                this.f4219f.setBounds(view.getLeft(), this.f4217d.getTop(), this.f4217d.getRight(), this.f4217d.getBottom());
            }
        }
        boolean z11 = true;
        if (!this.f4222i ? !(this.f4219f == null && this.f4220g == null) : this.f4221h != null) {
            z11 = false;
        }
        setWillNotDraw(z11);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f4221h;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f4221h);
        }
        this.f4221h = drawable;
        boolean z11 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f4222i && (drawable2 = this.f4221h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f4222i ? this.f4219f == null && this.f4220g == null : this.f4221h == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f4220g;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f4220g);
        }
        this.f4220g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f4223j && (drawable2 = this.f4220g) != null) {
                drawable2.setBounds(this.f4216c.getLeft(), this.f4216c.getTop(), this.f4216c.getRight(), this.f4216c.getBottom());
            }
        }
        boolean z11 = true;
        if (!this.f4222i ? !(this.f4219f == null && this.f4220g == null) : this.f4221h != null) {
            z11 = false;
        }
        setWillNotDraw(z11);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f4216c;
        if (view != null) {
            removeView(view);
        }
        this.f4216c = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z11) {
        this.f4215b = z11;
        setDescendantFocusability(z11 ? 393216 : 262144);
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z11 = i11 == 0;
        Drawable drawable = this.f4219f;
        if (drawable != null) {
            drawable.setVisible(z11, false);
        }
        Drawable drawable2 = this.f4220g;
        if (drawable2 != null) {
            drawable2.setVisible(z11, false);
        }
        Drawable drawable3 = this.f4221h;
        if (drawable3 != null) {
            drawable3.setVisible(z11, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i11) {
        if (i11 != 0) {
            return super.startActionModeForChild(view, callback, i11);
        }
        return null;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f4219f && !this.f4222i) || (drawable == this.f4220g && this.f4223j) || ((drawable == this.f4221h && this.f4222i) || super.verifyDrawable(drawable));
    }
}
