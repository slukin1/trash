package x2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public a f16774b;

    /* renamed from: c  reason: collision with root package name */
    public String f16775c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f16776d;

    /* renamed from: e  reason: collision with root package name */
    public a f16777e;

    /* renamed from: f  reason: collision with root package name */
    public b f16778f;

    public interface a {
        Socket a();
    }

    public d(a aVar, String str, String[] strArr, a aVar2, b bVar) {
        this.f16774b = aVar;
        this.f16775c = str;
        this.f16776d = strArr;
        this.f16777e = aVar2;
        this.f16778f = bVar;
    }

    public final int a(String str, int i11) {
        long j11;
        Socket a11 = this.f16774b.a();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a11.connect(new InetSocketAddress(str, i11), 5000);
            j11 = System.currentTimeMillis();
        } catch (IOException e11) {
            e11.printStackTrace();
            j11 = Long.MAX_VALUE;
        }
        if (j11 == Long.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) (j11 - currentTimeMillis);
    }

    public void run() {
        String[] strArr;
        int[] iArr = new int[this.f16776d.length];
        int i11 = 0;
        while (true) {
            strArr = this.f16776d;
            if (i11 >= strArr.length) {
                break;
            }
            iArr[i11] = a(strArr[i11], this.f16777e.b());
            i11++;
        }
        String[] g11 = w2.a.g(strArr, iArr);
        b bVar = this.f16778f;
        if (bVar != null) {
            bVar.a(this.f16775c, g11);
        }
    }
}
