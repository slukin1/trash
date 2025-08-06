package com.huobi.woodpecker;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.huobi.woodpecker.HBOkHttpDNS;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.core.HttpEventStatus;
import com.huobi.woodpecker.model.ApiData;
import com.huobi.woodpecker.model.ApiNetwork;
import com.huobi.woodpecker.model.ApiRequest;
import com.huobi.woodpecker.model.ApiResHeader;
import com.huobi.woodpecker.net.NetUtils;
import com.huobi.woodpecker.net.UrlConfig;
import com.huobi.woodpecker.utils.ContextUtil;
import com.huobi.woodpecker.utils.RecordUtil;
import com.jumio.sdk.reject.JumioRejectReason;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLException;
import kv.e;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.GzipSource;
import org.json.JSONException;
import org.json.JSONObject;
import vu.g;

public class a extends EventListener {

    /* renamed from: s  reason: collision with root package name */
    public static final EventListener.Factory f20946s = new C0160a();

    /* renamed from: a  reason: collision with root package name */
    public final Charset f20947a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    public long f20948b;

    /* renamed from: c  reason: collision with root package name */
    public long f20949c;

    /* renamed from: d  reason: collision with root package name */
    public long f20950d;

    /* renamed from: e  reason: collision with root package name */
    public long f20951e;

    /* renamed from: f  reason: collision with root package name */
    public long f20952f;

    /* renamed from: g  reason: collision with root package name */
    public long f20953g;

    /* renamed from: h  reason: collision with root package name */
    public long f20954h;

    /* renamed from: i  reason: collision with root package name */
    public long f20955i;

    /* renamed from: j  reason: collision with root package name */
    public long f20956j;

    /* renamed from: k  reason: collision with root package name */
    public final ApiRequest f20957k = new ApiRequest();

    /* renamed from: l  reason: collision with root package name */
    public boolean f20958l = false;

    /* renamed from: m  reason: collision with root package name */
    public HttpEventStatus f20959m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f20960n = false;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f20961o = false;

    /* renamed from: p  reason: collision with root package name */
    public volatile boolean f20962p = false;

    /* renamed from: q  reason: collision with root package name */
    public volatile boolean f20963q = false;

    /* renamed from: r  reason: collision with root package name */
    public c f20964r = new b();

    /* renamed from: com.huobi.woodpecker.a$a  reason: collision with other inner class name */
    public class C0160a implements EventListener.Factory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicLong f20965a = new AtomicLong(1);

