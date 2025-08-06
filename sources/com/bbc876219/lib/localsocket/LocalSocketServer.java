package com.bbc876219.lib.localsocket;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.bbc876219.lib.zlog.ZLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class LocalSocketServer {

    /* renamed from: a  reason: collision with root package name */
    public String f63189a = "com.bbc876219.LocalSocketServer";

    /* renamed from: b  reason: collision with root package name */
    public LocalServerSocket f63190b = null;

    /* renamed from: c  reason: collision with root package name */
    public List<Socket> f63191c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<h3.a> f63192d = new ArrayList();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            LocalSocketServer.this.h();
        }
    }

    public LocalSocketServer() {
        ZLog.b("LoaclServerSocket", "LocalSocketServer is constructed.");
    }

    public void b() {
        ZLog.b("LoaclServerSocket", "LocalSocketServer is connecting...");
        new Thread(new a(), "LocalSocketServerIoLoop").start();
    }

    public boolean c() {
        LocalServerSocket localServerSocket;
        synchronized (this) {
            localServerSocket = this.f63190b;
            this.f63190b = null;
        }
        if (localServerSocket != null) {
            ZLog.b("LoaclServerSocket", "LocalSocketServer is stopping I/O looper...");
            i(localServerSocket);
            try {
                localServerSocket.close();
            } catch (Exception unused) {
            }
            ZLog.b("LoaclServerSocket", "LocalSocketServer is closing pending sockets...");
            for (Socket a11 : this.f63191c) {
                a11.a();
            }
            this.f63191c.clear();
            ZLog.b("LoaclServerSocket", "LocalSocketServer is disconnecting channels...");
            for (h3.a next : this.f63192d) {
                if (next.g()) {
                    next.j();
                }
            }
            ZLog.b("LoaclServerSocket", "LocalSocketServer is disconnected.");
        }
        return localServerSocket != null;
    }

    public h3.a d(String str) {
        for (h3.a next : this.f63192d) {
            if (next.h().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public final void e(LocalSocket localSocket) throws IOException {
        ZLog.b("LoaclServerSocket", "onAccept() called with: sock = [" + localSocket + "]");
        ByteBuffer allocate = ByteBuffer.allocate(5);
        Socket.e(localSocket, allocate.array(), allocate.array().length);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        allocate.position(0);
        LocalMessage receiveLocalMessage = LocalMessage.receiveLocalMessage(allocate, localSocket, byteOrder);
        ZLog.b("LoaclServerSocket", "onAccept() called with: msg = [" + receiveLocalMessage + "]");
        f(receiveLocalMessage);
    }

    public void f(LocalMessage localMessage) {
        byte b11 = localMessage.type;
        if (b11 == 3) {
            ZLog.b("LoaclServerSocket", "收到clientack连接消息:" + localMessage);
        } else if (b11 == 4) {
            ZLog.b("LoaclServerSocket", "收到clientping连接消息:" + localMessage);
        } else if (b11 == 5) {
            ZLog.b("LoaclServerSocket", "收到clientpong连接消息:" + localMessage);
        } else if (b11 == 6) {
            ZLog.b("LoaclServerSocket", "收到client断开连接消息:" + localMessage);
            d(localMessage.token).g();
        } else if (b11 != 7) {
            ZLog.b("LoaclServerSocket", "收到client消息:" + localMessage);
        } else {
            ZLog.b("LoaclServerSocket", "收到client握手握手消息:" + localMessage);
        }
    }

    public boolean g(h3.a aVar) {
        for (h3.a h11 : this.f63192d) {
            if (h11.h().equals(aVar.h())) {
                ZLog.c("LoaclServerSocket", "Registering a duplicate Channel " + aVar.h());
                return false;
            }
        }
        ZLog.b("LoaclServerSocket", "Registering Channel " + aVar.h());
        this.f63192d.add(aVar);
        for (Socket next : this.f63191c) {
            if (next.b().equals(aVar.h())) {
                ZLog.b("LoaclServerSocket", "Found pending Socket for registering Channel " + aVar.h());
                this.f63191c.remove(next);
                aVar.n(next);
            }
        }
        return true;
    }

    public final void h() {
        ZLog.b("LoaclServerSocket", "In LocalSocketServer I/O looper.");
        do {
            try {
                LocalServerSocket localServerSocket = new LocalServerSocket(this.f63189a);
                this.f63190b = localServerSocket;
                while (true) {
                    if (localServerSocket == null) {
                        break;
                    }
                    LocalSocket accept = localServerSocket.accept();
                    ZLog.b("LoaclServerSocket", "socket.accept() called" + accept);
                    if (this.f63190b == null) {
                        ZLog.b("LoaclServerSocket", "mServerSocket ==null " + accept.toString());
                        break;
                    }
                    e(accept);
                    localServerSocket = this.f63190b;
                }
            } catch (IOException e11) {
                ZLog.c("LoaclServerSocket", "Exception " + e11 + "LocalSocketServer I/O looper." + ZLog.e(e11));
            }
            ZLog.b("LoaclServerSocket", "Exiting LocalSocketServer I/O looper.");
        } while (c());
    }

    public final void i(LocalServerSocket localServerSocket) {
        ZLog.b("LoaclServerSocket", " We wake the looper by connecting to the socket.");
        try {
            new LocalSocket().connect(localServerSocket.getLocalSocketAddress());
        } catch (IOException e11) {
            ZLog.c("LoaclServerSocket", "Exception " + e11 + " in LocalSocketServer while waking up the I/O looper." + ZLog.e(e11));
        }
    }
}
