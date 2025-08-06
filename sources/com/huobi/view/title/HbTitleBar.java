package com.huobi.view.title;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$styleable;

public class HbTitleBar extends HbBaseTitleBar {
    private String titleText;
    private TextView tvTitle;

    public HbTitleBar(Context context) {
        super(context);
    }

    public View getTitleContent() {
        return null;
    }

    public void init(Context context, AttributeSet attributeSet, int i11, int i12) {
        super.init(context, attributeSet, i11, i12);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HbTitleBar, i12, 0);
        this.titleText = obtainStyledAttributes.getString(R$styleable.HbTitleBar_titleText);
        obtainStyledAttributes.recycle();
        TextView textView = (TextView) findViewById(R$id.tv_title);
        this.tvTitle = textView;
        textView.setText(this.titleText);
    }

    public void setTitle(String str) {
        this.titleText = str;
        this.tvTitle.setText(str);
    }

    public void setTitleRes(int i11) {
        String string = getResources().getString(i11);
        this.titleText = string;
        this.tvTitle.setText(string);
    }

    public void setTitleSize(int i11) {
        this.tvTitle.setTextSize(getResources().getDimension(i11));
    }

    public HbTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HbTitleBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
