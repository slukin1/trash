package cn.sharesdk.telegram;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.g;
import cn.sharesdk.framework.utils.i;
import com.google.common.net.HttpHeaders;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public class a extends f {

    /* renamed from: b  reason: collision with root package name */
    private static String f13737b = "https://oauth.telegram.org/auth";

    /* renamed from: c  reason: collision with root package name */
    private static String f13738c = "www.mob.com";

    /* renamed from: d  reason: collision with root package name */
    private static a f13739d;

    /* renamed from: e  reason: collision with root package name */
    private SSDKNetworkHelper f13740e = SSDKNetworkHelper.getInstance();

    /* renamed from: f  reason: collision with root package name */
    private String f13741f;

    /* renamed from: g  reason: collision with root package name */
    private String f13742g;

    /* renamed from: h  reason: collision with root package name */
    private String f13743h;

    /* renamed from: i  reason: collision with root package name */
    private String f13744i;

    public a(Platform platform) {
        super(platform);
    }

    public void a(String str) {
        this.f13741f = str;
    }

    public void b(String str) {
        this.f13742g = str;
    }

    public void c(String str) {
        this.f13743h = str;
    }

    public void d(String str) {
        this.f13744i = str;
    }

    public HashMap<String, Object> e(String str) throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("bot_id", this.f13741f));
        arrayList.add(new KVPair("origin", this.f13742g));
        arrayList.add(new KVPair("request_access", "write"));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
        arrayList2.add(new KVPair(HttpHeaders.X_REQUESTED_WITH, "XMLHttpRequest"));
        arrayList2.add(new KVPair("cookie", "stel_ssid=" + this.f13744i + ';' + "stel_token=" + this.f13743h));
        String httpPost = this.f13740e.httpPost("https://oauth.telegram.org/auth/get", arrayList, (KVPair<String>) null, arrayList2, "/auth/get", b());
        if (httpPost == null || httpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(httpPost);
    }

    public String getAuthorizeUrl() {
        return f13737b + '?' + "bot_id" + '=' + this.f13741f + '&' + "origin" + '=' + this.f13742g + '&' + "request_access" + '=' + "write";
    }

    public b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity) {
        return new b(webAuthorizeActivity);
    }

    public String getRedirectUri() {
        return f13738c;
    }

    public boolean a() {
        return (this.f13743h == null || this.f13744i == null) ? false : true;
    }

    public static a a(Platform platform) {
        if (f13739d == null) {
            synchronized (a.class) {
                if (f13739d == null) {
                    f13739d = new a(platform);
                }
            }
        }
        return f13739d;
    }

    public void a(final Platform.ShareParams shareParams, final Platform platform) throws Throwable {
        DH.requester(MobSDK.getContext()).getPInfoForce(true, "org.telegram.messenger", 0).getPInfoForce(true, "org.telegram.messenger.web", 0).request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                String str = "";
                try {
                    PackageInfo pInfoForce = dHResponse.getPInfoForce(0);
                    String str2 = "org.telegram.messenger";
                    if (pInfoForce == null) {
                        pInfoForce = i.a(str2, 0);
                    }
                    PackageInfo pInfoForce2 = dHResponse.getPInfoForce(1);
                    String str3 = "org.telegram.messenger.web";
                    if (pInfoForce2 == null) {
                        pInfoForce2 = i.a(str3, 0);
                    }
                    if (pInfoForce != null) {
                        str = str2;
                    }
                    if (!TextUtils.isEmpty(str) || pInfoForce2 == null) {
                        str3 = str;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        SSDKLog.b().a("telegram is not installed!", new Object[0]);
                    } else {
                        str2 = str3;
                    }
                    g gVar = new g();
                    gVar.a(str2, "org.telegram.ui.LaunchActivity");
                    gVar.a(shareParams, platform);
                } catch (Throwable th2) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a("bp s" + th2, new Object[0]);
                }
            }
        });
    }

    public void a(AuthorizeListener authorizeListener) {
        b(authorizeListener);
    }
}
