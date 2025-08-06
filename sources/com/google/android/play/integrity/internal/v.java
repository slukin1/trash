package com.google.android.play.integrity.internal;

final class v extends r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ac f66895a;

    public v(ac acVar) {
        this.f66895a = acVar;
    }

    public final void b() {
        synchronized (this.f66895a.f66869g) {
            if (this.f66895a.f66875m.get() > 0) {
                if (this.f66895a.f66875m.decrementAndGet() > 0) {
                    this.f66895a.f66865c.c("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
            }
            ac acVar = this.f66895a;
            if (acVar.f66877o != null) {
                acVar.f66865c.c("Unbind from service.", new Object[0]);
                ac acVar2 = this.f66895a;
                acVar2.f66864b.unbindService(acVar2.f66876n);
                this.f66895a.f66870h = false;
                this.f66895a.f66877o = null;
                this.f66895a.f66876n = null;
            }
            this.f66895a.x();
        }
    }
}
