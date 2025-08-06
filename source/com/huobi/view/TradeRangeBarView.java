package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.w;
import com.huobi.view.bubbleseekbar.BubbleSeekBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class TradeRangeBarView extends RelativeLayout {
    private static final int PERCENT_0 = 0;
    private static final int PERCENT_100 = 100;
    private static final int PERCENT_25 = 25;
    private static final int PERCENT_50 = 50;
    private static final int PERCENT_75 = 75;
    private int mCurrentProgress;
    private boolean mIsBuy;
    private int mNormalTextColor;
    public BubbleSeekBar.OnProgressChangedListener mOnProgressChangedListener;
    private int mSelectTextColor;
    private TextView mTv100;
    private TextView mTv25;
    private TextView mTv50;
    private TextView mTv75;
    private boolean mV2;

    public TradeRangeBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initData() {
        LayoutInflater.from(getContext()).inflate(R.layout.trade_bubble_seekbar_view, this, true);
        this.mTv25 = (TextView) findViewById(R.id.leverage_25);
        this.mTv50 = (TextView) findViewById(R.id.leverage_50);
        this.mTv75 = (TextView) findViewById(R.id.leverage_75);
        this.mTv100 = (TextView) findViewById(R.id.leverage_100);
        this.mTv25.setOnClickListener(new l2(this));
        this.mTv50.setOnClickListener(new k2(this));
        this.mTv75.setOnClickListener(new m2(this));
        this.mTv100.setOnClickListener(new j2(this));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initData$0(View view) {
        this.mOnProgressChangedListener.onProgressChanged((BubbleSeekBar) null, 25, 25.0f, true);
        setProgress(25);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initData$1(View view) {
        this.mOnProgressChangedListener.onProgressChanged((BubbleSeekBar) null, 50, 50.0f, true);
        setProgress(50);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initData$2(View view) {
        this.mOnProgressChangedListener.onProgressChanged((BubbleSeekBar) null, 75, 75.0f, true);
        setProgress(75);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initData$3(View view) {
        this.mOnProgressChangedListener.onProgressChanged((BubbleSeekBar) null, 100, 100.0f, true);
        setProgress(100);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void updateNormalViewUi(TextView textView) {
        textView.setBackgroundResource(R.drawable.shape_etp_symbol_guide_bg);
        textView.setTextColor(this.mNormalTextColor);
    }

    private void updateSelectViewUi(TextView textView) {
        if (this.mIsBuy) {
            if (w.l()) {
                textView.setBackgroundResource(R.drawable.shape_seekbar_red_bg);
            } else {
                textView.setBackgroundResource(R.drawable.shape_seekbar_green_bg);
            }
        } else if (w.l()) {
            textView.setBackgroundResource(R.drawable.shape_seekbar_green_bg);
        } else {
            textView.setBackgroundResource(R.drawable.shape_seekbar_red_bg);
        }
        textView.setTextColor(this.mSelectTextColor);
    }

    private void updateSelectViewUiV2(TextView textView) {
        if (this.mSelectTextColor == ContextCompat.getColor(getContext(), R.color.baseColorShadeButtonRedStart)) {
            textView.setBackgroundResource(R.drawable.shape_seekbar_red_bg);
        } else {
            textView.setBackgroundResource(R.drawable.shape_seekbar_green_bg);
        }
        textView.setTextColor(this.mSelectTextColor);
    }

    public int getProgress() {
        return this.mCurrentProgress;
    }

    public void setIsBuy(boolean z11) {
        this.mIsBuy = z11;
    }

    public void setOnProgressChangedListener(BubbleSeekBar.OnProgressChangedListener onProgressChangedListener) {
        this.mOnProgressChangedListener = onProgressChangedListener;
    }

    public void setProgress(int i11) {
        if (i11 == 25) {
            if (this.mV2) {
                updateSelectViewUiV2(this.mTv25);
            } else {
                updateSelectViewUi(this.mTv25);
            }
            updateNormalViewUi(this.mTv50);
            updateNormalViewUi(this.mTv75);
            updateNormalViewUi(this.mTv100);
        } else if (i11 == 50) {
            if (this.mV2) {
                updateSelectViewUiV2(this.mTv50);
            } else {
                updateSelectViewUi(this.mTv50);
            }
            updateNormalViewUi(this.mTv25);
            updateNormalViewUi(this.mTv75);
            updateNormalViewUi(this.mTv100);
        } else if (i11 == 75) {
            if (this.mV2) {
                updateSelectViewUiV2(this.mTv75);
            } else {
                updateSelectViewUi(this.mTv75);
            }
            updateNormalViewUi(this.mTv25);
            updateNormalViewUi(this.mTv50);
            updateNormalViewUi(this.mTv100);
        } else if (i11 == 100) {
            if (this.mV2) {
                updateSelectViewUiV2(this.mTv100);
            } else {
                updateSelectViewUi(this.mTv100);
            }
            updateNormalViewUi(this.mTv25);
            updateNormalViewUi(this.mTv50);
            updateNormalViewUi(this.mTv75);
        } else {
            updateNormalViewUi(this.mTv25);
            updateNormalViewUi(this.mTv50);
            updateNormalViewUi(this.mTv75);
            updateNormalViewUi(this.mTv100);
        }
        this.mCurrentProgress = i11;
    }

    public void setSecondTrackColor(int i11) {
        this.mSelectTextColor = i11;
    }

    public void setThumbBitmap(int i11) {
    }

    public TradeRangeBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setSecondTrackColor(boolean z11, int i11) {
        this.mV2 = z11;
        this.mSelectTextColor = i11;
    }

    public TradeRangeBarView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mIsBuy = true;
        this.mV2 = false;
        this.mSelectTextColor = ContextCompat.getColor(getContext(), R.color.baseColorMajorTheme100);
        this.mNormalTextColor = ContextCompat.getColor(getContext(), R.color.baseColorSecondaryIconButton);
        initData();
    }
}
