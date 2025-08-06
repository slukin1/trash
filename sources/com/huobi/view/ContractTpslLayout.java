package com.huobi.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.contract.ui.ContractTpslEditText;
import com.huobi.feature.bean.FutureTpSlSettingParams;
import pro.huobi.R;

public class ContractTpslLayout extends LinearLayout {
    private View mContractAdvancedLayout;
    private ImageView mContractSlClearIv;
    private View mContractSlEntrustLayout;
    private TextView mContractSlEntrustTv;
    private EditText mContractSlEt;
    private ContractTpslEditText mContractSlLayout;
    private View mContractSlTriggerLayout;
    private TextView mContractSlTriggerTv;
    private ImageView mContractTpClearIv;
    private View mContractTpEntrustLayout;
    private TextView mContractTpEntrustTv;
    private EditText mContractTpEt;
    private ContractTpslEditText mContractTpLayout;
    private View mContractTpSlInclude;
    private View mContractTpSlInputContainer;
    private View mContractTpSlSwitchContainer;
    private CheckBox mContractTpSlSwitchIv;
    private View mContractTpSlSwitchIvContainer;
    private BottomLineTextView mContractTpSlTv;
    private View mContractTpTriggerLayout;
    private TextView mContractTpTriggerTv;
    private TextView mContractTpslAdvancedTv;
    private TextView mTpSlTagTv;
    private TradeType tradeType;

    public ContractTpslLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(AttributeSet attributeSet) {
    }

    public static boolean isLimitlOrder(int i11) {
        return i11 == 0 || i11 == 2 || i11 == 3 || i11 == 4;
    }

    public static boolean supportTpslOrder(int i11) {
        return i11 == 0 || i11 == 6 || i11 == 2 || i11 == 3 || i11 == 4;
    }

    public void changeTradeOrderType(int i11, int i12, FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
        if (!supportTpslOrder(i11)) {
            this.mContractTpSlInclude.setVisibility(8);
        } else if (i12 == 0) {
            this.mContractTpSlInclude.setVisibility(0);
            this.mContractTpSlSwitchContainer.setVisibility(0);
            if (this.mContractTpSlSwitchIv.isChecked()) {
                refreshTpSlView(futureTpSlSettingParams, futureTpSlSettingParams2);
                this.mContractTpslAdvancedTv.setVisibility(0);
                return;
            }
            this.mContractTpSlInputContainer.setVisibility(8);
            this.mContractAdvancedLayout.setVisibility(8);
            this.mContractTpslAdvancedTv.setVisibility(8);
        } else {
            this.mContractTpSlInclude.setVisibility(8);
        }
    }

    public String getEntrustPrice(FutureTpSlSettingParams futureTpSlSettingParams) {
        String str;
        if (!"limit".equals(futureTpSlSettingParams.getPriceType().getType()) && !TextUtils.isEmpty(futureTpSlSettingParams.getPriceType().getType())) {
            return futureTpSlSettingParams.getPriceType().getName();
        }
        if (futureTpSlSettingParams.getEntrustPrice() == null) {
            return "";
        }
        if (this.tradeType == TradeType.LINEAR_SWAP) {
            str = "USDT";
        } else {
            str = getResources().getString(R.string.usd_en_uppercase);
        }
        return futureTpSlSettingParams.getEntrustPrice().toPlainString() + " " + str;
    }

