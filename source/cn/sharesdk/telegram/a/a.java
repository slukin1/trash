package cn.sharesdk.telegram.a;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.i;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f13748a;

    public static a a() {
        if (f13748a == null) {
            f13748a = new a();
        }
        return f13748a;
    }

    public void a(final ShareSDKCallback<Boolean> shareSDKCallback) {
        SSDKLog.b().a("checking signature of Telegram client...", new Object[0]);
        DH.requester(MobSDK.getContext()).getPInfoForce(true, "org.telegram.messenger", 64).getPInfoForce(true, "org.telegram.messenger.web", 0).request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                boolean z11 = true;
                try {
                    PackageInfo pInfoForce = dHResponse.getPInfoForce(0);
                    if (pInfoForce == null) {
                        pInfoForce = i.a("org.telegram.messenger", 64);
                    }
                    if (pInfoForce == null) {
                        PackageInfo pInfoForce2 = dHResponse.getPInfoForce(1);
                        if (pInfoForce2 == null) {
                            pInfoForce2 = i.a("org.telegram.messenger.web", 64);
                        }
                        ShareSDKCallback shareSDKCallback = shareSDKCallback;
                        if (shareSDKCallback != null) {
                            if (pInfoForce2 == null) {
                                z11 = false;
                            }
                            shareSDKCallback.onCallback(Boolean.valueOf(z11));
                            return;
                        }
                        return;
                    }
                    for (Signature charsString : pInfoForce.signatures) {
                        if ("3082021730820180a0030201020204521f9d49300d06092a864886f70d0101050500305031193017060355040713105361696e742d50657465727362757267310b3009060355040a1302564b310b3009060355040b1302564b31193017060355040313104e696b6f6c6179204b75646173686f76301e170d3133303832393139313331335a170d3338303832333139313331335a305031193017060355040713105361696e742d50657465727362757267310b3009060355040a1302564b310b3009060355040b1302564b31193017060355040313104e696b6f6c6179204b75646173686f7630819f300d06092a864886f70d010101050003818d0030818902818100df5e993a0dec0ab5b557dfff77e0b2227186cbf13d1fd1ed8e9deb5650c5fd4467bb51bfa585228d084bd27045f7415b7c4e38f08be362639a2eeb9b0c749da460f2705f6a7e14aca76abe3360af00b719cc5f3ff4d4da05958327e948b3679e6417ad7baa8779b9d689799ba345839a049fd44362499054a0803a0178c773790203010001300d06092a864886f70d010105050003818100dda58cdd90159c431ecc4a15902eafb07a50e01ba9d4f8e655ec14b06bd8e8771239710a28991039e02e352762eb524af07602bbdfb479d3718658a534d411dfab30122c8d0a5efd165a620669d80a221a04ac7d68b3811150c769cf97d3274be9b9f27c4c5877eabbcf8990409e5943df8deb509fa83d68eabc74f7c5976743".equals(charsString.toCharsString())) {
                            SSDKLog.b().a("pass!", new Object[0]);
                            ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                            if (shareSDKCallback2 != null) {
                                shareSDKCallback2.onCallback(Boolean.TRUE);
                            }
                        } else {
                            ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                            if (shareSDKCallback3 != null) {
                                shareSDKCallback3.onCallback(Boolean.FALSE);
                            }
                        }
                    }
                } catch (Throwable unused) {
                    ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                    if (shareSDKCallback4 != null) {
                        shareSDKCallback4.onCallback(Boolean.FALSE);
                    }
                }
            }
        });
    }
}
