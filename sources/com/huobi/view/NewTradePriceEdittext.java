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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.R$styleable;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.login.bean.JumpTarget;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.k4;
import i6.m;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rn.c;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import sn.f;
import tg.r;
import u6.g;

public class NewTradePriceEdittext extends LinearLayout {
    public static final int TRADE_PLANE_LIMIT_TRADE = 4;
    public static final int TRADE_PLANE_MARKET_TRADE = 5;
    public static final int TRADE_PRICE_LIMIT = 1;
    public static final int TRADE_PRICE_MARKET = 2;
    public static final int TRADE_PRICE_STOP = 3;
    /* access modifiers changed from: private */
    public final CompositeSubscription compositeSubscription;
    private BigDecimal count;
    private View.OnClickListener inputPriceRlClickListener;
    private int length;
    private View mAddReduceDivider;
    /* access modifiers changed from: private */
    public EditText mInputEt;
    private TextView mInputPriceConvertTv;
    private LinearLayout mInputPriceRl;
    private TextView mLabelTv;
    private LinearLayout mMarketPriceArea;
    private TextView mMarketPriceText;
    private ImageView mTradeCurrentPriceIv;
    private View mTradeCurrentPriceLl;
    private View mTradeInputDivider;
    private ImageView mTradePriceAddIv;
    private LinearLayout mTradePriceAddLl;
    private ImageView mTradePriceReduceIv;
    private LinearLayout mTradePriceReduceLl;
    private TradeType mTradeType;
    /* access modifiers changed from: private */
    public BigDecimal num;
    private k4 onEditTextFocusChangeListener;
    private boolean quickTrade;

    public class OnAddReduceClickListener implements View.OnClickListener {
        public OnAddReduceClickListener() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            String trim = NewTradePriceEdittext.this.mInputEt.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                BigDecimal unused = NewTradePriceEdittext.this.num = BigDecimal.ZERO;
            } else {
                BigDecimal unused2 = NewTradePriceEdittext.this.num = m.a(trim);
            }
            NewTradePriceEdittext.this.updateInputText(view);
            NewTradePriceEdittext.this.mInputEt.requestFocus();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class OnAddReduceLongClickListener implements View.OnLongClickListener {
        public OnAddReduceLongClickListener() {
        }

        public boolean onLongClick(View view) {
            NewTradePriceEdittext.this.compositeSubscription.add(NewTradePriceEdittext.this.getOnClickObservable(view));
            return false;
        }
    }

    public NewTradePriceEdittext(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public Subscription getOnClickObservable(final View view) {
        return Observable.interval(0, 100, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber<Long>() {
            public void onError(Throwable th2) {
                super.onError(th2);
                unsubscribe();
            }

            public void onNext(Long l11) {
                super.onNext(l11);
                String trim = NewTradePriceEdittext.this.mInputEt.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    BigDecimal unused = NewTradePriceEdittext.this.num = BigDecimal.ZERO;
                } else {
                    BigDecimal unused2 = NewTradePriceEdittext.this.num = m.a(trim);
                }
                if (!view.isLongClickable() || !view.isPressed()) {
                    if (TextUtils.isEmpty(NewTradePriceEdittext.this.mInputEt.getText().toString()) || new BigDecimal(NewTradePriceEdittext.this.mInputEt.getText().toString()).compareTo(BigDecimal.ZERO) > 0) {
                        NewTradePriceEdittext.this.setReduceLongClickable(true);
                    } else {
                        NewTradePriceEdittext.this.setReduceLongClickable(false);
                    }
                    unsubscribe();
                    return;
                }
                NewTradePriceEdittext.this.updateInputText(view);
            }
        });
    }

