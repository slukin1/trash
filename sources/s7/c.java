package s7;

import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.huobi.contract.entity.ContractCancelResult;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class c implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractCancelResult f53429b;

    public /* synthetic */ c(ContractCancelResult contractCancelResult) {
        this.f53429b = contractCancelResult;
    }

    public final void call(Object obj) {
        ContractRetrofit.j(this.f53429b, (Subscriber) obj);
    }
}
