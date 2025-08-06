package fi.iki.elonen;

import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.google.android.exoplayer2.C;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.jumio.commons.log.LogUtils;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import com.twitter.sdk.android.core.internal.network.UrlUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

public abstract class NanoHTTPD {

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f54525h = Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f54526i = Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f54527j = Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");

    /* renamed from: k  reason: collision with root package name */
    public static final Logger f54528k = Logger.getLogger(NanoHTTPD.class.getName());

    /* renamed from: l  reason: collision with root package name */
    public static Map<String, String> f54529l;

    /* renamed from: a  reason: collision with root package name */
    public final String f54530a;

    /* renamed from: b  reason: collision with root package name */
    public final int f54531b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ServerSocket f54532c;

    /* renamed from: d  reason: collision with root package name */
    public l f54533d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f54534e;

    /* renamed from: f  reason: collision with root package name */
    public b f54535f;

    /* renamed from: g  reason: collision with root package name */
    public o f54536g;

    public static class DefaultAsyncRunner implements b {

        /* renamed from: a  reason: collision with root package name */
        public long f54537a;

        /* renamed from: b  reason: collision with root package name */
        public final List<c> f54538b = Collections.synchronizedList(new ArrayList());

        public void a(c cVar) {
            this.f54538b.remove(cVar);
        }

        public void b(c cVar) {
            this.f54537a++;
            Thread thread = new Thread(cVar);
            thread.setDaemon(true);
            thread.setName("NanoHttpd Request Processor (#" + this.f54537a + ")");
            this.f54538b.add(cVar);
            thread.start();
        }

        public void c() {
            Iterator it2 = new ArrayList(this.f54538b).iterator();
            while (it2.hasNext()) {
                ((c) it2.next()).a();
            }
        }
    }

    public static class DefaultServerSocketFactory implements l {
        public ServerSocket create() throws IOException {
            return new ServerSocket();
        }
    }

    public static class DefaultTempFileManager implements n {

        /* renamed from: a  reason: collision with root package name */
        public final File f54539a;

        /* renamed from: b  reason: collision with root package name */
        public final List<m> f54540b;

        public DefaultTempFileManager() {
            File file = new File(System.getProperty("java.io.tmpdir"));
            this.f54539a = file;
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f54540b = new ArrayList();
        }

        public m a(String str) throws Exception {
            g gVar = new g(this.f54539a);
            this.f54540b.add(gVar);
            return gVar;
        }

        public void clear() {
            for (m delete : this.f54540b) {
                try {
                    delete.delete();
                } catch (Exception e11) {
                    NanoHTTPD.f54528k.log(Level.WARNING, "could not delete file ", e11);
                }
            }
            this.f54540b.clear();
        }
    }

    public enum Method {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH,
        PROPFIND,
        PROPPATCH,
        MKCOL,
        MOVE,
        COPY,
        LOCK,
        UNLOCK;

