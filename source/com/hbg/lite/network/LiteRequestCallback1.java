package com.hbg.lite.network;

import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import i6.k;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import retrofit2.HttpException;

public abstract class LiteRequestCallback1<T> extends RequestCallback1<T> {
    public void a(Throwable th2) {
        if (!(th2 instanceof APIStatusErrorException)) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(th2 + "\n");
            if (stackTrace != null) {
                for (StackTraceElement append : stackTrace) {
                    sb2.append(append);
                    sb2.append("\n");
                }
            }
            k.c(sb2.toString());
        }
    }

    public void onError2(Throwable th2) {
        if ((th2 instanceof SocketTimeoutException) || (th2 instanceof SocketException) || (th2 instanceof TimeoutException) || (th2 instanceof HttpException) || (th2 instanceof UnknownHostException)) {
            HuobiToastUtil.k(BaseApplication.b(), R$string.server_error);
        }
    }

    public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
            HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
        }
    }

    public void onRequestFailure(Throwable th2) {
        if (th2 instanceof APIStatusErrorException) {
            onFailed((APIStatusErrorException) th2);
        } else {
            onError2(th2);
        }
        a(th2);
    }
}
