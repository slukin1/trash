package cn.sharesdk.framework;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.a.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.i;
import cn.sharesdk.framework.utils.k;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

public abstract class Platform {
    public static final int ACTION_AUTHORIZING = 1;
    public static final int ACTION_CUSTOMER = 655360;
    public static final int ACTION_FOLLOWING_USER = 6;
    public static final int ACTION_GETTING_BILATERAL_LIST = 10;
    public static final int ACTION_GETTING_FOLLOWER_LIST = 11;
    public static final int ACTION_GETTING_FRIEND_LIST = 2;
    public static final int ACTION_SENDING_DIRECT_MESSAGE = 5;
    public static final int ACTION_SHARE = 9;
    public static final int ACTION_TIMELINE = 7;
    public static final int ACTION_USER_INFOR = 8;
    public static final int CUSTOMER_ACTION_MASK = 65535;
    public static final int DY_MIXFILE = 23;
    public static final int GGP_REFUSE = 21;
    public static final int INSTAGRAM_FRIEND = 13;
    public static final int KAKAO_COMMERCE_TEMPLATE = 18;
    public static final int KAKAO_CUSTOM_TEMPLATE = 20;
    public static final int KAKAO_FEED_TEMPLATE = 16;
    public static final int KAKAO_TEXT_TEMPLATE = 19;
    public static final int KAKAO_URL_TEMPLATE = 17;
    public static final int OPEN_QQMINIPROGRAM = 22;
    public static final int OPEN_WXMINIPROGRAM = 12;
    public static final int QQ_MINI_PROGRAM = 15;
    public static final int SHARE_APPS = 7;
    public static final int SHARE_DYIM_IMG = 24;
    public static final int SHARE_DYIM_WEBPAGE = 25;
    public static final int SHARE_EMOJI = 9;
    public static final int SHARE_FILE = 8;
    public static final int SHARE_IMAGE = 2;
    public static final int SHARE_LINKCARD = 14;
    public static final int SHARE_MUSIC = 5;
    public static final int SHARE_TEXT = 1;
    public static final int SHARE_VIDEO = 6;
    public static final int SHARE_WEBPAGE = 4;
    public static final int SHARE_WXMINIPROGRAM = 11;
    public static final int SHARE_ZHIFUBAO = 10;

    /* renamed from: c  reason: collision with root package name */
    private static Platform f13198c;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public g f13199a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f13200b = new Object();

    /* renamed from: db  reason: collision with root package name */
    public final PlatformDb f13201db;
    public volatile boolean isClientValid;
    public PlatformActionListener listener;
    public String pkgName;
    public final PlatformActionListener uIListener;

    public static class ShareParams extends InnerShareParams {
        public ShareParams() {
        }

        public ShareParams(HashMap<String, Object> hashMap) {
            super(hashMap);
        }

        public ShareParams(String str) {
            super(str);
        }
    }

