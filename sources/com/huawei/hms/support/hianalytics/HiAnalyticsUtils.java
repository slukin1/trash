package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.HiAnalyticsOfCpUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AnalyticsSwitchHolder;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

public class HiAnalyticsUtils {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f38502c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f38503d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static HiAnalyticsUtils f38504e;

    /* renamed from: a  reason: collision with root package name */
    private int f38505a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38506b = HianalyticsExist.isHianalyticsExist();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f38507a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38508b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f38509c;

        public a(Context context, String str, Map map) {
            this.f38507a = context;
            this.f38508b = str;
            this.f38509c = map;
        }

        public void run() {
            HiAnalyticsUtils.getInstance().onEvent(this.f38507a, this.f38508b, this.f38509c);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f38511a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38512b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f38513c;

        public b(Context context, String str, String str2) {
            this.f38511a = context;
            this.f38512b = str;
            this.f38513c = str2;
        }

        public void run() {
            HiAnalyticsUtils.getInstance().onEvent2(this.f38511a, this.f38512b, this.f38513c);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f38515a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38516b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f38517c;

        public c(Context context, String str, Map map) {
            this.f38515a = context;
            this.f38516b = str;
            this.f38517c = map;
        }

        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f38515a, this.f38516b, this.f38517c);
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f38519a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38520b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f38521c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f38522d;

        public d(Context context, String str, Map map, int i11) {
            this.f38519a = context;
            this.f38520b = str;
            this.f38521c = map;
            this.f38522d = i11;
        }

        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f38519a, this.f38520b, this.f38521c, this.f38522d);
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f38524a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38525b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f38526c;

