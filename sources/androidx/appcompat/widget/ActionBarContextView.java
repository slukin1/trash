package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.e;
import androidx.core.view.h0;
import androidx.core.view.n0;

public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f4225j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f4226k;

    /* renamed from: l  reason: collision with root package name */
    public View f4227l;

    /* renamed from: m  reason: collision with root package name */
    public View f4228m;

    /* renamed from: n  reason: collision with root package name */
    public View f4229n;

    /* renamed from: o  reason: collision with root package name */
    public LinearLayout f4230o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f4231p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f4232q;

    /* renamed from: r  reason: collision with root package name */
    public int f4233r;

    /* renamed from: s  reason: collision with root package name */
    public int f4234s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f4235t;

    /* renamed from: u  reason: collision with root package name */
    public int f4236u;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ActionMode f4237b;

        public a(ActionMode actionMode) {
            this.f4237b = actionMode;
        }

        public void onClick(View view) {
            this.f4237b.a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public /* bridge */ /* synthetic */ n0 f(int i11, long j11) {
        return super.f(i11, j11);
    }

    public void g() {
        if (this.f4227l == null) {
            k();
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f4226k;
    }

    public CharSequence getTitle() {
        return this.f4225j;
    }

    public void h(ActionMode actionMode) {
        View view = this.f4227l;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f4236u, this, false);
            this.f4227l = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f4227l);
        }
        View findViewById = this.f4227l.findViewById(R$id.action_mode_close_button);
        this.f4228m = findViewById;
        findViewById.setOnClickListener(new a(actionMode));
        e eVar = (e) actionMode.c();
        ActionMenuPresenter actionMenuPresenter = this.f4207e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.r();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f4207e = actionMenuPresenter2;
        actionMenuPresenter2.C(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        eVar.addMenuPresenter(this.f4207e, this.f4205c);
        ActionMenuView actionMenuView = (ActionMenuView) this.f4207e.h(this);
        this.f4206d = actionMenuView;
        h0.B0(actionMenuView, (Drawable) null);
        addView(this.f4206d, layoutParams);
    }

    public final void i() {
        if (this.f4230o == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f4230o = linearLayout;
            this.f4231p = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.f4232q = (TextView) this.f4230o.findViewById(R$id.action_bar_subtitle);
            if (this.f4233r != 0) {
                this.f4231p.setTextAppearance(getContext(), this.f4233r);
            }
            if (this.f4234s != 0) {
                this.f4232q.setTextAppearance(getContext(), this.f4234s);
            }
        }
        this.f4231p.setText(this.f4225j);
        this.f4232q.setText(this.f4226k);
        boolean z11 = !TextUtils.isEmpty(this.f4225j);
        boolean z12 = !TextUtils.isEmpty(this.f4226k);
        int i11 = 0;
        this.f4232q.setVisibility(z12 ? 0 : 8);
        LinearLayout linearLayout2 = this.f4230o;
        if (!z11 && !z12) {
            i11 = 8;
        }
        linearLayout2.setVisibility(i11);
        if (this.f4230o.getParent() == null) {
            addView(this.f4230o);
        }
    }

    public boolean j() {
        return this.f4235t;
    }

    public void k() {
        removeAllViews();
        this.f4229n = null;
        this.f4206d = null;
        this.f4207e = null;
        View view = this.f4228m;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean l() {
        ActionMenuPresenter actionMenuPresenter = this.f4207e;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.D();
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f4207e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.u();
            this.f4207e.v();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        boolean b11 = o0.b(this);
        int paddingRight = b11 ? (i13 - i11) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i14 - i12) - getPaddingTop()) - getPaddingBottom();
        View view = this.f4227l;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4227l.getLayoutParams();
            int i15 = b11 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i16 = b11 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d11 = AbsActionBarView.d(paddingRight, i15, b11);
            paddingRight = AbsActionBarView.d(d11 + e(this.f4227l, d11, paddingTop, paddingTop2, b11), i16, b11);
        }
        int i17 = paddingRight;
        LinearLayout linearLayout = this.f4230o;
        if (!(linearLayout == null || this.f4229n != null || linearLayout.getVisibility() == 8)) {
            i17 += e(this.f4230o, i17, paddingTop, paddingTop2, b11);
        }
        int i18 = i17;
        View view2 = this.f4229n;
        if (view2 != null) {
            e(view2, i18, paddingTop, paddingTop2, b11);
        }
        int paddingLeft = b11 ? getPaddingLeft() : (i13 - i11) - getPaddingRight();
        ActionMenuView actionMenuView = this.f4206d;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b11);
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13 = 1073741824;
        if (View.MeasureSpec.getMode(i11) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i12) != 0) {
            int size = View.MeasureSpec.getSize(i11);
            int i14 = this.f4208f;
            if (i14 <= 0) {
                i14 = View.MeasureSpec.getSize(i12);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i15 = i14 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15, Integer.MIN_VALUE);
            View view = this.f4227l;
            if (view != null) {
                int c11 = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4227l.getLayoutParams();
                paddingLeft = c11 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f4206d;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.f4206d, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f4230o;
            if (linearLayout != null && this.f4229n == null) {
                if (this.f4235t) {
                    this.f4230o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f4230o.getMeasuredWidth();
                    boolean z11 = measuredWidth <= paddingLeft;
                    if (z11) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f4230o.setVisibility(z11 ? 0 : 8);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f4229n;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i16 = layoutParams.width;
                int i17 = i16 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (i16 >= 0) {
                    paddingLeft = Math.min(i16, paddingLeft);
                }
                int i18 = layoutParams.height;
                if (i18 == -2) {
                    i13 = Integer.MIN_VALUE;
                }
                if (i18 >= 0) {
                    i15 = Math.min(i18, i15);
                }
                this.f4229n.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i17), View.MeasureSpec.makeMeasureSpec(i15, i13));
            }
            if (this.f4208f <= 0) {
                int childCount = getChildCount();
                int i19 = 0;
                for (int i21 = 0; i21 < childCount; i21++) {
                    int measuredHeight = getChildAt(i21).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i19) {
                        i19 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i19);
                return;
            }
            setMeasuredDimension(size, i14);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i11) {
        this.f4208f = i11;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f4229n;
        if (view2 != null) {
            removeView(view2);
        }
        this.f4229n = view;
        if (!(view == null || (linearLayout = this.f4230o) == null)) {
            removeView(linearLayout);
            this.f4230o = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f4226k = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f4225j = charSequence;
        i();
        h0.A0(this, charSequence);
    }

    public void setTitleOptional(boolean z11) {
        if (z11 != this.f4235t) {
            requestLayout();
        }
        this.f4235t = z11;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i11) {
        super.setVisibility(i11);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        d0 v11 = d0.v(context, attributeSet, R$styleable.ActionMode, i11, 0);
        h0.B0(this, v11.g(R$styleable.ActionMode_background));
        this.f4233r = v11.n(R$styleable.ActionMode_titleTextStyle, 0);
        this.f4234s = v11.n(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f4208f = v11.m(R$styleable.ActionMode_height, 0);
        this.f4236u = v11.n(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        v11.w();
    }
}
