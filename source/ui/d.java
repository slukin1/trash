package ui;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.compliance.ComplianceService;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.c1;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Map;
import pro.huobi.R;
import tg.r;
import tq.p;
import u6.g;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f47936a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f47937b;

    public class a extends BaseSubscriber<Integer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f47938b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f47939c;

        public a(FragmentActivity fragmentActivity, g gVar) {
            this.f47938b = fragmentActivity;
            this.f47939c = gVar;
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            if (num.intValue() == 1) {
                d.n(this.f47938b, this.f47939c);
            }
        }
    }

    public class b extends BaseSubscriber<UserKycInfoNew> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f47940b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f47941c;

        public b(FragmentActivity fragmentActivity, g gVar) {
            this.f47940b = fragmentActivity;
            this.f47941c = gVar;
        }

        /* renamed from: a */
        public void onNext(UserKycInfoNew userKycInfoNew) {
            super.onNext(userKycInfoNew);
            Map<Object, String> auth_country = userKycInfoNew.getUser_info().getAuth_country();
            if (auth_country.containsKey("2")) {
                if (String.valueOf(183).equals(auth_country.get("2"))) {
                    d.f(this.f47940b, this.f47941c);
                }
            } else if (auth_country.containsKey("1")) {
                if (String.valueOf(183).equals(auth_country.get("1"))) {
                    d.f(this.f47940b, this.f47941c);
                }
            }
        }
    }

    public class c extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f47942b;

        public c(FragmentActivity fragmentActivity) {
            this.f47942b = fragmentActivity;
        }

        public void onStart() {
            super.onStart();
            r x11 = r.x();
            x11.m("old clearUserLoginInfo method t - [" + Thread.currentThread().getName() + "]", true);
            Intent h11 = k0.h(this.f47942b);
            rn.c.i().d(this.f47942b, new JumpTarget(h11, h11));
        }
    }

    public static void f(FragmentActivity fragmentActivity, g gVar) {
        ((ComplianceService) p.C(ComplianceService.class)).getLimitCode().compose(p.D()).compose(RxJavaHelper.t(gVar)).subscribe(new a(fragmentActivity, gVar));
    }

    public static void g(FragmentActivity fragmentActivity, g gVar) {
        KycProxy.l().i(true).compose(RxJavaHelper.s()).subscribe(new b(fragmentActivity, gVar));
    }

    public static boolean h() {
        return f47937b;
    }

    public static /* synthetic */ void i(g gVar, FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        rn.c.i().t().compose(RxJavaHelper.t(gVar)).subscribe(new c(fragmentActivity));
        hBDialogFragment.dismiss();
        f47937b = false;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void k(FragmentActivity fragmentActivity, View view) {
        HBBaseWebActivity.showWebView(fragmentActivity, c1.l(), (String) null, (String) null, false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void l(boolean z11) {
        f47936a = z11;
    }

    public static void m(FragmentActivity fragmentActivity, g gVar) {
        if (r.x().F0()) {
            if (r.x().R()) {
                f(fragmentActivity, gVar);
            } else {
                g(fragmentActivity, gVar);
            }
        }
    }

    public static void n(FragmentActivity fragmentActivity, g gVar) {
        if (!f47936a) {
            f47936a = true;
            HBDialogFragment j02 = new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getString(R.string.compliance_usa_title)).d1(true).C0(fragmentActivity.getString(R.string.compliance_usa_content)).P0(fragmentActivity.getString(R.string.compliance_usa_to_know)).q0(false).Q0(new c(gVar, fragmentActivity)).N0(new b(fragmentActivity)).j0();
            j02.show(fragmentActivity.getSupportFragmentManager(), "");
            f47937b = true;
            j02.xh(R.id.dialog_third_title, new a(fragmentActivity));
        }
    }
}
