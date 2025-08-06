package com.huobi.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.uc.core.utils.LicenseType;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.exchange.grid.presenter.GridTradePresenter;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.main.trade.ui.TradeDialogFragment;
import com.huobi.share.fragment.StrategyShareFragment;
import com.huobi.strategy.StrategyDetailActivity;
import com.huobi.strategy.StrategyOrderActivity;
import com.huobi.utils.a0;
import com.huobi.utils.k0;
import com.huobi.utils.v0;
import dt.h2;
import java.util.HashMap;
import java.util.Map;
import ml.d;
import rn.c;
import rx.Observable;
import sn.f;
import sn.t;
import tg.r;
import tq.p;
import u6.g;

public class ExchangeModuleCallbackImpl implements vc.a {

    /* renamed from: a  reason: collision with root package name */
    public String f43764a;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43765a;

        static {
            int[] iArr = new int[TradeType.values().length];
            f43765a = iArr;
            try {
                iArr[TradeType.GRID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(wc.a aVar, TradeType tradeType, s9.a aVar2) {
        if (a.f43765a[tradeType.ordinal()] == 1) {
            d dVar = (d) aVar2;
            String str = this.f43764a;
            if (str == null || !str.equalsIgnoreCase(dVar.o())) {
                aVar.j(dVar.o());
            }
        }
    }

    public boolean a() {
        return r.x().F0();
    }

    public boolean b() {
        return r.x().X();
    }

    public void c(Context context) {
        Intent h11 = k0.h(context);
        c.i().m((Activity) context, new JumpTarget(h11, h11));
    }

    public void d(String str, Map<String, Object> map, String str2) {
        is.a.j(str, map, str2);
    }

    public void e(Context context) {
        context.startActivity(new Intent(context, StrategyOrderActivity.class));
    }

    public Observable<Map<String, String>> f() {
        return h2.t1().y3(TradeType.PRO, false);
    }

    public Observable<Object> g() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", LicenseType.GRID_TRADING.type);
        return UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(p.c0());
    }

    public void h(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StrategyShareFragment strategyShareFragment = new StrategyShareFragment();
        strategyShareFragment.gi(str, str2, str3, str4, str5, String.valueOf(str6), str7);
        strategyShareFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "StrategyShareFragment");
    }

    public String i(String str) {
        return a0.f(str);
    }

    public void j(Activity activity) {
        f.U(activity);
    }

    public void k(Context context) {
        t.s(false, context).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
    }

    public void l(String str, String str2, Map<String, Object> map) {
        is.a.s(str, str2, false, (String) null, map);
    }

    public String m() {
        return v0.c("900003573146");
    }

    public Observable<TradeRiskReminder> n(boolean z11) {
        return UserCenterRemoteDataSource.A().requestLicenseState(LicenseType.GRID_TRADING.type, z11);
    }

    public BaseDialogFragment o(boolean z11, Context context, GridTradePresenter.i iVar, String str, BaseDialogFragment baseDialogFragment, String str2, wc.a aVar) {
        TradeDialogFragment tradeDialogFragment;
        this.f43764a = str;
        if (baseDialogFragment == null) {
            tradeDialogFragment = new TradeDialogFragment();
            tradeDialogFragment.xi(z11);
            tradeDialogFragment.zi(iVar);
            tradeDialogFragment.ri(new kj.a(this, aVar));
        } else {
            tradeDialogFragment = (TradeDialogFragment) baseDialogFragment;
        }
        tradeDialogFragment.Ci(((FragmentActivity) context).getSupportFragmentManager(), "trade", TradeType.parse(str2), str);
        return tradeDialogFragment;
    }

    public void p(Context context, String str) {
        StrategyDetailActivity.start(context, str);
    }

    public void q(Context context) {
        f.R((Activity) context);
    }
}
