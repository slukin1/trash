package cn.sharesdk.kakao.talk;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.f;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.kakao.utils.a;
import com.facebook.AccessToken;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import java.util.HashMap;

public class KakaoTalk extends Platform {
    public static final String NAME = "KakaoTalk";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f13561a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f13562b;

    public boolean checkAuthorize(int i11, Object obj) {
        if (i11 == 9) {
            if (this.isClientValid) {
                return true;
            }
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 9, new KakaoTalkClientNotExistException());
            }
            return false;
        } else if (isAuthValid()) {
            return true;
        } else {
            innerAuthorize(i11, obj);
            return false;
        }
    }

    public void doAuthorize(String[] strArr) {
        a a11 = a.a((Platform) this);
        a11.a(this.f13561a);
        if (!this.isClientValid || isSSODisable()) {
            c();
        } else {
            a11.a((PlatformActionListener) new PlatformActionListener() {
                public void onCancel(Platform platform, int i11) {
                    if (KakaoTalk.this.listener != null) {
                        KakaoTalk.this.listener.onCancel(platform, i11);
                    }
                }

                public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
                    String str = (String) hashMap.get("com.kakao.sdk.talk.redirectUrl");
                    if (str.equals("LoggedOut")) {
                        KakaoTalk.this.c();
                    } else {
                        KakaoTalk.this.a(str);
                    }
                }

                public void onError(Platform platform, int i11, Throwable th2) {
                    if (KakaoTalk.this.listener != null) {
                        KakaoTalk.this.listener.onError(platform, i11, th2);
                    }
                }
            });
        }
    }

    public void doCustomerProtocol(String str, String str2, int i11, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, i11);
        }
    }

    public void doShare(final Platform.ShareParams shareParams) {
        try {
            DH.requester(MobSDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().getScreenSize().getCarrier().getNetworkType().request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("dk", dHResponse.getDeviceKey());
                    hashMap.put("nt", dHResponse.getNetworkType());
                    hashMap.put("dnwktfs", dHResponse.getDetailNetworkTypeForStatic());
                    hashMap.put("srs", dHResponse.getScreenSize());
                    hashMap.put("car", dHResponse.getCarrier());
                    a a11 = a.a((Platform) KakaoTalk.this);
                    a11.a(KakaoTalk.this.f13561a);
                    String shortLintk = KakaoTalk.this.getShortLintk(shareParams.getText(), false, (HashMap<String, String>) hashMap);
                    shareParams.setText(shortLintk);
                    String url = shareParams.getUrl();
                    String site = shareParams.getSite();
                    String imagePath = shareParams.getImagePath();
                    String[] imageArray = shareParams.getImageArray();
                    String title = shareParams.getTitle();
                    String imageUrl = shareParams.getImageUrl();
                    String kakaoWebUrl = shareParams.getKakaoWebUrl();
                    String kakaoMobileweburl = shareParams.getKakaoMobileweburl();
                    String text = shareParams.getText();
                    String kakaoAddbuttonTitle = shareParams.getKakaoAddbuttonTitle();
                    String filePath = shareParams.getFilePath();
                    try {
                        AnonymousClass1 r52 = new PlatformActionListener() {
                            public void onCancel(Platform platform, int i11) {
                                if (KakaoTalk.this.listener != null) {
                                    KakaoTalk.this.listener.onCancel(platform, i11);
                                }
                            }

                            public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
                                HashMap hashMap2 = new HashMap();
                                if (hashMap != null) {
                                    hashMap2.putAll(hashMap);
                                }
                                hashMap2.put("ShareParams", shareParams);
                                if (KakaoTalk.this.listener != null) {
                                    KakaoTalk.this.listener.onComplete(platform, i11, hashMap2);
                                }
                            }

                            public void onError(Platform platform, int i11, Throwable th2) {
                                if (KakaoTalk.this.listener != null) {
                                    KakaoTalk.this.listener.onError(platform, i11, th2);
                                }
                            }
                        };
                        if (KakaoTalk.this.f13562b) {
                            a11.a(shortLintk, imageUrl, url, imagePath, site, imageArray, filePath, r52);
                            return;
                        }
                        c cVar = new c(KakaoTalk.this, r52);
                        switch (shareParams.getShareType()) {
                            case 16:
                                cVar.a(title, imageUrl, kakaoWebUrl, kakaoMobileweburl, text, shareParams.getKakaoLikecount(), shareParams.getKakaoCommentcount(), shareParams.getKakaoSharecount(), kakaoAddbuttonTitle, shareParams.getKakaoAddbuttonWeburl(), shareParams.getKakaoAddbuttonMobileweburl());
                                return;
                            case 17:
                                cVar.a(url);
                                return;
                            case 18:
                                cVar.a(title, imageUrl, kakaoWebUrl, kakaoMobileweburl, text, shareParams.getKakaoRegularprice(), shareParams.getKakaoTemplateProductname(), shareParams.getKakaoDiscountprice(), shareParams.getKakaoDiscountrate());
                                return;
                            case 19:
                                cVar.a(shortLintk, kakaoWebUrl, kakaoMobileweburl, kakaoAddbuttonTitle);
                                return;
                            case 20:
                                cVar.a(shareParams.getKakaoCustomTemplateId(), shareParams.getKakaoCustomTemplate());
                                return;
                            default:
                                if (KakaoTalk.this.listener != null) {
                                    KakaoTalk.this.listener.onError(KakaoTalk.this, 9, new Throwable("With SDK share, Please set ShareType"));
                                    return;
                                }
                                return;
                        }
                    } catch (Throwable th2) {
                        if (KakaoTalk.this.listener != null) {
                            KakaoTalk.this.listener.onError(KakaoTalk.this, 9, th2);
                        }
                    }
                }
            });
        } catch (Throwable th2) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 9, th2);
            }
        }
    }

    public HashMap<String, Object> filterFriendshipInfo(int i11, HashMap<String, Object> hashMap) {
        return null;
    }

    public f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        f.a aVar = new f.a();
        if (!TextUtils.isEmpty(shareParams.getText())) {
            aVar.f13363b = shareParams.getText();
        }
        if (!TextUtils.isEmpty(shareParams.getUrl())) {
            aVar.f13364c.add(shareParams.getUrl());
        }
        if (!TextUtils.isEmpty(shareParams.getImageUrl())) {
            aVar.f13365d.add(shareParams.getImageUrl());
        }
        if (!TextUtils.isEmpty(shareParams.getSite())) {
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put(InnerShareParams.SITE, shareParams.getSite());
            aVar.f13368g = hashMap2;
        }
        return aVar;
    }

    public void follow(String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 6);
        }
    }

    public HashMap<String, Object> getBilaterals(int i11, int i12, String str) {
        return null;
    }

    public HashMap<String, Object> getFollowers(int i11, int i12, String str) {
        return null;
    }

    public HashMap<String, Object> getFollowings(int i11, int i12, String str) {
        return null;
    }

    public void getFriendList(int i11, int i12, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 2);
        }
    }

    public String getName() {
        return NAME;
    }

    public int getPlatformId() {
        return 44;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return true;
    }

    public void initDevInfo(String str) {
        this.f13561a = getDevinfo("AppKey");
        this.f13562b = "true".equals(getDevinfo("BypassApproval"));
    }

    public void isClientValid(ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            a a11 = a.a((Platform) this);
            a11.a(this.f13561a);
            a11.a(shareSDKCallback);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    public void removeAccount(boolean z11) {
        if (z11 && isAuthValid()) {
            super.removeAccount(z11);
        }
    }

    public void setNetworkDevinfo() {
        this.f13561a = getNetworkDevinfo("api_key", "AppKey");
    }

    public void timeline(int i11, int i12, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
        }
    }

    public void userInfor(String str) {
        PlatformActionListener platformActionListener;
        PlatformActionListener platformActionListener2;
        a.a((Platform) this).a(this.f13561a);
        HashMap<String, Object> a11 = a.a(this.f13201db.getToken());
        if ((a11 == null || a11.size() == 0) && (platformActionListener2 = this.listener) != null) {
            platformActionListener2.onError(this, 8, new Throwable("http error"));
        } else if (TextUtils.isEmpty((String) a11.get("error")) || (platformActionListener = this.listener) == null) {
            HashMap hashMap = (HashMap) a11.get("properties");
            this.f13201db.putUserId(a11.get("id") + "");
            this.f13201db.put("nickname", (String) hashMap.get("nickname"));
            this.f13201db.put("icon", (String) hashMap.get("profile_image"));
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onComplete(this, 8, a11);
            }
        } else {
            platformActionListener.onError(this, 8, new Throwable((String) a11.get("error")));
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        a a11 = a.a((Platform) this);
        a11.a(this.f13561a);
        a11.a((AuthorizeListener) new AuthorizeListener() {
            public void onCancel() {
                if (KakaoTalk.this.listener != null) {
                    KakaoTalk.this.listener.onCancel(KakaoTalk.this, 1);
                }
            }

            public void onComplete(Bundle bundle) {
                KakaoTalk.this.a(bundle.getString("com.kakao.sdk.talk.redirectUrl"));
            }

            public void onError(Throwable th2) {
                if (KakaoTalk.this.listener != null) {
                    KakaoTalk.this.listener.onError(KakaoTalk.this, 1, th2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final String str) {
        final a a11 = a.a((Platform) this);
        a11.a(this.f13561a);
        new Thread(new Runnable() {
            public void run() {
                a.a(str, a11.getRedirectUri(), KakaoTalk.this.f13561a, KakaoTalk.this, new ShareSDKCallback<HashMap<String, Object>>() {
                    /* renamed from: a */
                    public void onCallback(HashMap<String, Object> hashMap) {
                        if (hashMap != null) {
                            KakaoTalk.this.f13201db.putToken((String) hashMap.get("access_token"));
                            PlatformDb l11 = KakaoTalk.this.f13201db;
                            l11.putExpiresIn(Long.parseLong(hashMap.get(AccessToken.EXPIRES_IN_KEY) + ""));
                            KakaoTalk.this.afterRegister(1, (Object) null);
                            return;
                        }
                        SSDKLog.b().a("token null", new Object[0]);
                    }
                });
            }
        }).start();
    }
}
