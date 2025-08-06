package com.hbg.module.kline.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.network.hbg.core.bean.EtpInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.bean.EtpChangeConditionListItem;
import com.hbg.module.kline.presenter.MarketInfoEtpChangePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import ky.j;

public class MarketInfoEtpChangeFragment extends BaseFragment<MarketInfoEtpChangePresenter, MarketInfoEtpChangePresenter.e> implements MarketInfoEtpChangePresenter.e, ny.a, f0 {
    public final Object A = new Object();
    public StableLinearLayoutManager B;
    public boolean C;
    public EtpChangeConditionListItem.a D = new b();

    /* renamed from: l  reason: collision with root package name */
    public TextView f23983l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f23984m;

    /* renamed from: n  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f23985n;

    /* renamed from: o  reason: collision with root package name */
    public final List<s9.a> f23986o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public List<ud.a> f23987p;

    /* renamed from: q  reason: collision with root package name */
    public List<ud.b> f23988q;

    /* renamed from: r  reason: collision with root package name */
    public EtpInfo f23989r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f23990s;

    /* renamed from: t  reason: collision with root package name */
    public SmartRefreshLayout f23991t;

    /* renamed from: u  reason: collision with root package name */
    public SmartRefreshFooter f23992u;

    /* renamed from: v  reason: collision with root package name */
    public LoadingLayout f23993v;

    /* renamed from: w  reason: collision with root package name */
    public EtpRebalInfo f23994w;

    /* renamed from: x  reason: collision with root package name */
    public String f23995x;

    /* renamed from: y  reason: collision with root package name */
    public final EtpChangeConditionListItem f23996y = new EtpChangeConditionListItem();

