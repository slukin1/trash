package com.huobi.asset.feature.account.huobiearn;

import al.p;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.base.AssetBaseHeaderToSubTypeFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.bean.MiningDataTotal;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hh.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import jh.a;
import jh.b;
import jh.c;
import jh.d;
import jh.e;
import jh.g;
import jh.h;
import vk.n;

public class AssetHuobiEarnFragment extends AssetBaseHeaderToSubTypeFragment {

    /* renamed from: o  reason: collision with root package name */
    public final AssetHeadView.AssetHeadData f42245o = new HeadViewData();

    /* renamed from: p  reason: collision with root package name */
    public final p.a f42246p = b.f55934a;

    /* renamed from: q  reason: collision with root package name */
    public final p.a f42247q = new a(this);

    /* renamed from: r  reason: collision with root package name */
    public AssetHeadView<AssetHeadView.AssetHeadData> f42248r;

    /* renamed from: s  reason: collision with root package name */
    public MiningDataTotal f42249s;

    /* renamed from: t  reason: collision with root package name */
    public HuobiEarnSubTypeAccountFragment f42250t;

    /* renamed from: u  reason: collision with root package name */
    public HuobiEarnSubTypeAccountFragment f42251u;

    /* renamed from: v  reason: collision with root package name */
    public final View.OnClickListener f42252v = new c(this);

    public static class HeadViewData extends AssetHeadView.AssetHeadData {
        public String getViewHandlerName() {
            return "";
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void bi(View view) {
        BaseModuleConfig.a().w("app_assets_Huobi_Earn_now_click", (HashMap) null);
        AssetModuleConfig.a().w0(view.getContext(), "financial/earn/h5?utm_source=huobiearn_assets_go_buy");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void ci(View view) {
        HBBaseWebActivity.showWebView(view.getContext(), BaseModuleConfig.a().W() + "financial/earn/order/h5/", (String) null, (String) null, true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void di(BaseAssetTotal baseAssetTotal) {
        this.f42249s = (MiningDataTotal) baseAssetTotal;
        this.f42245o.f(true);
        ji(this.f42249s);
        ai(this.f42249s);
        Kh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ei(APIStatusErrorException aPIStatusErrorException) {
        Kh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(Throwable th2) {
        Kh();
    }

    public static /* synthetic */ String gi(String str) {
        return str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String hi(String str) {
        return LegalCurrencyConfigUtil.J(getContext(), str);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ii(View view) {
        Qh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String Gh() {
        return "app_assets_Huobi_Earn_view";
    }

    public void Ih(boolean z11) {
        this.f42245o.f(false);
        ji(this.f42249s);
        ai(this.f42249s);
    }

    public List<Fragment> Lh() {
        HuobiEarnSubTypeAccountFragment huobiEarnSubTypeAccountFragment = new HuobiEarnSubTypeAccountFragment();
        this.f42250t = huobiEarnSubTypeAccountFragment;
        huobiEarnSubTypeAccountFragment.Kh(true);
        HuobiEarnSubTypeAccountFragment huobiEarnSubTypeAccountFragment2 = new HuobiEarnSubTypeAccountFragment();
        this.f42251u = huobiEarnSubTypeAccountFragment2;
        huobiEarnSubTypeAccountFragment2.Kh(false);
        return Arrays.asList(new Fragment[]{this.f42250t, this.f42251u});
    }

    public View Mh() {
        if (this.f42248r == null) {
            this.f42248r = new AssetHeadView<>(getActivity());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new vk.c(getResources().getString(R$string.n_balance_goto_earn), e.f55937b));
            this.f42248r.i(arrayList);
            this.f42248r.setDistributionType(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_HUOBI_EARN);
            this.f42248r.k(new HeadViewData());
            String string = getResources().getString(R$string.n_mining_balance_total_estimate);
            String upperCase = LegalCurrencyConfigUtil.d().toUpperCase(Locale.US);
            this.f42248r.f42421f.setText(string.replaceAll("BTC", upperCase));
            this.f42248r.f42431p.setText(getResources().getString(R$string.n_balance_mining_total_yield).replaceAll("BTC", upperCase));
            this.f42248r.f42419d.setVisibility(0);
            this.f42248r.setRecordEntrance(d.f55936b);
            this.f42248r.f42433r.setVisibility(8);
        }
        return this.f42248r;
    }

    public List<String> Nh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R$string.n_asset_ybb_text));
        arrayList.add(getResources().getString(R$string.n_mining_fixed));
        return arrayList;
    }

    public void Oh(View view) {
    }

    public void Qh() {
        f.a<?> g11 = f.h().g(AssetAccountType.HUOBI_EARN);
        if (g11 != null) {
            g11.b().compose(RxJavaHelper.t(zh())).subscribe(EasySubscriber.create(new g(this), new jh.f(this), new h(this)));
        }
    }

    public void ai(MiningDataTotal miningDataTotal) {
        if (miningDataTotal != null) {
            this.f42250t.setData(vk.b.a(miningDataTotal.getActiveList()));
            this.f42250t.Lh(this.f42252v);
            this.f42251u.setData(n.a(miningDataTotal.getFixedList()));
            this.f42251u.Lh(this.f42252v);
        }
    }

    public final void ji(MiningDataTotal miningDataTotal) {
        if (miningDataTotal != null) {
            this.f42245o.e(miningDataTotal);
            this.f42248r.k(this.f42245o);
            this.f42248r.f42432q.setText(p.o(getActivity(), miningDataTotal.getProfitAmountLegal(), p.u(), this.f42246p));
        }
    }
}
