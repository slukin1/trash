package com.huobi.assetrecord.presenter;

import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.bean.CommonDateSelectorItemBean;
import com.hbg.lib.widgets.utils.CalendarUtils;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ji.e;
import ji.f;
import pro.huobi.R;
import tq.p;
import u6.g;
import v7.b;

public class AppleOrderHistoryRecordPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public String f42822a;

    /* renamed from: b  reason: collision with root package name */
    public String f42823b;

    /* renamed from: c  reason: collision with root package name */
    public long f42824c;

    /* renamed from: d  reason: collision with root package name */
    public long f42825d;

    public interface a extends g {
        boolean C4();

        void Ff(int i11);

        boolean Gc();

        void K4(boolean z11);

        void Ka(boolean z11);

        void O8(boolean z11, boolean z12, boolean z13, String str);

        boolean Sc();

        void Xe(int i11);

        boolean f7();

        void jf(List<CommonDateSelectorItemBean> list);

        void p8();

        void sf(boolean z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(SecurityStrategySet securityStrategySet) {
        ((a) getUI()).O8(securityStrategySet.getSetting().isVerify_phone(), securityStrategySet.getSetting().isVerify_ga(), securityStrategySet.getSetting().isVerify_email(), "APPLY_FOR_ASSETS_RECORD");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(String str) {
        c0(this.f42824c, this.f42825d, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(Object obj) {
        ((a) getUI()).p8();
    }

    public void T(String str) {
        this.f42823b = str;
        if (TextUtils.isEmpty(str)) {
            ((a) getUI()).sf(false);
        } else {
            ((a) getUI()).sf(true);
        }
        g0();
    }

    public void U(String str) {
        this.f42822a = str;
        if (TextUtils.isEmpty(str)) {
            ((a) getUI()).K4(false);
        } else {
            ((a) getUI()).K4(true);
        }
        g0();
    }

    public void V(long j11, long j12) {
        this.f42824c = j11;
        this.f42825d = j12;
        if (!StringUtils.o(this.f42822a)) {
            ((a) getUI()).Ff(1);
        } else if (!StringUtils.o(this.f42823b)) {
            ((a) getUI()).Xe(1);
        } else if (!this.f42823b.equals(this.f42822a)) {
            ((a) getUI()).Xe(2);
        } else {
            UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new e(this)));
        }
    }

    public void W(String str, String str2, String str3, String str4) {
        UserCenterRemoteDataSource.G(str, str2, str3, (String) null, (Map<String, Object>) null, str4, EasySubscriber.create(new f(this)), (g) getUI());
    }

    public final void X() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CommonDateSelectorItemBean(1, getResources().getString(R.string.n_asset_last_n_month, new Object[]{BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL}), CalendarUtils.a(6)));
        arrayList.add(new CommonDateSelectorItemBean(2, getResources().getString(R.string.n_asset_last_n_month, new Object[]{"9"}), CalendarUtils.a(9)));
        arrayList.add(new CommonDateSelectorItemBean(3, getResources().getString(R.string.n_asset_last_n_year, new Object[]{"1"}), 365));
        ((a) getUI()).jf(arrayList);
    }

    /* renamed from: b0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        X();
    }

    public void c0(long j11, long j12, String str) {
        boolean f72 = ((a) getUI()).f7();
        boolean Gc = ((a) getUI()).Gc();
        b.a().u(j11, j12, this.f42822a, str, (!f72 || !Gc) ? f72 ? "1" : Gc ? "2" : "" : "1,2").b().compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new ji.g(this)));
    }

    public void d0() {
        if (TextUtils.isEmpty(this.f42822a)) {
            ((a) getUI()).Ff(0);
        } else if (!StringUtils.o(this.f42822a)) {
            ((a) getUI()).Ff(1);
        } else {
            ((a) getUI()).Ff(0);
        }
    }

    public void f0() {
        if (TextUtils.isEmpty(this.f42823b)) {
            ((a) getUI()).Xe(0);
        } else if (!StringUtils.o(this.f42823b)) {
            ((a) getUI()).Xe(1);
        } else if (!this.f42823b.equals(this.f42822a)) {
            ((a) getUI()).Xe(2);
        } else {
            ((a) getUI()).Xe(0);
        }
    }

    public void g0() {
        if (TextUtils.isEmpty(this.f42822a) || TextUtils.isEmpty(this.f42823b) || !((a) getUI()).Sc() || !((a) getUI()).C4()) {
            ((a) getUI()).Ka(false);
        } else {
            ((a) getUI()).Ka(true);
        }
    }
}
