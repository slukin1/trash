package com.huobi.login.usercenter.data.source.remote;

import android.text.TextUtils;
import bh.j;
import cn.sharesdk.framework.InnerShareParams;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.uc.core.utils.LicenseType;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.account.api.AccountService;
import com.huobi.kyc.bean.PhpLogin;
import com.huobi.login.bean.AccountVerifyBean;
import com.huobi.login.bean.SecurityVerifyBean;
import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.AccountDataSource;
import com.huobi.login.usercenter.data.source.api.UserCenterService;
import com.huobi.login.usercenter.data.source.bean.BrushGaVerifyData;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.CountryInfo;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.bean.GaGenerateData;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.LogoutInfoData;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.data.source.bean.RegisterResult;
import com.huobi.login.usercenter.data.source.bean.RetreatCountryData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.ThirdAuth;
import com.huobi.login.usercenter.data.source.bean.ThirdAuthUrl;
import com.huobi.login.usercenter.data.source.bean.ThirdData;
import com.huobi.login.usercenter.data.source.bean.ThirdInfo;
import com.huobi.login.usercenter.data.source.bean.ThirdState;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.bean.TsvTokenWrapper;
import com.huobi.login.usercenter.data.source.bean.UcAppControl;
import com.huobi.login.usercenter.data.source.bean.UserContacts;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.usercenter.utils.TokenErrorException;
import com.huobi.login.utils.VerifyHelper;
import com.huobi.utils.ADJustHelper;
import com.huobi.utils.StringUtilsTodo;
import com.huobi.vulcan.model.VulcanInfo;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.android.tpush.common.Constants;
import d7.m;
import i6.d;
import i6.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qn.e;
import qn.f;
import qn.h;
import qn.i;
import retrofit2.http.Body;
import rn.c;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import sn.w;
import tg.r;
import tq.p;
import u6.g;

public class UserCenterRemoteDataSource implements AccountDataSource {

    /* renamed from: c  reason: collision with root package name */
    public static UserCenterRemoteDataSource f75697c;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, TradeRiskReminder> f75698a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f75699b = new HashMap();

    public class a extends EasySubscriber<UcAppControl> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(UcAppControl ucAppControl) {
            super.onNext(ucAppControl);
            c.i().x(ucAppControl.getLoginWay());
            c.i().z(ucAppControl.getWebHost());
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public class b implements Action1<UcIntCodeResponse<CountryInfo>> {
        public b() {
        }

        /* renamed from: a */
        public void call(UcIntCodeResponse<CountryInfo> ucIntCodeResponse) {
            if (ucIntCodeResponse != null && ucIntCodeResponse.isSuccess() && ucIntCodeResponse.getData() != null) {
                w.j().o(ucIntCodeResponse.getData());
                String countryId = ucIntCodeResponse.getData().getCountryId();
                if (!TextUtils.isEmpty(countryId) && !countryId.equalsIgnoreCase(OptionsBridge.NULL_VALUE)) {
                    sn.a.c().e(ucIntCodeResponse.getData().getCountryId());
                    k.o("COUNTRY_ID", "当前 国家编号：" + countryId);
                }
                String regionId = ucIntCodeResponse.getData().getRegionId();
                if (TextUtils.isEmpty(regionId) || regionId.equalsIgnoreCase(OptionsBridge.NULL_VALUE)) {
                    sn.a.c().f("0");
                    return;
                }
                sn.a.c().f(ucIntCodeResponse.getData().getRegionId());
                k.o("COUNTRY_ID", "当前 省份编号：" + regionId + " 省份名称：" + sn.a.c().d());
            }
        }
    }

    public static UserCenterRemoteDataSource A() {
        if (f75697c == null) {
            f75697c = new UserCenterRemoteDataSource();
        }
        return f75697c;
    }

    public static Subscription G(String str, String str2, String str3, String str4, Map<String, Object> map, String str5, EasySubscriber<String> easySubscriber, g gVar) {
        return H(str, str2, str3, str4, map, (Map<String, Object>) null, str5, easySubscriber, gVar);
    }

