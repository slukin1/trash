package np;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.util.CollectionsUtils;
import com.huobi.otc.log.bean.OtcBusinessLogBean;
import com.huobi.otc.log.enums.LogKeys;
import com.huobi.otc.log.enums.LogType;
import com.huobi.utils.MapDeserializerDoubleAsIntFix;
import i6.k;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import org.json.JSONObject;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f84511c = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Map<String, OtcBusinessLogBean>> f84512a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Gson f84513b;

    /* renamed from: np.a$a  reason: collision with other inner class name */
    public class C0879a extends TypeToken<Map<String, Map<String, OtcBusinessLogBean>>> {
        public C0879a() {
        }
    }

    public class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public class c extends TypeToken<Map<String, Object>> {
        public c() {
        }
    }

    public a() {
        h();
    }

    public static a f() {
        return f84511c;
    }

    public static boolean k(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, buffer.size() < 64 ? buffer.size() : 64);
            for (int i11 = 0; i11 < 16; i11++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public final Map<String, String> a(Request request, List<String> list) throws Exception {
        String queryParameter;
        HashMap hashMap = new HashMap();
        if (!(request == null || list == null)) {
            HttpUrl build = request.url().newBuilder().build();
            for (String next : build.queryParameterNames()) {
                for (String next2 : list) {
                    if (TextUtils.equals(next, next2) && (queryParameter = build.queryParameter(next)) != null) {
                        hashMap.put(next2, queryParameter);
                    }
                }
            }
        }
        return hashMap;
    }

    public final void b(String str, Map<String, String> map, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String json = this.f84513b.toJson((Object) map);
            if (!TextUtils.isEmpty(json)) {
                k.o(g(str, str2), json);
            }
        }
    }

    public final Map<String, String> c(RequestBody requestBody, List<String> list) throws Exception {
        HashMap hashMap = new HashMap();
        if (requestBody == null) {
            return null;
        }
        if (CollectionsUtils.b(list)) {
            return hashMap;
        }
        HashMap hashMap2 = new HashMap();
        if (requestBody instanceof FormBody) {
            int i11 = 0;
            while (true) {
                FormBody formBody = (FormBody) requestBody;
                if (i11 >= formBody.size()) {
                    break;
                }
                hashMap2.put(formBody.name(i11), formBody.value(i11));
                String name = formBody.name(i11);
                String value = formBody.value(i11);
                for (String next : list) {
                    if (TextUtils.equals(name, next)) {
                        hashMap.put(next, value);
                    }
                }
                i11++;
            }
        } else if (!(requestBody instanceof MultipartBody)) {
            Buffer buffer = new Buffer();
            try {
                requestBody.writeTo(buffer);
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            String readUtf8 = buffer.readUtf8();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(new b().getType(), new MapDeserializerDoubleAsIntFix());
            for (Map.Entry entry : ((HashMap) gsonBuilder.create().fromJson(readUtf8, new c().getType())).entrySet()) {
                for (String next2 : list) {
                    if (TextUtils.equals((CharSequence) entry.getKey(), next2)) {
                        hashMap.put(next2, (String) entry.getValue());
                    }
                }
            }
        }
        return hashMap;
    }

    public final void d(OtcBusinessLogBean otcBusinessLogBean, Request request, String str) throws Exception {
        Map<String, String> map;
        if (request != null) {
            if (TextUtils.equals("POST", request.method())) {
                map = c(request.body(), otcBusinessLogBean.c());
            } else {
                map = a(request, otcBusinessLogBean.c());
            }
            if (map != null) {
                b(otcBusinessLogBean.b(), map, str);
            }
        }
    }

    public final void e(OtcBusinessLogBean otcBusinessLogBean, OtcBusinessLogBean otcBusinessLogBean2, Response response, String str) throws Exception {
        Boolean i11;
        if (response != null) {
            if (!j(response)) {
                String n11 = n(response);
                if (n11 != null && (i11 = i(n11)) != null) {
                    if (i11.booleanValue()) {
                        if (otcBusinessLogBean2 != null) {
                            IdentityHashMap identityHashMap = new IdentityHashMap();
                            identityHashMap.put(LogType.busError.name(), n11);
                            b(otcBusinessLogBean2.b(), identityHashMap, str);
                        }
                    } else if (otcBusinessLogBean == null) {
                    } else {
                        if (otcBusinessLogBean.d()) {
                            IdentityHashMap identityHashMap2 = new IdentityHashMap();
                            identityHashMap2.put(LogType.all.name(), n11);
                            b(otcBusinessLogBean.b(), identityHashMap2, str);
                            return;
                        }
                        List<String> c11 = otcBusinessLogBean.c();
                        IdentityHashMap identityHashMap3 = new IdentityHashMap();
                        m("", new JsonParser().parse(n11), c11, identityHashMap3);
                        b(otcBusinessLogBean.b(), identityHashMap3, str);
                    }
                }
            } else if (otcBusinessLogBean2 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(LogType.netError.name(), response.message());
                b(otcBusinessLogBean2.b(), hashMap, str);
            }
        }
    }

    public final String g(String str, String str2) {
        return "otc_net_business_logan/" + str2 + "/" + str;
    }

    public final void h() {
        InputStream inputStream = null;
        try {
            this.f84513b = new Gson();
            this.f84512a.clear();
            InputStream open = BaseApplication.b().getResources().getAssets().open("otc_netlog.json");
            Map map = (Map) this.f84513b.fromJson(FileUtil.k(open), new C0879a().getType());
            if (!CollectionsUtils.c(map)) {
                this.f84512a.putAll(map);
            }
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
        } catch (IOException e12) {
            e12.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th2;
        }
    }

    public final Boolean i(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("success")) {
            return Boolean.valueOf(!jSONObject.getBoolean("success"));
        }
        return null;
    }

    public final boolean j(Response response) {
        return response.code() != 200;
    }

    public boolean l(String str) {
        return !TextUtils.isEmpty(str) && this.f84512a.containsKey(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m(java.lang.String r2, com.google.gson.JsonElement r3, java.util.List<java.lang.String> r4, java.util.Map<java.lang.String, java.lang.String> r5) throws java.lang.Exception {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r3.isJsonNull()     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x007a
            boolean r0 = com.hbg.lib.core.util.CollectionsUtils.b(r4)     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x000e
            goto L_0x007a
        L_0x000e:
            boolean r0 = r3.isJsonPrimitive()     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0026
            boolean r0 = r4.contains(r2)     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0024
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x007c }
            r5.put(r2, r3)     // Catch:{ all -> 0x007c }
            r4.remove(r2)     // Catch:{ all -> 0x007c }
        L_0x0024:
            monitor-exit(r1)
            return
        L_0x0026:
            boolean r2 = r3.isJsonArray()     // Catch:{ all -> 0x007c }
            if (r2 == 0) goto L_0x004a
            com.google.gson.JsonArray r2 = r3.getAsJsonArray()     // Catch:{ all -> 0x007c }
            if (r2 == 0) goto L_0x0048
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x007c }
        L_0x0036:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x0048
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x007c }
            com.google.gson.JsonElement r3 = (com.google.gson.JsonElement) r3     // Catch:{ all -> 0x007c }
            java.lang.String r0 = ""
            r1.m(r0, r3, r4, r5)     // Catch:{ all -> 0x007c }
            goto L_0x0036
        L_0x0048:
            monitor-exit(r1)
            return
        L_0x004a:
            boolean r2 = r3.isJsonObject()     // Catch:{ all -> 0x007c }
            if (r2 == 0) goto L_0x0078
            com.google.gson.JsonObject r2 = r3.getAsJsonObject()     // Catch:{ all -> 0x007c }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x007c }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x007c }
        L_0x005c:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x0078
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x007c }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x007c }
            java.lang.Object r0 = r3.getKey()     // Catch:{ all -> 0x007c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x007c }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x007c }
            com.google.gson.JsonElement r3 = (com.google.gson.JsonElement) r3     // Catch:{ all -> 0x007c }
            r1.m(r0, r3, r4, r5)     // Catch:{ all -> 0x007c }
            goto L_0x005c
        L_0x0078:
            monitor-exit(r1)
            return
        L_0x007a:
            monitor-exit(r1)
            return
        L_0x007c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: np.a.m(java.lang.String, com.google.gson.JsonElement, java.util.List, java.util.Map):void");
    }

    public final String n(Response response) throws Exception {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        BufferedSource source = body.source();
        try {
            source.request(Long.MAX_VALUE);
            MediaType contentType = body.contentType();
            Charset forName = Charset.forName("UTF-8");
            if (contentType != null) {
                forName = contentType.charset(forName);
            }
            if (forName == null) {
                return null;
            }
            Buffer buffer = source.buffer();
            if (k(buffer)) {
                return buffer.clone().readString(forName);
            }
            return null;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public void o(Request request, Response response, String str) {
        OtcBusinessLogBean otcBusinessLogBean;
        OtcBusinessLogBean otcBusinessLogBean2;
        if (request != null) {
            try {
                Map map = this.f84512a.get(request.url().encodedPath());
                if (!CollectionsUtils.c(map)) {
                    LogKeys logKeys = LogKeys.begin;
                    if (map.containsKey(logKeys.name()) && (otcBusinessLogBean2 = (OtcBusinessLogBean) map.get(logKeys.name())) != null) {
                        d(otcBusinessLogBean2, request, str);
                    }
                    LogKeys logKeys2 = LogKeys.success;
                    if ((map.containsKey(logKeys2.name()) || map.containsKey(LogKeys.failure.name())) && (otcBusinessLogBean = (OtcBusinessLogBean) map.get(logKeys2.name())) != null) {
                        e((OtcBusinessLogBean) map.get(logKeys2.name()), otcBusinessLogBean, response, str);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
