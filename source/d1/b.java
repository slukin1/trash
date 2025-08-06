package d1;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final c f15615a;

    /* renamed from: d1.b$b  reason: collision with other inner class name */
    public static final class C0075b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f15617a;

        /* renamed from: b  reason: collision with root package name */
        public final ClipDescription f15618b;

        /* renamed from: c  reason: collision with root package name */
        public final Uri f15619c;

        public C0075b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f15617a = uri;
            this.f15618b = clipDescription;
            this.f15619c = uri2;
        }

        public Object a() {
            return null;
        }

        public Uri b() {
            return this.f15617a;
        }

        public void c() {
        }

        public Uri d() {
            return this.f15619c;
        }

        public ClipDescription getDescription() {
            return this.f15618b;
        }
    }

    public interface c {
        Object a();

        Uri b();

        void c();

        Uri d();

        ClipDescription getDescription();
    }

    public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f15615a = new a(uri, clipDescription, uri2);
        } else {
            this.f15615a = new C0075b(uri, clipDescription, uri2);
        }
    }

    public static b f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new b(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f15615a.b();
    }

    public ClipDescription b() {
        return this.f15615a.getDescription();
    }

    public Uri c() {
        return this.f15615a.d();
    }

    public void d() {
        this.f15615a.c();
    }

    public Object e() {
        return this.f15615a.a();
    }

    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final InputContentInfo f15616a;

        public a(Object obj) {
            this.f15616a = (InputContentInfo) obj;
        }

        public Object a() {
            return this.f15616a;
        }

        public Uri b() {
            return this.f15616a.getContentUri();
        }

        public void c() {
            this.f15616a.requestPermission();
        }

        public Uri d() {
            return this.f15616a.getLinkUri();
        }

        public ClipDescription getDescription() {
            return this.f15616a.getDescription();
        }

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f15616a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public b(c cVar) {
        this.f15615a = cVar;
    }
}
