package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.a.b.b;
import cn.sharesdk.framework.a.b.c;
import cn.sharesdk.framework.a.b.f;
import cn.sharesdk.framework.a.d;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.HashonHelper;
import java.util.HashMap;

public class e implements PlatformActionListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public PlatformActionListener f13427a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Platform, Platform.ShareParams> f13428b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private int f13429c;

    private void b(Platform platform, int i11, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2;
        Platform platform2;
        Platform.ShareParams remove = this.f13428b.remove(platform);
        if (hashMap != null) {
            remove = (Platform.ShareParams) hashMap.remove("ShareParams");
        }
        try {
            hashMap2 = (HashMap) hashMap.clone();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            hashMap2 = hashMap;
        }
        if (remove != null) {
            f fVar = new f();
            fVar.f13361n = remove.getCustomFlag();
            String userId = platform.getDb().getUserId();
            if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(userId)) {
                try {
                    platform2 = ShareSDK.getPlatform("Wechat");
                } catch (Throwable th3) {
                    SSDKLog.b().a(th3, "InnerPlatformActionListener wechat is null", new Object[0]);
                    platform2 = null;
                }
                if (platform2 != null) {
                    userId = platform2.getDb().getUserId();
                }
            } else if ("TencentWeibo".equals(platform.getName())) {
                userId = platform.getDb().get("name");
            }
            fVar.f13357b = userId;
            fVar.f13356a = platform.getPlatformId();
            String filterShareContent = platform.filterShareContent(remove);
            if (!TextUtils.isEmpty(filterShareContent)) {
                try {
                    fVar.f13359d = (f.a) HashonHelper.fromJson(filterShareContent, f.a.class);
                } catch (Throwable th4) {
                    SSDKLog.b().a(th4);
                }
            } else {
                f.a filterShareContent2 = platform.filterShareContent(remove, hashMap2);
                if (filterShareContent2 != null) {
                    fVar.f13358c = filterShareContent2.f13362a;
                    fVar.f13359d = filterShareContent2;
                }
            }
            fVar.f13360m = b(platform);
            d a11 = d.a();
            if (a11 != null) {
                a11.a((c) fVar);
            }
        }
        PlatformActionListener platformActionListener = this.f13427a;
        if (platformActionListener != null) {
            try {
                platformActionListener.onComplete(platform, i11, hashMap);
                this.f13427a = null;
                this.f13429c = 0;
            } catch (Throwable th5) {
                SSDKLog.b().a(th5);
            }
        }
    }

    public void onCancel(Platform platform, int i11) {
        PlatformActionListener platformActionListener = this.f13427a;
        if (platformActionListener != null) {
            platformActionListener.onCancel(platform, i11);
            this.f13427a = null;
            this.f13429c = 0;
        }
    }

    public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
        if (platform instanceof CustomPlatform) {
            PlatformActionListener platformActionListener = this.f13427a;
            if (platformActionListener != null) {
                platformActionListener.onComplete(platform, i11, hashMap);
                this.f13427a = null;
                this.f13429c = 0;
            }
        } else if (i11 == 1) {
            a(platform, i11, hashMap);
        } else if (i11 != 9) {
            PlatformActionListener platformActionListener2 = this.f13427a;
            if (platformActionListener2 != null) {
                platformActionListener2.onComplete(platform, i11, hashMap);
                if (!"Wechat".equals(platform.getName())) {
                    int i12 = this.f13429c;
                    if (i12 == 0 || i12 == i11) {
                        this.f13427a = null;
                        this.f13429c = 0;
                    }
                }
            }
        } else {
            b(platform, i11, hashMap);
        }
    }

    public void onError(Platform platform, int i11, Throwable th2) {
        PlatformActionListener platformActionListener = this.f13427a;
        if (platformActionListener != null) {
            platformActionListener.onError(platform, i11, th2);
            this.f13427a = null;
            this.f13429c = 0;
        }
    }

    public void a(PlatformActionListener platformActionListener) {
        this.f13427a = platformActionListener;
    }

    public PlatformActionListener a() {
        return this.f13427a;
    }

    public void a(Platform platform, Platform.ShareParams shareParams) {
        this.f13428b.put(platform, shareParams);
    }

    private void a(Platform platform, final int i11, final HashMap<String, Object> hashMap) {
        final PlatformActionListener platformActionListener = this.f13427a;
        this.f13427a = new PlatformActionListener() {
            public void onCancel(Platform platform, int i11) {
                PlatformActionListener unused = e.this.f13427a = platformActionListener;
                if (e.this.f13427a != null) {
                    e.this.f13427a.onComplete(platform, i11, hashMap);
                }
            }

            public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
                PlatformActionListener unused = e.this.f13427a = platformActionListener;
                if (e.this.f13427a != null) {
                    e.this.f13427a.onComplete(platform, i11, hashMap);
                }
                b bVar = new b();
                bVar.f13334a = platform.getPlatformId();
                bVar.f13335b = "TencentWeibo".equals(platform.getName()) ? platform.getDb().get("name") : platform.getDb().getUserId();
                bVar.f13336c = new Hashon().fromHashMap(hashMap);
                bVar.f13337d = e.this.a(platform);
                d a11 = d.a();
                if (a11 != null) {
                    a11.a((c) bVar);
                }
            }

            public void onError(Platform platform, int i11, Throwable th2) {
                SSDKLog.b().b(th2);
                PlatformActionListener unused = e.this.f13427a = platformActionListener;
                if (e.this.f13427a != null) {
                    e.this.f13427a.onComplete(platform, i11, hashMap);
                }
            }
        };
        platform.showUser((String) null);
    }

    public void a(Platform platform, final int i11, final Object obj) {
        this.f13429c = i11;
        final PlatformActionListener platformActionListener = this.f13427a;
        this.f13427a = new PlatformActionListener() {
            public void onCancel(Platform platform, int i11) {
                PlatformActionListener unused = e.this.f13427a = platformActionListener;
                if (e.this.f13427a != null) {
                    e.this.f13427a.onCancel(platform, i11);
                }
            }

            public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
                PlatformActionListener unused = e.this.f13427a = platformActionListener;
                platform.afterRegister(i11, obj);
            }

            public void onError(Platform platform, int i11, Throwable th2) {
                PlatformActionListener unused = e.this.f13427a = platformActionListener;
                if (e.this.f13427a != null) {
                    e.this.f13427a.onError(platform, i11, th2);
                }
            }
        };
        platform.doAuthorize((String[]) null);
    }

    /* access modifiers changed from: private */
    public String a(Platform platform) {
        try {
            try {
                return a(platform.getDb(), new String[]{"nickname", "icon", "gender", "snsUserUrl", "resume", "secretType", "secret", "birthday", "followerCount", "favouriteCount", "shareCount", "snsregat", "snsUserLevel", "educationJSONArrayStr", "workJSONArrayStr"});
            } catch (Throwable th2) {
                th = th2;
                SSDKLog.b().b(th);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            SSDKLog.b().b(th);
            return null;
        }
    }

    private String a(PlatformDb platformDb, String[] strArr) throws Throwable {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int i11 = 0;
        for (String str : strArr) {
            if (i11 > 0) {
                sb3.append('|');
                sb2.append('|');
            }
            i11++;
            String str2 = platformDb.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(str2);
                sb3.append(Data.urlEncode(str2, "utf-8"));
            }
        }
        SSDKLog.b().b("======UserData: " + sb2.toString());
        return sb3.toString();
    }

    private String b(Platform platform) {
        Platform platform2;
        PlatformDb db2 = platform.getDb();
        if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(db2.getUserGender())) {
            try {
                platform2 = ShareSDK.getPlatform("Wechat");
            } catch (Throwable th2) {
                SSDKLog.b().a(th2, "InnerPlatformActionListener getUserDataBrief catch ", new Object[0]);
                platform2 = null;
            }
            if (platform2 != null) {
                db2 = platform2.getDb();
            }
        }
        try {
            return a(db2, new String[]{"gender", "birthday", "secretType", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th3) {
            SSDKLog.b().b(th3);
            return null;
        }
    }
}
