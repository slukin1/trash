package okhttp3.logging;

import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.google.common.net.HttpHeaders;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.io.b;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE = new Companion();

            public static final class DefaultLogger implements Logger {
                public void log(String str) {
                    Platform.log$default(Platform.Companion.get(), str, 0, (Throwable) null, 6, (Object) null);
                }
            }

            private Companion() {
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this((Logger) null, 1, (r) null);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        this.logger = logger2;
        this.headersToRedact = SetsKt__SetsKt.d();
        this.level = Level.NONE;
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        if (str != null && !StringsKt__StringsJVMKt.w(str, "identity", true) && !StringsKt__StringsJVMKt.w(str, DecompressionHelper.GZIP_ENCODING, true)) {
            return true;
        }
        return false;
    }

    private final void logHeader(Headers headers, int i11) {
        String value = this.headersToRedact.contains(headers.name(i11)) ? "██" : headers.value(i11);
        Logger logger2 = this.logger;
        logger2.log(headers.name(i11) + l.f34627b + value);
    }

    /* renamed from: -deprecated_level  reason: not valid java name */
    public final Level m3219deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        String str2;
        long j11;
        char c11;
        String str3;
        String str4;
        Charset charset;
        Throwable th2;
        Charset charset2;
        Interceptor.Chain chain2 = chain;
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain2.proceed(request);
        }
        boolean z11 = level2 == Level.BODY;
        boolean z12 = z11 || level2 == Level.HEADERS;
        RequestBody body = request.body();
        Connection connection = chain.connection();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(request.method());
        sb2.append(' ');
        sb2.append(request.url());
        if (connection != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(' ');
            sb3.append(connection.protocol());
            str = sb3.toString();
        } else {
            str = "";
        }
        sb2.append(str);
        String sb4 = sb2.toString();
        if (!z12 && body != null) {
            sb4 = sb4 + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(sb4);
        if (z12) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType != null && headers.get("Content-Type") == null) {
                    this.logger.log("Content-Type: " + contentType);
                }
                if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log("Content-Length: " + body.contentLength());
                }
            }
            int size = headers.size();
            for (int i11 = 0; i11 < size; i11++) {
                logHeader(headers, i11);
            }
            if (!z11 || body == null) {
                this.logger.log("--> END " + request.method());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (body.isDuplex()) {
                this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (body.isOneShot()) {
                this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                MediaType contentType2 = body.contentType();
                if (contentType2 == null || (charset2 = contentType2.charset(StandardCharsets.UTF_8)) == null) {
                    charset2 = StandardCharsets.UTF_8;
                }
                this.logger.log("");
                if (Utf8Kt.isProbablyUtf8(buffer)) {
                    this.logger.log(buffer.readString(charset2));
                    this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain2.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                str2 = contentLength + "-byte";
            } else {
                str2 = "unknown-length";
            }
            Logger logger2 = this.logger;
            StringBuilder sb5 = new StringBuilder();
            String str5 = "-byte body)";
            sb5.append("<-- ");
            sb5.append(proceed.code());
            if (proceed.message().length() == 0) {
                str3 = "";
                j11 = contentLength;
                c11 = ' ';
            } else {
                String message = proceed.message();
                j11 = contentLength;
                StringBuilder sb6 = new StringBuilder();
                c11 = ' ';
                sb6.append(' ');
                sb6.append(message);
                str3 = sb6.toString();
            }
            sb5.append(str3);
            sb5.append(c11);
            sb5.append(proceed.request().url());
            sb5.append(" (");
            sb5.append(millis);
            sb5.append("ms");
            if (!z12) {
                str4 = ", " + str2 + " body";
            } else {
                str4 = "";
            }
            sb5.append(str4);
            sb5.append(')');
            logger2.log(sb5.toString());
            if (z12) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    logHeader(headers2, i12);
                }
                if (!z11 || !okhttp3.internal.http.HttpHeaders.promisesBody(proceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(proceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.getBuffer();
                    Long l11 = null;
                    if (StringsKt__StringsJVMKt.w(DecompressionHelper.GZIP_ENCODING, headers2.get(HttpHeaders.CONTENT_ENCODING), true)) {
                        Long valueOf = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            b.a(gzipSource, (Throwable) null);
                            l11 = valueOf;
                        } catch (Throwable th3) {
                            Throwable th4 = th3;
                            b.a(gzipSource, th2);
                            throw th4;
                        }
                    }
                    MediaType contentType3 = body2.contentType();
                    if (contentType3 == null || (charset = contentType3.charset(StandardCharsets.UTF_8)) == null) {
                        charset = StandardCharsets.UTF_8;
                    }
                    if (!Utf8Kt.isProbablyUtf8(buffer2)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                        return proceed;
                    }
                    if (j11 != 0) {
                        this.logger.log("");
                        this.logger.log(buffer2.clone().readString(charset));
                    }
                    if (l11 != null) {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte, " + l11 + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + str5);
                    }
                }
            }
            return proceed;
        } catch (Exception e11) {
            Exception exc = e11;
            this.logger.log("<-- HTTP FAILED: " + exc);
            throw exc;
        }
    }

    public final void level(Level level2) {
        this.level = level2;
    }

    public final void redactHeader(String str) {
        TreeSet treeSet = new TreeSet(StringsKt__StringsJVMKt.y(d0.f56774a));
        boolean unused = CollectionsKt__MutableCollectionsKt.A(treeSet, this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level2) {
        this.level = level2;
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpLoggingInterceptor(Logger logger2, int i11, r rVar) {
        this((i11 & 1) != 0 ? Logger.DEFAULT : logger2);
    }
}
