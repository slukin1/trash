package com.hbg.lib.network.hbg;

import android.content.Context;
import c9.b;
import com.hbg.lib.network.hbg.core.BusinessType;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.VipLevel;
import com.hbg.lib.network.hbg.core.bean.AccountBalanceInfo;
import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.hbg.lib.network.hbg.core.bean.AccountNftInfoBean;
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
import com.hbg.lib.network.hbg.core.bean.AutoOrderResult;
import com.hbg.lib.network.hbg.core.bean.BSTInfo;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.BenefitListData;
import com.hbg.lib.network.hbg.core.bean.BizShow;
import com.hbg.lib.network.hbg.core.bean.BizTipRecord;
import com.hbg.lib.network.hbg.core.bean.BotRank;
import com.hbg.lib.network.hbg.core.bean.C2CAccountInNetAssetResult;
import com.hbg.lib.network.hbg.core.bean.C2CAccountOutNetAssetResult;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import com.hbg.lib.network.hbg.core.bean.C2CLendThresholdGetAssetInfo;
import com.hbg.lib.network.hbg.core.bean.C2CLoanBalanceInfo;
import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
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
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCRouteChannelData;
import com.hbg.lib.network.hbg.core.bean.CurrencyIntroInfo;
import com.hbg.lib.network.hbg.core.bean.CustomerData;
import com.hbg.lib.network.hbg.core.bean.CustomerInfo;
import com.hbg.lib.network.hbg.core.bean.DeepNewsInfo;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.lib.network.hbg.core.bean.EtpAvailableBean;
import com.hbg.lib.network.hbg.core.bean.EtpInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalanceResult;
import com.hbg.lib.network.hbg.core.bean.EtpRiskInfo;
import com.hbg.lib.network.hbg.core.bean.FastNewsUnread;
import com.hbg.lib.network.hbg.core.bean.GridAssetItem;
import com.hbg.lib.network.hbg.core.bean.GroupInfoData;
import com.hbg.lib.network.hbg.core.bean.GroupInviteBean;
import com.hbg.lib.network.hbg.core.bean.GroupMemberListInfo;
import com.hbg.lib.network.hbg.core.bean.GroupUserListData;
import com.hbg.lib.network.hbg.core.bean.HTUpgradeConfig;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import com.hbg.lib.network.hbg.core.bean.HomeFeedAd;
import com.hbg.lib.network.hbg.core.bean.HomeFlowConfig;
import com.hbg.lib.network.hbg.core.bean.HomePageData;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;
import com.hbg.lib.network.hbg.core.bean.HomePageInvestData;
import com.hbg.lib.network.hbg.core.bean.HomePageNoticeData;
import com.hbg.lib.network.hbg.core.bean.HtExchangeConfig;
import com.hbg.lib.network.hbg.core.bean.HtExchangeConfigData;
import com.hbg.lib.network.hbg.core.bean.HtExchangeHistoryBean;
import com.hbg.lib.network.hbg.core.bean.HtExchangeHistoryDetailBean;
import com.hbg.lib.network.hbg.core.bean.IntegrationDetailSubmitResult;
import com.hbg.lib.network.hbg.core.bean.IntegrationNoticeInfo;
import com.hbg.lib.network.hbg.core.bean.IntegrationQuestionInfo;
import com.hbg.lib.network.hbg.core.bean.IntegrationRiskDescriptionInfo;
import com.hbg.lib.network.hbg.core.bean.KLineSymbolHistoryBean;
import com.hbg.lib.network.hbg.core.bean.KlineBottomBean;
import com.hbg.lib.network.hbg.core.bean.KlineContractBottomBean;
import com.hbg.lib.network.hbg.core.bean.KlineLabel;
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
import com.hbg.lib.network.hbg.core.bean.NewsInfoResultVO;
import com.hbg.lib.network.hbg.core.bean.NoDisturbData;
import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.hbg.lib.network.hbg.core.bean.OneKeySelectItem;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.network.hbg.core.bean.PersonalcenterActivityInfoBean;
import com.hbg.lib.network.hbg.core.bean.PioneerActivityLimit;
import com.hbg.lib.network.hbg.core.bean.PledgeAssetContent;
import com.hbg.lib.network.hbg.core.bean.PledgeBalance;
import com.hbg.lib.network.hbg.core.bean.PraiseCountBean;
import com.hbg.lib.network.hbg.core.bean.PricingMethodBean;
import com.hbg.lib.network.hbg.core.bean.PrimeKycLimit;
import com.hbg.lib.network.hbg.core.bean.ProRemindListData;
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
import com.hbg.lib.network.hbg.core.bean.SearchLiveGroupUserList;
import com.hbg.lib.network.hbg.core.bean.SecurityGradeDetailBean;
import com.hbg.lib.network.hbg.core.bean.ServerCurDate;
import com.hbg.lib.network.hbg.core.bean.ShareConfig;
import com.hbg.lib.network.hbg.core.bean.ShareGroupList;
import com.hbg.lib.network.hbg.core.bean.ShareResultBean;
import com.hbg.lib.network.hbg.core.bean.SpotAssertInfo;
import com.hbg.lib.network.hbg.core.bean.SpotConfigInfo;
import com.hbg.lib.network.hbg.core.bean.SpotContractEntryBean;
import com.hbg.lib.network.hbg.core.bean.StareConfigListData;
import com.hbg.lib.network.hbg.core.bean.StareInfo;
import com.hbg.lib.network.hbg.core.bean.SubscribeAll;
import com.hbg.lib.network.hbg.core.bean.SubscribeBox;
import com.hbg.lib.network.hbg.core.bean.TaskDrawInfo;
import com.hbg.lib.network.hbg.core.bean.TaskPrizeResp;
import com.hbg.lib.network.hbg.core.bean.TokenBindInfo;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.lib.network.hbg.core.bean.TraderRank;
import com.hbg.lib.network.hbg.core.bean.TransferSellList;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import com.hbg.lib.network.hbg.core.bean.UploadFile;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeConfig;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeHistoryBean;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeHistoryDetailBean;
import com.hbg.lib.network.hbg.core.bean.UserActiveInfo;
import com.hbg.lib.network.hbg.core.bean.UserCardInfoBean;
import com.hbg.lib.network.hbg.core.bean.UserOtcCoupon;
import com.hbg.lib.network.hbg.core.bean.UserRegistryTransferGuide;
import com.hbg.lib.network.hbg.core.bean.UserStepRateInfo;
import com.hbg.lib.network.hbg.core.bean.VipConfigResult;
import com.hbg.lib.network.hbg.core.bean.VipFeeInfo;
import com.hbg.lib.network.hbg.core.bean.VipInfoResult;
import com.hbg.lib.network.hbg.core.bean.WatchFansBean;
import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.hbg.lib.network.hbg.core.util.C2CTransferDirect;
import com.hbg.lib.network.hbg.core.util.C2CloanOrderDirect;
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
import com.hbg.lib.network.hbg.socket.listener.C2CMarketDepthListener;
import com.huobi.store.AppConfig;
import d9.a;
import g9.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import rx.Observable;

