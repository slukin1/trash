package com.sumsub.sentry.android;

import android.os.Build;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sumsub.sns.internal.log.c;

public class a {
    public final String a() {
        return Build.TAGS;
    }

    public final String b() {
        return Build.MANUFACTURER;
    }

    public final String c() {
        return Build.MODEL;
    }

    public final int d() {
        return Build.VERSION.SDK_INT;
    }

    public final String e() {
        return Build.VERSION.RELEASE;
    }

    public final boolean f() {
        try {
            if (!StringsKt__StringsJVMKt.M(Build.BRAND, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE, false, 2, (Object) null) || !StringsKt__StringsJVMKt.M(Build.DEVICE, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE, false, 2, (Object) null)) {
                String str = Build.FINGERPRINT;
                if (!StringsKt__StringsJVMKt.M(str, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE, false, 2, (Object) null) && !StringsKt__StringsJVMKt.M(str, "unknown", false, 2, (Object) null)) {
                    String str2 = Build.HARDWARE;
                    if (!StringsKt__StringsKt.R(str2, "goldfish", false, 2, (Object) null) && !StringsKt__StringsKt.R(str2, "ranchu", false, 2, (Object) null)) {
                        String str3 = Build.MODEL;
                        if (!StringsKt__StringsKt.R(str3, "google_sdk", false, 2, (Object) null) && !StringsKt__StringsKt.R(str3, "Emulator", false, 2, (Object) null) && !StringsKt__StringsKt.R(str3, "Android SDK built for x86", false, 2, (Object) null) && !StringsKt__StringsKt.R(Build.MANUFACTURER, "Genymotion", false, 2, (Object) null)) {
                            String str4 = Build.PRODUCT;
                            if (StringsKt__StringsKt.R(str4, "sdk_google", false, 2, (Object) null) || StringsKt__StringsKt.R(str4, "google_sdk", false, 2, (Object) null) || StringsKt__StringsKt.R(str4, ServerProtocol.DIALOG_PARAM_SDK_VERSION, false, 2, (Object) null) || StringsKt__StringsKt.R(str4, "sdk_x86", false, 2, (Object) null) || StringsKt__StringsKt.R(str4, "vbox86p", false, 2, (Object) null) || StringsKt__StringsKt.R(str4, c.f30264k, false, 2, (Object) null) || StringsKt__StringsKt.R(str4, "simulator", false, 2, (Object) null)) {
                                return true;
                            }
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(c.a(this), "Error checking whether application is running in an emulator.", th2);
            return false;
        }
    }
}
