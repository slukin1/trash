package org.cybergarage.upnp.ssdp;

import h20.d;
import j20.c;
import java.net.InetAddress;
import java.util.Vector;
import org.cybergarage.net.HostInterface;

public class SSDPSearchSocketList extends Vector {
    private InetAddress[] binds = null;
    private String multicastIPv4 = "239.255.255.250";
    private String multicastIPv6 = SSDP.a();
    private int port = 1900;

    public SSDPSearchSocketList() {
    }

    public void addSearchListener(d dVar) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPSearchSocket(i11).j(dVar);
        }
    }

    public void close() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPSearchSocket(i11).a();
        }
        clear();
    }

    public c getSSDPSearchSocket(int i11) {
        return (c) get(i11);
    }

    public boolean open() {
        String[] strArr;
        c cVar;
        InetAddress[] inetAddressArr = this.binds;
        if (inetAddressArr != null) {
            strArr = new String[inetAddressArr.length];
            for (int i11 = 0; i11 < inetAddressArr.length; i11++) {
                strArr[i11] = inetAddressArr[i11].getHostAddress();
            }
        } else {
            int d11 = HostInterface.d();
            strArr = new String[d11];
            for (int i12 = 0; i12 < d11; i12++) {
                strArr[i12] = HostInterface.a(i12);
            }
        }
        String[] strArr2 = strArr;
        for (int i13 = 0; i13 < strArr2.length; i13++) {
            if (strArr2[i13] != null) {
                if (HostInterface.g(strArr2[i13])) {
                    cVar = new c(strArr2[i13], this.port, this.multicastIPv6);
                } else {
                    cVar = new c(strArr2[i13], this.port, this.multicastIPv4);
                }
                add(cVar);
            }
        }
        return true;
    }

    public void start() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPSearchSocket(i11).m();
        }
    }

    public void stop() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPSearchSocket(i11).n();
        }
    }

    public SSDPSearchSocketList(InetAddress[] inetAddressArr) {
        this.binds = inetAddressArr;
    }

    public SSDPSearchSocketList(InetAddress[] inetAddressArr, int i11, String str, String str2) {
        this.binds = inetAddressArr;
        this.port = i11;
        this.multicastIPv4 = str;
        this.multicastIPv6 = str2;
    }
}
