package com.huochat.community.network.service;

import com.huochat.community.model.CommentsResultBean;
import com.huochat.community.model.CommonNetResponse;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.model.CommunityResultBean;
import com.huochat.community.model.TopicDetailBean;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface CommunityService {
    @GET("/community/global/comment/getMomentCommentList")
    Observable<CommonNetResponse<CommentsResultBean>> getCommunityCommentList(@QueryMap Map<String, Object> map);

    @GET("/community/global/moment/getMomentDetail")
    Observable<CommonNetResponse<CommunityItemBean>> getCommunityDynamicDetail(@QueryMap Map<String, Object> map);

    @GET("/community/global/moment/getMomentListByCommunity")
    Observable<CommonNetResponse<CommunityResultBean>> getCommunityListbySymbol(@QueryMap Map<String, Object> map);

    @GET("/community/global/topic/getMomentListByTopic")
    Observable<CommonNetResponse<TopicDetailBean>> getMomentListByTopic(@QueryMap Map<String, Object> map);
}
