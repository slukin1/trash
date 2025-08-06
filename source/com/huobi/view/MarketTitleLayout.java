package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.RedPointPagerTitleView;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

public class MarketTitleLayout extends TitleLayout {
    public MarketTitleLayout(Context context) {
        super(context);
    }

    public void generateContentLayout(List<?> list, int i11, boolean z11, int i12) {
        LinearLayout.LayoutParams layoutParams;
        RedPointPagerTitleView redPointPagerTitleView = new RedPointPagerTitleView(this.context);
        redPointPagerTitleView.setPadding(this.itemPaddingLeft, 0, this.itemPaddingRight, 0);
        ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(this.context);
        colorTransitionPagerTitleView.setSelectedColor(this.selectedColor);
        colorTransitionPagerTitleView.setNormalColor(this.normalColor);
        colorTransitionPagerTitleView.setTextColor(this.normalColor);
        colorTransitionPagerTitleView.setTextSize(0, this.normalTextSize);
        colorTransitionPagerTitleView.getPaint().setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        colorTransitionPagerTitleView.setPadding(0, 0, 0, 0);
        colorTransitionPagerTitleView.setText(list.get(i12).toString());
        colorTransitionPagerTitleView.setGravity(i11);
        redPointPagerTitleView.b(colorTransitionPagerTitleView, true);
        redPointPagerTitleView.setClickable(true);
        redPointPagerTitleView.setOnClickListener(this);
        this.titleViews.add(colorTransitionPagerTitleView);
        int i13 = this.maxLine;
        if (i13 != -1) {
            colorTransitionPagerTitleView.setMaxLines(i13);
        }
        if (z11) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        layoutParams.gravity = i11;
        addView(redPointPagerTitleView, layoutParams);
    }

    public void showHidePoint(boolean z11, String str) {
        List<TextView> list;
        if (str != null && (list = this.titleViews) != null && !list.isEmpty()) {
            int i11 = 0;
            while (i11 < this.titleViews.size()) {
                if (!str.equals(this.titleViews.get(i11).getText()) || i11 >= getChildCount()) {
                    i11++;
                } else if (z11) {
                    ((RedPointPagerTitleView) getChildAt(i11)).c();
                    return;
                } else {
                    ((RedPointPagerTitleView) getChildAt(i11)).a();
                    return;
                }
            }
        }
    }

    public MarketTitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarketTitleLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public MarketTitleLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    public void showHidePoint(boolean z11, int i11) {
        if (i11 < getChildCount()) {
            if (z11) {
                ((RedPointPagerTitleView) getChildAt(i11)).c();
            } else {
                ((RedPointPagerTitleView) getChildAt(i11)).a();
            }
        }
    }
}
