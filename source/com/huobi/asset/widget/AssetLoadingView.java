package com.huobi.asset.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.hbg.core.bean.SpotAssertInfo;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import jp.k0;
import qh.p0;
import vh.n;
import vh.o;

public class AssetLoadingView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f42447b;

    /* renamed from: c  reason: collision with root package name */
    public LoadingLayout f42448c;

    /* renamed from: d  reason: collision with root package name */
    public View f42449d;

    /* renamed from: e  reason: collision with root package name */
    public View f42450e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f42451f;

    public AssetLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(View view) {
        View.OnClickListener onClickListener = this.f42451f;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(Context context, View view) {
        if (p.h(context)) {
            k0.n(context, OtcTradeAreaEnum.FREE_AREA, "cny");
        } else {
            k0.m(context, OtcTradeAreaEnum.FREE_AREA);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R$layout.layout_asset_loading, this, true);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        this.f42447b = findViewById(R$id.loading_layout_parent);
        LoadingLayout loadingLayout = (LoadingLayout) findViewById(R$id.loading_layout);
        this.f42448c = loadingLayout;
        loadingLayout.g();
        this.f42450e = findViewById(R$id.balance_common_error_view);
        this.f42449d = findViewById(R$id.balance_common_empty_view);
        this.f42448c.findViewById(R$id.balance_common_guide_view).setBackground((Drawable) null);
        this.f42450e.findViewById(R$id.viewErrorRetry).setOnClickListener(new o(this));
    }

    public final void d(View view, Context context) {
        TextView textView = (TextView) view.findViewById(R$id.tv_balance_guide_text);
        TextView textView2 = (TextView) view.findViewById(R$id.tv_balance_guide_text2);
        TextView textView3 = (TextView) view.findViewById(R$id.tv_balance_guide_to_otc);
        TextView textView4 = (TextView) view.findViewById(R$id.tv_balance_guide_to_otc_tips);
        SpotAssertInfo o11 = p0.n().o();
        if (textView != null) {
            String lowerCase = p.a(context).toLowerCase();
            if (!p.h(context)) {
                textView.setText(context.getString(R$string.n_asset_guide_recharge));
                textView2.setText(context.getString(R$string.n_balance_new_guide_desc));
                textView3.setText(context.getString(R$string.n_balance_guide_to_recharge));
            } else if (lowerCase.equalsIgnoreCase("zh-cn")) {
                textView.setText("立即充值，开启您的数字货币之旅");
                textView2.setText("0手续费CNY买币，入金灵活价格实惠");
                textView3.setText("微信/支付宝买币");
            } else {
                textView.setText("立即充值，開啓您的數字貨幣之旅");
                textView2.setText("快速入金可領取高額獎勵");
                textView3.setText("去入金");
            }
            if (o11 != null && !TextUtils.isEmpty(o11.getDepositTag())) {
                String depositTag = o11.getDepositTag();
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    textView4.setText(depositTag);
                }
            } else if (textView4 != null) {
                textView4.setVisibility(8);
            }
        }
        if (textView3 != null) {
            textView3.setOnClickListener(new n(context));
        }
    }

    public void g(String str, String str2, View.OnClickListener onClickListener) {
        TextView textView = (TextView) this.f42449d.findViewById(R$id.tv_balance_empty_text);
        TextView textView2 = (TextView) this.f42449d.findViewById(R$id.viewEmptyRetry);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            textView2.setVisibility(0);
            textView2.setText(str2);
        } else {
            textView2.setVisibility(8);
        }
        if (onClickListener != null) {
            textView2.setOnClickListener(onClickListener);
        }
    }

    public View getEmptyLayout() {
        return this.f42449d;
    }

    public View getErrorLayout() {
        return this.f42450e;
    }

    public LoadingLayout getLoadingLayout() {
        return this.f42448c;
    }

    public View getLoadingLayoutParent() {
        return this.f42447b;
    }

    public void setRetryListener(View.OnClickListener onClickListener) {
        this.f42451f = onClickListener;
    }

    public void setState(int i11) {
        if (i11 == 1) {
            this.f42448c.p();
        } else if (i11 == 2) {
            this.f42448c.k();
        } else if (i11 == 3) {
            this.f42448c.i();
        } else if (i11 != 4) {
            this.f42448c.g();
        } else {
            d(this.f42448c, getContext());
            this.f42448c.m();
        }
    }

    public AssetLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssetLoadingView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public AssetLoadingView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        c();
    }
}
