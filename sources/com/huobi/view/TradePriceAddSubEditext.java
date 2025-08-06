package com.huobi.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.R$styleable;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.login.bean.JumpTarget;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
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

public class TradePriceAddSubEditext extends LinearLayout {
    public static final int TRADE_PLAN_LIMIT_TYPE = 4;
    public static final int TRADE_PLAN_MARKET_TYPE = 5;
    public static final int TRADE_PRICE_LIMIT = 1;
    public static final int TRADE_PRICE_MARKET = 2;
    public static final int TRADE_PRICE_STOP = 3;
    /* access modifiers changed from: private */
    public final CompositeSubscription compositeSubscription;
    private BigDecimal count;
    private View.OnClickListener inputPriceRlClickListener;
    private int length;
    private LinearLayout mAddSubArea;
    /* access modifiers changed from: private */
    public EditText mInputEt;
    private View mInputPriceParent;
    private LinearLayout mMarketPriceArea;
    private TextView mMarketPriceText;
    private ImageButton mPriceAddBtn;
    private ImageButton mPriceSubBtn;
    private TradeType mTradeType;
    /* access modifiers changed from: private */
    public BigDecimal num;
    private boolean quickTrade;

    public class OnAddReduceClickListener implements View.OnClickListener {
        public OnAddReduceClickListener() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            String trim = TradePriceAddSubEditext.this.mInputEt.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                BigDecimal unused = TradePriceAddSubEditext.this.num = BigDecimal.ZERO;
            } else {
                BigDecimal unused2 = TradePriceAddSubEditext.this.num = m.a(trim);
            }
            TradePriceAddSubEditext.this.updateInputText(view);
            TradePriceAddSubEditext.this.mInputEt.requestFocus();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class OnAddReduceLongClickListener implements View.OnLongClickListener {
        public OnAddReduceLongClickListener() {
        }

        public boolean onLongClick(View view) {
            TradePriceAddSubEditext.this.compositeSubscription.add(TradePriceAddSubEditext.this.getOnClickOvservable(view));
            return false;
        }
    }

    public TradePriceAddSubEditext(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public Subscription getOnClickOvservable(final View view) {
        return Observable.interval(0, 100, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber<Long>() {
            public void onError(Throwable th2) {
                super.onError(th2);
                unsubscribe();
            }

            public void onNext(Long l11) {
                super.onNext(l11);
                String trim = TradePriceAddSubEditext.this.mInputEt.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    BigDecimal unused = TradePriceAddSubEditext.this.num = BigDecimal.ZERO;
                } else {
                    BigDecimal unused2 = TradePriceAddSubEditext.this.num = m.a(trim);
                }
                if (!view.isLongClickable() || !view.isPressed()) {
                    if (TextUtils.isEmpty(TradePriceAddSubEditext.this.mInputEt.getText().toString()) || new BigDecimal(TradePriceAddSubEditext.this.mInputEt.getText().toString()).compareTo(BigDecimal.ZERO) > 0) {
                        TradePriceAddSubEditext.this.setReduceLongClickable(true);
                    } else {
                        TradePriceAddSubEditext.this.setReduceLongClickable(false);
                    }
                    unsubscribe();
                    return;
                }
                TradePriceAddSubEditext.this.updateInputText(view);
            }
        });
    }

