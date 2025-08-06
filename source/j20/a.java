package j20;

import java.io.IOException;
import java.net.InetAddress;
import org.cybergarage.net.HostInterface;
import org.cybergarage.upnp.ControlPoint;
import org.cybergarage.upnp.ssdp.HTTPMUSocket;
import org.cybergarage.upnp.ssdp.SSDP;
import org.cybergarage.util.Debug;

public class a extends HTTPMUSocket implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f55874e = false;

    /* renamed from: f  reason: collision with root package name */
    public ControlPoint f55875f = null;

    /* renamed from: g  reason: collision with root package name */
    public Thread f55876g = null;

    public a(String str) {
        String str2;
        if (HostInterface.g(str)) {
            str2 = SSDP.a();
            this.f55874e = true;
        } else {
            str2 = "239.255.255.250";
        }
        g(str2, 1900, str);
        k((ControlPoint) null);
    }

    public ControlPoint j() {
        return this.f55875f;
    }

    public void k(ControlPoint controlPoint) {
        this.f55875f = controlPoint;
    }

    public void l() {
        StringBuffer stringBuffer = new StringBuffer("Cyber.SSDPNotifySocket/");
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
        this.f55876g = thread;
        thread.start();
    }

    public void m() {
        a();
        this.f55876g = null;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        ControlPoint j11 = j();
        while (this.f55876g == currentThread) {
            Thread.yield();
            try {
                b i11 = i();
                if (i11 != null) {
                    InetAddress e11 = e();
                    InetAddress e12 = i11.e();
                    if (!e11.equals(e12)) {
                        Debug.e("Invalidate Multicast Recieved from IP " + e11 + " on " + e12);
                    } else if (j11 != null) {
                        j11.l(i11);
                    }
                }
            } catch (IOException unused) {
                return;
            }
        }
    }
}
