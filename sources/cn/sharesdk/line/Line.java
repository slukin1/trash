package cn.sharesdk.line;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.f;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.AccessToken;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.HashMap;

public class Line extends Platform {
    public static final String NAME = "Line";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public c f13598a = c.a();

    /* renamed from: b  reason: collision with root package name */
    private String f13599b;

    /* renamed from: c  reason: collision with root package name */
    private String f13600c;

    /* renamed from: d  reason: collision with root package name */
    private String f13601d;

    /* renamed from: e  reason: collision with root package name */
    private b f13602e;

    public Line() {
        this.pkgName = "jp.naver.line.android";
        b bVar = new b(this);
        this.f13602e = bVar;
        this.f13598a.a(bVar);
    }

    public boolean checkAuthorize(int i11, Object obj) {
        if (!this.isClientValid && i11 == 9) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, i11, new LineClientNotExistException());
            }
            return false;
        } else if (i11 == 9) {
            return true;
        } else {
            if (!TextUtils.isEmpty(this.f13201db.getToken()) && !this.f13598a.c(this.f13201db.getToken())) {
                innerAuthorize(i11, obj);
                return false;
            } else if (isAuthValid() || c()) {
                this.f13598a.a(this.f13599b, this.f13600c);
                this.f13598a.a(this.f13601d);
                this.f13598a.d(this.f13201db.getToken());
                return true;
            } else {
                innerAuthorize(i11, obj);
                return false;
            }
        }
    }

    public void doAuthorize(String[] strArr) {
        this.f13598a.a(this.f13599b, this.f13600c);
        this.f13598a.a(this.f13601d);
        this.f13598a.a((AuthorizeListener) new AuthorizeListener() {
            public void onCancel() {
                if (Line.this.listener != null) {
                    Line.this.listener.onCancel(Line.this, 1);
                }
            }

            public void onComplete(Bundle bundle) {
                long j11;
                String string = bundle.getString("access_token");
                String string2 = bundle.getString("token_type");
                String string3 = bundle.getString("refresh_token");
                String string4 = bundle.getString(AccessToken.EXPIRES_IN_KEY);
                bundle.getString("scope");
                bundle.getString("id_token");
                Line.this.f13201db.putToken(string);
                Line.this.f13201db.put("token_type", string2);
                try {
                    j11 = ResHelper.parseLong(string4);
                } catch (Throwable unused) {
                    j11 = 0;
                }
                Line.this.f13201db.putExpiresIn(j11);
                Line.this.f13201db.put("refresh_token", string3);
                Line.this.f13598a.d(string);
                Line.this.afterRegister(1, (Object) null);
            }

            public void onError(Throwable th2) {
                if (Line.this.listener != null) {
                    Line.this.listener.onError(Line.this, 1, th2);
                }
            }
        }, isSSODisable(), this.isClientValid);
    }

    public void doCustomerProtocol(String str, String str2, int i11, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, i11);
        }
    }

    public void doShare(final Platform.ShareParams shareParams) {
        this.f13602e.a(shareParams, this.listener);
        String text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            try {
                getShortLintk(text, false, (ShareSDKCallback<String>) new ShareSDKCallback<String>() {
                    /* renamed from: a */
                    public void onCallback(String str) {
                        try {
                            shareParams.setText(str);
                            c.a().e(str);
                            if (Line.this.listener != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("ShareParams", shareParams);
                                Line.this.listener.onComplete(Line.this, 9, hashMap);
                            }
                        } catch (Throwable th2) {
                            if (Line.this.listener != null) {
                                Line.this.listener.onError(Line.this, 9, th2);
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
        } else {
            String imagePath = shareParams.getImagePath();
            if (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) {
                try {
                    String downloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), shareParams.getImageUrl());
                    if (TextUtils.isEmpty(downloadBitmap) || !new File(downloadBitmap).exists()) {
                        PlatformActionListener platformActionListener2 = this.listener;
                        if (platformActionListener2 != null) {
                            platformActionListener2.onError(this, 9, new Throwable("both text and image are null"));
                            return;
                        }
                        return;
                    }
                    try {
                        c.a().f(downloadBitmap);
                        if (this.listener != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("ShareParams", shareParams);
                            this.listener.onComplete(this, 9, hashMap);
                        }
                    } catch (Throwable th3) {
                        PlatformActionListener platformActionListener3 = this.listener;
                        if (platformActionListener3 != null) {
                            platformActionListener3.onError(this, 9, th3);
                        }
                    }
                } catch (Throwable th4) {
                    PlatformActionListener platformActionListener4 = this.listener;
                    if (platformActionListener4 != null) {
                        platformActionListener4.onError(this, 9, th4);
                    }
                }
            } else {
                try {
                    c.a().f(imagePath);
                    if (this.listener != null) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("ShareParams", shareParams);
                        this.listener.onComplete(this, 9, hashMap2);
                    }
                } catch (Throwable th5) {
                    PlatformActionListener platformActionListener5 = this.listener;
                    if (platformActionListener5 != null) {
                        platformActionListener5.onError(this, 9, th5);
                    }
                }
            }
        }
    }

    public HashMap<String, Object> filterFriendshipInfo(int i11, HashMap<String, Object> hashMap) {
        return null;
    }

    public f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        f.a aVar = new f.a();
        aVar.f13363b = shareParams.getText();
        String imageUrl = shareParams.getImageUrl();
        if (imageUrl != null) {
            aVar.f13365d.add(imageUrl);
        } else {
            String imagePath = shareParams.getImagePath();
            if (imagePath != null) {
                aVar.f13366e.add(imagePath);
            }
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
        return 42;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return false;
    }

    public void initDevInfo(String str) {
        this.f13599b = getDevinfo("ChannelID");
        this.f13600c = getDevinfo("ChannelSecret");
        this.f13601d = getDevinfo("RedirectUri");
    }

    public void setNetworkDevinfo() {
    }

    public void timeline(int i11, int i12, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
        }
    }

    public void userInfor(String str) {
        try {
            HashMap<String, Object> d11 = this.f13598a.d();
            if (d11 == null) {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 8, new Throwable());
                    return;
                }
                return;
            }
            this.f13201db.putUserId(String.valueOf(d11.get("userId")));
            this.f13201db.put("nickname", String.valueOf(d11.get("displayName")));
            this.f13201db.put("icon", String.valueOf(d11.get("pictureUrl")));
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onComplete(this, 8, d11);
            }
        } catch (Throwable th2) {
            SSDKLog.b().b(th2);
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 8, th2);
            }
        }
    }

    private boolean c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        this.f13598a.a(this.f13599b, this.f13600c);
        this.f13598a.a(this.f13601d);
        return this.f13598a.b(this.f13602e);
    }
}
