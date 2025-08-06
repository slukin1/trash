package com.huawei.hms.hatool;

import android.os.Build;
import android.util.Log;

public class m0 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f38228a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f38229b = 4;

    private static String a() {
        return "FormalHASDK_2.2.0.314" + p.a();
    }

    public void a(int i11) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 19) {
            sb2.append(System.lineSeparator());
            sb2.append("======================================= ");
            sb2.append(System.lineSeparator());
            sb2.append(a());
            sb2.append("");
            sb2.append(System.lineSeparator());
            str = "=======================================";
        } else {
            sb2.append("====================");
            sb2.append(a());
            str = "===================";
        }
        sb2.append(str);
        Log.i("FormalHASDK", sb2.toString());
        this.f38229b = i11;
        this.f38228a = true;
    }

    public void a(int i11, String str, String str2) {
        if (i11 == 3) {
            Log.d(str, str2);
        } else if (i11 == 5) {
            Log.w(str, str2);
        } else if (i11 != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public void b(int i11, String str, String str2) {
        a(i11, "FormalHASDK", str + "=> " + str2);
    }

    public boolean b(int i11) {
        return this.f38228a && i11 >= this.f38229b;
    }
}