public interface IHbgApi {
    a<Object> A(int i11, String str);

    a<CurrencyAsset> A0(String str);

    a<List<NoticeManageResp>> B();

    a<Object> B0(String str, String str2, int i11, String str3, int i12, int i13);

    a<CommentDelBean> C(String str);

    a<Object> C0(boolean z11);

    a<List<String>> D();

    a<CommentPraiseBean> D0(String str, int i11);

    a<PraiseCountBean> E(String str);

    a<Object> E0(String str, String str2);

    a<String> F(String str, int i11);

    a<String> F0(List<Integer> list, int i11);

    a<List<AssertsTradeData>> G(String str);

    a<List<EtpRebalanceResult>> G0(long j11, int i11, int i12, String str);

    a<StareInfo> H(String str, String str2, Double d11);

    a<String> H0(String str);

    a<List<C2CLoanOrderBean>> I(int i11, C2CloanOrderDirect c2CloanOrderDirect, int i12, String str);

    a<BotRank> I0();

    a<TaskPrizeResp> J(List<TaskDrawInfo> list);

    a<DynamicDetailInfo> J0(String str, String str2, String str3, String str4, String str5, String str6);

    a<String> K(String str, String str2, String str3);

    a<LiveAppointmentData> K0(String str);

    a<UserStepRateInfo> L(BusinessType businessType);

    a<PledgeAssetContent> L0();

