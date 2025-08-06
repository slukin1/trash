package com.huobi.otc.floating;

import android.os.Handler;
import android.os.Looper;
import com.huobi.otc.bean.ReminderData;
import com.huobi.utils.GsonHelper;
import com.huobi.websocket.protobuf.source.Message$Proto;
import gp.a;
import gp.b;
import gp.c;
import i6.d;
import up.x;

public class OtcReminderModelImp implements a, x.h {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f78397c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public c f78398a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f78399b = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: private */
    public /* synthetic */ void e(ReminderData reminderData) {
        this.f78398a.a(reminderData);
    }

    public void a() {
        d.d("PSocketMsgDispatcher--->wsClose");
    }

    public void b() {
        if (x.j().l()) {
            x.j().q(this);
        }
    }

    public void c(Message$Proto message$Proto) {
        f(message$Proto.getContent());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect() {
        /*
            r2 = this;
            java.lang.Object r0 = f78397c
            monitor-enter(r0)
            uf.a r1 = com.hbg.module.otc.OtcModuleConfig.a()     // Catch:{ all -> 0x0036 }
            boolean r1 = r1.a()     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return
        L_0x000f:
            android.app.Application r1 = com.hbg.lib.common.BaseApplication.b()     // Catch:{ all -> 0x0036 }
            boolean r1 = i6.l.h(r1)     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x001b
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return
        L_0x001b:
            up.x r1 = up.x.j()     // Catch:{ all -> 0x0036 }
            boolean r1 = r1.l()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x002d
            up.x r1 = up.x.j()     // Catch:{ all -> 0x0036 }
            r1.q(r2)     // Catch:{ all -> 0x0036 }
            goto L_0x0034
        L_0x002d:
            up.x r1 = up.x.j()     // Catch:{ all -> 0x0036 }
            r1.h()     // Catch:{ all -> 0x0036 }
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return
        L_0x0036:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.floating.OtcReminderModelImp.connect():void");
    }

    public void disconnect() {
        x.j().s(this);
        x.j().i();
    }

    public final void f(String str) {
        try {
            this.f78399b.post(new b(this, (ReminderData) GsonHelper.a().fromJson(str, ReminderData.class)));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void g(c cVar) {
        this.f78398a = cVar;
    }
}
