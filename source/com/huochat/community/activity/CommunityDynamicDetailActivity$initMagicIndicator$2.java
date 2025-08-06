package com.huochat.community.activity;

import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.huochat.community.R;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import q10.b;
import q10.c;

public final class CommunityDynamicDetailActivity$initMagicIndicator$2 extends CommonNavigatorAdapter {
    public final /* synthetic */ CommunityDynamicDetailActivity this$0;

    public CommunityDynamicDetailActivity$initMagicIndicator$2(CommunityDynamicDetailActivity communityDynamicDetailActivity) {
        this.this$0 = communityDynamicDetailActivity;
    }

    public int getCount() {
        return this.this$0.vpTitleViewList.size();
    }

    public b getIndicator(Context context) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setMode(2);
        linePagerIndicator.setLineHeight((float) UIUtil.a(context, 3.0d));
        linePagerIndicator.setLineWidth((float) UIUtil.a(this.this$0, 30.0d));
        linePagerIndicator.setRoundRadius((float) UIUtil.a(context, 1.5d));
        linePagerIndicator.setPadding(0, 0, 0, 0);
        linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        linePagerIndicator.setEndInterpolator(new DecelerateInterpolator());
        linePagerIndicator.setColors(Integer.valueOf(this.this$0.getResources().getColor(R.color.color_0066ED)));
        return linePagerIndicator;
    }

    public c getTitleView(Context context, int i11) {
        return (c) this.this$0.vpTitleViewList.get(i11);
    }
}
