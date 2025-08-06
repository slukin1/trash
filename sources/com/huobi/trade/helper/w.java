package com.huobi.trade.helper;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.trade.ui.MarginRiskReminderActivity;
import com.huobi.utils.v0;
import java.util.HashMap;
import pro.huobi.R;
import rx.Observable;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
import tg.r;
import tq.p;
import u6.g;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f82084a = false;

    public class a extends EasySubscriber<TradeRiskReminder> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f82085b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaseSubscriber f82086c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f82087d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f82088e;

        public a(g gVar, BaseSubscriber baseSubscriber, FragmentActivity fragmentActivity, String str) {
            this.f82085b = gVar;
            this.f82086c = baseSubscriber;
            this.f82087d = fragmentActivity;
            this.f82088e = str;
        }

        public static /* synthetic */ void c(g gVar, String str, HBDialogFragment hBDialogFragment) {
            w.c(gVar, str);
            hBDialogFragment.dismiss();
        }

        public static /* synthetic */ void d(FragmentActivity fragmentActivity, g gVar, String str, HBDialogFragment hBDialogFragment) {
            v0.e(fragmentActivity, "94896387719534");
            w.c(gVar, str);
            hBDialogFragment.dismiss();
        }

        /* renamed from: e */
        public void onNext(TradeRiskReminder tradeRiskReminder) {
            super.onNext(tradeRiskReminder);
            if (!this.f82085b.isCanBeSeen()) {
                this.f82086c.onNext(Boolean.FALSE);
            } else if ("0".equals(tradeRiskReminder.getState())) {
                this.f82086c.onNext(Boolean.FALSE);
                this.f82087d.startActivity(new Intent(this.f82087d, MarginRiskReminderActivity.class));
            } else if (tradeRiskReminder.getVersion() == 0) {
                this.f82086c.onNext(Boolean.FALSE);
                new DialogUtils.b.d(this.f82087d).C0(this.f82087d.getString(R.string.n_content_leverage_agreement_update)).q0(true).s0(this.f82087d.getString(R.string.n_cancel)).P0(this.f82087d.getString(R.string.n_content_leverage_agreement_detail)).N0(new v(this.f82085b, this.f82088e)).Q0(new u(this.f82087d, this.f82085b, this.f82088e)).k0().show(this.f82087d.getSupportFragmentManager(), "");
            } else {
                this.f82086c.onNext(Boolean.TRUE);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f82086c.onNext(Boolean.TRUE);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            this.f82086c.onNext(Boolean.TRUE);
        }
    }

    public class b implements Func2<Object, Object, Object> {
        public Object call(Object obj, Object obj2) {
            return obj;
        }
    }

    public static void c(g gVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "MARGIN");
        hashMap.put("version", 1);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("type", "SUPER_MARGIN");
        hashMap2.put("version", 1);
        Observable.zip(UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(p.c0()).subscribeOn(Schedulers.io()), UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap2).compose(p.c0()).subscribeOn(Schedulers.io()), new b()).flatMap(new t(str)).compose(RxJavaHelper.t(gVar)).subscribe(new BaseSubscriber());
    }

    public static void d(FragmentActivity fragmentActivity, g gVar, String str, BaseSubscriber<Boolean> baseSubscriber) {
        if (!r.x().X()) {
            UserCenterRemoteDataSource.A().requestLicenseState(str, true).compose(RxJavaHelper.t(gVar)).subscribe(new a(gVar, baseSubscriber, fragmentActivity, str));
        } else {
            baseSubscriber.onNext(Boolean.TRUE);
        }
    }
}
