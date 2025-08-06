package com.huobi.asset2.index.component;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.TransferSellList;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import u6.g;
import v7.b;
import xh.s;
import xh.t;
import xh.u;
import xh.v;
import xh.w;

public class FeatureEntranceBar extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public final Context f42671b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42672c;

    public class a extends EasySubscriber<TransferSellList> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(TransferSellList transferSellList) {
            super.onNext(transferSellList);
            boolean z11 = transferSellList.getIsClearRange() == 1;
            if (FeatureEntranceBar.this.f42672c != z11) {
                boolean unused = FeatureEntranceBar.this.f42672c = z11;
                FeatureEntranceBar.this.s();
                FeatureEntranceBar featureEntranceBar = FeatureEntranceBar.this;
                featureEntranceBar.r(true ^ featureEntranceBar.f42672c);
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public FeatureEntranceBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void l(View view) {
        if (AssetModuleConfig.a().c()) {
            HuobiToastUtil.j(R$string.n_balance_subaccount_deposit_nosupport);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        AssetModuleConfig.a().v0((Activity) view.getContext(), "1");
        gi.a.h(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void m(View view) {
        if (AssetModuleConfig.a().c()) {
            HuobiToastUtil.j(R$string.n_balance_subaccount_withdraw_nosupport);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        AssetModuleConfig.a().v0((Activity) view.getContext(), "2");
        gi.a.h(1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void n(View view) {
        AssetModuleConfig.a().k1((Activity) view.getContext(), "usdt", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
        gi.a.h(2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(View view) {
        BaseModuleConfig.a().R(getContext());
        gi.a.h(3);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void p(View view) {
        bc.a a11 = AssetModuleConfig.a();
        Context context = this.f42671b;
        a11.B((FragmentActivity) context, (g) context);
        gi.a.h(4);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void j(int i11, int i12, View.OnClickListener onClickListener) {
        k(i11, i12, onClickListener, -1);
    }

    public final void k(int i11, int i12, View.OnClickListener onClickListener, int i13) {
        FeatureEntranceItemView featureEntranceItemView = new FeatureEntranceItemView(this.f42671b);
        featureEntranceItemView.b(i11, i12);
        featureEntranceItemView.setOnClickListener(onClickListener);
        addView(featureEntranceItemView, i13, new LinearLayout.LayoutParams(0, -2, 1.0f));
    }

    public void q(g gVar) {
        b.a().getTransferSellList().b().compose(RxJavaHelper.t(gVar)).subscribe(new a());
    }

    public final void r(boolean z11) {
        d.j("FeatureEntranceBar", "showEntranceList showDeposit=" + z11);
        if (z11) {
            k(R$drawable.wallet_01_buyicon_new_01, R$string.n_otc_deposit_title, u.f61622b, 0);
        }
    }

    public final void s() {
        removeAllViews();
        j(R$drawable.wallet_icon_withdraw_new, R$string.n_asset_position_trade_coin, v.f61623b);
        j(R$drawable.wallet_icon_transfer_new, R$string.balance_margin_transfer, w.f61624b);
        j(R$drawable.wallet_icon_order_flow_new, R$string.n_asset_record, new s(this));
        if (ti.a.a()) {
            j(R$drawable.wallet_icon_cloudwallet_new, R$string.n_cloud_wallet, new t(this));
        }
    }

    public FeatureEntranceBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42672c = true;
        this.f42671b = context;
        s();
    }
}
