package com.hbg.lib.network.hbg.retrofit;

import a8.c;
import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import c9.b;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.network.hbg.IHbgApi;
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
import com.hbg.lib.network.hbg.core.bean.HtExchangeRequest;
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
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeRequest;
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
import com.hbg.lib.network.hbg.retrofit.service.HbgService;
import com.hbg.lib.network.hbg.socket.listener.C2CMarketDepthListener;
import com.hbg.lib.network.hbg.socket.sub.C2CMarketDepthSub;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.store.AppConfig;
import com.huobi.vulcan.model.VulcanInfo;
import com.huochat.community.base.CommunityConstants;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.stat.ServiceStat;
import d9.a;
import g9.a;
import g9.i;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;

public class HbgApiRetrofitImpl implements IHbgApi {

    /* renamed from: a  reason: collision with root package name */
    public i f70292a;

    /* renamed from: b  reason: collision with root package name */
    public b f70293b;

    /* renamed from: c  reason: collision with root package name */
    public String f70294c;

    public static /* synthetic */ BalanceProfitLossData a1(BalanceProfitLossData balanceProfitLossData) {
        Iterator<BalanceProfitLossData.AccountBalance> it2 = balanceProfitLossData.getProfitAccountBalanceList().iterator();
        while (it2.hasNext()) {
            if ("12".equals(it2.next().getDistributionType())) {
                it2.remove();
            }
        }
        return balanceProfitLossData;
    }

    public static /* synthetic */ Boolean c1(Boolean bool) {
        return bool;
    }

