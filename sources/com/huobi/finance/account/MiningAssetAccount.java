package com.huobi.finance.account;

import al.p;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.widgets.tablayout.TabItemLayoutData;
import com.hbg.lib.widgets.tablayout.TabItemLayoutIndicator;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.MiningDataTotal;
import com.huobi.finance.widget.MiningListLayout;
import java.util.ArrayList;
import java.util.HashMap;
import sk.e;
import vk.n;

public class MiningAssetAccount extends BaseAssetAccount<MiningDataTotal> {

    /* renamed from: b  reason: collision with root package name */
    public View f45193b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f45194c;

    /* renamed from: d  reason: collision with root package name */
    public MiningListLayout f45195d;

    /* renamed from: e  reason: collision with root package name */
    public MiningListLayout f45196e;

    /* renamed from: f  reason: collision with root package name */
    public MiningDataTotal f45197f;

    /* renamed from: g  reason: collision with root package name */
    public final p.a f45198g = new a();

    public class a implements p.a {
        public a() {
        }

        public String a(String str) {
            return LegalCurrencyConfigUtil.J(MiningAssetAccount.this.f45193b.getContext(), str);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TabItemLayoutIndicator f45200b;

        public b(TabItemLayoutIndicator tabItemLayoutIndicator) {
            this.f45200b = tabItemLayoutIndicator;
        }

        public final void a(int i11) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", i11 == 0 ? "灵活挖矿" : "定期挖矿");
            BaseModuleConfig.a().b("5209", hashMap);
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            a(i11);
            this.f45200b.u(i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(int i11) {
        this.f45194c.setCurrentItem(i11);
    }

    public void a() {
        b(this.f45197f);
    }

    public int c() {
        return R$string.n_mining_title;
    }

    public View d(Context context, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f45193b = LayoutInflater.from(context).inflate(R$layout.layout_asset_mining, viewGroup, false);
        k(context, onClickListener);
        j(context, this.f45193b);
        return this.f45193b;
    }

    /* renamed from: i */
    public void b(MiningDataTotal miningDataTotal) {
        if (miningDataTotal != null) {
            MiningDataTotal miningDataTotal2 = this.f45197f;
            if (miningDataTotal2 == null || !miningDataTotal2.isAvailable() || miningDataTotal.isAvailable()) {
                this.f45197f = miningDataTotal;
                this.f45195d.setData(vk.b.a(miningDataTotal.getActiveList()));
                this.f45196e.setData(n.a(miningDataTotal.getFixedList()));
            }
        }
    }

    public final void j(Context context, View view) {
        TabItemLayoutIndicator tabItemLayoutIndicator = (TabItemLayoutIndicator) view.findViewById(R$id.tab_item_layout);
        ArrayList arrayList = new ArrayList();
        TabItemLayoutData tabItemLayoutData = new TabItemLayoutData();
        tabItemLayoutData.setMiddleTabText(context.getString(R$string.n_mining_active));
        tabItemLayoutData.setCheck(true);
        arrayList.add(tabItemLayoutData);
        TabItemLayoutData tabItemLayoutData2 = new TabItemLayoutData();
        tabItemLayoutData2.setMiddleTabText(context.getString(R$string.n_mining_fixed));
        arrayList.add(tabItemLayoutData2);
        tabItemLayoutIndicator.setTabItemLayoutData(arrayList);
        tabItemLayoutIndicator.setItemClickCallBack(new e(this));
        this.f45194c.addOnPageChangeListener(new b(tabItemLayoutIndicator));
    }

    public final void k(Context context, View.OnClickListener onClickListener) {
        this.f45194c = (ViewPager) this.f45193b.findViewById(R$id.vp_mining);
        MiningListLayout miningListLayout = new MiningListLayout(context);
        this.f45195d = miningListLayout;
        miningListLayout.setRetryListener(onClickListener);
        MiningListLayout miningListLayout2 = new MiningListLayout(context);
        this.f45196e = miningListLayout2;
        miningListLayout2.setRetryListener(onClickListener);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f45195d);
        arrayList.add(this.f45196e);
        this.f45194c.setAdapter(new yg.e(arrayList));
    }
}
