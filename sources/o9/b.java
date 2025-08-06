package o9;

import android.content.Context;
import com.hbg.lib.network.uc.retrofit.bean.DynamicLangData;
import com.hbg.lib.network.uc.retrofit.bean.MessageConfigWrapper;
import com.hbg.lib.network.uc.retrofit.bean.MessageNoReadNum;
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
import d9.a;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;

public interface b {
    void a(String str, Context context, c9.b bVar);

    a<AuthCodeLoginRegisterAbtestData> authCodeLoginRegisterAbtest(Map<String, Object> map);

    a<MessageNoReadNum> b();

    a<List<UserSecurityLoginListData>> c(int i11, int i12);

    a<Object> checkLogin();

    a<Object> createPasskey(Map<String, Object> map);

    a<String> d(int i11, String str, String str2, String str3, String str4);

    a<Object> e(Map<String, Object> map);

    a<Object> f(Map<String, Object> map);

    a<ChallengeTypeData> getChallenge(Map<String, Object> map);

    a<List<DynamicLangData>> getDynamicLanguage();

    a<ResponseBody> getH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);

    a<FollowTypeData> loginNameIsInvalid(Map<String, Object> map);

    a<String> loginTokenGet(String str);

    a<String> modifySwitchConfig(Map<String, Object> map);

    a<PasskeyAbtestData> passkeyABTest();

    a<PasskeyListData> passkeyList();

    a<PasskeyLoginData> passkeyLogin(Map<String, Object> map);

    a<PasskeyVerifyData> passkeyVerify();

    a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);

    a<RegisterCheckIpData> registerCheckIp();

    a<RegisterPreliminaryCheckData> registerPreliminaryCheck(Map<String, Object> map);

    a<Integer> requestClearReadNum(Map<String, Object> map);

    a<List<MessageConfigWrapper>> requestSwitchConfig(Map<String, Object> map);

    a<LoginInfoData> requestTicket();

    a<VerifyAuthCodeData> verifyAuthCode(Map<String, Object> map);
}
