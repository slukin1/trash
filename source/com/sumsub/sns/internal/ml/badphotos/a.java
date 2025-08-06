package com.sumsub.sns.internal.ml.badphotos;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.ml.core.a;
import com.sumsub.sns.internal.ml.core.e;
import com.sumsub.sns.internal.ml.core.j;
import java.util.HashMap;
import java.util.Map;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import okhttp3.OkHttpClient;

public final class a extends com.sumsub.sns.internal.ml.core.b<Bitmap, com.sumsub.sns.internal.ml.badphotos.models.a> {

    /* renamed from: p  reason: collision with root package name */
    public static final b f34946p = new b((r) null);

    /* renamed from: q  reason: collision with root package name */
    public static final int f34947q = 512;

    /* renamed from: r  reason: collision with root package name */
    public static final C0406a f34948r = new C0406a();

    /* renamed from: h  reason: collision with root package name */
    public final Context f34949h;

    /* renamed from: i  reason: collision with root package name */
    public final OkHttpClient f34950i;

    /* renamed from: j  reason: collision with root package name */
    public final String f34951j;

    /* renamed from: k  reason: collision with root package name */
    public final long f34952k;

    /* renamed from: l  reason: collision with root package name */
    public final String f34953l;

    /* renamed from: m  reason: collision with root package name */
    public final float[][][][] f34954m;

    /* renamed from: n  reason: collision with root package name */
    public final com.sumsub.sns.internal.ml.core.a f34955n;

    /* renamed from: o  reason: collision with root package name */
    public final String f34956o;

    /* renamed from: com.sumsub.sns.internal.ml.badphotos.a$a  reason: collision with other inner class name */
    public static final class C0406a implements e<Bitmap, com.sumsub.sns.internal.ml.badphotos.models.a> {
        public /* synthetic */ Object a(c cVar) {
            return j.a(this, cVar);
        }

        public Object a(Bitmap bitmap, c<? super e.a<com.sumsub.sns.internal.ml.badphotos.models.a>> cVar) {
            return new e.a.c();
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final e<Bitmap, com.sumsub.sns.internal.ml.badphotos.models.a> a(Context context, OkHttpClient okHttpClient, String str, boolean z11, DocumentType documentType) {
            try {
                c a11 = c.f34958h.a();
                if (!z11 || !a11.i().contains(documentType.c()) || Build.VERSION.SDK_INT < 26) {
                    return a.f34948r;
                }
                return new a(context, okHttpClient, str + "resources/embeddedModels/" + a11.n(), a11.j(), a11.n(), a11.h());
            } catch (Throwable th2) {
                com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, b.f34957a, "Can't create instance. Using dummy detector.", th2);
                return a.f34948r;
            }
        }

        public b() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Context context, OkHttpClient okHttpClient, String str, long j11, String str2, boolean z11, int i11, r rVar) {
        this(context, okHttpClient, str, j11, str2, (i11 & 32) != 0 ? true : z11);
    }

    public long c() {
        return this.f34952k;
    }

    public com.sumsub.sns.internal.ml.core.a e() {
        return this.f34955n;
    }

    public Map<Integer, Object> g() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, this.f34954m);
        return hashMap;
    }

    public String h() {
        return this.f34956o;
    }

    public final Context m() {
        return this.f34949h;
    }

    public final String n() {
        return this.f34953l;
    }

    public final String o() {
        return this.f34951j;
    }

    public final OkHttpClient p() {
        return this.f34950i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, OkHttpClient okHttpClient, String str, long j11, String str2, boolean z11) {
        super(b.f34957a);
        this.f34949h = context;
        OkHttpClient okHttpClient2 = okHttpClient;
        this.f34950i = okHttpClient2;
        String str3 = str;
        this.f34951j = str3;
        this.f34952k = j11;
        this.f34953l = str2;
        this.f34954m = new float[][][][]{new float[][][]{new float[][]{new float[]{0.0f}}, new float[][]{new float[]{0.0f}}}};
        this.f34955n = new a.b(context, okHttpClient2, str3, z11, b.f34957a);
        this.f34956o = "Unsatisfactory photos detector";
    }

    public Object[] a(Bitmap bitmap) {
        return new Object[]{((com.sumsub.sns.internal.ml.core.buffer.a) new com.sumsub.sns.internal.ml.core.pipeline.core.a(new com.sumsub.sns.internal.ml.core.pipeline.c(512, 512, true, false)).a(new com.sumsub.sns.internal.ml.core.pipeline.a()).a(new com.sumsub.sns.internal.ml.badphotos.pipeline.a(this.f34949h)).a(bitmap)).a()};
    }

    public com.sumsub.sns.internal.ml.badphotos.models.a a(Bitmap bitmap, long j11) {
        return new com.sumsub.sns.internal.ml.badphotos.models.a(this.f34953l, this.f34954m[0][0][0][0], j11);
    }
}
