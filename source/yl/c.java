package yl;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f61794b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserKycInfoNew f61795c;

    public /* synthetic */ c(g gVar, UserKycInfoNew userKycInfoNew) {
        this.f61794b = gVar;
        this.f61795c = userKycInfoNew;
    }

    public final void run() {
        this.f61794b.n(this.f61795c);
    }
}
