package cn.sharesdk.kakao.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.h;
import cn.sharesdk.framework.utils.i;
import com.facebook.internal.ServerProtocol;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import com.twitter.sdk.android.core.internal.oauth.OAuthConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;

public class a {
    public static void a(Context context, Intent intent, final int i11, final ShareSDKCallback<Boolean> shareSDKCallback) {
        final String str = i11 == 139 ? "com.kakao.talk" : "com.kakao.story";
        DH.requester(context).resolveActivity(intent, 0).getPInfoForce(true, str, 64).request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                ShareSDKCallback shareSDKCallback;
                try {
                    if (dHResponse.resolveActivity(new int[0]) == null) {
                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                        if (shareSDKCallback2 != null) {
                            shareSDKCallback2.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    PackageInfo pInfoForce = dHResponse.getPInfoForce(new int[0]);
                    if (pInfoForce == null) {
                        pInfoForce = i.a(str, 64);
                    }
                    if (pInfoForce == null) {
                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                        if (shareSDKCallback3 != null) {
                            shareSDKCallback3.onCallback(Boolean.FALSE);
                        }
                    } else if (pInfoForce.versionCode < i11) {
                        ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                        if (shareSDKCallback4 != null) {
                            shareSDKCallback4.onCallback(Boolean.FALSE);
                        }
                    } else {
                        for (Signature charsString : pInfoForce.signatures) {
                            String charsString2 = charsString.toCharsString();
                            if ((charsString2.equals("308201db30820144a00302010202044c707197300d06092a864886f70d01010505003031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d3020170d3130303832323030333834375a180f32313130303732393030333834375a3031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d30819f300d06092a864886f70d010101050003818d0030818902818100aef387bc86e022a87e66b8c42153284f18e0c468cf9c87a241b989729dfdad3dd9e1847546d01a2819ba77f3974a47b473c926acae173fd90c7e635000721feeef6705da7ae949a35b82900a0f67d9464d73ed8a98c37f4ac70729494a17469bc40d4ee06d043b09147ebadc55fa1020968d7036c5fb9b8c148cba1d8e9d9fc10203010001300d06092a864886f70d0101050500038181005569be704c68cff6221c1e04dd8a131110f9f5cd2138042286337fd6014a1b1d2d3eeb266ae1630afe56bf63c07dd0b5c8fad46dcb9f802f9a7802fb89eb3b4777b9665bb1ed9feaf1dc7cac4f91abedfc81187ff6d2f471dbd12335d2c0ef0e2ee719df6e763f814b9ac91f8be37fd11d40686700d66be6de22a1836f060f01") || charsString2.equals("308201e53082014ea00302010202044f4ae542300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3132303232373032303635385a170d3432303231393032303635385a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d0030818902818100c0b41c25ef21a39a13ce89c82dc3a14bf9ef0c3094aa2ac1bf755c9699535e79119e8b980c0ecdcc51f259eb0d8b2077d41de8fcfdeaac3f386c05e2a684ecb5504b660ad7d5a01cce35899f96bcbd099c9dcb274c6eb41fef861616a12fb45bc57a19683a8a97ab1a33d9c70128878b67dd1b3a388ad5121d1d66ff04c065ff0203010001300d06092a864886f70d0101050500038181000418a7dacb6d13eb61c8270fe1fdd006eb66d0ff9f58f475defd8dc1fb11c41e34ce924531d1fd8ad26d9479d64f54851bf57b8dfe3a5d6f0a01dcad5b8c36ac4ac48caeff37888c36483c26b09aaa9689dbb896938d5afe40135bf7d9f12643046301867165d28be0baa3513a5084e182f7f9c044d5baa58bdce55fa1845241")) && (shareSDKCallback = shareSDKCallback) != null) {
                                shareSDKCallback.onCallback(Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable unused) {
                    ShareSDKCallback shareSDKCallback5 = shareSDKCallback;
                    if (shareSDKCallback5 != null) {
                        shareSDKCallback5.onCallback(Boolean.FALSE);
                    }
                }
            }
        });
    }

    public static String a() {
        int i11 = Build.VERSION.SDK_INT;
        String upperCase = DH.SyncMtd.getModel().replaceAll("\\s", Constants.ACCEPT_TIME_SEPARATOR_SERVER).toUpperCase();
        String lowerCase = h.a().toLowerCase();
        String upperCase2 = h.b().toUpperCase();
        return "sdk/" + "1.0.46" + " " + "os/" + "android" + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i11 + " " + "lang/" + lowerCase + Constants.ACCEPT_TIME_SEPARATOR_SERVER + upperCase2 + " " + "device/" + upperCase;
    }

    public static void a(final ShareSDKCallback<String> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getPInfoForce(true, DH.SyncMtd.getPackageName(), 64).request(new DH.DHResponder() {
            /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0051 */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0055 A[Catch:{ NoSuchAlgorithmException -> 0x002e, all -> 0x0051, all -> 0x005b }] */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0058 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(com.mob.tools.utils.DH.DHResponse r12) {
                /*
                    r11 = this;
                    r0 = 0
                    r1 = 0
                    int[] r2 = new int[r1]     // Catch:{ all -> 0x005b }
                    android.content.pm.PackageInfo r12 = r12.getPInfoForce(r2)     // Catch:{ all -> 0x005b }
                    android.content.pm.Signature[] r12 = r12.signatures     // Catch:{ all -> 0x005b }
                    int r2 = r12.length     // Catch:{ all -> 0x005b }
                    r3 = r1
                L_0x000c:
                    if (r3 >= r2) goto L_0x0062
                    r4 = r12[r3]     // Catch:{ all -> 0x005b }
                    r5 = 2
                    java.lang.String r6 = "SHA"
                    java.security.MessageDigest r6 = java.security.MessageDigest.getInstance(r6)     // Catch:{ NoSuchAlgorithmException -> 0x002e }
                    byte[] r7 = r4.toByteArray()     // Catch:{ NoSuchAlgorithmException -> 0x002e }
                    r6.update(r7)     // Catch:{ NoSuchAlgorithmException -> 0x002e }
                    byte[] r6 = r6.digest()     // Catch:{ NoSuchAlgorithmException -> 0x002e }
                    java.lang.String r6 = android.util.Base64.encodeToString(r6, r5)     // Catch:{ NoSuchAlgorithmException -> 0x002e }
                    cn.sharesdk.framework.ShareSDKCallback r7 = r4     // Catch:{ NoSuchAlgorithmException -> 0x002e }
                    if (r7 == 0) goto L_0x0058
                    r7.onCallback(r6)     // Catch:{ NoSuchAlgorithmException -> 0x002e }
                    goto L_0x0058
                L_0x002e:
                    r6 = move-exception
                    cn.sharesdk.framework.utils.SSDKLog r7 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch:{ all -> 0x0051 }
                    java.lang.String r8 = "kakao"
                    java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0051 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
                    r9.<init>()     // Catch:{ all -> 0x0051 }
                    java.lang.String r10 = "Unable to get MessageDigest. signature="
                    r9.append(r10)     // Catch:{ all -> 0x0051 }
                    r9.append(r4)     // Catch:{ all -> 0x0051 }
                    java.lang.String r4 = r9.toString()     // Catch:{ all -> 0x0051 }
                    r5[r1] = r4     // Catch:{ all -> 0x0051 }
                    r4 = 1
                    r5[r4] = r6     // Catch:{ all -> 0x0051 }
                    r7.a(r8, r5)     // Catch:{ all -> 0x0051 }
                    goto L_0x0058
                L_0x0051:
                    cn.sharesdk.framework.ShareSDKCallback r4 = r4     // Catch:{ all -> 0x005b }
                    if (r4 == 0) goto L_0x0058
                    r4.onCallback(r0)     // Catch:{ all -> 0x005b }
                L_0x0058:
                    int r3 = r3 + 1
                    goto L_0x000c
                L_0x005b:
                    cn.sharesdk.framework.ShareSDKCallback r12 = r4
                    if (r12 == 0) goto L_0x0062
                    r12.onCallback(r0)
                L_0x0062:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.kakao.utils.a.AnonymousClass2.onResponse(com.mob.tools.utils.DH$DHResponse):void");
            }
        });
    }

    public static void a(String str, String str2, String str3, Platform platform, ShareSDKCallback<HashMap<String, Object>> shareSDKCallback) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Platform platform2 = platform;
        final ShareSDKCallback<HashMap<String, Object>> shareSDKCallback2 = shareSDKCallback;
        a((ShareSDKCallback<String>) new ShareSDKCallback<String>() {
            /* renamed from: a */
            public void onCallback(String str) {
                String queryParameter = Uri.parse(str4).getQueryParameter("code");
                if (TextUtils.isEmpty(queryParameter)) {
                    queryParameter = "";
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new KVPair(OAuthConstants.PARAM_GRANT_TYPE, "authorization_code"));
                arrayList.add(new KVPair("code", queryParameter));
                arrayList.add(new KVPair(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str5));
                arrayList.add(new KVPair("client_id", str6));
                arrayList.add(new KVPair(ServerProtocol.FALLBACK_DIALOG_PARAM_KEY_HASH, str));
                try {
                    HashMap fromJson = new Hashon().fromJson(SSDKNetworkHelper.getInstance().httpPost("https://kauth.kakao.com/oauth/token?", arrayList, "oauth/token", platform2.getId()));
                    ShareSDKCallback shareSDKCallback = shareSDKCallback2;
                    if (shareSDKCallback != null) {
                        shareSDKCallback.onCallback(fromJson);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                    ShareSDKCallback shareSDKCallback2 = shareSDKCallback2;
                    if (shareSDKCallback2 != null) {
                        shareSDKCallback2.onCallback(null);
                    }
                }
            }
        });
    }

    public static HashMap<String, Object> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new KVPair("KA", a()));
            arrayList2.add(new KVPair("Authorization", "Bearer " + str));
            return new Hashon().fromJson(SSDKNetworkHelper.getInstance().httpGet("https://kapi.kakao.com/v2/user/me?", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null));
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return (HashMap) new HashMap().put("error", th2.getMessage());
        }
    }
}
