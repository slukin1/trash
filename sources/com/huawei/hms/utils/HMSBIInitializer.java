package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class HMSBIInitializer {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f38576d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static HMSBIInitializer f38577e;

    /* renamed from: f  reason: collision with root package name */
    private static HiAnalyticsInstance f38578f;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f38579a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f38580b = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f38581c;

    public class a implements IQueryUrlCallBack {
        public a() {
        }

        public void onCallBackFail(int i11) {
            HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + i11);
            HMSBIInitializer.this.f38580b.set(false);
            com.huawei.hms.stats.a.c().a();
        }

        public void onCallBackSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!HMSBIInitializer.this.f38581c) {
                    HmsHiAnalyticsUtils.init(HMSBIInitializer.this.f38579a, false, false, false, str, "com.huawei.hwid");
                } else {
                    HMSBIInitializer.this.a(str);
                }
                HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
            }
            HMSBIInitializer.this.f38580b.set(false);
            com.huawei.hms.stats.a.c().b();
        }
    }

    public class b extends AsyncTask<String, Integer, Void> {
        private b() {
        }

        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            HMSBIInitializer.this.b(strArr[0]);
            return null;
        }

        public /* synthetic */ b(HMSBIInitializer hMSBIInitializer, a aVar) {
            this();
        }
    }

    private HMSBIInitializer(Context context) {
        this.f38579a = context;
        this.f38581c = HianalyticsExist.isHianalyticsExist();
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (f38576d) {
            if (f38577e == null && context != null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    f38577e = new HMSBIInitializer(applicationContext);
                } else {
                    f38577e = new HMSBIInitializer(context);
                }
            }
        }
        return f38577e;
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f38578f;
    }

    public void initBI() {
        boolean z11;
        if (!this.f38581c) {
            z11 = HmsHiAnalyticsUtils.getInitFlag();
        } else {
            z11 = HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        }
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + z11);
        if (!z11 && !AnalyticsSwitchHolder.isAnalyticsDisabled(this.f38579a)) {
            HMSLog.i("HMSBIInitializer", "Builder->biInitFlag : start initHaSDK");
            initHaSDK();
        }
    }

    public void initHaSDK() {
        if (this.f38580b.compareAndSet(false, true)) {
            String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.f38579a);
            if (!TextUtils.isEmpty(issueCountryCode)) {
                issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
            }
            if (GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(issueCountryCode) || TextUtils.isEmpty(issueCountryCode)) {
                HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
                this.f38580b.set(false);
                return;
            }
            new b(this, (a) null).execute(new String[]{issueCountryCode});
        }
    }

    public boolean isInit() {
        if (!this.f38581c) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag(HiAnalyticsConstant.HA_SERVICE_TAG);
        f38578f = instanceByTag;
        if (instanceByTag != null) {
            instanceByTag.setAppid("com.huawei.hwid");
            return;
        }
        HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
        HiAnalyticsInstance create = new HiAnalyticsInstance.Builder(this.f38579a).setOperConf(build).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
        f38578f = create;
        if (create != null) {
            create.setAppid("com.huawei.hwid");
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        HMSLog.i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.f38579a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new a());
    }
}
