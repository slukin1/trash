package com.huobi.order.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.n;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.order.persenter.OrderListFragmentPresenter;
import com.huobi.page.SmartRefreshPageSplitter;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import ky.f;
import ky.g;
import ky.j;
import pro.huobi.R;

public class OrderListFragment extends BaseFragment<OrderListFragmentPresenter, OrderListFragmentPresenter.a> implements OrderListFragmentPresenter.a {

    /* renamed from: l  reason: collision with root package name */
    public RecyclerView f78155l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingLayout f78156m;

    /* renamed from: n  reason: collision with root package name */
    public SmartRefreshLayout f78157n;

    /* renamed from: o  reason: collision with root package name */
    public int f78158o;

    /* renamed from: p  reason: collision with root package name */
    public d f78159p;

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
            i6.d.b("OrderListFragment-->onScrollStateChanged--> mType = " + OrderListFragment.this.f78158o + " newState = " + i11);
            if (OrderListFragment.this.f78159p != null) {
                OrderListFragment.this.f78159p.N3(OrderListFragment.this.f78158o, recyclerView, i11);
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            i6.d.b("OrderListFragment-->onScrolled--> mType = " + OrderListFragment.this.f78158o + " dx = " + i11 + " dy = " + i12);
            if (OrderListFragment.this.f78159p != null) {
                OrderListFragment.this.f78159p.e9(OrderListFragment.this.f78158o, recyclerView, i11, i12);
            }
        }
    }

    public class b implements ny.b {
        public b() {
        }

        public void A7(g gVar, float f11, int i11, int i12, int i13) {
            i6.d.b("OrderListFragment-->onHeaderPulling--> mType = " + OrderListFragment.this.f78158o + " v = " + f11 + " i = " + i11 + " i1 = " + i12 + " i2 = " + i13);
            if (OrderListFragment.this.f78159p != null) {
                OrderListFragment.this.f78159p.l0(OrderListFragment.this.f78158o, f11, i11, i12, i13);
            }
        }

        public void Cf(f fVar, float f11, int i11, int i12, int i13) {
            i6.d.b("OrderListFragment-->onFooterPulling--> mType = " + OrderListFragment.this.f78158o + " v = " + f11 + " i = " + i11 + " i1 = " + i12 + " i2 = " + i13);
            if (OrderListFragment.this.f78159p != null) {
                OrderListFragment.this.f78159p.pc(OrderListFragment.this.f78158o, f11, i11, i12, i13);
            }
        }

        public void Dg(f fVar, boolean z11) {
            i6.d.b("OrderListFragment-->onFooterFinish--> mType = " + OrderListFragment.this.f78158o + " b = " + z11);
        }

        public void Oa(g gVar, int i11, int i12) {
        }

        public void P8(j jVar) {
        }

        public void R3(f fVar, int i11, int i12) {
            i6.d.b("OrderListFragment-->onFooterStartAnimator--> mType = " + OrderListFragment.this.f78158o + " i = " + i11 + " i1 = " + i12);
        }

        public void T9(g gVar, int i11, int i12) {
            i6.d.b("OrderListFragment-->onHeaderReleased--> mType = " + OrderListFragment.this.f78158o + " i = " + i11 + " i1 = " + i12);
        }

        public void U5(g gVar, float f11, int i11, int i12, int i13) {
            i6.d.b("OrderListFragment-->onHeaderReleasing--> mType = " + OrderListFragment.this.f78158o + " v = " + f11 + " i = " + i11 + " i1 = " + i12 + " i2 = " + i13);
        }

        public void ba(g gVar, boolean z11) {
            i6.d.b("OrderListFragment-->onHeaderFinish--> mType = " + OrderListFragment.this.f78158o + " b = " + z11);
        }

        public void bf(j jVar) {
        }

        public void de(f fVar, float f11, int i11, int i12, int i13) {
            i6.d.b("OrderListFragment-->onFooterReleasing--> mType = " + OrderListFragment.this.f78158o + " v = " + f11 + " i = " + i11 + " i1 = " + i12 + " i2 = " + i13);
        }

        public void he(f fVar, int i11, int i12) {
            i6.d.b("OrderListFragment-->onFooterReleased--> mType = " + OrderListFragment.this.f78158o + " i = " + i11 + " i1 = " + i12);
        }

        public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
            i6.d.b("OrderListFragment-->onFooterReleasing--> mType = " + OrderListFragment.this.f78158o + " refreshState = " + refreshState + " refreshState1 = " + refreshState2);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            RecyclerView.ViewHolder findViewHolderForPosition = OrderListFragment.this.f78155l.findViewHolderForPosition(0);
            if (findViewHolderForPosition != null) {
                n.o().J(findViewHolderForPosition.itemView.findViewById(R.id.tv_order_type));
            }
        }
    }

    public interface d {
        int N2();

        void N3(int i11, RecyclerView recyclerView, int i12);

        void e9(int i11, RecyclerView recyclerView, int i12, int i13);

        void l0(int i11, float f11, int i12, int i13, int i14);

        void pc(int i11, float f11, int i12, int i13, int i14);

        SmartRefreshPageSplitter.b sb();

        void sc(int i11);

        SmartRefreshPageSplitter.c w2(int i11);
    }

    /* renamed from: Fh */
    public OrderListFragmentPresenter xh() {
        return new OrderListFragmentPresenter();
    }

    /* renamed from: Gh */
    public OrderListFragmentPresenter.a zh() {
        return this;
    }

    public void Hh() {
        OrderListFragmentPresenter orderListFragmentPresenter = (OrderListFragmentPresenter) yh();
        if (orderListFragmentPresenter != null) {
            orderListFragmentPresenter.d0();
        }
    }

    public void Ih(d dVar) {
        this.f78159p = dVar;
    }

    public void Jh(int i11) {
        this.f78158o = i11;
    }

    public void Kh() {
        int b02;
        int i11 = this.f78158o;
        if ((i11 == 0 || i11 == 1) && (b02 = ((OrderListFragmentPresenter) yh()).b0()) > 0 && b02 <= N2()) {
            this.f78155l.post(new c());
        }
    }

    public int N2() {
        d dVar = this.f78159p;
        if (dVar != null) {
            return dVar.N2();
        }
        return 0;
    }

    public void T1() {
        d dVar = this.f78159p;
        if (dVar != null) {
            dVar.sc(this.f78158o);
        }
    }

    public RecyclerView Y0() {
        return this.f78155l;
    }

    public SmartRefreshPageSplitter.c Y4() {
        d dVar = this.f78159p;
        if (dVar != null) {
            return dVar.w2(this.f78158o);
        }
        return null;
    }

    public LoadingLayout f6() {
        return this.f78156m;
    }

    public SmartRefreshPageSplitter.b hf() {
        d dVar = this.f78159p;
        if (dVar != null) {
            return dVar.sb();
        }
        return null;
    }

    public void initViews() {
        super.initViews();
        this.f78155l = (RecyclerView) this.f67460i.b(R.id.id_trade_order_recyclerView);
        this.f78156m = (LoadingLayout) this.f67460i.b(R.id.id_trade_order_loading_layout);
        this.f78157n = (SmartRefreshLayout) this.f67460i.b(R.id.id_trade_order_loading_ptr);
        this.f78155l.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.drawable.vertical_divider_bg), PixelUtils.a(0.5f), true, false));
        this.f78155l.setLayoutManager(new StableLinearLayoutManager(getActivity()));
        this.f78155l.addOnScrollListener(new a());
        this.f78157n.c0(new b());
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.order_list_fragment_layout, viewGroup, false);
    }

    public SmartRefreshLayout t2() {
        return this.f78157n;
    }
}