    a<Object> M(String str, String str2);

    a<PersonalCenterInfo> M0(String str, String str2, String str3);

    a<PushUserSig> N(String str);

    a<String> N0(String str, int i11, String str2);

    a<HbgIntCodeResponse<String>> O(List<String> list);

    a<HomePageData> O0(String str, int i11, int i12, Map<String, Object> map);

    a<String> P(long j11);

    a<List<LiveServerMsgBean>> P0(String str, int i11, int i12);

    a<String> Q(String str);

    a<Object> Q0(long j11, int i11);

    a<TokenBindInfo> R(String str, int i11, String str2);

    a<NewFlashInformationVote> R0(long j11, int i11);

    a<List<EtpRiskInfo>> S(String str, int i11);

    a<NewFlashInformationShare> S0(long j11, String str);

    a<HbgIntCodeResponse<AdConfig>> T(String str);

    a<Object> T0(String str, String str2);

    a<List<GridStrategy>> U(String str, int i11, int i12, String str2, long j11, String str3, int i13, Long l11, Long l12);

    a<Boolean> U0(String str, int i11, String str2);

    a<Object> V(String str, int i11);

    a<ShareResultBean> V0(String str, String str2, int i11);

    a<IntegrationDetailSubmitResult> W(String str, String str2);

    a<YbbUserAssetInfoData> W0(String str);

    a<RedPacketCollectBean> X(String str, String str2);

    a<Object> Y(String str, int i11);

    a<CommonPkData> Z(int i11, String str, String str2, int i12);

    void a(String str, Context context, b bVar);

    a<List<CommunityFeedInfo.ListBean>> a0(String str, int i11, long j11, int i12);

    a<ActivityZeroAvailablePositionBean> activityZeroAvailablePosition();

    a<ActivityZeroCreateBean> activityZeroCreatePosition();

    a<ActivityZeroNoticeSureBean> activityZeroNoticeSure(int i11);

    a<ActivityZeroPositionNoticeBean> activityZeroPositionNotice();

    a<ActivityZeroPositionProfitInfoBean> activityZeroPositionProfitInfo();

    Observable<HbgIntCodeResponse<Map<String, String>>> addBankCard(Map<String, Object> map, String str);

    a<Object> addRedDot(String str);

    a<HbgIntCodeResponse<Object>> addSymbolViewCollect(String str);

    a<GridAiQuote> aiQuote(String str);

    a<AirdropDetailBean> airdropDetail(int i11, String str);

    a<Void> announceContentRead();

    a<AppUrlInfo> appUrlGet(String str);

    void b();

    a<List<CurrencyFromCCFinanceRecordInfo>> b0(long j11, String str, int i11, int i12, int i13, Map<String, String> map);

    a<Object> blockUserInGroup(Map<String, Object> map);

    void c(a.d dVar);

    d9.a<Object> c0(String str, Map<String, String> map);

    d9.a<CheckInviteCodeResult> checkInvitedCode(String str);

    d9.a<Boolean> checkWhiteList();

    d9.a<CommunitySwitchBean> communitySwitchConfig(String str);

    void d(a.d dVar);

    d9.a<Object> d0(long j11, int i11);

    d9.a<String> delStare(String str);

    d9.a<Object> detailDepositCurrencyFromCCFinance(String str, Map<String, String> map);

    boolean e();

    d9.a<List<RemindFlashBean>> e0(long j11, String str, String str2);

    d9.a<String> f(String str, String str2);

    d9.a<TranslateBean> f0(String str, int i11);

    d9.a<Object> forbidInGroup(Map<String, Object> map);

    d9.a<Object> g(C2CTransferDirect c2CTransferDirect, String str, String str2, String str3);

    d9.a<MyPrimeInfo> g0();

    d9.a<AccountBalanceInfo> getAccountBalance(String str);

    d9.a<AccountRiskInfo> getAccountRiskInfo();

    d9.a<UserActiveInfo> getActivityStatus(int i11, String str);

    d9.a<List<ProRemindListData>> getAllOpenStare();

    d9.a<AssetAlterCostData> getAlterAverageCostData(String str, String str2);

    d9.a<List<AppConfig>> getAppConfigList();

    d9.a<List<AppleHistoryRecordBean>> getAppleHistoryList();

