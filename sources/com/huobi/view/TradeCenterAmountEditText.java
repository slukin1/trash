package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.R$styleable;
import com.huobi.coupon.bean.CouponReturn;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.k4;
import i6.m;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import sn.f;
import tg.r;
import u6.g;

public class TradeCenterAmountEditText extends LinearLayout {
    private AddReduceCallback addReduceCallback;
    /* access modifiers changed from: private */
    public final CompositeSubscription compositeSubscription;
    private BigDecimal count;
    private View.OnClickListener inputPriceRlClickListener;
    private int length;
    /* access modifiers changed from: private */
    public EditText mInputEt;
    private LinearLayout mInputPriceRl;
    private boolean mIsContract;
    private ImageView mTradePriceAddIv;
    private LinearLayout mTradePriceAddLl;
    private ImageView mTradePriceReduceIv;
    private LinearLayout mTradePriceReduceLl;
    private TradeType mTradeType;
    /* access modifiers changed from: private */
    public BigDecimal num;
    private k4 onEditTextFocusChangeListener;
    private BigDecimal percent;

    public interface AddReduceCallback {
        void addReduceCall(String str);
    }

    public class OnAddReduceClickListener implements View.OnClickListener {
        public OnAddReduceClickListener() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            String trim = TradeCenterAmountEditText.this.mInputEt.getText().toString().trim();
            boolean z11 = false;
            if (TextUtils.isEmpty(trim)) {
                BigDecimal unused = TradeCenterAmountEditText.this.num = BigDecimal.ZERO;
            } else {
                boolean contains = trim.contains("%");
                if (contains) {
                    BigDecimal unused2 = TradeCenterAmountEditText.this.num = m.a(trim.substring(0, trim.indexOf("%"))).divide(m.f68179a, 2, 1);
                } else {
                    BigDecimal unused3 = TradeCenterAmountEditText.this.num = m.a(trim);
                }
                z11 = contains;
            }
            TradeCenterAmountEditText.this.updateInputText(view, z11);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class OnAddReduceLongClickListener implements View.OnLongClickListener {
        public OnAddReduceLongClickListener() {
        }

        public boolean onLongClick(View view) {
            TradeCenterAmountEditText.this.compositeSubscription.add(TradeCenterAmountEditText.this.getOnClickObservable(view));
            return false;
        }
    }

