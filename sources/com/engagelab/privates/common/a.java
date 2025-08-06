package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.core.api.Outputer;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;
import com.tencent.android.tpush.common.Constants;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f64944a;

    public static a a() {
        if (f64944a == null) {
            synchronized (a.class) {
                f64944a = new a();
            }
        }
        return f64944a;
    }

    public void b(Context context) {
        int f11 = g.f(context);
        long m11 = g.m(context);
        String g11 = g.g(context);
        String d11 = g.d(context);
        Bundle bundle = new Bundle();
        bundle.putInt("code", f11);
        bundle.putLong("user_id", m11);
        bundle.putString(MTCoreConstants.Register.KEY_REGISTRATION_ID, g11);
        bundle.putString(MTCoreConstants.Register.KEY_PASSWORD, d11);
        MTCommonPrivatesApi.sendMessageToMainProcess(context, 2101, bundle);
    }

    public void c(Context context, Bundle bundle) {
        int i11 = bundle.getInt("code");
        long j11 = bundle.getLong("user_id");
        String string = bundle.getString(MTCoreConstants.Register.KEY_REGISTRATION_ID);
        String string2 = bundle.getString(MTCoreConstants.Register.KEY_PASSWORD);
        MTCoreGlobal.setRegisterCode(i11);
        MTCoreGlobal.setUserId(j11);
        MTCoreGlobal.setRegistrationId(string);
        MTCoreGlobal.setPassword(string2);
    }

    public void a(Context context) {
        int c11 = g.c(context);
        int h11 = g.h(context);
        long i11 = g.i(context);
        Bundle bundle = new Bundle();
        bundle.putInt("code", c11);
        bundle.putInt(MTCoreConstants.Login.KEY_SEED_ID, h11);
        bundle.putLong("server_time", i11);
        MTCommonPrivatesApi.sendMessageToMainProcess(context, 2102, bundle);
    }

    public void b(Context context, Bundle bundle) {
        int i11 = bundle.getInt("code");
        int i12 = bundle.getInt(MTCoreConstants.Login.KEY_SEED_ID);
        long j11 = bundle.getLong("server_time");
        MTCoreGlobal.setLoginCode(i11);
        MTCoreGlobal.setSeedId(i12);
        MTCoreGlobal.setServerTime(j11);
    }

    public void a(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL);
            mTProtocol.getRid();
            ByteBuffer wrap = ByteBuffer.wrap(mTProtocol.getBody());
            long j11 = wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            Outputer outputer = new Outputer();
            outputer.writeU16(0);
            outputer.writeU64(j11);
            outputer.writeByteArrayIncludeLength("".getBytes());
            MTProtocol body = new MTProtocol().setRid(j11).setCommand(25).setVersion(1).setBody(outputer.toByteArray());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, body);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.UPLOAD, bundle2);
            JSONObject jSONObject = new JSONObject(str);
            MTCommonLog.d("MTCoreBusiness", "onCtrl " + MTCommonLog.toLogString(jSONObject));
            int optInt = jSONObject.optInt(Constants.MQTT_STATISTISC_MSGTYPE_KEY);
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            Bundle bundle3 = new Bundle();
            bundle3.putString(MTCoreConstants.Protocol.KEY_PROTOCOL, optJSONObject.toString());
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, optInt, bundle3);
        } catch (Throwable th2) {
            MTCommonLog.w("MTCoreBusiness", "onCtrl failed " + th2.getMessage());
        }
    }
}