    private SpannableString getSpannable(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan((int) getContext().getResources().getDimension(R.dimen.dimen_13), false), 0, spannableString.length(), 33);
        return spannableString;
    }

    private void init(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_trade_price_add_sub_editext, this, true);
        this.mInputEt = (EditText) findViewById(R.id.input_price_et);
        this.mPriceAddBtn = (ImageButton) findViewById(R.id.price_add_btn);
        this.mPriceSubBtn = (ImageButton) findViewById(R.id.price_sub_btn);
        this.mAddSubArea = (LinearLayout) findViewById(R.id.ll_add_sub_area);
        this.mMarketPriceArea = (LinearLayout) findViewById(R.id.ll_market_price_area);
        this.mMarketPriceText = (TextView) findViewById(R.id.tv_market_price);
        this.mInputPriceParent = findViewById(R.id.ll_input_price_parent);
        initListener();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CustomTradePriceAddSubEditText);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(1);
            if (!TextUtils.isEmpty(string)) {
                this.mInputEt.setHint(new SpannableString(getHintStringSpan(string)));
            } else {
                this.mInputEt.setHint(string);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, PixelUtils.a(10.0f));
            EditText editText = this.mInputEt;
            editText.setPadding(dimensionPixelSize, editText.getTop(), this.mInputEt.getRight(), this.mInputEt.getBottom());
            obtainStyledAttributes.recycle();
        }
    }

    private void initListener() {
        this.mPriceAddBtn.setOnClickListener(new OnAddReduceClickListener());
        this.mPriceSubBtn.setOnClickListener(new OnAddReduceClickListener());
        this.mPriceAddBtn.setOnLongClickListener(new OnAddReduceLongClickListener());
        this.mPriceSubBtn.setOnLongClickListener(new OnAddReduceLongClickListener());
    }

    /* access modifiers changed from: private */
    public void updateInputText(View view) {
        if (view.getId() == R.id.price_add_btn) {
            if (this.num.compareTo(BigDecimal.ZERO) < 0) {
                setReduceEnable(false);
                this.mInputEt.setText(m.i(0.0d, this.length));
            } else {
                this.mInputEt.setText(m.q(this.num.add(this.count), this.length));
                setReduceEnable(true);
            }
            EditText editText = this.mInputEt;
            editText.setSelection(editText.getText().length());
        } else if (view.getId() == R.id.price_sub_btn) {
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

    public SpannableString getHintResIdSpan(int i11) {
        return getSpannable(getResources().getString(i11));
    }

    public SpannableString getHintStringSpan(String str) {
        return getSpannable(str);
    }

    public View getInputPriceParent() {
        return this.mInputPriceParent;
    }

    public View.OnClickListener getInputPriceRlClickListener() {
        return this.inputPriceRlClickListener;
    }

    public LinearLayout getMarketPriceArea() {
        return this.mMarketPriceArea;
    }

    public TextView getMarketPriceText() {
        return this.mMarketPriceText;
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
        this.mPriceAddBtn.setEnabled(z11);
        this.mPriceSubBtn.setEnabled(z11);
    }

    public void setEditHint(int i11) {
        this.mInputEt.setHint(new SpannableString(getHintResIdSpan(i11)));
    }

    public void setHintText(String str) {
        this.mInputEt.setHint(new SpannableString(getHintStringSpan(str)));
    }

    public void setInputPriceRlClickListener(View.OnClickListener onClickListener) {
        this.inputPriceRlClickListener = onClickListener;
        if (onClickListener != null) {
            this.mInputEt.setOnClickListener(onClickListener);
        }
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

    public void setPriceInputType(int i11) {
        if (i11 == 2) {
            this.mAddSubArea.setVisibility(0);
            this.mMarketPriceArea.setVisibility(8);
            this.mMarketPriceArea.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.mInputPriceParent.setBackgroundResource(0);
            setBtnClickEnable(false);
            this.mInputEt.setEnabled(false);
            this.mInputEt.setFocusable(false);
            this.mInputEt.setFocusableInTouchMode(false);
            ViewUtil.m(this.mPriceAddBtn, false);
            ViewUtil.m(this.mPriceSubBtn, false);
        } else if (i11 == 4) {
            this.mAddSubArea.setVisibility(8);
            this.mMarketPriceArea.setVisibility(0);
            this.mMarketPriceArea.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.mInputPriceParent.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            setBtnClickEnable(true);
            this.mPriceSubBtn.setClickable(true);
            this.mInputEt.setEnabled(true);
            this.mInputEt.setFocusableInTouchMode(true);
            ViewUtil.m(this.mPriceAddBtn, false);
            ViewUtil.m(this.mPriceSubBtn, false);
        } else if (i11 != 5) {
            this.mAddSubArea.setVisibility(0);
            this.mMarketPriceArea.setVisibility(8);
            this.mMarketPriceArea.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.mInputPriceParent.setBackgroundColor(getResources().getColor(R.color.transparent));
            this.mInputPriceParent.setBackgroundResource(0);
            setBtnClickEnable(true);
            this.mPriceSubBtn.setClickable(true);
            this.mInputEt.setEnabled(true);
            this.mInputEt.setFocusableInTouchMode(true);
            ViewUtil.m(this.mPriceAddBtn, true);
            ViewUtil.m(this.mPriceSubBtn, true);
        } else {
            this.mAddSubArea.setVisibility(8);
            this.mMarketPriceArea.setVisibility(0);
            this.mMarketPriceArea.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.mInputPriceParent.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            setBtnClickEnable(false);
            this.mPriceSubBtn.setClickable(false);
            this.mInputEt.setEnabled(false);
            this.mInputEt.setFocusableInTouchMode(false);
            ViewUtil.m(this.mPriceAddBtn, false);
            ViewUtil.m(this.mPriceSubBtn, false);
        }
    }

    public void setReduceEnable(boolean z11) {
        if (this.mPriceSubBtn.isClickable() != z11) {
            this.mPriceSubBtn.setClickable(z11);
            this.mPriceSubBtn.setEnabled(z11);
        }
    }

    public void setReduceLongClickable(boolean z11) {
        if (this.mPriceSubBtn.isLongClickable() != z11) {
            this.mPriceSubBtn.setLongClickable(z11);
            if (!z11) {
                this.mPriceSubBtn.setPressed(false);
            }
        }
    }

    public void setTradeType(TradeType tradeType) {
        this.mTradeType = tradeType;
    }

    public void setViewVisibilityAndEnable() {
        setBtnClickEnable(false);
        this.mInputEt.setEnabled(false);
        ViewUtil.m(this.mPriceAddBtn, false);
        ViewUtil.m(this.mPriceSubBtn, false);
    }

    public TradePriceAddSubEditext(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setHintText(int i11) {
        this.mInputEt.setHint(new SpannableString(getHintResIdSpan(i11)));
    }

    public void setTradeType(TradeType tradeType, boolean z11) {
        this.mTradeType = tradeType;
        this.quickTrade = z11;
    }

    public TradePriceAddSubEditext(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.num = BigDecimal.ZERO;
        this.count = BigDecimal.ONE;
        this.quickTrade = false;
        this.compositeSubscription = new CompositeSubscription();
        init(attributeSet);
    }
}
