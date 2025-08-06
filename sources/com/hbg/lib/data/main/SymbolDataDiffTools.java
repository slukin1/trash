package com.hbg.lib.data.main;

import com.google.gson.reflect.TypeToken;
import com.hbg.lib.data.main.bean.TimeStampMap;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.response.BigInterfaceResponse;
import java.lang.reflect.Type;
import java.util.List;

public class SymbolDataDiffTools extends BaseDataDiffTools<SymbolBean> {

    /* renamed from: b  reason: collision with root package name */
    public static final SymbolDataDiffTools f68851b = new SymbolDataDiffTools();

    public class a extends TypeToken<TimeStampMap<SymbolBean>> {
        public a() {
        }
    }

    public static SymbolDataDiffTools r() {
        return f68851b;
    }

    public String d() {
        return "symbol";
    }

    public Type e() {
        return new a().getType();
    }

    public d9.a<BigInterfaceResponse<List<SymbolBean>>> i(String str, String str2) {
        return x8.a.a().C(str);
    }

    /* renamed from: s */
    public String h(SymbolBean symbolBean) {
        return symbolBean.getSymbol();
    }
}
