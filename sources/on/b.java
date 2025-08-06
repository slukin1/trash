package on;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.ThirdData;
import i6.k;
import java.util.Arrays;
import java.util.Collection;
import org.json.JSONObject;
import pro.huobi.R;

public class b implements d<AccessToken>, FacebookCallback<LoginResult> {

    /* renamed from: a  reason: collision with root package name */
    public String f76401a = "Third login FacebookLogin";

    /* renamed from: b  reason: collision with root package name */
    public Activity f76402b;

    /* renamed from: c  reason: collision with root package name */
    public f f76403c;

    /* renamed from: d  reason: collision with root package name */
    public LoginManager f76404d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackManager f76405e;

    /* renamed from: f  reason: collision with root package name */
    public int f76406f = 0;

    public b(Activity activity, f fVar) {
        k.o("Third login FacebookLogin", "FacebookLogin construct");
        this.f76402b = activity;
        this.f76403c = fVar;
        this.f76405e = CallbackManager.Factory.create();
        LoginManager instance = LoginManager.getInstance();
        this.f76404d = instance;
        instance.registerCallback(this.f76405e, this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(AccessToken accessToken, JSONObject jSONObject, GraphResponse graphResponse) {
        String str = this.f76401a;
        k.o(str, "onSuccess token:" + accessToken.toString() + " object: " + jSONObject.toString() + " response:" + graphResponse.toString());
        ThirdData thirdData = new ThirdData();
        thirdData.f75672b = accessToken.getToken();
        thirdData.f75671a = LoginPresenter.f75468t;
        thirdData.f75675e = jSONObject.optString("email", (String) null);
        thirdData.f75673c = this.f76402b.getString(R.string.facebook_app_id);
        String str2 = this.f76401a;
        k.o(str2, "initAccountData: " + thirdData.toString());
        this.f76403c.x(thirdData);
    }

    /* renamed from: c */
    public void onSuccess(LoginResult loginResult) {
        k.o(this.f76401a, "onSuccess");
        int i11 = this.f76406f;
        if (i11 == 1) {
            this.f76406f = i11 - 1;
            d(loginResult.getAccessToken());
        }
    }

    public void d(AccessToken accessToken) {
        GraphRequest newMeRequest = GraphRequest.newMeRequest(accessToken, new a(this, accessToken));
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,link,gender,birthday,email,picture,locale,updated_time,timezone,age_range,first_name,last_name");
        newMeRequest.setParameters(bundle);
        newMeRequest.executeAsync();
    }

    public void login() {
        LoginManager loginManager = this.f76404d;
        if (loginManager != null) {
            this.f76406f = 1;
            loginManager.logInWithReadPermissions(this.f76402b, (Collection<String>) Arrays.asList(new String[]{"public_profile", "user_status", "email"}));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r7.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            if (r7 == 0) goto L_0x000d
            android.os.Bundle r0 = r7.getExtras()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.toString()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            java.lang.String r1 = r4.f76401a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onActivityResult: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r3 = " "
            r2.append(r3)
            r2.append(r6)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            i6.k.o(r1, r0)
            com.facebook.CallbackManager r0 = r4.f76405e
            if (r0 == 0) goto L_0x0039
            r0.onActivityResult(r5, r6, r7)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: on.b.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel() {
        k.o(this.f76401a, "onCancel");
        this.f76403c.p(LoginPresenter.f75468t);
    }

    public void onError(FacebookException facebookException) {
        if (facebookException != null) {
            String facebookException2 = facebookException.toString();
            String str = this.f76401a;
            k.o(str, "onError: " + facebookException2);
            HuobiToastUtil.j(R.string.third_login_bind_get_info_error);
        }
        this.f76403c.onError(facebookException);
    }
}
