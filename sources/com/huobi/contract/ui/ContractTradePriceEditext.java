package com.huobi.contract.ui;

import android.content.Context;
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
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.contract.R$styleable;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.k4;
import dj.u1;
import java.util.Locale;

public class ContractTradePriceEditext extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f43395b;

    /* renamed from: c  reason: collision with root package name */
    public int f43396c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f43397d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f43398e;

    /* renamed from: f  reason: collision with root package name */
    public View f43399f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43400g;

    /* renamed from: h  reason: collision with root package name */
    public TradeType f43401h;

    /* renamed from: i  reason: collision with root package name */
    public k4 f43402i;

    /* renamed from: j  reason: collision with root package name */
    public HuobiKeyboardHelper f43403j;

    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (ContractTradePriceEditext.this.f43402i != null) {
                ContractTradePriceEditext.this.f43402i.onFocusChange(view, z11);
            }
            if (ContractTradePriceEditext.this.f43395b == 0 && z11) {
                if (ContractTradePriceEditext.this.f43396c == 2) {
                    ContractTradePriceEditext.this.f43397d.setText("");
                }
                ContractTradePriceEditext.this.setPriceInputType(1);
            }
        }
    }

    public ContractTradePriceEditext(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view) {
        this.f43397d.setText(R$string.contract_trade_rival_price);
        setPriceInputType(2);
        this.f43397d.clearFocus();
        this.f43403j.hideKeyboard();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void setViewVisiablity(int i11) {
        this.f43399f.setVisibility(i11);
    }

    public final void f(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R$layout.layout_custom_contract_trade_price_editext, this, true);
        this.f43397d = (EditText) findViewById(R$id.input_price_et);
        this.f43398e = (TextView) findViewById(R$id.trade_price_label_tv);
        this.f43400g = (TextView) findViewById(R$id.trade_rival_price_tv);
        this.f43399f = findViewById(R$id.trade_input_divider);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CustomContractTradePriceEditText);
        if (obtainStyledAttributes != null) {
            this.f43397d.setHint(obtainStyledAttributes.getString(R$styleable.CustomContractTradePriceEditText_contract_price_eidttext_hint));
            this.f43398e.setText(obtainStyledAttributes.getString(R$styleable.CustomContractTradePriceEditText_contract_price_label_text));
            int integer = obtainStyledAttributes.getInteger(R$styleable.CustomContractTradePriceEditText_contract_price_label_text_visiablity, 0);
            if (integer == 0) {
                this.f43398e.setVisibility(0);
            } else if (integer == 1) {
                this.f43398e.setVisibility(4);
            } else if (integer != 2) {
                this.f43398e.setVisibility(0);
            } else {
                this.f43398e.setVisibility(8);
            }
            int integer2 = obtainStyledAttributes.getInteger(R$styleable.CustomContractTradePriceEditText_contract_price_divider_visiablity, 0);
            if (integer2 == 0) {
                this.f43399f.setVisibility(0);
                this.f43400g.setVisibility(0);
            } else if (integer2 == 1) {
                this.f43399f.setVisibility(4);
                this.f43400g.setVisibility(4);
            } else if (integer2 != 2) {
                this.f43399f.setVisibility(0);
                this.f43400g.setVisibility(0);
            } else {
                this.f43399f.setVisibility(8);
                this.f43400g.setVisibility(8);
            }
            this.f43395b = obtainStyledAttributes.getInteger(R$styleable.CustomContractTradePriceEditText_contract_price_input_user_type, 0);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CustomContractTradePriceEditText_contract_price_editext_paddingleft, PixelUtils.a(10.0f));
            EditText editText = this.f43397d;
            editText.setPadding(dimensionPixelSize, editText.getTop(), this.f43397d.getRight(), this.f43397d.getBottom());
            obtainStyledAttributes.recycle();
        }
        g();
    }

    public final void g() {
        this.f43400g.setOnClickListener(new u1(this));
        this.f43397d.setOnFocusChangeListener(new a());
    }

    public EditText getEditText() {
        return this.f43397d;
    }

    public int getTradePriceType() {
        return this.f43396c;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (BaseModuleConfig.a().a()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        ContractModuleConfig.a().h(this.f43401h, getContext());
        return true;
    }

    public void setDividerVisibility(int i11) {
        this.f43399f.setVisibility(i11);
        this.f43400g.setVisibility(i11);
    }

    public void setEditHint(int i11) {
        this.f43397d.setHint(i11);
    }

    public void setHintText(String str) {
        this.f43397d.setHint(str);
    }

    public void setKeyboardHelper(HuobiKeyboardHelper huobiKeyboardHelper) {
        this.f43403j = huobiKeyboardHelper;
    }

    public void setLabel(int i11) {
        this.f43398e.setText(i11);
    }

    public void setLabelVisibility(int i11) {
        this.f43398e.setVisibility(i11);
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.f43402i = k4Var;
    }

    public void setPriceInputType(int i11) {
        this.f43396c = i11;
        if (i11 == 1) {
            this.f43399f.setVisibility(0);
            this.f43400g.setVisibility(0);
            this.f43398e.setVisibility(8);
        } else if (i11 == 2) {
            this.f43399f.setVisibility(8);
            this.f43400g.setVisibility(8);
            this.f43398e.setVisibility(0);
        }
    }

    public void setTradeType(TradeType tradeType) {
        this.f43401h = tradeType;
    }

    public void setTradeUseType(int i11) {
        this.f43395b = i11;
    }

    public ContractTradePriceEditext(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43396c = 1;
        this.f43401h = TradeType.CONTRACT;
        f(attributeSet);
    }

    public void setHintText(int i11) {
        this.f43397d.setHint(i11);
    }

    public void setLabel(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f43398e.setText(str.toUpperCase(Locale.US));
        }
    }
}
