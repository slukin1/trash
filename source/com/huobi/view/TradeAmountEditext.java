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
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.R$styleable;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.login.bean.JumpTarget;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.k;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rn.c;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import sn.f;
import tg.r;

public class TradeAmountEditext extends LinearLayout {
    /* access modifiers changed from: private */
    public final CompositeSubscription compositeSubscription;
    private BigDecimal count;
    private int length;
    private View mAddReduceDivider;
    private TextView mAllTv;
    private ImageView mAmountAddIv;
    private LinearLayout mAmountAddLl;
    private View mAmountLeftDivider;
    private LinearLayout mAmountOperationLl;
    private LinearLayout mAmountOperationNewLl;
    private ImageView mAmountReduceIv;
    private LinearLayout mAmountReduceLl;
    private LinearLayout mAmountSelector;
    private View mAmountSelectorDivider;
    private TextView mHalfTv;
    /* access modifiers changed from: private */
    public EditText mInputEt;
    private TextView mLabelTv;
    private TextView mOneQuarterTv;
    private TradeType mTradeType;
    /* access modifiers changed from: private */
    public BigDecimal num;
    private View.OnClickListener onAllClickListener;
    private View.OnClickListener onHalfClickListener;
    private View.OnClickListener onQuarterClickListener;
    private View.OnClickListener onSelectorClickListener;
    private boolean quickTrade;

    public class OnAddReduceClickListener implements View.OnClickListener {
        public OnAddReduceClickListener() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            String trim = TradeAmountEditext.this.mInputEt.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                BigDecimal unused = TradeAmountEditext.this.num = BigDecimal.ZERO;
            } else {
                BigDecimal unused2 = TradeAmountEditext.this.num = m.a(trim);
            }
            TradeAmountEditext.this.updateInputText(view);
            try {
                g.i("App_trade_quantityAdd_click", (HashMap) null);
            } catch (Exception e11) {
                k.j("SensorsData", e11);
            }
            TradeAmountEditext.this.mInputEt.requestFocus();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class OnAddReduceLongClickListener implements View.OnLongClickListener {
        public OnAddReduceLongClickListener() {
        }

        public boolean onLongClick(View view) {
            TradeAmountEditext.this.compositeSubscription.add(TradeAmountEditext.this.getOnClickObservable(view));
            return false;
        }
    }

    public TradeAmountEditext(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public Subscription getOnClickObservable(final View view) {
        return Observable.interval(0, 100, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((u6.g) null)).subscribe(new BaseSubscriber<Long>() {
            public void onError(Throwable th2) {
                super.onError(th2);
                unsubscribe();
            }

            public void onNext(Long l11) {
                super.onNext(l11);
                String trim = TradeAmountEditext.this.mInputEt.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    BigDecimal unused = TradeAmountEditext.this.num = BigDecimal.ZERO;
                } else {
                    BigDecimal unused2 = TradeAmountEditext.this.num = m.a(trim);
                }
                if (!view.isLongClickable() || !view.isPressed()) {
                    if (TextUtils.isEmpty(TradeAmountEditext.this.mInputEt.getText().toString()) || new BigDecimal(TradeAmountEditext.this.mInputEt.getText().toString()).compareTo(BigDecimal.ZERO) > 0) {
                        TradeAmountEditext.this.setReduceLongClickable(true);
                    } else {
                        TradeAmountEditext.this.setReduceLongClickable(false);
                    }
                    unsubscribe();
                    return;
                }
                TradeAmountEditext.this.updateInputText(view);
            }
        });
    }

