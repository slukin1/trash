package com.huobi.activity;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.huobi.domain.DomainSwitcher;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.AbstractAbility;
import com.huochat.community.network.domain.DomainTool;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import i6.k;
import java.net.InetAddress;
import pro.huobi.R;
import rj.b;
import xg.v;

public class PingAbility extends AbstractAbility {
    /* access modifiers changed from: private */
    public /* synthetic */ void e(String str, b bVar, AbilityFunction.a aVar) {
        String str2;
        String str3;
        String str4;
        try {
            if (TextUtils.equals(RankScreenBean.SCREEN_VALUE_SPOT, str)) {
                String replace = DomainSwitcher.O().replace("/-/x/pro/", "");
                String a11 = MD5Utils.a(replace);
                if (!TextUtils.isEmpty(a11) && a11.length() >= 24) {
                    a11 = a11.substring(8, 24);
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean g11 = g(replace);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (g11) {
                    str4 = a11 + l.f34627b + bVar.d().getString(R.string.network_connect_success) + " " + currentTimeMillis2 + "ms";
                } else {
                    str4 = a11 + l.f34627b + bVar.d().getString(R.string.network_connect_failed);
                }
                f(replace, str4);
                aVar.a(true, str4);
            } else if (TextUtils.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB, str)) {
                String w11 = DomainSwitcher.w();
                String a12 = MD5Utils.a(w11);
                if (!TextUtils.isEmpty(a12) && a12.length() >= 24) {
                    a12 = a12.substring(8, 24);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                boolean g12 = g(w11);
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                if (g12) {
                    str3 = a12 + l.f34627b + bVar.d().getString(R.string.network_connect_success) + " " + currentTimeMillis4 + "ms";
                } else {
                    str3 = a12 + l.f34627b + bVar.d().getString(R.string.network_connect_failed);
                }
                f(w11, str3);
                aVar.a(true, str3);
            } else {
                long currentTimeMillis5 = System.currentTimeMillis();
                boolean g13 = g(str);
                long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
                if (g13) {
                    str2 = bVar.d().getString(R.string.network_connect_success) + " " + currentTimeMillis6 + "ms";
                } else {
                    str2 = bVar.d().getString(R.string.network_connect_failed);
                }
                f(str, str2);
                aVar.a(true, str2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            aVar.a(false, th2.getMessage());
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar != null) {
            new Thread(new v(this, obj.toString(), bVar, aVar)).start();
        }
    }

    public boolean b() {
        return false;
    }

    public boolean d(String str, int i11) {
        try {
            return InetAddress.getByName(str).isReachable(i11);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public final void f(String str, String str2) {
        k.d("PingAbility", "ping url:" + str + " " + str2);
    }

    public final boolean g(String str) {
        if (str.startsWith(DomainTool.DOMAIN_PREFIX)) {
            str = str.substring(8);
        }
        return d(str, 5000);
    }
}
