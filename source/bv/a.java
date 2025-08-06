package bv;

import bv.g;
import com.google.common.net.HttpHeaders;
import com.huobi.woodpecker.kalle.Headers;
import com.huobi.woodpecker.kalle.Kalle;
import com.huobi.woodpecker.kalle.Response;
import com.huobi.woodpecker.kalle.exception.NoCacheError;
import com.huobi.woodpecker.kalle.exception.ParseError;
import com.huobi.woodpecker.kalle.simple.cache.Cache;
import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.Callable;

public abstract class a<T extends g, Succeed, Failed> implements Callable<h<Succeed, Failed>> {

    /* renamed from: g  reason: collision with root package name */
    public static final long f19374g = (System.currentTimeMillis() + 3153600000000L);

    /* renamed from: b  reason: collision with root package name */
    public final T f19375b;

    /* renamed from: c  reason: collision with root package name */
    public final cv.a f19376c = Kalle.b().a();

    /* renamed from: d  reason: collision with root package name */
    public final d f19377d;

    /* renamed from: e  reason: collision with root package name */
    public final Type f19378e;

    /* renamed from: f  reason: collision with root package name */
    public final Type f19379f;

    /* renamed from: bv.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0135a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19380a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.woodpecker.kalle.simple.cache.CacheMode[] r0 = com.huobi.woodpecker.kalle.simple.cache.CacheMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19380a = r0
                com.huobi.woodpecker.kalle.simple.cache.CacheMode r1 = com.huobi.woodpecker.kalle.simple.cache.CacheMode.HTTP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19380a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.woodpecker.kalle.simple.cache.CacheMode r1 = com.huobi.woodpecker.kalle.simple.cache.CacheMode.HTTP_YES_THEN_WRITE_CACHE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19380a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.woodpecker.kalle.simple.cache.CacheMode r1 = com.huobi.woodpecker.kalle.simple.cache.CacheMode.NETWORK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19380a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.woodpecker.kalle.simple.cache.CacheMode r1 = com.huobi.woodpecker.kalle.simple.cache.CacheMode.NETWORK_YES_THEN_HTTP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f19380a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.woodpecker.kalle.simple.cache.CacheMode r1 = com.huobi.woodpecker.kalle.simple.cache.CacheMode.NETWORK_YES_THEN_WRITE_CACHE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f19380a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.woodpecker.kalle.simple.cache.CacheMode r1 = com.huobi.woodpecker.kalle.simple.cache.CacheMode.NETWORK_NO_THEN_READ_CACHE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f19380a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.woodpecker.kalle.simple.cache.CacheMode r1 = com.huobi.woodpecker.kalle.simple.cache.CacheMode.READ_CACHE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f19380a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huobi.woodpecker.kalle.simple.cache.CacheMode r1 = com.huobi.woodpecker.kalle.simple.cache.CacheMode.READ_CACHE_NO_THEN_NETWORK     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f19380a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.huobi.woodpecker.kalle.simple.cache.CacheMode r1 = com.huobi.woodpecker.kalle.simple.cache.CacheMode.READ_CACHE_NO_THEN_HTTP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bv.a.C0135a.<clinit>():void");
        }
    }

    public a(T t11, Type type, Type type2) {
        this.f19375b = t11;
        this.f19378e = type;
        this.f19379f = type2;
        this.f19377d = t11.converter() == null ? Kalle.b().e() : t11.converter();
    }

    public final void a(Headers headers) {
        Headers c11 = this.f19375b.c();
        String w11 = headers.w();
        if (w11 != null) {
            c11.H(HttpHeaders.IF_NONE_MATCH, w11);
        }
        long A = headers.A();
        if (A > 0) {
            c11.H(HttpHeaders.IF_MODIFIED_SINCE, Headers.o(A));
        }
    }

    public final Response b(int i11, Headers headers, byte[] bArr) {
        return Response.g().f(i11).g(headers).d(new c(headers.t(), bArr)).e();
    }

    public final h<Succeed, Failed> c(Response response, boolean z11) throws IOException {
        try {
            return this.f19377d.a(this.f19378e, this.f19379f, response, z11);
        } catch (IOException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new ParseError("An exception occurred while parsing the data.", e12);
        }
    }

    /* renamed from: d */
    public final h<Succeed, Failed> call() throws Exception {
        Response j11 = j();
        if (j11 != null) {
            return c(j11, true);
        }
        g();
        try {
            j11 = f(this.f19375b);
            int b11 = j11.b();
            if (b11 == 304) {
                Response i11 = i(-1);
                if (i11 != null) {
                    return c(i11, true);
                }
                h<Succeed, Failed> c11 = c(j11, false);
                IOUtils.a(j11);
                return c11;
            }
            Headers e11 = j11.e();
            byte[] bArr = new byte[0];
            if (b11 != 204) {
                bArr = j11.a().byteArray();
            }
            IOUtils.a(j11);
            h(b11, e11, bArr);
            Response b12 = b(b11, e11, bArr);
            h<Succeed, Failed> c12 = c(b12, false);
            IOUtils.a(b12);
            return c12;
        } catch (IOException e12) {
            Response i12 = i(-1);
            if (i12 != null) {
                return c(i12, true);
            }
            throw e12;
        } finally {
            IOUtils.a(j11);
        }
    }

