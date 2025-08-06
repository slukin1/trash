package com.huobi.ipdetecter;

import com.google.gson.JsonObject;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

public interface IpDetecterService {
    @GET
    Observable<JsonObject> getIpInfo(@Url String str);
}
