package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huobi.R$styleable;
import pro.huobi.R;

public class OrderItemLabelView extends LinearLayout {
    private ImageView mLabelIv;
    private TextView mLabelLeftTv;
    private TextView mLabelRightTv;

    public OrderItemLabelView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.order_item_label_view, this, true);
        this.mLabelLeftTv = (TextView) findViewById(R.id.label_left_tv);
        this.mLabelIv = (ImageView) findViewById(R.id.label_iv);
        this.mLabelRightTv = (TextView) findViewById(R.id.label_right_tv);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.OrderItemLabelView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(1);
            String string2 = obtainStyledAttributes.getString(2);
            this.mLabelLeftTv.setText(string);
            this.mLabelRightTv.setText(string2);
            obtainStyledAttributes.recycle();
        }
    }

    public void setLabelImage(int i11) {
    }

    public void setLabelLeftTv(String str) {
        this.mLabelLeftTv.setText(str);
    }

    public void setLabelRightTv(String str) {
        this.mLabelRightTv.setText(str);
    }

    public OrderItemLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setLabelLeftTv(int i11) {
        this.mLabelLeftTv.setText(i11);
    }

    public void setLabelRightTv(int i11) {
        this.mLabelRightTv.setText(i11);
    }

    public OrderItemLabelView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet);
    }
}
