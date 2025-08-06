package hh;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.BizShow;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.account.future.FutureAccountConfig;
import com.huobi.asset.feature.account.huobiearn.HuobiEarnAccountConfig;
import com.huobi.asset.feature.account.margin.MarginAccountConfig;
import com.huobi.asset.feature.account.mortgage.config.MortgageAccountConfig;
import com.huobi.asset.feature.account.otc.OtcAccountConfig;
import com.huobi.asset.feature.account.pool.PoolAccountConfig;
import com.huobi.asset.feature.account.quant.QuantAccountConfig;
import com.huobi.asset.feature.account.spot.SpotAccountConfig;
import com.huobi.asset.feature.account.warrant.WarrantAccountConfig;
import com.huobi.finance.bean.BaseAssetTotal;
import gj.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import rx.Observable;
import u6.g;
import v7.b;

public final class f {

    /* renamed from: d  reason: collision with root package name */
    public static final f f47592d = new f();

    /* renamed from: a  reason: collision with root package name */
    public List<a<? extends BaseAssetTotal>> f47593a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedHashMap<AssetAccountType, a<?>> f47594b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<Integer> f47595c;

    public interface a<T extends BaseAssetTotal> {
        Fragment a();

        Observable<T> b();

        String c(Context context);

        AssetAccountType d();

        int getPriority();
    }

    public static f h() {
        return f47592d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean m(List list) {
        t(list);
        ArrayList arrayList = new ArrayList();
        this.f47593a = arrayList;
        arrayList.add(new SpotAccountConfig());
        if (d.n().E()) {
            this.f47593a.add(new FutureAccountConfig());
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            BizShow bizShow = (BizShow) it2.next();
            if (bizShow.getAction().isShowAssetPage()) {
                int bizType = bizShow.getBizType();
                if (bizType == 1) {
                    this.f47593a.add(new MortgageAccountConfig());
                } else if (bizType != 2) {
                    switch (bizType) {
                        case 10:
                            this.f47593a.add(new OtcAccountConfig());
                            break;
                        case 11:
                            this.f47593a.add(new PoolAccountConfig());
                            break;
                        case 12:
                            this.f47593a.add(new HuobiEarnAccountConfig());
                            break;
                        case 13:
                            this.f47593a.add(new QuantAccountConfig());
                            break;
                        case 14:
                            this.f47593a.add(new WarrantAccountConfig());
                            break;
                    }
                } else if (d.n().G()) {
                    this.f47593a.add(new MarginAccountConfig());
                }
            }
        }
        v();
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean n(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.f47593a = arrayList;
        arrayList.add(new SpotAccountConfig());
        if (d.n().E()) {
            this.f47593a.add(new FutureAccountConfig());
        }
        this.f47593a.add(new MortgageAccountConfig());
        if (d.n().G()) {
            this.f47593a.add(new MarginAccountConfig());
        }
        this.f47593a.add(new HuobiEarnAccountConfig());
        this.f47593a.add(new QuantAccountConfig());
        this.f47593a.add(new WarrantAccountConfig());
        if (BaseModuleConfig.a().c()) {
            this.f47593a.add(new OtcAccountConfig());
            this.f47593a.add(new PoolAccountConfig());
        }
        v();
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            BizShow bizShow = (BizShow) it2.next();
            if (bizShow.getAction().isShowAssetPage()) {
                arrayList.add(bizShow);
            }
        }
        if (arrayList.size() != this.f47595c.size()) {
            r(list);
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            if (!this.f47595c.contains(Integer.valueOf(((BizShow) it3.next()).getBizType()))) {
                r(list);
            }
        }
    }

    public List<a<?>> f() {
        return this.f47593a;
    }

    public a<?> g(AssetAccountType assetAccountType) {
        LinkedHashMap<AssetAccountType, a<?>> linkedHashMap = this.f47594b;
        if (linkedHashMap == null) {
            return null;
        }
        return linkedHashMap.get(assetAccountType);
    }

    public AssetAccountType i() {
        AssetAccountType assetAccountType = null;
        String i11 = SP.i("asset_account_manager_select_accout_type", (String) null);
        if (TextUtils.isEmpty(i11)) {
            return null;
        }
        try {
            assetAccountType = AssetAccountType.valueOf(i11);
            i6.d.b("getLastSelectAccount ==> " + assetAccountType.toString());
            return assetAccountType;
        } catch (Exception e11) {
            e11.printStackTrace();
            return assetAccountType;
        }
    }

    public Observable<Boolean> j(Observable<List<BizShow>> observable) {
        return observable.map(new e(this)).onErrorReturn(new d(this));
    }

    public Observable<Boolean> k() {
        i6.d.b("AccountConfig init");
        return j(b.a().getBizShow().b());
    }

    public boolean l() {
        return true;
    }

    public final void r(List<BizShow> list) {
        i6.d.b("AccountConfig onAccountConfigChanged");
        j(Observable.just(list)).subscribe(SilentSubscriber.a(c.f54937b));
    }

    public void s() {
        i6.d.b("AccountConfig refreshAccountConfig");
        b.a().getBizShow().b().compose(RxJavaHelper.t((g) null)).subscribe(SilentSubscriber.a(new b(this)));
    }

    public final void t(List<BizShow> list) {
        if (this.f47595c == null) {
            this.f47595c = new HashSet<>();
        }
        this.f47595c.clear();
        for (BizShow next : list) {
            if (next.getAction().isShowAssetPage()) {
                this.f47595c.add(Integer.valueOf(next.getBizType()));
            }
        }
        i6.d.b("AccountConfig saveBizShow showBizTypeSet=" + this.f47595c.toString());
    }

    public void u(int i11) {
        i6.d.b("saveLastSelectAccount index=" + i11);
        if (i11 == 0) {
            SP.s("asset_account_manager_select_accout_type", "");
            return;
        }
        int i12 = i11 - 1;
        List<a<? extends BaseAssetTotal>> list = this.f47593a;
        if (list != null && i12 >= 0 && i12 <= list.size() - 1) {
            AssetAccountType d11 = this.f47593a.get(i12).d();
            SP.s("asset_account_manager_select_accout_type", d11.toString());
            i6.d.b("saveLastSelectAccount success. accountType=" + d11.toString());
        }
    }

    public final void v() {
        Collections.sort(this.f47593a, a.f54935b);
        this.f47594b = new LinkedHashMap<>();
        for (a next : this.f47593a) {
            this.f47594b.put(next.d(), next);
        }
    }
}
