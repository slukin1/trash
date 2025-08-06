package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.app.KeyguardManager;
import android.app.admin.DevicePolicyManager;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class p implements o {

    /* renamed from: a  reason: collision with root package name */
    public final DevicePolicyManager f34636a;

    /* renamed from: b  reason: collision with root package name */
    public final KeyguardManager f34637b;

    public static final class a extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f34638a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p pVar) {
            super(0);
            this.f34638a = pVar;
        }

        /* renamed from: a */
        public final String invoke() {
            DevicePolicyManager a11 = this.f34638a.f34636a;
            return q.b(a11 != null ? a11.getStorageEncryptionStatus() : 0);
        }
    }

    public static final class b extends Lambda implements d10.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f34639a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(p pVar) {
            super(0);
            this.f34639a = pVar;
        }

        /* renamed from: a */
        public final Boolean invoke() {
            KeyguardManager b11 = this.f34639a.f34637b;
            return Boolean.valueOf(b11 != null ? b11.isKeyguardSecure() : false);
        }
    }

    public static final class c extends Lambda implements d10.a<List<? extends Pair<? extends String, ? extends String>>> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f34640a = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final List<Pair<String, String>> invoke() {
            Provider[] providers = Security.getProviders();
            ArrayList arrayList = new ArrayList(providers.length);
            int length = providers.length;
            for (int i11 = 0; i11 < length; i11++) {
                Provider provider = providers[i11];
                String name = provider != null ? provider.getName() : null;
                String str = "";
                if (name == null) {
                    name = str;
                }
                String info = provider.getInfo();
                if (info != null) {
                    str = info;
                }
                arrayList.add(new Pair(name, str));
            }
            return arrayList;
        }
    }

    public p(DevicePolicyManager devicePolicyManager, KeyguardManager keyguardManager) {
        this.f34636a = devicePolicyManager;
        this.f34637b = keyguardManager;
    }

    public boolean c() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new b(this), 1, (Object) null);
        Boolean bool = Boolean.FALSE;
        if (Result.m3078isFailureimpl(a11)) {
            a11 = bool;
        }
        return ((Boolean) a11).booleanValue();
    }

    public List<Pair<String, String>> a() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, c.f34640a, 1, (Object) null);
        List k11 = CollectionsKt__CollectionsKt.k();
        if (Result.m3078isFailureimpl(a11)) {
            a11 = k11;
        }
        return (List) a11;
    }

    public String b() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new a(this), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }
}
