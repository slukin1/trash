package com.hbg.lib.network.uc.retrofit;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.network.retrofit.eventbus.HKPayOffEvent;
import com.hbg.lib.network.uc.core.response.UcIntCodeResponse;
import com.hbg.lib.network.uc.core.utils.UcHelper;
import com.hbg.lib.network.uc.retrofit.bean.DynamicLangData;
import com.hbg.lib.network.uc.retrofit.bean.MessageConfigWrapper;
import com.hbg.lib.network.uc.retrofit.bean.MessageNoReadNum;
import com.hbg.lib.network.uc.retrofit.service.MessageService;
import com.hbg.lib.network.uc.retrofit.service.UserCenterService;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.login.usercenter.data.source.bean.AuthCodeLoginRegisterAbtestData;
import com.huobi.login.usercenter.data.source.bean.ChallengeTypeData;
import com.huobi.login.usercenter.data.source.bean.FollowTypeData;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.PasskeyAbtestData;
import com.huobi.login.usercenter.data.source.bean.PasskeyListData;
import com.huobi.login.usercenter.data.source.bean.PasskeyLoginData;
import com.huobi.login.usercenter.data.source.bean.PasskeyVerifyData;
import com.huobi.login.usercenter.data.source.bean.RegisterCheckIpData;
import com.huobi.login.usercenter.data.source.bean.RegisterPreliminaryCheckData;
import com.huobi.login.usercenter.data.source.bean.UserSecurityLoginListData;
import com.huobi.login.usercenter.data.source.bean.VerifyAuthCodeData;
import com.huobi.vulcan.model.VulcanInfo;
import d9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o9.b;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;

public class UcApiRetrofitImpl implements b {
    public static /* synthetic */ Observable h(UcIntCodeResponse ucIntCodeResponse) {
        if (50001 == ucIntCodeResponse.a()) {
            EventBus.d().k(new HKPayOffEvent(true));
        }
        return Observable.just(ucIntCodeResponse);
    }

    public void a(String str, Context context, c9.b bVar) {
        UcRetrofit.d().init(str, context, bVar);
    }

    public a<AuthCodeLoginRegisterAbtestData> authCodeLoginRegisterAbtest(Map<String, Object> map) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).authCodeLoginRegisterAbtest(map).compose(UcRetrofit.h()));
    }

    public a<MessageNoReadNum> b() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("1.PRO.CONTENT_PRAISE_ALL_MSG");
        arrayList.add("1.PRO.CONTENT_COMMENT_ALL_MSG");
        arrayList.add("1.PRO.CONTENT_FOCUS_USER_MSG");
        hashMap.put("exchange_id", 1);
        hashMap.put("template_code", arrayList);
        return new a<>(((MessageService) UcRetrofit.request(MessageService.class)).getUCListByCode(hashMap).compose(UcRetrofit.h()));
    }

    public a<List<UserSecurityLoginListData>> c(int i11, int i12) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).requestUserSecurityLoginListData(i11, i12).compose(UcRetrofit.h()));
    }

    public a<Object> checkLogin() {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).checkLogin().compose(UcRetrofit.h()));
    }

    public a<Object> createPasskey(Map<String, Object> map) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).createPasskey(map).compose(UcRetrofit.h()));
    }

    public a<String> d(int i11, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap(9);
        hashMap.put("loginState", Integer.valueOf(i11));
        hashMap.put("way", GrsBaseInfo.CountryCodeSource.APP);
        hashMap.put("loginWay", str);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, UcHelper.b(true));
        hashMap.put("platform", "ANDROID");
        hashMap.put("clientApp", "HBG");
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(VulcanInfo.VTOKEN, str2);
        }
        hashMap.put("clientVersion", str3);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("extData", str4);
        }
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).uploadLoginHistory(hashMap).compose(UcRetrofit.h()));
    }

    public a<Object> e(Map<String, Object> map) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).passkeyDelete(map).compose(UcRetrofit.h()));
    }

    public a<Object> f(Map<String, Object> map) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).passkeyUpdateRemark(map).compose(UcRetrofit.h()));
    }

    public a<ChallengeTypeData> getChallenge(Map<String, Object> map) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).getChallenge(map).compose(UcRetrofit.h()));
    }

    public a<List<DynamicLangData>> getDynamicLanguage() {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).getDynamicLanguage().compose(UcRetrofit.h()));
    }

    public a<ResponseBody> getH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).getH5UrlRequest(str, map, map2));
    }

    public a<FollowTypeData> loginNameIsInvalid(Map<String, Object> map) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).loginNameIsInvalid(map).compose(UcRetrofit.h()));
    }

    public a<String> loginTokenGet(String str) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).loginTokenGet(str).compose(UcRetrofit.h()));
    }

    public a<String> modifySwitchConfig(Map<String, Object> map) {
        return new a<>(((MessageService) UcRetrofit.request(MessageService.class)).modifySwitchConfig(map).compose(UcRetrofit.h()));
    }

    public a<PasskeyAbtestData> passkeyABTest() {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).passkeyABTest().compose(UcRetrofit.h()));
    }

    public a<PasskeyListData> passkeyList() {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).passkeyList().compose(UcRetrofit.h()));
    }

    public a<PasskeyLoginData> passkeyLogin(Map<String, Object> map) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).passkeyLogin(map).compose(UcRetrofit.h()));
    }

    public a<PasskeyVerifyData> passkeyVerify() {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).passkeyVerify().compose(UcRetrofit.h()));
    }

    public a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).postH5UrlRequest(str, map, map2));
    }

    public a<RegisterCheckIpData> registerCheckIp() {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).registerCheckIp().compose(UcRetrofit.h()));
    }

    public a<RegisterPreliminaryCheckData> registerPreliminaryCheck(Map<String, Object> map) {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).registerPreliminaryCheck(map).compose(UcRetrofit.h()));
    }

    public a<Integer> requestClearReadNum(Map<String, Object> map) {
        return new a<>(((MessageService) UcRetrofit.request(MessageService.class)).requestClearReadNum(map).compose(UcRetrofit.h()));
    }

    public a<List<MessageConfigWrapper>> requestSwitchConfig(Map<String, Object> map) {
        return new a<>(((MessageService) UcRetrofit.request(MessageService.class)).requestSwitchConfig(map).compose(UcRetrofit.h()));
    }

    public a<LoginInfoData> requestTicket() {
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).requestTicket().compose(UcRetrofit.h()));
    }

    public a<VerifyAuthCodeData> verifyAuthCode(Map<String, Object> map) {
        map.put("way", "APP_HUOBI_PRO");
        map.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, UcHelper.b(true));
        return new a<>(((UserCenterService) UcRetrofit.request(UserCenterService.class)).verifyAuthCode(map).flatMap(q9.a.f53311b).compose(UcRetrofit.h()));
    }
}