    public String getTriggerPrice(FutureTpSlSettingParams futureTpSlSettingParams) {
        String str;
        if (futureTpSlSettingParams.getTriggerPrice() == null) {
            return "";
        }
        if (this.tradeType == TradeType.LINEAR_SWAP) {
            str = "USDT";
        } else {
            str = getResources().getString(R.string.usd_en_uppercase);
        }
        return futureTpSlSettingParams.getTriggerPrice().toPlainString() + " " + str;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mContractTpSlInclude = findViewById(R.id.contract_tp_sl_include);
        this.mContractTpSlSwitchContainer = findViewById(R.id.contract_tp_sl_switch_container);
        this.mContractTpSlSwitchIvContainer = findViewById(R.id.contract_tp_sl_switch_iv_container);
        BottomLineTextView bottomLineTextView = (BottomLineTextView) findViewById(R.id.contract_tp_sl_tv);
        this.mContractTpSlTv = bottomLineTextView;
        bottomLineTextView.setBottomLineText(getContext().getString(R.string.n_contract_trade_trend_stop));
        this.mContractTpSlTv.setTextColor(R.color.baseColorSecondaryText);
        this.mContractTpSlSwitchIv = (CheckBox) findViewById(R.id.contract_tp_sl_switch_iv);
        this.mContractTpSlInputContainer = findViewById(R.id.contract_tp_sl_input_container);
        this.mContractTpslAdvancedTv = (TextView) findViewById(R.id.tp_sl_advanced_tv);
        ContractTpslEditText contractTpslEditText = (ContractTpslEditText) findViewById(R.id.contract_tp_input_container);
        this.mContractTpLayout = contractTpslEditText;
        this.mContractTpEt = contractTpslEditText.getEditText();
        this.mContractTpClearIv = this.mContractTpLayout.getClearImageView();
        ContractTpslEditText contractTpslEditText2 = (ContractTpslEditText) findViewById(R.id.contract_sl_input_container);
        this.mContractSlLayout = contractTpslEditText2;
        this.mContractSlEt = contractTpslEditText2.getEditText();
        this.mContractSlClearIv = this.mContractSlLayout.getClearImageView();
        this.mContractAdvancedLayout = findViewById(R.id.contract_advanced_container);
        this.mContractTpTriggerLayout = findViewById(R.id.contract_tp_trigger_layout);
        this.mContractTpTriggerTv = (TextView) findViewById(R.id.contract_tp_trigger_text);
        this.mContractTpEntrustLayout = findViewById(R.id.contract_tp_entrust_layout);
        this.mContractTpEntrustTv = (TextView) findViewById(R.id.contract_tp_entrust_text);
        this.mContractSlTriggerLayout = findViewById(R.id.contract_sl_trigger_layout);
        this.mContractSlTriggerTv = (TextView) findViewById(R.id.contract_sl_trigger_text);
        this.mContractSlEntrustLayout = findViewById(R.id.contract_sl_entrust_layout);
        this.mContractSlEntrustTv = (TextView) findViewById(R.id.contract_sl_entrust_text);
    }

    public boolean paramsIsAdvanced(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
        return (futureTpSlSettingParams != null && futureTpSlSettingParams.isTpslAdvanced()) || (futureTpSlSettingParams2 != null && futureTpSlSettingParams2.isTpslAdvanced());
    }

    public void refreshTpSlView(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
        if (paramsIsAdvanced(futureTpSlSettingParams, futureTpSlSettingParams2)) {
            this.mContractTpslAdvancedTv.setText(getResources().getString(R.string.n_im_group_noti_edit));
            if (this.mContractTpSlSwitchIv.isChecked()) {
                this.mContractAdvancedLayout.setVisibility(0);
            }
            this.mContractTpSlInputContainer.setVisibility(8);
            if (futureTpSlSettingParams == null || !futureTpSlSettingParams.isTpslAdvanced()) {
                this.mContractTpTriggerLayout.setVisibility(8);
                this.mContractTpEntrustLayout.setVisibility(8);
            } else {
                this.mContractTpTriggerLayout.setVisibility(0);
                this.mContractTpEntrustLayout.setVisibility(0);
                this.mContractTpTriggerTv.setText(getTriggerPrice(futureTpSlSettingParams));
                this.mContractTpEntrustTv.setText(getEntrustPrice(futureTpSlSettingParams));
            }
            if (futureTpSlSettingParams2 == null || !futureTpSlSettingParams2.isTpslAdvanced()) {
                this.mContractSlTriggerLayout.setVisibility(8);
                this.mContractSlEntrustLayout.setVisibility(8);
                return;
            }
            this.mContractSlTriggerLayout.setVisibility(0);
            this.mContractSlEntrustLayout.setVisibility(0);
            this.mContractSlTriggerTv.setText(getTriggerPrice(futureTpSlSettingParams2));
            this.mContractSlEntrustTv.setText(getEntrustPrice(futureTpSlSettingParams2));
            return;
        }
        this.mContractTpslAdvancedTv.setText(getResources().getString(R.string.n_contract_tpsl_advanced));
        this.mContractAdvancedLayout.setVisibility(8);
        if (this.mContractTpSlSwitchIv.isChecked()) {
            this.mContractTpSlInputContainer.setVisibility(0);
        }
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public ContractTpslLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContractTpslLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.tradeType = TradeType.LINEAR_SWAP;
        init(attributeSet);
    }
}
