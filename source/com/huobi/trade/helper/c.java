package com.huobi.trade.helper;

import android.text.TextUtils;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import gs.g;
import java.util.HashMap;

public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final c f82014e = new c();

    /* renamed from: a  reason: collision with root package name */
    public String f82015a;

    /* renamed from: b  reason: collision with root package name */
    public int f82016b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f82017c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f82018d = -1;

    public static c b() {
        return f82014e;
    }

    public String a() {
        return this.f82015a;
    }

    public String c() {
        int i11 = this.f82017c;
        if (i11 == 0) {
            return "balances";
        }
        if (i11 == 1) {
            return "openorders";
        }
        return i11 == 2 ? "ordershistory" : "balances";
    }

    public String d() {
        int i11 = this.f82016b;
        if (i11 == 1) {
            return RankScreenBean.SCREEN_VALUE_SPOT;
        }
        if (i11 == 2) {
            return FutureContractInfo.MARGIN_CROSS;
        }
        return i11 == 3 ? "lsolated" : RankScreenBean.SCREEN_VALUE_SPOT;
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("coin_id", str);
            g.i("App_targe_slctab_click", hashMap);
        }
    }

    public void f() {
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", a());
        hashMap.put("targe_tab_name", d());
        hashMap.put("targe_slctab_name", c());
        g.i("App_targe_slctab_more_click", hashMap);
    }

    public void g() {
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", a());
        hashMap.put("targe_tab_name", d());
        hashMap.put("targe_slctab_name", c());
        g.i("App_targe_slctab_view", hashMap);
    }

    public void h() {
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", a());
        hashMap.put("targe_tab_name", d());
        hashMap.put("targe_slctab_name", c());
        hashMap.put("targe_slctab_name", c());
        g.i("App_targe_slctab_click", hashMap);
    }

    public void i(String str) {
        this.f82015a = str;
    }

    public void j(Integer num) {
        this.f82017c = num.intValue();
    }

    public void k(Integer num) {
        this.f82016b = num.intValue();
    }

    public void l(Integer num) {
        this.f82018d = num.intValue();
    }
}
