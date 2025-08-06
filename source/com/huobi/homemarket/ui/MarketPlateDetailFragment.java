package com.huobi.homemarket.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.MarketPlateDetail;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$dimen;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.homemarket.presenter.MarketDetailPlatePresenter;
import com.huobi.homemarket.ui.MarketSortLayout;
import com.huobi.homemarket.view.LimitGridView;
import com.huobi.homemarket.view.MarketIntroTextView;
import com.huobi.homemarket.view.MarketPlateProgressView;
import com.luck.picture.lib.config.PictureMimeType;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import f6.c;
import i6.m;
import i6.r;
import java.util.HashMap;
import java.util.List;
import ky.j;
import td.i;
import ul.w0;
import ul.x0;
import ul.y0;
import ul.z0;

public class MarketPlateDetailFragment extends BaseFragment<MarketDetailPlatePresenter, MarketDetailPlatePresenter.c> implements MarketDetailPlatePresenter.c, MarketSortLayout.a {
    public String A;
    public String B;
    public b C;

    /* renamed from: l  reason: collision with root package name */
    public TextView f72943l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f72944m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f72945n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f72946o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f72947p;

    /* renamed from: q  reason: collision with root package name */
    public MarketIntroTextView f72948q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f72949r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f72950s;

    /* renamed from: t  reason: collision with root package name */
    public RecyclerView f72951t;

    /* renamed from: u  reason: collision with root package name */
    public MarketSortLayout f72952u;

    /* renamed from: v  reason: collision with root package name */
    public LimitGridView f72953v;

    /* renamed from: w  reason: collision with root package name */
    public MarketPlateProgressView f72954w;

    /* renamed from: x  reason: collision with root package name */
    public View f72955x;

    /* renamed from: y  reason: collision with root package name */
    public SmartRefreshLayout f72956y;

    /* renamed from: z  reason: collision with root package name */
    public SmartRefreshHeader f72957z;

    public class b extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public List<MarketPlateDetail.CurrencyItem> f72958b;

        public b() {
        }

        /* renamed from: a */
        public MarketPlateDetail.CurrencyItem getItem(int i11) {
            List<MarketPlateDetail.CurrencyItem> list = this.f72958b;
            if (list == null) {
                return null;
            }
            return list.get(i11);
        }

        public void b(List<MarketPlateDetail.CurrencyItem> list) {
            this.f72958b = list;
            notifyDataSetChanged();
        }

