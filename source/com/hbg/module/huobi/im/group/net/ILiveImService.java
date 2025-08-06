package com.hbg.module.huobi.im.group.net;

import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.bean.DrawGiftBean;
import com.hbg.module.huobi.im.gift.bean.JackpotBean;
import com.hbg.module.huobi.im.group.bean.ChatBlockEntity;
import com.hbg.module.huobi.im.group.bean.GroupNoticeListEntity;
import com.hbg.module.huobi.im.group.bean.GroupUserForbidStatus;
import com.hbg.module.huobi.im.group.bean.ImGroupChatBean;
import com.hbg.module.huobi.im.group.bean.ImUserSigBean;
import com.hbg.module.huobi.im.group.bean.LiveGroupBean;
import com.hbg.module.huobi.im.group.bean.MessageNoDisturbStatus;
import com.hbg.module.huobi.im.group.bean.UserStatusEntity;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface ILiveImService {
    @POST("v1/content/live/live-group/remove-all-group")
    Observable<HbgIntCodeResponse<Object>> blockUserInGroup(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/watch-time")
    Observable<HbgIntCodeResponse<CusMsgGiftSend>> countWatchTime(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/award/draw")
    Observable<HbgIntCodeResponse<DrawGiftBean>> drawGift(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/im/forbid-in-group")
    Observable<HbgIntCodeResponse<Object>> forbidInGroup(@Body Map<String, Object> map);

    @GET("/-/x/hbg/v1/content/live/live-info/im-group")
    Observable<HbgIntCodeResponse<ImGroupChatBean>> getAllGroupChatList(@HeaderMap Map<String, String> map, @Query("page") int i11, @Query("size") int i12);

    @GET("/-/x/hbg/v1/content/live/chat/black-list")
    Observable<HbgIntCodeResponse<List<ChatBlockEntity>>> getChatBlockList(@HeaderMap Map<String, String> map);

    @GET("/-/x/hbg/v1/content/live/im/is-forbidden")
    Observable<HbgIntCodeResponse<GroupUserForbidStatus>> getForbidStatus(@Query("groupId") String str, @Query("account") String str2);

    @GET("/-/x/hbg/v1/content/live/group-notification/list")
    Observable<HbgIntCodeResponse<GroupNoticeListEntity>> getGroupNoticeList(@Query("groupId") String str);

    @GET("/-/x/hbg/v1/content/live/group-notification/top")
    Observable<HbgIntCodeResponse<GroupNoticeListEntity>> getGroupNoticeTopList(@Query("groupId") String str);

    @GET("/-/x/hbg/v1/content/live/active-jackpot-list")
    Observable<HbgIntCodeResponse<List<JackpotBean>>> getJackpotList(@Query("liveId") String str);

    @GET("/-/x/hbg/v1/content/live/live-info/detail-by-group")
    Observable<HbgIntCodeResponse<LiveGroupBean>> getLiveDetailByGroup(@Query("groupId") String str);

    @GET("/-/x/hbg/v1/content/live/live-info/im-group-joined")
    Observable<HbgIntCodeResponse<ImGroupChatBean>> getMyGroupChatList(@HeaderMap Map<String, String> map);

    @GET("v1/content/live/chat/freeRelation/get")
    Observable<HbgIntCodeResponse<MessageNoDisturbStatus>> getNoDisturbStatus(@Query("type") int i11, @Query("toChat") String str);

    @GET("/-/x/hbg/v1/content/live/im/recallable-time")
    Observable<HbgIntCodeResponse<Map<String, Integer>>> getRecallTime();

    @GET("/-/x/hbg/v1/content/live/im/getUserSig")
    Observable<HbgIntCodeResponse<ImUserSigBean>> getUserSig(@HeaderMap Map<String, String> map);

    @GET("/-/x/hbg/v1/content/live/im/status")
    Observable<HbgIntCodeResponse<UserStatusEntity>> getUserStatus(@Query("groupId") String str, @Query("account") String str2, @Query("type") String str3);

    @GET("/-/x/hbg/v1/content/live/im/status")
    Observable<HbgIntCodeResponse<UserStatusEntity>> getUserStatusForC2C(@Query("account") String str, @Query("type") String str2);

    @POST("/-/x/hbg/v1/content/live/group-notification/delete")
    Observable<HbgIntCodeResponse<Object>> groupNoticeDelete(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/group-notification/recommend")
    Observable<HbgIntCodeResponse<Object>> groupNoticeSettingTop(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/live-group/notification-close")
    Observable<HbgIntCodeResponse<Object>> hideGroupNoticeHint(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/group-notification/close")
    Observable<HbgIntCodeResponse<Object>> hideGroupNoticeHintById(@Body Map<String, Object> map);

    @POST("v1/content/live/live-appoint/appoint")
    Observable<HbgIntCodeResponse<LiveAppointmentData>> liveAppointment(@Body Map<String, String> map);

    @POST("v1/content/live/live-appoint/appoint-cancel")
    Observable<HbgIntCodeResponse<LiveAppointmentData>> liveCancelAppointment(@Body Map<String, String> map);

    @POST("/-/x/hbg/v1/content/live/live-msg/recall")
    Observable<HbgIntCodeResponse<Object>> recallInGroup(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/im/recall-msg")
    Observable<HbgIntCodeResponse<Object>> recallInGroupAll(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/live-group/user-remove")
    Observable<HbgIntCodeResponse<Object>> removeUserInGroup(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/live-group/forbid-all")
    Observable<HbgIntCodeResponse<Object>> setGroupAllForbid(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/im/set-manager")
    Observable<HbgIntCodeResponse<Object>> setGroupManager(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/live/live-group/share-status")
    Observable<HbgIntCodeResponse<Object>> setGroupShareContract(@Body Map<String, Object> map);

    @POST("v1/content/live/chat/freeRelation/relation")
    Observable<HbgIntCodeResponse<Object>> updateNoDisturbStatus(@Body Map<String, Object> map);

    @POST("v1/content/live/chat/relation")
    Observable<HbgIntCodeResponse<Object>> updatePersonalRelations(@Body Map<String, Object> map);
}
