package com.huobi.otc.helper;

import android.text.TextUtils;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.ui.OtcTradeActivity;
import com.tencent.android.tpush.common.Constants;
import jp.m0;
import jp.n0;
import jp.o0;
import jp.p0;
import nb.g;
import qu.d;
import rx.Observable;
import s8.a;

public class OtcLoginHelper {
    public static void e() {
        if (d.i().f23318d) {
            g.j().s();
        }
    }

    public static Observable<String[]> f(String str) {
        return OtcModuleConfig.a().n(str).flatMap(new m0(new String[2]));
    }

    public static Observable<String> g() {
        return OtcModuleConfig.a().n("OtcLoginHelper#getTicketObservable").flatMap(o0.f56044b);
    }

    public static /* synthetic */ String h(Throwable th2) {
        return null;
    }

    public static /* synthetic */ String[] i(String[] strArr, String str, String str2) {
        strArr[0] = str2;
        strArr[1] = str;
        return strArr;
    }

    public static /* synthetic */ Observable j(String[] strArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return Observable.just(strArr);
        }
        return a.a().getTicket(MapParamsBuilder.c().a("type", "PRO_APP").a(Constants.FLAG_TICKET, str).b()).b().onErrorReturn(p0.f56048b).map(new n0(strArr, str));
    }

    public static void l(String str) {
        if (d.i().f23318d) {
            if (oa.a.g().f(OtcTradeActivity.class) == null) {
                g.j().t(str, (g.c) null);
            }
            d.i().s(!TextUtils.isEmpty(str));
        }
    }
}