        public int getCount() {
            List<MarketPlateDetail.CurrencyItem> list = this.f72958b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            FragmentActivity activity = MarketPlateDetailFragment.this.getActivity();
            if (activity == null || activity.isFinishing()) {
                return view;
            }
            View inflate = LayoutInflater.from(activity).inflate(R$layout.item_plate_hot_view, (ViewGroup) null);
            MarketPlateDetail.CurrencyItem a11 = getItem(i11);
            c.a().f((ImageView) inflate.findViewById(R$id.iv_item_basecurrency), MarketPlateDetailFragment.Jh(a11.getCurrency()), MarketPlateDetailFragment.Kh());
            ((TextView) inflate.findViewById(R$id.tv_item_basecurrency)).setText(a11.getCurrency());
            inflate.setTag(a11);
            return inflate;
        }
    }

    public static String Jh(String str) {
        String j11 = BaseModuleConfig.a().j();
        if (j11 == null) {
            j11 = "";
        }
        return j11 + "/-/x/hb/p/api/contents/currency/icon_png/" + str.toLowerCase() + PictureMimeType.PNG;
    }

    public static int Kh() {
        if (NightHelper.e().g()) {
            return R$drawable.balances_currencyicon_night;
        }
        return R$drawable.balances_currencyicon;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nh(j jVar) {
        ((MarketDetailPlatePresenter) yh()).q0();
        ((MarketDetailPlatePresenter) yh()).m0();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oh(View view) {
        this.f72948q.setMaxLines(Integer.MAX_VALUE);
        this.f72949r.setVisibility(8);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(boolean z11) {
        this.f72949r.setVisibility(z11 ? 0 : 8);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qh(AdapterView adapterView, View view, int i11, long j11) {
        if (view.getTag() instanceof MarketPlateDetail.CurrencyItem) {
            MarketPlateDetail.CurrencyItem currencyItem = (MarketPlateDetail.CurrencyItem) view.getTag();
            MarketModuleConfig.a().e(getActivity(), currencyItem.getSymbol(), MarketModuleConfig.a().w(), TradeType.PRO);
            HashMap hashMap = new HashMap();
            hashMap.put("currency_name", currencyItem.getCurrency());
            Bundle arguments = getArguments();
            if (arguments != null) {
                hashMap.put("plate_name", arguments.getString("plateId"));
            }
            BaseModuleConfig.a().w("plate_details_hotlist_click", hashMap);
        }
        SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
    }

    public static MarketPlateDetailFragment Rh(String str) {
        MarketPlateDetailFragment marketPlateDetailFragment = new MarketPlateDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("plateId", str);
        marketPlateDetailFragment.setArguments(bundle);
        return marketPlateDetailFragment;
    }

    public void Ah() {
        super.Ah();
        this.f72956y.d0(new z0(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void C5(com.hbg.lib.network.hbg.core.bean.MarketPlateDetail r12) {
        /*
            r11 = this;
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r11.f72956y
            r1 = 0
            r0.d(r1)
            java.lang.String r0 = ""
            r2 = 8
            if (r12 == 0) goto L_0x0170
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r3 = r12.getPlateInfo()
            if (r3 == 0) goto L_0x0170
            com.huobi.homemarket.view.MarketIntroTextView r3 = r11.f72948q
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r4 = r12.getPlateInfo()
            java.lang.String r4 = r4.getIntro()
            r3.setText(r4)
            com.huobi.homemarket.view.MarketIntroTextView r3 = r11.f72948q
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r4 = r12.getPlateInfo()
            java.lang.String r4 = r4.getIntro()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0031
            r4 = r2
            goto L_0x0032
        L_0x0031:
            r4 = r1
        L_0x0032:
            r3.setVisibility(r4)
            android.widget.TextView r3 = r11.f72943l
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r4 = r12.getPlateInfo()
            java.lang.String r4 = r4.getTotalVol()
            java.lang.String r4 = r11.Ih(r4)
            r3.setText(r4)
            r3 = 0
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r5 = r12.getPlateInfo()     // Catch:{ all -> 0x007e }
            java.lang.String r5 = r5.getPlateUpDown()     // Catch:{ all -> 0x007e }
            double r5 = java.lang.Double.parseDouble(r5)     // Catch:{ all -> 0x007e }
            android.widget.TextView r7 = r11.f72945n     // Catch:{ all -> 0x007f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            r8.<init>()     // Catch:{ all -> 0x007f }
            int r9 = java.lang.Double.compare(r5, r3)     // Catch:{ all -> 0x007f }
            if (r9 <= 0) goto L_0x0063
            java.lang.String r0 = "+"
        L_0x0063:
            r8.append(r0)     // Catch:{ all -> 0x007f }
            r9 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r9 = r9 * r5
            r0 = 2
            java.lang.String r0 = i6.m.i(r9, r0)     // Catch:{ all -> 0x007f }
            r8.append(r0)     // Catch:{ all -> 0x007f }
            java.lang.String r0 = "%"
            r8.append(r0)     // Catch:{ all -> 0x007f }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x007f }
            r7.setText(r0)     // Catch:{ all -> 0x007f }
            goto L_0x008c
        L_0x007e:
            r5 = r3
        L_0x007f:
            android.widget.TextView r0 = r11.f72945n
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r7 = r12.getPlateInfo()
            java.lang.String r7 = r7.getPlateUpDown()
            r0.setText(r7)
        L_0x008c:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a2
            android.widget.TextView r0 = r11.f72945n
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.hbg.lib.core.util.w.h()
            int r3 = r3.getColor(r4)
            r0.setTextColor(r3)
            goto L_0x00c9
        L_0x00a2:
            int r0 = java.lang.Double.compare(r5, r3)
            if (r0 != 0) goto L_0x00b8
            android.widget.TextView r0 = r11.f72945n
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.hbg.module.market.R$color.baseColorSecondaryTextNew
            int r3 = r3.getColor(r4)
            r0.setTextColor(r3)
            goto L_0x00c9
        L_0x00b8:
            android.widget.TextView r0 = r11.f72945n
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.hbg.lib.core.util.w.d()
            int r3 = r3.getColor(r4)
            r0.setTextColor(r3)
        L_0x00c9:
            android.widget.TextView r0 = r11.f72946o
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r3 = r12.getPlateInfo()
            int r3 = r3.getUpCount()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.setText(r3)
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r0 = r12.getPlateInfo()
            int r0 = r0.getUpCount()
            if (r0 > 0) goto L_0x00f4
            android.widget.TextView r0 = r11.f72946o
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.hbg.module.market.R$color.baseColorSecondaryTextNew
            int r3 = r3.getColor(r4)
            r0.setTextColor(r3)
            goto L_0x0105
        L_0x00f4:
            android.widget.TextView r0 = r11.f72946o
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.hbg.lib.core.util.w.h()
            int r3 = r3.getColor(r4)
            r0.setTextColor(r3)
        L_0x0105:
            android.widget.TextView r0 = r11.f72947p
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r3 = r12.getPlateInfo()
            int r3 = r3.getDownCount()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.setText(r3)
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r0 = r12.getPlateInfo()
            int r0 = r0.getDownCount()
            if (r0 > 0) goto L_0x0130
            android.widget.TextView r0 = r11.f72947p
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.hbg.module.market.R$color.baseColorSecondaryTextNew
            int r3 = r3.getColor(r4)
            r0.setTextColor(r3)
            goto L_0x0141
        L_0x0130:
            android.widget.TextView r0 = r11.f72947p
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.hbg.lib.core.util.w.d()
            int r3 = r3.getColor(r4)
            r0.setTextColor(r3)
        L_0x0141:
            com.huobi.homemarket.view.MarketPlateProgressView r0 = r11.f72954w
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r3 = r12.getPlateInfo()
            int r3 = r3.getUpCount()
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r4 = r12.getPlateInfo()
            int r4 = r4.getDownCount()
            r0.b(r3, r4)
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            boolean r0 = r0 instanceof com.hbg.module.market.widget.ui.MarketPlateDetailActivity
            if (r0 == 0) goto L_0x017f
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            com.hbg.module.market.widget.ui.MarketPlateDetailActivity r0 = (com.hbg.module.market.widget.ui.MarketPlateDetailActivity) r0
            com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$PlateInfo r3 = r12.getPlateInfo()
            java.lang.String r3 = r3.getPlateName()
            r0.Og(r3)
            goto L_0x017f
        L_0x0170:
            com.huobi.homemarket.view.MarketPlateProgressView r3 = r11.f72954w
            r3.b(r1, r1)
            com.huobi.homemarket.view.MarketIntroTextView r3 = r11.f72948q
            r3.setText(r0)
            com.huobi.homemarket.view.MarketIntroTextView r0 = r11.f72948q
            r0.setVisibility(r2)
        L_0x017f:
            if (r12 == 0) goto L_0x01a3
            java.util.List r0 = r12.getCurrencyList()
            if (r0 == 0) goto L_0x01a3
            java.util.List r0 = r12.getCurrencyList()
            int r0 = r0.size()
            android.widget.TextView r3 = r11.f72944m
            java.lang.String r4 = java.lang.String.valueOf(r0)
            r3.setText(r4)
            android.view.View r3 = r11.f72955x
            if (r0 <= 0) goto L_0x019e
            r0 = r2
            goto L_0x019f
        L_0x019e:
            r0 = r1
        L_0x019f:
            r3.setVisibility(r0)
            goto L_0x01a8
        L_0x01a3:
            android.view.View r0 = r11.f72955x
            r0.setVisibility(r1)
        L_0x01a8:
            com.huobi.homemarket.ui.MarketPlateDetailFragment$b r0 = r11.C
            if (r12 != 0) goto L_0x01ae
            r3 = 0
            goto L_0x01b2
        L_0x01ae:
            java.util.List r3 = r12.getHotCurrency()
        L_0x01b2:
            r0.b(r3)
            if (r12 == 0) goto L_0x01d3
            java.util.List r0 = r12.getHotCurrency()
            if (r0 == 0) goto L_0x01d3
            java.util.List r12 = r12.getHotCurrency()
            int r12 = r12.size()
            if (r12 != 0) goto L_0x01c8
            goto L_0x01d3
        L_0x01c8:
            android.widget.TextView r12 = r11.f72950s
            r12.setVisibility(r1)
            com.huobi.homemarket.view.LimitGridView r12 = r11.f72953v
            r12.setVisibility(r1)
            goto L_0x01dd
        L_0x01d3:
            android.widget.TextView r12 = r11.f72950s
            r12.setVisibility(r2)
            com.huobi.homemarket.view.LimitGridView r12 = r11.f72953v
            r12.setVisibility(r2)
        L_0x01dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.homemarket.ui.MarketPlateDetailFragment.C5(com.hbg.lib.network.hbg.core.bean.MarketPlateDetail):void");
    }

    public void Gh(HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R$layout.head_market_platedetail, (ViewGroup) null);
        Mh(new r(inflate));
        headerAndFooterRecyclerViewAdapter.addHeaderView(inflate);
    }

    /* renamed from: Hh */
    public MarketDetailPlatePresenter xh() {
        return new MarketDetailPlatePresenter();
    }

    public final String Ih(String str) {
        if (TextUtils.isEmpty(str)) {
            return "--";
        }
        String v11 = i.a().b().v(str);
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return LegalCurrencyConfigUtil.w() + m.g(v11);
        }
        return LegalCurrencyConfigUtil.w() + m.X(v11);
    }

    /* renamed from: Lh */
    public MarketDetailPlatePresenter.c zh() {
        return this;
    }

    public final void Mh(r rVar) {
        this.f72943l = (TextView) rVar.b(R$id.id_deal_value);
        this.f72944m = (TextView) rVar.b(R$id.id_amount_value);
        this.f72945n = (TextView) rVar.b(R$id.id_tendency_value);
        this.f72946o = (TextView) rVar.b(R$id.id_up_value);
        this.f72947p = (TextView) rVar.b(R$id.id_down_value);
        this.f72948q = (MarketIntroTextView) rVar.b(R$id.id_plate_info_intro);
        this.f72949r = (TextView) rVar.b(R$id.id_check_detail);
        this.f72953v = (LimitGridView) rVar.b(R$id.id_hot_grid);
        this.f72954w = (MarketPlateProgressView) rVar.b(R$id.id_progress_view);
        this.f72955x = rVar.b(R$id.empty_view);
        this.f72950s = (TextView) rVar.b(R$id.id_hot_currency);
        MarketSortLayout marketSortLayout = (MarketSortLayout) rVar.b(R$id.market_sort);
        this.f72952u = marketSortLayout;
        marketSortLayout.setSrotTypeListener(this);
        this.f72952u.setPriceMargin(PixelUtils.a(119.0f));
        this.f72952u.setHeiLowMargin(PixelUtils.a(15.0f));
        this.B = ll.j.n().m();
        this.A = ll.j.n().l();
        this.f72949r.setOnClickListener(new w0(this));
        this.f72948q.setDisplayListener(new y0(this));
        this.f72953v.setGridViewMode(2);
        LimitGridView limitGridView = this.f72953v;
        Resources resources = getResources();
        int i11 = R$dimen.dimen_8;
        limitGridView.setMinSpacingX(resources.getDimensionPixelOffset(i11));
        this.f72953v.setMinSpacingY(getResources().getDimensionPixelOffset(i11));
        b bVar = new b();
        this.C = bVar;
        this.f72953v.setAdapter(bVar);
        this.f72953v.setItemClickListener(new x0(this));
    }

    public void initViews() {
        super.initViews();
        RecyclerView recyclerView = (RecyclerView) this.f67460i.b(R$id.market_plate_rv);
        this.f72951t = recyclerView;
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f72951t.setLayoutManager(new StableLinearLayoutManager(getActivity()));
        this.f72956y = (SmartRefreshLayout) this.f67460i.b(com.hbg.module.kline.R$id.market_info_refresh);
        this.f72957z = new SmartRefreshHeader(getActivity());
        this.f72956y.i(true);
        this.f72956y.g(false);
        this.f72956y.V(false);
        this.f72956y.j0(this.f72957z);
    }

    public void onPause() {
        super.onPause();
        ll.j.n().x(this.B);
        ll.j.n().w(this.A);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_platedetail, viewGroup, false);
    }

    public void ug(HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter) {
        Gh(headerAndFooterRecyclerViewAdapter);
        this.f72951t.setAdapter(headerAndFooterRecyclerViewAdapter);
    }

    public void w8(String str, String str2) {
        ((MarketDetailPlatePresenter) yh()).p0(str, str2);
    }
}
