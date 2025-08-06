package jp;

import android.text.TextUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean;
import com.huobi.otc.enums.TradeBusinessEnum;
import com.huobi.utils.GsonHelper;
import java.io.IOException;
import java.util.List;

public final class c1 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c1 f84324c = new c1();

    /* renamed from: a  reason: collision with root package name */
    public QuickTradeConfigBean f84325a;

    /* renamed from: b  reason: collision with root package name */
    public QuickTradeConfigBean f84326b;

    public c1() {
        try {
            n("express_config.json");
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public static c1 h() {
        if (f84324c == null) {
            synchronized (c1.class) {
                if (f84324c == null) {
                    f84324c = new c1();
                }
            }
        }
        return f84324c;
    }

    public boolean a(TradeBusinessEnum tradeBusinessEnum, String str) {
        QuickTradeConfigBean e11;
        if (!(TextUtils.isEmpty(str) || (e11 = e(tradeBusinessEnum)) == null || e11.getVirtualAsset() == null)) {
            for (QuickTradeConfigBean.Asset name : e11.getVirtualAsset()) {
                if (TextUtils.equals(str.toUpperCase(), name.getName().toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean b(TradeBusinessEnum tradeBusinessEnum, String str) {
        QuickTradeConfigBean e11 = e(tradeBusinessEnum);
        if (e11 == null || e11.getFiatAsset() == null) {
            return false;
        }
        for (QuickTradeConfigBean.Asset name : e11.getFiatAsset()) {
            if (TextUtils.equals(str.toUpperCase(), name.getName().toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public List<QuickTradeConfigBean.Payment> c(TradeBusinessEnum tradeBusinessEnum) {
        QuickTradeConfigBean e11 = e(tradeBusinessEnum);
        if (e11 != null) {
            return e11.getPayment();
        }
        return null;
    }

    public String d() {
        QuickTradeConfigBean quickTradeConfigBean = this.f84325a;
        return (quickTradeConfigBean == null || TextUtils.isEmpty(quickTradeConfigBean.getCdnHost())) ? "" : this.f84325a.getCdnHost();
    }

    public final QuickTradeConfigBean e(TradeBusinessEnum tradeBusinessEnum) {
        if (tradeBusinessEnum == TradeBusinessEnum.THIRD) {
            return this.f84326b;
        }
        return this.f84325a;
    }

    public QuickTradeConfigBean f(TradeBusinessEnum tradeBusinessEnum) {
        return e(tradeBusinessEnum);
    }

    public String g(TradeBusinessEnum tradeBusinessEnum, String str) {
        QuickTradeConfigBean e11;
        if (!(TextUtils.isEmpty(str) || (e11 = e(tradeBusinessEnum)) == null || e11.getVirtualAsset() == null)) {
            for (QuickTradeConfigBean.Asset next : e11.getVirtualAsset()) {
                if (str.equalsIgnoreCase(next.getName())) {
                    return next.getFullName();
                }
            }
        }
        return "";
    }

    public String i(TradeBusinessEnum tradeBusinessEnum, String str) {
        QuickTradeConfigBean e11 = e(tradeBusinessEnum);
        if (CollectionsUtils.b(e11.getPayment())) {
            return "";
        }
        for (QuickTradeConfigBean.Payment next : e11.getPayment()) {
            if (TextUtils.equals(str, next.getCode())) {
                return next.getColor();
            }
        }
        return "";
    }

    public String j(TradeBusinessEnum tradeBusinessEnum, String str) {
        QuickTradeConfigBean e11 = e(tradeBusinessEnum);
        if (CollectionsUtils.b(e11.getPayment())) {
            return "";
        }
        for (QuickTradeConfigBean.Payment next : e11.getPayment()) {
            if (TextUtils.equals(str, next.getCode())) {
                return next.getName();
            }
        }
        return "";
    }

    public String k(String str) {
        return "USD".equalsIgnoreCase(str) ? "USD01" : str;
    }

    public String l(TradeBusinessEnum tradeBusinessEnum, String str) {
        QuickTradeConfigBean e11 = e(tradeBusinessEnum);
        if (TextUtils.isEmpty(str) || e11 == null || CollectionsUtils.b(e11.getFiatAsset())) {
            return "";
        }
        for (QuickTradeConfigBean.Asset next : e11.getFiatAsset()) {
            if (str.equalsIgnoreCase(next.getName())) {
                return next.getSymbol();
            }
        }
        return "";
    }

    public void m(QuickTradeConfigBean quickTradeConfigBean) {
        if (quickTradeConfigBean != null) {
            this.f84325a = quickTradeConfigBean;
            ConfigPreferences.m("otc_config", "expressConfigKey", GsonHelper.a().toJson((Object) quickTradeConfigBean));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "otc_config"
            java.lang.String r1 = "expressConfigKey"
            java.lang.String r0 = com.hbg.lib.core.util.ConfigPreferences.d(r0, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x001b
            com.google.gson.Gson r1 = com.huobi.utils.GsonHelper.a()
            java.lang.Class<com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean> r2 = com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean.class
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, r2)
            com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean r0 = (com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean) r0
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 != 0) goto L_0x0049
            ra.d r1 = ra.c.c()
            android.app.Application r1 = r1.s()
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.AssetManager r1 = r1.getAssets()
            java.io.InputStream r4 = r1.open(r4)
            java.lang.String r4 = com.hbg.lib.common.utils.FileUtil.k(r4)
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L_0x0049
            com.google.gson.Gson r0 = com.huobi.utils.GsonHelper.a()
            java.lang.Class<com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean> r1 = com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean.class
            java.lang.Object r4 = r0.fromJson((java.lang.String) r4, r1)
            r0 = r4
            com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean r0 = (com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean) r0
        L_0x0049:
            r3.f84325a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.c1.n(java.lang.String):void");
    }
}
