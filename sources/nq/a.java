package nq;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.login.bean.JumpTarget;
import com.huobi.quicktrade.order.ui.QuickTradeOrderDialogFragment;
import com.huobi.quicktrade.result.ui.QuickTradeResultDialogFragment;
import com.huobi.quicktrade.trade.ui.QuickTradeDialogFragment;
import com.huobi.store.AppConfigManager;
import com.huobi.utils.HBHTtoHTXManager;
import d7.a1;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import rn.c;
import tg.r;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f84517a;

    public static String a() {
        return b(f84517a);
    }

    public static String b(int i11) {
        return i11 == 0 ? "limit" : i11 == 1 ? PrimeRounds.ROUND_TRADE_MARKET_TYPE : i11 == 2 ? "stoplimit" : "trigger";
    }

    public static int c() {
        return f84517a;
    }

    public static boolean d(String str) {
        SymbolBean J = a1.v().J(str, TradeType.PRO);
        if (J != null) {
            return e(J.getSymbol(), J.getSymbolPartition(), J.getState());
        }
        return false;
    }

    public static boolean e(String str, String str2, String str3) {
        if (AppConfigManager.g(MgtConfigNumber.QUICK_TRADE.number, "isOpen") && !a1.v().p0(str) && !a1.v().S(str) && SymbolBean.ONLINE.equals(str3) && str2 != null && (FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT.equals(str2) || SymbolBean.PIONEER.equals(str2))) {
            return true;
        }
        return false;
    }

    public static void f(int i11) {
        f84517a = i11;
    }

    public static void g(Activity activity, FragmentManager fragmentManager, String str, boolean z11, int i11) {
        if (!r.x().F0()) {
            c.i().d(activity, new JumpTarget((Intent) null, (Intent) null));
        } else {
            QuickTradeDialogFragment.uh(str, z11, i11).show(fragmentManager, "QuickTradeDialogFragment");
        }
    }

    public static void h(Activity activity, FragmentManager fragmentManager, String str, boolean z11) {
        if (!r.x().F0()) {
            c.i().d(activity, new JumpTarget((Intent) null, (Intent) null));
        } else if (!HBHTtoHTXManager.f83692a.f(str)) {
            QuickTradeDialogFragment.th(str, z11).show(fragmentManager, "QuickTradeDialogFragment");
        }
    }

    public static void i(Activity activity, FragmentManager fragmentManager, String str, boolean z11, c6.a aVar) {
        if (!r.x().F0()) {
            c.i().d(activity, new JumpTarget((Intent) null, (Intent) null));
        } else if (!HBHTtoHTXManager.f83692a.f(str)) {
            QuickTradeDialogFragment th2 = QuickTradeDialogFragment.th(str, z11);
            if (aVar != null) {
                th2.vh(aVar);
            }
            th2.show(fragmentManager, "QuickTradeDialogFragment");
        }
    }

    public static void j(Activity activity, FragmentManager fragmentManager, String str) {
        if (!r.x().F0()) {
            c.i().d(activity, new JumpTarget((Intent) null, (Intent) null));
        } else {
            QuickTradeOrderDialogFragment.th(str).show(fragmentManager, "QuickTradeOrderDialogFragment");
        }
    }

    public static void k(FragmentManager fragmentManager, String str, String str2, int i11, c6.a aVar) {
        QuickTradeResultDialogFragment th2 = QuickTradeResultDialogFragment.th(str, str2, i11);
        th2.uh(aVar);
        th2.show(fragmentManager, "QuickTradeResultDialogFragment");
    }
}
