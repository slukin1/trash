package nm;

import android.text.TextUtils;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import hm.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import jm.b;

public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f76377b;

    public a(HttpURLConnection httpURLConnection) {
        this.f76377b = httpURLConnection;
    }

    public static InputStream a(String str, InputStream inputStream) throws IOException {
        return (TextUtils.isEmpty(str) || !str.contains(DecompressionHelper.GZIP_ENCODING)) ? inputStream : new GZIPInputStream(inputStream);
    }

    public static boolean b(int i11) {
        return i11 > 100 && i11 != 204 && i11 != 205 && (i11 < 300 || i11 >= 400);
    }

    public static boolean e(String str, int i11) {
        return !"HEAD".equalsIgnoreCase(str) && b(i11);
    }

    public int c() throws IOException {
        return this.f76377b.getResponseCode();
    }

    public void close() throws IOException {
        HttpURLConnection httpURLConnection = this.f76377b;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public Map<String, List<String>> getHeaders() throws IOException {
        return this.f76377b.getHeaderFields();
    }

    public InputStream getInputStream() throws IOException {
        int responseCode = this.f76377b.getResponseCode();
        if (!e(this.f76377b.getRequestMethod(), responseCode)) {
            return new jm.a(this);
        }
        if (responseCode >= 400) {
            return a(this.f76377b.getContentEncoding(), new b(this, this.f76377b.getErrorStream()));
        }
        return a(this.f76377b.getContentEncoding(), new b(this, this.f76377b.getInputStream()));
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f76377b.getOutputStream();
    }
}
