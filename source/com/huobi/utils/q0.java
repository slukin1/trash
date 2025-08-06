package com.huobi.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import cn.n;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.login.usercenter.data.source.bean.RetreatCountryData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import tq.p;
import u6.g;

public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f83764a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f83765b;

    /* renamed from: c  reason: collision with root package name */
    public String f83766c;

    public class a extends EasySubscriber<RetreatCountryData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f83767b;

        public a(FragmentActivity fragmentActivity) {
            this.f83767b = fragmentActivity;
        }

        /* renamed from: a */
        public void onNext(RetreatCountryData retreatCountryData) {
            super.onNext(retreatCountryData);
            if (retreatCountryData != null && !TextUtils.isEmpty(retreatCountryData.getRetreatCountryMessage())) {
                q0.this.i(this.f83767b, retreatCountryData.getRetreatCountryMessage());
            }
        }

        public void onError2(Throwable th2) {
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static q0 f83769a = new q0((a) null);
    }

    public /* synthetic */ q0(a aVar) {
        this();
    }

    public static q0 d() {
        return b.f83769a;
    }

    public static /* synthetic */ void e(boolean z11) {
        SP.r("sp_key_no_more_today", z11 ? System.currentTimeMillis() : 0);
    }

    public void c(FragmentActivity fragmentActivity) {
        boolean z11 = this.f83764a;
        this.f83764a = false;
        if (z11 && !this.f83765b && !f()) {
            UserCenterRemoteDataSource.A().E().compose(p.c0()).compose(RxJavaHelper.t((g) null)).subscribe(new a(fragmentActivity));
        }
    }

    public final boolean f() {
        return DateTimeUtils.F(SP.g("sp_key_no_more_today", 0));
    }

    public void g(Activity activity) {
        if (!TextUtils.isEmpty(this.f83766c) && !this.f83765b && !f()) {
            i(activity, this.f83766c);
            this.f83766c = null;
        }
    }

    public void h(String str) {
        this.f83766c = str;
    }

    public final void i(Activity activity, String str) {
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            new DialogUtils.b.d(fragmentActivity).i1(0).c1("Notice").C0(str).T0(false).x0(true).y0("Remind me tomorrow").v0(p0.f83762a).P0("Confirm").Q0(n.f13170a).q0(false).n0(false).j0().show(fragmentActivity.getSupportFragmentManager(), "");
            this.f83765b = true;
        }
    }

    public q0() {
        this.f83764a = true;
        this.f83765b = false;
    }
}
