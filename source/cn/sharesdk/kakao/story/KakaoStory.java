package cn.sharesdk.kakao.story;

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

public class KakaoStory extends Platform {
    public static final String NAME = "KakaoStory";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f13540a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AuthorizeListener f13541b = new AuthorizeListener() {
        public void onCancel() {
            if (KakaoStory.this.listener != null) {
                KakaoStory.this.listener.onCancel(KakaoStory.this, 1);
            }
        }

        public void onComplete(Bundle bundle) {
            KakaoStory.this.a(bundle.getString("com.kakao.sdk.talk.redirectUrl"));
        }

        public void onError(Throwable th2) {
            if (KakaoStory.this.listener != null) {
                KakaoStory.this.listener.onError(KakaoStory.this, 1, th2);
            }
        }
    };

    public boolean checkAuthorize(int i11, Object obj) {
        if (i11 == 9) {
            if (this.isClientValid) {
                return true;
            }
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 9, new KakaoStoryClientNotExistException());
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
        final a a11 = a.a((Platform) this);
        a11.b(this.f13540a);
        if (!this.isClientValid || isSSODisable()) {
            a11.a(this.f13541b);
        } else {
            a11.a((PlatformActionListener) new PlatformActionListener() {
                public void onCancel(Platform platform, int i11) {
                    if (KakaoStory.this.listener != null) {
                        KakaoStory.this.listener.onCancel(platform, i11);
                    }
                }

                public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
                    String str = (String) hashMap.get("com.kakao.sdk.talk.redirectUrl");
                    if (str.equals("LoggedOut")) {
                        a11.a(KakaoStory.this.f13541b);
                    } else {
                        KakaoStory.this.a(str);
                    }
                }

                public void onError(Platform platform, int i11, Throwable th2) {
                    if (KakaoStory.this.listener != null) {
                        KakaoStory.this.listener.onError(platform, 1, th2);
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
                    a a11 = a.a((Platform) KakaoStory.this);
                    a11.b(KakaoStory.this.f13540a);
                    String text = shareParams.getText();
                    String site = shareParams.getSite();
                    String title = shareParams.getTitle();
                    String imageUrl = shareParams.getImageUrl();
                    String imagePath = shareParams.getImagePath();
                    String filePath = shareParams.getFilePath();
                    try {
                        AnonymousClass1 r82 = new PlatformActionListener() {
                            public void onCancel(Platform platform, int i11) {
                                if (KakaoStory.this.listener != null) {
                                    KakaoStory.this.listener.onCancel(platform, i11);
                                }
                            }

                            public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
                                HashMap hashMap2 = new HashMap();
                                if (hashMap != null) {
                                    hashMap2.putAll(hashMap);
                                }
                                hashMap2.put("ShareParams", shareParams);
                                if (KakaoStory.this.listener != null) {
                                    KakaoStory.this.listener.onComplete(platform, i11, hashMap2);
                                }
                            }

                            public void onError(Platform platform, int i11, Throwable th2) {
                                if (KakaoStory.this.listener != null) {
                                    KakaoStory.this.listener.onError(platform, i11, th2);
                                }
                            }
                        };
                        if (!TextUtils.isEmpty(text) && TextUtils.isEmpty(imagePath) && TextUtils.isEmpty(imageUrl) && TextUtils.isEmpty(filePath)) {
                            String shortLintk = KakaoStory.this.getShortLintk(text, false, (HashMap<String, String>) hashMap);
                            shareParams.setText(shortLintk);
                            a11.a(shortLintk, site, imageUrl, r82);
                        } else if (!TextUtils.isEmpty(imageUrl)) {
                            a11.a(text, site, imageUrl, r82);
                        } else if (!TextUtils.isEmpty(imagePath)) {
                            a11.a(2, imagePath, text, title, r82);
                        } else if (!TextUtils.isEmpty(filePath)) {
                            a11.a(6, filePath, text, title, r82);
                        } else if (KakaoStory.this.listener != null) {
                            KakaoStory.this.listener.onError(KakaoStory.this, 9, new Throwable("Missing parameters"));
                        }
                    } catch (Throwable th2) {
                        if (KakaoStory.this.listener != null) {
                            KakaoStory.this.listener.onError(KakaoStory.this, 9, th2);
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
        boolean z11;
        f.a aVar = new f.a();
        String text = shareParams.getText();
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        if (!TextUtils.isEmpty(text)) {
            aVar.f13363b = text;
            z11 = true;
        } else {
            if (!TextUtils.isEmpty(imagePath)) {
                aVar.f13366e.add(imagePath);
            } else if (!TextUtils.isEmpty(imageUrl)) {
                aVar.f13365d.add(imageUrl);
            }
            z11 = false;
        }
        if (z11) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(InnerShareParams.SITE, shareParams.getSite());
            hashMap2.put("title", shareParams.getTitle());
            hashMap2.put(InnerShareParams.COMMENT, shareParams.getComment());
            if (!TextUtils.isEmpty(imageUrl)) {
                aVar.f13365d.add(imageUrl);
            }
        }
        if (hashMap != null) {
            aVar.f13368g = hashMap;
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
        return 45;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return true;
    }

    public void initDevInfo(String str) {
        this.f13540a = getDevinfo("AppKey");
    }

    public void isClientValid(ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            a a11 = a.a((Platform) this);
            a11.b(this.f13540a);
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
        this.f13540a = getNetworkDevinfo("api_key", "AppKey");
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
        a a11 = a.a((Platform) this);
        a11.b(this.f13540a);
        String token = this.f13201db.getToken();
        HashMap<String, Object> a12 = a.a(token);
        HashMap<String, Object> a13 = a11.a(token);
        if ((a12 == null || a12.size() == 0) && (platformActionListener2 = this.listener) != null) {
            platformActionListener2.onError(this, 8, new Throwable("http error"));
        } else if (TextUtils.isEmpty((String) a12.get("error")) || (platformActionListener = this.listener) == null) {
            this.f13201db.putUserId(a12.get("id") + "");
            this.f13201db.put("nickname", (String) a13.get("nickName"));
            this.f13201db.put("icon", (String) ((HashMap) a12.get("properties")).get("profile_image"));
            this.f13201db.put("snsUserUrl", (String) a13.get("permalink"));
            a13.put("id", a12.get("id"));
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onComplete(this, 8, a13);
            }
        } else {
            platformActionListener.onError(this, 8, new Throwable((String) a12.get("error")));
        }
    }

    /* access modifiers changed from: private */
    public void a(final String str) {
        final a a11 = a.a((Platform) this);
        a11.b(this.f13540a);
        new Thread(new Runnable() {
            public void run() {
                a.a(str, a11.getRedirectUri(), KakaoStory.this.f13540a, KakaoStory.this, new ShareSDKCallback<HashMap<String, Object>>() {
                    /* renamed from: a */
                    public void onCallback(HashMap<String, Object> hashMap) {
                        if (hashMap != null) {
                            KakaoStory.this.f13201db.putToken((String) hashMap.get("access_token"));
                            PlatformDb l11 = KakaoStory.this.f13201db;
                            l11.putExpiresIn(Long.parseLong(hashMap.get(AccessToken.EXPIRES_IN_KEY) + ""));
                            KakaoStory.this.afterRegister(1, (Object) null);
                            return;
                        }
                        SSDKLog.b().a("token null", new Object[0]);
                    }
                });
            }
        }).start();
    }
}
