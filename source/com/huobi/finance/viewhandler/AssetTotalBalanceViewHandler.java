package com.huobi.finance.viewhandler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bl.a2;
import bl.v1;
import bl.w1;
import bl.x1;
import bl.y1;
import bl.z1;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LittlePieChartAnimView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.ui.x2;
import com.huobi.finance.utils.AssetAnimHelper;
import com.huobi.finance.utils.UiFillUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.m;
import i6.r;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import q6.d;
import s9.c;
import u6.g;
import zq.e;

public class AssetTotalBalanceViewHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public String f67603b;

    /* renamed from: c  reason: collision with root package name */
    public String f67604c;

    public class a extends d<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f67605e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, View view) {
            super(gVar);
            this.f67605e = view;
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool.booleanValue()) {
                HuobiToastUtil.j(R$string.ht_exchange_please_wait);
            } else {
                AssetModuleConfig.a().B0(this.f67605e.getContext());
            }
        }

        public void onError2(Throwable th2) {
            AssetModuleConfig.a().B0(this.f67605e.getContext());
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            AssetModuleConfig.a().B0(this.f67605e.getContext());
        }
    }

    public static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<LittlePieChartAnimView> f67607b;

        public b(LittlePieChartAnimView littlePieChartAnimView) {
            this.f67607b = new WeakReference<>(littlePieChartAnimView);
        }

        public void run() {
            LittlePieChartAnimView littlePieChartAnimView = (LittlePieChartAnimView) this.f67607b.get();
            if (littlePieChartAnimView != null) {
                littlePieChartAnimView.o(3);
                AssetAnimHelper.c(false);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l(View view) {
        AssetModuleConfig.a().L0("3560", (Map<String, Object>) null);
        BaseModuleConfig.a().w("assets_small_HT_click", (HashMap) null);
        i(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(View view) {
        HuobiToastUtil.j(R$string.balance_detail_no_asset_toast);
        q();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(BaseAssetTotal baseAssetTotal, View view) {
        q();
        x2.a aVar = baseAssetTotal.showCallback;
        if (aVar != null) {
            aVar.I(baseAssetTotal);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void p(BaseAssetTotal baseAssetTotal, View view) {
        if (BaseAssetTotal.isZeroAsset(baseAssetTotal)) {
            HuobiToastUtil.j(R$string.balance_detail_no_asset_toast);
        } else {
            x2.a aVar = baseAssetTotal.showCallback;
            if (aVar != null) {
                aVar.I(baseAssetTotal);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResId() {
        return R$layout.item_balance_asset_total;
    }

    public String h(BaseAssetTotal baseAssetTotal) {
        return baseAssetTotal.getNetAssetToBtc();
    }

    public final void i(View view) {
        v7.b.a().getHtExchangeSubmitStatus().b().compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) view.getContext())).subscribe(new a((g) view.getContext(), view));
    }

    @SensorsDataInstrumented
    public final void j(View view) {
        BaseModuleConfig.a().b("5171", (Map<String, Object>) null);
        BaseModuleConfig.a().w("assets_huobi_earn_click", (HashMap) null);
        AssetModuleConfig.a().m1(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: k */
    public void handleView(v9.c cVar, int i11, BalanceDataTotal balanceDataTotal, ViewGroup viewGroup) {
        String str;
        String str2;
        String str3;
        if (this.f67603b == null) {
            this.f67603b = cVar.itemView.getResources().getString(R$string.global_crossbar);
        }
        if (this.f67604c == null) {
            this.f67604c = cVar.itemView.getResources().getString(R$string.balance_hide_star);
        }
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.balance_header_hint);
        TextView textView2 = (TextView) e11.b(R$id.tv_total_amount);
        TextView textView3 = (TextView) e11.b(R$id.tv_total_amount_legal);
        ImageView imageView = (ImageView) e11.b(R$id.total_balance_header_chart);
        View b11 = e11.b(R$id.ll_func);
        LittlePieChartAnimView littlePieChartAnimView = (LittlePieChartAnimView) e11.b(R$id.total_balance_header_chart_anim);
        if (balanceDataTotal == null) {
            str = "";
        } else {
            str = balanceDataTotal.getTitle();
        }
        UiFillUtil.a(textView, str);
        String h11 = balanceDataTotal != null ? h(balanceDataTotal) : null;
        String netAsset = balanceDataTotal != null ? balanceDataTotal.getNetAsset() : null;
        if (TextUtils.isEmpty(h11)) {
            str2 = this.f67603b;
        } else if (balanceDataTotal.isShow()) {
            str2 = m.u0(h11, 12, 8);
        } else {
            str2 = this.f67604c;
        }
        if (TextUtils.isEmpty(netAsset)) {
            str3 = this.f67603b;
        } else if (balanceDataTotal.isShow()) {
            str3 = LegalCurrencyConfigUtil.J(textView3.getContext(), netAsset);
        } else {
            str3 = this.f67604c;
        }
        UiFillUtil.a(textView3, str3);
        UiFillUtil.a(textView2, str2);
        r(balanceDataTotal, imageView, littlePieChartAnimView);
        b11.setVisibility(0);
        e11.b(R$id.exchange_ht_entrance).setOnClickListener(new w1(this));
        View b12 = e11.b(R$id.ll_huobi_earn);
        b12.setOnClickListener(new y1(this));
        e.e().f(true).compose(RxJavaHelper.t((g) null)).subscribe(SilentSubscriber.a(new a2(b12)));
    }

    public final void q() {
        AssetModuleConfig.a().L0("256", (Map<String, Object>) null);
    }

    public final void r(BaseAssetTotal baseAssetTotal, ImageView imageView, LittlePieChartAnimView littlePieChartAnimView) {
        int i11;
        if (!AssetAnimHelper.b()) {
            littlePieChartAnimView.setVisibility(8);
            imageView.setVisibility(0);
            if (BaseAssetTotal.isZeroAsset(baseAssetTotal)) {
                i11 = R$drawable.balance_btn_pie_gray;
            } else {
                i11 = R$drawable.balance_btn_pie;
            }
            imageView.setImageResource(i11);
            imageView.setOnClickListener(new v1(baseAssetTotal));
        } else if (BaseAssetTotal.isZeroAsset(baseAssetTotal)) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new x1(this));
            imageView.setImageResource(R$drawable.balance_btn_pie_gray);
            littlePieChartAnimView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            littlePieChartAnimView.setVisibility(0);
            littlePieChartAnimView.setOnClickListener(new z1(this, baseAssetTotal));
            if (AssetAnimHelper.a()) {
                i.b().g(new b(littlePieChartAnimView), 2000);
            }
        }
    }
}
