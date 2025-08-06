package h3;

import android.os.Handler;
import com.bbc876219.lib.localsocket.LocalMessage;
import com.bbc876219.lib.localsocket.Socket;
import com.bbc876219.lib.zlog.ZLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Socket f66269a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f66270b;

    /* renamed from: c  reason: collision with root package name */
    public ByteOrder f66271c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f66272d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f66273e = true;

    /* renamed from: f  reason: collision with root package name */
    public final BlockingQueue<LocalMessage> f66274f = new LinkedBlockingQueue();

    /* renamed from: g  reason: collision with root package name */
    public final Thread f66275g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Handler> f66276h = new ArrayList();

    /* renamed from: h3.a$a  reason: collision with other inner class name */
    public class C0718a implements Runnable {
        public C0718a() {
        }

        public void run() {
            ZLog.b("Channel", "MsgThread.started-" + a.this.f66270b);
            while (a.this.f66273e) {
                try {
                    LocalMessage localMessage = (LocalMessage) a.this.f66274f.take();
                    if (localMessage != null) {
                        localMessage.f63188id = a.this.f66272d.get();
                        a.this.f66269a.i(localMessage);
                        a.this.f66272d.incrementAndGet();
                    }
                } catch (InterruptedException e11) {
                    ZLog.d("Channel", "MsgThread-" + a.this.f66270b, e11);
                }
            }
            ZLog.b("Channel", "MsgThread.terminate-" + a.this.f66270b);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            a.this.o();
        }
    }

    public a(String str) {
        this.f66270b = str;
        C0718a aVar = new C0718a();
        Thread thread = new Thread(aVar, "MsgThread-" + str);
        this.f66275g = thread;
        thread.start();
        ZLog.b("Channel", "Channel is constructed for " + this.f66270b);
    }

    public boolean g() {
        Socket socket;
        synchronized (this) {
            socket = this.f66269a;
            this.f66269a = null;
        }
        if (socket != null) {
            socket.i(LocalMessage.obtainClose(h()));
            socket.a();
        }
        return socket != null;
    }

    public String h() {
        return this.f66270b;
    }

    public void i() {
        ZLog.b("Channel", "onConnected() called");
    }

    public void j() {
        ZLog.b("Channel", "onDisconnected() called");
    }

    public final void k() {
        if (g()) {
            ZLog.c("Channel", "Connection with the emulator has been lost in Channel " + this.f66270b);
            j();
        }
    }

    public void l(LocalMessage localMessage) {
        byte b11 = localMessage.type;
        if (b11 == 3) {
            ZLog.b("Channel", "收到ack连接消息:" + localMessage);
        } else if (b11 == 4) {
            ZLog.b("Channel", "收到ping连接消息:" + localMessage);
        } else if (b11 == 5) {
            ZLog.b("Channel", "收到pong连接消息:" + localMessage);
        } else if (b11 == 6) {
            ZLog.b("Channel", "收到断开连接消息:" + localMessage);
        } else if (b11 != 7) {
            ZLog.b("Channel", "收到断开连接消息:" + localMessage);
        } else {
            ZLog.b("Channel", "收到握手握手消息:" + localMessage);
        }
    }

    public final void m(LocalMessage localMessage) {
        try {
            this.f66274f.put(localMessage);
        } catch (InterruptedException e11) {
            ZLog.d("Channel", "mMessageQueue.put", e11);
        }
    }

    public void n(Socket socket) {
        this.f66269a = socket;
        this.f66271c = ByteOrder.LITTLE_ENDIAN;
        ZLog.b("Channel", "Channel " + this.f66270b + " is now connected with the cllient." + this.f66271c);
        m(LocalMessage.obtainHandShake(this.f66270b));
        i();
        new Thread(new b(), "ChannelIoLoop").start();
    }

    public final void o() {
        ZLog.b("Channel", "In I/O looper for Channel " + this.f66270b);
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.order(this.f66271c);
        try {
            Socket socket = this.f66269a;
            while (socket != null) {
                allocate.position(0);
                socket.f(allocate.array());
                l(LocalMessage.receiveLocalMessage(allocate, socket.d(), this.f66271c));
                socket = this.f66269a;
            }
        } catch (IOException e11) {
            ZLog.c("Channel", "Exception " + e11 + " in I/O looper for Channel " + this.f66270b + ZLog.e(e11));
            k();
        }
        ZLog.b("Channel", "Exiting I/O looper for Channel " + this.f66270b);
    }
}
