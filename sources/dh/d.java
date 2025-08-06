package dh;

import bh.u;
import com.hbg.lib.core.util.CollectionsUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class d {

    /* renamed from: b  reason: collision with root package name */
    public static OkHttpClient f47467b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f47468c;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<t8.a>> f47469a = new HashMap();

    public class a implements t8.a {
        public a() {
        }

        public void a(HttpUrl httpUrl, long j11, long j12, boolean z11) {
            if (!CollectionsUtils.c(d.this.f47469a)) {
                List list = (List) d.this.f47469a.get(httpUrl.url().toString());
                if (!CollectionsUtils.b(list)) {
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        ((t8.a) list.get(i11)).a(httpUrl, j11, j12, z11);
                    }
                }
            }
        }

        public void b(HttpUrl httpUrl, IOException iOException) {
            b(httpUrl, iOException);
        }
    }

    public class b implements Interceptor {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t8.a f47471a;

        public b(t8.a aVar) {
            this.f47471a = aVar;
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new t8.b(chain.request().url(), proceed.body(), this.f47471a)).build();
        }
    }

    public class c implements Callback {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47473b;

        public c(String str) {
            this.f47473b = str;
        }

        public void onFailure(Call call, IOException iOException) {
            d.this.e(call.request().url(), iOException);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0047  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResponse(okhttp3.Call r5, okhttp3.Response r6) throws java.io.IOException {
            /*
                r4 = this;
                r5 = 0
                okhttp3.ResponseBody r0 = r6.body()     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x0010
                okhttp3.ResponseBody r6 = r6.body()     // Catch:{ all -> 0x003d }
                java.io.InputStream r6 = r6.byteStream()     // Catch:{ all -> 0x003d }
                goto L_0x0011
            L_0x0010:
                r6 = r5
            L_0x0011:
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x003b }
                java.lang.String r1 = r4.f47473b     // Catch:{ all -> 0x003b }
                r0.<init>(r1)     // Catch:{ all -> 0x003b }
                r5 = 2048(0x800, float:2.87E-42)
                byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0036 }
                if (r6 == 0) goto L_0x002a
            L_0x001e:
                r1 = -1
                int r2 = r6.read(r5)     // Catch:{ all -> 0x0036 }
                if (r1 == r2) goto L_0x002a
                r1 = 0
                r0.write(r5, r1, r2)     // Catch:{ all -> 0x0036 }
                goto L_0x001e
            L_0x002a:
                r0.flush()     // Catch:{ all -> 0x0036 }
                r0.close()
                if (r6 == 0) goto L_0x0035
                r6.close()
            L_0x0035:
                return
            L_0x0036:
                r5 = move-exception
                r3 = r0
                r0 = r5
                r5 = r3
                goto L_0x0040
            L_0x003b:
                r0 = move-exception
                goto L_0x0040
            L_0x003d:
                r6 = move-exception
                r0 = r6
                r6 = r5
            L_0x0040:
                if (r5 == 0) goto L_0x0045
                r5.close()
            L_0x0045:
                if (r6 == 0) goto L_0x004a
                r6.close()
            L_0x004a:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: dh.d.c.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    public d() {
        a aVar = new a();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(15, timeUnit).readTimeout(15, timeUnit).writeTimeout(15, timeUnit).retryOnConnectionFailure(false);
        u.b(builder);
        f47467b = builder.addNetworkInterceptor(new b(aVar)).build();
    }

    public static d d() {
        if (f47468c == null) {
            synchronized (d.class) {
                if (f47468c == null) {
                    f47468c = new d();
                }
            }
        }
        return f47468c;
    }

    public void c(String str, String str2, t8.a aVar) {
        List list = this.f47469a.get(str);
        if (list != null && !list.contains(aVar)) {
            list.add(aVar);
        } else if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            this.f47469a.put(str, arrayList);
        }
        Request build = new Request.Builder().url(str).build();
        f47467b.newCall(build).enqueue(new c(str2));
    }

    public final void e(HttpUrl httpUrl, IOException iOException) {
        if (!CollectionsUtils.c(this.f47469a)) {
            List list = this.f47469a.get(httpUrl.toString());
            if (!CollectionsUtils.b(list)) {
                for (int i11 = 0; i11 < list.size(); i11++) {
                    ((t8.a) list.get(i11)).b(httpUrl, iOException);
                }
            }
        }
    }

    public void f(t8.a aVar) {
        Map<String, List<t8.a>> map = this.f47469a;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, List<t8.a>> key : this.f47469a.entrySet()) {
                List list = this.f47469a.get((String) key.getKey());
                if (list.contains(aVar)) {
                    list.remove(aVar);
                }
            }
        }
    }
}