        public static Method lookup(String str) {
            if (str == null) {
                return null;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public static class Response implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        public b f54541b;

        /* renamed from: c  reason: collision with root package name */
        public String f54542c;

        /* renamed from: d  reason: collision with root package name */
        public InputStream f54543d;

        /* renamed from: e  reason: collision with root package name */
        public long f54544e;

        /* renamed from: f  reason: collision with root package name */
        public final Map<String, String> f54545f = new HashMap<String, String>() {
            public String put(String str, String str2) {
                Response.this.f54546g.put(str == null ? str : str.toLowerCase(), str2);
                return (String) super.put(str, str2);
            }
        };

        /* renamed from: g  reason: collision with root package name */
        public final Map<String, String> f54546g = new HashMap();

        /* renamed from: h  reason: collision with root package name */
        public Method f54547h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f54548i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f54549j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f54550k;

        public enum Status implements b {
            SWITCH_PROTOCOL(101, "Switching Protocols"),
            OK(200, "OK"),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(206, "Partial Content"),
            MULTI_STATUS(207, "Multi-Status"),
            REDIRECT(301, "Moved Permanently"),
            FOUND(302, "Found"),
            REDIRECT_SEE_OTHER(303, "See Other"),
            NOT_MODIFIED(304, "Not Modified"),
            TEMPORARY_REDIRECT(307, "Temporary Redirect"),
            BAD_REQUEST(400, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(403, "Forbidden"),
            NOT_FOUND(404, "Not Found"),
            METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
            NOT_ACCEPTABLE(TPNativePlayerInitConfig.BOOL_ENABLE_DROPFRAME_BY_REFRESHRATE, "Not Acceptable"),
            REQUEST_TIMEOUT(408, "Request Timeout"),
            CONFLICT(409, "Conflict"),
            GONE(410, "Gone"),
            LENGTH_REQUIRED(411, "Length Required"),
            PRECONDITION_FAILED(412, "Precondition Failed"),
            PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
            UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            EXPECTATION_FAILED(417, "Expectation Failed"),
            TOO_MANY_REQUESTS(429, "Too Many Requests"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(501, "Not Implemented"),
            SERVICE_UNAVAILABLE(503, "Service Unavailable"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");
            
            private final String description;
            private final int requestStatus;

            private Status(int i11, String str) {
                this.requestStatus = i11;
                this.description = str;
            }

            public static Status lookup(int i11) {
                for (Status status : values()) {
                    if (status.getRequestStatus() == i11) {
                        return status;
                    }
                }
                return null;
            }

            public String getDescription() {
                return "" + this.requestStatus + " " + this.description;
            }

            public int getRequestStatus() {
                return this.requestStatus;
            }
        }

        public static class a extends FilterOutputStream {
            public a(OutputStream outputStream) {
                super(outputStream);
            }

            public void a() throws IOException {
                this.out.write("0\r\n\r\n".getBytes());
            }

            public void write(int i11) throws IOException {
                write(new byte[]{(byte) i11}, 0, 1);
            }

            public void write(byte[] bArr) throws IOException {
                write(bArr, 0, bArr.length);
            }

            public void write(byte[] bArr, int i11, int i12) throws IOException {
                if (i12 != 0) {
                    this.out.write(String.format("%x\r\n", new Object[]{Integer.valueOf(i12)}).getBytes());
                    this.out.write(bArr, i11, i12);
                    this.out.write(LogUtils.NEW_LINE.getBytes());
                }
            }
        }

        public interface b {
            String getDescription();
        }

        public Response(b bVar, String str, InputStream inputStream, long j11) {
            this.f54541b = bVar;
            this.f54542c = str;
            boolean z11 = false;
            if (inputStream == null) {
                this.f54543d = new ByteArrayInputStream(new byte[0]);
                this.f54544e = 0;
            } else {
                this.f54543d = inputStream;
                this.f54544e = j11;
            }
            this.f54548i = this.f54544e < 0 ? true : z11;
            this.f54550k = true;
        }

        public void b(String str, String str2) {
            this.f54545f.put(str, str2);
        }

        public void close() throws IOException {
            InputStream inputStream = this.f54543d;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public String e(String str) {
            return this.f54546g.get(str.toLowerCase());
        }

        public String f() {
            return this.f54542c;
        }

        public boolean g() {
            return "close".equals(e("connection"));
        }

        public void j(PrintWriter printWriter, String str, String str2) {
            printWriter.append(str).append(com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b).append(str2).append(LogUtils.NEW_LINE);
        }

        public void k(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.f54541b != null) {
                    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, new d(this.f54542c).e())), false);
                    printWriter.append("HTTP/1.1 ").append(this.f54541b.getDescription()).append(" \r\n");
                    String str = this.f54542c;
                    if (str != null) {
                        j(printWriter, "Content-Type", str);
                    }
                    if (e(MessageKey.MSG_DATE) == null) {
                        j(printWriter, HttpHeaders.DATE, simpleDateFormat.format(new Date()));
                    }
                    for (Map.Entry next : this.f54545f.entrySet()) {
                        j(printWriter, (String) next.getKey(), (String) next.getValue());
                    }
                    if (e("connection") == null) {
                        j(printWriter, HttpHeaders.CONNECTION, this.f54550k ? "keep-alive" : "close");
                    }
                    if (e("content-length") != null) {
                        this.f54549j = false;
                    }
                    if (this.f54549j) {
                        j(printWriter, HttpHeaders.CONTENT_ENCODING, DecompressionHelper.GZIP_ENCODING);
                        p(true);
                    }
                    long j11 = this.f54543d != null ? this.f54544e : 0;
                    if (this.f54547h != Method.HEAD && this.f54548i) {
                        j(printWriter, HttpHeaders.TRANSFER_ENCODING, "chunked");
                    } else if (!this.f54549j) {
                        j11 = o(printWriter, j11);
                    }
                    printWriter.append(LogUtils.NEW_LINE);
                    printWriter.flush();
                    n(outputStream, j11);
                    outputStream.flush();
                    NanoHTTPD.t(this.f54543d);
                    return;
                }
                throw new Error("sendResponse(): Status can't be null.");
            } catch (IOException e11) {
                NanoHTTPD.f54528k.log(Level.SEVERE, "Could not send response to the client", e11);
            }
        }

        public final void l(OutputStream outputStream, long j11) throws IOException {
            long j12;
            byte[] bArr = new byte[((int) 16384)];
            boolean z11 = j11 == -1;
            while (true) {
                if (j11 > 0 || z11) {
                    if (z11) {
                        j12 = 16384;
                    } else {
                        j12 = Math.min(j11, 16384);
                    }
                    int read = this.f54543d.read(bArr, 0, (int) j12);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        if (!z11) {
                            j11 -= (long) read;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public final void m(OutputStream outputStream, long j11) throws IOException {
            if (this.f54549j) {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                l(gZIPOutputStream, -1);
                gZIPOutputStream.finish();
                return;
            }
            l(outputStream, j11);
        }

        public final void n(OutputStream outputStream, long j11) throws IOException {
            if (this.f54547h == Method.HEAD || !this.f54548i) {
                m(outputStream, j11);
                return;
            }
            a aVar = new a(outputStream);
            m(aVar, -1);
            aVar.a();
        }

        public long o(PrintWriter printWriter, long j11) {
            String e11 = e("content-length");
            if (e11 != null) {
                try {
                    j11 = Long.parseLong(e11);
                } catch (NumberFormatException unused) {
                    Logger c11 = NanoHTTPD.f54528k;
                    c11.severe("content-length was no number " + e11);
                }
            }
            printWriter.print("Content-Length: " + j11 + LogUtils.NEW_LINE);
            return j11;
        }

        public void p(boolean z11) {
            this.f54548i = z11;
        }

        public void r(boolean z11) {
            this.f54549j = z11;
        }

        public void s(boolean z11) {
            this.f54550k = z11;
        }

        public void t(Method method) {
            this.f54547h = method;
        }
    }

    public interface b {
        void a(c cVar);

        void b(c cVar);

        void c();
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final InputStream f54551b;

        /* renamed from: c  reason: collision with root package name */
        public final Socket f54552c;

        public c(InputStream inputStream, Socket socket) {
            this.f54551b = inputStream;
            this.f54552c = socket;
        }

        public void a() {
            NanoHTTPD.t(this.f54551b);
            NanoHTTPD.t(this.f54552c);
        }

        public void run() {
            OutputStream outputStream = null;
            try {
                outputStream = this.f54552c.getOutputStream();
                i iVar = new i(NanoHTTPD.this.f54536g.create(), this.f54551b, outputStream, this.f54552c.getInetAddress());
                while (!this.f54552c.isClosed()) {
                    iVar.h();
                }
            } catch (Exception e11) {
                if ((!(e11 instanceof SocketException) || !"NanoHttpd Shutdown".equals(e11.getMessage())) && !(e11 instanceof SocketTimeoutException)) {
                    NanoHTTPD.f54528k.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", e11);
                }
            } catch (Throwable th2) {
                NanoHTTPD.t((Object) null);
                NanoHTTPD.t(this.f54551b);
                NanoHTTPD.t(this.f54552c);
                NanoHTTPD.this.f54535f.a(this);
                throw th2;
            }
            NanoHTTPD.t(outputStream);
            NanoHTTPD.t(this.f54551b);
            NanoHTTPD.t(this.f54552c);
            NanoHTTPD.this.f54535f.a(this);
        }
    }

    public static class d {

        /* renamed from: e  reason: collision with root package name */
        public static final Pattern f54554e = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);

        /* renamed from: f  reason: collision with root package name */
        public static final Pattern f54555f = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

        /* renamed from: g  reason: collision with root package name */
        public static final Pattern f54556g = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

        /* renamed from: a  reason: collision with root package name */
        public final String f54557a;

        /* renamed from: b  reason: collision with root package name */
        public final String f54558b;

        /* renamed from: c  reason: collision with root package name */
        public final String f54559c;

        /* renamed from: d  reason: collision with root package name */
        public final String f54560d;

        public d(String str) {
            this.f54557a = str;
            if (str != null) {
                this.f54558b = d(str, f54554e, "", 1);
                this.f54559c = d(str, f54555f, (String) null, 2);
            } else {
                this.f54558b = "";
                this.f54559c = "UTF-8";
            }
            if ("multipart/form-data".equalsIgnoreCase(this.f54558b)) {
                this.f54560d = d(str, f54556g, (String) null, 2);
            } else {
                this.f54560d = null;
            }
        }

        public String a() {
            return this.f54560d;
        }

        public String b() {
            return this.f54558b;
        }

        public String c() {
            return this.f54557a;
        }

        public final String d(String str, Pattern pattern, String str2, int i11) {
            Matcher matcher = pattern.matcher(str);
            return matcher.find() ? matcher.group(i11) : str2;
        }

        public String e() {
            String str = this.f54559c;
            return str == null ? C.ASCII_NAME : str;
        }

        public boolean f() {
            return "multipart/form-data".equalsIgnoreCase(this.f54558b);
        }

        public d g() {
            if (this.f54559c != null) {
                return this;
            }
            return new d(this.f54557a + "; charset=UTF-8");
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f54561a;

        /* renamed from: b  reason: collision with root package name */
        public final String f54562b;

        /* renamed from: c  reason: collision with root package name */
        public final String f54563c;

        public String a() {
            return String.format("%s=%s; expires=%s", new Object[]{this.f54561a, this.f54562b, this.f54563c});
        }
    }

    public class f implements Iterable<String> {

        /* renamed from: b  reason: collision with root package name */
        public final HashMap<String, String> f54564b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f54565c = new ArrayList<>();

        public f(Map<String, String> map) {
            String str = map.get("cookie");
            if (str != null) {
                for (String trim : str.split(";")) {
                    String[] split = trim.trim().split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split.length == 2) {
                        this.f54564b.put(split[0], split[1]);
                    }
                }
            }
        }

        public void a(Response response) {
            Iterator<e> it2 = this.f54565c.iterator();
            while (it2.hasNext()) {
                response.b(HttpHeaders.SET_COOKIE, it2.next().a());
            }
        }

        public Iterator<String> iterator() {
            return this.f54564b.keySet().iterator();
        }
    }

    public static class g implements m {

        /* renamed from: a  reason: collision with root package name */
        public final File f54567a;

        /* renamed from: b  reason: collision with root package name */
        public final OutputStream f54568b;

        public g(File file) throws IOException {
            File createTempFile = File.createTempFile("NanoHTTPD-", "", file);
            this.f54567a = createTempFile;
            this.f54568b = new FileOutputStream(createTempFile);
        }

        public void delete() throws Exception {
            NanoHTTPD.t(this.f54568b);
            if (!this.f54567a.delete()) {
                throw new Exception("could not delete temporary file: " + this.f54567a.getAbsolutePath());
            }
        }

        public String getName() {
            return this.f54567a.getAbsolutePath();
        }
    }

    public class h implements o {
        public h() {
        }

        public n create() {
            return new DefaultTempFileManager();
        }
    }

    public class i implements j {

        /* renamed from: a  reason: collision with root package name */
        public final n f54570a;

        /* renamed from: b  reason: collision with root package name */
        public final OutputStream f54571b;

        /* renamed from: c  reason: collision with root package name */
        public final BufferedInputStream f54572c;

        /* renamed from: d  reason: collision with root package name */
        public int f54573d;

        /* renamed from: e  reason: collision with root package name */
        public int f54574e;

        /* renamed from: f  reason: collision with root package name */
        public String f54575f;

        /* renamed from: g  reason: collision with root package name */
        public Method f54576g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, List<String>> f54577h;

        /* renamed from: i  reason: collision with root package name */
        public Map<String, String> f54578i;

        /* renamed from: j  reason: collision with root package name */
        public f f54579j;

        /* renamed from: k  reason: collision with root package name */
        public String f54580k;

        /* renamed from: l  reason: collision with root package name */
        public String f54581l;

        /* renamed from: m  reason: collision with root package name */
        public String f54582m;

        /* renamed from: n  reason: collision with root package name */
        public String f54583n;

        public i(n nVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
            this.f54570a = nVar;
            this.f54572c = new BufferedInputStream(inputStream, 8192);
            this.f54571b = outputStream;
            this.f54581l = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
            this.f54582m = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "localhost" : inetAddress.getHostName().toString();
            this.f54578i = new HashMap();
        }

        public final Method a() {
            return this.f54576g;
        }

        @Deprecated
        public final Map<String, String> b() {
            HashMap hashMap = new HashMap();
            for (String next : this.f54577h.keySet()) {
                hashMap.put(next, this.f54577h.get(next).get(0));
            }
            return hashMap;
        }

        public void c(Map<String, String> map) throws IOException, ResponseException {
            DataOutputStream dataOutputStream;
            RandomAccessFile randomAccessFile;
            ByteArrayOutputStream byteArrayOutputStream;
            ByteBuffer byteBuffer;
            Map<String, String> map2 = map;
            RandomAccessFile randomAccessFile2 = null;
            try {
                long j11 = j();
                if (j11 < 1024) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    randomAccessFile = null;
                } else {
                    randomAccessFile = l();
                    byteArrayOutputStream = null;
                    dataOutputStream = randomAccessFile;
                }
                try {
                    byte[] bArr = new byte[512];
                    while (this.f54574e >= 0 && j11 > 0) {
                        int read = this.f54572c.read(bArr, 0, (int) Math.min(j11, 512));
                        this.f54574e = read;
                        j11 -= (long) read;
                        if (read > 0) {
                            dataOutputStream.write(bArr, 0, read);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteBuffer = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                    } else {
                        byteBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile.length());
                        randomAccessFile.seek(0);
                    }
                    if (Method.POST.equals(this.f54576g)) {
                        d dVar = new d(this.f54578i.get("content-type"));
                        if (!dVar.f()) {
                            byte[] bArr2 = new byte[byteBuffer.remaining()];
                            byteBuffer.get(bArr2);
                            String trim = new String(bArr2, dVar.e()).trim();
                            if ("application/x-www-form-urlencoded".equalsIgnoreCase(dVar.b())) {
                                g(trim, this.f54577h);
                            } else if (trim.length() != 0) {
                                map2.put("postData", trim);
                            }
                        } else if (dVar.a() != null) {
                            f(dVar, byteBuffer, this.f54577h, map2);
                        } else {
                            throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                        }
                    } else if (Method.PUT.equals(this.f54576g)) {
                        map2.put("content", m(byteBuffer, 0, byteBuffer.limit(), (String) null));
                    }
                    NanoHTTPD.t(randomAccessFile);
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile2 = randomAccessFile;
                    NanoHTTPD.t(randomAccessFile2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                NanoHTTPD.t(randomAccessFile2);
                throw th;
            }
        }

        public String d() {
            return this.f54580k;
        }

        public final void e(BufferedReader bufferedReader, Map<String, String> map, Map<String, List<String>> map2, Map<String, String> map3) throws ResponseException {
            String str;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                    if (stringTokenizer.hasMoreTokens()) {
                        map.put("method", stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            String nextToken = stringTokenizer.nextToken();
                            int indexOf = nextToken.indexOf(63);
                            if (indexOf >= 0) {
                                g(nextToken.substring(indexOf + 1), map2);
                                str = NanoHTTPD.l(nextToken.substring(0, indexOf));
                            } else {
                                str = NanoHTTPD.l(nextToken);
                            }
                            if (stringTokenizer.hasMoreTokens()) {
                                this.f54583n = stringTokenizer.nextToken();
                            } else {
                                this.f54583n = "HTTP/1.1";
                                NanoHTTPD.f54528k.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                            }
                            String readLine2 = bufferedReader.readLine();
                            while (readLine2 != null && !readLine2.trim().isEmpty()) {
                                int indexOf2 = readLine2.indexOf(58);
                                if (indexOf2 >= 0) {
                                    map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                                }
                                readLine2 = bufferedReader.readLine();
                            }
                            map.put(ShareConstants.MEDIA_URI, str);
                            return;
                        }
                        throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                    }
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
            } catch (IOException e11) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                throw new ResponseException(status, "SERVER INTERNAL ERROR: IOException: " + e11.getMessage(), e11);
            }
        }

        public final void f(d dVar, ByteBuffer byteBuffer, Map<String, List<String>> map, Map<String, String> map2) throws ResponseException {
            int i11;
            String str;
            ByteBuffer byteBuffer2 = byteBuffer;
            Map<String, List<String>> map3 = map;
            Map<String, String> map4 = map2;
            try {
                int[] k11 = k(byteBuffer2, dVar.a().getBytes());
                int i12 = 2;
                if (k11.length >= 2) {
                    int i13 = 1024;
                    byte[] bArr = new byte[1024];
                    int i14 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    while (true) {
                        int i17 = 1;
                        if (i15 < k11.length - 1) {
                            byteBuffer2.position(k11[i15]);
                            int remaining = byteBuffer.remaining() < i13 ? byteBuffer.remaining() : i13;
                            byteBuffer2.get(bArr, i14, remaining);
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i14, remaining), Charset.forName(dVar.e())), remaining);
                            String readLine = bufferedReader.readLine();
                            if (readLine != null && readLine.contains(dVar.a())) {
                                String readLine2 = bufferedReader.readLine();
                                String str2 = null;
                                int i18 = i12;
                                String str3 = null;
                                String str4 = null;
                                while (readLine2 != null && readLine2.trim().length() > 0) {
                                    Matcher matcher = NanoHTTPD.f54525h.matcher(readLine2);
                                    if (matcher.matches()) {
                                        Matcher matcher2 = NanoHTTPD.f54527j.matcher(matcher.group(i12));
                                        while (matcher2.find()) {
                                            String group = matcher2.group(i17);
                                            if ("name".equalsIgnoreCase(group)) {
                                                str = matcher2.group(2);
                                            } else {
                                                if ("filename".equalsIgnoreCase(group)) {
                                                    String group2 = matcher2.group(2);
                                                    if (!group2.isEmpty()) {
                                                        if (i16 > 0) {
                                                            str = str2 + String.valueOf(i16);
                                                            str3 = group2;
                                                            i16++;
                                                        } else {
                                                            i16++;
                                                        }
                                                    }
                                                    str3 = group2;
                                                }
                                                i17 = 1;
                                            }
                                            str2 = str;
                                            i17 = 1;
                                        }
                                    }
                                    Matcher matcher3 = NanoHTTPD.f54526i.matcher(readLine2);
                                    if (matcher3.matches()) {
                                        i11 = 2;
                                        str4 = matcher3.group(2).trim();
                                    } else {
                                        i11 = 2;
                                    }
                                    readLine2 = bufferedReader.readLine();
                                    i18++;
                                    i12 = i11;
                                    i17 = 1;
                                }
                                int i19 = i12;
                                int i21 = 0;
                                while (true) {
                                    int i22 = i18 - 1;
                                    if (i18 <= 0) {
                                        break;
                                    }
                                    i21 = n(bArr, i21);
                                    i18 = i22;
                                }
                                if (i21 < remaining - 4) {
                                    int i23 = k11[i15] + i21;
                                    i15++;
                                    int i24 = k11[i15] - 4;
                                    byteBuffer2.position(i23);
                                    List list = map3.get(str2);
                                    if (list == null) {
                                        list = new ArrayList();
                                        map3.put(str2, list);
                                    }
                                    if (str4 == null) {
                                        byte[] bArr2 = new byte[(i24 - i23)];
                                        byteBuffer2.get(bArr2);
                                        list.add(new String(bArr2, dVar.e()));
                                    } else {
                                        String m11 = m(byteBuffer2, i23, i24 - i23, str3);
                                        if (!map4.containsKey(str2)) {
                                            map4.put(str2, m11);
                                        } else {
                                            int i25 = i19;
                                            while (true) {
                                                if (!map4.containsKey(str2 + i25)) {
                                                    break;
                                                }
                                                i25++;
                                            }
                                            map4.put(str2 + i25, m11);
                                        }
                                        list.add(str3);
                                    }
                                    i12 = i19;
                                    i13 = 1024;
                                    i14 = 0;
                                } else {
                                    throw new ResponseException(Response.Status.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                }
                throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
            } catch (ResponseException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new ResponseException(Response.Status.INTERNAL_ERROR, e12.toString());
            }
        }

        public final void g(String str, Map<String, List<String>> map) {
            String str2;
            String str3;
            if (str == null) {
                this.f54580k = "";
                return;
            }
            this.f54580k = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, ContainerUtils.FIELD_DELIMITER);
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    str3 = NanoHTTPD.l(nextToken.substring(0, indexOf)).trim();
                    str2 = NanoHTTPD.l(nextToken.substring(indexOf + 1));
                } else {
                    str3 = NanoHTTPD.l(nextToken).trim();
                    str2 = "";
                }
                List list = map.get(str3);
                if (list == null) {
                    list = new ArrayList();
                    map.put(str3, list);
                }
                list.add(str2);
            }
        }

        public final Map<String, String> getHeaders() {
            return this.f54578i;
        }

        public final String getUri() {
            return this.f54575f;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0173, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            fi.iki.elonen.NanoHTTPD.s(r0.getStatus(), "text/plain", r0.getMessage()).k(r10.f54571b);
            fi.iki.elonen.NanoHTTPD.a(r10.f54571b);
         */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0173 A[ExcHandler: ResponseException (r0v14 'e' fi.iki.elonen.NanoHTTPD$ResponseException A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h() throws java.io.IOException {
            /*
                r10 = this;
                java.lang.String r0 = "method"
                java.lang.String r1 = "NanoHttpd Shutdown"
                java.lang.String r2 = "text/plain"
                r3 = 8192(0x2000, float:1.14794E-41)
                r4 = 0
                byte[] r5 = new byte[r3]     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r6 = 0
                r10.f54573d = r6     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.f54574e = r6     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.BufferedInputStream r7 = r10.f54572c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r7.mark(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.BufferedInputStream r7 = r10.f54572c     // Catch:{ SSLException -> 0x016f, IOException -> 0x015f, ResponseException -> 0x0173 }
                int r3 = r7.read(r5, r6, r3)     // Catch:{ SSLException -> 0x016f, IOException -> 0x015f, ResponseException -> 0x0173 }
                r7 = -1
                if (r3 == r7) goto L_0x014f
            L_0x001e:
                if (r3 <= 0) goto L_0x0039
                int r7 = r10.f54574e     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r7 = r7 + r3
                r10.f54574e = r7     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r3 = r10.i(r5, r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.f54573d = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 <= 0) goto L_0x002e
                goto L_0x0039
            L_0x002e:
                java.io.BufferedInputStream r3 = r10.f54572c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r7 = r10.f54574e     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r8 = 8192 - r7
                int r3 = r3.read(r5, r7, r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                goto L_0x001e
            L_0x0039:
                int r3 = r10.f54573d     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r7 = r10.f54574e     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 >= r7) goto L_0x004c
                java.io.BufferedInputStream r3 = r10.f54572c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.reset()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.BufferedInputStream r3 = r10.f54572c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r7 = r10.f54573d     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                long r7 = (long) r7     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.skip(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x004c:
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.f54577h = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.lang.String> r3 = r10.f54578i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 != 0) goto L_0x005f
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.f54578i = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                goto L_0x0062
            L_0x005f:
                r3.clear()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x0062:
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r9 = r10.f54574e     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r8.<init>(r5, r6, r9)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r7.<init>(r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.<init>(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.HashMap r5 = new java.util.HashMap     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r5.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7 = r10.f54577h     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.lang.String> r8 = r10.f54578i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.e(r3, r5, r7, r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = r10.f54581l     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 == 0) goto L_0x0093
                java.util.Map<java.lang.String, java.lang.String> r7 = r10.f54578i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r8 = "remote-addr"
                r7.put(r8, r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.lang.String> r3 = r10.f54578i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r7 = "http-client-ip"
                java.lang.String r8 = r10.f54581l     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.put(r7, r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x0093:
                java.lang.Object r3 = r5.get(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$Method r3 = fi.iki.elonen.NanoHTTPD.Method.lookup(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.f54576g = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 == 0) goto L_0x012b
                java.lang.String r0 = "uri"
                java.lang.Object r0 = r5.get(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.f54575f = r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$f r0 = new fi.iki.elonen.NanoHTTPD$f     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD r3 = fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.lang.String> r5 = r10.f54578i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r0.<init>(r5)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.f54579j = r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.lang.String> r0 = r10.f54578i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = "connection"
                java.lang.Object r0 = r0.get(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = "HTTP/1.1"
                java.lang.String r5 = r10.f54583n     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                boolean r3 = r3.equals(r5)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r5 = 1
                if (r3 == 0) goto L_0x00d7
                if (r0 == 0) goto L_0x00d5
                java.lang.String r3 = "(?i).*close.*"
                boolean r0 = r0.matches(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r0 != 0) goto L_0x00d7
            L_0x00d5:
                r0 = r5
                goto L_0x00d8
            L_0x00d7:
                r0 = r6
            L_0x00d8:
                fi.iki.elonen.NanoHTTPD r3 = fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$Response r4 = r3.u(r10)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r4 == 0) goto L_0x0121
                java.util.Map<java.lang.String, java.lang.String> r3 = r10.f54578i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r7 = "accept-encoding"
                java.lang.Object r3 = r3.get(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$f r7 = r10.f54579j     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r7.a(r4)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$Method r7 = r10.f54576g     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r4.t(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD r7 = fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                boolean r7 = r7.C(r4)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r7 == 0) goto L_0x0107
                if (r3 == 0) goto L_0x0107
                java.lang.String r7 = "gzip"
                boolean r3 = r3.contains(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 == 0) goto L_0x0107
                r6 = r5
            L_0x0107:
                r4.r(r6)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r4.s(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.OutputStream r3 = r10.f54571b     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r4.k(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r0 == 0) goto L_0x011b
                boolean r0 = r4.g()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r0 != 0) goto L_0x011b
                goto L_0x018a
            L_0x011b:
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r0.<init>(r1)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x0121:
                fi.iki.elonen.NanoHTTPD$ResponseException r0 = new fi.iki.elonen.NanoHTTPD$ResponseException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$Response$Status r1 = fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = "SERVER INTERNAL ERROR: Serve() returned a null response."
                r0.<init>(r1, r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x012b:
                fi.iki.elonen.NanoHTTPD$ResponseException r1 = new fi.iki.elonen.NanoHTTPD$ResponseException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$Response$Status r3 = fi.iki.elonen.NanoHTTPD.Response.Status.BAD_REQUEST     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r6.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r7 = "BAD REQUEST: Syntax error. HTTP verb "
                r6.append(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.Object r0 = r5.get(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r6.append(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r0 = " unhandled."
                r6.append(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r0 = r6.toString()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r1.<init>(r3, r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                throw r1     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x014f:
                java.io.BufferedInputStream r0 = r10.f54572c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD.t(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.OutputStream r0 = r10.f54571b     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD.t(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r0.<init>(r1)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x015f:
                java.io.BufferedInputStream r0 = r10.f54572c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD.t(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.OutputStream r0 = r10.f54571b     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD.t(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r0.<init>(r1)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x016f:
                r0 = move-exception
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x0171:
                r0 = move-exception
                goto L_0x01e6
            L_0x0173:
                r0 = move-exception
                fi.iki.elonen.NanoHTTPD$Response$Status r1 = r0.getStatus()     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0171 }
                fi.iki.elonen.NanoHTTPD$Response r0 = fi.iki.elonen.NanoHTTPD.s(r1, r2, r0)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r1 = r10.f54571b     // Catch:{ all -> 0x0171 }
                r0.k(r1)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r0 = r10.f54571b     // Catch:{ all -> 0x0171 }
                fi.iki.elonen.NanoHTTPD.t(r0)     // Catch:{ all -> 0x0171 }
            L_0x018a:
                fi.iki.elonen.NanoHTTPD.t(r4)
                fi.iki.elonen.NanoHTTPD$n r0 = r10.f54570a
                r0.clear()
                goto L_0x01e1
            L_0x0193:
                r0 = move-exception
                fi.iki.elonen.NanoHTTPD$Response$Status r1 = fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ all -> 0x0171 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0171 }
                r3.<init>()     // Catch:{ all -> 0x0171 }
                java.lang.String r5 = "SERVER INTERNAL ERROR: IOException: "
                r3.append(r5)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0171 }
                r3.append(r0)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0171 }
                fi.iki.elonen.NanoHTTPD$Response r0 = fi.iki.elonen.NanoHTTPD.s(r1, r2, r0)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r1 = r10.f54571b     // Catch:{ all -> 0x0171 }
                r0.k(r1)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r0 = r10.f54571b     // Catch:{ all -> 0x0171 }
                fi.iki.elonen.NanoHTTPD.t(r0)     // Catch:{ all -> 0x0171 }
                goto L_0x018a
            L_0x01ba:
                r0 = move-exception
                fi.iki.elonen.NanoHTTPD$Response$Status r1 = fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ all -> 0x0171 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0171 }
                r3.<init>()     // Catch:{ all -> 0x0171 }
                java.lang.String r5 = "SSL PROTOCOL FAILURE: "
                r3.append(r5)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0171 }
                r3.append(r0)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0171 }
                fi.iki.elonen.NanoHTTPD$Response r0 = fi.iki.elonen.NanoHTTPD.s(r1, r2, r0)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r1 = r10.f54571b     // Catch:{ all -> 0x0171 }
                r0.k(r1)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r0 = r10.f54571b     // Catch:{ all -> 0x0171 }
                fi.iki.elonen.NanoHTTPD.t(r0)     // Catch:{ all -> 0x0171 }
                goto L_0x018a
            L_0x01e1:
                return
            L_0x01e2:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0171 }
            L_0x01e4:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0171 }
            L_0x01e6:
                fi.iki.elonen.NanoHTTPD.t(r4)
                fi.iki.elonen.NanoHTTPD$n r1 = r10.f54570a
                r1.clear()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: fi.iki.elonen.NanoHTTPD.i.h():void");
        }

        public final int i(byte[] bArr, int i11) {
            int i12;
            int i13 = 0;
            while (true) {
                int i14 = i13 + 1;
                if (i14 >= i11) {
                    return 0;
                }
                if (bArr[i13] == 13 && bArr[i14] == 10 && (i12 = i13 + 3) < i11 && bArr[i13 + 2] == 13 && bArr[i12] == 10) {
                    return i13 + 4;
                }
                if (bArr[i13] == 10 && bArr[i14] == 10) {
                    return i13 + 2;
                }
                i13 = i14;
            }
        }

        public long j() {
            if (this.f54578i.containsKey("content-length")) {
                return Long.parseLong(this.f54578i.get("content-length"));
            }
            int i11 = this.f54573d;
            int i12 = this.f54574e;
            if (i11 < i12) {
                return (long) (i12 - i11);
            }
            return 0;
        }

        public final int[] k(ByteBuffer byteBuffer, byte[] bArr) {
            int[] iArr = new int[0];
            if (byteBuffer.remaining() < bArr.length) {
                return iArr;
            }
            int length = bArr.length + 4096;
            byte[] bArr2 = new byte[length];
            int remaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
            byteBuffer.get(bArr2, 0, remaining);
            int length2 = remaining - bArr.length;
            int i11 = 0;
            do {
                int i12 = 0;
                while (i12 < length2) {
                    int i13 = 0;
                    while (i13 < bArr.length && bArr2[i12 + i13] == bArr[i13]) {
                        if (i13 == bArr.length - 1) {
                            int[] iArr2 = new int[(iArr.length + 1)];
                            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                            iArr2[iArr.length] = i11 + i12;
                            iArr = iArr2;
                        }
                        i13++;
                    }
                    i12++;
                }
                i11 += length2;
                System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
                length2 = length - bArr.length;
                if (byteBuffer.remaining() < length2) {
                    length2 = byteBuffer.remaining();
                }
                byteBuffer.get(bArr2, bArr.length, length2);
            } while (length2 > 0);
            return iArr;
        }

        public final RandomAccessFile l() {
            try {
                return new RandomAccessFile(this.f54570a.a((String) null).getName(), "rw");
            } catch (Exception e11) {
                throw new Error(e11);
            }
        }

        public final String m(ByteBuffer byteBuffer, int i11, int i12, String str) {
            if (i12 <= 0) {
                return "";
            }
            FileOutputStream fileOutputStream = null;
            try {
                m a11 = this.f54570a.a(str);
                ByteBuffer duplicate = byteBuffer.duplicate();
                FileOutputStream fileOutputStream2 = new FileOutputStream(a11.getName());
                try {
                    FileChannel channel = fileOutputStream2.getChannel();
                    duplicate.position(i11).limit(i11 + i12);
                    channel.write(duplicate.slice());
                    String name = a11.getName();
                    NanoHTTPD.t(fileOutputStream2);
                    return name;
                } catch (Exception e11) {
                    e = e11;
                    fileOutputStream = fileOutputStream2;
                    try {
                        throw new Error(e);
                    } catch (Throwable th2) {
                        th = th2;
                        NanoHTTPD.t(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    NanoHTTPD.t(fileOutputStream);
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
                throw new Error(e);
            }
        }

        public final int n(byte[] bArr, int i11) {
            while (bArr[i11] != 10) {
                i11++;
            }
            return i11 + 1;
        }
    }

    public interface j {
        Method a();

        @Deprecated
        Map<String, String> b();

        void c(Map<String, String> map) throws IOException, ResponseException;

        String d();

        Map<String, String> getHeaders();

        String getUri();
    }

    public class k implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final int f54585b;

        /* renamed from: c  reason: collision with root package name */
        public IOException f54586c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f54587d = false;

        public k(int i11) {
            this.f54585b = i11;
        }

        public void run() {
            try {
                NanoHTTPD.this.f54532c.bind(NanoHTTPD.this.f54530a != null ? new InetSocketAddress(NanoHTTPD.this.f54530a, NanoHTTPD.this.f54531b) : new InetSocketAddress(NanoHTTPD.this.f54531b));
                this.f54587d = true;
                do {
                    try {
                        Socket accept = NanoHTTPD.this.f54532c.accept();
                        int i11 = this.f54585b;
                        if (i11 > 0) {
                            accept.setSoTimeout(i11);
                        }
                        InputStream inputStream = accept.getInputStream();
                        NanoHTTPD nanoHTTPD = NanoHTTPD.this;
                        nanoHTTPD.f54535f.b(nanoHTTPD.j(accept, inputStream));
                    } catch (IOException e11) {
                        NanoHTTPD.f54528k.log(Level.FINE, "Communication with the client broken", e11);
                    }
                } while (!NanoHTTPD.this.f54532c.isClosed());
            } catch (IOException e12) {
                this.f54586c = e12;
            }
        }
    }

    public interface l {
        ServerSocket create() throws IOException;
    }

    public interface m {
        void delete() throws Exception;

        String getName();
    }

    public interface n {
        m a(String str) throws Exception;

        void clear();
    }

    public interface o {
        n create();
    }

    public NanoHTTPD(int i11) {
        this((String) null, i11);
    }

    public static String l(String str) {
        try {
            return URLDecoder.decode(str, UrlUtils.UTF8);
        } catch (UnsupportedEncodingException e11) {
            f54528k.log(Level.WARNING, "Encoding not supported, ignored", e11);
            return null;
        }
    }

    public static String m(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = lastIndexOf >= 0 ? p().get(str.substring(lastIndexOf + 1).toLowerCase()) : null;
        return str2 == null ? "application/octet-stream" : str2;
    }

    public static void o(Map<String, String> map, String str) {
        InputStream inputStream;
        try {
            Enumeration<URL> resources = NanoHTTPD.class.getClassLoader().getResources(str);
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                Properties properties = new Properties();
                inputStream = null;
                try {
                    inputStream = nextElement.openStream();
                    properties.load(inputStream);
                } catch (IOException e11) {
                    Logger logger = f54528k;
                    Level level = Level.SEVERE;
                    logger.log(level, "could not load mimetypes from " + nextElement, e11);
                }
                t(inputStream);
                map.putAll(properties);
            }
        } catch (IOException unused) {
            Logger logger2 = f54528k;
            Level level2 = Level.INFO;
            logger2.log(level2, "no mime types available at " + str);
        } catch (Throwable th2) {
            t(inputStream);
            throw th2;
        }
    }

    public static Map<String, String> p() {
        if (f54529l == null) {
            HashMap hashMap = new HashMap();
            f54529l = hashMap;
            o(hashMap, "META-INF/nanohttpd/default-mimetypes.properties");
            o(f54529l, "META-INF/nanohttpd/mimetypes.properties");
            if (f54529l.isEmpty()) {
                f54528k.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
            }
        }
        return f54529l;
    }

    public static Response q(Response.b bVar, String str, InputStream inputStream) {
        return new Response(bVar, str, inputStream, -1);
    }

    public static Response r(Response.b bVar, String str, InputStream inputStream, long j11) {
        return new Response(bVar, str, inputStream, j11);
    }

    public static Response s(Response.b bVar, String str, String str2) {
        byte[] bArr;
        d dVar = new d(str);
        if (str2 == null) {
            return r(bVar, str, new ByteArrayInputStream(new byte[0]), 0);
        }
        try {
            if (!Charset.forName(dVar.e()).newEncoder().canEncode(str2)) {
                dVar = dVar.g();
            }
            bArr = str2.getBytes(dVar.e());
        } catch (UnsupportedEncodingException e11) {
            f54528k.log(Level.SEVERE, "encoding problem, responding nothing", e11);
            bArr = new byte[0];
        }
        return r(bVar, dVar.c(), new ByteArrayInputStream(bArr), (long) bArr.length);
    }

    public static final void t(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (obj instanceof ServerSocket) {
                    ((ServerSocket) obj).close();
                } else {
                    throw new IllegalArgumentException("Unknown object to close");
                }
            } catch (IOException e11) {
                f54528k.log(Level.SEVERE, "Could not close", e11);
            }
        }
    }

    public void A(int i11, boolean z11) throws IOException {
        this.f54532c = n().create();
        this.f54532c.setReuseAddress(true);
        k k11 = k(i11);
        Thread thread = new Thread(k11);
        this.f54534e = thread;
        thread.setDaemon(z11);
        this.f54534e.setName("NanoHttpd Main Listener");
        this.f54534e.start();
        while (!k11.f54587d && k11.f54586c == null) {
            try {
                Thread.sleep(10);
            } catch (Throwable unused) {
            }
        }
        if (k11.f54586c != null) {
            throw k11.f54586c;
        }
    }

    public void B() {
        try {
            t(this.f54532c);
            this.f54535f.c();
            Thread thread = this.f54534e;
            if (thread != null) {
                thread.join();
            }
        } catch (Exception e11) {
            f54528k.log(Level.SEVERE, "Could not stop all connections", e11);
        }
    }

    public boolean C(Response response) {
        return response.f() != null && (response.f().toLowerCase().contains("text/") || response.f().toLowerCase().contains("/json"));
    }

    public c j(Socket socket, InputStream inputStream) {
        return new c(inputStream, socket);
    }

    public k k(int i11) {
        return new k(i11);
    }

    public l n() {
        return this.f54533d;
    }

    public Response u(j jVar) {
        HashMap hashMap = new HashMap();
        Method a11 = jVar.a();
        if (Method.PUT.equals(a11) || Method.POST.equals(a11)) {
            try {
                jVar.c(hashMap);
            } catch (IOException e11) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                return s(status, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e11.getMessage());
            } catch (ResponseException e12) {
                return s(e12.getStatus(), "text/plain", e12.getMessage());
            }
        }
        Map<String, String> b11 = jVar.b();
        b11.put("NanoHttpd.QUERY_STRING", jVar.d());
        return v(jVar.getUri(), a11, jVar.getHeaders(), b11, hashMap);
    }

    @Deprecated
    public Response v(String str, Method method, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        return s(Response.Status.NOT_FOUND, "text/plain", "Not Found");
    }

    public void w(b bVar) {
        this.f54535f = bVar;
    }

    public void x(o oVar) {
        this.f54536g = oVar;
    }

    public void y() throws IOException {
        z(5000);
    }

    public void z(int i11) throws IOException {
        A(i11, true);
    }

    public static final class ResponseException extends Exception {
        private static final long serialVersionUID = 6569838532917408380L;
        private final Response.Status status;

        public ResponseException(Response.Status status2, String str) {
            super(str);
            this.status = status2;
        }

        public Response.Status getStatus() {
            return this.status;
        }

        public ResponseException(Response.Status status2, String str, Exception exc) {
            super(str, exc);
            this.status = status2;
        }
    }

    public NanoHTTPD(String str, int i11) {
        this.f54533d = new DefaultServerSocketFactory();
        this.f54530a = str;
        this.f54531b = i11;
        x(new h());
        w(new DefaultAsyncRunner());
    }
}
