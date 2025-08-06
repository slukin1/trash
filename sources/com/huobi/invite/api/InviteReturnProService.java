package com.huobi.invite.api;

import com.hbg.lib.core.network.response.StringStatusResponse;
import com.huobi.invite.bean.InviteReturnRank;
import com.huobi.invite.bean.InviteReturnRecordListItem;
import com.huobi.invite.bean.InviteReturnSum;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface InviteReturnProService {
    @POST("v1/brokerage/rank")
    Observable<StringStatusResponse<InviteReturnRank>> getInviteReturnRank(@Body Map<String, Object> map);

    @GET("v1/brokerage/sum")
    Observable<StringStatusResponse<InviteReturnSum>> getInviteReturnSum();

    @GET("v1/brokerage/orders")
    Observable<StringStatusResponse<List<InviteReturnRecordListItem>>> getReturnRecordList(@QueryMap Map<String, Object> map);
}
