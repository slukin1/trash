package s7;

import com.hbg.lib.network.contract.core.response.ContractStatusResponse;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class b implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractStatusResponse f53428b;

    public /* synthetic */ b(ContractStatusResponse contractStatusResponse) {
        this.f53428b = contractStatusResponse;
    }

    public final void call(Object obj) {
        ContractRetrofit.m(this.f53428b, (Subscriber) obj);
    }
}
