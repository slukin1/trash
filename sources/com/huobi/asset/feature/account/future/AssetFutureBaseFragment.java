package com.huobi.asset.feature.account.future;

import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.asset.feature.account.future.maintenance.MaintenanceData;
import com.huobi.asset.feature.base.AssetSubTypeBaseFragment;
import com.huobi.asset.feature.base.AssetSubTypesContainerFragment;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.BaseAssetTotal;
import ih.a;
import ih.b;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import uh.d;

public abstract class AssetFutureBaseFragment extends AssetSubTypeBaseFragment {

    /* renamed from: v  reason: collision with root package name */
    public MaintenanceData f42240v;

    public AssetFutureBaseFragment(AssetSubTypesContainerFragment assetSubTypesContainerFragment) {
        super(assetSubTypesContainerFragment);
    }

    public static /* synthetic */ BaseAssetTotal ci(ContractHeartBeat contractHeartBeat, BaseAssetTotal baseAssetTotal) {
        return baseAssetTotal;
    }

    public void Jh(List<? extends BaseAssetInfo> list) {
        this.f42309p = list;
        if (AssetModuleConfig.a().b0(Zh())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bi());
            this.f42305l.setData(arrayList);
            return;
        }
        List<P> b11 = d.d().b(list);
        if (b11.size() == 0) {
            Th();
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f42310q);
        arrayList2.add(this.f42312s);
        arrayList2.addAll(b11);
        this.f42305l.setData(arrayList2);
    }

    public Observable<? extends BaseAssetTotal> Kh() {
        return Observable.zip(AssetModuleConfig.a().X().compose(RxJavaHelper.t(zh())).onErrorResumeNext(Observable.just(null)), ai(), b.f55078b);
    }

    public abstract int Zh();

    public abstract Observable<? extends BaseAssetTotal> ai();

    public final MaintenanceData bi() {
        if (this.f42240v == null) {
            this.f42240v = new MaintenanceData(Zh(), this, new a(this));
        }
        return this.f42240v;
    }
}
