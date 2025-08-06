package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huobi.R$styleable;
import pro.huobi.R;

public class CommonTipsLayout extends LinearLayout {
    private TextView mTitle;

    public CommonTipsLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(Context context) {
        setOrientation(1);
        setBackgroundColor(getResources().getColor(R.color.global_item_bg));
        this.mTitle = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.global_expanded_title_margin_bottom_large);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.global_expanded_title_margin_bottom_large);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.global_expanded_title_margin_top_large);
        this.mTitle.setLayoutParams(layoutParams);
        this.mTitle.setTextSize(1, 24.0f);
        this.mTitle.setTextColor(getResources().getColor(R.color.global_main_text_color));
        this.mTitle.setIncludeFontPadding(false);
        addView(this.mTitle);
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.global_divider_height));
        layoutParams2.leftMargin = getResources().getDimensionPixelOffset(R.dimen.global_expanded_title_margin_bottom_large);
        layoutParams2.rightMargin = getResources().getDimensionPixelOffset(R.dimen.global_expanded_title_margin_bottom_large);
        layoutParams2.topMargin = getResources().getDimensionPixelOffset(R.dimen.global_content_margin_top);
        view.setLayoutParams(layoutParams2);
        view.setBackgroundColor(getResources().getColor(R.color.global_divider_color));
        addView(view);
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.mTitle;
        if (textView != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            textView.setText(charSequence);
        }
    }

    public CommonTipsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTipsLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonTipsLayout, i11, 0);
        String string = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        init(context);
        setTitle((CharSequence) string);
    }

    public void setTitle(int i11) {
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setText(getResources().getString(i11));
        }
    }
}
