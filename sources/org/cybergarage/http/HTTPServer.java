package org.cybergarage.http;

import e20.c;
import e20.d;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.cybergarage.util.Debug;
import org.cybergarage.util.ListenerList;

public class HTTPServer implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public ServerSocket f59816b;

    /* renamed from: c  reason: collision with root package name */
    public InetAddress f59817c;

    /* renamed from: d  reason: collision with root package name */
    public int f59818d;

    /* renamed from: e  reason: collision with root package name */
    public int f59819e;

    /* renamed from: f  reason: collision with root package name */
    public ListenerList f59820f;

    /* renamed from: g  reason: collision with root package name */
    public Thread f59821g;

    public HTTPServer() {
        this.f59816b = null;
        this.f59817c = null;
        this.f59818d = 0;
        this.f59819e = 80000;
        this.f59820f = new ListenerList();
        this.f59821g = null;
        this.f59816b = null;
    }

    public static String d() {
        String property = System.getProperty("os.name");
        String property2 = System.getProperty("os.version");
        return String.valueOf(property) + "/" + property2 + " " + "CyberHTTP" + "/" + "1.0";
    }

    public Socket a() {
        ServerSocket serverSocket = this.f59816b;
        if (serverSocket == null) {
            return null;
        }
        try {
            Socket accept = serverSocket.accept();
            accept.setSoTimeout(e());
            return accept;
        } catch (Exception unused) {
            return null;
        }
    }

    public void b(c cVar) {
        this.f59820f.add(cVar);
    }

    public boolean c() {
        ServerSocket serverSocket = this.f59816b;
        if (serverSocket == null) {
            return true;
        }
        try {
            serverSocket.close();
            this.f59816b = null;
            this.f59817c = null;
            this.f59818d = 0;
            return true;
        } catch (Exception e11) {
            Debug.d(e11);
            return false;
        }
    }

    public synchronized int e() {
        return this.f59819e;
    }

    public boolean f() {
        return this.f59816b != null;
    }

    public boolean g(String str, int i11) {
        if (this.f59816b != null) {
            return true;
        }
        try {
            this.f59817c = InetAddress.getByName(str);
            this.f59818d = i11;
            this.f59816b = new ServerSocket(this.f59818d, 0, this.f59817c);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void h(HTTPRequest hTTPRequest) {
        int size = this.f59820f.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((c) this.f59820f.get(i11)).a(hTTPRequest);
        }
    }

    public boolean i() {
        StringBuffer stringBuffer = new StringBuffer("Cyber.HTTPServer/");
        stringBuffer.append(this.f59816b.getLocalSocketAddress());
        Thread thread = new Thread(this, stringBuffer.toString());
        this.f59821g = thread;
        thread.start();
        return true;
    }

    public boolean j() {
        this.f59821g = null;
        return true;
    }

    public void run() {
        if (f()) {
            Thread currentThread = Thread.currentThread();
            while (this.f59821g == currentThread) {
                Thread.yield();
                try {
                    Debug.c("accept ...");
                    Socket a11 = a();
                    if (a11 != null) {
                        Debug.c("sock = " + a11.getRemoteSocketAddress());
                    }
                    new d(this, a11).start();
                    Debug.c("httpServThread ...");
                } catch (Exception e11) {
                    Debug.d(e11);
                    return;
                }
            }
        }
    }
}
