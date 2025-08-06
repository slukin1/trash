package hm;

import android.text.TextUtils;
import com.huobi.kalle.Headers;
import com.huobi.kalle.m;
import com.huobi.kalle.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class f implements m {

    /* renamed from: b  reason: collision with root package name */
    public String f76194b;

    /* renamed from: c  reason: collision with root package name */
    public InputStream f76195c;

    public f(String str, InputStream inputStream) {
        this.f76194b = str;
        this.f76195c = inputStream;
    }

    public byte[] byteArray() throws IOException {
        return IOUtils.c(this.f76195c);
    }

    public void close() throws IOException {
        this.f76195c.close();
    }

    public String string() throws IOException {
        String E = Headers.E(this.f76194b, "charset", (String) null);
        return TextUtils.isEmpty(E) ? IOUtils.e(this.f76195c) : IOUtils.f(this.f76195c, E);
    }
}
