package com.huobi.view;

import al.p;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.AssetAlterCostData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.coupon.bean.Coupon;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import f6.c;
import gi.a;
import i6.k;
import i6.m;
import i6.r;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import u6.g;
import v7.b;

public class BottomAlterCostDialogFragment extends BaseBottomCurrencyDialogFragment {
    private static final String defaultValue = "--";
    /* access modifiers changed from: private */
    public DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String mAccount = Coupon.SPOT.toLowerCase();
    private Subscriber<AssetAlterCostData> mAlterSubscriber;
    private String mAverageCostAuto;
    /* access modifiers changed from: private */
    public String mAverageCostManu;
    private String mCurrency;
    private DialogCloseCallback mDialogCloseCallback;
    /* access modifiers changed from: private */
    public EditText mEtCostCountManu;
    private ImageView mIvIcon;
    private String mPriceMethod;
    private TextView mTvAutoSymbol;
    private TextView mTvCostCountAuto;
    private TextView mTvCurrency;
    private TextView mTvManuSymbol;
    /* access modifiers changed from: private */
    public TextView mTvUpdateButton;
    /* access modifiers changed from: private */
    public TextView mTvUpdateTime;

    public interface DialogCloseCallback {
        void onDialogClose(String str);
    }

    private Subscriber<AssetAlterCostData> createAlterSubscriber() {
        return new BaseSubscriber<AssetAlterCostData>() {
            public void onNext(AssetAlterCostData assetAlterCostData) {
                super.onNext(assetAlterCostData);
                BottomAlterCostDialogFragment.this.refreshUi(assetAlterCostData);
            }
        };
    }

    private Observable<AssetAlterCostData> getAlterObservable(String str, String str2) {
        return b.a().getAlterAverageCostData(str, str2).b().onErrorReturn(new Func1<Throwable, AssetAlterCostData>() {
            public AssetAlterCostData call(Throwable th2) {
                k.e("getAlterObservable e=" + th2.getMessage());
                return null;
            }
        }).compose(RxJavaHelper.t((g) null));
    }

    private void init() {
        String y11 = LegalCurrencyConfigUtil.y();
        Locale locale = Locale.US;
        this.mPriceMethod = y11.toUpperCase(locale);
        if (!TextUtils.isEmpty(this.mCurrency)) {
            this.mTvCurrency.setText(this.mCurrency.toUpperCase(locale));
        }
        this.mTvManuSymbol.setText(this.mPriceMethod);
        this.mTvAutoSymbol.setText(this.mPriceMethod);
        c.a().l(getContext(), p.k(this.mCurrency), this.mIvIcon, p.m());
        requestAlterData();
    }

