package com.huobi.homemarket.view;

import a7.e;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.huobi.homemarket.bean.MarketOptionSettingBean;
import com.huobi.homemarket.presenter.HomeMarketNewPresenter;
import com.huobi.homemarket.view.MarketOptionSettingDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rl.m;
import vl.b;
import vl.k;
import vl.l;
import vl.n;

public class MarketOptionTopView extends FrameLayout implements MarketOptionSettingDialogFragment.a {

    /* renamed from: b  reason: collision with root package name */
    public FragmentActivity f73072b;

    /* renamed from: c  reason: collision with root package name */
    public MarketOptionSettingDialogFragment f73073c;

    /* renamed from: d  reason: collision with root package name */
    public HomeMarketNewPresenter f73074d;

    /* renamed from: e  reason: collision with root package name */
    public b f73075e;

    /* renamed from: f  reason: collision with root package name */
    public View f73076f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f73077g;

    /* renamed from: h  reason: collision with root package name */
    public View f73078h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f73079i;

    /* renamed from: j  reason: collision with root package name */
    public View f73080j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f73081k;

    /* renamed from: l  reason: collision with root package name */
    public View f73082l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f73083m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f73084n;

    /* renamed from: o  reason: collision with root package name */
    public List<MarketOptionSettingBean> f73085o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public List<MarketOptionSettingBean> f73086p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public List<MarketOptionSettingBean> f73087q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public List<MarketOptionSettingBean> f73088r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public List<String> f73089s = new ArrayList();

