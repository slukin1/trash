package org.cybergarage.upnp.ssdp;

import j20.a;
import java.net.InetAddress;
import java.util.Vector;
import org.cybergarage.net.HostInterface;
import org.cybergarage.upnp.ControlPoint;

public class SSDPNotifySocketList extends Vector {
    private InetAddress[] binds = null;

    public SSDPNotifySocketList() {
    }

    public void close() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPNotifySocket(i11).a();
        }
        clear();
    }

    public a getSSDPNotifySocket(int i11) {
        return (a) get(i11);
    }

    public boolean open() {
        String[] strArr;
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
                add(new a(strArr2[i13]));
            }
        }
        return true;
    }

    public void setControlPoint(ControlPoint controlPoint) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPNotifySocket(i11).k(controlPoint);
        }
    }

    public void start() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPNotifySocket(i11).l();
        }
    }

    public void stop() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getSSDPNotifySocket(i11).m();
        }
    }

    public SSDPNotifySocketList(InetAddress[] inetAddressArr) {
        this.binds = inetAddressArr;
    }
}
