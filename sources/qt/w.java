package qt;

import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import gs.g;
import java.util.HashMap;

public class w {
    public static void a() {
        g.i("App_trade_setup_helpcenter_click", (HashMap) null);
    }

    public static void b() {
        g.i("App_trade_setup_click", (HashMap) null);
    }

    public static void c() {
        g.i("App_trade_setup_beginnerguide_click", (HashMap) null);
    }

    public static void d() {
        g.i("App_trade_setup_favories_click", (HashMap) null);
    }

    public static void e() {
        g.i("App_trade_setup_orderPopup_click", (HashMap) null);
    }

    public static void f() {
        g.i("App_trade_setup_questionnaire_click", (HashMap) null);
    }

    public static void g(int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("page_id", i11 + "");
        g.i("App_trade_beginnerguide_show", hashMap);
    }

    public static void h(int i11) {
        HashMap hashMap = new HashMap(1);
        if (i11 == 1) {
            hashMap.put("TradeType_id", "margin");
        } else {
            hashMap.put("TradeType_id", RankScreenBean.SCREEN_VALUE_SPOT);
        }
        g.i("App_trade_setup_orderPopup_click", hashMap);
    }

    public static void i() {
        g.i("App_trade_setup_orderPopup_show", (HashMap) null);
    }
}
