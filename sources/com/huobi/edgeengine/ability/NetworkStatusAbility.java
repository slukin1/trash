package com.huobi.edgeengine.ability;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.hbg.lib.common.BaseApplication;
import com.huobi.edgeengine.ability.AbilityFunction;
import i6.d;
import kotlin.jvm.internal.r;
import rj.b;

public final class NetworkStatusAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43894a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        try {
            d.c("networkStatus", "NetworkStatusAbility call result= " + obj);
            if (StringsKt__StringsJVMKt.w((String) obj, "vpn", true)) {
                boolean b11 = b();
                d.c("networkStatus", "NetworkStatusAbility call vpnStatus= " + b11);
                if (aVar != null) {
                    aVar.a(true, Boolean.valueOf(b11));
                }
            }
        } catch (Throwable th2) {
            d.g(th2);
            if (aVar != null) {
                aVar.a(false, String.valueOf(obj));
            }
        }
    }

    public final boolean b() {
        NetworkInfo networkInfo;
        Application b11 = BaseApplication.b();
        if (b11 == null || (networkInfo = ((ConnectivityManager) b11.getSystemService("connectivity")).getNetworkInfo(17)) == null) {
            return false;
        }
        return networkInfo.isConnected();
    }
}
