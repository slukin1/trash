package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public class ForegroundBusDelegate implements IBridgeActivityDelegate {
    public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    public static final String INNER_PKG_NAME = "INNER_PACKAGE_NAME";

    /* renamed from: a  reason: collision with root package name */
    private RequestHeader f37669a;

    /* renamed from: b  reason: collision with root package name */
    private String f37670b;

    /* renamed from: c  reason: collision with root package name */
    private ForegroundInnerHeader f37671c = new ForegroundInnerHeader();

    /* renamed from: d  reason: collision with root package name */
    private ResponseHeader f37672d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<Activity> f37673e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37674f;

    public class b implements AvailableAdapter.AvailableCallBack {
        private b() {
        }

        public void onComplete(int i11) {
            if (i11 == 0) {
                ForegroundBusDelegate.this.h();
                return;
            }
            HMSLog.i("ForegroundBusDelegate", "version check failed");
            ForegroundBusDelegate.this.a(0, "apk version is invalid");
        }
    }

    private BusResponseCallback b(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    private void c() {
        if (this.f37669a != null) {
            a(HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED);
        }
    }

    private void d() {
        a(HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY);
    }

    private void e() {
        if (g() == null) {
            HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
            a(0, "checkMinVersion failed, activity must not be null.");
        } else if (this.f37674f) {
            h();
        } else if (Util.isAvailableLibExist(g().getApplicationContext())) {
            b bVar = new b();
            AvailableAdapter availableAdapter = new AvailableAdapter(this.f37671c.getApkVersion());
            int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(g());
            if (isHuaweiMobileServicesAvailable == 0) {
                bVar.onComplete(isHuaweiMobileServicesAvailable);
            } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                a(g(), availableAdapter, (AvailableAdapter.AvailableCallBack) bVar);
            } else {
                bVar.onComplete(isHuaweiMobileServicesAvailable);
            }
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(g().getApplicationContext(), this.f37671c.getApkVersion()) != 0) {
            HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
            a(0, "apk version is invalid");
        } else {
            h();
        }
    }

    private void f() {
        Activity g11 = g();
        if (g11 != null && !g11.isFinishing()) {
            g11.finish();
        }
    }

    private Activity g() {
        WeakReference<Activity> weakReference = this.f37673e;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    /* access modifiers changed from: private */
    public void h() {
        String str;
        HMSLog.i("ForegroundBusDelegate", "startApkHubActivity");
        Activity g11 = g();
        if (g11 == null) {
            HMSLog.e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
            return;
        }
        if (this.f37674f) {
            str = g11.getPackageName();
        } else {
            str = HMSPackageManager.getInstance(g11.getApplicationContext()).getHMSPackageNameForMultiService();
        }
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("ForegroundBusDelegate", "hmsPackageName is null, Service is invalid.");
            a(0, "hmsPackageName is null, Service is invalid.");
            return;
        }
        Intent intent = new Intent(this.f37671c.getAction());
        intent.putExtra(HMS_FOREGROUND_REQ_BODY, this.f37670b);
        try {
            intent.setPackage(str);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("ForegroundBusDelegate", "IllegalArgumentException when startApkHubActivity intent.setPackage");
        }
        intent.putExtra(BridgeActivity.EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(g11));
        intent.setClassName(str, "com.huawei.hms.core.activity.UiJumpActivity");
        intent.putExtra(HMS_FOREGROUND_REQ_HEADER, this.f37669a.toJson());
        intent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
        try {
            b();
            g11.startActivityForResult(intent, 431057);
        } catch (ActivityNotFoundException e11) {
            HMSLog.e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", (Throwable) e11);
            a(0, "launch bus intent failed");
        }
    }

    public int getRequestCode() {
        return 431057;
    }

    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.e("ForegroundBusDelegate", "activity is null");
            a(0, "activity is null");
        } else if (activity.isFinishing()) {
            HMSLog.e("ForegroundBusDelegate", "activity is finishing");
            a(0, "activity is finishing");
        } else {
            this.f37673e = new WeakReference<>(activity);
            try {
                Intent intent = activity.getIntent();
                if (intent == null) {
                    a(0, "intent is invalid");
                    return;
                }
                String stringExtra = intent.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
                RequestHeader requestHeader = new RequestHeader();
                this.f37669a = requestHeader;
                if (!requestHeader.fromJson(stringExtra)) {
                    a(0, "header is invalid");
                    return;
                }
                this.f37670b = intent.getStringExtra(HMS_FOREGROUND_REQ_BODY);
                ForegroundInnerHeader foregroundInnerHeader = this.f37671c;
                if (foregroundInnerHeader == null) {
                    a(0, "inner header is invalid");
                    return;
                }
                foregroundInnerHeader.fromJson(intent.getStringExtra(HMS_FOREGROUND_REQ_INNER));
                if (TextUtils.isEmpty(this.f37669a.getApiName())) {
                    a(0, "action is invalid");
                    return;
                }
                a();
                if (!TextUtils.isEmpty(intent.getStringExtra(INNER_PKG_NAME))) {
                    HMSLog.i("ForegroundBusDelegate", "isUseInnerHms: true");
                    this.f37674f = true;
                }
                e();
            } catch (Throwable th2) {
                HMSLog.e("ForegroundBusDelegate", "ForegroundBusDelegate getStringExtra error:" + th2.getMessage());
                a(0, "ForegroundBusDelegate getStringExtra error:" + th2.getMessage());
            }
        }
    }

    public void onBridgeActivityDestroy() {
        c();
        this.f37673e = null;
    }

    public boolean onBridgeActivityResult(int i11, int i12, Intent intent) {
        String str;
        if (i11 != 431057) {
            return false;
        }
        if (intent != null && intent.hasExtra(HMS_FOREGROUND_RESP_HEADER)) {
            try {
                str = intent.getStringExtra(HMS_FOREGROUND_RESP_HEADER);
            } catch (Throwable unused) {
                HMSLog.w("ForegroundBusDelegate", "exception occur, HMS_FOREGROUND_RESP_HEADER get failed.");
                str = "";
            }
            ResponseHeader responseHeader = new ResponseHeader();
            this.f37672d = responseHeader;
            JsonUtil.jsonToEntity(str, responseHeader);
        }
        d();
        BusResponseCallback b11 = b(this.f37671c.getResponseCallbackKey());
        if (b11 == null) {
            a(i12, intent);
            return true;
        }
        BusResponseResult succeedReturn = b11.succeedReturn((Activity) this.f37673e.get(), i12, intent);
        if (succeedReturn == null) {
            a(i12, intent);
            return true;
        }
        a(succeedReturn.getCode(), succeedReturn.getIntent());
        return true;
    }

    public void onBridgeConfigurationChanged() {
    }

    public void onKeyUp(int i11, KeyEvent keyEvent) {
    }

    private void b() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f37669a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f37669a.getKitSdkVersion())));
        if (g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    private void a(int i11, Intent intent) {
        HMSLog.i("ForegroundBusDelegate", "succeedReturn");
        Activity g11 = g();
        if (g11 != null) {
            g11.setResult(i11, IntentUtil.modifyIntentBehaviorsSafe(intent));
            f();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, String str) {
        HMSLog.e("ForegroundBusDelegate", str);
        Activity g11 = g();
        if (g11 != null) {
            BusResponseCallback b11 = b(this.f37671c.getResponseCallbackKey());
            if (b11 != null) {
                BusResponseResult innerError = b11.innerError((Activity) this.f37673e.get(), i11, str);
                if (innerError == null) {
                    g11.setResult(0);
                } else {
                    g11.setResult(innerError.getCode(), IntentUtil.modifyIntentBehaviorsSafe(innerError.getIntent()));
                }
            } else {
                g11.setResult(0);
            }
            f();
        }
    }

    private static void a(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null) {
            HMSLog.i("ForegroundBusDelegate", "null activity, could not start resolution intent");
        }
        availableAdapter.startResolution(activity, availableCallBack);
    }

    private void a() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f37669a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f37669a.getKitSdkVersion())));
        if (g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
        }
    }

    private void a(String str) {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f37669a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f37669a.getKitSdkVersion())));
        ResponseHeader responseHeader = this.f37672d;
        if (responseHeader != null) {
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader.getStatusCode()));
            mapFromForegroundRequestHeader.put("result", String.valueOf(this.f37672d.getErrorCode()));
        }
        if (g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), str, mapFromForegroundRequestHeader);
        }
    }
}
