package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public class q1 {

    /* renamed from: c  reason: collision with root package name */
    private static q1 f38253c = new q1();

    /* renamed from: a  reason: collision with root package name */
    private boolean f38254a = false;

    /* renamed from: b  reason: collision with root package name */
    private Context f38255b = q0.i();

    private q1() {
    }

    public static q1 b() {
        return f38253c;
    }

    @TargetApi(24)
    public boolean a() {
        boolean z11;
        if (!this.f38254a) {
            Context context = this.f38255b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService("user");
                if (userManager != null) {
                    z11 = userManager.isUserUnlocked();
                } else {
                    this.f38254a = false;
                }
            } else {
                z11 = true;
            }
            this.f38254a = z11;
        }
        return this.f38254a;
    }
}
