package com.huawei.hms.hatool;

import com.hbg.lib.network.pro.core.util.Period;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.UUID;

public class p0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f38243a = Period.MIN30_MILLS;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f38244b = false;

    /* renamed from: c  reason: collision with root package name */
    private a f38245c = null;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38246a = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");

        /* renamed from: b  reason: collision with root package name */
        public boolean f38247b;

        /* renamed from: c  reason: collision with root package name */
        private long f38248c;

        public a(long j11) {
            this.f38246a += "_" + j11;
            this.f38248c = j11;
            this.f38247b = true;
            boolean unused = p0.this.f38244b = false;
        }

        private boolean a(long j11, long j12) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j11);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j12);
            return (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) ? false : true;
        }

        private void b(long j11) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f38246a = uuid;
            this.f38246a = uuid.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.f38246a += "_" + j11;
            this.f38248c = j11;
            this.f38247b = true;
        }

        private boolean b(long j11, long j12) {
            return j12 - j11 >= p0.this.f38243a;
        }

        public void a(long j11) {
            if (p0.this.f38244b) {
                boolean unused = p0.this.f38244b = false;
                b(j11);
            } else if (b(this.f38248c, j11) || a(this.f38248c, j11)) {
                b(j11);
            } else {
                this.f38248c = j11;
                this.f38247b = false;
            }
        }
    }

    public String a() {
        a aVar = this.f38245c;
        if (aVar != null) {
            return aVar.f38246a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    public void a(long j11) {
        a aVar = this.f38245c;
        if (aVar == null) {
            v.c("hmsSdk", "Session is first flush");
            this.f38245c = new a(j11);
            return;
        }
        aVar.a(j11);
    }

    public boolean b() {
        a aVar = this.f38245c;
        if (aVar != null) {
            return aVar.f38247b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
