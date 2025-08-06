package com.hbg.module.exchange.grid.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.cpiz.android.bubbleview.BubbleTextView;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;

public class GridConversationRateOfYearTipsView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public BubbleTextView f19477b;

    public GridConversationRateOfYearTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.grid_no_highlight_pop_tips, this, false);
        this.f19477b = (BubbleTextView) inflate.findViewById(R$id.bubble_text);
        addView(inflate);
    }

    public void setArrowTo(View view) {
        this.f19477b.setArrowTo(view);
    }

    public void setArrowTo(int i11) {
        this.f19477b.setArrowTo(i11);
    }

    public GridConversationRateOfYearTipsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