    private void initListener(r rVar) {
        rVar.b(R$id.tv_close).setOnClickListener(new t(this));
        rVar.b(R$id.tv_update).setOnClickListener(new v(this));
        rVar.b(R$id.tv_recover).setOnClickListener(new u(this));
        this.mEtCostCountManu.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                if (charSequence.length() > 0) {
                    BottomAlterCostDialogFragment.this.mTvUpdateButton.setTextColor(-1);
                    BottomAlterCostDialogFragment.this.mTvUpdateButton.setBackgroundColor(BottomAlterCostDialogFragment.this.getResources().getColor(R$color.global_dialog_top_button_text_color));
                    BottomAlterCostDialogFragment.this.mTvUpdateButton.setClickable(true);
                    return;
                }
                BottomAlterCostDialogFragment.this.mTvUpdateButton.setTextColor(BottomAlterCostDialogFragment.this.getResources().getColor(R$color.baseColorThreeLevelText));
                BottomAlterCostDialogFragment.this.mTvUpdateButton.setBackgroundColor(BottomAlterCostDialogFragment.this.getResources().getColor(R$color.baseColorDisableButton));
                BottomAlterCostDialogFragment.this.mTvUpdateButton.setClickable(false);
            }
        });
    }

    private void initView(r rVar) {
        this.mTvCurrency = (TextView) rVar.b(R$id.tv_coin_name);
        this.mTvCostCountAuto = (TextView) rVar.b(R$id.tv_cost_auto_count);
        this.mEtCostCountManu = (EditText) rVar.b(R$id.et_cost_count_manu);
        this.mTvManuSymbol = (TextView) rVar.b(R$id.tv_symbol_manu);
        this.mTvAutoSymbol = (TextView) rVar.b(R$id.tv_symbol_auto);
        this.mTvUpdateTime = (TextView) rVar.b(R$id.tv_update_date);
        this.mTvUpdateButton = (TextView) rVar.b(R$id.tv_update);
        this.mIvIcon = (ImageView) rVar.b(R$id.iv_symbol_coin);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$1(View view) {
        onUpdate();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$2(View view) {
        recover();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public void refreshUi(AssetAlterCostData assetAlterCostData) {
        String C = LegalCurrencyConfigUtil.C(assetAlterCostData.getSysCost(), this.mPriceMethod);
        this.mAverageCostAuto = C;
        if (!StringUtils.p(C)) {
            this.mTvCostCountAuto.setText(this.mAverageCostAuto);
        } else {
            this.mTvCostCountAuto.setText("--");
        }
        String C2 = LegalCurrencyConfigUtil.C(assetAlterCostData.getUserCost(), this.mPriceMethod);
        this.mAverageCostManu = C2;
        if (m.b0(C2)) {
            this.mAverageCostManu = this.mAverageCostAuto;
        }
        this.mEtCostCountManu.setText(this.mAverageCostManu);
        String format = this.dateFormat.format(assetAlterCostData.getUpdatedAt());
        TextView textView = this.mTvUpdateTime;
        textView.setText(format + " " + getResources().getString(R$string.n_asset_update));
        if (this.mTvUpdateTime.getVisibility() == 8) {
            this.mTvUpdateTime.setVisibility(0);
            onStart();
        }
    }

    private void requestAlterData() {
        Subscriber<AssetAlterCostData> subscriber = this.mAlterSubscriber;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.mAlterSubscriber = createAlterSubscriber();
        getAlterObservable(this.mCurrency, this.mAccount).subscribe(this.mAlterSubscriber);
    }

    public int getPeekHeight() {
        if (this.mTvUpdateTime.getVisibility() == 0) {
            return PixelUtils.a(332.0f);
        }
        return PixelUtils.a(315.0f);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCurrency = getArguments().getString(FirebaseAnalytics.Param.CURRENCY);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.dialog_fragment_alter_cost_layout, viewGroup, false);
        r rVar = new r(inflate);
        initView(rVar);
        initListener(rVar);
        init();
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.mDialogCloseCallback != null) {
            String str = this.mAverageCostManu;
            if (TextUtils.isEmpty(str)) {
                str = this.mAverageCostAuto;
            }
            this.mDialogCloseCallback.onDialogClose(m.p0(str));
        }
    }

    public void onUpdate() {
        String obj = this.mEtCostCountManu.getText().toString();
        if (!m.a0(obj) || m.b0(obj)) {
            HuobiToastUtil.m(getResources().getString(R$string.n_asset_cost_error));
        } else {
            updateUsdtAmount(LegalCurrencyConfigUtil.Y(obj, this.mPriceMethod));
        }
    }

    public void recover() {
        this.mEtCostCountManu.setText(this.mAverageCostAuto);
    }

    public void setOnDialogCloseCallback(DialogCloseCallback dialogCloseCallback) {
        this.mDialogCloseCallback = dialogCloseCallback;
    }

    public void updateUsdtAmount(String str) {
        b.a().r0(this.mCurrency, this.mAccount, str).b().compose(RxJavaHelper.t((g) null)).subscribe(new EasySubscriber<Object>() {
            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                super.onFailed(aPIStatusErrorException);
                HuobiToastUtil.m(BottomAlterCostDialogFragment.this.getResources().getString(R$string.n_asset_cost_error));
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                String format = BottomAlterCostDialogFragment.this.dateFormat.format(new Date());
                TextView access$200 = BottomAlterCostDialogFragment.this.mTvUpdateTime;
                access$200.setText(format + " " + BottomAlterCostDialogFragment.this.getResources().getString(R$string.n_asset_update));
                if (BottomAlterCostDialogFragment.this.mTvUpdateTime.getVisibility() == 8) {
                    BottomAlterCostDialogFragment.this.mTvUpdateTime.setVisibility(0);
                    BottomAlterCostDialogFragment.this.onStart();
                }
                BottomAlterCostDialogFragment bottomAlterCostDialogFragment = BottomAlterCostDialogFragment.this;
                String unused = bottomAlterCostDialogFragment.mAverageCostManu = bottomAlterCostDialogFragment.mEtCostCountManu.getText().toString();
                BottomAlterCostDialogFragment.this.dismiss();
                a.g();
            }
        });
    }
}
