package cn.sharesdk.line;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.SSOAuthorizeActivity;
import cn.sharesdk.framework.authorize.c;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.line.utils.LineAuthenticationConfig;
import cn.sharesdk.line.utils.LineAuthenticationParams;
import cn.sharesdk.line.utils.b;
import cn.sharesdk.line.utils.e;
import cn.sharesdk.line.utils.f;
import cn.sharesdk.line.utils.g;
import com.facebook.internal.ServerProtocol;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d extends c {

    /* renamed from: d  reason: collision with root package name */
    private String f13629d;

    /* renamed from: e  reason: collision with root package name */
    private String f13630e;

    public d(SSOAuthorizeActivity sSOAuthorizeActivity) {
        super(sSOAuthorizeActivity);
    }

    private List<e> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(e.f13659a);
        arrayList.add(e.f13663e);
        return arrayList;
    }

    private LineAuthenticationParams.a e() {
        return LineAuthenticationParams.a.normal;
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        String a11 = f.a(8);
        String a12 = f.a(8);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(a(c(), str, b(), a12, a11, this.f13630e));
        intent.setPackage("jp.naver.line.android");
        this.f13417a.startActivityForResult(intent, 22);
    }

    private LineAuthenticationConfig c() {
        return b.a(this.f13629d, false);
    }

    public void a(String str, String str2) {
        this.f13629d = str;
        this.f13630e = str2;
    }

    private void a(final String str) throws Throwable {
        new Thread() {
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new KVPair("client_id", str));
                try {
                    String httpPost = c.a().b().httpPost("https://api.line.me/oauth2/v2.1/otp", arrayList, "/oauth2/v2.1/otp", c.a().c());
                    if (httpPost != null) {
                        HashMap fromJson = new Hashon().fromJson(httpPost);
                        String valueOf = String.valueOf(fromJson.get("otpId"));
                        String valueOf2 = String.valueOf(fromJson.get("otp"));
                        d.this.b(valueOf);
                        if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                            e eVar = new e(MobSDK.getContext(), "line_sp");
                            eVar.a("otp_id", valueOf);
                            eVar.a("otp_password", valueOf2);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }.start();
    }

    public void a() {
        if (b(((Activity) this.f13417a.getContext()).getIntent())) {
            this.f13417a.finish();
        } else if (TextUtils.isEmpty(this.f13629d)) {
            this.f13417a.finish();
        } else {
            try {
                a(this.f13629d);
            } catch (Throwable th2) {
                this.f13417a.finish();
                throw th2;
            }
            this.f13417a.finish();
        }
    }

    private LineAuthenticationParams b() {
        return new LineAuthenticationParams.b().a(d()).a(e()).a();
    }

    private boolean b(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return false;
        }
        Uri data = intent.getData();
        if (!(this.f13419c == null || data == null)) {
            Bundle urlToBundle = ResHelper.urlToBundle(data.toString());
            try {
                int parseInt = ResHelper.parseInt(urlToBundle.getString("status"));
                String string = urlToBundle.getString("requestToken");
                if (parseInt == 0) {
                    a(this.f13417a.getHelper().getPlatform(), string);
                } else if (parseInt != 1) {
                    this.f13419c.onFailed(new Throwable(data.toString()));
                } else {
                    this.f13419c.onCancel();
                }
            } catch (Throwable th2) {
                this.f13419c.onFailed(th2);
                SSDKLog.b().b(th2);
            }
        }
        return true;
    }

    public void a(int i11, int i12, Intent intent) {
        super.a(i11, i12, intent);
    }

    private Uri a(LineAuthenticationConfig lineAuthenticationConfig, String str, LineAuthenticationParams lineAuthenticationParams, String str2, String str3, String str4) {
        Map<String, String> a11 = g.a(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "code", "client_id", this.f13629d, "state", str2, "otpId", str, ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str4, HiAnalyticsConstant.BI_KEY_SDK_VER, "5.0.0", "scope", e.a(lineAuthenticationParams.a()));
        if (!TextUtils.isEmpty(str3)) {
            a11.put("nonce", str3);
        }
        if (!TextUtils.isEmpty(str3)) {
            a11.put("nonce", str3);
        }
        return g.a(Uri.parse("https://access.line.me/oauth2/v2.1/login"), g.a("returnUri", g.a("/oauth2/v2.1/authorize/consent", a11).toString(), "loginChannelId", this.f13629d));
    }

    private void a(Platform platform, String str) {
        new Thread() {
            public void run() {
                try {
                    c.a();
                    d.this.f13419c.onFailed(new Throwable("Authorize token is empty"));
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                    d.this.f13419c.onFailed(th2);
                }
            }
        }.start();
    }
}
