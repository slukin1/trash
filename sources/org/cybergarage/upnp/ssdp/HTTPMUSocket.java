package org.cybergarage.upnp.ssdp;

import j20.b;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.util.Enumeration;
import org.cybergarage.util.Debug;

public class HTTPMUSocket {

    /* renamed from: b  reason: collision with root package name */
    public InetSocketAddress f59886b = null;

    /* renamed from: c  reason: collision with root package name */
    public MulticastSocket f59887c = null;

    /* renamed from: d  reason: collision with root package name */
    public NetworkInterface f59888d = null;

    public boolean a() {
        MulticastSocket multicastSocket = this.f59887c;
        if (multicastSocket == null) {
            return true;
        }
        try {
            multicastSocket.leaveGroup(this.f59886b, this.f59888d);
            this.f59887c.close();
            this.f59887c = null;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String b() {
        InetSocketAddress inetSocketAddress = this.f59886b;
        if (inetSocketAddress == null || this.f59888d == null) {
            return "";
        }
        InetAddress address = inetSocketAddress.getAddress();
        Enumeration<InetAddress> inetAddresses = this.f59888d.getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
            InetAddress nextElement = inetAddresses.nextElement();
            if ((address instanceof Inet6Address) && (nextElement instanceof Inet6Address)) {
                return nextElement.getHostAddress();
            }
            if ((address instanceof Inet4Address) && (nextElement instanceof Inet4Address)) {
                return nextElement.getHostAddress();
            }
        }
        return "";
    }

    public int c() {
        return this.f59887c.getLocalPort();
    }

    public String d() {
        return e().getHostAddress();
    }

    public InetAddress e() {
        return this.f59886b.getAddress();
    }

    public int f() {
        return this.f59886b.getPort();
    }

    public void finalize() {
        a();
    }

    public boolean g(String str, int i11, String str2) {
        try {
            return h(str, i11, InetAddress.getByName(str2));
        } catch (Exception e11) {
            Debug.d(e11);
            return false;
        }
    }

    public boolean h(String str, int i11, InetAddress inetAddress) {
        try {
            MulticastSocket multicastSocket = new MulticastSocket((SocketAddress) null);
            this.f59887c = multicastSocket;
            multicastSocket.setReuseAddress(true);
            this.f59887c.bind(new InetSocketAddress(i11));
            this.f59886b = new InetSocketAddress(InetAddress.getByName(str), i11);
            NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(inetAddress);
            this.f59888d = byInetAddress;
            this.f59887c.joinGroup(this.f59886b, byInetAddress);
            return true;
        } catch (Exception e11) {
            Debug.d(e11);
            return false;
        }
    }

    public b i() throws IOException {
        b bVar = new b(new byte[1024], 1024);
        bVar.u(b());
        MulticastSocket multicastSocket = this.f59887c;
        if (multicastSocket != null) {
            multicastSocket.receive(bVar.c());
            bVar.v(System.currentTimeMillis());
            return bVar;
        }
        throw new IOException("Multicast socket has already been closed.");
    }
}
