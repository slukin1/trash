package com.sumsub.sns.internal.core.data.source.applicant.remote.utils;

import com.facebook.appevents.UserDataStore;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.q;
import com.sumsub.sns.internal.core.data.model.remote.k;
import com.sumsub.sns.internal.core.data.model.remote.l;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import kotlin.jvm.internal.r;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.Response;

public final class c {

    public static final class a extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MediaType f33224a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InputStream f33225b;

        public a(MediaType mediaType, InputStream inputStream) {
            this.f33224a = mediaType;
            this.f33225b = inputStream;
        }

        public long contentLength() {
            return (long) this.f33225b.available();
        }

        public MediaType contentType() {
            return this.f33224a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            kotlin.io.b.a(r0, r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeTo(okio.BufferedSink r3) {
            /*
                r2 = this;
                java.io.InputStream r0 = r2.f33225b
                okio.Source r0 = okio.Okio.source((java.io.InputStream) r0)
                r3.writeAll(r0)     // Catch:{ all -> 0x000e }
                r3 = 0
                kotlin.io.b.a(r0, r3)
                return
            L_0x000e:
                r3 = move-exception
                throw r3     // Catch:{ all -> 0x0010 }
            L_0x0010:
                r1 = move-exception
                kotlin.io.b.a(r0, r3)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a.writeTo(okio.BufferedSink):void");
        }
    }

    public static final k a(Response<l> response) {
        k kVar;
        l body = response.body();
        k kVar2 = null;
        if (body != null) {
            Long e11 = body.e();
            String l11 = e11 != null ? e11.toString() : null;
            l.c c11 = body.c();
            kVar = new k(c11 != null ? c11.b() : null, (String) null, (IdentitySide) null, (List) null, (List) null, (List) null, l11, 62, (r) null);
        } else {
            kVar = null;
        }
        String str = response.headers().get("X-Image-Id");
        if (str == null) {
            return kVar;
        }
        if (kVar != null) {
            kVar2 = k.a(kVar, (String) null, (String) null, (IdentitySide) null, (List) null, (List) null, (List) null, str, 63, (Object) null);
        }
        return kVar2 == null ? kVar : kVar2;
    }

    public static /* synthetic */ MultipartBody.Part a(File file, RequestBody requestBody, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            requestBody = null;
        }
        return a(file, requestBody);
    }

    public static final MultipartBody.Part a(File file, RequestBody requestBody) {
        MultipartBody.Part.Companion companion = MultipartBody.Part.Companion;
        String name = file.getName();
        if (requestBody == null) {
            requestBody = RequestBody.Companion.create(file, MediaType.Companion.parse("multipart/form-data"));
        }
        return companion.createFormData("content", name, requestBody);
    }

    public static final MultipartBody.Part a(InputStream inputStream) {
        return MultipartBody.Part.Companion.createFormData("content", System.currentTimeMillis() + "_file.jpg", a(inputStream, MediaType.Companion.parse("multipart/form-data")));
    }

    public static final RequestBody a(String str, String str2, IdentitySide identitySide) {
        String value;
        if (str2 == null) {
            str2 = q.f32685e;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(UserDataStore.COUNTRY, str);
        jSONObject.put("idDocType", str2);
        if (!(identitySide == null || (value = identitySide.getValue()) == null)) {
            jSONObject.put("idDocSubType", value);
        }
        return RequestBody.Companion.create(jSONObject.toString(), MediaType.Companion.parse("multipart/form-data"));
    }

    public static /* synthetic */ RequestBody a(InputStream inputStream, MediaType mediaType, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mediaType = null;
        }
        return a(inputStream, mediaType);
    }

    public static final RequestBody a(InputStream inputStream, MediaType mediaType) {
        return new a(mediaType, inputStream);
    }
}