    private void init(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_trade_amount_editext, this, true);
        this.mInputEt = (EditText) findViewById(R.id.input_amount_et);
        this.mLabelTv = (TextView) findViewById(R.id.label_amount_tv);
        this.mOneQuarterTv = (TextView) findViewById(R.id.one_quarter_tv);
        this.mHalfTv = (TextView) findViewById(R.id.half_tv);
        this.mAllTv = (TextView) findViewById(R.id.all_tv);
        this.mAmountOperationLl = (LinearLayout) findViewById(R.id.amount_operation_ll);
        this.mAmountOperationNewLl = (LinearLayout) findViewById(R.id.amount_operation_new_ll);
        this.mAmountSelector = (LinearLayout) findViewById(R.id.trade_amount_selector_ll);
        this.mAmountReduceLl = (LinearLayout) findViewById(R.id.trade_amount_reduce_ll);
        this.mAmountAddLl = (LinearLayout) findViewById(R.id.trade_amount_add_ll);
        this.mAmountAddIv = (ImageView) findViewById(R.id.trade_amount_add_iv);
        this.mAmountReduceIv = (ImageView) findViewById(R.id.trade_amount_reduce_iv);
        this.mAddReduceDivider = findViewById(R.id.add_reduce_divider);
        this.mAmountLeftDivider = findViewById(R.id.trade_amount_left_divider);
        this.mAmountSelectorDivider = findViewById(R.id.trade_amount_selector_divider);
        initListener();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CustomTradeAmountEditText);
        if (obtainStyledAttributes != null) {
            this.mInputEt.setHint(obtainStyledAttributes.getString(1));
            this.mLabelTv.setText(obtainStyledAttributes.getString(2));
            int integer = obtainStyledAttributes.getInteger(3, 0);
            if (integer == 0) {
                this.mAmountOperationLl.setVisibility(0);
            } else if (integer == 1) {
                this.mAmountOperationLl.setVisibility(4);
            } else if (integer != 2) {
                this.mAmountOperationLl.setVisibility(0);
            } else {
                this.mAmountOperationLl.setVisibility(8);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, PixelUtils.a(10.0f));
            EditText editText = this.mInputEt;
            editText.setPadding(dimensionPixelSize, editText.getTop(), this.mInputEt.getRight(), this.mInputEt.getBottom());
            obtainStyledAttributes.recycle();
        }
    }

    private void initListener() {
        this.mAllTv.setOnClickListener(new v1(this));
        this.mOneQuarterTv.setOnClickListener(new x1(this));
        this.mHalfTv.setOnClickListener(new w1(this));
        this.mAmountSelector.setOnClickListener(new y1(this));
        this.mAmountReduceLl.setOnClickListener(new OnAddReduceClickListener());
        this.mAmountAddLl.setOnClickListener(new OnAddReduceClickListener());
        this.mAmountReduceLl.setOnLongClickListener(new OnAddReduceLongClickListener());
        this.mAmountAddLl.setOnLongClickListener(new OnAddReduceLongClickListener());
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$0(View view) {
        View.OnClickListener onClickListener = this.onAllClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$1(View view) {
        View.OnClickListener onClickListener = this.onQuarterClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$2(View view) {
        View.OnClickListener onClickListener = this.onHalfClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$3(View view) {
        View.OnClickListener onClickListener = this.onSelectorClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void setViewVisiablity(int i11) {
        this.mLabelTv.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public void updateInputText(View view) {
        if (view.getId() == R.id.trade_amount_add_ll) {
            if (this.num.compareTo(BigDecimal.ZERO) < 0) {
                setReduceEnable(false);
                this.mInputEt.setText(m.i(0.0d, this.length));
            } else {
                this.mInputEt.setText(m.q(this.num.add(this.count), this.length));
                setReduceEnable(true);
            }
            EditText editText = this.mInputEt;
            editText.setSelection(editText.getText().length());
        } else if (view.getId() == R.id.trade_amount_reduce_ll) {
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

    public void setAddReduceVisibility(boolean z11) {
        int i11 = !z11 ? 8 : 0;
        this.mAmountLeftDivider.setVisibility(i11);
        this.mAmountAddLl.setVisibility(i11);
        this.mAmountReduceLl.setVisibility(i11);
        this.mAddReduceDivider.setVisibility(i11);
    }

    public void setAddReduceZoneVisible(boolean z11) {
        if (z11) {
            this.mAmountOperationNewLl.setVisibility(0);
        } else {
            this.mAmountOperationNewLl.setVisibility(8);
        }
    }

    public void setBtnClickEnable(boolean z11) {
        if (z11) {
            this.mAllTv.setTextColor(ContextCompat.getColor(getContext(), R.color.global_secondary_text_color));
            this.mHalfTv.setTextColor(ContextCompat.getColor(getContext(), R.color.global_secondary_text_color));
            this.mOneQuarterTv.setTextColor(ContextCompat.getColor(getContext(), R.color.global_secondary_text_color));
            this.mAllTv.setClickable(true);
            this.mHalfTv.setClickable(true);
            this.mOneQuarterTv.setClickable(true);
        } else {
            this.mAllTv.setTextColor(ContextCompat.getColor(getContext(), R.color.trade_amount_btn_unenable_text_color));
            this.mHalfTv.setTextColor(ContextCompat.getColor(getContext(), R.color.trade_amount_btn_unenable_text_color));
            this.mOneQuarterTv.setTextColor(ContextCompat.getColor(getContext(), R.color.trade_amount_btn_unenable_text_color));
            this.mAllTv.setClickable(false);
            this.mHalfTv.setClickable(false);
            this.mOneQuarterTv.setClickable(false);
        }
        this.mAmountAddIv.setEnabled(z11);
        this.mAmountReduceIv.setEnabled(z11);
        this.mAmountAddLl.setClickable(z11);
        this.mAmountReduceLl.setClickable(z11);
        this.mAmountAddLl.setLongClickable(z11);
        this.mAmountReduceLl.setLongClickable(z11);
    }

    public void setDividerColor(int i11) {
        this.mAmountLeftDivider.setBackgroundColor(i11);
        this.mAddReduceDivider.setBackgroundColor(i11);
        this.mAmountSelectorDivider.setBackgroundColor(i11);
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

    public void setLength(int i11) {
        this.length = i11;
        this.count = BigDecimal.ONE.divide(new BigDecimal(CouponReturn.TYPE_EXPERIENCE).pow(i11)).setScale(i11);
    }

    public void setOnAllClickListener(View.OnClickListener onClickListener) {
        this.onAllClickListener = onClickListener;
    }

    public void setOnHalfClickListener(View.OnClickListener onClickListener) {
        this.onHalfClickListener = onClickListener;
    }

    public void setOnQuarterClickListener(View.OnClickListener onClickListener) {
        this.onQuarterClickListener = onClickListener;
    }

    public void setOnSelectorClickListener(View.OnClickListener onClickListener) {
        this.onSelectorClickListener = onClickListener;
    }

    public void setReduceEnable(boolean z11) {
        if (this.mAmountReduceLl.isClickable() != z11) {
            this.mAmountReduceLl.setClickable(z11);
            this.mAmountReduceIv.setEnabled(z11);
        }
    }

    public void setReduceLongClickable(boolean z11) {
        if (this.mAmountReduceLl.isLongClickable() != z11) {
            this.mAmountReduceLl.setLongClickable(z11);
            if (z11) {
                this.mAmountReduceLl.setBackgroundResource(R.drawable.selector_trade_input_btn_bg);
                return;
            }
            this.mAmountReduceLl.setBackgroundResource(R.color.global_item_bg);
            this.mAmountReduceLl.setPressed(false);
        }
    }

    public void setTradeType(TradeType tradeType) {
        this.mTradeType = tradeType;
    }

    public TradeAmountEditext(Context context, AttributeSet attributeSet) {
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

    public TradeAmountEditext(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.num = BigDecimal.ZERO;
        this.count = BigDecimal.ONE;
        this.compositeSubscription = new CompositeSubscription();
        this.quickTrade = false;
        init(attributeSet);
    }
}
