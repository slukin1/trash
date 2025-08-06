package cn.sharesdk.line;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOAuthorizeActivity;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.line.utils.a;
import cn.sharesdk.line.utils.f;
import com.facebook.AccessToken;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.Scopes;
import com.huochat.community.base.CommunityConstants;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.twitter.sdk.android.core.internal.oauth.OAuthConstants;
import java.util.ArrayList;
import java.util.HashMap;

public class c implements AuthorizeHelper {

    /* renamed from: c  reason: collision with root package name */
    private static c f13612c;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public AuthorizeListener f13613a;

    /* renamed from: b  reason: collision with root package name */
    private SSOListener f13614b;

    /* renamed from: d  reason: collision with root package name */
    private b f13615d;

    /* renamed from: e  reason: collision with root package name */
    private SSDKNetworkHelper f13616e;

    /* renamed from: f  reason: collision with root package name */
    private Platform f13617f;

    /* renamed from: g  reason: collision with root package name */
    private String f13618g;

    /* renamed from: h  reason: collision with root package name */
    private String f13619h;

    /* renamed from: i  reason: collision with root package name */
    private String f13620i;

    /* renamed from: j  reason: collision with root package name */
    private String f13621j;

    private c() {
        SSDKNetworkHelper instance = SSDKNetworkHelper.getInstance();
        this.f13616e = instance;
        a(instance);
    }

    public SSDKNetworkHelper b() {
        return this.f13616e;
    }

    public int c() {
        return 32;
    }

