package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.app.ActivityManager;
import com.sumsub.sns.internal.fingerprint.tools.threading.safe.c;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class u implements t {

    /* renamed from: a  reason: collision with root package name */
    public final ActivityManager f34648a;

    public static final class a extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u f34649a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(u uVar) {
            super(0);
            this.f34649a = uVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r0.getDeviceConfigurationInfo();
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String invoke() {
            /*
                r1 = this;
                com.sumsub.sns.internal.fingerprint.infoproviders.u r0 = r1.f34649a
                android.app.ActivityManager r0 = r0.f34648a
                if (r0 == 0) goto L_0x0013
                android.content.pm.ConfigurationInfo r0 = r0.getDeviceConfigurationInfo()
                if (r0 == 0) goto L_0x0013
                java.lang.String r0 = r0.getGlEsVersion()
                goto L_0x0014
            L_0x0013:
                r0 = 0
            L_0x0014:
                if (r0 != 0) goto L_0x0018
                java.lang.String r0 = ""
            L_0x0018:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.fingerprint.infoproviders.u.a.invoke():java.lang.String");
        }
    }

    public u(ActivityManager activityManager) {
        this.f34648a = activityManager;
    }

    public String a() {
        Object a11 = c.a(0, new a(this), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }
}