    private void init(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_new_trade_price_edittext, this, true);
        this.mInputEt = (EditText) findViewById(R.id.input_price_et);
        this.mLabelTv = (TextView) findViewById(R.id.label_price_tv);
        this.mInputPriceConvertTv = (TextView) findViewById(R.id.input_price_convert_tv);
        this.mTradeInputDivider = findViewById(R.id.trade_input_divider);
        this.mTradePriceAddIv = (ImageView) findViewById(R.id.trade_price_add_iv);
        this.mTradePriceReduceIv = (ImageView) findViewById(R.id.trade_price_reduce_iv);
        this.mAddReduceDivider = findViewById(R.id.add_reduce_divider);
        this.mInputPriceRl = (LinearLayout) findViewById(R.id.input_price_rl);
        this.mTradePriceAddLl = (LinearLayout) findViewById(R.id.trade_price_add_ll);
        this.mTradePriceReduceLl = (LinearLayout) findViewById(R.id.trade_price_reduce_ll);
        this.mTradeCurrentPriceLl = findViewById(R.id.trade_current_price_ll);
        this.mTradeCurrentPriceIv = (ImageView) findViewById(R.id.trade_current_price_iv);
        this.mMarketPriceArea = (LinearLayout) findViewById(R.id.ll_market_price_area);
        this.mMarketPriceText = (TextView) findViewById(R.id.tv_market_price);
        initListener();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.NewTradePriceEditText);
        if (obtainStyledAttributes != null) {
            this.mInputEt.setHint(obtainStyledAttributes.getString(3));
            this.mLabelTv.setText(obtainStyledAttributes.getString(4));
            int integer = obtainStyledAttributes.getInteger(5, 0);
            if (integer == 0) {
                this.mLabelTv.setVisibility(0);
            } else if (integer == 1) {
                this.mLabelTv.setVisibility(4);
            } else if (integer != 2) {
                this.mLabelTv.setVisibility(0);
            } else {
                this.mLabelTv.setVisibility(8);
            }
            int integer2 = obtainStyledAttributes.getInteger(0, 0);
            if (integer2 == 0) {
                this.mInputPriceConvertTv.setVisibility(0);
            } else if (integer2 == 1) {
                this.mInputPriceConvertTv.setVisibility(4);
            } else if (integer2 != 2) {
                this.mInputPriceConvertTv.setVisibility(0);
            } else {
                this.mInputPriceConvertTv.setVisibility(8);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, PixelUtils.a(10.0f));
            EditText editText = this.mInputEt;
            editText.setPadding(dimensionPixelSize, editText.getTop(), this.mInputEt.getRight(), this.mInputEt.getBottom());
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, PixelUtils.a(40.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTradePriceAddLl.getLayoutParams();
            layoutParams.width = dimensionPixelSize2;
            this.mTradePriceAddLl.setLayoutParams(layoutParams);
            ((LinearLayout.LayoutParams) this.mTradePriceReduceLl.getLayoutParams()).width = dimensionPixelSize2;
            this.mTradePriceReduceLl.setLayoutParams(layoutParams);
            obtainStyledAttributes.recycle();
        }
    }

    private void initListener() {
        this.mTradePriceAddLl.setOnClickListener(new OnAddReduceClickListener());
        this.mTradePriceReduceLl.setOnClickListener(new OnAddReduceClickListener());
        this.mTradePriceAddLl.setOnLongClickListener(new OnAddReduceLongClickListener());
        this.mTradePriceReduceLl.setOnLongClickListener(new OnAddReduceLongClickListener());
        this.mInputEt.setOnFocusChangeListener(new z0(this));
        this.mTradeCurrentPriceLl.setOnClickListener(y0.f19125b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$0(View view, boolean z11) {
        k4 k4Var = this.onEditTextFocusChangeListener;
        if (k4Var != null) {
            k4Var.onFocusChange(view, z11);
        }
    }

    private void setViewVisibility(int i11) {
        this.mTradeInputDivider.setVisibility(i11);
        this.mTradePriceAddLl.setVisibility(i11);
        this.mTradePriceReduceLl.setVisibility(i11);
        this.mAddReduceDivider.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public void updateInputText(View view) {
        if (view.getId() == R.id.trade_price_add_ll) {
            if (this.num.compareTo(BigDecimal.ZERO) < 0) {
                setReduceEnable(false);
                this.mInputEt.setText(m.i(0.0d, this.length));
            } else {
                this.mInputEt.setText(m.q(this.num.add(this.count), this.length));
                setReduceEnable(true);
            }
            EditText editText = this.mInputEt;
            editText.setSelection(editText.getText().length());
        } else if (view.getId() == R.id.trade_price_reduce_ll) {
            if (this.num.compareTo(this.count) < 0) {
                setReduceEnable(false);
                this.mInputEt.setText(m.i(0.0d, this.length));
            } else {
                BigDecimal subtract = this.num.subtract(this.count);
                if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                    this.mInputEt.setText(m.i(0.0d, this.length));
                    setReduceEnable(false);
                } else {
                    this.mInputEt.setText(m.q(subtract, this.length));
                }
            }
            EditText editText2 = this.mInputEt;
            editText2.setSelection(editText2.getText().length());
        }
    }

    public EditText getEditText() {
        return this.mInputEt;
    }

    public LinearLayout getInputPriceRl() {
        return this.mInputPriceRl;
    }

    public View.OnClickListener getInputPriceRlClickListener() {
        return this.inputPriceRlClickListener;
    }

    public LinearLayout getMarketPriceArea() {
        return this.mMarketPriceArea;
    }

    public String getPrice() {
        EditText editText = this.mInputEt;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.compositeSubscription.clear();
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

    public void setBtnClickEnable(boolean z11) {
        this.mTradePriceAddIv.setEnabled(z11);
        this.mTradePriceReduceIv.setEnabled(z11);
        this.mTradePriceAddLl.setClickable(z11);
        this.mTradePriceReduceLl.setClickable(z11);
        this.mTradePriceAddLl.setLongClickable(z11);
        this.mTradePriceReduceLl.setLongClickable(z11);
    }

    public void setConvertText(String str) {
        this.mInputPriceConvertTv.setText(str);
    }

    public void setConvertVisibility(int i11) {
        this.mInputPriceConvertTv.setVisibility(i11);
    }

    public void setEditHint(int i11) {
        this.mInputEt.setHint(i11);
    }

    public void setHintText(String str) {
        this.mInputEt.setHint(str);
    }

    public void setInputPriceRlClickListener(View.OnClickListener onClickListener) {
        this.inputPriceRlClickListener = onClickListener;
        if (onClickListener != null) {
            this.mInputPriceRl.setOnClickListener(onClickListener);
        }
    }

    public void setLabel(int i11) {
        this.mLabelTv.setText(i11);
    }

    public void setLabelVisibility(int i11) {
        this.mLabelTv.setVisibility(i11);
    }

    public void setLength(int i11) {
        this.length = i11;
        this.count = BigDecimal.ONE.divide(new BigDecimal(CouponReturn.TYPE_EXPERIENCE).pow(i11)).setScale(i11);
    }

    public void setMarketPriceAreaPressStyle(boolean z11) {
        if (z11) {
            this.mMarketPriceArea.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
            this.mMarketPriceText.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
            return;
        }
        this.mMarketPriceArea.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        this.mMarketPriceText.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
    }

    public void setMarketPriceStyle(boolean z11) {
        if (z11) {
            setViewVisibility(8);
            this.mMarketPriceArea.setVisibility(0);
            setBackgroundResource(0);
            this.mInputPriceRl.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.mMarketPriceArea.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            return;
        }
        setViewVisibility(0);
        this.mMarketPriceArea.setVisibility(8);
        setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        this.mInputPriceRl.setBackgroundResource(0);
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.onEditTextFocusChangeListener = k4Var;
    }

    public void setPriceInputType(int i11) {
        if (i11 != 1) {
            if (i11 == 2) {
                setViewVisibility(8);
                this.mInputEt.setEnabled(false);
                return;
            } else if (i11 != 3) {
                if (i11 == 4) {
                    setViewVisibility(0);
                    this.mInputEt.setEnabled(true);
                    setMarketPriceStyle(false);
                    return;
                } else if (i11 == 5) {
                    setViewVisibility(8);
                    this.mInputEt.setEnabled(false);
                    setViewVisibility(8);
                    this.mInputEt.setEnabled(false);
                    return;
                } else {
                    return;
                }
            }
        }
        setViewVisibility(0);
        this.mInputEt.setEnabled(true);
    }

    public void setReduceEnable(boolean z11) {
        if (this.mTradePriceReduceLl.isClickable() != z11) {
            this.mTradePriceReduceLl.setClickable(z11);
            this.mTradePriceReduceIv.setEnabled(z11);
        }
    }

    public void setReduceLongClickable(boolean z11) {
        if (this.mTradePriceReduceLl.isLongClickable() != z11) {
            this.mTradePriceReduceLl.setLongClickable(z11);
            if (z11) {
                this.mTradePriceReduceLl.setBackgroundResource(R.drawable.selector_trade_input_btn_bg);
                return;
            }
            this.mTradePriceReduceLl.setBackgroundResource(R.color.global_item_bg);
            this.mTradePriceReduceLl.setPressed(false);
        }
    }

    public void setTradeType(TradeType tradeType) {
        this.mTradeType = tradeType;
    }

    public void setViewVisibilityAndEnable(int i11, boolean z11) {
        setViewVisibility(i11);
        this.mInputEt.setEnabled(z11);
    }

    public NewTradePriceEdittext(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setConvertText(int i11) {
        this.mInputPriceConvertTv.setText(i11);
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

    public NewTradePriceEdittext(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.num = BigDecimal.ZERO;
        this.count = BigDecimal.ONE;
        this.compositeSubscription = new CompositeSubscription();
        this.quickTrade = false;
        init(attributeSet);
    }
}
