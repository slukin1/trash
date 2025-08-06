package org.cybergarage.http;

import e20.c;
import java.net.InetAddress;
import java.util.Vector;
import org.cybergarage.net.HostInterface;

public class HTTPServerList extends Vector {
    private InetAddress[] binds = null;
    private int port = 4004;

    public HTTPServerList() {
    }

    public void addRequestListener(c cVar) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getHTTPServer(i11).b(cVar);
        }
    }

    public void close() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getHTTPServer(i11).c();
        }
    }

    public HTTPServer getHTTPServer(int i11) {
        return (HTTPServer) get(i11);
    }

    public int open() {
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
        int i13 = 0;
        for (int i14 = 0; i14 < strArr2.length; i14++) {
            HTTPServer hTTPServer = new HTTPServer();
            if (strArr2[i14] == null || !hTTPServer.g(strArr2[i14], this.port)) {
                close();
                clear();
            } else {
                add(hTTPServer);
                i13++;
            }
        }
        return i13;
    }

    public void start() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getHTTPServer(i11).i();
        }
    }

    public void stop() {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            getHTTPServer(i11).j();
        }
    }

    public HTTPServerList(InetAddress[] inetAddressArr, int i11) {
        this.binds = inetAddressArr;
        this.port = i11;
    }

    public boolean open(int i11) {
        this.port = i11;
        return open() != 0;
    }
}
