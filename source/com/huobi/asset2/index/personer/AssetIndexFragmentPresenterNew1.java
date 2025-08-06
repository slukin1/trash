package com.huobi.asset2.index.personer;

import a7.e;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BaseAssetPositionAccountData;
import i6.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import qh.i0;
import rx.Observable;
import sl.f0;
import u6.g;
import vk.i;
import vk.k;
import zh.a2;
import zh.b2;
import zh.c2;
import zh.d2;
import zh.e2;
import zh.f2;
import zh.g2;
import zh.y1;
import zh.z1;

public class AssetIndexFragmentPresenterNew1 extends BaseFragmentPresenter<a> {

    /* renamed from: c  reason: collision with root package name */
    public i0 f42736c;

    /* renamed from: d  reason: collision with root package name */
    public int f42737d = 1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42738e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42739f;

    /* renamed from: g  reason: collision with root package name */
    public String f42740g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42741h = false;

    /* renamed from: i  reason: collision with root package name */
    public List<k> f42742i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public k.a f42743j = new g2(this);

    /* renamed from: k  reason: collision with root package name */
    public AssetAccountType[] f42744k;

    /* renamed from: l  reason: collision with root package name */
    public ArrayList<AssetAccountType> f42745l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    public List<BaseAssetPositionAccountData> f42746m = new ArrayList();

    public interface a extends h6.a, g {
        void H1(List<k> list, String str, boolean z11);

        void x1();
    }

    public static /* synthetic */ Integer s0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Integer t0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Integer u0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Map v0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Object w0(Integer num, Integer num2, Integer num3, Map map) {
        return null;
    }

    /* renamed from: A0 */
    public final void n0(int i11) {
        boolean z11 = true;
        String str = "";
        if (this.f42737d != i11) {
            this.f42737d = i11;
            for (k next : this.f42742i) {
                if (next.c() == i11) {
                    str = next.a();
                }
                next.f(next.c() == i11);
            }
            z0();
            gi.a.v(this.f42737d);
        }
        a aVar = (a) getUI();
        List<k> list = this.f42742i;
        if (i11 != 0) {
            z11 = false;
        }
        aVar.H1(list, str, z11);
    }

    public final void l0() {
        if (BaseModuleConfig.a().c()) {
            this.f42744k = new AssetAccountType[]{AssetAccountType.SPOT, AssetAccountType.FUTURE, AssetAccountType.MARGIN, AssetAccountType.QUANT};
            return;
        }
        this.f42744k = new AssetAccountType[]{AssetAccountType.SPOT, AssetAccountType.FUTURE, AssetAccountType.MARGIN, AssetAccountType.OTC, AssetAccountType.HUOBI_EARN, AssetAccountType.QUANT, AssetAccountType.WARRANT};
    }

    public final void m0() {
        List<k> list = this.f42742i;
        int i11 = R$string.n_asset_count_equivalent_sort;
        list.add(new k(true, getString(i11), 1, this.f42743j));
        this.f42742i.add(new k(false, getString(R$string.n_asset_profit_sort), 2, this.f42743j));
        this.f42742i.add(new k(false, getString(R$string.n_asset_Yield_sort), 3, this.f42743j));
        ((a) getUI()).H1(this.f42742i, getString(i11), true);
    }

    public void onPause() {
        super.onPause();
        f0.g().m();
    }

    public void onResume() {
        super.onResume();
        f0.g().i();
    }

    /* renamed from: x0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        this.f42736c = i0.d();
        this.f42739f = BaseModuleConfig.a().c();
        this.f42740g = BaseModuleConfig.a().getUid();
        l0();
        m0();
        y0().subscribe(EasySubscriber.create(a2.f62992b, y1.f63070b, z1.f63073b));
    }

    public final Observable<Object> y0() {
        d.c("AssetIndexFragmentPresenter", "preLoad");
        return Observable.zip(e.K(TradeType.CONTRACT).onErrorReturn(d2.f63004b), e.K(TradeType.SWAP).onErrorReturn(e2.f63008b), e.K(TradeType.LINEAR_SWAP).onErrorReturn(c2.f63000b), LegalCurrencyConfigUtil.e().onErrorReturn(b2.f62996b), f2.f63012b).compose(RxJavaHelper.t((g) getUI())).timeout(5, TimeUnit.SECONDS);
    }

    public final void z0() {
        for (int i11 = 0; i11 < this.f42746m.size(); i11++) {
            BaseAssetPositionAccountData baseAssetPositionAccountData = this.f42746m.get(i11);
            if (baseAssetPositionAccountData instanceof i) {
                baseAssetPositionAccountData.c(this.f42737d, this.f42741h);
            }
        }
        ((a) getUI()).x1();
    }
}
