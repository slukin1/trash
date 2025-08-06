package com.mob.mcl.c;

import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicLong;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public a f27461a;

    /* renamed from: b  reason: collision with root package name */
    public final d f27462b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicLong f27463c = new AtomicLong();

    public f(d dVar) {
        this.f27462b = dVar;
    }

    public void a() {
        a aVar = this.f27461a;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    public boolean b() {
        a aVar = this.f27461a;
        return aVar != null && aVar.f27435d.get();
    }

    public void a(SocketAddress socketAddress, boolean z11, boolean z12, int i11) throws Throwable {
        a aVar = this.f27461a;
        if (aVar != null) {
            if (!socketAddress.equals(aVar.f27434c)) {
                this.f27461a.a(false);
            } else if (b()) {
                return;
            }
        }
        Socket socket = new Socket();
        socket.setKeepAlive(z11);
        socket.setTcpNoDelay(z12);
        socket.connect(socketAddress, i11);
        a aVar2 = new a(socket, this.f27462b);
        this.f27461a = aVar2;
        aVar2.f27434c = socketAddress;
    }

    public c a(e eVar) {
        if (eVar.f27459c == 0) {
            eVar.f27459c = this.f27463c.incrementAndGet();
        }
        return this.f27461a.a(eVar);
    }
}
