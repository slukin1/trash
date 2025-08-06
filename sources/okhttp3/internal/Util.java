package okhttp3.internal;

import com.google.common.net.HttpHeaders;
import d10.a;
import d10.l;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;
import r10.b;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
    private static final Regex VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    public static final boolean assertionsEnabled = false;
    public static final String okHttpName = StringsKt__StringsKt.C0(StringsKt__StringsKt.A0(OkHttpClient.class.getName(), "okhttp3."), "Client");
    public static final String userAgent = "okhttp/4.12.0";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        Class<OkHttpClient> cls = OkHttpClient.class;
    }

    public static final <E> void addIfAbsent(List<E> list, E e11) {
        if (!list.contains(e11)) {
            list.add(e11);
        }
    }

    public static final int and(byte b11, int i11) {
        return b11 & i11;
    }

    public static final int and(short s11, int i11) {
        return s11 & i11;
    }

    public static final long and(int i11, long j11) {
        return ((long) i11) & j11;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        return new b(eventListener);
    }

    /* access modifiers changed from: private */
    public static final EventListener asFactory$lambda$8(EventListener eventListener, Call call) {
        return eventListener;
    }

    public static final void assertThreadDoesntHoldLock(Object obj) {
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(Object obj) {
        if (assertionsEnabled && !Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj);
        }
    }

    public static final boolean canParseAsIpAddress(String str) {
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        return x.b(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && x.b(httpUrl.scheme(), httpUrl2.scheme());
    }

    public static final int checkDuration(String str, long j11, TimeUnit timeUnit) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        boolean z11 = true;
        if (i11 >= 0) {
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j11);
                if (millis <= 2147483647L) {
                    if (millis == 0 && i11 > 0) {
                        z11 = false;
                    }
                    if (z11) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException((str + " too small.").toString());
                }
                throw new IllegalArgumentException((str + " too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException((str + " < 0").toString());
    }

    public static final void checkOffsetAndCount(long j11, long j12, long j13) {
        if ((j12 | j13) < 0 || j12 > j11 || j11 - j12 < j13) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String str) {
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
        strArr2[ArraysKt___ArraysKt.L(strArr2)] = str;
        return strArr2;
    }

    public static final int delimiterOffset(String str, String str2, int i11, int i12) {
        while (i11 < i12) {
            if (StringsKt__StringsKt.Q(str2, str.charAt(i11), false, 2, (Object) null)) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = str.length();
        }
        return delimiterOffset(str, str2, i11, i12);
    }

    public static final boolean discard(Source source, int i11, TimeUnit timeUnit) {
        try {
            return skipAll(source, i11, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, l<? super T, Boolean> lVar) {
        List<T> k11 = CollectionsKt__CollectionsKt.k();
        for (Object next : iterable) {
            if (lVar.invoke(next).booleanValue()) {
                if (k11.isEmpty()) {
                    k11 = new ArrayList<>();
                }
                TypeIntrinsics.c(k11).add(next);
            }
        }
        return k11;
    }

    public static final String format(String str, Object... objArr) {
        d0 d0Var = d0.f56774a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    Iterator a11 = h.a(strArr2);
                    while (a11.hasNext()) {
                        if (comparator.compare(str, (String) a11.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1);
        }
        return -1;
    }

    public static final void ignoreIoExceptions(a<Unit> aVar) {
        try {
            aVar.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        Object[] objArr = (Object[]) tArr.clone();
        return Collections.unmodifiableList(CollectionsKt__CollectionsKt.n(Arrays.copyOf(objArr, objArr.length)));
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        int length = strArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (comparator.compare(strArr[i11], str) == 0) {
                return i11;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (x.c(charAt, 31) <= 0 || x.c(charAt, 127) >= 0) {
                return i11;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i11, int i12) {
        while (i11 < i12) {
            char charAt = str.charAt(i11);
            boolean z11 = false;
            if ((((charAt == 9 || charAt == 10) || charAt == 12) || charAt == 13) || charAt == ' ') {
                z11 = true;
            }
            if (!z11) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i11, i12);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i11, int i12) {
        int i13 = i12 - 1;
        if (i11 <= i13) {
            while (true) {
                char charAt = str.charAt(i13);
                boolean z11 = false;
                if ((((charAt == 9 || charAt == 10) || charAt == 12) || charAt == 13) || charAt == ' ') {
                    z11 = true;
                }
                if (z11) {
                    if (i13 == i11) {
                        break;
                    }
                    i13--;
                } else {
                    return i13 + 1;
                }
            }
        }
        return i11;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i11, i12);
    }

    public static final int indexOfNonWhitespace(String str, int i11) {
        int length = str.length();
        while (i11 < length) {
            char charAt = str.charAt(i11);
            if (charAt != ' ' && charAt != 9) {
                return i11;
            }
            i11++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        return indexOfNonWhitespace(str, i11);
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i11]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i11++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        kotlin.io.b.a(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r2 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        kotlin.io.b.a(r0, (java.lang.Throwable) null);
        r3.delete(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isCivilized(okhttp3.internal.io.FileSystem r3, java.io.File r4) {
        /*
            okio.Sink r0 = r3.sink(r4)
            r1 = 0
            r3.delete(r4)     // Catch:{ IOException -> 0x000f }
            r3 = 1
            kotlin.io.b.a(r0, r1)
            return r3
        L_0x000d:
            r3 = move-exception
            goto L_0x0019
        L_0x000f:
            kotlin.Unit r2 = kotlin.Unit.f56620a     // Catch:{ all -> 0x000d }
            kotlin.io.b.a(r0, r1)
            r3.delete(r4)
            r3 = 0
            return r3
        L_0x0019:
            throw r3     // Catch:{ all -> 0x001a }
        L_0x001a:
            r4 = move-exception
            kotlin.io.b.a(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.isCivilized(okhttp3.internal.io.FileSystem, java.io.File):boolean");
    }

    public static final boolean isHealthy(Socket socket, BufferedSource bufferedSource) {
        int soTimeout;
        try {
            soTimeout = socket.getSoTimeout();
            socket.setSoTimeout(1);
            boolean z11 = !bufferedSource.exhausted();
            socket.setSoTimeout(soTimeout);
            return z11;
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        } catch (Throwable th2) {
            socket.setSoTimeout(soTimeout);
            throw th2;
        }
    }

    public static final boolean isSensitiveHeader(String str) {
        if (StringsKt__StringsJVMKt.w(str, "Authorization", true) || StringsKt__StringsJVMKt.w(str, HttpHeaders.COOKIE, true) || StringsKt__StringsJVMKt.w(str, HttpHeaders.PROXY_AUTHORIZATION, true) || StringsKt__StringsJVMKt.w(str, HttpHeaders.SET_COOKIE, true)) {
            return true;
        }
        return false;
    }

    public static final void notify(Object obj) {
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c11) {
        boolean z11 = true;
        if ('0' <= c11 && c11 < ':') {
            return c11 - '0';
        }
        char c12 = 'a';
        if (!('a' <= c11 && c11 < 'g')) {
            c12 = 'A';
            if ('A' > c11 || c11 >= 'G') {
                z11 = false;
            }
            if (!z11) {
                return -1;
            }
        }
        return (c11 - c12) + 10;
    }

    public static final String peerName(Socket socket) {
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        return remoteSocketAddress instanceof InetSocketAddress ? ((InetSocketAddress) remoteSocketAddress).getHostName() : remoteSocketAddress.toString();
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        int select = bufferedSource.select(UNICODE_BOMS);
        if (select == -1) {
            return charset;
        }
        if (select == 0) {
            return StandardCharsets.UTF_8;
        }
        if (select == 1) {
            return StandardCharsets.UTF_16BE;
        }
        if (select == 2) {
            return StandardCharsets.UTF_16LE;
        }
        if (select == 3) {
            return kotlin.text.b.f56907a.a();
        }
        if (select == 4) {
            return kotlin.text.b.f56907a.b();
        }
        throw new AssertionError();
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        Object readFieldOrNull;
        Class<Object> cls2 = Object.class;
        Class cls3 = obj.getClass();
        while (!x.b(cls3, cls2)) {
            try {
                Field declaredField = cls3.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (!cls.isInstance(obj2)) {
                    return null;
                }
                return cls.cast(obj2);
            } catch (NoSuchFieldException unused) {
                cls3 = cls3.getSuperclass();
            }
        }
        if (x.b(str, "delegate") || (readFieldOrNull = readFieldOrNull(obj, cls2, "delegate")) == null) {
            return null;
        }
        return readFieldOrNull(readFieldOrNull, cls, str);
    }

    public static final int readMedium(BufferedSource bufferedSource) throws IOException {
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
        if (r5 == Long.MAX_VALUE) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
        r11.timeout().clearDeadline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        r11.timeout().deadlineNanoTime(r0 + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        if (r5 != Long.MAX_VALUE) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
        return r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean skipAll(okio.Source r11, int r12, java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /*
            long r0 = java.lang.System.nanoTime()
            okio.Timeout r2 = r11.timeout()
            boolean r2 = r2.hasDeadline()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L_0x001d
            okio.Timeout r2 = r11.timeout()
            long r5 = r2.deadlineNanoTime()
            long r5 = r5 - r0
            goto L_0x001e
        L_0x001d:
            r5 = r3
        L_0x001e:
            okio.Timeout r2 = r11.timeout()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.deadlineNanoTime(r12)
            okio.Buffer r12 = new okio.Buffer     // Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
            r12.<init>()     // Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        L_0x0034:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.read(r12, r7)     // Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L_0x0044
            r12.clear()     // Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
            goto L_0x0034
        L_0x0044:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x0051
        L_0x0049:
            okio.Timeout r11 = r11.timeout()
            r11.clearDeadline()
            goto L_0x0076
        L_0x0051:
            okio.Timeout r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
            goto L_0x0076
        L_0x005a:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x0067
            okio.Timeout r11 = r11.timeout()
            r11.clearDeadline()
            goto L_0x006f
        L_0x0067:
            okio.Timeout r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
        L_0x006f:
            throw r12
        L_0x0070:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x0051
            goto L_0x0049
        L_0x0076:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.skipAll(okio.Source, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static final ThreadFactory threadFactory(String str, boolean z11) {
        return new r10.a(str, z11);
    }

    /* access modifiers changed from: private */
    public static final Thread threadFactory$lambda$1(String str, boolean z11, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z11);
        return thread;
    }

    public static final void threadName(String str, a<Unit> aVar) {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            aVar.invoke();
        } finally {
            InlineMarker.b(1);
            currentThread.setName(name);
            InlineMarker.a(1);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        kotlin.ranges.h o11 = RangesKt___RangesKt.o(0, headers.size());
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(o11, 10));
        Iterator it2 = o11.iterator();
        while (it2.hasNext()) {
            int a11 = ((IntIterator) it2).a();
            arrayList.add(new Header(headers.name(a11), headers.value(a11)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        for (Header next : list) {
            builder.addLenient$okhttp(next.component1().utf8(), next.component2().utf8());
        }
        return builder.build();
    }

    public static final String toHexString(long j11) {
        return Long.toHexString(j11);
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z11) {
        String str;
        if (StringsKt__StringsKt.R(httpUrl.host(), ":", false, 2, (Object) null)) {
            str = '[' + httpUrl.host() + ']';
        } else {
            str = httpUrl.host();
        }
        if (!z11 && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return str;
        }
        return str + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return toHostHeader(httpUrl, z11);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        return Collections.unmodifiableList(CollectionsKt___CollectionsKt.L0(list));
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        if (map.isEmpty()) {
            return MapsKt__MapsKt.h();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static final long toLongOrDefault(String str, long j11) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j11;
        }
    }

    public static final int toNonNegativeInt(String str, int i11) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i11;
    }

    public static final String trimSubstring(String str, int i11, int i12) {
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i11, i12);
        return str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i12));
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        return trimSubstring(str, i11, i12);
    }

    public static final void wait(Object obj) {
        obj.wait();
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> list) {
        for (Exception a11 : list) {
            ExceptionsKt__ExceptionsKt.a(exc, a11);
        }
        return exc;
    }

    public static final void writeMedium(BufferedSink bufferedSink, int i11) throws IOException {
        bufferedSink.writeByte((i11 >>> 16) & 255);
        bufferedSink.writeByte((i11 >>> 8) & 255);
        bufferedSink.writeByte(i11 & 255);
    }

    public static final int delimiterOffset(String str, char c11, int i11, int i12) {
        while (i11 < i12) {
            if (str.charAt(i11) == c11) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = str.length();
        }
        return delimiterOffset(str, c11, i11, i12);
    }

    public static final String toHexString(int i11) {
        return Integer.toHexString(i11);
    }

    public static final void closeQuietly(Socket socket) {
        try {
            socket.close();
        } catch (AssertionError e11) {
            throw e11;
        } catch (RuntimeException e12) {
            if (!x.b(e12.getMessage(), "bio == null")) {
                throw e12;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        try {
            serverSocket.close();
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(Buffer buffer, byte b11) {
        int i11 = 0;
        while (!buffer.exhausted() && buffer.getByte(0) == b11) {
            i11++;
            buffer.readByte();
        }
        return i11;
    }
}