        public EventListener create(Call call) {
            if (ActionType.API.isEnable() && call != null) {
                long andIncrement = this.f20965a.getAndIncrement();
                HttpUrl url = call.request().url();
                String httpUrl = url.toString();
                e.c("WP-HttpEventListener", "create EventListener callId:" + andIncrement + ", url=" + httpUrl);
                if (UrlConfig.e(httpUrl)) {
                    return new a(url, call);
                }
            }
            return EventListener.NONE;
        }
    }

    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20966a = false;

        /* renamed from: com.huobi.woodpecker.a$b$a  reason: collision with other inner class name */
        public class C0161a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f20968b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Buffer f20969c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Charset f20970d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f20971e;

            public C0161a(boolean z11, Buffer buffer, Charset charset, long j11) {
                this.f20968b = z11;
                this.f20969c = buffer;
                this.f20970d = charset;
                this.f20971e = j11;
            }

            public void run() {
                long j11;
                StringBuilder sb2;
                Buffer buffer;
                try {
                    if (this.f20968b) {
                        GzipSource gzipSource = new GzipSource(this.f20969c);
                        buffer = new Buffer();
                        buffer.writeAll(gzipSource);
                    } else {
                        buffer = this.f20969c;
                    }
                    String str = null;
                    try {
                        str = buffer.readString(this.f20970d);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    if (TextUtils.isEmpty(str)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        e.c("WP-HttpEventListener", "hadParseRespBody cost time = " + (currentTimeMillis - this.f20971e) + " ms  " + Thread.currentThread());
                        boolean unused = a.this.f20961o = true;
                        a.this.h();
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("code");
                    if ("".equals(optString)) {
                        optString = jSONObject.optString("err-code");
                    }
                    if ("".equals(optString)) {
                        optString = jSONObject.optString("err_code");
                    }
                    boolean equals = "".equals(optString);
                    String str2 = JumioRejectReason.NOT_READABLE;
                    if (equals) {
                        if (BaseHbgResponse.STATUS_OK.equalsIgnoreCase(jSONObject.optString("status"))) {
                            optString = str2;
                        } else {
                            optString = "";
                        }
                    }
                    if (!"".equals(optString)) {
                        str2 = optString;
                    } else if (!"true".equalsIgnoreCase(jSONObject.optString("success"))) {
                        str2 = "";
                    }
                    if ("".equals(str2)) {
                        str2 = "550";
                    }
                    e.c("WP-HttpEventListener", "hadParseRespBody code=" + str2);
                    ((ApiData) a.this.f20957k.getData()).setRescode(str2);
                    j11 = System.currentTimeMillis();
                    sb2 = new StringBuilder();
                    sb2.append("hadParseRespBody cost time = ");
                    sb2.append(j11 - this.f20971e);
                    sb2.append(" ms  ");
                    sb2.append(Thread.currentThread());
                    e.c("WP-HttpEventListener", sb2.toString());
                    boolean unused2 = a.this.f20961o = true;
                    a.this.h();
                } catch (IOException e11) {
                    e.d("WP-HttpEventListener", "hadParseRespBody", e11);
                    j11 = System.currentTimeMillis();
                    sb2 = new StringBuilder();
                } catch (JSONException e12) {
                    e.d("WP-HttpEventListener", "hadParseRespBody", e12);
                    j11 = System.currentTimeMillis();
                    sb2 = new StringBuilder();
                } catch (Exception e13) {
                    e.d("WP-HttpEventListener", "hadParseRespBody", e13);
                    j11 = System.currentTimeMillis();
                    sb2 = new StringBuilder();
                } catch (Throwable th3) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    e.c("WP-HttpEventListener", "hadParseRespBody cost time = " + (currentTimeMillis2 - this.f20971e) + " ms  " + Thread.currentThread());
                    boolean unused3 = a.this.f20961o = true;
                    a.this.h();
                    throw th3;
                }
            }
        }

        public b() {
        }

        public void a(ResponseBody responseBody, Buffer buffer, boolean z11) {
            MediaType contentType;
            if (!this.f20966a) {
                this.f20966a = true;
                long currentTimeMillis = System.currentTimeMillis();
                Charset charset = null;
                if (!(responseBody == null || responseBody.contentType() == null || (contentType = responseBody.contentType()) == null)) {
                    charset = contentType.charset(a.this.f20947a);
                }
                g.d().i(new C0161a(z11, buffer, charset == null ? a.this.f20947a : charset, currentTimeMillis));
            }
        }
    }

    public interface c {
        void a(ResponseBody responseBody, Buffer buffer, boolean z11);
    }

    public a(HttpUrl httpUrl, Call call) {
        f(httpUrl, call);
    }

    public void callEnd(Call call) {
        super.callEnd(call);
        this.f20959m = HttpEventStatus.callEnd;
        long e11 = e();
        ((ApiData) this.f20957k.getData()).setTime(e11 - this.f20948b);
        ((ApiData) this.f20957k.getData()).setMsg("OK");
        e.k("WP-HttpEventListener", "callEnd " + this.f20957k.toCountTimeString());
        if (!((ApiData) this.f20957k.getData()).isRedirection() && ((ApiData) this.f20957k.getData()).getCode() != 0) {
            e.c("WP-HttpEventListener", "callEndMillis=" + e11 + ", callData:" + this.f20957k.toString());
            this.f20962p = true;
            h();
        }
    }

    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        long e11 = e();
        if (iOException instanceof UnknownHostException) {
            if (ContextUtil.n()) {
                ((ApiData) this.f20957k.getData()).setCode(-1020);
            } else {
                ((ApiData) this.f20957k.getData()).setCode(-1070);
            }
        } else if (iOException instanceof ConnectException) {
            if (this.f20959m == HttpEventStatus.connectFailed) {
                ((ApiData) this.f20957k.getData()).setCode(-1030);
            }
        } else if (iOException instanceof SocketTimeoutException) {
            ((ApiData) this.f20957k.getData()).setCode(-1010);
        } else if (iOException instanceof SSLException) {
            ((ApiData) this.f20957k.getData()).setCode(-1040);
        }
        if (((ApiData) this.f20957k.getData()).getCode() != 0) {
            String str = "exception:" + iOException.getMessage();
            try {
                j(call.request().url().host(), str);
            } catch (Exception e12) {
                ((ApiData) this.f20957k.getData()).setMsg(str);
                e12.printStackTrace();
            }
            ((ApiData) this.f20957k.getData()).setTime(e11 - this.f20948b);
            e.c("WP-HttpEventListener", "callFailedMillis=" + e11 + ", callData:" + this.f20957k.toString());
            e.p("WP-HttpEventListener", "callFailed", iOException);
            this.f20962p = true;
            h();
        }
    }

    public void callStart(Call call) {
        super.callStart(call);
        this.f20959m = HttpEventStatus.callStart;
        this.f20948b = e();
        e.c("WP-HttpEventListener", "callStartMillis=" + this.f20948b);
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        this.f20959m = HttpEventStatus.connectEnd;
        long e11 = e();
        ((ApiData) this.f20957k.getData()).setTcp(e11 - this.f20950d);
        e.c("WP-HttpEventListener", "connectEndMillis=" + e11);
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        this.f20959m = HttpEventStatus.connectFailed;
        long e11 = e();
        ((ApiData) this.f20957k.getData()).setTcp(e11 - this.f20950d);
        e.c("WP-HttpEventListener", "connectFailedMillis=" + e11);
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        this.f20959m = HttpEventStatus.connectStart;
        if (this.f20950d > 0) {
            this.f20948b = e();
            this.f20950d = 0;
            this.f20951e = 0;
            this.f20952f = 0;
            this.f20954h = 0;
            this.f20955i = 0;
        }
        InetAddress address = inetSocketAddress.getAddress();
        if (address != null) {
            this.f20957k.getNetwork().setIp(address.getHostAddress());
        }
        this.f20950d = e();
        e.c("WP-HttpEventListener", "connectStartMillis=" + this.f20950d);
    }

    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        this.f20959m = HttpEventStatus.connectionAcquired;
    }

    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        this.f20959m = HttpEventStatus.connectionReleased;
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        this.f20959m = HttpEventStatus.dnsEnd;
        long e11 = e();
        ((ApiData) this.f20957k.getData()).setDns(e11 - this.f20949c);
        int dnsst = ((ApiData) this.f20957k.getData()).getDnsst();
        boolean z11 = list instanceof HBOkHttpDNS.HBArrayList;
        this.f20958l = z11;
        if (z11 || dnsst > 0) {
            ((ApiData) this.f20957k.getData()).setDnsst(dnsst + 1);
        }
        if (list != null && !list.isEmpty()) {
            ((ApiData) this.f20957k.getData()).setDnsip(list.get(0).getHostAddress());
        }
        e.c("WP-HttpEventListener", "dnsEndMillis=" + e11 + ", domainName: " + str + ", isHttpDns=" + this.f20958l + " , dns=" + ((ApiData) this.f20957k.getData()).getDns());
    }

    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        this.f20959m = HttpEventStatus.dnsStart;
        if (this.f20949c > 0) {
            this.f20948b = e();
            this.f20950d = 0;
            this.f20951e = 0;
            this.f20952f = 0;
            this.f20954h = 0;
            this.f20955i = 0;
        }
        this.f20949c = e();
        e.c("WP-HttpEventListener", "dnsStartMillis=" + this.f20949c + "  domainName:" + str);
    }

    public final long e() {
        return System.currentTimeMillis();
    }

    public final void f(HttpUrl httpUrl, Call call) {
        this.f20957k.setUrl(httpUrl.toString());
        this.f20957k.setUuid(b.n());
        RecordUtil.a(this.f20957k);
        if (this.f20957k.getData() == null) {
            this.f20957k.setData(new ApiData());
        }
        ((ApiData) this.f20957k.getData()).setSchema(httpUrl.scheme());
        ((ApiData) this.f20957k.getData()).setPath(httpUrl.encodedPath());
        ((ApiData) this.f20957k.getData()).setHost(httpUrl.host());
        if (this.f20957k.getNetwork() == null) {
            this.f20957k.setNetwork(new ApiNetwork());
        }
        this.f20957k.getNetwork().setNt(ContextUtil.j());
        this.f20957k.getNetwork().setIsp(ContextUtil.i());
        if (TextUtils.isEmpty(httpUrl.encodedPath()) || !httpUrl.encodedPath().contains("/netinfo")) {
            ((ApiData) this.f20957k.getData()).setDnsserver("");
        } else {
            ((ApiData) this.f20957k.getData()).setDnsserver(b.j());
        }
    }

    public boolean g() {
        return this.f20958l;
    }

    public final void h() {
        if (!this.f20962p) {
            return;
        }
        if (!this.f20960n) {
            wu.c.b(this.f20957k);
        } else if (this.f20961o) {
            wu.c.b(this.f20957k);
        }
    }

    public void i() {
        this.f20960n = true;
    }

    public final void j(String str, String str2) {
        ((ApiData) this.f20957k.getData()).setMsg(NetUtils.c(str, str2));
    }

    public void requestBodyEnd(Call call, long j11) {
        super.requestBodyEnd(call, j11);
        this.f20959m = HttpEventStatus.requestBodyEnd;
        long e11 = e();
        this.f20954h = e11;
        ((ApiData) this.f20957k.getData()).setTtfb(e11 - this.f20952f);
        e.c("WP-HttpEventListener", "requestBodyEndMillis=" + this.f20954h);
        long j12 = this.f20954h - this.f20953g;
        double a11 = kv.c.a(j11, j12);
        e.c("WP-HttpEventListener", "speed=" + a11 + ", byteCount=" + j11 + ", rctTime" + j12);
        ((ApiData) this.f20957k.getData()).setReqsp(a11);
        ((ApiData) this.f20957k.getData()).setReqLength(j11);
        ((ApiData) this.f20957k.getData()).setRealnt(kv.c.g(a11));
    }

    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        this.f20959m = HttpEventStatus.requestBodyStart;
        this.f20953g = e();
    }

    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        this.f20959m = HttpEventStatus.requestHeadersEnd;
        if (request != null) {
            ((ApiData) this.f20957k.getData()).setMethod(request.method());
            this.f20957k.setUa(request.headers().get("User-Agent"));
            Headers headers = request.headers();
            String str = headers.get("x-b3-traceid");
            if (TextUtils.isEmpty(str)) {
                str = b.b();
            }
            ((ApiData) this.f20957k.getData()).setTrace(str);
            if (b.f() == 11) {
                String str2 = headers.get("hbwp-is-request-node");
                if (!TextUtils.isEmpty(str2)) {
                    ((ApiData) this.f20957k.getData()).setIsRequestNode(str2);
                }
                String str3 = headers.get("X-Wallet-Session");
                if (!TextUtils.isEmpty(str3)) {
                    ((ApiData) this.f20957k.getData()).setSessionId(str3);
                }
            }
        }
        this.f20954h = e();
        ((ApiData) this.f20957k.getData()).setTtfb(e() - this.f20952f);
        e.c("WP-HttpEventListener", "requestHeadersEndMillis=" + this.f20954h);
    }

    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        this.f20959m = HttpEventStatus.requestHeadersStart;
        this.f20952f = e();
        e.c("WP-HttpEventListener", "requestStartMillis=" + this.f20952f);
    }

    public void responseBodyEnd(Call call, long j11) {
        super.responseBodyEnd(call, j11);
        this.f20959m = HttpEventStatus.responseBodyEnd;
        long e11 = e();
        ((ApiData) this.f20957k.getData()).setRct(e11 - this.f20955i);
        e.c("WP-HttpEventListener", "responseBodyEndMillis=" + e11);
        double a11 = kv.c.a(j11, e11 - this.f20956j);
        ((ApiData) this.f20957k.getData()).setRessp(a11);
        ((ApiData) this.f20957k.getData()).setResLength(j11);
        ((ApiData) this.f20957k.getData()).setRealnt(kv.c.g(a11));
    }

    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        this.f20959m = HttpEventStatus.responseBodyStart;
        this.f20956j = e();
        e.c("WP-HttpEventListener", "responseBodyStartTime=" + this.f20956j);
    }

    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        this.f20959m = HttpEventStatus.responseHeadersEnd;
        if (response != null) {
            ((ApiData) this.f20957k.getData()).setCode(response.code());
            ((ApiData) this.f20957k.getData()).setProtocol(response.protocol().toString());
            ((ApiData) this.f20957k.getData()).setResheader(ApiResHeader.a(response.headers()));
        }
        this.f20955i = e();
        ((ApiData) this.f20957k.getData()).setFbt(this.f20955i - this.f20954h);
        e.c("WP-HttpEventListener", "responseHeadersStartMillis=" + this.f20955i);
        long e11 = e();
        ((ApiData) this.f20957k.getData()).setRct(e11 - this.f20955i);
        e.c("WP-HttpEventListener", "responseHeadersEndMillis=" + e11);
    }

    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        this.f20959m = HttpEventStatus.responseHeadersStart;
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        this.f20959m = HttpEventStatus.secureConnectEnd;
        long e11 = e();
        ((ApiData) this.f20957k.getData()).setSsl(e11 - this.f20951e);
        ((ApiData) this.f20957k.getData()).setTls(handshake.tlsVersion().javaName());
        if (handshake.peerCertificates().size() != 0) {
            for (Certificate next : handshake.peerCertificates()) {
                if (next instanceof X509Certificate) {
                    JSONObject a11 = NetUtils.a((X509Certificate) next);
                    NetUtils.f21152a.put(call.request().url().host(), a11);
                    e.c("WP-HttpEventListener", "secureConnectEnd sslInfo=" + a11);
                }
            }
        }
        e.c("WP-HttpEventListener", "secureConnectEndMillis=" + e11);
    }

    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        this.f20959m = HttpEventStatus.secureConnectStart;
        this.f20951e = e();
        e.c("WP-HttpEventListener", "secureConnectStartMillis=" + this.f20951e);
    }
}
