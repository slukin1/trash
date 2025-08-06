package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.utils.Util;

public class ForegroundIntentBuilder {

    /* renamed from: a  reason: collision with root package name */
    private Activity f37676a;

    /* renamed from: b  reason: collision with root package name */
    private RequestHeader f37677b;

    /* renamed from: c  reason: collision with root package name */
    private String f37678c;

    /* renamed from: d  reason: collision with root package name */
    private ForegroundInnerHeader f37679d;

    /* renamed from: e  reason: collision with root package name */
    private String f37680e;

    /* renamed from: f  reason: collision with root package name */
    private Context f37681f;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity != null) {
            this.f37676a = activity;
            RequestHeader requestHeader = new RequestHeader();
            this.f37677b = requestHeader;
            requestHeader.setSdkVersion(61100302);
            this.f37678c = "";
            ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
            this.f37679d = foregroundInnerHeader;
            foregroundInnerHeader.setApkVersion(30000000);
            return;
        }
        throw new IllegalArgumentException("listener must not be null.");
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(String str) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }

    public Intent build() {
        String str;
        String str2;
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.f37676a, ForegroundBusDelegate.class.getName());
        Context context = this.f37681f;
        if (context != null) {
            str2 = context.getPackageName();
            str = Util.getAppId(this.f37681f);
        } else {
            str2 = this.f37676a.getPackageName();
            str = Util.getAppId(this.f37676a);
        }
        if (this.f37677b.getAppID() == null) {
            RequestHeader requestHeader = this.f37677b;
            requestHeader.setAppID(str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        } else {
            RequestHeader requestHeader2 = this.f37677b;
            requestHeader2.setAppID(str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f37677b.getAppID());
        }
        if (TextUtils.isEmpty(this.f37677b.getTransactionId())) {
            RequestHeader requestHeader3 = this.f37677b;
            requestHeader3.setTransactionId(TransactionIdCreater.getId(requestHeader3.getAppID(), CoreNaming.HUBREQUEST));
        }
        this.f37677b.setPkgName(str2);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.f37677b.toJson());
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.f37678c);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.f37679d.toJson());
        if (!TextUtils.isEmpty(this.f37680e)) {
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.f37680e);
        }
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.f37677b.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int i11) {
        this.f37677b.setApiLevel(i11);
        return this;
    }

    public ForegroundIntentBuilder setApplicationContext(Context context) {
        this.f37681f = context;
        return this;
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.f37680e = this.f37676a.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i11) {
        this.f37677b.setKitSdkVersion(i11);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i11) {
        this.f37679d.setApkVersion(i11);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.f37678c = str;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.f37679d.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.f37677b.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.f37677b.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.f37677b.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.f37679d.setResponseCallbackKey(str);
        return this;
    }
}
