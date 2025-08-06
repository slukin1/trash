package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.core.util.h;
import java.util.Objects;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final f f8567a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final c f8568a;

        public a(ClipData clipData, int i11) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f8568a = new C0027b(clipData, i11);
            } else {
                this.f8568a = new d(clipData, i11);
            }
        }

        public b a() {
            return this.f8568a.build();
        }

        public a b(Bundle bundle) {
            this.f8568a.setExtras(bundle);
            return this;
        }

        public a c(int i11) {
            this.f8568a.setFlags(i11);
            return this;
        }

        public a d(Uri uri) {
            this.f8568a.a(uri);
            return this;
        }
    }

    /* renamed from: androidx.core.view.b$b  reason: collision with other inner class name */
    public static final class C0027b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final ContentInfo.Builder f8569a;

        public C0027b(ClipData clipData, int i11) {
            this.f8569a = new ContentInfo.Builder(clipData, i11);
        }

        public void a(Uri uri) {
            this.f8569a.setLinkUri(uri);
        }

        public b build() {
            return new b(new e(this.f8569a.build()));
        }

        public void setExtras(Bundle bundle) {
            this.f8569a.setExtras(bundle);
        }

        public void setFlags(int i11) {
            this.f8569a.setFlags(i11);
        }
    }

    public interface c {
        void a(Uri uri);

        b build();

        void setExtras(Bundle bundle);

        void setFlags(int i11);
    }

    public static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        public ClipData f8570a;

        /* renamed from: b  reason: collision with root package name */
        public int f8571b;

        /* renamed from: c  reason: collision with root package name */
        public int f8572c;

        /* renamed from: d  reason: collision with root package name */
        public Uri f8573d;

        /* renamed from: e  reason: collision with root package name */
        public Bundle f8574e;

        public d(ClipData clipData, int i11) {
            this.f8570a = clipData;
            this.f8571b = i11;
        }

        public void a(Uri uri) {
            this.f8573d = uri;
        }

        public b build() {
            return new b(new g(this));
        }

        public void setExtras(Bundle bundle) {
            this.f8574e = bundle;
        }

        public void setFlags(int i11) {
            this.f8572c = i11;
        }
    }

    public static final class e implements f {

        /* renamed from: a  reason: collision with root package name */
        public final ContentInfo f8575a;

        public e(ContentInfo contentInfo) {
            this.f8575a = (ContentInfo) h.g(contentInfo);
        }

        public ContentInfo a() {
            return this.f8575a;
        }

        public ClipData b() {
            return this.f8575a.getClip();
        }

        public int c() {
            return this.f8575a.getSource();
        }

        public int getFlags() {
            return this.f8575a.getFlags();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f8575a + "}";
        }
    }

    public interface f {
        ContentInfo a();

        ClipData b();

        int c();

        int getFlags();
    }

    public static final class g implements f {

        /* renamed from: a  reason: collision with root package name */
        public final ClipData f8576a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8577b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8578c;

        /* renamed from: d  reason: collision with root package name */
        public final Uri f8579d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f8580e;

        public g(d dVar) {
            this.f8576a = (ClipData) h.g(dVar.f8570a);
            this.f8577b = h.c(dVar.f8571b, 0, 5, "source");
            this.f8578c = h.f(dVar.f8572c, 1);
            this.f8579d = dVar.f8573d;
            this.f8580e = dVar.f8574e;
        }

        public ContentInfo a() {
            return null;
        }

        public ClipData b() {
            return this.f8576a;
        }

        public int c() {
            return this.f8577b;
        }

        public int getFlags() {
            return this.f8578c;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.f8576a.getDescription());
            sb2.append(", source=");
            sb2.append(b.e(this.f8577b));
            sb2.append(", flags=");
            sb2.append(b.a(this.f8578c));
            String str2 = "";
            if (this.f8579d == null) {
                str = str2;
            } else {
                str = ", hasLinkUri(" + this.f8579d.toString().length() + ")";
            }
            sb2.append(str);
            if (this.f8580e != null) {
                str2 = ", hasExtras";
            }
            sb2.append(str2);
            sb2.append("}");
            return sb2.toString();
        }
    }

    public b(f fVar) {
        this.f8567a = fVar;
    }

    public static String a(int i11) {
        return (i11 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i11);
    }

    public static String e(int i11) {
        if (i11 == 0) {
            return "SOURCE_APP";
        }
        if (i11 == 1) {
            return "SOURCE_CLIPBOARD";
        }
        if (i11 == 2) {
            return "SOURCE_INPUT_METHOD";
        }
        if (i11 == 3) {
            return "SOURCE_DRAG_AND_DROP";
        }
        if (i11 != 4) {
            return i11 != 5 ? String.valueOf(i11) : "SOURCE_PROCESS_TEXT";
        }
        return "SOURCE_AUTOFILL";
    }

    public static b g(ContentInfo contentInfo) {
        return new b(new e(contentInfo));
    }

    public ClipData b() {
        return this.f8567a.b();
    }

    public int c() {
        return this.f8567a.getFlags();
    }

    public int d() {
        return this.f8567a.c();
    }

    public ContentInfo f() {
        ContentInfo a11 = this.f8567a.a();
        Objects.requireNonNull(a11);
        ContentInfo contentInfo = a11;
        return a11;
    }

    public String toString() {
        return this.f8567a.toString();
    }
}
