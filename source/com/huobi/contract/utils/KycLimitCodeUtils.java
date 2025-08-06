package com.huobi.contract.utils;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import u6.g;

public final class KycLimitCodeUtils {

    public class a extends EasySubscriber<Object> {
        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public static boolean a(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt > 50100 && parseInt <= 50200;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            return Integer.parseInt(str) > 50000;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static void c() {
        q7.a.a().v("CONTRACT_OPEN_ACCOUNT_ORDER").b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }
}
