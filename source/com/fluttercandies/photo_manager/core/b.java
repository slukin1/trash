package com.fluttercandies.photo_manager.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.fluttercandies.photo_manager.core.entity.FilterOption;
import com.fluttercandies.photo_manager.core.entity.d;
import com.fluttercandies.photo_manager.core.entity.f;
import com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils;
import com.fluttercandies.photo_manager.core.utils.DBUtils;
import com.fluttercandies.photo_manager.core.utils.IDBUtils;
import com.huobi.vulcan.model.VulcanInfo;
import com.jumio.sdk.reject.JumioRejectReason;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.l;
import z4.e;

public final class b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f65033d = new a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final ExecutorService f65034e = Executors.newFixedThreadPool(5);

    /* renamed from: a  reason: collision with root package name */
    public final Context f65035a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65036b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<com.bumptech.glide.request.b<Bitmap>> f65037c = new ArrayList<>();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public b(Context context) {
        this.f65035a = context;
    }

    public static final void v(com.bumptech.glide.request.b bVar) {
        if (!bVar.isCancelled()) {
            bVar.get();
        }
    }

    public final void b(String str, e eVar) {
        eVar.h(Boolean.valueOf(j().t(this.f65035a, str)));
    }

    public final void c() {
        List<com.bumptech.glide.request.b> I0 = CollectionsKt___CollectionsKt.I0(this.f65037c);
        this.f65037c.clear();
        for (com.bumptech.glide.request.b g11 : I0) {
            com.bumptech.glide.a.v(this.f65035a).g(g11);
        }
    }

    public final void d() {
        j().b();
    }

    public final void e() {
        y4.a.f66718a.a(this.f65035a);
        j().f(this.f65035a);
    }

    public final void f(String str, String str2, e eVar) {
        try {
            com.fluttercandies.photo_manager.core.entity.b d11 = j().d(this.f65035a, str, str2);
            if (d11 == null) {
                eVar.h((Object) null);
            } else {
                eVar.h(com.fluttercandies.photo_manager.core.utils.b.f65118a.c(d11));
            }
        } catch (Exception e11) {
            z4.a.b(e11);
            eVar.h((Object) null);
        }
    }

    public final List<com.fluttercandies.photo_manager.core.entity.b> g(String str, int i11, int i12, int i13, FilterOption filterOption) {
        if (x.b(str, "isAll")) {
            str = "";
        }
        return j().q(this.f65035a, str, i12, i13, i11, filterOption);
    }

    public final List<com.fluttercandies.photo_manager.core.entity.b> h(String str, int i11, int i12, int i13, FilterOption filterOption) {
        if (x.b(str, "isAll")) {
            str = "";
        }
        return j().l(this.f65035a, str, i12, i13, i11, filterOption);
    }

    public final com.fluttercandies.photo_manager.core.entity.b i(String str) {
        return j().w(this.f65035a, str);
    }

    public final IDBUtils j() {
        if (this.f65036b || Build.VERSION.SDK_INT < 29) {
            return DBUtils.f65105b;
        }
        return AndroidQDBUtils.f65102b;
    }

    public final void k(String str, boolean z11, e eVar) {
        eVar.h(j().v(this.f65035a, str, z11));
    }

    public final List<d> l(int i11, boolean z11, boolean z12, FilterOption filterOption) {
        if (z12) {
            return j().r(this.f65035a, i11, filterOption);
        }
        List<d> m11 = j().m(this.f65035a, i11, filterOption);
        if (!z11) {
            return m11;
        }
        int i12 = 0;
        for (d b11 : m11) {
            i12 += b11.b();
        }
        return CollectionsKt___CollectionsKt.q0(CollectionsKt__CollectionsJVMKt.e(new d("isAll", "Recent", i12, i11, true, (Long) null, 32, (r) null)), m11);
    }

    public final Map<String, Double> m(String str) {
        m1.a y11 = j().y(this.f65035a, str);
        double[] m11 = y11 != null ? y11.m() : null;
        if (m11 == null) {
            return MapsKt__MapsKt.l(l.a(VulcanInfo.LAT, Double.valueOf(0.0d)), l.a(VulcanInfo.LNG, Double.valueOf(0.0d)));
        }
        return MapsKt__MapsKt.l(l.a(VulcanInfo.LAT, Double.valueOf(m11[0])), l.a(VulcanInfo.LNG, Double.valueOf(m11[1])));
    }

    public final String n(String str, int i11) {
        return j().i(this.f65035a, str, i11);
    }

    public final void o(String str, e eVar) {
        com.fluttercandies.photo_manager.core.entity.b w11 = j().w(this.f65035a, str);
        if (w11 == null) {
            e.k(eVar, "The asset not found", (String) null, (Object) null, 6, (Object) null);
            return;
        }
        try {
            eVar.h(FilesKt__FileReadWriteKt.a(new File(w11.k())));
        } catch (Exception e11) {
            j().h(this.f65035a, str);
            eVar.j("202", "get origin Bytes error", e11);
        }
    }

    public final d p(String str, int i11, FilterOption filterOption) {
        if (x.b(str, "isAll")) {
            List<d> m11 = j().m(this.f65035a, i11, filterOption);
            if (m11.isEmpty()) {
                return null;
            }
            int i12 = 0;
            for (d b11 : m11) {
                i12 += b11.b();
            }
            d dVar = new d("isAll", "Recent", i12, i11, true, (Long) null, 32, (r) null);
            if (!filterOption.b()) {
                return dVar;
            }
            j().g(this.f65035a, dVar);
            return dVar;
        }
        d x11 = j().x(this.f65035a, str, i11, filterOption);
        if (x11 != null && filterOption.b()) {
            j().g(this.f65035a, x11);
        }
        return x11;
    }

    public final void q(String str, f fVar, e eVar) {
        String str2 = str;
        int e11 = fVar.e();
        int c11 = fVar.c();
        int d11 = fVar.d();
        Bitmap.CompressFormat a11 = fVar.a();
        long b11 = fVar.b();
        try {
            com.fluttercandies.photo_manager.core.entity.b w11 = j().w(this.f65035a, str2);
            if (w11 == null) {
                e.k(eVar, "The asset not found!", (String) null, (Object) null, 6, (Object) null);
            } else {
                y4.a.f66718a.b(this.f65035a, w11.k(), fVar.e(), fVar.c(), a11, d11, b11, eVar.e());
            }
        } catch (Exception e12) {
            Log.e("PhotoManager", "get " + str2 + " thumb error, width : " + e11 + ", height: " + c11, e12);
            j().h(this.f65035a, str2);
            eVar.j(JumioRejectReason.NO_DOC, "get thumb error", e12);
        }
    }

    public final Uri r(String str) {
        com.fluttercandies.photo_manager.core.entity.b w11 = j().w(this.f65035a, str);
        if (w11 != null) {
            return w11.n();
        }
        return null;
    }

    public final void s(String str, String str2, e eVar) {
        try {
            com.fluttercandies.photo_manager.core.entity.b z11 = j().z(this.f65035a, str, str2);
            if (z11 == null) {
                eVar.h((Object) null);
            } else {
                eVar.h(com.fluttercandies.photo_manager.core.utils.b.f65118a.c(z11));
            }
        } catch (Exception e11) {
            z4.a.b(e11);
            eVar.h((Object) null);
        }
    }

    public final void t(e eVar) {
        eVar.h(Boolean.valueOf(j().a(this.f65035a)));
    }

    public final void u(List<String> list, f fVar, e eVar) {
        for (String c11 : j().c(this.f65035a, list)) {
            this.f65037c.add(y4.a.f66718a.c(this.f65035a, c11, fVar));
        }
        eVar.h(1);
        for (com.bumptech.glide.request.b aVar : CollectionsKt___CollectionsKt.I0(this.f65037c)) {
            f65034e.execute(new a(aVar));
        }
    }

    public final com.fluttercandies.photo_manager.core.entity.b w(String str, String str2, String str3, String str4) {
        return j().p(this.f65035a, str, str2, str3, str4);
    }

    public final com.fluttercandies.photo_manager.core.entity.b x(byte[] bArr, String str, String str2, String str3) {
        return j().o(this.f65035a, bArr, str, str2, str3);
    }

    public final com.fluttercandies.photo_manager.core.entity.b y(String str, String str2, String str3, String str4) {
        if (!new File(str).exists()) {
            return null;
        }
        return j().k(this.f65035a, str, str2, str3, str4);
    }

    public final void z(boolean z11) {
        this.f65036b = z11;
    }
}
