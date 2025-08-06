package com.hbg.module.contract.helper;

import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.contract.retrofit.service.ContractService;
import com.huobi.contract.entity.ContractLeverrate;
import com.huobi.contract.entity.ContractLightLimitLevel;
import java.util.List;
import java.util.Map;
import rx.Observable;

public class ContractRequestHelper {
    public static Observable<List<ContractLightLimitLevel>> a() {
        return ((ContractService) ContractRetrofit.request(ContractService.class)).contractLightLimitLevel().compose(ContractRetrofit.h());
    }

    public static Observable<ContractLeverrate> b(Map<String, Object> map) {
        return ((ContractService) ContractRetrofit.request(ContractService.class)).getContractLeverrate(map).compose(ContractRetrofit.h());
    }
}
