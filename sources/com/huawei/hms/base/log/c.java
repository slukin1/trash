package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private d f37830a;

    public void a(Context context, String str) {
        d dVar = this.f37830a;
        if (dVar != null) {
            dVar.a(context, str);
        }
    }

    public void a(d dVar) {
        this.f37830a = dVar;
    }

    public void a(String str, int i11, String str2, String str3) {
        Log.println(i11, "HMSSDK_" + str2, str3);
        d dVar = this.f37830a;
        if (dVar != null) {
            dVar.a(str, i11, str2, str3);
        }
    }
}
