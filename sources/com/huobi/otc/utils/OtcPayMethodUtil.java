package com.huobi.otc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.module.otc.OtcModuleConfig;
import jp.f0;
import rx.Observable;
import u6.g;
import up.e;

public class OtcPayMethodUtil {
    public static Observable<UserKycInfoNew> b(boolean z11, g gVar) {
        return OtcModuleConfig.a().G(z11, gVar);
    }

    public static Observable<UserVO> c(boolean z11, g gVar) {
        return Observable.zip(d(z11, gVar), b(z11, gVar), e.f60905b);
    }

    public static Observable<UserVO> d(boolean z11, g gVar) {
        return OtcModuleConfig.a().X(false).compose(RxJavaHelper.t(gVar));
    }

    public static void e(Context context) {
        OtcModuleConfig.b().e(context, new Intent());
    }

    public static void f(Context context) {
        if (context != null) {
            if (!OtcModuleConfig.a().a()) {
                OtcModuleConfig.a().l((Activity) context, (Intent) null, (Intent) null);
            } else {
                f0.a().e(context);
            }
        }
    }

    public static /* synthetic */ UserVO g(UserVO userVO, UserKycInfoNew userKycInfoNew) {
        return userVO;
    }
}
