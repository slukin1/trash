package bv;

import android.text.TextUtils;
import com.huobi.woodpecker.kalle.Headers;
import com.huobi.woodpecker.kalle.m;
import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.IOException;

public class c implements m {

    /* renamed from: b  reason: collision with root package name */
    public String f19382b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f19383c;

    public c(String str, byte[] bArr) {
        this.f19382b = str;
        this.f19383c = bArr;
    }

    public byte[] byteArray() throws IOException {
        return this.f19383c;
    }

    public void close() throws IOException {
        this.f19383c = null;
    }

    public String string() throws IOException {
        String E = Headers.E(this.f19382b, "charset", (String) null);
        return TextUtils.isEmpty(E) ? IOUtils.g(this.f19383c) : IOUtils.h(this.f19383c, E);
    }
}
