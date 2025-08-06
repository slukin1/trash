package com.iproov.sdk.p017implements;

import android.view.Window;
import android.view.WindowManager;

/* renamed from: com.iproov.sdk.implements.public  reason: invalid class name and invalid package */
public final class Cpublic {
    /* renamed from: do  reason: not valid java name */
    public static final void m1032do(Window window, boolean z11) {
        if (z11) {
            window.addFlags(128);
        } else {
            window.clearFlags(128);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static final void m1033if(Window window, boolean z11) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z11) {
            attributes.screenBrightness = 1.0f;
        } else {
            attributes.screenBrightness = -1.0f;
        }
        window.setAttributes(attributes);
    }

    /* renamed from: do  reason: not valid java name */
    public static final void m1031do(Window window, float f11) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f11;
        window.setAttributes(attributes);
    }
}
