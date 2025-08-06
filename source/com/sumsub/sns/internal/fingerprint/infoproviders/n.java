package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.media.RingtoneManager;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class n implements m {

    /* renamed from: a  reason: collision with root package name */
    public final RingtoneManager f34628a;

    /* renamed from: b  reason: collision with root package name */
    public final AssetManager f34629b;

    /* renamed from: c  reason: collision with root package name */
    public final Configuration f34630c;

    public static final class a extends Lambda implements d10.a<String[]> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f34631a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(n nVar) {
            super(0);
            this.f34631a = nVar;
        }

        /* renamed from: a */
        public final String[] invoke() {
            String[] locales;
            AssetManager a11 = this.f34631a.f34629b;
            if (!(a11 == null || (locales = a11.getLocales()) == null)) {
                ArrayList arrayList = new ArrayList(locales.length);
                for (String valueOf : locales) {
                    arrayList.add(String.valueOf(valueOf));
                }
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                if (strArr != null) {
                    return strArr;
                }
            }
            return new String[0];
        }
    }

    public static final class b extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f34632a = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return Locale.getDefault().getLanguage();
        }
    }

    public static final class c extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f34633a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(n nVar) {
            super(0);
            this.f34633a = nVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r0.locale;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String invoke() {
            /*
                r1 = this;
                com.sumsub.sns.internal.fingerprint.infoproviders.n r0 = r1.f34633a
                android.content.res.Configuration r0 = r0.f34630c
                if (r0 == 0) goto L_0x0011
                java.util.Locale r0 = r0.locale
                if (r0 == 0) goto L_0x0011
                java.lang.String r0 = r0.getCountry()
                goto L_0x0012
            L_0x0011:
                r0 = 0
            L_0x0012:
                if (r0 != 0) goto L_0x0016
                java.lang.String r0 = ""
            L_0x0016:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.fingerprint.infoproviders.n.c.invoke():java.lang.String");
        }
    }

    public static final class d extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f34634a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(n nVar) {
            super(0);
            this.f34634a = nVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
            r0 = (r0 = r0.getRingtoneUri(0)).toString();
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String invoke() {
            /*
                r2 = this;
                com.sumsub.sns.internal.fingerprint.infoproviders.n r0 = r2.f34634a
                android.media.RingtoneManager r0 = r0.f34628a
                if (r0 == 0) goto L_0x0015
                r1 = 0
                android.net.Uri r0 = r0.getRingtoneUri(r1)
                if (r0 == 0) goto L_0x0015
                java.lang.String r0 = r0.toString()
                if (r0 != 0) goto L_0x0017
            L_0x0015:
                java.lang.String r0 = ""
            L_0x0017:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.fingerprint.infoproviders.n.d.invoke():java.lang.String");
        }
    }

    public static final class e extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f34635a = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return TimeZone.getDefault().getDisplayName();
        }
    }

    public n(RingtoneManager ringtoneManager, AssetManager assetManager, Configuration configuration) {
        this.f34628a = ringtoneManager;
        this.f34629b = assetManager;
        this.f34630c = configuration;
    }

    public String[] d() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new a(this), 1, (Object) null);
        String[] strArr = new String[0];
        if (Result.m3078isFailureimpl(a11)) {
            a11 = strArr;
        }
        return (String[]) a11;
    }

    public String e() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, b.f34632a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public String a() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, e.f34635a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public String b() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new c(this), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public String c() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new d(this), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }
}
