package com.huobi.utils;

import android.net.Uri;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSON;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.HTUpgradeConfig;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.huobi.domain.DomainSwitcher;
import com.huobi.lifecycle.OnBackgroundStatusChangedEvent;
import com.huochat.community.network.domain.DomainTool;
import d7.a1;
import k20.h;
import kotlin.Pair;
import kotlin.l;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import v7.b;

public final class HBHTtoHTXManager {

    /* renamed from: a  reason: collision with root package name */
    public static final HBHTtoHTXManager f83692a;

    /* renamed from: b  reason: collision with root package name */
    public static HTUpgradeConfig f83693b;

    public static final class a extends RequestCallback1<HTUpgradeConfig> {
        /* renamed from: a */
        public void onRequestSuccess(HTUpgradeConfig hTUpgradeConfig) {
            HBHTtoHTXManager.f83692a.j(hTUpgradeConfig);
        }
    }

    static {
        HBHTtoHTXManager hBHTtoHTXManager = new HBHTtoHTXManager();
        f83692a = hBHTtoHTXManager;
        hBHTtoHTXManager.j((HTUpgradeConfig) null);
        EventBus.d().p(hBHTtoHTXManager);
    }

    public final void b() {
        Pair[] pairArr = new Pair[5];
        pairArr[0] = l.a("upDetailCurrency", "htx");
        pairArr[1] = l.a("upgradeCurrency", "ht");
        HTUpgradeConfig hTUpgradeConfig = f83693b;
        HTUpgradeConfig hTUpgradeConfig2 = null;
        if (hTUpgradeConfig == null) {
            hTUpgradeConfig = null;
        }
        pairArr[2] = l.a("upgradeJumpUrl", e(hTUpgradeConfig.getJumpUrl()));
        HTUpgradeConfig hTUpgradeConfig3 = f83693b;
        if (hTUpgradeConfig3 != null) {
            hTUpgradeConfig2 = hTUpgradeConfig3;
        }
        pairArr[3] = l.a("upgradeDetailUrl", e(hTUpgradeConfig2.getUpgradeDetailUrl()));
        pairArr[4] = l.a("upgradeState", Boolean.valueOf(g()));
        SP.w("global", MD5Utils.a("currencyUpdateData"), JSON.toJSONString(MapsKt__MapsKt.l(pairArr)));
    }

    public final void c() {
        b.a().getHTUpgradeConfig().d(new a());
    }

    public final HTUpgradeConfig d() {
        HTUpgradeConfig hTUpgradeConfig = f83693b;
        if (hTUpgradeConfig == null) {
            return null;
        }
        return hTUpgradeConfig;
    }

    public final String e(String str) {
        if (sd.a.c(str)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(DomainTool.DOMAIN_PREFIX + DomainSwitcher.w());
        sb2.append(m6.a.h());
        if (str != null && StringsKt__StringsJVMKt.M(str, "/", false, 2, (Object) null)) {
            str = str != null ? StringsKt__StringsKt.B0(str, 0, 1).toString() : null;
        }
        sb2.append(str);
        return sb2.toString();
    }

    public final boolean f(String str) {
        SymbolBean J = a1.v().J(str, TradeType.PRO);
        if (J != null && StringsKt__StringsJVMKt.w("ht", J.getBaseCurrency(), true) && StringsKt__StringsJVMKt.w(SymbolBean.SUSPEND, J.getState(), true) && g()) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        HTUpgradeConfig hTUpgradeConfig = f83693b;
        if (hTUpgradeConfig == null) {
            hTUpgradeConfig = null;
        }
        return hTUpgradeConfig.isNeedUpdate().booleanValue();
    }

    public final void h() {
        zn.a d11 = zn.a.d();
        HTUpgradeConfig hTUpgradeConfig = f83693b;
        if (hTUpgradeConfig == null) {
            hTUpgradeConfig = null;
        }
        d11.v(Uri.parse(e(hTUpgradeConfig.getUpgradeDetailUrl()))).a().c();
    }

    public final void i() {
        zn.a d11 = zn.a.d();
        HTUpgradeConfig hTUpgradeConfig = f83693b;
        if (hTUpgradeConfig == null) {
            hTUpgradeConfig = null;
        }
        d11.v(Uri.parse(e(hTUpgradeConfig.getJumpUrl()))).a().c();
    }

    public final void j(HTUpgradeConfig hTUpgradeConfig) {
        if (hTUpgradeConfig == null) {
            try {
                String i11 = SP.i("sp_key_config_cache", "");
                if (sd.a.c(i11)) {
                    hTUpgradeConfig = new HTUpgradeConfig();
                } else {
                    hTUpgradeConfig = (HTUpgradeConfig) JSON.parseObject(i11, HTUpgradeConfig.class);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } else {
            SP.s("sp_key_config_cache", JSON.toJSONString(hTUpgradeConfig));
        }
        f83693b = hTUpgradeConfig;
        b();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onBackgroundStatusChanged(OnBackgroundStatusChangedEvent onBackgroundStatusChangedEvent) {
        if (onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.FOREGROUND) {
            c();
        }
    }
}
