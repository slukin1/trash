package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.api.CustomMessage;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.engagelab.privates.push.utils.NotificationUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import org.json.JSONObject;

public class m extends l {

    /* renamed from: b  reason: collision with root package name */
    public static volatile m f64969b;

    public static m b() {
        if (f64969b == null) {
            synchronized (m.class) {
                f64969b = new m();
            }
        }
        return f64969b;
    }

    public void a(Context context, Bundle bundle) {
        try {
            String string = bundle.getString("message");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("ad_id");
                if (TextUtils.isEmpty(optString)) {
                    MTCommonLog.d("MTCustomBusiness", "customMessage's messageId is null, can't callback this custom");
                    return;
                }
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("message");
                if (TextUtils.isEmpty(optString3)) {
                    MTCommonLog.d("MTCustomBusiness", "customMessage's content is null, can't callback this custom");
                    return;
                }
                String optString4 = jSONObject.optString(FirebaseAnalytics.Param.CONTENT_TYPE);
                CustomMessage extras = new CustomMessage().setMessageId(optString).setTitle(optString2).setContent(optString3).setContentType(optString4).setExtras(NotificationUtil.convertJsonToBundle(jSONObject.optJSONObject("extras")));
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("message", extras);
                MTCommonPrivatesApi.sendMessageToMainProcess(context, 3001, bundle2);
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTCustomBusiness", "onMessage failed " + th2.getMessage());
        }
    }

    public void b(Context context, int i11, Bundle bundle) {
        String str;
        try {
            bundle.setClassLoader(CustomMessage.class.getClassLoader());
            CustomMessage customMessage = (CustomMessage) bundle.getParcelable("message");
            if (customMessage != null) {
                MTCommonLog.d("MTCustomBusiness", "onCustomMessage");
                int i12 = MTPushConstants.MainWhat.REPORT_MESSAGE_STATE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg_id", customMessage.getMessageId());
                if (customMessage.getPlatform() != 0) {
                    i12 = MTPushConstants.MainWhat.REPORT_PLATFORM_MESSAGE_STATE;
                    jSONObject.put(HianalyticsBaseData.SDK_TYPE, customMessage.getPlatform());
                    jSONObject.put("tmsg_id", customMessage.getPlatformMessageId());
                    str = MTPushConstants.Message.TYPE_PLATFORM_MESSAGE_STATE;
                } else {
                    str = MTPushConstants.Message.TYPE_MESSAGE_STATE;
                }
                jSONObject.put("result", 1018);
                MTReporter content = new MTReporter().setType(str).setContent(jSONObject.toString());
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, content);
                MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, bundle2);
                Bundle bundle3 = new Bundle();
                bundle3.putString(MTPushConstants.Analysis.KEY_JSON, jSONObject.toString());
                MTCommonPrivatesApi.sendMessageToMainProcess(context, i12, bundle3);
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTCustomBusiness", "processRemoteMessage failed " + th2.getMessage());
        }
    }

    public void a(Context context, int i11, Bundle bundle) {
        MTCommonReceiver commonReceiver;
        try {
            bundle.setClassLoader(CustomMessage.class.getClassLoader());
            CustomMessage customMessage = (CustomMessage) bundle.getParcelable("message");
            if (customMessage != null && (commonReceiver = MTGlobal.getCommonReceiver(context)) != null) {
                commonReceiver.onCustomMessage(context, customMessage);
                MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.ON_CUSTOM_ARRIVED, bundle);
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTCustomBusiness", "processMainMessage failed " + th2.getMessage());
        }
    }
}
