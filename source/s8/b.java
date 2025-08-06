package s8;

import android.content.Context;
import com.google.gson.JsonObject;
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
import com.hbg.lib.network.retrofit.websocketnew.PSocketListenerDispatcher;
import com.huobi.account.entity.LegalQueryData;
import com.huobi.otc.bean.OtcU1000DetailBean;
import d9.a;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

public interface b {
    void a(String str, Context context, c9.b bVar);

    a<Object> actionAuDvs();

    a<String> authPull();

    void b();

    a<OTCStatusExtendResponse<MktRuleBean>> bindCardMktRule(Map<String, Object> map);

    void c();

    a<Boolean> cancelConsultCommit(Map<String, Object> map);

    a<List<OtcChatOnlineCheck>> chatOnlineCheck(long... jArr);

    a<OTCStatusResponse<Object>> chatRead(Map<String, String> map);

    a<OtcContactsResponseBean> contactList(String str);

    a<OtcConfigBean> d();

    a<List<MktRuleBean>> depositOperationBatch(Map<String, List<Map<String, Object>>> map);

    a<DialPhoneResponseBean> dialPhone(String str, String str2, String str3, String str4);

    boolean e();

    void f(String str);

    a<OTCStatusResponse<Object>> faqLike(Map<String, Object> map);

    a<List<OtcTradeConfigListBean>> fastTradeConfigList(String str, String str2);

    a<FunctionAvailableBean> functionAvailable(String str);

    a<OssSignBean> g(String str, String str2, String str3);

    a<OtcU1000DetailBean> get1000UDetail();

    a<OTCStatusResponse<List<AdvertVerifyCapitalConfigBean>>> getAdvertVerifyCapitalConfigs();

    a<AgencyKycUserBean> getAgencyKycUser();

    a<OTCStatusExtendResponse<List<OtcCancelReasonBean>>> getCancelReason(String str);

    a<OTCStatusResponse<OtcChatUnread>> getChatUnReadAll();

    a<OTCStatusResponse<List<OtcChatUnread>>> getChatUnread(String str);

    a<QuickTradeConfigBean> getExpressConfig();

    a<List<OtcFAQBean>> getFAQConfig(Map<String, Object> map);

    a<ResponseBody> getH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);

    a<OtcLiteCollection> getLiteWallet();

    a<LiteMarketBuyHint> getMarketBuyTips(String str);

    a<LiteMarketDetail> getMarketDetail(String str, String str2, String str3);

    a<List<MarketMergedInfo>> getMarketMergedList(String str, String str2, String str3);

    a<LiteMarketPrice> getMarketPrice(String str, String str2, String str3);

    a<MarketPrice> getMarketPriceList();

    a<OTCStatusResponse<OnLineStatusBean>> getOnLineStatus(String str);

    a<OtcTermsUrlBean> getOtcTermsUrl();

    a<String> getTicket(Map<String, Object> map);

    a<UserVO> getUser();

    a<List<LegalQueryData>> getWallet2();

    a<Boolean> h(Map<String, Object> map);

    void i(Map<String, String> map, PSocketListenerDispatcher.PWebSocketListener pWebSocketListener);

    void j();

    void k(String str);

    a<List<OrderInfoListBean>> l(RequestOrderListBean requestOrderListBean);

    a<BaseSettingBean> loadApolloConfig();

    a<FaceVerifyPortalBean> loadLiteVerifyPortal(String str, String str2);

    a<FaceVerifyPortalBean> loadVerifyPortal(String str, String str2, String str3);

    a<OtcOrderDetailBean> m(String str);

    a<MktRuleBean> mktRule(Map<String, Object> map);

    void n();

    a<UserAssetLimitBean> o(String str, String str2, String str3, String str4);

    a<Response<OtcUploadPicBean>> ossUploadPicture(String str, Map<String, RequestBody> map, MultipartBody.Part part);

    a<Response<JsonObject>> otcGet(String str, Map<String, Object> map, Map<String, Object> map2);

    a<Response<JsonObject>> otcPostBody(String str, Map<String, Object> map, Map<String, Object> map2);

    a<Response<JsonObject>> otcPostFormUrlEncoded(String str, Map<String, Object> map, Map<String, Object> map2);

    a<Response<JsonObject>> otcPostNoBody(String str, Map<String, Object> map);

    a<Integer> p();

    a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);

    a<OTCStatusExtendResponse<OtcAdTicket>> requestFreeQuote(String str, Boolean bool, String str2);

    a<Response<Object>> saveChatContent(String str, String str2, String str3);

    a<String> setTradePass(String str, String str2, String str3);

    a<TradeReMarkBean> tradeRemark(String str);

    a<Boolean> updateTradePass(Map<String, Object> map);

    a<Boolean> updateUser(Map<String, Object> map);

    a<Object> userRelationChange(String str, Map<String, Object> map);

    a<UserVerifyWaysBean> userVerifyWays();
}
