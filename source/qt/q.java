package qt;

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

public final class q {

    public class a extends EasySubscriber<TradeRiskReminder> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseSubscriber f84715b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f84716c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f84717d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f84718e;

        public a(BaseSubscriber baseSubscriber, FragmentActivity fragmentActivity, g gVar, String str) {
            this.f84715b = baseSubscriber;
            this.f84716c = fragmentActivity;
            this.f84717d = gVar;
            this.f84718e = str;
        }

        public static /* synthetic */ void c(g gVar, String str, HBDialogFragment hBDialogFragment) {
            q.c(gVar, str);
            hBDialogFragment.dismiss();
        }

        public static /* synthetic */ void d(FragmentActivity fragmentActivity, g gVar, String str, HBDialogFragment hBDialogFragment) {
            v0.e(fragmentActivity, "94896387719534");
            q.c(gVar, str);
            hBDialogFragment.dismiss();
        }

        /* renamed from: e */
        public void onNext(TradeRiskReminder tradeRiskReminder) {
            super.onNext(tradeRiskReminder);
            if ("0".equals(tradeRiskReminder.getState())) {
                this.f84715b.onNext(Boolean.FALSE);
                this.f84716c.startActivity(new Intent(this.f84716c, MarginRiskReminderActivity.class));
            } else if (tradeRiskReminder.getVersion() == 0) {
                this.f84715b.onNext(Boolean.FALSE);
                new DialogUtils.b.d(this.f84716c).C0(this.f84716c.getString(R.string.n_content_leverage_agreement_update)).q0(true).s0(this.f84716c.getString(R.string.n_cancel)).P0(this.f84716c.getString(R.string.n_content_leverage_agreement_detail)).N0(new p(this.f84717d, this.f84718e)).Q0(new o(this.f84716c, this.f84717d, this.f84718e)).k0().show(this.f84716c.getSupportFragmentManager(), "");
            } else {
                this.f84715b.onNext(Boolean.TRUE);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f84715b.onNext(Boolean.FALSE);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            this.f84715b.onNext(Boolean.FALSE);
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
        Observable.zip(UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(p.c0()).subscribeOn(Schedulers.io()), UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap2).compose(p.c0()).subscribeOn(Schedulers.io()), new b()).flatMap(new n(str)).compose(RxJavaHelper.t(gVar)).subscribe(new BaseSubscriber());
    }

    public static void d(FragmentActivity fragmentActivity, g gVar, String str, BaseSubscriber<Boolean> baseSubscriber) {
        if (!r.x().X()) {
            UserCenterRemoteDataSource.A().requestLicenseState(str, true).compose(RxJavaHelper.t(gVar)).subscribe(new a(baseSubscriber, fragmentActivity, gVar, str));
        } else {
            baseSubscriber.onNext(Boolean.TRUE);
        }
    }
}