    d9.a<ApplyListBean> getApplyList(int i11, int i12, String str);

    d9.a<AssetDailyData> getAssertDialy();

    d9.a<SpotAssertInfo> getAssertInfo(String str);

    d9.a<List<AssetBannerData>> getAssetBannerList(String str);

    d9.a<Boolean> getAssetContractConfig();

    d9.a<Boolean> getAssetPageGary(String str, String str2);

    d9.a<Boolean> getAssetUserGray();

    d9.a<List<AssertsTradeData>> getAssetsTrade(long j11, String str);

    d9.a<BSTInfo> getBSTInfo(String str, int i11, String str2, int i12);

    d9.a<BalanceProfitLossData> getBalanceProfitLoss();

    d9.a<List<BizShow>> getBizShow();

    d9.a<C2CLoanBalanceInfo> getC2CLoanBalance(String str);

    d9.a<ChatSessionRemove> getChatSessionRemove();

    d9.a<ClearDialogConfig> getClearDialogConfig(int i11);

    d9.a<List<CommentInfo>> getCommentList(String str, String str2, String str3, String str4, int i11, int i12);

    d9.a<CommunityFeedInfo> getCommunityFeedHotInfoByKLine(Map<String, Object> map);

    d9.a<CommunityFeedInfo> getCommunityFeedInfo(int i11, long j11);

    d9.a<CommunityFeedInfo> getCommunityFeedInfoNew(Map<String, Object> map);

    d9.a<CommunityUserPermissions> getCommunityUserPermissions();

    d9.a<List<ContentNavigationInfo>> getContentNavigation();

    d9.a<ContentUnreadBean> getContentUnread(String str, int i11);

    d9.a<BSTInfo> getContractBSTInfo(String str, int i11, int i12, String str2, int i13);

    d9.a<CTAccountBean> getCopyTradingAccountStatus();

    d9.a<UserOtcCoupon> getCouponUserOtc();

    d9.a<CustomerInfo> getCustomerInfo(String str, String str2);

    d9.a<List<NewFlashCategory>> getDeepCategoryList();

    d9.a<List<DeepNewsInfo>> getDeepNewsList(long j11, int i11, int i12);

    d9.a<Object> getDeprecated();

    d9.a<CurrencyIntroInfo> getDigitalAssetInfo(Map<String, Object> map);

    d9.a<DynamicDetailInfo> getDynamicDetail(String str);

    d9.a<HomePageEarnData> getEarnArea();

    d9.a<EtpAvailableBean> getEtpAvailableAmount(String str);

    d9.a<EtpInfo> getEtpInfo(String str);

    d9.a<EtpRebalInfo> getEtpRebalInfo(String str);

    d9.a<List<OneKeySelectItem>> getFavoriteRecommend();

    d9.a<NewFeed> getFeedList(Map<String, Object> map);

    d9.a<LiveGiftRank> getGiftTop(String str, int i11);

    d9.a<List<GridAssetItem>> getGridAccount();

    d9.a<GridAuth> getGridAuth();

    d9.a<GridSymbolsConfig> getGridSymbols();

    d9.a<List<GridAccountConvertInfo>> getGridSymbolsAccountConvert();

    d9.a<GroupInfoData> getGroupInfoData(String str);

    d9.a<GroupInviteBean> getGroupInviteCode(String str);

    d9.a<GroupMemberListInfo> getGroupMemberList(String str, int i11, String str2);

    d9.a<GroupUserListData> getGroupUserListData(String str, int i11, int i12, String str2);