    public Platform() {
        g gVar = new g(this);
        this.f13199a = gVar;
        this.f13201db = gVar.g();
        this.listener = this.f13199a.i();
        this.uIListener = new PlatformActionListener() {
            public void onCancel(final Platform platform, final int i11) {
                if (Platform.this.listener != null) {
                    try {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Platform.this.listener.onCancel(platform, i11);
                        } else {
                            UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                                public boolean handleMessage(Message message) {
                                    Platform.this.listener.onCancel(platform, i11);
                                    return false;
                                }
                            });
                        }
                    } catch (Throwable th2) {
                        SSDKLog.b().a(th2);
                    }
                }
            }

            public void onComplete(final Platform platform, final int i11, final HashMap<String, Object> hashMap) {
                if (Platform.this.listener != null) {
                    try {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Platform.this.listener.onComplete(platform, i11, hashMap);
                        } else {
                            UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                                public boolean handleMessage(Message message) {
                                    Platform.this.listener.onComplete(platform, i11, hashMap);
                                    return false;
                                }
                            });
                        }
                    } catch (Throwable th2) {
                        SSDKLog.b().a(th2);
                    }
                }
            }

            public void onError(final Platform platform, final int i11, final Throwable th2) {
                if (Platform.this.listener != null) {
                    try {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Platform.this.listener.onError(platform, i11, th2);
                        } else {
                            UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                                public boolean handleMessage(Message message) {
                                    Platform.this.listener.onError(platform, i11, th2);
                                    return false;
                                }
                            });
                        }
                    } catch (Throwable th3) {
                        SSDKLog.b().a(th3);
                    }
                }
            }
        };
    }

    public static Platform getDefaultPlatform() {
        if (f13198c == null) {
            f13198c = new Platform() {

                /* renamed from: a  reason: collision with root package name */
                public final Throwable f13226a = new Throwable("Privacy policy is not accepted Use default platform");

                public boolean checkAuthorize(int i11, Object obj) {
                    return true;
                }

                public void doAuthorize(String[] strArr) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this, 1, this.f13226a);
                    }
                }

                public void doCustomerProtocol(String str, String str2, int i11, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
                }

                public void doShare(ShareParams shareParams) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this, 9, this.f13226a);
                    }
                }

                public HashMap<String, Object> filterFriendshipInfo(int i11, HashMap<String, Object> hashMap) {
                    return null;
                }

                public f.a filterShareContent(ShareParams shareParams, HashMap<String, Object> hashMap) {
                    return null;
                }

                public void follow(String str) {
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
                }

                public String getName() {
                    return "default";
                }

                public int getPlatformId() {
                    return -1;
                }

                public int getVersion() {
                    return -1;
                }

                public boolean hasShareCallback() {
                    return false;
                }

                public void initDevInfo(String str) {
                }

                public void setNetworkDevinfo() {
                }

                public void timeline(int i11, int i12, String str) {
                }

                public void userInfor(String str) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this, 8, this.f13226a);
                    }
                }
            };
        }
        return f13198c;
    }

    public void SSOSetting(boolean z11) {
        this.f13199a.a(z11);
    }

    public void afterRegister(int i11, Object obj) {
        this.f13199a.b(i11, obj);
    }

    public void authorize() {
        authorize((String[]) null);
    }

    public abstract boolean checkAuthorize(int i11, Object obj);

    public void copyDevinfo(String str, String str2) {
        ShareSDK.a(str, str2);
    }

    public void copyNetworkDevinfo(int i11, int i12) {
        ShareSDK.a(i11, i12);
    }

    public void customerProtocol(String str, String str2, short s11, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        this.f13199a.a(str, str2, s11, hashMap, hashMap2);
    }

    public abstract void doAuthorize(String[] strArr);

    public abstract void doCustomerProtocol(String str, String str2, int i11, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2);

    public abstract void doShare(ShareParams shareParams);

    public abstract HashMap<String, Object> filterFriendshipInfo(int i11, HashMap<String, Object> hashMap);

    public abstract f.a filterShareContent(ShareParams shareParams, HashMap<String, Object> hashMap);

    public String filterShareContent(ShareParams shareParams) {
        return null;
    }

    public abstract void follow(String str);

    public void followFriend(String str) {
        this.f13199a.b(str);
    }

    public abstract HashMap<String, Object> getBilaterals(int i11, int i12, String str);

    public PlatformDb getDb() {
        return this.f13201db;
    }

    public String getDevinfo(String str) {
        return getDevinfo(getName(), str);
    }

    public abstract HashMap<String, Object> getFollowers(int i11, int i12, String str);

    public abstract HashMap<String, Object> getFollowings(int i11, int i12, String str);

    public abstract void getFriendList(int i11, int i12, String str);

    public int getId() {
        return this.f13199a.a();
    }

    public abstract String getName();

    public String getNetworkDevinfo(String str, String str2) {
        return getNetworkDevinfo(getPlatformId(), str, str2);
    }

    public PlatformActionListener getPlatformActionListener() {
        return this.f13199a.c();
    }

    public abstract int getPlatformId();

    public void getShortLintk(String str, boolean z11, ShareSDKCallback<String> shareSDKCallback) {
        this.f13199a.a(str, z11, shareSDKCallback);
    }

    public int getSortId() {
        return this.f13199a.b();
    }

    public void getTimeLine(String str, int i11, int i12) {
        this.f13199a.a(str, i11, i12);
    }

    public abstract int getVersion();

    public abstract boolean hasShareCallback();

    public abstract void initDevInfo(String str);

    public void innerAuthorize(int i11, Object obj) {
        this.f13199a.a(i11, obj);
    }

    public boolean isAuthValid() {
        return this.f13199a.d();
    }

    @Deprecated
    public boolean isClientValid() {
        k.a(new k.a() {
            public void a() throws Throwable {
                Platform.this.isClientValid(new ShareSDKCallback<Boolean>() {
                    /* renamed from: a */
                    public void onCallback(Boolean bool) {
                        synchronized (Platform.this.f13200b) {
                            Platform.this.isClientValid = bool != null && bool.booleanValue();
                            Platform.this.f13200b.notifyAll();
                        }
                    }
                });
            }
        });
        synchronized (this.f13200b) {
            try {
                this.f13200b.wait(1000);
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
        }
        return this.isClientValid;
    }

    public boolean isSSODisable() {
        return this.f13199a.e();
    }

    public void listFriend(int i11, int i12, String str) {
        this.f13199a.a(i11, i12, str);
    }

    public void removeAccount(boolean z11) {
        this.f13199a.h();
        ShareSDK.removeCookieOnAuthorize(z11);
    }

    public abstract void setNetworkDevinfo();

    public void setPlatformActionListener(PlatformActionListener platformActionListener) {
        this.f13199a.a(platformActionListener);
    }

    public void share(final ShareParams shareParams) {
        i.a();
        isClientValid(new ShareSDKCallback<Boolean>() {
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Platform.this.isClientValid = bool.booleanValue();
                Platform.this.f13199a.b(shareParams);
            }
        });
    }

    public void showUser(final String str) {
        isClientValid(new ShareSDKCallback<Boolean>() {
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Platform.this.isClientValid = bool.booleanValue();
                Platform.this.f13199a.c(str);
            }
        });
    }

    public void subscribeAuth(final ShareParams shareParams) {
        isClientValid(new ShareSDKCallback<Boolean>() {
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Platform.this.isClientValid = bool.booleanValue();
                Platform.this.f13199a.a(shareParams);
            }
        });
    }

    public abstract void timeline(int i11, int i12, String str);

    public String uploadImageToFileServer(String str) {
        return this.f13199a.d(str);
    }

    public abstract void userInfor(String str);

    public void a() {
        this.f13199a.a(false);
        this.f13199a.a(getName());
    }

    public void authorize(final String[] strArr) {
        i.a();
        isClientValid(new ShareSDKCallback<Boolean>() {
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Platform.this.isClientValid = bool.booleanValue();
                Platform.this.f13199a.a(strArr);
            }
        });
    }

    public boolean b() {
        return this.f13199a.f();
    }

    public String getDevinfo(String str, String str2) {
        return ShareSDK.getDevinfo(str, str2);
    }

    public String getNetworkDevinfo(int i11, String str, String str2) {
        return this.f13199a.a(i11, str, str2);
    }

    public String getShortLintk(String str, boolean z11, HashMap<String, String> hashMap) {
        return this.f13199a.a(str, z11, hashMap);
    }

    public String uploadImageToFileServer(Bitmap bitmap) {
        return this.f13199a.a(bitmap);
    }

    public void isClientValid(final ShareSDKCallback<Boolean> shareSDKCallback) {
        if (shareSDKCallback != null) {
            try {
                if (TextUtils.isEmpty(this.pkgName)) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                } else {
                    DH.requester(MobSDK.getContext()).getPInfoForce(true, this.pkgName, 0).request(new DH.DHResponder() {
                        public void onResponse(DH.DHResponse dHResponse) {
                            try {
                                if (dHResponse.getPInfoForce(new int[0]) == null) {
                                    shareSDKCallback.onCallback(Boolean.valueOf(i.a(Platform.this.pkgName, 0) != null));
                                    return;
                                }
                                shareSDKCallback.onCallback(Boolean.TRUE);
                            } catch (Throwable th2) {
                                SSDKLog b11 = SSDKLog.b();
                                b11.a("isClientValid" + th2, new Object[0]);
                                shareSDKCallback.onCallback(Boolean.FALSE);
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }
}
