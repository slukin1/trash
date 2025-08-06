package com.hbg.lib.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.hbg.lib.common.utils.PixelUtils;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import q10.c;

public class RedPointPagerTitleView extends RelativeLayout implements c {

    /* renamed from: b  reason: collision with root package name */
    public View f71605b;

    /* renamed from: c  reason: collision with root package name */
    public SimplePagerTitleView f71606c;

    public RedPointPagerTitleView(Context context) {
        super(context);
    }

    public void a() {
        View view = this.f71605b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @SuppressLint({"ResourceType"})
    public void b(SimplePagerTitleView simplePagerTitleView, boolean z11) {
        this.f71606c = simplePagerTitleView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f71606c.setLayoutParams(layoutParams);
        if (this.f71606c.getId() == -1) {
            this.f71606c.setId(291);
        }
        addView(this.f71606c);
        if (z11) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(PixelUtils.a(7.0f), PixelUtils.a(7.0f));
            layoutParams2.addRule(1, this.f71606c.getId());
            layoutParams2.addRule(2, this.f71606c.getId());
            layoutParams2.bottomMargin = -PixelUtils.a(5.0f);
            layoutParams2.leftMargin = -PixelUtils.a(3.0f);
            View view = new View(getContext());
            this.f71605b = view;
            view.setLayoutParams(layoutParams2);
            this.f71605b.setBackground(getContext().getResources().getDrawable(R$drawable.red_point));
            this.f71605b.setVisibility(8);
            addView(this.f71605b);
        }
    }

    public void c() {
        View view = this.f71605b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public SimplePagerTitleView getSimplePagerTitleView() {
        return this.f71606c;
    }

    public void onDeselected(int i11, int i12) {
        SimplePagerTitleView simplePagerTitleView = this.f71606c;
        if (simplePagerTitleView != null) {
            simplePagerTitleView.onDeselected(i11, i12);
        }
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
        SimplePagerTitleView simplePagerTitleView = this.f71606c;
        if (simplePagerTitleView != null) {
            simplePagerTitleView.onEnter(i11, i12, f11, z11);
        }
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
        SimplePagerTitleView simplePagerTitleView = this.f71606c;
        if (simplePagerTitleView != null) {
            simplePagerTitleView.onLeave(i11, i12, f11, z11);
        }
    }

    public void onSelected(int i11, int i12) {
        SimplePagerTitleView simplePagerTitleView = this.f71606c;
        if (simplePagerTitleView != null) {
            simplePagerTitleView.onSelected(i11, i12);
        }
    }

    public RedPointPagerTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RedPointPagerTitleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
