package com.mob.mcl.c;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Socket f27432a;

    /* renamed from: b  reason: collision with root package name */
    public final d f27433b;

    /* renamed from: c  reason: collision with root package name */
    public SocketAddress f27434c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f27435d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<c, Long> f27436e = new WeakHashMap();

    /* renamed from: com.mob.mcl.c.a$a  reason: collision with other inner class name */
    public class C0241a extends Thread {
        public C0241a(String str) {
            super(str);
            setDaemon(true);
        }

        public void run() {
            a.this.a();
        }
    }

    public a(Socket socket, d dVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f27435d = atomicBoolean;
        this.f27432a = socket;
        this.f27433b = dVar;
        atomicBoolean.getAndSet(true);
        dVar.a(this);
        new C0241a("mlp-worker").start();
    }

    public c a(e eVar) {
        c cVar = new c();
        synchronized (this.f27436e) {
            this.f27436e.put(cVar, Long.valueOf(eVar.f27459c));
        }
        try {
            OutputStream outputStream = this.f27432a.getOutputStream();
            outputStream.write(eVar.a());
            outputStream.flush();
            return cVar;
        } catch (Throwable th2) {
            this.f27433b.a(this, th2);
            return null;
        }
    }

    public void a() {
        try {
            InputStream inputStream = this.f27432a.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8096];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 != read) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    if (read < 8096) {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        ByteBuffer wrap = ByteBuffer.wrap(byteArray);
                        int i11 = 0;
                        while (wrap.hasRemaining() && wrap.get() != 1) {
                            i11++;
                        }
                        List<e> a11 = e.a((ByteBuffer) ((Buffer) new Object[]{wrap}[0]).position(i11));
                        for (e b11 : a11) {
                            i11 += b11.b();
                        }
                        a(a11);
                        byteArrayOutputStream.reset();
                        if (byteArray.length - i11 > 0) {
                            byteArrayOutputStream.write(byteArray, i11, byteArray.length - i11);
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable th2) {
            this.f27433b.a(this, th2);
            a(true);
        }
    }

    public void a(List<e> list) {
        for (e next : list) {
            d dVar = this.f27433b;
            if (dVar != null && next.f27458b >= 9001) {
                dVar.a(this, next);
            }
            if (next.f27458b < 9001) {
                Iterator<Map.Entry<c, Long>> it2 = this.f27436e.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry next2 = it2.next();
                    if (((Long) next2.getValue()).equals(Long.valueOf(next.f27459c))) {
                        ((c) next2.getKey()).a(next);
                        break;
                    }
                }
            }
        }
    }

    public void a(boolean z11) {
        if (this.f27435d.getAndSet(false)) {
            try {
                this.f27432a.close();
                this.f27433b.a(this, z11);
            } catch (Throwable unused) {
            }
            this.f27435d.getAndSet(false);
            this.f27436e.clear();
        }
    }
}
