package com.tencent.tpns.baseapi.base.util;

import android.content.ContentValues;
import android.content.Context;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class CloudManager {
    public static final String KEY_CONFIG = "cloud";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Context f49792a;
    /* access modifiers changed from: private */
    public String A;
    /* access modifiers changed from: private */
    public int B;
    /* access modifiers changed from: private */
    public int C;
    /* access modifiers changed from: private */
    public int D;
    /* access modifiers changed from: private */
    public int E;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f49793b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f49794c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f49795d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f49796e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f49797f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f49798g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f49799h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public long f49800i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public long f49801j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f49802k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f49803l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f49804m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public int f49805n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f49806o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f49807p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public String f49808q;

    /* renamed from: r  reason: collision with root package name */
    private String f49809r;

    /* renamed from: s  reason: collision with root package name */
    private String f49810s;

    /* renamed from: t  reason: collision with root package name */
    private String f49811t;

    /* renamed from: u  reason: collision with root package name */
    private String f49812u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public int f49813v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public int f49814w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public int f49815x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public String f49816y;

    /* renamed from: z  reason: collision with root package name */
    private JSONArray f49817z;

    public static class CloudManagerHolder {
        public static CloudManager instance = new CloudManager();
    }

    public static CloudManager getInstance(Context context) {
        if (f49792a == null) {
            f49792a = context.getApplicationContext();
        }
        return CloudManagerHolder.instance;
    }

    public void clearGuid() {
        this.f49812u = null;
        this.f49808q = null;
        try {
            PushPreferences.remove(f49792a, "cloud_control_addrCfg");
        } catch (Throwable unused) {
            TBaseLogger.w("CloudManager", "unexpected for clearGuid");
        }
    }

    public boolean disableCollData() {
        return i() == 1;
    }

    public boolean disablePullMsg() {
        if (this.f49813v == -1) {
            this.f49813v = a(f49792a, "cloud_control_pullMsg", 0);
        }
        if (this.f49813v == 1) {
            return true;
        }
        return false;
    }

    public boolean disablePullUp() {
        return c() == 10 || h() == 1;
    }

    public boolean disableRepLanuEv() {
        if (this.f49807p == -1) {
            this.f49807p = a(f49792a, "cloud_control_repoLanuEv", 1);
        }
        if (this.f49807p == 1) {
            return true;
        }
        return false;
    }

    public boolean disableRepoCloudArrive() {
        if (this.D == -1) {
            this.D = a(f49792a, "cloud_control_repoCloudArrive", 1);
        }
        if (this.D == 1) {
            return true;
        }
        return false;
    }

    public boolean disableRepoCusEv() {
        if (this.E == -1) {
            this.E = a(f49792a, "cloud_control_repoCusEv", 2);
        }
        return this.E == 1;
    }

    public boolean disableReptErrCode() {
        int reptErrCode = getReptErrCode();
        if (reptErrCode == 1) {
            return true;
        }
        if (reptErrCode <= 0 || new Random().nextInt(100) >= reptErrCode) {
            return false;
        }
        return true;
    }

    public boolean disableReptLog() {
        if (this.f49814w == -1) {
            this.f49814w = a(f49792a, "cloud_control_reptLog", 0);
        }
        if (this.f49814w == 1) {
            return true;
        }
        return false;
    }

    public boolean disableShareBugly() {
        return j() == 1;
    }

    public int getAppClsAlive() {
        if (this.f49806o == -1) {
            this.f49806o = a(f49792a, "cloud_control_appClsAlive", 0);
        }
        return this.f49806o;
    }

    public String getCloud() {
        return this.f49793b;
    }

    public long getCloudVersion() {
        if (this.f49794c == -1) {
            this.f49794c = PushPreferences.getLong(f49792a, "cloud_control_version", 0);
        }
        return this.f49794c;
    }

    public int getCompressLevel() {
        if (this.f49815x == -1) {
            this.f49815x = a(f49792a, "cloud_control_compress", 0);
        }
        return this.f49815x;
    }

    public String getCustom() {
        if (!Util.isNullOrEmptyString(this.f49810s)) {
            return this.f49810s;
        }
        try {
            if (Util.isNullOrEmptyString(l())) {
                return this.f49810s;
            }
            this.f49810s = new JSONObject(l()).getString("custom");
            return this.f49810s;
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getCustom");
        }
    }

    public String getGuid() {
        if (!Util.isNullOrEmptyString(this.f49812u)) {
            return this.f49812u;
        }
        try {
            if (Util.isNullOrEmptyString(l())) {
                return this.f49812u;
            }
            this.f49812u = new JSONObject(l()).getString(TPDownloadProxyEnum.USER_GUID);
            return this.f49812u;
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getGuid");
        }
    }

    public int getInterval() {
        if (this.f49797f == -1) {
            this.f49797f = PushPreferences.getInt(f49792a, "cloud_control_interval", 0);
        }
        return this.f49797f;
    }

    public String getLog() {
        if (!Util.isNullOrEmptyString(this.f49811t)) {
            return this.f49811t;
        }
        try {
            if (Util.isNullOrEmptyString(l())) {
                return this.f49811t;
            }
            this.f49811t = new JSONObject(l()).getString("log");
            return this.f49811t;
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getLog");
        }
    }

    public JSONArray getPullupArrProviderAndActivity() {
        JSONArray jSONArray = this.f49817z;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
            if (Util.isNullOrEmptyString(k())) {
                return null;
            }
            this.f49817z = new JSONArray(this.f49816y);
            return this.f49817z;
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getPullupJSONArr");
        }
    }

    public String getPullupBlackList() {
        try {
            if (this.A == null) {
                this.A = PushPreferences.getString(f49792a, "cloud_control_conf_pull_black_list", "");
            }
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getPullupBlackList");
        }
        return "";
    }

    public int getRecons() {
        if (this.f49802k == -1) {
            this.f49802k = a(f49792a, "cloud_control_recons", 0);
        }
        return this.f49802k;
    }

    public int getReptErrCode() {
        if (this.f49803l == -1) {
            this.f49803l = a(f49792a, "cloud_control_reptErrCode", 1);
        }
        return this.f49803l;
    }

    public String getStat() {
        if (!Util.isNullOrEmptyString(this.f49809r)) {
            return this.f49809r;
        }
        try {
            if (Util.isNullOrEmptyString(l())) {
                return this.f49809r;
            }
            this.f49809r = new JSONObject(l()).getString("stat");
            return this.f49809r;
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getStat");
        }
    }

    public void parseCloudConfig(final String str, final long j11) {
        if (!Util.isNullOrEmptyString(str) && f49792a != null) {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    try {
                        TBaseLogger.d("CloudManager", "config: " + str);
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("reset")) {
                            ContentValues reset = CloudManager.this.reset();
                            if (reset != null) {
                                PushPreferences.putContentValues(CloudManager.f49792a, reset);
                                return;
                            }
                            return;
                        }
                        String unused = CloudManager.this.f49793b = str;
                        long unused2 = CloudManager.this.f49794c = jSONObject.optLong("cloudVersion", 0);
                        int unused3 = CloudManager.this.f49795d = jSONObject.optInt("keepAlive", 0);
                        int unused4 = CloudManager.this.f49796e = jSONObject.optInt("packetLoss", 0);
                        int unused5 = CloudManager.this.f49797f = jSONObject.optInt(MTPushConstants.Geofence.KEY_INTERVAL, 0);
                        int unused6 = CloudManager.this.f49798g = jSONObject.optInt("appAlive", 0);
                        int unused7 = CloudManager.this.f49799h = jSONObject.optInt("losePkt", 0);
                        long unused8 = CloudManager.this.f49800i = jSONObject.optLong("loseStart", 0) * 1000;
                        long unused9 = CloudManager.this.f49801j = jSONObject.optLong("loseEnd", 0) * 1000;
                        int unused10 = CloudManager.this.f49802k = jSONObject.optInt("recons", 0);
                        int unused11 = CloudManager.this.f49803l = jSONObject.optInt("reptErrCode", 0);
                        int unused12 = CloudManager.this.f49804m = jSONObject.optInt("collData", 0);
                        int unused13 = CloudManager.this.f49805n = jSONObject.optInt("shrBugly", 0);
                        int unused14 = CloudManager.this.f49806o = jSONObject.optInt("appClsAlive", 0);
                        int unused15 = CloudManager.this.f49807p = jSONObject.optInt("repoLanuEv", 0);
                        int unused16 = CloudManager.this.f49815x = jSONObject.optInt("compress", 0);
                        String unused17 = CloudManager.this.f49808q = jSONObject.optString("addrCfg", "");
                        int unused18 = CloudManager.this.f49813v = jSONObject.optInt("pullMsg", -1);
                        int unused19 = CloudManager.this.f49814w = jSONObject.optInt("reptLog", -1);
                        String unused20 = CloudManager.this.f49816y = jSONObject.optString("conf_pull_arr", "");
                        String unused21 = CloudManager.this.A = jSONObject.optString("conf_pull_black_list", "");
                        int unused22 = CloudManager.this.B = jSONObject.optInt("useHttpAccount", 0);
                        int unused23 = CloudManager.this.C = jSONObject.optInt("useTpnsChannel", 0);
                        int unused24 = CloudManager.this.D = jSONObject.optInt("repoCloudArrive", 1);
                        int unused25 = CloudManager.this.E = jSONObject.optInt("repoCusEv", 2);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("cloud_control_keepAlive", Integer.valueOf(CloudManager.this.f49795d));
                        contentValues.put("cloud_control_packetLoss", Integer.valueOf(CloudManager.this.f49796e));
                        contentValues.put("cloud_control_interval", Integer.valueOf(CloudManager.this.f49797f));
                        if (CloudManager.this.f49794c > 0) {
                            contentValues.put("cloud_control_version", Long.valueOf(CloudManager.this.f49794c));
                        }
                        contentValues.put("cloud_control_appAlive", Integer.valueOf(CloudManager.this.f49798g));
                        contentValues.put("cloud_control_losePkt", Integer.valueOf(CloudManager.this.f49799h));
                        contentValues.put("cloud_control_recons", Integer.valueOf(CloudManager.this.f49802k));
                        contentValues.put("cloud_control_reptErrCode", Integer.valueOf(CloudManager.this.f49803l));
                        contentValues.put("cloud_control_collData", Integer.valueOf(CloudManager.this.f49804m));
                        contentValues.put("cloud_control_shrBugly", Integer.valueOf(CloudManager.this.f49805n));
                        contentValues.put("cloud_control_appClsAlive", Integer.valueOf(CloudManager.this.f49806o));
                        contentValues.put("cloud_control_repoLanuEv", Integer.valueOf(CloudManager.this.f49807p));
                        contentValues.put("cloud_control_compress", Integer.valueOf(CloudManager.this.f49815x));
                        contentValues.put("cloud_control_pullMsg", Integer.valueOf(CloudManager.this.f49813v));
                        contentValues.put("cloud_control_reptLog", Integer.valueOf(CloudManager.this.f49814w));
                        contentValues.put("cloud_control_useHttpAccount", Integer.valueOf(CloudManager.this.B));
                        contentValues.put("cloud_control_useTpnsChannel", Integer.valueOf(CloudManager.this.C));
                        contentValues.put("cloud_control_repoCloudArrive", Integer.valueOf(CloudManager.this.D));
                        contentValues.put("cloud_control_repoCusEv", Integer.valueOf(CloudManager.this.E));
                        if (!Util.isNullOrEmptyString(CloudManager.this.f49808q)) {
                            contentValues.put("cloud_control_addrCfg", CloudManager.this.f49808q);
                        }
                        if (!Util.isNullOrEmptyString(CloudManager.this.f49816y)) {
                            contentValues.put("cloud_control_conf_pull_arr", CloudManager.this.f49816y);
                        }
                        if (!Util.isNullOrEmptyString(CloudManager.this.A)) {
                            contentValues.put("cloud_control_conf_pull_black_list", CloudManager.this.A);
                        }
                        PushPreferences.putContentValues(CloudManager.f49792a, contentValues);
                        StatHelper.reportCloudControl(CloudManager.f49792a, CloudManager.this.f49794c, 1, str, j11);
                    } catch (Throwable th2) {
                        TBaseLogger.w("CloudManager", "unexpected for config:" + str, th2);
                        StatHelper.reportCloudControl(CloudManager.f49792a, CloudManager.this.getCloudVersion(), 2, str, j11);
                    }
                }
            });
        }
    }

    public ContentValues reset() {
        this.f49793b = null;
        this.f49794c = -1;
        this.f49795d = -1;
        this.f49796e = -1;
        this.f49797f = -1;
        this.f49798g = -1;
        this.f49799h = -1;
        this.f49802k = -1;
        this.f49803l = -1;
        this.f49804m = -1;
        this.f49805n = -1;
        this.f49806o = -1;
        this.f49815x = -1;
        this.f49813v = -1;
        this.f49814w = -1;
        this.B = -1;
        this.f49808q = null;
        this.f49816y = null;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.putNull("cloud_control_keepAlive");
            contentValues.putNull("cloud_control_packetLoss");
            contentValues.putNull("cloud_control_version");
            contentValues.putNull("cloud_control_interval");
            contentValues.putNull("cloud_control_appAlive");
            contentValues.putNull("cloud_control_losePkt");
            contentValues.putNull("cloud_control_recons");
            contentValues.putNull("cloud_control_reptErrCode");
            contentValues.putNull("cloud_control_collData");
            contentValues.putNull("cloud_control_shrBugly");
            contentValues.putNull("cloud_control_appClsAlive");
            contentValues.putNull("cloud_control_repoLanuEv");
            contentValues.putNull("cloud_control_compress");
            contentValues.putNull("cloud_control_pullMsg");
            contentValues.putNull("cloud_control_reptLog");
            contentValues.putNull("cloud_control_addrCfg");
            contentValues.putNull("cloud_control_conf_pull_arr");
            contentValues.putNull("cloud_control_conf_pull_black_list");
            contentValues.putNull("cloud_control_useHttpAccount");
            contentValues.putNull("cloud_control_useTpnsChannel");
            contentValues.putNull("cloud_control_repoCloudArrive");
            contentValues.putNull("cloud_control_repoCusEv");
            return contentValues;
        } catch (Throwable th2) {
            TBaseLogger.w("CloudManager", "unexpected for reset", th2);
            return null;
        }
    }

    public boolean shouldRefuse() {
        if (!b()) {
            TBaseLogger.d("CloudManager", "shouldRefuse | isCloudRefuse : false");
            return false;
        }
        f();
        g();
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.f49801j;
        if (currentTimeMillis > j11 || currentTimeMillis < this.f49800i) {
            long j12 = this.f49800i;
            if (!(j12 == 0 && j11 == 0) && ((currentTimeMillis > j11 || j12 != 0) && (currentTimeMillis < j12 || j11 != 0))) {
                return false;
            }
        }
        TBaseLogger.d("CloudManager", "shouldRefuse | refuse ");
        return true;
    }

    public int useHttp() {
        if (this.B == -1) {
            this.B = a(f49792a, "cloud_control_useHttpAccount", 0);
        }
        return this.B;
    }

    public int useTpnsChannel() {
        if (this.C == -1) {
            this.C = a(f49792a, "cloud_control_useTpnsChannel", 0);
        }
        return this.C;
    }

    private CloudManager() {
        this.f49793b = null;
        this.f49794c = -1;
        this.f49795d = -1;
        this.f49796e = -1;
        this.f49797f = -1;
        this.f49798g = -1;
        this.f49799h = -1;
        this.f49800i = 0;
        this.f49801j = 0;
        this.f49802k = -1;
        this.f49803l = -1;
        this.f49804m = -1;
        this.f49805n = -1;
        this.f49806o = -1;
        this.f49807p = -1;
        this.f49808q = null;
        this.f49809r = null;
        this.f49810s = null;
        this.f49811t = null;
        this.f49812u = null;
        this.f49813v = -1;
        this.f49814w = -1;
        this.f49815x = -1;
        this.f49816y = null;
        this.f49817z = null;
        this.A = null;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
    }

    private int e() {
        if (this.f49799h == -1) {
            this.f49799h = a(f49792a, "cloud_control_losePkt", 0);
        }
        return this.f49799h;
    }

    private long f() {
        if (this.f49800i == 0) {
            this.f49800i = (long) a(f49792a, "cloud_control_loseStart", 0);
        }
        return this.f49800i;
    }

    private long g() {
        if (this.f49801j == 0) {
            this.f49801j = (long) a(f49792a, "cloud_control_loseStart", 0);
        }
        return this.f49801j;
    }

    private int h() {
        if (this.f49798g == -1) {
            this.f49798g = a(f49792a, "cloud_control_appAlive", 0);
        }
        return this.f49798g;
    }

    private int i() {
        if (this.f49804m == -1) {
            this.f49804m = a(f49792a, "cloud_control_collData", 0);
        }
        return this.f49804m;
    }

    private int j() {
        if (this.f49805n == -1) {
            this.f49805n = a(f49792a, "cloud_control_shrBugly", 0);
        }
        return this.f49805n;
    }

    private String k() {
        if (this.f49816y == null) {
            this.f49816y = PushPreferences.getString(f49792a, "cloud_control_conf_pull_arr", "");
        }
        return this.f49816y;
    }

    private String l() {
        if (this.f49808q == null) {
            this.f49808q = PushPreferences.getString(f49792a, "cloud_control_addrCfg", "");
        }
        return this.f49808q;
    }

    private int d() {
        if (this.f49796e == -1) {
            this.f49796e = a(f49792a, "cloud_control_packetLoss", 0);
        }
        return this.f49796e;
    }

    private boolean b() {
        if (d() == 20 || e() == 1) {
            return true;
        }
        int max = Math.max(d(), e());
        if (max <= 0 || new Random().nextInt(100) >= max) {
            return false;
        }
        return true;
    }

    private int c() {
        if (this.f49795d == -1) {
            this.f49795d = a(f49792a, "cloud_control_keepAlive", 0);
        }
        return this.f49795d;
    }

    private int a(Context context, String str, int i11) {
        if (context == null) {
            return i11;
        }
        try {
            return PushPreferences.getInt(context, str, i11);
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getCloudConfig:" + str);
            return i11;
        }
    }
}
