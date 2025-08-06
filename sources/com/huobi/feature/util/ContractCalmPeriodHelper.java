package com.huobi.feature.util;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractCalmPeriodInfo;
import com.huobi.feature.ui.ContractCalmPeriodActivity;
import com.huobi.login.bean.JumpTarget;
import i6.d;
import i6.t;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rn.c;
import rx.Observable;
import rx.Subscriber;
import tg.r;
import u6.g;

public final class ContractCalmPeriodHelper implements t.a {

    /* renamed from: f  reason: collision with root package name */
    public static ContractCalmPeriodInfo f45058f;

    /* renamed from: g  reason: collision with root package name */
    public static long f45059g;

    /* renamed from: b  reason: collision with root package name */
    public ContractCalmPeriodInfo f45060b;

    /* renamed from: c  reason: collision with root package name */
    public Observable<ContractCalmPeriodInfo> f45061c = q7.a.a().getCoolingOffPeriodInfo().b();

    /* renamed from: d  reason: collision with root package name */
    public Handler f45062d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45063e;

    public class a extends BaseSubscriber<ContractCalmPeriodInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(ContractCalmPeriodInfo contractCalmPeriodInfo) {
            d.d("ContractCalmPeriodHelper onNext:" + contractCalmPeriodInfo);
            ContractCalmPeriodHelper.f45058f = contractCalmPeriodInfo;
            if (contractCalmPeriodInfo != null) {
                EventBus.d().k(contractCalmPeriodInfo);
            }
        }

        public void onAfter() {
            super.onAfter();
            ContractCalmPeriodHelper.this.f();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            d.d("ContractCalmPeriodHelper onError:" + th2);
            if (ContractCalmPeriodHelper.f45058f == null) {
                EventBus.d().k(ContractCalmPeriodHelper.this.f45060b);
            }
        }
    }

    public ContractCalmPeriodHelper() {
        ContractCalmPeriodInfo contractCalmPeriodInfo = new ContractCalmPeriodInfo();
        this.f45060b = contractCalmPeriodInfo;
        contractCalmPeriodInfo.status = -1;
        this.f45062d = new t(this);
    }

    public static boolean d() {
        ContractCalmPeriodInfo contractCalmPeriodInfo = f45058f;
        return contractCalmPeriodInfo != null && contractCalmPeriodInfo.isOff();
    }

    public static void e(Activity activity) {
        c.i().d(activity, new JumpTarget(new Intent(activity, ContractCalmPeriodActivity.class), (Intent) null));
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            f45058f = null;
            f45059g = 0;
        }
    }

    public static void h(Resources resources) {
        String str;
        if (f45058f == null) {
            str = "";
        } else {
            str = String.format(Locale.US, resources.getString(R.string.n_contract_calm_period_cannot_trade), new Object[]{DateTimeUtils.k(f45058f.getCoolingOffEndTime())});
        }
        HuobiToastUtil.m(str);
    }

    public final Subscriber<ContractCalmPeriodInfo> c() {
        return new a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        if (f45059g > 0) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ContractCalmPeriodHelper nextPolling isLooping:"
            r0.append(r1)
            boolean r1 = r9.f45063e
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            i6.d.d(r0)
            boolean r0 = r9.f45063e
            if (r0 == 0) goto L_0x003d
            r0 = 60000(0xea60, double:2.9644E-319)
            com.huobi.contract.entity.ContractCalmPeriodInfo r2 = f45058f
            r3 = 5000(0x1388, double:2.4703E-320)
            if (r2 != 0) goto L_0x0025
        L_0x0023:
            r0 = r3
            goto L_0x0037
        L_0x0025:
            boolean r2 = d()
            r5 = 0
            if (r2 == 0) goto L_0x0030
            f45059g = r5
            goto L_0x0023
        L_0x0030:
            long r7 = f45059g
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0037
            goto L_0x0023
        L_0x0037:
            android.os.Handler r2 = r9.f45062d
            r3 = 1
            r2.sendEmptyMessageDelayed(r3, r0)
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.feature.util.ContractCalmPeriodHelper.f():void");
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            i();
        }
    }

    public void i() {
        j();
        if (r.x().F0()) {
            this.f45063e = true;
            this.f45061c.compose(RxJavaHelper.t((g) null)).subscribe(c());
            return;
        }
        f45058f = null;
        EventBus.d().k(this.f45060b);
    }

    public void j() {
        this.f45063e = false;
        this.f45062d.removeCallbacksAndMessages((Object) null);
    }
}