    public static Subscription H(String str, String str2, String str3, String str4, Map<String, Object> map, Map<String, Object> map2, String str5, EasySubscriber<String> easySubscriber, g gVar) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("sms_code", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email_code", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("ga_code", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("login_password", MD5Utils.c(str4));
        }
        if (map2 != null) {
            hashMap.put("passkey", map2);
        }
        hashMap.put("use_type", str5);
        if (map != null) {
            hashMap.putAll(map);
        }
        return A().getSecurityStrategyVerify(hashMap).compose(p.c0()).map(f.f60064b).compose(RxJavaHelper.t(gVar)).subscribe(easySubscriber);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ KvStore Z(KvStore kvStore) {
        this.f75699b.put(kvStore.getStore_key(), kvStore.getStore_value());
        return kvStore;
    }

    public static /* synthetic */ UserToken a0(PhpLogin phpLogin) {
        UserToken userToken = new UserToken();
        userToken.g(phpLogin.getToken());
        return userToken;
    }

    public static /* synthetic */ void c0() {
        d.c("DataDiffTools", "PRO LOGIN");
        m.c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ TradeRiskReminder d0(String str, TradeRiskReminder tradeRiskReminder) {
        this.f75698a.put(str, tradeRiskReminder);
        return tradeRiskReminder;
    }

    public static /* synthetic */ Boolean e0(TradeRiskReminder tradeRiskReminder) {
        return Boolean.valueOf(tradeRiskReminder != null && "1".equals(tradeRiskReminder.getState()));
    }

    public static /* synthetic */ Boolean f0(TradeRiskReminder tradeRiskReminder) {
        return Boolean.valueOf(tradeRiskReminder != null);
    }

    public static Observable<ProUserToken> q() {
        return A().P().compose(p.c0()).flatMap(h.f60066b).doOnNext(qn.b.f60059b);
    }

    public Observable<TsvTokenWrapper> A0(String str, String str2, String str3, Boolean bool) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("tsv_token", str);
        hashMap.put(InnerShareParams.SCENCE, str3);
        hashMap.put("risk_operate", str2);
        hashMap.put("cancel", bool);
        return ((UserCenterService) p.b0(UserCenterService.class)).securityRiskCheck(hashMap).compose(p.c0());
    }

    public Map<String, String> B() {
        return this.f75699b;
    }

    public Observable<UcIntCodeResponse<CodeVerifyData>> B0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("auth_token", str);
        hashMap.put("strategy_type", "SETTING");
        hashMap.put("item", str2);
        return strategyDisable(hashMap);
    }

    public Observable<UcIntCodeResponse<List<String>>> C(List<String> list) {
        return ((UserCenterService) p.b0(UserCenterService.class)).getMultipleTradingPair(list);
    }

    public Observable<UcIntCodeResponse<UcAppControl>> C0() {
        return ((UserCenterService) p.b0(UserCenterService.class)).ucAppControl();
    }

    public Observable<UcIntCodeResponse<List<CountryListData>>> D() {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestRegisterCountryCodeList();
    }

