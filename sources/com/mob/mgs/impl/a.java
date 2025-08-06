package com.mob.mgs.impl;

import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f27529a = new a();

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f27530b = Executors.newSingleThreadExecutor();

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f27531c = Executors.newSingleThreadExecutor();

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<String, LinkedBlockingQueue<Boolean>> f27532d = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Integer, String> f27533e = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentHashMap<Integer, SelectionKey> f27534f = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Socket f27535g = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f27536h = 5;

    /* renamed from: i  reason: collision with root package name */
    private ScheduledExecutorService f27537i = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: j  reason: collision with root package name */
    private ScheduledFuture f27538j;

    private a() {
    }

    public static /* synthetic */ int g(a aVar) {
        int i11 = aVar.f27536h;
        aVar.f27536h = i11 - 1;
        return i11;
    }

    /* access modifiers changed from: private */
    public void c() {
        try {
            this.f27532d.clear();
            this.f27533e.clear();
            this.f27534f.clear();
        } catch (Throwable th2) {
            e.a().b(th2);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            e();
            this.f27538j = this.f27537i.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        e a11 = e.a();
                        a11.a("[GdCon] p cli sct: " + a.this.f27535g);
                        if (a.this.f27535g != null && a.this.f27535g.isConnected()) {
                            OutputStream outputStream = a.this.f27535g.getOutputStream();
                            outputStream.write(TtmlNode.TAG_P.getBytes());
                            outputStream.flush();
                        }
                    } catch (Throwable th2) {
                        e.a().a(th2);
                    }
                }
            }, 0, 240, TimeUnit.SECONDS);
        } catch (Throwable th2) {
            e.a().a("[GdCon] HB timer error", th2);
        }
    }

    private boolean e() {
        try {
            ScheduledFuture scheduledFuture = this.f27538j;
            if (scheduledFuture == null) {
                return false;
            }
            boolean cancel = scheduledFuture.cancel(true);
            e a11 = e.a();
            a11.a("[GdCon] HB restart, cancel: " + cancel);
            return cancel;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return false;
        }
    }

    private void f() {
        try {
            if (this.f27535g != null) {
                e();
                this.f27535g.close();
                this.f27535g = null;
            }
        } catch (Throwable th2) {
            e.a().b(th2);
        }
    }

    public void b() {
        this.f27530b.execute(new Runnable() {
            public void run() {
                try {
                    DH.requester(MobSDK.getContext()).getIPAddress().request(new DH.DHResponder() {
                        public void onResponse(DH.DHResponse dHResponse) throws Throwable {
                            try {
                                if (a.this.f27535g != null) {
                                    a.this.f27535g.close();
                                    Socket unused = a.this.f27535g = null;
                                }
                                Socket unused2 = a.this.f27535g = new Socket(dHResponse.getIPAddress(), 59898);
                                if (a.this.f27535g.isConnected()) {
                                    int unused3 = a.this.f27536h = 5;
                                    e.a().a("[GdCon] clientSocket connected");
                                    try {
                                        String packageName = MobSDK.getContext().getPackageName();
                                        OutputStream outputStream = a.this.f27535g.getOutputStream();
                                        outputStream.write(("lg_" + packageName).getBytes("utf-8"));
                                        outputStream.flush();
                                    } catch (Throwable th2) {
                                        e.a().b(th2);
                                    }
                                    a.this.d();
                                    InputStream inputStream = a.this.f27535g.getInputStream();
                                    while (a.this.f27535g.isConnected() && !a.this.f27535g.isClosed()) {
                                        byte[] bArr = new byte[1024];
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            e.a().a("[GdCon] client received server disconnect");
                                            a.this.a(false);
                                        } else {
                                            String str = new String(bArr, 0, read);
                                            e a11 = e.a();
                                            a11.a("[GdCon] client received server msg: " + str);
                                            if ("chk".equals(str)) {
                                                try {
                                                    String packageName2 = MobSDK.getContext().getPackageName();
                                                    OutputStream outputStream2 = a.this.f27535g.getOutputStream();
                                                    outputStream2.write(("chk_cb_" + packageName2).getBytes("utf-8"));
                                                    outputStream2.flush();
                                                    e a12 = e.a();
                                                    a12.a("[GdCon] client send alive check msg callback to server: " + "chk_cb_" + packageName2);
                                                } catch (Throwable th3) {
                                                    e.a().b(th3);
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (SocketException e11) {
                                e a13 = e.a();
                                a13.a("[GdCon] client received socket exception: " + e11.getMessage());
                                e.a().a((Throwable) e11);
                                a.this.a(true);
                            }
                        }
                    });
                } catch (Throwable th2) {
                    e a11 = e.a();
                    a11.a("[GdCon] clientSocket exception: " + th2.getMessage());
                    e.a().a(th2);
                }
            }
        });
    }

    public static a a() {
        return f27529a;
    }

    public void a(final BlockingQueue<Boolean> blockingQueue) {
        this.f27530b.execute(new Runnable() {
            public void run() {
                try {
                    ServerSocketChannel open = ServerSocketChannel.open();
                    open.configureBlocking(false);
                    try {
                        open.socket().bind(new InetSocketAddress(59898));
                        e.a().a("[GdCon] registerServerSocket success");
                        blockingQueue.offer(Boolean.TRUE);
                        Selector open2 = Selector.open();
                        open.register(open2, 16);
                        while (open2 != null && open2.isOpen()) {
                            if (open2.select() > 0) {
                                Iterator<SelectionKey> it2 = open2.selectedKeys().iterator();
                                while (it2.hasNext()) {
                                    SelectionKey next = it2.next();
                                    it2.remove();
                                    if (next.isValid() && next.isAcceptable()) {
                                        SocketChannel accept = ((ServerSocketChannel) next.channel()).accept();
                                        accept.configureBlocking(false);
                                        accept.register(open2, 1);
                                    }
                                    if (next.isValid() && next.isReadable()) {
                                        SocketChannel socketChannel = (SocketChannel) next.channel();
                                        ByteBuffer allocate = ByteBuffer.allocate(1024);
                                        int read = socketChannel.read(allocate);
                                        e a11 = e.a();
                                        a11.a("[GdCon] serverSocket received bytes:" + read);
                                        if (read > 0) {
                                            String str = new String(allocate.array(), 0, read);
                                            e a12 = e.a();
                                            a12.a("[GdCon] serverSocket received msg:" + str);
                                            if (!TtmlNode.TAG_P.equals(str)) {
                                                if (str.startsWith("lg_")) {
                                                    int port = ((InetSocketAddress) socketChannel.socket().getRemoteSocketAddress()).getPort();
                                                    String substring = str.substring(3);
                                                    a.this.f27533e.put(Integer.valueOf(port), substring);
                                                    a.this.f27534f.put(Integer.valueOf(port), next);
                                                    c.a().b(substring);
                                                } else if (str.startsWith("chk_cb_")) {
                                                    a.this.a(str.substring(7));
                                                }
                                            }
                                        } else {
                                            try {
                                                int port2 = ((InetSocketAddress) socketChannel.socket().getRemoteSocketAddress()).getPort();
                                                String str2 = (String) a.this.f27533e.remove(Integer.valueOf(port2));
                                                a.this.f27534f.remove(Integer.valueOf(port2));
                                                e a13 = e.a();
                                                a13.a("[GdCon] serverSocket received client disconnect pkg: " + str2);
                                                c.a().a(str2, false);
                                            } catch (Throwable th2) {
                                                e.a().a(th2);
                                            }
                                            try {
                                                socketChannel.close();
                                            } catch (Throwable th3) {
                                                e.a().a(th3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused) {
                        e.a().a("[GdCon] registerServerSocket failed");
                        blockingQueue.offer(Boolean.FALSE);
                    }
                } catch (Throwable th4) {
                    e a14 = e.a();
                    a14.a("[GdCon] serverSocket exception: " + th4.getMessage());
                    e.a().b(th4);
                    a.this.c();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        LinkedBlockingQueue remove = this.f27532d.remove(str);
        if (remove != null) {
            remove.offer(Boolean.TRUE);
        }
    }

    public int a(String str, LinkedBlockingQueue linkedBlockingQueue) {
        int i11 = 0;
        for (Map.Entry next : this.f27533e.entrySet()) {
            if (((String) next.getValue()).equals(str) && next.getKey() != null) {
                this.f27532d.put(str, linkedBlockingQueue);
                SelectionKey selectionKey = this.f27534f.get(next.getKey());
                if (selectionKey != null) {
                    i11 = a(selectionKey) ? 1 : 2;
                }
            }
        }
        return i11;
    }

    private boolean a(SelectionKey selectionKey) {
        try {
            if (!selectionKey.isValid()) {
                return false;
            }
            ((SocketChannel) selectionKey.channel()).write(ByteBuffer.wrap("chk".getBytes("utf-8")));
            return true;
        } catch (Throwable th2) {
            e.a().a(th2);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void a(final boolean z11) {
        e a11 = e.a();
        a11.a("[GdCon] onServerDisconnect maxRegisterClientFailedCount: " + this.f27536h + ", isConnectException: " + z11);
        f();
        this.f27531c.execute(new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                    com.mob.mgs.impl.c r0 = com.mob.mgs.impl.c.a()     // Catch:{ all -> 0x005f }
                    boolean r0 = r0.c()     // Catch:{ all -> 0x005f }
                    if (r0 == 0) goto L_0x0032
                    java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue     // Catch:{ all -> 0x005f }
                    r0.<init>()     // Catch:{ all -> 0x005f }
                    com.mob.mgs.impl.a r1 = com.mob.mgs.impl.a.this     // Catch:{ all -> 0x005f }
                    r1.a((java.util.concurrent.BlockingQueue<java.lang.Boolean>) r0)     // Catch:{ all -> 0x005f }
                    java.lang.Object r0 = r0.take()     // Catch:{ all -> 0x002a }
                    java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002a }
                    boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002a }
                    if (r0 == 0) goto L_0x0032
                    com.mob.mgs.impl.c r0 = com.mob.mgs.impl.c.a()     // Catch:{ all -> 0x002a }
                    r1 = 0
                    r2 = 1
                    r0.a((java.lang.String) r1, (boolean) r2)     // Catch:{ all -> 0x002a }
                    return
                L_0x002a:
                    r0 = move-exception
                    com.mob.mgs.impl.e r1 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x005f }
                    r1.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x005f }
                L_0x0032:
                    com.mob.mgs.impl.a r0 = com.mob.mgs.impl.a.this     // Catch:{ all -> 0x005f }
                    int r0 = r0.f27536h     // Catch:{ all -> 0x005f }
                    if (r0 <= 0) goto L_0x0067
                    boolean r0 = r4     // Catch:{ all -> 0x005f }
                    if (r0 == 0) goto L_0x0054
                    com.mob.mgs.impl.a r0 = com.mob.mgs.impl.a.this     // Catch:{ all -> 0x005f }
                    int r0 = r0.f27536h     // Catch:{ all -> 0x005f }
                    r1 = 5
                    if (r0 >= r1) goto L_0x0054
                    com.mob.mgs.impl.a r0 = com.mob.mgs.impl.a.this     // Catch:{ all -> 0x0054 }
                    int r0 = r0.f27536h     // Catch:{ all -> 0x0054 }
                    int r1 = r1 - r0
                    int r1 = r1 * 1000
                    long r0 = (long) r1     // Catch:{ all -> 0x0054 }
                    java.lang.Thread.sleep(r0)     // Catch:{ all -> 0x0054 }
                L_0x0054:
                    com.mob.mgs.impl.a r0 = com.mob.mgs.impl.a.this     // Catch:{ all -> 0x005f }
                    com.mob.mgs.impl.a.g(r0)     // Catch:{ all -> 0x005f }
                    com.mob.mgs.impl.a r0 = com.mob.mgs.impl.a.this     // Catch:{ all -> 0x005f }
                    r0.b()     // Catch:{ all -> 0x005f }
                    goto L_0x0067
                L_0x005f:
                    r0 = move-exception
                    com.mob.mgs.impl.e r1 = com.mob.mgs.impl.e.a()
                    r1.a((java.lang.Throwable) r0)
                L_0x0067:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.mgs.impl.a.AnonymousClass3.run():void");
            }
        });
    }
}
