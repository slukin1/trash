package com.huawei.hms.aaid.init;

import android.content.Context;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f37661a;

    public a(Context context) {
        this.f37661a = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        com.huawei.hms.support.log.HMSLog.i("AutoInit", "push kit sdk not exists");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x008c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            java.lang.String r0 = "push kit sdk not exists"
            java.lang.String r1 = "AutoInit"
            com.huawei.hms.aaid.constant.ErrorEnum r2 = com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS     // Catch:{ Exception -> 0x0090 }
            int r2 = r2.getInternalCode()     // Catch:{ Exception -> 0x0090 }
            r3 = 0
            android.content.Context r4 = r8.f37661a     // Catch:{ ApiException -> 0x0027 }
            com.huawei.hms.aaid.HmsInstanceId r4 = com.huawei.hms.aaid.HmsInstanceId.getInstance(r4)     // Catch:{ ApiException -> 0x0027 }
            android.content.Context r5 = r8.f37661a     // Catch:{ ApiException -> 0x0027 }
            java.lang.String r5 = com.huawei.hms.utils.Util.getAppId(r5)     // Catch:{ ApiException -> 0x0027 }
            java.lang.String r3 = r4.getToken(r5, r3)     // Catch:{ ApiException -> 0x0027 }
            java.lang.String r4 = "Push init succeed"
            com.huawei.hms.support.log.HMSLog.i(r1, r4)     // Catch:{ ApiException -> 0x0027 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ ApiException -> 0x0027 }
            if (r4 == 0) goto L_0x0031
            return
        L_0x0027:
            r2 = move-exception
            int r2 = r2.getStatusCode()     // Catch:{ Exception -> 0x0090 }
            java.lang.String r4 = "new Push init failed"
            com.huawei.hms.support.log.HMSLog.e(r1, r4)     // Catch:{ Exception -> 0x0090 }
        L_0x0031:
            android.content.Context r4 = r8.f37661a     // Catch:{ NameNotFoundException -> 0x008c }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x008c }
            android.content.Context r5 = r8.f37661a     // Catch:{ NameNotFoundException -> 0x008c }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x008c }
            r6 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r5, r6)     // Catch:{ NameNotFoundException -> 0x008c }
            android.os.Bundle r4 = r4.metaData     // Catch:{ NameNotFoundException -> 0x008c }
            if (r4 == 0) goto L_0x0088
            java.lang.String r5 = "com.huawei.hms.client.service.name:push"
            java.lang.String r4 = r4.getString(r5)     // Catch:{ NameNotFoundException -> 0x008c }
            if (r4 == 0) goto L_0x0088
            android.content.Intent r4 = new android.content.Intent     // Catch:{ NameNotFoundException -> 0x008c }
            java.lang.String r5 = "com.huawei.push.action.MESSAGING_EVENT"
            r4.<init>(r5)     // Catch:{ NameNotFoundException -> 0x008c }
            android.content.Context r5 = r8.f37661a     // Catch:{ NameNotFoundException -> 0x008c }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x008c }
            r4.setPackage(r5)     // Catch:{ NameNotFoundException -> 0x008c }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ NameNotFoundException -> 0x008c }
            r5.<init>()     // Catch:{ NameNotFoundException -> 0x008c }
            java.lang.String r6 = "message_type"
            java.lang.String r7 = "new_token"
            r5.putString(r6, r7)     // Catch:{ NameNotFoundException -> 0x008c }
            java.lang.String r6 = "device_token"
            r5.putString(r6, r3)     // Catch:{ NameNotFoundException -> 0x008c }
            java.lang.String r3 = "error"
            r5.putInt(r3, r2)     // Catch:{ NameNotFoundException -> 0x008c }
            com.huawei.hms.opendevice.k r2 = new com.huawei.hms.opendevice.k     // Catch:{ NameNotFoundException -> 0x008c }
            r2.<init>()     // Catch:{ NameNotFoundException -> 0x008c }
            android.content.Context r3 = r8.f37661a     // Catch:{ NameNotFoundException -> 0x008c }
            boolean r2 = r2.a(r3, r5, r4)     // Catch:{ NameNotFoundException -> 0x008c }
            if (r2 != 0) goto L_0x0096
            java.lang.String r2 = "start service failed"
            com.huawei.hms.support.log.HMSLog.e(r1, r2)     // Catch:{ NameNotFoundException -> 0x008c }
            goto L_0x0096
        L_0x0088:
            com.huawei.hms.support.log.HMSLog.i(r1, r0)     // Catch:{ NameNotFoundException -> 0x008c }
            goto L_0x0096
        L_0x008c:
            com.huawei.hms.support.log.HMSLog.i(r1, r0)     // Catch:{ Exception -> 0x0090 }
            goto L_0x0096
        L_0x0090:
            r0 = move-exception
            java.lang.String r2 = "Push init failed"
            com.huawei.hms.support.log.HMSLog.e((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r0)
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.aaid.init.a.run():void");
    }
}
