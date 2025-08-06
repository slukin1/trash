package com.huobi.data;

import com.hbg.lib.data.HbgDataModuleConfig;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import dt.h2;
import java.math.BigDecimal;
import java.util.Map;

public class HbgDataModuleConfigCallbackImpl implements HbgDataModuleConfig.a {
    public Map<String, BigDecimal> a(String str, Map<String, SymbolPrice> map) {
        return h2.t1().s1(str, map);
    }
}
