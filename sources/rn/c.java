package rn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.ui.FingerprintLoginActivity;
import com.huobi.login.ui.SecurityVerificationActivity;
import com.huobi.login.usercenter.data.source.bean.LogoutInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.usercenter.external.bean.LoginResult;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.utils.FingerprintHelper;
import com.huobi.login.v3.ui.UserRegisterActivityV3;
import com.huobi.utils.GestureUtil;
import com.huobi.utils.k0;
import com.huobi.webview2.ui.LoginWebActivity;
import com.huochat.community.network.domain.DomainTool;
import i6.k;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kn.a;
import pro.huobi.R;
import rx.Emitter;
import rx.Observable;
import sn.f;
import tg.r;
import tq.p;
import wi.b;
import wn.c0;

public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static c f76473e = new c();

    /* renamed from: a  reason: collision with root package name */
    public UserToken f76474a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Emitter<LoginResult>> f76475b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public String f76476c;

    /* renamed from: d  reason: collision with root package name */
    public String f76477d;

    public static c i() {
        return f76473e;
    }

    public static /* synthetic */ Boolean r(LogoutInfoData logoutInfoData) {
        return Boolean.valueOf(logoutInfoData != null);
    }

    public void A(Activity activity, a aVar) {
        if (aVar instanceof JumpTarget) {
            try {
                String expandData = ((JumpTarget) aVar).getExpandData();
                if (!"LOGIN_FROM_PERSONAL_CENTER".equals(expandData)) {
                    Intent showIntent = ((JumpTarget) aVar).getShowIntent();
                    if (showIntent != null) {
                        String stringExtra = showIntent.getStringExtra("navigator_action");
                        if (TextUtils.isEmpty(stringExtra)) {
                            activity.startActivity(k0.h(activity));
                            return;
                        }
                        if (!"pro.huobi.pro".equals(stringExtra) && !"pro.huobi.margin".equals(stringExtra) && !"pro.huobi.balance".equals(stringExtra) && !"pro.huobi.contract".equals(stringExtra) && !"pro.huobi.swap".equals(stringExtra) && !"pro.huobi.supermargin".equals(stringExtra) && !"pro.huobi.c2c".equals(stringExtra) && !"pro.huobi.c2clend".equals(stringExtra) && !"pro.huobi.home".equals(stringExtra) && !"pro.huobi.linearswap".equals(stringExtra) && !"pro.huobi.option".equals(stringExtra)) {
                            if (!"pro.huobi.account".equals(stringExtra)) {
                                if (showIntent.getBooleanExtra("EXTRA_FORCE_JUMP_VIP_RULE", false)) {
                                    activity.startActivity(os.c.k(activity));
                                    return;
                                } else {
                                    activity.startActivity(k0.h(activity));
                                    return;
                                }
                            }
                        }
                        f.e(activity, aVar);
                    } else if ("SUB_ACCOUNT_ENTER_FLAG".equals(expandData)) {
                        i().g(activity, aVar);
                    } else {
                        activity.startActivity(k0.h(activity));
                    }
                } else if (gj.a.b().c()) {
                    Intent a11 = k0.a(activity);
                    a11.addFlags(67108864);
                    activity.startActivity(a11);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                activity.startActivity(k0.h(activity));
            }
        } else {
            activity.startActivity(k0.h(activity));
        }
    }

    public boolean B() {
        return r.x().F0();
    }

    public Intent c(Intent intent, a aVar) {
        if (aVar == null) {
            return intent;
        }
        if (aVar instanceof Serializable) {
            intent.putExtra("target", (Serializable) aVar);
        } else if (aVar instanceof Parcelable) {
            intent.putExtra("target", (Parcelable) aVar);
        }
        return intent;
    }

    public boolean d(Context context, a aVar) {
        return e(context, aVar, true);
    }

    public boolean e(Context context, a aVar, boolean z11) {
        FingerprintHelper fingerprintHelper = new FingerprintHelper();
        if (r.x().F0()) {
            g(context, aVar);
            return false;
        } else if (GestureUtil.c()) {
            q(context, aVar);
            return true;
        } else if (fingerprintHelper.d()) {
            l(context, aVar);
            return true;
        } else {
            n(context, aVar, Boolean.FALSE, z11);
            return true;
        }
    }

    public boolean f(Activity activity) {
        Intent h11 = k0.h(activity);
        return i().d(activity, new JumpTarget(h11, h11));
    }

    public final void g(Context context, a aVar) {
        if (aVar != null) {
            aVar.show(context);
        }
    }

    public Intent h(Context context) {
        Intent intent = new Intent(context, LoginWebActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("url", DomainTool.DOMAIN_PREFIX + this.f76477d + b.E);
        intent.putExtra("title", context.getResources().getString(R.string.login_button));
        intent.putExtra("login_webview_type", 1);
        return intent;
    }

    public Intent j(Activity activity) {
        return k(activity, true, (String) null);
    }

    public Intent k(Activity activity, boolean z11, String str) {
        if (u()) {
            return h(activity);
        }
        Intent intent = new Intent(activity, c0.g(str));
        if (z11) {
            intent.addFlags(67108864);
        }
        return intent;
    }

    public void l(Context context, a aVar) {
        k.n("goToFingerprint");
        Intent intent = new Intent(context, FingerprintLoginActivity.class);
        c(intent, aVar);
        if (context == context.getApplicationContext()) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void m(Context context, a aVar) {
        n(context, aVar, Boolean.FALSE, true);
    }

    public void n(Context context, a aVar, Boolean bool, boolean z11) {
        Intent intent;
        k.n("goToLoginPage");
        if (!u()) {
            if (z11) {
                bool = Boolean.valueOf(TextUtils.isEmpty(c0.b()));
            }
            Intent intent2 = new Intent(context, bool.booleanValue() ? UserRegisterActivityV3.class : c0.f());
            intent2.addFlags(603979776);
            intent = intent2;
        } else if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(context, R.string.string_network_disconnect);
            return;
        } else {
            intent = h(context);
        }
        c(intent, aVar);
        if (context == context.getApplicationContext()) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        k.n("goToLoginPage");
    }

    public void o(Context context, a aVar) {
        p(context, aVar, true);
    }

    public void p(Context context, a aVar, boolean z11) {
        k.n("goToSecurityOrFingerOrLogin");
        r.x().k();
        FingerprintHelper fingerprintHelper = new FingerprintHelper();
        if (GestureUtil.c()) {
            q(context, aVar);
        } else if (fingerprintHelper.d()) {
            l(context, aVar);
        } else {
            n(context, aVar, Boolean.FALSE, z11);
        }
    }

    public void q(Context context, a aVar) {
        k.n("goToSecurityVer");
        Intent intent = new Intent(context, SecurityVerificationActivity.class);
        c(intent, aVar);
        if (context == context.getApplicationContext()) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public Observable<Boolean> t() {
        return UserCenterRemoteDataSource.A().k0().compose(p.c0()).map(a.f25763b).onErrorReturn(b.f25764b);
    }

    public boolean u() {
        return !TextUtils.isEmpty(this.f76476c) && "WEB".equals(this.f76476c);
    }

    public void v(JumpTarget jumpTarget, Context context) {
        w(jumpTarget, context, false);
    }

    public void w(JumpTarget jumpTarget, Context context, boolean z11) {
        if (!z11) {
            com.huobi.lifecycle.a.j().w();
        }
        if (jumpTarget != null) {
            jumpTarget.back(context);
        } else {
            context.startActivity(k0.h(context));
        }
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public void x(String str) {
        this.f76476c = str;
    }

    public void y(UserToken userToken) {
        this.f76474a = userToken;
    }

    public void z(String str) {
        this.f76477d = str;
    }
}
