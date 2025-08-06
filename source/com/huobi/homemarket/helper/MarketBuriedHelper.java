package com.huobi.homemarket.helper;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import java.util.HashMap;

public final class MarketBuriedHelper {

    /* renamed from: d  reason: collision with root package name */
    public static final MarketBuriedHelper f72724d = new MarketBuriedHelper();

    /* renamed from: a  reason: collision with root package name */
    public MarketBuried f72725a = MarketBuried.OPTIONAL;

    /* renamed from: b  reason: collision with root package name */
    public String f72726b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f72727c = "";

    public enum MarketBuried {
        SQUARE(MessengerShareContentUtility.IMAGE_RATIO_SQUARE),
        OPTIONAL("optional"),
        SPOT(RankScreenBean.SCREEN_VALUE_SPOT),
        CONTRACT("contract"),
        CONTENT("content"),
        COPY_TRADING("copy_trading");
        
        private String valueName;

        private MarketBuried(String str) {
            this.valueName = str;
        }

        public String getValueName() {
            return this.valueName;
        }
    }

    public static MarketBuriedHelper a() {
        return f72724d;
    }

    public void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("markets_list_tab_name", this.f72725a.getValueName());
        BaseModuleConfig.a().w("App_markets_list_maintab_click", hashMap);
    }

    public void c() {
        HashMap hashMap = new HashMap();
        hashMap.put("markets_list_tab_name", this.f72725a.getValueName());
        hashMap.put("markets_list_tab_slc", this.f72727c);
        hashMap.put("markets_list_tab_flc", this.f72726b);
        BaseModuleConfig.a().w("App_markets_list_slctab_click", hashMap);
    }

    public void d() {
        HashMap hashMap = new HashMap();
        hashMap.put("markets_list_tab_name", this.f72725a.getValueName());
        hashMap.put("markets_list_tab_flc", this.f72726b);
        BaseModuleConfig.a().w("App_markets_list_flctab_click", hashMap);
    }

    public void e(String str, String str2) {
        this.f72726b = str;
        this.f72727c = str2;
    }

    public void f(MarketBuried marketBuried) {
        this.f72725a = marketBuried;
    }

    public void g(String str) {
        this.f72727c = str;
    }
}
