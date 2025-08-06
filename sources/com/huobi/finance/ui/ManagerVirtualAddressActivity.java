package com.huobi.finance.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.controller.VirtualAddressProvider;
import com.huobi.finance.presenter.ManagerVirtualAddressPresenter;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.huobi.view.rv.WrapVerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import pro.huobi.R;
import v9.a;

public class ManagerVirtualAddressActivity extends BaseActivity<ManagerVirtualAddressPresenter, ManagerVirtualAddressPresenter.b> implements ManagerVirtualAddressPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayoutManager f46654b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f46655c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46656d;

    /* renamed from: e  reason: collision with root package name */
    public LoadingLayout f46657e;

    /* renamed from: f  reason: collision with root package name */
    public CollapsingToolbarLayout f46658f;

    /* renamed from: g  reason: collision with root package name */
    public Toolbar f46659g;

    /* renamed from: h  reason: collision with root package name */
    public BottomMenuFragment f46660h = new BottomMenuFragment();

    /* renamed from: i  reason: collision with root package name */
    public CoordinatorLayout f46661i;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gg(View view) {
        ((ManagerVirtualAddressPresenter) getPresenter()).W(VirtualAddressProvider.f().e(((ManagerVirtualAddressPresenter) getPresenter()).Z(), ((ManagerVirtualAddressPresenter) getPresenter()).X(), false));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        List<VirtualAddressInfo> d11 = VirtualAddressProvider.f().d(((ManagerVirtualAddressPresenter) getPresenter()).Z());
        int i11 = 1;
        if (d11 != null) {
            i11 = 1 + d11.size();
        }
        startActivityForResult(new Intent(this, AddVirtualAddressActivity.class).putExtra("coin_type", ((ManagerVirtualAddressPresenter) getPresenter()).Z()).putExtra("chain", ((ManagerVirtualAddressPresenter) getPresenter()).X()).putExtra("number", i11), 203);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Id(boolean z11) {
        if (z11) {
            this.f46656d.setVisibility(0);
        } else {
            this.f46656d.setVisibility(8);
        }
    }

    /* renamed from: Zf */
    public ManagerVirtualAddressPresenter createPresenter() {
        return new ManagerVirtualAddressPresenter();
    }

    public void addEvent() {
        this.f46656d.setOnClickListener(new q6(this));
        this.f46657e.setOnRetryClickListener(new p6(this));
    }

    public void b(a aVar) {
        this.f46655c.setAdapter(aVar);
    }

    public LoadingLayout f6() {
        return this.f46657e;
    }

    /* renamed from: fg */
    public ManagerVirtualAddressPresenter.b getUI() {
        return this;
    }

    public int getContentView() {
        return R.layout.activity_manager_virtual_address;
    }

    public void initView() {
        this.f46655c = (RecyclerView) this.viewFinder.b(R.id.manager_address_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f46654b = linearLayoutManager;
        this.f46655c.setLayoutManager(linearLayoutManager);
        this.f46655c.addItemDecoration(new WrapVerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_large_divider_color), PixelUtils.a(10.0f)));
        this.f46656d = (TextView) this.viewFinder.b(R.id.add_address_tv);
        this.f46657e = (LoadingLayout) this.viewFinder.b(R.id.manager_address_loading_layout);
        this.f46658f = (CollapsingToolbarLayout) this.viewFinder.b(R.id.address_manager_collapsing_toolbar);
        this.f46659g = (Toolbar) this.viewFinder.b(R.id.address_mamager_toolbar);
        this.f46661i = (CoordinatorLayout) this.viewFinder.b(R.id.address_cl_root);
        setToolBar(this.f46659g, "", true);
    }

    public void ud(boolean z11) {
        if (z11) {
            getUI().f6().i();
        } else {
            getUI().f6().g();
        }
    }

    public void wc(String str) {
        this.f46658f.setTitle(String.format(getString(R.string.address_manager_title), new Object[]{str}));
    }
}
