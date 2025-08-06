package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.k4;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import sn.f;
import tg.r;

public class HorizontalTradeAmountPercentEdittext extends LinearLayout implements View.OnClickListener {
    private TextView absolutelyTv;
    private AmountCallback amountCallback;
    /* access modifiers changed from: private */
    public int amountType;
    public HuobiKeyboardHelper keyboardHelper;
    /* access modifiers changed from: private */
    public String label;
    private Context mContext;
    private EditText mInputEt;
    /* access modifiers changed from: private */
    public TextView mLabelTv;
    private View mTradeInputDivider;
    private TradeType mTradeType;
    private k4 onEditTextFocusChangeListener;
    private TextView persentHalfTv;
    private LinearLayout persentLl;
    private TextView persentQuarterTv;
    private TextView threeQuartersTv;
    private List<TextView> viewList;

    public interface AmountCallback {
        void onAmountPercentClick(int i11);
    }

    public HorizontalTradeAmountPercentEdittext(Context context) {
        this(context, (AttributeSet) null);
    }

    private void bindSelectChangeUi(int i11) {
        int color = getContext().getResources().getColor(R.color.color_horizontal_trade_amount_percent_select);
        int color2 = getContext().getResources().getColor(R.color.color_horizontal_trade_amount_percent_unselect);
        int color3 = getContext().getResources().getColor(R.color.color_horizontal_trade_amount_percent_select_bg);
        int size = this.viewList.size();
        for (int i12 = 0; i12 < size; i12++) {
            TextView textView = this.viewList.get(i12);
            if (textView.getId() == i11) {
                textView.setTextColor(color);
                textView.setBackgroundColor(color3);
            } else {
                textView.setTextColor(color2);
                textView.setBackgroundColor(0);
            }
        }
    }

    private void hideSoftAndClearFocus() {
        HuobiKeyboardHelper huobiKeyboardHelper = this.keyboardHelper;
        if (huobiKeyboardHelper != null) {
            huobiKeyboardHelper.hideKeyboard();
        }
    }

    private void init(AttributeSet attributeSet, Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(R.layout.layout_horizontal_trade_amount_percent_edittext, this, true);
        this.mInputEt = (EditText) findViewById(R.id.input_amount_et);
        this.mLabelTv = (TextView) findViewById(R.id.trade_amount_label_tv);
        this.mTradeInputDivider = findViewById(R.id.trade_input_divider);
        this.persentQuarterTv = (TextView) findViewById(R.id.persent_quarter_tv);
        this.persentHalfTv = (TextView) findViewById(R.id.persent_half_tv);
        this.threeQuartersTv = (TextView) findViewById(R.id.three_quarters_tv);
        this.absolutelyTv = (TextView) findViewById(R.id.absolutely_tv);
        this.persentLl = (LinearLayout) findViewById(R.id.persent_ll);
        this.viewList.add(this.persentQuarterTv);
        this.viewList.add(this.persentHalfTv);
        this.viewList.add(this.threeQuartersTv);
        this.viewList.add(this.absolutelyTv);
        initListener();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CustomHorizontalTradeAmountEditText);
        if (obtainStyledAttributes != null) {
            this.mInputEt.setHint(obtainStyledAttributes.getString(2));
            String string = obtainStyledAttributes.getString(3);
            this.label = string;
            this.mLabelTv.setText(string);
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
            obtainStyledAttributes.recycle();
        }
    }

    private void initListener() {
        this.persentQuarterTv.setOnClickListener(this);
        this.persentHalfTv.setOnClickListener(this);
        this.threeQuartersTv.setOnClickListener(this);
        this.absolutelyTv.setOnClickListener(this);
        this.mInputEt.setOnFocusChangeListener(new s0(this));
        this.mInputEt.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (HorizontalTradeAmountPercentEdittext.this.amountType == 0) {
                    HorizontalTradeAmountPercentEdittext.this.mLabelTv.setText(HorizontalTradeAmountPercentEdittext.this.label);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$0(View view, boolean z11) {
        if (z11 && this.amountType != 0) {
            HuobiKeyboardHelper huobiKeyboardHelper = this.keyboardHelper;
            if (huobiKeyboardHelper != null) {
                huobiKeyboardHelper.showKeyboard(this.mInputEt);
            }
            setAmountType(0);
        }
        k4 k4Var = this.onEditTextFocusChangeListener;
        if (k4Var != null) {
            k4Var.onFocusChange(view, z11);
        }
    }

    private void setViewVisiablity(int i11) {
        this.mTradeInputDivider.setVisibility(i11);
    }

    public int getAmountType() {
        return this.amountType;
    }

    public EditText getEditText() {
        return this.mInputEt;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        switch (id2) {
            case R.id.absolutely_tv:
                bindSelectChangeUi(id2);
                setAmountType(4);
                hideSoftAndClearFocus();
                break;
            case R.id.persent_half_tv:
                bindSelectChangeUi(id2);
                setAmountType(2);
                hideSoftAndClearFocus();
                break;
            case R.id.persent_quarter_tv:
                bindSelectChangeUi(id2);
                setAmountType(1);
                hideSoftAndClearFocus();
                break;
            case R.id.three_quarters_tv:
                bindSelectChangeUi(id2);
                setAmountType(3);
                hideSoftAndClearFocus();
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (r.x().F0()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        f.f(this.mTradeType, getContext());
        return true;
    }

    public void setAmountCallback(AmountCallback amountCallback2) {
        this.amountCallback = amountCallback2;
    }

    public void setAmountType(int i11) {
        this.amountType = i11;
        AmountCallback amountCallback2 = this.amountCallback;
        if (amountCallback2 != null) {
            amountCallback2.onAmountPercentClick(i11);
        }
    }

    public void setEditHint(int i11) {
        this.mInputEt.setHint(i11);
    }

    public void setKeyboardHelper(HuobiKeyboardHelper huobiKeyboardHelper) {
        this.keyboardHelper = huobiKeyboardHelper;
    }

    public void setLabel(int i11) {
        setLabel(getResources().getString(i11));
    }

    public void setLabelVisiablity(int i11) {
        this.mLabelTv.setVisibility(i11);
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.onEditTextFocusChangeListener = k4Var;
    }

    public void setTradeType(TradeType tradeType) {
        this.mTradeType = tradeType;
    }

    public HorizontalTradeAmountPercentEdittext(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setLabel(String str) {
        if (!TextUtils.isEmpty(str)) {
            Locale locale = Locale.US;
            this.label = str.toUpperCase(locale);
            this.mLabelTv.setText(str.toUpperCase(locale));
        }
    }

    public HorizontalTradeAmountPercentEdittext(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.viewList = new ArrayList();
        init(attributeSet, context);
    }
}
