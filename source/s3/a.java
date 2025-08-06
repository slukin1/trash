package s3;

import android.net.Uri;
import android.text.TextUtils;
import f4.h;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import n3.b;

public class a implements b {

    /* renamed from: b  reason: collision with root package name */
    public final com.bumptech.glide.load.model.b f66599b;

    /* renamed from: c  reason: collision with root package name */
    public final URL f66600c;

    /* renamed from: d  reason: collision with root package name */
    public final String f66601d;

    /* renamed from: e  reason: collision with root package name */
    public String f66602e;

    /* renamed from: f  reason: collision with root package name */
    public URL f66603f;

    /* renamed from: g  reason: collision with root package name */
    public volatile byte[] f66604g;

    /* renamed from: h  reason: collision with root package name */
    public int f66605h;

    public a(URL url) {
        this(url, com.bumptech.glide.load.model.b.f63987b);
    }

    public String a() {
        String str = this.f66601d;
        return str != null ? str : ((URL) h.d(this.f66600c)).toString();
    }

    public final byte[] b() {
        if (this.f66604g == null) {
            this.f66604g = a().getBytes(b.f66506a);
        }
        return this.f66604g;
    }

    public Map<String, String> c() {
        return this.f66599b.getHeaders();
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f66602e)) {
            String str = this.f66601d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) h.d(this.f66600c)).toString();
            }
            this.f66602e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f66602e;
    }

    public final URL e() throws MalformedURLException {
        if (this.f66603f == null) {
            this.f66603f = new URL(d());
        }
        return this.f66603f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!a().equals(aVar.a()) || !this.f66599b.equals(aVar.f66599b)) {
            return false;
        }
        return true;
    }

    public String f() {
        return d();
    }

    public URL g() throws MalformedURLException {
        return e();
    }

    public int hashCode() {
        if (this.f66605h == 0) {
            int hashCode = a().hashCode();
            this.f66605h = hashCode;
            this.f66605h = (hashCode * 31) + this.f66599b.hashCode();
        }
        return this.f66605h;
    }

    public String toString() {
        return a();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(b());
    }

    public a(String str) {
        this(str, com.bumptech.glide.load.model.b.f63987b);
    }

    public a(URL url, com.bumptech.glide.load.model.b bVar) {
        this.f66600c = (URL) h.d(url);
        this.f66601d = null;
        this.f66599b = (com.bumptech.glide.load.model.b) h.d(bVar);
    }

    public a(String str, com.bumptech.glide.load.model.b bVar) {
        this.f66600c = null;
        this.f66601d = h.b(str);
        this.f66599b = (com.bumptech.glide.load.model.b) h.d(bVar);
    }
}
