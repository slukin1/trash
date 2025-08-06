package com.huobi.c2c.util;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import d9.a;
import i6.d;
import jp.l;
import rx.Observable;
import tg.r;
import u6.g;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static int f43033a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f43034b;

    public static void b() {
        f43033a = -1;
        f43034b = null;
    }

    public static a<Boolean> c() {
        if (!r.x().F0()) {
            d.b("C2CLicenseManager-->createRequester-->未登录");
            b();
            return new a<>(Observable.just(Boolean.FALSE));
        } else if (!d()) {
            return new a<>(Observable.zip(UserCenterRemoteDataSource.A().requestLicenseState("C2C", false), l.q(false), m.f43032b));
        } else {
            d.b("C2CLicenseManager-->createRequester-->验证通过");
            return new a<>(Observable.just(Boolean.TRUE));
        }
    }

    public static boolean d() {
        if (!r.x().F0()) {
            b();
            return false;
        } else if ((!r.x().R() || !r.x().V()) && f() && e()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean e() {
        return f43033a == 2;
    }

    public static boolean f() {
        return "1".equals(f43034b);
    }

    public static /* synthetic */ Boolean g(TradeRiskReminder tradeRiskReminder, UserVO userVO) {
        f43034b = tradeRiskReminder.getState();
        f43033a = userVO.getRealBind();
        boolean d11 = d();
        d.b("C2CLicenseManager-->createRequester--> licenseState:" + f43034b + " mRealBind:" + f43033a + " enable:" + d11);
        return Boolean.valueOf(d11);
    }

    public static void h(FragmentActivity fragmentActivity, g gVar) {
        if (!r.x().F0()) {
            b();
        } else if (r.x().R() && r.x().V()) {
            C2CDialogUtil.u(fragmentActivity);
        } else if (!f()) {
            C2CDialogUtil.v(fragmentActivity, gVar, (DialogInterface.OnDismissListener) null);
        } else if (!e()) {
            C2CDialogUtil.t(fragmentActivity, f43033a);
        }
    }
}
