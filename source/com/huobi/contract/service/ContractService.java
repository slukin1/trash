package com.huobi.contract.service;

import com.hbg.lib.network.contract.core.response.ContractStatusResponse;
import com.huobi.contract.entity.ContractAccountInfo;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface ContractService {
    @POST("contract-order/x/v1/contract_account_info")
    Observable<ContractStatusResponse<List<ContractAccountInfo>>> getAccountInfo(@Body Map<String, Object> map);
}
