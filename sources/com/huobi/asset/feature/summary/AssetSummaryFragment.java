package com.huobi.asset.feature.summary;

import al.a;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.SpotAssertInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.asset.feature.base.BaseAssetFragment;
import com.huobi.asset.feature.summary.AssetSummaryAccountItemView;
import com.huobi.asset.feature.summary.AssetSummaryHeaderView;
import com.huobi.asset.widget.AssetLoadingView;
import com.huobi.finance.ui.g7;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import java.util.HashMap;
import java.util.List;
import jp.k0;
import org.greenrobot.eventbus.EventBus;
import qh.g;
import qh.h;
import qh.i;
import qh.i0;
import qh.j;
import qh.k;
import qh.l;
import qh.m;
import qh.p0;
import rh.q;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uh.f;

public class AssetSummaryFragment extends BaseAssetFragment implements AssetSummaryHeaderView.h, AssetSummaryAccountItemView.b {

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f42361n;

    /* renamed from: o  reason: collision with root package name */
    public AssetSummaryHeaderView f42362o;

    /* renamed from: p  reason: collision with root package name */
    public final HashMap<String, AssetSummaryAccountItemView> f42363p = new HashMap<>();

    /* renamed from: q  reason: collision with root package name */
    public AssetLoadingView f42364q;

