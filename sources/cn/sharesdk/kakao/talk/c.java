package cn.sharesdk.kakao.talk;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.kakao.message.template.LinkObject;
import com.kakao.message.template.SocialObject;
import com.kakao.network.callback.ResponseCallback;
import com.mob.MobSDK;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import java.util.Map;
import rw.b;
import tw.a;
import tw.d;
import tw.e;
import tw.g;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private PlatformActionListener f13580a;

    /* renamed from: b  reason: collision with root package name */
    private Platform f13581b;

    public c(Platform platform, PlatformActionListener platformActionListener) {
        this.f13581b = platform;
        this.f13580a = platformActionListener;
    }

    public void a(String str, String str2, String str3, String str4, String str5, int i11, int i12, int i13, String str6, String str7, String str8) {
        SSDKLog b11 = SSDKLog.b();
        b11.b(OnekeyShare.SHARESDK_TAG, " sendDefaultFeedTemplate contentTitle: " + str + " imageUrl: " + str2 + " kakaoWebUrl: " + str3 + " kakaoMobileweburl: " + str4 + " description " + str5 + " likeCount: " + i11 + " commentcount: " + i12 + " sharecount: " + i13 + " addbuttonTitle: " + str6 + " addbuttonWeburl:  addbuttonMobileweburl: " + str8);
        b.b().h(MobSDK.getContext(), e.c(d.a(str, str2, LinkObject.a().g(str3).f(str4).e()).h(str5).g()).c(SocialObject.a().h(i11).g(i12).i(i13).f()).a(new a(str6, LinkObject.a().g(str7).f(str8).e())).b(), new ResponseCallback<rw.a>() {
            /* renamed from: a */
            public void onSuccess(rw.a aVar) {
                c.this.a(aVar);
            }

            public void onFailure(uw.c cVar) {
                c.this.a(cVar);
            }
        });
    }

    public void a(String str) {
        SSDKLog b11 = SSDKLog.b();
        b11.b(OnekeyShare.SHARESDK_TAG, " sendDefaultUrl url: " + str);
        b.b().l(MobSDK.getContext(), str, (Map<String, String>) null, new ResponseCallback<rw.a>() {
            /* renamed from: a */
            public void onSuccess(rw.a aVar) {
                c.this.a(aVar);
            }

            public void onFailure(uw.c cVar) {
                c.this.a(cVar);
            }
        });
    }

    public void a(String str, String str2, String str3, String str4, String str5, int i11, String str6, int i12, int i13) {
        SSDKLog b11 = SSDKLog.b();
        b11.b(OnekeyShare.SHARESDK_TAG, " sendDefaultCommerceTemplate title: " + str + " imageUrl: " + str2 + " webUrl: " + str3 + " mobileWebUrl " + str4 + " description:  regularPrice: " + i11 + " productName: " + str6 + " discountPrice: " + i12 + " discountRate " + i13);
        b.b().i(MobSDK.getContext(), tw.c.c(d.a(str, str2, LinkObject.a().g(str3).f(str4).e()).h(str5).g(), tw.b.a(Integer.valueOf(i11)).i(str6).g(Integer.valueOf(i12)).h(Integer.valueOf(i13)).f()).a(), (Map<String, String>) null, new ResponseCallback<rw.a>() {
            /* renamed from: a */
            public void onSuccess(rw.a aVar) {
                c.this.a(aVar);
            }

            public void onFailure(uw.c cVar) {
                c.this.a(cVar);
            }
        });
    }

    public void a(String str, String str2, String str3, String str4) {
        SSDKLog b11 = SSDKLog.b();
        b11.b(OnekeyShare.SHARESDK_TAG, " sendDefaultTextTemplate text: " + str + " webUrl: " + str2 + " mobileWebUrl: " + str3 + " buttonTitle " + str4);
        b.b().i(MobSDK.getContext(), g.c(str, LinkObject.a().g(str2).f(str3).e()).b(str4).a(), (Map<String, String>) null, new ResponseCallback<rw.a>() {
            /* renamed from: a */
            public void onSuccess(rw.a aVar) {
                c.this.a(aVar);
            }

            public void onFailure(uw.c cVar) {
                c.this.a(cVar);
            }
        });
    }

    public void a(String str, HashMap<String, String> hashMap) {
        b.b().g(MobSDK.getContext(), str, hashMap, (Map<String, String>) null, new ResponseCallback<rw.a>() {
            /* renamed from: a */
            public void onSuccess(rw.a aVar) {
                c.this.a(aVar);
            }

            public void onFailure(uw.c cVar) {
                c.this.a(cVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(uw.c cVar) {
        try {
            PlatformActionListener platformActionListener = this.f13580a;
            if (platformActionListener != null) {
                platformActionListener.onError(this.f13581b, 9, cVar.c());
            }
        } catch (Throwable th2) {
            SSDKLog b11 = SSDKLog.b();
            b11.a("KakaoTalkWithSDK onFailure catch: " + th2, new Object[0]);
            PlatformActionListener platformActionListener2 = this.f13580a;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this.f13581b, 9, (Throwable) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(rw.a aVar) {
        try {
            if (this.f13580a != null) {
                this.f13580a.onComplete(this.f13581b, 9, new Hashon().fromJson(aVar.b().toString()));
            }
        } catch (Throwable th2) {
            SSDKLog b11 = SSDKLog.b();
            b11.a("KakaoTalkWithSDK onSuccess switch result catcht " + th2, new Object[0]);
            PlatformActionListener platformActionListener = this.f13580a;
            if (platformActionListener != null) {
                platformActionListener.onComplete(this.f13581b, 9, (HashMap<String, Object>) null);
            }
        }
    }
}
