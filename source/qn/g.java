package qn;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.kyc.service.KycService;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.tencent.android.tpush.common.Constants;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ g f60065b = new g();

    public final Object call(Object obj) {
        return ((KycService) p.V(KycService.class)).ucLogin(MapParamsBuilder.c().a("method", FirebaseAnalytics.Event.LOGIN).a(Constants.FLAG_TICKET, ((LoginInfoData) obj).getTicket()).b()).compose(p.a0());
    }
}
