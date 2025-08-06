package cn.sharesdk.kakao.talk;

import android.content.Intent;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.kakao.utils.KakaoWebViewClient;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;

public class a extends f {

    /* renamed from: d  reason: collision with root package name */
    private static a f13572d;

    /* renamed from: b  reason: collision with root package name */
    private String f13573b;

    /* renamed from: c  reason: collision with root package name */
    private String f13574c;

    private a(Platform platform) {
        super(platform);
    }

    public String getAuthorizeUrl() {
        return "https://kauth.kakao.com/oauth/authorize?client_id=" + this.f13573b + "&redirect_uri=" + this.f13574c + "&response_type=code";
    }

    public b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity) {
        return new KakaoWebViewClient(webAuthorizeActivity);
    }

    public String getRedirectUri() {
        return this.f13574c;
    }

    public static a a(Platform platform) {
        if (f13572d == null) {
            f13572d = new a(platform);
        }
        return f13572d;
    }

    public void a(String str) {
        this.f13573b = str;
        this.f13574c = "kakao" + str + "://oauth";
    }

    public void a(ShareSDKCallback<Boolean> shareSDKCallback) {
        cn.sharesdk.kakao.utils.a.a(MobSDK.getContext(), a(), 139, shareSDKCallback);
    }

    private Intent a() {
        return new Intent().setAction("com.kakao.talk.intent.action.CAPRI_LOGGED_IN_ACTIVITY").addCategory("android.intent.category.DEFAULT").putExtra("com.kakao.sdk.talk.protocol.version", 1).putExtra("com.kakao.sdk.talk.appKey", this.f13573b).putExtra("com.kakao.sdk.talk.redirectUri", this.f13574c).putExtra("com.kakao.sdk.talk.kaHeader", cn.sharesdk.kakao.utils.a.a());
    }

    public void a(String str, final String str2, String str3, String str4, String str5, String[] strArr, String str6, final PlatformActionListener platformActionListener) {
        try {
            final Intent intent = new Intent();
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("text", str);
            }
            if (!TextUtils.isEmpty(str4)) {
                intent.putExtra(InnerShareParams.IMAGE_PATH, str4);
            }
            if (strArr != null) {
                intent.putExtra(InnerShareParams.IMAGE_ARRAY, strArr);
            }
            if (!TextUtils.isEmpty(str3)) {
                intent.putExtra("url", str3);
            }
            if (!TextUtils.isEmpty(str6)) {
                intent.putExtra(InnerShareParams.FILE_PATH, str6);
            }
            if (!TextUtils.isEmpty(str2)) {
                new Thread() {
                    public void run() {
                        try {
                            String downloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), str2);
                            if (!TextUtils.isEmpty(downloadBitmap)) {
                                intent.putExtra(InnerShareParams.IMAGE_PATH, downloadBitmap);
                            }
                            ShareActivity shareActivity = new ShareActivity();
                            shareActivity.setPlatformActionListener(a.this.f13438a, platformActionListener);
                            shareActivity.setAction("share");
                            shareActivity.show(MobSDK.getContext(), intent);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                        }
                    }
                }.start();
                return;
            }
            ShareActivity shareActivity = new ShareActivity();
            shareActivity.setPlatformActionListener(this.f13438a, platformActionListener);
            shareActivity.setAction("share");
            shareActivity.show(MobSDK.getContext(), intent);
        } catch (Exception e11) {
            SSDKLog.b().a((Throwable) e11);
        }
    }

    public void a(PlatformActionListener platformActionListener) {
        Intent intent = new Intent();
        intent.putExtra(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, a());
        ShareActivity shareActivity = new ShareActivity();
        shareActivity.setPlatformActionListener(this.f13438a, platformActionListener);
        shareActivity.setAction("auth");
        shareActivity.show(MobSDK.getContext(), intent);
    }

    public void a(AuthorizeListener authorizeListener) {
        b(authorizeListener);
    }
}
