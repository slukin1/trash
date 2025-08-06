package com.huobi.feature.presenter;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bj.p0;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroAvailablePositionBean;
import com.hbg.lib.network.hbg.core.bean.NewBannerBean;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.contract.entity.ContractUserInfoActive;
import com.huobi.contract.ui.ContractTradeSplitFragment;
import com.huobi.contract.ui.ContractTradeTogetherFragment;
import com.huobi.feature.util.ContractCalmPeriodHelper;
import com.huobi.feature.util.KycAndHasTradeDialogUtils;
import com.huobi.linearswap.ordertutorial.ui.OrderTutorialActivity;
import com.huobi.linearswap.ui.LinearSwapTradeSplitFragment;
import com.huobi.linearswap.ui.LinearSwapTradeTogetherFragment;
import com.huobi.login.bean.JumpTarget;
import com.huobi.swap.bean.ClearInputEvent;
import com.huobi.swap.ui.SwapTradeSplitFragment;
import com.huobi.swap.ui.SwapTradeTogetherFragment;
import com.huobi.utils.k0;
import d7.g0;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import qk.n0;
import qk.t;
import tg.r;
import u6.g;

public class FutureTradePresenter extends BaseFragmentPresenter<d> {

    /* renamed from: c  reason: collision with root package name */
    public Fragment f44630c = null;

    /* renamed from: d  reason: collision with root package name */
    public TradeType f44631d;

    /* renamed from: e  reason: collision with root package name */
    public TradeType f44632e;

    /* renamed from: f  reason: collision with root package name */
    public int f44633f = 0;

    /* renamed from: g  reason: collision with root package name */
    public TradeType f44634g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44635h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44636i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f44637j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f44638k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f44639l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f44640m;

    /* renamed from: n  reason: collision with root package name */
    public ContractCalmPeriodHelper f44641n;

    /* renamed from: o  reason: collision with root package name */
    public final MutableLiveData<List<NewBannerBean.BannerAdv>> f44642o;

    /* renamed from: p  reason: collision with root package name */
    public LiveData<List<NewBannerBean.BannerAdv>> f44643p;

    /* renamed from: q  reason: collision with root package name */
    public final MutableLiveData<ActivityZeroAvailablePositionBean> f44644q;

    /* renamed from: r  reason: collision with root package name */
    public LiveData<ActivityZeroAvailablePositionBean> f44645r;

    public class a extends RequestCallback1<ContractUserInfoActive> {
        public a() {
        }

        /* renamed from: a */
        public void onRequestSuccess(ContractUserInfoActive contractUserInfoActive) {
            boolean unused = FutureTradePresenter.this.f44638k = true;
            boolean unused2 = FutureTradePresenter.this.f44637j = contractUserInfoActive.getHas_trade() == 1;
            FutureTradePresenter futureTradePresenter = FutureTradePresenter.this;
            futureTradePresenter.B0(futureTradePresenter.f44637j, true);
            KycAndHasTradeDialogUtils.k(contractUserInfoActive.isKycVerified());
        }
    }

