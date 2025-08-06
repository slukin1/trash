package com.iproov.sdk.core;

import com.facebook.internal.AnalyticsEvents;

/* renamed from: com.iproov.sdk.core.for  reason: invalid class name */
public class Cfor {

    /* renamed from: do  reason: not valid java name */
    public final Cdo f304do;

    /* renamed from: com.iproov.sdk.core.for$do  reason: invalid class name */
    public enum Cdo {
        NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
        NATIVE_BRIDGE("native_bridge");
        

        /* renamed from: do  reason: not valid java name */
        public final String f308do;

        private Cdo(String str) {
            this.f308do = str;
        }
    }

    public Cfor(Cdo doVar) {
        this.f304do = doVar;
    }

    public Cfor() {
        this.f304do = Cdo.NATIVE;
    }
}
