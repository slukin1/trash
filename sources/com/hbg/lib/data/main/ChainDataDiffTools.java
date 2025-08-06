package com.hbg.lib.data.main;

import com.google.gson.reflect.TypeToken;
import com.hbg.lib.data.main.bean.TimeStampMap;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.response.BigInterfaceResponse;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Type;
import java.util.List;

public class ChainDataDiffTools extends BaseDataDiffTools<ChainInfo> {

    /* renamed from: c  reason: collision with root package name */
    public static final ChainDataDiffTools f68846c = new ChainDataDiffTools();

    /* renamed from: b  reason: collision with root package name */
    public String f68847b;

    public class a extends TypeToken<TimeStampMap<ChainInfo>> {
        public a() {
        }
    }

    public static ChainDataDiffTools r() {
        return f68846c;
    }

    public String d() {
        return "chain";
    }

    public Type e() {
        return new a().getType();
    }

    public d9.a<BigInterfaceResponse<List<ChainInfo>>> i(String str, String str2) {
        return x8.a.a().y(str, str2, (String) null, this.f68847b);
    }

    /* renamed from: s */
    public String h(ChainInfo chainInfo) {
        return chainInfo.getCurrency() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + chainInfo.getChain();
    }

    public ChainDataDiffTools t(String str) {
        this.f68847b = str;
        return this;
    }
}