    public MarketOptionTopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(View view) {
        r(this.f73077g);
        v(1, this.f73085o);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(View view) {
        r(this.f73079i);
        v(2, this.f73086p);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(View view) {
        r(this.f73081k);
        v(3, this.f73087q);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void p(View view) {
        r((TextView) null);
        v(4, this.f73088r);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void a(int i11) {
        if (i11 == 1) {
            u(this.f73077g, true);
        } else if (i11 == 2) {
            u(this.f73079i, true);
        } else if (i11 == 3) {
            u(this.f73081k, true);
        }
    }

    public void b(int i11) {
        if (i11 == 1) {
            if (!TextUtils.equals(getSelectedSymbol(), this.f73077g.getText().toString())) {
                t();
            }
            s();
        } else if (i11 == 2) {
            w();
            s();
        } else if (i11 == 3) {
            x();
        } else if (i11 == 4) {
            q();
        }
        this.f73084n = null;
    }

    public final void g() {
        this.f73087q.add(new MarketOptionSettingBean(3, getContext().getString(R$string.n_option_market_list_setting_all_type), 0));
        this.f73087q.add(new MarketOptionSettingBean(3, getContext().getString(R$string.n_option_right_c), 1));
        this.f73087q.add(new MarketOptionSettingBean(3, getContext().getString(R$string.n_option_right_p), 2));
        this.f73087q.get(0).setSelected(true);
        this.f73088r = m.b(getContext());
    }

    public List<MarketOptionSettingBean> getFieldSettingList() {
        return this.f73088r;
    }

    public MarketOptionSettingBean getSelectedDelivery() {
        for (MarketOptionSettingBean next : this.f73086p) {
            if (next.isSelected()) {
                return next;
            }
        }
        return null;
    }

    public MarketOptionSettingBean getSelectedDirection() {
        MarketOptionSettingBean marketOptionSettingBean;
        Iterator<MarketOptionSettingBean> it2 = this.f73087q.iterator();
        while (true) {
            if (!it2.hasNext()) {
                marketOptionSettingBean = null;
                break;
            }
            marketOptionSettingBean = it2.next();
            if (marketOptionSettingBean.isSelected()) {
                break;
            }
        }
        return marketOptionSettingBean == null ? this.f73087q.get(0) : marketOptionSettingBean;
    }

    public String getSelectedSymbol() {
        MarketOptionSettingBean marketOptionSettingBean;
        Iterator<MarketOptionSettingBean> it2 = this.f73085o.iterator();
        while (true) {
            if (!it2.hasNext()) {
                marketOptionSettingBean = null;
                break;
            }
            marketOptionSettingBean = it2.next();
            if (marketOptionSettingBean.isSelected()) {
                break;
            }
        }
        return marketOptionSettingBean != null ? marketOptionSettingBean.getName() : "";
    }

    public void h(List<FutureContractInfo> list) {
        this.f73089s.clear();
        this.f73089s.addAll(FutureProductInfoController.d().j());
        ArrayList arrayList = new ArrayList();
        for (String marketOptionSettingBean : this.f73089s) {
            arrayList.add(new MarketOptionSettingBean(1, marketOptionSettingBean));
        }
        j(this.f73085o, arrayList, true);
        i();
        y();
        w();
    }

    public final void i() {
        List<FutureContractInfo> b11;
        if (this.f73074d != null && (b11 = this.f73074d.B1().b(getSelectedSymbol())) != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (FutureContractInfo next : b11) {
                if (!arrayList.contains(next.getDeliveryDate())) {
                    arrayList2.add(new MarketOptionSettingBean(2, next.getDeliveryDate(), next.getContractType(), next.getDeliveryDate()));
                    arrayList.add(next.getDeliveryDate());
                }
            }
            j(this.f73086p, arrayList2, true);
        }
    }

    public final void j(List<MarketOptionSettingBean> list, List<MarketOptionSettingBean> list2, boolean z11) {
        boolean z12;
        if (list.size() == 0) {
            list.addAll(list2);
            if (list.size() > 0) {
                list.get(0).setSelected(true);
                return;
            }
            return;
        }
        MarketOptionSettingBean marketOptionSettingBean = null;
        Iterator<MarketOptionSettingBean> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            MarketOptionSettingBean next = it2.next();
            if (next.isSelected()) {
                marketOptionSettingBean = next;
                break;
            }
        }
        if (marketOptionSettingBean == null || !z11) {
            z12 = false;
        } else {
            z12 = false;
            for (MarketOptionSettingBean next2 : list2) {
                if (next2.getName().equals(marketOptionSettingBean.getName())) {
                    next2.setSelected(true);
                    z12 = true;
                }
            }
        }
        list.clear();
        list.addAll(list2);
        if (!z12 && list.size() > 0) {
            list.get(0).setSelected(true);
        }
    }

    public final void k(Context context) {
        this.f73072b = (FragmentActivity) context;
        addView(LayoutInflater.from(context).inflate(R$layout.market_option_filter_layout, (ViewGroup) null, false));
        this.f73076f = findViewById(R$id.fl_type1);
        this.f73077g = (TextView) findViewById(R$id.tv_type1);
        this.f73078h = findViewById(R$id.fl_type2);
        this.f73079i = (TextView) findViewById(R$id.tv_type2);
        this.f73080j = findViewById(R$id.fl_type3);
        this.f73081k = (TextView) findViewById(R$id.tv_type3);
        this.f73082l = findViewById(R$id.fl_type4);
        this.f73083m = (TextView) findViewById(R$id.tv_type4);
        g();
        l();
    }

    public final void l() {
        this.f73076f.setOnClickListener(new k(this));
        this.f73078h.setOnClickListener(new vl.m(this));
        this.f73080j.setOnClickListener(new l(this));
        this.f73082l.setOnClickListener(new n(this));
    }

    public final void q() {
        m.g(this.f73088r, getContext());
        this.f73075e.s();
    }

    public final void r(TextView textView) {
        TextView textView2 = this.f73084n;
        if (textView2 != null) {
            u(textView2, true);
        }
        this.f73084n = textView;
        if (textView != null) {
            u(textView, false);
        }
    }

    public final void s() {
        if (this.f73074d != null && getSelectedDelivery() != null) {
            this.f73074d.z2(getSelectedSymbol(), getSelectedDelivery().getContractType(), true);
        }
    }

    public void setOptionOverviewLayout(b bVar) {
        this.f73075e = bVar;
    }

    public void setPresenter(HomeMarketNewPresenter homeMarketNewPresenter) {
        this.f73074d = homeMarketNewPresenter;
    }

    public final void t() {
        y();
        i();
        w();
    }

    public final void u(TextView textView, boolean z11) {
        if (z11) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$drawable.trade_arrow_down, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$drawable.trade_arrow_up, 0);
        }
    }

    public final void v(int i11, List<MarketOptionSettingBean> list) {
        if (this.f73073c == null) {
            MarketOptionSettingDialogFragment marketOptionSettingDialogFragment = new MarketOptionSettingDialogFragment();
            this.f73073c = marketOptionSettingDialogFragment;
            marketOptionSettingDialogFragment.zh(this);
            this.f73073c.addExtraClickView(this.f73076f, this.f73078h, this.f73080j, this.f73082l);
        }
        if (!this.f73073c.isVisible() || this.f73073c.xh() != i11) {
            this.f73073c.setTopMargin(ViewUtil.h(this, this.f73072b)[1] + getHeight());
            this.f73073c.Ah(i11);
            this.f73073c.setSettingBeans(list);
            if (!this.f73073c.isVisible()) {
                this.f73073c.show(this.f73072b.getSupportFragmentManager(), "settingDialogFragment");
            } else {
                this.f73073c.wh();
            }
        } else {
            this.f73073c.dismiss();
        }
    }

    public final void w() {
        MarketOptionSettingBean selectedDelivery = getSelectedDelivery();
        if (selectedDelivery != null) {
            this.f73079i.setText(e.h(selectedDelivery.getContractType(), selectedDelivery.getDeliveryDate()));
        }
    }

    public final void x() {
        MarketOptionSettingBean selectedDirection = getSelectedDirection();
        this.f73081k.setText(selectedDirection.getName());
        this.f73075e.r(selectedDirection.getDirection());
    }

    public final void y() {
        this.f73077g.setText(getSelectedSymbol());
    }

    public MarketOptionTopView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        k(context);
    }
}
