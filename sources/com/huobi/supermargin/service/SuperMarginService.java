package com.huobi.supermargin.service;

import com.hbg.lib.core.network.response.StringStatusResponse;
import com.huobi.finance.bean.TransferOrderHistory;
import com.huobi.supermargin.bean.LoanCurrency;
import com.huobi.supermargin.bean.LoanRepay;
import com.huobi.supermargin.bean.MarginCurrency;
import com.huobi.supermargin.bean.MarginLoanAsset;
import com.huobi.supermargin.bean.MarginOverview;
import com.huobi.supermargin.bean.RepayCurrency;
import com.huobi.supermargin.bean.TransferOutQuota;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface SuperMarginService {
    @GET("v1/hbg/super-margin/check-white-list-user")
    Observable<StringStatusResponse<Boolean>> checkWhiteListUser();

    @GET("v1/hbg/super-margin/loan-currencies")
    Observable<StringStatusResponse<List<LoanCurrency>>> getLoanCurrencies(@QueryMap Map<String, Object> map);

    @GET("v1/hbg/super-margin/margin-loan-asset2")
    Observable<StringStatusResponse<List<MarginLoanAsset>>> getMarginLoanAsset(@Query("account-id") long j11, @Query("currencies") String str);

    @GET("v1/hbg/super-margin/margin-overview")
    Observable<StringStatusResponse<MarginOverview>> getMarginOverview(@Query("account-id") long j11);

    @POST("v1/hbg/super-margin/loan")
    Observable<StringStatusResponse<Object>> loan(@Body Map<String, Object> map);

    @GET("v1/hbg/super-margin/loan-repay-detail")
    Observable<StringStatusResponse<LoanRepay>> loanRepayDetail(@QueryMap Map<String, Object> map);

    @GET("v1/hbg/super-margin/loan-repay-record")
    Observable<StringStatusResponse<List<TransferOrderHistory>>> loanRepayRecord(@QueryMap Map<String, Object> map);

    @GET("v1/hbg/super-margin/margin-currencies")
    Observable<StringStatusResponse<List<MarginCurrency>>> marginCurrencies();

    @POST("v1/hbg/super-margin/margin-transfer")
    Observable<StringStatusResponse<Object>> marginTransfer(@Body Map<String, Object> map);

    @POST("v1/hbg/super-margin/repay")
    Observable<StringStatusResponse<Object>> repay(@Body Map<String, Object> map);

    @GET("v1/hbg/super-margin/repay-currencies")
    Observable<StringStatusResponse<List<RepayCurrency>>> repayCurrencies(@QueryMap Map<String, Object> map);

    @GET("v1/hbg/super-margin/transfer-out-quota")
    Observable<StringStatusResponse<TransferOutQuota>> transferOutQuota(@Query("currency") String str);
}
