package okhttp3;

import com.adjust.sdk.Constants;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion((r) null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    public static final class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot2, String str, String str2) {
            this.snapshot = snapshot2;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.buffer((Source) new ForwardingSource(snapshot2.getSource(1)) {
                public void close() throws IOException {
                    this.getSnapshot().close();
                    super.close();
                }
            });
        }

        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return Util.toLongOrDefault(str, -1);
            }
            return -1;
        }

        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        public BufferedSource source() {
            return this.bodySource;
        }
    }

    public final class RealCacheRequest implements CacheRequest {
        private final Sink body;
        private final Sink cacheOut;
        private boolean done;
        /* access modifiers changed from: private */
        public final DiskLruCache.Editor editor;

        public RealCacheRequest(DiskLruCache.Editor editor2) {
            this.editor = editor2;
            Sink newSink = editor2.newSink(1);
            this.cacheOut = newSink;
            this.body = new ForwardingSink(Cache.this, newSink) {
                public void close() throws IOException {
                    Cache cache = r2;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache) {
                        if (!realCacheRequest.getDone()) {
                            realCacheRequest.setDone(true);
                            cache.setWriteSuccessCount$okhttp(cache.getWriteSuccessCount$okhttp() + 1);
                            super.close();
                            this.editor.commit();
                        }
                    }
                }
            };
        }

        public void abort() {
            Cache cache = Cache.this;
            synchronized (cache) {
                if (!this.done) {
                    this.done = true;
                    cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                    Util.closeQuietly((Closeable) this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public Sink body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z11) {
            this.done = z11;
        }
    }

    public Cache(File file, long j11, FileSystem fileSystem) {
        this.cache = new DiskLruCache(fileSystem, file, VERSION, 2, j11, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    /* renamed from: -deprecated_directory  reason: not valid java name */
    public final File m3096deprecated_directory() {
        return this.cache.getDirectory();
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                ResponseBody body = response.body();
                if (body != null) {
                    Util.closeQuietly((Closeable) body);
                }
                return null;
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!x.b(method, "GET")) {
            return null;
        } else {
            Companion companion = Companion;
            if (companion.hasVaryAll(response)) {
                return null;
            }
            Entry entry = new Entry(response);
            try {
                editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0, 2, (Object) null);
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new RealCacheRequest(editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i11) {
        this.writeAbortCount = i11;
    }

    public final void setWriteSuccessCount$okhttp(int i11) {
        this.writeSuccessCount = i11;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final void update$okhttp(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.body()).getSnapshot().edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            abortQuietly(editor);
        }
    }

    public final Iterator<String> urls() throws IOException {
        return new Cache$urls$1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i11 = 0; i11 < size; i11++) {
                if (StringsKt__StringsJVMKt.w(HttpHeaders.VARY, headers.name(i11), true)) {
                    String value = headers.value(i11);
                    if (treeSet == null) {
                        treeSet = new TreeSet(StringsKt__StringsJVMKt.y(d0.f56774a));
                    }
                    for (String i12 : StringsKt__StringsKt.K0(value, new char[]{','}, false, 0, 6, (Object) null)) {
                        treeSet.add(StringsKt__StringsKt.i1(i12).toString());
                    }
                }
            }
            return treeSet == null ? SetsKt__SetsKt.d() : treeSet;
        }

        public final boolean hasVaryAll(Response response) {
            return varyFields(response.headers()).contains("*");
        }

        public final String key(HttpUrl httpUrl) {
            return ByteString.Companion.encodeUtf8(httpUrl.toString()).md5().hex();
        }

        public final int readInt$okhttp(BufferedSource bufferedSource) throws IOException {
            try {
                long readDecimalLong = bufferedSource.readDecimalLong();
                String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L) {
                    if (!(readUtf8LineStrict.length() > 0)) {
                        return (int) readDecimalLong;
                    }
                }
                throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + '\"');
            } catch (NumberFormatException e11) {
                throw new IOException(e11.getMessage());
            }
        }

        public final Headers varyHeaders(Response response) {
            return varyHeaders(response.networkResponse().request().headers(), response.headers());
        }

        public final boolean varyMatches(Response response, Headers headers, Request request) {
            Set<String> varyFields = varyFields(response.headers());
            if ((varyFields instanceof Collection) && varyFields.isEmpty()) {
                return true;
            }
            for (String str : varyFields) {
                if (!x.b(headers.values(str), request.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i11 = 0; i11 < size; i11++) {
                String name = headers.name(i11);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i11));
                }
            }
            return builder.build();
        }
    }

    public Cache(File file, long j11) {
        this(file, j11, FileSystem.SYSTEM);
    }

    public static final class Entry {
        public static final Companion Companion = new Companion((r) null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(r rVar) {
                this();
            }
        }

        static {
            StringBuilder sb2 = new StringBuilder();
            Platform.Companion companion = Platform.Companion;
            sb2.append(companion.get().getPrefix());
            sb2.append("-Sent-Millis");
            SENT_MILLIS = sb2.toString();
            RECEIVED_MILLIS = companion.get().getPrefix() + "-Received-Millis";
        }

        /* JADX WARNING: Code restructure failed: missing block: B:40:0x011f, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0120, code lost:
            kotlin.io.b.a(r10, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0123, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Entry(okio.Source r10) throws java.io.IOException {
            /*
                r9 = this;
                r9.<init>()
                okio.BufferedSource r0 = okio.Okio.buffer((okio.Source) r10)     // Catch:{ all -> 0x011d }
                java.lang.String r1 = r0.readUtf8LineStrict()     // Catch:{ all -> 0x011d }
                okhttp3.HttpUrl$Companion r2 = okhttp3.HttpUrl.Companion     // Catch:{ all -> 0x011d }
                okhttp3.HttpUrl r2 = r2.parse(r1)     // Catch:{ all -> 0x011d }
                if (r2 == 0) goto L_0x00fa
                r9.url = r2     // Catch:{ all -> 0x011d }
                java.lang.String r1 = r0.readUtf8LineStrict()     // Catch:{ all -> 0x011d }
                r9.requestMethod = r1     // Catch:{ all -> 0x011d }
                okhttp3.Headers$Builder r1 = new okhttp3.Headers$Builder     // Catch:{ all -> 0x011d }
                r1.<init>()     // Catch:{ all -> 0x011d }
                okhttp3.Cache$Companion r2 = okhttp3.Cache.Companion     // Catch:{ all -> 0x011d }
                int r2 = r2.readInt$okhttp(r0)     // Catch:{ all -> 0x011d }
                r3 = 0
                r4 = r3
            L_0x0028:
                if (r4 >= r2) goto L_0x0034
                java.lang.String r5 = r0.readUtf8LineStrict()     // Catch:{ all -> 0x011d }
                r1.addLenient$okhttp(r5)     // Catch:{ all -> 0x011d }
                int r4 = r4 + 1
                goto L_0x0028
            L_0x0034:
                okhttp3.Headers r1 = r1.build()     // Catch:{ all -> 0x011d }
                r9.varyHeaders = r1     // Catch:{ all -> 0x011d }
                okhttp3.internal.http.StatusLine$Companion r1 = okhttp3.internal.http.StatusLine.Companion     // Catch:{ all -> 0x011d }
                java.lang.String r2 = r0.readUtf8LineStrict()     // Catch:{ all -> 0x011d }
                okhttp3.internal.http.StatusLine r1 = r1.parse(r2)     // Catch:{ all -> 0x011d }
                okhttp3.Protocol r2 = r1.protocol     // Catch:{ all -> 0x011d }
                r9.protocol = r2     // Catch:{ all -> 0x011d }
                int r2 = r1.code     // Catch:{ all -> 0x011d }
                r9.code = r2     // Catch:{ all -> 0x011d }
                java.lang.String r1 = r1.message     // Catch:{ all -> 0x011d }
                r9.message = r1     // Catch:{ all -> 0x011d }
                okhttp3.Headers$Builder r1 = new okhttp3.Headers$Builder     // Catch:{ all -> 0x011d }
                r1.<init>()     // Catch:{ all -> 0x011d }
                okhttp3.Cache$Companion r2 = okhttp3.Cache.Companion     // Catch:{ all -> 0x011d }
                int r2 = r2.readInt$okhttp(r0)     // Catch:{ all -> 0x011d }
                r4 = r3
            L_0x005c:
                if (r4 >= r2) goto L_0x0068
                java.lang.String r5 = r0.readUtf8LineStrict()     // Catch:{ all -> 0x011d }
                r1.addLenient$okhttp(r5)     // Catch:{ all -> 0x011d }
                int r4 = r4 + 1
                goto L_0x005c
            L_0x0068:
                java.lang.String r2 = SENT_MILLIS     // Catch:{ all -> 0x011d }
                java.lang.String r4 = r1.get(r2)     // Catch:{ all -> 0x011d }
                java.lang.String r5 = RECEIVED_MILLIS     // Catch:{ all -> 0x011d }
                java.lang.String r6 = r1.get(r5)     // Catch:{ all -> 0x011d }
                r1.removeAll(r2)     // Catch:{ all -> 0x011d }
                r1.removeAll(r5)     // Catch:{ all -> 0x011d }
                r7 = 0
                if (r4 == 0) goto L_0x0083
                long r4 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x011d }
                goto L_0x0084
            L_0x0083:
                r4 = r7
            L_0x0084:
                r9.sentRequestMillis = r4     // Catch:{ all -> 0x011d }
                if (r6 == 0) goto L_0x008c
                long r7 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x011d }
            L_0x008c:
                r9.receivedResponseMillis = r7     // Catch:{ all -> 0x011d }
                okhttp3.Headers r1 = r1.build()     // Catch:{ all -> 0x011d }
                r9.responseHeaders = r1     // Catch:{ all -> 0x011d }
                boolean r1 = r9.isHttps()     // Catch:{ all -> 0x011d }
                r2 = 0
                if (r1 == 0) goto L_0x00f2
                java.lang.String r1 = r0.readUtf8LineStrict()     // Catch:{ all -> 0x011d }
                int r4 = r1.length()     // Catch:{ all -> 0x011d }
                if (r4 <= 0) goto L_0x00a6
                r3 = 1
            L_0x00a6:
                if (r3 != 0) goto L_0x00d6
                java.lang.String r1 = r0.readUtf8LineStrict()     // Catch:{ all -> 0x011d }
                okhttp3.CipherSuite$Companion r3 = okhttp3.CipherSuite.Companion     // Catch:{ all -> 0x011d }
                okhttp3.CipherSuite r1 = r3.forJavaName(r1)     // Catch:{ all -> 0x011d }
                java.util.List r3 = r9.readCertificateList(r0)     // Catch:{ all -> 0x011d }
                java.util.List r4 = r9.readCertificateList(r0)     // Catch:{ all -> 0x011d }
                boolean r5 = r0.exhausted()     // Catch:{ all -> 0x011d }
                if (r5 != 0) goto L_0x00cb
                okhttp3.TlsVersion$Companion r5 = okhttp3.TlsVersion.Companion     // Catch:{ all -> 0x011d }
                java.lang.String r0 = r0.readUtf8LineStrict()     // Catch:{ all -> 0x011d }
                okhttp3.TlsVersion r0 = r5.forJavaName(r0)     // Catch:{ all -> 0x011d }
                goto L_0x00cd
            L_0x00cb:
                okhttp3.TlsVersion r0 = okhttp3.TlsVersion.SSL_3_0     // Catch:{ all -> 0x011d }
            L_0x00cd:
                okhttp3.Handshake$Companion r5 = okhttp3.Handshake.Companion     // Catch:{ all -> 0x011d }
                okhttp3.Handshake r0 = r5.get(r0, r1, r3, r4)     // Catch:{ all -> 0x011d }
                r9.handshake = r0     // Catch:{ all -> 0x011d }
                goto L_0x00f4
            L_0x00d6:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x011d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
                r2.<init>()     // Catch:{ all -> 0x011d }
                java.lang.String r3 = "expected \"\" but was \""
                r2.append(r3)     // Catch:{ all -> 0x011d }
                r2.append(r1)     // Catch:{ all -> 0x011d }
                r1 = 34
                r2.append(r1)     // Catch:{ all -> 0x011d }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x011d }
                r0.<init>(r1)     // Catch:{ all -> 0x011d }
                throw r0     // Catch:{ all -> 0x011d }
            L_0x00f2:
                r9.handshake = r2     // Catch:{ all -> 0x011d }
            L_0x00f4:
                kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x011d }
                kotlin.io.b.a(r10, r2)
                return
            L_0x00fa:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x011d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
                r2.<init>()     // Catch:{ all -> 0x011d }
                java.lang.String r3 = "Cache corruption for "
                r2.append(r3)     // Catch:{ all -> 0x011d }
                r2.append(r1)     // Catch:{ all -> 0x011d }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x011d }
                r0.<init>(r1)     // Catch:{ all -> 0x011d }
                okhttp3.internal.platform.Platform$Companion r1 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x011d }
                okhttp3.internal.platform.Platform r1 = r1.get()     // Catch:{ all -> 0x011d }
                java.lang.String r2 = "cache corruption"
                r3 = 5
                r1.log(r2, r3, r0)     // Catch:{ all -> 0x011d }
                throw r0     // Catch:{ all -> 0x011d }
            L_0x011d:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x011f }
            L_0x011f:
                r1 = move-exception
                kotlin.io.b.a(r10, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.Entry.<init>(okio.Source):void");
        }

        private final boolean isHttps() {
            return x.b(this.url.scheme(), Constants.SCHEME);
        }

        private final List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int readInt$okhttp = Cache.Companion.readInt$okhttp(bufferedSource);
            if (readInt$okhttp == -1) {
                return CollectionsKt__CollectionsKt.k();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                int i11 = 0;
                while (i11 < readInt$okhttp) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    ByteString decodeBase64 = ByteString.Companion.decodeBase64(readUtf8LineStrict);
                    if (decodeBase64 != null) {
                        buffer.write(decodeBase64);
                        arrayList.add(instance.generateCertificate(buffer.inputStream()));
                        i11++;
                    } else {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                }
                return arrayList;
            } catch (CertificateException e11) {
                throw new IOException(e11.getMessage());
            }
        }

        private final void writeCertList(BufferedSink bufferedSink, List<? extends Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong((long) list.size()).writeByte(10);
                for (Certificate encoded : list) {
                    bufferedSink.writeUtf8(ByteString.Companion.of$default(ByteString.Companion, encoded.getEncoded(), 0, 0, 3, (Object) null).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e11) {
                throw new IOException(e11.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            return x.b(this.url, request.url()) && x.b(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, (RequestBody) null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0110, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0111, code lost:
            kotlin.io.b.a(r8, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0114, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void writeTo(okhttp3.internal.cache.DiskLruCache.Editor r8) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 0
                okio.Sink r8 = r8.newSink(r0)
                okio.BufferedSink r8 = okio.Okio.buffer((okio.Sink) r8)
                okhttp3.HttpUrl r1 = r7.url     // Catch:{ all -> 0x010e }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x010e }
                okio.BufferedSink r1 = r8.writeUtf8(r1)     // Catch:{ all -> 0x010e }
                r2 = 10
                r1.writeByte(r2)     // Catch:{ all -> 0x010e }
                java.lang.String r1 = r7.requestMethod     // Catch:{ all -> 0x010e }
                okio.BufferedSink r1 = r8.writeUtf8(r1)     // Catch:{ all -> 0x010e }
                r1.writeByte(r2)     // Catch:{ all -> 0x010e }
                okhttp3.Headers r1 = r7.varyHeaders     // Catch:{ all -> 0x010e }
                int r1 = r1.size()     // Catch:{ all -> 0x010e }
                long r3 = (long) r1     // Catch:{ all -> 0x010e }
                okio.BufferedSink r1 = r8.writeDecimalLong(r3)     // Catch:{ all -> 0x010e }
                r1.writeByte(r2)     // Catch:{ all -> 0x010e }
                okhttp3.Headers r1 = r7.varyHeaders     // Catch:{ all -> 0x010e }
                int r1 = r1.size()     // Catch:{ all -> 0x010e }
                r3 = r0
            L_0x0036:
                java.lang.String r4 = ": "
                if (r3 >= r1) goto L_0x0058
                okhttp3.Headers r5 = r7.varyHeaders     // Catch:{ all -> 0x010e }
                java.lang.String r5 = r5.name(r3)     // Catch:{ all -> 0x010e }
                okio.BufferedSink r5 = r8.writeUtf8(r5)     // Catch:{ all -> 0x010e }
                okio.BufferedSink r4 = r5.writeUtf8(r4)     // Catch:{ all -> 0x010e }
                okhttp3.Headers r5 = r7.varyHeaders     // Catch:{ all -> 0x010e }
                java.lang.String r5 = r5.value(r3)     // Catch:{ all -> 0x010e }
                okio.BufferedSink r4 = r4.writeUtf8(r5)     // Catch:{ all -> 0x010e }
                r4.writeByte(r2)     // Catch:{ all -> 0x010e }
                int r3 = r3 + 1
                goto L_0x0036
            L_0x0058:
                okhttp3.internal.http.StatusLine r1 = new okhttp3.internal.http.StatusLine     // Catch:{ all -> 0x010e }
                okhttp3.Protocol r3 = r7.protocol     // Catch:{ all -> 0x010e }
                int r5 = r7.code     // Catch:{ all -> 0x010e }
                java.lang.String r6 = r7.message     // Catch:{ all -> 0x010e }
                r1.<init>(r3, r5, r6)     // Catch:{ all -> 0x010e }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x010e }
                okio.BufferedSink r1 = r8.writeUtf8(r1)     // Catch:{ all -> 0x010e }
                r1.writeByte(r2)     // Catch:{ all -> 0x010e }
                okhttp3.Headers r1 = r7.responseHeaders     // Catch:{ all -> 0x010e }
                int r1 = r1.size()     // Catch:{ all -> 0x010e }
                int r1 = r1 + 2
                long r5 = (long) r1     // Catch:{ all -> 0x010e }
                okio.BufferedSink r1 = r8.writeDecimalLong(r5)     // Catch:{ all -> 0x010e }
                r1.writeByte(r2)     // Catch:{ all -> 0x010e }
                okhttp3.Headers r1 = r7.responseHeaders     // Catch:{ all -> 0x010e }
                int r1 = r1.size()     // Catch:{ all -> 0x010e }
            L_0x0084:
                if (r0 >= r1) goto L_0x00a4
                okhttp3.Headers r3 = r7.responseHeaders     // Catch:{ all -> 0x010e }
                java.lang.String r3 = r3.name(r0)     // Catch:{ all -> 0x010e }
                okio.BufferedSink r3 = r8.writeUtf8(r3)     // Catch:{ all -> 0x010e }
                okio.BufferedSink r3 = r3.writeUtf8(r4)     // Catch:{ all -> 0x010e }
                okhttp3.Headers r5 = r7.responseHeaders     // Catch:{ all -> 0x010e }
                java.lang.String r5 = r5.value(r0)     // Catch:{ all -> 0x010e }
                okio.BufferedSink r3 = r3.writeUtf8(r5)     // Catch:{ all -> 0x010e }
                r3.writeByte(r2)     // Catch:{ all -> 0x010e }
                int r0 = r0 + 1
                goto L_0x0084
            L_0x00a4:
                java.lang.String r0 = SENT_MILLIS     // Catch:{ all -> 0x010e }
                okio.BufferedSink r0 = r8.writeUtf8(r0)     // Catch:{ all -> 0x010e }
                okio.BufferedSink r0 = r0.writeUtf8(r4)     // Catch:{ all -> 0x010e }
                long r5 = r7.sentRequestMillis     // Catch:{ all -> 0x010e }
                okio.BufferedSink r0 = r0.writeDecimalLong(r5)     // Catch:{ all -> 0x010e }
                r0.writeByte(r2)     // Catch:{ all -> 0x010e }
                java.lang.String r0 = RECEIVED_MILLIS     // Catch:{ all -> 0x010e }
                okio.BufferedSink r0 = r8.writeUtf8(r0)     // Catch:{ all -> 0x010e }
                okio.BufferedSink r0 = r0.writeUtf8(r4)     // Catch:{ all -> 0x010e }
                long r3 = r7.receivedResponseMillis     // Catch:{ all -> 0x010e }
                okio.BufferedSink r0 = r0.writeDecimalLong(r3)     // Catch:{ all -> 0x010e }
                r0.writeByte(r2)     // Catch:{ all -> 0x010e }
                boolean r0 = r7.isHttps()     // Catch:{ all -> 0x010e }
                if (r0 == 0) goto L_0x0107
                r8.writeByte(r2)     // Catch:{ all -> 0x010e }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x010e }
                okhttp3.CipherSuite r0 = r0.cipherSuite()     // Catch:{ all -> 0x010e }
                java.lang.String r0 = r0.javaName()     // Catch:{ all -> 0x010e }
                okio.BufferedSink r0 = r8.writeUtf8(r0)     // Catch:{ all -> 0x010e }
                r0.writeByte(r2)     // Catch:{ all -> 0x010e }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x010e }
                java.util.List r0 = r0.peerCertificates()     // Catch:{ all -> 0x010e }
                r7.writeCertList(r8, r0)     // Catch:{ all -> 0x010e }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x010e }
                java.util.List r0 = r0.localCertificates()     // Catch:{ all -> 0x010e }
                r7.writeCertList(r8, r0)     // Catch:{ all -> 0x010e }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x010e }
                okhttp3.TlsVersion r0 = r0.tlsVersion()     // Catch:{ all -> 0x010e }
                java.lang.String r0 = r0.javaName()     // Catch:{ all -> 0x010e }
                okio.BufferedSink r0 = r8.writeUtf8(r0)     // Catch:{ all -> 0x010e }
                r0.writeByte(r2)     // Catch:{ all -> 0x010e }
            L_0x0107:
                kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x010e }
                r0 = 0
                kotlin.io.b.a(r8, r0)
                return
            L_0x010e:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0110 }
            L_0x0110:
                r1 = move-exception
                kotlin.io.b.a(r8, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.Entry.writeTo(okhttp3.internal.cache.DiskLruCache$Editor):void");
        }

        public Entry(Response response) {
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
