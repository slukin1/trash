package com.sumsub.sns.core.presentation.util;

import android.os.Bundle;
import java.util.UUID;
import kotlin.jvm.internal.r;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0299a f31204b = new C0299a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final String f31205c = "fragment_unique_id";

    /* renamed from: a  reason: collision with root package name */
    public String f31206a;

    /* renamed from: com.sumsub.sns.core.presentation.util.a$a  reason: collision with other inner class name */
    public static final class C0299a {
        public /* synthetic */ C0299a(r rVar) {
            this();
        }

        public C0299a() {
        }
    }

    public final String a() {
        String str = this.f31206a;
        if (str == null) {
            return null;
        }
        return str;
    }

    public final void b(Bundle bundle) {
        String str = this.f31206a;
        if (str == null) {
            str = null;
        }
        bundle.putString(f31205c, str);
    }

    public final void a(Bundle bundle) {
        String str;
        if (bundle != null) {
            str = bundle.getString(f31205c, "");
        } else {
            str = UUID.randomUUID().toString();
        }
        this.f31206a = str;
    }
}
