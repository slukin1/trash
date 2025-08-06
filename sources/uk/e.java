package uk;

import com.huobi.finance.address.AddrMgrDialog;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddrMgrDialog f60753b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f60754c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f60755d;

    public /* synthetic */ e(AddrMgrDialog addrMgrDialog, boolean z11, boolean z12) {
        this.f60753b = addrMgrDialog;
        this.f60754c = z11;
        this.f60755d = z12;
    }

    public final void run() {
        this.f60753b.Ih(this.f60754c, this.f60755d);
    }
}
