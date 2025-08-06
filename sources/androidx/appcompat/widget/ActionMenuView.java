package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements e.b, j {

    /* renamed from: b  reason: collision with root package name */
    public e f4291b;

    /* renamed from: c  reason: collision with root package name */
    public Context f4292c;

    /* renamed from: d  reason: collision with root package name */
    public int f4293d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4294e;

    /* renamed from: f  reason: collision with root package name */
    public ActionMenuPresenter f4295f;

    /* renamed from: g  reason: collision with root package name */
    public i.a f4296g;

    /* renamed from: h  reason: collision with root package name */
    public e.a f4297h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4298i;

    /* renamed from: j  reason: collision with root package name */
    public int f4299j;

    /* renamed from: k  reason: collision with root package name */
    public int f4300k;

    /* renamed from: l  reason: collision with root package name */
    public int f4301l;

    /* renamed from: m  reason: collision with root package name */
    public d f4302m;

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f4303a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f4304b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f4305c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f4306d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f4307e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4308f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f4303a = layoutParams.f4303a;
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
            this.f4303a = false;
        }
    }

    public interface a {
        boolean a();

        boolean b();
    }

    public static class b implements i.a {
        public boolean a(e eVar) {
            return false;
        }

        public void onCloseMenu(e eVar, boolean z11) {
        }
    }

    public class c implements e.a {
        public c() {
        }

        public boolean onMenuItemSelected(e eVar, MenuItem menuItem) {
            d dVar = ActionMenuView.this.f4302m;
            return dVar != null && dVar.onMenuItemClick(menuItem);
        }

        public void onMenuModeChange(e eVar) {
            e.a aVar = ActionMenuView.this.f4297h;
            if (aVar != null) {
                aVar.onMenuModeChange(eVar);
            }
        }
    }

    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static int l(View view, int i11, int i12, int i13, int i14) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i13) - i14, View.MeasureSpec.getMode(i13));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z11 = true;
        boolean z12 = actionMenuItemView != null && actionMenuItemView.d();
        int i15 = 2;
        if (i12 <= 0 || (z12 && i12 < 2)) {
            i15 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i12 * i11, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i16 = measuredWidth / i11;
            if (measuredWidth % i11 != 0) {
                i16++;
            }
            if (!z12 || i16 >= 2) {
                i15 = i16;
            }
        }
        if (layoutParams.f4303a || !z12) {
            z11 = false;
        }
        layoutParams.f4306d = z11;
        layoutParams.f4304b = i15;
        view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i15, 1073741824), makeMeasureSpec);
        return i15;
    }

    public boolean a(g gVar) {
        return this.f4291b.performItemAction(gVar, 0);
    }

    public void b() {
        ActionMenuPresenter actionMenuPresenter = this.f4295f;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.r();
        }
    }

    /* renamed from: c */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: d */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* renamed from: e */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        if (layoutParams instanceof LayoutParams) {
            layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
        }
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    public LayoutParams f() {
        LayoutParams c11 = generateDefaultLayoutParams();
        c11.f4303a = true;
        return c11;
    }

    public boolean g(int i11) {
        boolean z11 = false;
        if (i11 == 0) {
            return false;
        }
        View childAt = getChildAt(i11 - 1);
        View childAt2 = getChildAt(i11);
        if (i11 < getChildCount() && (childAt instanceof a)) {
            z11 = false | ((a) childAt).a();
        }
        return (i11 <= 0 || !(childAt2 instanceof a)) ? z11 : z11 | ((a) childAt2).b();
    }

    public Menu getMenu() {
        if (this.f4291b == null) {
            Context context = getContext();
            e eVar = new e(context);
            this.f4291b = eVar;
            eVar.setCallback(new c());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f4295f = actionMenuPresenter;
            actionMenuPresenter.C(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f4295f;
            i.a aVar = this.f4296g;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter2.setCallback(aVar);
            this.f4291b.addMenuPresenter(this.f4295f, this.f4292c);
            this.f4295f.A(this);
        }
        return this.f4291b;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f4295f.t();
    }

    public int getPopupTheme() {
        return this.f4293d;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.f4295f;
        return actionMenuPresenter != null && actionMenuPresenter.u();
    }

    public boolean i() {
        ActionMenuPresenter actionMenuPresenter = this.f4295f;
        return actionMenuPresenter != null && actionMenuPresenter.w();
    }

    public void initialize(e eVar) {
        this.f4291b = eVar;
    }

    public boolean j() {
        ActionMenuPresenter actionMenuPresenter = this.f4295f;
        return actionMenuPresenter != null && actionMenuPresenter.x();
    }

    public boolean k() {
        return this.f4294e;
    }

    public final void m(int i11, int i12) {
        int i13;
        boolean z11;
        int i14;
        int i15;
        int i16;
        boolean z12;
        boolean z13;
        int i17;
        boolean z14;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i12, paddingTop, -2);
        int i18 = size - paddingLeft;
        int i19 = this.f4300k;
        int i21 = i18 / i19;
        int i22 = i18 % i19;
        if (i21 == 0) {
            setMeasuredDimension(i18, 0);
            return;
        }
        int i23 = i19 + (i22 / i21);
        int childCount = getChildCount();
        int i24 = 0;
        int i25 = 0;
        boolean z15 = false;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        long j11 = 0;
        while (i25 < childCount) {
            View childAt = getChildAt(i25);
            int i29 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z16 = childAt instanceof ActionMenuItemView;
                int i30 = i26 + 1;
                if (z16) {
                    int i31 = this.f4301l;
                    i17 = i30;
                    z14 = false;
                    childAt.setPadding(i31, 0, i31, 0);
                } else {
                    i17 = i30;
                    z14 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f4308f = z14;
                layoutParams.f4305c = z14 ? 1 : 0;
                layoutParams.f4304b = z14;
                layoutParams.f4306d = z14;
                layoutParams.leftMargin = z14;
                layoutParams.rightMargin = z14;
                layoutParams.f4307e = z16 && ((ActionMenuItemView) childAt).d();
                int l11 = l(childAt, i23, layoutParams.f4303a ? 1 : i21, childMeasureSpec, paddingTop);
                i27 = Math.max(i27, l11);
                if (layoutParams.f4306d) {
                    i28++;
                }
                if (layoutParams.f4303a) {
                    z15 = true;
                }
                i21 -= l11;
                i24 = Math.max(i24, childAt.getMeasuredHeight());
                if (l11 == 1) {
                    j11 |= (long) (1 << i25);
                    i24 = i24;
                } else {
                    int i32 = i24;
                }
                i26 = i17;
            }
            i25++;
            size2 = i29;
        }
        int i33 = size2;
        boolean z17 = z15 && i26 == 2;
        boolean z18 = false;
        while (true) {
            if (i28 <= 0 || i21 <= 0) {
                i15 = mode;
                i13 = i18;
                z11 = z18;
                i14 = i24;
            } else {
                int i34 = Integer.MAX_VALUE;
                int i35 = 0;
                int i36 = 0;
                long j12 = 0;
                while (i36 < childCount) {
                    boolean z19 = z18;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i36).getLayoutParams();
                    int i37 = i24;
                    if (layoutParams2.f4306d) {
                        int i38 = layoutParams2.f4304b;
                        if (i38 < i34) {
                            j12 = 1 << i36;
                            i34 = i38;
                            i35 = 1;
                        } else if (i38 == i34) {
                            i35++;
                            j12 |= 1 << i36;
                        }
                    }
                    i36++;
                    i24 = i37;
                    z18 = z19;
                }
                z11 = z18;
                i14 = i24;
                j11 |= j12;
                if (i35 > i21) {
                    i15 = mode;
                    i13 = i18;
                    break;
                }
                int i39 = i34 + 1;
                int i40 = 0;
                while (i40 < childCount) {
                    View childAt2 = getChildAt(i40);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i41 = i18;
                    int i42 = mode;
                    long j13 = (long) (1 << i40);
                    if ((j12 & j13) == 0) {
                        if (layoutParams3.f4304b == i39) {
                            j11 |= j13;
                        }
                        z13 = z17;
                    } else {
                        if (!z17 || !layoutParams3.f4307e || i21 != 1) {
                            z13 = z17;
                        } else {
                            int i43 = this.f4301l;
                            z13 = z17;
                            childAt2.setPadding(i43 + i23, 0, i43, 0);
                        }
                        layoutParams3.f4304b++;
                        layoutParams3.f4308f = true;
                        i21--;
                    }
                    i40++;
                    mode = i42;
                    i18 = i41;
                    z17 = z13;
                }
                i24 = i14;
                z18 = true;
            }
        }
        boolean z21 = !z15 && i26 == 1;
        if (i21 <= 0 || j11 == 0 || (i21 >= i26 - 1 && !z21 && i27 <= 1)) {
            i16 = 0;
            z12 = z11;
        } else {
            float bitCount = (float) Long.bitCount(j11);
            if (!z21) {
                i16 = 0;
                if ((j11 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f4307e) {
                    bitCount -= 0.5f;
                }
                int i44 = childCount - 1;
                if ((j11 & ((long) (1 << i44))) != 0 && !((LayoutParams) getChildAt(i44).getLayoutParams()).f4307e) {
                    bitCount -= 0.5f;
                }
            } else {
                i16 = 0;
            }
            int i45 = bitCount > 0.0f ? (int) (((float) (i21 * i23)) / bitCount) : i16;
            z12 = z11;
            for (int i46 = i16; i46 < childCount; i46++) {
                if ((j11 & ((long) (1 << i46))) != 0) {
                    View childAt3 = getChildAt(i46);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.f4305c = i45;
                        layoutParams4.f4308f = true;
                        if (i46 == 0 && !layoutParams4.f4307e) {
                            layoutParams4.leftMargin = (-i45) / 2;
                        }
                        z12 = true;
                    } else if (layoutParams4.f4303a) {
                        layoutParams4.f4305c = i45;
                        layoutParams4.f4308f = true;
                        layoutParams4.rightMargin = (-i45) / 2;
                        z12 = true;
                    } else {
                        if (i46 != 0) {
                            layoutParams4.leftMargin = i45 / 2;
                        }
                        if (i46 != childCount - 1) {
                            layoutParams4.rightMargin = i45 / 2;
                        }
                    }
                }
            }
        }
        if (z12) {
            for (int i47 = i16; i47 < childCount; i47++) {
                View childAt4 = getChildAt(i47);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f4308f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f4304b * i23) + layoutParams5.f4305c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i13, i15 != 1073741824 ? i14 : i33);
    }

    public e n() {
        return this.f4291b;
    }

    public void o(i.a aVar, e.a aVar2) {
        this.f4296g = aVar;
        this.f4297h = aVar2;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f4295f;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.f4295f.x()) {
                this.f4295f.u();
                this.f4295f.D();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        if (!this.f4298i) {
            super.onLayout(z11, i11, i12, i13, i14);
            return;
        }
        int childCount = getChildCount();
        int i17 = (i14 - i12) / 2;
        int dividerWidth = getDividerWidth();
        int i18 = i13 - i11;
        int paddingRight = (i18 - getPaddingRight()) - getPaddingLeft();
        boolean b11 = o0.b(this);
        int i19 = 0;
        int i21 = 0;
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt = getChildAt(i22);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f4303a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (g(i22)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b11) {
                        i15 = getPaddingLeft() + layoutParams.leftMargin;
                        i16 = i15 + measuredWidth;
                    } else {
                        i16 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i15 = i16 - measuredWidth;
                    }
                    int i23 = i17 - (measuredHeight / 2);
                    childAt.layout(i15, i23, i16, measuredHeight + i23);
                    paddingRight -= measuredWidth;
                    i19 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    g(i22);
                    i21++;
                }
            }
        }
        if (childCount == 1 && i19 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i24 = (i18 / 2) - (measuredWidth2 / 2);
            int i25 = i17 - (measuredHeight2 / 2);
            childAt2.layout(i24, i25, measuredWidth2 + i24, measuredHeight2 + i25);
            return;
        }
        int i26 = i21 - (i19 ^ 1);
        int max = Math.max(0, i26 > 0 ? paddingRight / i26 : 0);
        if (b11) {
            int width = getWidth() - getPaddingRight();
            for (int i27 = 0; i27 < childCount; i27++) {
                View childAt3 = getChildAt(i27);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f4303a) {
                    int i28 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i29 = i17 - (measuredHeight3 / 2);
                    childAt3.layout(i28 - measuredWidth3, i29, i28, measuredHeight3 + i29);
                    width = i28 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i30 = 0; i30 < childCount; i30++) {
            View childAt4 = getChildAt(i30);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f4303a) {
                int i31 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i32 = i17 - (measuredHeight4 / 2);
                childAt4.layout(i31, i32, i31 + measuredWidth4, measuredHeight4 + i32);
                paddingLeft = i31 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        e eVar;
        boolean z11 = this.f4298i;
        boolean z12 = View.MeasureSpec.getMode(i11) == 1073741824;
        this.f4298i = z12;
        if (z11 != z12) {
            this.f4299j = 0;
        }
        int size = View.MeasureSpec.getSize(i11);
        if (!(!this.f4298i || (eVar = this.f4291b) == null || size == this.f4299j)) {
            this.f4299j = size;
            eVar.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.f4298i || childCount <= 0) {
            for (int i13 = 0; i13 < childCount; i13++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i13).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i11, i12);
            return;
        }
        m(i11, i12);
    }

    public boolean p() {
        ActionMenuPresenter actionMenuPresenter = this.f4295f;
        return actionMenuPresenter != null && actionMenuPresenter.D();
    }

    public void setExpandedActionViewsExclusive(boolean z11) {
        this.f4295f.z(z11);
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.f4302m = dVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f4295f.B(drawable);
    }

    public void setOverflowReserved(boolean z11) {
        this.f4294e = z11;
    }

    public void setPopupTheme(int i11) {
        if (this.f4293d != i11) {
            this.f4293d = i11;
            if (i11 == 0) {
                this.f4292c = getContext();
            } else {
                this.f4292c = new ContextThemeWrapper(getContext(), i11);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f4295f = actionMenuPresenter;
        actionMenuPresenter.A(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.f4300k = (int) (56.0f * f11);
        this.f4301l = (int) (f11 * 4.0f);
        this.f4292c = context;
        this.f4293d = 0;
    }
}
