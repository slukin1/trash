package zendesk.belvedere;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import f30.d;
import f30.e;
import f30.g;
import f30.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import zendesk.belvedere.MediaIntent;
import zendesk.belvedere.h;

public class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static a f62261e;

    /* renamed from: a  reason: collision with root package name */
    public final Context f62262a;

    /* renamed from: b  reason: collision with root package name */
    public h f62263b;

    /* renamed from: c  reason: collision with root package name */
    public d f62264c = new d();

    /* renamed from: d  reason: collision with root package name */
    public e f62265d;

    /* renamed from: zendesk.belvedere.a$a  reason: collision with other inner class name */
    public static class C0681a {

        /* renamed from: a  reason: collision with root package name */
        public Context f62266a;

        /* renamed from: b  reason: collision with root package name */
        public h.b f62267b = new h.a();

        /* renamed from: c  reason: collision with root package name */
        public boolean f62268c = false;

        public C0681a(Context context) {
            this.f62266a = context.getApplicationContext();
        }

        public a a() {
            return new a(this);
        }
    }

    public a(C0681a aVar) {
        Context context = aVar.f62266a;
        this.f62262a = context;
        aVar.f62267b.a(aVar.f62268c);
        h.d(aVar.f62267b);
        f30.h hVar = new f30.h();
        this.f62263b = hVar;
        this.f62265d = new e(context, hVar, this.f62264c);
        h.a("Belvedere", "Belvedere initialized");
    }

    public static a c(Context context) {
        synchronized (a.class) {
            if (f62261e == null) {
                if (context == null || context.getApplicationContext() == null) {
                    throw new IllegalArgumentException("Invalid context provided");
                }
                f62261e = new C0681a(context.getApplicationContext()).a();
            }
        }
        return f62261e;
    }

    public MediaIntent.b a() {
        return new MediaIntent.b(this.f62264c.d(), this.f62265d, this.f62264c);
    }

    public MediaIntent.c b() {
        return new MediaIntent.c(this.f62264c.d(), this.f62265d);
    }

    public MediaResult d(String str, String str2) {
        Uri i11;
        long j11;
        long j12;
        File d11 = this.f62263b.d(this.f62262a, str, str2);
        h.a("Belvedere", String.format(Locale.US, "Get internal File: %s", new Object[]{d11}));
        if (d11 == null || (i11 = this.f62263b.i(this.f62262a, d11)) == null) {
            return null;
        }
        MediaResult j13 = f30.h.j(this.f62262a, i11);
        if (j13.getMimeType().contains("image")) {
            Pair<Integer, Integer> a11 = BitmapUtils.a(d11);
            j11 = (long) ((Integer) a11.second).intValue();
            j12 = (long) ((Integer) a11.first).intValue();
        } else {
            j12 = -1;
            j11 = -1;
        }
        return new MediaResult(d11, i11, i11, str2, j13.getMimeType(), j13.getSize(), j12, j11);
    }

    public void e(int i11, int i12, Intent intent, Callback<List<MediaResult>> callback, boolean z11) {
        this.f62265d.e(this.f62262a, i11, i12, intent, callback, z11);
    }

    public Intent f(Uri uri, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(str)) {
            intent.setDataAndType(uri, str);
        }
        g(intent, uri);
        return intent;
    }

    public void g(Intent intent, Uri uri) {
        h.a("Belvedere", String.format(Locale.US, "Grant Permission - Intent: %s - Uri: %s", new Object[]{intent, uri}));
        this.f62263b.l(this.f62262a, intent, uri, 3);
    }

    public void h(List<Uri> list, String str, Callback<List<MediaResult>> callback) {
        if (list == null || list.size() <= 0) {
            callback.internalSuccess(new ArrayList(0));
        } else {
            g.d(this.f62262a, this.f62263b, callback, list, str);
        }
    }
}
