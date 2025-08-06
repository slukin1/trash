package com.huobi.view;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.login.bean.JumpTarget;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.m;
import java.util.HashMap;
import oa.a;
import pro.huobi.R;
import rn.c;
import tg.r;

public class TradeIceBergLayout extends LinearLayout {
    /* access modifiers changed from: private */
    public Callback callback;
    /* access modifiers changed from: private */
    public EditText mAmountEt;
    private BottomLineTextView mIceBergLineTv;
    private CheckBox mIceBergSwitchCb;
    /* access modifiers changed from: private */
    public View mLayoutAmount;
    private TradeType mTradeType;
    private TextView mTvAmountLabel;
    private int tradeViewType;

    public interface Callback {
        void afterTextChanged(EditText editText, String str);

        int getTradePricePrecision();

        void onCheckedChange(CompoundButton compoundButton, boolean z11);
    }

    public TradeIceBergLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void commonSensorParams(HashMap<String, String> hashMap) {
        int i11 = this.tradeViewType;
        if (i11 == 0) {
            hashMap.put("type", "limit_order");
        } else if (i11 == 2) {
            hashMap.put("type", "stop_limit_order");
        } else if (i11 == 3) {
            hashMap.put("type", "trigger_order");
        }
        TradeType tradeType = this.mTradeType;
        if (tradeType == TradeType.MARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
        } else if (tradeType == TradeType.SUPERMARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
        } else {
            hashMap.put("trade_mode", RankScreenBean.SCREEN_VALUE_SPOT);
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_trade_iceberg, this, true);
        setOrientation(1);
        this.mLayoutAmount = findViewById(R.id.layout_amount);
        this.mAmountEt = (EditText) findViewById(R.id.input_amount_et);
        this.mTvAmountLabel = (TextView) findViewById(R.id.label_amount_tv);
        this.mLayoutAmount.setBackgroundResource(R.drawable.selector_custom_edittext_buy_bg);
        this.mIceBergLineTv = (BottomLineTextView) findViewById(R.id.iceberg_line_tv);
        this.mIceBergSwitchCb = (CheckBox) findViewById(R.id.iceberg_line_switch_cb);
        initListener();
    }

    private void initListener() {
        this.mAmountEt.setKeyListener(DigitsKeyListener.getInstance(false, true));
        this.mAmountEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                if (!z11) {
                    TradeIceBergLayout.this.mAmountEt.setSelection(0);
                } else {
                    HashMap hashMap = new HashMap();
                    TradeIceBergLayout.this.commonSensorParams(hashMap);
                    g.i("app_trade_order_type_iceamount_click", hashMap);
                }
                TradeIceBergLayout.this.mLayoutAmount.setSelected(z11);
            }
        });
        this.mAmountEt.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    TradeIceBergLayout.this.mAmountEt.setTypeface(ResourcesCompat.h(TradeIceBergLayout.this.getContext(), R.font.roboto_regular));
                } else {
                    TradeIceBergLayout.this.mAmountEt.setTypeface(ResourcesCompat.h(TradeIceBergLayout.this.getContext(), R.font.roboto_medium));
                }
                if (TradeIceBergLayout.this.callback != null) {
                    String b11 = m.b(editable, 20, TradeIceBergLayout.this.callback.getTradePricePrecision());
                    if (b11 != null) {
                        TradeIceBergLayout.this.mAmountEt.setText(b11);
                        TradeIceBergLayout.this.mAmountEt.setSelection(b11.length());
                        TradeIceBergLayout.this.callback.afterTextChanged(TradeIceBergLayout.this.mAmountEt, b11);
                        return;
                    }
                    TradeIceBergLayout.this.callback.afterTextChanged(TradeIceBergLayout.this.mAmountEt, editable.toString().trim());
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.mIceBergLineTv.setOnClickListener(new a2(this));
        this.mIceBergSwitchCb.setOnCheckedChangeListener(new b2(this));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$1(View view) {
        DialogUtils.X((FragmentActivity) a.g().b(), "", getResources().getString(R.string.n_trade_iceberg_dialog_content), "", getResources().getString(R.string.n_known), c2.f19007a);
        HashMap hashMap = new HashMap();
        commonSensorParams(hashMap);
        g.i("app_trade_order_type_ice_content_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$2(CompoundButton compoundButton, boolean z11) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onCheckedChange(compoundButton, z11);
        }
        HashMap hashMap = new HashMap();
        if (z11) {
            this.mLayoutAmount.setVisibility(0);
            hashMap.put("button_type", "open");
        } else {
            this.mLayoutAmount.setVisibility(8);
            reset();
            hashMap.put("button_type", "close");
        }
        commonSensorParams(hashMap);
        g.i("app_trade_order_type_ice_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    public void clearInnerFocus() {
        this.mAmountEt.clearFocus();
    }

    public EditText getAmountEt() {
        return this.mAmountEt;
    }

    public String getAmountText() {
        return this.mAmountEt.getText().toString();
    }

    public boolean isChecked() {
        return this.mIceBergSwitchCb.isChecked();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (r.x().F0()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        c.i().d(getContext(), new JumpTarget((Intent) null, (Intent) null));
        return true;
    }

    public void reset() {
        this.mAmountEt.setText("");
    }

    public void setAmountLabel(String str) {
        this.mTvAmountLabel.setText(str);
    }

    public void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public void setParams(int i11, TradeType tradeType) {
        this.tradeViewType = i11;
        this.mTradeType = tradeType;
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

    public TradeIceBergLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TradeIceBergLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mTradeType = TradeType.PRO;
        init();
    }
}
