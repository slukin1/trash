package j20;

import h20.d;
import java.io.IOException;
import org.cybergarage.net.HostInterface;
import org.cybergarage.upnp.ssdp.HTTPMUSocket;
import org.cybergarage.util.ListenerList;

public class c extends HTTPMUSocket implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f55881e;

    /* renamed from: f  reason: collision with root package name */
    public ListenerList f55882f = new ListenerList();

    /* renamed from: g  reason: collision with root package name */
    public Thread f55883g = null;

    public c(String str, int i11, String str2) {
        k(str, str2);
    }

    public void j(d dVar) {
        this.f55882f.add(dVar);
    }

    public boolean k(String str, String str2) {
        if (HostInterface.g(str) && HostInterface.g(str2)) {
            this.f55881e = true;
        } else if (!HostInterface.f(str) || !HostInterface.f(str2)) {
            throw new IllegalArgumentException("Cannot open a UDP Socket for IPv6 address on IPv4 interface or viceversa");
        } else {
            this.f55881e = false;
        }
        return g(str2, 1900, str);
    }

    public void l(b bVar) {
        int size = this.f55882f.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((d) this.f55882f.get(i11)).b(bVar);
        }
    }

    public void m() {
        StringBuffer stringBuffer = new StringBuffer("Cyber.SSDPSearchSocket/");
        String b11 = b();
        if (b11 != null && b11.length() > 0) {
            stringBuffer.append(b());
            stringBuffer.append(':');
            stringBuffer.append(c());
            stringBuffer.append(" -> ");
            stringBuffer.append(d());
            stringBuffer.append(':');
            stringBuffer.append(f());
        }
        Thread thread = new Thread(this, stringBuffer.toString());
        this.f55883g = thread;
        thread.start();
    }

    public void n() {
        a();
        this.f55883g = null;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (this.f55883g == currentThread) {
            Thread.yield();
            try {
                b i11 = i();
                if (i11 != null && i11.s()) {
                    l(i11);
                }
            } catch (IOException unused) {
                return;
            }
        }
    }
}
