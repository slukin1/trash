package xu;

import android.text.TextUtils;
import com.huobi.woodpecker.kalle.Headers;
import com.huobi.woodpecker.kalle.m;
import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class f implements m {

    /* renamed from: b  reason: collision with root package name */
    public String f23445b;

    /* renamed from: c  reason: collision with root package name */
    public InputStream f23446c;

    public f(String str, InputStream inputStream) {
        this.f23445b = str;
        this.f23446c = inputStream;
    }

    public byte[] byteArray() throws IOException {
        return IOUtils.c(this.f23446c);
    }

    public void close() throws IOException {
        this.f23446c.close();
    }

    public String string() throws IOException {
        String E = Headers.E(this.f23445b, "charset", (String) null);
        return TextUtils.isEmpty(E) ? IOUtils.e(this.f23446c) : IOUtils.f(this.f23446c, E);
    }
}