    public class b extends BaseSubscriber<NewBannerBean> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(NewBannerBean newBannerBean) {
            super.onNext(newBannerBean);
            ArrayList arrayList = new ArrayList();
            if (!(newBannerBean == null || newBannerBean.getBannerAdvList() == null)) {
                arrayList.addAll(newBannerBean.getBannerAdvList());
            }
            FutureTradePresenter.this.f44642o.postValue(arrayList);
        }
    }

    public class c extends BaseSubscriber<ActivityZeroAvailablePositionBean> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(ActivityZeroAvailablePositionBean activityZeroAvailablePositionBean) {
            super.onNext(activityZeroAvailablePositionBean);
            if (activityZeroAvailablePositionBean != null) {
                int i11 = 0;
                int intValue = activityZeroAvailablePositionBean.getAvailable() == null ? 0 : activityZeroAvailablePositionBean.getAvailable().intValue();
                int intValue2 = activityZeroAvailablePositionBean.getPositionNotice() == null ? 0 : activityZeroAvailablePositionBean.getPositionNotice().intValue();
                if (activityZeroAvailablePositionBean.getCount() != null) {
                    i11 = activityZeroAvailablePositionBean.getCount().intValue();
                }
                String highestProfit = activityZeroAvailablePositionBean.getHighestProfit() == null ? "" : activityZeroAvailablePositionBean.getHighestProfit();
                if (1 == intValue && intValue2 == 0 && i11 > 0 && !highestProfit.isEmpty()) {
                    FutureTradePresenter.this.f44644q.postValue(activityZeroAvailablePositionBean);
                    v7.b.a().activityZeroNoticeSure(3).b().compose(RxJavaHelper.t((g) FutureTradePresenter.this.getUI())).subscribe(new BaseSubscriber());
                }
            }
        }
    }

    public interface d extends g {
        void B3(int i11);

        void j0(int i11);
    }

    public FutureTradePresenter() {
        MutableLiveData<List<NewBannerBean.BannerAdv>> mutableLiveData = new MutableLiveData<>();
        this.f44642o = mutableLiveData;
        this.f44643p = mutableLiveData;
        MutableLiveData<ActivityZeroAvailablePositionBean> mutableLiveData2 = new MutableLiveData<>();
        this.f44644q = mutableLiveData2;
        this.f44645r = mutableLiveData2;
    }

    public void A0() {
        this.f44631d = TradeType.OTC_OPTIONS;
    }

    public final void B0(boolean z11, boolean z12) {
        Fragment fragment = this.f44630c;
        if (fragment instanceof SwapTradeTogetherFragment) {
            ((SwapTradeTogetherFragment) fragment).ri(z11);
        } else if (fragment instanceof SwapTradeSplitFragment) {
            ((SwapTradeSplitFragment) fragment).ri(z11);
        } else if (fragment instanceof LinearSwapTradeTogetherFragment) {
            ((LinearSwapTradeTogetherFragment) fragment).Qi(z11);
        } else if (fragment instanceof LinearSwapTradeSplitFragment) {
            ((LinearSwapTradeSplitFragment) fragment).Qi(z11);
        } else if (fragment instanceof ContractTradeTogetherFragment) {
            ((ContractTradeTogetherFragment) fragment).ri(z11);
        } else if (fragment instanceof ContractTradeSplitFragment) {
            ((ContractTradeSplitFragment) fragment).ri(z11);
        }
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (this.f44641n == null) {
            this.f44641n = new ContractCalmPeriodHelper();
        }
        if (z11) {
            if (this.f44635h) {
                w0();
            }
            this.f44635h = true;
            g0.e(false).compose(RxJavaHelper.t((g) getUI())).subscribe(new BaseSubscriber());
            j0();
            this.f44641n.i();
            return;
        }
        this.f44641n.j();
    }

    public Fragment i0() {
        return this.f44630c;
    }

    public final void j0() {
        if (this.f44631d == TradeType.LINEAR_SWAP && this.f44638k && !this.f44637j && SP.l("is_first_order", true)) {
            rn.c.i().d(getActivity(), new JumpTarget(new Intent(getActivity(), OrderTutorialActivity.class), (Intent) null));
        }
    }

    public Fragment k0(String str, Bundle bundle, String str2) {
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

    public boolean l0() {
        return this.f44640m;
    }

    public boolean m0(NewBannerBean.BannerAdv bannerAdv) {
        String n11 = DateTimeUtils.n(System.currentTimeMillis());
        return !ConfigPreferences.c("user_config", "CONFIG_CONTRACT_BOTTOM_LEFT_ACTIVITY_" + r.x().J() + bannerAdv.getAdvId() + n11, false);
    }

    /* renamed from: n0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        int a11 = n0.a();
        if (a11 == 0) {
            k0.E(TradeType.LINEAR_SWAP);
        } else if (a11 != 1) {
            if (a11 == 99) {
                k0.E(TradeType.OPTION);
            }
        } else if (k0.g() == null) {
            k0.E(TradeType.CONTRACT);
        }
        w0();
        this.f44636i = p0.h();
        this.f44639l = p0.g();
    }

    public void p0() {
        v7.b.a().activityZeroAvailablePosition().b().compose(RxJavaHelper.t((g) getUI())).subscribe(new c());
    }

    public void q0() {
        v7.b.a().requestNewBanner(67, 9, (String) null).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
    }

    public void r0() {
        if (r.x().F0()) {
            q7.a.a().fetchUserInfoActive().d(new a());
        }
    }

    public void s0(NewBannerBean.BannerAdv bannerAdv) {
        String n11 = DateTimeUtils.n(System.currentTimeMillis());
        ConfigPreferences.n("user_config", "CONFIG_CONTRACT_BOTTOM_LEFT_ACTIVITY_" + r.x().J() + bannerAdv.getAdvId() + n11, true);
    }

    public void t0(boolean z11) {
        this.f44640m = z11;
    }

    public void u0() {
        if (this.f44634g == null) {
            this.f44634g = k0.e();
        }
        TradeType tradeType = this.f44634g;
        TradeType tradeType2 = TradeType.CONTRACT;
        if (tradeType == tradeType2) {
            this.f44631d = tradeType2;
            k0.G("pro.huobi.contract");
        } else {
            this.f44631d = TradeType.SWAP;
            k0.G("pro.huobi.swap");
        }
        k0.E(this.f44631d);
        k0.D(this.f44631d);
        x0(Q().getArguments());
        this.f44632e = this.f44631d;
    }

    public final void v0(Class cls, Bundle bundle) {
        FragmentManager childFragmentManager = Q().getChildFragmentManager();
        FragmentTransaction q11 = childFragmentManager.q();
        for (Fragment next : childFragmentManager.B0()) {
            if (next != null && !(next instanceof DialogFragment)) {
                q11.q(next);
            }
        }
        String name = cls.getName();
        Fragment k02 = k0(cls.getName(), bundle, cls.getName());
        if (!k02.isAdded()) {
            q11.c(R.id.future_tab_content, k02, name);
        }
        this.f44630c = k02;
        B0(this.f44637j, false);
        q11.A(k02).k();
    }

    public void w0() {
        Bundle arguments = Q().getArguments();
        TradeType g11 = k0.g();
        if (g11 == null) {
            g11 = TradeType.CONTRACT;
        }
        TradeType tradeType = this.f44631d;
        if (tradeType == null) {
            this.f44631d = g11;
            if (g11 == TradeType.CONTRACT || g11 == TradeType.SWAP) {
                this.f44634g = g11;
            }
            x0(arguments);
        } else if (tradeType != g11) {
            this.f44631d = g11;
            if (g11 == TradeType.CONTRACT || g11 == TradeType.SWAP) {
                this.f44634g = g11;
            }
            x0(arguments);
        } else if (this.f44636i != p0.h()) {
            x0(arguments);
            this.f44636i = p0.h();
        } else if (this.f44639l != p0.g()) {
            x0(arguments);
            this.f44639l = p0.g();
        }
    }

    public final void x0(Bundle bundle) {
        EventBus.d().k(new ClearInputEvent());
        TradeType tradeType = this.f44632e;
        if (tradeType == TradeType.OTC_OPTIONS) {
            y0(tradeType, bundle);
        } else {
            y0(this.f44631d, bundle);
        }
    }

    public void y0(TradeType tradeType, Bundle bundle) {
        if (tradeType == TradeType.CONTRACT) {
            t.d();
            if (p0.h()) {
                v0(ContractTradeTogetherFragment.class, bundle);
            } else {
                v0(ContractTradeSplitFragment.class, bundle);
            }
            n0.b(1);
            ((d) getUI()).B3(1);
            ((d) getUI()).j0(R.string.n_contract_tab_coin_top_title);
        } else if (tradeType == TradeType.SWAP) {
            t.d();
            if (p0.h()) {
                v0(SwapTradeTogetherFragment.class, bundle);
            } else {
                v0(SwapTradeSplitFragment.class, bundle);
            }
            n0.b(1);
            ((d) getUI()).B3(1);
            ((d) getUI()).j0(R.string.n_contract_tab_coin_top_title);
        } else if (tradeType == TradeType.LINEAR_SWAP) {
            t.f();
            if (p0.g()) {
                v0(LinearSwapTradeTogetherFragment.class, bundle);
            } else {
                v0(LinearSwapTradeSplitFragment.class, bundle);
            }
            n0.b(0);
            ((d) getUI()).B3(0);
            ((d) getUI()).j0(R.string.n_contract_tab_usdt_top_title);
        }
    }

    public void z0() {
        TradeType tradeType = TradeType.LINEAR_SWAP;
        this.f44631d = tradeType;
        k0.E(tradeType);
        k0.G("pro.huobi.linearswap");
        x0(Q().getArguments());
        this.f44632e = tradeType;
    }
}
