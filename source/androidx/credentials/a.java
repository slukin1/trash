package androidx.credentials;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import kotlin.jvm.internal.r;

public abstract class a {

    /* renamed from: h  reason: collision with root package name */
    public static final C0030a f8754h = new C0030a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f8755a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f8756b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f8757c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f8758d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f8759e;

    /* renamed from: f  reason: collision with root package name */
    public final b f8760f;

    /* renamed from: g  reason: collision with root package name */
    public final String f8761g;

    /* renamed from: androidx.credentials.a$a  reason: collision with other inner class name */
    public static final class C0030a {
        public C0030a() {
        }

        public /* synthetic */ C0030a(r rVar) {
            this();
        }
    }

    public a(String str, Bundle bundle, Bundle bundle2, boolean z11, boolean z12, b bVar, String str2) {
        this.f8755a = str;
        this.f8756b = bundle;
        this.f8757c = bundle2;
        this.f8758d = z11;
        this.f8759e = z12;
        this.f8760f = bVar;
        this.f8761g = str2;
        if (a() != null) {
            a().putBoolean(i.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED, b());
        }
    }

    public Bundle a() {
        return this.f8756b;
    }

    public boolean b() {
        return this.f8759e;
    }

    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        public static final C0031a f8762e = new C0031a((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f8763a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f8764b;

        /* renamed from: c  reason: collision with root package name */
        public final Icon f8765c;

        /* renamed from: d  reason: collision with root package name */
        public final String f8766d;

        /* renamed from: androidx.credentials.a$b$a  reason: collision with other inner class name */
        public static final class C0031a {
            public C0031a() {
            }

            public /* synthetic */ C0031a(r rVar) {
                this();
            }
        }

        public b(CharSequence charSequence, CharSequence charSequence2, Icon icon, String str) {
            this.f8763a = charSequence;
            this.f8764b = charSequence2;
            this.f8765c = icon;
            this.f8766d = str;
            if (!(charSequence.length() > 0)) {
                throw new IllegalArgumentException("userId should not be empty".toString());
            }
        }

        public b(CharSequence charSequence, CharSequence charSequence2) {
            this(charSequence, charSequence2, (Icon) null, (String) null);
        }
    }
}
