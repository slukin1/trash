package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

public final class i0 extends Writer {

    /* renamed from: b  reason: collision with root package name */
    public final String f9756b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f9757c = new StringBuilder(128);

    public i0(String str) {
        this.f9756b = str;
    }

    public final void a() {
        if (this.f9757c.length() > 0) {
            Log.d(this.f9756b, this.f9757c.toString());
            StringBuilder sb2 = this.f9757c;
            sb2.delete(0, sb2.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            char c11 = cArr[i11 + i13];
            if (c11 == 10) {
                a();
            } else {
                this.f9757c.append(c11);
            }
        }
    }
}
