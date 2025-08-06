package bj;

import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.module.contract.service.ContractService;
import rx.functions.Func1;

public final /* synthetic */ class r1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ r1 f12488b = new r1();

    public final Object call(Object obj) {
        return ((ContractService) ContractRetrofit.request(ContractService.class)).getContractOpenCountInfo();
    }
}