    public final void e(int i11, Headers headers, byte[] bArr, long j11) {
        String b11 = this.f19375b.b();
        Cache cache = new Cache();
        cache.setKey(b11);
        cache.setCode(i11);
        cache.setHeaders(headers);
        cache.setBody(bArr);
        cache.setExpires(j11);
        this.f19376c.a(b11, cache);
    }

    public abstract Response f(T t11) throws IOException;

    public final void g() {
        Cache cache;
        int i11 = C0135a.f19380a[this.f19375b.a().ordinal()];
        if ((i11 == 1 || i11 == 2) && (cache = this.f19376c.get(this.f19375b.b())) != null) {
            a(cache.getHeaders());
        }
    }

    public final void h(int i11, Headers headers, byte[] bArr) {
        int i12 = C0135a.f19380a[this.f19375b.a().ordinal()];
        if (i12 == 1) {
            long l11 = Headers.l(headers);
            if (l11 > 0 || headers.A() > 0) {
                e(i11, headers, bArr, l11);
            }
        } else if (i12 == 2) {
            e(i11, headers, bArr, f19374g);
        } else if (i12 == 4) {
            long l12 = Headers.l(headers);
            if (l12 > 0 || headers.A() > 0) {
                e(i11, headers, bArr, l12);
            }
        } else if (i12 == 5 || i12 == 6) {
            e(i11, headers, bArr, f19374g);
        } else if (i12 == 9) {
            long l13 = Headers.l(headers);
            if (l13 > 0 || headers.A() > 0) {
                e(i11, headers, bArr, l13);
            }
        }
    }

    public final Response i(int i11) {
        Cache cache;
        Cache cache2;
        int i12 = C0135a.f19380a[this.f19375b.a().ordinal()];
        if (i12 == 1 || i12 == 2) {
            if (i11 != 304 || (cache = this.f19376c.get(this.f19375b.b())) == null) {
                return null;
            }
            return b(cache.getCode(), cache.getHeaders(), cache.getBody());
        } else if (i12 == 6) {
            Cache cache3 = this.f19376c.get(this.f19375b.b());
            if (cache3 != null) {
                return b(cache3.getCode(), cache3.getHeaders(), cache3.getBody());
            }
            return null;
        } else if (i12 == 9 && i11 == 304 && (cache2 = this.f19376c.get(this.f19375b.b())) != null) {
            return b(cache2.getCode(), cache2.getHeaders(), cache2.getBody());
        } else {
            return null;
        }
    }

    public final Response j() throws NoCacheError {
        Cache cache;
        int i11 = C0135a.f19380a[this.f19375b.a().ordinal()];
        if (i11 == 1) {
            Cache cache2 = this.f19376c.get(this.f19375b.b());
            if (cache2 != null && cache2.getExpires() > System.currentTimeMillis()) {
                return b(cache2.getCode(), cache2.getHeaders(), cache2.getBody());
            }
        } else if (i11 == 7) {
            Cache cache3 = this.f19376c.get(this.f19375b.b());
            if (cache3 != null) {
                return b(cache3.getCode(), cache3.getHeaders(), cache3.getBody());
            }
            throw new NoCacheError("No cache found.");
        } else if ((i11 == 8 || i11 == 9) && (cache = this.f19376c.get(this.f19375b.b())) != null) {
            return b(cache.getCode(), cache.getHeaders(), cache.getBody());
        }
        return null;
    }
}