    d9.a<ResponseBody> getH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);

    d9.a<HTUpgradeConfig> getHTUpgradeConfig();

    d9.a<HomeFeedAd> getHomeFeedAd(String str);

    d9.a<HomeFlowConfig> getHomeFlowConfig(Map<String, String> map);

    d9.a<HbgIntCodeResponse<HtExchangeConfig>> getHtExchangeConfig();

    d9.a<HbgIntCodeResponse<List<HtExchangeConfigData>>> getHtExchangeConfigDataList();

    d9.a<HbgIntCodeResponse<List<HtExchangeHistoryBean>>> getHtExchangeHistory(Long l11, Long l12);

    d9.a<HbgIntCodeResponse<List<HtExchangeHistoryDetailBean>>> getHtExchangeHistoryDetail(long j11);

    d9.a<HbgIntCodeResponse<Boolean>> getHtExchangeSubmitStatus();

    d9.a<IntegrationNoticeInfo> getIntegrationNotice();

    d9.a<List<IntegrationQuestionInfo>> getIntegrationQuestionList();

    d9.a<IntegrationRiskDescriptionInfo> getIntegrationRiskDescription();

    d9.a<HomePageInvestData> getInvestArea(int i11);

    d9.a<KlineBottomBean> getKlineBottomBean(String str);

    d9.a<KlineContractBottomBean> getKlineContractBottomBean(String str);

    d9.a<List<DeepNewsInfo>> getKlineDeepNewsList(long j11, int i11, String str, int i12);

    d9.a<KlineLabel> getKlineLabel(String str);

    d9.a<PrimeKycLimit> getKycLimit();

    d9.a<ArrayList<LiveBannerData>> getLiveBanner(int i11, int i12);

    d9.a<ArrayList<LiveCategoryData>> getLiveCategory(int i11, int i12);

    d9.a<LiveCategoryListData> getLiveCategoryList(int i11, int i12, int i13);

    d9.a<LiveDetailBean> getLiveDetail(String str);

    d9.a<LiveEndRecommendData> getLiveEndRecommend(String str);

    d9.a<LiveGroupUserListData> getLiveGroupUserList(String str, int i11, int i12);

    d9.a<List<LiveDetailBean>> getLiveList();

    d9.a<LiveSquareContentData> getLiveListData(int i11);

    d9.a<LivePraiseCount> getLivePraiseCount(String str);

    d9.a<LiveSquareSubData> getLiveSquareCategoryData(int i11, int i12, int i13);

    d9.a<LiveSquareContentData> getLiveSquareData(String str);

    d9.a<String> getLogUserIds();

    d9.a<MarketPlateDetail> getMarketPlateDetail(String str);

    d9.a<MarketRedData> getMarketRed(String str);

    d9.a<MedalHomePageShare> getMedalHomePageShare();

    d9.a<MedalUserInfo> getMedalUserInfo();

    d9.a<MemberCountBean> getMemberCount(String str);

    d9.a<List<MineAccountItem>> getMineCurrencyList();

    d9.a<List<MiningMarketInfo>> getMiningAssetMarket();

    d9.a<MiningSwitch> getMiningAssetSwitch();

    d9.a<MiningDetailBean> getMiningDetailInfo(String str);

    d9.a<List<MiningItem>> getMiningItemList(int i11);

    d9.a<MaxRateMiningProject> getMiningMaxRateProject(String str);

    d9.a<CommunityData> getMyCommunityData();

    d9.a<CustomerData> getMyCustomer();

    d9.a<NewsInfoResultVO> getNewsBanner();

    d9.a<NewFlashInformation> getNewsDetail(long j11);

    d9.a<List<NewFlashInformation>> getNewsList(String str, int i11, int i12);

    d9.a<List<NewFlashInformation>> getNewsListByCoin(String str, int i11, int i12, String str2);

    d9.a<List<NewFlashInformation>> getNewsListBySelect(String str, int i11, String str2);

    d9.a<AccountNftInfoBean> getNftInfo();

    d9.a<NoDisturbData> getNoDisturb();

    d9.a<HomePageNoticeData> getNotice(int i11);

    d9.a<List<AssetOptionsInfo>> getOptionsAsset();

    d9.a<List<String>> getOtcOptionsCurrency();

    d9.a<List<String>> getOtcOptionsOrderCurrency();

    d9.a<List<String>> getOtcOptionsSymbol();

    d9.a<List<PioneerActivityLimit>> getPioneerActivityLimit();

    d9.a<PledgeBalance> getPledgeBalanceList();

    d9.a<PreVisibleBean> getPreVisible();

    d9.a<ProfitUserInfo> getProfitUserInfo();

    d9.a<List<RankList>> getRankInfoV3(Map<String, Object> map);

    d9.a<LiveRecommendInfo> getRecommendDetail(String str, String str2);

    d9.a<RecommendSpeakerList> getRecommendSpeaker(int i11, int i12, int i13);

    d9.a<RemainingAmountBean> getRemainingAmount(String str);

    d9.a<RewardInfo> getRewardInfo();

    d9.a<RMSConfig> getRmsConfig();

    d9.a<S3TokenBean> getS3Token();

    d9.a<SecurityGradeDetailBean> getSecurityGradeDetail(String str);

    d9.a<List<UserCardInfoBean>> getSettlePayUserCardList(Map<String, Object> map);

    d9.a<ShareGroupList> getShareGroups(int i11);

    d9.a<AssetPositionSpotData> getSpotApiMerge();

    d9.a<SpotContractEntryBean> getSpotContractEntry(String str, String str2);

    d9.a<StareConfigListData> getStareConfigList(String str);

    d9.a<SubscribeBox> getSubscribeBox();

    d9.a<GridSymbolDetail> getSymbolDetail(String str);

    d9.a<KLineSymbolHistoryBean> getSymbolHistoryRate(String str);

    d9.a<ContentUGCModel> getTaskList();

    d9.a<BizTipRecord> getTipsRecord(int i11);

    d9.a<List<CommunityFeedInfo.ListBean>> getTopicDetailHotList(Map<String, Object> map);

    d9.a<TopicDetailInfo> getTopicDetailInfo(int i11);

    d9.a<List<CommunityFeedInfo.ListBean>> getTopicDetailNewestList(Map<String, Object> map);

    d9.a<TransferSellList> getTransferSellList();

    d9.a<FastNewsUnread> getUnreadByCategory(String str, int i11);

    d9.a<HbgIntCodeResponse<UsdtExchangeConfig>> getUsdtExchangeConfig();

    d9.a<HbgIntCodeResponse<List<UsdtExchangeHistoryBean>>> getUsdtExchangeHistory(Long l11, Long l12);

    d9.a<HbgIntCodeResponse<List<UsdtExchangeHistoryDetailBean>>> getUsdtExchangeHistoryDetail(long j11);

    d9.a<HbgIntCodeResponse<Boolean>> getUsdtExchangeSubmitStatus();

    d9.a<List<PersonalcenterActivityInfoBean>> getUserActivityList();

    d9.a<List<UserCardInfoBean>> getUserCardList(Map<String, Object> map);

    d9.a<UserRegistryTransferGuide> getUserRegistryTransferGuide(Map<String, String> map);

    d9.a<LiveUserRole> getUserRole(String str);

    d9.a<AccountTaskResp> getUserTaskInfo();

    d9.a<List<PricingMethodBean>> getValuationWayList();

    @GET("v1/hbg/open/vip/benefit/list")
    d9.a<BenefitListData> getVipBenefitList();

    d9.a<VipConfigResult> getVipConfig(String str, String str2);

    d9.a<VipFeeInfo> getVipFeeInfo();

    d9.a<VipInfoResult> getVipInfo();

    d9.a<List<VipLevel>> getVipLevels();

    d9.a<List<WatchFansBean>> getWatchOrFansList(String str, String str2, long j11);

    d9.a<LiveWiningInfo> getWiningInfoList(String str);

    d9.a<List<String>> getYbbCurrencies();

    d9.a<Boolean> getYbbSwitch();

    d9.a<SearchLiveGroupUserList> h(String str, String str2);

    d9.a<SubscribeAll> h0(int i11);

    d9.a<HbgIntCodeResponse> hbgReport(@FieldMap Map<String, Object> map);

    d9.a<String> i(String str, String str2, int i11, int i12, int i13, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    d9.a<CommentSaveBean> i0(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    d9.a<Boolean> inGridWhite();

    d9.a<IntegrationConfig> integrationConfig();

    d9.a<Object> j(String str);

    void j0();

    d9.a<RecommendTrader> k(String str, String str2, String str3);

    d9.a<String> k0(String str);

    d9.a<List<Integer>> kolLanguage(String str);

    d9.a<HbgIntCodeResponse<List<HbgDialogConfigInfo>>> l(String str, String str2);

    d9.a<List<C2CLoanOrderBean>> l0(int i11, C2CloanOrderDirect c2CloanOrderDirect, int i12, String str);

    d9.a<HbgIntCodeResponse<String>> m(List<String> list);

    d9.a<ArrayList<String>> m0(String str, String str2);

    d9.a<Long> n();

    d9.a<String> n0(boolean z11);

    d9.a<RankJumpInfo> o(int i11, String str);

    d9.a<String> o0(String str, int i11, int i12, String str2, String str3);

    d9.a<AutoOrderResult> orderPlaceAuto(Map<String, Object> map);

    d9.a<Object> p(String str, String str2, int i11, int i12);

    d9.a<String> p0(String str);

    d9.a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);

    d9.a<ShareConfig> postShareConfig(Map<String, Object> map);

    d9.a<String> potentialOrderPlace(Map<String, Object> map);

    d9.a<Object> q(List<Integer> list);

    d9.a<AccountChallengeTask.SignInResp> q0(long j11, long j12);

    d9.a<ServerCurDate> queryCurDate();

    void r(boolean z11, String str, int i11, C2CMarketDepthListener c2CMarketDepthListener);

    d9.a<String> r0(String str, String str2, String str3);

    d9.a<RedPacketInfoBean> redPacketInfo(String str);

    d9.a<Object> removeCard(Map<String, Object> map);

    d9.a<String> removeLogUserId(String str);

    d9.a<Object> removeUserInGroup(Map<String, Object> map);

    d9.a<Object> requestBulkUserInfo();

    d9.a<List<C2CAccountInNetAssetResult>> requestC2CAccountInNetAsset();

    d9.a<C2CAccountOutNetAssetResult> requestC2CAccountOutNetAsset();

    d9.a<List<C2CCurrencyBean>> requestC2CCurrencys();

    d9.a<C2CLendThresholdGetAssetInfo> requestC2CLendThresholdGetAsset(String str);

    d9.a<Object> requestC2CLoanOrderCancel(String str);

    d9.a<List<C2CSymbolBean>> requestC2CSymbols();

    d9.a<List<C2CTransferOutQuotaInfo>> requestC2CTransferOutQuota(String str);

    d9.a<Map<String, String>> requestCardState();

    d9.a<Boolean> requestCommunityAttention(Map<String, Object> map);

    d9.a<GridLeverageRange> requestContractGridLeverageRange(String str);

    d9.a<GridSupportedSymbol> requestContractGridSymbols();

    d9.a<CopyTradingAssetInfo> requestCopyTradingAssetInfo(int i11, String str);

    d9.a<TraderRank> requestCopyTradingRank(String str, Integer num, int i11, int i12);

    d9.a<CopyTradingAccountTransferRecord> requestCopyTradingTransferRecord(Integer num, int i11, int i12);

    d9.a<NewBannerBean> requestNewBanner(int i11, int i12, String str);

    d9.a<GridStrategyInfo> requestStrategyInfo(String str);

    d9.a<HbgIntCodeResponse<String>> s(List<String> list);

    d9.a<Boolean> s0(String str);

    d9.a<Boolean> savingsCheckPermission();

    d9.a<Object> setGroupManager(Map<String, Object> map);

    d9.a<String> setStareConfig(String str, int i11, int i12);

    d9.a<String> t(int i11, String str);

    d9.a<Map<String, List<SpotConfigInfo>>> t0(String str);

    d9.a<TranslateBean> translateContent(String str, int i11, String str2);

    d9.a<Object> u(long j11, long j12, String str, String str2, String str3);

    d9.a<AirdropResultBean> u0(int i11, String str);

    d9.a<Map<String, String>> updateBillingAddress(Map<String, Object> map);

    d9.a<UploadFile> uploadFile(MultipartBody.Part part);

    d9.a<String> uploadUserLogInfo(Map<String, Object> map);

    d9.a<String> v(String str);

    d9.a<LiveAppointmentData> v0(String str);

    d9.a<Object> w(String str, String str2, String str3, String str4, boolean z11);

    d9.a<Object> w0(String str);

    d9.a<List<CurrencyFromCCRouteChannelData>> x(String str, String str2, String str3, Map<String, String> map);

    d9.a<HbgIntCodeResponse<String>> x0(String str, String str2);

    d9.a<HbgIntCodeResponse<String>> y(List<String> list);

    d9.a<Object> y0(String str);

    d9.a<DynamicDetailInfo> z(String str, String str2, String str3, String str4, String str5, int i11, String str6, String str7);

    d9.a<Object> z0(Integer num, Integer num2);
}
