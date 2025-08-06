package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile l f64968a;

    public static l a() {
        if (f64968a == null) {
            synchronized (l.class) {
                f64968a = new l();
            }
        }
        return f64968a;
    }

    public void a(Context context, Bundle bundle) {
        JSONObject optJSONObject;
        try {
            ByteBuffer wrap = ByteBuffer.wrap(((MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL)).getBody());
            byte b11 = wrap.get();
            int intValue = Long.valueOf(wrap.getLong()).intValue();
            LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(StringUtil.getTlv2(wrap)));
            String readLine = lineNumberReader.readLine();
            String readLine2 = lineNumberReader.readLine();
            String readLine3 = lineNumberReader.readLine();
            if (!TextUtils.equals(readLine, context.getPackageName())) {
                MTCommonLog.w("MTMessageBusiness", "the message applicationId is [" + readLine + "]");
            } else if (!TextUtils.equals(readLine2, MTGlobal.getAppKey(context))) {
                MTCommonLog.w("MTMessageBusiness", "the message applicationKey is [" + readLine2 + "]");
            } else if (TextUtils.isEmpty(readLine3)) {
                MTCommonLog.w("MTMessageBusiness", "the message is empty");
            } else {
                JSONObject jSONObject = new JSONObject(readLine3);
                int optInt = jSONObject.optInt("n_only");
                int optInt2 = jSONObject.optInt("show_type");
                a(context, b11, intValue);
                Bundle bundle2 = new Bundle();
                bundle2.putString("message", jSONObject.toString());
                MTCommonLog.d("MTMessageBusiness", "onMessage:" + MTCommonLog.toLogString(jSONObject));
                if (!jSONObject.has("geofence") || (optJSONObject = jSONObject.optJSONObject("geofence")) == null || TextUtils.isEmpty(optJSONObject.optString("geofenceid"))) {
                    MTCommonLog.w("MTMessageBusiness", "onMessage type=" + optInt2 + " flag=" + optInt);
                    if (optInt2 == 4) {
                        n.b().a(context, bundle2);
                        m.b().a(context, bundle2);
                    } else if (optInt == 1) {
                        n.b().a(context, bundle2);
                    } else if (optInt == 0) {
                        m.b().a(context, bundle2);
                    }
                } else {
                    MTCommonLog.d("MTMessageBusiness", "is geofence notification");
                    MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.ADD_GEOFENCE, bundle2);
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTMessageBusiness", "onMessage failed " + th2.getMessage());
        }
    }

    public final void a(Context context, int i11, int i12) {
        MTProtocol threadName = new MTProtocol().setCommand(4).setVersion(2).setBody(v.a(i11, i12)).setThreadName("ENGAGELAB-PRIVATES-PUSH");
        Bundle bundle = new Bundle();
        bundle.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, threadName);
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.UPLOAD, bundle);
    }
}
