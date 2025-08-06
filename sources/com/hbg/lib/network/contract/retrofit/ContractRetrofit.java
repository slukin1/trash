package com.hbg.lib.network.contract.retrofit;

import c9.b;
import com.hbg.lib.network.contract.core.response.ContractStatusResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import com.huobi.contract.entity.ContractCancelResult;
import com.huobi.contract.entity.ContractOrderErrorInfo;
import java.util.List;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;
import s7.d;
import s7.e;

public class ContractRetrofit extends c9.a<b> {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static ContractRetrofit f69239a = new ContractRetrofit();
    }

    public static Observable.Transformer<ContractCancelResult, List<Integer>> g() {
        return d.f53430b;
    }

    public static <T> Observable.Transformer<ContractStatusResponse<T>, T> h() {
        return e.f53431b;
    }

    public static ContractRetrofit i() {
        return a.f69239a;
    }

    public static /* synthetic */ void j(ContractCancelResult contractCancelResult, Subscriber subscriber) {
        subscriber.onStart();
        if (contractCancelResult == null) {
            subscriber.onError(new NullResponseException());
        } else if (contractCancelResult.getErrors() == null || contractCancelResult.getErrors().isEmpty()) {
            subscriber.onNext(contractCancelResult.getSucccess());
            subscriber.onCompleted();
        } else {
            ContractOrderErrorInfo contractOrderErrorInfo = contractCancelResult.getErrors().get(0);
            subscriber.onError(new APIStatusErrorException(String.valueOf(contractOrderErrorInfo.getErrCode()), contractOrderErrorInfo.getErrMsg()));
        }
    }

    public static /* synthetic */ void m(ContractStatusResponse contractStatusResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (contractStatusResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (contractStatusResponse.isSuccess()) {
            subscriber.onNext(contractStatusResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(contractStatusResponse.getErrCode(), contractStatusResponse.getErrMsg()));
        }
    }

    public static <T> T request(Class<T> cls) {
        return i().doRequest(cls);
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }
}
