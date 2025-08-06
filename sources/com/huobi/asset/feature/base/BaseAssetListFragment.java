package com.huobi.asset.feature.base;

import al.p;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.asset.widget.FilterBar;
import com.huobi.asset.widget.FilterViewData;
import com.huobi.asset.widget.LoadingViewData;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.BaseAssetTotal;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import ph.i;
import ph.j;
import ph.k;
import ph.l;
import rx.Observable;
import uh.d;

public abstract class BaseAssetListFragment extends BaseAssetFragment implements d.a {

    /* renamed from: n  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f42326n;

    /* renamed from: o  reason: collision with root package name */
    public final View.OnClickListener f42327o = new i(this);

    /* renamed from: p  reason: collision with root package name */
    public LoadingViewData f42328p;

    /* renamed from: q  reason: collision with root package name */
    public List<? extends BaseAssetInfo> f42329q;

    /* renamed from: r  reason: collision with root package name */
    public AssetHeadView.AssetHeadData f42330r;

    /* renamed from: s  reason: collision with root package name */
    public FragmentActivity f42331s;

    /* renamed from: t  reason: collision with root package name */
    public FilterViewData f42332t;

    /* renamed from: u  reason: collision with root package name */
    public s9.a f42333u;

    /* renamed from: v  reason: collision with root package name */
    public BaseAssetTotal f42334v;

    /* renamed from: w  reason: collision with root package name */
    public View f42335w;

    /* renamed from: x  reason: collision with root package name */
    public FilterBar f42336x;

    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f42337a = Integer.MAX_VALUE;

        public a() {
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            if (BaseAssetListFragment.this.f42326n.getChildCount() > 0) {
                boolean z11 = false;
                View childAt = BaseAssetListFragment.this.f42326n.getChildAt(0);
                int childAdapterPosition = BaseAssetListFragment.this.f42326n.getChildAdapterPosition(childAt);
                if (childAt.getId() == R$id.filter_bar_container) {
                    this.f42337a = childAdapterPosition;
                }
                View Ph = BaseAssetListFragment.this.f42335w;
                if (childAdapterPosition >= this.f42337a) {
                    z11 = true;
                }
                ViewUtil.m(Ph, z11);
            }
        }
    }

    public class b extends BalanceListShowCallbackAdapter {
        public b() {
        }

        public void I(BaseAssetTotal baseAssetTotal) {
            ph.a.c().f(BaseAssetListFragment.this.getActivity(), baseAssetTotal);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Wh(View view) {
        fi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xh(BaseAssetTotal baseAssetTotal) {
        bi(baseAssetTotal);
        this.f42330r.f(true);
        Qh(baseAssetTotal.getDetailInfos());
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

    public void Ah() {
        super.Ah();
    }

    public void Ec() {
        if (this.f42329q != null) {
            this.f42330r.f(false);
            Qh(this.f42329q);
        }
    }

    public int Fh() {
        return R$layout.fragment_asset_list;
    }

    public void Ih(boolean z11) {
        this.f42326n.c();
    }

    public void Jh() {
        fi();
    }

    public void Qh(List<? extends BaseAssetInfo> list) {
        this.f42329q = list;
        if (Vh()) {
            ei();
            return;
        }
        List<P> b11 = d.d().b(list);
        if (b11.size() == 0) {
            ci();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f42330r);
        s9.a aVar = this.f42333u;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        arrayList.add(this.f42332t);
        arrayList.addAll(b11);
        this.f42326n.setData(arrayList);
    }

    public abstract Observable<? extends BaseAssetTotal> Rh();

    public abstract AssetHeadView.AssetHeadData Sh();

    public String Th() {
        return null;
    }

    public s9.a Uh() {
        return null;
    }

    public abstract boolean Vh();

    public boolean ai() {
        return false;
    }

    public void bi(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal != null) {
            this.f42334v = baseAssetTotal;
            baseAssetTotal.setShowCallback(new b());
            AssetHeadView.AssetHeadData assetHeadData = this.f42330r;
            if (assetHeadData != null) {
                assetHeadData.e(baseAssetTotal);
            }
        }
    }

    public void ci() {
        i6.d.b("onLoadEmpty show");
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f42330r);
        s9.a aVar = this.f42333u;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        arrayList.add(this.f42332t);
        this.f42328p.g(3);
        arrayList.add(this.f42328p);
        this.f42326n.setData(arrayList);
        this.f42326n.c();
    }

    public void di() {
        i6.d.b("onLoadFail");
        if (this.f42329q == null) {
            i6.d.b("onLoadFail show");
            this.f42328p.g(2);
            this.f42326n.c();
        }
    }

    public void ei() {
        i6.d.b("onLoadGuide show");
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f42330r);
        s9.a aVar = this.f42333u;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        this.f42328p.g(4);
        arrayList.add(this.f42328p);
        this.f42326n.setData(arrayList);
        this.f42326n.c();
    }

    public final void fi() {
        showLoading();
        Rh().compose(RxJavaHelper.t(zh())).subscribe(EasySubscriber.create(new k(this), new j(this), new l(this)));
    }

    public void initViews() {
        super.initViews();
        this.f42331s = getActivity();
        this.f42326n = (EasyRecyclerView) this.f67460i.b(R$id.rcv);
        this.f42335w = this.f67460i.b(R$id.stick_filter_bar);
        this.f42336x = (FilterBar) this.f67460i.b(R$id.fb_sticky);
        this.f42326n.setLayoutManager(new StableLinearLayoutManager(this.f42331s));
        this.f42326n.addItemDecoration(p.p(this.f42331s));
        this.f42326n.addOnScrollListener(new a());
        this.f42330r = Sh();
        this.f42332t = new FilterViewData();
        String Th = Th();
        if (Th != null) {
            this.f42336x.setFilterTitle(Th);
            this.f42332t.f(Th);
        }
        if (ai()) {
            this.f42336x.n();
            this.f42332t.e(true);
        }
        this.f42333u = Uh();
        this.f42328p = new LoadingViewData(this.f42327o);
        d.d().a(this);
        fi();
    }

    public void showLoading() {
        i6.d.b("showLoading");
        if (this.f42329q == null) {
            i6.d.b("showLoading show");
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f42330r);
            s9.a aVar = this.f42333u;
            if (aVar != null) {
                arrayList.add(aVar);
            }
            this.f42328p.g(1);
            arrayList.add(this.f42328p);
            this.f42326n.setData(arrayList);
        }
    }
}
