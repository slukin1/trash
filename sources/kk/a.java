package kk;

import com.huobi.etf.service.EtfService;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a f56584b = new a();

    public final Object call(Object obj) {
        return ((EtfService) p.A(EtfService.class)).getEtfToken(((LoginInfoData) obj).getTicket());
    }
}