    public boolean c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("access_token", str));
        try {
            String httpGet = this.f13616e.httpGet("https://api.line.me/oauth2/v2.1/verify", arrayList, (ArrayList<KVPair<String>>) null, (NetworkHelper.NetworkTimeOut) null);
            if (!TextUtils.isEmpty(httpGet) && !httpGet.contains("error")) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return false;
        }
    }

    public void d(String str) {
        this.f13621j = str;
    }

    public void e(String str) throws Throwable {
        c("text", Data.urlEncode(str, "utf-8"));
    }

    public void f(String str) throws Throwable {
        c("image", str);
    }

    public AuthorizeListener getAuthorizeListener() {
        return this.f13613a;
    }

    public String getAuthorizeUrl() {
        String a11 = f.a(8);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "code"));
        arrayList.add(new KVPair("client_id", this.f13618g));
        arrayList.add(new KVPair(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "https://www.mob.com/"));
        arrayList.add(new KVPair("scope", Scopes.PROFILE));
        arrayList.add(new KVPair("nonce", a11));
        arrayList.add(new KVPair("state", "12345abcde"));
        return "https://access.line.me/oauth2/v2.1/authorize?" + ResHelper.encodeUrl((ArrayList<KVPair<String>>) arrayList);
    }

    public b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity) {
        return new a(webAuthorizeActivity);
    }

    public Platform getPlatform() {
        Platform a11 = this.f13615d.a();
        this.f13617f = a11;
        return a11;
    }

    public String getRedirectUri() {
        return this.f13620i;
    }

    public SSOListener getSSOListener() {
        return null;
    }

    public cn.sharesdk.framework.authorize.c getSSOProcessor(SSOAuthorizeActivity sSOAuthorizeActivity) {
        d dVar = new d(sSOAuthorizeActivity);
        String str = this.f13618g;
        dVar.a(str, "intent://result#Intent;package=" + sSOAuthorizeActivity.getContext().getPackageName() + ";scheme=lineauth;end");
        return dVar;
    }

    public String b(String str, String str2) throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(OAuthConstants.PARAM_GRANT_TYPE, "authorization_code"));
        arrayList.add(new KVPair("code", str));
        arrayList.add(new KVPair(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "intent://result#Intent;package=" + MobSDK.getContext().getPackageName() + ";scheme=lineauth;end"));
        arrayList.add(new KVPair("client_id", this.f13618g));
        arrayList.add(new KVPair("otp", str2));
        arrayList.add(new KVPair("id_token_key_type", a.JWK.name()));
        arrayList.add(new KVPair("client_version", "LINE SDK Android v5.0.0"));
        try {
            return this.f13616e.httpPost("https://api.line.me/oauth2/v2.1/token", arrayList, "/oauth2/v2.1/token", c());
        } catch (Throwable unused) {
            return null;
        }
    }

    public HashMap<String, Object> d() throws Throwable {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair("Authorization", "Bearer " + this.f13621j));
        String httpGet = this.f13616e.httpGet("https://api.line.me/v2/profile", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null, "/v2/profile", c());
        if (httpGet != null) {
            return new Hashon().fromJson(httpGet);
        }
        return null;
    }

    public static c a() {
        if (f13612c == null) {
            synchronized (c.class) {
                if (f13612c == null) {
                    f13612c = new c();
                }
            }
        }
        return f13612c;
    }

    private void c(String str, String str2) throws Throwable {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("line://msg/" + str + "/" + str2));
        intent.addFlags(268435456);
        try {
            MobSDK.getContext().startActivity(intent);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }

    /* access modifiers changed from: private */
    public void d(final String str, final String str2) {
        new Thread() {
            public void run() {
                String str;
                try {
                    str = c.this.b(str, str2);
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                    if (c.this.f13613a != null) {
                        c.this.f13613a.onError(th2);
                        return;
                    }
                    return;
                }
                if (str != null || c.this.f13613a == null) {
                    HashMap fromJson = new Hashon().fromJson(str);
                    Bundle bundle = new Bundle();
                    bundle.putString("access_token", String.valueOf(fromJson.get("access_token")));
                    bundle.putString("token_type", String.valueOf(fromJson.get("token_type")));
                    bundle.putString("refresh_token", String.valueOf(fromJson.get("refresh_token")));
                    bundle.putString(AccessToken.EXPIRES_IN_KEY, String.valueOf(fromJson.get(AccessToken.EXPIRES_IN_KEY)));
                    bundle.putString("scope", String.valueOf(fromJson.get("scope")));
                    bundle.putString("id_token", String.valueOf(fromJson.get("id_token")));
                    c.this.f13613a.onComplete(bundle);
                    return;
                }
                c.this.f13613a.onError(new Throwable("Authorize token is empty"));
            }
        }.start();
    }

    public void a(SSDKNetworkHelper sSDKNetworkHelper) {
        this.f13616e = sSDKNetworkHelper;
    }

    public void a(b bVar) {
        this.f13615d = bVar;
    }

    public void a(String str, String str2) {
        this.f13618g = str;
        this.f13619h = str2;
    }

    public String b(String str) throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(OAuthConstants.PARAM_GRANT_TYPE, "authorization_code"));
        arrayList.add(new KVPair("code", str));
        arrayList.add(new KVPair(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.f13620i));
        arrayList.add(new KVPair("client_id", this.f13618g));
        arrayList.add(new KVPair("client_secret", this.f13619h));
        try {
            return this.f13616e.httpPost("https://api.line.me/oauth2/v2.1/token", arrayList, "/oauth2/v2.1/token", c());
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(String str) {
        this.f13620i = str;
    }

    public void a(AuthorizeListener authorizeListener) {
        this.f13613a = authorizeListener;
        WebAuthorizeActivity webAuthorizeActivity = new WebAuthorizeActivity();
        webAuthorizeActivity.setAuthorizeListener(this.f13613a);
        webAuthorizeActivity.show(this);
    }

    public void a(SSOListener sSOListener) {
        this.f13614b = sSOListener;
        SSOAuthorizeActivity sSOAuthorizeActivity = new SSOAuthorizeActivity();
        sSOAuthorizeActivity.setSSOListener(sSOListener);
        sSOAuthorizeActivity.show(this);
    }

    public boolean b(b bVar) {
        Platform a11 = bVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("refreshToken", a11.getDb().get("refresh_token")));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair("Content-Type", "application/x-www-form-urlencoded"));
        arrayList2.add(new KVPair("X-Line-ChannelToken", a11.getDb().getToken()));
        try {
            String httpPost = this.f13616e.httpPost("https://api.line.me/v1/oauth/accessToken", (ArrayList<KVPair<String>>) arrayList, (KVPair<String>) null, (ArrayList<KVPair<String>>) arrayList2, (NetworkHelper.NetworkTimeOut) null);
            if (TextUtils.isEmpty(httpPost) || httpPost.contains("error")) {
                return false;
            }
            a(httpPost, bVar);
            return true;
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return false;
        }
    }

    public void a(final AuthorizeListener authorizeListener, boolean z11, boolean z12) {
        this.f13613a = authorizeListener;
        if (z11) {
            a(authorizeListener);
        } else if (z12) {
            a((SSOListener) new SSOListener() {
                public void onCancel() {
                    authorizeListener.onCancel();
                }

                public void onComplete(Bundle bundle) {
                    authorizeListener.onComplete(bundle);
                }

                public void onFailed(Throwable th2) {
                    c.this.a(authorizeListener);
                }
            });
        } else {
            a(authorizeListener);
        }
    }

    private void a(String str, b bVar) {
        Platform a11 = bVar.a();
        HashMap fromJson = new Hashon().fromJson(str);
        String valueOf = String.valueOf(fromJson.get(CommunityConstants.REQUEST_KEY_MID));
        String valueOf2 = String.valueOf(fromJson.get(AccessToken.EXPIRES_IN_KEY));
        String valueOf3 = String.valueOf(fromJson.get("access_token"));
        String valueOf4 = String.valueOf(fromJson.get("refresh_token"));
        String valueOf5 = String.valueOf(fromJson.get("token_type"));
        a11.getDb().putUserId(valueOf);
        a11.getDb().putExpiresIn(Long.valueOf(valueOf2).longValue());
        a11.getDb().putToken(valueOf3);
        a11.getDb().put("refresh_token", valueOf4);
        a11.getDb().put("token_type", valueOf5);
    }

    public void a(LineHandlerActivity lineHandlerActivity, Uri uri) {
        if (uri == null && this.f13613a != null) {
            this.f13613a.onError(new Throwable("Illegal redirection from external application."));
        }
        String queryParameter = uri.getQueryParameter("error");
        String queryParameter2 = uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
        if (!TextUtils.isEmpty(queryParameter)) {
            this.f13613a.onError(new Throwable(queryParameter));
        }
        if (!TextUtils.isEmpty(queryParameter2)) {
            this.f13613a.onError(new Throwable(queryParameter2));
        }
        final String queryParameter3 = uri.getQueryParameter("code");
        if (!TextUtils.isEmpty(queryParameter3)) {
            new Thread() {
                public void run() {
                    try {
                        String trim = new e(MobSDK.getContext(), "line_sp").b("otp_password", (Object) null).toString().trim();
                        if (!TextUtils.isEmpty(trim)) {
                            c.this.d(queryParameter3, trim);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }.start();
        }
    }
}
