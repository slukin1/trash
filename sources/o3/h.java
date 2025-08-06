package o3;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.google.common.net.HttpHeaders;
import f4.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import o3.d;

public class h implements d<InputStream> {

    /* renamed from: h  reason: collision with root package name */
    public static final b f66525h = new a();

    /* renamed from: b  reason: collision with root package name */
    public final s3.a f66526b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66527c;

    /* renamed from: d  reason: collision with root package name */
    public final b f66528d;

    /* renamed from: e  reason: collision with root package name */
    public HttpURLConnection f66529e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f66530f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f66531g;

    public static class a implements b {
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public h(s3.a aVar, int i11) {
        this(aVar, i11, f66525h);
    }

    public static boolean e(int i11) {
        return i11 / 100 == 2;
    }

    public static boolean g(int i11) {
        return i11 / 100 == 3;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.f66530f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f66529e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f66529e = null;
    }

    public DataSource c() {
        return DataSource.REMOTE;
    }

    public void cancel() {
        this.f66531g = true;
    }

    public final InputStream d(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f66530f = f4.b.b(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f66530f = httpURLConnection.getInputStream();
        }
        return this.f66530f;
    }

    public void f(Priority priority, d.a<? super InputStream> aVar) {
        StringBuilder sb2;
        long b11 = e.b();
        try {
            aVar.d(h(this.f66526b.g(), 0, (URL) null, this.f66526b.c()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb2 = new StringBuilder();
                sb2.append("Finished http url fetcher fetch in ");
                sb2.append(e.a(b11));
                Log.v("HttpUrlFetcher", sb2.toString());
            }
        } catch (IOException e11) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e11);
            }
            aVar.e(e11);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb2 = new StringBuilder();
            }
        } catch (Throwable th2) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + e.a(b11));
            }
            throw th2;
        }
    }

    public final InputStream h(URL url, int i11, URL url2, Map<String, String> map) throws IOException {
        if (i11 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f66529e = this.f66528d.a(url);
            for (Map.Entry next : map.entrySet()) {
                this.f66529e.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.f66529e.setConnectTimeout(this.f66527c);
            this.f66529e.setReadTimeout(this.f66527c);
            this.f66529e.setUseCaches(false);
            this.f66529e.setDoInput(true);
            this.f66529e.setInstanceFollowRedirects(false);
            this.f66529e.connect();
            this.f66530f = this.f66529e.getInputStream();
            if (this.f66531g) {
                return null;
            }
            int responseCode = this.f66529e.getResponseCode();
            if (e(responseCode)) {
                return d(this.f66529e);
            }
            if (g(responseCode)) {
                String headerField = this.f66529e.getHeaderField(HttpHeaders.LOCATION);
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    b();
                    return h(url3, i11 + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f66529e.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    public h(s3.a aVar, int i11, b bVar) {
        this.f66526b = aVar;
        this.f66527c = i11;
        this.f66528d = bVar;
    }
}
