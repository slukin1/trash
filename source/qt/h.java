package qt;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import gs.g;
import java.util.HashMap;

public class h {

    /* renamed from: e  reason: collision with root package name */
    public static final h f84699e = new h();

    /* renamed from: a  reason: collision with root package name */
    public String f84700a;

    /* renamed from: b  reason: collision with root package name */
    public int f84701b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f84702c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f84703d = -1;

    public static h b() {
        return f84699e;
    }

    public String a() {
        return this.f84700a;
    }

    public String c() {
        int i11 = this.f84702c;
        if (i11 == 0) {
            return "balances";
        }
        if (i11 == 1) {
            return "openorders";
        }
        return i11 == 2 ? "ordershistory" : "balances";
    }

    public String d() {
        int i11 = this.f84701b;
        if (i11 == 1) {
            return RankScreenBean.SCREEN_VALUE_SPOT;
        }
        if (i11 == 2) {
            return FutureContractInfo.MARGIN_CROSS;
        }
        return i11 == 3 ? "lsolated" : RankScreenBean.SCREEN_VALUE_SPOT;
    }

    public void e() {
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", a());
        hashMap.put("targe_tab_name", d());
        hashMap.put("targe_slctab_name", c());
        g.i("App_targe_slctab_more_click", hashMap);
    }

    public void f() {
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", a());
        hashMap.put("targe_tab_name", d());
        hashMap.put("targe_slctab_name", c());
        hashMap.put("targe_slctab_name", c());
        g.i("App_targe_slctab_click", hashMap);
    }

    public void g(Integer num) {
        this.f84703d = num.intValue();
    }
}
