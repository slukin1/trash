package yu;

import av.a;
import com.google.common.net.HttpHeaders;
import com.huobi.woodpecker.kalle.Headers;
import com.huobi.woodpecker.kalle.Kalle;
import com.huobi.woodpecker.kalle.Response;
import com.huobi.woodpecker.kalle.exception.ConnectException;
import com.huobi.woodpecker.kalle.exception.ConnectTimeoutError;
import com.huobi.woodpecker.kalle.exception.HostError;
import com.huobi.woodpecker.kalle.exception.NetworkError;
import com.huobi.woodpecker.kalle.exception.ReadException;
import com.huobi.woodpecker.kalle.exception.ReadTimeoutError;
import com.huobi.woodpecker.kalle.exception.URLError;
import com.huobi.woodpecker.kalle.exception.WriteException;
import com.huobi.woodpecker.kalle.k;
import com.huobi.woodpecker.kalle.l;
import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import xu.b;
import xu.c;
import xu.e;
import xu.f;

public class d implements xu.d {

    /* renamed from: a  reason: collision with root package name */
    public final a f23457a = new a(Kalle.b().f());

    /* renamed from: b  reason: collision with root package name */
    public final b f23458b = Kalle.b().c();

    /* renamed from: c  reason: collision with root package name */
    public final e f23459c = Kalle.b().k();

    /* renamed from: d  reason: collision with root package name */
    public c f23460d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23461e;

    public Response a(c cVar) throws IOException {
        if (!this.f23461e) {
            k request = cVar.request();
            if (request.h().allowBody()) {
                Headers c11 = request.c();
                l d11 = request.d();
                c11.H("Content-Length", Long.toString(d11.length()));
                c11.H("Content-Type", d11.contentType());
                this.f23460d = b(request);
                e(d11);
            } else {
                this.f23460d = b(request);
            }
            return d(request);
        }
        throw new CancellationException("The request has been cancelled.");
    }

    public final c b(k kVar) throws ConnectException {
        if (this.f23459c.isAvailable()) {
            try {
                Headers c11 = kVar.c();
                URI uri = new URI(kVar.l().toString());
                List<String> d11 = this.f23457a.d(uri);
                if (d11 != null && !d11.isEmpty()) {
                    c11.k(HttpHeaders.COOKIE, d11);
                }
                c11.H("Host", uri.getHost());
                return this.f23458b.a(kVar);
            } catch (URISyntaxException e11) {
                throw new URLError(String.format("The url syntax error: %1$s.", new Object[]{kVar.l()}), e11);
            } catch (MalformedURLException e12) {
                throw new URLError(String.format("The url is malformed: %1$s.", new Object[]{kVar.l()}), e12);
            } catch (UnknownHostException e13) {
                throw new HostError(String.format("Hostname can not be resolved: %1$s.", new Object[]{kVar.l()}), e13);
            } catch (SocketTimeoutException e14) {
                throw new ConnectTimeoutError(String.format("Connect time out: %1$s.", new Object[]{kVar.l()}), e14);
            } catch (Exception e15) {
                throw new ConnectException(String.format("An unknown exception: %1$s.", new Object[]{kVar.l()}), e15);
            }
        } else {
            throw new NetworkError(String.format("Network Unavailable: %1$s.", new Object[]{kVar.l()}));
        }
    }

    public final Headers c(Map<String, List<String>> map) {
        Headers headers = new Headers();
        for (Map.Entry next : map.entrySet()) {
            headers.k((String) next.getKey(), (List) next.getValue());
        }
        return headers;
    }

    public final Response d(k kVar) throws ReadException {
        try {
            int c11 = this.f23460d.c();
            Headers c12 = c(this.f23460d.getHeaders());
            List<String> q11 = c12.q(HttpHeaders.SET_COOKIE);
            if (q11 != null && !q11.isEmpty()) {
                this.f23457a.b(URI.create(kVar.l().toString()), q11);
            }
            return Response.g().f(c11).g(c12).d(new f(c12.t(), this.f23460d.getInputStream())).e();
        } catch (SocketTimeoutException e11) {
            throw new ReadTimeoutError(String.format("Read data time out: %1$s.", new Object[]{kVar.l()}), e11);
        } catch (Exception e12) {
            throw new ReadException((Throwable) e12);
        }
    }

    public final void e(l lVar) throws WriteException {
        try {
            OutputStream outputStream = this.f23460d.getOutputStream();
            lVar.writeTo(IOUtils.b(outputStream));
            IOUtils.a(outputStream);
        } catch (Exception e11) {
            throw new WriteException((Throwable) e11);
        }
    }
}
