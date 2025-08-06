package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.huawei.secure.android.common.ssl.util.f;
import com.mob.MobSDK;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashMap;

public class PlatformDb {
    private static final String DB_NAME = "cn_sharesdk_weibodb";
    private String platformNname;
    private int platformVersion;

    /* renamed from: sp  reason: collision with root package name */
    private SharePrefrenceHelper f13227sp;

    public PlatformDb(String str, int i11) {
        SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
        this.f13227sp = sharePrefrenceHelper;
        sharePrefrenceHelper.open("cn_sharesdk_weibodb_" + str, i11);
        this.platformNname = str;
        this.platformVersion = i11;
    }

    public String exportData() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.f13227sp.getAll());
            return new Hashon().fromHashMap(hashMap);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return null;
        }
    }

    public String get(String str) {
        return this.f13227sp.getString(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:3|4|5|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return (long) r2.f13227sp.getInt("expiresIn");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getExpiresIn() {
        /*
            r2 = this;
            java.lang.String r0 = "expiresIn"
            com.mob.tools.utils.SharePrefrenceHelper r1 = r2.f13227sp     // Catch:{ all -> 0x0009 }
            long r0 = r1.getLong(r0)     // Catch:{ all -> 0x0009 }
            goto L_0x0013
        L_0x0009:
            com.mob.tools.utils.SharePrefrenceHelper r1 = r2.f13227sp     // Catch:{ all -> 0x0011 }
            int r0 = r1.getInt(r0)     // Catch:{ all -> 0x0011 }
            long r0 = (long) r0
            goto L_0x0013
        L_0x0011:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.PlatformDb.getExpiresIn():long");
    }

    public long getExpiresTime() {
        return this.f13227sp.getLong("expiresTime") + (getExpiresIn() * 1000);
    }

    public String getPlatformNname() {
        return this.platformNname;
    }

    public int getPlatformVersion() {
        return this.platformVersion;
    }

    public String getToken() {
        return this.f13227sp.getString("token");
    }

    public String getTokenSecret() {
        return this.f13227sp.getString("secret");
    }

    public String getUserGender() {
        String string = this.f13227sp.getString("gender");
        if ("0".equals(string)) {
            return "m";
        }
        if ("1".equals(string)) {
            return f.f38658a;
        }
        return null;
    }

    public String getUserIcon() {
        return this.f13227sp.getString("icon");
    }

    public String getUserId() {
        String string = this.f13227sp.getString("userID");
        return TextUtils.isEmpty(string) ? this.f13227sp.getString("weibo") : string;
    }

    public String getUserName() {
        return this.f13227sp.getString("nickname");
    }

    public void importData(String str) {
        try {
            HashMap fromJson = new Hashon().fromJson(str);
            if (fromJson != null) {
                this.f13227sp.putAll(fromJson);
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }

    public boolean isValid() {
        String token = getToken();
        if (token == null || token.length() <= 0) {
            return false;
        }
        if (getExpiresIn() == 0) {
            return true;
        }
        if (getExpiresTime() > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public void put(String str, String str2) {
        this.f13227sp.putString(str, str2);
    }

    public void putExpiresIn(long j11) {
        this.f13227sp.putLong("expiresIn", Long.valueOf(j11));
        this.f13227sp.putLong("expiresTime", Long.valueOf(System.currentTimeMillis()));
    }

    public void putToken(String str) {
        this.f13227sp.putString("token", str);
    }

    public void putTokenSecret(String str) {
        this.f13227sp.putString("secret", str);
    }

    public void putUserId(String str) {
        this.f13227sp.putString("userID", str);
    }

    public void removeAccount() {
        this.f13227sp.clear();
    }
}
