package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.sumsub.sns.internal.fingerprint.tools.threading.safe.c;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34587a;

    public static final class a extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f34588a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar) {
            super(0);
            this.f34588a = bVar;
        }

        /* renamed from: a */
        public final String invoke() {
            int intExtra;
            Intent registerReceiver = this.f34588a.f34587a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null || (intExtra = registerReceiver.getIntExtra("health", -1)) == -1) {
                return "";
            }
            return this.f34588a.a(intExtra);
        }
    }

    /* renamed from: com.sumsub.sns.internal.fingerprint.infoproviders.b$b  reason: collision with other inner class name */
    public static final class C0392b extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f34589a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0392b(b bVar) {
            super(0);
            this.f34589a = bVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return String.valueOf(((Double) Class.forName(c.f34590a).getMethod(c.f34591b, new Class[0]).invoke(Class.forName(c.f34590a).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f34589a.f34587a}), new Object[0])).doubleValue());
        }
    }

    public b(Context context) {
        this.f34587a = context;
    }

    public final String a(int i11) {
        switch (i11) {
            case 2:
                return "good";
            case 3:
                return "overheat";
            case 4:
                return "dead";
            case 5:
                return "over voltage";
            case 6:
                return "unspecified failure";
            case 7:
                return "cold";
            default:
                return "unknown";
        }
    }

    @SuppressLint({"PrivateApi"})
    public String b() {
        Object a11 = c.a(0, new C0392b(this), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public String a() {
        Object a11 = c.a(0, new a(this), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }
}
