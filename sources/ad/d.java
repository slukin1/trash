package ad;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.exchange.R$string;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import oa.a;
import rx.Observable;
import rx.schedulers.Schedulers;
import vc.b;
import yc.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static TradeRiskReminder f19356a;

    public static boolean b() {
        TradeRiskReminder tradeRiskReminder = f19356a;
        return tradeRiskReminder != null && "1".equals(tradeRiskReminder.getState());
    }

    public static boolean c() {
        return c.e();
    }

    public static void e(Context context) {
        b.a().q(context);
    }

    public static void f(Context context) {
        if (b.a().b()) {
            FragmentActivity fragmentActivity = (FragmentActivity) a.g().b();
            new DialogUtils.b.d(fragmentActivity).c1(context.getString(R$string.n_option_delivery_tip)).C0(context.getString(R$string.n_grid_strategy_switch_to_main_account)).P0(context.getString(R$string.n_known)).Q0(b.f3517a).k0().show(fragmentActivity.getSupportFragmentManager(), "");
            return;
        }
        HbgRouter.h(context, "/trade/gridReminder");
    }

    public static Observable<TradeRiskReminder> g() {
        return Observable.zip(b.a().n(false).subscribeOn(Schedulers.io()), c.c(false).subscribeOn(Schedulers.io()), c.f3518b);
    }
}
