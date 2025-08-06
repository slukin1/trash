package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.api.MTPushPrivatesApi;
import com.engagelab.privates.push.api.MobileNumberMessage;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class r extends p {

    /* renamed from: c  reason: collision with root package name */
    public static volatile r f64977c;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Integer, String> f64978b = new ConcurrentHashMap<>();

    public static r b() {
        if (f64977c == null) {
            synchronized (r.class) {
                f64977c = new r();
            }
        }
        return f64977c;
    }

    public void a(Context context, int i11, Bundle bundle) {
        MTCommonReceiver commonReceiver;
        try {
            bundle.setClassLoader(MobileNumberMessage.class.getClassLoader());
            MobileNumberMessage mobileNumberMessage = (MobileNumberMessage) bundle.getParcelable("message");
            if (mobileNumberMessage != null && (commonReceiver = MTGlobal.getCommonReceiver(context)) != null) {
                commonReceiver.onMobileNumber(context, mobileNumberMessage);
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTMobileNumberBusiness", "processMainMessage failed " + th2.getMessage());
        }
    }

    public void a(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL);
            if (mTProtocol != null) {
                int rid = (int) mTProtocol.getRid();
                String str = this.f64978b.get(Integer.valueOf(rid));
                this.f64978b.remove(Integer.valueOf(rid));
                if (!TextUtils.isEmpty(str)) {
                    MobileNumberMessage mobileNumber = new MobileNumberMessage().setSequence(rid).setCode(MTPushPrivatesApi.Code.TIMEOUT).setMobileNumber(str);
                    MTCommonLog.d("MTMobileNumberBusiness", "onMobileNumberFailed mobileNumberMessage:" + mobileNumber.toString());
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("message", mobileNumber);
                    MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.ON_MOBILE_NUMBER, bundle2);
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTMobileNumberBusiness", "onMobileNumberFailed failed " + th2.getMessage());
        }
    }

    public void b(Context context, int i11, Bundle bundle) {
        try {
            int i12 = bundle.getInt(MTPushConstants.Operation.KEY_SEQUENCE);
            String string = bundle.getString(MTPushConstants.Operation.KEY_MOBILE_NUMBER);
            int a11 = a(string);
            if (a11 != 0) {
                MTCommonLog.d("MTMobileNumberBusiness", "sendMobileNumberOperation failed code:" + a11 + ", sequence:" + i12 + ", mobileNumber:" + string);
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("message", new MobileNumberMessage().setSequence(i12).setCode(a11).setMobileNumber(string));
                MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.ON_MOBILE_NUMBER, bundle2);
                return;
            }
            this.f64978b.put(Integer.valueOf(i12), string);
            MTCommonLog.d("MTMobileNumberBusiness", "sendMobileNumberOperation sequence:" + i12 + ", mobileNumber:" + string);
            MTProtocol body = new MTProtocol().setRid((long) i12).setCommand(26).setVersion(1).setBody(v.a(string));
            Bundle bundle3 = new Bundle();
            bundle3.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, body);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.UPLOAD, bundle3);
        } catch (Throwable th2) {
            MTCommonLog.w("MTMobileNumberBusiness", "processRemoteMessage failed " + th2.getMessage());
        }
    }

    public final int a(String str) {
        if (!Pattern.compile("^[+0-9][-0-9]{1,}$").matcher(str).matches()) {
            MTCommonLog.w("MTMobileNumberBusiness", "[" + str + "] is not mobileNumber");
            return MTPushPrivatesApi.Code.INVALID_MOBILE_NUMBER;
        } else if (a() != 0) {
            return MTPushPrivatesApi.Code.INVOKE_TOO_SOON;
        } else {
            return 0;
        }
    }

    public void b(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL);
            int rid = (int) mTProtocol.getRid();
            if (!this.f64978b.containsKey(Integer.valueOf(rid))) {
                MTCommonLog.d("MTMobileNumberBusiness", "failed ");
                return;
            }
            this.f64978b.remove(Integer.valueOf(rid));
            MobileNumberMessage mobileNumber = new MobileNumberMessage().setSequence(rid).setCode(ByteBuffer.wrap(mTProtocol.getBody()).getShort()).setMobileNumber(this.f64978b.get(Integer.valueOf(rid)));
            MTCommonLog.d("MTMobileNumberBusiness", "onMobileNumberSuccess mobileNumberMessage:" + mobileNumber.toString());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("message", mobileNumber);
            MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.ON_MOBILE_NUMBER, bundle2);
        } catch (Throwable th2) {
            MTCommonLog.w("MTMobileNumberBusiness", "onMobileNumberSuccess failed " + th2.getMessage());
        }
    }
}
