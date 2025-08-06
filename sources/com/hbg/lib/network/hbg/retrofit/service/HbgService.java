package com.hbg.lib.network.hbg.retrofit.service;

import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.VipLevel;
import com.hbg.lib.network.hbg.core.bean.AccountBalanceInfo;
import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.hbg.lib.network.hbg.core.bean.AccountNftInfoBean;
import com.hbg.lib.network.hbg.core.bean.AccountNpsBean;
import com.hbg.lib.network.hbg.core.bean.AccountRiskInfo;
import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroAvailablePositionBean;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroCreateBean;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroNoticeSureBean;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroPositionNoticeBean;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroPositionProfitInfoBean;
import com.hbg.lib.network.hbg.core.bean.AdConfig;
import com.hbg.lib.network.hbg.core.bean.AirdropDetailBean;
import com.hbg.lib.network.hbg.core.bean.AirdropResultBean;
import com.hbg.lib.network.hbg.core.bean.AppUrlInfo;
import com.hbg.lib.network.hbg.core.bean.AppleHistoryRecordBean;
import com.hbg.lib.network.hbg.core.bean.ApplyListBean;
import com.hbg.lib.network.hbg.core.bean.AssertsTradeData;
import com.hbg.lib.network.hbg.core.bean.AssetAlterCostData;
import com.hbg.lib.network.hbg.core.bean.AssetBannerData;
import com.hbg.lib.network.hbg.core.bean.AssetDailyData;
import com.hbg.lib.network.hbg.core.bean.AssetOptionsInfo;
import com.hbg.lib.network.hbg.core.bean.AssetPositionSpotData;
import com.hbg.lib.network.hbg.core.bean.AssetWhiteListBean;
import com.hbg.lib.network.hbg.core.bean.AttitudeUpdate;
import com.hbg.lib.network.hbg.core.bean.AutoOrderResult;
import com.hbg.lib.network.hbg.core.bean.BSTInfo;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.BenefitListData;
import com.hbg.lib.network.hbg.core.bean.BizShow;
import com.hbg.lib.network.hbg.core.bean.BizTipRecord;
import com.hbg.lib.network.hbg.core.bean.BotRank;
import com.hbg.lib.network.hbg.core.bean.C2CAccountInNetAssetResult;
import com.hbg.lib.network.hbg.core.bean.C2CAccountOutNetAssetResult;
import com.hbg.lib.network.hbg.core.bean.C2CAccountOverviewInfo;
import com.hbg.lib.network.hbg.core.bean.C2CBorrowExpiredStatistics;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import com.hbg.lib.network.hbg.core.bean.C2CLendThresholdGetAssetInfo;
import com.hbg.lib.network.hbg.core.bean.C2CLoanBalanceInfo;
import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.hbg.lib.network.hbg.core.bean.C2CNationalityBlackListInfo;
import com.hbg.lib.network.hbg.core.bean.C2COrderRepayInfo;
import com.hbg.lib.network.hbg.core.bean.C2CSymbolBean;
import com.hbg.lib.network.hbg.core.bean.C2CTransferOutQuotaInfo;
import com.hbg.lib.network.hbg.core.bean.CTAccountBean;
import com.hbg.lib.network.hbg.core.bean.ChatSessionRemove;
import com.hbg.lib.network.hbg.core.bean.CheckInviteCodeResult;
import com.hbg.lib.network.hbg.core.bean.ClearDialogConfig;
import com.hbg.lib.network.hbg.core.bean.CommentDelBean;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.network.hbg.core.bean.CommentPraiseBean;
import com.hbg.lib.network.hbg.core.bean.CommentSaveBean;
import com.hbg.lib.network.hbg.core.bean.CommonPkData;
import com.hbg.lib.network.hbg.core.bean.CommunityData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.CommunitySwitchBean;
import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import com.hbg.lib.network.hbg.core.bean.ContentNavigationInfo;
import com.hbg.lib.network.hbg.core.bean.ContentUGCModel;
import com.hbg.lib.network.hbg.core.bean.ContentUnreadBean;
import com.hbg.lib.network.hbg.core.bean.CopyTradingAccountTransferRecord;
import com.hbg.lib.network.hbg.core.bean.CopyTradingAssetInfo;
import com.hbg.lib.network.hbg.core.bean.CurrencyAsset;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCAuthorizationData;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCKYCLevel;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCRouteChannelData;
import com.hbg.lib.network.hbg.core.bean.CurrencyIntroInfo;
import com.hbg.lib.network.hbg.core.bean.CustomerData;
import com.hbg.lib.network.hbg.core.bean.CustomerInfo;
import com.hbg.lib.network.hbg.core.bean.DeepNewsInfo;
import com.hbg.lib.network.hbg.core.bean.DominicaKycPageInfo;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.lib.network.hbg.core.bean.EquityUserInfo;
import com.hbg.lib.network.hbg.core.bean.EtpAvailableBean;
import com.hbg.lib.network.hbg.core.bean.EtpInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalanceResult;
import com.hbg.lib.network.hbg.core.bean.EtpRiskInfo;
import com.hbg.lib.network.hbg.core.bean.FastNewsUnread;
import com.hbg.lib.network.hbg.core.bean.FiatKycInfo;
import com.hbg.lib.network.hbg.core.bean.FootprintData;
import com.hbg.lib.network.hbg.core.bean.GridAssetItem;
import com.hbg.lib.network.hbg.core.bean.GroupInfoData;
import com.hbg.lib.network.hbg.core.bean.GroupInviteBean;
import com.hbg.lib.network.hbg.core.bean.GroupMemberListInfo;
import com.hbg.lib.network.hbg.core.bean.GroupUserListData;
import com.hbg.lib.network.hbg.core.bean.HBUniAppBizInfo;
import com.hbg.lib.network.hbg.core.bean.HTUpgradeConfig;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import com.hbg.lib.network.hbg.core.bean.HbgRankListInfo;
import com.hbg.lib.network.hbg.core.bean.HbgSymbolPrice;
import com.hbg.lib.network.hbg.core.bean.HomeFeedAd;
import com.hbg.lib.network.hbg.core.bean.HomeFlowConfig;
import com.hbg.lib.network.hbg.core.bean.HomePageData;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;
import com.hbg.lib.network.hbg.core.bean.HomePageInvestData;
import com.hbg.lib.network.hbg.core.bean.HomePageNoticeData;
import com.hbg.lib.network.hbg.core.bean.HotSearchListInfo;
import com.hbg.lib.network.hbg.core.bean.HtExchangeConfig;
import com.hbg.lib.network.hbg.core.bean.HtExchangeConfigData;
import com.hbg.lib.network.hbg.core.bean.HtExchangeHistoryBean;
import com.hbg.lib.network.hbg.core.bean.HtExchangeHistoryDetailBean;
import com.hbg.lib.network.hbg.core.bean.IntegrationDetailSubmitResult;
import com.hbg.lib.network.hbg.core.bean.IntegrationNoticeInfo;
import com.hbg.lib.network.hbg.core.bean.IntegrationQuestionInfo;
import com.hbg.lib.network.hbg.core.bean.IntegrationRiskDescriptionInfo;
import com.hbg.lib.network.hbg.core.bean.InviterInfoBean;
import com.hbg.lib.network.hbg.core.bean.KLineSymbolHistoryBean;
import com.hbg.lib.network.hbg.core.bean.KlineBottomBean;
import com.hbg.lib.network.hbg.core.bean.KlineContractBottomBean;
import com.hbg.lib.network.hbg.core.bean.KlineLabel;
import com.hbg.lib.network.hbg.core.bean.KycInfoSaveInfo;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryData;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryListData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveEndRecommendData;
import com.hbg.lib.network.hbg.core.bean.LiveGiftRank;
import com.hbg.lib.network.hbg.core.bean.LiveGroupUserListData;
import com.hbg.lib.network.hbg.core.bean.LivePraiseCount;
import com.hbg.lib.network.hbg.core.bean.LiveRecommendInfo;
import com.hbg.lib.network.hbg.core.bean.LiveServerMsgBean;
import com.hbg.lib.network.hbg.core.bean.LiveSquareContentData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareSubData;
import com.hbg.lib.network.hbg.core.bean.LiveUserRole;
import com.hbg.lib.network.hbg.core.bean.LiveWiningInfo;
import com.hbg.lib.network.hbg.core.bean.MarketPlateDetail;
import com.hbg.lib.network.hbg.core.bean.MarketRedData;
import com.hbg.lib.network.hbg.core.bean.MaxRateMiningProject;
import com.hbg.lib.network.hbg.core.bean.MedalHomePageShare;
import com.hbg.lib.network.hbg.core.bean.MedalUserInfo;
import com.hbg.lib.network.hbg.core.bean.MemberCountBean;
import com.hbg.lib.network.hbg.core.bean.MgtConfigInfo;
import com.hbg.lib.network.hbg.core.bean.MineAccountItem;
import com.hbg.lib.network.hbg.core.bean.MiningDetailBean;
import com.hbg.lib.network.hbg.core.bean.MiningItem;
import com.hbg.lib.network.hbg.core.bean.MiningMarketInfo;
import com.hbg.lib.network.hbg.core.bean.MiningSwitch;
import com.hbg.lib.network.hbg.core.bean.MyPrimeInfo;
import com.hbg.lib.network.hbg.core.bean.NewBannerBean;
import com.hbg.lib.network.hbg.core.bean.NewFeed;
import com.hbg.lib.network.hbg.core.bean.NewFlashCategory;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationShare;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationVote;
import com.hbg.lib.network.hbg.core.bean.NewUserGuideResult;
import com.hbg.lib.network.hbg.core.bean.NewsInfoResultVO;
import com.hbg.lib.network.hbg.core.bean.NoDisturbData;
import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.hbg.lib.network.hbg.core.bean.OneKeySelectItem;
import com.hbg.lib.network.hbg.core.bean.OtcAuthBean;
import com.hbg.lib.network.hbg.core.bean.OtcAuthJumioBean;
import com.hbg.lib.network.hbg.core.bean.OtcChannelInfo;
import com.hbg.lib.network.hbg.core.bean.OtcKycInfo;
import com.hbg.lib.network.hbg.core.bean.PatchInfo;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.network.hbg.core.bean.PersonalcenterActivityInfoBean;
import com.hbg.lib.network.hbg.core.bean.PioneerActivityLimit;
import com.hbg.lib.network.hbg.core.bean.PledgeAssetContent;
import com.hbg.lib.network.hbg.core.bean.PledgeBalance;
import com.hbg.lib.network.hbg.core.bean.PledgeBean;
import com.hbg.lib.network.hbg.core.bean.PraiseCountBean;
import com.hbg.lib.network.hbg.core.bean.PricingMethodBean;
import com.hbg.lib.network.hbg.core.bean.PrimeBoxDetail;
import com.hbg.lib.network.hbg.core.bean.PrimeKycLimit;
import com.hbg.lib.network.hbg.core.bean.ProRemindListData;
import com.hbg.lib.network.hbg.core.bean.ProfitAndLossData;
import com.hbg.lib.network.hbg.core.bean.ProfitUserInfo;
import com.hbg.lib.network.hbg.core.bean.PushUserSig;
import com.hbg.lib.network.hbg.core.bean.RMSConfig;
import com.hbg.lib.network.hbg.core.bean.RankJumpInfo;
import com.hbg.lib.network.hbg.core.bean.RankList;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.lib.network.hbg.core.bean.RecommendTrader;
import com.hbg.lib.network.hbg.core.bean.RedPacketCollectBean;
import com.hbg.lib.network.hbg.core.bean.RedPacketInfoBean;
import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.hbg.lib.network.hbg.core.bean.RemindFlashBean;
import com.hbg.lib.network.hbg.core.bean.RewardInfo;
import com.hbg.lib.network.hbg.core.bean.S3TokenBean;
import com.hbg.lib.network.hbg.core.bean.SearchCoinListInfo;
import com.hbg.lib.network.hbg.core.bean.SearchLiveGroupUserList;
import com.hbg.lib.network.hbg.core.bean.SecurityGradeDetailBean;
import com.hbg.lib.network.hbg.core.bean.ServerCurDate;
import com.hbg.lib.network.hbg.core.bean.ShareConfig;
import com.hbg.lib.network.hbg.core.bean.ShareGroupList;
import com.hbg.lib.network.hbg.core.bean.ShareNewConfigInfo;
import com.hbg.lib.network.hbg.core.bean.ShareResultBean;
import com.hbg.lib.network.hbg.core.bean.SmartDomainData;
import com.hbg.lib.network.hbg.core.bean.SpotAssertInfo;
import com.hbg.lib.network.hbg.core.bean.SpotConfigInfo;
import com.hbg.lib.network.hbg.core.bean.SpotContractEntryBean;
import com.hbg.lib.network.hbg.core.bean.StareConfigListData;
import com.hbg.lib.network.hbg.core.bean.StareInfo;
import com.hbg.lib.network.hbg.core.bean.StopCurrencyCostBean;
import com.hbg.lib.network.hbg.core.bean.SubscribeAll;
import com.hbg.lib.network.hbg.core.bean.SubscribeBox;
import com.hbg.lib.network.hbg.core.bean.TaskPrizeResp;
import com.hbg.lib.network.hbg.core.bean.TemplateLabelListData;
import com.hbg.lib.network.hbg.core.bean.TokenBindInfo;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.lib.network.hbg.core.bean.TraderRank;
import com.hbg.lib.network.hbg.core.bean.TransferSellList;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import com.hbg.lib.network.hbg.core.bean.UnreadCountData;
import com.hbg.lib.network.hbg.core.bean.UploadFile;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeConfig;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeHistoryBean;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeHistoryDetailBean;
import com.hbg.lib.network.hbg.core.bean.UserActiveInfo;
import com.hbg.lib.network.hbg.core.bean.UserCardInfoBean;
import com.hbg.lib.network.hbg.core.bean.UserCenterProfitsData;
import com.hbg.lib.network.hbg.core.bean.UserInvalidCoupon;
import com.hbg.lib.network.hbg.core.bean.UserLevelPopup;
import com.hbg.lib.network.hbg.core.bean.UserOtcCoupon;
import com.hbg.lib.network.hbg.core.bean.UserPermissionsBean;
import com.hbg.lib.network.hbg.core.bean.UserRegistryTransferGuide;
import com.hbg.lib.network.hbg.core.bean.UserStepRateInfo;
import com.hbg.lib.network.hbg.core.bean.UserStepRateLevelsResult;
import com.hbg.lib.network.hbg.core.bean.VipConfigResult;
import com.hbg.lib.network.hbg.core.bean.VipFeeInfo;
import com.hbg.lib.network.hbg.core.bean.VipInfoResult;
import com.hbg.lib.network.hbg.core.bean.VipRedPointData;
import com.hbg.lib.network.hbg.core.bean.WatchFansBean;
import com.hbg.lib.network.hbg.core.bean.WeChatGroupInfoBean;
import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.hbg.lib.network.hbg.grid.bean.GridAccountConvertInfo;
import com.hbg.lib.network.hbg.grid.bean.GridAiQuote;
import com.hbg.lib.network.hbg.grid.bean.GridAuth;
import com.hbg.lib.network.hbg.grid.bean.GridLeverageRange;
import com.hbg.lib.network.hbg.grid.bean.GridStrategy;
import com.hbg.lib.network.hbg.grid.bean.GridStrategyInfo;
import com.hbg.lib.network.hbg.grid.bean.GridSupportedSymbol;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolDetail;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import com.hbg.lib.network.hbg.integration.IntegrationConfig;
import com.hbg.lib.network.hbg.otcoptions.PreVisibleBean;
import com.huobi.store.AppConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface HbgService {
    @GET("v1/pledge/loaning-pledgeUSDT")
    Observable<HbgIntCodeResponse<PledgeAssetContent>> PledgeAssetContent();

    @GET("v1/activity/zero/available/position")
    Observable<HbgIntCodeResponse<ActivityZeroAvailablePositionBean>> activityZeroAvailablePosition();

    @POST("v1/activity/zero/create/position")
    Observable<HbgIntCodeResponse<ActivityZeroCreateBean>> activityZeroCreatePosition();

    @GET("v1/activity/zero/notice/sure")
    Observable<HbgIntCodeResponse<ActivityZeroNoticeSureBean>> activityZeroNoticeSure(@Query("noticeType") int i11);

    @GET("v1/activity/zero/position/notice")
    Observable<HbgIntCodeResponse<ActivityZeroPositionNoticeBean>> activityZeroPositionNotice();

    @GET("v1/activity/zero/position/profitInfo")
    Observable<HbgIntCodeResponse<ActivityZeroPositionProfitInfoBean>> activityZeroPositionProfitInfo();

    @POST("v1/important/pay/card/add")
    Observable<HbgIntCodeResponse<Map<String, String>>> addBankCard(@Body Map<String, Object> map, @Header("x-dialog-trace-id") String str);

    @GET("v1/hbg/myhome/addRedDot")
    Observable<HbgIntCodeResponse<Object>> addRedDot(@Query("name") String str);

    @GET("/-/x/hbg/v1/hbg/myhome/symbolView/collect")
    Observable<HbgIntCodeResponse<Object>> addSymbolViewCollect(@Query("symbol") String str);

    @GET("v1/quantization/gridding/ai-quote")
    Observable<HbgIntCodeResponse<GridAiQuote>> aiQuote(@Query("symbol") String str);

    @POST("/-/x/hbg/v1/content/activity/airdrop/close")
    Observable<HbgIntCodeResponse<Object>> airdropClose(@Body Map<String, Object> map);

    @GET("/-/x/hbg/v1/content/activity/airdrop/detail")
    Observable<HbgIntCodeResponse<AirdropDetailBean>> airdropDetail(@Query("topicType") int i11, @Query("topicId") String str);

    @POST("/-/x/hbg/v1/content/activity/airdrop/draw")
    Observable<HbgIntCodeResponse<AirdropResultBean>> airdropDraw(@Body Map<String, Object> map);

    @POST("/-/x/hbg/v1/content/stare/read/content-table")
    Observable<HbgIntCodeResponse<Void>> announceContentRead();

    @GET("v1/important/app/url/get")
    Observable<HbgIntCodeResponse<AppUrlInfo>> appUrlGet(@Query("types") String str);

    @POST("v1/content/live/live-group/applyAudit")
    Observable<HbgIntCodeResponse<String>> applyAudit(@Body Map<String, Object> map);

    @POST("v1/hbg/open/vip/benefit/apply")
    Observable<HbgIntCodeResponse<String>> applyVipBenefit(@Body Map<String, Object> map);

    @POST("v1/content/comment/attitude/update")
    Observable<HbgIntCodeResponse<AttitudeUpdate>> attitudeUpdate(@Body Map<String, Object> map);

    @POST("v1/content/live/award/exposure")
    Observable<HbgIntCodeResponse<Object>> awardExposure(@Body Map<String, Object> map);

    @POST("v1/saving/mining/common/balanceAuto/switch")
    Observable<HbgIntCodeResponse<Object>> balanceAutoMiningSwitch(@Body Map<String, Object> map);

    @POST("v1/content/live/live-group/remove-all-group")
    Observable<HbgIntCodeResponse<Boolean>> blockUserInGroup(@Body Map<String, Object> map);

    @POST("v1/pay/deposit/cancel")
    Observable<HbgIntCodeResponse<Object>> cancelDepositCurrencyFromCCFinance(@Body Map<String, Object> map, @HeaderMap Map<String, String> map2);

    @GET("v1/hbg/open/user/page/get")
    Observable<HbgIntCodeResponse<AssetWhiteListBean>> checkAssetWhiteList(@Query("bizType") String str);

    @GET("uc/hbg/open/invite/v2/invite_code/check")
    Observable<HbgIntCodeResponse<CheckInviteCodeResult>> checkInvitedCode(@Query("invite_code") String str);

    @GET("v1/c2c/check-white-list")
    Observable<HbgIntCodeResponse<Boolean>> checkWhiteList();

    @POST("v1/content/comment/praise")
    Observable<HbgIntCodeResponse<CommentPraiseBean>> commentPraise(@Body Map<String, Object> map);

    @POST("v1/content/comment/save")
    Observable<HbgIntCodeResponse<CommentSaveBean>> commentSave(@Body Map<String, Object> map);

    @GET("v1/important/huobi-access-huochat/currency/info")
    Observable<HbgIntCodeResponse<CommunitySwitchBean>> communitySwitchConfig(@Query("symbol") String str);

    @POST("v1/content/comment/delete")
    Observable<HbgIntCodeResponse<CommentDelBean>> delComment(@Body Map<String, Object> map);

    @POST("v1/content/community/dynamic/del")
    Observable<HbgIntCodeResponse<Object>> delDynamic(@Body Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/content/stare/selection/del")
    Observable<HbgIntCodeResponse<String>> delStare(@Field("symbols") String str);

    @GET("v1/pay/deposit/detail")
    Observable<HbgIntCodeResponse<Object>> detailDepositCurrencyFromCCFinance(@Query("orderCode") String str, @HeaderMap Map<String, String> map);

    @POST("v1/kyc/authorize/doAuth")
    Observable<HbgIntCodeResponse<OtcAuthBean>> doAuth(@Body Map<String, Object> map);

    @POST("v1/kyc/authorize/doAuthJumio")
    Observable<HbgIntCodeResponse<OtcAuthJumioBean>> doAuthJumio(@Body Map<String, Object> map);

    @POST("v1/saving/mining/common/fixedToActive/switch")
    Observable<HbgIntCodeResponse<Object>> fixedToActiveMiningSwitch(@Body Map<String, Object> map);

    @POST("v1/content/live/im/forbid-in-group")
    Observable<HbgIntCodeResponse<Boolean>> forbidInGroup(@Body Map<String, Object> map);

    @GET("v1/assert/dx-point/account/balance")
    Observable<HbgIntCodeResponse<AccountBalanceInfo>> getAccountBalance(@Query("id") String str);

    @GET("v1/asset/profit/account_info")
    Observable<HbgIntCodeResponse<AccountRiskInfo>> getAccountRiskInfo();

    @GET("v1/content/activity/get-activity-status")
    Observable<HbgIntCodeResponse<UserActiveInfo>> getActivityStatus(@Query("type") int i11, @Query("cid") String str);

    @GET("v1/config/push/advConfig")
    Observable<HbgIntCodeResponse<AdConfig>> getAdConfig(@QueryMap Map<String, Object> map);

    @GET("/-/x/hbg/v1/content/stare/all-open-stare")
    Observable<HbgIntCodeResponse<List<ProRemindListData>>> getAllOpenStare();

    @GET("/-/x/hbg/v1/asset/profit/user/cost/get")
    Observable<HbgIntCodeResponse<AssetAlterCostData>> getAlterAverageCostData(@Query("currency") String str, @Query("account") String str2);

    @GET("v1/mgt/config/default/list")
    Observable<HbgIntCodeResponse<List<AppConfig>>> getAppConfigList();

    @POST("v1/open/profit/apply/asset/history/recordList")
    Observable<HbgIntCodeResponse<List<AppleHistoryRecordBean>>> getAppleHistoryList();

    @POST("v1/open/profit/apply/asset/history/submit")
    Observable<HbgIntCodeResponse<Object>> getAppleHistorySubmit(@Body Map<String, Object> map);

    @GET("v1/content/live/live-group/applyList")
    Observable<HbgIntCodeResponse<ApplyListBean>> getApplyList(@Query("pageNum") int i11, @Query("pageSize") int i12, @Query("groupId") String str);

    @GET("v1/open/profit/daily/getViewStatus")
    Observable<HbgIntCodeResponse<AssetDailyData>> getAssertDialy();

    @GET("v1/spot/assert/info")
    Observable<HbgIntCodeResponse<SpotAssertInfo>> getAssertInfo(@Query("countryId") String str);

    @GET("v1/important/asset-page/carousel/list")
    Observable<HbgIntCodeResponse<List<AssetBannerData>>> getAssetBannerList(@Query("countryId") String str);

    @GET("v1/open/profit/contract/linear/userWhiteInfo")
    Observable<HbgIntCodeResponse<Boolean>> getAssetContractConfig();

    Observable<HbgIntCodeResponse<Boolean>> getAssetPageGary(@Query("vtoken") String str);

    @GET("v1/important/asset-page/gray-value")
    Observable<HbgIntCodeResponse<Boolean>> getAssetPageGary(@Query("vtoken") String str, @Query("bizType") String str2);

    @GET("v1/open/profit/newAssetsWhiteListFlag")
    Observable<HbgIntCodeResponse<Boolean>> getAssetUserGray();

    @GET("v1/asset/profit/trade")
    Observable<HbgIntCodeResponse<List<AssertsTradeData>>> getAssetsTrade(@Query("accountId") long j11, @Query("currencys") String str);

    @GET("v1/content/comment/attitude/list")
    Observable<HbgIntCodeResponse<CommunityFeedInfo.ListBean.AttitudeInfo>> getAttitudeList(@Query("topicId") String str, @Query("topicType") int i11);

    @GET("v1/hbg/open/trade/kline/query_bst")
    Observable<HbgIntCodeResponse<BSTInfo>> getBSTInfo(@Query("symbol") String str, @Query("klineType") int i11, @Query("endKline") String str2, @Query("size") int i12);

    @GET("v1/asset/profit/balance-profit-loss")
    Observable<HbgIntCodeResponse<BalanceProfitLossData>> getBalanceProfitLoss();

    @GET("finance/generalBiz/show/list")
    Observable<HbgIntCodeResponse<List<BizShow>>> getBizShow();

    @GET("v1/quantization/gridding/recommend")
    Observable<HbgIntCodeResponse<BotRank>> getBotRankData();

    @GET("v1/c2c/accounts/loan-balance")
    Observable<HbgIntCodeResponse<C2CLoanBalanceInfo>> getC2CLoanBalance(@Query("currency") String str);

    @GET("v1/content/newsflash/api/category-list")
    Observable<HbgIntCodeResponse<List<NewFlashCategory>>> getCategoryList();

    @GET("v1/pay/route/channel/list")
    Observable<HbgIntCodeResponse<List<OtcChannelInfo>>> getChannelList(@QueryMap Map<String, Object> map, @HeaderMap Map<String, String> map2);

    @GET("v1/content/live/chat/session-remove")
    Observable<HbgIntCodeResponse<ChatSessionRemove>> getChatSessionRemove();

    @GET("v1/holding/transfer/clearout/dialog-config")
    Observable<HbgIntCodeResponse<ClearDialogConfig>> getClearDialogConfig(@Query("productType") int i11);

    @GET("v1/content/comment/list")
    Observable<HbgIntCodeResponse<List<CommentInfo>>> getCommentList(@Query("topicId") String str, @Query("topicType") String str2, @Query("commentId") String str3, @Query("lastTime") String str4, @Query("size") int i11, @Query("sort") int i12);

    @POST("v1/content/community/dynamic/list-by-symbol-hot")
    Observable<HbgIntCodeResponse<CommunityFeedInfo>> getCommunityFeedHotInfoByKLine(@Body Map<String, Object> map);

    @GET("v1/content/community/dynamic/list")
    Observable<HbgIntCodeResponse<CommunityFeedInfo>> getCommunityFeedInfo(@Query("size") int i11, @Query("lastTime") long j11);

    @GET("v1/content/community/dynamic/list-by-symbol")
    Observable<HbgIntCodeResponse<CommunityFeedInfo>> getCommunityFeedInfoByKLine(@Query("lastTime") long j11, @Query("size") int i11, @Query("symbol") String str, @Query("plateId") String str2);

    @POST("v1/content/community/dynamic/list-v1")
    Observable<HbgIntCodeResponse<CommunityFeedInfo>> getCommunityFeedInfoNew(@Body Map<String, Object> map);

    @GET("v1/content/community/user/content-info")
    Observable<HbgIntCodeResponse<CommunityUserPermissions>> getCommunityUserPermissions();

    @GET("v1/content/community/nav/list")
    Observable<HbgIntCodeResponse<List<ContentNavigationInfo>>> getContentNavigation();

    @GET("v1/content/newsflash/api/content/unread")
    Observable<HbgIntCodeResponse<ContentUnreadBean>> getContentUnread(@Query("topicId") String str, @Query("topicType") int i11);

    @GET("v1/hbg/open/trade/kline/query_contract_bst")
    Observable<HbgIntCodeResponse<BSTInfo>> getContractBSTInfo(@Query("symbol") String str, @Query("klineType") int i11, @Query("volumeUnit") int i12, @Query("endKline") String str2, @Query("size") int i13);

    @GET("v1/copytrading/user-account/get")
    Observable<HbgIntCodeResponse<CTAccountBean>> getCopyTradingAccountStatus();

    @GET("v1/hbg/open/coupon/user/soon/invalid")
    Observable<HbgIntCodeResponse<UserInvalidCoupon>> getCouponSoonInvalid();

    @GET("v1/hbg/open/coupon/user/otc")
    Observable<HbgIntCodeResponse<UserOtcCoupon>> getCouponUserOtc();

    @GET("v1/asset/profit/user/currency/profit")
    Observable<HbgIntCodeResponse<List<StopCurrencyCostBean>>> getCurrencyCostProfitList(@Query("currencies") String str);

    @GET("v1/content/live/customer/getCustomerInfo")
    Observable<HbgIntCodeResponse<CustomerInfo>> getCustomerInfo(@Query("uid") String str, @Query("account") String str2);

    @GET("v1/content/news/category-v1-list")
    Observable<HbgIntCodeResponse<List<NewFlashCategory>>> getDeepCategoryList();

    @GET("v1/content/news/list")
    Observable<HbgIntCodeResponse<List<DeepNewsInfo>>> getDeepNewsList(@Query("issueTime") long j11, @Query("size") int i11, @Query("categoryId") int i12);

    @GET("v1/holding/transfer/user/deprecated")
    Observable<HbgIntCodeResponse<Object>> getDeprecated();

    @GET("v1/holding/transfer/user/deprecated")
    Observable<HbgIntCodeResponse<Map<String, Object>>> getDeprecatedInfo(@Query("productType") int i11);

    @GET("v1/config/push/dialog-common-config")
    Observable<HbgIntCodeResponse<List<HbgDialogConfigInfo>>> getDialogConfigList(@QueryMap Map<String, Object> map);

    @GET("v1/config/push/timer")
    Observable<HbgIntCodeResponse<Long>> getDialogTime();

    @GET("v1/important/currency/introduction/detail")
    Observable<HbgIntCodeResponse<CurrencyIntroInfo>> getDigitalAssetInfo(@QueryMap Map<String, Object> map);

    @GET
    Observable<HbgIntCodeResponse<SmartDomainData>> getDomain(@Url String str);

    @GET("v1/public/kyc/digital/user/info")
    Observable<HbgIntCodeResponse<DominicaKycPageInfo>> getDominicaKycPageInfo();

    @GET("v1/content/community/dynamic/get")
    Observable<HbgIntCodeResponse<DynamicDetailInfo>> getDynamicDetail(@Query("dynamicId") String str);

    @GET("/-/x/hbg/v1/saving-market/mining/app/index/earnAreaHomepage")
    Observable<HbgIntCodeResponse<HomePageEarnData>> getEarnArea();

    @GET("v1/equity/user/gray")
    Observable<HbgIntCodeResponse<Boolean>> getEquityUserGray();

    @GET("v1/equity/user/info")
    Observable<HbgIntCodeResponse<EquityUserInfo>> getEquityUserInfo();

    @GET("v1/holding/etp/remaining/amount")
    Observable<HbgIntCodeResponse<EtpAvailableBean>> getEtpAvailableAmount(@Query("currency") String str);

    @GET("v1/etp/info")
    Observable<HbgIntCodeResponse<EtpInfo>> getEtpInfo(@Query("currency") String str);

    @GET("v1/etp/rebal/info")
    Observable<HbgIntCodeResponse<EtpRebalInfo>> getEtpRebalInfo(@Query("currency") String str);

    @GET("v1/etp/rebalance")
    Observable<HbgIntCodeResponse<List<EtpRebalanceResult>>> getEtpRebalance(@QueryMap Map<String, Object> map);

    @GET("v1/biz/tips/risk")
    Observable<HbgIntCodeResponse<List<EtpRiskInfo>>> getEtpRiskList(@QueryMap Map<String, Object> map);

    @GET("/-/x/hbg/v1/app/favorite/favoriteRecommend")
    Observable<HbgIntCodeResponse<List<OneKeySelectItem>>> getFavoriteRecommend();

    @POST("v1/content/newsflash/api/feed/page-list-v1")
    Observable<HbgIntCodeResponse<NewFeed>> getFeedList(@Body Map<String, Object> map);

    @GET("v1/fiat/kyc/getInfo")
    Observable<HbgIntCodeResponse<FiatKycInfo>> getFiatKycInfo();

    @GET("v1/hbg/open/user/footprint/info")
    Observable<HbgIntCodeResponse<FootprintData>> getFootprint(@Query("number") String str);

    @GET("v1/content/activity/gift-top")
    Observable<HbgIntCodeResponse<LiveGiftRank>> getGiftTop(@Query("liveId") String str, @Query("type") int i11);

    @GET("v1/quantization/gridding/account")
    Observable<HbgIntCodeResponse<List<GridAssetItem>>> getGridAccount();

    @GET("v1/quantization/gridding/grid-auth")
    Observable<HbgIntCodeResponse<GridAuth>> getGridAuth();

    @GET("v1/quantization/gridding/symbols")
    Observable<HbgIntCodeResponse<GridSymbolsConfig>> getGridSymbols();

    @GET("v1/quantization/gridding/symbols-account-convert")
    Observable<HbgIntCodeResponse<List<GridAccountConvertInfo>>> getGridSymbolsAccountConvert();

    @GET("v1/content/live/live-group/detail")
    Observable<HbgIntCodeResponse<GroupInfoData>> getGroupInfoData(@Query("groupId") String str);

    @GET("v1/content/live/live-group/invite/get")
    Observable<HbgIntCodeResponse<GroupInviteBean>> getGroupInviteCode(@Query("groupId") String str);

    @GET("v1/content/live/live-group/user-list")
    Observable<HbgIntCodeResponse<GroupMemberListInfo>> getGroupMemberList(@Query("groupId") String str, @Query("pageNum") int i11, @Query("keyword") String str2);

    @GET("v1/content/live/live-group/user-list")
    Observable<HbgIntCodeResponse<GroupUserListData>> getGroupUserListData(@Query("groupId") String str, @Query("pageNum") int i11, @Query("pageSize") int i12, @Query("keyword") String str2);

    @GET
    Observable<ResponseBody> getH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @QueryMap Map<String, Object> map2);

    @GET("v1/open/profit/small/upgrade")
    Observable<HbgIntCodeResponse<HTUpgradeConfig>> getHTUpgradeConfig();

    @GET("v1/config/push/batch/banner/list")
    Observable<HbgIntCodeResponse<HomeFeedAd>> getHomeFeedAd(@Query("pageTypes") String str);

    @GET("v1/app/flow/homeFlowConfig")
    Observable<HbgIntCodeResponse<HomeFlowConfig>> getHomeFlowConfig(@HeaderMap Map<String, String> map);

    @GET("v1/spot/homepage/info")
    Observable<HbgIntCodeResponse<HomePageData>> getHomePageData(@QueryMap Map<String, Object> map, @HeaderMap Map<String, Object> map2);

    @GET("v1/hbg/open/invite/hot/list")
    Observable<HbgIntCodeResponse<HotSearchListInfo>> getHotList();

    @GET("v1/asset/small/config")
    Observable<HbgIntCodeResponse<HtExchangeConfig>> getHtExchangeConfig();

    @GET("v1/open/profit/small/usdt/htList")
    Observable<HbgIntCodeResponse<List<HtExchangeConfigData>>> getHtExchangeConfigDataList();

    @GET("v1/open/profit/small/history")
    Observable<HbgIntCodeResponse<List<HtExchangeHistoryBean>>> getHtExchangeHistory(@Query("from") Long l11, @Query("size") Long l12);

    @GET("v1/open/profit/small/history/detail")
    Observable<HbgIntCodeResponse<List<HtExchangeHistoryDetailBean>>> getHtExchangeHistoryDetail(@Query("id") long j11);

    @GET("v1/open/profit/small/check/submit")
    Observable<HbgIntCodeResponse<Boolean>> getHtExchangeSubmitStatus();

    @GET("v1/config/push/generateUserSig")
    Observable<HbgIntCodeResponse<PushUserSig>> getIMUserSig(@QueryMap Map<String, Object> map);

    @GET("v1/app/rankingList")
    Observable<HbgIntCodeResponse<HbgRankListInfo>> getIndexRankInfo();

    @GET("v1/integration/notice")
    Observable<HbgIntCodeResponse<IntegrationNoticeInfo>> getIntegrationNotice();

    @GET("v1/integration/questionnaire/list")
    Observable<HbgIntCodeResponse<List<IntegrationQuestionInfo>>> getIntegrationQuestionList();

    @GET("v1/integration/risk/description")
    Observable<HbgIntCodeResponse<IntegrationRiskDescriptionInfo>> getIntegrationRiskDescription();

    @GET("/-/x/hbg/v1/app/invest/drawer/getData")
    Observable<HbgIntCodeResponse<HomePageInvestData>> getInvestArea(@Header("HB-COUNTRY-ID") int i11);

    @GET("uc/hbg/open/invite/v2/inviter/get")
    Observable<HbgIntCodeResponse<InviterInfoBean>> getInviterInfo(@Header("HB-UC-TOKEN") String str);

    @GET("/-/x/hbg/v1/app/market/kline/isShowEntrance")
    Observable<HbgIntCodeResponse<KlineBottomBean>> getKlineBottomBean(@Query("symbol") String str);

    @GET("/-/x/hbg/v1/app/market/kline/isShowContractEntrance")
    Observable<HbgIntCodeResponse<KlineContractBottomBean>> getKlineContractBottomBean(@Query("code") String str);

    @GET("v1/content/news/list-by-coin")
    Observable<HbgIntCodeResponse<List<DeepNewsInfo>>> getKlineDeepNewsList(@Query("issueTime") long j11, @Query("size") int i11, @Query("symbol") String str, @Query("dataSource") int i12);

    @GET("v1/app/market-square/klineDetail")
    Observable<HbgIntCodeResponse<KlineLabel>> getKlineLabel(@Query("symbol") String str);

    @GET("v1/kyc/auth/kycData")
    Observable<HbgIntCodeResponse<OtcKycInfo>> getKycInfo(@QueryMap Map<String, Object> map);

    @GET("prime/v1/kyc/limit/get")
    Observable<HbgIntCodeResponse<PrimeKycLimit>> getKycLimit();

    @GET("v1/content/live/banner/index")
    Observable<HbgIntCodeResponse<ArrayList<LiveBannerData>>> getLiveBanner(@Query("type") int i11, @Query("isNight") int i12);

    @GET("v1/content/live/category/list")
    Observable<HbgIntCodeResponse<ArrayList<LiveCategoryData>>> getLiveCategory(@Query("status") int i11, @Query("isNight") int i12);

    @GET("v1/content/live/live-info/category-status-list")
    Observable<HbgIntCodeResponse<LiveCategoryListData>> getLiveCategoryList(@Query("categoryId") int i11, @Query("status") int i12, @Query("pageNum") int i13);

    @GET("v1/content/live/live-info/detail")
    Observable<HbgIntCodeResponse<LiveDetailBean>> getLiveDetail(@Query("id") String str);

    @GET("v1/content/live/live-info/recommend")
    Observable<HbgIntCodeResponse<LiveEndRecommendData>> getLiveEndRecommend(@Query("liveId") String str);

    @GET("v1/content/live/live-group/user-list")
    Observable<HbgIntCodeResponse<LiveGroupUserListData>> getLiveGroupUserList(@Query("groupId") String str, @Query("pageNum") int i11, @Query("pageSize") int i12);

    @GET("/-/x/hbg/v1/content/live/live-info/homepage")
    Observable<HbgIntCodeResponse<List<LiveDetailBean>>> getLiveList();

    @GET("v1/content/live/live-info/group-list")
    Observable<HbgIntCodeResponse<LiveSquareContentData>> getLiveListData(@Query("categoryId") int i11);

    @GET("v1/content/live/live-msg/list")
    Observable<HbgIntCodeResponse<List<LiveServerMsgBean>>> getLiveMsgFromServer(@Query("groupId") String str, @Query("msgSeq") int i11, @Query("size") int i12, @Query("direction") int i13);

    @GET("v1/content/live/live-info/praise-count")
    Observable<HbgIntCodeResponse<LivePraiseCount>> getLivePraiseCount(@Query("liveId") String str);

    @GET("v1/content/live/live-info/category-status-list")
    Observable<HbgIntCodeResponse<LiveSquareSubData>> getLiveSquareCategoryData(@Query("status") int i11, @Query("pageNum") int i12, @Query("categoryId") int i13);

    @GET("v1/content/live/live-info/group-list-user")
    Observable<HbgIntCodeResponse<LiveSquareContentData>> getLiveSquareData(@Query("uidUnique") String str);

    @GET("v1/hbg/open/log/getLogUserIds")
    Observable<HbgIntCodeResponse<String>> getLogUserIds();

    @GET("v1/app/market-square/plateDetail")
    Observable<HbgIntCodeResponse<MarketPlateDetail>> getMarketPlateDetail(@Query("plateId") String str);

    @GET("/-/x/hbg/v1/content/stare/unread")
    Observable<HbgIntCodeResponse<MarketRedData>> getMarketRed(@Query("symbols") String str);

    @GET("/-/x/dp/hb/v1/open/medal/homePageShare")
    Observable<HbgIntCodeResponse<MedalHomePageShare>> getMedalHomePageShare();

    @GET("/-/x/dp/hb/v1/open/medal/user/info")
    Observable<HbgIntCodeResponse<MedalUserInfo>> getMedalUserInfo();

    @GET("v1/content/live/live-info/member-count")
    Observable<HbgIntCodeResponse<MemberCountBean>> getMemberCount(@Query("liveId") String str);

    @GET("v1/hbg/open/message/unread/count")
    Observable<HbgIntCodeResponse<UnreadCountData>> getMessageUnreadCount();

    @GET("v1/mgt/config/get")
    Observable<HbgIntCodeResponse<MgtConfigInfo>> getMgtConfig(@QueryMap Map<String, Object> map);

    @GET("v1/quantization/gridding/min-invest")
    Observable<HbgIntCodeResponse<String>> getMinAmount(@QueryMap Map<String, Object> map);

    @GET("v1/important/app/pool/wallet/currency/list")
    Observable<HbgIntCodeResponse<List<MineAccountItem>>> getMineCurrencyList();

    @GET("v1/saving/mining/user/asset/market2")
    Observable<HbgIntCodeResponse<List<MiningMarketInfo>>> getMiningAssetMarket();

    @GET("v1/saving/mining/common/viewAssetsPage/switch")
    Observable<HbgIntCodeResponse<MiningSwitch>> getMiningAssetSwitch();

    @GET("v1/saving/mining/user/assets/details")
    Observable<HbgIntCodeResponse<MiningDetailBean>> getMiningDetailInfo(@Query("orderId") String str);

    @GET("v1/saving/mining/user/assets/list")
    Observable<HbgIntCodeResponse<List<MiningItem>>> getMiningItemList(@Query("projectType") int i11);

    @GET("v1/saving/mining/project/max_rate")
    Observable<HbgIntCodeResponse<MaxRateMiningProject>> getMiningMaxRateProject(@Query("currency") String str);

    @GET("v1/hbg/myhome/myCommunityData")
    Observable<HbgIntCodeResponse<CommunityData>> getMyCommunityData();

    @GET("v1/hbg/myhome/myCustomer")
    Observable<HbgIntCodeResponse<CustomerData>> getMyCustomer();

    @GET("v1/hbg/myhome/popUp")
    Observable<HbgIntCodeResponse<UserLevelPopup>> getMyPopup();

    @GET("v1/hbg/myhome/myPrimeInfo")
    Observable<HbgIntCodeResponse<MyPrimeInfo>> getMyPrimeInfo();

    @POST("v1/activity/userguide/queryuserguide")
    Observable<HbgIntCodeResponse<NewUserGuideResult>> getNewUserGuide(@Body Map<String, Object> map);

    @POST("v1/hbg/open/welfare/news/queryNews")
    Observable<HbgIntCodeResponse<NewsInfoResultVO>> getNewsBanner();

    @GET("v1/content/newsflash/api/detail")
    Observable<HbgIntCodeResponse<NewFlashInformation>> getNewsDetail(@Query("id") long j11);

    @GET("v1/content/newsflash/api/page-list")
    Observable<HbgIntCodeResponse<List<NewFlashInformation>>> getNewsList(@Query("lastIssueTime") String str, @Query("size") int i11, @Query("categoryId") int i12);

    @GET("v1/content/newsflash/api/list-by-coin")
    Observable<HbgIntCodeResponse<List<NewFlashInformation>>> getNewsListByCoin(@Query("lastIssueTime") String str, @Query("size") int i11, @Query("languageId") int i12, @Query("symbols") String str2);

    @GET("v1/content/newsflash/api/page-list-by-selection")
    Observable<HbgIntCodeResponse<List<NewFlashInformation>>> getNewsListBySelect(@Query("timestamp") String str, @Query("size") int i11, @Query("symbols") String str2);

    @GET("v1/hbg/open/app/nft/did/getInfo")
    Observable<HbgIntCodeResponse<AccountNftInfoBean>> getNftInfo();

    @GET("v1/hbg/open/message/user/no_disturb/query")
    Observable<HbgIntCodeResponse<NoDisturbData>> getNoDisturb();

    @GET("v1/proclamation/app/home-page/announcement")
    Observable<HbgIntCodeResponse<HomePageNoticeData>> getNotice(@Header("clientCountryId") int i11);

    @GET("v1/hbg/open/message/user/app/notice/list")
    Observable<HbgIntCodeResponse<List<NoticeManageResp>>> getNotificationSettingList();

    @GET("v1/hbg/open/user/nps/check")
    Observable<HbgIntCodeResponse<AccountNpsBean>> getNpsCheck();

    @GET("otc/opt/option/common/v1/assets")
    Observable<HbgIntCodeResponse<List<AssetOptionsInfo>>> getOptionsAsset();

    @GET("otc/opt/option/v1/currency")
    Observable<HbgIntCodeResponse<List<String>>> getOtcOptionsCurrency();

    @GET("otc/opt/option/v1/order-currency")
    Observable<HbgIntCodeResponse<List<String>>> getOtcOptionsOrderCurrency();

    @GET("otc/opt/option/v1/symbol")
    Observable<HbgIntCodeResponse<List<String>>> getOtcOptionsSymbol();

    @GET("v1/important/app-hot-deployment/patch/info")
    Observable<HbgIntCodeResponse<PatchInfo>> getPatchInfo(@QueryMap Map<String, Object> map);

    @GET("v1/content/community/dynamic/user-info")
    Observable<HbgIntCodeResponse<PersonalCenterInfo>> getPersonalCenterInfo(@QueryMap Map<String, String> map);

    @GET("v1/content/community/dynamic/user-list")
    Observable<HbgIntCodeResponse<List<CommunityFeedInfo.ListBean>>> getPersonalCenterTabList(@Query("uidUnique") String str, @Query("type") int i11, @Query("lastTime") long j11, @Query("size") int i12);

    @GET("v1/holding/transfer/limit")
    Observable<HbgIntCodeResponse<List<PioneerActivityLimit>>> getPioneerActivityLimit();

    @GET("v1/content/comment/vote/info")
    Observable<HbgIntCodeResponse<CommonPkData>> getPkData(@Query("topicId") String str, @Query("topicType") int i11);

    @GET("v1/pledge/balance")
    Observable<HbgIntCodeResponse<PledgeBalance>> getPledgeBalanceList();

    @GET("v1/pledge/pledge-list")
    Observable<HbgIntCodeResponse<List<PledgeBean>>> getPledgeList();

    @GET("otc/opt/option/v1/pre/visible")
    Observable<HbgIntCodeResponse<PreVisibleBean>> getPreVisible();

    @GET("v1/prime-box/detail")
    Observable<HbgIntCodeResponse<PrimeBoxDetail>> getPrimeBoxDetail();

    @GET("v1/asset/profit/analysis")
    @Headers({"Connection:close"})
    Observable<HbgIntCodeResponse<ProfitAndLossData>> getProfitAndLoss(@Query("type") int i11, @Query("period") int i12);

    @GET("v1/open/profit/user-info")
    Observable<HbgIntCodeResponse<ProfitUserInfo>> getProfitUserInfo();

    @GET("v1/hbg/open/uc/right/query")
    Observable<HbgIntCodeResponse<UserCenterProfitsData>> getProfitsData();

    @GET("v1/app/new/rankingList/v2")
    Observable<HbgIntCodeResponse<List<RankList>>> getRankInfo(@HeaderMap Map<String, String> map);

    @POST("v1/app/new/rankingList/v3")
    Observable<HbgIntCodeResponse<List<RankList>>> getRankInfoV3(@Body Map<String, Object> map);

    @GET("v1/app/jump/info")
    Observable<HbgIntCodeResponse<RankJumpInfo>> getRankJump(@QueryMap Map<String, Object> map);

    @GET("v1/content/live/track-order/recommend-detail")
    Observable<HbgIntCodeResponse<LiveRecommendInfo>> getRecommendDetail(@Query("id") String str, @Query("liveId") String str2);

    @GET("v1/content/live/speaker/list")
    Observable<HbgIntCodeResponse<RecommendSpeakerList>> getRecommendSpeaker(@Query("pageNum") int i11, @Query("pageSize") int i12, @Query("type") int i13);

    @GET("order/remaining-amount")
    Observable<HbgIntCodeResponse<RemainingAmountBean>> getRemainingAmount(@Query("currency") String str);

    @GET("v1/content/stare/monitor/list")
    Observable<HbgIntCodeResponse<List<RemindFlashBean>>> getRemindFlash(@QueryMap Map<String, Object> map);

    @GET("v1/hbg/myhome/myRewardInfo")
    Observable<HbgIntCodeResponse<RewardInfo>> getRewardInfo();

    @POST("v1/hbg/open/welfare/center/drawMultipleTaskPrize")
    Observable<HbgIntCodeResponse<TaskPrizeResp>> getRewards(@Body Map<String, Object> map);

    @GET("v1/app/home/queryAppResPackConfig")
    Observable<HbgIntCodeResponse<RMSConfig>> getRmsConfig();

    @GET("v1/content/community/tool/upload-token")
    Observable<HbgIntCodeResponse<S3TokenBean>> getS3Token();

    @GET("finance/savings/support/currencies")
    Observable<HbgIntCodeResponse<List<String>>> getSavingsCurrencyList();

    @GET("v1/hbg/open/invite/consolidation/list")
    Observable<HbgIntCodeResponse<SearchCoinListInfo>> getSearchCoinInfo();

    @GET("v1/important/currency/securityGrade/detail")
    Observable<HbgIntCodeResponse<SecurityGradeDetailBean>> getSecurityGradeDetail(@Query("currency") String str);

    @GET("v1/pay/card/list")
    Observable<HbgIntCodeResponse<List<UserCardInfoBean>>> getSettlePayUserCardList(@QueryMap Map<String, Object> map);

    @GET("v1/hbg/myhome/shareInfo")
    Observable<HbgIntCodeResponse<Object>> getShareConfig();

    @GET("v1/content/live/live-group/share-groups")
    Observable<HbgIntCodeResponse<ShareGroupList>> getShareGroups(@Query("business") int i11);

    @GET("v1/hbg/open/share/v2/config")
    Observable<HbgIntCodeResponse<ShareNewConfigInfo>> getSharePageData(@HeaderMap Map<String, Object> map, @Query("pageId") String str, @Query("buttonId") String str2);

    @GET("v1/asset/profit/trade-v2")
    Observable<HbgIntCodeResponse<CurrencyAsset>> getSpotAccountBalance(@QueryMap Map<String, String> map);

    @GET("v1/asset/profit/page/api/merge")
    Observable<HbgIntCodeResponse<AssetPositionSpotData>> getSpotApiMerge();

    @GET("v1/asset/profit/balance")
    Observable<HbgIntCodeResponse<List<AssertsTradeData>>> getSpotAsset(@QueryMap Map<String, String> map);

    @GET("v1/asset/profit/getConfig")
    Observable<HbgIntCodeResponse<Map<String, List<SpotConfigInfo>>>> getSpotConfigInfoMap(@QueryMap Map<String, String> map);

    @GET("/-/x/hbg/v1/app/spot-contract-entry")
    Observable<HbgIntCodeResponse<SpotContractEntryBean>> getSpotContractEntry(@Query("currency") String str, @Query("symbol") String str2);

    @GET("v1/content/stare/config/query")
    Observable<HbgIntCodeResponse<StareConfigListData>> getStareConfigList(@Query("symbol") String str);

    @GET("v1/quantization/gridding/strategy-list")
    Observable<HbgIntCodeResponse<List<GridStrategy>>> getStrategyList(@QueryMap Map<String, Object> map);

    @GET("v1/hbg/myhome/mySubscribes")
    Observable<HbgIntCodeResponse<SubscribeAll>> getSubscribeAll(@Query("type") int i11, @Query("offSet") int i12, @Query("limit") int i13);

    @GET("v1/hbg/myhome/myBox")
    Observable<HbgIntCodeResponse<SubscribeBox>> getSubscribeBox();

    @GET("v1/quantization/gridding/symbol-detail")
    Observable<HbgIntCodeResponse<GridSymbolDetail>> getSymbolDetail(@Query("symbol") String str);

    @GET("v1/app/market/kline/symbolHistoryRate")
    Observable<HbgIntCodeResponse<KLineSymbolHistoryBean>> getSymbolHistoryRate(@Query("symbol") String str);

    @GET("/-/x/hbg/v1/content/activity/reward/task-list")
    Observable<HbgIntCodeResponse<ContentUGCModel>> getTaskList();

    @GET("v1/hbg/open/message/user/template_label/list")
    Observable<HbgIntCodeResponse<List<TemplateLabelListData>>> getTemplateLabelList();

    @GET("v1/biz/tips/record")
    Observable<HbgIntCodeResponse<BizTipRecord>> getTipsRecord(@Query("tipsType") int i11);

    @GET("v1/app/topBannerSymbols")
    Observable<HbgIntCodeResponse<Map<String, List<String>>>> getTopBannerSymbols();

    @GET("v1/app/topContractSymbols")
    Observable<HbgIntCodeResponse<List<HbgSymbolPrice>>> getTopContractSymbols();

    @GET("v1/app/topSymbolPrice")
    Observable<HbgIntCodeResponse<List<HbgSymbolPrice>>> getTopSymbolPrice();

    @GET("v1/app/topSymbolPrice")
    Observable<HbgIntCodeResponse<List<HbgSymbolPrice>>> getTopSymbolPrice(@Query("symbols") List<String> list);

    @GET("v1/content/community/topic/dynamic/list")
    Observable<HbgIntCodeResponse<List<CommunityFeedInfo.ListBean>>> getTopicDetailDynamicList(@Query("topicId") int i11, @Query("tabId") int i12, @Query("lastTime") long j11, @Query("size") int i13);

    @POST("v1/content/community/topic/list-by-topic-hot")
    Observable<HbgIntCodeResponse<List<CommunityFeedInfo.ListBean>>> getTopicDetailHotList(@Body Map<String, Object> map);

    @GET("v1/content/community/topic/detail")
    Observable<HbgIntCodeResponse<TopicDetailInfo>> getTopicDetailInfo(@Query("topicId") int i11);

    @POST("v1/content/community/topic/list-by-topic-newest")
    Observable<HbgIntCodeResponse<List<CommunityFeedInfo.ListBean>>> getTopicDetailNewestList(@Body Map<String, Object> map);

    @GET("v1/holding/transfer/sell/list")
    Observable<HbgIntCodeResponse<TransferSellList>> getTransferSellList();

    @GET("v1/spot/app/version/mini/info")
    Observable<HbgIntCodeResponse<HBUniAppBizInfo>> getUniAppBizData(@QueryMap Map<String, String> map);

    @GET("v1/spot/app/version/mini/list")
    Observable<HbgIntCodeResponse<List<HBUniAppBizInfo>>> getUniAppBizDataList(@QueryMap Map<String, String> map);

    @GET("v1/content/newsflash/api/unread")
    Observable<HbgIntCodeResponse<FastNewsUnread>> getUnreadByCategory(@Query("timestamp") String str, @Query("categoryId") int i11);

    @GET("v1/asset/stand-alone/usdt/config")
    Observable<HbgIntCodeResponse<UsdtExchangeConfig>> getUsdtExchangeConfig();

    @GET("v1/asset/small/usdt/history")
    Observable<HbgIntCodeResponse<List<UsdtExchangeHistoryBean>>> getUsdtExchangeHistory(@Query("from") Long l11, @Query("size") Long l12);

    @GET("v1/asset/small/usdt/history/detail")
    Observable<HbgIntCodeResponse<List<UsdtExchangeHistoryDetailBean>>> getUsdtExchangeHistoryDetail(@Query("id") long j11);

    @GET("v1/asset/small/usdt/check/submit")
    Observable<HbgIntCodeResponse<Boolean>> getUsdtExchangeSubmitStatus();

    @GET("v1/hbg/myhome/activityList")
    Observable<HbgIntCodeResponse<List<PersonalcenterActivityInfoBean>>> getUserActivityList();

    @GET("v1/important/pay/card/list")
    Observable<HbgIntCodeResponse<List<UserCardInfoBean>>> getUserCardList(@QueryMap Map<String, Object> map);

    @GET("v1/content/newsflash/api/user/info")
    Observable<HbgIntCodeResponse<UserPermissionsBean>> getUserContentPermissions();

    @GET("v1/app/guide/userRegistryTransferGuide")
    Observable<HbgIntCodeResponse<UserRegistryTransferGuide>> getUserRegistryTransferGuide(@HeaderMap Map<String, String> map);

    @GET("v1/content/live/live-group/role")
    Observable<HbgIntCodeResponse<LiveUserRole>> getUserRole(@Query("groupId") String str);

    @GET("v1/fee/step-rate/user-info")
    Observable<HbgIntCodeResponse<UserStepRateInfo>> getUserStepRate(@Query("businessType") String str);

    @GET("v1/fee/step-rate/levels")
    Observable<HbgIntCodeResponse<UserStepRateLevelsResult>> getUserStepRateLevels(@Query("businessType") String str, @Query("limit") int i11);

    @GET("v1/hbg/myhome/taskActivity")
    Observable<HbgIntCodeResponse<AccountTaskResp>> getUserTaskInfo();

    @GET("v1/hbg/open/biz/control/valuation-currency/list")
    Observable<HbgIntCodeResponse<List<PricingMethodBean>>> getValuationWayList();

    @GET("v1/hbg/open/vip/benefit/list")
    Observable<HbgIntCodeResponse<BenefitListData>> getVipBenefitList();

    @GET("v1/hbg/open/vip/config")
    Observable<HbgIntCodeResponse<VipConfigResult>> getVipConfig(@Query("lang") String str, @Query("platform") String str2);

    @GET("v1/hbg/open/vip/tradingFee")
    Observable<HbgIntCodeResponse<VipFeeInfo>> getVipFeeInfo();

    @GET("v1/hbg/open/vip/info")
    Observable<HbgIntCodeResponse<VipInfoResult>> getVipInfo();

    @GET("v1/hbg/open/vip/config/levels")
    Observable<HbgIntCodeResponse<List<VipLevel>>> getVipLevels();

    @GET("v1/content/community/focus/{driver}")
    Observable<HbgIntCodeResponse<List<WatchFansBean>>> getWatchOrFansList(@Path("driver") String str, @Query("uidUnique") String str2, @Query("lastTime") long j11);

    @GET("v1/hbg/open/school/baseInfo/get")
    Observable<HbgIntCodeResponse<WeChatGroupInfoBean>> getWeChatGroupInfo();

    @GET("v1/content/live/active-jackpot-list")
    Observable<HbgIntCodeResponse<LiveWiningInfo>> getWiningInfoList(@Query("liveId") String str);

    @GET("v1/saving/mining/ybb/can_buy_currencies")
    Observable<HbgIntCodeResponse<String>> getYbbCurrencies();

    @GET("v1/saving/mining/user/balanceAuto/openAnyOne")
    Observable<HbgIntCodeResponse<Boolean>> getYbbSwitch();

    @GET("v1/saving/mining/ybb/user/asset")
    Observable<HbgIntCodeResponse<YbbUserAssetInfoData>> getYbbUserAssetInfoData(@QueryMap Map<String, Object> map);

    @POST("v1/quantization/gridding/grid-auth-submit")
    Observable<HbgIntCodeResponse<Object>> gridAuthSubmit(@Body Map<String, Object> map);

    @POST("v1/config/push/event/report")
    Observable<HbgIntCodeResponse> hbgReport(@Body Map<String, Object> map);

    @GET("v1/quantization/gridding/in-white")
    Observable<HbgIntCodeResponse<Boolean>> inGridWhite();

    @GET("v1/integration/config")
    Observable<HbgIntCodeResponse<IntegrationConfig>> integrationConfig();

    @POST("v1/content/community/interest/tag/edit")
    Observable<HbgIntCodeResponse<Boolean>> interestTagEdit(@Body Map<String, Object> map);

    @POST("v1/content/live/live-group/change")
    Observable<HbgIntCodeResponse<String>> joinFuncChange(@Body Map<String, Object> map);

    @POST("v1/content/live/live-info/in-live")
    Observable<HbgIntCodeResponse<String>> joinLive(@Body Map<String, Object> map);

    @GET("v1/hbg/open/invite/v2/kol/check")
    Observable<HbgIntCodeResponse<Boolean>> kolCheck(@Header("HB-UC-TOKEN") String str);

    @GET("v1/hbg/open/invite/v2/kol/language")
    Observable<HbgIntCodeResponse<List<Integer>>> kolLanguage(@Header("HB-UC-TOKEN") String str);

    @POST("v1/content/live/live-appoint/appoint")
    Observable<HbgIntCodeResponse<LiveAppointmentData>> liveAppointment(@Body Map<String, Object> map);

    @POST("v1/content/live/live-appoint/appoint-cancel")
    Observable<HbgIntCodeResponse<LiveAppointmentData>> liveCancelAppointment(@Body Map<String, Object> map);

    @POST("v1/content/live/live-info/praise")
    Observable<HbgIntCodeResponse<PraiseCountBean>> livePraise(@Body Map<String, Object> map);

    @POST("v1/content/live/track-order/recommend-cancel")
    Observable<HbgIntCodeResponse<Object>> liveRecommendCancel(@Body Map<String, Object> map);

    @POST("v1/content/live/track-order/recommend")
    Observable<HbgIntCodeResponse<RecommendTrader>> liveRecommendTrader(@Body Map<String, Object> map);

    @POST("v1/content/live/video/recover")
    Observable<HbgIntCodeResponse<Object>> liveVideoRecover(@Body Map<String, Object> map);

    @POST("v1/saving/mining/order/demand/redeem-order")
    Observable<HbgIntCodeResponse<Object>> miningRedeemOrder(@Body Map<String, Object> map);

    @Deprecated
    @GET("v1/content/newsflash/api/market")
    Observable<HbgIntCodeResponse<List<NewFlashInformation>>> newFlashMarket(@QueryMap Map<String, Object> map);

    @POST("v1/content/newsflash/api/shared")
    Observable<HbgIntCodeResponse<NewFlashInformationShare>> newFlashShare(@Body Map<String, Object> map);

    @POST("v1/content/newsflash/api/vote")
    Observable<HbgIntCodeResponse<NewFlashInformationVote>> newFlashVote(@Body Map<String, Object> map);

    @POST("otc/opt/option/order/v1/transfer-in")
    Observable<HbgIntCodeResponse<Object>> optionTransferIn(@Body Map<String, Object> map, @HeaderMap Map<String, String> map2);

    @POST("order/place/auto")
    Observable<HbgIntCodeResponse<AutoOrderResult>> orderPlaceAuto(@Body Map<String, Object> map);

    @POST("v1/content/live/live-info/out-live")
    Observable<HbgIntCodeResponse<String>> outLive(@Body Map<String, Object> map);

    @POST("v1/important/app-hot-deployment/patch/collect")
    Observable<HbgIntCodeResponse<Object>> patchCollect(@Body Map<String, Object> map);

    @POST("v1/content/comment/vote/join")
    Observable<HbgIntCodeResponse<CommonPkData>> pkVote(@Body Map<String, Object> map);

    @POST("v1/open/profit/small/check")
    Observable<HbgIntCodeResponse<String>> postCheckHtExchange(@Body RequestBody requestBody);

    @POST("v1/asset/small/usdt/check")
    Observable<HbgIntCodeResponse<String>> postCheckUsdtExchange(@Body RequestBody requestBody);

    @POST("v1/content/community/dynamic/save")
    Observable<HbgIntCodeResponse<DynamicDetailInfo>> postDynamic(@Body Map<String, Object> map);

    @POST("v1/content/live/live-group/business-share")
    Observable<HbgIntCodeResponse<Object>> postGroupShare(@Body Map<String, Object> map);

    @POST
    Observable<ResponseBody> postH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @Body Map<String, Object> map2);

    @POST("v1/open/profit/small/place")
    Observable<HbgIntCodeResponse<String>> postHtExchange(@Body RequestBody requestBody);

    @POST("v1/open/profit/activation")
    Observable<HbgIntCodeResponse<String>> postProfitActivation(@Body Map<String, Object> map);

    @POST("v1/hbg/open/share/v3/config")
    Observable<HbgIntCodeResponse<ShareConfig>> postShareConfig(@Body Map<String, Object> map);

    @POST("v1/content/comment/share")
    Observable<HbgIntCodeResponse<ShareResultBean>> postShareNum(@Body Map<String, Object> map);

    @POST("v1/asset/small/usdt/place")
    Observable<HbgIntCodeResponse<String>> postUsdtExchange(@Body RequestBody requestBody);

    @POST("v1/content/community/dynamic/saveWithTopic")
    Observable<HbgIntCodeResponse<DynamicDetailInfo>> postWithTopicDynamic(@Body Map<String, Object> map);

    @POST("order/place")
    Observable<HbgIntCodeResponse<String>> potentialOrderPlace(@Body Map<String, Object> map);

    @POST("v1/content/live/live-group/notification")
    Observable<HbgIntCodeResponse<String>> pushNotification(@Body Map<String, Object> map);

    @POST("v1/content/live/group-notification/publish")
    Observable<HbgIntCodeResponse<String>> pushNotificationNew(@Body Map<String, Object> map);

    @PUT
    Observable<ResponseBody> putH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @Body Map<String, Object> map2);

    @GET("v1/kyc/authorize/query")
    Observable<HbgIntCodeResponse<CurrencyFromCCAuthorizationData>> queryAuthorization(@Query("appId") String str);

    @GET("v1/vip/privilege/checkRedPoint")
    Observable<HbgIntCodeResponse<VipRedPointData>> queryCheckRedPoint();

    @GET("v1/hbg/open/common/date/queryCurDate")
    Observable<HbgIntCodeResponse<ServerCurDate>> queryCurDate();

    @GET("v1/pay/bill/list")
    Observable<HbgIntCodeResponse<List<CurrencyFromCCFinanceRecordInfo>>> queryCurrencyFromCCFinances(@QueryMap Map<String, Object> map, @HeaderMap Map<String, String> map2);

    @GET("v1/kyc/level")
    Observable<HbgIntCodeResponse<CurrencyFromCCKYCLevel>> queryKycLevel();

    @GET("otc/opt/option/v1/pre/query-maker-info")
    Observable<HbgIntCodeResponse<Integer>> queryMakerInfo();

    @GET("v1/pay/route/channel/list")
    Observable<HbgIntCodeResponse<List<CurrencyFromCCRouteChannelData>>> queryPayRouteChannelList(@QueryMap Map<String, Object> map, @HeaderMap Map<String, String> map2);

    @POST("v1/red/packet/collect")
    Observable<HbgIntCodeResponse<RedPacketCollectBean>> redPacketCollect(@Body Map<String, Object> map);

    @GET("v1/red/packet/main/info")
    Observable<HbgIntCodeResponse<RedPacketInfoBean>> redPacketInfo(@Query("codeWord") String str);

    @POST("v1/saving/mining/order/regular/get_interest")
    Observable<HbgIntCodeResponse<String>> regularGetInterest(@Body Map<String, Object> map);

    @POST("v1/important/pay/card/remove")
    Observable<HbgIntCodeResponse<Object>> removeCard(@Body Map<String, Object> map);

    @GET("v1/hbg/open/log/removeLogUserId")
    Observable<HbgIntCodeResponse<String>> removeLogUserId(@Query("useridStr") String str);

    @POST("v1/content/live/live-group/user-remove")
    Observable<HbgIntCodeResponse<Boolean>> removeUserInGroup(@Body Map<String, Object> map);

    @POST("v1/hbg/open/user/footprint/symbol/report")
    Observable<HbgIntCodeResponse<Object>> reportMarketFootprint(@Body HashMap<String, Object> hashMap);

    @POST("v1/spot/app/version/mini/report")
    Observable<HbgIntCodeResponse<Object>> reportUniAppUpgradeSuccess(@Body Map<String, Object> map);

    @GET("v1/pay/largeTrade/validLargeTradeUser")
    Observable<HbgIntCodeResponse<Object>> requestBulkUserInfo();

    @GET("v1/c2c/account-in/net-asset")
    Observable<HbgIntCodeResponse<List<C2CAccountInNetAssetResult>>> requestC2CAccountInNetAsset();

    @GET("v1/c2c/account-out/net-asset")
    Observable<HbgIntCodeResponse<C2CAccountOutNetAssetResult>> requestC2CAccountOutNetAsset();

    @GET("v1/c2c/accounts/overview")
    Observable<HbgIntCodeResponse<C2CAccountOverviewInfo>> requestC2CAccountOverview(@Query("symbol") String str);

    @GET("v1/c2c/check-white-list")
    Observable<HbgIntCodeResponse<Boolean>> requestC2CCheckWhiteList(@Query("type") int i11);

    @GET("v1/c2c/currencys")
    Observable<HbgIntCodeResponse<List<C2CCurrencyBean>>> requestC2CCurrencys();

    @GET("v1/c2c/lend-threshold/get-asset")
    Observable<HbgIntCodeResponse<C2CLendThresholdGetAssetInfo>> requestC2CLendThresholdGetAsset(@Query("currency") String str);

    @POST("v1/c2c/order/{orderId}/cancel")
    Observable<HbgIntCodeResponse<Object>> requestC2CLoanOrderCancel(@Path("orderId") String str);

    @GET("v1/c2c/loan/orders")
    Observable<HbgIntCodeResponse<List<C2CLoanOrderBean>>> requestC2CLoanOrders(@QueryMap Map<String, Object> map);

    @GET("v1/c2c/loan/open-orders")
    Observable<HbgIntCodeResponse<List<C2CLoanOrderBean>>> requestC2CLoanOrdersHistory(@QueryMap Map<String, Object> map);

    @GET("v1/c2c/nationality/blacklist/list")
    Observable<HbgIntCodeResponse<List<C2CNationalityBlackListInfo>>> requestC2CNationalityBlackList();

    @POST("v1/c2c/order/loan")
    Observable<HbgIntCodeResponse<Object>> requestC2COrderLoan(@Body Map<String, Object> map);

    @POST("v1/c2c/order/repay")
    Observable<HbgIntCodeResponse<Object>> requestC2COrderRepay(@Body Map<String, Object> map);

    @GET("v1/c2c/order/{orderId}/repay/info")
    Observable<HbgIntCodeResponse<C2COrderRepayInfo>> requestC2COrderRepayInfo(@Path("orderId") String str, @Query("symbol") String str2);

    @POST("v1/c2c/renew/state")
    Observable<HbgIntCodeResponse<Object>> requestC2CRenewState(@Body Map<String, Object> map);

    @GET("v1/c2c/symbols")
    Observable<HbgIntCodeResponse<List<C2CSymbolBean>>> requestC2CSymbols();

    @POST("v1/c2c/transfer")
    Observable<HbgIntCodeResponse<Object>> requestC2CTransfer(@Body Map<String, Object> map);

    @GET("v1/c2c/transfer-out-quota")
    Observable<HbgIntCodeResponse<List<C2CTransferOutQuotaInfo>>> requestC2CTransferOutQuota(@Query("symbol") String str);

    @GET("v1/important/pay/card/state")
    Observable<HbgIntCodeResponse<Map<String, String>>> requestCardState();

    @POST("v1/content/community/focus/save")
    Observable<HbgIntCodeResponse<Boolean>> requestCommunityAttention(@Body Map<String, Object> map);

    @GET("v1/gridstrategy/leverage-range")
    Observable<HbgIntCodeResponse<GridLeverageRange>> requestContractGridLeverageRange(@Query("symbol") String str);

    @GET("v1/gridstrategy/supported-symbols")
    Observable<HbgIntCodeResponse<GridSupportedSymbol>> requestContractGridSymbols();

    @GET("/-/x/hbg/v1/copytrading/contract-account/asset-info")
    Observable<HbgIntCodeResponse<CopyTradingAssetInfo>> requestCopyTradingAssetInfo(@Query("accountType") int i11, @Query("currency") String str);

    @GET("v1/copytrading/rank")
    Observable<HbgIntCodeResponse<TraderRank>> requestCopyTradingRank(@Query("search") String str, @Query("rankType") Integer num, @Query("pageNo") int i11, @Query("pageSize") int i12);

    @POST("/-/x/hbg/v1/copytrading/contract-account/transfer")
    Observable<HbgIntCodeResponse<Boolean>> requestCopyTradingTransfer(@Body Map<String, Object> map);

    @GET("/-/x/hbg/v2/copytrading/contract-account/transfer-record")
    Observable<HbgIntCodeResponse<CopyTradingAccountTransferRecord>> requestCopyTradingTransferRecord(@Query("type") Integer num, @Query("pageNo") int i11, @Query("pageSize") int i12);

    @GET("v1/activity/force/pop")
    @Headers({"DATA-SOURCE:1"})
    Observable<HbgIntCodeResponse<Object>> requestDialogActivityPop(@QueryMap Map<String, Object> map);

    @POST("v1/config/push/bunding")
    Observable<HbgIntCodeResponse<Boolean>> requestDialogConfigPushBinding(@Body Map<String, Object> map);

    @POST("v1/config/push/unbunding")
    Observable<HbgIntCodeResponse<Boolean>> requestDialogConfigPushUnbinding(@Body Map<String, Object> map);

    @GET("v1/c2c/borrow/expired-statistics")
    Observable<HbgIntCodeResponse<C2CBorrowExpiredStatistics>> requestExpiredStatistics(@Query("symbol") String str);

    @POST("v1/integration/detain/confirm")
    Observable<HbgIntCodeResponse<Object>> requestIntegrationDetainConfirm(@Body Map<String, Object> map);

    @POST("v1/integration/detain/submit")
    Observable<HbgIntCodeResponse<IntegrationDetailSubmitResult>> requestIntegrationDetainSubmit(@Body Map<String, Object> map);

    @POST("v1/integration/questionnaire/submit")
    Observable<HbgIntCodeResponse<Object>> requestIntegrationQuestionSubmit(@Body Map<String, Object> map);

    @POST("v1/kyc/info/save")
    Observable<HbgIntCodeResponse<KycInfoSaveInfo>> requestKycInfoSave(@Body Map<String, Object> map);

    @POST("v1/kyc/result/callback")
    Observable<HbgIntCodeResponse<String>> requestKycJumioComplete(@Body Map<String, Object> map);

    @GET("v1/config/push/banner/list")
    Observable<HbgIntCodeResponse<NewBannerBean>> requestNewBanner(@Query("pageType") int i11, @Query("showType") int i12, @Query("symbol") String str);

    @GET("v1/gridstrategy/strategy-info")
    Observable<HbgIntCodeResponse<GridStrategyInfo>> requestStrategyInfo(@Query("strategyId") String str);

    @POST("v1/content/stare/cid/save")
    Observable<HbgIntCodeResponse<String>> saveCid(@Body Map<String, Object> map);

    @POST("v1/hbg/open/message/user/no_disturb/save")
    Observable<HbgIntCodeResponse<String>> saveNoDisturb(@Body HashMap<String, Object> hashMap);

    @POST("v1/hbg/open/message/user/app/template_label/save")
    Observable<HbgIntCodeResponse<String>> saveNotificationSetting(@Body HashMap<String, Object> hashMap);

    @POST("v1/hbg/open/message/user/language/save")
    Observable<HbgIntCodeResponse<String>> savePushLang(@Body Map<String, Object> map);

    @GET("finance/savings/order/checkPermission")
    Observable<HbgIntCodeResponse<Boolean>> savingsCheckPermission();

    @POST("v1/important/scan/code/token/bind")
    Observable<HbgIntCodeResponse<TokenBindInfo>> scanTokenBind(@Body Map<String, Object> map);

    @GET("v1/important/scan/code/token/get")
    Observable<HbgIntCodeResponse<String>> scanTokenGet(@QueryMap Map<String, Object> map);

    @GET("v1/content/live/live-group/search")
    Observable<HbgIntCodeResponse<SearchLiveGroupUserList>> searchLiveGroupUser(@Query("groupId") String str, @Query("keyword") String str2);

    @POST("v1/content/live/im/set-manager")
    Observable<HbgIntCodeResponse<Boolean>> setGroupManager(@Body Map<String, Object> map);

    @POST("v1/content/stare/tactic/set-percent")
    Observable<HbgIntCodeResponse<StareInfo>> setPercent(@Body Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/content/stare/config/set")
    Observable<HbgIntCodeResponse<String>> setStareConfig(@Field("symbol") String str, @Field("strategyId") int i11, @Field("status") int i12);

    @POST("v1/quantization/gridding/strategy-commit")
    Observable<HbgIntCodeResponse<String>> strategyCommit(@Body Map<String, Object> map);

    @POST("v1/quantization/gridding/strategy-stop")
    Observable<HbgIntCodeResponse<String>> strategyStop(@Body Map<String, Object> map);

    @POST("v1/hbg/open/message/user/template_label/save")
    Observable<HbgIntCodeResponse<List<TemplateLabelListData>>> templateLabelSave(@Body HashMap<String, Object> hashMap);

    @POST("v1/biz/tips/action")
    Observable<HbgIntCodeResponse<String>> tipsAction(@QueryMap Map<String, Object> map);

    @POST("v1/content/platform/user/action-notice")
    Observable<HbgIntCodeResponse<Object>> trackPushSensors(@Body Map<String, Object> map);

    @GET("v1/content/comment/translate")
    Observable<HbgIntCodeResponse<TranslateBean>> translateContent(@Query("topicId") String str, @Query("topicType") int i11, @Query("messageContent") String str2);

    @POST("/-/x/hbg/v1/asset/profit/user/cost/update")
    Observable<HbgIntCodeResponse<String>> updateAverageCostManu(@Body Map<String, Object> map);

    @POST("v1/important/pay/card/update/billingAddress")
    Observable<HbgIntCodeResponse<Map<String, String>>> updateBillingAddress(@Body Map<String, Object> map);

    @POST("v1/content/platform/user/upload-image-fail")
    Observable<HbgIntCodeResponse<Object>> uploadFail(@Body Map<String, Object> map);

    @POST("v1/content/platform/upload/file")
    @Multipart
    Observable<HbgIntCodeResponse<UploadFile>> uploadFile(@Part MultipartBody.Part part);

    @POST("v1/hbg/open/user/feedback/file/upload")
    @Multipart
    Observable<HbgIntCodeResponse<ArrayList<String>>> uploadUserLog(@Part("uuid") RequestBody requestBody, @Part MultipartBody.Part part);

    @POST("v1/hbg/open/user/feedback/information/add")
    Observable<HbgIntCodeResponse<String>> uploadUserLogInfo(@Body Map<String, Object> map);

    @POST("v1/content/comment/mute")
    Observable<HbgIntCodeResponse<String>> userMute(@Body Map<String, Object> map);

    @POST("v1/open/taskcenter/userSignIn")
    Observable<HbgIntCodeResponse<AccountChallengeTask.SignInResp>> userSignIn(@Body Map<String, Object> map);

    @POST("v1/content/comment/unmute")
    Observable<HbgIntCodeResponse<String>> userUnMute(@Body Map<String, Object> map);
}
