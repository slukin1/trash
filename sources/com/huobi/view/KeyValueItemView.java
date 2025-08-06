package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import pro.huobi.R;

public class KeyValueItemView extends RelativeLayout {
    private TextView mTvKey;
    private TextView mTvValue;

    public KeyValueItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_key_value, this, true);
        this.mTvKey = (TextView) findViewById(R.id.tv_key);
        this.mTvValue = (TextView) findViewById(R.id.tv_value);
    }

    public void setKeyText(String str) {
        this.mTvKey.setText(str);
    }

    public void setValueText(String str) {
        this.mTvValue.setText(str);
    }

    public KeyValueItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeyValueItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView();
    }
}
