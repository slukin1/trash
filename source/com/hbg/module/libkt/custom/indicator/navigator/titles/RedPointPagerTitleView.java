package com.hbg.module.libkt.custom.indicator.navigator.titles;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.libkt.R$drawable;
import kotlin.jvm.internal.r;
import pe.c;

public final class RedPointPagerTitleView extends RelativeLayout implements c {

    /* renamed from: b  reason: collision with root package name */
    public View f24837b;

    /* renamed from: c  reason: collision with root package name */
    public PagerTitleView f24838c;

    public RedPointPagerTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedPointPagerTitleView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void a() {
        View view = this.f24837b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void b() {
        View view = this.f24837b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final PagerTitleView getPagerTitle() {
        return this.f24838c;
    }

    public void onDeselected(int i11, int i12) {
        PagerTitleView pagerTitleView = this.f24838c;
        if (pagerTitleView != null) {
            pagerTitleView.onDeselected(i11, i12);
        }
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
        PagerTitleView pagerTitleView = this.f24838c;
        if (pagerTitleView != null) {
            pagerTitleView.onEnter(i11, i12, f11, z11);
        }
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
        PagerTitleView pagerTitleView = this.f24838c;
        if (pagerTitleView != null) {
            pagerTitleView.onLeave(i11, i12, f11, z11);
        }
    }

    public void onSelected(int i11, int i12) {
        PagerTitleView pagerTitleView = this.f24838c;
        if (pagerTitleView != null) {
            pagerTitleView.onSelected(i11, i12);
        }
    }

    @SuppressLint({"ResourceType"})
    public final void setPageTitleView(PagerTitleView pagerTitleView) {
        try {
            this.f24838c = pagerTitleView;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            PagerTitleView pagerTitleView2 = this.f24838c;
            if (pagerTitleView2 != null) {
                pagerTitleView2.setLayoutParams(layoutParams);
            }
            PagerTitleView pagerTitleView3 = this.f24838c;
            if (pagerTitleView3 != null) {
                pagerTitleView3.setId(291);
            }
            addView(this.f24838c);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(PixelUtils.a(6.0f), PixelUtils.a(6.0f));
            layoutParams2.addRule(7, 291);
            layoutParams2.addRule(6, 291);
            layoutParams2.rightMargin = PixelUtils.a(4.0f);
            View view = new View(getContext());
            this.f24837b = view;
            view.setLayoutParams(layoutParams2);
            View view2 = this.f24837b;
            if (view2 != null) {
                view2.setBackground(getContext().getResources().getDrawable(R$drawable.red_point));
            }
            View view3 = this.f24837b;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            addView(this.f24837b);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public RedPointPagerTitleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
