package org.cybergarage.upnp.ssdp;

import j20.b;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.cybergarage.util.Debug;

public class HTTPUSocket {

    /* renamed from: b  reason: collision with root package name */
    public DatagramSocket f59889b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f59890c = "";

    public HTTPUSocket() {
        d();
    }

    public boolean a() {
        DatagramSocket datagramSocket = this.f59889b;
        if (datagramSocket == null) {
            return true;
        }
        try {
            datagramSocket.close();
            this.f59889b = null;
            return true;
        } catch (Exception e11) {
            Debug.d(e11);
            return false;
        }
    }

    public DatagramSocket b() {
        return this.f59889b;
    }

    public String c() {
        if (this.f59890c.length() > 0) {
            return this.f59890c;
        }
        return this.f59889b.getLocalAddress().getHostAddress();
    }

    public boolean d() {
        a();
        try {
            this.f59889b = new DatagramSocket();
            return true;
        } catch (Exception e11) {
            Debug.d(e11);
            return false;
        }
    }

    public boolean e(String str, int i11) {
        a();
        try {
            this.f59889b = new DatagramSocket(new InetSocketAddress(InetAddress.getByName(str), i11));
            h(str);
            return true;
        } catch (Exception e11) {
            Debug.d(e11);
            return false;
        }
    }

    public boolean f(String str, int i11, String str2) {
        try {
            this.f59889b.send(new DatagramPacket(str2.getBytes(), str2.length(), InetAddress.getByName(str), i11));
            return true;
        } catch (Exception e11) {
            Debug.e("addr = " + this.f59889b.getLocalAddress().getHostName());
            Debug.e("port = " + this.f59889b.getLocalPort());
            Debug.d(e11);
            return false;
        }
    }

    public void finalize() {
        a();
    }

    public b g() {
        b bVar = new b(new byte[1024], 1024);
        bVar.u(c());
        try {
            this.f59889b.receive(bVar.c());
            bVar.v(System.currentTimeMillis());
            return bVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public void h(String str) {
        this.f59890c = str;
    }

    public HTTPUSocket(String str, int i11) {
        e(str, i11);
    }
}
