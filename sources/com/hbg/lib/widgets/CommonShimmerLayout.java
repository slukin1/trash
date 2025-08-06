package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import x9.d;

public class CommonShimmerLayout extends FrameLayout implements d.b {

    /* renamed from: b  reason: collision with root package name */
    public View f71186b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f71187c;

    /* renamed from: d  reason: collision with root package name */
    public final List<List<View>> f71188d;

    /* renamed from: e  reason: collision with root package name */
    public Set<Integer> f71189e;

    /* renamed from: f  reason: collision with root package name */
    public a f71190f;

    /* renamed from: g  reason: collision with root package name */
    public int f71191g;

    /* renamed from: h  reason: collision with root package name */
    public int f71192h;

    /* renamed from: i  reason: collision with root package name */
    public int f71193i;

    public interface a {
        void a(int i11, View view);

        Animator b(int i11, View view);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f71194a;

        /* renamed from: b  reason: collision with root package name */
        public int f71195b;

        /* renamed from: c  reason: collision with root package name */
        public int f71196c;

        /* renamed from: d  reason: collision with root package name */
        public int f71197d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f71198e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f71199f;

        public b(int i11, int i12, int i13, int i14, boolean z11, boolean z12) {
            this.f71194a = i11;
            this.f71195b = i12;
            this.f71196c = i13;
            this.f71197d = i14;
            this.f71198e = z11;
            this.f71199f = z12;
        }
    }

    public CommonShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(b[] bVarArr) {
        int i11;
        int i12;
        ArrayList arrayList = new ArrayList();
        for (b bVar : bVarArr) {
            if (!this.f71189e.contains(Integer.valueOf(bVar.f71194a))) {
                View findViewById = findViewById(bVar.f71194a);
                View view = new View(getContext());
                int b11 = bVar.f71195b;
                int c11 = bVar.f71196c;
                int d11 = bVar.f71197d;
                if (bVar.f71199f || findViewById == null) {
                    i12 = 0;
                    i11 = 0;
                } else {
                    if (b11 == 0) {
                        b11 = findViewById.getWidth();
                    }
                    if (c11 == 0) {
                        c11 = findViewById.getHeight();
                    }
                    if (b11 != 0 || c11 != 0) {
                        if (d11 == 0) {
                            d11 = findViewById.getTop();
                        }
                        i11 = findViewById.getRight();
                        i12 = findViewById.getLeft();
                    }
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b11, c11);
                if (bVar.f71198e) {
                    layoutParams.gravity = 8388613;
                    layoutParams.rightMargin = (getWidth() - i11) - getPaddingRight();
                } else {
                    layoutParams.leftMargin = i12;
                }
                layoutParams.topMargin = d11;
                view.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.f71191g);
                view.setTag(Integer.valueOf(bVar.f71194a));
                a aVar = this.f71190f;
                if (aVar != null) {
                    aVar.a(bVar.f71194a, view);
                }
                this.f71187c.addView(view);
                arrayList.add(view);
                this.f71189e.add(Integer.valueOf(bVar.f71194a));
            }
        }
        if (!arrayList.isEmpty()) {
            this.f71188d.add(arrayList);
        }
    }

    public List<Animator> a(int i11) {
        if (i11 >= this.f71188d.size()) {
            return null;
        }
        List list = this.f71188d.get(i11);
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            View view = (View) list.get(i12);
            if (view != null) {
                arrayList.add(d(view));
            }
        }
        return arrayList;
    }

    public void c(b... bVarArr) {
        post(new u(this, bVarArr));
    }

    public final Animator d(View view) {
        Animator b11;
        a aVar = this.f71190f;
        if (aVar == null || (b11 = aVar.b(((Integer) view.getTag()).intValue(), view)) == null) {
            return ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.5f, 1.0f, 0.5f});
        }
        return b11;
    }

    public final void e(Context context) {
        this.f71187c = new FrameLayout(context);
        this.f71187c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f71187c.setClickable(true);
        this.f71187c.setBackgroundResource(this.f71193i);
        this.f71187c.setVisibility(8);
        this.f71191g = getResources().getColor(R$color.baseColorPrimarySeparator);
    }

    public boolean f() {
        FrameLayout frameLayout = this.f71187c;
        return frameLayout != null && frameLayout.getVisibility() == 0;
    }

    public void h() {
        View childAt = getChildAt(0);
        this.f71186b = childAt;
        childAt.setVisibility(0);
        if (f()) {
            ObjectAnimator.ofFloat(this.f71186b, FrameLayout.ALPHA, new float[]{0.0f, 1.0f}).setDuration(200).start();
        }
        FrameLayout frameLayout = this.f71187c;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        if (getChildCount() > 1) {
            try {
                removeView(this.f71187c);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void i() {
        View childAt = getChildAt(0);
        this.f71186b = childAt;
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        FrameLayout frameLayout = this.f71187c;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            if (getChildCount() == 1) {
                try {
                    addView(this.f71187c);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i6.d.b("CommonShimmerLayout-->onAttachedToWindow-->mType = " + this.f71192h);
        d.m(this.f71192h).l(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i6.d.b("CommonShimmerLayout-->onDetachedFromWindow-->mType = " + this.f71192h);
        d.m(this.f71192h).q(this);
    }

    public void setCallback(a aVar) {
        this.f71190f = aVar;
    }

    public CommonShimmerLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71188d = new ArrayList();
        this.f71189e = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonShimmerLayout, i11, 0);
        this.f71192h = obtainStyledAttributes.getInt(R$styleable.CommonShimmerLayout_shimmer_type, 0);
        this.f71193i = obtainStyledAttributes.getResourceId(R$styleable.CommonShimmerLayout_shimmer_cover_bg, 0);
        obtainStyledAttributes.recycle();
        e(context);
    }
}
