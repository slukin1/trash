package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.DateUtil;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.tencent.android.tpush.common.MessageKey;
import org.json.JSONObject;

public class k {

    /* renamed from: c  reason: collision with root package name */
    public static volatile k f64965c;

    /* renamed from: a  reason: collision with root package name */
    public long f64966a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f64967b = 0;

    public static k a() {
        if (f64965c == null) {
            synchronized (k.class) {
                f64965c = new k();
            }
        }
        return f64965c;
    }

    public void b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        c(context, currentTimeMillis);
        this.f64966a = currentTimeMillis;
        t.b(context, currentTimeMillis);
    }

    public void c(Context context, long j11) {
        try {
            if (this.f64966a == 0) {
                this.f64967b = t.c(context);
            }
            if (j11 - this.f64967b >= 30000) {
                String b11 = t.b(context);
                if (!TextUtils.isEmpty(b11)) {
                    MTReporter content = new MTReporter().setType("active_terminate").setContent(new JSONObject(b11).toString());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, content);
                    MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, bundle);
                }
                String a11 = a(context, j11);
                if (TextUtils.isEmpty(a11)) {
                    MTCommonLog.d("MTActiveBusiness", "session is null");
                    return;
                }
                t.a(context, a11);
                String todayDateTimeForReport = DateUtil.getTodayDateTimeForReport();
                String str = todayDateTimeForReport.split("_")[0];
                String str2 = todayDateTimeForReport.split("_")[1];
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("session_id", a11);
                jSONObject.put(MessageKey.MSG_DATE, str);
                jSONObject.put(CrashHianalyticsData.TIME, str2);
                MTReporter content2 = new MTReporter().setType("active_launch").setContent(jSONObject.toString());
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, content2);
                MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, bundle2);
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTActiveBusiness", "processForeground failed " + th2.getMessage());
        }
    }

    public void b(Context context, long j11) {
        try {
            String a11 = t.a(context);
            if (TextUtils.isEmpty(a11)) {
                MTCommonLog.d("MTActiveBusiness", "session is null");
                return;
            }
            String todayDateTimeForReport = DateUtil.getTodayDateTimeForReport();
            String str = todayDateTimeForReport.split("_")[0];
            String str2 = todayDateTimeForReport.split("_")[1];
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session_id", a11);
            jSONObject.put(MessageKey.MSG_DATE, str);
            jSONObject.put(CrashHianalyticsData.TIME, str2);
            jSONObject.put(IBridgeMediaLoader.COLUMN_DURATION, (j11 - this.f64966a) / 1000);
            t.b(context, jSONObject.toString());
        } catch (Throwable th2) {
            MTCommonLog.w("MTActiveBusiness", "processBackground failed " + th2.getMessage());
        }
    }

    public void a(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        b(context, currentTimeMillis);
        this.f64967b = currentTimeMillis;
        t.a(context, currentTimeMillis);
    }

    public final String a(Context context, long j11) {
        StringBuilder sb2 = new StringBuilder();
        String appKey = MTGlobal.getAppKey(context);
        if (!TextUtils.isEmpty(appKey)) {
            sb2.append(appKey);
        }
        String deviceId = MTGlobal.getDeviceId(context);
        if (!TextUtils.isEmpty(deviceId)) {
            sb2.append(deviceId);
        }
        sb2.append(j11);
        return StringUtil.get32MD5String(sb2.toString());
    }
}
