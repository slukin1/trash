package com.engagelab.privates.common.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.push.api.MTPushPrivatesApi;
import com.engagelab.privates.push.api.NotificationMessage;
import com.engagelab.privates.push.utils.NotificationUtil;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import org.json.JSONObject;

public class MTCommonActivity extends Activity {
    private static final String TAG = "MTCommonActivity";

    private void processIntent(Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            String uri = intent.getData() != null ? intent.getData().toString() : "";
            if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
                uri = MTGlobal.IS_FOR_JIGUANG ? extras.getString("JMessageExtra") : extras.getString("MTMessageExtra");
            }
            if (TextUtils.isEmpty(uri)) {
                MTCommonPrivatesApi.sendMessageToMainProcess(getApplicationContext(), Integer.parseInt(intent.getAction()), extras);
            } else {
                processPlatformMessage(uri);
            }
            finish();
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "processIntent failed " + th2.getMessage());
        }
    }

    private void processPlatformMessage(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        Bundle bundle;
        try {
            JSONObject jSONObject = new JSONObject(str);
            MTCommonLog.d(TAG, "platformMessageJson:" + MTCommonLog.toLogString(jSONObject));
            String messageId = NotificationUtil.getMessageId(jSONObject);
            byte optInt = (byte) jSONObject.optInt("rom_type");
            if (jSONObject.has("m_content")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
                str5 = optJSONObject.optString("n_title");
                str4 = optJSONObject.optString("n_content");
                str2 = optJSONObject.optString("n_intent_uri");
                str3 = optJSONObject.optString("n_intent_ssl");
                bundle = NotificationUtil.convertJsonToBundle(optJSONObject.optJSONObject("n_extras"));
            } else {
                String optString = jSONObject.optString("n_title");
                str4 = jSONObject.optString("n_content");
                str2 = jSONObject.optString("n_intent_uri");
                str3 = jSONObject.optString("n_intent_ssl");
                Bundle convertJsonToBundle = NotificationUtil.convertJsonToBundle(jSONObject.optJSONObject("n_extras"));
                str5 = optString;
                bundle = convertJsonToBundle;
            }
            NotificationMessage intentSsl = new NotificationMessage().setMessageId(messageId).setPlatform(optInt).setTitle(str5).setContent(str4).setExtras(bundle).setIntentUri(str2).setIntentSsl(str3);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("message", intentSsl);
            MTPushPrivatesApi.init(getApplicationContext());
            MTCommonPrivatesApi.sendMessageToMainProcess(getApplicationContext(), 3003, bundle2);
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "processPlatformMessage failed " + th2.getMessage());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        processIntent(getIntent());
    }

    public void onNewIntent(Intent intent) {
        PushAutoTrackHelper.onNewIntent(this, intent);
        super.onNewIntent(intent);
        processIntent(intent);
    }
}
