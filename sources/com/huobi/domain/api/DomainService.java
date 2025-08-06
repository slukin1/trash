package com.huobi.domain.api;

import com.hbg.lib.core.network.response.ContractStatusResponse;
import com.hbg.lib.core.network.response.IntStatusResponse;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.login.usercenter.data.source.bean.UcAppControl;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Url;
import rx.Observable;

public interface DomainService {
    @GET
    Observable<Response<Void>> globalOtcDomainTest(@Url String str);

    @GET
    @Headers({"group:global_web"})
    Observable<Response<Void>> globalWebDomainTest(@Url String str);

    @GET
    Observable<StringStatusResponse<String>> hadaxDomainTest(@Url String str);

    @GET
    @Headers({"source:android"})
    Observable<ContractStatusResponse<Object>> hbdmDomainTest(@Url String str);

    @GET
    @Headers({"group:kyc_web"})
    Observable<Response<Void>> kycWebDomainTest(@Url String str);

    @GET
    Observable<Response<Void>> mobileDomainTest(@Url String str);

    @GET
    Observable<UcIntCodeResponse<Object>> otcDomainTest(@Url String str, @Header("trace_id") String str2, @Header("request_sniffing") String str3);

    @GET
    Observable<StringStatusResponse<String>> proDomainTest(@Url String str);

    @GET
    Observable<UcIntCodeResponse<UcAppControl>> ucDomainTest(@Url String str);

    @GET
    Observable<IntStatusResponse<Object>> wwwDomainTest(@Url String str);

    @HEAD
    @Headers({"isRemoveCommonHeaders:true"})
    Observable<Response<Void>> zendeskDomainTest(@Url String str);
}
