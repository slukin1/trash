package org.cybergarage.upnp.ssdp;

import java.net.InetAddress;
import java.util.Vector;
import org.cybergarage.net.HostInterface;
import org.cybergarage.upnp.ControlPoint;

public class SSDPSearchResponseSocketList extends Vector {
    private InetAddress[] binds = null;

    public SSDPSearchResponseSocketList() {
    }

    public void close() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPSearchResponseSocket(i11).a();
        }
        clear();
    }

    public SSDPSearchResponseSocket getSSDPSearchResponseSocket(int i11) {
        return (SSDPSearchResponseSocket) get(i11);
    }

    public boolean open(int i11) {
        String[] strArr;
        InetAddress[] inetAddressArr = this.binds;
        if (inetAddressArr != null) {
            strArr = new String[inetAddressArr.length];
            for (int i12 = 0; i12 < inetAddressArr.length; i12++) {
                strArr[i12] = inetAddressArr[i12].getHostAddress();
            }
        } else {
            int d11 = HostInterface.d();
            strArr = new String[d11];
            for (int i13 = 0; i13 < d11; i13++) {
                strArr[i13] = HostInterface.a(i13);
            }
        }
        int i14 = 0;
        while (i14 < strArr.length) {
            try {
                add(new SSDPSearchResponseSocket(strArr[i14], i11));
                i14++;
            } catch (Exception unused) {
                stop();
                close();
                clear();
                return false;
            }
        }
        return true;
    }

    public boolean post(SSDPSearchRequest sSDPSearchRequest) {
        int size = size();
        boolean z11 = true;
        for (int i11 = 0; i11 < size; i11++) {
            SSDPSearchResponseSocket sSDPSearchResponseSocket = getSSDPSearchResponseSocket(i11);
            String c11 = sSDPSearchResponseSocket.c();
            sSDPSearchRequest.R0(c11);
            if (!sSDPSearchResponseSocket.j(HostInterface.g(c11) ? SSDP.a() : "239.255.255.250", 1900, sSDPSearchRequest)) {
                z11 = false;
            }
        }
        return z11;
    }

    public void setControlPoint(ControlPoint controlPoint) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPSearchResponseSocket(i11).l(controlPoint);
        }
    }

    public void start() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPSearchResponseSocket(i11).m();
        }
    }

    public void stop() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPSearchResponseSocket(i11).n();
        }
    }

    public SSDPSearchResponseSocketList(InetAddress[] inetAddressArr) {
        this.binds = inetAddressArr;
    }

    public boolean open() {
        return open(1900);
    }
}
