package com.huobi.account.api;

import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.account.entity.AccountQueryData;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.account.entity.BalanceQueryDataV2;
import com.huobi.account.entity.InviteConfigBean;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface AccountService {
    @GET("v1/back/checkBackCommisionConfigExt")
    Observable<UcIntCodeResponse<InviteConfigBean>> backCommissionConfig(@Query("nationalId") int i11, @Header("HB-PRO-TOKEN") String str);

    @POST("v1/dw/deposit-legal/create")
    Observable<StringStatusResponse<Long>> deposit(@Body Map<String, Object> map);

    @POST("v1/dw/deposit-legal/{deposit-id}/place")
    Observable<StringStatusResponse<Long>> depositPlace(@Path("deposit-id") long j11);

    @GET("v1/account/accounts/{accountId}/balance")
    Observable<StringStatusResponse<BalanceQueryData>> getAccountBalance(@Path("accountId") int i11);

    @GET("v2/account/accounts/{accountId}/balance")
    Observable<StringStatusResponse<BalanceQueryDataV2>> getAccountBalanceV2(@Path("accountId") int i11);

    @GET("v1/hadax/account/accounts/{accountId}/balance")
    Observable<StringStatusResponse<BalanceQueryData>> getAccountHadaxBalance(@Path("accountId") int i11);

    @GET("v1/account/accounts")
    Observable<StringStatusResponse<List<AccountQueryData>>> getAccounts();

    @POST("v1/users/login")
    Observable<StringStatusResponse<ProUserToken>> proLogin(@Body Map<String, Object> map, @Query("ticket") String str);

    @POST("v1/dw/transfer-in/create")
    Observable<StringStatusResponse<Long>> transferInCreate(@Body Map<String, Object> map);

    @POST("v1/dw/transfer-in/{transfer-id}/place")
    Observable<StringStatusResponse<Long>> transferInPlace(@Path("transfer-id") long j11);

    @POST("v1/dw/transfer-out/create")
    Observable<StringStatusResponse<Long>> transferOutCreate(@Body Map<String, Object> map);

    @POST("v1/dw/transfer-out/{transfer-id}/place")
    Observable<StringStatusResponse<Long>> transferOutPlace(@Path("transfer-id") long j11);

    @POST("v1/dw/withdraw-legal/{withdraw-id}/place")
    Observable<StringStatusResponse<Long>> withDrawPlace(@Path("withdraw-id") long j11);

    @POST("v1/dw/withdraw-legal/create")
    Observable<StringStatusResponse<Long>> withdraw(@Body Map<String, Object> map);
}
