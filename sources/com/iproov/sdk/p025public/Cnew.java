package com.iproov.sdk.p025public;

import android.view.Window;
import android.view.WindowManager;

/* renamed from: com.iproov.sdk.public.new  reason: invalid class name and invalid package */
public class Cnew {

    /* renamed from: do  reason: not valid java name */
    private Window f1149do;

    public Cnew(Window window) {
        this.f1149do = window;
    }

    /* renamed from: do  reason: not valid java name */
    public void m1307do(boolean z11) {
        if (z11) {
            this.f1149do.addFlags(128);
        } else {
            this.f1149do.clearFlags(128);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m1308if(boolean z11) {
        WindowManager.LayoutParams attributes = this.f1149do.getAttributes();
        if (z11) {
            attributes.screenBrightness = 1.0f;
        } else {
            attributes.screenBrightness = -1.0f;
        }
        this.f1149do.setAttributes(attributes);
    }
}
