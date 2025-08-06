package q6;

import u6.g;

public abstract class b<T> extends a<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f69030a;

    public b(g gVar) {
        super(gVar);
    }

    public void onRequestFailure(Throwable th2) {
        super.onRequestFailure(th2);
        g gVar = this.f69029ui;
        if (gVar != null) {
            gVar.dismissProgressDialog();
        }
    }

    public void onRequestStart() {
        super.onRequestStart();
        g gVar = this.f69029ui;
        if (gVar != null && gVar.isAlive()) {
            this.f69029ui.showProgressDialog(this.f69030a);
        }
    }

    public void onRequestSuccess(T t11) {
        g gVar = this.f69029ui;
        if (gVar != null) {
            gVar.dismissProgressDialog();
        }
    }

    public b(g gVar, boolean z11) {
        super(gVar);
        this.f69030a = z11;
    }
}