    /* renamed from: r  reason: collision with root package name */
    public BalanceProfitLossData f42365r;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Uh(View view) {
        k0.k(getActivity());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Pair Wh(BalanceProfitLossData balanceProfitLossData) {
        return new Pair(balanceProfitLossData, a.e(getContext(), balanceProfitLossData));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xh(Pair pair) {
        Sh((BalanceProfitLossData) pair.first, (List) pair.second);
        Kh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yh(APIStatusErrorException aPIStatusErrorException) {
        di();
        Kh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zh(Throwable th2) {
        di();
        Kh();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ai(View view) {
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Dc(boolean z11) {
        f.a().c(z11);
        if (this.f42365r != null && getActivity() != null) {
            Sh(this.f42365r, a.e(getActivity(), this.f42365r));
        }
    }

    public void Eb() {
        this.f42361n.requestLayout();
        this.f42361n.invalidate();
    }

    public int Fh() {
        return R$layout.fragment_asset_summary;
    }

    public String Gh() {
        return "app_assets_overview_view";
    }

    public void H7() {
        AssetModuleConfig.a().B(getActivity(), this);
    }

    public void I9(View view, BalanceProfitLossData.AccountBalance accountBalance) {
        EventBus.d().k(new th.a(AssetSummaryAccountType.get(accountBalance.getDistributionType()), (AssetSummaryAccountType) null));
    }

    public void Ih(boolean z11) {
        HashMap<String, AssetSummaryAccountItemView> hashMap = this.f42363p;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (String str : this.f42363p.keySet()) {
                AssetSummaryAccountItemView assetSummaryAccountItemView = this.f42363p.get(str);
                if (assetSummaryAccountItemView != null) {
                    assetSummaryAccountItemView.v();
                }
            }
        }
    }

    public void Jh() {
        bi();
    }

    public final void Sh(BalanceProfitLossData balanceProfitLossData, List<BalanceProfitLossData.AccountBalance> list) {
        if (isAdded() && getContext() != null) {
            if (balanceProfitLossData == null) {
                ci();
                return;
            }
            this.f42365r = balanceProfitLossData;
            if (f.a().b()) {
                list = a.a(list);
            }
            this.f42361n.removeAllViews();
            this.f42362o.w(balanceProfitLossData);
            this.f42361n.addView(this.f42362o);
            if (p0.n().p()) {
                this.f42364q.getLoadingLayout().setBackgroundResource(R$drawable.asset_filter_bg);
                this.f42364q.getLoadingLayoutParent().setPadding(0, PixelUtils.a(10.0f), 0, 0);
                Th();
                this.f42364q.setState(4);
                this.f42361n.addView(this.f42364q);
                return;
            }
            this.f42364q.getLoadingLayout().setBackground((Drawable) null);
            this.f42364q.getLoadingLayoutParent().setPadding(0, 0, 0, 0);
            if (CollectionsUtils.b(list)) {
                this.f42364q.setState(3);
                this.f42361n.addView(this.f42364q);
                return;
            }
            for (BalanceProfitLossData.AccountBalance next : list) {
                String distributionType = next.getDistributionType();
                AssetSummaryAccountType assetSummaryAccountType = AssetSummaryAccountType.get(distributionType);
                if (assetSummaryAccountType == AssetSummaryAccountType.CONTRACT || assetSummaryAccountType == AssetSummaryAccountType.MARGIN || !this.f42363p.containsKey(distributionType)) {
                    AssetSummaryAccountItemView assetSummaryAccountItemView = new AssetSummaryAccountItemView(getContext());
                    assetSummaryAccountItemView.setOnItemClickListener(this);
                    this.f42363p.put(distributionType, assetSummaryAccountItemView);
                }
                this.f42363p.get(distributionType).j(next);
                this.f42361n.addView(this.f42363p.get(distributionType));
            }
        }
    }

    public final void Th() {
        LoadingLayout loadingLayout = this.f42364q.getLoadingLayout();
        TextView textView = (TextView) loadingLayout.findViewById(R$id.tv_balance_guide_text);
        TextView textView2 = (TextView) loadingLayout.findViewById(R$id.tv_balance_guide_to_otc);
        TextView textView3 = (TextView) loadingLayout.findViewById(R$id.tv_balance_guide_to_otc_tips);
        SpotAssertInfo o11 = p0.n().o();
        if (textView != null) {
            if (o11 != null && !TextUtils.isEmpty(o11.getDepositTag())) {
                String depositTag = o11.getDepositTag();
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    textView3.setText(depositTag);
                }
            } else if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        if (textView2 != null) {
            textView2.setOnClickListener(new qh.f(this));
        }
    }

    public final void bi() {
        if (this.f42365r == null) {
            showLoading();
        }
        q.s().map(m.f53357b).map(new l(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(EasySubscriber.create(new i(this), new j(this), new k(this)));
        if (p0.n().p()) {
            p0.n().y();
        }
    }

    public final void ci() {
        d.b("onLoadEmpty show");
        this.f42364q.setState(3);
        this.f42361n.removeAllViews();
        this.f42361n.addView(this.f42364q);
    }

    public final void di() {
        d.b("onLoadFail");
        if (this.f42365r == null) {
            d.b("onLoadFail show");
            this.f42364q.setState(2);
            this.f42361n.removeAllViews();
            this.f42361n.addView(this.f42364q);
        }
    }

    public void o7() {
        new g7(getContext(), zh(), new h(this)).f();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f42365r = i0.d().c();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f42361n = (LinearLayout) view.findViewById(R$id.asset_summary_list_container);
        AssetSummaryHeaderView assetSummaryHeaderView = new AssetSummaryHeaderView(getContext());
        this.f42362o = assetSummaryHeaderView;
        assetSummaryHeaderView.setCallback(this);
        AssetLoadingView assetLoadingView = new AssetLoadingView(getContext());
        this.f42364q = assetLoadingView;
        assetLoadingView.getLoadingLayout().setBackground((Drawable) null);
        this.f42364q.getEmptyLayout().setBackground((Drawable) null);
        this.f42364q.getErrorLayout().setBackground((Drawable) null);
        this.f42364q.setRetryListener(new g(this));
        BalanceProfitLossData balanceProfitLossData = this.f42365r;
        if (balanceProfitLossData != null) {
            Sh(balanceProfitLossData, a.e(getActivity(), this.f42365r));
        } else {
            bi();
        }
    }

    public final void showLoading() {
        d.b("showLoading");
        if (this.f42365r == null) {
            d.b("showLoading show");
            this.f42364q.setState(1);
            this.f42361n.removeAllViews();
            this.f42361n.addView(this.f42364q);
        }
    }

    public void ze(View view, BalanceProfitLossData.AccountBalance accountBalance, BalanceProfitLossData.AccountBalance accountBalance2) {
        EventBus.d().k(new th.a(AssetSummaryAccountType.get(accountBalance.getDistributionType()), AssetSummaryAccountType.get(accountBalance2.getDistributionType())));
    }
}
