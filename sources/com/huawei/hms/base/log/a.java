package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final HMSExtLogger f37825a;

    /* renamed from: b  reason: collision with root package name */
    private d f37826b;

    public a(HMSExtLogger hMSExtLogger) {
        this.f37825a = hMSExtLogger;
    }

    public void a(Context context, String str) {
        d dVar = this.f37826b;
        if (dVar != null) {
            dVar.a(context, str);
        }
    }

    public void a(d dVar) {
        this.f37826b = dVar;
    }

    public void a(String str, int i11, String str2, String str3) {
        HMSExtLogger hMSExtLogger = this.f37825a;
        if (hMSExtLogger != null) {
            if (i11 == 3) {
                hMSExtLogger.d(str2, str3);
            } else if (i11 == 4) {
                hMSExtLogger.i(str2, str3);
            } else if (i11 != 5) {
                hMSExtLogger.e(str2, str3);
            } else {
                hMSExtLogger.w(str2, str3);
            }
        }
        d dVar = this.f37826b;
        if (dVar != null) {
            dVar.a(str, i11, str2, str3);
        }
    }
}
