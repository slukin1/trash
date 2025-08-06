package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: m  reason: collision with root package name */
    public static final Interpolator f4470m = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public Runnable f4471b;

    /* renamed from: c  reason: collision with root package name */
    public c f4472c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayoutCompat f4473d;

    /* renamed from: e  reason: collision with root package name */
    public Spinner f4474e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4475f;

    /* renamed from: g  reason: collision with root package name */
    public int f4476g;

    /* renamed from: h  reason: collision with root package name */
    public int f4477h;

    /* renamed from: i  reason: collision with root package name */
    public int f4478i;

    /* renamed from: j  reason: collision with root package name */
    public int f4479j;

    /* renamed from: k  reason: collision with root package name */
    public ViewPropertyAnimator f4480k;

    /* renamed from: l  reason: collision with root package name */
    public final d f4481l = new d();

    public class TabView extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        public final int[] f4482b;

        /* renamed from: c  reason: collision with root package name */
        public ActionBar.Tab f4483c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4484d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f4485e;

        /* renamed from: f  reason: collision with root package name */
        public View f4486f;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TabView(android.content.Context r6, androidx.appcompat.app.ActionBar.Tab r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.ScrollingTabContainerView.this = r5
                int r5 = androidx.appcompat.R$attr.actionBarTabStyle
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f4482b = r1
                r4.f4483c = r7
                androidx.appcompat.widget.d0 r5 = androidx.appcompat.widget.d0.v(r6, r0, r1, r5, r3)
                boolean r6 = r5.s(r3)
                if (r6 == 0) goto L_0x0026
                android.graphics.drawable.Drawable r6 = r5.g(r3)
                r4.setBackgroundDrawable(r6)
            L_0x0026:
                r5.w()
                if (r8 == 0) goto L_0x0031
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L_0x0031:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ScrollingTabContainerView.TabView.<init>(androidx.appcompat.widget.ScrollingTabContainerView, android.content.Context, androidx.appcompat.app.ActionBar$Tab, boolean):void");
        }

        public void a(ActionBar.Tab tab) {
            this.f4483c = tab;
            c();
        }

        public ActionBar.Tab b() {
            return this.f4483c;
        }

        public void c() {
            ActionBar.Tab tab = this.f4483c;
            View b11 = tab.b();
            CharSequence charSequence = null;
            if (b11 != null) {
                ViewParent parent = b11.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b11);
                    }
                    addView(b11);
                }
                this.f4486f = b11;
                TextView textView = this.f4484d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f4485e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f4485e.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.f4486f;
            if (view != null) {
                removeView(view);
                this.f4486f = null;
            }
            Drawable c11 = tab.c();
            CharSequence e11 = tab.e();
            if (c11 != null) {
                if (this.f4485e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f4485e = appCompatImageView;
                }
                this.f4485e.setImageDrawable(c11);
                this.f4485e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f4485e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f4485e.setImageDrawable((Drawable) null);
                }
            }
            boolean z11 = !TextUtils.isEmpty(e11);
            if (z11) {
                if (this.f4484d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, R$attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f4484d = appCompatTextView;
                }
                this.f4484d.setText(e11);
                this.f4484d.setVisibility(0);
            } else {
                TextView textView2 = this.f4484d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f4484d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f4485e;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.a());
            }
            if (!z11) {
                charSequence = tab.a();
            }
            i0.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i11, int i12) {
            int i13;
            super.onMeasure(i11, i12);
            if (ScrollingTabContainerView.this.f4476g > 0 && getMeasuredWidth() > (i13 = ScrollingTabContainerView.this.f4476g)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), i12);
            }
        }

        public void setSelected(boolean z11) {
            boolean z12 = isSelected() != z11;
            super.setSelected(z11);
            if (z12 && z11) {
                sendAccessibilityEvent(4);
            }
        }
    }

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f4488b;

        public a(View view) {
            this.f4488b = view;
        }

        public void run() {
            ScrollingTabContainerView.this.smoothScrollTo(this.f4488b.getLeft() - ((ScrollingTabContainerView.this.getWidth() - this.f4488b.getWidth()) / 2), 0);
            ScrollingTabContainerView.this.f4471b = null;
        }
    }

    public class b extends BaseAdapter {
        public b() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.f4473d.getChildCount();
        }

        public Object getItem(int i11) {
            return ((TabView) ScrollingTabContainerView.this.f4473d.getChildAt(i11)).b();
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.f((ActionBar.Tab) getItem(i11), true);
            }
            ((TabView) view).a((ActionBar.Tab) getItem(i11));
            return view;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            ((TabView) view).b().f();
            int childCount = ScrollingTabContainerView.this.f4473d.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = ScrollingTabContainerView.this.f4473d.getChildAt(i11);
                childAt.setSelected(childAt == view);
            }
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f4492b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f4493c;

        public d() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f4492b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f4492b) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.f4480k = null;
                scrollingTabContainerView.setVisibility(this.f4493c);
            }
        }

        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f4492b = false;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        g.a b11 = g.a.b(context);
        setContentHeight(b11.f());
        this.f4477h = b11.e();
        LinearLayoutCompat e11 = e();
        this.f4473d = e11;
        addView(e11, new ViewGroup.LayoutParams(-2, -1));
    }

    public void a(ActionBar.Tab tab, int i11, boolean z11) {
        TabView f11 = f(tab, false);
        this.f4473d.addView(f11, i11, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.f4474e;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z11) {
            f11.setSelected(true);
        }
        if (this.f4475f) {
            requestLayout();
        }
    }

    public void b(ActionBar.Tab tab, boolean z11) {
        TabView f11 = f(tab, false);
        this.f4473d.addView(f11, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.f4474e;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z11) {
            f11.setSelected(true);
        }
        if (this.f4475f) {
            requestLayout();
        }
    }

    public void c(int i11) {
        View childAt = this.f4473d.getChildAt(i11);
        Runnable runnable = this.f4471b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f4471b = aVar;
        post(aVar);
    }

    public final Spinner d() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R$attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public final LinearLayoutCompat e() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, R$attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    public TabView f(ActionBar.Tab tab, boolean z11) {
        TabView tabView = new TabView(getContext(), tab, z11);
        if (z11) {
            tabView.setBackgroundDrawable((Drawable) null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f4478i));
        } else {
            tabView.setFocusable(true);
            if (this.f4472c == null) {
                this.f4472c = new c();
            }
            tabView.setOnClickListener(this.f4472c);
        }
        return tabView;
    }

    public final boolean g() {
        Spinner spinner = this.f4474e;
        return spinner != null && spinner.getParent() == this;
    }

    public final void h() {
        if (!g()) {
            if (this.f4474e == null) {
                this.f4474e = d();
            }
            removeView(this.f4473d);
            addView(this.f4474e, new ViewGroup.LayoutParams(-2, -1));
            if (this.f4474e.getAdapter() == null) {
                this.f4474e.setAdapter(new b());
            }
            Runnable runnable = this.f4471b;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f4471b = null;
            }
            this.f4474e.setSelection(this.f4479j);
        }
    }

    public final boolean i() {
        if (!g()) {
            return false;
        }
        removeView(this.f4474e);
        addView(this.f4473d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f4474e.getSelectedItemPosition());
        return false;
    }

    public void j() {
        this.f4473d.removeAllViews();
        Spinner spinner = this.f4474e;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f4475f) {
            requestLayout();
        }
    }

    public void k(int i11) {
        this.f4473d.removeViewAt(i11);
        Spinner spinner = this.f4474e;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f4475f) {
            requestLayout();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f4471b;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g.a b11 = g.a.b(getContext());
        setContentHeight(b11.f());
        this.f4477h = b11.e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f4471b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
        ((TabView) view).b().f();
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        boolean z11 = true;
        boolean z12 = mode == 1073741824;
        setFillViewport(z12);
        int childCount = this.f4473d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f4476g = -1;
        } else {
            if (childCount > 2) {
                this.f4476g = (int) (((float) View.MeasureSpec.getSize(i11)) * 0.4f);
            } else {
                this.f4476g = View.MeasureSpec.getSize(i11) / 2;
            }
            this.f4476g = Math.min(this.f4476g, this.f4477h);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f4478i, 1073741824);
        if (z12 || !this.f4475f) {
            z11 = false;
        }
        if (z11) {
            this.f4473d.measure(0, makeMeasureSpec);
            if (this.f4473d.getMeasuredWidth() > View.MeasureSpec.getSize(i11)) {
                h();
            } else {
                i();
            }
        } else {
            i();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i11, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z12 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f4479j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z11) {
        this.f4475f = z11;
    }

    public void setContentHeight(int i11) {
        this.f4478i = i11;
        requestLayout();
    }

    public void setTabSelected(int i11) {
        this.f4479j = i11;
        int childCount = this.f4473d.getChildCount();
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = this.f4473d.getChildAt(i12);
            boolean z11 = i12 == i11;
            childAt.setSelected(z11);
            if (z11) {
                c(i11);
            }
            i12++;
        }
        Spinner spinner = this.f4474e;
        if (spinner != null && i11 >= 0) {
            spinner.setSelection(i11);
        }
    }
}
