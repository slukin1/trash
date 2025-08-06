package com.huobi.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.huobi.login.bean.JumpTarget;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.HashMap;
import pro.huobi.R;
import rn.c;
import tg.r;

public class TradeMarketAmountVolume extends FrameLayout {
    public static final int TRADE_AMOUNT_FIRST = 0;
    public static final String TRADE_AMOUNT_VOLUME_SP = "TRADE_AMOUNT_VOLUME_SP";
    public static final int TRADE_VOLUME_SECOND = 1;
    private EditText mAmountEt;
    private boolean mIsBuy;
    private View mLayoutAmount;
    private View mLayoutVolume;
    private int mSelectIndex;
    private TradeType mTradeType;
    private TextView mTvAmountLabel;
    private TextView mTvMarketAmount;
    private TextView mTvMarketVolume;
    private TextView mTvVolumeLabel;
    private EditText mVolumeEt;
    private int tradeViewType;

    public TradeMarketAmountVolume(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_trade_amount_volume, this, true);
        setBackgroundResource(R.drawable.selector_custom_edittext_buy_bg);
        this.mTvMarketAmount = (TextView) findViewById(R.id.tv_market_amount);
        this.mTvMarketVolume = (TextView) findViewById(R.id.tv_market_volume);
        this.mLayoutAmount = findViewById(R.id.layout_amount);
        this.mAmountEt = (EditText) findViewById(R.id.input_amount_et);
        this.mTvAmountLabel = (TextView) findViewById(R.id.label_amount_tv);
        this.mLayoutVolume = findViewById(R.id.layout_volume);
        this.mVolumeEt = (EditText) findViewById(R.id.input_volume_et);
        this.mTvVolumeLabel = (TextView) findViewById(R.id.label_volume_tv);
        initListener();
    }

    private void initListener() {
        this.mTvMarketAmount.setOnClickListener(new f2(this));
        this.mTvMarketVolume.setOnClickListener(new e2(this));
        g2 g2Var = new g2(this);
        this.mAmountEt.setOnFocusChangeListener(g2Var);
        this.mVolumeEt.setOnFocusChangeListener(g2Var);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$0(View view) {
        setSelect(0);
        track(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$1(View view) {
        setSelect(1);
        track(1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$2(View view, boolean z11) {
        setSelected(this.mAmountEt.hasFocus() || this.mVolumeEt.hasFocus());
    }

    private void track(int i11) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("select", i11 == 0 ? FirebaseAnalytics.Param.QUANTITY : "total");
        TradeType tradeType = this.mTradeType;
        if (tradeType == TradeType.MARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
        } else if (tradeType == TradeType.SUPERMARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
        } else {
            hashMap.put("trade_mode", RankScreenBean.SCREEN_VALUE_SPOT);
        }
        int i12 = this.tradeViewType;
        if (i12 == 1) {
            g.i("app_trade_market_select_click", hashMap);
        } else if (i12 == 3) {
            g.i("app_Trigger_market_select_click", hashMap);
        }
    }

    public void clearInnerFocus() {
        this.mAmountEt.clearFocus();
        this.mVolumeEt.clearFocus();
    }

    public EditText getAmountEt() {
        return this.mAmountEt;
    }

    public String getAmountPrice() {
        return this.mAmountEt.getText().toString();
    }

    public EditText getVolumeEt() {
        return this.mVolumeEt;
    }

    public String getVolumePrice() {
        return this.mVolumeEt.getText().toString();
    }

    public void initDataAndTab(boolean z11, int i11, TradeType tradeType) {
        setParams(i11, tradeType);
        setBuy(z11);
    }

    public boolean isSelectedMarketAmount() {
        return this.mSelectIndex == 0;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (r.x().F0()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        c.i().d(getContext(), new JumpTarget((Intent) null, (Intent) null));
        return true;
    }

    public void reset() {
        this.mVolumeEt.setText("");
        this.mAmountEt.setText("");
    }

    public void setAmountLabel(String str) {
        this.mTvAmountLabel.setText(str);
    }

    public void setBuy(boolean z11) {
        this.mIsBuy = z11;
        setSelect(SP.e(TRADE_AMOUNT_VOLUME_SP + this.mIsBuy, this.mIsBuy ? 1 : 0));
    }

    public void setParams(int i11, TradeType tradeType) {
        this.tradeViewType = i11;
        this.mTradeType = tradeType;
    }

    public void setSelect(int i11) {
        if (i11 == 0) {
            this.mTvMarketAmount.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.mTvMarketVolume.setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
            this.mLayoutAmount.setVisibility(0);
            this.mLayoutVolume.setVisibility(8);
        } else {
            this.mTvMarketAmount.setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
            this.mTvMarketVolume.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.mLayoutAmount.setVisibility(8);
            this.mLayoutVolume.setVisibility(0);
        }
        this.mSelectIndex = i11;
        SP.q(TRADE_AMOUNT_VOLUME_SP + this.mIsBuy, i11);
    }

    public void setVolumeLabel(String str) {
        this.mTvVolumeLabel.setText(str);
    }

    public void updateAmount(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mAmountEt.setText("");
        } else {
            this.mAmountEt.setText(str);
        }
        if (TextUtils.isEmpty(this.mAmountEt.getText())) {
            this.mAmountEt.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
        } else {
            this.mAmountEt.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        }
    }

    public void updateTotalVolume(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mVolumeEt.setText("");
        } else {
            this.mVolumeEt.setText(str);
        }
        if (TextUtils.isEmpty(this.mVolumeEt.getText())) {
            this.mVolumeEt.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
        } else {
            this.mVolumeEt.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        }
    }

    public TradeMarketAmountVolume(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TradeMarketAmountVolume(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mSelectIndex = 0;
        this.mIsBuy = true;
        this.mTradeType = TradeType.PRO;
        init();
    }
}
