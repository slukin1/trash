package com.huobi.otc.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.persenter.P2PTradeContainerPresenter;
import com.huobi.otc.widget.OtcTradeBottomTab;
import jp.b1;
import jp.q0;
import lp.b;
import lp.e;

public class P2PTradeContainerFragment extends BaseFragment<P2PTradeContainerPresenter, P2PTradeContainerPresenter.a> implements P2PTradeContainerPresenter.a, q0.e, OtcTradeBottomTab.a, b {

    /* renamed from: l  reason: collision with root package name */
    public FrameLayout f79593l;

    /* renamed from: m  reason: collision with root package name */
    public OtcTradeBottomTab f79594m;

    /* renamed from: n  reason: collision with root package name */
    public q0 f79595n;

    /* renamed from: Ch */
    public P2PTradeContainerPresenter xh() {
        return new P2PTradeContainerPresenter();
    }

    /* renamed from: Dh */
    public P2PTradeContainerPresenter.a zh() {
        return this;
    }

    public final void Eh() {
        if (this.f79595n.d() == OtcTradeAreaEnum.FREE_AREA) {
            if (getActivity() instanceof e) {
                ((e) getActivity()).P3().setVisibility(8);
            }
        } else if (getActivity() instanceof e) {
            ((e) getActivity()).o9();
        }
    }

    public ViewGroup Fc() {
        return this.f79593l;
    }

    public void M5() {
        if (!b1.h().j()) {
            this.f79594m.setVisibility(8);
            OtcTradeAreaEnum e11 = this.f79595n.e();
            OtcTradeAreaEnum otcTradeAreaEnum = OtcTradeAreaEnum.P2P_TRAD_AREA;
            if (e11 != otcTradeAreaEnum) {
                this.f79595n.r(otcTradeAreaEnum, (Bundle) null);
                return;
            }
            return;
        }
        this.f79594m.setVisibility(0);
    }

    public FragmentManager Vd() {
        return getChildFragmentManager();
    }

    public void fh(OtcTradeAreaEnum otcTradeAreaEnum, OtcTradeAreaEnum otcTradeAreaEnum2, Fragment fragment, Fragment fragment2) {
        this.f79594m.setTabSelected(otcTradeAreaEnum);
        Eh();
    }

    /* renamed from: if  reason: not valid java name */
    public void m3256if(int i11) {
        if (b1.h().j()) {
            this.f79594m.setChatUnReadNum(i11);
        }
    }

    public void initViews() {
        super.initViews();
        this.f79593l = (FrameLayout) this.f67460i.b(R$id.id_child_fragment_container);
        if (getActivity() != null) {
            e eVar = (e) getActivity();
            q0 m52 = eVar.m5();
            this.f79595n = m52;
            m52.n(this);
            eVar.p7(this);
            this.f79594m = eVar.v4();
        }
        if (this.f79595n != null) {
            Bundle bundle = new Bundle();
            if (getActivity() instanceof e) {
                e eVar2 = (e) getActivity();
                if (eVar2.getTradePosition() != -1) {
                    bundle.putString("tradeSide", eVar2.getTradePosition() == 0 ? "buy" : "sell");
                }
            }
            this.f79595n.r(OtcTradeAreaEnum.P2P_TRAD_AREA, bundle);
        }
        this.f79594m.setOnBottomTabClickListener(this);
        ViewUtil.m(this.f79594m, b1.h().j());
    }

    public void m9(OtcTradeAreaEnum otcTradeAreaEnum) {
        q0 q0Var = this.f79595n;
        if (q0Var != null) {
            q0Var.r(otcTradeAreaEnum, (Bundle) null);
            Eh();
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.p2p_trade_container_layout, viewGroup, false);
    }

    public void tf(OtcTradeAreaEnum otcTradeAreaEnum, OtcTradeAreaEnum otcTradeAreaEnum2) {
    }
}