    public a<Object> A(int i11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("topicType", Integer.valueOf(i11));
        if (!str.isEmpty()) {
            hashMap.put(CommunityConstants.TOPIC_ID, str);
        }
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).airdropClose(hashMap).timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public a<CurrencyAsset> A0(String str) {
        HashMap hashMap = new HashMap(1);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSpotAccountBalance(hashMap).compose(HbgRetrofit.e()));
    }

    public a<List<NoticeManageResp>> B() {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getNotificationSettingList().compose(HbgRetrofit.e()));
    }

    public a<Object> B0(String str, String str2, int i11, String str3, int i12, int i13) {
        HashMap hashMap = new HashMap();
        hashMap.put("amount", str);
        if (i13 == 0) {
            hashMap.put("interestRate", str2);
        }
        hashMap.put(FirebaseAnalytics.Param.TERM, Integer.valueOf(i11));
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str3);
        hashMap.put("source", 3);
        hashMap.put("renewState", Integer.valueOf(i12));
        hashMap.put("rateType", Integer.valueOf(i13));
        RetrofitLogger.a("HbgApiRetrofitImpl-->requestC2COrderLoan-->" + hashMap);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2COrderLoan(hashMap).compose(HbgRetrofit.e()));
    }

    public a<CommentDelBean> C(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("commentId", str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).delComment(hashMap).compose(HbgRetrofit.e()));
    }

    public a<Object> C0(boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("isReceive", Boolean.valueOf(z11));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestIntegrationDetainConfirm(hashMap).compose(HbgRetrofit.e()));
    }

    public a<List<String>> D() {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSavingsCurrencyList().compose(HbgRetrofit.e()));
    }

    public a<CommentPraiseBean> D0(String str, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("cid", str);
        hashMap.put("ctype", Integer.valueOf(i11));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).commentPraise(hashMap).compose(HbgRetrofit.e()));
    }

    public a<PraiseCountBean> E(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).livePraise(hashMap).compose(HbgRetrofit.e()));
    }

    public a<Object> E0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", str);
        hashMap.put("amount", str2);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).miningRedeemOrder(hashMap).compose(HbgRetrofit.e()));
    }

    public a<String> F(String str, int i11) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("groupId", str);
        arrayMap.put("type", Integer.valueOf(i11));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).joinFuncChange(arrayMap).compose(HbgRetrofit.e()));
    }

    public a<String> F0(List<Integer> list, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("labelIds", list);
        hashMap.put("type", Integer.valueOf(i11));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).saveNotificationSetting(hashMap).compose(HbgRetrofit.e()));
    }

    public a<List<AssertsTradeData>> G(String str) {
        HashMap hashMap = new HashMap(1);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("currencys", str);
        }
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSpotAsset(hashMap).compose(HbgRetrofit.e()));
    }

    public a<List<EtpRebalanceResult>> G0(long j11, int i11, int i12, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", Long.valueOf(j11));
        hashMap.put(DevicePublicKeyStringDef.DIRECT, Integer.valueOf(i11));
        hashMap.put("limit", Integer.valueOf(i12));
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getEtpRebalance(hashMap).compose(HbgRetrofit.e()));
    }

    public a<StareInfo> H(String str, String str2, Double d11) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("tacticId", str2);
        hashMap.put("percent", d11);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).setPercent(hashMap).compose(HbgRetrofit.e()));
    }

    public a<String> H0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).regularGetInterest(hashMap).compose(HbgRetrofit.e()));
    }

    public a<List<C2CLoanOrderBean>> I(int i11, C2CloanOrderDirect c2CloanOrderDirect, int i12, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", Integer.valueOf(i11));
        hashMap.put(DevicePublicKeyStringDef.DIRECT, Integer.valueOf(c2CloanOrderDirect.direct));
        hashMap.put("limit", Integer.valueOf(i12));
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CLoanOrdersHistory(hashMap).compose(HbgRetrofit.e()));
    }

    public a<BotRank> I0() {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getBotRankData().compose(HbgRetrofit.e()));
    }

    public a<TaskPrizeResp> J(List<TaskDrawInfo> list) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("taskInfos", list);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getRewards(arrayMap).compose(HbgRetrofit.e()));
    }

    public a<DynamicDetailInfo> J0(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put("title", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("content", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("imgs", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("richText", str4);
        }
        hashMap.put("topicIds", str5);
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("symbol", str6);
        }
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postWithTopicDynamic(hashMap).compose(HbgRetrofit.e()));
    }

    public a<String> K(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("startTime", str);
        hashMap.put("endTime", str2);
        hashMap.put("disturbType", str3);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).saveNoDisturb(hashMap).compose(HbgRetrofit.e()));
    }

    public a<LiveAppointmentData> K0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).liveCancelAppointment(hashMap).compose(HbgRetrofit.e()));
    }

    public a<UserStepRateInfo> L(BusinessType businessType) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUserStepRate(businessType.type).compose(HbgRetrofit.e()));
    }

    public a<PledgeAssetContent> L0() {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).PledgeAssetContent().compose(HbgRetrofit.e()));
    }

    public a<Object> M(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str);
        hashMap.put("redPotId", str2);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).awardExposure(hashMap).compose(HbgRetrofit.e()));
    }

    public a<PersonalCenterInfo> M0(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("uidUnique", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(Constants.FLAG_ACCOUNT, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("groupId", str3);
        }
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getPersonalCenterInfo(hashMap).compose(HbgRetrofit.e()));
    }

    public a<PushUserSig> N(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FLAG_DEVICE_ID, str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getIMUserSig(hashMap).compose(HbgRetrofit.e()));
    }

    public a<String> N0(String str, int i11, String str2) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("groupId", str);
        arrayMap.put("status", Integer.valueOf(i11));
        arrayMap.put("id", str2);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).applyAudit(arrayMap).compose(HbgRetrofit.e()));
    }

    public a<HbgIntCodeResponse<String>> O(List<String> list) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postCheckUsdtExchange(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson((Object) new UsdtExchangeRequest(list)))));
    }

    public a<HomePageData> O0(String str, int i11, int i12, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (i11 != -1) {
            hashMap.put("countryId", Integer.valueOf(i11));
        }
        hashMap.put("nightMode", Integer.valueOf(i12));
        hashMap.put("pricingMode", str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getHomePageData(hashMap, map).compose(HbgRetrofit.e()));
    }

    public a<String> P(long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put("benefitId", Long.valueOf(j11));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).applyVipBenefit(hashMap).compose(HbgRetrofit.e()));
    }

    public a<List<LiveServerMsgBean>> P0(String str, int i11, int i12) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveMsgFromServer(str, i11, 100, i12).compose(HbgRetrofit.e()));
    }

    public a<String> Q(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("language", str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).savePushLang(hashMap).compose(HbgRetrofit.e()));
    }

    public a<Object> Q0(long j11, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", Long.valueOf(j11));
        hashMap.put("state", Integer.valueOf(i11));
        RetrofitLogger.a("HbgApiRetrofitImpl-->requestC2CRenewState-->" + hashMap);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CRenewState(hashMap).compose(HbgRetrofit.e()));
    }

    public a<TokenBindInfo> R(String str, int i11, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", str);
        hashMap.put("op", Integer.valueOf(i11));
        hashMap.put("token", str2);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).scanTokenBind(hashMap).compose(HbgRetrofit.e()));
    }

    public a<NewFlashInformationVote> R0(long j11, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("newsflashId", Long.valueOf(j11));
        hashMap.put("type", Integer.valueOf(i11));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).newFlashVote(hashMap).compose(HbgRetrofit.e()));
    }

    public a<List<EtpRiskInfo>> S(String str, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("bizType", str);
        hashMap.put("type", Integer.valueOf(i11));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getEtpRiskList(hashMap).compose(HbgRetrofit.e()));
    }

    public a<NewFlashInformationShare> S0(long j11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("newsflashId", Long.valueOf(j11));
        hashMap.put("deviceCode", str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).newFlashShare(hashMap).compose(HbgRetrofit.e()));
    }

    public a<HbgIntCodeResponse<AdConfig>> T(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FLAG_DEVICE_ID, str);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAdConfig(hashMap));
    }

    public a<Object> T0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(HiAnalyticsConstant.Direction.REQUEST, str);
        hashMap.put(HiAnalyticsConstant.Direction.RESPONSE, str2);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).uploadFail(hashMap).compose(HbgRetrofit.e()));
    }

    public a<List<GridStrategy>> U(String str, int i11, int i12, String str2, long j11, String str3, int i13, Long l11, Long l12) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("baseCurrency", str);
        }
        hashMap.put("type", Integer.valueOf(i11));
        if (i12 != -1) {
            hashMap.put("status", Integer.valueOf(i12));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("quoteCurrency", str2);
        }
        if (j11 != -1) {
            hashMap.put("from", Long.valueOf(j11));
        }
        hashMap.put(DevicePublicKeyStringDef.DIRECT, str3);
        if (i13 != -1) {
            hashMap.put("limit", Integer.valueOf(i13));
        }
        if (l11 != null) {
            hashMap.put("startAt", l11);
        }
        if (l12 != null) {
            hashMap.put("endAt", l12);
        }
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getStrategyList(hashMap).compose(HbgRetrofit.e()));
    }

    public a<Boolean> U0(String str, int i11, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("amount", str);
        hashMap.put("type", Integer.valueOf(i11));
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestCopyTradingTransfer(hashMap).compose(HbgRetrofit.e()));
    }

    public a<Object> V(String str, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str);
        hashMap.put("switchStatus", Integer.valueOf(i11));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).balanceAutoMiningSwitch(hashMap).compose(HbgRetrofit.e()));
    }

    public a<ShareResultBean> V0(String str, String str2, int i11) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("cid", str);
        arrayMap.put("ctype", str2);
        arrayMap.put(AppsFlyerProperties.CHANNEL, Integer.valueOf(i11));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postShareNum(arrayMap).compose(HbgRetrofit.e()));
    }

    public a<IntegrationDetailSubmitResult> W(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str);
        hashMap.put("amount", str2);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestIntegrationDetainSubmit(hashMap).compose(HbgRetrofit.e()));
    }

    public a<YbbUserAssetInfoData> W0(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, str);
        }
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getYbbUserAssetInfoData(hashMap).compose(HbgRetrofit.e()));
    }

    public a<RedPacketCollectBean> X(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("codeWord", str);
        hashMap.put(VulcanInfo.VTOKEN, str2);
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).redPacketCollect(hashMap).timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public a<Object> Y(String str, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", str);
        hashMap.put("switchStatus", Integer.valueOf(i11));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).fixedToActiveMiningSwitch(hashMap).compose(HbgRetrofit.e()));
    }

    public a<CommonPkData> Z(int i11, String str, String str2, int i12) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("voteId", Integer.valueOf(i11));
        arrayMap.put("choiceIds", str);
        arrayMap.put(CommunityConstants.TOPIC_ID, str2);
        arrayMap.put("topicType", Integer.valueOf(i12));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).pkVote(arrayMap).compose(HbgRetrofit.e()));
    }

    public void a(String str, Context context, b bVar) {
        this.f70294c = str;
        RetrofitLogger.a(this.f70294c + "-->init");
        this.f70293b = bVar;
        HbgRetrofit.d().init(str, context, bVar);
    }

    public a<List<CommunityFeedInfo.ListBean>> a0(String str, int i11, long j11, int i12) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getPersonalCenterTabList(str, i11, j11, i12).compose(HbgRetrofit.e()));
    }

    public a<ActivityZeroAvailablePositionBean> activityZeroAvailablePosition() {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).activityZeroAvailablePosition().timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public a<ActivityZeroCreateBean> activityZeroCreatePosition() {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).activityZeroCreatePosition().timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public a<ActivityZeroNoticeSureBean> activityZeroNoticeSure(int i11) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).activityZeroNoticeSure(i11).timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public a<ActivityZeroPositionNoticeBean> activityZeroPositionNotice() {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).activityZeroPositionNotice().timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public a<ActivityZeroPositionProfitInfoBean> activityZeroPositionProfitInfo() {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).activityZeroPositionProfitInfo().timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public Observable<HbgIntCodeResponse<Map<String, String>>> addBankCard(Map<String, Object> map, String str) {
        return ((HbgService) HbgRetrofit.request(HbgService.class)).addBankCard(map, str);
    }

    public a<Object> addRedDot(String str) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).addRedDot(str).compose(HbgRetrofit.e()));
    }

    public a<HbgIntCodeResponse<Object>> addSymbolViewCollect(String str) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).addSymbolViewCollect(str));
    }

    public a<GridAiQuote> aiQuote(String str) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).aiQuote(str).compose(HbgRetrofit.e()));
    }

    public a<AirdropDetailBean> airdropDetail(int i11, String str) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).airdropDetail(i11, str).timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public a<Void> announceContentRead() {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).announceContentRead().compose(HbgRetrofit.e()));
    }

    public a<AppUrlInfo> appUrlGet(String str) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).appUrlGet(str).compose(HbgRetrofit.e()));
    }

    public void b() {
        RetrofitLogger.a(this.f70294c + "-->disconnectWebSocket");
        i iVar = this.f70292a;
        if (iVar != null) {
            iVar.n();
        }
    }

    public a<List<CurrencyFromCCFinanceRecordInfo>> b0(long j11, String str, int i11, int i12, int i13, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", Long.valueOf(j11));
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str);
        hashMap.put("types", Integer.valueOf(i11));
        hashMap.put("limit", Integer.valueOf(i12));
        hashMap.put(DevicePublicKeyStringDef.DIRECT, Integer.valueOf(i13));
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).queryCurrencyFromCCFinances(hashMap, map).compose(HbgRetrofit.e()));
    }

    public a<Object> blockUserInGroup(Map<String, Object> map) {
        return new a<>(((HbgService) HbgRetrofit.request(HbgService.class)).blockUserInGroup(map).compose(HbgRetrofit.e()));
    }

    public void c(a.d dVar) {
        RetrofitLogger.a(this.f70294c + "-->removeReconnectListener-->" + dVar);
        i iVar = this.f70292a;
        if (iVar != null) {
            iVar.r(dVar);
        }
    }

    public d9.a<Object> c0(String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("orderCode", str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).cancelDepositCurrencyFromCCFinance(hashMap, map).compose(HbgRetrofit.e()));
    }

    public d9.a<CheckInviteCodeResult> checkInvitedCode(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).checkInvitedCode(str).compose(HbgRetrofit.e()));
    }

    public d9.a<Boolean> checkWhiteList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).checkWhiteList().compose(HbgRetrofit.e()));
    }

    public d9.a<CommunitySwitchBean> communitySwitchConfig(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).communitySwitchConfig(str).compose(HbgRetrofit.e()));
    }

    public void d(a.d dVar) {
        RetrofitLogger.a(this.f70294c + "-->addReconnectListener-->" + dVar);
        i iVar = this.f70292a;
        if (iVar != null) {
            iVar.h(dVar);
        }
    }

    public d9.a<Object> d0(long j11, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Long.valueOf(j11));
        hashMap.put("type", Integer.valueOf(i11));
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).strategyStop(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<String> delStare(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).delStare(str).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> detailDepositCurrencyFromCCFinance(String str, Map<String, String> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).detailDepositCurrencyFromCCFinance(str, map).compose(HbgRetrofit.e()));
    }

    public boolean e() {
        i iVar = this.f70292a;
        boolean p11 = iVar != null ? iVar.p() : false;
        RetrofitLogger.a(this.f70294c + "-->isSocketAlive-->" + p11);
        return p11;
    }

    public d9.a<List<RemindFlashBean>> e0(long j11, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Long.valueOf(j11));
        hashMap.put("size", 20);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbols", str);
        }
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getRemindFlash(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<String> f(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("tcid", str);
        hashMap.put("tappCode", str2);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).saveCid(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<TranslateBean> f0(String str, int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).translateContent(str, i11, (String) null).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> forbidInGroup(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).forbidInGroup(map).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> g(C2CTransferDirect c2CTransferDirect, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(DevicePublicKeyStringDef.DIRECT, c2CTransferDirect.state);
        hashMap.put("symbol", str);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2);
        hashMap.put("amount", str3);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CTransfer(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<MyPrimeInfo> g0() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMyPrimeInfo().compose(HbgRetrofit.e()));
    }

    public d9.a<AccountBalanceInfo> getAccountBalance(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAccountBalance(str).compose(HbgRetrofit.e()));
    }

    public d9.a<AccountRiskInfo> getAccountRiskInfo() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAccountRiskInfo().compose(HbgRetrofit.e()));
    }

    public d9.a<UserActiveInfo> getActivityStatus(int i11, String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getActivityStatus(i11, str).compose(HbgRetrofit.e()));
    }

    public d9.a<List<ProRemindListData>> getAllOpenStare() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAllOpenStare().compose(HbgRetrofit.e()));
    }

    public d9.a<AssetAlterCostData> getAlterAverageCostData(String str, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAlterAverageCostData(str, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<List<AppConfig>> getAppConfigList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAppConfigList().compose(HbgRetrofit.e()));
    }

    public d9.a<List<AppleHistoryRecordBean>> getAppleHistoryList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAppleHistoryList().compose(HbgRetrofit.e()));
    }

    public d9.a<ApplyListBean> getApplyList(int i11, int i12, String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getApplyList(i11, i12, str).compose(HbgRetrofit.e()));
    }

    public d9.a<AssetDailyData> getAssertDialy() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAssertDialy().compose(HbgRetrofit.e()));
    }

    public d9.a<SpotAssertInfo> getAssertInfo(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAssertInfo(str).compose(HbgRetrofit.e()));
    }

    public d9.a<List<AssetBannerData>> getAssetBannerList(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAssetBannerList(str).compose(HbgRetrofit.e()));
    }

    public d9.a<Boolean> getAssetContractConfig() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAssetContractConfig().compose(HbgRetrofit.e()));
    }

    public d9.a<Boolean> getAssetPageGary(String str, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAssetPageGary(str, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<Boolean> getAssetUserGray() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAssetUserGray().compose(HbgRetrofit.e()));
    }

    public d9.a<List<AssertsTradeData>> getAssetsTrade(long j11, String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAssetsTrade(j11, str).compose(HbgRetrofit.e()));
    }

    public d9.a<BSTInfo> getBSTInfo(String str, int i11, String str2, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getBSTInfo(str, i11, str2, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<BalanceProfitLossData> getBalanceProfitLoss() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getBalanceProfitLoss().compose(HbgRetrofit.e()).map(a8.a.f3492b));
    }

    public d9.a<List<BizShow>> getBizShow() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getBizShow().compose(HbgRetrofit.e()));
    }

    public d9.a<C2CLoanBalanceInfo> getC2CLoanBalance(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getC2CLoanBalance(str).compose(HbgRetrofit.e()));
    }

    public d9.a<ChatSessionRemove> getChatSessionRemove() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getChatSessionRemove().compose(HbgRetrofit.e()));
    }

    public d9.a<ClearDialogConfig> getClearDialogConfig(int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getClearDialogConfig(i11).compose(HbgRetrofit.e()));
    }

    public d9.a<List<CommentInfo>> getCommentList(String str, String str2, String str3, String str4, int i11, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getCommentList(str, str2, str3, str4, i11, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<CommunityFeedInfo> getCommunityFeedHotInfoByKLine(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getCommunityFeedHotInfoByKLine(map).compose(HbgRetrofit.e()));
    }

    public d9.a<CommunityFeedInfo> getCommunityFeedInfo(int i11, long j11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getCommunityFeedInfo(i11, j11).compose(HbgRetrofit.e()));
    }

    public d9.a<CommunityFeedInfo> getCommunityFeedInfoNew(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getCommunityFeedInfoNew(map).compose(HbgRetrofit.e()));
    }

    public d9.a<CommunityUserPermissions> getCommunityUserPermissions() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getCommunityUserPermissions().compose(HbgRetrofit.e()));
    }

    public d9.a<List<ContentNavigationInfo>> getContentNavigation() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getContentNavigation().compose(HbgRetrofit.e()));
    }

    public d9.a<ContentUnreadBean> getContentUnread(String str, int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getContentUnread(str, i11).compose(HbgRetrofit.e()));
    }

    public d9.a<BSTInfo> getContractBSTInfo(String str, int i11, int i12, String str2, int i13) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getContractBSTInfo(str, i11, i12, str2, i13).compose(HbgRetrofit.e()));
    }

    public d9.a<CTAccountBean> getCopyTradingAccountStatus() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getCopyTradingAccountStatus().timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public d9.a<UserOtcCoupon> getCouponUserOtc() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getCouponUserOtc().compose(HbgRetrofit.e()));
    }

    public d9.a<CustomerInfo> getCustomerInfo(String str, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getCustomerInfo(str, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<List<NewFlashCategory>> getDeepCategoryList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getDeepCategoryList().compose(HbgRetrofit.e()));
    }

    public d9.a<List<DeepNewsInfo>> getDeepNewsList(long j11, int i11, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getDeepNewsList(j11, i11, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> getDeprecated() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getDeprecated().compose(HbgRetrofit.e()));
    }

    public d9.a<CurrencyIntroInfo> getDigitalAssetInfo(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getDigitalAssetInfo(map).compose(HbgRetrofit.e()));
    }

    public d9.a<DynamicDetailInfo> getDynamicDetail(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getDynamicDetail(str).compose(HbgRetrofit.e()));
    }

    public d9.a<HomePageEarnData> getEarnArea() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getEarnArea().compose(HbgRetrofit.e()));
    }

    public d9.a<EtpAvailableBean> getEtpAvailableAmount(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getEtpAvailableAmount(str).compose(HbgRetrofit.e()));
    }

    public d9.a<EtpInfo> getEtpInfo(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getEtpInfo(str).compose(HbgRetrofit.e()));
    }

    public d9.a<EtpRebalInfo> getEtpRebalInfo(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getEtpRebalInfo(str).compose(HbgRetrofit.e()));
    }

    public d9.a<List<OneKeySelectItem>> getFavoriteRecommend() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getFavoriteRecommend().compose(HbgRetrofit.e()));
    }

    public d9.a<NewFeed> getFeedList(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getFeedList(map).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveGiftRank> getGiftTop(String str, int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getGiftTop(str, i11).compose(HbgRetrofit.e()));
    }

    public d9.a<List<GridAssetItem>> getGridAccount() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getGridAccount().compose(HbgRetrofit.e()));
    }

    public d9.a<GridAuth> getGridAuth() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getGridAuth().compose(HbgRetrofit.e()));
    }

    public d9.a<GridSymbolsConfig> getGridSymbols() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getGridSymbols().compose(HbgRetrofit.e()));
    }

    public d9.a<List<GridAccountConvertInfo>> getGridSymbolsAccountConvert() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getGridSymbolsAccountConvert().compose(HbgRetrofit.e()));
    }

    public d9.a<GroupInfoData> getGroupInfoData(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getGroupInfoData(str).compose(HbgRetrofit.e()));
    }

    public d9.a<GroupInviteBean> getGroupInviteCode(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getGroupInviteCode(str).compose(HbgRetrofit.e()));
    }

    public d9.a<GroupMemberListInfo> getGroupMemberList(String str, int i11, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getGroupMemberList(str, i11, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<GroupUserListData> getGroupUserListData(String str, int i11, int i12, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getGroupUserListData(str, i11, i12, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<ResponseBody> getH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getH5UrlRequest(str, map, map2));
    }

    public d9.a<HTUpgradeConfig> getHTUpgradeConfig() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getHTUpgradeConfig().compose(HbgRetrofit.e()));
    }

    public d9.a<HomeFeedAd> getHomeFeedAd(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getHomeFeedAd(str).compose(HbgRetrofit.e()));
    }

    public d9.a<HomeFlowConfig> getHomeFlowConfig(Map<String, String> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getHomeFlowConfig(map).compose(HbgRetrofit.e()));
    }

    public d9.a<HbgIntCodeResponse<HtExchangeConfig>> getHtExchangeConfig() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getHtExchangeConfig());
    }

    public d9.a<HbgIntCodeResponse<List<HtExchangeConfigData>>> getHtExchangeConfigDataList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getHtExchangeConfigDataList());
    }

    public d9.a<HbgIntCodeResponse<List<HtExchangeHistoryBean>>> getHtExchangeHistory(Long l11, Long l12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getHtExchangeHistory(l11, l12));
    }

    public d9.a<HbgIntCodeResponse<List<HtExchangeHistoryDetailBean>>> getHtExchangeHistoryDetail(long j11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getHtExchangeHistoryDetail(j11));
    }

    public d9.a<HbgIntCodeResponse<Boolean>> getHtExchangeSubmitStatus() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getHtExchangeSubmitStatus());
    }

    public d9.a<IntegrationNoticeInfo> getIntegrationNotice() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getIntegrationNotice().compose(HbgRetrofit.e()));
    }

    public d9.a<List<IntegrationQuestionInfo>> getIntegrationQuestionList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getIntegrationQuestionList().compose(HbgRetrofit.e()));
    }

    public d9.a<IntegrationRiskDescriptionInfo> getIntegrationRiskDescription() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getIntegrationRiskDescription().compose(HbgRetrofit.e()));
    }

    public d9.a<HomePageInvestData> getInvestArea(int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getInvestArea(i11).compose(HbgRetrofit.e()));
    }

    public d9.a<KlineBottomBean> getKlineBottomBean(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getKlineBottomBean(str).compose(HbgRetrofit.e()));
    }

    public d9.a<KlineContractBottomBean> getKlineContractBottomBean(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getKlineContractBottomBean(str).compose(HbgRetrofit.e()));
    }

    public d9.a<List<DeepNewsInfo>> getKlineDeepNewsList(long j11, int i11, String str, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getKlineDeepNewsList(j11, i11, str, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<KlineLabel> getKlineLabel(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getKlineLabel(str).compose(HbgRetrofit.e()));
    }

    public d9.a<PrimeKycLimit> getKycLimit() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getKycLimit().compose(HbgRetrofit.e()));
    }

    public d9.a<ArrayList<LiveBannerData>> getLiveBanner(int i11, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveBanner(i11, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<ArrayList<LiveCategoryData>> getLiveCategory(int i11, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveCategory(i11, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveCategoryListData> getLiveCategoryList(int i11, int i12, int i13) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveCategoryList(i11, i12, i13).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveDetailBean> getLiveDetail(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveDetail(str).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveEndRecommendData> getLiveEndRecommend(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveEndRecommend(str).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveGroupUserListData> getLiveGroupUserList(String str, int i11, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveGroupUserList(str, i11, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<List<LiveDetailBean>> getLiveList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveList().compose(HbgRetrofit.e()));
    }

    public d9.a<LiveSquareContentData> getLiveListData(int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveListData(i11).compose(HbgRetrofit.e()));
    }

    public d9.a<LivePraiseCount> getLivePraiseCount(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLivePraiseCount(str).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveSquareSubData> getLiveSquareCategoryData(int i11, int i12, int i13) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveSquareCategoryData(i11, i12, i13).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveSquareContentData> getLiveSquareData(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLiveSquareData(str).compose(HbgRetrofit.e()));
    }

    public d9.a<String> getLogUserIds() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getLogUserIds().compose(HbgRetrofit.e()));
    }

    public d9.a<MarketPlateDetail> getMarketPlateDetail(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMarketPlateDetail(str).compose(HbgRetrofit.e()));
    }

    public d9.a<MarketRedData> getMarketRed(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMarketRed(str).compose(HbgRetrofit.e()));
    }

    public d9.a<MedalHomePageShare> getMedalHomePageShare() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMedalHomePageShare().compose(HbgRetrofit.e()));
    }

    public d9.a<MedalUserInfo> getMedalUserInfo() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMedalUserInfo().compose(HbgRetrofit.e()));
    }

    public d9.a<MemberCountBean> getMemberCount(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMemberCount(str).compose(HbgRetrofit.e()));
    }

    public d9.a<List<MineAccountItem>> getMineCurrencyList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMineCurrencyList().compose(HbgRetrofit.e()));
    }

    public d9.a<List<MiningMarketInfo>> getMiningAssetMarket() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMiningAssetMarket().compose(HbgRetrofit.e()));
    }

    public d9.a<MiningSwitch> getMiningAssetSwitch() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMiningAssetSwitch().compose(HbgRetrofit.e()));
    }

    public d9.a<MiningDetailBean> getMiningDetailInfo(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMiningDetailInfo(str).compose(HbgRetrofit.e()));
    }

    public d9.a<List<MiningItem>> getMiningItemList(int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMiningItemList(i11).compose(HbgRetrofit.e()));
    }

    public d9.a<MaxRateMiningProject> getMiningMaxRateProject(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMiningMaxRateProject(str).compose(HbgRetrofit.e()));
    }

    public d9.a<CommunityData> getMyCommunityData() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMyCommunityData().compose(HbgRetrofit.e()));
    }

    public d9.a<CustomerData> getMyCustomer() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMyCustomer().compose(HbgRetrofit.e()));
    }

    public d9.a<NewsInfoResultVO> getNewsBanner() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getNewsBanner().compose(HbgRetrofit.e()));
    }

    public d9.a<NewFlashInformation> getNewsDetail(long j11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getNewsDetail(j11).compose(HbgRetrofit.e()));
    }

    public d9.a<List<NewFlashInformation>> getNewsList(String str, int i11, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getNewsList(str, i11, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<List<NewFlashInformation>> getNewsListByCoin(String str, int i11, int i12, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getNewsListByCoin(str, i11, i12, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<List<NewFlashInformation>> getNewsListBySelect(String str, int i11, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getNewsListBySelect(str, i11, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<AccountNftInfoBean> getNftInfo() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getNftInfo().compose(HbgRetrofit.e()));
    }

    public d9.a<NoDisturbData> getNoDisturb() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getNoDisturb().compose(HbgRetrofit.e()));
    }

    public d9.a<HomePageNoticeData> getNotice(int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getNotice(i11).compose(HbgRetrofit.e()));
    }

    public d9.a<List<AssetOptionsInfo>> getOptionsAsset() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getOptionsAsset().compose(HbgRetrofit.e()));
    }

    public d9.a<List<String>> getOtcOptionsCurrency() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getOtcOptionsCurrency().compose(HbgRetrofit.e()));
    }

    public d9.a<List<String>> getOtcOptionsOrderCurrency() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getOtcOptionsOrderCurrency().compose(HbgRetrofit.e()));
    }

    public d9.a<List<String>> getOtcOptionsSymbol() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getOtcOptionsSymbol().compose(HbgRetrofit.e()));
    }

    public d9.a<List<PioneerActivityLimit>> getPioneerActivityLimit() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getPioneerActivityLimit().compose(HbgRetrofit.e()));
    }

    public d9.a<PledgeBalance> getPledgeBalanceList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getPledgeBalanceList().compose(HbgRetrofit.e()));
    }

    public d9.a<PreVisibleBean> getPreVisible() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getPreVisible().compose(HbgRetrofit.e()));
    }

    public d9.a<ProfitUserInfo> getProfitUserInfo() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getProfitUserInfo().compose(HbgRetrofit.e()));
    }

    public d9.a<List<RankList>> getRankInfoV3(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getRankInfoV3(map).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveRecommendInfo> getRecommendDetail(String str, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getRecommendDetail(str, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<RecommendSpeakerList> getRecommendSpeaker(int i11, int i12, int i13) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getRecommendSpeaker(i11, i12, i13).compose(HbgRetrofit.e()));
    }

    public d9.a<RemainingAmountBean> getRemainingAmount(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getRemainingAmount(str).compose(HbgRetrofit.e()));
    }

    public d9.a<RewardInfo> getRewardInfo() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getRewardInfo().compose(HbgRetrofit.e()));
    }

    public d9.a<RMSConfig> getRmsConfig() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getRmsConfig().timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public d9.a<S3TokenBean> getS3Token() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getS3Token().compose(HbgRetrofit.e()));
    }

    public d9.a<SecurityGradeDetailBean> getSecurityGradeDetail(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSecurityGradeDetail(str).compose(HbgRetrofit.e()));
    }

    public d9.a<List<UserCardInfoBean>> getSettlePayUserCardList(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSettlePayUserCardList(map).compose(HbgRetrofit.e()));
    }

    public d9.a<ShareGroupList> getShareGroups(int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getShareGroups(i11).compose(HbgRetrofit.e()));
    }

    public d9.a<AssetPositionSpotData> getSpotApiMerge() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSpotApiMerge().compose(HbgRetrofit.e()));
    }

    public d9.a<SpotContractEntryBean> getSpotContractEntry(String str, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSpotContractEntry(str, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<StareConfigListData> getStareConfigList(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getStareConfigList(str).compose(HbgRetrofit.e()));
    }

    public d9.a<SubscribeBox> getSubscribeBox() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSubscribeBox().compose(HbgRetrofit.e()));
    }

    public d9.a<GridSymbolDetail> getSymbolDetail(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSymbolDetail(str).compose(HbgRetrofit.e()));
    }

    public d9.a<KLineSymbolHistoryBean> getSymbolHistoryRate(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSymbolHistoryRate(str).compose(HbgRetrofit.e()));
    }

    public d9.a<ContentUGCModel> getTaskList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getTaskList().compose(HbgRetrofit.e()));
    }

    public d9.a<BizTipRecord> getTipsRecord(int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getTipsRecord(i11).compose(HbgRetrofit.e()));
    }

    public d9.a<List<CommunityFeedInfo.ListBean>> getTopicDetailHotList(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getTopicDetailHotList(map).compose(HbgRetrofit.e()));
    }

    public d9.a<TopicDetailInfo> getTopicDetailInfo(int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getTopicDetailInfo(i11).compose(HbgRetrofit.e()));
    }

    public d9.a<List<CommunityFeedInfo.ListBean>> getTopicDetailNewestList(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getTopicDetailNewestList(map).compose(HbgRetrofit.e()));
    }

    public d9.a<TransferSellList> getTransferSellList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getTransferSellList().compose(HbgRetrofit.e()));
    }

    public d9.a<FastNewsUnread> getUnreadByCategory(String str, int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUnreadByCategory(str, i11).compose(HbgRetrofit.e()));
    }

    public d9.a<HbgIntCodeResponse<UsdtExchangeConfig>> getUsdtExchangeConfig() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUsdtExchangeConfig());
    }

    public d9.a<HbgIntCodeResponse<List<UsdtExchangeHistoryBean>>> getUsdtExchangeHistory(Long l11, Long l12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUsdtExchangeHistory(l11, l12));
    }

    public d9.a<HbgIntCodeResponse<List<UsdtExchangeHistoryDetailBean>>> getUsdtExchangeHistoryDetail(long j11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUsdtExchangeHistoryDetail(j11));
    }

    public d9.a<HbgIntCodeResponse<Boolean>> getUsdtExchangeSubmitStatus() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUsdtExchangeSubmitStatus());
    }

    public d9.a<List<PersonalcenterActivityInfoBean>> getUserActivityList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUserActivityList().compose(HbgRetrofit.e()));
    }

    public d9.a<List<UserCardInfoBean>> getUserCardList(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUserCardList(map).compose(HbgRetrofit.e()));
    }

    public d9.a<UserRegistryTransferGuide> getUserRegistryTransferGuide(Map<String, String> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUserRegistryTransferGuide(map).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveUserRole> getUserRole(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUserRole(str).compose(HbgRetrofit.e()));
    }

    public d9.a<AccountTaskResp> getUserTaskInfo() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getUserTaskInfo().compose(HbgRetrofit.e()));
    }

    public d9.a<List<PricingMethodBean>> getValuationWayList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getValuationWayList().compose(HbgRetrofit.e()));
    }

    public d9.a<BenefitListData> getVipBenefitList() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getVipBenefitList().compose(HbgRetrofit.e()));
    }

    public d9.a<VipConfigResult> getVipConfig(String str, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getVipConfig(str, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<VipFeeInfo> getVipFeeInfo() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getVipFeeInfo().compose(HbgRetrofit.e()));
    }

    public d9.a<VipInfoResult> getVipInfo() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getVipInfo().compose(HbgRetrofit.e()));
    }

    public d9.a<List<VipLevel>> getVipLevels() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getVipLevels().compose(HbgRetrofit.e()));
    }

    public d9.a<List<WatchFansBean>> getWatchOrFansList(String str, String str2, long j11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getWatchOrFansList(str, str2, j11).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveWiningInfo> getWiningInfoList(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getWiningInfoList(str).compose(HbgRetrofit.e()));
    }

    public d9.a<List<String>> getYbbCurrencies() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getYbbCurrencies().compose(HbgRetrofit.e()).flatMap(c.f3494b));
    }

    public d9.a<Boolean> getYbbSwitch() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getYbbSwitch().compose(HbgRetrofit.e()).map(a8.b.f3493b));
    }

    public d9.a<SearchLiveGroupUserList> h(String str, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).searchLiveGroupUser(str, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<SubscribeAll> h0(int i11) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSubscribeAll(i11, 0, 30).compose(HbgRetrofit.e()));
    }

    public d9.a<HbgIntCodeResponse> hbgReport(Map<String, Object> map) {
        map.put("deviceType", "2");
        map.put("version", "0");
        map.put(AppsFlyerProperties.CHANNEL, "0");
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).hbgReport(map));
    }

    public d9.a<String> i(String str, String str2, int i11, int i12, int i13, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("source", str2);
        hashMap.put("investType", Integer.valueOf(i11));
        hashMap.put("runType", Integer.valueOf(i12));
        hashMap.put("gridNum", Integer.valueOf(i13));
        hashMap.put("minPrice", str3);
        hashMap.put("maxPrice", str4);
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("yieldRate", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("stopProfitPrice", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("stopLossPrice", str7);
        }
        hashMap.put("investQuoteAmount", str8);
        if (!TextUtils.isEmpty(str9)) {
            hashMap.put("investBaseAmount", str9);
        }
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).strategyCommit(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<CommentSaveBean> i0(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap();
        hashMap.put(CommunityConstants.TOPIC_ID, str);
        hashMap.put("topicType", str2);
        hashMap.put("content", str3);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("firstLevelId", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("parentId", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(VulcanInfo.VTOKEN, str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("imgs", str7);
        }
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).commentSave(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<Boolean> inGridWhite() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).inGridWhite().compose(HbgRetrofit.e()));
    }

    public d9.a<IntegrationConfig> integrationConfig() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).integrationConfig().compose(HbgRetrofit.e()));
    }

    public d9.a<Object> j(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).liveRecommendCancel(hashMap).compose(HbgRetrofit.e()));
    }

    public void j0() {
        RetrofitLogger.a(this.f70294c + "-->connectWebSocket");
        i iVar = this.f70292a;
        if (iVar != null) {
            iVar.n();
        }
        b bVar = this.f70293b;
        if (bVar != null) {
            String webSocketHost = bVar.getWebSocketHost();
            if (!TextUtils.isEmpty(webSocketHost)) {
                if (this.f70292a == null) {
                    this.f70292a = new i(HbgRetrofit.d().getTag(), HbgRetrofit.d().createSocketOkHttpClientBuilder().build(), this.f70293b);
                }
                this.f70292a.m(webSocketHost);
            }
        }
    }

    public d9.a<RecommendTrader> k(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str);
        hashMap.put("userSign", str2);
        hashMap.put(io.flutter.plugins.firebase.crashlytics.Constants.REASON, str3);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).liveRecommendTrader(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<String> k0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).outLive(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<List<Integer>> kolLanguage(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).kolLanguage(str).compose(HbgRetrofit.e()));
    }

    public d9.a<HbgIntCodeResponse<List<HbgDialogConfigInfo>>> l(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceType", "2");
        hashMap.put("version", str);
        hashMap.put(Constants.FLAG_DEVICE_ID, str2);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getDialogConfigList(hashMap));
    }

    public d9.a<List<C2CLoanOrderBean>> l0(int i11, C2CloanOrderDirect c2CloanOrderDirect, int i12, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", Integer.valueOf(i11));
        hashMap.put(DevicePublicKeyStringDef.DIRECT, Integer.valueOf(c2CloanOrderDirect.direct));
        hashMap.put("limit", Integer.valueOf(i12));
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CLoanOrders(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<HbgIntCodeResponse<String>> m(List<String> list) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postUsdtExchange(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson((Object) new HtExchangeRequest(list)))));
    }

    public d9.a<ArrayList<String>> m0(String str, String str2) {
        MultipartBody.Part part = null;
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.exists()) {
                part = MultipartBody.Part.createFormData("files", file.getPath().substring(str2.lastIndexOf("/") + 1), RequestBody.create(MediaType.parse("application/zip"), file));
            }
        }
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).uploadUserLog(RequestBody.create(MediaType.parse("text/plain"), str), part).compose(HbgRetrofit.e()));
    }

    public d9.a<Long> n() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getDialogTime().compose(HbgRetrofit.e()));
    }

    public d9.a<String> n0(boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("activation", Integer.valueOf(z11 ? 1 : 0));
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postProfitActivation(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<RankJumpInfo> o(int i11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i11));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("screen", str);
        }
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getRankJump(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<String> o0(String str, int i11, int i12, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("runType", Integer.valueOf(i11));
        hashMap.put("gridNum", Integer.valueOf(i12));
        hashMap.put("minPrice", str2);
        hashMap.put("maxPrice", str3);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getMinAmount(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<AutoOrderResult> orderPlaceAuto(Map<String, Object> map) {
        RetrofitLogger.h(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, "一键借贷下单:" + new Gson().toJson((Object) map));
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).orderPlaceAuto(map).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> p(String str, String str2, int i11, int i12) {
        HashMap hashMap = new HashMap();
        hashMap.put("shareGroups", str);
        hashMap.put("message", str2);
        hashMap.put("business", Integer.valueOf(i11));
        hashMap.put("messageType", Integer.valueOf(i12));
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postGroupShare(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<String> p0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).joinLive(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postH5UrlRequest(str, map, map2));
    }

    public d9.a<ShareConfig> postShareConfig(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postShareConfig(map).compose(HbgRetrofit.e()));
    }

    public d9.a<String> potentialOrderPlace(Map<String, Object> map) {
        RetrofitLogger.h(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, "创新区下单:" + new Gson().toJson((Object) map));
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).potentialOrderPlace(map).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> q(List<Integer> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("questionList", list);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestIntegrationQuestionSubmit(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<AccountChallengeTask.SignInResp> q0(long j11, long j12) {
        HashMap hashMap = new HashMap();
        hashMap.put("activityId", Long.valueOf(j11));
        hashMap.put("userTaskId", Long.valueOf(j12));
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).userSignIn(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<ServerCurDate> queryCurDate() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).queryCurDate().compose(HbgRetrofit.e()));
    }

    public void r(boolean z11, String str, int i11, C2CMarketDepthListener c2CMarketDepthListener) {
        RetrofitLogger.a(this.f70294c + "-->subscribeC2CMarketDepth--> isSubscribe:" + z11 + " currency:" + str + " term:" + i11 + " listener:" + c2CMarketDepthListener);
        i iVar = this.f70292a;
        if (iVar != null) {
            iVar.u(new C2CMarketDepthSub(z11, str, i11), c2CMarketDepthListener);
        }
    }

    public d9.a<String> r0(String str, String str2, String str3) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(FirebaseAnalytics.Param.CURRENCY, str);
        arrayMap.put(Constants.FLAG_ACCOUNT, str2);
        arrayMap.put("userCost", str3);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).updateAverageCostManu(arrayMap).compose(HbgRetrofit.e()));
    }

    public d9.a<RedPacketInfoBean> redPacketInfo(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).redPacketInfo(str).timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> removeCard(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).removeCard(map).compose(HbgRetrofit.e()));
    }

    public d9.a<String> removeLogUserId(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).removeLogUserId(str).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> removeUserInGroup(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).removeUserInGroup(map).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> requestBulkUserInfo() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestBulkUserInfo().timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public d9.a<List<C2CAccountInNetAssetResult>> requestC2CAccountInNetAsset() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CAccountInNetAsset().compose(HbgRetrofit.e()));
    }

    public d9.a<C2CAccountOutNetAssetResult> requestC2CAccountOutNetAsset() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CAccountOutNetAsset().compose(HbgRetrofit.e()));
    }

    public d9.a<List<C2CCurrencyBean>> requestC2CCurrencys() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CCurrencys().compose(HbgRetrofit.e()));
    }

    public d9.a<C2CLendThresholdGetAssetInfo> requestC2CLendThresholdGetAsset(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CLendThresholdGetAsset(str).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> requestC2CLoanOrderCancel(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CLoanOrderCancel(str).compose(HbgRetrofit.e()));
    }

    public d9.a<List<C2CSymbolBean>> requestC2CSymbols() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CSymbols().compose(HbgRetrofit.e()));
    }

    public d9.a<List<C2CTransferOutQuotaInfo>> requestC2CTransferOutQuota(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestC2CTransferOutQuota(str).compose(HbgRetrofit.e()));
    }

    public d9.a<Map<String, String>> requestCardState() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestCardState().compose(HbgRetrofit.e()));
    }

    public d9.a<Boolean> requestCommunityAttention(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestCommunityAttention(map).compose(HbgRetrofit.e()));
    }

    public d9.a<GridLeverageRange> requestContractGridLeverageRange(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestContractGridLeverageRange(str).compose(HbgRetrofit.e()));
    }

    public d9.a<GridSupportedSymbol> requestContractGridSymbols() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestContractGridSymbols().compose(HbgRetrofit.e()));
    }

    public d9.a<CopyTradingAssetInfo> requestCopyTradingAssetInfo(int i11, String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestCopyTradingAssetInfo(i11, str).compose(HbgRetrofit.e()));
    }

    public d9.a<TraderRank> requestCopyTradingRank(String str, Integer num, int i11, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestCopyTradingRank(str, num, i11, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<CopyTradingAccountTransferRecord> requestCopyTradingTransferRecord(Integer num, int i11, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestCopyTradingTransferRecord(num, i11, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<NewBannerBean> requestNewBanner(int i11, int i12, String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestNewBanner(i11, i12, str).compose(HbgRetrofit.e()));
    }

    public d9.a<GridStrategyInfo> requestStrategyInfo(String str) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).requestStrategyInfo(str).compose(HbgRetrofit.e()));
    }

    public d9.a<HbgIntCodeResponse<String>> s(List<String> list) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postHtExchange(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson((Object) new HtExchangeRequest(list)))));
    }

    public d9.a<Boolean> s0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("interest", str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).interestTagEdit(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<Boolean> savingsCheckPermission() {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).savingsCheckPermission().compose(HbgRetrofit.e()));
    }

    public d9.a<Object> setGroupManager(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).setGroupManager(map).compose(HbgRetrofit.e()));
    }

    public d9.a<String> setStareConfig(String str, int i11, int i12) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).setStareConfig(str, i11, i12).compose(HbgRetrofit.e()));
    }

    public d9.a<String> t(int i11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i11));
        hashMap.put("uidUnique", str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).userMute(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<Map<String, List<SpotConfigInfo>>> t0(String str) {
        HashMap hashMap = new HashMap(1);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("types", str);
        }
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getSpotConfigInfoMap(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<TranslateBean> translateContent(String str, int i11, String str2) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).translateContent(str, i11, str2).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> u(long j11, long j12, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("beginDate", Long.valueOf(j11));
        hashMap.put("endDate", Long.valueOf(j12));
        hashMap.put(AppsFlyerProperties.USER_EMAIL, str);
        hashMap.put("2faToken", str2);
        hashMap.put("type", str3);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).getAppleHistorySubmit(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<AirdropResultBean> u0(int i11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("topicType", Integer.valueOf(i11));
        if (!str.isEmpty()) {
            hashMap.put(CommunityConstants.TOPIC_ID, str);
        }
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).airdropDraw(hashMap).timeout(30, TimeUnit.SECONDS).compose(HbgRetrofit.e()));
    }

    public d9.a<Map<String, String>> updateBillingAddress(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).updateBillingAddress(map).compose(HbgRetrofit.e()));
    }

    public d9.a<UploadFile> uploadFile(MultipartBody.Part part) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).uploadFile(part).compose(HbgRetrofit.e()));
    }

    public d9.a<String> uploadUserLogInfo(Map<String, Object> map) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).uploadUserLogInfo(map).compose(HbgRetrofit.e()));
    }

    public d9.a<String> v(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("uidUnique", str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).userUnMute(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<LiveAppointmentData> v0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).liveAppointment(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> w(String str, String str2, String str3, String str4, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str3);
        hashMap.put("amount", str4);
        hashMap.put("type", z11 ? FinanceRecordItem.TYPE_PRO_TO_OTC_OPTIONS : FinanceRecordItem.TYPE_OTC_OPTIONS_TO_PRO);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("device-vToken", str);
        hashMap2.put("device-fbToken", str2);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).optionTransferIn(hashMap, hashMap2).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> w0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).liveVideoRecover(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<List<CurrencyFromCCRouteChannelData>> x(String str, String str2, String str3, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2);
        hashMap.put("type", str3);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).queryPayRouteChannelList(hashMap, map).compose(HbgRetrofit.e()));
    }

    public d9.a<HbgIntCodeResponse<String>> x0(String str, String str2) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("groupId", str);
        arrayMap.put(RemoteMessageConst.NOTIFICATION, str2);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).pushNotificationNew(arrayMap));
    }

    public d9.a<HbgIntCodeResponse<String>> y(List<String> list) {
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postCheckHtExchange(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson((Object) new HtExchangeRequest(list)))));
    }

    public d9.a<Object> y0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("dynamicId", str);
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).delDynamic(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<DynamicDetailInfo> z(String str, String str2, String str3, String str4, String str5, int i11, String str6, String str7) {
        HashMap hashMap = new HashMap();
        hashMap.put("title", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("content", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("imgs", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("richText", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(CommunityConstants.TOPIC_ID, str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("shareTitle", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("path", str7);
        }
        hashMap.put("topicType", Integer.valueOf(i11));
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).postDynamic(hashMap).compose(HbgRetrofit.e()));
    }

    public d9.a<Object> z0(Integer num, Integer num2) {
        HashMap hashMap = new HashMap();
        if (num != null) {
            hashMap.put("isAnswer", num);
        }
        if (num2 != null) {
            hashMap.put("isNewUser", num2);
        }
        return new d9.a<>(((HbgService) HbgRetrofit.request(HbgService.class)).gridAuthSubmit(hashMap).compose(HbgRetrofit.e()));
    }
}
