package j20;

import com.google.common.net.HttpHeaders;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.cybergarage.upnp.device.MAN;
import org.cybergarage.upnp.device.NT;
import org.cybergarage.upnp.device.NTS;
import org.cybergarage.upnp.device.ST;
import org.cybergarage.upnp.device.USN;
import org.cybergarage.upnp.ssdp.SSDP;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public DatagramPacket f55877a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f55878b = "";

    /* renamed from: c  reason: collision with root package name */
    public long f55879c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f55880d = null;

    public b(byte[] bArr, int i11) {
        this.f55877a = new DatagramPacket(bArr, i11);
    }

    public String a() {
        return e20.b.f(b(), HttpHeaders.CACHE_CONTROL);
    }

    public byte[] b() {
        byte[] bArr = this.f55880d;
        if (bArr != null) {
            return bArr;
        }
        DatagramPacket c11 = c();
        byte[] bytes = new String(c11.getData(), 0, c11.getLength()).getBytes();
        this.f55880d = bytes;
        return bytes;
    }

    public DatagramPacket c() {
        return this.f55877a;
    }

    public String d() {
        return e20.b.f(b(), "HOST");
    }

    public InetAddress e() {
        String str;
        String d11 = d();
        int lastIndexOf = d11.lastIndexOf(":");
        if (lastIndexOf >= 0) {
            str = d11.substring(0, lastIndexOf);
            if (str.charAt(0) == '[') {
                str = str.substring(1, str.length());
            }
            if (str.charAt(str.length() - 1) == ']') {
                str = str.substring(0, str.length() - 1);
            }
        } else {
            str = "127.0.0.1";
        }
        return new InetSocketAddress(str, 0).getAddress();
    }

    public int f() {
        return SSDP.b(a());
    }

    public String g() {
        return this.f55878b;
    }

    public String h() {
        return e20.b.f(b(), HttpHeaders.LOCATION);
    }

    public String i() {
        return e20.b.f(b(), "MAN");
    }

    public int j() {
        return e20.b.a(b(), "MX");
    }

    public String k() {
        return e20.b.f(b(), "NT");
    }

    public String l() {
        return e20.b.f(b(), "NTS");
    }

    public String m() {
        return c().getAddress().getHostAddress();
    }

    public int n() {
        return c().getPort();
    }

    public String o() {
        return e20.b.f(b(), "ST");
    }

    public String p() {
        return e20.b.f(b(), "USN");
    }

    public boolean q() {
        return NTS.a(l());
    }

    public boolean r() {
        return NTS.b(l());
    }

    public boolean s() {
        return MAN.a(i());
    }

    public boolean t() {
        if (!NT.a(k()) && !ST.b(o())) {
            return USN.b(p());
        }
        return true;
    }

    public String toString() {
        return new String(b());
    }

    public void u(String str) {
        this.f55878b = str;
    }

    public void v(long j11) {
        this.f55879c = j11;
    }
}
