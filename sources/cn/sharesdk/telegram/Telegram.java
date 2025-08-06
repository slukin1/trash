package cn.sharesdk.telegram;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.f;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.telegram.a.a;
import com.facebook.internal.NativeProtocol;
import com.mob.MobSDK;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Telegram extends Platform {
    public static final String NAME = "Telegram";

    /* renamed from: a  reason: collision with root package name */
    private String f13728a;

    /* renamed from: b  reason: collision with root package name */
    private String f13729b;

    /* renamed from: c  reason: collision with root package name */
    private a f13730c;

    public static boolean isSpecialChar(String str) {
        Pattern compile = Pattern.compile(":");
        if (str != null) {
            return compile.matcher(str).find();
        }
        SSDKLog.b().a("Telegram isSpecialChar str is null", new Object[0]);
        return false;
    }

    public boolean checkAuthorize(int i11, Object obj) {
        if (!this.isClientValid) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, i11, new TelegramClientNotExistException());
            }
            return false;
        }
        if (isAuthValid()) {
            a a11 = a.a((Platform) this);
            a11.a(this.f13728a);
            a11.b(this.f13729b);
            String token = this.f13201db.getToken();
            String str = this.f13201db.get("stel_ssid");
            if (!(token == null || str == null)) {
                a11.c(token);
                a11.d(str);
                if (a11.a()) {
                    return true;
                }
            }
        }
        if (i11 == 9) {
            return true;
        }
        innerAuthorize(i11, obj);
        return false;
    }

    public void checkBotId(String str) {
        try {
            if (isSpecialChar(str)) {
                this.f13728a = str.substring(0, str.indexOf(58));
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }

    public void doAuthorize(String[] strArr) {
        a a11 = a.a((Platform) this);
        this.f13730c = a11;
        a11.a(this.f13728a);
        this.f13730c.b(this.f13729b);
        this.f13730c.a((AuthorizeListener) new AuthorizeListener() {
            public void onCancel() {
                if (Telegram.this.listener != null) {
                    Telegram.this.listener.onCancel(Telegram.this, 1);
                }
            }

            public void onComplete(Bundle bundle) {
                String string = bundle.getString("stel_ssid");
                String string2 = bundle.getString("stel_token");
                if (string != null) {
                    Telegram.this.f13201db.put("stel_ssid", string);
                }
                if (string2 != null) {
                    Telegram.this.f13201db.putToken(string2);
                }
                Telegram.this.afterRegister(1, (Object) null);
            }

            public void onError(Throwable th2) {
                if (Telegram.this.listener != null) {
                    Telegram.this.listener.onError(Telegram.this, 1, th2);
                }
            }
        });
    }

    public void doCustomerProtocol(String str, String str2, int i11, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, i11);
        }
    }

    public void doShare(final Platform.ShareParams shareParams) {
        AnonymousClass2 r02 = new ActionListener() {
            public void onComplete(HashMap<String, Object> hashMap) {
                hashMap.put("ShareParams", shareParams);
                if (Telegram.this.listener != null) {
                    Telegram.this.listener.onComplete(Telegram.this, 9, hashMap);
                }
            }

            public void onError(Throwable th2) {
                if (Telegram.this.listener != null) {
                    Telegram.this.listener.onError(Telegram.this, 9, th2);
                }
            }

            public void onStart(HashMap<String, Object> hashMap) {
                hashMap.put("ShareParams", shareParams);
                if (Telegram.this.listener != null) {
                    Telegram.this.listener.onComplete(Telegram.this, 9, hashMap);
                }
            }
        };
        TelegramActivity telegramActivity = new TelegramActivity();
        telegramActivity.setShareParams(shareParams);
        telegramActivity.setAuthListener(r02);
        telegramActivity.setPlatform(this);
        telegramActivity.show(MobSDK.getContext(), (Intent) null);
    }

    public HashMap<String, Object> filterFriendshipInfo(int i11, HashMap<String, Object> hashMap) {
        return null;
    }

    public f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        f.a aVar = new f.a();
        if (!TextUtils.isEmpty(shareParams.getText())) {
            aVar.f13363b = shareParams.getText();
        }
        if (shareParams.getImageData() != null) {
            aVar.f13367f.add(shareParams.getImageData());
        } else if (!TextUtils.isEmpty(shareParams.getImagePath())) {
            aVar.f13366e.add(shareParams.getImagePath());
        } else if (!TextUtils.isEmpty(shareParams.getImageUrl())) {
            aVar.f13365d.add(shareParams.getImageUrl());
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
        return 47;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return false;
    }

    public void initDevInfo(String str) {
        String devinfo = getDevinfo("AppKey");
        this.f13728a = devinfo;
        checkBotId(devinfo);
        this.f13729b = getDevinfo("RedirectUrl");
    }

    public void isClientValid(ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            a.a().a(shareSDKCallback);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    public void setNetworkDevinfo() {
        String networkDevinfo = getNetworkDevinfo("AppKey", "AppKey");
        this.f13728a = networkDevinfo;
        checkBotId(networkDevinfo);
        this.f13729b = getNetworkDevinfo("RedirectUrl", "RedirectUrl");
    }

    public void timeline(int i11, int i12, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
        }
    }

    public void userInfor(String str) {
        a a11 = a.a((Platform) this);
        this.f13730c = a11;
        try {
            HashMap<String, Object> e11 = a11.e(str);
            if (e11 != null) {
                if (e11.size() > 0) {
                    if (!e11.containsKey(NativeProtocol.BRIDGE_ARG_ERROR_CODE) && !e11.containsKey("error")) {
                        if (str == null) {
                            HashMap hashMap = (HashMap) e11.get("user");
                            if (hashMap != null) {
                                String str2 = (String) hashMap.get("hash");
                                String valueOf = String.valueOf(hashMap.get("id"));
                                String str3 = (String) hashMap.get("first_name");
                                String valueOf2 = String.valueOf(hashMap.get("auth_date"));
                                String str4 = (String) hashMap.get("last_name");
                                String str5 = str3 + str4;
                                if (str2 != null) {
                                    this.f13201db.put("hash", str2);
                                }
                                this.f13201db.putUserId(valueOf);
                                if (str3 != null) {
                                    this.f13201db.put("first_name", str3);
                                }
                                this.f13201db.put("auth_date", valueOf2);
                                if (str4 != null) {
                                    this.f13201db.put("last_name", str4);
                                }
                                if (str5 != null) {
                                    this.f13201db.put("nickName", str5);
                                }
                            }
                        }
                        if (this.listener == null) {
                            return;
                        }
                        if (e11.get("user") != null) {
                            this.listener.onComplete(this, 8, (HashMap) e11.get("user"));
                            return;
                        }
                        this.listener.onComplete(this, 8, e11);
                        return;
                    } else if (this.listener != null) {
                        this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(e11)));
                        return;
                    } else {
                        return;
                    }
                }
            }
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 8, new Throwable(" telegram response is null"));
            }
        } catch (Throwable th2) {
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 8, th2);
            }
        }
    }
}
