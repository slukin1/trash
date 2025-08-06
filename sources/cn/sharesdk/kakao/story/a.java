package cn.sharesdk.kakao.story;

import android.content.Intent;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.kakao.utils.KakaoWebViewClient;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class a extends f {

    /* renamed from: e  reason: collision with root package name */
    private static a f13552e;

    /* renamed from: b  reason: collision with root package name */
    private SSDKNetworkHelper f13553b = SSDKNetworkHelper.getInstance();

    /* renamed from: c  reason: collision with root package name */
    private String f13554c;

    /* renamed from: d  reason: collision with root package name */
    private String f13555d;

    private a(Platform platform) {
        super(platform);
    }

    public void b(String str) {
        this.f13554c = str;
        this.f13555d = "kakao" + str + "://oauth";
    }

    public String getAuthorizeUrl() {
        return "https://kauth.kakao.com/oauth/authorize?client_id=" + this.f13554c + "&redirect_uri=" + this.f13555d + "&response_type=code";
    }

    public b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity) {
        return new KakaoWebViewClient(webAuthorizeActivity);
    }

    public String getRedirectUri() {
        return this.f13555d;
    }

    public static a a(Platform platform) {
        if (f13552e == null) {
            f13552e = new a(platform);
        }
        return f13552e;
    }

    public void a(ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            cn.sharesdk.kakao.utils.a.a(MobSDK.getContext(), a(), 80, shareSDKCallback);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    private Intent a() {
        return new Intent().setAction("com.kakao.story.intent.action.CAPRI_LOGGED_IN_ACTIVITY").addCategory("android.intent.category.DEFAULT").putExtra("com.kakao.sdk.talk.protocol.version", 1).putExtra("com.kakao.sdk.talk.appKey", this.f13554c).putExtra("com.kakao.sdk.talk.redirectUri", this.f13555d);
    }

    public void a(String str, String str2, String str3, PlatformActionListener platformActionListener) {
        final String str4 = str;
        final String str5 = str3;
        final String str6 = str2;
        final PlatformActionListener platformActionListener2 = platformActionListener;
        DH.requester(MobSDK.getContext()).getAppName().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                ArrayList arrayList;
                String str;
                String str2;
                try {
                    String appName = dHResponse.getAppName();
                    arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(str4)) {
                        arrayList.add(new KVPair("post", str4));
                    } else {
                        arrayList.add(new KVPair("post", str5));
                    }
                    arrayList.add(new KVPair("appid", DH.SyncMtd.getPackageName()));
                    arrayList.add(new KVPair("appver", DH.SyncMtd.getAppVersionName()));
                    arrayList.add(new KVPair("apiver", "1.0"));
                    if (!TextUtils.isEmpty(str6)) {
                        appName = str6;
                    }
                    arrayList.add(new KVPair("appname", appName));
                    str = "";
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str5)) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(str5);
                        jSONObject.put("imageurl", jSONArray);
                    }
                    str = "&urlinfo=" + URLEncoder.encode(jSONObject.toString(), "utf-8");
                } catch (Exception e11) {
                    SSDKLog.b().a((Throwable) e11);
                } catch (Throwable unused) {
                    return;
                }
                if (!TextUtils.isEmpty(str5)) {
                    str2 = "storylink://posting?" + ResHelper.encodeUrl((ArrayList<KVPair<String>>) arrayList) + str;
                } else {
                    str2 = "storylink://posting?" + ResHelper.encodeUrl((ArrayList<KVPair<String>>) arrayList);
                }
                Intent intent = new Intent();
                intent.putExtra(ShareConstants.MEDIA_URI, str2);
                ShareActivity shareActivity = new ShareActivity();
                shareActivity.setAction("share");
                shareActivity.setPlatformActionListener(a.this.f13438a, platformActionListener2);
                shareActivity.show(MobSDK.getContext(), intent);
            }
        });
    }

    public void a(int i11, String str, String str2, String str3, PlatformActionListener platformActionListener) {
        Intent intent = new Intent();
        intent.putExtra("path", str);
        intent.putExtra("type", i11);
        intent.putExtra("text", str2);
        intent.putExtra("title", str3);
        ShareActivity shareActivity = new ShareActivity();
        shareActivity.setAction("share");
        shareActivity.setPlatformActionListener(this.f13438a, platformActionListener);
        shareActivity.show(MobSDK.getContext(), intent);
    }

    public void a(PlatformActionListener platformActionListener) {
        Intent intent = new Intent();
        intent.putExtra(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, a());
        ShareActivity shareActivity = new ShareActivity();
        shareActivity.setPlatformActionListener(this.f13438a, platformActionListener);
        shareActivity.setAction("auth");
        shareActivity.show(MobSDK.getContext(), intent);
    }

    public HashMap<String, Object> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new KVPair("Authorization", "Bearer " + str));
            return new Hashon().fromJson(this.f13553b.httpGet("https://kapi.kakao.com/v1/api/story/profile", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null));
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return (HashMap) new HashMap().put("error", th2.getMessage());
        }
    }

    public void a(AuthorizeListener authorizeListener) {
        b(authorizeListener);
    }
}
