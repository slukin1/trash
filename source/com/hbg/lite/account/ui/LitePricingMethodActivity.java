package com.hbg.lite.account.ui;

import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.otc.core.bean.OtcConfigItem;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.main.ui.LiteMainActivity;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.List;
import ta.a;
import va.b;

public class LitePricingMethodActivity extends EmptyMVPActivity implements a.C0885a {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f77062b;

    /* renamed from: c  reason: collision with root package name */
    public CollapsingToolbarLayout f77063c;

    /* renamed from: d  reason: collision with root package name */
    public List<s9.a> f77064d = new ArrayList();

    /* access modifiers changed from: private */
    public /* synthetic */ void Pg() {
        EasyRecyclerView<s9.a> easyRecyclerView = this.f77062b;
        if (easyRecyclerView != null) {
            easyRecyclerView.c();
        }
    }

    public final void Og() {
        setToolBar((Toolbar) this.viewFinder.b(R$id.toolbar), Yf(), true);
    }

    public void Qg() {
        EasyRecyclerView<s9.a> easyRecyclerView;
        if (!isFinishing() && (easyRecyclerView = this.f77062b) != null) {
            easyRecyclerView.setData(fg());
        }
    }

    public final String Yf() {
        return getString(R$string.setting_pricing_method);
    }

    public final void Zf() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.viewFinder.b(R$id.collapsing_toolbar);
        this.f77063c = collapsingToolbarLayout;
        collapsingToolbarLayout.setShowDivider(false);
    }

    public String a(int i11) {
        String k11 = b.k(i11);
        return "(" + k11 + ")";
    }

    public final List<s9.a> fg() {
        if (b.o().r() != null) {
            List<OtcConfigItem.CurrencyBean> currencyBeans = b.o().r().getCurrencyBeans();
            if (!CollectionsUtils.b(currencyBeans)) {
                this.f77064d.clear();
                for (OtcConfigItem.CurrencyBean next : currencyBeans) {
                }
            }
        }
        return this.f77064d;
    }

    public int getContentView() {
        return R$layout.activity_lite_pricing_list;
    }

    public final void gg() {
        EasyRecyclerView<s9.a> easyRecyclerView = (EasyRecyclerView) this.viewFinder.b(R$id.id_common_list_recyclerView);
        this.f77062b = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new StableLinearLayoutManager(this));
    }

    public void initView() {
        removeWinBg();
        Og();
        Zf();
        gg();
        Qg();
    }

    public void oh() {
        runOnUiThread(new ua.b(this));
    }

    public void onItemClick(int i11) {
        sa.a.j(String.valueOf(i11));
        oh();
        oa.a.g().i(LiteMainActivity.class);
        this.f77062b.postDelayed(new ua.a(this), 250);
    }

    public boolean s(int i11) {
        return i11 == Integer.parseInt(sa.a.c());
    }
}