    /* renamed from: z  reason: collision with root package name */
    public SimpleDateFormat f23997z;

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            MarketInfoEtpChangeFragment.this.Fh();
        }
    }

    public class b implements EtpChangeConditionListItem.a {
        public b() {
        }

        public String a() {
            String i11 = StringUtils.i(((MarketInfoEtpChangePresenter) MarketInfoEtpChangeFragment.this.yh()).f0());
            if (TextUtils.isEmpty(MarketInfoEtpChangeFragment.this.f23995x)) {
                return "--";
            }
            return MarketInfoEtpChangeFragment.this.f23995x + " " + i11;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        this.f23991t.g(false);
        this.f23984m.setTextColor(Hh(R$attr.kline_primary_text_color));
        this.f23983l.setTextColor(Hh(R$attr.kline_index_setting_text_color));
        this.f23990s = false;
        Jh();
        ((MarketInfoEtpChangePresenter) yh()).j0();
        ((MarketInfoEtpChangePresenter) yh()).m0();
        Kh(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        this.f23991t.g(true);
        this.f23983l.setTextColor(Hh(R$attr.kline_primary_text_color));
        this.f23984m.setTextColor(Hh(R$attr.kline_index_setting_text_color));
        this.f23990s = true;
        Jh();
        if (((MarketInfoEtpChangePresenter) yh()).g0()) {
            ((MarketInfoEtpChangePresenter) yh()).k0();
        }
        Kh(this.C);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f23983l.setOnClickListener(new u1(this));
        this.f23984m.setOnClickListener(new t1(this));
        this.f23991t.i(false);
        this.f23991t.g(false);
        this.f23991t.setOverScrollMode(2);
        SmartRefreshFooter smartRefreshFooter = new SmartRefreshFooter(getActivity());
        this.f23992u = smartRefreshFooter;
        smartRefreshFooter.setFooterDividerVisible(false);
        this.f23992u.setFooterBackgroundColor(Hh(R$attr.kline_content_background_color));
        this.f23991t.h0(this.f23992u);
        this.f23991t.b0(this);
        this.f23985n.setOverScrollMode(2);
        StableLinearLayoutManager stableLinearLayoutManager = new StableLinearLayoutManager(getActivity());
        this.B = stableLinearLayoutManager;
        this.f23985n.setLayoutManager(stableLinearLayoutManager);
        this.f23985n.setCallback(new v1(this));
        this.f23985n.addOnScrollListener(new a());
    }

    public void B7(String str) {
        EasyRecyclerView<s9.a> easyRecyclerView;
        this.f23995x = str;
        if (!this.f23990s && (easyRecyclerView = this.f23985n) != null) {
            easyRecyclerView.c();
        }
    }

    public void Fh() {
        int findFirstVisibleItemPosition = this.B.findFirstVisibleItemPosition();
        if (getActivity() != null) {
            boolean z11 = true;
            this.C = findFirstVisibleItemPosition > 4;
            if (!this.f23990s || findFirstVisibleItemPosition <= 4) {
                z11 = false;
            }
            Kh(z11);
        }
    }

    /* renamed from: Gh */
    public MarketInfoEtpChangePresenter xh() {
        return new MarketInfoEtpChangePresenter();
    }

    public int Hh(int i11) {
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    /* renamed from: Ih */
    public MarketInfoEtpChangePresenter.e zh() {
        return this;
    }

    public final void Jh() {
        this.f23986o.clear();
        if (this.f23990s) {
            List<ud.b> list = this.f23988q;
            if (list != null) {
                this.f23986o.addAll(list);
            }
        } else {
            String i11 = StringUtils.i(((MarketInfoEtpChangePresenter) yh()).f0());
            EtpRebalInfo etpRebalInfo = this.f23994w;
            if (etpRebalInfo != null) {
                String str = "--";
                if (etpRebalInfo.getOptionState() != EtpRebalInfo.OPTION_STATE_NOT_NORMAL) {
                    str = m.m(this.f23994w.getRebalNav(), 4) + " " + i11;
                }
                this.f23996y.g(str);
                synchronized (this.A) {
                    if (this.f23997z == null) {
                        this.f23997z = new SimpleDateFormat("MM/dd HH:mm", Locale.US);
                    }
                }
                this.f23996y.h(this.f23997z.format(new Date(this.f23994w.getRebalTime().longValue())));
            }
            this.f23996y.f(this.D);
            this.f23986o.add(this.f23996y);
            List<ud.a> list2 = this.f23987p;
            if (list2 != null) {
                this.f23986o.addAll(list2);
            }
        }
        this.f23985n.setData(this.f23986o);
        if (!this.f23990s) {
            return;
        }
        if (this.f23985n.getItemCount() > 0) {
            this.f23993v.g();
        } else {
            this.f23993v.i();
        }
    }

    public final void Kh(boolean z11) {
        getActivity();
    }

    public void M3(List<ud.b> list) {
        this.f23988q = list;
        this.f23991t.w();
        Jh();
    }

    public void N4(EtpInfo etpInfo) {
        this.f23989r = etpInfo;
        this.f23991t.w();
        Jh();
    }

    public void P8(j jVar) {
        ((MarketInfoEtpChangePresenter) yh()).k0();
        this.f23991t.b(8000);
    }

    public void b0(EtpRebalInfo etpRebalInfo) {
        this.f23994w = etpRebalInfo;
        Jh();
    }

    public void d0(List<ud.a> list) {
        this.f23987p = list;
        this.f23991t.w();
        Jh();
    }

    public void i8() {
        this.f23991t.e();
    }

    public void initViews() {
        super.initViews();
        this.f23991t = (SmartRefreshLayout) this.f67460i.b(R$id.smart_refresh_layout_etp_change);
        this.f23983l = (TextView) this.f67460i.b(R$id.market_info_etp_change_tab_info);
        this.f23984m = (TextView) this.f67460i.b(R$id.market_info_etp_change_tab_risk);
        this.f23985n = (EasyRecyclerView) this.f67460i.b(R$id.market_info_etp_change_question_recyclerView);
        this.f23993v = (LoadingLayout) this.f67460i.b(R$id.market_info_etp_change_question_loadingLayout);
    }

    public void m0() {
        this.f23993v.k();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_info_etp_change, viewGroup, false);
    }

    public void q7() {
        this.f23991t.w();
    }

    public void showLoading() {
        this.f23993v.p();
    }

    public void uh(boolean z11) {
        super.uh(z11);
        Kh(z11 && this.f23990s && this.C);
    }
}
