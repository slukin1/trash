package com.hbg.lib.network.index.retrofit.service;

import com.hbg.lib.network.index.core.IndexStatusResponse;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface IndexService {
    @GET("index/market/overview")
    Observable<IndexStatusResponse<List<SymbolPrice>>> requestIndexOverView(@Query("data") String str);
}
