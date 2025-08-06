package com.hbg.lib.network.otc.retrofit;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.bean.AdvertVerifyCapitalConfigBean;
import com.hbg.lib.network.otc.core.bean.AgencyKycUserBean;
import com.hbg.lib.network.otc.core.bean.BaseSettingBean;
import com.hbg.lib.network.otc.core.bean.DialPhoneResponseBean;
import com.hbg.lib.network.otc.core.bean.FaceVerifyPortalBean;
import com.hbg.lib.network.otc.core.bean.FunctionAvailableBean;
import com.hbg.lib.network.otc.core.bean.LiteMarketBuyHint;
import com.hbg.lib.network.otc.core.bean.LiteMarketDetail;
import com.hbg.lib.network.otc.core.bean.LiteMarketPrice;
import com.hbg.lib.network.otc.core.bean.MarketMergedInfo;
import com.hbg.lib.network.otc.core.bean.MarketPrice;
import com.hbg.lib.network.otc.core.bean.MktRuleBean;
import com.hbg.lib.network.otc.core.bean.OnLineStatusBean;
import com.hbg.lib.network.otc.core.bean.OrderInfoListBean;
import com.hbg.lib.network.otc.core.bean.OssSignBean;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.OtcCancelReasonBean;
import com.hbg.lib.network.otc.core.bean.OtcChatOnlineCheck;
import com.hbg.lib.network.otc.core.bean.OtcChatUnread;
import com.hbg.lib.network.otc.core.bean.OtcConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcContactsResponseBean;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.hbg.lib.network.otc.core.bean.OtcLiteCollection;
import com.hbg.lib.network.otc.core.bean.OtcOrderDetailBean;
import com.hbg.lib.network.otc.core.bean.OtcTermsUrlBean;
import com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean;
import com.hbg.lib.network.otc.core.bean.OtcUploadPicBean;
import com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean;
import com.hbg.lib.network.otc.core.bean.RequestOrderListBean;
import com.hbg.lib.network.otc.core.bean.TradeReMarkBean;
import com.hbg.lib.network.otc.core.bean.UserAssetLimitBean;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.otc.core.bean.UserVerifyWaysBean;
import com.hbg.lib.network.otc.core.wsbean.OtcOrderReminderOfflineSend;
import com.hbg.lib.network.otc.core.wsbean.PChatChannelBean;
import com.hbg.lib.network.otc.core.wsbean.PUnSubscribeChatBean;
import com.hbg.lib.network.otc.core.wsbean.SubOtcOrderReminderSend;
import com.hbg.lib.network.otc.core.wsbean.UnSubOtcOrderReminderSend;
import com.hbg.lib.network.otc.retrofit.service.OtcService;
import com.hbg.lib.network.retrofit.websocketnew.PSocketListenerDispatcher;
import com.hbg.lib.network.retrofit.websocketnew.d;
import com.huobi.account.entity.LegalQueryData;
import com.huobi.otc.bean.OtcU1000DetailBean;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;
import s8.b;

