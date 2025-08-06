package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f66863a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f66864b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final q f66865c;

    /* renamed from: d  reason: collision with root package name */
    private final String f66866d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final List f66867e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final Set f66868f = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Object f66869g = new Object();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f66870h;

    /* renamed from: i  reason: collision with root package name */
    private final Intent f66871i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final x f66872j;

    /* renamed from: k  reason: collision with root package name */
    private final WeakReference f66873k;

    /* renamed from: l  reason: collision with root package name */
    private final IBinder.DeathRecipient f66874l = new t(this);
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final AtomicInteger f66875m = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public ServiceConnection f66876n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public IInterface f66877o;

    public ac(Context context, q qVar, String str, Intent intent, x xVar, w wVar) {
        this.f66864b = context;
        this.f66865c = qVar;
        this.f66866d = str;
        this.f66871i = intent;
        this.f66872j = xVar;
        this.f66873k = new WeakReference((Object) null);
    }

    public static /* synthetic */ void k(ac acVar) {
        acVar.f66865c.c("reportBinderDeath", new Object[0]);
        w wVar = (w) acVar.f66873k.get();
        if (wVar != null) {
            acVar.f66865c.c("calling onBinderDied", new Object[0]);
            wVar.a();
        } else {
            acVar.f66865c.c("%s : Binder has died.", acVar.f66866d);
            for (r a11 : acVar.f66867e) {
                a11.a(acVar.w());
            }
            acVar.f66867e.clear();
        }
        synchronized (acVar.f66869g) {
            acVar.x();
        }
    }

    public static /* bridge */ /* synthetic */ void o(ac acVar, TaskCompletionSource taskCompletionSource) {
        acVar.f66868f.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new s(acVar, taskCompletionSource));
    }

    public static /* bridge */ /* synthetic */ void q(ac acVar, r rVar) {
        if (acVar.f66877o == null && !acVar.f66870h) {
            acVar.f66865c.c("Initiate binding to the service.", new Object[0]);
            acVar.f66867e.add(rVar);
            ab abVar = new ab(acVar, (aa) null);
            acVar.f66876n = abVar;
            acVar.f66870h = true;
            if (!acVar.f66864b.bindService(acVar.f66871i, abVar, 1)) {
                acVar.f66865c.c("Failed to bind to the service.", new Object[0]);
                acVar.f66870h = false;
                for (r a11 : acVar.f66867e) {
                    a11.a(new ad());
                }
                acVar.f66867e.clear();
            }
        } else if (acVar.f66870h) {
            acVar.f66865c.c("Waiting to bind to the service.", new Object[0]);
            acVar.f66867e.add(rVar);
        } else {
            rVar.run();
        }
    }

    public static /* bridge */ /* synthetic */ void r(ac acVar) {
        acVar.f66865c.c("linkToDeath", new Object[0]);
        try {
            acVar.f66877o.asBinder().linkToDeath(acVar.f66874l, 0);
        } catch (RemoteException e11) {
            acVar.f66865c.b(e11, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void s(ac acVar) {
        acVar.f66865c.c("unlinkToDeath", new Object[0]);
        acVar.f66877o.asBinder().unlinkToDeath(acVar.f66874l, 0);
    }

    private final RemoteException w() {
        if (Build.VERSION.SDK_INT < 15) {
            return new RemoteException();
        }
        return new RemoteException(String.valueOf(this.f66866d).concat(" : Binder has died."));
    }

    /* access modifiers changed from: private */
    public final void x() {
        for (TaskCompletionSource trySetException : this.f66868f) {
            trySetException.trySetException(w());
        }
        this.f66868f.clear();
    }

    public final Handler c() {
        Handler handler;
        Map map = f66863a;
        synchronized (map) {
            if (!map.containsKey(this.f66866d)) {
                HandlerThread handlerThread = new HandlerThread(this.f66866d, 10);
                handlerThread.start();
                map.put(this.f66866d, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.f66866d);
        }
        return handler;
    }

    public final IInterface e() {
        return this.f66877o;
    }

    public final void t(r rVar, TaskCompletionSource taskCompletionSource) {
        c().post(new u(this, rVar.c(), taskCompletionSource, rVar));
    }

    public final /* synthetic */ void u(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f66869g) {
            this.f66868f.remove(taskCompletionSource);
        }
    }

    public final void v(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f66869g) {
            this.f66868f.remove(taskCompletionSource);
        }
        c().post(new v(this));
    }
}
