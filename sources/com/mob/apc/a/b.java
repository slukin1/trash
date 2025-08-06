package com.mob.apc.a;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.mob.MobACService;
import com.mob.apc.APCException;
import com.mob.apc.a;
import com.mob.apc.b;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadPoolExecutor f26857a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<String, d> f26858b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<String, byte[]> f26859c = new ConcurrentHashMap<>();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 8, 60, TimeUnit.SECONDS, new LinkedBlockingDeque());
        f26857a = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable unused) {
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            String packageName = componentName.getPackageName();
            f.a().b("[AIDLMessager][onServiceConnected] pkg: %s", packageName);
            this.f26858b.put(packageName, d.a(iBinder));
            byte[] remove = this.f26859c.remove(packageName);
            if (remove != null) {
                synchronized (remove) {
                    remove.notifyAll();
                }
            }
        } catch (Throwable th2) {
            f.a().b("[AIDLMessager][onServiceConnected] exception: %s", th2.getMessage());
            f.a().a(th2);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        try {
            String packageName = componentName.getPackageName();
            f.a().b("[AIDLMessager][onServiceDisconnected] pkg: %s", packageName);
            this.f26858b.remove(packageName);
        } catch (Throwable th2) {
            f.a().a(th2);
            f.a().b("[AIDLMessager][onServiceDisconnected] exception: %s", th2.getMessage());
        }
    }

    public a a(String str, String str2, a aVar, long j11) throws Throwable {
        e eVar;
        long j12 = j11;
        f.a().b("[sendAIDLMessage] pkg: %s, businessID: %s, apcMessage: %s, timeout: %s", str, str2, aVar, Long.valueOf(j11));
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        try {
            Runnable a11 = a(str, new e(aVar, str2, j12), j11, (BlockingQueue<e>) linkedBlockingQueue);
            if (j12 <= 0) {
                eVar = (e) linkedBlockingQueue.take();
            } else {
                e eVar2 = (e) linkedBlockingQueue.poll(j12, TimeUnit.MILLISECONDS);
                if (eVar2 == null) {
                    f26857a.remove(a11);
                }
                eVar = eVar2;
            }
            if (eVar != null) {
                a aVar2 = eVar.f26878a;
                if (aVar2 != null) {
                    return aVar2;
                }
                APCException aPCException = eVar.f26881d;
                if (aPCException != null) {
                    throw aPCException;
                }
            }
            throw new APCException("[sendAIDLMessage] callback is null or timeout.");
        } catch (Throwable th2) {
            f.a().b("[sendAIDLMessage] exception: %s", th2.getMessage());
            throw new APCException(th2);
        }
    }

    private Runnable a(String str, e eVar, long j11, BlockingQueue<e> blockingQueue) {
        final String str2 = str;
        final e eVar2 = eVar;
        final long j12 = j11;
        final BlockingQueue<e> blockingQueue2 = blockingQueue;
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                e eVar;
                e eVar2;
                try {
                    b.this.a(str2, eVar2);
                    blockingQueue2.offer(b.this.a(str2, eVar2, j12));
                } catch (Throwable th2) {
                    f.a().a(th2);
                }
            }
        };
        f26857a.execute(r02);
        return r02;
    }

    /* access modifiers changed from: private */
    public e a(String str, e eVar, long j11) throws Throwable {
        boolean z11;
        boolean z12;
        f.a().b("[realSendAIDLMessage] pkg: %s, InnerMessage: %s, timeout: %s", str, eVar, Long.valueOf(j11));
        d dVar = this.f26858b.get(str);
        if (dVar != null) {
            try {
                if (dVar.isBinderAlive()) {
                    f.a().b("[realSendAIDLMessage] serverBinder %s is alive.", str);
                    return dVar.a(eVar);
                }
            } catch (RemoteException e11) {
                f.a().b("[realSendAIDLMessage] serverBinder send error: %s %s", str, e11.getMessage());
                f.a().a(e11);
            }
        }
        Intent intent = new Intent();
        intent.setClassName(str, MobACService.class.getName());
        try {
            f.a().a("check alive, pkg: " + str, new Object[0]);
            b.a b11 = c.a().b();
            if (b11 != null) {
                z11 = b11.a(str);
            } else {
                f.a().a("WARNING: mgsRequestListener null, can not check alive", new Object[0]);
                z11 = false;
            }
            f.a().a("is tgt alv: " + z11, new Object[0]);
            if (!z11) {
                f.a().a("can not rebnd acSvc, msg can not be send ", new Object[0]);
                z12 = false;
            } else if (Build.VERSION.SDK_INT >= 34) {
                z12 = com.mob.apc.b.a().bindService(intent, this, 513);
            } else {
                z12 = com.mob.apc.b.a().bindService(intent, this, 1);
            }
            f.a().b("[realSendAIDLMessage] rebind service: %s %s", str, Boolean.valueOf(z12));
            if (z12) {
                try {
                    byte[] bArr = this.f26859c.get(str);
                    if (bArr == null) {
                        bArr = new byte[0];
                        this.f26859c.put(str, bArr);
                    }
                    synchronized (bArr) {
                        bArr.wait(j11);
                    }
                    d dVar2 = this.f26858b.get(str);
                    f.a().b("[realSendAIDLMessage] rebind service binder: %s %s", str, dVar2);
                    if (dVar2 != null) {
                        return dVar2.a(eVar);
                    }
                    throw new APCException(1001, String.format("service binder %s is null or timeout", new Object[]{str}));
                } catch (RemoteException e12) {
                    throw new APCException(1004, String.format("service binder %s send message RemoteException: %s", new Object[]{str, e12.getMessage()}));
                } catch (Throwable th2) {
                    f.a().b("[realSendAIDLMessage] service binder %s send exception: %s", str, th2.getMessage());
                    throw new APCException(th2);
                }
            } else {
                throw new APCException(1003, String.format("service %s bind failed", new Object[]{str}));
            }
        } catch (Throwable th3) {
            throw new APCException(1002, "service bind exception: " + th3.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, e eVar) {
        a aVar;
        if (eVar != null && (aVar = eVar.f26878a) != null) {
            b.a b11 = c.a().b();
            int i11 = aVar.f26847a;
            f a11 = f.a();
            a11.a("APCMessageType: " + i11, new Object[0]);
            if (!(i11 == 1 || i11 == 2)) {
                if (i11 == 1001) {
                    f a12 = f.a();
                    a12.a("Need GD. busType: " + 1, new Object[0]);
                    if (b11 != null) {
                        b11.a(1, str);
                        return;
                    }
                    return;
                } else if (i11 != 1003) {
                    if (i11 == 9004) {
                        f a13 = f.a();
                        a13.a("Need GD. busType: " + 2, new Object[0]);
                        if (b11 != null) {
                            b11.a(2, str);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            f.a().a("No need to call GD.", new Object[0]);
        }
    }
}