public class OtcApiRetrofitImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public d f70597a;

    /* renamed from: b  reason: collision with root package name */
    public c9.b f70598b;

    public class a extends TypeToken<Map<String, String>> {
        public a() {
        }
    }

    public static /* synthetic */ OtcConfigBean r(OtcConfigBean otcConfigBean, OtcConfigBean otcConfigBean2, OtcConfigBean otcConfigBean3) {
        OtcConfigBean otcConfigBean4 = new OtcConfigBean();
        otcConfigBean4.setCoinInfoList(otcConfigBean.getCoinInfoList());
        otcConfigBean4.setCountryBeans(otcConfigBean2.getCountryBeans());
        otcConfigBean4.setCurrencyBeans(otcConfigBean3.getCurrencyBeans());
        return otcConfigBean4;
    }

    public void a(String str, Context context, c9.b bVar) {
        this.f70598b = bVar;
        OtcRetrofit.g().init(str, context, bVar);
    }

    public d9.a<Object> actionAuDvs() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).actionAuDvs().compose(OtcRetrofit.o()));
    }

    public d9.a<String> authPull() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).authPull().compose(OtcRetrofit.o()));
    }

    public void b() {
        d dVar = this.f70597a;
        if (dVar != null) {
            dVar.g();
        }
    }

    public d9.a<OTCStatusExtendResponse<MktRuleBean>> bindCardMktRule(Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).bindCardMktRule(map));
    }

    public void c() {
        d dVar = this.f70597a;
        if (dVar != null) {
            dVar.m(new OtcOrderReminderOfflineSend());
        }
    }

    public d9.a<Boolean> cancelConsultCommit(Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).cancelConsultCommit(map).compose(OtcRetrofit.o()));
    }

    public d9.a<List<OtcChatOnlineCheck>> chatOnlineCheck(long... jArr) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).chatOnlineCheck(jArr).compose(OtcRetrofit.o()));
    }

    public d9.a<OTCStatusResponse<Object>> chatRead(Map<String, String> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).chatRead(map));
    }

    public d9.a<OtcContactsResponseBean> contactList(String str) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).contactList(str).compose(OtcRetrofit.o()));
    }

    public d9.a<OtcConfigBean> d() {
        Class cls = OtcService.class;
        return new d9.a<>(Observable.zip(((OtcService) OtcRetrofit.request(cls)).getOtcBaseConfigCoin().compose(OtcRetrofit.o()), ((OtcService) OtcRetrofit.request(cls)).getOtcBaseConfigCountry().compose(OtcRetrofit.o()), ((OtcService) OtcRetrofit.request(cls)).getOtcBaseConfigCurrency().compose(OtcRetrofit.o()), u8.b.f60549b));
    }

    public d9.a<List<MktRuleBean>> depositOperationBatch(Map<String, List<Map<String, Object>>> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).depositOperationBatch(map).compose(OtcRetrofit.o()));
    }

    public d9.a<DialPhoneResponseBean> dialPhone(String str, String str2, String str3, String str4) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).dialPhone(str, str2, str3, str4).compose(OtcRetrofit.o()));
    }

    public boolean e() {
        d dVar = this.f70597a;
        if (dVar != null) {
            return dVar.j();
        }
        return false;
    }

    public void f(String str) {
        d dVar = this.f70597a;
        if (dVar != null) {
            dVar.m(new PChatChannelBean(str));
        }
    }

    public d9.a<OTCStatusResponse<Object>> faqLike(Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).faqLike(map));
    }

    public d9.a<List<OtcTradeConfigListBean>> fastTradeConfigList(String str, String str2) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).fastTradeConfigList(str, str2).compose(OtcRetrofit.o()));
    }

    public d9.a<FunctionAvailableBean> functionAvailable(String str) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).functionAvailable(str).compose(OtcRetrofit.o()));
    }

    public d9.a<OssSignBean> g(String str, String str2, String str3) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getOssUploadSign(str, str2, str3, 1));
    }

    public d9.a<OtcU1000DetailBean> get1000UDetail() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).get1000UDetail());
    }

    public d9.a<OTCStatusResponse<List<AdvertVerifyCapitalConfigBean>>> getAdvertVerifyCapitalConfigs() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getAdvertVerifyCapitalConfigs());
    }

    public d9.a<AgencyKycUserBean> getAgencyKycUser() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getAgencyKycUser().compose(OtcRetrofit.o()));
    }

    public d9.a<OTCStatusExtendResponse<List<OtcCancelReasonBean>>> getCancelReason(String str) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getCancelReason(str));
    }

    public d9.a<OTCStatusResponse<OtcChatUnread>> getChatUnReadAll() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getChatUnReadAll());
    }

    public d9.a<OTCStatusResponse<List<OtcChatUnread>>> getChatUnread(String str) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getChatUnread(str));
    }

    public d9.a<QuickTradeConfigBean> getExpressConfig() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getExpressConfig().compose(OtcRetrofit.o()));
    }

    public d9.a<List<OtcFAQBean>> getFAQConfig(Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getFAQConfig(map).compose(OtcRetrofit.o()));
    }

    public d9.a<ResponseBody> getH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getH5UrlRequest(str, map, map2));
    }

    public d9.a<OtcLiteCollection> getLiteWallet() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getLiteWallet().compose(OtcRetrofit.o()));
    }

    public d9.a<LiteMarketBuyHint> getMarketBuyTips(String str) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getMarketBuyTips(str).compose(OtcRetrofit.o()));
    }

    public d9.a<LiteMarketDetail> getMarketDetail(String str, String str2, String str3) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getMarketDetail(str, str2, str3).compose(OtcRetrofit.o()));
    }

    public d9.a<List<MarketMergedInfo>> getMarketMergedList(String str, String str2, String str3) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getMarketMergedList(str, str2, str3).compose(OtcRetrofit.o()));
    }

    public d9.a<LiteMarketPrice> getMarketPrice(String str, String str2, String str3) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getMarketPrice(str, str2, str3).compose(OtcRetrofit.o()));
    }

    public d9.a<MarketPrice> getMarketPriceList() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getMarketPriceList().compose(OtcRetrofit.o()));
    }

    public d9.a<OTCStatusResponse<OnLineStatusBean>> getOnLineStatus(String str) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getOnLineStatus(str));
    }

    public d9.a<OtcTermsUrlBean> getOtcTermsUrl() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getOtcTermsUrl().compose(OtcRetrofit.o()));
    }

    public d9.a<String> getTicket(Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getTicket(map).compose(OtcRetrofit.o()));
    }

    public d9.a<UserVO> getUser() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getUser().compose(OtcRetrofit.o()));
    }

    public d9.a<List<LegalQueryData>> getWallet2() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getWallet2().compose(OtcRetrofit.o()));
    }

    public d9.a<Boolean> h(Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).cancenlOrder(map).compose(OtcRetrofit.o()));
    }

    public void i(Map<String, String> map, PSocketListenerDispatcher.PWebSocketListener pWebSocketListener) {
        d dVar = this.f70597a;
        if (dVar != null) {
            dVar.g();
        }
        c9.b bVar = this.f70598b;
        if (bVar != null) {
            String webSocketHost = bVar.getWebSocketHost();
            if (!TextUtils.isEmpty(webSocketHost)) {
                if (this.f70597a == null) {
                    this.f70597a = new d("OtcWebSocket", OtcRetrofit.g().createSocketOkHttpClientBuilder().build(), this.f70598b, pWebSocketListener);
                }
                this.f70597a.f(webSocketHost, map);
            }
        }
    }

    public void j() {
        d dVar = this.f70597a;
        if (dVar != null) {
            dVar.m(new UnSubOtcOrderReminderSend());
        }
    }

    public void k(String str) {
        d dVar = this.f70597a;
        if (dVar != null) {
            dVar.m(new PUnSubscribeChatBean(str));
        }
    }

    public d9.a<List<OrderInfoListBean>> l(RequestOrderListBean requestOrderListBean) {
        Gson gson = new Gson();
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getOrderList((Map) gson.fromJson(gson.toJson((Object) requestOrderListBean), new a().getType())).compose(OtcRetrofit.o()));
    }

    public d9.a<BaseSettingBean> loadApolloConfig() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).loadApolloConfig().compose(OtcRetrofit.o()));
    }

    public d9.a<FaceVerifyPortalBean> loadLiteVerifyPortal(String str, String str2) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).loadLiteVerifyPortal(str, str2).compose(OtcRetrofit.o()));
    }

    public d9.a<FaceVerifyPortalBean> loadVerifyPortal(String str, String str2, String str3) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).loadVerifyPortal(str, str2, str3).compose(OtcRetrofit.o()));
    }

    public d9.a<OtcOrderDetailBean> m(String str) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getOrderDetail(str, "chat").compose(OtcRetrofit.o()));
    }

    public d9.a<MktRuleBean> mktRule(Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).mktRule(map).compose(OtcRetrofit.o()));
    }

    public void n() {
        d dVar = this.f70597a;
        if (dVar != null) {
            dVar.m(new SubOtcOrderReminderSend());
        }
    }

    public d9.a<UserAssetLimitBean> o(String str, String str2, String str3, String str4) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getUserLimitAsset(str, str2, str3, str4).compose(OtcRetrofit.o()));
    }

    public d9.a<Response<OtcUploadPicBean>> ossUploadPicture(String str, Map<String, RequestBody> map, MultipartBody.Part part) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).ossUploadPicture(str, map, part));
    }

    public d9.a<Response<JsonObject>> otcGet(String str, Map<String, Object> map, Map<String, Object> map2) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).otcGet(str, map, map2));
    }

    public d9.a<Response<JsonObject>> otcPostBody(String str, Map<String, Object> map, Map<String, Object> map2) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).otcPostBody(str, map, map2));
    }

    public d9.a<Response<JsonObject>> otcPostFormUrlEncoded(String str, Map<String, Object> map, Map<String, Object> map2) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).otcPostFormUrlEncoded(str, map, map2));
    }

    public d9.a<Response<JsonObject>> otcPostNoBody(String str, Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).otcPostNoBody(str, map));
    }

    public d9.a<Integer> p() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).getTradingStatus().compose(OtcRetrofit.o()).map(u8.a.f60548b));
    }

    public d9.a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).postH5UrlRequest(str, map, map2));
    }

    public d9.a<OTCStatusExtendResponse<OtcAdTicket>> requestFreeQuote(String str, Boolean bool, String str2) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).requestFreeQuote(str, bool, str2));
    }

    public d9.a<Response<Object>> saveChatContent(String str, String str2, String str3) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).saveChatContent(str, str2, str3).compose(OtcRetrofit.o()));
    }

    public d9.a<String> setTradePass(String str, String str2, String str3) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).setTradePass(str, str2, str3).compose(OtcRetrofit.o()));
    }

    public d9.a<TradeReMarkBean> tradeRemark(String str) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).tradeRemark(str).compose(OtcRetrofit.o()));
    }

    public d9.a<Boolean> updateTradePass(Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).updateTradePass(map).compose(OtcRetrofit.o()));
    }

    public d9.a<Boolean> updateUser(Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).updateUser(map).compose(OtcRetrofit.o()));
    }

    public d9.a<Object> userRelationChange(String str, Map<String, Object> map) {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).userRelationChange(str, map).compose(OtcRetrofit.o()));
    }

    public d9.a<UserVerifyWaysBean> userVerifyWays() {
        return new d9.a<>(((OtcService) OtcRetrofit.request(OtcService.class)).userVerifyWays().compose(OtcRetrofit.o()));
    }
}
