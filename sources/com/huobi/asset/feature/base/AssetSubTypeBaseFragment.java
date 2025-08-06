package com.huobi.asset.feature.base;

import al.p;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.asset.widget.FilterViewData;
import com.huobi.asset.widget.LoadingViewData;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.BaseAssetTotal;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import ph.c;
import ph.e;
import ph.f;
import rx.Observable;
import uh.d;

public abstract class AssetSubTypeBaseFragment extends EmptyMVPFragment implements d.a {

    /* renamed from: l  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f42305l;

    /* renamed from: m  reason: collision with root package name */
    public final View.OnClickListener f42306m = new ph.b(this);

    /* renamed from: n  reason: collision with root package name */
    public LoadingViewData f42307n;

    /* renamed from: o  reason: collision with root package name */
    public BaseAssetTotal f42308o;

    /* renamed from: p  reason: collision with root package name */
    public List<? extends BaseAssetInfo> f42309p;

    /* renamed from: q  reason: collision with root package name */
    public AssetHeadView.AssetHeadData f42310q;

    /* renamed from: r  reason: collision with root package name */
    public final AssetSubTypesContainerFragment f42311r;

    /* renamed from: s  reason: collision with root package name */
    public FilterViewData f42312s;

    /* renamed from: t  reason: collision with root package name */
    public Runnable f42313t;

    /* renamed from: u  reason: collision with root package name */
    public View f42314u;

    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f42315a = Integer.MAX_VALUE;

        public a() {
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            if (AssetSubTypeBaseFragment.this.f42305l.getChildCount() > 0) {
                boolean z11 = false;
                View childAt = AssetSubTypeBaseFragment.this.f42305l.getChildAt(0);
                int childAdapterPosition = AssetSubTypeBaseFragment.this.f42305l.getChildAdapterPosition(childAt);
                if (childAt.getId() == R$id.filter_bar_container) {
                    this.f42315a = childAdapterPosition;
                }
                View Ih = AssetSubTypeBaseFragment.this.f42314u;
                if (childAdapterPosition >= this.f42315a) {
                    z11 = true;
                }
                ViewUtil.m(Ih, z11);
            }
        }
    }

    public class b extends BalanceListShowCallbackAdapter {
        public b() {
        }

        public void I(BaseAssetTotal baseAssetTotal) {
            ph.a.c().f(AssetSubTypeBaseFragment.this.getActivity(), baseAssetTotal);
        }
    }

    public AssetSubTypeBaseFragment(AssetSubTypesContainerFragment assetSubTypesContainerFragment) {
        this.f42311r = assetSubTypesContainerFragment;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        Wh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oh(BaseAssetTotal baseAssetTotal) {
        Rh(baseAssetTotal);
        this.f42310q.f(true);
        Jh(baseAssetTotal.getDetailInfos());
        this.f42311r.Kh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(APIStatusErrorException aPIStatusErrorException) {
        Uh();
        this.f42311r.Kh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qh(Throwable th2) {
        Uh();
        this.f42311r.Kh();
    }

    public void Ah() {
        super.Ah();
    }

    public void Ec() {
        if (this.f42309p != null) {
            this.f42310q.f(false);
            Jh(this.f42309p);
        }
    }

    public void Jh(List<? extends BaseAssetInfo> list) {
        this.f42309p = list;
        List<P> b11 = d.d().b(list);
        if (b11.size() == 0) {
            Th();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f42310q);
        arrayList.add(this.f42312s);
        arrayList.addAll(b11);
        this.f42305l.setData(arrayList);
    }

    public abstract Observable<? extends BaseAssetTotal> Kh();

    public abstract AssetHeadView.AssetHeadData Lh();

    public String Mh() {
        return null;
    }

    public void Rh(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal != null) {
            this.f42308o = baseAssetTotal;
            baseAssetTotal.setShowCallback(new b());
            AssetHeadView.AssetHeadData assetHeadData = this.f42310q;
            if (assetHeadData != null) {
                assetHeadData.e(baseAssetTotal);
            }
        }
    }

    public void Sh(boolean z11) {
        this.f42305l.c();
    }

    public void Th() {
        i6.d.b("onLoadEmpty show");
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f42310q);
        arrayList.add(this.f42312s);
        this.f42307n.g(3);
        arrayList.add(this.f42307n);
        this.f42305l.setData(arrayList);
        this.f42305l.c();
    }

    public void Uh() {
        i6.d.b("onLoadFail");
        if (this.f42309p == null) {
            i6.d.b("onLoadFail show");
            this.f42307n.g(2);
            this.f42305l.c();
        }
    }

    public void Vh() {
        if (this.f42313t == null) {
            this.f42313t = new c(this);
        }
        i.b().h(this.f42313t);
        i.b().g(this.f42313t, 1000);
    }

    public void Wh() {
        Observable<? extends BaseAssetTotal> Kh = Kh();
        if (Kh != null) {
            showLoading();
            Kh.compose(RxJavaHelper.t(zh())).subscribe(EasySubscriber.create(new e(this), new ph.d(this), new f(this)));
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void hideAmountChange(gh.b bVar) {
        Sh(bVar.b());
    }

    public void initViews() {
        super.initViews();
        this.f42314u = this.f67460i.b(R$id.stick_filter_bar);
        EasyRecyclerView<s9.a> easyRecyclerView = (EasyRecyclerView) this.f67460i.b(R$id.rcv);
        this.f42305l = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new StableLinearLayoutManager(getActivity()));
        this.f42305l.addItemDecoration(p.p(getActivity()));
        this.f42305l.addOnScrollListener(new a());
        this.f42310q = Lh();
        this.f42312s = new FilterViewData();
        this.f42307n = new LoadingViewData(this.f42306m);
        d.d().a(this);
        Vh();
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        EventBus.d().p(this);
        return layoutInflater.inflate(R$layout.fragment_asset_future_list, viewGroup, false);
    }

    public void showLoading() {
        i6.d.b("showLoading");
        if (this.f42309p == null && this.f42307n != null) {
            i6.d.b("showLoading show");
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f42310q);
            this.f42307n.g(1);
            arrayList.add(this.f42307n);
            this.f42305l.setData(arrayList);
        }
    }

    public void th(boolean z11) {
        super.th(z11);
        if (z11) {
            Vh();
            String Mh = Mh();
            if (Mh != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Page_name", Mh);
                BaseModuleConfig.a().w("app_assets_all_view", hashMap);
            }
        }
    }
}
