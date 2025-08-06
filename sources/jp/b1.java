package jp;

import ad.b;
import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huobi.otc.persenter.OtcTradePresenter;
import java.util.ArrayList;
import java.util.List;
import q6.d;
import rx.Observable;
import s8.a;
import u6.g;

public final class b1 {

    /* renamed from: d  reason: collision with root package name */
    public static final b1 f84319d = new b1();

    /* renamed from: e  reason: collision with root package name */
    public static boolean f84320e;

    /* renamed from: a  reason: collision with root package name */
    public int f84321a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f84322b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f84323c;

    public b1() {
        ArrayList arrayList = new ArrayList();
        this.f84323c = arrayList;
        arrayList.add("/zh-cn/");
        this.f84323c.add("/zh-tw/");
        this.f84323c.add("/en-us/");
        this.f84323c.add("/vi-vi/");
        this.f84323c.add("/ru-ru/");
        this.f84323c.add("/tr-tr/");
        this.f84323c.add("/pt-br/");
        this.f84323c.add("/ko-kr/");
        this.f84323c.add("/ja-jp/");
        this.f84323c.add("/es-es/");
        this.f84323c.add("/es-la/");
        this.f84323c.add("/it-it/");
    }

    public static b1 h() {
        return f84319d;
    }

    public static /* synthetic */ void m(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        f0.a().e(fragmentActivity);
    }

    public static /* synthetic */ void n(FragmentActivity fragmentActivity, Boolean bool) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            DialogUtils.b0(fragmentActivity, fragmentActivity.getString(R$string.n_option_delivery_tip), fragmentActivity.getString(R$string.n_otc_advert_need_auth), "", fragmentActivity.getString(R$string.n_cancel), fragmentActivity.getString(R$string.n_otc_go_verification), b.f3517a, new w0(fragmentActivity));
        } else if (fragmentActivity instanceof OtcTradePresenter.i) {
            ((OtcTradePresenter.i) fragmentActivity).Zd();
        }
    }

    public static void q(boolean z11) {
        f84320e = z11;
    }

    public void f() {
        int i11 = this.f84321a == 1 ? 0 : 1;
        this.f84321a = i11;
        this.f84322b = true;
        ConfigPreferences.k("otc_config", "otc_trade_page_mode", i11);
    }

    public Observable<Boolean> g(Activity activity) {
        if (OtcModuleConfig.a().a()) {
            return a.a().functionAvailable(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC).b().map(a1.f55995b);
        }
        OtcModuleConfig.a().l(activity, (Intent) null, (Intent) null);
        return Observable.just(null);
    }

    public List<String> i() {
        return this.f84323c;
    }

    public boolean j() {
        if (!this.f84322b) {
            this.f84322b = true;
            this.f84321a = ConfigPreferences.g("otc_config", "otc_trade_page_mode", 0);
        }
        if (this.f84321a == 1) {
            return true;
        }
        return false;
    }

    public void k(FragmentActivity fragmentActivity, g gVar) {
        if (!OtcModuleConfig.a().a()) {
            OtcModuleConfig.a().l(fragmentActivity, (Intent) null, (Intent) null);
        } else {
            h().g(fragmentActivity).compose(RxJavaHelper.t(gVar)).subscribe(new d(gVar, new x0(fragmentActivity), y0.f56094b, z0.f56097b));
        }
    }
}
