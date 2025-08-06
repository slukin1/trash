package lm;

import android.text.TextUtils;
import com.huobi.kalle.Headers;
import com.huobi.kalle.m;
import com.huobi.kalle.util.IOUtils;
import java.io.IOException;

public class c implements m {

    /* renamed from: b  reason: collision with root package name */
    public String f76247b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f76248c;

    public c(String str, byte[] bArr) {
        this.f76247b = str;
        this.f76248c = bArr;
    }

    public byte[] byteArray() throws IOException {
        return this.f76248c;
    }

    public void close() throws IOException {
        this.f76248c = null;
    }

    public String string() throws IOException {
        String E = Headers.E(this.f76247b, "charset", (String) null);
        return TextUtils.isEmpty(E) ? IOUtils.g(this.f76248c) : IOUtils.h(this.f76248c, E);
    }
}
