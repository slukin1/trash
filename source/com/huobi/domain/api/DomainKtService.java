package com.huobi.domain.api;

import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import kotlin.coroutines.c;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface DomainKtService {
    @GET
    Object commonDomainTest(@Url String str, c<? super Response<Void>> cVar);

    @GET
    @Headers({"group:global_web"})
    Object globalWebDomainTest(@Url String str, c<? super Response<Void>> cVar);

    @GET
    @Headers({"source:android"})
    Object hbdmDomainTest(@Url String str, c<? super Response<Void>> cVar);

    @GET
    @Headers({"group:kyc_web"})
    Object kycWebDomainTest(@Url String str, c<? super Response<Void>> cVar);

    @GET
    Object proDomainTest(@Url String str, c<? super HbgIntCodeResponse<String>> cVar);
}
