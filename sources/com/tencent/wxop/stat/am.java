package com.tencent.wxop.stat;

import java.util.List;

final class am implements Runnable {

    /* renamed from: bc  reason: collision with root package name */
    public final /* synthetic */ List f50976bc;

    /* renamed from: ck  reason: collision with root package name */
    public final /* synthetic */ aj f50977ck;

    /* renamed from: dm  reason: collision with root package name */
    public final /* synthetic */ ak f50978dm;

    public am(ak akVar, List list, aj ajVar) {
        this.f50978dm = akVar;
        this.f50976bc = list;
        this.f50977ck = ajVar;
    }

    public final void run() {
        this.f50978dm.a((List<?>) this.f50976bc, this.f50977ck);
    }
}
