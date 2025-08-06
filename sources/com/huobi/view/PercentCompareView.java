package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import pro.huobi.R;

public class PercentCompareView extends RelativeLayout {
    private LinearLayout.LayoutParams mRightLayoutParams;
    private TextView mTvLeft;
    private TextView mTvRight;
    private View mViewCenter;
    private View mViewLeft;
    private View mViewRight;
    private LinearLayout.LayoutParams mleftLayoutParams;

    public PercentCompareView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_percent_compare, this, true);
        this.mTvLeft = (TextView) findViewById(R.id.tv_left);
        this.mTvRight = (TextView) findViewById(R.id.tv_right);
        this.mViewLeft = findViewById(R.id.v_left);
        this.mViewCenter = findViewById(R.id.v_middle);
        this.mViewRight = findViewById(R.id.v_right);
        this.mleftLayoutParams = (LinearLayout.LayoutParams) this.mViewLeft.getLayoutParams();
        this.mRightLayoutParams = (LinearLayout.LayoutParams) this.mViewRight.getLayoutParams();
        setLeftTextWithProgress(70);
        setRightTextWithProgress(30);
        setTextSize(12);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public void setCenterVisibility(boolean z11) {
        if (z11) {
            this.mViewCenter.setVisibility(0);
        } else {
            this.mViewCenter.setVisibility(8);
        }
    }

    public void setLeftBgColor(int i11) {
        this.mViewLeft.setBackgroundColor(i11);
    }

    public void setLeftTextColor(int i11) {
        this.mTvLeft.setTextColor(i11);
    }

    public void setLeftTextWithProgress(int i11) {
        this.mleftLayoutParams.weight = (float) i11;
    }

    public void setProgressHeight(int i11) {
        float f11 = (float) i11;
        this.mleftLayoutParams.height = PixelUtils.a(f11);
        this.mRightLayoutParams.height = PixelUtils.a(f11);
    }

    public void setRightBgColor(int i11) {
        this.mViewRight.setBackgroundColor(i11);
    }

    public void setRightTextColor(int i11) {
        this.mTvRight.setTextColor(i11);
    }

    public void setRightTextWithProgress(int i11) {
        this.mRightLayoutParams.weight = (float) i11;
    }

    public void setTextSize(int i11) {
        float f11 = (float) i11;
        this.mTvLeft.setTextSize(f11);
        this.mTvRight.setTextSize(f11);
    }

    public void setTvLeftText(String str) {
        this.mTvLeft.setText(str);
    }

    public void setTvRightText(String str) {
        this.mTvRight.setText(str);
    }

    public PercentCompareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PercentCompareView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