    public TradeCenterAmountEditText(Context context) {
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
                boolean z11;
                super.onNext(l11);
                String trim = TradeCenterAmountEditText.this.mInputEt.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    BigDecimal unused = TradeCenterAmountEditText.this.num = BigDecimal.ZERO;
                    z11 = false;
                } else {
                    z11 = trim.contains("%");
                    if (z11) {
                        BigDecimal unused2 = TradeCenterAmountEditText.this.num = m.a(trim.substring(0, trim.indexOf("%"))).divide(m.f68179a, 2, 1);
                    } else {
                        BigDecimal unused3 = TradeCenterAmountEditText.this.num = m.a(trim);
                    }
                }
                if (!view.isLongClickable() || !view.isPressed()) {
                    if (TextUtils.isEmpty(TradeCenterAmountEditText.this.mInputEt.getText().toString()) || new BigDecimal(TradeCenterAmountEditText.this.mInputEt.getText().toString()).compareTo(BigDecimal.ZERO) > 0) {
                        TradeCenterAmountEditText.this.setReduceLongClickable(true);
                    } else {
                        TradeCenterAmountEditText.this.setReduceLongClickable(false);
                    }
                    unsubscribe();
                    return;
                }
                TradeCenterAmountEditText.this.updateInputText(view, z11);
            }
        });
    }

    private void init(Context context, AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TradeCenterAmountEditText, i11, 0);
        this.mIsContract = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (this.mIsContract) {
            LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_contract_trade_center_amount_editext, this, true);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_trade_center_amount_editext, this, true);
        }
        this.mInputEt = (EditText) findViewById(R.id.input_et);
        this.mTradePriceAddIv = (ImageView) findViewById(R.id.trade_add_iv);
        this.mTradePriceReduceIv = (ImageView) findViewById(R.id.trade_reduce_iv);
        this.mInputPriceRl = (LinearLayout) findViewById(R.id.input_price_rl);
        this.mTradePriceAddLl = (LinearLayout) findViewById(R.id.trade_add_ll);
        this.mTradePriceReduceLl = (LinearLayout) findViewById(R.id.trade_reduce_ll);
        initListener();
        TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(attributeSet, R$styleable.CustomTradeCenterAmountEditText);
        if (obtainStyledAttributes2 != null) {
            this.mInputEt.setHint(obtainStyledAttributes2.getString(0));
            obtainStyledAttributes2.recycle();
        }
    }

    private void initListener() {
        this.mTradePriceAddLl.setOnClickListener(new OnAddReduceClickListener());
        this.mTradePriceReduceLl.setOnClickListener(new OnAddReduceClickListener());
        this.mTradePriceAddLl.setOnLongClickListener(new OnAddReduceLongClickListener());
        this.mTradePriceReduceLl.setOnLongClickListener(new OnAddReduceLongClickListener());
        this.mInputEt.setOnFocusChangeListener(new z1(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$0(View view, boolean z11) {
        k4 k4Var = this.onEditTextFocusChangeListener;
        if (k4Var != null) {
            k4Var.onFocusChange(view, z11);
        }
    }

    private void setViewVisibility(int i11) {
        this.mTradePriceAddLl.setVisibility(i11);
        this.mTradePriceReduceLl.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public void updateInputText(View view, boolean z11) {
        String str = "0";
        if (view.getId() == R.id.trade_add_ll) {
            if (z11) {
                if (this.num.compareTo(BigDecimal.ZERO) < 0) {
                    setReduceEnable(false);
                } else if (this.num.compareTo(BigDecimal.ONE) >= 0) {
                    setAddEnable(false);
                    str = "100";
                } else {
                    str = this.num.add(this.percent).multiply(m.f68179a).setScale(0, 1).toPlainString();
                    setReduceEnable(true);
                }
                AddReduceCallback addReduceCallback2 = this.addReduceCallback;
                if (addReduceCallback2 != null) {
                    addReduceCallback2.addReduceCall(str);
                    return;
                }
                return;
            }
            if (this.num.compareTo(BigDecimal.ZERO) < 0) {
                setReduceEnable(false);
                this.mInputEt.setText(m.i(0.0d, this.length));
            } else {
                this.mInputEt.setText(m.q(this.num.add(this.count), this.length));
                setReduceEnable(true);
            }
            EditText editText = this.mInputEt;
            editText.setSelection(editText.getText().length());
        } else if (view.getId() != R.id.trade_reduce_ll) {
        } else {
            if (z11) {
                if (this.num.compareTo(this.percent) < 0) {
                    setReduceEnable(false);
                } else {
                    BigDecimal subtract = this.num.subtract(this.percent);
                    if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                        setReduceEnable(false);
                    } else {
                        str = subtract.multiply(m.f68179a).setScale(0, 1).toPlainString();
                    }
                }
                AddReduceCallback addReduceCallback3 = this.addReduceCallback;
                if (addReduceCallback3 != null) {
                    addReduceCallback3.addReduceCall(str);
                    return;
                }
                return;
            }
            if (this.num.compareTo(this.count) < 0) {
                setReduceEnable(false);
                this.mInputEt.setText(m.i(0.0d, this.length));
            } else {
                BigDecimal subtract2 = this.num.subtract(this.count);
                if (subtract2.compareTo(BigDecimal.ZERO) <= 0) {
                    this.mInputEt.setText(m.i(0.0d, this.length));
                    setReduceEnable(false);
                } else {
                    this.mInputEt.setText(m.q(subtract2, this.length));
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
        f.f(this.mTradeType, getContext());
        return true;
    }

    public void setAddEnable(boolean z11) {
        if (this.mTradePriceAddLl.isClickable() != z11) {
            this.mTradePriceAddLl.setClickable(z11);
            this.mTradePriceAddIv.setEnabled(z11);
        }
    }

    public void setAddLongClickable(boolean z11) {
        if (this.mTradePriceAddLl.isLongClickable() != z11) {
            this.mTradePriceAddLl.setLongClickable(z11);
            if (z11) {
                this.mTradePriceAddLl.setBackgroundResource(R.drawable.selector_trade_input_btn_bg);
                return;
            }
            this.mTradePriceAddLl.setBackgroundResource(R.color.baseColorInputBackground);
            this.mTradePriceAddLl.setPressed(false);
        }
    }

    public void setAddReduceCallback(AddReduceCallback addReduceCallback2) {
        this.addReduceCallback = addReduceCallback2;
    }

    public void setBtnClickEnable(boolean z11) {
        this.mTradePriceAddIv.setEnabled(z11);
        this.mTradePriceReduceIv.setEnabled(z11);
        this.mTradePriceAddLl.setClickable(z11);
        this.mTradePriceReduceLl.setClickable(z11);
        this.mTradePriceAddLl.setLongClickable(z11);
        this.mTradePriceReduceLl.setLongClickable(z11);
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

    public void setLength(int i11) {
        this.length = i11;
        this.count = BigDecimal.ONE.divide(new BigDecimal(CouponReturn.TYPE_EXPERIENCE).pow(i11)).setScale(i11);
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.onEditTextFocusChangeListener = k4Var;
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
            this.mTradePriceReduceLl.setBackgroundResource(R.color.baseColorInputBackground);
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

    public TradeCenterAmountEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setHintText(int i11) {
        this.mInputEt.setHint(i11);
    }

    public TradeCenterAmountEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.num = BigDecimal.ZERO;
        this.count = BigDecimal.ONE;
        this.percent = new BigDecimal("0.01");
        this.compositeSubscription = new CompositeSubscription();
        init(context, attributeSet, i11);
    }
}
