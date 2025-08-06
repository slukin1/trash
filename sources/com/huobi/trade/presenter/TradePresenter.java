package com.huobi.trade.presenter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.asset.event.ChangeVerticalSpotFromWhiteListEvent;
import com.huobi.supermargin.ui.TradeVerticalSuperMarginFragment;
import com.huobi.trade.event.UpdateSpotMarginUiEvent;
import com.huobi.trade.helper.c;
import com.huobi.trade.helper.m;
import com.huobi.trade.helper.x;
import com.huobi.trade.ui.TradeVerticalMarginFragment;
import com.huobi.trade.ui.TradeVerticalSpotFragment;
import com.huobi.utils.k0;
import d7.a1;
import dt.i2;
import java.util.HashMap;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import tg.r;
import u6.g;
import uh.i;

public class TradePresenter extends BaseFragmentPresenter<a> {

    /* renamed from: c  reason: collision with root package name */
    public TradeType f82135c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f82136d = null;

    /* renamed from: e  reason: collision with root package name */
    public TradeType f82137e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f82138f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f82139g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f82140h;

    public interface a extends g {
        void B3(int i11);

        void S8(TradeType tradeType);

        void j0(int i11);
    }

    public void V() {
        EventBus.d().r(this);
        super.V();
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            if (this.f82138f) {
                s0();
            }
            this.f82138f = true;
            m.e().d();
        }
    }

    @h
    @Keep
    public void afterSymbolIdChanged(lk.a aVar) {
        i0();
    }

    public Fragment b0() {
        return this.f82136d;
    }

    public TradeType c0() {
        return this.f82135c;
    }

    public Fragment d0(String str, Bundle bundle, String str2) {
        Fragment m02 = Q().getChildFragmentManager().m0(str2);
        if (m02 != null) {
            if (!(m02.getArguments() == null || bundle == null)) {
                m02.getArguments().putAll(bundle);
            }
            return m02;
        }
        for (Fragment next : Q().getChildFragmentManager().B0()) {
            if (next != null && next.getClass().getName().equals(str) && str2.equals(next.getTag())) {
                if (!(next.getArguments() == null || bundle == null)) {
                    next.getArguments().putAll(bundle);
                }
                return next;
            }
        }
        return Fragment.instantiate(getActivity(), str, bundle);
    }

    public boolean f0() {
        return this.f82139g;
    }

    /* renamed from: g0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        EventBus.d().p(this);
        s0();
    }

    public void h0(boolean z11) {
        this.f82139g = z11;
    }

    public void i0() {
        TradeType tradeType = this.f82135c;
        TradeType tradeType2 = TradeType.MARGIN;
        if (tradeType == tradeType2) {
            i2.a().h(TradeType.PRO, i2.a().d(tradeType2));
        } else {
            TradeType tradeType3 = TradeType.SUPERMARGIN;
            if (tradeType == tradeType3) {
                i2.a().h(TradeType.PRO, i2.a().d(tradeType3));
            }
        }
        TradeType tradeType4 = TradeType.PRO;
        this.f82135c = tradeType4;
        k0.H(tradeType4);
        k0.G("pro.huobi.pro");
        t0(new Bundle());
        c.b().k(1);
        c.b().g();
    }

    public void j0() {
        zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/trade/exchange")).c();
    }

    public final void k0(Class cls, Bundle bundle) {
        FragmentManager childFragmentManager = Q().getChildFragmentManager();
        FragmentTransaction q11 = childFragmentManager.q();
        for (Fragment next : childFragmentManager.B0()) {
            if (next != null && !(next instanceof DialogFragment)) {
                q11.q(next);
            }
        }
        String name = cls.getName();
        Fragment d02 = d0(cls.getName(), bundle, cls.getName());
        if (!d02.isAdded()) {
            q11.c(R.id.future_tab_content, d02, name);
        }
        this.f82136d = d02;
        q11.A(d02).k();
    }

    public void l0() {
        TradeType tradeType = TradeType.MARGIN;
        this.f82135c = tradeType;
        this.f82137e = tradeType;
        k0.H(tradeType);
        k0.F(this.f82137e);
        k0.G("pro.huobi.margin");
        t0(new Bundle());
        c.b().k(3);
        c.b().g();
    }

    public void m0(String str) {
        i2 a11 = i2.a();
        TradeType tradeType = TradeType.MARGIN;
        a11.h(tradeType, str);
        this.f82135c = tradeType;
        this.f82137e = tradeType;
        k0.H(tradeType);
        k0.F(this.f82137e);
        k0.G("pro.huobi.margin");
        t0(new Bundle());
        c.b().k(3);
        c.b().g();
    }

    public void n0() {
        TradeType tradeType = this.f82135c;
        TradeType tradeType2 = TradeType.PRO;
        if (tradeType == tradeType2) {
            String d11 = i2.a().d(tradeType2);
            TradeType tradeType3 = this.f82137e;
            TradeType tradeType4 = TradeType.MARGIN;
            if (tradeType3 != tradeType4) {
                TradeType tradeType5 = TradeType.SUPERMARGIN;
                if (tradeType3 == tradeType5 && a1.v().J(d11, tradeType5) != null) {
                    i2.a().h(tradeType5, d11);
                }
            } else if (a1.v().J(d11, tradeType4) != null) {
                i2.a().h(tradeType4, d11);
            }
        }
        TradeType tradeType6 = this.f82137e;
        TradeType tradeType7 = TradeType.MARGIN;
        if (tradeType6 == tradeType7) {
            this.f82135c = tradeType7;
            k0.G("pro.huobi.margin");
            c.b().k(3);
            gs.g.i("App_targe_tab_lsomargin_click", (HashMap) null);
        } else {
            TradeType tradeType8 = TradeType.SUPERMARGIN;
            if (tradeType6 == tradeType8) {
                this.f82135c = tradeType8;
                k0.G("pro.huobi.supermargin");
                c.b().k(2);
                gs.g.i("App_targe_tab_crossmargin_click", (HashMap) null);
            }
        }
        k0.H(this.f82135c);
        k0.F(this.f82135c);
        t0(new Bundle());
        c.b().g();
    }

    public String o0() {
        return i2.a().d(this.f82135c);
    }

    @h
    @Keep
    public void onUpdateSpotMarginUi(UpdateSpotMarginUiEvent updateSpotMarginUiEvent) {
        this.f82140h = true;
    }

    public void p0() {
        is.a.i("3526", (Map<String, Object>) null);
        if (r.x().X()) {
            HuobiToastUtil.j(R.string.sub_account_not_support_otc);
        } else {
            jp.k0.k(getActivity());
        }
    }

    public void q0() {
        TradeType tradeType = TradeType.SUPERMARGIN;
        this.f82135c = tradeType;
        this.f82137e = tradeType;
        k0.H(tradeType);
        k0.F(this.f82137e);
        k0.G("pro.huobi.supermargin");
        t0(new Bundle());
        c.b().k(2);
        c.b().g();
    }

    public void r0(String str) {
        i2 a11 = i2.a();
        TradeType tradeType = TradeType.SUPERMARGIN;
        a11.h(tradeType, str);
        this.f82135c = tradeType;
        this.f82137e = tradeType;
        k0.H(tradeType);
        k0.F(this.f82137e);
        k0.G("pro.huobi.supermargin");
        t0(new Bundle());
        c.b().k(2);
        c.b().g();
    }

    public void s0() {
        Bundle arguments = Q().getArguments();
        TradeType x11 = k0.x();
        if (x11 == null) {
            x11 = TradeType.PRO;
        }
        TradeType tradeType = this.f82135c;
        if (tradeType == null) {
            this.f82135c = x11;
            if (x11 == TradeType.MARGIN || x11 == TradeType.SUPERMARGIN) {
                this.f82137e = x11;
            }
            t0(arguments);
        } else if (tradeType != x11) {
            this.f82135c = x11;
            if (x11 == TradeType.MARGIN || x11 == TradeType.SUPERMARGIN) {
                this.f82137e = x11;
            }
            t0(arguments);
        } else if (this.f82140h) {
            t0(arguments);
            this.f82140h = false;
        }
        TradeType k11 = k0.k();
        TradeType tradeType2 = this.f82137e;
        if (tradeType2 == null && k11 != null) {
            this.f82137e = k11;
        } else if (tradeType2 == null || k11 == null || tradeType2 != k11) {
            this.f82137e = TradeType.SUPERMARGIN;
        }
        TradeType tradeType3 = this.f82135c;
        TradeType tradeType4 = TradeType.MARGIN;
        String str = HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE;
        if (!(tradeType3 == tradeType4 || tradeType3 == TradeType.SUPERMARGIN)) {
            str = "bb";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", o0());
        hashMap.put("targe_tab_name", str);
        BaseModuleConfig.a().w("App_targe_view", hashMap);
        c.b().i(o0());
    }

    public final void t0(Bundle bundle) {
        bundle.putString("key_trade_type", this.f82135c.name());
        TradeType tradeType = this.f82135c;
        if (tradeType == TradeType.PRO) {
            if (!r.x().F0()) {
                k0(TradeVerticalSpotFragment.class, bundle);
            } else if (i.d().g()) {
                k0(com.huobi.tradenew.ui.TradeVerticalSpotFragment.class, bundle);
            } else {
                k0(TradeVerticalSpotFragment.class, bundle);
            }
            ((a) getUI()).B3(1);
            ((a) getUI()).j0(R.string.n_spot);
        } else if (tradeType == TradeType.MARGIN) {
            k0(TradeVerticalMarginFragment.class, bundle);
            if (x.b()) {
                ((a) getUI()).B3(1);
                ((a) getUI()).j0(R.string.n_spot);
            } else {
                ((a) getUI()).B3(2);
            }
        } else if (tradeType == TradeType.SUPERMARGIN) {
            k0(TradeVerticalSuperMarginFragment.class, bundle);
            if (x.b()) {
                ((a) getUI()).B3(1);
                ((a) getUI()).j0(R.string.n_spot);
            } else {
                ((a) getUI()).B3(2);
            }
        } else if (tradeType == TradeType.OTC) {
            p0();
        }
        ((a) getUI()).S8(this.f82135c);
    }

    public void u0(Context context) {
        zn.a.d().v(Uri.parse("holigeit://open/v1?url=ihuobiglobal://m.hbg.com/trade/bot?source=app_bots_spottrade")).c();
        gs.g.i("tradingbot_pageview_app_spot", (HashMap) null);
    }

    @h
    @Keep
    public void afterSymbolIdChanged(ChangeVerticalSpotFromWhiteListEvent changeVerticalSpotFromWhiteListEvent) {
        if (this.f82135c == TradeType.PRO) {
            i0();
        }
    }
}
