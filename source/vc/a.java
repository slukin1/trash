package vc;

import android.app.Activity;
import android.content.Context;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.exchange.grid.presenter.GridTradePresenter;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import java.util.Map;
import rx.Observable;

public interface a {
    boolean a();

    boolean b();

    void c(Context context);

    void d(String str, Map<String, Object> map, String str2);

    void e(Context context);

    Observable<Map<String, String>> f();

    Observable<Object> g();

    void h(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    String i(String str);

    void j(Activity activity);

    void k(Context context);

    void l(String str, String str2, Map<String, Object> map);

    String m();

    Observable<TradeRiskReminder> n(boolean z11);

    BaseDialogFragment o(boolean z11, Context context, GridTradePresenter.i iVar, String str, BaseDialogFragment baseDialogFragment, String str2, wc.a aVar);

    void p(Context context, String str);

    void q(Context context);
}
