package qp;

import com.hbg.lib.network.uc.retrofit.UcRetrofit;
import com.hbg.lib.network.uc.retrofit.service.UserCenterService;
import rx.functions.Func1;

public final /* synthetic */ class a0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a0 f60070b = new a0();

    public final Object call(Object obj) {
        return ((UserCenterService) UcRetrofit.request(UserCenterService.class)).requestImgCaptcha().compose(UcRetrofit.h());
    }
}
