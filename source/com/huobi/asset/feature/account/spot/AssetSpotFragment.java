package com.huobi.asset.feature.account.spot;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeConfig;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.base.BaseAssetListFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.asset.widget.HtExchangeViewData;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.viewhandler.AssetSpotHeaderViewHandler;
import com.huobi.finance.viewhandler.AssetSpotItemViewAdapter;
import hh.f;
import k20.h;
import oh.b;
import oh.c;
import org.greenrobot.eventbus.ThreadMode;
import qh.i0;
import qh.p0;
import rx.Observable;

public class AssetSpotFragment extends BaseAssetListFragment {

    public static class a extends AssetHeadView.AssetHeadData {

        /* renamed from: d  reason: collision with root package name */
        public AssetSpotFragment f42292d;

        public a(AssetSpotFragment assetSpotFragment) {
            this.f42292d = assetSpotFragment;
        }

        public boolean a(Object obj) {
            return obj instanceof a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this) || !super.equals(obj)) {
                return false;
            }
            AssetSpotFragment g11 = g();
            AssetSpotFragment g12 = aVar.g();
            return g11 != null ? g11.equals(g12) : g12 == null;
        }

        public AssetSpotFragment g() {
            return this.f42292d;
        }

        public String getViewHandlerName() {
            return AssetSpotHeaderViewHandler.class.getName();
        }

        public int hashCode() {
            int hashCode = super.hashCode();
            AssetSpotFragment g11 = g();
            return (hashCode * 59) + (g11 == null ? 43 : g11.hashCode());
        }

        public String toString() {
            return "AssetSpotFragment.HeadViewData(fragment=" + g() + ")";
        }
    }

    public static /* synthetic */ Object ji(Boolean bool, BalanceProfitLossData balanceProfitLossData) {
        return balanceProfitLossData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ki(Object obj) {
        this.f42326n.c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void li(UsdtExchangeConfig usdtExchangeConfig) {
        ((HtExchangeViewData) this.f42333u).h(usdtExchangeConfig.isClearedUser());
        ((HtExchangeViewData) this.f42333u).g(usdtExchangeConfig.getTag());
        this.f42326n.c();
    }

    public String Gh() {
        return "app_assets_Exchange_view";
    }

    public void Jh() {
        super.Jh();
        if (Vh()) {
            p0.n().i();
        }
    }

    public Observable<? extends BaseAssetTotal> Rh() {
        i0 d11 = i0.d();
        Observable.zip(d11.f(), d11.e(), c.f58856b).compose(RxJavaHelper.t(zh())).subscribe(EasySubscriber.create(new b(this)));
        v7.b.a().getUsdtExchangeConfig().b().compose(HbgRetrofit.e()).compose(RxJavaHelper.t(zh())).subscribe(EasySubscriber.create(new oh.a(this)));
        f.a<?> g11 = f.h().g(AssetAccountType.SPOT);
        return g11 == null ? Observable.empty() : g11.b();
    }

    public AssetHeadView.AssetHeadData Sh() {
        return new a(this);
    }

    public String Th() {
        return getResources().getString(R$string.n_balance_hidden_zero_asset);
    }

    public s9.a Uh() {
        return new HtExchangeViewData();
    }

    public boolean Vh() {
        return p0.n().p();
    }

    public boolean ai() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AssetSpotItemViewAdapter.j();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onSpotItemExpandEvent(AssetSpotItemViewAdapter.a aVar) {
        int a11;
        if (aVar != null && aVar.b() != null && (a11 = this.f42326n.a(aVar.b())) >= 0) {
            this.f42326n.d(a11);
        }
    }
}
