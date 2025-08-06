package com.hbg.lib.network.linear.swap.retrofit;

import c9.b;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCancelAllResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderErrorInfo;
import com.hbg.lib.network.linear.swap.core.response.LinearSwapStatusResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import java.util.List;
import k8.c;
import k8.d;
import rx.Observable;
import rx.Subscriber;

public class LinearSwapRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LinearSwapRetrofit f70344a = new LinearSwapRetrofit();
    }

    public static LinearSwapRetrofit g() {
        return a.f70344a;
    }

    public static /* synthetic */ void h(LinearSwapCancelAllResult linearSwapCancelAllResult, Subscriber subscriber) {
        subscriber.onStart();
        if (linearSwapCancelAllResult == null) {
            subscriber.onError(new NullResponseException());
        } else if (linearSwapCancelAllResult.getErrors() == null || linearSwapCancelAllResult.getErrors().isEmpty()) {
            subscriber.onNext(linearSwapCancelAllResult.getSucccess());
            subscriber.onCompleted();
        } else {
            LinearSwapOrderErrorInfo linearSwapOrderErrorInfo = linearSwapCancelAllResult.getErrors().get(0);
            subscriber.onError(new APIStatusErrorException(String.valueOf(linearSwapOrderErrorInfo.getErrCode()), linearSwapOrderErrorInfo.getErrMsg()));
        }
    }

    public static /* synthetic */ void k(LinearSwapStatusResponse linearSwapStatusResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (linearSwapStatusResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (linearSwapStatusResponse.isSuccess()) {
            subscriber.onNext(linearSwapStatusResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(linearSwapStatusResponse.getErrCode(), linearSwapStatusResponse.getErrMsg()));
        }
    }

    public static Observable.Transformer<LinearSwapCancelAllResult, List<Integer>> n() {
        return c.f56554b;
    }

    public static <T> Observable.Transformer<LinearSwapStatusResponse<T>, T> o() {
        return d.f56555b;
    }

    public static <T> T request(Class<T> cls) {
        return g().doRequest(cls);
    }
}
