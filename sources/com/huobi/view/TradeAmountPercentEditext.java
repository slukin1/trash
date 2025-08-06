package com.huobi.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.R$styleable;
import com.huobi.login.bean.JumpTarget;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import pro.huobi.R;
import rn.c;
import sn.f;
import tg.r;

public class TradeAmountPercentEditext extends LinearLayout implements View.OnClickListener {
    private TextView absolutelyTv;
    private LinearLayout inputAmountLl;
    private int length;
    private EditText mInputEt;
    private TextView mLabelTv;
    private BigDecimal mTotalAmount;
    private View mTradeInputDivider;
    private TradeType mTradeType;
    private TextView persentHalfTv;
    private LinearLayout persentLl;
    private TextView persentQuarterTv;
    private boolean quickTrade;
    private TextView threeQuartersTv;

    public TradeAmountPercentEditext(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_trade_amount_percent_edittext, this, true);
        this.inputAmountLl = (LinearLayout) findViewById(R.id.input_amount_ll);
        this.mInputEt = (EditText) findViewById(R.id.input_amount_et);
        this.mLabelTv = (TextView) findViewById(R.id.trade_amount_label_tv);
        this.mTradeInputDivider = findViewById(R.id.trade_input_divider);
        this.persentQuarterTv = (TextView) findViewById(R.id.persent_quarter_tv);
        this.persentHalfTv = (TextView) findViewById(R.id.persent_half_tv);
        this.threeQuartersTv = (TextView) findViewById(R.id.three_quarters_tv);
        this.absolutelyTv = (TextView) findViewById(R.id.absolutely_tv);
        this.persentLl = (LinearLayout) findViewById(R.id.persent_ll);
        initListener();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CustomContractTradeAmountEditText);
        if (obtainStyledAttributes != null) {
            this.mInputEt.setHint(obtainStyledAttributes.getString(2));
            this.mLabelTv.setText(obtainStyledAttributes.getString(3));
            int integer = obtainStyledAttributes.getInteger(4, 0);
            if (integer == 0) {
                this.mLabelTv.setVisibility(0);
            } else if (integer == 1) {
                this.mLabelTv.setVisibility(4);
            } else if (integer != 2) {
                this.mLabelTv.setVisibility(0);
            } else {
                this.mLabelTv.setVisibility(8);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, PixelUtils.a(10.0f));
            EditText editText = this.mInputEt;
            editText.setPadding(dimensionPixelSize, editText.getTop(), this.mInputEt.getRight(), this.mInputEt.getBottom());
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(0, PixelUtils.a(50.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputAmountLl.getLayoutParams();
            layoutParams.height = dimensionPixelSize2;
            this.inputAmountLl.setLayoutParams(layoutParams);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(5, PixelUtils.a(35.0f));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.persentLl.getLayoutParams();
            layoutParams2.height = dimensionPixelSize3;
            this.persentLl.setLayoutParams(layoutParams2);
            obtainStyledAttributes.recycle();
        }
    }

    private void initListener() {
        this.persentQuarterTv.setOnClickListener(this);
        this.persentHalfTv.setOnClickListener(this);
        this.threeQuartersTv.setOnClickListener(this);
        this.absolutelyTv.setOnClickListener(this);
    }

    private void setViewVisiablity(int i11) {
        this.mTradeInputDivider.setVisibility(i11);
    }

    public EditText getEditText() {
        return this.mInputEt;
    }

    public BigDecimal getTotalAmount() {
        return this.mTotalAmount;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.absolutely_tv:
                this.mInputEt.setText(m.q(this.mTotalAmount, this.length));
                EditText editText = this.mInputEt;
                editText.setSelection(editText.getText().length());
                break;
            case R.id.persent_half_tv:
                this.mInputEt.setText(this.mTotalAmount.divide(new BigDecimal(2), this.length, 1).toPlainString());
                EditText editText2 = this.mInputEt;
                editText2.setSelection(editText2.getText().length());
                break;
            case R.id.persent_quarter_tv:
                this.mInputEt.setText(this.mTotalAmount.divide(new BigDecimal(4), this.length, 1).toPlainString());
                EditText editText3 = this.mInputEt;
                editText3.setSelection(editText3.getText().length());
                break;
            case R.id.three_quarters_tv:
                this.mInputEt.setText(m.q(this.mTotalAmount.multiply(new BigDecimal(0.75d)), this.length));
                EditText editText4 = this.mInputEt;
                editText4.setSelection(editText4.getText().length());
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (r.x().F0()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.quickTrade) {
            c.i().d((Activity) getContext(), new JumpTarget((Intent) null, (Intent) null));
            return true;
        }
        f.f(this.mTradeType, getContext());
        return true;
    }

    public void setEditHint(int i11) {
        this.mInputEt.setHint(i11);
    }

    public void setHintText(String str) {
        this.mInputEt.setHint(str);
    }

    public void setLabel(int i11) {
        this.mLabelTv.setText(i11);
    }

    public void setLabelVisiablity(int i11) {
        this.mLabelTv.setVisibility(i11);
    }

    public void setTotalAmount(BigDecimal bigDecimal, int i11) {
        this.mTotalAmount = bigDecimal;
        this.length = i11;
    }

    public void setTradeType(TradeType tradeType) {
        this.mTradeType = tradeType;
    }

    public TradeAmountPercentEditext(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setHintText(int i11) {
        this.mInputEt.setHint(i11);
    }

    public void setLabel(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mLabelTv.setText(str);
        }
    }

    public void setTradeType(TradeType tradeType, boolean z11) {
        this.mTradeType = tradeType;
        this.quickTrade = z11;
    }

    public TradeAmountPercentEditext(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mTotalAmount = BigDecimal.ZERO;
        this.quickTrade = false;
        init(attributeSet);
    }
}
