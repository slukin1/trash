package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.R$styleable;
import com.huobi.coupon.bean.CouponReturn;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import u6.g;

public class PointsPriceEditext extends LinearLayout {
    /* access modifiers changed from: private */
    public final CompositeSubscription compositeSubscription;
    private BigDecimal count;
    private int length;
    /* access modifiers changed from: private */
    public EditText mInputEt;
    private ImageView mPointsPriceAddIv;
    private LinearLayout mPointsPriceAddLl;
    private ImageView mPointsPriceReduceIv;
    private LinearLayout mPointsPriceReduceLl;
    /* access modifiers changed from: private */
    public BigDecimal num;

    public class OnAddReduceClickListener implements View.OnClickListener {
        public OnAddReduceClickListener() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            String trim = PointsPriceEditext.this.mInputEt.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                BigDecimal unused = PointsPriceEditext.this.num = BigDecimal.ZERO;
            } else {
                BigDecimal unused2 = PointsPriceEditext.this.num = m.a(trim);
            }
            PointsPriceEditext.this.updateInputText(view);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class OnAddReduceLongClickListener implements View.OnLongClickListener {
        public OnAddReduceLongClickListener() {
        }

        public boolean onLongClick(View view) {
            PointsPriceEditext.this.compositeSubscription.add(PointsPriceEditext.this.getOnClickOvservable(view));
            return false;
        }
    }

    public PointsPriceEditext(Context context) {
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
                String trim = PointsPriceEditext.this.mInputEt.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    BigDecimal unused = PointsPriceEditext.this.num = BigDecimal.ZERO;
                } else {
                    BigDecimal unused2 = PointsPriceEditext.this.num = m.a(trim);
                }
                if (!view.isLongClickable() || !view.isPressed()) {
                    if (TextUtils.isEmpty(PointsPriceEditext.this.mInputEt.getText().toString()) || new BigDecimal(PointsPriceEditext.this.mInputEt.getText().toString()).compareTo(BigDecimal.ZERO) > 0) {
                        PointsPriceEditext.this.setReduceLongClickable(true);
                    } else {
                        PointsPriceEditext.this.setReduceLongClickable(false);
                    }
                    unsubscribe();
                    return;
                }
                PointsPriceEditext.this.updateInputText(view);
            }
        });
    }

    private void init(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_points_buy_editext, this, true);
        this.mInputEt = (EditText) findViewById(R.id.points_price_et);
        this.mPointsPriceAddIv = (ImageView) findViewById(R.id.points_price_add_iv);
        this.mPointsPriceReduceIv = (ImageView) findViewById(R.id.points_price_reduce_iv);
        this.mPointsPriceAddLl = (LinearLayout) findViewById(R.id.points_price_add_ll);
        this.mPointsPriceReduceLl = (LinearLayout) findViewById(R.id.points_price_reduce_ll);
        initListener();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CustomPointsPriceEditText);
        if (obtainStyledAttributes != null) {
            this.mInputEt.setHint(obtainStyledAttributes.getString(2));
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, PixelUtils.a(40.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPointsPriceAddLl.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            this.mPointsPriceAddLl.setLayoutParams(layoutParams);
            ((LinearLayout.LayoutParams) this.mPointsPriceReduceLl.getLayoutParams()).width = dimensionPixelSize;
            this.mPointsPriceReduceLl.setLayoutParams(layoutParams);
            obtainStyledAttributes.recycle();
        }
    }

    private void initListener() {
        this.mPointsPriceAddLl.setOnClickListener(new OnAddReduceClickListener());
        this.mPointsPriceReduceLl.setOnClickListener(new OnAddReduceClickListener());
        this.mPointsPriceAddLl.setOnLongClickListener(new OnAddReduceLongClickListener());
        this.mPointsPriceReduceLl.setOnLongClickListener(new OnAddReduceLongClickListener());
    }

    /* access modifiers changed from: private */
    public void updateInputText(View view) {
        if (view.getId() == R.id.points_price_add_ll) {
            if (this.num.compareTo(BigDecimal.ZERO) < 0) {
                setReduceEnable(false);
                this.mInputEt.setText(m.i(0.0d, this.length));
                return;
            }
            this.mInputEt.setText(m.q(this.num.add(this.count), this.length));
            setReduceEnable(true);
        } else if (view.getId() != R.id.points_price_reduce_ll) {
        } else {
            if (this.num.compareTo(this.count) < 0) {
                setReduceEnable(false);
                this.mInputEt.setText(m.i(0.0d, this.length));
                return;
            }
            BigDecimal subtract = this.num.subtract(this.count);
            if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                this.mInputEt.setText(m.i(0.0d, this.length));
                setReduceEnable(false);
                return;
            }
            this.mInputEt.setText(m.q(subtract, this.length));
        }
    }

    public EditText getEditText() {
        return this.mInputEt;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.compositeSubscription.clear();
    }

    public void setBtnClickEnable(boolean z11) {
        this.mPointsPriceAddIv.setEnabled(z11);
        this.mPointsPriceReduceIv.setEnabled(z11);
        this.mPointsPriceAddLl.setClickable(z11);
        this.mPointsPriceReduceLl.setClickable(z11);
        this.mPointsPriceAddLl.setLongClickable(z11);
        this.mPointsPriceReduceLl.setLongClickable(z11);
    }

    public void setEditHint(int i11) {
        this.mInputEt.setHint(i11);
    }

    public void setHintText(String str) {
        this.mInputEt.setHint(str);
    }

    public void setLength(int i11) {
        this.length = i11;
        this.count = BigDecimal.ONE.divide(new BigDecimal(CouponReturn.TYPE_EXPERIENCE).pow(i11)).setScale(i11);
    }

    public void setReduceEnable(boolean z11) {
        if (this.mPointsPriceReduceLl.isClickable() != z11) {
            this.mPointsPriceReduceLl.setClickable(z11);
            this.mPointsPriceReduceIv.setEnabled(z11);
        }
    }

    public void setReduceLongClickable(boolean z11) {
        if (this.mPointsPriceReduceLl.isLongClickable() != z11) {
            this.mPointsPriceReduceLl.setLongClickable(z11);
            if (z11) {
                this.mPointsPriceReduceLl.setBackgroundResource(R.drawable.selector_trade_input_btn_bg);
                return;
            }
            this.mPointsPriceReduceLl.setBackgroundResource(R.color.global_item_bg);
            this.mPointsPriceReduceLl.setPressed(false);
        }
    }

    public PointsPriceEditext(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setHintText(int i11) {
        this.mInputEt.setHint(i11);
    }

    public PointsPriceEditext(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.num = BigDecimal.ZERO;
        this.count = BigDecimal.ONE;
        this.compositeSubscription = new CompositeSubscription();
        init(attributeSet);
    }
}
