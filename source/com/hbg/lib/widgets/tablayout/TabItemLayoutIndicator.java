package com.hbg.lib.widgets.tablayout;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$styleable;
import java.util.List;
import la.a;
import la.b;
import la.c;
import la.d;
import la.e;
import la.f;
import la.g;

public class TabItemLayoutIndicator extends ConstraintLayout implements b {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f72321b;

    /* renamed from: c  reason: collision with root package name */
    public View f72322c;

    /* renamed from: d  reason: collision with root package name */
    public List<TabItemLayoutData> f72323d;

    /* renamed from: e  reason: collision with root package name */
    public int f72324e;

    /* renamed from: f  reason: collision with root package name */
    public int f72325f;

    /* renamed from: g  reason: collision with root package name */
    public b f72326g;

    /* renamed from: h  reason: collision with root package name */
    public int f72327h;

    /* renamed from: i  reason: collision with root package name */
    public int f72328i;

    /* renamed from: j  reason: collision with root package name */
    public int f72329j;

    /* renamed from: k  reason: collision with root package name */
    public int f72330k;

    /* renamed from: l  reason: collision with root package name */
    public int f72331l;

    /* renamed from: m  reason: collision with root package name */
    public int f72332m;

    /* renamed from: n  reason: collision with root package name */
    public int f72333n;

    /* renamed from: o  reason: collision with root package name */
    public int f72334o;

    /* renamed from: p  reason: collision with root package name */
    public int f72335p;

    /* renamed from: q  reason: collision with root package name */
    public int f72336q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f72337r;

    public TabItemLayoutIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(int i11) {
        r();
        View view = this.f72322c;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{view.getTranslationX(), (float) (this.f72336q * i11)});
        ofFloat.setDuration(270);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
        this.f72325f = i11;
        b bVar = this.f72326g;
        if (bVar != null) {
            bVar.onItemClick(i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(int i11) {
        r();
        this.f72322c.setTranslationX((float) (this.f72336q * i11));
        this.f72325f = i11;
        b bVar = this.f72326g;
        if (bVar != null) {
            bVar.onItemClick(i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t() {
        List<TabItemLayoutData> list = this.f72323d;
        if (list == null || list.isEmpty()) {
            this.f72322c.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f72322c.getLayoutParams();
        if (getWidth() != 0) {
            int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) / this.f72323d.size();
            this.f72336q = width;
            layoutParams.width = width;
        }
        this.f72322c.setTranslationX((float) (this.f72325f * layoutParams.width));
        this.f72322c.setVisibility(0);
    }

    public int getCheckPosition() {
        return this.f72325f;
    }

    public final void o(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R$layout.layout_tab_indicator, this, true);
        this.f72321b = (LinearLayout) findViewById(R$id.item_layout);
        this.f72322c = findViewById(R$id.cover_view);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TabItemLayoutIndicator);
        if (obtainStyledAttributes != null) {
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.TabItemLayoutIndicator_tab_check_bg, R$drawable.shape_tab_item_check_bg);
            this.f72324e = resourceId;
            this.f72322c.setBackgroundResource(resourceId);
            this.f72327h = obtainStyledAttributes.getColor(R$styleable.TabItemLayoutIndicator_tab_check_color, ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
            this.f72328i = obtainStyledAttributes.getColor(R$styleable.TabItemLayoutIndicator_tab_unCheck_color, ContextCompat.getColor(context, R$color.baseColorSecondaryText));
            this.f72329j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabItemLayoutIndicator_left_tab_text_size, 14);
            this.f72330k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabItemLayoutIndicator_middle_tab_text_size, 14);
            this.f72331l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabItemLayoutIndicator_right_tab_text_size, 14);
            this.f72332m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabItemLayoutIndicator_tab_padding_left, PixelUtils.a(10.0f));
            this.f72333n = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabItemLayoutIndicator_tab_padding_right, PixelUtils.a(10.0f));
            this.f72334o = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabItemLayoutIndicator_tab_padding_top, 0);
            this.f72335p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabItemLayoutIndicator_tab_padding_bottom, 0);
            this.f72337r = obtainStyledAttributes.getBoolean(R$styleable.TabItemLayoutIndicator_middle_tab_tight, false);
            obtainStyledAttributes.recycle();
        }
    }

    public void onItemClick(int i11) {
        if (this.f72325f == i11) {
            post(new c(this));
            return;
        }
        int childCount = this.f72321b.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            a aVar = (a) this.f72321b.getChildAt(i12);
            if (this.f72325f == i12) {
                aVar.c(false, true);
            } else if (i11 == i12) {
                aVar.c(true, true);
            }
        }
        post(new f(this, i11));
    }

    public void setItemClickCallBack(b bVar) {
        this.f72326g = bVar;
    }

    public void setTabItemLayoutData(List<TabItemLayoutData> list) {
        if (list != null) {
            this.f72323d = list;
            this.f72321b.removeAllViews();
            int size = this.f72323d.size();
            for (int i11 = 0; i11 < size; i11++) {
                TabItemLayoutData tabItemLayoutData = this.f72323d.get(i11);
                TabItemLayout tabItemLayout = new TabItemLayout(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                tabItemLayout.setPadding(this.f72332m, this.f72334o, this.f72333n, this.f72335p);
                tabItemLayout.setLayoutParams(layoutParams);
                tabItemLayout.setItemClickCallBack(this);
                tabItemLayout.setTabCheckTextColor(this.f72327h);
                tabItemLayout.setTabUnCheckTextColor(this.f72328i);
                tabItemLayout.setLeftViewTextSize(PixelUtils.h((float) this.f72329j));
                tabItemLayout.setMiddleViewTextSize(PixelUtils.h((float) this.f72330k));
                tabItemLayout.setRightViewTextSize(PixelUtils.h((float) this.f72331l));
                tabItemLayout.setLeftViewText(tabItemLayoutData.getLeftTabText());
                tabItemLayout.setMiddleViewText(tabItemLayoutData.getMiddleTabText());
                tabItemLayout.setRightViewText(tabItemLayoutData.getRightTabText());
                if (this.f72337r && tabItemLayout.getMiddleView() != null) {
                    tabItemLayout.getMiddleView().setLineHeight(this.f72330k);
                }
                tabItemLayout.setChecked(tabItemLayoutData.isCheck());
                tabItemLayout.setPosition(i11);
                if (tabItemLayoutData.isCheck()) {
                    this.f72325f = i11;
                }
                this.f72321b.addView(tabItemLayout);
            }
            w();
        }
    }

    public void u(int i11) {
        if (this.f72325f == i11) {
            post(new d(this));
            return;
        }
        int childCount = this.f72321b.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            a aVar = (a) this.f72321b.getChildAt(i12);
            if (this.f72325f == i12) {
                aVar.c(false, false);
            } else if (i11 == i12) {
                aVar.c(true, false);
            }
        }
        post(new g(this, i11));
    }

    public final void w() {
        post(new e(this));
    }

    /* renamed from: x */
    public final void r() {
        if (this.f72336q == 0) {
            ViewGroup.LayoutParams layoutParams = this.f72322c.getLayoutParams();
            if (getWidth() != 0) {
                int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) / this.f72323d.size();
                this.f72336q = width;
                layoutParams.width = width;
            }
            this.f72322c.setLayoutParams(layoutParams);
        }
    }

    public void y(String str, int i11) {
        TabItemLayout tabItemLayout = (TabItemLayout) this.f72321b.getChildAt(i11);
        if (tabItemLayout != null) {
            tabItemLayout.setLeftViewText(str);
        }
    }

    public TabItemLayoutIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        o(context, attributeSet);
    }
}
