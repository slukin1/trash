package jp;

import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.tencent.android.tpush.common.Constants;
import rx.functions.Func1;
import s8.a;

public final /* synthetic */ class o0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ o0 f56044b = new o0();

    public final Object call(Object obj) {
        return a.a().getTicket(MapParamsBuilder.c().a("type", "PRO_APP").a(Constants.FLAG_TICKET, (String) obj).b()).b();
    }
}
