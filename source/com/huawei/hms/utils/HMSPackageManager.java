package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Pair;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HMSPackageManager {

    /* renamed from: o  reason: collision with root package name */
    private static HMSPackageManager f38584o;

    /* renamed from: p  reason: collision with root package name */
    private static final Object f38585p = new Object();

    /* renamed from: q  reason: collision with root package name */
    private static final Object f38586q = new Object();

    /* renamed from: r  reason: collision with root package name */
    private static final Object f38587r = new Object();
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final Map<String, String> f38588s;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f38589a;

    /* renamed from: b  reason: collision with root package name */
    private final PackageManagerHelper f38590b;

    /* renamed from: c  reason: collision with root package name */
    private String f38591c;

    /* renamed from: d  reason: collision with root package name */
    private String f38592d;

    /* renamed from: e  reason: collision with root package name */
    private int f38593e;

    /* renamed from: f  reason: collision with root package name */
    private String f38594f;

    /* renamed from: g  reason: collision with root package name */
    private String f38595g;

    /* renamed from: h  reason: collision with root package name */
    private String f38596h;

    /* renamed from: i  reason: collision with root package name */
    private String f38597i;

    /* renamed from: j  reason: collision with root package name */
    private int f38598j;

    /* renamed from: k  reason: collision with root package name */
    private int f38599k;

    /* renamed from: l  reason: collision with root package name */
    private long f38600l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f38601m;

    /* renamed from: n  reason: collision with root package name */
    private int f38602n;

    public static class PackagePriorityInfo implements Comparable<PackagePriorityInfo> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f38603a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f38604b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f38605c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f38606d;

        /* renamed from: e  reason: collision with root package name */
        private String f38607e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Long f38608f;

        public PackagePriorityInfo(String str, String str2, String str3, String str4, String str5, long j11) {
            this.f38603a = str;
            this.f38604b = str2;
            this.f38605c = str3;
            this.f38606d = str4;
            this.f38607e = str5;
            this.f38608f = Long.valueOf(j11);
        }

        public int compareTo(PackagePriorityInfo packagePriorityInfo) {
            if (TextUtils.equals(this.f38607e, packagePriorityInfo.f38607e)) {
                return this.f38608f.compareTo(packagePriorityInfo.f38608f);
            }
            return this.f38607e.compareTo(packagePriorityInfo.f38607e);
        }
    }

    public class a implements Comparator<ResolveInfo> {
        public a() {
        }

        /* renamed from: a */
        public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            String str2 = resolveInfo2.serviceInfo.applicationInfo.packageName;
            if (HMSPackageManager.f38588s.containsKey(str) && HMSPackageManager.f38588s.containsKey(str2)) {
                return str.compareTo(str2);
            }
            if (HMSPackageManager.f38588s.containsKey(str)) {
                return -1;
            }
            return HMSPackageManager.f38588s.containsKey(str2) ? 1 : 0;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            try {
                List<ResolveInfo> queryIntentServices = HMSPackageManager.this.f38589a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
                if (queryIntentServices != null && queryIntentServices.size() != 0) {
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        if ("com.huawei.hwid".equals(resolveInfo.serviceInfo.applicationInfo.packageName)) {
                            int unused = HMSPackageManager.this.d();
                        }
                    }
                    HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
                }
            } catch (Exception e11) {
                HMSLog.e("HMSPackageManager", "asyncOnceCheckMDMState query hms action failed. " + e11.getMessage());
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f38588s = hashMap;
        hashMap.put("com.huawei.hwid", "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05");
        hashMap.put("com.huawei.hwid.tv", "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C");
    }

    private HMSPackageManager(Context context) {
        this.f38589a = context;
        this.f38590b = new PackageManagerHelper(context);
    }

    private boolean c(String str, String str2) {
        return Objects.equals(str2, this.f38590b.getPackageSigningCertificate(str)) || Objects.equals(str2, this.f38590b.getPackageSignature(str));
    }

    private Pair<String, String> d(String str, String str2) {
        if (!f38588s.containsKey(str) || !PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(str2)) {
            return null;
        }
        this.f38602n = 3;
        return new Pair<>(str, str2);
    }

    private void e(String str) {
        if (SystemUtils.isHuawei() || SystemUtils.isSystemApp(this.f38589a, str) || Build.VERSION.SDK_INT < 28 || b(str)) {
            AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        }
    }

    private void f() {
        synchronized (f38586q) {
            this.f38591c = null;
            this.f38592d = null;
            this.f38593e = 0;
        }
    }

    private Pair<String, String> g() {
        try {
            List<ResolveInfo> queryIntentServices = this.f38589a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
            if (queryIntentServices == null || queryIntentServices.size() == 0) {
                HMSLog.e("HMSPackageManager", "query hms action, resolveInfoList is null or empty.");
                return null;
            }
            a(queryIntentServices);
            for (ResolveInfo next : queryIntentServices) {
                String str = next.serviceInfo.applicationInfo.packageName;
                String packageSigningCertificate = this.f38590b.getPackageSigningCertificate(str);
                String packageSignature = this.f38590b.getPackageSignature(str);
                Pair<String, String> d11 = d(str, packageSigningCertificate);
                if (d11 != null) {
                    HMSLog.i("HMSPackageManager", "signature V3 check success");
                    return d11;
                }
                Pair<String, String> a11 = a(next.serviceInfo.metaData, str, packageSigningCertificate, packageSignature);
                if (a11 != null) {
                    HMSLog.i("HMSPackageManager", "DSS signature check success");
                    return a11;
                }
                Pair<String, String> a12 = a(str, packageSignature);
                if (a12 != null) {
                    HMSLog.i("HMSPackageManager", "signature V2 check success");
                    return a12;
                }
            }
            return null;
        } catch (Exception e11) {
            HMSLog.e("HMSPackageManager", "getHmsPackageName query hms action failed. " + e11.getMessage());
            return null;
        }
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (f38585p) {
            if (f38584o == null && context != null) {
                if (context.getApplicationContext() != null) {
                    f38584o = new HMSPackageManager(context.getApplicationContext());
                } else {
                    f38584o = new HMSPackageManager(context);
                }
                f38584o.k();
                f38584o.b();
            }
        }
        return f38584o;
    }

    private Pair<String, String> h() {
        Pair<String, String> g11 = g();
        if (g11 != null) {
            HMSLog.i("HMSPackageManager", "aidlService pkgName: " + ((String) g11.first));
            this.f38596h = "com.huawei.hms.core.aidlservice";
            this.f38597i = null;
            return g11;
        }
        ArrayList<PackagePriorityInfo> i11 = i();
        if (i11 == null) {
            HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        Iterator<PackagePriorityInfo> it2 = i11.iterator();
        while (it2.hasNext()) {
            PackagePriorityInfo next = it2.next();
            String a11 = next.f38603a;
            String b11 = next.f38604b;
            String c11 = next.f38605c;
            String d11 = next.f38606d;
            String packageSignature = this.f38590b.getPackageSignature(a11);
            if (a(a11 + ContainerUtils.FIELD_DELIMITER + packageSignature + ContainerUtils.FIELD_DELIMITER + b11, c11, d11)) {
                HMSLog.i("HMSPackageManager", "result: " + a11 + ", " + b11 + ", " + next.f38608f);
                this.f38596h = PackageConstants.GENERAL_SERVICES_ACTION;
                d(b11);
                return new Pair<>(a11, packageSignature);
            }
        }
        return null;
    }

    private ArrayList<PackagePriorityInfo> i() {
        try {
            List<ResolveInfo> queryIntentServices = this.f38589a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                HMSLog.e("HMSPackageManager", "query aglite action, resolveInfoList is null or empty");
                return null;
            }
            ArrayList<PackagePriorityInfo> arrayList = new ArrayList<>();
            for (ResolveInfo next : queryIntentServices) {
                String str = next.serviceInfo.applicationInfo.packageName;
                long packageFirstInstallTime = this.f38590b.getPackageFirstInstallTime(str);
                Bundle bundle = next.serviceInfo.metaData;
                if (bundle == null) {
                    HMSLog.e("HMSPackageManager", "package " + str + " get metaData is null");
                } else {
                    String a11 = a(bundle, "hms_app_checker_config");
                    String a12 = a(a11);
                    if (TextUtils.isEmpty(a12)) {
                        HMSLog.i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + a11);
                    } else {
                        String a13 = a(bundle, "hms_app_signer_v2");
                        if (TextUtils.isEmpty(a13)) {
                            HMSLog.i("HMSPackageManager", "get signerV2 fail.");
                        } else {
                            String a14 = a(bundle, "hms_app_cert_chain");
                            if (TextUtils.isEmpty(a14)) {
                                HMSLog.i("HMSPackageManager", "get certChain fail.");
                            } else {
                                HMSLog.i("HMSPackageManager", "add: " + str + ", " + a11 + ", " + packageFirstInstallTime);
                                arrayList.add(new PackagePriorityInfo(str, a11, a13, a14, a12, packageFirstInstallTime));
                            }
                        }
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        } catch (Exception e11) {
            HMSLog.e("HMSPackageManager", "query aglite action failed. " + e11.getMessage());
            return null;
        }
    }

    private void j() {
        synchronized (f38586q) {
            Pair<String, String> g11 = g();
            if (g11 == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                f();
                return;
            }
            String str = (String) g11.first;
            this.f38591c = str;
            this.f38592d = (String) g11.second;
            this.f38593e = this.f38590b.getPackageVersionCode(str);
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.f38591c + " version: " + this.f38593e);
        }
    }

    private void k() {
        synchronized (f38586q) {
            Pair<String, String> h11 = h();
            if (h11 == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                e();
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                return;
            }
            this.f38594f = (String) h11.first;
            this.f38595g = (String) h11.second;
            this.f38598j = this.f38590b.getPackageVersionCode(getHMSPackageNameForMultiService());
            e(this.f38594f);
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f38594f + " version: " + this.f38598j);
        }
    }

    private boolean l() {
        Bundle bundle;
        PackageManager packageManager = this.f38589a.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
            if (TextUtils.isEmpty(this.f38596h) || (!this.f38596h.equals(PackageConstants.GENERAL_SERVICES_ACTION) && !this.f38596h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
                    HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
                    return false;
                }
                return true;
            }
            HMSLog.i("HMSPackageManager", "action = " + this.f38596h + " exist");
            return false;
        } catch (AndroidException unused) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e11) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", (Throwable) e11);
        }
    }

    public String getHMSFingerprint() {
        String str = this.f38592d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.f38591c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f38590b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                j();
            }
            String str2 = this.f38591c;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f38594f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f38590b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                k();
            }
            String str2 = this.f38594f;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (f38585p) {
            refresh();
            PackageManagerHelper.PackageStates packageStates = this.f38590b.getPackageStates(this.f38591c);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                f();
                return packageStates2;
            }
            boolean z11 = false;
            if ("com.huawei.hwid".equals(this.f38591c) && d() == 1) {
                PackageManagerHelper.PackageStates packageStates3 = PackageManagerHelper.PackageStates.SPOOF;
                return packageStates3;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !c(this.f38591c, this.f38592d)) {
                z11 = true;
            }
            if (z11) {
                return packageStates2;
            }
            return packageStates;
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (f38585p) {
            refreshForMultiService();
            PackageManagerHelper.PackageStates packageStates = this.f38590b.getPackageStates(this.f38594f);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                e();
                return packageStates2;
            }
            boolean z11 = false;
            if ("com.huawei.hwid".equals(this.f38594f) && d() == 1) {
                PackageManagerHelper.PackageStates packageStates3 = PackageManagerHelper.PackageStates.SPOOF;
                return packageStates3;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !c(this.f38594f, this.f38595g)) {
                z11 = true;
            }
            if (z11) {
                return packageStates2;
            }
            return packageStates;
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.f38590b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.f38590b.getPackageVersionCode(getHMSPackageName());
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public String getServiceAction() {
        return !TextUtils.isEmpty(this.f38596h) ? this.f38596h : "com.huawei.hms.core.aidlservice";
    }

    public boolean hmsVerHigherThan(int i11) {
        if (this.f38593e >= i11 || !l()) {
            return true;
        }
        int packageVersionCode = this.f38590b.getPackageVersionCode(getHMSPackageName());
        this.f38593e = packageVersionCode;
        if (packageVersionCode >= i11) {
            return true;
        }
        return false;
    }

    public boolean isApkNeedUpdate(int i11) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i11);
        return hmsVersionCode < i11;
    }

    public boolean isApkUpdateNecessary(int i11) {
        if (isUpdateHmsForThirdPartyDevice()) {
            return true;
        }
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i11);
        if (!l() || hmsVersionCode >= i11) {
            return false;
        }
        return true;
    }

    public boolean isUpdateHmsForThirdPartyDevice() {
        return "com.huawei.hwid".equals(this.f38594f) && AgHmsUpdateState.getInstance().isUpdateHms();
    }

    public boolean isUseOldCertificate() {
        return this.f38601m;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f38591c) || TextUtils.isEmpty(this.f38592d)) {
            j();
        }
        c(this.f38591c);
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f38594f) || TextUtils.isEmpty(this.f38595g)) {
            k();
        }
        c(this.f38594f);
    }

    public void resetMultiServiceState() {
        e();
    }

    public void setUseOldCertificate(boolean z11) {
        this.f38601m = z11;
    }

    private boolean b(String str) {
        return !"com.huawei.hwid".equals(str) || this.f38602n == 3;
    }

    private void a(List<ResolveInfo> list) {
        if (list.size() > 1) {
            Collections.sort(list, new a());
        }
    }

    private boolean b(String str, String str2) {
        Map<String, String> map = f38588s;
        return map.containsKey(str) && map.get(str).equalsIgnoreCase(str2);
    }

    private void c(String str) {
        if ("com.huawei.hwid".equals(str) && AgHmsUpdateState.getInstance().isUpdateHms() && this.f38590b.getPackageVersionCode(str) >= AgHmsUpdateState.getInstance().getTargetVersionCode()) {
            AgHmsUpdateState.getInstance().resetUpdateState();
            HMSLog.i("HMSPackageManager", "refresh update state for HMS V3");
        }
    }

    private Pair<String, String> a(Bundle bundle, String str, String str2, String str3) {
        String str4;
        if (bundle == null) {
            HMSLog.e("HMSPackageManager", "DSS check: " + str + " for metadata is null");
            return null;
        }
        this.f38602n = 2;
        if (a(bundle, str, str2)) {
            HMSLog.i("HMSPackageManager", "support DSS V3 check");
            str3 = str2;
            str4 = "hms_app_signer_v3";
        } else {
            str4 = "hms_app_signer";
        }
        if (!bundle.containsKey(str4)) {
            HMSLog.e("HMSPackageManager", "skip package " + str + " for no " + str4);
            return null;
        } else if (!bundle.containsKey("hms_app_cert_chain")) {
            HMSLog.e("HMSPackageManager", "skip package " + str + " for no cert chain");
            return null;
        } else {
            if (!a(str + ContainerUtils.FIELD_DELIMITER + str3, bundle.getString(str4), bundle.getString("hms_app_cert_chain"))) {
                HMSLog.e("HMSPackageManager", "checkSigner failed");
                return null;
            }
            if (str4.equals("hms_app_signer_v3")) {
                this.f38602n = 3;
            }
            return new Pair<>(str, str3);
        }
    }

    private void b() {
        new Thread(new b(), "Thread-asyncOnceCheckMDMState").start();
    }

    private void d(String str) {
        String a11 = a(str);
        if (!TextUtils.isEmpty(a11)) {
            this.f38597i = a11.substring(9);
        }
    }

    private void e() {
        synchronized (f38586q) {
            this.f38594f = null;
            this.f38595g = null;
            this.f38596h = null;
            this.f38597i = null;
            this.f38598j = 0;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int d() {
        /*
            r6 = this;
            java.lang.Object r0 = f38587r
            monitor-enter(r0)
            java.lang.String r1 = "HMSPackageManager"
            java.lang.String r2 = "enter checkHmsIsSpoof"
            com.huawei.hms.support.log.HMSLog.i(r1, r2)     // Catch:{ all -> 0x0077 }
            com.huawei.hms.utils.PackageManagerHelper r1 = r6.f38590b     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "com.huawei.hwid"
            long r1 = r1.getPackageFirstInstallTime(r2)     // Catch:{ all -> 0x0077 }
            int r3 = r6.f38599k     // Catch:{ all -> 0x0077 }
            r4 = 3
            r5 = 1
            if (r3 == r4) goto L_0x0021
            long r3 = r6.f38600l     // Catch:{ all -> 0x0077 }
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r1 = 0
            goto L_0x0022
        L_0x0021:
            r1 = r5
        L_0x0022:
            if (r1 != 0) goto L_0x0044
            java.lang.String r1 = "HMSPackageManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r2.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "quit checkHmsIsSpoof cached state: "
            r2.append(r3)     // Catch:{ all -> 0x0077 }
            int r3 = r6.f38599k     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = a((int) r3)     // Catch:{ all -> 0x0077 }
            r2.append(r3)     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0077 }
            com.huawei.hms.support.log.HMSLog.i(r1, r2)     // Catch:{ all -> 0x0077 }
            int r1 = r6.f38599k     // Catch:{ all -> 0x0077 }
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            return r1
        L_0x0044:
            boolean r1 = r6.c()     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x004b
            r5 = 2
        L_0x004b:
            r6.f38599k = r5     // Catch:{ all -> 0x0077 }
            com.huawei.hms.utils.PackageManagerHelper r1 = r6.f38590b     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "com.huawei.hwid"
            long r1 = r1.getPackageFirstInstallTime(r2)     // Catch:{ all -> 0x0077 }
            r6.f38600l = r1     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = "HMSPackageManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r2.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "quit checkHmsIsSpoof state: "
            r2.append(r3)     // Catch:{ all -> 0x0077 }
            int r3 = r6.f38599k     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = a((int) r3)     // Catch:{ all -> 0x0077 }
            r2.append(r3)     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0077 }
            com.huawei.hms.support.log.HMSLog.i(r1, r2)     // Catch:{ all -> 0x0077 }
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            int r0 = r6.f38599k
            return r0
        L_0x0077:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.HMSPackageManager.d():int");
    }

    private boolean c() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.f38589a);
        if (hmsPath == null) {
            HMSLog.i("HMSPackageManager", "hmsPath is null!");
            return false;
        } else if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        } else if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.i("HMSPackageManager", "checkSignature fail!");
            return false;
        } else if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        } else {
            HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
            return false;
        }
    }

    private Pair<String, String> a(String str, String str2) {
        if (b(str, str2)) {
            return new Pair<>(str, str2);
        }
        HMSLog.w("HMSPackageManager", "check sign fail: " + str + "_" + str2);
        return null;
    }

    private boolean a(Bundle bundle, String str, String str2) {
        return bundle.containsKey("hms_app_signer_v3") && !b(str, str2) && Build.VERSION.SDK_INT >= 28;
    }

    private String a(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return bundle.getString(str);
        }
        HMSLog.e("HMSPackageManager", "no " + str + " in metaData");
        return null;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("priority=");
        if (indexOf == -1) {
            HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int indexOf2 = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2);
    }

    private boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            HMSLog.e("HMSPackageManager", "args is invalid");
            return false;
        }
        List<X509Certificate> b11 = com.huawei.hms.device.a.b(str3);
        if (b11.size() == 0) {
            HMSLog.e("HMSPackageManager", "certChain is empty");
            return false;
        } else if (!com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.f38589a), b11)) {
            HMSLog.e("HMSPackageManager", "failed to verify cert chain");
            return false;
        } else {
            X509Certificate x509Certificate = b11.get(b11.size() - 1);
            if (!com.huawei.hms.device.a.a(x509Certificate, "Huawei CBG HMS")) {
                HMSLog.e("HMSPackageManager", "CN is invalid");
                return false;
            } else if (!com.huawei.hms.device.a.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                HMSLog.e("HMSPackageManager", "OU is invalid");
                return false;
            } else if (com.huawei.hms.device.a.a(x509Certificate, str, str2)) {
                return true;
            } else {
                HMSLog.e("HMSPackageManager", "signature is invalid: " + str);
                return false;
            }
        }
    }

    private static String a(int i11) {
        if (i11 == 1) {
            return "SPOOFED";
        }
        if (i11 == 2) {
            return "SUCCESS";
        }
        if (i11 == 3) {
            return "UNCHECKED";
        }
        HMSLog.e("HMSPackageManager", "invalid checkMDM state: " + i11);
        return "";
    }
}
