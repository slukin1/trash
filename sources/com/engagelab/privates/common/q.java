package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.api.AliasMessage;
import com.engagelab.privates.push.api.MTPushPrivatesApi;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class q extends p {

    /* renamed from: c  reason: collision with root package name */
    public static volatile q f64975c;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Integer, String> f64976b = new ConcurrentHashMap<>();

    public static q b() {
        if (f64975c == null) {
            synchronized (q.class) {
                f64975c = new q();
            }
        }
        return f64975c;
    }

    public void a(Context context, int i11, Bundle bundle) {
        MTCommonReceiver commonReceiver;
        try {
            bundle.setClassLoader(AliasMessage.class.getClassLoader());
            AliasMessage aliasMessage = (AliasMessage) bundle.getParcelable(MTPushConstants.Operation.KEY_ALIAS);
            if (aliasMessage != null && (commonReceiver = MTGlobal.getCommonReceiver(context)) != null) {
                switch (i11) {
                    case MTPushConstants.MainWhat.ALIAS_SET /*3017*/:
                    case MTPushConstants.MainWhat.ALIAS_GET /*3018*/:
                    case MTPushConstants.MainWhat.ALIAS_CLEAR /*3019*/:
                        commonReceiver.onAliasMessage(context, aliasMessage);
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTAliasBusiness", "processMainMessage failed " + th2.getMessage());
        }
    }

    public void a(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL);
            if (mTProtocol != null) {
                int rid = (int) mTProtocol.getRid();
                this.f64976b.remove(Integer.valueOf(rid));
                AliasMessage alias = new AliasMessage().setSequence(rid).setCode(MTPushPrivatesApi.Code.TIMEOUT).setAlias(this.f64976b.get(Integer.valueOf(rid)));
                MTCommonLog.d("MTAliasBusiness", "onAliasOperationFailed sequence:" + rid + ", aliasMessage:" + alias.toString());
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MTPushConstants.Operation.KEY_ALIAS, alias);
                MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.ALIAS_SET, bundle2);
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTAliasBusiness", "onAliasOperationFailed failed " + th2.getMessage());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r7, int r8, android.os.Bundle r9) {
        /*
            r6 = this;
            java.lang.String r0 = "MTAliasBusiness"
            java.lang.String r1 = "alias"
            java.lang.String r2 = "sequence"
            int r2 = r9.getInt(r2)     // Catch:{ all -> 0x00be }
            java.lang.String r9 = r9.getString(r1)     // Catch:{ all -> 0x00be }
            switch(r8) {
                case 3981: goto L_0x003f;
                case 3982: goto L_0x003c;
                case 3983: goto L_0x0014;
                default: goto L_0x0011;
            }
        L_0x0011:
            java.lang.String r8 = ""
            goto L_0x0041
        L_0x0014:
            int r8 = r6.a(r9)     // Catch:{ all -> 0x00be }
            if (r8 == 0) goto L_0x0039
            com.engagelab.privates.push.api.AliasMessage r3 = new com.engagelab.privates.push.api.AliasMessage     // Catch:{ all -> 0x00be }
            r3.<init>()     // Catch:{ all -> 0x00be }
            com.engagelab.privates.push.api.AliasMessage r2 = r3.setSequence(r2)     // Catch:{ all -> 0x00be }
            com.engagelab.privates.push.api.AliasMessage r8 = r2.setCode(r8)     // Catch:{ all -> 0x00be }
            com.engagelab.privates.push.api.AliasMessage r8 = r8.setAlias(r9)     // Catch:{ all -> 0x00be }
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x00be }
            r9.<init>()     // Catch:{ all -> 0x00be }
            r9.putParcelable(r1, r8)     // Catch:{ all -> 0x00be }
            r8 = 3017(0xbc9, float:4.228E-42)
            com.engagelab.privates.common.api.MTCommonPrivatesApi.sendMessageToMainProcess(r7, r8, r9)     // Catch:{ all -> 0x00be }
            return
        L_0x0039:
            java.lang.String r8 = "set"
            goto L_0x0041
        L_0x003c:
            java.lang.String r8 = "get"
            goto L_0x0041
        L_0x003f:
            java.lang.String r8 = "del"
        L_0x0041:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x00be }
            r3.<init>()     // Catch:{ all -> 0x00be }
            java.lang.String r4 = "platform"
            java.lang.String r5 = "a"
            r3.put(r4, r5)     // Catch:{ all -> 0x00be }
            java.lang.String r4 = "op"
            r3.put(r4, r8)     // Catch:{ all -> 0x00be }
            boolean r8 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x00be }
            if (r8 != 0) goto L_0x0064
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.String> r8 = r6.f64976b     // Catch:{ all -> 0x00be }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00be }
            r8.put(r4, r9)     // Catch:{ all -> 0x00be }
            r3.put(r1, r9)     // Catch:{ all -> 0x00be }
        L_0x0064:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            r8.<init>()     // Catch:{ all -> 0x00be }
            java.lang.String r9 = "sendAliasOperation sequence:"
            r8.append(r9)     // Catch:{ all -> 0x00be }
            r8.append(r2)     // Catch:{ all -> 0x00be }
            java.lang.String r9 = ", content:"
            r8.append(r9)     // Catch:{ all -> 0x00be }
            java.lang.String r9 = com.engagelab.privates.common.log.MTCommonLog.toLogString((org.json.JSONObject) r3)     // Catch:{ all -> 0x00be }
            r8.append(r9)     // Catch:{ all -> 0x00be }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00be }
            com.engagelab.privates.common.log.MTCommonLog.d(r0, r8)     // Catch:{ all -> 0x00be }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x00be }
            byte[] r8 = com.engagelab.privates.common.v.b(r8)     // Catch:{ all -> 0x00be }
            if (r8 != 0) goto L_0x008f
            return
        L_0x008f:
            com.engagelab.privates.core.api.MTProtocol r9 = new com.engagelab.privates.core.api.MTProtocol     // Catch:{ all -> 0x00be }
            r9.<init>()     // Catch:{ all -> 0x00be }
            long r1 = (long) r2     // Catch:{ all -> 0x00be }
            com.engagelab.privates.core.api.MTProtocol r9 = r9.setRid(r1)     // Catch:{ all -> 0x00be }
            r1 = 29
            com.engagelab.privates.core.api.MTProtocol r9 = r9.setCommand(r1)     // Catch:{ all -> 0x00be }
            r1 = 1
            com.engagelab.privates.core.api.MTProtocol r9 = r9.setVersion(r1)     // Catch:{ all -> 0x00be }
            com.engagelab.privates.core.api.MTProtocol r8 = r9.setBody(r8)     // Catch:{ all -> 0x00be }
            java.lang.String r9 = "ENGAGELAB-PRIVATES-PUSH"
            com.engagelab.privates.core.api.MTProtocol r8 = r8.setThreadName(r9)     // Catch:{ all -> 0x00be }
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x00be }
            r9.<init>()     // Catch:{ all -> 0x00be }
            java.lang.String r1 = "protocol"
            r9.putParcelable(r1, r8)     // Catch:{ all -> 0x00be }
            r8 = 2222(0x8ae, float:3.114E-42)
            com.engagelab.privates.common.api.MTCommonPrivatesApi.sendMessageToRemoteProcess(r7, r8, r9)     // Catch:{ all -> 0x00be }
            goto L_0x00d7
        L_0x00be:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "sendAliasOperation failed "
            r8.append(r9)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r0, r7)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.engagelab.privates.common.q.b(android.content.Context, int, android.os.Bundle):void");
    }

    public final int a(String str) {
        int a11 = a();
        if (a11 != 0) {
            return a11;
        }
        if (TextUtils.isEmpty(str)) {
            return MTPushPrivatesApi.Code.INVALID_ALIAS;
        }
        if (str.getBytes().length > 40) {
            return MTPushPrivatesApi.Code.TOO_LONG_ALIAS;
        }
        if (!Pattern.compile("^[一-龥0-9a-zA-Z_!@#$&*+=.|]+$").matcher(str).matches()) {
            return MTPushPrivatesApi.Code.INVALID_ALIAS;
        }
        return 0;
    }

    public void b(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL);
            if (mTProtocol != null) {
                int rid = (int) mTProtocol.getRid();
                JSONObject jSONObject = new JSONObject(StringUtil.getTlv2(ByteBuffer.wrap(mTProtocol.getBody())));
                MTCommonLog.d("MTAliasBusiness", "onAliasOperationSuccess sequence:" + rid + ", content:" + MTCommonLog.toLogString(jSONObject));
                int optInt = jSONObject.optInt("code");
                String optString = jSONObject.optString("op");
                char c11 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != 99339) {
                    if (hashCode != 102230) {
                        if (hashCode == 113762) {
                            if (optString.equals("set")) {
                                c11 = 0;
                            }
                        }
                    } else if (optString.equals("get")) {
                        c11 = 1;
                    }
                } else if (optString.equals("del")) {
                    c11 = 2;
                }
                int i11 = MTPushConstants.MainWhat.ALIAS_SET;
                String str = "";
                if (c11 == 0) {
                    str = this.f64976b.get(Integer.valueOf(rid));
                    this.f64976b.remove(Integer.valueOf(rid));
                } else if (c11 == 1) {
                    str = jSONObject.optString(MTPushConstants.Operation.KEY_ALIAS);
                    i11 = MTPushConstants.MainWhat.ALIAS_GET;
                } else if (c11 == 2) {
                    i11 = MTPushConstants.MainWhat.ALIAS_CLEAR;
                }
                AliasMessage alias = new AliasMessage().setSequence(rid).setCode(optInt).setAlias(str);
                MTCommonLog.d("MTAliasBusiness", "onAliasOperationSuccess aliasMessage:" + alias.toString());
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MTPushConstants.Operation.KEY_ALIAS, alias);
                MTCommonPrivatesApi.sendMessageToMainProcess(context, i11, bundle2);
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTAliasBusiness", "onAliasOperationSuccess failed " + th2.getMessage());
        }
    }
}
