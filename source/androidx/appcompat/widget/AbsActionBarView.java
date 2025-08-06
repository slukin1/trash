package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.view.h0;
import androidx.core.view.n0;
import androidx.core.view.o0;

abstract class AbsActionBarView extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public final a f4204b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f4205c;

    /* renamed from: d  reason: collision with root package name */
    public ActionMenuView f4206d;

    /* renamed from: e  reason: collision with root package name */
    public ActionMenuPresenter f4207e;

    /* renamed from: f  reason: collision with root package name */
    public int f4208f;

    /* renamed from: g  reason: collision with root package name */
    public n0 f4209g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4210h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4211i;

    public class a implements o0 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4212a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f4213b;

        public a() {
        }

        public void a(View view) {
            this.f4212a = true;
        }

        public void b(View view) {
            if (!this.f4212a) {
                AbsActionBarView absActionBarView = AbsActionBarView.this;
                absActionBarView.f4209g = null;
                AbsActionBarView.super.setVisibility(this.f4213b);
            }
        }

        public void c(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f4212a = false;
        }

        public a d(n0 n0Var, int i11) {
            AbsActionBarView.this.f4209g = n0Var;
            this.f4213b = i11;
            return this;
        }
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int d(int i11, int i12, boolean z11) {
        return z11 ? i11 - i12 : i11 + i12;
    }

    public int c(View view, int i11, int i12, int i13) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE), i12);
        return Math.max(0, (i11 - view.getMeasuredWidth()) - i13);
    }

    public int e(View view, int i11, int i12, int i13, boolean z11) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i14 = i12 + ((i13 - measuredHeight) / 2);
        if (z11) {
            view.layout(i11 - measuredWidth, i14, i11, measuredHeight + i14);
        } else {
            view.layout(i11, i14, i11 + measuredWidth, measuredHeight + i14);
        }
        return z11 ? -measuredWidth : measuredWidth;
    }

    public n0 f(int i11, long j11) {
        n0 n0Var = this.f4209g;
        if (n0Var != null) {
            n0Var.c();
        }
        if (i11 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            n0 b11 = h0.e(this).b(1.0f);
            b11.h(j11);
            b11.j(this.f4204b.d(b11, i11));
            return b11;
        }
        n0 b12 = h0.e(this).b(0.0f);
        b12.h(j11);
        b12.j(this.f4204b.d(b12, i11));
        return b12;
    }

    public int getAnimatedVisibility() {
        if (this.f4209g != null) {
            return this.f4204b.f4213b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f4208f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f4207e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.y(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f4211i = false;
        }
        if (!this.f4211i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f4211i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f4211i = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4210h = false;
        }
        if (!this.f4210h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f4210h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f4210h = false;
        }
        return true;
    }

    public void setContentHeight(int i11) {
        this.f4208f = i11;
        requestLayout();
    }

    public void setVisibility(int i11) {
        if (i11 != getVisibility()) {
            n0 n0Var = this.f4209g;
            if (n0Var != null) {
                n0Var.c();
            }
            super.setVisibility(i11);
        }
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f4204b = new a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f4205c = context;
        } else {
            this.f4205c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
