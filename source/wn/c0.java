package wn;

import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.usercenter.data.source.bean.AuthCodeLoginRegisterAbtestData;
import com.huobi.login.v3.bean.LoginSuccBean;
import com.huobi.login.v3.ui.UserLoginActivityV4;
import gs.g;
import i6.m;
import java.util.HashMap;
import ku.b;
import rx.functions.Action1;
import tg.r;

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f76688a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f76689b = true;

    public class a extends EasySubscriber<AuthCodeLoginRegisterAbtestData> {
        public a(Action1 action1) {
            super(action1);
        }

        /* renamed from: a */
        public void onNext(AuthCodeLoginRegisterAbtestData authCodeLoginRegisterAbtestData) {
            super.onNext(authCodeLoginRegisterAbtestData);
            boolean unused = c0.f76689b = authCodeLoginRegisterAbtestData.isAbTest();
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public static String b() {
        return ConfigPreferences.d("user_config", "last_loged_account");
    }

    public static String c(String str) {
        if (str == null) {
            str = b();
        }
        return ConfigPreferences.e("user_config", "config_area_code_v3" + str, "");
    }

    public static String d(String str) {
        if (str == null) {
            str = b();
        }
        return ConfigPreferences.e("user_config", "config_country_id_v3" + str, "");
    }

    public static String e(String str) {
        if (str == null) {
            str = b();
        }
        return ConfigPreferences.d("user_config", "last_loged_account_third_type" + str);
    }

    public static Class<?> f() {
        return g((String) null);
    }

    public static Class<?> g(String str) {
        return UserLoginActivityV4.class;
    }

    public static boolean h() {
        return f76689b;
    }

    public static void i(String str, Boolean bool, String str2, LoginSuccBean loginSuccBean) {
        j(str, bool, str2, loginSuccBean, false);
    }

    public static void j(String str, Boolean bool, String str2, LoginSuccBean loginSuccBean, boolean z11) {
        int i11;
        String str3;
        String str4;
        ConfigPreferences.m("user_config", "last_loged_account", str);
        if (bool == null) {
            str3 = "";
            i11 = 2;
        } else if (bool.booleanValue()) {
            i11 = 0;
            str3 = "验证码登录";
        } else {
            i11 = 1;
            str3 = "密码登录";
        }
        if (z11) {
            str3 = "通行密钥";
        }
        ConfigPreferences.k("user_config", "last_loged_account_from_page" + str, i11);
        ConfigPreferences.m("user_config", "last_loged_account_third_type" + str, str2);
        if (loginSuccBean != null && loginSuccBean.c()) {
            ConfigPreferences.m("user_config", "config_area_code_v3" + str, loginSuccBean.a());
            ConfigPreferences.m("user_config", "config_country_id_v3" + str, loginSuccBean.b());
        }
        if (r.x().F0()) {
            if (m.Y(str)) {
                str4 = "tel";
            } else {
                str4 = StringUtils.o(str) ? "mail" : "sub";
            }
            HashMap hashMap = new HashMap(2);
            hashMap.put("sign_type", str4);
            hashMap.put("verification_type", str3);
            g.i("sign_result", hashMap);
        }
    }

    public static void k() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("vToken", b.e().h(BaseApplication.b()));
        o9.a.a().authCodeLoginRegisterAbtest(hashMap).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a((Action1) null));
    }
}