        public e(Context context, String str, Map map) {
            this.f38524a = context;
            this.f38525b = str;
            this.f38526c = map;
        }

        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f38524a, this.f38525b, this.f38526c);
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f38528a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38529b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f38530c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f38531d;

        public f(Context context, String str, Map map, int i11) {
            this.f38528a = context;
            this.f38529b = str;
            this.f38530c = map;
            this.f38531d = i11;
        }

        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f38528a, this.f38529b, this.f38530c, this.f38531d);
        }
    }

    private HiAnalyticsUtils() {
    }

    private static LinkedHashMap<String, String> a(Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    private void b(Context context) {
        synchronized (f38503d) {
            int i11 = this.f38505a;
            if (i11 < 60) {
                this.f38505a = i11 + 1;
            } else {
                this.f38505a = 0;
                if (!this.f38506b) {
                    HmsHiAnalyticsUtils.onReport();
                } else {
                    HiAnalyticsOfCpUtils.onReport(context, 0);
                    HiAnalyticsOfCpUtils.onReport(context, 1);
                }
            }
        }
    }

    private void c(Context context, String str, Map map) {
        try {
            com.huawei.hms.stats.a.c().a(new e(context.getApplicationContext(), str, map));
        } catch (Throwable th2) {
            HMSLog.e("HiAnalyticsUtils", "<addOnReportToCache> failed. " + th2.getMessage());
        }
    }

    public static HiAnalyticsUtils getInstance() {
        HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (f38502c) {
            if (f38504e == null) {
                f38504e = new HiAnalyticsUtils();
            }
            hiAnalyticsUtils = f38504e;
        }
        return hiAnalyticsUtils;
    }

    public static String versionCodeToName(String str) {
        if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                Integer.parseInt(str);
                return Integer.parseInt(str.substring(0, str.length() - 7)) + InstructionFileId.DOT + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + InstructionFileId.DOT + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + InstructionFileId.DOT + Integer.parseInt(str.substring(str.length() - 3));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    public void enableLog(Context context) {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (!this.f38506b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HiAnalyticTools.enableLog(context);
        }
    }

    public boolean getInitFlag() {
        if (!this.f38506b) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public int getOobeAnalyticsState(Context context) {
        if (context == null) {
            return 0;
        }
        int a11 = a(context);
        if (a11 == 1) {
            return a11;
        }
        Bundle bundle = new Bundle();
        bundle.putString("hms_cp_bundle_key", "content://com.huawei.hms.contentprovider" + "/" + "com.huawei.hms.privacy.HmsAnalyticsStateProvider");
        try {
            Bundle call = context.getApplicationContext().getContentResolver().call(Uri.parse("content://com.huawei.hms.contentprovider"), "getAnalyticsState", (String) null, bundle);
            if (call == null) {
                return a11;
            }
            int i11 = call.getInt("SWITCH_IS_CHECKED");
            HMSLog.i("HiAnalyticsUtils", "get hms analyticsOobe state " + i11);
            return i11;
        } catch (IllegalArgumentException unused) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState IllegalArgumentException ");
            return a11;
        } catch (SecurityException unused2) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState SecurityException ");
            return a11;
        } catch (Exception unused3) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState Exception ");
            return a11;
        }
    }

    public boolean hasError(Context context) {
        return AnalyticsSwitchHolder.isAnalyticsDisabled(context);
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        onEvent2(context, str, str2);
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onEvent> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            a(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (!this.f38506b) {
                HmsHiAnalyticsUtils.onEvent(0, str, a(map));
                HmsHiAnalyticsUtils.onEvent(1, str, a(map));
            } else {
                HiAnalyticsOfCpUtils.onEvent(context, 0, str, a(map));
                HiAnalyticsOfCpUtils.onEvent(context, 1, str, a(map));
            }
            b(context);
        }
    }

    public void onEvent2(Context context, String str, String str2) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onEvent2> context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (!initFlag && andRefreshAnalyticsState != 2 && a(str2)) {
            a(context, str, str2);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (!this.f38506b) {
                HmsHiAnalyticsUtils.onEvent(context, str, str2);
            } else {
                HiAnalyticsOfCpUtils.onEvent(context, str, str2);
            }
        }
    }

    public void onNewEvent(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onNewEvent> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            b(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (!this.f38506b) {
                HmsHiAnalyticsUtils.onEvent(0, str, a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onEvent(1, str, a((Map<String, String>) map));
            } else {
                HiAnalyticsOfCpUtils.onEvent(context, 0, str, a((Map<String, String>) map));
                HiAnalyticsOfCpUtils.onEvent(context, 1, str, a((Map<String, String>) map));
            }
            b(context);
        }
    }

    public void onReport(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onReport> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            c(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (!this.f38506b) {
                HmsHiAnalyticsUtils.onStreamEvent(0, str, a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onStreamEvent(1, str, a((Map<String, String>) map));
                return;
            }
            HiAnalyticsOfCpUtils.onStreamEvent(context, 0, str, a((Map<String, String>) map));
            HiAnalyticsOfCpUtils.onStreamEvent(context, 1, str, a((Map<String, String>) map));
        }
    }

    public void enableLog() {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (!this.f38506b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HMSLog.i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
        }
    }

    private int a(Context context) {
        int i11 = 0;
        try {
            i11 = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
            HMSLog.i("HiAnalyticsUtils", "getOobeStateForSettings value is " + i11);
            return i11;
        } catch (Settings.SettingNotFoundException e11) {
            HMSLog.i("HiAnalyticsUtils", "Settings.SettingNotFoundException " + e11.getMessage());
            return i11;
        }
    }

    private boolean a(boolean z11, boolean z12, Map<?, ?> map) {
        return !z11 && z12 && b(map);
    }

    private boolean b(Map<?, ?> map) {
        try {
            long j11 = 0;
            for (Object next : map.values()) {
                if (next instanceof String) {
                    j11 += (long) ((String) next).getBytes(Charset.forName("UTF-8")).length;
                }
            }
            if (j11 <= 512) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            HMSLog.e("HiAnalyticsUtils", "<isValidSize map> Exception: " + th2.getMessage());
            return false;
        }
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return str.getBytes(Charset.forName("UTF-8")).length <= 512;
        } catch (Throwable th2) {
            HMSLog.e("HiAnalyticsUtils", "<isValidSize String> Exception: " + th2.getMessage());
            return false;
        }
    }

    public void onReport(Context context, String str, Map map, int i11) {
        if (i11 == 0 || i11 == 1) {
            int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
            if (map == null || map.isEmpty() || context == null) {
                HMSLog.e("HiAnalyticsUtils", "<onReport with type> map or context is null, state: " + andRefreshAnalyticsState);
                return;
            }
            boolean initFlag = getInitFlag();
            if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                b(context, str, map, i11);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f38506b) {
                    HmsHiAnalyticsUtils.onStreamEvent(i11, str, a((Map<String, String>) map));
                } else {
                    HiAnalyticsOfCpUtils.onStreamEvent(context, i11, str, a((Map<String, String>) map));
                }
            }
        } else {
            HMSLog.e("HiAnalyticsUtils", "<onReport with type> Data reporting type is not supported");
        }
    }

    private void a(Context context, String str, Map<String, String> map) {
        try {
            com.huawei.hms.stats.a.c().a(new a(context.getApplicationContext(), str, map));
        } catch (Throwable th2) {
            HMSLog.e("HiAnalyticsUtils", "<addOnEventToCache> failed. " + th2.getMessage());
        }
    }

    public void onNewEvent(Context context, String str, Map map, int i11) {
        if (i11 == 0 || i11 == 1) {
            int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
            if (map == null || map.isEmpty() || context == null) {
                HMSLog.e("HiAnalyticsUtils", "<onNewEvent with type> map or context is null, state: " + andRefreshAnalyticsState);
                return;
            }
            boolean initFlag = getInitFlag();
            if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                a(context, str, map, i11);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f38506b) {
                    HmsHiAnalyticsUtils.onEvent(i11, str, a((Map<String, String>) map));
                } else {
                    HiAnalyticsOfCpUtils.onEvent(context, i11, str, a((Map<String, String>) map));
                }
                b(context);
                return;
            }
            return;
        }
        HMSLog.e("HiAnalyticsUtils", "<onNewEvent with type> Data reporting type is not supported");
    }

    private void b(Context context, String str, Map map) {
        try {
            com.huawei.hms.stats.a.c().a(new c(context.getApplicationContext(), str, map));
        } catch (Throwable th2) {
            HMSLog.e("HiAnalyticsUtils", "<addOnNewEventToCache> failed. " + th2.getMessage());
        }
    }

    private void a(Context context, String str, String str2) {
        try {
            com.huawei.hms.stats.a.c().a(new b(context.getApplicationContext(), str, str2));
        } catch (Throwable th2) {
            HMSLog.e("HiAnalyticsUtils", "<addOnEvent2ToCache> Failed. " + th2.getMessage());
        }
    }

    private void b(Context context, String str, Map map, int i11) {
        try {
            com.huawei.hms.stats.a.c().a(new f(context.getApplicationContext(), str, map, i11));
        } catch (Throwable th2) {
            HMSLog.e("HiAnalyticsUtils", "<addOnReportToCache with type> failed. " + th2.getMessage());
        }
    }

    private void a(Context context, String str, Map map, int i11) {
        try {
            com.huawei.hms.stats.a.c().a(new d(context.getApplicationContext(), str, map, i11));
        } catch (Throwable th2) {
            HMSLog.e("HiAnalyticsUtils", "<addOnNewEventToCache with type> failed. " + th2.getMessage());
        }
    }
}
