package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.r;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f10383a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10384b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10385c;

    public static final class a {

        /* renamed from: d  reason: collision with root package name */
        public static final C0050a f10386d = new C0050a((r) null);

        /* renamed from: a  reason: collision with root package name */
        public Uri f10387a;

        /* renamed from: b  reason: collision with root package name */
        public String f10388b;

        /* renamed from: c  reason: collision with root package name */
        public String f10389c;

        /* renamed from: androidx.navigation.e$a$a  reason: collision with other inner class name */
        public static final class C0050a {
            public C0050a() {
            }

            public /* synthetic */ C0050a(r rVar) {
                this();
            }

            public final a a(Uri uri) {
                a aVar = new a((r) null);
                aVar.b(uri);
                return aVar;
            }
        }

        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final e a() {
            return new e(this.f10387a, this.f10388b, this.f10389c);
        }

        public final a b(Uri uri) {
            this.f10387a = uri;
            return this;
        }
    }

    public e(Uri uri, String str, String str2) {
        this.f10383a = uri;
        this.f10384b = str;
        this.f10385c = str2;
    }

    public String a() {
        return this.f10384b;
    }

    public String b() {
        return this.f10385c;
    }

    public Uri c() {
        return this.f10383a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NavDeepLinkRequest");
        sb2.append("{");
        if (c() != null) {
            sb2.append(" uri=");
            sb2.append(String.valueOf(c()));
        }
        if (a() != null) {
            sb2.append(" action=");
            sb2.append(a());
        }
        if (b() != null) {
            sb2.append(" mimetype=");
            sb2.append(b());
        }
        sb2.append(" }");
        return sb2.toString();
    }

    public e(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
    }
}