    public Observable<Object> D0(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).userCidSave(map).compose(p.c0());
    }

    public Observable<UcIntCodeResponse<RetreatCountryData>> E() {
        return ((UserCenterService) p.b0(UserCenterService.class)).getRetreatCountry();
    }

    public Observable<Object> E0(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).userDau(map).compose(p.c0());
    }

    public Observable<UcIntCodeResponse<SecurityStrategySet>> F() {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestSecurityStrategy();
    }

    public Observable<UcIntCodeResponse<Object>> I(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestSmsCode(map);
    }

    public Observable<UcIntCodeResponse<Object>> J(String str, String str2, String str3, HashMap<String, Object> hashMap, String str4, String str5, boolean z11) {
        return K(str, str2, str3, hashMap, str4, str5, z11, 0);
    }

    public Observable<UcIntCodeResponse<Object>> K(String str, String str2, String str3, HashMap<String, Object> hashMap, String str4, String str5, boolean z11, int i11) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("country_code", str);
        hashMap2.put(PlaceFields.PHONE, str2);
        hashMap2.put("use_type", str3);
        hashMap2.put("voice", Boolean.valueOf(z11));
        if ("AUTH_CODE_LOGIN_REGISTER".equals(str3)) {
            hashMap2.put(InnerShareParams.SCENCE, Integer.valueOf(i11));
        }
        VerifyHelper.k(hashMap2, hashMap);
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            hashMap2.put("captcha_key", str4);
            hashMap2.put("captcha_code", str5);
        }
        return I(hashMap2);
    }

    public Observable<UcIntCodeResponse<ThirdAuth>> L(ThirdData thirdData, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        hashMap.put("third_type", thirdData.f75671a);
        hashMap.put("id_token", thirdData.f75672b);
        hashMap.put("client_id", str2);
        hashMap.put("state", str);
        if (thirdData.f75671a.equalsIgnoreCase(LoginPresenter.f75470v)) {
            hashMap.put("telegram_user_Info_req", thirdData.f75676f);
        }
        return ((UserCenterService) p.b0(UserCenterService.class)).getThirdAuth(hashMap);
    }

    public Observable<UcIntCodeResponse<ThirdAuthUrl>> M(ThirdInfo thirdInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        hashMap.put("app_name", thirdInfo.a());
        hashMap.put(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, thirdInfo.c());
        hashMap.put("client_id", thirdInfo.b());
        return ((UserCenterService) p.b0(UserCenterService.class)).getThirdAuthUrl(hashMap);
    }

    public Observable<UcIntCodeResponse<List<ThirdInfo>>> N() {
        return ((UserCenterService) p.b0(UserCenterService.class)).thirdList(2);
    }

    public Observable<UcIntCodeResponse<ThirdState>> O() {
        HashMap hashMap = new HashMap();
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        return ((UserCenterService) p.b0(UserCenterService.class)).getThirdState(hashMap);
    }

    @Deprecated
    public Observable<UcIntCodeResponse<LoginInfoData>> P() {
        return Q("old need-get-ticket");
    }

    public Observable<UcIntCodeResponse<LoginInfoData>> Q(String str) {
        k.f("LOGIN", "requestTicket- " + str + " - verifyUserIsLogin - " + r.x().F0());
        if (r.x().F0()) {
            return ((UserCenterService) p.b0(UserCenterService.class)).requestTicket();
        }
        TokenErrorException tokenErrorException = new TokenErrorException(str);
        k.f("LOGIN", "requestTicket- not login" + str);
        k.f("LOGIN", "TokenErrorException 原逻辑会上传到FireBase 现在添加到日志");
        return Observable.error(tokenErrorException);
    }

    public Observable<UcIntCodeResponse<UserInfoData>> R() {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestUserInfo();
    }

    public Observable<UcIntCodeResponse<UserOtherInfoData>> S() {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestUserOtherInfo();
    }

    public Observable<UcIntCodeResponse<UserSecurityInfoData>> T() {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestUserSecurityInfo();
    }

    public Observable<UcIntCodeResponse<BrushGaVerifyData>> U(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestVerifyBrushGaCode(map);
    }

    public Observable<UcIntCodeResponse<CodeVerifyData>> V(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("ga_code", str);
        return getVerifyGaCode(hashMap);
    }

    public Observable<UserToken> W(String str) {
        if (TextUtils.isEmpty(str)) {
            return Observable.empty();
        }
        r.x().x0(str);
        return l0().map(e.f60063b);
    }

    public Observable<UcIntCodeResponse<AccountVerifyBean>> accountVerify(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).accountVerify(map);
    }

    public Observable<UcIntCodeResponse<Object>> addMultipleTradingPair(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).addMultipleTradingPair(map);
    }

    public Observable<UcIntCodeResponse<Object>> addTradingPair(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).addTradingPair(map);
    }

    public Observable<UcIntCodeResponse<TsvTokenWrapper>> bindEmail(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestBindEmail(map);
    }

    public Observable<UcIntCodeResponse<Object>> bindGa(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestBindGa(map);
    }

    public Observable<UcIntCodeResponse<TsvTokenWrapper>> bindPhone(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestBindPhone(map);
    }

    public Observable<UcIntCodeResponse<Object>> cancelTradingPair(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).cancelTradingPair(map);
    }

    public Observable<UcIntCodeResponse<Object>> editTradingPair(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).editTradingPair(map);
    }

    public Observable<UcIntCodeResponse<LoginInfoData>> g0(Map<String, Object> map) {
        map.put("login_ext_data", gs.a.a());
        return ((UserCenterService) p.b0(UserCenterService.class)).requestLogin(map);
    }

    public Observable<UcIntCodeResponse<List<UserContacts>>> getContacts(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).getContacts(map);
    }

    public Observable<UcIntCodeResponse<String>> getEmailSendResult(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).getEmailSendResult(map);
    }

    public Observable<KvStore> getKvStore(String str, String str2) {
        return ((UserCenterService) p.b0(UserCenterService.class)).getKvStore(str, str2).compose(p.c0()).map(new qn.c(this));
    }

    public Observable<UcIntCodeResponse<List<String>>> getRegisterShieldWords() {
        return ((UserCenterService) p.b0(UserCenterService.class)).getRegisterShieldWords();
    }

    public Observable<UcIntCodeResponse<CodeVerifyData>> getSecurityStrategySmartVerify(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestSecurityStrategySmartVerify(map);
    }

    public Observable<UcIntCodeResponse<CodeVerifyData>> getSecurityStrategyVerify(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestSecurityStrategyVerify(map);
    }

    public Observable<UcIntCodeResponse<SecurityStrategySet>> getSecurityStrategyWithParams(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).getSecurityStrategyWithParams(map);
    }

    public Observable<UcIntCodeResponse<List<String>>> getTradingPair(String str) {
        return ((UserCenterService) p.b0(UserCenterService.class)).getTradingPair(str);
    }

    public Observable<UcIntCodeResponse<CodeVerifyData>> getVerifyEmailCode(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestVerifyEmailCode(map);
    }

    public Observable<UcIntCodeResponse<CodeVerifyData>> getVerifyGaCode(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestVerifyGaCode(map);
    }

    public Observable<UcIntCodeResponse<CodeVerifyData>> getVerifySmsCode(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestVerifySmsCode(map);
    }

    public Observable<UcIntCodeResponse<LoginInfoData>> h0(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("token", str);
        map.put(VulcanInfo.VTOKEN, ku.b.e().h(j.c().getApplicationContext()));
        hashMap.putAll(map);
        return i0(hashMap);
    }

    public Observable<UcIntCodeResponse<LoginInfoData>> i0(Map<String, Object> map) {
        map.put("login_ext_data", gs.a.a());
        return ((UserCenterService) p.b0(UserCenterService.class)).requestLogin2FA(map);
    }

    public final void j(String str, Map<String, Object> map, String str2) {
        if (!TextUtils.isEmpty(str)) {
            map.put("invite_code", str);
        } else if ("11328670".equals(str2)) {
            map.put("invite_code", "rt7w4");
        } else if ("11328680".equals(str2)) {
            map.put("invite_code", "mqfw4");
        } else if ("11328690".equals(str2)) {
            map.put("invite_code", "b8aw4");
        } else if ("11328720".equals(str2)) {
            map.put("invite_code", "zyqy4");
        } else if ("11329110".equals(str2)) {
            map.put("invite_code", "fpdj5");
        } else if ("11329260".equals(str2)) {
            map.put("invite_code", "axkx4");
        } else if ("11330400".equals(str2)) {
            map.put("invite_code", "7vw73");
        } else if ("11330410".equals(str2)) {
            map.put("invite_code", "j6ta6");
        } else if ("11329780".equals(str2)) {
            map.put("invite_code", "hsx66");
        } else if ("11330460".equals(str2)) {
            map.put("invite_code", "ht437");
        } else if ("11330470".equals(str2)) {
            map.put("invite_code", "msr37");
        } else if ("11330900".equals(str2)) {
            map.put("invite_code", "536c7");
        } else if ("11331750".equals(str2)) {
            map.put("invite_code", "wef58");
        } else if ("11331840".equals(str2)) {
            map.put("invite_code", "3m4t4");
        } else if ("11331850".equals(str2)) {
            map.put("invite_code", "8mmt9");
        } else if ("11331890".equals(str2)) {
            map.put("invite_code", "2t4v9");
        } else if ("11331980".equals(str2)) {
            map.put("invite_code", "wucn3");
        } else if ("11332140".equals(str2)) {
            map.put("invite_code", "yeq32223");
        } else if ("11332150".equals(str2)) {
            map.put("invite_code", "vgaya");
        } else if ("11332100".equals(str2)) {
            map.put("invite_code", "b5gc4");
        } else if ("11332110".equals(str2)) {
            map.put("invite_code", "ywtac");
        } else {
            map.put("invite_code", "");
        }
    }

    public Observable<UcIntCodeResponse<LoginInfoData>> j0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        hashMap.put("way", "APP_HUOBI_PRO");
        hashMap.put("third_token", str);
        hashMap.put("login_version", 3);
        hashMap.put("vToken", ku.b.e().h(BaseApplication.b()));
        return ((UserCenterService) p.b0(UserCenterService.class)).loginWithThirdAccount(hashMap);
    }

    public Observable<UcIntCodeResponse<TsvTokenWrapper>> k(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("email", str);
        hashMap.put("email_token", str2);
        hashMap.put("auth_token", str3);
        hashMap.put("enable_in_2fa", Boolean.TRUE);
        return bindEmail(hashMap);
    }

    public Observable<UcIntCodeResponse<LogoutInfoData>> k0() {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestLogout();
    }

    public Observable<UcIntCodeResponse<Object>> l(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("ga_code", str);
        hashMap.put("ga_token", str2);
        hashMap.put("auth_token", str3);
        hashMap.put("enable_in_2fa", Boolean.TRUE);
        return bindGa(hashMap);
    }

    public final Observable<PhpLogin> l0() {
        return Q("h5 phpLoginInit").compose(p.c0()).flatMap(qn.g.f60065b).subscribeOn(Schedulers.io());
    }

    public Observable<UcIntCodeResponse<Object>> loginPasswordVerify(@Body Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).loginPasswordVerify(map);
    }

    public Observable<UcIntCodeResponse<TsvTokenWrapper>> m(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(PlaceFields.PHONE, str2);
        hashMap.put("country_code", str);
        hashMap.put("phone_token", str3);
        hashMap.put("auth_token", str4);
        hashMap.put("enable_in_2fa", Boolean.TRUE);
        return bindPhone(hashMap);
    }

    public Observable<StringStatusResponse<ProUserToken>> m0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FLAG_TICKET, str);
        return ((AccountService) p.W(AccountService.class)).proLogin(hashMap, str).doOnCompleted(qn.a.f60058b);
    }

    public Observable<UcIntCodeResponse<Object>> n(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        hashMap.put("way", "APP_HUOBI_PRO");
        hashMap.put("third_token", str);
        hashMap.put("business_type", "PRO");
        hashMap.putAll(map);
        return ((UserCenterService) p.b0(UserCenterService.class)).bindV2WithThirdAccount(hashMap);
    }

    public Observable<UcIntCodeResponse<RegisterResult>> n0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("country_code", str5);
            hashMap.put(PlaceFields.PHONE, str2);
        } else {
            hashMap.put("email", str3);
        }
        hashMap.put(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE, str4);
        hashMap.put("password_level", Integer.valueOf(StringUtilsTodo.a(str)));
        hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, MD5Utils.c(str));
        hashMap.put("site_id", 2);
        String a11 = ChannelUtils.a();
        if (TextUtils.isEmpty(a11)) {
            a11 = "7890747";
        }
        hashMap.put("inviter_id", Integer.valueOf(i6.m.k0(a11)));
        hashMap.put("client_platform", "ANDROID");
        hashMap.put("client_app", "HBG");
        hashMap.put("client_version", "10.54.0");
        hashMap.put(VulcanInfo.VTOKEN, ku.b.e().h(j.c().getApplicationContext()));
        j(str7, hashMap, a11);
        if ("2".equals(str8)) {
            hashMap.put("version", str8);
            hashMap.put("way", "APP_HUOBI_PRO");
        }
        if (str9 != null && !str9.isEmpty()) {
            hashMap.put("third_token", str9);
        }
        hashMap.put("login_ext_data", gs.a.a());
        String d11 = ADJustHelper.d();
        if (!d11.isEmpty()) {
            hashMap.put("ad_id", d11);
        }
        String e11 = ADJustHelper.e();
        if (!e11.isEmpty()) {
            hashMap.put("gps_ad_id", e11);
        }
        return o0(hashMap);
    }

    public Observable<UcIntCodeResponse<Object>> o(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        hashMap.put("way", "APP_HUOBI_PRO");
        hashMap.put("third_token", str);
        hashMap.putAll(map);
        return ((UserCenterService) p.b0(UserCenterService.class)).bindWithThirdAccount(hashMap);
    }

    public Observable<UcIntCodeResponse<RegisterResult>> o0(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestRegisterUser(map);
    }

    public void p() {
        this.f75698a.clear();
        this.f75699b.clear();
    }

    public Observable<UcIntCodeResponse<RegisterResult>> p0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("country_code", str5);
            hashMap.put(PlaceFields.PHONE, str);
        } else {
            hashMap.put("email", str2);
        }
        hashMap.put("auth_token", str9);
        hashMap.put(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE, str4);
        hashMap.put("password_level", Integer.valueOf(StringUtilsTodo.a(str3)));
        hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, MD5Utils.c(str3));
        hashMap.put("site_id", 2);
        String a11 = ChannelUtils.a();
        if (TextUtils.isEmpty(a11)) {
            a11 = "7890747";
        }
        hashMap.put("inviter_id", Integer.valueOf(i6.m.k0(a11)));
        hashMap.put("client_platform", "ANDROID");
        hashMap.put("client_app", "HBG");
        hashMap.put("client_version", "10.54.0");
        j(str8, hashMap, a11);
        if ("2".equals(str6)) {
            hashMap.put("version", str6);
            hashMap.put("way", "APP_HUOBI_PRO");
        }
        if (str7 != null && !str7.isEmpty()) {
            hashMap.put("third_token", str7);
        }
        hashMap.put("login_ext_data", gs.a.a());
        hashMap.put(VulcanInfo.VTOKEN, ku.b.e().h(j.c().getApplicationContext()));
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        String d11 = ADJustHelper.d();
        if (!d11.isEmpty()) {
            hashMap.put("ad_id", d11);
        }
        String e11 = ADJustHelper.e();
        if (!e11.isEmpty()) {
            hashMap.put("gps_ad_id", e11);
        }
        return q0(hashMap);
    }

    public Observable<Object> putKvStore(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).putKvStore(map).compose(p.c0());
    }

    public Observable<UcIntCodeResponse<RegisterResult>> q0(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestRegisterUserByAuthCode(map);
    }

    public Observable<UcIntCodeResponse<Object>> r(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).editMultipleTradingPair(map);
    }

    public Observable<UcIntCodeResponse<GaGenerateData>> r0() {
        return requestGaGenerateInfo("ASSET_GA");
    }

    public Observable<UcIntCodeResponse<Object>> rebindEmail(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).rebindEmail(map);
    }

    public Observable<UcIntCodeResponse<Object>> rebindGa(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).rebindGa(map);
    }

    public Observable<UcIntCodeResponse<Object>> rebindPhone(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).rebindPhone(map);
    }

    public Observable<UcIntCodeResponse<Object>> registerCodeVerify(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).registerCodeVerify(map);
    }

    public Observable<UcIntCodeResponse<GaGenerateData>> requestGaGenerateInfo(String str) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestGaGenerateInfo(str);
    }

    public Observable<UcIntCodeResponse<Object>> requestLicenseAgree(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestLicenseAgree(map);
    }

    public Observable<TradeRiskReminder> requestLicenseState(String str, boolean z11) {
        Observable<R> map = ((UserCenterService) p.b0(UserCenterService.class)).requestLicenseState(str).compose(p.c0()).map(new qn.d(this, str));
        return z11 ? Observable.concat(Observable.just(this.f75698a.get(str)).filter(i.f60067b), map).takeFirst(qn.j.f60068b) : map;
    }

    public Observable<UcIntCodeResponse<RiskControl>> requestRiskControl(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestRiskControl(map);
    }

    public Observable<UcIntCodeResponse<TsvTokenWrapper>> resetPassword(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).resetPassword(map);
    }

    public Observable<UcIntCodeResponse<GaGenerateData>> s(String str) {
        return ((UserCenterService) p.b0(UserCenterService.class)).gaGenerateForChange(str);
    }

    public d9.a<Object> s0(LicenseType licenseType) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", licenseType.type);
        return new d9.a<>(((UserCenterService) p.b0(UserCenterService.class)).requestLicenseAgree(hashMap).compose(p.c0()));
    }

    public Observable<UcIntCodeResponse<SecurityVerifyBean>> securityVerify(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).securityVerify(map);
    }

    public Observable<UcIntCodeResponse<CodeVerifyData>> strategyDisable(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestStrategyDisable(map);
    }

    public Observable<UcIntCodeResponse<Object>> strategyEnable(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestStrategyEnable(map);
    }

    public Observable<UcIntCodeResponse<List<CountryListData>>> t() {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestCountryCodeList();
    }

    public Observable<UcIntCodeResponse<RiskControl>> t0(String str, int i11, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(InnerShareParams.SCENCE, Integer.valueOf(i11));
        hashMap.put("login_name", str);
        hashMap.put("source", 5);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        hashMap.put("version", "4");
        hashMap.put("vToken", ku.b.e().h(j.c().getApplicationContext()));
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("country_code", str2);
        }
        return requestRiskControl(hashMap);
    }

    public Observable<UcIntCodeResponse<CountryInfo>> u() {
        CountryInfo g11 = w.j().g();
        if (g11 == null || TextUtils.isEmpty(g11.getCountryId())) {
            return ((UserCenterService) p.b0(UserCenterService.class)).getCountryIdByIP(1).doOnNext(new b());
        }
        UcIntCodeResponse ucIntCodeResponse = new UcIntCodeResponse();
        ucIntCodeResponse.setCode(200);
        ucIntCodeResponse.setSuccess(true);
        ucIntCodeResponse.setData(g11);
        return Observable.just(ucIntCodeResponse);
    }

    public Observable<UcIntCodeResponse<RiskControl>> u0(String str, int i11) {
        return t0(str, i11, (String) null);
    }

    public Observable<UcIntCodeResponse<List<CountryListData>>> v() {
        List<CountryListData> f11 = w.j().f();
        if (f11 == null || f11.size() <= 0) {
            return ((UserCenterService) p.b0(UserCenterService.class)).requestCountryList();
        }
        UcIntCodeResponse ucIntCodeResponse = new UcIntCodeResponse();
        ucIntCodeResponse.setCode(200);
        ucIntCodeResponse.setSuccess(true);
        ucIntCodeResponse.setData(f11);
        return Observable.just(ucIntCodeResponse);
    }

    public void v0() {
        C0().subscribeOn(Schedulers.io()).compose(p.c0()).subscribeOn(Schedulers.io()).subscribe(new a());
    }

    public Observable<UcIntCodeResponse<Object>> w(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestEmailCode(map);
    }

    public Observable<UcIntCodeResponse<GaGenerateData>> w0(Map<String, Object> map) {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestUnLoginGaInfo(map);
    }

    public Observable<UcIntCodeResponse<Object>> x(String str, String str2, HashMap<String, Object> hashMap, String str3, String str4) {
        return y(str, str2, hashMap, str3, str4, 0);
    }

    public Observable<UcIntCodeResponse<CodeVerifyData>> x0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", "BIND_EMAIL");
        hashMap.put("email", str);
        hashMap.put("email_code", str2);
        return getVerifyEmailCode(hashMap);
    }

    public Observable<UcIntCodeResponse<Object>> y(String str, String str2, HashMap<String, Object> hashMap, String str3, String str4, int i11) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("email", str);
        hashMap2.put("use_type", str2);
        if ("AUTH_CODE_LOGIN_REGISTER".equals(str2)) {
            hashMap2.put(InnerShareParams.SCENCE, Integer.valueOf(i11));
        }
        VerifyHelper.k(hashMap2, hashMap);
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            hashMap2.put("captcha_key", str3);
            hashMap2.put("captcha_code", str4);
        }
        return w(hashMap2);
    }

    public Observable<UcIntCodeResponse<CodeVerifyData>> y0(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", "BIND_PHONE");
        hashMap.put(PlaceFields.PHONE, str2);
        hashMap.put("country_code", str);
        hashMap.put("sms_code", str3);
        return getVerifySmsCode(hashMap);
    }

    public Observable<UcIntCodeResponse<ImgCaptchaData>> z() {
        return ((UserCenterService) p.b0(UserCenterService.class)).requestImgCaptcha();
    }

    public Observable<TsvTokenWrapper> z0(String str, Boolean bool) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("tsv_token", str);
        hashMap.put("cancel", bool);
        return ((UserCenterService) p.b0(UserCenterService.class)).resetPasswordRiskCheck(hashMap).compose(p.c0());
    }
}
