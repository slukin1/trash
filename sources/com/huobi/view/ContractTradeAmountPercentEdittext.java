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
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.R$styleable;
import com.huobi.feature.util.FutureTpSlHelper;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.seekbar.MultiColorSeekBar;
import dj.k4;
import java.util.Locale;
import pro.huobi.R;
import sn.f;
import tg.r;

public class ContractTradeAmountPercentEdittext extends FrameLayout {
    /* access modifiers changed from: private */
    public int amountType;
    public HuobiKeyboardHelper keyboardHelper;
    private MultiColorSeekBar mContractSeekBarNew;
    private View mEditAreaContainer;
    private EditText mInputEt;
    /* access modifiers changed from: private */
    public String mLabel;
    /* access modifiers changed from: private */
    public TextView mLabelTv;
    private TradeType mTradeType;
    private k4 onEditTextFocusChangeListener;

    public ContractTradeAmountPercentEdittext(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void hideSoftAndClearFocus() {
        HuobiKeyboardHelper huobiKeyboardHelper = this.keyboardHelper;
        if (huobiKeyboardHelper != null) {
            huobiKeyboardHelper.hideKeyboard();
        }
    }

    private void init(AttributeSet attributeSet, Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_contract_trade_amount_percent_edittext, this, true);
        this.mEditAreaContainer = findViewById(R.id.edit_area);
        this.mInputEt = (EditText) findViewById(R.id.input_amount_et);
        this.mLabelTv = (TextView) findViewById(R.id.trade_amount_label_tv);
        MultiColorSeekBar multiColorSeekBar = (MultiColorSeekBar) findViewById(R.id.contract_seekbar_new);
        this.mContractSeekBarNew = multiColorSeekBar;
        multiColorSeekBar.getConfigBuilder().colorConfig(getContext(), NightHelper.e().g(), true).build();
        initListener();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CustomHorizontalTradeAmountEditText);
        this.mInputEt.setHint(obtainStyledAttributes.getString(2));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, PixelUtils.a(10.0f));
        EditText editText = this.mInputEt;
        editText.setPadding(dimensionPixelSize, editText.getTop(), this.mInputEt.getRight(), this.mInputEt.getBottom());
        obtainStyledAttributes.recycle();
    }

    private void initListener() {
        this.mInputEt.setOnFocusChangeListener(new a0(this));
        this.mInputEt.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (ContractTradeAmountPercentEdittext.this.amountType == 0) {
                    ContractTradeAmountPercentEdittext.this.mLabelTv.setText(ContractTradeAmountPercentEdittext.this.mLabel);
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
            this.mInputEt.setText("");
            this.mContractSeekBarNew.setProgress(0.0f);
        }
        k4 k4Var = this.onEditTextFocusChangeListener;
        if (k4Var != null) {
            k4Var.onFocusChange(view, z11);
        }
    }

    public int getAmountType() {
        return this.amountType;
    }

    public EditText getEditText() {
        return this.mInputEt;
    }

    public void initProgressListener(final FutureTpSlHelper.l lVar) {
        this.mContractSeekBarNew.setOnProgressChangedListener(new MultiColorSeekBar.OnProgressChangedListener() {
            public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
            }

            public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            }

            public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
                if (z11) {
                    int unused = ContractTradeAmountPercentEdittext.this.amountType = 5;
                    FutureTpSlHelper.l lVar = lVar;
                    if (lVar != null) {
                        lVar.onProgress(i11);
                    }
                    ContractTradeAmountPercentEdittext.this.hideSoftAndClearFocus();
                }
            }
        });
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (r.x().F0()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        f.f(this.mTradeType, getContext());
        return true;
    }

    public void setAmountType(int i11) {
        this.amountType = i11;
    }

    public void setEditAreaBackgroundResource(int i11) {
        this.mEditAreaContainer.setBackgroundResource(i11);
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

    public ContractTradeAmountPercentEdittext(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setLabel(String str) {
        if (!TextUtils.isEmpty(str)) {
            String upperCase = str.toUpperCase(Locale.US);
            this.mLabel = upperCase;
            this.mLabelTv.setText(upperCase);
        }
    }

    public ContractTradeAmountPercentEdittext(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet, context);
    }
}
