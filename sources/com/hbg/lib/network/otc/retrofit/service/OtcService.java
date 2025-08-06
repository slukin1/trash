package com.hbg.lib.network.otc.retrofit.service;

import com.google.gson.JsonObject;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.bean.AdvertVerifyCapitalConfigBean;
import com.hbg.lib.network.otc.core.bean.AgencyKycUserBean;
import com.hbg.lib.network.otc.core.bean.BaseSettingBean;
import com.hbg.lib.network.otc.core.bean.BlockInfoBean;
import com.hbg.lib.network.otc.core.bean.CardOrderPayResultBean;
import com.hbg.lib.network.otc.core.bean.ConfigEntranceCurrencyInfoBean;
import com.hbg.lib.network.otc.core.bean.ConfigEntranceInfoBean;
import com.hbg.lib.network.otc.core.bean.DialPhoneResponseBean;
import com.hbg.lib.network.otc.core.bean.DialStatusResponseBean;
import com.hbg.lib.network.otc.core.bean.FaceVerifyPortalBean;
import com.hbg.lib.network.otc.core.bean.FastBuyBean;
import com.hbg.lib.network.otc.core.bean.FastTradePaymentBean;
import com.hbg.lib.network.otc.core.bean.FunctionAvailableBean;
import com.hbg.lib.network.otc.core.bean.LiteMarketBuyHint;
import com.hbg.lib.network.otc.core.bean.LiteMarketDetail;
import com.hbg.lib.network.otc.core.bean.LiteMarketPrice;
import com.hbg.lib.network.otc.core.bean.MakerAdsConfigBean;
import com.hbg.lib.network.otc.core.bean.MarketMergedInfo;
import com.hbg.lib.network.otc.core.bean.MarketPrice;
import com.hbg.lib.network.otc.core.bean.MerchantInfo;
import com.hbg.lib.network.otc.core.bean.MktRuleBean;
import com.hbg.lib.network.otc.core.bean.OnLineStatusBean;
import com.hbg.lib.network.otc.core.bean.OrdId;
import com.hbg.lib.network.otc.core.bean.OrderCancelMaxNumBean;
import com.hbg.lib.network.otc.core.bean.OrderInfoListBean;
import com.hbg.lib.network.otc.core.bean.OrderPhone;
import com.hbg.lib.network.otc.core.bean.OssSignBean;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.OtcCancelReasonBean;
import com.hbg.lib.network.otc.core.bean.OtcChatOnlineCheck;
import com.hbg.lib.network.otc.core.bean.OtcChatUnread;
import com.hbg.lib.network.otc.core.bean.OtcConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcContactsResponseBean;
import com.hbg.lib.network.otc.core.bean.OtcCountryBean;
import com.hbg.lib.network.otc.core.bean.OtcCurrencyBean;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.hbg.lib.network.otc.core.bean.OtcLastBlock;
import com.hbg.lib.network.otc.core.bean.OtcLiteCollection;
import com.hbg.lib.network.otc.core.bean.OtcOneKeyBuyConfig;
import com.hbg.lib.network.otc.core.bean.OtcOrderDetailBean;
import com.hbg.lib.network.otc.core.bean.OtcPaymentBean;
import com.hbg.lib.network.otc.core.bean.OtcPaymentRecommendResponse;
import com.hbg.lib.network.otc.core.bean.OtcPaymentTemplateInfo;
import com.hbg.lib.network.otc.core.bean.OtcQueryData;
import com.hbg.lib.network.otc.core.bean.OtcQuickQuoteResultBean;
import com.hbg.lib.network.otc.core.bean.OtcSenior;
import com.hbg.lib.network.otc.core.bean.OtcTermsUrlBean;
import com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean;
import com.hbg.lib.network.otc.core.bean.OtcUploadPicBean;
import com.hbg.lib.network.otc.core.bean.OtcUserActivityInfo;
import com.hbg.lib.network.otc.core.bean.P2PPayMethodBean;
import com.hbg.lib.network.otc.core.bean.PurchasePriceBean;
import com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean;
import com.hbg.lib.network.otc.core.bean.SmallCoinReLockPriceBean;
import com.hbg.lib.network.otc.core.bean.ThirdOrderId;
import com.hbg.lib.network.otc.core.bean.TradeGuideDataBean;
import com.hbg.lib.network.otc.core.bean.TradeReMarkBean;
import com.hbg.lib.network.otc.core.bean.TradingHoseConfigBean;
import com.hbg.lib.network.otc.core.bean.TradingHoseOrderSuccessBean;
import com.hbg.lib.network.otc.core.bean.TradingHoseQuoteBean;
import com.hbg.lib.network.otc.core.bean.TradingStatus;
import com.hbg.lib.network.otc.core.bean.UserAssetLimitBean;
import com.hbg.lib.network.otc.core.bean.UserEmailBean;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.otc.core.bean.UserVerifyWaysBean;
import com.hbg.lib.network.otc.core.bean.VerifyResultBean;
import com.hbg.lib.network.otc.core.bean.WalletCoinBean;
import com.huobi.account.entity.LegalQueryData;
import com.huobi.account.entity.OTCKycInfo;
import com.huobi.otc.bean.OtcU1000DetailBean;
import com.huobi.otc.bean.OtcU1000bean;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface OtcService {
    @POST("v1/risk/action/au-dvs")
    Observable<OTCStatusResponse<Object>> actionAuDvs();

    @GET("v1/data/config-trade")
    Observable<OTCStatusResponse<MakerAdsConfigBean>> adsConfigTrade(@Query("blockType") String str, @Query("coinId") String str2, @Query("currencyId") String str3, @Query("tradeType") String str4);

    @GET("v1/user/kyc/pull")
    Observable<OTCStatusResponse<String>> authPull();

    @POST("v1/risk/page/element")
    Observable<OTCStatusExtendResponse<MktRuleBean>> bindCardMktRule(@Body Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/trade/appeal/cancel")
    Observable<OTCStatusResponse<Boolean>> cancelAppealOrder(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("v1/otc/order/{orderId}/appeal/cancel")
    Observable<OTCStatusResponse<Void>> cancelComplainOrder(@Path("orderId") String str, @Field("orderId") String str2);

    @FormUrlEncoded
    @POST("v1/trade/order/cancelconsult/commit")
    Observable<OTCStatusResponse<Boolean>> cancelConsultCommit(@FieldMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/trade/order/cancelconsult/update")
    Observable<OTCStatusResponse<Object>> cancelConsultUpdate(@Field("orderId") String str, @Field("orderCancelConsultStatus") String str2);

    @FormUrlEncoded
    @POST("v1/trade/order/cancel")
    Observable<OTCStatusResponse<Boolean>> cancenlOrder(@FieldMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/user/receipt-account/{id}")
    Observable<OTCStatusResponse<Boolean>> changeActivatePayMethod(@Path("id") String str, @Field("type") String str2);

    @GET("v1/user/online")
    Observable<OTCStatusResponse<List<OtcChatOnlineCheck>>> chatOnlineCheck(@Query("userIds") long... jArr);

    @FormUrlEncoded
    @POST("v1/chat/read")
    Observable<OTCStatusResponse<Object>> chatRead(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("v1/trade/fast/settle/expire")
    Observable<OTCStatusResponse<Boolean>> chooseSmallCoin(@Field("orderId") String str, @Field("quoteToken") String str2, @Field("assetName") String str3);

    @FormUrlEncoded
    @POST("v1/otc/order/{orderId}/appeal")
    Observable<OTCStatusResponse<String>> complainOrder(@Path("orderId") String str, @Field("orderId") String str2, @Field("type") String str3, @Field("reason") String str4);

    @GET("v1/trade/fast/config/entrance/info")
    Observable<OTCStatusResponse<ConfigEntranceInfoBean>> configEntranceInfo(@Query("countryId") String str, @Query("onlyCurrency") boolean z11, @Query("currency") String str2);

    @GET("v1/otc/base/config/gray/list")
    Observable<OTCStatusResponse<List<Integer>>> configGrayList();

    @FormUrlEncoded
    @POST("v1/trade/exchange/order")
    Observable<OTCStatusResponse<TradingHoseOrderSuccessBean>> confirmTradingHoseOrder(@Field("quoteToken") String str);

    @GET("v1/trade/contact/merchant/contact-list")
    Observable<OTCStatusResponse<OtcContactsResponseBean>> contactList(@Query("orderId") String str);

    @FormUrlEncoded
    @POST("v1/fiat/fast/place")
    Observable<OTCStatusExtendResponse<OrdId>> createMatchOrder(@FieldMap Map<String, Object> map, @Header("x-dialog-trace-id") String str);

    @FormUrlEncoded
    @POST("v1/fiat/fast/third/place")
    Observable<OTCStatusExtendResponse<ThirdOrderId>> createThirdOrder(@FieldMap Map<String, Object> map, @Header("x-dialog-trace-id") String str);

    @POST("v1/risk/page/element/batch")
    Observable<OTCStatusResponse<List<MktRuleBean>>> depositOperationBatch(@Body Map<String, List<Map<String, Object>>> map);

    @FormUrlEncoded
    @POST("v1/voice/order/phone")
    Observable<OTCStatusResponse<DialPhoneResponseBean>> dialPhone(@Field("type") String str, @Field("orderId") String str2, @Field("phone") String str3, @Field("smsToken") String str4);

    @GET("v1/voice/order/info")
    Observable<OTCStatusResponse<DialStatusResponseBean>> dialStatus(@Query("orderId") String str);

    @GET("v1/trade/fast/config/entrance/currency/info")
    Observable<OTCStatusResponse<ConfigEntranceCurrencyInfoBean>> entranceCurrencyInfo(@Query("currency") String str);

    @FormUrlEncoded
    @POST("v1/faq/like")
    Observable<OTCStatusResponse<Object>> faqLike(@FieldMap Map<String, Object> map);

    @GET("v1/trade/fast/config/list")
    Observable<OTCStatusResponse<List<OtcTradeConfigListBean>>> fastTradeConfigList(@Query("side") String str, @Query("tradeMode") String str2);

    @GET("v1/trade/fast/config/list")
    Observable<Response<JsonObject>> fastTradeConfigListFlutter(@QueryMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/trade/order/appeal/premature")
    Observable<OTCStatusResponse<Boolean>> forceRelease(@FieldMap Map<String, Object> map);

    @GET("v1/risk/function/available")
    Observable<OTCStatusResponse<FunctionAvailableBean>> functionAvailable(@Query("id") String str);

    @GET("v1/advertise/activity/effective")
    Observable<OtcU1000bean> get1000UAvailable();

    @GET("v1/advertise/activity/detail")
    Observable<OtcU1000DetailBean> get1000UDetail();

    @GET("v1/data/trade/verify/capital/config")
    Observable<OTCStatusResponse<List<AdvertVerifyCapitalConfigBean>>> getAdvertVerifyCapitalConfigs();

    @GET("v1/user/kyc/getAgencyKycUser")
    Observable<OTCStatusResponse<AgencyKycUserBean>> getAgencyKycUser();

    @GET("v1/user/system/setting/key?key=blueshieldIntroUrl,hbgSlowRequestTime,orderNotSupportedTips_i18n")
    Observable<OTCStatusResponse<BaseSettingBean>> getBaseSystemSetting();

    @GET("v1/data/trade/create/limit/block")
    Observable<OTCStatusResponse<List<BlockInfoBean>>> getBlockList();

    @GET("v1/trade/prcrule/run")
    Observable<OTCStatusExtendResponse<List<OtcCancelReasonBean>>> getCancelReason(@Query("orderId") String str);

    @GET("v1/chat/unread-all")
    Observable<OTCStatusResponse<OtcChatUnread>> getChatUnReadAll();

    @GET("v1/chat/unread-order")
    Observable<OTCStatusResponse<List<OtcChatUnread>>> getChatUnread(@Query("orderIds") String str);

    @GET("v1/capital/wallet/{coinId}")
    Observable<OTCStatusResponse<WalletCoinBean>> getCoinWalletInfo(@Path("coinId") int i11);

    @GET("v1/data/base/country")
    Observable<OTCStatusResponse<List<OtcCountryBean>>> getCountryList();

    @GET("v1/data/base/currency")
    Observable<OTCStatusResponse<List<OtcCurrencyBean>>> getCurrencyList();

    @FormUrlEncoded
    @POST("v1/activity/fiat/user/dayOpenGift")
    Observable<OTCStatusResponse<OtcUserActivityInfo>> getDayOpenGift(@Field("key") String str);

    @GET("v1/fiat/fast/base/config")
    Observable<OTCStatusResponse<QuickTradeConfigBean>> getExpressConfig();

    @GET("v1/faq/config")
    Observable<OTCStatusResponse<List<OtcFAQBean>>> getFAQConfig(@QueryMap Map<String, Object> map);

    @GET("v1/user/system/setting/key?key=fastbuyTips_i18n,fastbuyRefreshInterval")
    Observable<OTCStatusResponse<FastBuyBean>> getFastBuySystemSetting();

    @GET("v1/otc/trade/match/global/payment")
    Observable<OTCStatusResponse<List<FastTradePaymentBean>>> getFastTradePayments(@Query("matchType") int i11, @Query("payId") String str, @Query("currencyId") String str2);

    @GET
    Observable<ResponseBody> getH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @QueryMap Map<String, Object> map2);

    @GET("v1/capital/lite/balance")
    Observable<OTCStatusResponse<OtcLiteCollection>> getLiteWallet();

    @GET("/v1/otc/order/trading-house/hint/info")
    Observable<OTCStatusResponse<LiteMarketBuyHint>> getMarketBuyTips(@Query("currencyId") String str);

    @GET("/v1/market/detail")
    Observable<OTCStatusResponse<LiteMarketDetail>> getMarketDetail(@Query("currencyName") String str, @Query("period") String str2, @Query("coinName") String str3);

    @GET("v1/market/merged")
    Observable<OTCStatusResponse<List<MarketMergedInfo>>> getMarketMergedList(@Query("currencyName") String str, @Query("merged") String str2, @Query("coinName") String str3);

    @GET("/v1/market/price")
    Observable<OTCStatusResponse<LiteMarketPrice>> getMarketPrice(@Query("currencyName") String str, @Query("period") String str2, @Query("coinName") String str3);

    @GET("v1/data/config-list?type=price")
    Observable<OTCStatusResponse<MarketPrice>> getMarketPriceList();

    @GET("v1/trade/free/config/maximum/cancel")
    Observable<OTCStatusResponse<OrderCancelMaxNumBean>> getMaximumCancel(@Query("roleId") int i11);

    @GET("v1/user/{userId}/info")
    Observable<OTCStatusResponse<MerchantInfo>> getMerchantInfo(@Path("userId") long j11);

    @GET("v1/user/kyc")
    Observable<OTCStatusResponse<OTCKycInfo>> getOTCKycInfo();

    @GET("v1/trade/activity/novice/popup/guide")
    Observable<TradeGuideDataBean> getOTCTradeGuideData();

    @GET("v1/user/online/info")
    Observable<OTCStatusResponse<OnLineStatusBean>> getOnLineStatus(@Query("userId") String str);

    @GET("v1/data/config/global/purchase")
    Observable<OTCStatusResponse<OtcOneKeyBuyConfig>> getOneKeyBuyConfig(@Query("matchType") int i11, @Query("currencyId") String str);

    @GET("v1/trade/order")
    Observable<OTCStatusResponse<OtcOrderDetailBean>> getOrderDetail(@Query("orderId") String str, @Query("pageSource") String str2);

    @GET("v1/data/order/last-block")
    Observable<OTCStatusResponse<OtcLastBlock>> getOrderLastBlock();

    @GET("v1/trade/order/list")
    Observable<OTCStatusResponse<List<OrderInfoListBean>>> getOrderList(@QueryMap Map<String, String> map);

    @GET("v1/otc/order/{orderId}/phone")
    Observable<OTCStatusResponse<OrderPhone>> getOrderPhoneInfo(@Path("orderId") String str, @Query("orderId") String str2);

    @GET("v1/upload/post/sign")
    Observable<OssSignBean> getOssUploadSign(@Query("name") String str, @Query("type") String str2, @Query("businessType") String str3, @Query("version") Integer num);

    @GET("v1/data/config-list?type=coin")
    Observable<OTCStatusResponse<OtcConfigBean>> getOtcBaseConfigCoin();

    @GET("v1/data/config-list?type=country")
    Observable<OTCStatusResponse<OtcConfigBean>> getOtcBaseConfigCountry();

    @GET("v1/data/config-list?type=currency")
    Observable<OTCStatusResponse<OtcConfigBean>> getOtcBaseConfigCurrency();

    @GET("v1/data/config-list?type=senior")
    Observable<OTCStatusResponse<OtcSenior>> getOtcSenior();

    @GET("v1/user/system/setting/key?key=otcTermsUrl")
    Observable<OTCStatusResponse<OtcTermsUrlBean>> getOtcTermsUrl();

    @GET("v1/p2p/base/config/payMethod/list")
    Observable<OTCStatusResponse<List<P2PPayMethodBean>>> getPayMethodByFiat(@Query("currencyName") String str);

    @GET("v1/user/receipt-account")
    Observable<OTCStatusResponse<List<OtcPaymentBean>>> getPayMethods();

    @GET("v1/user/receipt-account/dynamicModelInfo")
    Observable<OTCStatusResponse<OtcPaymentTemplateInfo>> getPaymentTemplate(@Query("payMethodIds") int i11);

    @GET("v1/trade/fast/config/price")
    Observable<OTCStatusResponse<PurchasePriceBean>> getPurchasePrice(@Query("cryptoAsset") String str, @Query("quoteAsset") String str2, @Query("side") String str3, @Query("tradeMode") String str4);

    @GET("v1/data/recommend/payments")
    Observable<OTCStatusResponse<OtcPaymentRecommendResponse>> getRecommendPayments(@Query("currency") String str, @Query("needPayMethod") boolean z11);

    @FormUrlEncoded
    @POST("v1/user/login")
    Observable<OTCStatusResponse<String>> getTicket(@FieldMap Map<String, Object> map);

    @GET("v1/otc/order/trading-house/config")
    Observable<OTCStatusResponse<List<TradingHoseConfigBean>>> getTradingHouseConfig(@Query("baseCoinId") int i11, @Query("quoteCoinId") int i12, @Query("matchType") int i13);

    @GET("v1/trade/exchange/quote")
    Observable<OTCStatusResponse<List<TradingHoseQuoteBean>>> getTradingHouseQuote(@QueryMap Map<String, Object> map);

    @GET("/v1/data/trading/status")
    Observable<OTCStatusResponse<TradingStatus>> getTradingStatus();

    @GET("v1/user/info")
    Observable<OTCStatusResponse<UserVO>> getUser();

    @GET("v1/activity/fiat/user/info")
    Observable<OTCStatusResponse<OtcUserActivityInfo>> getUserActivityInfo();

    @GET("v1/trade/contact/user/email")
    Observable<OTCStatusResponse<List<UserEmailBean>>> getUserEmail();

    @GET("v1/trade/fast/config")
    Observable<OTCStatusResponse<UserAssetLimitBean>> getUserLimitAsset(@Query("cryptoAsset") String str, @Query("quoteAsset") String str2, @Query("side") String str3, @Query("tradeMode") String str4);

    @GET("v1/capital/balance")
    Observable<OTCStatusResponse<List<OtcQueryData>>> getWallet();

    @GET("v1/capital/balance")
    Observable<OTCStatusResponse<List<LegalQueryData>>> getWallet2();

    @GET("v1/capital/balance")
    Observable<Response<JsonObject>> getWalletFlutter();

    @GET("/v1/data/order/exist")
    Observable<OTCStatusResponse<Integer>> isUserOrderExisted();

    @GET("v1/user/system/setting/key?key=wsBaseUrl,acceptGuideLimit,goWebVerification,goWebDeposit,balanceTradeConfig,neofiAgreementUrl,chatWsSwitch,simplexRequestNew,simplexTerms,countryLocalName,vndBuyNftVisible,mercuryoAgreementUrl,mercuryoTerms,banxaAgreementUrl,banxaSupportUrl,krabitiTerms,krabitiSupportUrl,downgradeFundPassword")
    Observable<OTCStatusResponse<BaseSettingBean>> loadApolloConfig();

    @FormUrlEncoded
    @POST("/v1/face/verify/result")
    Observable<OTCStatusResponse<VerifyResultBean>> loadFaceVerifyResult(@Field("bizId") String str);

    @FormUrlEncoded
    @POST("/v1/face/verify/portal/identity")
    Observable<OTCStatusResponse<FaceVerifyPortalBean>> loadLiteVerifyPortal(@Field("identityName") String str, @Field("identityNumber") String str2);

    @FormUrlEncoded
    @POST("/v1/face/verify/portal")
    Observable<OTCStatusResponse<FaceVerifyPortalBean>> loadVerifyPortal(@Field("scene") String str, @Field("type") String str2, @Field("tsvToken") String str3);

    @GET("v1/trade/mktRule/run")
    Observable<OTCStatusResponse<MktRuleBean>> mktRule(@QueryMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/user/receipt-account/modifyByDynamicModel")
    Observable<OTCStatusResponse<Boolean>> modifyPayMethod(@FieldMap Map<String, Object> map);

    @GET("v1/trade/order/pay/result")
    Observable<OTCStatusResponse<CardOrderPayResultBean>> orderPayResult(@Query("orderId") String str, @Query("callback") boolean z11);

    @POST
    @Multipart
    Observable<Response<OtcUploadPicBean>> ossUploadPicture(@Url String str, @PartMap Map<String, RequestBody> map, @Part MultipartBody.Part part);

    @GET
    Observable<Response<JsonObject>> otcGet(@Url String str, @QueryMap Map<String, Object> map, @HeaderMap Map<String, Object> map2);

    @POST
    Observable<Response<JsonObject>> otcPostBody(@Url String str, @Body Map<String, Object> map, @HeaderMap Map<String, Object> map2);

    @FormUrlEncoded
    @POST
    Observable<Response<JsonObject>> otcPostFormUrlEncoded(@Url String str, @FieldMap Map<String, Object> map, @HeaderMap Map<String, Object> map2);

    @POST
    Observable<Response<JsonObject>> otcPostNoBody(@Url String str, @HeaderMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/trade/order/pay")
    Observable<OTCStatusResponse<Boolean>> payOrder(@Field("orderId") String str, @Field("paymentId") String str2);

    @FormUrlEncoded
    @POST("v1/trade/free/order")
    Observable<OTCStatusExtendResponse<OrdId>> placeOrder(@FieldMap Map<String, Object> map, @Header("x-dialog-trace-id") String str);

    @FormUrlEncoded
    @POST("v1/trade/free/order")
    Observable<Response<JsonObject>> placeOrderFlutter(@FieldMap Map<String, Object> map, @Header("x-dialog-trace-id") String str);

    @POST
    Observable<ResponseBody> postH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @Body Map<String, Object> map2);

    @GET("v1/fiat/fast/quote")
    Observable<OTCStatusResponse<List<OtcQuickQuoteResultBean>>> quickQuote(@QueryMap Map<String, String> map);

    @GET("v1/trade/fast/settle/quote")
    Observable<OTCStatusResponse<SmallCoinReLockPriceBean>> recLockOrder(@Query("orderId") String str);

    @FormUrlEncoded
    @POST("v1/trade/order/finish")
    Observable<OTCStatusResponse<Boolean>> releaseOrderCoin(@FieldMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("/v1/user/receipt-account/remove")
    Observable<OTCStatusResponse<String>> removePayMethod(@FieldMap Map<String, Object> map);

    @GET("v1/trade/free/quote")
    Observable<OTCStatusExtendResponse<OtcAdTicket>> requestFreeQuote(@Query("tradeId") String str, @Query("isContinue") Boolean bool, @Header("x-dialog-trace-id") String str2);

    @GET("v1/trade/free/quote")
    Observable<Response<JsonObject>> requestFreeQuoteFlutter(@Query("tradeId") String str, @Query("isContinue") Boolean bool, @Header("x-dialog-trace-id") String str2);

    @FormUrlEncoded
    @POST("v1/chat/{orderId}")
    Observable<OTCStatusResponse<Response<Object>>> saveChatContent(@Path("orderId") String str, @Field("content") String str2, @Field("type") String str3);

    @FormUrlEncoded
    @POST("v1/user/receipt-account/addByDynamicModel")
    Observable<OTCStatusResponse<Object>> savePayMethod(@FieldMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/user/setting/trade/pass")
    Observable<OTCStatusResponse<String>> setTradePass(@Field("tradePass") String str, @Field("ucPass") String str2, @Field("authToken") String str3);

    @FormUrlEncoded
    @POST("v1/trade/order/accept")
    Observable<OTCStatusResponse<Object>> tradeOrderAccept(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("v1/trade/order/accept/cancel")
    Observable<OTCStatusResponse<Object>> tradeOrderAcceptCancel(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("v1/trade/order/accept/refuse")
    Observable<OTCStatusResponse<Object>> tradeOrderAcceptRefuse(@Field("orderId") String str);

    @GET("v1/data/trade/remark")
    Observable<OTCStatusResponse<TradeReMarkBean>> tradeRemark(@Query("tradeId") String str);

    @GET("v1/data/trade/remark")
    Observable<Response<JsonObject>> tradeRemarkFlutter(@Query("tradeId") String str);

    @FormUrlEncoded
    @POST("v1/otc/order/{orderId}/phone")
    Observable<OTCStatusResponse<OrderPhone>> updateOrderPhoneInfo(@Path("orderId") String str, @Field("orderId") String str2, @Field("phone") String str3);

    @FormUrlEncoded
    @POST("v1/user/trade-pass")
    Observable<OTCStatusResponse<Boolean>> updateTradePass(@FieldMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/user/init")
    Observable<OTCStatusResponse<Boolean>> updateUser(@FieldMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/user/relation/change/{uid}")
    Observable<OTCStatusResponse<Object>> userRelationChange(@Path("uid") String str, @FieldMap Map<String, Object> map);

    @GET("v1/user/verify/ways")
    Observable<OTCStatusResponse<UserVerifyWaysBean>> userVerifyWays();
}
