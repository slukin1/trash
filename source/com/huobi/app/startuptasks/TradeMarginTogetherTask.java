package com.huobi.app.startuptasks;

import com.huobi.trade.helper.x;
import com.tencent.android.tpush.stat.ServiceStat;
import i6.k;
import java.util.HashMap;
import tg.g;

public final class TradeMarginTogetherTask extends BaseAppStartTask {
    public void c() {
        d();
    }

    public final void d() {
        k.o(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, "冷启动");
        g.d(true);
        x.c();
        HashMap hashMap = new HashMap();
        if (x.b()) {
            hashMap.put("exvalue", "1");
        } else {
            hashMap.put("exvalue", "0");
        }
        gs.g.i("Experimental_sign", hashMap);
    }
}
